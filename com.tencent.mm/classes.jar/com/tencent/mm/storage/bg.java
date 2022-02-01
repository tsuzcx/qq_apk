package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
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

public final class bg
  extends j<bf>
  implements d, k.a
{
  private static final String[] Ipp;
  public static final String[] SQL_CREATE;
  private Runnable ILL;
  private final int cVS;
  public com.tencent.mm.sdk.e.e db;
  protected Context mContext;
  
  static
  {
    AppMethodBeat.i(117161);
    SQL_CREATE = new String[] { j.getCreateSQLs(bf.info, "fmessage_conversation") };
    Ipp = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )" };
    AppMethodBeat.o(117161);
  }
  
  public bg(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, bf.info, "fmessage_conversation", Ipp);
    AppMethodBeat.i(117148);
    this.mContext = null;
    this.cVS = 1;
    this.ILL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117147);
        int i = bg.this.frk();
        ad.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", new Object[] { Integer.valueOf(i) });
        g.ajC().ajl().set(143618, Integer.valueOf(i));
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
      if (!g.ajA().aiK())
      {
        ad.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        AppMethodBeat.o(117158);
        return;
      }
      paramm = new bh();
      if (!((bi)((l)g.ab(l.class)).dlJ()).get(l, paramm))
      {
        ad.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = ".concat(String.valueOf(l)));
        AppMethodBeat.o(117158);
        return;
      }
      ad.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = ".concat(String.valueOf(l)));
      paramString = ((l)g.ab(l.class)).dlI().apL(paramm.field_talker);
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
    paramString = new bf();
    Object localObject;
    if (paramm.field_type == 0)
    {
      localObject = bu.a.aUb(paramm.field_msgContent);
      paramString.field_displayName = ((bu.a)localObject).getDisplayName();
      if ((((bu.a)localObject).scene == 4) && (((bu.a)localObject).fss() != null)) {
        paramString.field_displayName = ((bu.a)localObject).fss();
      }
      paramString.field_addScene = ((bu.a)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bu.a)localObject).dHm;
      paramString.field_contentNickname = ((bu.a)localObject).nickname;
      paramString.field_contentPhoneNumMD5 = ((bu.a)localObject).IMm;
      paramString.field_contentFullPhoneNumMD5 = ((bu.a)localObject).IMn;
      ad.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      paramString.field_lastModifiedTime = System.currentTimeMillis();
      paramString.field_state = 0;
      paramString.field_talker = paramm.field_talker;
      paramString.field_encryptTalker = paramm.field_encryptTalker;
      paramString.field_fmsgSysRowId = l;
      paramString.field_fmsgIsSend = paramm.field_isSend;
      paramString.field_fmsgType = paramm.field_type;
      paramString.field_fmsgContent = paramm.field_msgContent;
      if (!paramm.frm()) {
        break label646;
      }
    }
    label646:
    for (int i = paramm.field_type;; i = 0)
    {
      paramString.field_recvFmsgType = i;
      ad.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + paramString.field_fmsgContent);
      ((bg)((l)g.ab(l.class)).dlI()).insert(paramString);
      frl();
      AppMethodBeat.o(117158);
      return;
      if (!paramm.frm()) {
        break;
      }
      localObject = bu.d.aUe(paramm.field_msgContent);
      paramString.field_displayName = ((bu.d)localObject).getDisplayName();
      paramString.field_addScene = ((bu.d)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bu.d)localObject).dHm;
      paramString.field_contentNickname = ((bu.d)localObject).nickname;
      paramString.field_contentVerifyContent = ((bu.d)localObject).content;
      ad.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      break;
    }
    label651:
    ad.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + paramm.field_talker);
    if (paramm.frm()) {
      paramString.field_isNew = 1;
    }
    paramString.field_lastModifiedTime = System.currentTimeMillis();
    paramString.field_encryptTalker = paramm.field_encryptTalker;
    paramString.field_fmsgSysRowId = l;
    paramString.field_fmsgIsSend = paramm.field_isSend;
    paramString.field_fmsgType = paramm.field_type;
    paramString.field_fmsgContent = paramm.field_msgContent;
    if (paramm.frm())
    {
      paramString.field_recvFmsgType = paramm.field_type;
      ad.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + paramString.field_recvFmsgType);
    }
    if (paramm.field_type == 0)
    {
      paramm = bu.a.aUb(paramm.field_msgContent);
      paramString.field_contentFromUsername = paramm.dHm;
      paramString.field_contentNickname = paramm.nickname;
      paramString.field_contentPhoneNumMD5 = paramm.IMm;
      paramString.field_contentFullPhoneNumMD5 = paramm.IMn;
      ad.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
    }
    label1078:
    for (;;)
    {
      ((bg)((l)g.ab(l.class)).dlI()).update(paramString, new String[0]);
      if (frk() != 0) {
        break;
      }
      g.ajC().ajl().set(340225, Long.valueOf(System.currentTimeMillis()));
      break;
      if (paramm.frm())
      {
        if (paramm.field_isSend >= 2) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1078;
          }
          paramm = bu.d.aUe(paramm.field_msgContent);
          paramString.field_contentVerifyContent = paramm.content;
          paramString.field_contentFromUsername = paramm.dHm;
          paramString.field_contentNickname = paramm.nickname;
          ad.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + paramString.field_contentVerifyContent + " receive, new friend Username: " + paramString.field_contentFromUsername + " new friend Nickname: " + paramString.field_contentNickname);
          paramm = paramString.field_contentFromUsername;
          localObject = paramString.field_contentNickname;
          ne localne = new ne();
          localne.dBe.userName = paramm;
          localne.dBe.bVF = ((String)localObject);
          localne.dBe.type = 1;
          com.tencent.mm.sdk.b.a.IbL.l(localne);
          break;
        }
      }
    }
  }
  
  public final boolean aTT(String paramString)
  {
    AppMethodBeat.i(117155);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
      AppMethodBeat.o(117155);
      return false;
    }
    bf localbf = apL(paramString);
    if ((localbf == null) || (!paramString.equals(localbf.field_talker)))
    {
      ad.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117155);
      return false;
    }
    localbf.field_isNew = 0;
    boolean bool = super.update(localbf, new String[0]);
    AppMethodBeat.o(117155);
    return bool;
  }
  
  public final bf aTU(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117157);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
      AppMethodBeat.o(117157);
      return null;
    }
    paramString = "select * from fmessage_conversation  where encryptTalker=" + h.wo(paramString);
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new bf();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117157);
    return paramString;
  }
  
  public final bf apL(String paramString)
  {
    AppMethodBeat.i(117156);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
      AppMethodBeat.o(117156);
      return null;
    }
    bf localbf = new bf();
    localbf.field_talker = paramString;
    if (super.get(localbf, new String[0]))
    {
      AppMethodBeat.o(117156);
      return localbf;
    }
    ad.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117156);
    return null;
  }
  
  public final List<bf> fri()
  {
    AppMethodBeat.i(117150);
    ad.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", new Object[] { Integer.valueOf(4) });
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
    while (localCursor.moveToNext())
    {
      bf localbf = new bf();
      localbf.convertFrom(localCursor);
      if (!bt.isNullOrNil(localbf.field_talker)) {
        localArrayList.add(localbf);
      }
    }
    localCursor.close();
    AppMethodBeat.o(117150);
    return localArrayList;
  }
  
  public final boolean frj()
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
  
  public final int frk()
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
  
  public final void frl()
  {
    AppMethodBeat.i(117159);
    aq.aA(this.ILL);
    aq.o(this.ILL, 500L);
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
    ad.d("MicroMsg.FMessageConversationStorage", "getCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117151);
    return i;
  }
  
  public final boolean gn(String paramString, int paramInt)
  {
    AppMethodBeat.i(117152);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
      AppMethodBeat.o(117152);
      return false;
    }
    bf localbf = apL(paramString);
    if (localbf == null)
    {
      ad.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117152);
      return false;
    }
    if (paramInt == localbf.field_state)
    {
      ad.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
      AppMethodBeat.o(117152);
      return true;
    }
    localbf.field_state = paramInt;
    localbf.field_lastModifiedTime = System.currentTimeMillis();
    if (super.update(localbf, new String[0]))
    {
      doNotify(paramString);
      AppMethodBeat.o(117152);
      return true;
    }
    AppMethodBeat.o(117152);
    return false;
  }
  
  public final boolean t(long paramLong, String paramString)
  {
    AppMethodBeat.i(117160);
    ad.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    if (bt.isNullOrNil(paramString)) {
      if (paramLong <= 0L) {}
    }
    for (String str = "delete from fmessage_conversation where fmsgSysRowId = '" + paramLong + "'"; this.db.execSQL("fmessage_conversation", str); str = "delete from fmessage_conversation where talker = '" + bt.aQN(paramString) + "'")
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bg
 * JD-Core Version:    0.7.0.1
 */