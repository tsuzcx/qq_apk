package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class ac
  extends j<ab>
  implements ak, g.a
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ConcurrentHashMap<String, ab> Ipo;
  private e db;
  
  static
  {
    AppMethodBeat.i(116941);
    SQL_CREATE = new String[] { j.getCreateSQLs(ab.info, "chatroom") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )" };
    AppMethodBeat.o(116941);
  }
  
  public ac(e parame)
  {
    super(parame, ab.info, "chatroom", INDEX_CREATE);
    AppMethodBeat.i(217582);
    this.Ipo = new ConcurrentHashMap();
    this.db = parame;
    AppMethodBeat.o(217582);
  }
  
  private boolean a(ab paramab, boolean paramBoolean)
  {
    ab localab = null;
    AppMethodBeat.i(217583);
    if (paramab == null)
    {
      ad.w("MicroMsg.ChatroomStorage", "replace error(item == null)");
      AppMethodBeat.o(217583);
      return false;
    }
    if (bt.isNullOrNil(paramab.field_chatroomname))
    {
      ad.w("MicroMsg.ChatroomStorage", "replace error,item.field_chatroomname is null");
      AppMethodBeat.o(217583);
      return false;
    }
    Object localObject = "select rowid,chatroomname from chatroom where chatroomname='" + bt.aQN(paramab.field_chatroomname) + "'";
    ad.d("MicroMsg.ChatroomStorage", "replace : ".concat(String.valueOf(localObject)));
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localab = new ab();
      localab.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    if (localab == null) {}
    for (paramBoolean = insertNotify(paramab, paramBoolean);; paramBoolean = update(paramab.systemRowid, paramab, paramBoolean))
    {
      AppMethodBeat.o(217583);
      return paramBoolean;
      paramab.systemRowid = localab.systemRowid;
    }
  }
  
  public final ab AN(String paramString)
  {
    AppMethodBeat.i(116930);
    ab localab = new ab();
    localab.field_chatroomname = paramString;
    if (super.get(localab, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116930);
      return localab;
    }
    AppMethodBeat.o(116930);
    return null;
  }
  
  public final ab AO(String paramString)
  {
    AppMethodBeat.i(116931);
    ab localab = new ab();
    localab.field_chatroomname = paramString;
    if (super.get(localab, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116931);
      return localab;
    }
    AppMethodBeat.o(116931);
    return localab;
  }
  
  public final String AP(String paramString)
  {
    AppMethodBeat.i(116933);
    if (paramString.length() > 0) {}
    Cursor localCursor;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "select roomowner from chatroom where chatroomname='" + bt.aQN(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (localCursor != null) {
        break;
      }
      ad.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
      AppMethodBeat.o(116933);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      paramString = new ab();
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
  
  public final String AQ(String paramString)
  {
    AppMethodBeat.i(116934);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select memberlist from chatroom where chatroomname='" + bt.aQN(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label112;
      }
      paramString = new ab();
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
  
  public final List<String> AR(String paramString)
  {
    AppMethodBeat.i(116937);
    Object localObject = AQ(paramString);
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
  
  public final boolean AS(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(116938);
    paramString = "select * from chatroom where chatroomname='" + bt.aQN(paramString) + "'";
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new ab();
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
  
  public final boolean AT(String paramString)
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
  
  public final int AU(String paramString)
  {
    ab localab = null;
    AppMethodBeat.i(116935);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(116935);
      return 0;
    }
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = "select memberCount from chatroom where chatroomname='" + bt.aQN(paramString) + "'";
      localObject = this.db.a((String)localObject, null, 2);
      if (((Cursor)localObject).moveToFirst())
      {
        localab = new ab();
        localab.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
      if (localab == null) {
        return 0;
      }
      if (localab.field_memberCount < 0)
      {
        i = AQ(paramString).split(";").length;
        localab.field_memberCount = i;
        localObject = "update chatroom set memberCount = " + i + " where chatroomname = '" + bt.aQN(paramString) + "'";
        this.db.execSQL("chatroom", (String)localObject);
        ad.i("MicroMsg.ChatroomStorage", "[getMemberCount] init field_memberCount! username:%s count:%s", new Object[] { paramString, Integer.valueOf(i) });
      }
      int i = localab.field_memberCount;
      return i;
    }
    finally
    {
      ad.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(116935);
    }
  }
  
  public final int a(g paramg)
  {
    return 0;
  }
  
  public final void y(String paramString, long paramLong)
  {
    AppMethodBeat.i(116932);
    paramString = "update chatroom set modifytime = " + paramLong + " where chatroomname = '" + bt.aQN(paramString) + "'";
    this.db.execSQL("chatroom", paramString);
    AppMethodBeat.o(116932);
  }
  
  public final String zf(String paramString)
  {
    AppMethodBeat.i(116936);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select displayname from chatroom where chatroomname='" + bt.aQN(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label116;
      }
      paramString = new ab();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ac
 * JD-Core Version:    0.7.0.1
 */