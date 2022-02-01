package com.tencent.tavkit.component.effectchain;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
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

public class VideoMixEffectProxy
  implements TAVVideoMixEffect
{
  private boolean autoCheckEffectRemove;
  private CopyOnWriteArrayList<TAVVideoMixEffect> effects;
  private final List<FilterProxy> filterProxies;
  
  public VideoMixEffectProxy()
  {
    AppMethodBeat.i(218724);
    this.effects = new CopyOnWriteArrayList();
    this.filterProxies = new ArrayList();
    this.autoCheckEffectRemove = true;
    AppMethodBeat.o(218724);
  }
  
  public TAVVideoMixEffect.Filter createFilter()
  {
    AppMethodBeat.i(218784);
    FilterProxy localFilterProxy = new FilterProxy(null);
    this.filterProxies.add(localFilterProxy);
    AppMethodBeat.o(218784);
    return localFilterProxy;
  }
  
  public String effectId()
  {
    AppMethodBeat.i(218772);
    String str = "VideoMixEffectProxy" + Integer.toHexString(hashCode());
    AppMethodBeat.o(218772);
    return str;
  }
  
  public List<TAVVideoMixEffect> getEffects()
  {
    return this.effects;
  }
  
  public boolean isAutoCheckEffectRemove()
  {
    return this.autoCheckEffectRemove;
  }
  
  public void notifyOnEffectRemove()
  {
    AppMethodBeat.i(218761);
    Iterator localIterator = this.filterProxies.iterator();
    while (localIterator.hasNext()) {
      FilterProxy.access$000((FilterProxy)localIterator.next());
    }
    AppMethodBeat.o(218761);
  }
  
  public void setAutoCheckEffectRemove(boolean paramBoolean)
  {
    this.autoCheckEffectRemove = paramBoolean;
  }
  
  public void setEffects(CopyOnWriteArrayList<TAVVideoMixEffect> paramCopyOnWriteArrayList)
  {
    this.effects = paramCopyOnWriteArrayList;
  }
  
  static class FilterProxy
    implements TAVVideoMixEffect.Filter, IReportable
  {
    private final HashMap<String, TAVVideoMixEffect.Filter> filterMap;
    private boolean onEffectRemove;
    private final FilterChainReportSession reportSession;
    
    private FilterProxy()
    {
      AppMethodBeat.i(218710);
      this.filterMap = new HashMap();
      this.reportSession = new FilterChainReportSession();
      AppMethodBeat.o(218710);
    }
    
    private void checkRuntimeRelease(List<TAVVideoMixEffect> paramList)
    {
      AppMethodBeat.i(218721);
      if (!this.onEffectRemove)
      {
        AppMethodBeat.o(218721);
        return;
      }
      this.onEffectRemove = false;
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      Object localObject;
      while (paramList.hasNext())
      {
        localObject = (TAVVideoMixEffect)paramList.next();
        if (!TextUtils.isEmpty(((TAVVideoMixEffect)localObject).effectId())) {
          localArrayList.add(((TAVVideoMixEffect)localObject).effectId());
        }
      }
      paramList = new HashSet(this.filterMap.keySet()).iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if (!localArrayList.contains(localObject))
        {
          ((TAVVideoMixEffect.Filter)this.filterMap.get(localObject)).release();
          this.filterMap.remove(localObject);
        }
      }
      AppMethodBeat.o(218721);
    }
    
    private TAVVideoMixEffect.Filter getCacheFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
    {
      AppMethodBeat.i(218728);
      if ((paramTAVVideoMixEffect == null) || (TextUtils.isEmpty(paramTAVVideoMixEffect.effectId())))
      {
        AppMethodBeat.o(218728);
        return null;
      }
      String str = paramTAVVideoMixEffect.effectId();
      if (this.filterMap.containsKey(str)) {
        paramTAVVideoMixEffect = (TAVVideoMixEffect.Filter)this.filterMap.get(str);
      }
      for (;;)
      {
        AppMethodBeat.o(218728);
        return paramTAVVideoMixEffect;
        paramTAVVideoMixEffect = paramTAVVideoMixEffect.createFilter();
        this.filterMap.put(str, paramTAVVideoMixEffect);
      }
    }
    
    private void notifyOnEffectRemove()
    {
      this.onEffectRemove = true;
    }
    
    public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
    {
      AppMethodBeat.i(218754);
      if (!(paramTAVVideoMixEffect instanceof VideoMixEffectProxy))
      {
        AppMethodBeat.o(218754);
        return null;
      }
      Object localObject = ((VideoMixEffectProxy)paramTAVVideoMixEffect).getEffects();
      if ((((VideoMixEffectProxy)paramTAVVideoMixEffect).isAutoCheckEffectRemove()) || (this.onEffectRemove)) {
        checkRuntimeRelease((List)localObject);
      }
      Iterator localIterator = ((List)localObject).iterator();
      paramTAVVideoMixEffect = null;
      TAVVideoMixEffect.Filter localFilter;
      long l;
      while (localIterator.hasNext())
      {
        localObject = (TAVVideoMixEffect)localIterator.next();
        localFilter = getCacheFilter((TAVVideoMixEffect)localObject);
        if (localFilter != null)
        {
          l = System.nanoTime();
          if (!(localFilter instanceof IReportable)) {
            break label168;
          }
        }
      }
      label168:
      for (paramTAVVideoMixEffect = ((IReportable)localFilter).getReportKey();; paramTAVVideoMixEffect = null)
      {
        localObject = localFilter.apply((TAVVideoMixEffect)localObject, paramImageCollection, paramRenderInfo);
        if (!TextUtils.isEmpty(paramTAVVideoMixEffect)) {
          this.reportSession.tick(paramTAVVideoMixEffect, System.nanoTime() - l);
        }
        paramTAVVideoMixEffect = (TAVVideoMixEffect)localObject;
        break;
        AppMethodBeat.o(218754);
        return paramTAVVideoMixEffect;
      }
    }
    
    public String getReportKey()
    {
      AppMethodBeat.i(218743);
      String str = MemoryReportHelper.appendReportKey(this.filterMap.values());
      AppMethodBeat.o(218743);
      return str;
    }
    
    public void release()
    {
      try
      {
        AppMethodBeat.i(218764);
        Iterator localIterator = this.filterMap.values().iterator();
        while (localIterator.hasNext()) {
          ((TAVVideoMixEffect.Filter)localIterator.next()).release();
        }
        this.filterMap.clear();
      }
      finally {}
      this.reportSession.commit();
      AppMethodBeat.o(218764);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.VideoMixEffectProxy
 * JD-Core Version:    0.7.0.1
 */