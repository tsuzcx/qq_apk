package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qe;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.List;

public final class bo
  extends MAutoStorage<bn>
  implements d, MStorage.IOnStorageChange
{
  public static final String[] SQL_CREATE;
  private static final String[] acGS;
  private Runnable adjT;
  public ISQLiteDatabase db;
  private final int hjM;
  private final int hjN;
  protected Context mContext;
  
  static
  {
    AppMethodBeat.i(117161);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(bn.info, "fmessage_conversation") };
    acGS = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )" };
    AppMethodBeat.o(117161);
  }
  
  public bo(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, bn.info, "fmessage_conversation", acGS);
    AppMethodBeat.i(117148);
    this.mContext = null;
    this.hjM = 1;
    this.hjN = 2;
    this.adjT = new bo.1(this);
    this.db = paramISQLiteDatabase;
    this.mContext = MMApplicationContext.getContext();
    AppMethodBeat.o(117148);
  }
  
  private static void aN(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(248427);
    qe localqe = new qe();
    localqe.hTo.userName = paramString1;
    localqe.hTo.nickName = paramString2;
    localqe.hTo.type = paramInt;
    localqe.publish();
    AppMethodBeat.o(248427);
  }
  
  public final boolean S(long paramLong, String paramString)
  {
    AppMethodBeat.i(117160);
    Log.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s, stack = %s", new Object[] { Long.valueOf(paramLong), paramString, Util.getStack() });
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
  
  public final bn aLu(String paramString)
  {
    AppMethodBeat.i(117156);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
      AppMethodBeat.o(117156);
      return null;
    }
    bn localbn = new bn();
    localbn.field_talker = paramString;
    if (super.get(localbn, new String[0]))
    {
      AppMethodBeat.o(117156);
      return localbn;
    }
    Log.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117156);
    return null;
  }
  
  public final boolean byk(String paramString)
  {
    AppMethodBeat.i(117155);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
      AppMethodBeat.o(117155);
      return false;
    }
    bn localbn = aLu(paramString);
    if ((localbn == null) || (!paramString.equals(localbn.field_talker)))
    {
      Log.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117155);
      return false;
    }
    localbn.field_isNew = 0;
    boolean bool = super.update(localbn, new String[0]);
    AppMethodBeat.o(117155);
    return bool;
  }
  
  public final bn byl(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117157);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
      AppMethodBeat.o(117157);
      return null;
    }
    paramString = "select * from fmessage_conversation  where encryptTalker=" + com.tencent.mm.storagebase.h.EQ(paramString);
    Cursor localCursor = this.db.rawQuery(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new bn();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117157);
    return paramString;
  }
  
  public final boolean fP(String paramString, int paramInt)
  {
    AppMethodBeat.i(117152);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
      AppMethodBeat.o(117152);
      return false;
    }
    bn localbn = aLu(paramString);
    if (localbn == null)
    {
      Log.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117152);
      return false;
    }
    if (paramInt == localbn.field_state)
    {
      Log.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
      AppMethodBeat.o(117152);
      return true;
    }
    localbn.field_state = paramInt;
    localbn.field_lastModifiedTime = cn.bDv();
    if (super.update(localbn, new String[0]))
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
  
  public final List<bn> jbc()
  {
    AppMethodBeat.i(117150);
    Log.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", new Object[] { Integer.valueOf(4) });
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.rawQuery("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
    while (localCursor.moveToNext())
    {
      bn localbn = new bn();
      localbn.convertFrom(localCursor);
      if (!Util.isNullOrNil(localbn.field_talker)) {
        localArrayList.add(localbn);
      }
    }
    localCursor.close();
    AppMethodBeat.o(117150);
    return localArrayList;
  }
  
  public final boolean jbd()
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
  
  public final int jbe()
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
  
  public final void jbf()
  {
    AppMethodBeat.i(117159);
    MMHandlerThread.removeRunnable(this.adjT);
    MMHandlerThread.postToMainThreadDelayed(this.adjT, 500L);
    AppMethodBeat.o(117159);
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
    long l1;
    try
    {
      l1 = Util.getLong(paramString, 0L);
      if (l1 == 0L)
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
        l1 = 0L;
      }
      if (!com.tencent.mm.kernel.h.baC().aZN())
      {
        Log.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        AppMethodBeat.o(117158);
        return;
      }
      paramString = new bp();
      if (!((bq)((n)com.tencent.mm.kernel.h.ax(n.class)).gaY()).get(l1, paramString))
      {
        Log.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = ".concat(String.valueOf(l1)));
        AppMethodBeat.o(117158);
        return;
      }
      Log.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = ".concat(String.valueOf(l1)));
      paramMStorageEventData = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaX().aLu(paramString.field_talker);
      if (paramMStorageEventData != null) {
        break label970;
      }
    }
    Log.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + paramString.field_talker);
    if (Util.isNullOrNil(paramString.field_talker))
    {
      Log.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
      AppMethodBeat.o(117158);
      return;
    }
    paramMStorageEventData = new bn();
    Object localObject;
    if (paramString.field_type == 0)
    {
      localObject = cc.a.bys(paramString.field_msgContent);
      paramMStorageEventData.field_displayName = ((cc.a)localObject).getDisplayName();
      if ((((cc.a)localObject).scene == 4) && (((cc.a)localObject).jcv() != null)) {
        paramMStorageEventData.field_displayName = ((cc.a)localObject).jcv();
      }
      paramMStorageEventData.field_addScene = ((cc.a)localObject).scene;
      paramMStorageEventData.field_isNew = 1;
      paramMStorageEventData.field_contentFromUsername = ((cc.a)localObject).hgk;
      paramMStorageEventData.field_contentNickname = ((cc.a)localObject).nickname;
      paramMStorageEventData.field_contentPhoneNumMD5 = ((cc.a)localObject).adkz;
      paramMStorageEventData.field_contentFullPhoneNumMD5 = ((cc.a)localObject).adkA;
      Log.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + paramMStorageEventData.field_contentFromUsername + "new friend Nickname: " + paramMStorageEventData.field_contentNickname);
      paramMStorageEventData.field_lastModifiedTime = cn.bDv();
      paramMStorageEventData.field_talker = paramString.field_talker;
      paramMStorageEventData.field_encryptTalker = paramString.field_encryptTalker;
      paramMStorageEventData.field_fmsgSysRowId = l1;
      paramMStorageEventData.field_fmsgIsSend = paramString.field_isSend;
      paramMStorageEventData.field_fmsgType = paramString.field_type;
      paramMStorageEventData.field_fmsgContent = paramString.field_msgContent;
      if (((paramString.field_isSend != 1) || (paramString.field_type != 1)) && ((!paramString.jbg()) || (paramString.field_type != 3)) && ((paramString.field_isSend != 1) || (paramString.field_type != 2))) {
        break label869;
      }
      paramMStorageEventData.field_state = 2;
      paramMStorageEventData.field_recvFmsgType = paramString.field_type;
      Log.i("MicroMsg.FMessageConversationStorage", "send, field_state = %s, fmsgConv.field_recvFmsgType = %s，new friend field_contentVerifyContent: ", new Object[] { Integer.valueOf(paramMStorageEventData.field_state), Integer.valueOf(paramMStorageEventData.field_recvFmsgType), paramMStorageEventData.field_contentVerifyContent });
    }
    for (;;)
    {
      Log.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + paramMStorageEventData.field_fmsgContent);
      ((bo)((n)com.tencent.mm.kernel.h.ax(n.class)).gaX()).insert(paramMStorageEventData);
      jbf();
      AppMethodBeat.o(117158);
      return;
      if (paramString.jbg())
      {
        localObject = cc.f.byv(paramString.field_msgContent);
        paramMStorageEventData.field_displayName = ((cc.f)localObject).getDisplayName();
        paramMStorageEventData.field_addScene = ((cc.f)localObject).scene;
        paramMStorageEventData.field_isNew = 1;
        paramMStorageEventData.field_contentFromUsername = ((cc.f)localObject).hgk;
        paramMStorageEventData.field_contentNickname = ((cc.f)localObject).nickname;
        paramMStorageEventData.field_contentVerifyContent = ((cc.f)localObject).content;
        Log.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + paramMStorageEventData.field_contentFromUsername + "new friend Nickname: " + paramMStorageEventData.field_contentNickname);
        break;
      }
      if ((paramString.field_isSend != 1) || (paramString.field_type != 1)) {
        break;
      }
      localObject = cc.f.byv(paramString.field_msgContent);
      if (TextUtils.isEmpty(((cc.f)localObject).hgk)) {
        break;
      }
      paramMStorageEventData.field_displayName = ((cc.f)localObject).getDisplayName();
      paramMStorageEventData.field_addScene = ((cc.f)localObject).scene;
      paramMStorageEventData.field_isNew = 0;
      paramMStorageEventData.field_contentFromUsername = ((cc.f)localObject).hgk;
      paramMStorageEventData.field_contentNickname = ((cc.f)localObject).nickname;
      paramMStorageEventData.field_contentVerifyContent = ((cc.f)localObject).content;
      Log.i("MicroMsg.FMessageConversationStorage", "send, new friend Username: " + paramMStorageEventData.field_contentFromUsername + "new friend Nickname: " + paramMStorageEventData.field_contentNickname);
      break;
      label869:
      if ((paramString.field_isSend != 1) || (paramString.field_type != 3)) {
        break label901;
      }
      paramMStorageEventData.field_state = 0;
      paramMStorageEventData.field_recvFmsgType = paramString.field_type;
    }
    label901:
    paramMStorageEventData.field_state = 0;
    if (paramString.jbg()) {}
    for (int i = paramString.field_type;; i = 0)
    {
      paramMStorageEventData.field_recvFmsgType = i;
      Log.i("MicroMsg.FMessageConversationStorage", "send, field_state = %s, fmsgConv.field_recvFmsgType = %s，new friend field_contentVerifyContent: %s", new Object[] { Integer.valueOf(paramMStorageEventData.field_state), Integer.valueOf(paramMStorageEventData.field_recvFmsgType), paramMStorageEventData.field_contentVerifyContent });
      break;
    }
    label970:
    Log.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + paramString.field_talker);
    if (paramString.jbg()) {
      paramMStorageEventData.field_isNew = 1;
    }
    long l2 = 1000L * ((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getInt("VerifyUserTicketTimeExceed", 259200);
    label1053:
    boolean bool;
    if (cn.bDv() - paramMStorageEventData.field_lastModifiedTime > l2)
    {
      i = 1;
      if ((paramMStorageEventData.field_state != 2) || (i == 0)) {
        break label1408;
      }
      bool = true;
      label1068:
      Log.i("MicroMsg.FMessageConversationStorage", "expired time , defaultExpireTime = " + l2 + "， isWaitingVerfyTimeOut = " + bool + ", fmsgInfo.field_type = " + paramString.field_type);
      paramMStorageEventData.field_lastModifiedTime = cn.bDv();
      paramMStorageEventData.field_encryptTalker = paramString.field_encryptTalker;
      paramMStorageEventData.field_fmsgSysRowId = l1;
      paramMStorageEventData.field_fmsgIsSend = paramString.field_isSend;
      paramMStorageEventData.field_fmsgType = paramString.field_type;
      paramMStorageEventData.field_fmsgContent = paramString.field_msgContent;
      if (paramString.field_type != 0) {
        break label1414;
      }
      localObject = cc.a.bys(paramString.field_msgContent);
      paramMStorageEventData.field_contentFromUsername = ((cc.a)localObject).hgk;
      paramMStorageEventData.field_contentNickname = ((cc.a)localObject).nickname;
      paramMStorageEventData.field_contentPhoneNumMD5 = ((cc.a)localObject).adkz;
      paramMStorageEventData.field_contentFullPhoneNumMD5 = ((cc.a)localObject).adkA;
      Log.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + paramMStorageEventData.field_contentFromUsername + "new friend Nickname: " + paramMStorageEventData.field_contentNickname);
      label1250:
      if (((paramString.field_isSend != 1) || (paramString.field_type != 1)) && ((!paramString.jbg()) || (paramString.field_type != 3)) && ((paramString.field_isSend != 1) || (paramString.field_type != 2))) {
        break label1802;
      }
      paramMStorageEventData.field_state = 2;
      paramMStorageEventData.field_recvFmsgType = paramString.field_type;
      Log.i("MicroMsg.FMessageConversationStorage", "send, field_state = %s, fmsgConv.field_recvFmsgType = %s，new friend field_contentVerifyContent: ", new Object[] { Integer.valueOf(paramMStorageEventData.field_state), Integer.valueOf(paramMStorageEventData.field_recvFmsgType), paramMStorageEventData.field_contentVerifyContent });
    }
    for (;;)
    {
      ((bo)((n)com.tencent.mm.kernel.h.ax(n.class)).gaX()).update(paramMStorageEventData, new String[0]);
      if (jbe() != 0) {
        break;
      }
      com.tencent.mm.kernel.h.baE().ban().B(340225, Long.valueOf(cn.bDv()));
      break;
      i = 0;
      break label1053;
      label1408:
      bool = false;
      break label1068;
      label1414:
      if (paramString.jbg())
      {
        if (paramString.field_isSend >= 2) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0)
          {
            localObject = cc.f.byv(paramString.field_msgContent);
            paramMStorageEventData.field_contentVerifyContent = ((cc.f)localObject).content;
            paramMStorageEventData.field_contentFromUsername = ((cc.f)localObject).hgk;
            paramMStorageEventData.field_contentNickname = ((cc.f)localObject).nickname;
            i = paramMStorageEventData.field_state;
            int j = paramMStorageEventData.field_recvFmsgType;
            Log.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + paramMStorageEventData.field_contentVerifyContent + ", receive, new friend Username: " + paramMStorageEventData.field_contentFromUsername + ", new friend Nickname: " + paramMStorageEventData.field_contentNickname + ", preKey = " + i + ", fmsgConv.field_state = " + paramMStorageEventData.field_state + ", fmsgInfo.field_type = " + paramString.field_type + ", prrecyType = " + j + ", isWaitingVerfyTimeOut  = " + bool);
            if (paramMStorageEventData.field_recvFmsgType != 3)
            {
              aN(paramMStorageEventData.field_contentFromUsername, paramMStorageEventData.field_contentNickname, 1);
              break;
              i = 0;
              continue;
            }
            aN(paramMStorageEventData.field_contentFromUsername, paramMStorageEventData.field_contentNickname, 2);
            break;
          }
        }
      }
      if ((paramString.field_isSend != 1) || ((paramString.field_type != 2) && (paramString.field_type != 1))) {
        break label1250;
      }
      localObject = cc.f.byv(paramString.field_msgContent);
      Log.i("MicroMsg.FMessageConversationStorage", "2 field_state = " + paramMStorageEventData.field_state);
      paramMStorageEventData.field_recvFmsgType = paramString.field_type;
      if (TextUtils.isEmpty(((cc.f)localObject).hgk)) {
        break label1250;
      }
      paramMStorageEventData.field_displayName = ((cc.f)localObject).getDisplayName();
      paramMStorageEventData.field_addScene = ((cc.f)localObject).scene;
      paramMStorageEventData.field_isNew = 0;
      paramMStorageEventData.field_contentFromUsername = ((cc.f)localObject).hgk;
      paramMStorageEventData.field_contentNickname = ((cc.f)localObject).nickname;
      paramMStorageEventData.field_contentVerifyContent = ((cc.f)localObject).content;
      Log.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + paramMStorageEventData.field_contentFromUsername + "new friend Nickname: " + paramMStorageEventData.field_contentNickname);
      break label1250;
      label1802:
      if ((paramString.field_isSend != 1) || (paramString.field_type != 3)) {
        break label1834;
      }
      paramMStorageEventData.field_state = 0;
      paramMStorageEventData.field_recvFmsgType = paramString.field_type;
    }
    label1834:
    paramMStorageEventData.field_state = 0;
    if (paramString.jbg()) {}
    for (i = paramString.field_type;; i = 0)
    {
      paramMStorageEventData.field_recvFmsgType = i;
      Log.i("MicroMsg.FMessageConversationStorage", "send, field_state = %s, fmsgConv.field_recvFmsgType = %s，new friend field_contentVerifyContent: %s", new Object[] { Integer.valueOf(paramMStorageEventData.field_state), Integer.valueOf(paramMStorageEventData.field_recvFmsgType), paramMStorageEventData.field_contentVerifyContent });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bo
 * JD-Core Version:    0.7.0.1
 */