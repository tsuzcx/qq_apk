package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.model.af;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class v
  extends i<u>
  implements g.a, af
{
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )" };
  public static final String[] dXp = { i.a(u.buS, "chatroom") };
  private e dXw;
  
  public v(e parame)
  {
    super(parame, u.buS, "chatroom", cqY);
    this.dXw = parame;
  }
  
  public final int a(g paramg)
  {
    return 0;
  }
  
  public final String gV(String paramString)
  {
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select displayname from chatroom where chatroomname='" + bk.pl(paramString) + "'";
      localCursor = this.dXw.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label95;
      }
      paramString = new u();
      paramString.d(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      if (paramString == null)
      {
        return null;
        bool = false;
        break;
      }
      return paramString.field_displayname;
      label95:
      paramString = null;
    }
  }
  
  public final u in(String paramString)
  {
    u localu = new u();
    localu.field_chatroomname = paramString;
    if (super.b(localu, new String[] { "chatroomname" })) {
      return localu;
    }
    return null;
  }
  
  public final u io(String paramString)
  {
    u localu = new u();
    localu.field_chatroomname = paramString;
    if (super.b(localu, new String[] { "chatroomname" })) {}
    return localu;
  }
  
  public final String ip(String paramString)
  {
    if (paramString.length() > 0) {}
    Cursor localCursor;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "select roomowner from chatroom where chatroomname='" + bk.pl(paramString) + "'";
      localCursor = this.dXw.a(paramString, null, 2);
      if (localCursor != null) {
        break;
      }
      y.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
      return null;
    }
    if (localCursor.moveToFirst())
    {
      paramString = new u();
      paramString.d(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      if (paramString == null) {
        break;
      }
      return paramString.field_roomowner;
      paramString = null;
    }
  }
  
  public final String iq(String paramString)
  {
    boolean bool;
    Cursor localCursor;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = "select memberlist from chatroom where chatroomname='" + bk.pl(paramString) + "'";
      localCursor = this.dXw.a(paramString, null, 2);
      if (!localCursor.moveToFirst()) {
        break label95;
      }
      paramString = new u();
      paramString.d(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      if (paramString == null)
      {
        return null;
        bool = false;
        break;
      }
      return paramString.field_memberlist;
      label95:
      paramString = null;
    }
  }
  
  public final List<String> ir(String paramString)
  {
    Object localObject = iq(paramString);
    if (localObject == null) {
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
    return paramString;
  }
  
  public final boolean is(String paramString)
  {
    Object localObject = null;
    paramString = "select * from chatroom where chatroomname='" + bk.pl(paramString) + "'";
    Cursor localCursor = this.dXw.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new u();
      paramString.d(localCursor);
    }
    localCursor.close();
    return (paramString != null) && ((paramString.field_roomflag & 0x1) == 0);
  }
  
  public final boolean it(String paramString)
  {
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.dXw.delete("chatroom", "chatroomname=?", new String[] { paramString }) != 0) {
        break;
      }
      return false;
    }
    aam(paramString);
    return true;
  }
  
  public final void m(String paramString, long paramLong)
  {
    paramString = "update chatroom set modifytime = " + paramLong + " where chatroomname = '" + bk.pl(paramString) + "'";
    this.dXw.gk("chatroom", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.v
 * JD-Core Version:    0.7.0.1
 */