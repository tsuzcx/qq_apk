package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.c;
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
  private Map<Integer, FloatCompHelperWithLifecycle> znL;
  private b znM;
  
  public a()
  {
    AppMethodBeat.i(219032);
    this.znL = new ConcurrentHashMap();
    AppMethodBeat.o(219032);
  }
  
  public final FloatJumpCompHelper a(com.tencent.mm.plugin.sns.ad.landingpage.component.b.a parama, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(219033);
    if ((parama == null) || (paramViewGroup == null))
    {
      AppMethodBeat.o(219033);
      return null;
    }
    try
    {
      paramViewGroup = new FloatJumpCompHelper(parama, paramViewGroup);
      int i = parama.type;
      this.znL.put(Integer.valueOf(i), paramViewGroup);
      AppMethodBeat.o(219033);
      return paramViewGroup;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(219033);
    }
    return null;
  }
  
  public final b a(i.a parama)
  {
    AppMethodBeat.i(219034);
    if (parama == null)
    {
      AppMethodBeat.o(219034);
      return null;
    }
    try
    {
      this.znM = new b(parama);
      parama = this.znM;
      AppMethodBeat.o(219034);
      return parama;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(219034);
    }
    return null;
  }
  
  public final List<m> dUP()
  {
    AppMethodBeat.i(219035);
    try
    {
      ArrayList localArrayList = new ArrayList();
      localObject = this.znL.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        m localm = ((FloatCompHelperWithLifecycle)((Iterator)localObject).next()).dUQ();
        if (localm != null) {
          localArrayList.add(localm);
        }
      }
      if (this.znM == null) {
        break label103;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219035);
      return null;
    }
    Object localObject = this.znM.getAllComp();
    if (c.m((Collection)localObject)) {
      localThrowable.addAll((Collection)localObject);
    }
    label103:
    AppMethodBeat.o(219035);
    return localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a
 * JD-Core Version:    0.7.0.1
 */