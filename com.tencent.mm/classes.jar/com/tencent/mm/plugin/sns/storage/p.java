package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hi;
import com.tencent.mm.plugin.sns.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class p
  extends MAutoStorage<o>
  implements f
{
  public static final String[] SQL_CREATE;
  public boolean QYF = false;
  public h omV;
  
  static
  {
    AppMethodBeat.i(97465);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(o.info, "SnsComment") };
    AppMethodBeat.o(97465);
  }
  
  public p(h paramh)
  {
    super(paramh, o.info, "SnsComment", hi.INDEX_CREATE);
    this.omV = paramh;
  }
  
  public static String hkK()
  {
    return "select *, rowid from SnsComment";
  }
  
  public final boolean V(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(97463);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      String str = " update SnsComment set isSilence = " + i + " where isSilence != " + i + " and  snsID = " + paramLong;
      Log.i("MicroMsg.SnsCommentStorage", "updateIsSilence ".concat(String.valueOf(str)));
      paramBoolean = this.omV.execSQL("SnsComment", str);
      AppMethodBeat.o(97463);
      return paramBoolean;
    }
  }
  
  public final boolean a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(97457);
    if (Util.isNullOrNil(paramString2)) {}
    for (paramString1 = "select count(*) from SnsComment where snsID = " + paramLong + " and createTime = " + paramInt + " and talker = '" + paramString1 + "'";; paramString1 = "select count(*) from SnsComment where snsID = " + paramLong + " and clientId = '" + paramString2 + "'")
    {
      paramString1 = rawQuery(paramString1, new String[0]);
      if (paramString1 == null) {
        break label144;
      }
      paramString1.moveToFirst();
      paramInt = paramString1.getInt(0);
      paramString1.close();
      if (paramInt <= 0) {
        break;
      }
      AppMethodBeat.o(97457);
      return true;
    }
    AppMethodBeat.o(97457);
    return false;
    label144:
    AppMethodBeat.o(97457);
    return false;
  }
  
  public final Cursor alA(int paramInt)
  {
    AppMethodBeat.i(97455);
    Object localObject = "select *, rowid from SnsComment where isSend = 0 order by createTime desc LIMIT " + paramInt;
    Log.v("MicroMsg.SnsCommentStorage", "getCursor sql:".concat(String.valueOf(localObject)));
    localObject = this.omV.rawQuery((String)localObject, null);
    AppMethodBeat.o(97455);
    return localObject;
  }
  
  public final int dkF()
  {
    int i = 0;
    AppMethodBeat.i(97454);
    Cursor localCursor = this.omV.rawQuery(" select count(*) from SnsComment where isRead = ? and isSilence != ? ", new String[] { "0", "1" }, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(97454);
      return 0;
    }
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(97454);
    return i;
  }
  
  public final boolean dkG()
  {
    AppMethodBeat.i(97462);
    boolean bool = this.omV.execSQL("SnsComment", " update SnsComment set isRead = 1 where isRead = 0");
    AppMethodBeat.o(97462);
    return bool;
  }
  
  public final void gGK()
  {
    AppMethodBeat.i(97464);
    this.omV.bzv("SnsComment");
    AppMethodBeat.o(97464);
  }
  
  public final boolean hed()
  {
    return this.QYF;
  }
  
  public final Cursor hkL()
  {
    AppMethodBeat.i(97456);
    Cursor localCursor = this.omV.rawQuery("select *, rowid from SnsComment where isRead = ?  and isSilence != ?  order by createTime desc", new String[] { "0", "1" });
    AppMethodBeat.o(97456);
    return localCursor;
  }
  
  public final int hkM()
  {
    AppMethodBeat.i(97458);
    Cursor localCursor = rawQuery("select count(*) from SnsComment where isSend = 0", new String[0]);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      int i = localCursor.getInt(0);
      localCursor.close();
      AppMethodBeat.o(97458);
      return i;
    }
    AppMethodBeat.o(97458);
    return 0;
  }
  
  public final o o(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(97459);
    Object localObject1 = "";
    if (paramInt == 9) {
      localObject1 = "" + "(2)";
    }
    Object localObject2 = localObject1;
    if (paramInt == 10) {
      localObject2 = (String)localObject1 + "(8,16)";
    }
    localObject2 = rawQuery("select *, rowid from SnsComment where snsID = " + paramLong1 + " and commentSvrID = " + paramLong2 + " and type in " + (String)localObject2, new String[0]);
    if (localObject2 != null) {
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject1 = new o();
        ((o)localObject1).convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(97459);
      return localObject1;
      localObject1 = null;
      break;
      localObject1 = null;
    }
  }
  
  public final boolean p(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(97461);
    String str1 = "";
    if (paramInt == 9) {
      str1 = "" + "(2)";
    }
    String str2 = str1;
    if (paramInt == 10) {
      str2 = str1 + "(8,16)";
    }
    str1 = "delete from SnsComment where snsID = " + paramLong1 + " and commentSvrID = " + paramLong2 + " and type in " + str2;
    boolean bool = this.omV.execSQL("SnsComment", str1);
    AppMethodBeat.o(97461);
    return bool;
  }
  
  public final boolean vh(long paramLong)
  {
    AppMethodBeat.i(97460);
    String str = "delete from SnsComment where snsID = ".concat(String.valueOf(paramLong));
    boolean bool = this.omV.execSQL("SnsComment", str);
    AppMethodBeat.o(97460);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.p
 * JD-Core Version:    0.7.0.1
 */