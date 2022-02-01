package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<Integer, FloatCompHelperWithLifecycle> yXk;
  private b yXl;
  
  public a()
  {
    AppMethodBeat.i(197571);
    this.yXk = new ConcurrentHashMap();
    AppMethodBeat.o(197571);
  }
  
  public final FloatJumpCompHelper a(com.tencent.mm.plugin.sns.ad.landingpage.component.b.a parama, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(197572);
    if ((parama == null) || (paramViewGroup == null))
    {
      AppMethodBeat.o(197572);
      return null;
    }
    try
    {
      paramViewGroup = new FloatJumpCompHelper(parama, paramViewGroup);
      int i = parama.type;
      this.yXk.put(Integer.valueOf(i), paramViewGroup);
      AppMethodBeat.o(197572);
      return paramViewGroup;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(197572);
    }
    return null;
  }
  
  public final b a(i.a parama)
  {
    AppMethodBeat.i(197573);
    if (parama == null)
    {
      AppMethodBeat.o(197573);
      return null;
    }
    try
    {
      this.yXl = new b(parama);
      parama = this.yXl;
      AppMethodBeat.o(197573);
      return parama;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(197573);
    }
    return null;
  }
  
  public final List<l> dRr()
  {
    AppMethodBeat.i(197574);
    try
    {
      ArrayList localArrayList = new ArrayList();
      localObject = this.yXk.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        l locall = ((FloatCompHelperWithLifecycle)((Iterator)localObject).next()).dRs();
        if (locall != null) {
          localArrayList.add(locall);
        }
      }
      if (this.yXl == null) {
        break label103;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197574);
      return null;
    }
    Object localObject = this.yXl.getAllComp();
    if (com.tencent.mm.plugin.sns.ad.e.b.m((Collection)localObject)) {
      localThrowable.addAll((Collection)localObject);
    }
    label103:
    AppMethodBeat.o(197574);
    return localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a
 * JD-Core Version:    0.7.0.1
 */