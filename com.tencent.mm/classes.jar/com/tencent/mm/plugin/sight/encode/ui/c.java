package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.p;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends p
{
  public static boolean qWh = true;
  public static boolean qWi = false;
  List<String> qWf;
  boolean qWg;
  
  public c(m paramm)
  {
    super(paramm, new ArrayList(), true, true);
    AppMethodBeat.i(25064);
    this.qWg = true;
    this.qWg = true;
    this.qWf = null;
    AppMethodBeat.o(25064);
  }
  
  public static boolean Zq(String paramString)
  {
    AppMethodBeat.i(25068);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25068);
      return false;
    }
    boolean bool = paramString.endsWith("@sns.tencent");
    AppMethodBeat.o(25068);
    return bool;
  }
  
  public static boolean Zr(String paramString)
  {
    AppMethodBeat.i(25069);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25069);
      return false;
    }
    boolean bool = paramString.endsWith("@search.tencent");
    AppMethodBeat.o(25069);
    return bool;
  }
  
  public static boolean Zs(String paramString)
  {
    AppMethodBeat.i(25070);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25070);
      return false;
    }
    boolean bool = paramString.endsWith("@draft.tencent");
    AppMethodBeat.o(25070);
    return bool;
  }
  
  public final void aW(List<String> paramList)
  {
    AppMethodBeat.i(25066);
    clearCache();
    this.qWf = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(25066);
  }
  
  public final boolean cni()
  {
    return this.qWg;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25065);
    if (this.qWf == null)
    {
      AppMethodBeat.o(25065);
      return 0;
    }
    int i = this.qWf.size();
    AppMethodBeat.o(25065);
    return i;
  }
  
  public final a mM(int paramInt)
  {
    AppMethodBeat.i(25067);
    if (this.qWf == null)
    {
      AppMethodBeat.o(25067);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      ab.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(25067);
      return null;
    }
    c.a locala = new c.a(this, paramInt);
    Object localObject = (String)this.qWf.get(paramInt);
    if (Zq((String)localObject)) {
      localObject = new ad("@sns.tencent");
    }
    for (;;)
    {
      locala.contact = ((ad)localObject);
      locala.Adl = this.qWg;
      AppMethodBeat.o(25067);
      return locala;
      if (Zr((String)localObject))
      {
        localObject = new ad("@search.tencent");
      }
      else if (Zs((String)localObject))
      {
        localObject = new ad("@draft.tencent");
      }
      else
      {
        aw.aaz();
        localObject = com.tencent.mm.model.c.YA().arw((String)this.qWf.get(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.c
 * JD-Core Version:    0.7.0.1
 */