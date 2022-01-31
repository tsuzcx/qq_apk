package com.tencent.mm.plugin.multitalk.b;

import android.database.Cursor;
import com.tencent.mm.bf.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.pb.common.c.g;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class a
  extends i<f>
{
  public static final String[] dXp = { i.a(f.buS, "MultiTalkInfo"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkInfo_key  on MultiTalkInfo  (  wxGroupId )" };
  public static LinkedHashMap<String, Class> kqA = new a.1();
  
  public a(e parame)
  {
    super(parame, f.buS, "MultiTalkInfo", null);
  }
  
  public final f Iu(String paramString)
  {
    y.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTaklInfo for wxGroupId = %s", new Object[] { paramString });
    paramString = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, inviteUserName,memberCount,createTime,state from MultiTalkInfo where wxGroupId = '" + paramString + "'", new String[0]);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToNext())
      {
        f localf = new f();
        localf.field_wxGroupId = paramString.getString(0);
        localf.field_groupId = paramString.getString(1);
        localf.field_roomId = paramString.getInt(2);
        localf.field_roomKey = paramString.getLong(3);
        localf.field_routeId = paramString.getInt(4);
        localf.field_inviteUserName = paramString.getString(5);
        localf.field_memberCount = paramString.getInt(6);
        localf.field_createTime = paramString.getLong(7);
        localf.field_state = paramString.getInt(8);
        y.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d,inviteUser=%s,memberCount=%d, createTime=%d,field_state=%d", new Object[] { localf.field_wxGroupId, localf.field_groupId, Integer.valueOf(localf.field_roomId), Long.valueOf(localf.field_roomKey), Integer.valueOf(localf.field_routeId), localf.field_inviteUserName, Integer.valueOf(localf.field_memberCount), Long.valueOf(localf.field_createTime), Integer.valueOf(localf.field_state) });
        return localf;
      }
      return null;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo error! " + localException.toString());
      return null;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
    }
  }
  
  public final boolean a(f paramf)
  {
    String str = paramf.field_wxGroupId;
    if (g.isEmpty(str))
    {
      y.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. multiTalkInfo wxGroupId is empty!");
      return false;
    }
    y.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d", new Object[] { str, paramf.field_groupId, Integer.valueOf(paramf.field_roomId), Long.valueOf(paramf.field_roomKey), Integer.valueOf(paramf.field_routeId), paramf.field_inviteUserName, Integer.valueOf(paramf.field_memberCount), Long.valueOf(paramf.field_createTime) });
    try
    {
      boolean bool = b(paramf);
      y.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "insert ret " + bool + " for id=%s" + str);
      return bool;
    }
    catch (Exception paramf)
    {
      y.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + paramf.toString());
    }
    return false;
  }
  
  public final boolean b(f paramf)
  {
    String str = paramf.field_wxGroupId;
    if (g.isEmpty(str))
    {
      y.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. multiTalkInfo wxGroupId is empty!");
      return false;
    }
    y.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d,state=%d", new Object[] { str, paramf.field_groupId, Integer.valueOf(paramf.field_roomId), Long.valueOf(paramf.field_roomKey), Integer.valueOf(paramf.field_routeId), paramf.field_inviteUserName, Integer.valueOf(paramf.field_memberCount), Long.valueOf(paramf.field_createTime), Integer.valueOf(paramf.field_state) });
    try
    {
      boolean bool = c(paramf, new String[] { "wxGroupId" });
      y.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update ret " + bool + " for id=%s" + str);
      return bool;
    }
    catch (Exception paramf)
    {
      y.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + paramf.toString());
    }
    return false;
  }
  
  public final LinkedList<f> blJ()
  {
    Cursor localCursor = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, createTime from MultiTalkInfo", new String[0]);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      if (localCursor != null) {}
      try
      {
        if (localCursor.moveToNext())
        {
          f localf = new f();
          localf.field_wxGroupId = localCursor.getString(0);
          localf.field_groupId = localCursor.getString(1);
          localf.field_roomId = localCursor.getInt(2);
          localf.field_roomKey = localCursor.getLong(3);
          localf.field_routeId = localCursor.getInt(4);
          localf.field_createTime = localCursor.getLong(5);
          y.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d, createTime=%d", new Object[] { localf.field_wxGroupId, localf.field_groupId, Integer.valueOf(localf.field_roomId), Long.valueOf(localf.field_roomKey), Integer.valueOf(localf.field_routeId), Long.valueOf(localf.field_createTime) });
          localLinkedList.add(localf);
          continue;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList error!");
        return localLinkedList;
        return localLinkedList;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
  }
  
  public final boolean jJ(String paramString)
  {
    y.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete id = %s", new Object[] { paramString });
    try
    {
      super.gk("MultiTalkInfo", "delete from MultiTalkInfo where wxGroupId = \"" + paramString + "\"");
      return true;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete fail for wxGroupId = " + paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.a
 * JD-Core Version:    0.7.0.1
 */