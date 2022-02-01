package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class t
  extends MAutoStorage<s>
  implements l
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(97635);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(s.info, "snsTagInfo2") };
    AppMethodBeat.o(97635);
  }
  
  public t(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, s.info, "snsTagInfo2", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final List<String> IZ(long paramLong)
  {
    AppMethodBeat.i(97625);
    Object localObject = JL(paramLong);
    if ((((s)localObject).field_memberList != null) && (!((s)localObject).field_memberList.equals("")))
    {
      localObject = Util.stringsToList(((s)localObject).field_memberList.split(","));
      AppMethodBeat.o(97625);
      return localObject;
    }
    localObject = new ArrayList();
    AppMethodBeat.o(97625);
    return localObject;
  }
  
  public final s JL(long paramLong)
  {
    AppMethodBeat.i(97624);
    Cursor localCursor = this.db.rawQuery("select *, rowid from snsTagInfo2 where tagId = ? ", new String[] { String.valueOf(paramLong) }, 2);
    s locals = new s();
    if (localCursor.moveToFirst()) {
      locals.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(97624);
    return locals;
  }
  
  public final int JM(long paramLong)
  {
    AppMethodBeat.i(97629);
    int i = this.db.delete("snsTagInfo2", " tagId = ? ", new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(97629);
    return i;
  }
  
  public final String Ja(long paramLong)
  {
    AppMethodBeat.i(97626);
    String str = JL(paramLong).field_tagName;
    AppMethodBeat.o(97626);
    return str;
  }
  
  public final boolean K(long paramLong, String paramString)
  {
    AppMethodBeat.i(97630);
    paramString = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5 AND  tagName  =\"" + Util.escapeSqlValue(paramString) + "\" AND  tagId != " + paramLong;
    Log.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist ".concat(String.valueOf(paramString)));
    paramString = this.db.rawQuery(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(97630);
    return bool;
  }
  
  public final boolean a(s params)
  {
    AppMethodBeat.i(97628);
    if (params.field_tagId == 0L)
    {
      AppMethodBeat.o(97628);
      return false;
    }
    long l = params.field_tagId;
    Cursor localCursor = this.db.rawQuery("select *, rowid from snsTagInfo2 where tagId = ? ", new String[] { String.valueOf(l) }, 2);
    boolean bool = localCursor.moveToFirst();
    localCursor.close();
    if (!bool) {
      super.insert(params);
    }
    for (;;)
    {
      doNotify(params.field_tagId, 0, params);
      AppMethodBeat.o(97628);
      return true;
      super.replace(params);
    }
  }
  
  public final boolean aKt(String paramString)
  {
    AppMethodBeat.i(97632);
    s locals = JL(5L);
    if (Util.isNullOrNil(locals.field_memberList))
    {
      AppMethodBeat.o(97632);
      return false;
    }
    boolean bool = Util.stringsToList(locals.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(97632);
    return bool;
  }
  
  public final boolean eZm()
  {
    AppMethodBeat.i(97633);
    if (ffg().size() == 0)
    {
      AppMethodBeat.o(97633);
      return false;
    }
    AppMethodBeat.o(97633);
    return true;
  }
  
  public final List<Long> ffg()
  {
    AppMethodBeat.i(97627);
    Cursor localCursor = this.db.query("snsTagInfo2", new String[] { "tagId" }, null, null, null, null, null, 2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.t
 * JD-Core Version:    0.7.0.1
 */