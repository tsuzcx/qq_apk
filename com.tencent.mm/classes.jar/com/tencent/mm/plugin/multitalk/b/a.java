package com.tencent.mm.plugin.multitalk.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class a
  extends j<com.tencent.mm.bi.f>
{
  public static final String[] SQL_CREATE;
  public static LinkedHashMap<String, Class> rjq;
  
  static
  {
    AppMethodBeat.i(114643);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.bi.f.info, "MultiTalkInfo"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkInfo_key  on MultiTalkInfo  (  wxGroupId )" };
    rjq = new a.1();
    AppMethodBeat.o(114643);
  }
  
  public a(e parame)
  {
    super(parame, com.tencent.mm.bi.f.info, "MultiTalkInfo", null);
  }
  
  public final boolean a(com.tencent.mm.bi.f paramf)
  {
    AppMethodBeat.i(114639);
    String str = paramf.field_wxGroupId;
    if (com.tencent.pb.common.c.f.dq(str))
    {
      ad.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. multiTalkInfo wxGroupId is empty!");
      AppMethodBeat.o(114639);
      return false;
    }
    ad.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d", new Object[] { str, paramf.field_groupId, Integer.valueOf(paramf.field_roomId), Long.valueOf(paramf.field_roomKey), Integer.valueOf(paramf.field_routeId), paramf.field_inviteUserName, Integer.valueOf(paramf.field_memberCount), Long.valueOf(paramf.field_createTime) });
    try
    {
      boolean bool = insert(paramf);
      ad.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "insert ret " + bool + " for id=%s" + str);
      AppMethodBeat.o(114639);
      return bool;
    }
    catch (Exception paramf)
    {
      ad.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + paramf.toString());
      AppMethodBeat.o(114639);
    }
    return false;
  }
  
  public final com.tencent.mm.bi.f ahq(String paramString)
  {
    AppMethodBeat.i(114641);
    ad.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTaklInfo for wxGroupId = %s", new Object[] { paramString });
    paramString = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, inviteUserName,memberCount,createTime,state from MultiTalkInfo where wxGroupId = '" + paramString + "'", new String[0]);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToNext())
      {
        com.tencent.mm.bi.f localf = new com.tencent.mm.bi.f();
        localf.field_wxGroupId = paramString.getString(0);
        localf.field_groupId = paramString.getString(1);
        localf.field_roomId = paramString.getInt(2);
        localf.field_roomKey = paramString.getLong(3);
        localf.field_routeId = paramString.getInt(4);
        localf.field_inviteUserName = paramString.getString(5);
        localf.field_memberCount = paramString.getInt(6);
        localf.field_createTime = paramString.getLong(7);
        localf.field_state = paramString.getInt(8);
        ad.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d,inviteUser=%s,memberCount=%d, createTime=%d,field_state=%d", new Object[] { localf.field_wxGroupId, localf.field_groupId, Integer.valueOf(localf.field_roomId), Long.valueOf(localf.field_roomKey), Integer.valueOf(localf.field_routeId), localf.field_inviteUserName, Integer.valueOf(localf.field_memberCount), Long.valueOf(localf.field_createTime), Integer.valueOf(localf.field_state) });
        return localf;
      }
      return null;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo error! " + localException.toString());
      return null;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(114641);
    }
  }
  
  public final boolean b(com.tencent.mm.bi.f paramf)
  {
    AppMethodBeat.i(114640);
    String str = paramf.field_wxGroupId;
    if (com.tencent.pb.common.c.f.dq(str))
    {
      ad.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. multiTalkInfo wxGroupId is empty!");
      AppMethodBeat.o(114640);
      return false;
    }
    ad.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d,state=%d", new Object[] { str, paramf.field_groupId, Integer.valueOf(paramf.field_roomId), Long.valueOf(paramf.field_roomKey), Integer.valueOf(paramf.field_routeId), paramf.field_inviteUserName, Integer.valueOf(paramf.field_memberCount), Long.valueOf(paramf.field_createTime), Integer.valueOf(paramf.field_state) });
    try
    {
      boolean bool = update(paramf, new String[] { "wxGroupId" });
      ad.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update ret " + bool + " for id=%s" + str);
      AppMethodBeat.o(114640);
      return bool;
    }
    catch (Exception paramf)
    {
      ad.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + paramf.toString());
      AppMethodBeat.o(114640);
    }
    return false;
  }
  
  public final LinkedList<com.tencent.mm.bi.f> cSS()
  {
    AppMethodBeat.i(114638);
    Cursor localCursor = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, createTime from MultiTalkInfo", new String[0]);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      if (localCursor != null) {}
      try
      {
        if (localCursor.moveToNext())
        {
          com.tencent.mm.bi.f localf = new com.tencent.mm.bi.f();
          localf.field_wxGroupId = localCursor.getString(0);
          localf.field_groupId = localCursor.getString(1);
          localf.field_roomId = localCursor.getInt(2);
          localf.field_roomKey = localCursor.getLong(3);
          localf.field_routeId = localCursor.getInt(4);
          localf.field_createTime = localCursor.getLong(5);
          ad.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d, createTime=%d", new Object[] { localf.field_wxGroupId, localf.field_groupId, Integer.valueOf(localf.field_roomId), Long.valueOf(localf.field_roomKey), Integer.valueOf(localf.field_routeId), Long.valueOf(localf.field_createTime) });
          localLinkedList.add(localf);
          continue;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList error!");
        for (;;)
        {
          return localLinkedList;
          if (localCursor != null) {
            localCursor.close();
          }
        }
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
        AppMethodBeat.o(114638);
      }
    }
  }
  
  public final boolean vv(String paramString)
  {
    AppMethodBeat.i(114642);
    ad.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete id = %s", new Object[] { paramString });
    try
    {
      super.execSQL("MultiTalkInfo", "delete from MultiTalkInfo where wxGroupId = \"" + paramString + "\"");
      AppMethodBeat.o(114642);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete fail for wxGroupId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(114642);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.a
 * JD-Core Version:    0.7.0.1
 */