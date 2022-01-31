package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.a.le;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class aw
  extends com.tencent.mm.sdk.e.j<av>
  implements d, k.a
{
  public static final String[] SQL_CREATE;
  private static final String[] yxa;
  private final int bZH;
  public com.tencent.mm.sdk.e.e db;
  protected Context mContext;
  private Runnable yNK;
  
  static
  {
    AppMethodBeat.i(1293);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(av.info, "fmessage_conversation") };
    yxa = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )" };
    AppMethodBeat.o(1293);
  }
  
  public aw(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, av.info, "fmessage_conversation", yxa);
    AppMethodBeat.i(1280);
    this.mContext = null;
    this.bZH = 1;
    this.yNK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(1279);
        int i = aw.this.dxy();
        ab.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", new Object[] { Integer.valueOf(i) });
        g.RL().Ru().set(143618, Integer.valueOf(i));
        AppMethodBeat.o(1279);
      }
    };
    this.db = parame;
    this.mContext = ah.getContext();
    AppMethodBeat.o(1280);
  }
  
  public final av Tc(String paramString)
  {
    AppMethodBeat.i(1288);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
      AppMethodBeat.o(1288);
      return null;
    }
    av localav = new av();
    localav.field_talker = paramString;
    if (super.get(localav, new String[0]))
    {
      AppMethodBeat.o(1288);
      return localav;
    }
    ab.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(1288);
    return null;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(1290);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
      AppMethodBeat.o(1290);
      return;
    }
    long l;
    try
    {
      l = bo.getLong(paramString, 0L);
      if (l == 0L)
      {
        ab.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
        AppMethodBeat.o(1290);
        return;
      }
    }
    catch (Exception paramm)
    {
      for (;;)
      {
        ab.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + paramString + ", ex = " + paramm.getMessage());
        l = 0L;
      }
      if (!g.RJ().QU())
      {
        ab.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        AppMethodBeat.o(1290);
        return;
      }
      paramm = new ax();
      if (!((ay)((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPP()).get(l, paramm))
      {
        ab.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = ".concat(String.valueOf(l)));
        AppMethodBeat.o(1290);
        return;
      }
      ab.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = ".concat(String.valueOf(l)));
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPO().Tc(paramm.field_talker);
      if (paramString != null) {
        break label658;
      }
    }
    ab.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + paramm.field_talker);
    if (bo.isNullOrNil(paramm.field_talker))
    {
      ab.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
      AppMethodBeat.o(1290);
      return;
    }
    paramString = new av();
    Object localObject;
    if (paramm.field_type == 0)
    {
      localObject = bi.a.asj(paramm.field_msgContent);
      paramString.field_displayName = ((bi.a)localObject).getDisplayName();
      if ((((bi.a)localObject).scene == 4) && (((bi.a)localObject).dyu() != null)) {
        paramString.field_displayName = ((bi.a)localObject).dyu();
      }
      paramString.field_addScene = ((bi.a)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bi.a)localObject).tac;
      paramString.field_contentNickname = ((bi.a)localObject).nickname;
      paramString.field_contentPhoneNumMD5 = ((bi.a)localObject).yOi;
      paramString.field_contentFullPhoneNumMD5 = ((bi.a)localObject).yOj;
      ab.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      paramString.field_lastModifiedTime = System.currentTimeMillis();
      paramString.field_state = 0;
      paramString.field_talker = paramm.field_talker;
      paramString.field_encryptTalker = paramm.field_encryptTalker;
      paramString.field_fmsgSysRowId = l;
      paramString.field_fmsgIsSend = paramm.field_isSend;
      paramString.field_fmsgType = paramm.field_type;
      paramString.field_fmsgContent = paramm.field_msgContent;
      if (!paramm.dxA()) {
        break label653;
      }
    }
    label653:
    for (int i = paramm.field_type;; i = 0)
    {
      paramString.field_recvFmsgType = i;
      ab.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + paramString.field_fmsgContent);
      ((aw)((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPO()).insert(paramString);
      dxz();
      AppMethodBeat.o(1290);
      return;
      if (!paramm.dxA()) {
        break;
      }
      localObject = bi.d.asm(paramm.field_msgContent);
      paramString.field_displayName = ((bi.d)localObject).getDisplayName();
      paramString.field_addScene = ((bi.d)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bi.d)localObject).tac;
      paramString.field_contentNickname = ((bi.d)localObject).nickname;
      paramString.field_contentVerifyContent = ((bi.d)localObject).content;
      ab.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      break;
    }
    label658:
    ab.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + paramm.field_talker);
    if (paramm.dxA()) {
      paramString.field_isNew = 1;
    }
    paramString.field_lastModifiedTime = System.currentTimeMillis();
    paramString.field_encryptTalker = paramm.field_encryptTalker;
    paramString.field_fmsgSysRowId = l;
    paramString.field_fmsgIsSend = paramm.field_isSend;
    paramString.field_fmsgType = paramm.field_type;
    paramString.field_fmsgContent = paramm.field_msgContent;
    if (paramm.dxA())
    {
      paramString.field_recvFmsgType = paramm.field_type;
      ab.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + paramString.field_recvFmsgType);
    }
    if (paramm.field_type == 0)
    {
      paramm = bi.a.asj(paramm.field_msgContent);
      paramString.field_contentFromUsername = paramm.tac;
      paramString.field_contentNickname = paramm.nickname;
      paramString.field_contentPhoneNumMD5 = paramm.yOi;
      paramString.field_contentFullPhoneNumMD5 = paramm.yOj;
      ab.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
    }
    label1085:
    for (;;)
    {
      ((aw)((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPO()).update(paramString, new String[0]);
      if (dxy() != 0) {
        break;
      }
      g.RL().Ru().set(340225, Long.valueOf(System.currentTimeMillis()));
      break;
      if (paramm.dxA())
      {
        if (paramm.field_isSend >= 2) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1085;
          }
          paramm = bi.d.asm(paramm.field_msgContent);
          paramString.field_contentVerifyContent = paramm.content;
          paramString.field_contentFromUsername = paramm.tac;
          paramString.field_contentNickname = paramm.nickname;
          ab.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + paramString.field_contentVerifyContent + " receive, new friend Username: " + paramString.field_contentFromUsername + " new friend Nickname: " + paramString.field_contentNickname);
          paramm = paramString.field_contentFromUsername;
          localObject = paramString.field_contentNickname;
          le localle = new le();
          localle.cBo.userName = paramm;
          localle.cBo.blZ = ((String)localObject);
          localle.cBo.type = 1;
          com.tencent.mm.sdk.b.a.ymk.l(localle);
          break;
        }
      }
    }
  }
  
  public final boolean asa(String paramString)
  {
    AppMethodBeat.i(1287);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
      AppMethodBeat.o(1287);
      return false;
    }
    av localav = Tc(paramString);
    if ((localav == null) || (!paramString.equals(localav.field_talker)))
    {
      ab.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1287);
      return false;
    }
    localav.field_isNew = 0;
    boolean bool = super.update(localav, new String[0]);
    AppMethodBeat.o(1287);
    return bool;
  }
  
  public final av asb(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(1289);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
      AppMethodBeat.o(1289);
      return null;
    }
    paramString = "select * from fmessage_conversation  where encryptTalker=" + h.escape(paramString);
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new av();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(1289);
    return paramString;
  }
  
  public final List<av> dxw()
  {
    AppMethodBeat.i(1282);
    ab.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", new Object[] { Integer.valueOf(4) });
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
    while (localCursor.moveToNext())
    {
      av localav = new av();
      localav.convertFrom(localCursor);
      if (!bo.isNullOrNil(localav.field_talker)) {
        localArrayList.add(localav);
      }
    }
    localCursor.close();
    AppMethodBeat.o(1282);
    return localArrayList;
  }
  
  public final boolean dxx()
  {
    AppMethodBeat.i(1285);
    if (this.db.execSQL("fmessage_conversation", "update fmessage_conversation set isNew = 0"))
    {
      ab.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
      doNotify();
      AppMethodBeat.o(1285);
      return true;
    }
    ab.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
    AppMethodBeat.o(1285);
    return false;
  }
  
  public final int dxy()
  {
    int i = 0;
    AppMethodBeat.i(1286);
    Object localObject = String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[] { "fmessage_conversation", "isNew", "fmsgIsSend" });
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    ab.d("MicroMsg.FMessageConversationStorage", "getNewCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(1286);
    return i;
  }
  
  public final void dxz()
  {
    AppMethodBeat.i(1291);
    al.ae(this.yNK);
    al.p(this.yNK, 500L);
    AppMethodBeat.o(1291);
  }
  
  public final boolean eD(String paramString, int paramInt)
  {
    AppMethodBeat.i(1284);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
      AppMethodBeat.o(1284);
      return false;
    }
    av localav = Tc(paramString);
    if (localav == null)
    {
      ab.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1284);
      return false;
    }
    if (paramInt == localav.field_state)
    {
      ab.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
      AppMethodBeat.o(1284);
      return true;
    }
    localav.field_state = paramInt;
    localav.field_lastModifiedTime = System.currentTimeMillis();
    if (super.update(localav, new String[0]))
    {
      doNotify(paramString);
      AppMethodBeat.o(1284);
      return true;
    }
    AppMethodBeat.o(1284);
    return false;
  }
  
  public final Cursor getAll()
  {
    AppMethodBeat.i(1281);
    Cursor localCursor = this.db.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
    AppMethodBeat.o(1281);
    return localCursor;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(1283);
    Cursor localCursor = this.db.a("select count(*) from fmessage_conversation", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    ab.d("MicroMsg.FMessageConversationStorage", "getCount = ".concat(String.valueOf(i)));
    AppMethodBeat.o(1283);
    return i;
  }
  
  public final boolean p(long paramLong, String paramString)
  {
    AppMethodBeat.i(1292);
    ab.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    if (bo.isNullOrNil(paramString)) {
      if (paramLong <= 0L) {}
    }
    for (String str = "delete from fmessage_conversation where fmsgSysRowId = '" + paramLong + "'"; this.db.execSQL("fmessage_conversation", str); str = "delete from fmessage_conversation where talker = '" + bo.wC(paramString) + "'")
    {
      ab.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
      doNotify(paramString);
      AppMethodBeat.o(1292);
      return true;
      AppMethodBeat.o(1292);
      return false;
    }
    AppMethodBeat.o(1292);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.aw
 * JD-Core Version:    0.7.0.1
 */