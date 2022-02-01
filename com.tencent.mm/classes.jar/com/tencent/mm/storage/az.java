package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class az
  extends j<ay>
  implements d, k.a
{
  private static final String[] Ffk;
  public static final String[] SQL_CREATE;
  private Runnable Fzv;
  private final int cNk;
  public com.tencent.mm.sdk.e.e db;
  protected Context mContext;
  
  static
  {
    AppMethodBeat.i(117161);
    SQL_CREATE = new String[] { j.getCreateSQLs(ay.info, "fmessage_conversation") };
    Ffk = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )" };
    AppMethodBeat.o(117161);
  }
  
  public az(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, ay.info, "fmessage_conversation", Ffk);
    AppMethodBeat.i(117148);
    this.mContext = null;
    this.cNk = 1;
    this.Fzv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117147);
        int i = az.this.eLD();
        ad.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", new Object[] { Integer.valueOf(i) });
        g.afB().afk().set(143618, Integer.valueOf(i));
        AppMethodBeat.o(117147);
      }
    };
    this.db = parame;
    this.mContext = aj.getContext();
    AppMethodBeat.o(117148);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(117158);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
      AppMethodBeat.o(117158);
      return;
    }
    long l;
    try
    {
      l = bt.getLong(paramString, 0L);
      if (l == 0L)
      {
        ad.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
        AppMethodBeat.o(117158);
        return;
      }
    }
    catch (Exception paramm)
    {
      for (;;)
      {
        ad.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + paramString + ", ex = " + paramm.getMessage());
        l = 0L;
      }
      if (!g.afz().aeI())
      {
        ad.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        AppMethodBeat.o(117158);
        return;
      }
      paramm = new ba();
      if (!((bb)((k)g.ab(k.class)).cOH()).get(l, paramm))
      {
        ad.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = ".concat(String.valueOf(l)));
        AppMethodBeat.o(117158);
        return;
      }
      ad.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = ".concat(String.valueOf(l)));
      paramString = ((k)g.ab(k.class)).cOG().agf(paramm.field_talker);
      if (paramString != null) {
        break label651;
      }
    }
    ad.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + paramm.field_talker);
    if (bt.isNullOrNil(paramm.field_talker))
    {
      ad.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
      AppMethodBeat.o(117158);
      return;
    }
    paramString = new ay();
    Object localObject;
    if (paramm.field_type == 0)
    {
      localObject = bl.a.aIO(paramm.field_msgContent);
      paramString.field_displayName = ((bl.a)localObject).getDisplayName();
      if ((((bl.a)localObject).scene == 4) && (((bl.a)localObject).eMG() != null)) {
        paramString.field_displayName = ((bl.a)localObject).eMG();
      }
      paramString.field_addScene = ((bl.a)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bl.a)localObject).yGA;
      paramString.field_contentNickname = ((bl.a)localObject).nickname;
      paramString.field_contentPhoneNumMD5 = ((bl.a)localObject).FzV;
      paramString.field_contentFullPhoneNumMD5 = ((bl.a)localObject).FzW;
      ad.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      paramString.field_lastModifiedTime = System.currentTimeMillis();
      paramString.field_state = 0;
      paramString.field_talker = paramm.field_talker;
      paramString.field_encryptTalker = paramm.field_encryptTalker;
      paramString.field_fmsgSysRowId = l;
      paramString.field_fmsgIsSend = paramm.field_isSend;
      paramString.field_fmsgType = paramm.field_type;
      paramString.field_fmsgContent = paramm.field_msgContent;
      if (!paramm.eLF()) {
        break label646;
      }
    }
    label646:
    for (int i = paramm.field_type;; i = 0)
    {
      paramString.field_recvFmsgType = i;
      ad.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + paramString.field_fmsgContent);
      ((az)((k)g.ab(k.class)).cOG()).insert(paramString);
      eLE();
      AppMethodBeat.o(117158);
      return;
      if (!paramm.eLF()) {
        break;
      }
      localObject = bl.d.aIR(paramm.field_msgContent);
      paramString.field_displayName = ((bl.d)localObject).getDisplayName();
      paramString.field_addScene = ((bl.d)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bl.d)localObject).yGA;
      paramString.field_contentNickname = ((bl.d)localObject).nickname;
      paramString.field_contentVerifyContent = ((bl.d)localObject).content;
      ad.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      break;
    }
    label651:
    ad.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + paramm.field_talker);
    if (paramm.eLF()) {
      paramString.field_isNew = 1;
    }
    paramString.field_lastModifiedTime = System.currentTimeMillis();
    paramString.field_encryptTalker = paramm.field_encryptTalker;
    paramString.field_fmsgSysRowId = l;
    paramString.field_fmsgIsSend = paramm.field_isSend;
    paramString.field_fmsgType = paramm.field_type;
    paramString.field_fmsgContent = paramm.field_msgContent;
    if (paramm.eLF())
    {
      paramString.field_recvFmsgType = paramm.field_type;
      ad.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + paramString.field_recvFmsgType);
    }
    if (paramm.field_type == 0)
    {
      paramm = bl.a.aIO(paramm.field_msgContent);
      paramString.field_contentFromUsername = paramm.yGA;
      paramString.field_contentNickname = paramm.nickname;
      paramString.field_contentPhoneNumMD5 = paramm.FzV;
      paramString.field_contentFullPhoneNumMD5 = paramm.FzW;
      ad.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
    }
    label1078:
    for (;;)
    {
      ((az)((k)g.ab(k.class)).cOG()).update(paramString, new String[0]);
      if (eLD() != 0) {
        break;
      }
      g.afB().afk().set(340225, Long.valueOf(System.currentTimeMillis()));
      break;
      if (paramm.eLF())
      {
        if (paramm.field_isSend >= 2) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1078;
          }
          paramm = bl.d.aIR(paramm.field_msgContent);
          paramString.field_contentVerifyContent = paramm.content;
          paramString.field_contentFromUsername = paramm.yGA;
          paramString.field_contentNickname = paramm.nickname;
          ad.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + paramString.field_contentVerifyContent + " receive, new friend Username: " + paramString.field_contentFromUsername + " new friend Nickname: " + paramString.field_contentNickname);
          paramm = paramString.field_contentFromUsername;
          localObject = paramString.field_contentNickname;
          mn localmn = new mn();
          localmn.drG.userName = paramm;
          localmn.drG.bNK = ((String)localObject);
          localmn.drG.type = 1;
          com.tencent.mm.sdk.b.a.ESL.l(localmn);
          break;
        }
      }
    }
  }
  
  public final boolean aIG(String paramString)
  {
    AppMethodBeat.i(117155);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
      AppMethodBeat.o(117155);
      return false;
    }
    ay localay = agf(paramString);
    if ((localay == null) || (!paramString.equals(localay.field_talker)))
    {
      ad.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117155);
      return false;
    }
    localay.field_isNew = 0;
    boolean bool = super.update(localay, new String[0]);
    AppMethodBeat.o(117155);
    return bool;
  }
  
  public final ay aIH(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117157);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
      AppMethodBeat.o(117157);
      return null;
    }
    paramString = "select * from fmessage_conversation  where encryptTalker=" + h.qj(paramString);
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new ay();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117157);
    return paramString;
  }
  
  public final ay agf(String paramString)
  {
    AppMethodBeat.i(117156);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
      AppMethodBeat.o(117156);
      return null;
    }
    ay localay = new ay();
    localay.field_talker = paramString;
    if (super.get(localay, new String[0]))
    {
      AppMethodBeat.o(117156);
      return localay;
    }
    ad.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117156);
    return null;
  }
  
  public final List<ay> eLB()
  {
    AppMethodBeat.i(117150);
    ad.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", new Object[] { Integer.valueOf(4) });
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
    while (localCursor.moveToNext())
    {
      ay localay = new ay();
      localay.convertFrom(localCursor);
      if (!bt.isNullOrNil(localay.field_talker)) {
        localArrayList.add(localay);
      }
    }
    localCursor.close();
    AppMethodBeat.o(117150);
    return localArrayList;
  }
  
  public final boolean eLC()
  {
    AppMethodBeat.i(117153);
    if (this.db.execSQL("fmessage_conversation", "update fmessage_conversation set isNew = 0"))
    {
      ad.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
      doNotify();
      AppMethodBeat.o(117153);
      return true;
    }
    ad.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
    AppMethodBeat.o(117153);
    return false;
  }
  
  public final int eLD()
  {
    int i = 0;
    AppMethodBeat.i(117154);
    Object localObject = String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[] { "fmessage_conversation", "isNew", "fmsgIsSend" });
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    ad.d("MicroMsg.FMessageConversationStorage", "getNewCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117154);
    return i;
  }
  
  public final void eLE()
  {
    AppMethodBeat.i(117159);
    aq.az(this.Fzv);
    aq.n(this.Fzv, 500L);
    AppMethodBeat.o(117159);
  }
  
  public final boolean fM(String paramString, int paramInt)
  {
    AppMethodBeat.i(117152);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
      AppMethodBeat.o(117152);
      return false;
    }
    ay localay = agf(paramString);
    if (localay == null)
    {
      ad.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117152);
      return false;
    }
    if (paramInt == localay.field_state)
    {
      ad.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
      AppMethodBeat.o(117152);
      return true;
    }
    localay.field_state = paramInt;
    localay.field_lastModifiedTime = System.currentTimeMillis();
    if (super.update(localay, new String[0]))
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
    Cursor localCursor = this.db.a("select count(*) from fmessage_conversation", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    ad.d("MicroMsg.FMessageConversationStorage", "getCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117151);
    return i;
  }
  
  public final boolean u(long paramLong, String paramString)
  {
    AppMethodBeat.i(117160);
    ad.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    if (bt.isNullOrNil(paramString)) {
      if (paramLong <= 0L) {}
    }
    for (String str = "delete from fmessage_conversation where fmsgSysRowId = '" + paramLong + "'"; this.db.execSQL("fmessage_conversation", str); str = "delete from fmessage_conversation where talker = '" + bt.aFQ(paramString) + "'")
    {
      ad.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.az
 * JD-Core Version:    0.7.0.1
 */