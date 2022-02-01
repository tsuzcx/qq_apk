package com.tencent.tavkit.component.effectchain;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.FilterChainReportSession;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoEffectProxy
  implements TAVVideoEffect
{
  private boolean autoCheckEffectRemove;
  private CopyOnWriteArrayList<TAVVideoEffect> effects;
  private final List<FilterProxy> filterProxies;
  
  public VideoEffectProxy()
  {
    AppMethodBeat.i(219748);
    this.effects = new CopyOnWriteArrayList();
    this.filterProxies = new ArrayList();
    this.autoCheckEffectRemove = true;
    AppMethodBeat.o(219748);
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    AppMethodBeat.i(219751);
    FilterProxy localFilterProxy = new FilterProxy(null);
    this.filterProxies.add(localFilterProxy);
    AppMethodBeat.o(219751);
    return localFilterProxy;
  }
  
  public String effectId()
  {
    AppMethodBeat.i(219750);
    String str = "VideoEffectProxy" + Integer.toHexString(hashCode());
    AppMethodBeat.o(219750);
    return str;
  }
  
  public List<TAVVideoEffect> getEffects()
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.effects;
      return localCopyOnWriteArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isAutoCheckEffectRemove()
  {
    return this.autoCheckEffectRemove;
  }
  
  public void notifyOnEffectRemove()
  {
    AppMethodBeat.i(219749);
    Iterator localIterator = this.filterProxies.iterator();
    while (localIterator.hasNext()) {
      ((FilterProxy)localIterator.next()).notifyOnEffectRemove();
    }
    AppMethodBeat.o(219749);
  }
  
  public void setAutoCheckEffectRemove(boolean paramBoolean)
  {
    this.autoCheckEffectRemove = paramBoolean;
  }
  
  public void setEffects(CopyOnWriteArrayList<TAVVideoEffect> paramCopyOnWriteArrayList)
  {
    try
    {
      this.effects = paramCopyOnWriteArrayList;
      return;
    }
    finally
    {
      paramCopyOnWriteArrayList = finally;
      throw paramCopyOnWriteArrayList;
    }
  }
  
  static class FilterProxy
    implements TAVVideoEffect.Filter, IReportable
  {
    private final HashMap<String, TAVVideoEffect.Filter> filterMap;
    private boolean onEffectRemove;
    private final FilterChainReportSession reportSession;
    
    private FilterProxy()
    {
      AppMethodBeat.i(219742);
      this.filterMap = new HashMap();
      this.reportSession = new FilterChainReportSession();
      AppMethodBeat.o(219742);
    }
    
    private void checkRuntimeRelease(List<TAVVideoEffect> paramList)
    {
      AppMethodBeat.i(219745);
      this.onEffectRemove = false;
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      Object localObject;
      while (paramList.hasNext())
      {
        localObject = (TAVVideoEffect)paramList.next();
        if (!TextUtils.isEmpty(((TAVVideoEffect)localObject).effectId())) {
          localArrayList.add(((TAVVideoEffect)localObject).effectId());
        }
      }
      paramList = new HashSet(this.filterMap.keySet()).iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if (!localArrayList.contains(localObject))
        {
          ((TAVVideoEffect.Filter)this.filterMap.get(localObject)).release();
          this.filterMap.remove(localObject);
        }
      }
      AppMethodBeat.o(219745);
    }
    
    private TAVVideoEffect.Filter getCacheFilter(TAVVideoEffect paramTAVVideoEffect)
    {
      AppMethodBeat.i(219746);
      if ((paramTAVVideoEffect == null) || (TextUtils.isEmpty(paramTAVVideoEffect.effectId())))
      {
        AppMethodBeat.o(219746);
        return null;
      }
      String str = paramTAVVideoEffect.effectId();
      if (this.filterMap.containsKey(str)) {
        paramTAVVideoEffect = (TAVVideoEffect.Filter)this.filterMap.get(str);
      }
      for (;;)
      {
        AppMethodBeat.o(219746);
        return paramTAVVideoEffect;
        paramTAVVideoEffect = paramTAVVideoEffect.createFilter();
        this.filterMap.put(str, paramTAVVideoEffect);
      }
    }
    
    public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
    {
      AppMethodBeat.i(219744);
      if (!(paramTAVVideoEffect instanceof VideoEffectProxy))
      {
        AppMethodBeat.o(219744);
        return paramCIImage;
      }
      Object localObject = ((VideoEffectProxy)paramTAVVideoEffect).getEffects();
      if ((((VideoEffectProxy)paramTAVVideoEffect).isAutoCheckEffectRemove()) || (this.onEffectRemove)) {
        checkRuntimeRelease((List)localObject);
      }
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (TAVVideoEffect)localIterator.next();
        TAVVideoEffect.Filter localFilter = getCacheFilter((TAVVideoEffect)localObject);
        if (localFilter != null)
        {
          paramTAVVideoEffect = null;
          long l = System.nanoTime();
          if ((localFilter instanceof IReportable)) {
            paramTAVVideoEffect = ((IReportable)localFilter).getReportKey();
          }
          localObject = localFilter.apply((TAVVideoEffect)localObject, paramCIImage, paramRenderInfo);
          paramCIImage = (CIImage)localObject;
          if (!TextUtils.isEmpty(paramTAVVideoEffect))
          {
            this.reportSession.tick(paramTAVVideoEffect, System.nanoTime() - l);
            paramCIImage = (CIImage)localObject;
          }
        }
      }
      AppMethodBeat.o(219744);
      return paramCIImage;
    }
    
    public String getReportKey()
    {
      AppMethodBeat.i(219743);
      String str = MemoryReportHelper.appendReportKey(this.filterMap.values());
      AppMethodBeat.o(219743);
      return str;
    }
    
    public void notifyOnEffectRemove()
    {
      this.onEffectRemove = true;
    }
    
    public void release()
    {
      try
      {
        AppMethodBeat.i(219747);
        Iterator localIterator = this.filterMap.values().iterator();
        while (localIterator.hasNext()) {
          ((TAVVideoEffect.Filter)localIterator.next()).release();
        }
        this.filterMap.clear();
      }
      finally {}
      this.reportSession.commit();
      AppMethodBeat.o(219747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.VideoEffectProxy
 * JD-Core Version:    0.7.0.1
 */