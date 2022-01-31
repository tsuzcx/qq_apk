package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.model.ag;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class v
  extends j<u>
  implements g.a, ag
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(1077);
    SQL_CREATE = new String[] { j.getCreateSQLs(u.info, "chatroom") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )" };
    AppMethodBeat.o(1077);
  }
  
  public v(e parame)
  {
    super(parame, u.info, "chatroom", INDEX_CREATE);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    return 0;
  }
  
  public final String nE(String paramString)
  {
    AppMethodBeat.i(1072);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select displayname from chatroom where chatroomname='" + bo.wC(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label115;
      }
      paramString = new u();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      if (paramString == null)
      {
        AppMethodBeat.o(1072);
        return null;
        bool = false;
        break;
      }
      paramString = paramString.field_displayname;
      AppMethodBeat.o(1072);
      return paramString;
      label115:
      paramString = null;
    }
  }
  
  public final u oU(String paramString)
  {
    AppMethodBeat.i(1066);
    u localu = new u();
    localu.field_chatroomname = paramString;
    if (super.get(localu, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(1066);
      return localu;
    }
    AppMethodBeat.o(1066);
    return null;
  }
  
  public final u oV(String paramString)
  {
    AppMethodBeat.i(1067);
    u localu = new u();
    localu.field_chatroomname = paramString;
    if (super.get(localu, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(1067);
      return localu;
    }
    AppMethodBeat.o(1067);
    return localu;
  }
  
  public final String oW(String paramString)
  {
    AppMethodBeat.i(1069);
    if (paramString.length() > 0) {}
    Cursor localCursor;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "select roomowner from chatroom where chatroomname='" + bo.wC(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (localCursor != null) {
        break;
      }
      ab.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
      AppMethodBeat.o(1069);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      paramString = new u();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      if (paramString == null)
      {
        AppMethodBeat.o(1069);
        return null;
      }
      paramString = paramString.field_roomowner;
      AppMethodBeat.o(1069);
      return paramString;
      paramString = null;
    }
  }
  
  public final String oX(String paramString)
  {
    AppMethodBeat.i(1070);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select memberlist from chatroom where chatroomname='" + bo.wC(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label115;
      }
      paramString = new u();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      if (paramString == null)
      {
        AppMethodBeat.o(1070);
        return null;
        bool = false;
        break;
      }
      paramString = paramString.field_memberlist;
      AppMethodBeat.o(1070);
      return paramString;
      label115:
      paramString = null;
    }
  }
  
  public final List<String> oY(String paramString)
  {
    AppMethodBeat.i(1073);
    Object localObject = oX(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(1073);
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
    AppMethodBeat.o(1073);
    return paramString;
  }
  
  public final boolean oZ(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(1074);
    paramString = "select * from chatroom where chatroomname='" + bo.wC(paramString) + "'";
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new u();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    if ((paramString != null) && ((paramString.field_roomflag & 0x1) == 0))
    {
      AppMethodBeat.o(1074);
      return true;
    }
    AppMethodBeat.o(1074);
    return false;
  }
  
  public final boolean pa(String paramString)
  {
    AppMethodBeat.i(1075);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.db.delete("chatroom", "chatroomname=?", new String[] { paramString }) != 0) {
        break;
      }
      AppMethodBeat.o(1075);
      return false;
    }
    doNotify(paramString);
    AppMethodBeat.o(1075);
    return true;
  }
  
  public final int pb(String paramString)
  {
    u localu = null;
    AppMethodBeat.i(1071);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(1071);
      return 0;
    }
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = "select memberCount from chatroom where chatroomname='" + bo.wC(paramString) + "'";
      localObject = this.db.a((String)localObject, null, 2);
      if (((Cursor)localObject).moveToFirst())
      {
        localu = new u();
        localu.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
      if (localu == null) {
        return 0;
      }
      if (localu.field_memberCount < 0)
      {
        i = oX(paramString).split(";").length;
        localu.field_memberCount = i;
        localObject = "update chatroom set memberCount = " + i + " where chatroomname = '" + bo.wC(paramString) + "'";
        this.db.execSQL("chatroom", (String)localObject);
        ab.i("MicroMsg.ChatroomStorage", "[getMemberCount] init field_memberCount! username:%s count:%s", new Object[] { paramString, Integer.valueOf(i) });
      }
      int i = localu.field_memberCount;
      return i;
    }
    finally
    {
      ab.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(1071);
    }
  }
  
  public final void u(String paramString, long paramLong)
  {
    AppMethodBeat.i(1068);
    paramString = "update chatroom set modifytime = " + paramLong + " where chatroomname = '" + bo.wC(paramString) + "'";
    this.db.execSQL("chatroom", paramString);
    AppMethodBeat.o(1068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.v
 * JD-Core Version:    0.7.0.1
 */