package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class ai
  extends MAutoStorage<ah>
  implements ap, g.a
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ConcurrentHashMap<String, ah> NRF;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(116941);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ah.info, "chatroom") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )" };
    AppMethodBeat.o(116941);
  }
  
  public ai(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ah.info, "chatroom", INDEX_CREATE);
    AppMethodBeat.i(187481);
    this.NRF = new ConcurrentHashMap();
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(187481);
  }
  
  private boolean a(ah paramah, boolean paramBoolean)
  {
    ah localah = null;
    AppMethodBeat.i(187482);
    if (paramah == null)
    {
      Log.w("MicroMsg.ChatroomStorage", "replace error(item == null)");
      AppMethodBeat.o(187482);
      return false;
    }
    if (Util.isNullOrNil(paramah.field_chatroomname))
    {
      Log.w("MicroMsg.ChatroomStorage", "replace error,item.field_chatroomname is null");
      AppMethodBeat.o(187482);
      return false;
    }
    Object localObject = "select rowid,chatroomname from chatroom where chatroomname='" + Util.escapeSqlValue(paramah.field_chatroomname) + "'";
    Log.d("MicroMsg.ChatroomStorage", "replace : ".concat(String.valueOf(localObject)));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localah = new ah();
      localah.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    if (localah == null) {}
    for (paramBoolean = insertNotify(paramah, paramBoolean);; paramBoolean = update(paramah.systemRowid, paramah, paramBoolean))
    {
      AppMethodBeat.o(187482);
      return paramBoolean;
      paramah.systemRowid = localah.systemRowid;
    }
  }
  
  public final ah Kd(String paramString)
  {
    AppMethodBeat.i(116930);
    ah localah = new ah();
    localah.field_chatroomname = paramString;
    if (super.get(localah, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116930);
      return localah;
    }
    AppMethodBeat.o(116930);
    return null;
  }
  
  public final ah Ke(String paramString)
  {
    AppMethodBeat.i(116931);
    ah localah = new ah();
    localah.field_chatroomname = paramString;
    if (super.get(localah, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116931);
      return localah;
    }
    AppMethodBeat.o(116931);
    return localah;
  }
  
  public final String Kf(String paramString)
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
      paramString = new ah();
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
  
  public final String Kg(String paramString)
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
        break label112;
      }
      paramString = new ah();
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
      label112:
      paramString = null;
    }
  }
  
  public final List<String> Kh(String paramString)
  {
    AppMethodBeat.i(116937);
    Object localObject = Kg(paramString);
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
  
  public final boolean Ki(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(116938);
    paramString = "select * from chatroom where chatroomname='" + Util.escapeSqlValue(paramString) + "'";
    Cursor localCursor = this.db.rawQuery(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new ah();
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
  
  public final boolean Kj(String paramString)
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
  
  public final int Kk(String paramString)
  {
    ah localah = null;
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
        localah = new ah();
        localah.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
      if (localah == null) {
        return 0;
      }
      if (localah.field_memberCount < 0)
      {
        i = Kg(paramString).split(";").length;
        localah.field_memberCount = i;
        localObject = "update chatroom set memberCount = " + i + " where chatroomname = '" + Util.escapeSqlValue(paramString) + "'";
        this.db.execSQL("chatroom", (String)localObject);
        Log.i("MicroMsg.ChatroomStorage", "[getMemberCount] init field_memberCount! username:%s count:%s", new Object[] { paramString, Integer.valueOf(i) });
      }
      int i = localah.field_memberCount;
      return i;
    }
    finally
    {
      Log.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(116935);
    }
  }
  
  public final int a(g paramg)
  {
    return 0;
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
      paramString = new ah();
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
  
  public final void z(String paramString, long paramLong)
  {
    AppMethodBeat.i(116932);
    paramString = "update chatroom set modifytime = " + paramLong + " where chatroomname = '" + Util.escapeSqlValue(paramString) + "'";
    this.db.execSQL("chatroom", paramString);
    AppMethodBeat.o(116932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ai
 * JD-Core Version:    0.7.0.1
 */