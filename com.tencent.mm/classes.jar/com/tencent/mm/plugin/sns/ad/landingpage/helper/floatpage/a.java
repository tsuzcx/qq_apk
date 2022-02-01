package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<Integer, FloatCompHelperWithLifecycle> JDm;
  private b JDn;
  
  public a()
  {
    AppMethodBeat.i(207164);
    this.JDm = new ConcurrentHashMap();
    AppMethodBeat.o(207164);
  }
  
  public final FloatJumpCompHelper a(e parame, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(207166);
    if ((parame == null) || (paramViewGroup == null))
    {
      AppMethodBeat.o(207166);
      return null;
    }
    try
    {
      paramViewGroup = new FloatJumpCompHelper(parame, paramViewGroup);
      int i = parame.type;
      this.JDm.put(Integer.valueOf(i), paramViewGroup);
      AppMethodBeat.o(207166);
      return paramViewGroup;
    }
    catch (Throwable parame)
    {
      AppMethodBeat.o(207166);
    }
    return null;
  }
  
  public final b a(i.a parama)
  {
    AppMethodBeat.i(207167);
    if (parama == null)
    {
      AppMethodBeat.o(207167);
      return null;
    }
    try
    {
      this.JDn = new b(parama);
      parama = this.JDn;
      AppMethodBeat.o(207167);
      return parama;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(207167);
    }
    return null;
  }
  
  public final List<m> fKI()
  {
    AppMethodBeat.i(207169);
    try
    {
      ArrayList localArrayList = new ArrayList();
      localObject = this.JDm.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        m localm = ((FloatCompHelperWithLifecycle)((Iterator)localObject).next()).fKJ();
        if (localm != null) {
          localArrayList.add(localm);
        }
      }
      if (this.JDn == null) {
        break label103;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(207169);
      return null;
    }
    Object localObject = this.JDn.getAllComp();
    if (d.n((Collection)localObject)) {
      localThrowable.addAll((Collection)localObject);
    }
    label103:
    AppMethodBeat.o(207169);
    return localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a
 * JD-Core Version:    0.7.0.1
 */