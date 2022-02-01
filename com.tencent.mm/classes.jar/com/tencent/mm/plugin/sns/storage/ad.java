package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class ad
  extends MAutoStorage<ac>
  implements n
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(97635);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ac.info, "snsTagInfo2") };
    AppMethodBeat.o(97635);
  }
  
  public ad(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ac.info, "snsTagInfo2", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final Cursor Fv()
  {
    AppMethodBeat.i(97631);
    Cursor localCursor = this.db.rawQuery("select *, rowid from snsTagInfo2 where tagId > 5", null);
    AppMethodBeat.o(97631);
    return localCursor;
  }
  
  public final boolean a(ac paramac)
  {
    AppMethodBeat.i(97628);
    if (paramac.field_tagId == 0L)
    {
      AppMethodBeat.o(97628);
      return false;
    }
    long l = paramac.field_tagId;
    Cursor localCursor = this.db.rawQuery("select *, rowid from snsTagInfo2 where tagId = ? ", new String[] { String.valueOf(l) }, 2);
    boolean bool = localCursor.moveToFirst();
    localCursor.close();
    if (!bool) {
      super.insert(paramac);
    }
    for (;;)
    {
      doNotify(paramac.field_tagId, 0, paramac);
      AppMethodBeat.o(97628);
      return true;
      super.replace(paramac);
    }
  }
  
  public final boolean aRZ(String paramString)
  {
    AppMethodBeat.i(97632);
    ac localac = vl(5L);
    if (Util.isNullOrNil(localac.field_memberList))
    {
      AppMethodBeat.o(97632);
      return false;
    }
    boolean bool = Util.stringsToList(localac.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(97632);
    return bool;
  }
  
  public final boolean ah(long paramLong, String paramString)
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
  
  public final boolean hei()
  {
    AppMethodBeat.i(97633);
    List localList = hlo();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(97633);
      return false;
    }
    AppMethodBeat.o(97633);
    return true;
  }
  
  public final List<Long> hlo()
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
  
  public final List<String> ux(long paramLong)
  {
    AppMethodBeat.i(97625);
    Object localObject = vl(paramLong);
    if ((((ac)localObject).field_memberList != null) && (!((ac)localObject).field_memberList.equals("")))
    {
      localObject = Util.stringsToList(((ac)localObject).field_memberList.split(","));
      AppMethodBeat.o(97625);
      return localObject;
    }
    localObject = new ArrayList();
    AppMethodBeat.o(97625);
    return localObject;
  }
  
  public final String uy(long paramLong)
  {
    AppMethodBeat.i(97626);
    Object localObject = vl(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(97626);
      return "";
    }
    localObject = ((ac)localObject).field_tagName;
    AppMethodBeat.o(97626);
    return localObject;
  }
  
  public final ac vl(long paramLong)
  {
    AppMethodBeat.i(97624);
    Cursor localCursor = this.db.rawQuery("select *, rowid from snsTagInfo2 where tagId = ? ", new String[] { String.valueOf(paramLong) }, 2);
    ac localac = new ac();
    if (localCursor.moveToFirst()) {
      localac.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(97624);
    return localac;
  }
  
  public final int vm(long paramLong)
  {
    AppMethodBeat.i(97629);
    int i = this.db.delete("snsTagInfo2", " tagId = ? ", new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(97629);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ad
 * JD-Core Version:    0.7.0.1
 */