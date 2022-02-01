package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<Integer, FloatCompHelperWithLifecycle> PUl;
  private b PUm;
  
  public a()
  {
    AppMethodBeat.i(310842);
    this.PUl = new ConcurrentHashMap();
    AppMethodBeat.o(310842);
  }
  
  public final FloatJumpCompHelper a(f paramf, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(310850);
    if ((paramf == null) || (paramViewGroup == null))
    {
      AppMethodBeat.o(310850);
      return null;
    }
    try
    {
      paramViewGroup = new FloatJumpCompHelper(paramf, paramViewGroup);
      int i = paramf.type;
      this.PUl.put(Integer.valueOf(i), paramViewGroup);
      return paramViewGroup;
    }
    finally
    {
      AppMethodBeat.o(310850);
    }
    return null;
  }
  
  public final b a(l.a parama)
  {
    AppMethodBeat.i(310858);
    if (parama == null)
    {
      AppMethodBeat.o(310858);
      return null;
    }
    try
    {
      this.PUm = new b(parama);
      parama = this.PUm;
      return parama;
    }
    finally
    {
      AppMethodBeat.o(310858);
    }
    return null;
  }
  
  public final List<n> haX()
  {
    AppMethodBeat.i(310867);
    try
    {
      ArrayList localArrayList = new ArrayList();
      localObject = this.PUl.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        n localn = ((FloatCompHelperWithLifecycle)((Iterator)localObject).next()).haY();
        if (localn != null) {
          localArrayList.add(localn);
        }
      }
      if (this.PUm == null) {
        break label103;
      }
    }
    finally
    {
      AppMethodBeat.o(310867);
      return null;
    }
    Object localObject = this.PUm.getAllComp();
    if (d.B((Collection)localObject)) {
      localList.addAll((Collection)localObject);
    }
    label103:
    AppMethodBeat.o(310867);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a
 * JD-Core Version:    0.7.0.1
 */