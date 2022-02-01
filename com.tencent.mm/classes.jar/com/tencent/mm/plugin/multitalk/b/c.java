package com.tencent.mm.plugin.multitalk.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class c
  extends j<b>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(114650);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "MultiTalkMember"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkMember  on MultiTalkMember  (  wxGroupId )" };
    AppMethodBeat.o(114650);
  }
  
  public c(e parame)
  {
    super(parame, b.info, "MultiTalkMember", null);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(114647);
    long l = paramb.field_memberUuid;
    Cursor localCursor = rawQuery("select * from MultiTalkMember where memberUuid = '" + l + "' and wxGroupId = '" + paramb.field_wxGroupId + "'", new String[0]);
    try
    {
      if (localCursor.getCount() == 0)
      {
        bool = insert(paramb);
        ac.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "insert ret " + bool + " for memberUuid = " + l);
        return bool;
      }
      boolean bool = update(paramb, new String[0]);
      ac.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "update ret " + bool + " for memberUuid = " + l);
      return bool;
    }
    catch (Exception paramb)
    {
      ac.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", paramb.toString());
      return false;
    }
    finally
    {
      localCursor.close();
      AppMethodBeat.o(114647);
    }
  }
  
  public final LinkedList<b> amD(String paramString)
  {
    AppMethodBeat.i(114646);
    paramString = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + paramString + "'", new String[0]);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        if (paramString.moveToNext())
        {
          b localb = new b();
          localb.field_memberUuid = paramString.getInt(0);
          localb.field_wxGroupId = paramString.getString(1);
          localb.field_userName = paramString.getString(2);
          localb.field_inviteUserName = paramString.getString(3);
          localb.field_memberId = paramString.getLong(4);
          localb.field_status = paramString.getInt(5);
          localb.field_createTime = paramString.getLong(6);
          ac.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMemberList get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", new Object[] { Long.valueOf(localb.field_memberUuid), localb.field_wxGroupId, localb.field_userName, localb.field_inviteUserName, Long.valueOf(localb.field_memberId), Integer.valueOf(localb.field_status), Long.valueOf(localb.field_createTime) });
          localLinkedList.add(localb);
          continue;
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", localException.toString());
        for (;;)
        {
          return localLinkedList;
          if (paramString != null) {
            paramString.close();
          }
        }
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
        AppMethodBeat.o(114646);
      }
    }
  }
  
  public final boolean eM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114648);
    ac.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = " + paramString1 + ",member = " + paramString2);
    try
    {
      super.execSQL("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + paramString1 + "\" and userName = \"" + paramString2 + "\"");
      AppMethodBeat.o(114648);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = " + paramString1 + ",member = " + paramString2);
      AppMethodBeat.o(114648);
    }
    return false;
  }
  
  public final b hP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114645);
    paramString1 = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + paramString1 + "' and userName ='" + paramString2 + "'", new String[0]);
    if (paramString1 != null) {}
    try
    {
      if (paramString1.moveToNext())
      {
        paramString2 = new b();
        paramString2.field_memberUuid = paramString1.getInt(0);
        paramString2.field_wxGroupId = paramString1.getString(1);
        paramString2.field_userName = paramString1.getString(2);
        paramString2.field_inviteUserName = paramString1.getString(3);
        paramString2.field_memberId = paramString1.getLong(4);
        paramString2.field_status = paramString1.getInt(5);
        paramString2.field_createTime = paramString1.getLong(6);
        ac.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMember get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", new Object[] { Long.valueOf(paramString2.field_memberUuid), paramString2.field_wxGroupId, paramString2.field_userName, paramString2.field_inviteUserName, Long.valueOf(paramString2.field_memberId), Integer.valueOf(paramString2.field_status), Long.valueOf(paramString2.field_createTime) });
        return paramString2;
      }
      if (paramString1 != null) {
        paramString1.close();
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        ac.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", paramString2.toString());
        if (paramString1 != null) {
          paramString1.close();
        }
      }
    }
    finally
    {
      if (paramString1 == null) {
        break label286;
      }
      paramString1.close();
      AppMethodBeat.o(114645);
    }
    AppMethodBeat.o(114645);
    return null;
  }
  
  public final boolean zB(String paramString)
  {
    AppMethodBeat.i(114649);
    ac.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = ".concat(String.valueOf(paramString)));
    try
    {
      super.execSQL("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + paramString + "\"");
      AppMethodBeat.o(114649);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(114649);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.c
 * JD-Core Version:    0.7.0.1
 */