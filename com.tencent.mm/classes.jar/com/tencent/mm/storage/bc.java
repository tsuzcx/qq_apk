package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class bc
  extends j<bb>
  implements d, k.a
{
  private static final String[] GCW;
  public static final String[] SQL_CREATE;
  private Runnable GYx;
  private final int cKF;
  public com.tencent.mm.sdk.e.e db;
  protected Context mContext;
  
  static
  {
    AppMethodBeat.i(117161);
    SQL_CREATE = new String[] { j.getCreateSQLs(bb.info, "fmessage_conversation") };
    GCW = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )" };
    AppMethodBeat.o(117161);
  }
  
  public bc(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, bb.info, "fmessage_conversation", GCW);
    AppMethodBeat.i(117148);
    this.mContext = null;
    this.cKF = 1;
    this.GYx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117147);
        int i = bc.this.fbh();
        ac.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", new Object[] { Integer.valueOf(i) });
        g.agR().agA().set(143618, Integer.valueOf(i));
        AppMethodBeat.o(117147);
      }
    };
    this.db = parame;
    this.mContext = ai.getContext();
    AppMethodBeat.o(117148);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(117158);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
      AppMethodBeat.o(117158);
      return;
    }
    long l;
    try
    {
      l = bs.getLong(paramString, 0L);
      if (l == 0L)
      {
        ac.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
        AppMethodBeat.o(117158);
        return;
      }
    }
    catch (Exception paramm)
    {
      for (;;)
      {
        ac.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + paramString + ", ex = " + paramm.getMessage());
        l = 0L;
      }
      if (!g.agP().afY())
      {
        ac.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        AppMethodBeat.o(117158);
        return;
      }
      paramm = new bd();
      if (!((be)((k)g.ab(k.class)).dcq()).get(l, paramm))
      {
        ac.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = ".concat(String.valueOf(l)));
        AppMethodBeat.o(117158);
        return;
      }
      ac.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = ".concat(String.valueOf(l)));
      paramString = ((k)g.ab(k.class)).dcp().akZ(paramm.field_talker);
      if (paramString != null) {
        break label651;
      }
    }
    ac.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + paramm.field_talker);
    if (bs.isNullOrNil(paramm.field_talker))
    {
      ac.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
      AppMethodBeat.o(117158);
      return;
    }
    paramString = new bb();
    Object localObject;
    if (paramm.field_type == 0)
    {
      localObject = bo.a.aOk(paramm.field_msgContent);
      paramString.field_displayName = ((bo.a)localObject).getDisplayName();
      if ((((bo.a)localObject).scene == 4) && (((bo.a)localObject).fcl() != null)) {
        paramString.field_displayName = ((bo.a)localObject).fcl();
      }
      paramString.field_addScene = ((bo.a)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bo.a)localObject).zTO;
      paramString.field_contentNickname = ((bo.a)localObject).nickname;
      paramString.field_contentPhoneNumMD5 = ((bo.a)localObject).GYX;
      paramString.field_contentFullPhoneNumMD5 = ((bo.a)localObject).GYY;
      ac.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      paramString.field_lastModifiedTime = System.currentTimeMillis();
      paramString.field_state = 0;
      paramString.field_talker = paramm.field_talker;
      paramString.field_encryptTalker = paramm.field_encryptTalker;
      paramString.field_fmsgSysRowId = l;
      paramString.field_fmsgIsSend = paramm.field_isSend;
      paramString.field_fmsgType = paramm.field_type;
      paramString.field_fmsgContent = paramm.field_msgContent;
      if (!paramm.fbj()) {
        break label646;
      }
    }
    label646:
    for (int i = paramm.field_type;; i = 0)
    {
      paramString.field_recvFmsgType = i;
      ac.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + paramString.field_fmsgContent);
      ((bc)((k)g.ab(k.class)).dcp()).insert(paramString);
      fbi();
      AppMethodBeat.o(117158);
      return;
      if (!paramm.fbj()) {
        break;
      }
      localObject = bo.d.aOn(paramm.field_msgContent);
      paramString.field_displayName = ((bo.d)localObject).getDisplayName();
      paramString.field_addScene = ((bo.d)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bo.d)localObject).zTO;
      paramString.field_contentNickname = ((bo.d)localObject).nickname;
      paramString.field_contentVerifyContent = ((bo.d)localObject).content;
      ac.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      break;
    }
    label651:
    ac.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + paramm.field_talker);
    if (paramm.fbj()) {
      paramString.field_isNew = 1;
    }
    paramString.field_lastModifiedTime = System.currentTimeMillis();
    paramString.field_encryptTalker = paramm.field_encryptTalker;
    paramString.field_fmsgSysRowId = l;
    paramString.field_fmsgIsSend = paramm.field_isSend;
    paramString.field_fmsgType = paramm.field_type;
    paramString.field_fmsgContent = paramm.field_msgContent;
    if (paramm.fbj())
    {
      paramString.field_recvFmsgType = paramm.field_type;
      ac.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + paramString.field_recvFmsgType);
    }
    if (paramm.field_type == 0)
    {
      paramm = bo.a.aOk(paramm.field_msgContent);
      paramString.field_contentFromUsername = paramm.zTO;
      paramString.field_contentNickname = paramm.nickname;
      paramString.field_contentPhoneNumMD5 = paramm.GYX;
      paramString.field_contentFullPhoneNumMD5 = paramm.GYY;
      ac.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
    }
    label1078:
    for (;;)
    {
      ((bc)((k)g.ab(k.class)).dcp()).update(paramString, new String[0]);
      if (fbh() != 0) {
        break;
      }
      g.agR().agA().set(340225, Long.valueOf(System.currentTimeMillis()));
      break;
      if (paramm.fbj())
      {
        if (paramm.field_isSend >= 2) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1078;
          }
          paramm = bo.d.aOn(paramm.field_msgContent);
          paramString.field_contentVerifyContent = paramm.content;
          paramString.field_contentFromUsername = paramm.zTO;
          paramString.field_contentNickname = paramm.nickname;
          ac.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + paramString.field_contentVerifyContent + " receive, new friend Username: " + paramString.field_contentFromUsername + " new friend Nickname: " + paramString.field_contentNickname);
          paramm = paramString.field_contentFromUsername;
          localObject = paramString.field_contentNickname;
          mw localmw = new mw();
          localmw.dpr.userName = paramm;
          localmw.dpr.bLs = ((String)localObject);
          localmw.dpr.type = 1;
          com.tencent.mm.sdk.b.a.GpY.l(localmw);
          break;
        }
      }
    }
  }
  
  public final boolean aOc(String paramString)
  {
    AppMethodBeat.i(117155);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
      AppMethodBeat.o(117155);
      return false;
    }
    bb localbb = akZ(paramString);
    if ((localbb == null) || (!paramString.equals(localbb.field_talker)))
    {
      ac.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117155);
      return false;
    }
    localbb.field_isNew = 0;
    boolean bool = super.update(localbb, new String[0]);
    AppMethodBeat.o(117155);
    return bool;
  }
  
  public final bb aOd(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117157);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
      AppMethodBeat.o(117157);
      return null;
    }
    paramString = "select * from fmessage_conversation  where encryptTalker=" + h.ty(paramString);
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new bb();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117157);
    return paramString;
  }
  
  public final bb akZ(String paramString)
  {
    AppMethodBeat.i(117156);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
      AppMethodBeat.o(117156);
      return null;
    }
    bb localbb = new bb();
    localbb.field_talker = paramString;
    if (super.get(localbb, new String[0]))
    {
      AppMethodBeat.o(117156);
      return localbb;
    }
    ac.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117156);
    return null;
  }
  
  public final boolean fQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(117152);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
      AppMethodBeat.o(117152);
      return false;
    }
    bb localbb = akZ(paramString);
    if (localbb == null)
    {
      ac.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117152);
      return false;
    }
    if (paramInt == localbb.field_state)
    {
      ac.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
      AppMethodBeat.o(117152);
      return true;
    }
    localbb.field_state = paramInt;
    localbb.field_lastModifiedTime = System.currentTimeMillis();
    if (super.update(localbb, new String[0]))
    {
      doNotify(paramString);
      AppMethodBeat.o(117152);
      return true;
    }
    AppMethodBeat.o(117152);
    return false;
  }
  
  public final List<bb> fbf()
  {
    AppMethodBeat.i(117150);
    ac.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", new Object[] { Integer.valueOf(4) });
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
    while (localCursor.moveToNext())
    {
      bb localbb = new bb();
      localbb.convertFrom(localCursor);
      if (!bs.isNullOrNil(localbb.field_talker)) {
        localArrayList.add(localbb);
      }
    }
    localCursor.close();
    AppMethodBeat.o(117150);
    return localArrayList;
  }
  
  public final boolean fbg()
  {
    AppMethodBeat.i(117153);
    if (this.db.execSQL("fmessage_conversation", "update fmessage_conversation set isNew = 0"))
    {
      ac.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
      doNotify();
      AppMethodBeat.o(117153);
      return true;
    }
    ac.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
    AppMethodBeat.o(117153);
    return false;
  }
  
  public final int fbh()
  {
    int i = 0;
    AppMethodBeat.i(117154);
    Object localObject = String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[] { "fmessage_conversation", "isNew", "fmsgIsSend" });
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    ac.d("MicroMsg.FMessageConversationStorage", "getNewCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117154);
    return i;
  }
  
  public final void fbi()
  {
    AppMethodBeat.i(117159);
    ap.aB(this.GYx);
    ap.n(this.GYx, 500L);
    AppMethodBeat.o(117159);
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
    Cursor localCursor = this.db.a("select count(*) from fmessage_conversation", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    ac.d("MicroMsg.FMessageConversationStorage", "getCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117151);
    return i;
  }
  
  public final boolean s(long paramLong, String paramString)
  {
    AppMethodBeat.i(117160);
    ac.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    if (bs.isNullOrNil(paramString)) {
      if (paramLong <= 0L) {}
    }
    for (String str = "delete from fmessage_conversation where fmsgSysRowId = '" + paramLong + "'"; this.db.execSQL("fmessage_conversation", str); str = "delete from fmessage_conversation where talker = '" + bs.aLh(paramString) + "'")
    {
      ac.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bc
 * JD-Core Version:    0.7.0.1
 */