package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.sdk.storage.MStorageEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import junit.framework.Assert;

public final class bc
  extends MStorageEx
  implements by
{
  public static final String[] SQL_CREATE;
  private by.b adit;
  private com.tencent.mm.plugin.messenger.foundation.a.h adiu;
  private a adiv;
  private MStorageEvent<by.a, bb> adiw;
  private MStorageEvent<by.a, bb> adix;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(117133);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.l.a.info, "rconversation"), MAutoStorage.getCreateSQLs(com.tencent.mm.l.a.info, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE INDEX IF NOT EXISTS rconversation_unreadcount_index ON rconversation ( unReadCount )", "DROP INDEX IF EXISTS multi_index ", "DROP INDEX IF EXISTS rconversation_multi_index", "CREATE INDEX IF NOT EXISTS rconversation_parentref_index ON  rconversation ( parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )", "CREATE INDEX IF NOT EXISTS rconversation_flag_parentref_index ON  rconversation ( flag,parentRef )" };
    AppMethodBeat.o(117133);
  }
  
  public bc(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(117067);
    this.adiv = new a((byte)0);
    this.adiw = new MStorageEvent() {};
    this.adix = new MStorageEvent() {};
    Assert.assertTrue(paramISQLiteDatabase instanceof com.tencent.mm.storagebase.h);
    Object localObject = paramISQLiteDatabase.rawQuery("PRAGMA table_info( rconversation)", null, 2);
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
      localObject = MAutoStorage.getUpdateSQLs(com.tencent.mm.l.a.info, "rconversation", paramISQLiteDatabase);
      ((List)localObject).addAll(MAutoStorage.getUpdateSQLs(com.tencent.mm.l.a.info, "rbottleconversation", paramISQLiteDatabase));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramISQLiteDatabase.execSQL("rconversation", (String)((Iterator)localObject).next());
      }
      if (i == 0) {
        paramISQLiteDatabase.execSQL("rconversation", "update rconversation set flag = conversationTime");
      }
      this.db = paramISQLiteDatabase;
      AppMethodBeat.o(117067);
      return;
    }
  }
  
  private static String Og(String paramString)
  {
    AppMethodBeat.i(117068);
    com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.ConversationStorage", "talker :".concat(String.valueOf(paramString)));
    if (au.bwS(paramString))
    {
      AppMethodBeat.o(117068);
      return "rbottleconversation";
    }
    AppMethodBeat.o(117068);
    return "rconversation";
  }
  
  private static String T(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(117104);
    StringBuilder localStringBuilder1 = new StringBuilder("");
    if ((paramList != null) && (paramList.size() > 0))
    {
      localStringBuilder1.append(paramString).append(" not in (");
      int i = 0;
      if (i < paramList.size())
      {
        StringBuilder localStringBuilder2 = localStringBuilder1.append("\"").append(Util.escapeSqlValue((String)paramList.get(i))).append("\"");
        if (i == paramList.size() - 1) {}
        for (paramString = "";; paramString = ",")
        {
          localStringBuilder2.append(paramString);
          i += 1;
          break;
        }
      }
      localStringBuilder1.append(") ");
    }
    paramString = localStringBuilder1.toString();
    AppMethodBeat.o(117104);
    return paramString;
  }
  
  private void a(bb parambb, boolean paramBoolean)
  {
    AppMethodBeat.i(248790);
    if (parambb == null)
    {
      AppMethodBeat.o(248790);
      return;
    }
    if (au.bwB(parambb.field_username))
    {
      parambb.BH(null);
      AppMethodBeat.o(248790);
      return;
    }
    if (paramBoolean)
    {
      if ((parambb.field_parentRef == null) || (parambb.field_parentRef.isEmpty()) || (parambb.field_parentRef.equals("message_fold")))
      {
        if ((!k(parambb)) && (parambb != null) && (parambb.field_unReadCount == 0) && (parambb.field_unReadMuteCount == 0) && (!parambb.rx(1048576)) && (!parambb.rx(536870912)))
        {
          com.tencent.mm.storage.b.a locala = com.tencent.mm.storage.b.a.admS;
          if (com.tencent.mm.storage.b.a.jdN())
          {
            parambb.BH("message_fold");
            AppMethodBeat.o(248790);
            return;
          }
        }
        parambb.BH(null);
        AppMethodBeat.o(248790);
      }
    }
    else if ((parambb.field_parentRef == null) || (parambb.field_parentRef.isEmpty()) || (parambb.field_parentRef.equals("message_fold")))
    {
      if ((parambb.field_unReadCount == 0) && (parambb.field_unReadMuteCount == 0) && (!parambb.rx(1048576)) && (!parambb.rx(536870912)) && (k(parambb)))
      {
        parambb.BH("message_fold");
        AppMethodBeat.o(248790);
        return;
      }
      if ("message_fold".equals(parambb.field_parentRef)) {
        parambb.BH(null);
      }
    }
    AppMethodBeat.o(248790);
  }
  
  private static String ab(String... paramVarArgs)
  {
    AppMethodBeat.i(248802);
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" or ");
      }
      localStringBuilder.append("parentRef = '").append(Util.escapeSqlValue(str)).append("'");
      i += 1;
    }
    paramVarArgs = localStringBuilder.toString();
    AppMethodBeat.o(248802);
    return paramVarArgs;
  }
  
  private static String bxX(String paramString)
  {
    AppMethodBeat.i(248806);
    paramString = " and ( rconversation.username like '%" + paramString + "%' or content like '%" + paramString + "%' or rcontact.nickname like '%" + paramString + "%' or rcontact.alias like '%" + paramString + "%' or rcontact.pyInitial like '%" + paramString + "%' or rcontact.quanPin like '%" + paramString + "%' or rcontact.conRemark like '%" + paramString + "%'  ) ";
    AppMethodBeat.o(248806);
    return paramString;
  }
  
  private static long g(bb parambb)
  {
    AppMethodBeat.i(117075);
    if (parambb != null)
    {
      l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(parambb, parambb.field_conversationTime);
      AppMethodBeat.o(117075);
      return l;
    }
    long l = Util.nowMilliSecond();
    AppMethodBeat.o(117075);
    return l & 0xFFFFFFFF;
  }
  
  private void i(bb parambb)
  {
    AppMethodBeat.i(117092);
    if (parambb == null)
    {
      AppMethodBeat.o(117092);
      return;
    }
    if (parambb.field_unReadCount > 0)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
      if ((parambb.field_attrflag & 0x100000) != 0)
      {
        parambb.pG(parambb.field_unReadCount - 1);
        parambb.pK(parambb.field_attrflag & 0xFFEFFFFF);
      }
    }
    if (("message_fold".equals(parambb.field_username)) && (!k(parambb))) {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "insert or update message_fold error!, stack: %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(117092);
  }
  
  private static String jaN()
  {
    AppMethodBeat.i(248793);
    Object localObject = new StringBuilder();
    com.tencent.mm.storage.b.a locala = com.tencent.mm.storage.b.a.admS;
    if (com.tencent.mm.storage.b.a.jdO()) {
      ((StringBuilder)localObject).append(" ( parentRef is null  or parentRef = ''  or ").append("parentRef = '" + Util.escapeSqlValue("message_fold") + "' ) ");
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(248793);
      return localObject;
      ((StringBuilder)localObject).append(" ( parentRef is null  or parentRef = '' ) ");
    }
  }
  
  public final Cursor I(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(249000);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.l.a.maX == paramString) {
      localStringBuilder.append(jaN());
    }
    for (;;)
    {
      localStringBuilder.append(Util.nullAsNil(ab.j(false, 1)));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramList = new ArrayList(paramList).iterator();
      while (paramList.hasNext())
      {
        paramString = (String)paramList.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramString).append("'");
      }
      if ("*".equals(paramString)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(Util.escapeSqlValue(paramString)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc");
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "getNecessaryCursorWithConversation sql " + localStringBuilder.toString());
    paramList = this.db.rawQuery(localStringBuilder.toString(), null, 4);
    AppMethodBeat.o(249000);
    return paramList;
  }
  
  public final boolean Te(String paramString)
  {
    AppMethodBeat.i(248904);
    if (bxM(paramString) != null)
    {
      AppMethodBeat.o(248904);
      return true;
    }
    AppMethodBeat.o(248904);
    return false;
  }
  
  public final String Z(int paramInt, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(117127);
    Object localObject1 = localObject2;
    if (!Util.isNullOrNil(paramString)) {
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
      paramString = XmlParser.parseXml(paramString, "msg", null);
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = (String)paramString.get(".msg.appmsg.title");
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { localObject1 });
      }
    }
  }
  
  public final int a(bb parambb, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117091);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(117091);
      return 0;
    }
    if (paramBoolean) {
      parambb.gS(g(parambb));
    }
    i(parambb);
    a(parambb, false);
    int i = this.db.update(Og(paramString), parambb.convertTo(), "username=?", new String[] { paramString });
    if (i != 0) {
      doNotify(3, this, paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(117091);
      return i;
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", new Object[] { Og(paramString) });
    }
  }
  
  public final Cursor a(int paramInt, List<String> paramList, String paramString)
  {
    AppMethodBeat.i(248994);
    paramList = a(paramInt, paramList, paramString, -1);
    AppMethodBeat.o(248994);
    return paramList;
  }
  
  public final Cursor a(int paramInt1, List<String> paramList, String paramString, int paramInt2)
  {
    AppMethodBeat.i(248997);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from rconversation where ");
    if (com.tencent.mm.l.a.maX == paramString) {
      localStringBuilder.append(jaN());
    }
    for (;;)
    {
      localStringBuilder.append(Util.nullAsNil(ab.j(false, paramInt1)));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString = (String)paramList.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramString).append("'");
      }
      if ("*".equals(paramString)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(Util.escapeSqlValue(paramString)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc, conversationTime desc");
    if (paramInt2 > 0) {
      localStringBuilder.append(" limit ").append(paramInt2);
    }
    paramList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(248997);
    return paramList;
  }
  
  public final Cursor a(int paramInt, List<String> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(249013);
    String str = " ";
    Object localObject = str;
    if (paramString2 != null)
    {
      localObject = str;
      if (paramString2.length() > 0) {
        localObject = " and rconversation.username = rcontact.username ";
      }
    }
    localObject = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + " " + " where rconversation.username = rcontact.username" + (String)localObject + Util.nullAsNil(ab.j(false, paramInt));
    paramList = T(" and rconversation.username", paramList);
    localObject = (String)localObject + paramList;
    paramList = (List<String>)localObject;
    if (paramBoolean) {
      paramList = (String)localObject + " and ( verifyFlag & 8 ) = 0";
    }
    localObject = paramList;
    if (com.tencent.mm.l.a.maX == paramString1) {
      localObject = paramList + " and ( parentRef is null or parentRef = '' or " + ab(new String[] { "message_fold" }) + " ) ";
    }
    paramList = (List<String>)localObject;
    if (paramString2 != null)
    {
      paramList = (List<String>)localObject;
      if (paramString2.length() > 0) {
        paramList = (String)localObject + bxX(paramString2);
      }
    }
    if ((paramString2 == null) || (paramString2.equals(""))) {}
    for (paramList = paramList + " order by flag desc, conversationTime desc";; paramList = paramList + " order by rconversation.username like \"%@chatroom\" asc")
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "getSearchCursor sql ".concat(String.valueOf(paramList)));
      paramList = this.db.rawQuery(paramList, null);
      AppMethodBeat.o(249013);
      return paramList;
    }
  }
  
  public final Cursor a(List<String> paramList1, int paramInt, List<String> paramList2, String paramString1, boolean paramBoolean, String paramString2)
  {
    int j = 0;
    AppMethodBeat.i(249010);
    Object localObject = " ";
    if (paramString2.length() > 0) {
      localObject = " and rconversation.username = rcontact.username ";
    }
    localObject = new StringBuilder("select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + " " + " where rconversation.username = rcontact.username" + (String)localObject + "and (");
    int i = 0;
    if (i < paramList1.size())
    {
      if (i != paramList1.size() - 1) {
        ((StringBuilder)localObject).append("rconversation.username = '").append((String)paramList1.get(i)).append("' OR ");
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject).append("rconversation.username = '").append((String)paramList1.get(i)).append("')");
      }
    }
    ((StringBuilder)localObject).append(Util.nullAsNil(ab.j(false, paramInt)));
    ((StringBuilder)localObject).append(T(" and rconversation.username", paramList2));
    if (paramBoolean) {
      ((StringBuilder)localObject).append(" and ( verifyFlag & 8 ) = 0");
    }
    if (com.tencent.mm.l.a.maX == paramString1) {
      ((StringBuilder)localObject).append(" and ( parentRef is null or parentRef = '' or " + ab(new String[] { "message_fold", "conversationboxservice" }) + " ) ");
    }
    if (paramString2.length() > 0) {
      ((StringBuilder)localObject).append(bxX(paramString2));
    }
    ((StringBuilder)localObject).append("order by case rconversation.username ");
    paramInt = j;
    while (paramInt < paramList1.size())
    {
      ((StringBuilder)localObject).append(" when '").append((String)paramList1.get(paramInt)).append("' then ").append(paramInt);
      paramInt += 1;
    }
    ((StringBuilder)localObject).append(" end");
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "getCursorByNamesInListOrder sql:".concat(String.valueOf(localObject)));
    paramList1 = this.db.rawQuery(((StringBuilder)localObject).toString().toString(), null);
    AppMethodBeat.o(249010);
    return paramList1;
  }
  
  public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.i parami)
  {
    AppMethodBeat.i(117069);
    parami = this.adiv.add(parami);
    AppMethodBeat.o(117069);
    return parami;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(117074);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.Log.f("MicroMsg.ConversationStorage", "null notifyInfo");
      AppMethodBeat.o(117074);
      return;
    }
    if ((ab.IN(paramc.talker)) || (ab.IO(paramc.talker)))
    {
      AppMethodBeat.o(117074);
      return;
    }
    Object localObject1 = paramc.talker;
    cc localcc = parami.aLG((String)localObject1);
    parami = new boolean[1];
    parami[0] = 0;
    this.adiv.a(localcc, paramc, parami);
    if (parami[0] != 0)
    {
      AppMethodBeat.o(117074);
      return;
    }
    parami = bxM((String)localObject1);
    if (parami == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "create new cvs:%s", new Object[] { localObject1 });
      parami = new bb((String)localObject1);
      if (au.bwS((String)localObject1)) {
        parami.pH(1);
      }
      if ((localcc != null) && (!Util.isNullOrNil(localcc.jUr)))
      {
        localObject1 = br.JP(localcc.jUr);
        if ((localObject1 != null) && ((((br.b)localObject1).olV & 0x40) != 0L))
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ConversationStorage", "not fas msg no need to create conversation");
          AppMethodBeat.o(117074);
          return;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.adiv.a(localcc, parami, bool, paramc);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d", new Object[] { paramc.talker, paramc.KRm, Integer.valueOf(paramc.apS) });
      long l1;
      long l2;
      if ((localcc != null) && (localcc.field_msgId != 0L))
      {
        if ((paramc.apS == 1) && (((cc)paramc.mZo.get(0)).field_msgId != localcc.field_msgId)) {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", new Object[] { Long.valueOf(localcc.field_msgId), Long.valueOf(((cc)paramc.mZo.get(0)).field_msgId) });
        }
        i = localcc.field_flag;
        l1 = parami.field_lastSeq;
        l2 = localcc.field_msgSeq;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(parami.field_UnDeliverCount) });
        if (((!paramc.KRm.equals("insert")) || (paramc.apS <= 0)) && ((!paramc.KRm.equals("update")) || (parami.field_unReadCount + paramc.apS < 0))) {
          break label625;
        }
        parami.pG(parami.field_unReadCount + paramc.apS);
        if (l2 > l1)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", new Object[] { Long.valueOf(l2) });
          parami.gT(l2);
        }
        if ((localcc.dSJ()) && (localcc.field_isSend == 1))
        {
          parami.field_sightTime = localcc.getCreateTime();
          parami.kbt = true;
        }
      }
      Object localObject2;
      Object localObject3;
      label625:
      Object localObject4;
      label910:
      label915:
      if ((paramc.KRm.equals("insert")) && (paramc.mZo.size() > 0) && (au.bwE(paramc.talker)))
      {
        localObject1 = z.bAM();
        localObject2 = paramc.mZo.iterator();
        label816:
        label959:
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label961;
          }
          localObject3 = (cc)((Iterator)localObject2).next();
          if (localObject3 == null)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "[onMsgInfoStgNotifyChange] msgInfo is null.");
            continue;
            if ((paramc.KRo <= 0) || (l2 >= l1)) {
              break;
            }
            localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aV(parami.field_username, l1);
            if ((localObject1 != null) && (((fi)localObject1).field_msgId != 0L)) {
              break;
            }
            long l3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aMa(parami.field_username);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
            parami.gT(l2);
            if (l1 <= l3) {
              break;
            }
            ((n)com.tencent.mm.kernel.h.ax(n.class)).bAd().aR(parami.field_username, l3);
            break;
          }
          if (((fi)localObject3).field_isSend != 1) {
            if (!((cc)localObject3).iYl())
            {
              if (((cc)localObject3).getType() != 503316529) {
                break label910;
              }
              i = 1;
              if (i == 0) {}
            }
            else
            {
              if ((!((cc)localObject3).byr((String)localObject1)) && (!((cc)localObject3).jcr())) {
                break label915;
              }
              parami.pL(parami.field_atCount + 1);
            }
          }
          label848:
          localObject4 = XmlParser.parseXml(((fi)localObject3).field_content, "sysmsg", null);
          if (cc.cI((Map)localObject4)) {
            parami.pO(parami.field_UnReadInvite + 1);
          }
          for (;;)
          {
            if ((((fi)localObject3).field_isSend == 1) || (!((cc)localObject3).jcq())) {
              break label959;
            }
            parami.pS(parami.field_hasSpecialFollow + 1);
            break;
            i = 0;
            break label816;
            if (!((cc)localObject3).jcs()) {
              break label848;
            }
            parami.pL(parami.field_atCount + 4096);
            break label848;
            if (cc.cJ((Map)localObject4)) {
              parami.pO(parami.field_UnReadInvite + 4096);
            }
          }
        }
      }
      label961:
      int k = 0;
      int i = 0;
      if (paramc != null) {}
      for (localObject1 = paramc.talker;; localObject1 = null)
      {
        int j = k;
        if (paramc != null)
        {
          j = k;
          if (paramc.KRm != null)
          {
            j = k;
            if (paramc.KRm.equals("delete"))
            {
              if (paramc.KRo > 0) {
                i = paramc.KRo;
              }
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "notify delete count %d ", new Object[] { Integer.valueOf(paramc.KRo) });
              j = i;
            }
          }
        }
        if ((paramc != null) && (paramc.KRm != null) && (paramc.KRm.equals("insert"))) {
          if (paramc.KRn > 0)
          {
            i = paramc.KRn;
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "notify insert all count %d ", new Object[] { Integer.valueOf(paramc.KRn) });
          }
        }
        for (;;)
        {
          localObject2 = Util.nullAs((String)localObject1, "");
          if (localcc != null) {}
          for (l1 = localcc.field_msgSeq;; l1 = -1L)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d], ParentRef[%s]", new Object[] { localObject2, Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Thread.currentThread().getId()), parami.field_parentRef });
            if ((!bool) || (j <= 0) || (i != 0)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "summerdel ignore delete event [%s, %s]", new Object[] { localObject1, parami.field_username });
            AppMethodBeat.o(117074);
            return;
          }
          this.adiw.event(parami);
          this.adiw.doNotify();
          if (localObject1 == null)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "talker == null");
            AppMethodBeat.o(117074);
            return;
          }
          if (!((String)localObject1).equals(parami.field_username))
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
            AppMethodBeat.o(117074);
            return;
          }
          if ((localcc != null) && (localcc.field_msgId != 0L))
          {
            com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + localcc.field_msgId);
            parami.bG(localcc);
            if (this.adit != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              localObject4 = new PInt();
              this.adit.a(localcc, (PString)localObject2, (PString)localObject3, (PInt)localObject4, parami.rx(2097152));
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", new Object[] { ((PString)localObject3).value });
              parami.BF(((PString)localObject2).value);
              parami.BG(((PString)localObject3).value);
              parami.pJ(((PInt)localObject4).value);
              parami.BE(Integer.toString(localcc.getType()));
              if (this.adiu != null) {
                this.adiu.a(localcc, parami);
              }
              parami.gS(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(parami, 1, localcc.getCreateTime()));
              if (!bool) {
                break label1727;
              }
              localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject1);
              if ((localObject1 != null) && (!Util.isNullOrNil(((az)localObject1).field_username)) && (((au)localObject1).aSQ())) {
                parami.gS(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(parami, 2, 0L));
              }
              a(parami, j, i);
              if (localcc.getCreateTime() == 0L) {
                break label1717;
              }
              parami.gR(localcc.getCreateTime());
              label1599:
              h(parami);
            }
          }
          label1717:
          label1727:
          do
          {
            for (;;)
            {
              this.adix.event(parami);
              this.adix.doNotify();
              this.adiv.b(localcc, parami, bool, paramc);
              AppMethodBeat.o(117074);
              return;
              localObject2 = Z(localcc.getType(), parami.field_content);
              localObject3 = Util.nullAsNil(parami.field_digest);
              if (Util.isNullOrNil((String)localObject2)) {}
              for (localObject2 = "";; localObject2 = " " + Util.nullAsNil((String)localObject2))
              {
                parami.BF(((String)localObject3).concat((String)localObject2));
                break;
              }
              parami.gR(cn.bDu());
              break label1599;
              a(parami, j, i);
              a(parami, (String)localObject1, true);
              continue;
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "update null conversation with talker ".concat(String.valueOf(localObject1)));
              if (bool) {
                break label1792;
              }
              parami.jaJ();
              a(parami, j, i);
              a(parami, (String)localObject1, true);
            }
          } while (((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLW((String)localObject1) <= 0);
          label1792:
          if ((localcc != null) && (localcc.getCreateTime() != 0L)) {
            parami.gR(localcc.getCreateTime());
          }
          for (;;)
          {
            a(parami, j, i);
            h(parami);
            break;
            parami.gR(cn.bDu());
          }
          i = 0;
          break;
          i = 0;
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.h paramh)
  {
    this.adiu = paramh;
  }
  
  public final void a(bb parambb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117083);
    if (!br.JM(parambb.field_username))
    {
      AppMethodBeat.o(117083);
      return;
    }
    if (Util.nullAsNil(parambb.field_username).length() <= 0)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
      AppMethodBeat.o(117083);
      return;
    }
    if (parambb.field_msgCount == 0)
    {
      parambb.pF(br.JL(parambb.field_username));
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(parambb.field_msgCount), parambb.field_username, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(117083);
      return;
      if (paramInt1 > 0)
      {
        parambb.pF(parambb.field_msgCount - paramInt1);
        if (parambb.field_msgCount < 0)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
          parambb.pF(0);
        }
      }
      else if (paramInt2 > 0)
      {
        parambb.pF(parambb.field_msgCount + paramInt2);
      }
    }
  }
  
  public final void a(by.a parama)
  {
    AppMethodBeat.i(117070);
    this.adix.add(parama, null);
    AppMethodBeat.o(117070);
  }
  
  public final void a(by.b paramb)
  {
    this.adit = paramb;
  }
  
  public final boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(117089);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117089);
      return false;
    }
    if (bxM(paramString) == null)
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
      com.tencent.mm.sdk.platformtools.Log.i("Conversition", "wrong add attr flag: %s, %s, %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Util.getStack() });
      f.Ozc.b(20435, new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString });
    }
    paramBoolean = this.db.execSQL("rconversation", "update " + Og(paramString) + " set attrflag = " + i + " where username = \"" + Util.escapeSqlValue(paramString) + "\"");
    if (paramBoolean) {
      doNotify(3, this, paramString);
    }
    AppMethodBeat.o(117089);
    return paramBoolean;
  }
  
  public final by.b aDH()
  {
    return this.adit;
  }
  
  public final boolean aEb(String paramString)
  {
    AppMethodBeat.i(117111);
    paramString = this.db.query(Og(paramString), null, "username=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.close();
      AppMethodBeat.o(117111);
      return bool;
    }
  }
  
  public final Cursor ayU(int paramInt)
  {
    AppMethodBeat.i(249033);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "getUnreadConversationCursor filterType[%d] [%s]", new Object[] { Integer.valueOf(1), Util.getStack() });
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username, ");
    ((StringBuilder)localObject).append("rconversation.unReadCount, ");
    ((StringBuilder)localObject).append("rconversation.conversationTime");
    boolean bool = com.tencent.mm.contact.b.maH.aRG();
    ((StringBuilder)localObject).append(" from ").append(ab.a(bool, "rconversation", "username")).append("unReadCount > 0 AND  ( parentRef is ").append(com.tencent.mm.l.a.maX).append(" or parentRef = '' ) ").append(ab.j(bool, 1));
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "get unread conversation with black list, sql is %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(249033);
    return localObject;
  }
  
  public final Cursor b(ArrayList<String> paramArrayList, List<String> paramList, String paramString)
  {
    AppMethodBeat.i(249006);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef");
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
    if (com.tencent.mm.l.a.maX == paramString) {
      localStringBuilder.append(jaN());
    }
    for (;;)
    {
      localStringBuilder.append(Util.nullAsNil(ab.j(false, 1)));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramArrayList = new ArrayList(paramList).iterator();
      while (paramArrayList.hasNext())
      {
        paramList = (String)paramArrayList.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramList).append("'");
      }
      if ("*".equals(paramString)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(Util.escapeSqlValue(paramString)).append("' ");
      }
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(249006);
    return paramArrayList;
  }
  
  public final void b(com.tencent.mm.plugin.messenger.foundation.a.i parami)
  {
    AppMethodBeat.i(248825);
    this.adiv.remove(parami);
    AppMethodBeat.o(248825);
  }
  
  public final void b(by.a parama)
  {
    AppMethodBeat.i(117072);
    this.adiw.add(parama, null);
    AppMethodBeat.o(117072);
  }
  
  public final void bH(cc paramcc)
  {
    AppMethodBeat.i(117080);
    String str = paramcc.field_talker;
    int i = 0;
    bb localbb2 = bxM(str);
    if ((localbb2 != null) && (localbb2.field_conversationTime > paramcc.getCreateTime()) && (localbb2.field_conversationTime != 9223372036854775807L))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      AppMethodBeat.o(117080);
      return;
    }
    bb localbb1 = localbb2;
    if (localbb2 == null)
    {
      localbb1 = new bb(str);
      i = 1;
    }
    localbb1.pI(paramcc.field_isSend);
    localbb1.pG(localbb1.field_unReadCount);
    localbb1.bG(paramcc);
    localbb1.BE(Integer.toString(paramcc.getType()));
    localbb1.gS(localbb1.field_flag & 0x0 | paramcc.getCreateTime() & 0xFFFFFFFF);
    if (i != 0)
    {
      h(localbb1);
      AppMethodBeat.o(117080);
      return;
    }
    a(localbb1, str, true);
    AppMethodBeat.o(117080);
  }
  
  public final void bxK(String paramString)
  {
    AppMethodBeat.i(117076);
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", new Object[] { paramString, MMStack.getStack(true) });
    if (this.db.delete(Og(paramString), "username=?", new String[] { paramString }) != 0) {
      doNotify(5, this, paramString);
    }
    AppMethodBeat.o(117076);
  }
  
  public final boolean bxL(String paramString)
  {
    AppMethodBeat.i(117078);
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[] { paramString, MMStack.getStack(true) });
    boolean bool = this.db.execSQL("rconversation", "delete from " + Og(paramString) + " where username like '%" + paramString + "'");
    if (bool) {
      doNotify(5, this, paramString);
    }
    AppMethodBeat.o(117078);
    return bool;
  }
  
  public final bb bxM(String paramString)
  {
    AppMethodBeat.i(117079);
    Cursor localCursor = this.db.query(Og(paramString), null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ConversationStorage", "get null with username:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(117079);
      return null;
    }
    paramString = new bb();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117079);
    return paramString;
  }
  
  public final void bxN(String paramString)
  {
    AppMethodBeat.i(117085);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, "username=?", new String[] { paramString });
    AppMethodBeat.o(117085);
  }
  
  public final boolean bxO(String paramString)
  {
    AppMethodBeat.i(117086);
    if ((paramString == null) || (paramString.length() <= 0)) {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "update conversation failed");
    }
    int i;
    do
    {
      AppMethodBeat.o(117086);
      return false;
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", new Object[] { paramString });
      bb localbb = bxM(paramString);
      if (localbb == null)
      {
        AppMethodBeat.o(117086);
        return true;
      }
      a(localbb, false);
      if ((localbb.field_unReadCount == 0) && (localbb.field_unReadMuteCount == 0) && (paramString.equals(localbb.field_username)))
      {
        a(paramString, 1048576, false, localbb.field_attrflag);
        localContentValues = new ContentValues();
        localContentValues.put("UnReadInvite", Integer.valueOf(0));
        localContentValues.put("atCount", Integer.valueOf(0));
        localContentValues.put("parentRef", localbb.field_parentRef);
        if (this.db.update(Og(paramString), localContentValues, "username= ?", new String[] { Util.escapeSqlValue(paramString) }) > 0) {
          doNotify(3, this, paramString);
        }
        AppMethodBeat.o(117086);
        return true;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("unReadCount", Integer.valueOf(0));
      localContentValues.put("unReadMuteCount", Integer.valueOf(0));
      localContentValues.put("UnReadInvite", Integer.valueOf(0));
      localContentValues.put("atCount", Integer.valueOf(0));
      localContentValues.put("attrflag", Integer.valueOf(localbb.field_attrflag & 0xFFEFFFFF));
      localContentValues.put("parentRef", localbb.field_parentRef);
      i = this.db.update(Og(paramString), localContentValues, "username= ?", new String[] { Util.escapeSqlValue(paramString) });
      if (i > 0) {
        doNotify(3, this, paramString);
      }
    } while (i <= 0);
    AppMethodBeat.o(117086);
    return true;
  }
  
  public final boolean bxP(String paramString)
  {
    AppMethodBeat.i(117087);
    if (paramString.length() <= 0)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "update updateUnreadByParentRef failed");
      AppMethodBeat.o(117087);
      return false;
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "updateUnreadByParentRef %s", new Object[] { paramString });
    bb localbb = bxM(paramString);
    if (localbb == null)
    {
      AppMethodBeat.o(117087);
      return true;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("unReadCount", Integer.valueOf(0));
    localContentValues.put("unReadMuteCount", Integer.valueOf(0));
    localContentValues.put("UnReadInvite", Integer.valueOf(0));
    localContentValues.put("atCount", Integer.valueOf(0));
    localContentValues.put("attrflag", Integer.valueOf(localbb.field_attrflag & 0xFFEFFFFF));
    int i = this.db.update(Og(paramString), localContentValues, "parentRef= ?", new String[] { Util.escapeSqlValue(paramString) });
    if (i > 0) {
      doNotify(3, this, paramString);
    }
    if (i > 0)
    {
      AppMethodBeat.o(117087);
      return true;
    }
    AppMethodBeat.o(117087);
    return false;
  }
  
  public final boolean bxQ(String paramString)
  {
    AppMethodBeat.i(117088);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(117088);
      return false;
    }
    bb localbb = bxM(paramString);
    if ((localbb == null) || ((localbb.field_unReadCount > 0) && (paramString.equals(localbb.field_username))))
    {
      AppMethodBeat.o(117088);
      return true;
    }
    localbb.pK(localbb.field_attrflag | 0x100000);
    a(localbb, false);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("unReadCount", Integer.valueOf(1));
    localContentValues.put("atCount", Integer.valueOf(0));
    localContentValues.put("attrflag", Integer.valueOf(localbb.field_attrflag));
    localContentValues.put("parentRef", localbb.field_parentRef);
    int i = this.db.update(Og(paramString), localContentValues, "username= ?", new String[] { Util.escapeSqlValue(paramString) });
    if (i > 0) {
      doNotify(3, this, paramString);
    }
    if (i > 0)
    {
      AppMethodBeat.o(117088);
      return true;
    }
    AppMethodBeat.o(117088);
    return false;
  }
  
  public final boolean bxR(String paramString)
  {
    AppMethodBeat.i(248968);
    com.tencent.mm.storage.b.a locala = com.tencent.mm.storage.b.a.admS;
    if (com.tencent.mm.storage.b.a.jdO())
    {
      if ((paramString == null) || (paramString.isEmpty()) || (paramString.equalsIgnoreCase("message_fold")))
      {
        AppMethodBeat.o(248968);
        return true;
      }
      AppMethodBeat.o(248968);
      return false;
    }
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(248968);
      return true;
    }
    AppMethodBeat.o(248968);
    return false;
  }
  
  public final boolean bxS(String paramString)
  {
    AppMethodBeat.i(117094);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
      AppMethodBeat.o(117094);
      return false;
    }
    paramString = bxM(paramString);
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
      AppMethodBeat.o(117094);
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1 = 0L;
    Cursor localCursor = this.db.rawQuery("select max(conversationTime) as conversationTime from rconversation", null, 2);
    while (localCursor.moveToNext()) {
      l1 = localCursor.getLong(0);
    }
    localCursor.close();
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", new Object[] { Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
    long l3 = cn.bDu();
    l2 = l1;
    if (l1 > l3)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ConversationStorage", "conversationTime=%s serverTime=%s diff=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 - l1) });
      l2 = l3;
    }
    l1 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 1, l2 + 1L);
    boolean bool = this.db.execSQL("rconversation", "update " + Og(paramString.field_username) + " set flag = " + l1 + " where username = \"" + Util.escapeSqlValue(paramString.field_username) + "\"");
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "[setMoveUp] flag=%s result=%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool) });
    if (bool) {
      doNotify(3, this, paramString.field_username);
    }
    AppMethodBeat.o(117094);
    return bool;
  }
  
  public final boolean bxT(String paramString)
  {
    AppMethodBeat.i(117095);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
      AppMethodBeat.o(117095);
      return false;
    }
    if (bxM(paramString) == null)
    {
      localObject = new bb(paramString);
      ((bb)localObject).gR(System.currentTimeMillis());
      h((bb)localObject);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "setPlacedTop username = ".concat(String.valueOf(paramString)));
    }
    paramString = bxM(paramString);
    a(paramString, true);
    if (paramString == null)
    {
      AppMethodBeat.o(117095);
      return false;
    }
    long l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 2, 0L);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("update " + Og(paramString.field_username) + " set flag = " + l);
    if ("message_fold".equals(paramString.field_parentRef)) {
      ((StringBuilder)localObject).append(" , parentRef = '").append(Util.escapeSqlValue(paramString.field_parentRef)).append("' ");
    }
    ((StringBuilder)localObject).append(" where username = \"").append(Util.escapeSqlValue(paramString.field_username)).append("\"");
    boolean bool = this.db.execSQL("rconversation", ((StringBuilder)localObject).toString());
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      doNotify(3, this, paramString.field_username);
    }
    AppMethodBeat.o(117095);
    return bool;
  }
  
  public final boolean bxU(String paramString)
  {
    AppMethodBeat.i(117096);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
      AppMethodBeat.o(117096);
      return false;
    }
    boolean bool = j(bxM(paramString));
    AppMethodBeat.o(117096);
    return bool;
  }
  
  public final boolean bxV(String paramString)
  {
    AppMethodBeat.i(117098);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
      AppMethodBeat.o(117098);
      return false;
    }
    boolean bool = k(bxM(paramString));
    AppMethodBeat.o(117098);
    return bool;
  }
  
  public final boolean bxW(String paramString)
  {
    AppMethodBeat.i(248992);
    if (bxV(paramString))
    {
      paramString = com.tencent.mm.storage.b.a.admS;
      if (com.tencent.mm.storage.b.a.jdP())
      {
        AppMethodBeat.o(248992);
        return true;
      }
    }
    AppMethodBeat.o(248992);
    return false;
  }
  
  public final Cursor bxY(String paramString)
  {
    AppMethodBeat.i(117106);
    paramString = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + Util.nullAsNil(paramString) + " order by flag desc, conversationTime desc";
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(117106);
    return paramString;
  }
  
  public final Cursor bxZ(String paramString)
  {
    AppMethodBeat.i(249032);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, ");
    localStringBuilder.append("parentRef");
    localStringBuilder.append(" from rconversation where username = '").append(paramString).append("' AND unReadCount > 0 ");
    paramString = localStringBuilder.toString();
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "get unread by username, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(249032);
    return paramString;
  }
  
  public final Cursor bya(String paramString)
  {
    AppMethodBeat.i(249036);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT rcontact.* FROM rcontact,rconversation");
    localStringBuilder.append(" WHERE unReadCount > 0 AND ").append(jaN());
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(Util.nullAsNil(paramString));
    localStringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
    paramString = localStringBuilder.toString();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "get total unread contact with black list, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(249036);
    return paramString;
  }
  
  public final int byb(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117119);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM rconversation");
    localStringBuilder.append(" WHERE parentRef = '").append(paramString).append("'");
    paramString = localStringBuilder.toString();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null, 2);
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
  
  public final String byc(String paramString)
  {
    AppMethodBeat.i(117120);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = '").append(paramString).append("'");
    ((StringBuilder)localObject).append(" ORDER BY conversationTime DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    paramString = ((StringBuilder)localObject).toString();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null, 2);
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
  
  public final int byd(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117122);
    paramString = "select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + Util.nullAsNil(paramString);
    paramString = this.db.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117122);
    return i;
  }
  
  public final bb bye(String paramString)
  {
    AppMethodBeat.i(117124);
    Cursor localCursor = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(1, null, paramString);
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        paramString = new bb();
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
  
  public final int byf(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117126);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(atCount) from rconversation");
    localStringBuilder.append(" where unReadCount > 0");
    if (!Util.isNullOrNil(paramString)) {
      localStringBuilder.append(" and username = '").append(paramString).append("'");
    }
    localStringBuilder.append(" and ").append(jaN());
    paramString = localStringBuilder.toString();
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "query sql: %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null, 2);
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
  
  public final void byg(String paramString)
  {
    AppMethodBeat.i(117129);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Update rconversation");
    ((StringBuilder)localObject).append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + Util.escapeSqlValue(paramString) + "\"");
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", new Object[] { localObject });
    if (this.db.execSQL("rconversation", (String)localObject)) {
      doNotify(3, this, paramString);
    }
    AppMethodBeat.o(117129);
  }
  
  public final void byh(String paramString)
  {
    AppMethodBeat.i(117130);
    int i = this.db.delete(Og(paramString), "username=? or parentRef =?", new String[] { paramString, paramString });
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i != 0) {
      doNotify(5, this, paramString);
    }
    AppMethodBeat.o(117130);
  }
  
  public final int byi(String paramString)
  {
    int i = -1;
    AppMethodBeat.i(117131);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117131);
      return -1;
    }
    paramString = "select msgCount from rconversation where username=" + com.tencent.mm.storagebase.h.EQ(paramString);
    paramString = this.db.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117131);
    return i;
  }
  
  public final int c(bb parambb, String paramString)
  {
    AppMethodBeat.i(369610);
    int i = a(parambb, paramString, true);
    AppMethodBeat.o(369610);
    return i;
  }
  
  public final void c(by.a parama)
  {
    AppMethodBeat.i(117073);
    this.adiw.remove(parama);
    AppMethodBeat.o(117073);
  }
  
  public final void cv(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(117107);
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", new Object[] { MMStack.getStack(true) });
    if (paramLinkedList.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
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
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", new Object[] { localStringBuilder.toString() });
    this.db.execSQL("rconversation", localStringBuilder.toString());
    AppMethodBeat.o(117107);
  }
  
  public final Cursor d(List<String> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(249003);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.l.a.maX == paramString) {
      localStringBuilder.append(jaN());
    }
    for (;;)
    {
      localStringBuilder.append(Util.nullAsNil(ab.j(false, 1)));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramList = new ArrayList(paramList).iterator();
      while (paramList.hasNext())
      {
        paramString = (String)paramList.next();
        localStringBuilder.append(" and rconversation.username != '").append(paramString).append("'");
      }
      if ("*".equals(paramString)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(Util.escapeSqlValue(paramString)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc");
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + localStringBuilder.toString());
    paramList = this.db;
    paramString = localStringBuilder.toString();
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      paramList = paramList.rawQuery(paramString, null, i);
      AppMethodBeat.o(249003);
      return paramList;
    }
  }
  
  public final void e(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(117125);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Update rconversation");
    localStringBuilder.append(" set parentRef = '").append(Util.nullAsNil(paramString)).append("' where 1 != 1 ");
    int i = 0;
    while (i <= 0)
    {
      paramString = paramArrayOfString[0];
      localStringBuilder.append(" or username = '").append(paramString).append("'");
      i += 1;
    }
    paramString = localStringBuilder.toString();
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "update sql: %s", new Object[] { paramString });
    if (this.db.execSQL("rconversation", paramString))
    {
      i = 0;
      while (i <= 0)
      {
        doNotify(3, this, paramArrayOfString[0]);
        i += 1;
      }
    }
    AppMethodBeat.o(117125);
  }
  
  public final long h(bb parambb)
  {
    AppMethodBeat.i(117082);
    String str = Util.nullAsNil(parambb.field_username);
    if (str.length() <= 0)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
      AppMethodBeat.o(117082);
      return -1L;
    }
    parambb.gS(g(parambb));
    i(parambb);
    long l = this.db.insert(Og(str), null, parambb.convertTo());
    if (l != -1L) {
      doNotify(2, this, parambb.field_username);
    }
    for (;;)
    {
      AppMethodBeat.o(117082);
      return l;
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", new Object[] { Og(str) });
    }
  }
  
  public final boolean j(bb parambb)
  {
    AppMethodBeat.i(117097);
    if (parambb == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
      AppMethodBeat.o(117097);
      return false;
    }
    long l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(parambb, 3, parambb.field_conversationTime);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update " + Og(parambb.field_username) + " set flag = " + l);
    if ("message_fold".equals(parambb.field_parentRef)) {
      localStringBuilder.append(" , parentRef = '' ");
    }
    localStringBuilder.append(" where username = \"").append(Util.escapeSqlValue(parambb.field_username)).append("\"");
    boolean bool = this.db.execSQL("rconversation", localStringBuilder.toString());
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      doNotify(3, this, parambb.field_username);
    }
    AppMethodBeat.o(117097);
    return bool;
  }
  
  public final boolean jaK()
  {
    AppMethodBeat.i(117077);
    boolean bool1 = this.db.execSQL("rconversation", "delete from rconversation");
    boolean bool2 = this.db.execSQL("rconversation", "delete from rbottleconversation");
    if ((bool1) || (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      if (bool1) {
        doNotify(5, this, "");
      }
      AppMethodBeat.o(117077);
      return bool1;
    }
  }
  
  public final HashMap<String, Long> jaL()
  {
    AppMethodBeat.i(117081);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    Cursor localCursor = this.db.query("rconversation", new String[] { "username", "conversationTime" }, null, null, null, null, null, 2);
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
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(117081);
    return localHashMap;
  }
  
  public final void jaM()
  {
    AppMethodBeat.i(117084);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, null, null);
    AppMethodBeat.o(117084);
  }
  
  public final List<String> jaO()
  {
    AppMethodBeat.i(117101);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select rconversation.username from rconversation,rcontact where ");
    ((StringBuilder)localObject).append("rconversation.username = rcontact.username");
    ((StringBuilder)localObject).append(Util.nullAsNil(Util.nullAsNil(ab.ojZ)));
    ((StringBuilder)localObject).append(" and ( verifyFlag & 8 ) = 0");
    ((StringBuilder)localObject).append(" and ").append(jaN());
    String[] arrayOfString = ab.oko;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ((StringBuilder)localObject).append(" and rconversation.username != '").append(str).append("'");
      i += 1;
    }
    ((StringBuilder)localObject).append(" order by sightTime desc, flag desc, conversationTime desc");
    localObject = this.db.rawQuery(((StringBuilder)localObject).toString(), null, 2);
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
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "user list:%s", new Object[] { localArrayList });
    AppMethodBeat.o(117101);
    return localArrayList;
  }
  
  public final Cursor jaP()
  {
    AppMethodBeat.i(117110);
    Cursor localCursor = this.db.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    AppMethodBeat.o(117110);
    return localCursor;
  }
  
  public final int jaQ()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117117);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT SUM(rconversation.unReadCount)");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null, 2);
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
  
  public final String jaR()
  {
    AppMethodBeat.i(117118);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    ((StringBuilder)localObject).append(" ORDER BY flag DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null, 2);
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
  
  public final Cursor jaS()
  {
    AppMethodBeat.i(117121);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", new Object[] { "select count(*) from rbottleconversation where unReadCount > 0" });
    Cursor localCursor = this.db.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
    AppMethodBeat.o(117121);
    return localCursor;
  }
  
  public final List<bb> jaT()
  {
    AppMethodBeat.i(249045);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = a(5, null, "conversationboxservice");
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      while (localCursor.moveToNext())
      {
        bb localbb = new bb();
        localbb.convertFrom(localCursor);
        localLinkedList.add(localbb);
      }
      localCursor.close();
    }
    AppMethodBeat.o(249045);
    return localLinkedList;
  }
  
  public final Cursor jaU()
  {
    AppMethodBeat.i(117132);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username, ");
    ((StringBuilder)localObject).append("rconversation.unReadCount");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE unReadCount > 0");
    ((StringBuilder)localObject).append(" AND ").append(jaN());
    localObject = this.db.rawQuery(((StringBuilder)localObject).toString(), null);
    AppMethodBeat.o(117132);
    return localObject;
  }
  
  public final boolean k(bb parambb)
  {
    AppMethodBeat.i(117099);
    if (parambb == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
      AppMethodBeat.o(117099);
      return false;
    }
    if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(parambb, 4, 0L) != 0L)
    {
      AppMethodBeat.o(117099);
      return true;
    }
    AppMethodBeat.o(117099);
    return false;
  }
  
  public final boolean l(bb parambb)
  {
    AppMethodBeat.i(248987);
    if (parambb == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ConversationStorage", "conv is null ");
      AppMethodBeat.o(248987);
      return false;
    }
    if ("conversationboxservice".equals(parambb.field_parentRef))
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "conv is in conv box");
      AppMethodBeat.o(248987);
      return true;
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "conv is not in conv box");
    AppMethodBeat.o(248987);
    return false;
  }
  
  public final boolean m(bb parambb)
  {
    AppMethodBeat.i(248989);
    if (k(parambb))
    {
      parambb = com.tencent.mm.storage.b.a.admS;
      if (com.tencent.mm.storage.b.a.jdP())
      {
        AppMethodBeat.o(248989);
        return true;
      }
    }
    AppMethodBeat.o(248989);
    return false;
  }
  
  public final List<String> nd(List<String> paramList)
  {
    AppMethodBeat.i(249022);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramList = new ArrayList();
    localObject = T(" where username", (List)localObject);
    localObject = "select username from rconversation" + (String)localObject;
    localObject = (String)localObject + " order by flag desc, conversationTime desc";
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationStorage", "getAllConvUserName sql %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null);
    int i = ((Cursor)localObject).getColumnIndex("username");
    while (((Cursor)localObject).moveToNext()) {
      paramList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(249022);
    return paramList;
  }
  
  public final Cursor p(List<String> paramList, int paramInt1, int paramInt2)
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
        paramList = paramList + "username != \"" + Util.escapeSqlValue((String)((List)localObject).get(i)) + "\"";
        i += 1;
        break;
      }
    }
    paramList = paramList + " order by flag desc, conversationTime desc limit " + paramInt2 + " offset " + paramInt1;
    paramList = this.db.rawQuery(paramList, null);
    AppMethodBeat.o(117109);
    return paramList;
  }
  
  public final Cursor pJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249072);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, conversationTime, username, flag");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.l.a.maX == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = ''  or ").append(ab(new String[] { "message_fold" }) + " ) ");
    }
    for (;;)
    {
      localStringBuilder.append(Util.nullAsNil(paramString1));
      localStringBuilder.append(" order by flag desc");
      localStringBuilder.append(" limit 18");
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + localStringBuilder.toString());
      paramString1 = this.db.rawQuery(localStringBuilder.toString(), null);
      AppMethodBeat.o(249072);
      return paramString1;
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(Util.escapeSqlValue(paramString2)).append("' ");
      }
    }
  }
  
  public final boolean shouldProcessEvent()
  {
    AppMethodBeat.i(117128);
    if ((this.db == null) || (this.db.isClose()))
    {
      if (this.db == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.db.isClose()))
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ConversationStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(117128);
        return false;
      }
    }
    AppMethodBeat.o(117128);
    return true;
  }
  
  static final class a
    extends com.tencent.mm.cp.a<com.tencent.mm.plugin.messenger.foundation.a.i>
    implements com.tencent.mm.plugin.messenger.foundation.a.i
  {
    public final void a(final cc paramcc, final i.c paramc, final boolean[] paramArrayOfBoolean)
    {
      AppMethodBeat.i(248474);
      a(new a.a() {});
      AppMethodBeat.o(248474);
    }
    
    public final void a(final cc paramcc, final bb parambb, final boolean paramBoolean, final i.c paramc)
    {
      AppMethodBeat.i(117065);
      a(new a.a() {});
      AppMethodBeat.o(117065);
    }
    
    public final void b(final cc paramcc, final bb parambb, final boolean paramBoolean, final i.c paramc)
    {
      AppMethodBeat.i(117066);
      a(new a.a() {});
      AppMethodBeat.o(117066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bc
 * JD-Core Version:    0.7.0.1
 */