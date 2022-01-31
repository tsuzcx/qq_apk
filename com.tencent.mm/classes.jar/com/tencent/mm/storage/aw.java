package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.a.kq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class aw
  extends i<av>
  implements d, j.a
{
  public static final String[] dXp = { i.a(av.buS, "fmessage_conversation") };
  private static final String[] uno = { "CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )" };
  private final int bxF = 1;
  public com.tencent.mm.sdk.e.e dXw;
  protected Context mContext = null;
  private Runnable uBA = new Runnable()
  {
    public final void run()
    {
      int i = aw.this.cuU();
      y.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", new Object[] { Integer.valueOf(i) });
      g.DP().Dz().o(143618, Integer.valueOf(i));
    }
  };
  
  public aw(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, av.buS, "fmessage_conversation", uno);
    this.dXw = parame;
    this.mContext = ae.getContext();
  }
  
  public final av Hq(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
      localObject = null;
    }
    av localav;
    do
    {
      return localObject;
      localav = new av();
      localav.field_talker = paramString;
      localObject = localav;
    } while (super.b(localav, new String[0]));
    y.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = " + paramString);
    return null;
  }
  
  public final void a(String paramString, l paraml)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
      return;
    }
    long l;
    try
    {
      l = bk.getLong(paramString, 0L);
      if (l == 0L)
      {
        y.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
        return;
      }
    }
    catch (Exception paraml)
    {
      for (;;)
      {
        y.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + paramString + ", ex = " + paraml.getMessage());
        l = 0L;
      }
      if (!g.DN().Dc())
      {
        y.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        return;
      }
      paraml = new ax();
      if (!((ay)((j)g.r(j.class)).bhN()).b(l, paraml))
      {
        y.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = " + l);
        return;
      }
      y.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = " + l);
      paramString = ((j)g.r(j.class)).bhM().Hq(paraml.field_talker);
      if (paramString != null) {
        break label627;
      }
    }
    y.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + paraml.field_talker);
    if (bk.bl(paraml.field_talker))
    {
      y.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
      return;
    }
    paramString = new av();
    Object localObject;
    if (paraml.field_type == 0)
    {
      localObject = bi.a.abZ(paraml.field_msgContent);
      paramString.field_displayName = ((bi.a)localObject).getDisplayName();
      if ((((bi.a)localObject).scene == 4) && (((bi.a)localObject).cvM() != null)) {
        paramString.field_displayName = ((bi.a)localObject).cvM();
      }
      paramString.field_addScene = ((bi.a)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bi.a)localObject).pyp;
      paramString.field_contentNickname = ((bi.a)localObject).nickname;
      paramString.field_contentPhoneNumMD5 = ((bi.a)localObject).uBW;
      paramString.field_contentFullPhoneNumMD5 = ((bi.a)localObject).uBX;
      y.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      paramString.field_lastModifiedTime = System.currentTimeMillis();
      paramString.field_state = 0;
      paramString.field_talker = paraml.field_talker;
      paramString.field_encryptTalker = paraml.field_encryptTalker;
      paramString.field_fmsgSysRowId = l;
      paramString.field_fmsgIsSend = paraml.field_isSend;
      paramString.field_fmsgType = paraml.field_type;
      paramString.field_fmsgContent = paraml.field_msgContent;
      if (!paraml.cuX()) {
        break label622;
      }
    }
    label622:
    for (int i = paraml.field_type;; i = 0)
    {
      paramString.field_recvFmsgType = i;
      y.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + paramString.field_fmsgContent);
      ((aw)((j)g.r(j.class)).bhM()).b(paramString);
      cuW();
      return;
      if (!paraml.cuX()) {
        break;
      }
      localObject = bi.d.acc(paraml.field_msgContent);
      paramString.field_displayName = ((bi.d)localObject).getDisplayName();
      paramString.field_addScene = ((bi.d)localObject).scene;
      paramString.field_isNew = 1;
      paramString.field_contentFromUsername = ((bi.d)localObject).pyp;
      paramString.field_contentNickname = ((bi.d)localObject).nickname;
      paramString.field_contentVerifyContent = ((bi.d)localObject).content;
      y.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
      break;
    }
    label627:
    y.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + paraml.field_talker);
    if (paraml.cuX()) {
      paramString.field_isNew = 1;
    }
    paramString.field_lastModifiedTime = System.currentTimeMillis();
    paramString.field_encryptTalker = paraml.field_encryptTalker;
    paramString.field_fmsgSysRowId = l;
    paramString.field_fmsgIsSend = paraml.field_isSend;
    paramString.field_fmsgType = paraml.field_type;
    paramString.field_fmsgContent = paraml.field_msgContent;
    if (paraml.cuX())
    {
      paramString.field_recvFmsgType = paraml.field_type;
      y.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + paramString.field_recvFmsgType);
    }
    if (paraml.field_type == 0)
    {
      paraml = bi.a.abZ(paraml.field_msgContent);
      paramString.field_contentFromUsername = paraml.pyp;
      paramString.field_contentNickname = paraml.nickname;
      paramString.field_contentPhoneNumMD5 = paraml.uBW;
      paramString.field_contentFullPhoneNumMD5 = paraml.uBX;
      y.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + paramString.field_contentFromUsername + "new friend Nickname: " + paramString.field_contentNickname);
    }
    label1053:
    for (;;)
    {
      ((aw)((j)g.r(j.class)).bhM()).c(paramString, new String[0]);
      if (cuU() != 0) {
        break;
      }
      g.DP().Dz().o(340225, Long.valueOf(System.currentTimeMillis()));
      break;
      if (paraml.cuX())
      {
        if (paraml.field_isSend >= 2) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1053;
          }
          paraml = bi.d.acc(paraml.field_msgContent);
          paramString.field_contentVerifyContent = paraml.content;
          paramString.field_contentFromUsername = paraml.pyp;
          paramString.field_contentNickname = paraml.nickname;
          y.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + paramString.field_contentVerifyContent + " receive, new friend Username: " + paramString.field_contentFromUsername + " new friend Nickname: " + paramString.field_contentNickname);
          paraml = paramString.field_contentFromUsername;
          localObject = paramString.field_contentNickname;
          kq localkq = new kq();
          localkq.bTH.userName = paraml;
          localkq.bTH.aVr = ((String)localObject);
          localkq.bTH.type = 1;
          com.tencent.mm.sdk.b.a.udP.m(localkq);
          break;
        }
      }
    }
  }
  
  public final Cursor aAn()
  {
    return this.dXw.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
  }
  
  public final boolean abQ(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
      return false;
    }
    av localav = Hq(paramString);
    if ((localav == null) || (!paramString.equals(localav.field_talker)))
    {
      y.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = " + paramString);
      return false;
    }
    localav.field_isNew = 0;
    return super.c(localav, new String[0]);
  }
  
  public final av abR(String paramString)
  {
    Object localObject = null;
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
      return null;
    }
    paramString = "select * from fmessage_conversation  where encryptTalker=" + h.fA(paramString);
    Cursor localCursor = this.dXw.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new av();
      paramString.d(localCursor);
    }
    localCursor.close();
    return paramString;
  }
  
  public final boolean cuT()
  {
    if (this.dXw.gk("fmessage_conversation", "update fmessage_conversation set isNew = 0"))
    {
      y.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
      doNotify();
      return true;
    }
    y.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
    return false;
  }
  
  public final int cuU()
  {
    int i = 0;
    Object localObject = String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[] { "fmessage_conversation", "isNew", "fmsgIsSend" });
    localObject = this.dXw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    y.d("MicroMsg.FMessageConversationStorage", "getNewCount = " + i);
    return i;
  }
  
  public final List<String> cuV()
  {
    Object localObject = String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[] { "contentNickname", "fmessage_conversation", Integer.valueOf(2) });
    localObject = this.dXw.a((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("contentNickname")));
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final void cuW()
  {
    ai.S(this.uBA);
    ai.l(this.uBA, 500L);
  }
  
  public final boolean du(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      y.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
    }
    av localav;
    do
    {
      return false;
      localav = Hq(paramString);
      if (localav == null)
      {
        y.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = " + paramString);
        return false;
      }
      if (paramInt == localav.field_state)
      {
        y.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
        return true;
      }
      localav.field_state = paramInt;
      localav.field_lastModifiedTime = System.currentTimeMillis();
    } while (!super.c(localav, new String[0]));
    aam(paramString);
    return true;
  }
  
  public final int getCount()
  {
    int i = 0;
    Cursor localCursor = this.dXw.a("select count(*) from fmessage_conversation", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    y.d("MicroMsg.FMessageConversationStorage", "getCount = " + i);
    return i;
  }
  
  public final boolean p(long paramLong, String paramString)
  {
    y.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    if (bk.bl(paramString)) {
      if (paramLong <= 0L) {}
    }
    for (String str = "delete from fmessage_conversation where fmsgSysRowId = '" + paramLong + "'"; this.dXw.gk("fmessage_conversation", str); str = "delete from fmessage_conversation where talker = '" + bk.pl(paramString) + "'")
    {
      y.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
      aam(paramString);
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.aw
 * JD-Core Version:    0.7.0.1
 */