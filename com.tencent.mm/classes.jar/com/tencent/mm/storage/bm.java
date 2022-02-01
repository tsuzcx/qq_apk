package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class bm
  extends MAutoStorage<bl>
  implements d, MStorage.IOnStorageChange
{
  private static final String[] NRG;
  public static final String[] SQL_CREATE;
  private Runnable Oqj;
  public ISQLiteDatabase db;
  private final int dnq;
  protected Context mContext;
  
  static
  {
    AppMethodBeat.i(117161);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(bl.info, "fmessage_conversation") };
    NRG = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )" };
    AppMethodBeat.o(117161);
  }
  
  public bm(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, bl.info, "fmessage_conversation", NRG);
    AppMethodBeat.i(117148);
    this.mContext = null;
    this.dnq = 1;
    this.Oqj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117147);
        int i = bm.this.gCR();
        Log.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", new Object[] { Integer.valueOf(i) });
        g.aAh().azQ().set(143618, Integer.valueOf(i));
        AppMethodBeat.o(117147);
      }
    };
    this.db = paramISQLiteDatabase;
    this.mContext = MMApplicationContext.getContext();
    AppMethodBeat.o(117148);
  }
  
  public final bl aEl(String paramString)
  {
    AppMethodBeat.i(117156);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
      AppMethodBeat.o(117156);
      return null;
    }
    bl localbl = new bl();
    localbl.field_talker = paramString;
    if (super.get(localbl, new String[0]))
    {
      AppMethodBeat.o(117156);
      return localbl;
    }
    Log.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117156);
    return null;
  }
  
  public final boolean bks(String paramString)
  {
    AppMethodBeat.i(117155);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
      AppMethodBeat.o(117155);
      return false;
    }
    bl localbl = aEl(paramString);
    if ((localbl == null) || (!paramString.equals(localbl.field_talker)))
    {
      Log.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117155);
      return false;
    }
    localbl.field_isNew = 0;
    boolean bool = super.update(localbl, new String[0]);
    AppMethodBeat.o(117155);
    return bool;
  }
  
  public final bl bkt(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117157);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
      AppMethodBeat.o(117157);
      return null;
    }
    paramString = "select * from fmessage_conversation  where encryptTalker=" + h.Fl(paramString);
    Cursor localCursor = this.db.rawQuery(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new bl();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117157);
    return paramString;
  }
  
  public final List<bl> gCP()
  {
    AppMethodBeat.i(117150);
    Log.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", new Object[] { Integer.valueOf(4) });
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.rawQuery("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
    while (localCursor.moveToNext())
    {
      bl localbl = new bl();
      localbl.convertFrom(localCursor);
      if (!Util.isNullOrNil(localbl.field_talker)) {
        localArrayList.add(localbl);
      }
    }
    localCursor.close();
    AppMethodBeat.o(117150);
    return localArrayList;
  }
  
  public final boolean gCQ()
  {
    AppMethodBeat.i(117153);
    if (this.db.execSQL("fmessage_conversation", "update fmessage_conversation set isNew = 0"))
    {
      Log.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
      doNotify();
      AppMethodBeat.o(117153);
      return true;
    }
    Log.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
    AppMethodBeat.o(117153);
    return false;
  }
  
  public final int gCR()
  {
    int i = 0;
    AppMethodBeat.i(117154);
    Object localObject = String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[] { "fmessage_conversation", "isNew", "fmsgIsSend" });
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    Log.d("MicroMsg.FMessageConversationStorage", "getNewCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117154);
    return i;
  }
  
  public final void gCS()
  {
    AppMethodBeat.i(117159);
    MMHandlerThread.removeRunnable(this.Oqj);
    MMHandlerThread.postToMainThreadDelayed(this.Oqj, 500L);
    AppMethodBeat.o(117159);
  }
  
  public final boolean gP(String paramString, int paramInt)
  {
    AppMethodBeat.i(117152);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
      AppMethodBeat.o(117152);
      return false;
    }
    bl localbl = aEl(paramString);
    if (localbl == null)
    {
      Log.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117152);
      return false;
    }
    if (paramInt == localbl.field_state)
    {
      Log.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
      AppMethodBeat.o(117152);
      return true;
    }
    localbl.field_state = paramInt;
    localbl.field_lastModifiedTime = System.currentTimeMillis();
    if (super.update(localbl, new String[0]))
    {
      doNotify(paramString);
      AppMethodBeat.o(117152);
      return true;
    }
    AppMethodBeat.o(117152);
    return false;
  }
  
  public final Cursor getAll()
  {
    AppMethodBeat.i(117149);
    Cursor localCursor = this.db.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
    AppMethodBeat.o(117149);
    return localCursor;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(117151);
    Cursor localCursor = this.db.rawQuery("select count(*) from fmessage_conversation", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    Log.d("MicroMsg.FMessageConversationStorage", "getCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117151);
    return i;
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(117158);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
      AppMethodBeat.o(117158);
      return;
    }
    long l;
    try
    {
      l = Util.getLong(paramString, 0L);
      if (l == 0L)
      {
        Log.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
        AppMethodBeat.o(117158);
        return;
      }
    }
    catch (Exception paramMStorageEventData)
    {
      for (;;)
      {
        Log.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + paramString + ", ex = " + paramMStorageEventData.getMessage());
        l = 0L;
      }
      if (!g.aAf().azp())
      {
        Log.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        AppMethodBeat.o(117158);
        return;
      }
      paramMStorageEventData = new bn();
      if (!((bo)((l)g.af(l.class)).eix()).get(l, paramMStorageEventData))
      {
        Log.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = ".concat(String.valueOf(l)));
        AppMethodBeat.o(117158);
        return;
      }
      Log.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = ".concat(String.valueOf(l)));
      paramString = ((l)g.af(l.class)).eiw().aEl(paramMStorageEventData.field_talker);
      if (paramString != null) {
        break label670;
      }
    }
    Log.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + paramMStorageEventData.field_talker);
    if (Util.isNullOrNil(paramMStorageEventData.field_talker))
    {
      Log.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
      AppMethodBeat.o(117158);
      return;
    }
    paramString = new bl();
    Object localObject;
    if (paramMStorageEventData.field_type == 0)
    {
      localObject = ca.a.bkA(paramMStorageEventData.field_msgContent);
      paramString.field_displayName = ((ca.a)localObject).getDisplayName();
      if ((((ca.a)localObject).scene == 4) && (((ca.a)localObject).gDZ() != null)) {
        paramString.field_displayName = ((ca.a)localObject).gDZ();
      }
      paramString.field_addScene = ((ca.a)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((ca.a)localObject).dkU;
      paramString.field_contentNickname = ((ca.a)localObject).nickname;
      paramString.field_contentPhoneNumMD5 = ((ca.a)localObject).OqK;
      paramString.field_contentFullPhoneNumMD5 = ((ca.a)localObject).OqL;
      Log.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      paramString.field_lastModifiedTime = System.currentTimeMillis();
      paramString.field_state = 0;
      paramString.field_talker = paramMStorageEventData.field_talker;
      paramString.field_encryptTalker = paramMStorageEventData.field_encryptTalker;
      paramString.field_fmsgSysRowId = l;
      paramString.field_fmsgIsSend = paramMStorageEventData.field_isSend;
      paramString.field_fmsgType = paramMStorageEventData.field_type;
      paramString.field_fmsgContent = paramMStorageEventData.field_msgContent;
      if (!paramMStorageEventData.gCT()) {
        break label665;
      }
    }
    label665:
    for (int i = paramMStorageEventData.field_type;; i = 0)
    {
      paramString.field_recvFmsgType = i;
      Log.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + paramString.field_fmsgContent);
      ((bm)((l)g.af(l.class)).eiw()).insert(paramString);
      gCS();
      AppMethodBeat.o(117158);
      return;
      if (!paramMStorageEventData.gCT()) {
        break;
      }
      localObject = ca.d.bkD(paramMStorageEventData.field_msgContent);
      paramString.field_displayName = ((ca.d)localObject).getDisplayName();
      paramString.field_addScene = ((ca.d)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((ca.d)localObject).dkU;
      paramString.field_contentNickname = ((ca.d)localObject).nickname;
      paramString.field_contentVerifyContent = ((ca.d)localObject).content;
      Log.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      break;
    }
    label670:
    Log.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + paramMStorageEventData.field_talker);
    if (paramMStorageEventData.gCT()) {
      paramString.field_isNew = 1;
    }
    paramString.field_lastModifiedTime = System.currentTimeMillis();
    paramString.field_encryptTalker = paramMStorageEventData.field_encryptTalker;
    paramString.field_fmsgSysRowId = l;
    paramString.field_fmsgIsSend = paramMStorageEventData.field_isSend;
    paramString.field_fmsgType = paramMStorageEventData.field_type;
    paramString.field_fmsgContent = paramMStorageEventData.field_msgContent;
    if (paramMStorageEventData.gCT())
    {
      paramString.field_recvFmsgType = paramMStorageEventData.field_type;
      Log.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + paramString.field_recvFmsgType);
    }
    if (paramMStorageEventData.field_type == 0)
    {
      paramMStorageEventData = ca.a.bkA(paramMStorageEventData.field_msgContent);
      paramString.field_contentFromUsername = paramMStorageEventData.dkU;
      paramString.field_contentNickname = paramMStorageEventData.nickname;
      paramString.field_contentPhoneNumMD5 = paramMStorageEventData.OqK;
      paramString.field_contentFullPhoneNumMD5 = paramMStorageEventData.OqL;
      Log.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
    }
    label1098:
    for (;;)
    {
      ((bm)((l)g.af(l.class)).eiw()).update(paramString, new String[0]);
      if (gCR() != 0) {
        break;
      }
      g.aAh().azQ().set(340225, Long.valueOf(System.currentTimeMillis()));
      break;
      if (paramMStorageEventData.gCT())
      {
        if (paramMStorageEventData.field_isSend >= 2) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1098;
          }
          paramMStorageEventData = ca.d.bkD(paramMStorageEventData.field_msgContent);
          paramString.field_contentVerifyContent = paramMStorageEventData.content;
          paramString.field_contentFromUsername = paramMStorageEventData.dkU;
          paramString.field_contentNickname = paramMStorageEventData.nickname;
          Log.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + paramString.field_contentVerifyContent + " receive, new friend Username: " + paramString.field_contentFromUsername + " new friend Nickname: " + paramString.field_contentNickname);
          paramMStorageEventData = paramString.field_contentFromUsername;
          localObject = paramString.field_contentNickname;
          nx localnx = new nx();
          localnx.dTZ.userName = paramMStorageEventData;
          localnx.dTZ.nickName = ((String)localObject);
          localnx.dTZ.type = 1;
          EventCenter.instance.publish(localnx);
          break;
        }
      }
    }
  }
  
  public final boolean x(long paramLong, String paramString)
  {
    AppMethodBeat.i(117160);
    Log.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    if (Util.isNullOrNil(paramString)) {
      if (paramLong <= 0L) {}
    }
    for (String str = "delete from fmessage_conversation where fmsgSysRowId = '" + paramLong + "'"; this.db.execSQL("fmessage_conversation", str); str = "delete from fmessage_conversation where talker = '" + Util.escapeSqlValue(paramString) + "'")
    {
      Log.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
      doNotify(paramString);
      AppMethodBeat.o(117160);
      return true;
      AppMethodBeat.o(117160);
      return false;
    }
    AppMethodBeat.o(117160);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bm
 * JD-Core Version:    0.7.0.1
 */