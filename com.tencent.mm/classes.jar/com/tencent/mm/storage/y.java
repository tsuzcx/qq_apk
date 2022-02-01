package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class y
  extends j<x>
  implements aj, g.a
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ConcurrentHashMap<String, x> GCV;
  private e db;
  
  static
  {
    AppMethodBeat.i(116941);
    SQL_CREATE = new String[] { j.getCreateSQLs(x.info, "chatroom") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )" };
    AppMethodBeat.o(116941);
  }
  
  public y(e parame)
  {
    super(parame, x.info, "chatroom", INDEX_CREATE);
    AppMethodBeat.i(209605);
    this.GCV = new ConcurrentHashMap();
    this.db = parame;
    AppMethodBeat.o(209605);
  }
  
  private boolean a(x paramx, boolean paramBoolean)
  {
    x localx = null;
    AppMethodBeat.i(209606);
    if (paramx == null)
    {
      ac.w("MicroMsg.ChatroomStorage", "replace error(item == null)");
      AppMethodBeat.o(209606);
      return false;
    }
    if (bs.isNullOrNil(paramx.field_chatroomname))
    {
      ac.w("MicroMsg.ChatroomStorage", "replace error,item.field_chatroomname is null");
      AppMethodBeat.o(209606);
      return false;
    }
    Object localObject = "select rowid,chatroomname from chatroom where chatroomname='" + bs.aLh(paramx.field_chatroomname) + "'";
    ac.d("MicroMsg.ChatroomStorage", "replace : ".concat(String.valueOf(localObject)));
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localx = new x();
      localx.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    if (localx == null) {}
    for (paramBoolean = insertNotify(paramx, paramBoolean);; paramBoolean = update(paramx.systemRowid, paramx, paramBoolean))
    {
      AppMethodBeat.o(209606);
      return paramBoolean;
      paramx.systemRowid = localx.systemRowid;
    }
  }
  
  public final int a(g paramg)
  {
    return 0;
  }
  
  public final void w(String paramString, long paramLong)
  {
    AppMethodBeat.i(116932);
    paramString = "update chatroom set modifytime = " + paramLong + " where chatroomname = '" + bs.aLh(paramString) + "'";
    this.db.execSQL("chatroom", paramString);
    AppMethodBeat.o(116932);
  }
  
  public final String wk(String paramString)
  {
    AppMethodBeat.i(116936);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select displayname from chatroom where chatroomname='" + bs.aLh(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label112;
      }
      paramString = new x();
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
      label112:
      paramString = null;
    }
  }
  
  public final x xN(String paramString)
  {
    AppMethodBeat.i(116930);
    x localx = new x();
    localx.field_chatroomname = paramString;
    if (super.get(localx, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116930);
      return localx;
    }
    AppMethodBeat.o(116930);
    return null;
  }
  
  public final x xO(String paramString)
  {
    AppMethodBeat.i(116931);
    x localx = new x();
    localx.field_chatroomname = paramString;
    if (super.get(localx, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116931);
      return localx;
    }
    AppMethodBeat.o(116931);
    return localx;
  }
  
  public final String xP(String paramString)
  {
    AppMethodBeat.i(116933);
    if (paramString.length() > 0) {}
    Cursor localCursor;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "select roomowner from chatroom where chatroomname='" + bs.aLh(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (localCursor != null) {
        break;
      }
      ac.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
      AppMethodBeat.o(116933);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      paramString = new x();
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
  
  public final String xQ(String paramString)
  {
    AppMethodBeat.i(116934);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select memberlist from chatroom where chatroomname='" + bs.aLh(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label112;
      }
      paramString = new x();
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
  
  public final List<String> xR(String paramString)
  {
    AppMethodBeat.i(116937);
    Object localObject = xQ(paramString);
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
  
  public final boolean xS(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(116938);
    paramString = "select * from chatroom where chatroomname='" + bs.aLh(paramString) + "'";
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new x();
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
  
  public final boolean xT(String paramString)
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
  
  public final int xU(String paramString)
  {
    x localx = null;
    AppMethodBeat.i(116935);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(116935);
      return 0;
    }
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = "select memberCount from chatroom where chatroomname='" + bs.aLh(paramString) + "'";
      localObject = this.db.a((String)localObject, null, 2);
      if (((Cursor)localObject).moveToFirst())
      {
        localx = new x();
        localx.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
      if (localx == null) {
        return 0;
      }
      if (localx.field_memberCount < 0)
      {
        i = xQ(paramString).split(";").length;
        localx.field_memberCount = i;
        localObject = "update chatroom set memberCount = " + i + " where chatroomname = '" + bs.aLh(paramString) + "'";
        this.db.execSQL("chatroom", (String)localObject);
        ac.i("MicroMsg.ChatroomStorage", "[getMemberCount] init field_memberCount! username:%s count:%s", new Object[] { paramString, Integer.valueOf(i) });
      }
      int i = localx.field_memberCount;
      return i;
    }
    finally
    {
      ac.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(116935);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.y
 * JD-Core Version:    0.7.0.1
 */