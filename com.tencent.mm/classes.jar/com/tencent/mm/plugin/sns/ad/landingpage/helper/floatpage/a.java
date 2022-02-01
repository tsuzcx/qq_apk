package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.d;
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
  private Map<Integer, FloatCompHelperWithLifecycle> DtX;
  private b DtY;
  
  public a()
  {
    AppMethodBeat.i(202003);
    this.DtX = new ConcurrentHashMap();
    AppMethodBeat.o(202003);
  }
  
  public final FloatJumpCompHelper a(d paramd, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(202004);
    if ((paramd == null) || (paramViewGroup == null))
    {
      AppMethodBeat.o(202004);
      return null;
    }
    try
    {
      paramViewGroup = new FloatJumpCompHelper(paramd, paramViewGroup);
      int i = paramd.type;
      this.DtX.put(Integer.valueOf(i), paramViewGroup);
      AppMethodBeat.o(202004);
      return paramViewGroup;
    }
    catch (Throwable paramd)
    {
      AppMethodBeat.o(202004);
    }
    return null;
  }
  
  public final b a(i.a parama)
  {
    AppMethodBeat.i(202005);
    if (parama == null)
    {
      AppMethodBeat.o(202005);
      return null;
    }
    try
    {
      this.DtY = new b(parama);
      parama = this.DtY;
      AppMethodBeat.o(202005);
      return parama;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(202005);
    }
    return null;
  }
  
  public final List<m> eXi()
  {
    AppMethodBeat.i(202006);
    try
    {
      ArrayList localArrayList = new ArrayList();
      localObject = this.DtX.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        m localm = ((FloatCompHelperWithLifecycle)((Iterator)localObject).next()).eXj();
        if (localm != null) {
          localArrayList.add(localm);
        }
      }
      if (this.DtY == null) {
        break label103;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202006);
      return null;
    }
    Object localObject = this.DtY.getAllComp();
    if (c.o((Collection)localObject)) {
      localThrowable.addAll((Collection)localObject);
    }
    label103:
    AppMethodBeat.o(202006);
    return localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a
 * JD-Core Version:    0.7.0.1
 */