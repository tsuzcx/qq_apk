package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class x
  extends j<w>
  implements aj, g.a
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(116941);
    SQL_CREATE = new String[] { j.getCreateSQLs(w.info, "chatroom") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )" };
    AppMethodBeat.o(116941);
  }
  
  public x(e parame)
  {
    super(parame, w.info, "chatroom", INDEX_CREATE);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    return 0;
  }
  
  public final String sh(String paramString)
  {
    AppMethodBeat.i(116936);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select displayname from chatroom where chatroomname='" + bt.aFQ(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label112;
      }
      paramString = new w();
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
  
  public final w tH(String paramString)
  {
    AppMethodBeat.i(116930);
    w localw = new w();
    localw.field_chatroomname = paramString;
    if (super.get(localw, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116930);
      return localw;
    }
    AppMethodBeat.o(116930);
    return null;
  }
  
  public final w tI(String paramString)
  {
    AppMethodBeat.i(116931);
    w localw = new w();
    localw.field_chatroomname = paramString;
    if (super.get(localw, new String[] { "chatroomname" }))
    {
      AppMethodBeat.o(116931);
      return localw;
    }
    AppMethodBeat.o(116931);
    return localw;
  }
  
  public final String tJ(String paramString)
  {
    AppMethodBeat.i(116933);
    if (paramString.length() > 0) {}
    Cursor localCursor;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "select roomowner from chatroom where chatroomname='" + bt.aFQ(paramString) + "'";
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
      paramString = new w();
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
  
  public final String tK(String paramString)
  {
    AppMethodBeat.i(116934);
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select memberlist from chatroom where chatroomname='" + bt.aFQ(paramString) + "'";
      localCursor = this.db.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label112;
      }
      paramString = new w();
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
  
  public final List<String> tL(String paramString)
  {
    AppMethodBeat.i(116937);
    Object localObject = tK(paramString);
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
  
  public final boolean tM(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(116938);
    paramString = "select * from chatroom where chatroomname='" + bt.aFQ(paramString) + "'";
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new w();
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
  
  public final boolean tN(String paramString)
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
  
  public final int tO(String paramString)
  {
    w localw = null;
    AppMethodBeat.i(116935);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(116935);
      return 0;
    }
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = "select memberCount from chatroom where chatroomname='" + bt.aFQ(paramString) + "'";
      localObject = this.db.a((String)localObject, null, 2);
      if (((Cursor)localObject).moveToFirst())
      {
        localw = new w();
        localw.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
      if (localw == null) {
        return 0;
      }
      if (localw.field_memberCount < 0)
      {
        i = tK(paramString).split(";").length;
        localw.field_memberCount = i;
        localObject = "update chatroom set memberCount = " + i + " where chatroomname = '" + bt.aFQ(paramString) + "'";
        this.db.execSQL("chatroom", (String)localObject);
        ad.i("MicroMsg.ChatroomStorage", "[getMemberCount] init field_memberCount! username:%s count:%s", new Object[] { paramString, Integer.valueOf(i) });
      }
      int i = localw.field_memberCount;
      return i;
    }
    finally
    {
      ad.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(116935);
    }
  }
  
  public final void v(String paramString, long paramLong)
  {
    AppMethodBeat.i(116932);
    paramString = "update chatroom set modifytime = " + paramLong + " where chatroomname = '" + bt.aFQ(paramString) + "'";
    this.db.execSQL("chatroom", paramString);
    AppMethodBeat.o(116932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.x
 * JD-Core Version:    0.7.0.1
 */