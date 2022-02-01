package com.tencent.mm.plugin.multitalk.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class a
  extends j<com.tencent.mm.bh.f>
{
  public static final String[] SQL_CREATE;
  public static LinkedHashMap<String, Class> tzC;
  
  static
  {
    AppMethodBeat.i(114643);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.bh.f.info, "MultiTalkInfo"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkInfo_key  on MultiTalkInfo  (  wxGroupId )" };
    tzC = new a.1();
    AppMethodBeat.o(114643);
  }
  
  public a(e parame)
  {
    super(parame, com.tencent.mm.bh.f.info, "MultiTalkInfo", null);
  }
  
  public final boolean Dc(String paramString)
  {
    AppMethodBeat.i(114642);
    ae.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete id = %s", new Object[] { paramString });
    try
    {
      super.execSQL("MultiTalkInfo", "delete from MultiTalkInfo where wxGroupId = \"" + paramString + "\"");
      AppMethodBeat.o(114642);
      return true;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete fail for wxGroupId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(114642);
    }
    return false;
  }
  
  public final boolean a(com.tencent.mm.bh.f paramf)
  {
    AppMethodBeat.i(114639);
    String str = paramf.field_wxGroupId;
    if (com.tencent.pb.common.c.f.ef(str))
    {
      ae.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. multiTalkInfo wxGroupId is empty!");
      AppMethodBeat.o(114639);
      return false;
    }
    ae.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d, ilinkroomid=%d", new Object[] { str, paramf.field_groupId, Integer.valueOf(paramf.field_roomId), Long.valueOf(paramf.field_roomKey), Integer.valueOf(paramf.field_routeId), paramf.field_inviteUserName, Integer.valueOf(paramf.field_memberCount), Long.valueOf(paramf.field_createTime), Long.valueOf(paramf.field_ilinkRoomId) });
    try
    {
      boolean bool = insert(paramf);
      ae.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "insert ret " + bool + " for id=%s" + str);
      AppMethodBeat.o(114639);
      return bool;
    }
    catch (Exception paramf)
    {
      ae.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + paramf.toString());
      AppMethodBeat.o(114639);
    }
    return false;
  }
  
  public final com.tencent.mm.bh.f asp(String paramString)
  {
    AppMethodBeat.i(114641);
    ae.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTaklInfo for wxGroupId = %s", new Object[] { paramString });
    paramString = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, inviteUserName,memberCount,createTime,state,ilinkRoomId from MultiTalkInfo where wxGroupId = '" + paramString + "'", new String[0]);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToNext())
      {
        com.tencent.mm.bh.f localf = new com.tencent.mm.bh.f();
        localf.field_wxGroupId = paramString.getString(0);
        localf.field_groupId = paramString.getString(1);
        localf.field_roomId = paramString.getInt(2);
        localf.field_roomKey = paramString.getLong(3);
        localf.field_routeId = paramString.getInt(4);
        localf.field_inviteUserName = paramString.getString(5);
        localf.field_memberCount = paramString.getInt(6);
        localf.field_createTime = paramString.getLong(7);
        localf.field_state = paramString.getInt(8);
        localf.field_ilinkRoomId = paramString.getLong(9);
        ae.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d,inviteUser=%s,memberCount=%d, createTime=%d,field_state=%d, ilinkroomid=%d", new Object[] { localf.field_wxGroupId, localf.field_groupId, Integer.valueOf(localf.field_roomId), Long.valueOf(localf.field_roomKey), Integer.valueOf(localf.field_routeId), localf.field_inviteUserName, Integer.valueOf(localf.field_memberCount), Long.valueOf(localf.field_createTime), Integer.valueOf(localf.field_state), Long.valueOf(localf.field_ilinkRoomId) });
        return localf;
      }
      return null;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo error! " + localException.toString());
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
  
  public final boolean b(com.tencent.mm.bh.f paramf)
  {
    AppMethodBeat.i(114640);
    String str = paramf.field_wxGroupId;
    if (com.tencent.pb.common.c.f.ef(str))
    {
      ae.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. multiTalkInfo wxGroupId is empty!");
      AppMethodBeat.o(114640);
      return false;
    }
    ae.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d,state=%d,ilinkroomid=%d", new Object[] { str, paramf.field_groupId, Integer.valueOf(paramf.field_roomId), Long.valueOf(paramf.field_roomKey), Integer.valueOf(paramf.field_routeId), paramf.field_inviteUserName, Integer.valueOf(paramf.field_memberCount), Long.valueOf(paramf.field_createTime), Integer.valueOf(paramf.field_state), Long.valueOf(paramf.field_ilinkRoomId) });
    try
    {
      boolean bool = update(paramf, new String[] { "wxGroupId" });
      ae.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update ret " + bool + " for id=%s" + str);
      AppMethodBeat.o(114640);
      return bool;
    }
    catch (Exception paramf)
    {
      ae.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + paramf.toString());
      AppMethodBeat.o(114640);
    }
    return false;
  }
  
  public final LinkedList<com.tencent.mm.bh.f> dtQ()
  {
    AppMethodBeat.i(114638);
    Cursor localCursor = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, createTime, ilinkRoomId from MultiTalkInfo", new String[0]);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      if (localCursor != null) {}
      try
      {
        if (localCursor.moveToNext())
        {
          com.tencent.mm.bh.f localf = new com.tencent.mm.bh.f();
          localf.field_wxGroupId = localCursor.getString(0);
          localf.field_groupId = localCursor.getString(1);
          localf.field_roomId = localCursor.getInt(2);
          localf.field_roomKey = localCursor.getLong(3);
          localf.field_routeId = localCursor.getInt(4);
          localf.field_createTime = localCursor.getLong(5);
          localf.field_ilinkRoomId = localCursor.getLong(6);
          ae.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d, createTime=%d, ilinkroomid = %d", new Object[] { localf.field_wxGroupId, localf.field_groupId, Integer.valueOf(localf.field_roomId), Long.valueOf(localf.field_roomKey), Integer.valueOf(localf.field_routeId), Long.valueOf(localf.field_createTime), Long.valueOf(localf.field_ilinkRoomId) });
          localLinkedList.add(localf);
          continue;
        }
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList error!");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.a
 * JD-Core Version:    0.7.0.1
 */