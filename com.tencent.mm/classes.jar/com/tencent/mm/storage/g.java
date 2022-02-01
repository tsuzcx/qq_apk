package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;

public final class g
  extends j<com.tencent.mm.g.c.g>
{
  public static final String[] SQL_CREATE;
  SparseArray<String> GBQ;
  private h hpA;
  
  static
  {
    AppMethodBeat.i(152799);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.g.c.g.Th(), "AddContactAntispamTicket") };
    AppMethodBeat.o(152799);
  }
  
  public g(e parame)
  {
    super(parame, com.tencent.mm.g.c.g.Th(), "AddContactAntispamTicket", null);
    AppMethodBeat.i(152794);
    this.GBQ = new SparseArray();
    this.hpA = ((h)parame);
    AppMethodBeat.o(152794);
  }
  
  public final void C(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(152795);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(152795);
      return;
    }
    a locala = new a();
    locala.field_userName = paramString1;
    locala.field_scene = paramInt;
    locala.field_ticket = paramString2;
    replace(locala);
    lv(paramString1, paramString2);
    AppMethodBeat.o(152795);
  }
  
  public final String aMF(String paramString)
  {
    AppMethodBeat.i(152798);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152798);
      return null;
    }
    Object localObject = (String)this.GBQ.get(paramString.hashCode());
    if (!bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(152798);
      return localObject;
    }
    localObject = new a();
    ((a)localObject).field_userName = paramString;
    if (get((c)localObject, new String[] { "userName" }))
    {
      lv(((a)localObject).field_userName, ((a)localObject).field_ticket);
      paramString = ((a)localObject).field_ticket;
      AppMethodBeat.o(152798);
      return paramString;
    }
    AppMethodBeat.o(152798);
    return null;
  }
  
  public final void hc(List<com.tencent.mm.g.c.g> paramList)
  {
    AppMethodBeat.i(152796);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(152796);
      return;
    }
    long l = this.hpA.vE(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      replace((com.tencent.mm.g.c.g)paramList.next());
    }
    this.hpA.qL(l);
    AppMethodBeat.o(152796);
  }
  
  public final void lv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152797);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(152797);
      return;
    }
    this.GBQ.put(paramString1.hashCode(), paramString2);
    AppMethodBeat.o(152797);
  }
  
  public static final class a
    extends com.tencent.mm.g.c.g
  {
    public final c.a getDBInfo()
    {
      AppMethodBeat.i(152793);
      c.a locala = com.tencent.mm.g.c.g.Th();
      AppMethodBeat.o(152793);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.g
 * JD-Core Version:    0.7.0.1
 */