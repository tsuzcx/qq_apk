package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class u
  extends j<t>
  implements k
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(38016);
    SQL_CREATE = new String[] { j.getCreateSQLs(t.info, "snsTagInfo2") };
    AppMethodBeat.o(38016);
  }
  
  public u(e parame)
  {
    super(parame, t.info, "snsTagInfo2", null);
    this.db = parame;
  }
  
  public final boolean Xh(String paramString)
  {
    AppMethodBeat.i(38013);
    t localt = mb(5L);
    if (bo.isNullOrNil(localt.field_memberList))
    {
      AppMethodBeat.o(38013);
      return false;
    }
    boolean bool = bo.P(localt.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(38013);
    return bool;
  }
  
  public final boolean a(t paramt)
  {
    AppMethodBeat.i(38009);
    if (paramt.field_tagId == 0L)
    {
      AppMethodBeat.o(38009);
      return false;
    }
    long l = paramt.field_tagId;
    Cursor localCursor = this.db.a("select *, rowid from snsTagInfo2 where tagId = ? ", new String[] { String.valueOf(l) }, 2);
    boolean bool = localCursor.moveToFirst();
    localCursor.close();
    if (!bool) {
      super.insert(paramt);
    }
    for (;;)
    {
      doNotify(paramt.field_tagId, 0, paramt);
      AppMethodBeat.o(38009);
      return true;
      super.replace(paramt);
    }
  }
  
  public final boolean cnO()
  {
    AppMethodBeat.i(38014);
    if (cti().size() == 0)
    {
      AppMethodBeat.o(38014);
      return false;
    }
    AppMethodBeat.o(38014);
    return true;
  }
  
  public final List<Long> cti()
  {
    AppMethodBeat.i(38008);
    Cursor localCursor = this.db.a("snsTagInfo2", new String[] { "tagId" }, null, null, null, null, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(Long.valueOf(localCursor.getLong(0)));
    }
    localCursor.close();
    AppMethodBeat.o(38008);
    return localArrayList;
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(38012);
    Cursor localCursor = this.db.rawQuery("select *, rowid from snsTagInfo2 where tagId > 5", null);
    AppMethodBeat.o(38012);
    return localCursor;
  }
  
  public final List<String> lo(long paramLong)
  {
    AppMethodBeat.i(38006);
    Object localObject = mb(paramLong);
    if ((((t)localObject).field_memberList != null) && (!((t)localObject).field_memberList.equals("")))
    {
      localObject = bo.P(((t)localObject).field_memberList.split(","));
      AppMethodBeat.o(38006);
      return localObject;
    }
    localObject = new ArrayList();
    AppMethodBeat.o(38006);
    return localObject;
  }
  
  public final String lp(long paramLong)
  {
    AppMethodBeat.i(38007);
    String str = mb(paramLong).field_tagName;
    AppMethodBeat.o(38007);
    return str;
  }
  
  public final t mb(long paramLong)
  {
    AppMethodBeat.i(38005);
    Cursor localCursor = this.db.a("select *, rowid from snsTagInfo2 where tagId = ? ", new String[] { String.valueOf(paramLong) }, 2);
    t localt = new t();
    if (localCursor.moveToFirst()) {
      localt.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(38005);
    return localt;
  }
  
  public final int mc(long paramLong)
  {
    AppMethodBeat.i(38010);
    int i = this.db.delete("snsTagInfo2", " tagId = ? ", new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(38010);
    return i;
  }
  
  public final boolean v(long paramLong, String paramString)
  {
    AppMethodBeat.i(38011);
    paramString = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5 AND  tagName  =\"" + bo.wC(paramString) + "\" AND  tagId != " + paramLong;
    ab.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist ".concat(String.valueOf(paramString)));
    paramString = this.db.a(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(38011);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.u
 * JD-Core Version:    0.7.0.1
 */