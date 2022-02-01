package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;

public final class g
  extends MAutoStorage<com.tencent.mm.f.c.g>
{
  public static final String[] SQL_CREATE;
  SparseArray<String> Vcx;
  private h lvy;
  
  static
  {
    AppMethodBeat.i(152799);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.f.c.g.aoY(), "AddContactAntispamTicket") };
    AppMethodBeat.o(152799);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.f.c.g.aoY(), "AddContactAntispamTicket", null);
    AppMethodBeat.i(152794);
    this.Vcx = new SparseArray();
    this.lvy = ((h)paramISQLiteDatabase);
    AppMethodBeat.o(152794);
  }
  
  public final void T(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(152795);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(152795);
      return;
    }
    a locala = new a();
    locala.field_userName = paramString1;
    locala.field_scene = paramInt;
    locala.field_ticket = paramString2;
    replace(locala);
    nG(paramString1, paramString2);
    AppMethodBeat.o(152795);
  }
  
  public final String buW(String paramString)
  {
    AppMethodBeat.i(152798);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152798);
      return null;
    }
    Object localObject = (String)this.Vcx.get(paramString.hashCode());
    if (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(152798);
      return localObject;
    }
    localObject = new a();
    ((a)localObject).field_userName = paramString;
    if (get((IAutoDBItem)localObject, new String[] { "userName" }))
    {
      nG(((a)localObject).field_userName, ((a)localObject).field_ticket);
      paramString = ((a)localObject).field_ticket;
      AppMethodBeat.o(152798);
      return paramString;
    }
    AppMethodBeat.o(152798);
    return null;
  }
  
  public final void jt(List<com.tencent.mm.f.c.g> paramList)
  {
    AppMethodBeat.i(152796);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(152796);
      return;
    }
    long l = this.lvy.beginTransaction(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      replace((com.tencent.mm.f.c.g)paramList.next());
    }
    this.lvy.endTransaction(l);
    AppMethodBeat.o(152796);
  }
  
  public final void nG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152797);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(152797);
      return;
    }
    this.Vcx.put(paramString1.hashCode(), paramString2);
    AppMethodBeat.o(152797);
  }
  
  public static final class a
    extends com.tencent.mm.f.c.g
  {
    public final IAutoDBItem.MAutoDBInfo getDBInfo()
    {
      AppMethodBeat.i(152793);
      IAutoDBItem.MAutoDBInfo localMAutoDBInfo = com.tencent.mm.f.c.g.aoY();
      AppMethodBeat.o(152793);
      return localMAutoDBInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.g
 * JD-Core Version:    0.7.0.1
 */