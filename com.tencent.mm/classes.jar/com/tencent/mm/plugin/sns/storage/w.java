package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;

public final class w
  extends j<v>
  implements l
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(97635);
    SQL_CREATE = new String[] { j.getCreateSQLs(v.info, "snsTagInfo2") };
    AppMethodBeat.o(97635);
  }
  
  public w(e parame)
  {
    super(parame, v.info, "snsTagInfo2", null);
    this.db = parame;
  }
  
  public final v AI(long paramLong)
  {
    AppMethodBeat.i(97624);
    Cursor localCursor = this.db.a("select *, rowid from snsTagInfo2 where tagId = ? ", new String[] { String.valueOf(paramLong) }, 2);
    v localv = new v();
    if (localCursor.moveToFirst()) {
      localv.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(97624);
    return localv;
  }
  
  public final int AJ(long paramLong)
  {
    AppMethodBeat.i(97629);
    int i = this.db.delete("snsTagInfo2", " tagId = ? ", new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(97629);
    return i;
  }
  
  public final boolean E(long paramLong, String paramString)
  {
    AppMethodBeat.i(97630);
    paramString = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5 AND  tagName  =\"" + bu.aSk(paramString) + "\" AND  tagId != " + paramLong;
    ae.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist ".concat(String.valueOf(paramString)));
    paramString = this.db.a(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(97630);
    return bool;
  }
  
  public final boolean a(v paramv)
  {
    AppMethodBeat.i(97628);
    if (paramv.field_tagId == 0L)
    {
      AppMethodBeat.o(97628);
      return false;
    }
    long l = paramv.field_tagId;
    Cursor localCursor = this.db.a("select *, rowid from snsTagInfo2 where tagId = ? ", new String[] { String.valueOf(l) }, 2);
    boolean bool = localCursor.moveToFirst();
    localCursor.close();
    if (!bool) {
      super.insert(paramv);
    }
    for (;;)
    {
      doNotify(paramv.field_tagId, 0, paramv);
      AppMethodBeat.o(97628);
      return true;
      super.replace(paramv);
    }
  }
  
  public final boolean awb(String paramString)
  {
    AppMethodBeat.i(97632);
    v localv = AI(5L);
    if (bu.isNullOrNil(localv.field_memberList))
    {
      AppMethodBeat.o(97632);
      return false;
    }
    boolean bool = bu.U(localv.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(97632);
    return bool;
  }
  
  public final boolean dWb()
  {
    AppMethodBeat.i(97633);
    if (ecT().size() == 0)
    {
      AppMethodBeat.o(97633);
      return false;
    }
    AppMethodBeat.o(97633);
    return true;
  }
  
  public final List<Long> ecT()
  {
    AppMethodBeat.i(97627);
    Cursor localCursor = this.db.a("snsTagInfo2", new String[] { "tagId" }, null, null, null, null, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(Long.valueOf(localCursor.getLong(0)));
    }
    localCursor.close();
    AppMethodBeat.o(97627);
    return localArrayList;
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(97631);
    Cursor localCursor = this.db.rawQuery("select *, rowid from snsTagInfo2 where tagId > 5", null);
    AppMethodBeat.o(97631);
    return localCursor;
  }
  
  public final List<String> zT(long paramLong)
  {
    AppMethodBeat.i(97625);
    Object localObject = AI(paramLong);
    if ((((v)localObject).field_memberList != null) && (!((v)localObject).field_memberList.equals("")))
    {
      localObject = bu.U(((v)localObject).field_memberList.split(","));
      AppMethodBeat.o(97625);
      return localObject;
    }
    localObject = new ArrayList();
    AppMethodBeat.o(97625);
    return localObject;
  }
  
  public final String zU(long paramLong)
  {
    AppMethodBeat.i(97626);
    String str = AI(paramLong).field_tagName;
    AppMethodBeat.o(97626);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.w
 * JD-Core Version:    0.7.0.1
 */