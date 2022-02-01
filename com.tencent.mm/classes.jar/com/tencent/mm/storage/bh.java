package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class bh
  extends j<bg>
  implements d, k.a
{
  private static final String[] IJJ;
  public static final String[] SQL_CREATE;
  private Runnable Jgs;
  private final int cWP;
  public com.tencent.mm.sdk.e.e db;
  protected Context mContext;
  
  static
  {
    AppMethodBeat.i(117161);
    SQL_CREATE = new String[] { j.getCreateSQLs(bg.info, "fmessage_conversation") };
    IJJ = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )" };
    AppMethodBeat.o(117161);
  }
  
  public bh(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, bg.info, "fmessage_conversation", IJJ);
    AppMethodBeat.i(117148);
    this.mContext = null;
    this.cWP = 1;
    this.Jgs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117147);
        int i = bh.this.fvk();
        ae.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", new Object[] { Integer.valueOf(i) });
        g.ajR().ajA().set(143618, Integer.valueOf(i));
        AppMethodBeat.o(117147);
      }
    };
    this.db = parame;
    this.mContext = ak.getContext();
    AppMethodBeat.o(117148);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(117158);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
      AppMethodBeat.o(117158);
      return;
    }
    long l;
    try
    {
      l = bu.getLong(paramString, 0L);
      if (l == 0L)
      {
        ae.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
        AppMethodBeat.o(117158);
        return;
      }
    }
    catch (Exception paramm)
    {
      for (;;)
      {
        ae.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + paramString + ", ex = " + paramm.getMessage());
        l = 0L;
      }
      if (!g.ajP().aiZ())
      {
        ae.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        AppMethodBeat.o(117158);
        return;
      }
      paramm = new bi();
      if (!((bj)((l)g.ab(l.class)).doI()).get(l, paramm))
      {
        ae.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = ".concat(String.valueOf(l)));
        AppMethodBeat.o(117158);
        return;
      }
      ae.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = ".concat(String.valueOf(l)));
      paramString = ((l)g.ab(l.class)).doH().aqQ(paramm.field_talker);
      if (paramString != null) {
        break label651;
      }
    }
    ae.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + paramm.field_talker);
    if (bu.isNullOrNil(paramm.field_talker))
    {
      ae.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
      AppMethodBeat.o(117158);
      return;
    }
    paramString = new bg();
    Object localObject;
    if (paramm.field_type == 0)
    {
      localObject = bv.a.aVC(paramm.field_msgContent);
      paramString.field_displayName = ((bv.a)localObject).getDisplayName();
      if ((((bv.a)localObject).scene == 4) && (((bv.a)localObject).fwt() != null)) {
        paramString.field_displayName = ((bv.a)localObject).fwt();
      }
      paramString.field_addScene = ((bv.a)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bv.a)localObject).cUA;
      paramString.field_contentNickname = ((bv.a)localObject).nickname;
      paramString.field_contentPhoneNumMD5 = ((bv.a)localObject).JgT;
      paramString.field_contentFullPhoneNumMD5 = ((bv.a)localObject).JgU;
      ae.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      paramString.field_lastModifiedTime = System.currentTimeMillis();
      paramString.field_state = 0;
      paramString.field_talker = paramm.field_talker;
      paramString.field_encryptTalker = paramm.field_encryptTalker;
      paramString.field_fmsgSysRowId = l;
      paramString.field_fmsgIsSend = paramm.field_isSend;
      paramString.field_fmsgType = paramm.field_type;
      paramString.field_fmsgContent = paramm.field_msgContent;
      if (!paramm.fvm()) {
        break label646;
      }
    }
    label646:
    for (int i = paramm.field_type;; i = 0)
    {
      paramString.field_recvFmsgType = i;
      ae.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + paramString.field_fmsgContent);
      ((bh)((l)g.ab(l.class)).doH()).insert(paramString);
      fvl();
      AppMethodBeat.o(117158);
      return;
      if (!paramm.fvm()) {
        break;
      }
      localObject = bv.d.aVF(paramm.field_msgContent);
      paramString.field_displayName = ((bv.d)localObject).getDisplayName();
      paramString.field_addScene = ((bv.d)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bv.d)localObject).cUA;
      paramString.field_contentNickname = ((bv.d)localObject).nickname;
      paramString.field_contentVerifyContent = ((bv.d)localObject).content;
      ae.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      break;
    }
    label651:
    ae.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + paramm.field_talker);
    if (paramm.fvm()) {
      paramString.field_isNew = 1;
    }
    paramString.field_lastModifiedTime = System.currentTimeMillis();
    paramString.field_encryptTalker = paramm.field_encryptTalker;
    paramString.field_fmsgSysRowId = l;
    paramString.field_fmsgIsSend = paramm.field_isSend;
    paramString.field_fmsgType = paramm.field_type;
    paramString.field_fmsgContent = paramm.field_msgContent;
    if (paramm.fvm())
    {
      paramString.field_recvFmsgType = paramm.field_type;
      ae.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + paramString.field_recvFmsgType);
    }
    if (paramm.field_type == 0)
    {
      paramm = bv.a.aVC(paramm.field_msgContent);
      paramString.field_contentFromUsername = paramm.cUA;
      paramString.field_contentNickname = paramm.nickname;
      paramString.field_contentPhoneNumMD5 = paramm.JgT;
      paramString.field_contentFullPhoneNumMD5 = paramm.JgU;
      ae.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
    }
    label1078:
    for (;;)
    {
      ((bh)((l)g.ab(l.class)).doH()).update(paramString, new String[0]);
      if (fvk() != 0) {
        break;
      }
      g.ajR().ajA().set(340225, Long.valueOf(System.currentTimeMillis()));
      break;
      if (paramm.fvm())
      {
        if (paramm.field_isSend >= 2) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1078;
          }
          paramm = bv.d.aVF(paramm.field_msgContent);
          paramString.field_contentVerifyContent = paramm.content;
          paramString.field_contentFromUsername = paramm.cUA;
          paramString.field_contentNickname = paramm.nickname;
          ae.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + paramString.field_contentVerifyContent + " receive, new friend Username: " + paramString.field_contentFromUsername + " new friend Nickname: " + paramString.field_contentNickname);
          paramm = paramString.field_contentFromUsername;
          localObject = paramString.field_contentNickname;
          nf localnf = new nf();
          localnf.dCj.userName = paramm;
          localnf.dCj.bVF = ((String)localObject);
          localnf.dCj.type = 1;
          com.tencent.mm.sdk.b.a.IvT.l(localnf);
          break;
        }
      }
    }
  }
  
  public final boolean aVu(String paramString)
  {
    AppMethodBeat.i(117155);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
      AppMethodBeat.o(117155);
      return false;
    }
    bg localbg = aqQ(paramString);
    if ((localbg == null) || (!paramString.equals(localbg.field_talker)))
    {
      ae.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117155);
      return false;
    }
    localbg.field_isNew = 0;
    boolean bool = super.update(localbg, new String[0]);
    AppMethodBeat.o(117155);
    return bool;
  }
  
  public final bg aVv(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117157);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
      AppMethodBeat.o(117157);
      return null;
    }
    paramString = "select * from fmessage_conversation  where encryptTalker=" + h.wX(paramString);
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new bg();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117157);
    return paramString;
  }
  
  public final bg aqQ(String paramString)
  {
    AppMethodBeat.i(117156);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
      AppMethodBeat.o(117156);
      return null;
    }
    bg localbg = new bg();
    localbg.field_talker = paramString;
    if (super.get(localbg, new String[0]))
    {
      AppMethodBeat.o(117156);
      return localbg;
    }
    ae.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117156);
    return null;
  }
  
  public final List<bg> fvi()
  {
    AppMethodBeat.i(117150);
    ae.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", new Object[] { Integer.valueOf(4) });
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
    while (localCursor.moveToNext())
    {
      bg localbg = new bg();
      localbg.convertFrom(localCursor);
      if (!bu.isNullOrNil(localbg.field_talker)) {
        localArrayList.add(localbg);
      }
    }
    localCursor.close();
    AppMethodBeat.o(117150);
    return localArrayList;
  }
  
  public final boolean fvj()
  {
    AppMethodBeat.i(117153);
    if (this.db.execSQL("fmessage_conversation", "update fmessage_conversation set isNew = 0"))
    {
      ae.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
      doNotify();
      AppMethodBeat.o(117153);
      return true;
    }
    ae.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
    AppMethodBeat.o(117153);
    return false;
  }
  
  public final int fvk()
  {
    int i = 0;
    AppMethodBeat.i(117154);
    Object localObject = String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[] { "fmessage_conversation", "isNew", "fmsgIsSend" });
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    ae.d("MicroMsg.FMessageConversationStorage", "getNewCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117154);
    return i;
  }
  
  public final void fvl()
  {
    AppMethodBeat.i(117159);
    ar.ay(this.Jgs);
    ar.o(this.Jgs, 500L);
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
    ae.d("MicroMsg.FMessageConversationStorage", "getCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117151);
    return i;
  }
  
  public final boolean gw(String paramString, int paramInt)
  {
    AppMethodBeat.i(117152);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
      AppMethodBeat.o(117152);
      return false;
    }
    bg localbg = aqQ(paramString);
    if (localbg == null)
    {
      ae.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117152);
      return false;
    }
    if (paramInt == localbg.field_state)
    {
      ae.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
      AppMethodBeat.o(117152);
      return true;
    }
    localbg.field_state = paramInt;
    localbg.field_lastModifiedTime = System.currentTimeMillis();
    if (super.update(localbg, new String[0]))
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
    ae.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    if (bu.isNullOrNil(paramString)) {
      if (paramLong <= 0L) {}
    }
    for (String str = "delete from fmessage_conversation where fmsgSysRowId = '" + paramLong + "'"; this.db.execSQL("fmessage_conversation", str); str = "delete from fmessage_conversation where talker = '" + bu.aSk(paramString) + "'")
    {
      ae.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
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
 * Qualified Name:     com.tencent.mm.storage.bh
 * JD-Core Version:    0.7.0.1
 */