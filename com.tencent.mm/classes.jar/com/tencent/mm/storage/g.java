package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;

public final class g
  extends j<com.tencent.mm.g.c.g>
{
  public static final String[] SQL_CREATE;
  SparseArray<String> Feh;
  private h gPa;
  
  static
  {
    AppMethodBeat.i(152799);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.g.c.g.So(), "AddContactAntispamTicket") };
    AppMethodBeat.o(152799);
  }
  
  public g(e parame)
  {
    super(parame, com.tencent.mm.g.c.g.So(), "AddContactAntispamTicket", null);
    AppMethodBeat.i(152794);
    this.Feh = new SparseArray();
    this.gPa = ((h)parame);
    AppMethodBeat.o(152794);
  }
  
  public final void D(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(152795);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(152795);
      return;
    }
    a locala = new a();
    locala.field_userName = paramString1;
    locala.field_scene = paramInt;
    locala.field_ticket = paramString2;
    replace(locala);
    kY(paramString1, paramString2);
    AppMethodBeat.o(152795);
  }
  
  public final String aHl(String paramString)
  {
    AppMethodBeat.i(152798);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152798);
      return null;
    }
    Object localObject = (String)this.Feh.get(paramString.hashCode());
    if (!bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(152798);
      return localObject;
    }
    localObject = new a();
    ((a)localObject).field_userName = paramString;
    if (get((c)localObject, new String[] { "userName" }))
    {
      kY(((a)localObject).field_userName, ((a)localObject).field_ticket);
      paramString = ((a)localObject).field_ticket;
      AppMethodBeat.o(152798);
      return paramString;
    }
    AppMethodBeat.o(152798);
    return null;
  }
  
  public final void gP(List<com.tencent.mm.g.c.g> paramList)
  {
    AppMethodBeat.i(152796);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(152796);
      return;
    }
    long l = this.gPa.rb(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      replace((com.tencent.mm.g.c.g)paramList.next());
    }
    this.gPa.mX(l);
    AppMethodBeat.o(152796);
  }
  
  public final void kY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152797);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(152797);
      return;
    }
    this.Feh.put(paramString1.hashCode(), paramString2);
    AppMethodBeat.o(152797);
  }
  
  public static final class a
    extends com.tencent.mm.g.c.g
  {
    public final c.a getDBInfo()
    {
      AppMethodBeat.i(152793);
      c.a locala = com.tencent.mm.g.c.g.So();
      AppMethodBeat.o(152793);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.g
 * JD-Core Version:    0.7.0.1
 */