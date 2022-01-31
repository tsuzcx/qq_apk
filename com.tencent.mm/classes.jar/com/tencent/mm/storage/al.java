package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class al
  extends n
  implements be
{
  public static final String[] SQL_CREATE;
  private final com.tencent.mm.sdk.e.e db;
  private be.b yMr;
  private com.tencent.mm.plugin.messenger.foundation.a.e yMs;
  private al.a yMt;
  private l<be.a, ak> yMu;
  private l<be.a, ak> yMv;
  
  static
  {
    AppMethodBeat.i(1265);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.o.a.info, "rconversation"), com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.o.a.info, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "DROP INDEX IF EXISTS rconversation_unreadcount_index ", "DROP INDEX IF EXISTS multi_index ", "CREATE INDEX IF NOT EXISTS rconversation_multi_index ON  rconversation ( unReadCount,parentRef )", "CREATE INDEX IF NOT EXISTS rconversation_parentref_index ON  rconversation ( parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )" };
    AppMethodBeat.o(1265);
  }
  
  public al(com.tencent.mm.sdk.e.e parame)
  {
    AppMethodBeat.i(1199);
    this.yMt = new al.a((byte)0);
    this.yMu = new al.1(this);
    this.yMv = new l() {};
    Assert.assertTrue(parame instanceof com.tencent.mm.cg.h);
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
      localObject = com.tencent.mm.sdk.e.j.getUpdateSQLs(com.tencent.mm.o.a.info, "rconversation", parame);
      ((List)localObject).addAll(com.tencent.mm.sdk.e.j.getUpdateSQLs(com.tencent.mm.o.a.info, "rbottleconversation", parame));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        parame.execSQL("rconversation", (String)((Iterator)localObject).next());
      }
      if (i == 0) {
        parame.execSQL("rconversation", "update rconversation set flag = conversationTime");
      }
      this.db = parame;
      AppMethodBeat.o(1199);
      return;
    }
  }
  
  private static String A(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(1236);
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
          localObject = new StringBuilder().append(paramString).append("\"").append(bo.wC((String)paramList.get(i))).append("\"");
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
    AppMethodBeat.o(1236);
    return localObject;
  }
  
  private static String arE(String paramString)
  {
    AppMethodBeat.i(1200);
    ab.v("MicroMsg.ConversationStorage", "talker :".concat(String.valueOf(paramString)));
    if (ad.nM(paramString))
    {
      AppMethodBeat.o(1200);
      return "rbottleconversation";
    }
    AppMethodBeat.o(1200);
    return "rconversation";
  }
  
  private static long c(ak paramak)
  {
    AppMethodBeat.i(1207);
    if (paramak != null)
    {
      l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramak, paramak.field_conversationTime);
      AppMethodBeat.o(1207);
      return l;
    }
    long l = bo.aoy();
    AppMethodBeat.o(1207);
    return l & 0xFFFFFFFF;
  }
  
  private long dxg()
  {
    AppMethodBeat.i(1225);
    long l2 = System.currentTimeMillis();
    long l1 = 0L;
    Cursor localCursor = this.db.a("select max(conversationTime) as conversationTime from rconversation", null, 2);
    while (localCursor.moveToNext()) {
      l1 = localCursor.getLong(0);
    }
    localCursor.close();
    ab.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", new Object[] { Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
    AppMethodBeat.o(1225);
    return l1;
  }
  
  private static void e(ak paramak)
  {
    AppMethodBeat.i(1224);
    if (paramak == null)
    {
      AppMethodBeat.o(1224);
      return;
    }
    if (paramak.field_unReadCount > 0)
    {
      ab.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
      if ((paramak.field_attrflag & 0x100000) != 0)
      {
        paramak.hJ(paramak.field_unReadCount - 1);
        paramak.hN(paramak.field_attrflag & 0xFFEFFFFF);
      }
    }
    AppMethodBeat.o(1224);
  }
  
  public final Cursor B(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(1246);
    ab.i("MicroMsg.ConversationStorage", "getTotalUnreadCursor filter[%s] [%s]", new Object[] { paramString, bo.dtY() });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(unReadCount) from rconversation, rcontact");
    localStringBuilder.append(" where rconversation.unReadCount > 0 AND (rconversation.parentRef is ").append(com.tencent.mm.o.a.euH).append(" or parentRef = '' ) AND rconversation.username = rcontact.username").append(bo.nullAsNil(paramString)).append(" AND ( type & 512 ) == 0");
    localStringBuilder.append(" AND rcontact.username != 'officialaccounts'");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        localStringBuilder.append(" AND rconversation.username != '").append(paramList).append("'");
      }
    }
    paramString = localStringBuilder.toString();
    ab.v("MicroMsg.ConversationStorage", "get total unread with black list, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(1246);
    return paramString;
  }
  
  public final be.b BX()
  {
    return this.yMr;
  }
  
  public final Cursor C(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(139746);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(rconversation.username)");
    localStringBuilder.append(" FROM rconversation, rcontact");
    localStringBuilder.append(" WHERE unReadCount > 0");
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(bo.nullAsNil(paramString));
    localStringBuilder.append(" AND ( type & 512 ) == 0");
    localStringBuilder.append(" AND ( attrflag & 2097152 ) == 0");
    localStringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.o.a.euH).append(" or parentRef = '' ) ");
    localStringBuilder.append(" AND rcontact.username != 'officialaccounts')");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        localStringBuilder.append(" AND rconversation.username != '").append(paramList).append("'");
      }
    }
    paramString = localStringBuilder.toString();
    ab.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(139746);
    return paramString;
  }
  
  public final boolean OU(String paramString)
  {
    AppMethodBeat.i(1243);
    paramString = this.db.a(arE(paramString), null, "username=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.close();
      AppMethodBeat.o(1243);
      return bool;
    }
  }
  
  public final int a(ak paramak, String paramString)
  {
    AppMethodBeat.i(156735);
    int i = a(paramak, paramString, true);
    AppMethodBeat.o(156735);
    return i;
  }
  
  public final int a(ak paramak, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(1223);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(1223);
      return 0;
    }
    if (paramBoolean) {
      paramak.fL(c(paramak));
    }
    e(paramak);
    int i = this.db.update(arE(paramString), paramak.convertTo(), "username=?", new String[] { paramString });
    if (i != 0) {
      b(3, this, paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(1223);
      return i;
      ab.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", new Object[] { arE(paramString) });
    }
  }
  
  public final Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(1234);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.o.a.euH == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bo.nullAsNil(paramString1));
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
        localStringBuilder.append("parentRef = '").append(bo.wC(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc");
    ab.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + localStringBuilder.toString());
    paramString1 = this.db;
    paramList = localStringBuilder.toString();
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      paramString1 = paramString1.a(paramList, null, i);
      AppMethodBeat.o(1234);
      return paramString1;
    }
  }
  
  public final Cursor a(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(1237);
    String str2 = " ";
    String str1 = str2;
    if (paramString2 != null)
    {
      str1 = str2;
      if (paramString2.length() > 0) {
        str1 = " and rconversation.username = rcontact.username ";
      }
    }
    paramString1 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + " " + " where rconversation.username = rcontact.username" + str1 + bo.nullAsNil(paramString1);
    paramList = A(" and rconversation.username", paramList);
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
      ab.d("MicroMsg.ConversationStorage", "getSearchCursor sql ".concat(String.valueOf(paramString1)));
      paramString1 = this.db.rawQuery(paramString1, null);
      AppMethodBeat.o(1237);
      return paramString1;
    }
  }
  
  public final Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(1235);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
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
    if (com.tencent.mm.o.a.euH == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bo.nullAsNil(paramString1));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramArrayList = paramList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString1 = (String)paramArrayList.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramString1).append("'");
      }
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(bo.wC(paramString2)).append("' ");
      }
    }
    ab.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(1235);
    return paramArrayList;
  }
  
  public final com.tencent.mm.vending.b.b a(f paramf)
  {
    AppMethodBeat.i(1201);
    paramf = this.yMt.at(paramf);
    AppMethodBeat.o(1201);
    return paramf;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.e parame)
  {
    this.yMs = parame;
  }
  
  public final void a(ak paramak, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1215);
    if (!bf.px(paramak.field_username))
    {
      AppMethodBeat.o(1215);
      return;
    }
    if (bo.nullAsNil(paramak.field_username).length() <= 0)
    {
      ab.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
      AppMethodBeat.o(1215);
      return;
    }
    if (paramak.field_msgCount == 0)
    {
      paramak.hI(bf.pw(paramak.field_username));
      ab.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      ab.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(paramak.field_msgCount), paramak.field_username, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(1215);
      return;
      if (paramInt1 > 0)
      {
        paramak.hI(paramak.field_msgCount - paramInt1);
        if (paramak.field_msgCount < 0)
        {
          ab.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
          paramak.hI(0);
        }
      }
      else if (paramInt2 > 0)
      {
        paramak.hI(paramak.field_msgCount + paramInt2);
      }
    }
  }
  
  public final void a(be.a parama)
  {
    AppMethodBeat.i(1202);
    this.yMv.a(parama, null);
    AppMethodBeat.o(1202);
  }
  
  public final void a(be.b paramb)
  {
    this.yMr = paramb;
  }
  
  public final boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(1221);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1221);
      return false;
    }
    if (arH(paramString) == null)
    {
      AppMethodBeat.o(1221);
      return true;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2 | paramInt1; paramInt1 == paramInt2; paramInt1 = (paramInt1 ^ 0xFFFFFFFF) & paramInt2)
    {
      AppMethodBeat.o(1221);
      return false;
    }
    paramBoolean = this.db.execSQL("rconversation", "update " + arE(paramString) + " set attrflag = " + paramInt1 + " where username = \"" + bo.wC(paramString) + "\"");
    if (paramBoolean) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(1221);
    return paramBoolean;
  }
  
  public final void aK(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(1239);
    ab.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", new Object[] { an.dth() });
    if (paramLinkedList.isEmpty())
    {
      ab.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
      AppMethodBeat.o(1239);
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
    ab.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", new Object[] { localStringBuilder.toString() });
    this.db.execSQL("rconversation", localStringBuilder.toString());
    AppMethodBeat.o(1239);
  }
  
  public final String ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(1259);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bo.isNullOrNil(paramString)) {
      switch (paramInt)
      {
      default: 
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(1259);
      return localObject1;
      paramString = br.F(paramString, "msg");
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = (String)paramString.get(".msg.appmsg.title");
        ab.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { localObject1 });
      }
    }
  }
  
  public final boolean aqj()
  {
    AppMethodBeat.i(1260);
    if ((this.db == null) || (this.db.dun()))
    {
      if (this.db == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.db.dun()))
      {
        ab.w("MicroMsg.ConversationStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(1260);
        return false;
      }
    }
    AppMethodBeat.o(1260);
    return true;
  }
  
  public final void ar(bi parambi)
  {
    AppMethodBeat.i(1212);
    String str = parambi.field_talker;
    int i = 0;
    ak localak2 = arH(str);
    if ((localak2 != null) && (localak2.field_conversationTime > parambi.field_createTime) && (localak2.field_conversationTime != 9223372036854775807L))
    {
      ab.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      AppMethodBeat.o(1212);
      return;
    }
    ak localak1 = localak2;
    if (localak2 == null)
    {
      localak1 = new ak(str);
      i = 1;
    }
    localak1.hL(parambi.field_isSend);
    localak1.hJ(localak1.field_unReadCount);
    localak1.aq(parambi);
    localak1.jV(Integer.toString(parambi.getType()));
    localak1.fL(localak1.field_flag & 0x0 | parambi.field_createTime & 0xFFFFFFFF);
    if (i != 0)
    {
      d(localak1);
      AppMethodBeat.o(1212);
      return;
    }
    a(localak1, str, true);
    AppMethodBeat.o(1212);
  }
  
  public final void arF(String paramString)
  {
    AppMethodBeat.i(1208);
    ab.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", new Object[] { paramString, an.dth() });
    if (this.db.delete(arE(paramString), "username=?", new String[] { paramString }) != 0) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(1208);
  }
  
  public final boolean arG(String paramString)
  {
    AppMethodBeat.i(1210);
    ab.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[] { paramString, an.dth() });
    boolean bool = this.db.execSQL("rconversation", "delete from " + arE(paramString) + " where username like '%" + paramString + "'");
    if (bool) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(1210);
    return bool;
  }
  
  public final ak arH(String paramString)
  {
    AppMethodBeat.i(1211);
    Cursor localCursor = this.db.a(arE(paramString), null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ab.w("MicroMsg.ConversationStorage", "get null with username:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(1211);
      return null;
    }
    paramString = new ak();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(1211);
    return paramString;
  }
  
  public final void arI(String paramString)
  {
    AppMethodBeat.i(1217);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, "username=?", new String[] { paramString });
    AppMethodBeat.o(1217);
  }
  
  public final boolean arJ(String paramString)
  {
    AppMethodBeat.i(1218);
    if ((paramString == null) || (paramString.length() <= 0)) {
      ab.e("MicroMsg.ConversationStorage", "update conversation failed");
    }
    int i;
    do
    {
      AppMethodBeat.o(1218);
      return false;
      ab.d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", new Object[] { paramString });
      Object localObject = arH(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(1218);
        return true;
      }
      if ((((au)localObject).field_unReadCount == 0) && (((au)localObject).field_unReadMuteCount == 0) && (paramString.equals(((au)localObject).field_username)))
      {
        a(paramString, 1048576, false, ((au)localObject).field_attrflag);
        localObject = new ContentValues();
        ((ContentValues)localObject).put("UnReadInvite", Integer.valueOf(0));
        ((ContentValues)localObject).put("atCount", Integer.valueOf(0));
        if (this.db.update(arE(paramString), (ContentValues)localObject, "username= ?", new String[] { bo.wC(paramString) }) > 0) {
          b(3, this, paramString);
        }
        AppMethodBeat.o(1218);
        return true;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("unReadCount", Integer.valueOf(0));
      localContentValues.put("unReadMuteCount", Integer.valueOf(0));
      localContentValues.put("UnReadInvite", Integer.valueOf(0));
      localContentValues.put("atCount", Integer.valueOf(0));
      localContentValues.put("attrflag", Integer.valueOf(((au)localObject).field_attrflag & 0xFFEFFFFF));
      i = this.db.update(arE(paramString), localContentValues, "username= ?", new String[] { bo.wC(paramString) });
      if (i > 0) {
        b(3, this, paramString);
      }
    } while (i <= 0);
    AppMethodBeat.o(1218);
    return true;
  }
  
  public final boolean arK(String paramString)
  {
    AppMethodBeat.i(1219);
    if (paramString.length() <= 0)
    {
      ab.e("MicroMsg.ConversationStorage", "update updateUnreadByParentRef failed");
      AppMethodBeat.o(1219);
      return false;
    }
    ab.d("MicroMsg.ConversationStorage", "updateUnreadByParentRef %s", new Object[] { paramString });
    ak localak = arH(paramString);
    if (localak == null)
    {
      AppMethodBeat.o(1219);
      return true;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("unReadCount", Integer.valueOf(0));
    localContentValues.put("unReadMuteCount", Integer.valueOf(0));
    localContentValues.put("UnReadInvite", Integer.valueOf(0));
    localContentValues.put("atCount", Integer.valueOf(0));
    localContentValues.put("attrflag", Integer.valueOf(localak.field_attrflag & 0xFFEFFFFF));
    int i = this.db.update(arE(paramString), localContentValues, "parentRef= ?", new String[] { bo.wC(paramString) });
    if (i > 0) {
      b(3, this, paramString);
    }
    if (i > 0)
    {
      AppMethodBeat.o(1219);
      return true;
    }
    AppMethodBeat.o(1219);
    return false;
  }
  
  public final boolean arL(String paramString)
  {
    AppMethodBeat.i(1220);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(1220);
      return false;
    }
    ak localak = arH(paramString);
    if ((localak == null) || ((localak.field_unReadCount > 0) && (paramString.equals(localak.field_username))))
    {
      AppMethodBeat.o(1220);
      return true;
    }
    boolean bool = this.db.execSQL("rconversation", "update " + arE(paramString) + " set unReadCount = 1, atCount = 0, attrflag = " + (localak.field_attrflag | 0x100000) + " where username = \"" + bo.wC(paramString) + "\"");
    if (bool) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(1220);
    return bool;
  }
  
  public final boolean arM(String paramString)
  {
    AppMethodBeat.i(1226);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
      AppMethodBeat.o(1226);
      return false;
    }
    paramString = arH(paramString);
    if (paramString == null)
    {
      ab.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
      AppMethodBeat.o(1226);
      return false;
    }
    boolean bool = this.db.execSQL("rconversation", "update " + arE(paramString.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 1, dxg() + 1L) + " where username = \"" + bo.wC(paramString.field_username) + "\"");
    if (bool) {
      b(3, this, paramString.field_username);
    }
    AppMethodBeat.o(1226);
    return bool;
  }
  
  public final boolean arN(String paramString)
  {
    AppMethodBeat.i(1227);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
      AppMethodBeat.o(1227);
      return false;
    }
    if (arH(paramString) == null)
    {
      ak localak = new ak(paramString);
      localak.fK(System.currentTimeMillis());
      d(localak);
      ab.i("MicroMsg.ConversationStorage", "setPlacedTop username = ".concat(String.valueOf(paramString)));
    }
    paramString = arH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(1227);
      return false;
    }
    boolean bool = this.db.execSQL("rconversation", "update " + arE(paramString.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 2, 0L) + " where username = \"" + bo.wC(paramString.field_username) + "\"");
    if (bool) {
      b(3, this, paramString.field_username);
    }
    AppMethodBeat.o(1227);
    return bool;
  }
  
  public final boolean arO(String paramString)
  {
    AppMethodBeat.i(1228);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
      AppMethodBeat.o(1228);
      return false;
    }
    boolean bool = f(arH(paramString));
    AppMethodBeat.o(1228);
    return bool;
  }
  
  public final boolean arP(String paramString)
  {
    AppMethodBeat.i(1230);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
      AppMethodBeat.o(1230);
      return false;
    }
    boolean bool = g(arH(paramString));
    AppMethodBeat.o(1230);
    return bool;
  }
  
  public final Cursor arQ(String paramString)
  {
    AppMethodBeat.i(1238);
    paramString = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + bo.nullAsNil(paramString) + " order by flag desc, conversationTime desc";
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(1238);
    return paramString;
  }
  
  public final Cursor arR(String paramString)
  {
    AppMethodBeat.i(1244);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT username, unReadCount");
    localStringBuilder.append(" FROM rconversation");
    localStringBuilder.append(" WHERE (username LIKE '%@chatroom' ");
    localStringBuilder.append(" or username LIKE '%@im.chatroom' ) ");
    localStringBuilder.append(bo.nullAsNil(paramString));
    localStringBuilder.append(" AND unReadCount > 0");
    paramString = localStringBuilder.toString();
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(1244);
    return paramString;
  }
  
  public final int arS(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(1251);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM rconversation");
    localStringBuilder.append(" WHERE parentRef = '").append(paramString).append("'");
    paramString = localStringBuilder.toString();
    ab.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", new Object[] { paramString });
    paramString = this.db.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(1251);
    return i;
  }
  
  public final String arT(String paramString)
  {
    AppMethodBeat.i(1252);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = '").append(paramString).append("'");
    ((StringBuilder)localObject).append(" ORDER BY conversationTime DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    paramString = ((StringBuilder)localObject).toString();
    ab.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", new Object[] { paramString });
    paramString = this.db.a(paramString, null, 2);
    if (paramString != null)
    {
      if (paramString.moveToFirst())
      {
        localObject = paramString.getString(0);
        paramString.close();
        AppMethodBeat.o(1252);
        return localObject;
      }
      paramString.close();
    }
    AppMethodBeat.o(1252);
    return null;
  }
  
  public final ak arU(String paramString)
  {
    AppMethodBeat.i(1256);
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().c(t.flc, null, paramString);
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        paramString = new ak();
        paramString.convertFrom(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(1256);
      return paramString;
      paramString = null;
      break;
      paramString = null;
    }
  }
  
  public final int arV(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(1258);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(atCount) from rconversation");
    localStringBuilder.append(" where unReadCount > 0");
    if (!bo.isNullOrNil(paramString)) {
      localStringBuilder.append(" and username = '").append(paramString).append("'");
    }
    paramString = localStringBuilder.toString();
    ab.d("MicroMsg.ConversationStorage", "query sql: %s", new Object[] { paramString });
    paramString = this.db.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(1258);
    return i;
  }
  
  public final void arW(String paramString)
  {
    AppMethodBeat.i(1261);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Update rconversation");
    ((StringBuilder)localObject).append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + bo.wC(paramString) + "\"");
    localObject = ((StringBuilder)localObject).toString();
    ab.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", new Object[] { localObject });
    if (this.db.execSQL("rconversation", (String)localObject)) {
      b(3, this, paramString);
    }
    AppMethodBeat.o(1261);
  }
  
  public final void arX(String paramString)
  {
    AppMethodBeat.i(1262);
    int i = this.db.delete(arE(paramString), "username=? or parentRef =?", new String[] { paramString, paramString });
    ab.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i != 0) {
      b(5, this, paramString);
    }
    AppMethodBeat.o(1262);
  }
  
  public final int arY(String paramString)
  {
    int i = -1;
    AppMethodBeat.i(1263);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(1263);
      return -1;
    }
    paramString = "select msgCount from rconversation where username=" + com.tencent.mm.cg.h.escape(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(1263);
    return i;
  }
  
  public final void b(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc)
  {
    AppMethodBeat.i(1206);
    if (paramc == null)
    {
      ab.f("MicroMsg.ConversationStorage", "null notifyInfo");
      AppMethodBeat.o(1206);
      return;
    }
    Object localObject2 = paramc.talker;
    Object localObject1 = arH((String)localObject2);
    bi localbi = paramh.Tm((String)localObject2);
    if (localObject1 == null)
    {
      ab.i("MicroMsg.ConversationStorage", "create new cvs:%s", new Object[] { localObject2 });
      paramh = new ak((String)localObject2);
      if (ad.nM((String)localObject2)) {
        paramh.hK(1);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.yMt.a(localbi, paramh, bool, paramc);
      ab.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d ", new Object[] { paramc.talker, paramc.oDP, Integer.valueOf(paramc.oDR) });
      long l1;
      long l2;
      if ((localbi != null) && (localbi.field_msgId != 0L))
      {
        if ((paramc.oDR == 1) && (((bi)paramc.oDQ.get(0)).field_msgId != localbi.field_msgId)) {
          ab.w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", new Object[] { Long.valueOf(localbi.field_msgId), Long.valueOf(((bi)paramc.oDQ.get(0)).field_msgId) });
        }
        i = localbi.field_flag;
        l1 = paramh.field_lastSeq;
        l2 = localbi.field_msgSeq;
        ab.i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramh.field_UnDeliverCount) });
        if (((!paramc.oDP.equals("insert")) || (paramc.oDR <= 0)) && ((!paramc.oDP.equals("update")) || (paramh.field_unReadCount + paramc.oDR < 0))) {
          break label580;
        }
        paramh.hJ(paramh.field_unReadCount + paramc.oDR);
        if (l2 > l1)
        {
          ab.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", new Object[] { Long.valueOf(l2) });
          paramh.fM(l2);
        }
        if ((localbi.byk()) && (localbi.field_isSend == 1))
        {
          paramh.field_sightTime = localbi.field_createTime;
          paramh.drC = true;
        }
      }
      label470:
      Object localObject3;
      if ((paramc.oDP.equals("insert")) && (paramc.oDQ.size() > 0) && (t.lA(paramc.talker)))
      {
        localObject1 = r.Zn();
        localObject2 = paramc.oDQ.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label783;
          }
          localObject3 = (bi)((Iterator)localObject2).next();
          if (((dd)localObject3).field_isSend != 1) {
            if (!((bi)localObject3).isText())
            {
              if (((bi)localObject3).getType() != 503316529) {
                break label732;
              }
              i = 1;
              label522:
              if (i == 0) {}
            }
            else
            {
              if (!((bi)localObject3).asi((String)localObject1)) {
                break label737;
              }
              paramh.hO(paramh.field_atCount + 1);
            }
          }
          for (;;)
          {
            localObject3 = br.F(((dd)localObject3).field_content, "sysmsg");
            if (!bi.aU((Map)localObject3)) {
              break label760;
            }
            paramh.hR(paramh.field_UnReadInvite + 1);
            break label470;
            label580:
            if ((paramc.oDT <= 0) || (l2 >= l1) || (((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().ah(paramh.field_username, l1).field_msgId != 0L)) {
              break;
            }
            long l3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().TF(paramh.field_username);
            ab.i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
            paramh.fM(l2);
            if (l1 <= l3) {
              break;
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Zc().ad(paramh.field_username, l3);
            break;
            label732:
            i = 0;
            break label522;
            label737:
            if (((bi)localObject3).dyq()) {
              paramh.hO(paramh.field_atCount + 4096);
            }
          }
          label760:
          if (bi.aV((Map)localObject3)) {
            paramh.hR(paramh.field_UnReadInvite + 4096);
          }
        }
      }
      label783:
      int k = 0;
      int i = 0;
      if (paramc != null) {}
      for (localObject1 = paramc.talker;; localObject1 = null)
      {
        int j = k;
        if (paramc != null)
        {
          j = k;
          if (paramc.oDP != null)
          {
            j = k;
            if (paramc.oDP.equals("delete"))
            {
              if (paramc.oDT > 0) {
                i = paramc.oDT;
              }
              ab.i("MicroMsg.ConversationStorage", "notify delete count %d ", new Object[] { Integer.valueOf(paramc.oDT) });
              j = i;
            }
          }
        }
        if ((paramc != null) && (paramc.oDP != null) && (paramc.oDP.equals("insert"))) {
          if (paramc.oDS > 0)
          {
            i = paramc.oDS;
            ab.i("MicroMsg.ConversationStorage", "notify insert all count %d ", new Object[] { Integer.valueOf(paramc.oDS) });
          }
        }
        for (;;)
        {
          localObject2 = bo.bf((String)localObject1, "");
          if (localbi != null) {}
          for (l1 = localbi.field_msgSeq;; l1 = -1L)
          {
            ab.i("MicroMsg.ConversationStorage", "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d], ParentRef[%s]", new Object[] { localObject2, Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Thread.currentThread().getId()), paramh.field_parentRef });
            if ((!bool) || (j <= 0) || (i != 0)) {
              break;
            }
            ab.i("MicroMsg.ConversationStorage", "summerdel ignore delete event [%s, %s]", new Object[] { localObject1, paramh.field_username });
            AppMethodBeat.o(1206);
            return;
          }
          this.yMu.cy(paramh);
          this.yMu.doNotify();
          if (localObject1 == null)
          {
            ab.e("MicroMsg.ConversationStorage", "talker == null");
            AppMethodBeat.o(1206);
            return;
          }
          if (!((String)localObject1).equals(paramh.field_username))
          {
            ab.e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
            AppMethodBeat.o(1206);
            return;
          }
          if ((localbi != null) && (localbi.field_msgId != 0L))
          {
            ab.v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + localbi.field_msgId);
            paramh.aq(localbi);
            if (this.yMr != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              PInt localPInt = new PInt();
              this.yMr.a(localbi, (PString)localObject2, (PString)localObject3, localPInt, paramh.ji(2097152));
              ab.d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", new Object[] { ((PString)localObject3).value });
              paramh.jW(((PString)localObject2).value);
              paramh.jX(((PString)localObject3).value);
              paramh.hM(localPInt.value);
              paramh.jV(Integer.toString(localbi.getType()));
              if (this.yMs != null) {
                this.yMs.a(localbi, paramh);
              }
              paramh.fL(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramh, 1, localbi.field_createTime));
              if (!bool) {
                break label1553;
              }
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw((String)localObject1);
              if ((localObject1 != null) && (!bo.isNullOrNil(((aq)localObject1).field_username)) && (((ad)localObject1).Oa())) {
                paramh.fL(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramh, 2, 0L));
              }
              a(paramh, j, i);
              if ((!localbi.byk()) && (!com.tencent.mm.sdk.a.b.dsh())) {
                break label1543;
              }
              paramh.fK(localbi.field_createTime);
              label1425:
              d(paramh);
            }
          }
          label1543:
          label1553:
          label1618:
          do
          {
            for (;;)
            {
              this.yMv.cy(paramh);
              this.yMv.doNotify();
              this.yMt.b(localbi, paramh, bool, paramc);
              AppMethodBeat.o(1206);
              return;
              localObject2 = ac(localbi.getType(), paramh.field_content);
              localObject3 = bo.nullAsNil(paramh.field_digest);
              if (bo.isNullOrNil((String)localObject2)) {}
              for (localObject2 = "";; localObject2 = " " + bo.nullAsNil((String)localObject2))
              {
                paramh.jW(((String)localObject3).concat((String)localObject2));
                break;
              }
              paramh.fK(bo.aoy());
              break label1425;
              a(paramh, j, i);
              a(paramh, (String)localObject1, true);
              continue;
              ab.i("MicroMsg.ConversationStorage", "update null conversation with talker ".concat(String.valueOf(localObject1)));
              if (bool) {
                break label1618;
              }
              paramh.dxc();
              a(paramh, j, i);
              a(paramh, (String)localObject1, true);
            }
          } while (((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().TA((String)localObject1) <= 0);
          if ((localbi.byk()) || (com.tencent.mm.sdk.a.b.dsh())) {
            paramh.fK(localbi.field_createTime);
          }
          for (;;)
          {
            a(paramh, j, i);
            d(paramh);
            break;
            paramh.fK(bo.aoy());
          }
          i = 0;
          break;
          i = 0;
        }
      }
      paramh = (com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject1;
    }
  }
  
  public final void b(be.a parama)
  {
    AppMethodBeat.i(1203);
    this.yMv.remove(parama);
    AppMethodBeat.o(1203);
  }
  
  public final Cursor c(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(1232);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from rconversation where ");
    if (com.tencent.mm.o.a.euH == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bo.nullAsNil(paramString1));
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
        localStringBuilder.append("parentRef = '").append(bo.wC(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc, conversationTime desc");
    paramString1 = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(1232);
    return paramString1;
  }
  
  public final void c(be.a parama)
  {
    AppMethodBeat.i(1204);
    this.yMu.a(parama, null);
    AppMethodBeat.o(1204);
  }
  
  public final void c(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(1257);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Update rconversation");
    localStringBuilder.append(" set parentRef = '").append(bo.nullAsNil(paramString)).append("' where 1 != 1 ");
    int i = 0;
    while (i <= 0)
    {
      paramString = paramArrayOfString[0];
      localStringBuilder.append(" or username = '").append(paramString).append("'");
      i += 1;
    }
    paramString = localStringBuilder.toString();
    ab.d("MicroMsg.ConversationStorage", "update sql: %s", new Object[] { paramString });
    if (this.db.execSQL("rconversation", paramString))
    {
      i = 0;
      while (i <= 0)
      {
        b(3, this, paramArrayOfString[0]);
        i += 1;
      }
    }
    AppMethodBeat.o(1257);
  }
  
  public final long d(ak paramak)
  {
    AppMethodBeat.i(1214);
    String str = bo.nullAsNil(paramak.field_username);
    if (str.length() <= 0)
    {
      ab.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
      AppMethodBeat.o(1214);
      return -1L;
    }
    paramak.fL(c(paramak));
    e(paramak);
    long l = this.db.insert(arE(str), null, paramak.convertTo());
    if (l != -1L) {
      b(2, this, paramak.field_username);
    }
    for (;;)
    {
      AppMethodBeat.o(1214);
      return l;
      ab.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", new Object[] { arE(str) });
    }
  }
  
  public final void d(be.a parama)
  {
    AppMethodBeat.i(1205);
    this.yMu.remove(parama);
    AppMethodBeat.o(1205);
  }
  
  public final boolean dxd()
  {
    AppMethodBeat.i(1209);
    boolean bool1 = this.db.execSQL("rconversation", "delete from rconversation");
    boolean bool2 = this.db.execSQL("rconversation", "delete from rbottleconversation");
    if ((bool1) || (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      if (bool1) {
        b(5, this, "");
      }
      AppMethodBeat.o(1209);
      return bool1;
    }
  }
  
  public final HashMap<String, Long> dxe()
  {
    AppMethodBeat.i(1213);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    Cursor localCursor = this.db.a("rconversation", new String[] { "username", "conversationTime" }, null, null, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(1213);
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
    ab.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(1213);
    return localHashMap;
  }
  
  public final void dxf()
  {
    AppMethodBeat.i(1216);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, null, null);
    AppMethodBeat.o(1216);
  }
  
  public final List<String> dxh()
  {
    AppMethodBeat.i(1233);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select rconversation.username from rconversation,rcontact where ");
    ((StringBuilder)localObject).append("rconversation.username = rcontact.username");
    ((StringBuilder)localObject).append(bo.nullAsNil(bo.nullAsNil(t.flc)));
    ((StringBuilder)localObject).append(" and ( verifyFlag & 8 ) = 0");
    ((StringBuilder)localObject).append(" and ( rconversation.parentRef is null  or rconversation.parentRef = '' ) ");
    String[] arrayOfString = t.fll;
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
    ab.d("MicroMsg.ConversationStorage", "user list:%s", new Object[] { localArrayList });
    AppMethodBeat.o(1233);
    return localArrayList;
  }
  
  public final List<String> dxi()
  {
    AppMethodBeat.i(1240);
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localObject = A(" where username", (List)localObject);
    localObject = "select username from rconversation" + (String)localObject;
    localObject = (String)localObject + " order by flag desc, conversationTime desc";
    ab.i("MicroMsg.ConversationStorage", "getAllConvUserName sql %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null);
    int i = ((Cursor)localObject).getColumnIndex("username");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1240);
    return localArrayList;
  }
  
  public final Cursor dxj()
  {
    AppMethodBeat.i(1242);
    Cursor localCursor = this.db.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    AppMethodBeat.o(1242);
    return localCursor;
  }
  
  public final int dxk()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(1249);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT SUM(rconversation.unReadCount)");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    localObject = ((StringBuilder)localObject).toString();
    ab.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", new Object[] { localObject });
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      i = j;
      if (((Cursor)localObject).moveToFirst()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(1249);
    return i;
  }
  
  public final String dxl()
  {
    AppMethodBeat.i(1250);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    ((StringBuilder)localObject).append(" ORDER BY flag DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    localObject = ((StringBuilder)localObject).toString();
    ab.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", new Object[] { localObject });
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst())
      {
        String str = ((Cursor)localObject).getString(0);
        ((Cursor)localObject).close();
        AppMethodBeat.o(1250);
        return str;
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(1250);
    return null;
  }
  
  public final Cursor dxm()
  {
    AppMethodBeat.i(1253);
    ab.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", new Object[] { "select count(*) from rbottleconversation where unReadCount > 0" });
    Cursor localCursor = this.db.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
    AppMethodBeat.o(1253);
    return localCursor;
  }
  
  public final ak dxn()
  {
    AppMethodBeat.i(1255);
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().c(t.flc, null, "officialaccounts");
    ak localak;
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        localak = new ak();
        localak.convertFrom(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(1255);
      return localak;
      localak = null;
      break;
      localak = null;
    }
  }
  
  public final Cursor dxo()
  {
    AppMethodBeat.i(1264);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username, ");
    ((StringBuilder)localObject).append("rconversation.unReadCount");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE unReadCount > 0");
    ((StringBuilder)localObject).append(" AND ( parentRef is ").append(com.tencent.mm.o.a.euH).append(" or parentRef = '' ) ");
    localObject = this.db.rawQuery(((StringBuilder)localObject).toString(), null);
    AppMethodBeat.o(1264);
    return localObject;
  }
  
  public final Cursor eC(String paramString, int paramInt)
  {
    AppMethodBeat.i(1248);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT rconversation.username");
    localStringBuilder.append(" FROM rconversation, rcontact");
    localStringBuilder.append(" WHERE unReadCount > 0");
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(bo.nullAsNil(paramString));
    localStringBuilder.append(" AND ( type & 512 ) == 0");
    localStringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.o.a.euH).append(" or parentRef = '' ) ");
    localStringBuilder.append(" AND rcontact.username != 'officialaccounts')");
    localStringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
    if (paramInt > 0) {
      localStringBuilder.append(" LIMIT ").append(String.valueOf(paramInt));
    }
    paramString = localStringBuilder.toString();
    ab.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(1248);
    return paramString;
  }
  
  public final boolean f(ak paramak)
  {
    AppMethodBeat.i(1229);
    if (paramak == null)
    {
      ab.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
      AppMethodBeat.o(1229);
      return false;
    }
    boolean bool = this.db.execSQL("rconversation", "update " + arE(paramak.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramak, 3, paramak.field_conversationTime) + " where username = \"" + bo.wC(paramak.field_username) + "\"");
    if (bool) {
      b(3, this, paramak.field_username);
    }
    AppMethodBeat.o(1229);
    return bool;
  }
  
  public final boolean g(ak paramak)
  {
    AppMethodBeat.i(1231);
    if (paramak == null)
    {
      ab.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
      AppMethodBeat.o(1231);
      return false;
    }
    if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramak, 4, 0L) != 0L)
    {
      AppMethodBeat.o(1231);
      return true;
    }
    AppMethodBeat.o(1231);
    return false;
  }
  
  public final Cursor ip(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1245);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount");
    localStringBuilder.append(" from rconversation where username = '").append(paramString1).append("' AND ( parentRef is ").append(com.tencent.mm.o.a.euH).append(" or parentRef = '' ) ").append(bo.nullAsNil(paramString2));
    paramString1 = localStringBuilder.toString();
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(1245);
    return paramString1;
  }
  
  public final int oM(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(1254);
    paramString = "select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + bo.nullAsNil(paramString);
    paramString = this.db.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(1254);
    return i;
  }
  
  public final Cursor s(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(1241);
    String str = "select username from rconversation";
    int i = 0;
    if (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      if (i > 0) {}
      for (str = " and ";; str = " where ")
      {
        str = str + "username != \"" + bo.wC((String)paramList.get(i)) + "\"";
        i += 1;
        break;
      }
    }
    paramList = str + " order by flag desc, conversationTime desc limit 50 offset " + paramInt;
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(1241);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.al
 * JD-Core Version:    0.7.0.1
 */