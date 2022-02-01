package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vending.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class au
  extends n
  implements bq
{
  public static final String[] SQL_CREATE;
  private bq.b IKl;
  private f IKm;
  private a IKn;
  private com.tencent.mm.sdk.e.l<bq.a, at> IKo;
  private com.tencent.mm.sdk.e.l<bq.a, at> IKp;
  private final com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(117133);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.p.a.info, "rconversation"), j.getCreateSQLs(com.tencent.mm.p.a.info, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE INDEX IF NOT EXISTS rconversation_unreadcount_index ON rconversation ( unReadCount )", "DROP INDEX IF EXISTS multi_index ", "DROP INDEX IF EXISTS rconversation_multi_index", "CREATE INDEX IF NOT EXISTS rconversation_parentref_index ON  rconversation ( parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )" };
    AppMethodBeat.o(117133);
  }
  
  public au(com.tencent.mm.sdk.e.e parame)
  {
    AppMethodBeat.i(117067);
    this.IKn = new a((byte)0);
    this.IKo = new com.tencent.mm.sdk.e.l() {};
    this.IKp = new com.tencent.mm.sdk.e.l() {};
    Assert.assertTrue(parame instanceof h);
    Object localObject = parame.a("PRAGMA table_info( rconversation)", null, 2);
    int i = ((Cursor)localObject).getColumnIndex("name");
    do
    {
      if (!((Cursor)localObject).moveToNext()) {
        break;
      }
    } while ((i < 0) || (!"flag".equalsIgnoreCase(((Cursor)localObject).getString(i))));
    for (i = 1;; i = 0)
    {
      ((Cursor)localObject).close();
      localObject = j.getUpdateSQLs(com.tencent.mm.p.a.info, "rconversation", parame);
      ((List)localObject).addAll(j.getUpdateSQLs(com.tencent.mm.p.a.info, "rbottleconversation", parame));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        parame.execSQL("rconversation", (String)((Iterator)localObject).next());
      }
      if (i == 0) {
        parame.execSQL("rconversation", "update rconversation set flag = conversationTime");
      }
      this.db = parame;
      AppMethodBeat.o(117067);
      return;
    }
  }
  
  private static String F(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(117104);
    String str = "";
    Object localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.size() > 0)
      {
        paramString = "" + paramString + " not in (";
        int i = 0;
        if (i < paramList.size())
        {
          localObject = new StringBuilder().append(paramString).append("\"").append(bt.aQN((String)paramList.get(i))).append("\"");
          if (i == paramList.size() - 1) {}
          for (paramString = "";; paramString = ",")
          {
            paramString = paramString;
            i += 1;
            break;
          }
        }
        localObject = paramString + ") ";
      }
    }
    AppMethodBeat.o(117104);
    return localObject;
  }
  
  private static String Fu(String paramString)
  {
    AppMethodBeat.i(117068);
    ad.v("MicroMsg.ConversationStorage", "talker :".concat(String.valueOf(paramString)));
    if (am.zs(paramString))
    {
      AppMethodBeat.o(117068);
      return "rbottleconversation";
    }
    AppMethodBeat.o(117068);
    return "rconversation";
  }
  
  private static long d(at paramat)
  {
    AppMethodBeat.i(117075);
    if (paramat != null)
    {
      l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramat, paramat.field_conversationTime);
      AppMethodBeat.o(117075);
      return l;
    }
    long l = bt.flT();
    AppMethodBeat.o(117075);
    return l & 0xFFFFFFFF;
  }
  
  private static void f(at paramat)
  {
    AppMethodBeat.i(117092);
    if (paramat == null)
    {
      AppMethodBeat.o(117092);
      return;
    }
    if (paramat.field_unReadCount > 0)
    {
      ad.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
      if ((paramat.field_attrflag & 0x100000) != 0)
      {
        paramat.kp(paramat.field_unReadCount - 1);
        paramat.kt(paramat.field_attrflag & 0xFFEFFFFF);
      }
    }
    AppMethodBeat.o(117092);
  }
  
  public final int AA(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117122);
    paramString = "select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + bt.nullAsNil(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117122);
    return i;
  }
  
  public final boolean JI(String paramString)
  {
    AppMethodBeat.i(217601);
    if (aTz(paramString) != null)
    {
      AppMethodBeat.o(217601);
      return true;
    }
    AppMethodBeat.o(217601);
    return false;
  }
  
  public final bq.b Na()
  {
    return this.IKl;
  }
  
  public final int a(at paramat, String paramString)
  {
    AppMethodBeat.i(221254);
    int i = a(paramat, paramString, true);
    AppMethodBeat.o(221254);
    return i;
  }
  
  public final int a(at paramat, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117091);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(117091);
      return 0;
    }
    if (paramBoolean) {
      paramat.qv(d(paramat));
    }
    f(paramat);
    int i = this.db.update(Fu(paramString), paramat.convertTo(), "username=?", new String[] { paramString });
    if (i != 0) {
      b(3, this, paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(117091);
      return i;
      ad.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", new Object[] { Fu(paramString) });
    }
  }
  
  public final Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(117102);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.p.a.gfl == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bt.nullAsNil(paramString1));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramString1 = new ArrayList(paramList).iterator();
      while (paramString1.hasNext())
      {
        paramList = (String)paramString1.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramList).append("'");
      }
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(bt.aQN(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc");
    ad.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + localStringBuilder.toString());
    paramString1 = this.db;
    paramList = localStringBuilder.toString();
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      paramString1 = paramString1.a(paramList, null, i);
      AppMethodBeat.o(117102);
      return paramString1;
    }
  }
  
  public final Cursor a(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(117105);
    String str2 = " ";
    String str1 = str2;
    if (paramString2 != null)
    {
      str1 = str2;
      if (paramString2.length() > 0) {
        str1 = " and rconversation.username = rcontact.username ";
      }
    }
    paramString1 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + " " + " where rconversation.username = rcontact.username" + str1 + bt.nullAsNil(paramString1);
    paramList = F(" and rconversation.username", paramList);
    paramList = paramString1 + paramList;
    paramString1 = paramList;
    if (paramBoolean) {
      paramString1 = paramList + " and ( verifyFlag & 8 ) = 0";
    }
    paramList = paramString1;
    if (paramString2 != null)
    {
      paramList = paramString1;
      if (paramString2.length() > 0) {
        paramList = paramString1 + new StringBuilder(" and ( rconversation.username like '%").append(paramString2).append("%' or content like '%").append(paramString2).append("%' or rcontact.nickname like '%").append(paramString2).append("%' or rcontact.alias like '%").append(paramString2).append("%' or rcontact.pyInitial like '%").append(paramString2).append("%' or rcontact.quanPin like '%").append(paramString2).append("%' or rcontact.conRemark like '%").append(paramString2).append("%'  ) ").toString();
      }
    }
    if ((paramString2 == null) || (paramString2.equals(""))) {}
    for (paramString1 = paramList + " order by flag desc, conversationTime desc";; paramString1 = paramList + " order by rconversation.username like \"%@chatroom\" asc")
    {
      ad.d("MicroMsg.ConversationStorage", "getSearchCursor sql ".concat(String.valueOf(paramString1)));
      paramString1 = this.db.rawQuery(paramString1, null);
      AppMethodBeat.o(117105);
      return paramString1;
    }
  }
  
  public final Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(117103);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo");
    localStringBuilder.append(" from rconversation where (");
    int i = 0;
    if (i < paramArrayList.size())
    {
      if (i != paramArrayList.size() - 1) {
        localStringBuilder.append("username = '" + (String)paramArrayList.get(i) + "' OR ");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("username = '" + (String)paramArrayList.get(i) + "'");
      }
    }
    localStringBuilder.append(") and ");
    if (com.tencent.mm.p.a.gfl == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bt.nullAsNil(paramString1));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramArrayList = new ArrayList(paramList).iterator();
      while (paramArrayList.hasNext())
      {
        paramString1 = (String)paramArrayList.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramString1).append("'");
      }
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(bt.aQN(paramString2)).append("' ");
      }
    }
    ad.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(117103);
    return paramArrayList;
  }
  
  public final b a(com.tencent.mm.plugin.messenger.foundation.a.g paramg)
  {
    AppMethodBeat.i(117069);
    paramg = this.IKn.bu(paramg);
    AppMethodBeat.o(117069);
    return paramg;
  }
  
  public final void a(f paramf)
  {
    this.IKm = paramf;
  }
  
  public final void a(at paramat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117083);
    if (!bj.Bn(paramat.field_username))
    {
      AppMethodBeat.o(117083);
      return;
    }
    if (bt.nullAsNil(paramat.field_username).length() <= 0)
    {
      ad.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
      AppMethodBeat.o(117083);
      return;
    }
    if (paramat.field_msgCount == 0)
    {
      paramat.ko(bj.Bm(paramat.field_username));
      ad.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      ad.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(paramat.field_msgCount), paramat.field_username, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(117083);
      return;
      if (paramInt1 > 0)
      {
        paramat.ko(paramat.field_msgCount - paramInt1);
        if (paramat.field_msgCount < 0)
        {
          ad.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
          paramat.ko(0);
        }
      }
      else if (paramInt2 > 0)
      {
        paramat.ko(paramat.field_msgCount + paramInt2);
      }
    }
  }
  
  public final void a(bq.a parama)
  {
    AppMethodBeat.i(117070);
    this.IKp.a(parama, null);
    AppMethodBeat.o(117070);
  }
  
  public final void a(bq.b paramb)
  {
    this.IKl = paramb;
  }
  
  public final boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(117089);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117089);
      return false;
    }
    if (aTz(paramString) == null)
    {
      AppMethodBeat.o(117089);
      return true;
    }
    if (paramBoolean) {}
    for (int i = paramInt2 | paramInt1; i == paramInt2; i = (paramInt1 ^ 0xFFFFFFFF) & paramInt2)
    {
      AppMethodBeat.o(117089);
      return false;
    }
    if ((paramInt2 >= 0) && (paramInt2 < 536870912) && ((i >= 536870912) || (i < 0)) && (paramString.contains("@")))
    {
      ad.i("Conversition", "wrong add attr flag: %s, %s, %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), bt.flS() });
      com.tencent.mm.plugin.report.e.ygI.f(20435, new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString });
    }
    paramBoolean = this.db.execSQL("rconversation", "update " + Fu(paramString) + " set attrflag = " + i + " where username = \"" + bt.aQN(paramString) + "\"");
    if (paramBoolean) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(117089);
    return paramBoolean;
  }
  
  public final void aM(bu parambu)
  {
    AppMethodBeat.i(117080);
    String str = parambu.field_talker;
    int i = 0;
    at localat2 = aTz(str);
    if ((localat2 != null) && (localat2.field_conversationTime > parambu.field_createTime) && (localat2.field_conversationTime != 9223372036854775807L))
    {
      ad.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      AppMethodBeat.o(117080);
      return;
    }
    at localat1 = localat2;
    if (localat2 == null)
    {
      localat1 = new at(str);
      i = 1;
    }
    localat1.kr(parambu.field_isSend);
    localat1.kp(localat1.field_unReadCount);
    localat1.aL(parambu);
    localat1.tA(Integer.toString(parambu.getType()));
    localat1.qv(localat1.field_flag & 0x0 | parambu.field_createTime & 0xFFFFFFFF);
    if (i != 0)
    {
      e(localat1);
      AppMethodBeat.o(117080);
      return;
    }
    a(localat1, str, true);
    AppMethodBeat.o(117080);
  }
  
  public final boolean aSH()
  {
    AppMethodBeat.i(117128);
    if ((this.db == null) || (this.db.fmj()))
    {
      if (this.db == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.db.fmj()))
      {
        ad.w("MicroMsg.ConversationStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(117128);
        return false;
      }
    }
    AppMethodBeat.o(117128);
    return true;
  }
  
  public final void aTA(String paramString)
  {
    AppMethodBeat.i(117085);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, "username=?", new String[] { paramString });
    AppMethodBeat.o(117085);
  }
  
  public final boolean aTB(String paramString)
  {
    AppMethodBeat.i(117086);
    if ((paramString == null) || (paramString.length() <= 0)) {
      ad.e("MicroMsg.ConversationStorage", "update conversation failed");
    }
    int i;
    do
    {
      AppMethodBeat.o(117086);
      return false;
      ad.d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", new Object[] { paramString });
      Object localObject = aTz(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(117086);
        return true;
      }
      if ((((ba)localObject).field_unReadCount == 0) && (((ba)localObject).field_unReadMuteCount == 0) && (paramString.equals(((ba)localObject).field_username)))
      {
        a(paramString, 1048576, false, ((ba)localObject).field_attrflag);
        localObject = new ContentValues();
        ((ContentValues)localObject).put("UnReadInvite", Integer.valueOf(0));
        ((ContentValues)localObject).put("atCount", Integer.valueOf(0));
        if (this.db.update(Fu(paramString), (ContentValues)localObject, "username= ?", new String[] { bt.aQN(paramString) }) > 0) {
          b(3, this, paramString);
        }
        AppMethodBeat.o(117086);
        return true;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("unReadCount", Integer.valueOf(0));
      localContentValues.put("unReadMuteCount", Integer.valueOf(0));
      localContentValues.put("UnReadInvite", Integer.valueOf(0));
      localContentValues.put("atCount", Integer.valueOf(0));
      localContentValues.put("attrflag", Integer.valueOf(((ba)localObject).field_attrflag & 0xFFEFFFFF));
      i = this.db.update(Fu(paramString), localContentValues, "username= ?", new String[] { bt.aQN(paramString) });
      if (i > 0) {
        b(3, this, paramString);
      }
    } while (i <= 0);
    AppMethodBeat.o(117086);
    return true;
  }
  
  public final boolean aTC(String paramString)
  {
    AppMethodBeat.i(117087);
    if (paramString.length() <= 0)
    {
      ad.e("MicroMsg.ConversationStorage", "update updateUnreadByParentRef failed");
      AppMethodBeat.o(117087);
      return false;
    }
    ad.d("MicroMsg.ConversationStorage", "updateUnreadByParentRef %s", new Object[] { paramString });
    at localat = aTz(paramString);
    if (localat == null)
    {
      AppMethodBeat.o(117087);
      return true;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("unReadCount", Integer.valueOf(0));
    localContentValues.put("unReadMuteCount", Integer.valueOf(0));
    localContentValues.put("UnReadInvite", Integer.valueOf(0));
    localContentValues.put("atCount", Integer.valueOf(0));
    localContentValues.put("attrflag", Integer.valueOf(localat.field_attrflag & 0xFFEFFFFF));
    int i = this.db.update(Fu(paramString), localContentValues, "parentRef= ?", new String[] { bt.aQN(paramString) });
    if (i > 0) {
      b(3, this, paramString);
    }
    if (i > 0)
    {
      AppMethodBeat.o(117087);
      return true;
    }
    AppMethodBeat.o(117087);
    return false;
  }
  
  public final boolean aTD(String paramString)
  {
    AppMethodBeat.i(117088);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(117088);
      return false;
    }
    at localat = aTz(paramString);
    if ((localat == null) || ((localat.field_unReadCount > 0) && (paramString.equals(localat.field_username))))
    {
      AppMethodBeat.o(117088);
      return true;
    }
    boolean bool = this.db.execSQL("rconversation", "update " + Fu(paramString) + " set unReadCount = 1, atCount = 0, attrflag = " + (localat.field_attrflag | 0x100000) + " where username = \"" + bt.aQN(paramString) + "\"");
    if (bool) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(117088);
    return bool;
  }
  
  public final boolean aTE(String paramString)
  {
    AppMethodBeat.i(117094);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
      AppMethodBeat.o(117094);
      return false;
    }
    paramString = aTz(paramString);
    if (paramString == null)
    {
      ad.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
      AppMethodBeat.o(117094);
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1 = 0L;
    Cursor localCursor = this.db.a("select max(conversationTime) as conversationTime from rconversation", null, 2);
    while (localCursor.moveToNext()) {
      l1 = localCursor.getLong(0);
    }
    localCursor.close();
    ad.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", new Object[] { Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
    long l3 = cf.aCK();
    l2 = l1;
    if (l1 > l3)
    {
      ad.w("MicroMsg.ConversationStorage", "conversationTime=%s serverTime=%s diff=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 - l1) });
      l2 = l3;
    }
    l1 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 1, l2 + 1L);
    boolean bool = this.db.execSQL("rconversation", "update " + Fu(paramString.field_username) + " set flag = " + l1 + " where username = \"" + bt.aQN(paramString.field_username) + "\"");
    ad.i("MicroMsg.ConversationStorage", "[setMoveUp] flag=%s result=%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool) });
    if (bool) {
      b(3, this, paramString.field_username);
    }
    AppMethodBeat.o(117094);
    return bool;
  }
  
  public final boolean aTF(String paramString)
  {
    AppMethodBeat.i(117095);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
      AppMethodBeat.o(117095);
      return false;
    }
    if (aTz(paramString) == null)
    {
      at localat = new at(paramString);
      localat.qu(System.currentTimeMillis());
      e(localat);
      ad.i("MicroMsg.ConversationStorage", "setPlacedTop username = ".concat(String.valueOf(paramString)));
    }
    paramString = aTz(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117095);
      return false;
    }
    long l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 2, 0L);
    boolean bool = this.db.execSQL("rconversation", "update " + Fu(paramString.field_username) + " set flag = " + l + " where username = \"" + bt.aQN(paramString.field_username) + "\"");
    ad.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      b(3, this, paramString.field_username);
    }
    AppMethodBeat.o(117095);
    return bool;
  }
  
  public final boolean aTG(String paramString)
  {
    AppMethodBeat.i(117096);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
      AppMethodBeat.o(117096);
      return false;
    }
    boolean bool = g(aTz(paramString));
    AppMethodBeat.o(117096);
    return bool;
  }
  
  public final boolean aTH(String paramString)
  {
    AppMethodBeat.i(117098);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
      AppMethodBeat.o(117098);
      return false;
    }
    boolean bool = h(aTz(paramString));
    AppMethodBeat.o(117098);
    return bool;
  }
  
  public final Cursor aTI(String paramString)
  {
    AppMethodBeat.i(117106);
    paramString = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + bt.nullAsNil(paramString) + " order by flag desc, conversationTime desc";
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(117106);
    return paramString;
  }
  
  public final Cursor aTJ(String paramString)
  {
    AppMethodBeat.i(217603);
    ad.i("MicroMsg.ConversationStorage", "getUnreadConversationCursor filter[%s] [%s]", new Object[] { paramString, bt.flS() });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT rconversation.username, ");
    localStringBuilder.append("rconversation.unReadCount, ");
    localStringBuilder.append("rconversation.conversationTime");
    localStringBuilder.append(" from rconversation where unReadCount > 0 AND (parentRef is ").append(com.tencent.mm.p.a.gfl).append(" or parentRef = '' ) ").append(bt.nullAsNil(paramString));
    paramString = localStringBuilder.toString();
    ad.i("MicroMsg.ConversationStorage", "get unread conversation with black list, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(217603);
    return paramString;
  }
  
  public final Cursor aTK(String paramString)
  {
    AppMethodBeat.i(217604);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT rcontact.* FROM rcontact,rconversation");
    localStringBuilder.append(" WHERE unReadCount > 0 AND (parentRef is ").append(com.tencent.mm.p.a.gfl).append(" or parentRef = '' ) ");
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(bt.nullAsNil(paramString));
    localStringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
    paramString = localStringBuilder.toString();
    ad.i("MicroMsg.ConversationStorage", "get total unread contact with black list, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(217604);
    return paramString;
  }
  
  public final int aTL(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117119);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM rconversation");
    localStringBuilder.append(" WHERE parentRef = '").append(paramString).append("'");
    paramString = localStringBuilder.toString();
    ad.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", new Object[] { paramString });
    paramString = this.db.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(117119);
    return i;
  }
  
  public final String aTM(String paramString)
  {
    AppMethodBeat.i(117120);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = '").append(paramString).append("'");
    ((StringBuilder)localObject).append(" ORDER BY conversationTime DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    paramString = ((StringBuilder)localObject).toString();
    ad.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", new Object[] { paramString });
    paramString = this.db.a(paramString, null, 2);
    if (paramString != null)
    {
      if (paramString.moveToFirst())
      {
        localObject = paramString.getString(0);
        paramString.close();
        AppMethodBeat.o(117120);
        return localObject;
      }
      paramString.close();
    }
    AppMethodBeat.o(117120);
    return null;
  }
  
  public final at aTN(String paramString)
  {
    AppMethodBeat.i(117124);
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().c(w.hFd, null, paramString);
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        paramString = new at();
        paramString.convertFrom(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117124);
      return paramString;
      paramString = null;
      break;
      paramString = null;
    }
  }
  
  public final int aTO(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117126);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(atCount) from rconversation");
    localStringBuilder.append(" where unReadCount > 0");
    if (!bt.isNullOrNil(paramString)) {
      localStringBuilder.append(" and username = '").append(paramString).append("'");
    }
    paramString = localStringBuilder.toString();
    ad.d("MicroMsg.ConversationStorage", "query sql: %s", new Object[] { paramString });
    paramString = this.db.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(117126);
    return i;
  }
  
  public final void aTP(String paramString)
  {
    AppMethodBeat.i(117129);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Update rconversation");
    ((StringBuilder)localObject).append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + bt.aQN(paramString) + "\"");
    localObject = ((StringBuilder)localObject).toString();
    ad.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", new Object[] { localObject });
    if (this.db.execSQL("rconversation", (String)localObject)) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(117129);
  }
  
  public final void aTQ(String paramString)
  {
    AppMethodBeat.i(117130);
    int i = this.db.delete(Fu(paramString), "username=? or parentRef =?", new String[] { paramString, paramString });
    ad.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i != 0) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(117130);
  }
  
  public final int aTR(String paramString)
  {
    int i = -1;
    AppMethodBeat.i(117131);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117131);
      return -1;
    }
    paramString = "select msgCount from rconversation where username=" + h.wo(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117131);
    return i;
  }
  
  public final void aTx(String paramString)
  {
    AppMethodBeat.i(117076);
    ad.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", new Object[] { paramString, com.tencent.mm.sdk.platformtools.at.fkW() });
    if (this.db.delete(Fu(paramString), "username=?", new String[] { paramString }) != 0) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(117076);
  }
  
  public final boolean aTy(String paramString)
  {
    AppMethodBeat.i(117078);
    ad.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[] { paramString, com.tencent.mm.sdk.platformtools.at.fkW() });
    boolean bool = this.db.execSQL("rconversation", "delete from " + Fu(paramString) + " where username like '%" + paramString + "'");
    if (bool) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(117078);
    return bool;
  }
  
  public final at aTz(String paramString)
  {
    AppMethodBeat.i(117079);
    Cursor localCursor = this.db.a(Fu(paramString), null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ad.w("MicroMsg.ConversationStorage", "get null with username:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(117079);
      return null;
    }
    paramString = new at();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117079);
    return paramString;
  }
  
  public final boolean aki(String paramString)
  {
    AppMethodBeat.i(117111);
    paramString = this.db.a(Fu(paramString), null, "username=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.close();
      AppMethodBeat.o(117111);
      return bool;
    }
  }
  
  public final void b(i parami, i.c paramc)
  {
    AppMethodBeat.i(117074);
    if (paramc == null)
    {
      ad.f("MicroMsg.ConversationStorage", "null notifyInfo");
      AppMethodBeat.o(117074);
      return;
    }
    if ((w.zy(paramc.talker)) || (w.zz(paramc.talker)))
    {
      AppMethodBeat.o(117074);
      return;
    }
    Object localObject1 = paramc.talker;
    bu localbu = parami.apX((String)localObject1);
    parami = new boolean[1];
    parami[0] = 0;
    this.IKn.a(localbu, paramc, parami);
    if (parami[0] != 0)
    {
      AppMethodBeat.o(117074);
      return;
    }
    parami = aTz((String)localObject1);
    if (parami == null)
    {
      ad.i("MicroMsg.ConversationStorage", "create new cvs:%s", new Object[] { localObject1 });
      parami = new at((String)localObject1);
      if (am.zs((String)localObject1)) {
        parami.kq(1);
      }
      if ((localbu != null) && (!bt.isNullOrNil(localbu.eLs)))
      {
        localObject1 = bj.Bq(localbu.eLs);
        if ((localObject1 != null) && ((((bj.b)localObject1).hGT & 0x40) != 0L))
        {
          ad.w("MicroMsg.ConversationStorage", "not fas msg no need to create conversation");
          AppMethodBeat.o(117074);
          return;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.IKn.a(localbu, parami, bool, paramc);
      ad.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d", new Object[] { paramc.talker, paramc.vKe, Integer.valueOf(paramc.scY) });
      ad.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d ", new Object[] { paramc.talker, paramc.vKe, Integer.valueOf(paramc.scY) });
      long l1;
      long l2;
      if ((localbu != null) && (localbu.field_msgId != 0L))
      {
        if ((paramc.scY == 1) && (((bu)paramc.gNE.get(0)).field_msgId != localbu.field_msgId)) {
          ad.w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", new Object[] { Long.valueOf(localbu.field_msgId), Long.valueOf(((bu)paramc.gNE.get(0)).field_msgId) });
        }
        i = localbu.field_flag;
        l1 = parami.field_lastSeq;
        l2 = localbu.field_msgSeq;
        ad.i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(parami.field_UnDeliverCount) });
        if (((!paramc.vKe.equals("insert")) || (paramc.scY <= 0)) && ((!paramc.vKe.equals("update")) || (parami.field_unReadCount + paramc.scY < 0))) {
          break label661;
        }
        parami.kp(parami.field_unReadCount + paramc.scY);
        if (l2 > l1)
        {
          ad.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", new Object[] { Long.valueOf(l2) });
          parami.qw(l2);
        }
        if ((localbu.cxh()) && (localbu.field_isSend == 1))
        {
          parami.field_sightTime = localbu.field_createTime;
          parami.eQo = true;
        }
      }
      Object localObject2;
      Object localObject3;
      if ((paramc.vKe.equals("insert")) && (paramc.gNE.size() > 0) && (w.vF(paramc.talker)))
      {
        localObject1 = u.aAm();
        localObject2 = paramc.gNE.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label952;
          }
          localObject3 = (bu)((Iterator)localObject2).next();
          if (localObject3 == null)
          {
            ad.e("MicroMsg.ConversationStorage", "[onMsgInfoStgNotifyChange] msgInfo is null.");
            continue;
            label661:
            if ((paramc.vKg <= 0) || (l2 >= l1) || (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aJ(parami.field_username, l1).field_msgId != 0L)) {
              break;
            }
            long l3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aqr(parami.field_username);
            ad.i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
            parami.qw(l2);
            if (l1 <= l3) {
              break;
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azS().aF(parami.field_username, l3);
            break;
          }
          if (((ei)localObject3).field_isSend != 1) {
            if (!((bu)localObject3).isText())
            {
              if (((bu)localObject3).getType() != 503316529) {
                break label901;
              }
              i = 1;
              label843:
              if (i == 0) {}
            }
            else
            {
              if (!((bu)localObject3).aUa((String)localObject1)) {
                break label906;
              }
              parami.ku(parami.field_atCount + 1);
            }
          }
          for (;;)
          {
            localObject3 = bw.M(((ei)localObject3).field_content, "sysmsg");
            if (!bu.bR((Map)localObject3)) {
              break label929;
            }
            parami.kx(parami.field_UnReadInvite + 1);
            break;
            label901:
            i = 0;
            break label843;
            label906:
            if (((bu)localObject3).fso()) {
              parami.ku(parami.field_atCount + 4096);
            }
          }
          label929:
          if (bu.bS((Map)localObject3)) {
            parami.kx(parami.field_UnReadInvite + 4096);
          }
        }
      }
      label952:
      int k = 0;
      int i = 0;
      if (paramc != null) {}
      for (localObject1 = paramc.talker;; localObject1 = null)
      {
        int j = k;
        if (paramc != null)
        {
          j = k;
          if (paramc.vKe != null)
          {
            j = k;
            if (paramc.vKe.equals("delete"))
            {
              if (paramc.vKg > 0) {
                i = paramc.vKg;
              }
              ad.i("MicroMsg.ConversationStorage", "notify delete count %d ", new Object[] { Integer.valueOf(paramc.vKg) });
              j = i;
            }
          }
        }
        if ((paramc != null) && (paramc.vKe != null) && (paramc.vKe.equals("insert"))) {
          if (paramc.vKf > 0)
          {
            i = paramc.vKf;
            ad.i("MicroMsg.ConversationStorage", "notify insert all count %d ", new Object[] { Integer.valueOf(paramc.vKf) });
          }
        }
        for (;;)
        {
          localObject2 = bt.bI((String)localObject1, "");
          if (localbu != null) {}
          for (l1 = localbu.field_msgSeq;; l1 = -1L)
          {
            ad.i("MicroMsg.ConversationStorage", "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d], ParentRef[%s]", new Object[] { localObject2, Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Thread.currentThread().getId()), parami.field_parentRef });
            if ((!bool) || (j <= 0) || (i != 0)) {
              break;
            }
            ad.i("MicroMsg.ConversationStorage", "summerdel ignore delete event [%s, %s]", new Object[] { localObject1, parami.field_username });
            AppMethodBeat.o(117074);
            return;
          }
          this.IKo.dV(parami);
          this.IKo.doNotify();
          if (localObject1 == null)
          {
            ad.e("MicroMsg.ConversationStorage", "talker == null");
            AppMethodBeat.o(117074);
            return;
          }
          if (!((String)localObject1).equals(parami.field_username))
          {
            ad.e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
            AppMethodBeat.o(117074);
            return;
          }
          if ((localbu != null) && (localbu.field_msgId != 0L))
          {
            ad.v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + localbu.field_msgId);
            parami.aL(localbu);
            if (this.IKl != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              PInt localPInt = new PInt();
              this.IKl.a(localbu, (PString)localObject2, (PString)localObject3, localPInt, parami.lQ(2097152));
              ad.d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", new Object[] { ((PString)localObject3).value });
              parami.tB(((PString)localObject2).value);
              parami.tC(((PString)localObject3).value);
              parami.ks(localPInt.value);
              parami.tA(Integer.toString(localbu.getType()));
              if (this.IKm != null) {
                this.IKm.a(localbu, parami);
              }
              parami.qv(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(parami, 1, localbu.field_createTime));
              if (!bool) {
                break label1718;
              }
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf((String)localObject1);
              if ((localObject1 != null) && (!bt.isNullOrNil(((aw)localObject1).field_username)) && (((am)localObject1).adq())) {
                parami.qv(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(parami, 2, 0L));
              }
              a(parami, j, i);
              if (localbu.field_createTime == 0L) {
                break label1708;
              }
              parami.qu(localbu.field_createTime);
              label1590:
              e(parami);
            }
          }
          label1708:
          label1718:
          label1783:
          do
          {
            for (;;)
            {
              this.IKp.dV(parami);
              this.IKp.doNotify();
              this.IKn.b(localbu, parami, bool, paramc);
              AppMethodBeat.o(117074);
              return;
              localObject2 = cP(localbu.getType(), parami.field_content);
              localObject3 = bt.nullAsNil(parami.field_digest);
              if (bt.isNullOrNil((String)localObject2)) {}
              for (localObject2 = "";; localObject2 = " " + bt.nullAsNil((String)localObject2))
              {
                parami.tB(((String)localObject3).concat((String)localObject2));
                break;
              }
              parami.qu(cf.aCK());
              break label1590;
              a(parami, j, i);
              a(parami, (String)localObject1, true);
              continue;
              ad.i("MicroMsg.ConversationStorage", "update null conversation with talker ".concat(String.valueOf(localObject1)));
              if (bool) {
                break label1783;
              }
              parami.fqK();
              a(parami, j, i);
              a(parami, (String)localObject1, true);
            }
          } while (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aqm((String)localObject1) <= 0);
          if ((localbu != null) && (localbu.field_createTime != 0L)) {
            parami.qu(localbu.field_createTime);
          }
          for (;;)
          {
            a(parami, j, i);
            e(parami);
            break;
            parami.qu(cf.aCK());
          }
          i = 0;
          break;
          i = 0;
        }
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.messenger.foundation.a.g paramg)
  {
    AppMethodBeat.i(217600);
    this.IKn.remove(paramg);
    AppMethodBeat.o(217600);
  }
  
  public final void b(bq.a parama)
  {
    AppMethodBeat.i(117071);
    this.IKp.remove(parama);
    AppMethodBeat.o(117071);
  }
  
  public final void bm(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(117107);
    ad.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", new Object[] { com.tencent.mm.sdk.platformtools.at.fkW() });
    if (paramLinkedList.isEmpty())
    {
      ad.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
      AppMethodBeat.o(117107);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = (String)paramLinkedList.poll();
    localStringBuilder.append("delete from rconversation where ");
    localStringBuilder.append("username='").append(str).append('\'');
    while (!paramLinkedList.isEmpty())
    {
      str = (String)paramLinkedList.poll();
      localStringBuilder.append(" or username='").append(str).append('\'');
    }
    ad.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", new Object[] { localStringBuilder.toString() });
    this.db.execSQL("rconversation", localStringBuilder.toString());
    AppMethodBeat.o(117107);
  }
  
  public final Cursor c(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(117100);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from rconversation where ");
    if (com.tencent.mm.p.a.gfl == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bt.nullAsNil(paramString1));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (String)paramString1.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramList).append("'");
      }
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(bt.aQN(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc, conversationTime desc");
    paramString1 = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(117100);
    return paramString1;
  }
  
  public final void c(bq.a parama)
  {
    AppMethodBeat.i(117072);
    this.IKo.a(parama, null);
    AppMethodBeat.o(117072);
  }
  
  public final void c(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(117125);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Update rconversation");
    localStringBuilder.append(" set parentRef = '").append(bt.nullAsNil(paramString)).append("' where 1 != 1 ");
    int i = 0;
    while (i <= 0)
    {
      paramString = paramArrayOfString[0];
      localStringBuilder.append(" or username = '").append(paramString).append("'");
      i += 1;
    }
    paramString = localStringBuilder.toString();
    ad.d("MicroMsg.ConversationStorage", "update sql: %s", new Object[] { paramString });
    if (this.db.execSQL("rconversation", paramString))
    {
      i = 0;
      while (i <= 0)
      {
        b(3, this, paramArrayOfString[0]);
        i += 1;
      }
    }
    AppMethodBeat.o(117125);
  }
  
  public final String cP(int paramInt, String paramString)
  {
    AppMethodBeat.i(117127);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bt.isNullOrNil(paramString)) {
      switch (paramInt)
      {
      default: 
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117127);
      return localObject1;
      paramString = bw.M(paramString, "msg");
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = (String)paramString.get(".msg.appmsg.title");
        ad.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { localObject1 });
      }
    }
  }
  
  public final void d(bq.a parama)
  {
    AppMethodBeat.i(117073);
    this.IKo.remove(parama);
    AppMethodBeat.o(117073);
  }
  
  public final long e(at paramat)
  {
    AppMethodBeat.i(117082);
    String str = bt.nullAsNil(paramat.field_username);
    if (str.length() <= 0)
    {
      ad.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
      AppMethodBeat.o(117082);
      return -1L;
    }
    paramat.qv(d(paramat));
    f(paramat);
    long l = this.db.insert(Fu(str), null, paramat.convertTo());
    if (l != -1L) {
      b(2, this, paramat.field_username);
    }
    for (;;)
    {
      AppMethodBeat.o(117082);
      return l;
      ad.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", new Object[] { Fu(str) });
    }
  }
  
  public final Cursor f(List<String> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117109);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramList = "select username from rconversation";
    int i = 0;
    if (i < ((List)localObject).size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(paramList);
      if (i > 0) {}
      for (paramList = " and ";; paramList = " where ")
      {
        paramList = paramList + "username != \"" + bt.aQN((String)((List)localObject).get(i)) + "\"";
        i += 1;
        break;
      }
    }
    paramList = paramList + " order by flag desc, conversationTime desc limit " + paramInt2 + " offset " + paramInt1;
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117109);
    return paramList;
  }
  
  public final boolean fqL()
  {
    AppMethodBeat.i(117077);
    boolean bool1 = this.db.execSQL("rconversation", "delete from rconversation");
    boolean bool2 = this.db.execSQL("rconversation", "delete from rbottleconversation");
    if ((bool1) || (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      if (bool1) {
        b(5, this, "");
      }
      AppMethodBeat.o(117077);
      return bool1;
    }
  }
  
  public final HashMap<String, Long> fqM()
  {
    AppMethodBeat.i(117081);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    Cursor localCursor = this.db.a("rconversation", new String[] { "username", "conversationTime" }, null, null, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(117081);
      return localHashMap;
    }
    int i;
    if (localCursor == null) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label167;
      }
      localHashMap.put(localCursor.getString(0), Long.valueOf(localCursor.getLong(1)));
      localCursor.moveToNext();
      break;
      if ((localCursor.isClosed()) || (localCursor.isBeforeFirst()) || (localCursor.isAfterLast())) {
        i = 0;
      } else {
        i = 1;
      }
    }
    label167:
    localCursor.close();
    ad.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(117081);
    return localHashMap;
  }
  
  public final void fqN()
  {
    AppMethodBeat.i(117084);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, null, null);
    AppMethodBeat.o(117084);
  }
  
  public final List<String> fqO()
  {
    AppMethodBeat.i(117101);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select rconversation.username from rconversation,rcontact where ");
    ((StringBuilder)localObject).append("rconversation.username = rcontact.username");
    ((StringBuilder)localObject).append(bt.nullAsNil(bt.nullAsNil(w.hFd)));
    ((StringBuilder)localObject).append(" and ( verifyFlag & 8 ) = 0");
    ((StringBuilder)localObject).append(" and ( rconversation.parentRef is null  or rconversation.parentRef = '' ) ");
    String[] arrayOfString = w.hFm;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ((StringBuilder)localObject).append(" and rconversation.username != '").append(str).append("'");
      i += 1;
    }
    ((StringBuilder)localObject).append(" order by sightTime desc, flag desc, conversationTime desc");
    localObject = this.db.a(((StringBuilder)localObject).toString(), null, 2);
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        do
        {
          localArrayList.add(((Cursor)localObject).getString(0));
        } while (((Cursor)localObject).moveToNext());
      }
      ((Cursor)localObject).close();
    }
    ad.d("MicroMsg.ConversationStorage", "user list:%s", new Object[] { localArrayList });
    AppMethodBeat.o(117101);
    return localArrayList;
  }
  
  public final List<String> fqP()
  {
    AppMethodBeat.i(117108);
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localObject = F(" where username", (List)localObject);
    localObject = "select username from rconversation" + (String)localObject;
    localObject = (String)localObject + " order by flag desc, conversationTime desc";
    ad.i("MicroMsg.ConversationStorage", "getAllConvUserName sql %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null);
    int i = ((Cursor)localObject).getColumnIndex("username");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117108);
    return localArrayList;
  }
  
  public final Cursor fqQ()
  {
    AppMethodBeat.i(117110);
    Cursor localCursor = this.db.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    AppMethodBeat.o(117110);
    return localCursor;
  }
  
  public final int fqR()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117117);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT SUM(rconversation.unReadCount)");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    localObject = ((StringBuilder)localObject).toString();
    ad.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", new Object[] { localObject });
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      i = j;
      if (((Cursor)localObject).moveToFirst()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(117117);
    return i;
  }
  
  public final String fqS()
  {
    AppMethodBeat.i(117118);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    ((StringBuilder)localObject).append(" ORDER BY flag DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    localObject = ((StringBuilder)localObject).toString();
    ad.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", new Object[] { localObject });
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst())
      {
        String str = ((Cursor)localObject).getString(0);
        ((Cursor)localObject).close();
        AppMethodBeat.o(117118);
        return str;
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(117118);
    return null;
  }
  
  public final Cursor fqT()
  {
    AppMethodBeat.i(117121);
    ad.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", new Object[] { "select count(*) from rbottleconversation where unReadCount > 0" });
    Cursor localCursor = this.db.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
    AppMethodBeat.o(117121);
    return localCursor;
  }
  
  public final at fqU()
  {
    AppMethodBeat.i(117123);
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().c(w.hFd, null, "officialaccounts");
    at localat;
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        localat = new at();
        localat.convertFrom(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117123);
      return localat;
      localat = null;
      break;
      localat = null;
    }
  }
  
  public final Cursor fqV()
  {
    AppMethodBeat.i(117132);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username, ");
    ((StringBuilder)localObject).append("rconversation.unReadCount");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE unReadCount > 0");
    ((StringBuilder)localObject).append(" AND ( parentRef is ").append(com.tencent.mm.p.a.gfl).append(" or parentRef = '' ) ");
    localObject = this.db.rawQuery(((StringBuilder)localObject).toString(), null);
    AppMethodBeat.o(117132);
    return localObject;
  }
  
  public final boolean g(at paramat)
  {
    AppMethodBeat.i(117097);
    if (paramat == null)
    {
      ad.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
      AppMethodBeat.o(117097);
      return false;
    }
    long l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramat, 3, paramat.field_conversationTime);
    boolean bool = this.db.execSQL("rconversation", "update " + Fu(paramat.field_username) + " set flag = " + l + " where username = \"" + bt.aQN(paramat.field_username) + "\"");
    ad.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      b(3, this, paramat.field_username);
    }
    AppMethodBeat.o(117097);
    return bool;
  }
  
  public final boolean h(at paramat)
  {
    AppMethodBeat.i(117099);
    if (paramat == null)
    {
      ad.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
      AppMethodBeat.o(117099);
      return false;
    }
    if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramat, 4, 0L) != 0L)
    {
      AppMethodBeat.o(117099);
      return true;
    }
    AppMethodBeat.o(117099);
    return false;
  }
  
  public final Cursor lY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117113);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount");
    localStringBuilder.append(" from rconversation where username = '").append(paramString1).append("' AND ( parentRef is ").append(com.tencent.mm.p.a.gfl).append(" or parentRef = '' ) ").append(bt.nullAsNil(paramString2));
    paramString1 = localStringBuilder.toString();
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(117113);
    return paramString1;
  }
  
  static final class a
    extends com.tencent.mm.cn.a<com.tencent.mm.plugin.messenger.foundation.a.g>
    implements com.tencent.mm.plugin.messenger.foundation.a.g
  {
    public final void a(final bu parambu, final i.c paramc, final boolean[] paramArrayOfBoolean)
    {
      AppMethodBeat.i(217599);
      a(new a.a() {});
      AppMethodBeat.o(217599);
    }
    
    public final void a(final bu parambu, final at paramat, final boolean paramBoolean, final i.c paramc)
    {
      AppMethodBeat.i(117065);
      a(new a.a() {});
      AppMethodBeat.o(117065);
    }
    
    public final void b(final bu parambu, final at paramat, final boolean paramBoolean, final i.c paramc)
    {
      AppMethodBeat.i(117066);
      a(new a.a() {});
      AppMethodBeat.o(117066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.au
 * JD-Core Version:    0.7.0.1
 */