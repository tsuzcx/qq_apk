package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;

public final class g
  extends j<com.tencent.mm.g.c.g>
{
  public static final String[] SQL_CREATE;
  SparseArray<String> IHV;
  private h hKK;
  
  static
  {
    AppMethodBeat.i(152799);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.g.c.g.VD(), "AddContactAntispamTicket") };
    AppMethodBeat.o(152799);
  }
  
  public g(e parame)
  {
    super(parame, com.tencent.mm.g.c.g.VD(), "AddContactAntispamTicket", null);
    AppMethodBeat.i(152794);
    this.IHV = new SparseArray();
    this.hKK = ((h)parame);
    AppMethodBeat.o(152794);
  }
  
  public final void F(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(152795);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(152795);
      return;
    }
    a locala = new a();
    locala.field_userName = paramString1;
    locala.field_scene = paramInt;
    locala.field_ticket = paramString2;
    replace(locala);
    mb(paramString1, paramString2);
    AppMethodBeat.o(152795);
  }
  
  public final String aTI(String paramString)
  {
    AppMethodBeat.i(152798);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152798);
      return null;
    }
    Object localObject = (String)this.IHV.get(paramString.hashCode());
    if (!bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(152798);
      return localObject;
    }
    localObject = new a();
    ((a)localObject).field_userName = paramString;
    if (get((c)localObject, new String[] { "userName" }))
    {
      mb(((a)localObject).field_userName, ((a)localObject).field_ticket);
      paramString = ((a)localObject).field_ticket;
      AppMethodBeat.o(152798);
      return paramString;
    }
    AppMethodBeat.o(152798);
    return null;
  }
  
  public final void hx(List<com.tencent.mm.g.c.g> paramList)
  {
    AppMethodBeat.i(152796);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(152796);
      return;
    }
    long l = this.hKK.yi(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      replace((com.tencent.mm.g.c.g)paramList.next());
    }
    this.hKK.sW(l);
    AppMethodBeat.o(152796);
  }
  
  public final void mb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152797);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(152797);
      return;
    }
    this.IHV.put(paramString1.hashCode(), paramString2);
    AppMethodBeat.o(152797);
  }
  
  public static final class a
    extends com.tencent.mm.g.c.g
  {
    public final c.a getDBInfo()
    {
      AppMethodBeat.i(152793);
      c.a locala = com.tencent.mm.g.c.g.VD();
      AppMethodBeat.o(152793);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.g
 * JD-Core Version:    0.7.0.1
 */