package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.al;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class ad
  extends j<ac>
  implements al, g.a
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ConcurrentHashMap<String, ac> IJI;
  private e db;
  
  static
  {
    AppMethodBeat.i(116941);
    SQL_CREATE = new String[] { j.getCreateSQLs(ac.info, "chatroom") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )" };
    AppMethodBeat.o(116941);
  }
  
  public ad(e parame)
  {
    super(parame, ac.info, "chatroom", INDEX_CREATE);
    AppMethodBeat.i(211751);
    this.IJI = new ConcurrentHashMap();
    this.db = parame;
    AppMethodBeat.o(211751);
  }
  
  private boolean a(ac paramac, boolean paramBoolean)
  {
    ac localac = null;
    AppMethodBeat.i(211752);
    if (paramac == null)
    {
      ae.w("MicroMsg.ChatroomStorage", "replace error(item == null)");
      AppMethodBeat.o(211752);
      return false;
    }
    if (bu.isNullOrNil(paramac.field_chatroomname))
    {
      ae.w("MicroMsg.ChatroomStorage", "replace error,item.field_chatroomname is null");
      AppMethodBeat.o(211752);
      return false;
    }
    Object localObject = "select rowid,chatroomname from chatroom where chatroomname='" + bu.aSk(paramac.field_chatroomname) + "'";
    ae.d("MicroMsg.ChatroomStorage", "replace : ".concat(String.valueOf(localObject)));
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localac = new ac();
      localac.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    if (localac == null) {}
    for (paramBoolean = insertNotify(paramac, paramBoolean);; paramBoolean = update(paramac.systemRowid, paramac, paramBoolean))
    {
      AppMethodBeat.o(211752);
      return paramBoolean;
      paramac.systemRowid = localac.systemRowid;
    }
  }
  
  public final String BA(String paramString)
  {
    AppMethodBeat.i(116934);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select memberlist from chatroom where chatroomname='" + bu.aSk(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label112;
      }
      paramString = new ac();
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
  
  public final List<String> BB(String paramString)
  {
    AppMethodBeat.i(116937);
    Object localObject = BA(paramString);
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
  
  public final boolean BC(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(116938);
    paramString = "select * from chatroom where chatroomname='" + bu.aSk(paramString) + "'";
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new ac();
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
  
  public final boolean BD(String paramString)
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
  
  public final int BE(String paramString)
  {
    ac localac = null;
    AppMethodBeat.i(116935);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(116935);
      return 0;
    }
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = "select memberCount from chatroom where chatroomname='" + bu.aSk(paramString) + "'";
      localObject = this.db.a((String)localObject, null, 2);
      if (((Cursor)localObject).moveToFirst())
      {
        localac = new ac();
        localac.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
      if (localac == null) {
        return 0;
      }
      if (localac.field_memberCount < 0)
      {
        i = BA(paramString).split(";").length;
        localac.field_memberCount = i;
        localObject = "update chatroom set memberCount = " + i + " where chatroomname = '" + bu.aSk(paramString) + "'";
        this.db.execSQL("chatroom", (String)localObject);
        ae.i("MicroMsg.ChatroomStorage", "[getMemberCount] init field_memberCount! username:%s count:%s", new Object[] { paramString, Integer.valueOf(i) });
      }
      int i = localac.field_memberCount;
      return i;
    }
    finally
    {
      ae.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(116935);
    }
  }
  
  public final ac Bx(String paramString)
  {
    AppMethodBeat.i(116930);
    ac localac = new ac();
    localac.field_chatroomname = paramString;
    if (super.get(localac, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116930);
      return localac;
    }
    AppMethodBeat.o(116930);
    return null;
  }
  
  public final ac By(String paramString)
  {
    AppMethodBeat.i(116931);
    ac localac = new ac();
    localac.field_chatroomname = paramString;
    if (super.get(localac, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116931);
      return localac;
    }
    AppMethodBeat.o(116931);
    return localac;
  }
  
  public final String Bz(String paramString)
  {
    AppMethodBeat.i(116933);
    if (paramString.length() > 0) {}
    Cursor localCursor;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "select roomowner from chatroom where chatroomname='" + bu.aSk(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (localCursor != null) {
        break;
      }
      ae.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
      AppMethodBeat.o(116933);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      paramString = new ac();
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
  
  public final int a(g paramg)
  {
    return 0;
  }
  
  public final void y(String paramString, long paramLong)
  {
    AppMethodBeat.i(116932);
    paramString = "update chatroom set modifytime = " + paramLong + " where chatroomname = '" + bu.aSk(paramString) + "'";
    this.db.execSQL("chatroom", paramString);
    AppMethodBeat.o(116932);
  }
  
  public final String zP(String paramString)
  {
    AppMethodBeat.i(116936);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select displayname from chatroom where chatroomname='" + bu.aSk(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label116;
      }
      paramString = new ac();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.ad
 * JD-Core Version:    0.7.0.1
 */