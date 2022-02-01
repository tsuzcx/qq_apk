package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ak
  extends MAutoStorage<aj>
  implements ar
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(116941);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(aj.info, "chatroom") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )" };
    AppMethodBeat.o(116941);
  }
  
  public ak(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aj.info, "chatroom", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  private boolean a(aj paramaj, boolean paramBoolean)
  {
    aj localaj = null;
    AppMethodBeat.i(248611);
    if (paramaj == null)
    {
      Log.w("MicroMsg.ChatroomStorage", "replace error(item == null)");
      AppMethodBeat.o(248611);
      return false;
    }
    if (Util.isNullOrNil(paramaj.field_chatroomname))
    {
      Log.w("MicroMsg.ChatroomStorage", "replace error,item.field_chatroomname is null");
      AppMethodBeat.o(248611);
      return false;
    }
    Object localObject = "select rowid,chatroomname from chatroom where chatroomname='" + Util.escapeSqlValue(paramaj.field_chatroomname) + "'";
    Log.d("MicroMsg.ChatroomStorage", "replace : ".concat(String.valueOf(localObject)));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localaj = new aj();
      localaj.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    if (localaj == null) {}
    for (paramBoolean = insertNotify(paramaj, paramBoolean);; paramBoolean = update(paramaj.systemRowid, paramaj, paramBoolean))
    {
      AppMethodBeat.o(248611);
      return paramBoolean;
      paramaj.systemRowid = localaj.systemRowid;
    }
  }
  
  public final void A(String paramString, long paramLong)
  {
    AppMethodBeat.i(116932);
    paramString = "update chatroom set modifytime = " + paramLong + " where chatroomname = '" + Util.escapeSqlValue(paramString) + "'";
    this.db.execSQL("chatroom", paramString);
    AppMethodBeat.o(116932);
  }
  
  public final boolean JA(String paramString)
  {
    AppMethodBeat.i(116939);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.db.delete("chatroom", "chatroomname=?", new String[] { paramString }) != 0) {
        break;
      }
      AppMethodBeat.o(116939);
      return false;
    }
    doNotify(paramString);
    AppMethodBeat.o(116939);
    return true;
  }
  
  public final int JB(String paramString)
  {
    aj localaj = null;
    AppMethodBeat.i(116935);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(116935);
      return 0;
    }
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = "select memberCount from chatroom where chatroomname='" + Util.escapeSqlValue(paramString) + "'";
      localObject = this.db.rawQuery((String)localObject, null, 2);
      if (((Cursor)localObject).moveToFirst())
      {
        localaj = new aj();
        localaj.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
      if (localaj == null) {
        return 0;
      }
      if (localaj.field_memberCount < 0)
      {
        i = Jx(paramString).split(";").length;
        localaj.field_memberCount = i;
        localObject = "update chatroom set memberCount = " + i + " where chatroomname = '" + Util.escapeSqlValue(paramString) + "'";
        this.db.execSQL("chatroom", (String)localObject);
        Log.i("MicroMsg.ChatroomStorage", "[getMemberCount] init field_memberCount! username:%s count:%s", new Object[] { paramString, Integer.valueOf(i) });
      }
      int i = localaj.field_memberCount;
      return i;
    }
    finally
    {
      Log.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(116935);
    }
  }
  
  public final aj Ju(String paramString)
  {
    AppMethodBeat.i(116930);
    aj localaj = new aj();
    localaj.field_chatroomname = paramString;
    if (super.get(localaj, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116930);
      return localaj;
    }
    AppMethodBeat.o(116930);
    return null;
  }
  
  public final aj Jv(String paramString)
  {
    AppMethodBeat.i(116931);
    aj localaj = new aj();
    localaj.field_chatroomname = paramString;
    if (super.get(localaj, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116931);
      return localaj;
    }
    AppMethodBeat.o(116931);
    return localaj;
  }
  
  public final String Jw(String paramString)
  {
    AppMethodBeat.i(116933);
    if (paramString.length() > 0) {}
    Cursor localCursor;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "select roomowner from chatroom where chatroomname='" + Util.escapeSqlValue(paramString) + "'";
      localCursor = this.db.rawQuery(paramString, null, 2);
      if (localCursor != null) {
        break;
      }
      Log.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
      AppMethodBeat.o(116933);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      paramString = new aj();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      if (paramString == null)
      {
        AppMethodBeat.o(116933);
        return null;
      }
      paramString = paramString.field_roomowner;
      AppMethodBeat.o(116933);
      return paramString;
      paramString = null;
    }
  }
  
  public final String Jx(String paramString)
  {
    AppMethodBeat.i(116934);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select memberlist from chatroom where chatroomname='" + Util.escapeSqlValue(paramString) + "'";
      localCursor = this.db.rawQuery(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label116;
      }
      paramString = new aj();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      if (paramString == null)
      {
        AppMethodBeat.o(116934);
        return null;
        bool = false;
        break;
      }
      paramString = paramString.field_memberlist;
      AppMethodBeat.o(116934);
      return paramString;
      label116:
      paramString = null;
    }
  }
  
  public final List<String> Jy(String paramString)
  {
    AppMethodBeat.i(116937);
    Object localObject = Jx(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(116937);
      return null;
    }
    paramString = new LinkedList();
    if (!((String)localObject).equals(""))
    {
      localObject = ((String)localObject).split(";");
      int i = 0;
      while (i < localObject.length)
      {
        paramString.add(localObject[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(116937);
    return paramString;
  }
  
  public final boolean Jz(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(116938);
    paramString = "select * from chatroom where chatroomname='" + Util.escapeSqlValue(paramString) + "'";
    Cursor localCursor = this.db.rawQuery(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new aj();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    if ((paramString != null) && ((paramString.field_roomflag & 0x1) == 0))
    {
      AppMethodBeat.o(116938);
      return true;
    }
    AppMethodBeat.o(116938);
    return false;
  }
  
  public final String getDisplayName(String paramString)
  {
    AppMethodBeat.i(116936);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select displayname from chatroom where chatroomname='" + Util.escapeSqlValue(paramString) + "'";
      localCursor = this.db.rawQuery(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label116;
      }
      paramString = new aj();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      if (paramString == null)
      {
        AppMethodBeat.o(116936);
        return null;
        bool = false;
        break;
      }
      paramString = paramString.field_displayname;
      AppMethodBeat.o(116936);
      return paramString;
      label116:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ak
 * JD-Core Version:    0.7.0.1
 */