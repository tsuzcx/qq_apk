package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class g
  extends j<com.tencent.mm.g.c.g>
{
  public static final String[] SQL_CREATE;
  private h fnw;
  SparseArray<String> ywy;
  
  static
  {
    AppMethodBeat.i(80280);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.g.c.g.Hm(), "AddContactAntispamTicket") };
    AppMethodBeat.o(80280);
  }
  
  public g(e parame)
  {
    super(parame, com.tencent.mm.g.c.g.Hm(), "AddContactAntispamTicket", null);
    AppMethodBeat.i(80275);
    this.ywy = new SparseArray();
    this.fnw = ((h)parame);
    AppMethodBeat.o(80275);
  }
  
  public final String aqP(String paramString)
  {
    AppMethodBeat.i(80279);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80279);
      return null;
    }
    Object localObject = (String)this.ywy.get(paramString.hashCode());
    if (!bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(80279);
      return localObject;
    }
    localObject = new g.a();
    ((g.a)localObject).field_userName = paramString;
    if (get((c)localObject, new String[] { "userName" }))
    {
      in(((g.a)localObject).field_userName, ((g.a)localObject).field_ticket);
      paramString = ((g.a)localObject).field_ticket;
      AppMethodBeat.o(80279);
      return paramString;
    }
    AppMethodBeat.o(80279);
    return null;
  }
  
  public final void ev(List<com.tencent.mm.g.c.g> paramList)
  {
    AppMethodBeat.i(80277);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(80277);
      return;
    }
    long l = this.fnw.kr(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      replace((com.tencent.mm.g.c.g)paramList.next());
    }
    this.fnw.nY(l);
    AppMethodBeat.o(80277);
  }
  
  public final void in(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80278);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(80278);
      return;
    }
    this.ywy.put(paramString1.hashCode(), paramString2);
    AppMethodBeat.o(80278);
  }
  
  public final void x(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(80276);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(80276);
      return;
    }
    g.a locala = new g.a();
    locala.field_userName = paramString1;
    locala.field_scene = paramInt;
    locala.field_ticket = paramString2;
    replace(locala);
    in(paramString1, paramString2);
    AppMethodBeat.o(80276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.g
 * JD-Core Version:    0.7.0.1
 */