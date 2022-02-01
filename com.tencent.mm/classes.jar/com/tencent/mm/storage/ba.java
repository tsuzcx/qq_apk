package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
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

public final class ba
  extends MStorageEx
  implements bw
{
  public static final String[] SQL_CREATE;
  private bw.b VEG;
  private com.tencent.mm.plugin.messenger.foundation.a.h VEH;
  private ba.a VEI;
  private MStorageEvent<bw.a, az> VEJ;
  private MStorageEvent<bw.a, az> VEK;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(117133);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.o.a.info, "rconversation"), MAutoStorage.getCreateSQLs(com.tencent.mm.o.a.info, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE INDEX IF NOT EXISTS rconversation_unreadcount_index ON rconversation ( unReadCount )", "DROP INDEX IF EXISTS multi_index ", "DROP INDEX IF EXISTS rconversation_multi_index", "CREATE INDEX IF NOT EXISTS rconversation_parentref_index ON  rconversation ( parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )", "CREATE INDEX IF NOT EXISTS rconversation_flag_parentref_index ON  rconversation ( flag,parentRef )" };
    AppMethodBeat.o(117133);
  }
  
  public ba(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(117067);
    this.VEI = new ba.a((byte)0);
    this.VEJ = new MStorageEvent() {};
    this.VEK = new MStorageEvent() {};
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
      localObject = MAutoStorage.getUpdateSQLs(com.tencent.mm.o.a.info, "rconversation", paramISQLiteDatabase);
      ((List)localObject).addAll(MAutoStorage.getUpdateSQLs(com.tencent.mm.o.a.info, "rbottleconversation", paramISQLiteDatabase));
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
  
  private static String L(String paramString, List<String> paramList)
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
  
  private static String Wf(String paramString)
  {
    AppMethodBeat.i(117068);
    Log.v("MicroMsg.ConversationStorage", "talker :".concat(String.valueOf(paramString)));
    if (as.PY(paramString))
    {
      AppMethodBeat.o(117068);
      return "rbottleconversation";
    }
    AppMethodBeat.o(117068);
    return "rconversation";
  }
  
  private static String bIP(String paramString)
  {
    AppMethodBeat.i(292901);
    paramString = " and ( rconversation.username like '%" + paramString + "%' or content like '%" + paramString + "%' or rcontact.nickname like '%" + paramString + "%' or rcontact.alias like '%" + paramString + "%' or rcontact.pyInitial like '%" + paramString + "%' or rcontact.quanPin like '%" + paramString + "%' or rcontact.conRemark like '%" + paramString + "%'  ) ";
    AppMethodBeat.o(292901);
    return paramString;
  }
  
  private static long d(az paramaz)
  {
    AppMethodBeat.i(117075);
    if (paramaz != null)
    {
      l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramaz, paramaz.field_conversationTime);
      AppMethodBeat.o(117075);
      return l;
    }
    long l = Util.nowMilliSecond();
    AppMethodBeat.o(117075);
    return l & 0xFFFFFFFF;
  }
  
  private static void f(az paramaz)
  {
    AppMethodBeat.i(117092);
    if (paramaz == null)
    {
      AppMethodBeat.o(117092);
      return;
    }
    if (paramaz.field_unReadCount > 0)
    {
      Log.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
      if ((paramaz.field_attrflag & 0x100000) != 0)
      {
        paramaz.pH(paramaz.field_unReadCount - 1);
        paramaz.pL(paramaz.field_attrflag & 0xFFEFFFFF);
      }
    }
    AppMethodBeat.o(117092);
  }
  
  public final int a(az paramaz, String paramString)
  {
    AppMethodBeat.i(186131);
    int i = a(paramaz, paramString, true);
    AppMethodBeat.o(186131);
    return i;
  }
  
  public final int a(az paramaz, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117091);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(117091);
      return 0;
    }
    if (paramBoolean) {
      paramaz.EC(d(paramaz));
    }
    f(paramaz);
    int i = this.db.update(Wf(paramString), paramaz.convertTo(), "username=?", new String[] { paramString });
    if (i != 0) {
      doNotify(3, this, paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(117091);
      return i;
      Log.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", new Object[] { Wf(paramString) });
    }
  }
  
  public final Cursor a(int paramInt, List<String> paramList, String paramString)
  {
    AppMethodBeat.i(189368);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from rconversation where ");
    if (com.tencent.mm.o.a.jxD == paramString) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(Util.nullAsNil(ab.m(false, paramInt)));
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
    paramList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(189368);
    return paramList;
  }
  
  public final Cursor a(int paramInt, List<String> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(189425);
    String str = " ";
    Object localObject = str;
    if (paramString2 != null)
    {
      localObject = str;
      if (paramString2.length() > 0) {
        localObject = " and rconversation.username = rcontact.username ";
      }
    }
    localObject = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + " " + " where rconversation.username = rcontact.username" + (String)localObject + Util.nullAsNil(ab.m(false, paramInt));
    paramList = L(" and rconversation.username", paramList);
    localObject = (String)localObject + paramList;
    paramList = (List<String>)localObject;
    if (paramBoolean) {
      paramList = (String)localObject + " and ( verifyFlag & 8 ) = 0";
    }
    localObject = paramList;
    if (com.tencent.mm.o.a.jxD == paramString1) {
      localObject = paramList + " and ( parentRef is null or parentRef = '' ) ";
    }
    paramList = (List<String>)localObject;
    if (paramString2 != null)
    {
      paramList = (List<String>)localObject;
      if (paramString2.length() > 0) {
        paramList = (String)localObject + bIP(paramString2);
      }
    }
    if ((paramString2 == null) || (paramString2.equals(""))) {}
    for (paramList = paramList + " order by flag desc, conversationTime desc";; paramList = paramList + " order by rconversation.username like \"%@chatroom\" asc")
    {
      Log.d("MicroMsg.ConversationStorage", "getSearchCursor sql ".concat(String.valueOf(paramList)));
      paramList = this.db.rawQuery(paramList, null);
      AppMethodBeat.o(189425);
      return paramList;
    }
  }
  
  public final Cursor a(List<String> paramList1, int paramInt, List<String> paramList2, String paramString1, boolean paramBoolean, String paramString2)
  {
    int j = 0;
    AppMethodBeat.i(292900);
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
    ((StringBuilder)localObject).append(Util.nullAsNil(ab.m(false, paramInt)));
    ((StringBuilder)localObject).append(L(" and rconversation.username", paramList2));
    if (paramBoolean) {
      ((StringBuilder)localObject).append(" and ( verifyFlag & 8 ) = 0");
    }
    if (com.tencent.mm.o.a.jxD == paramString1) {
      ((StringBuilder)localObject).append(" and ( parentRef is null or parentRef = '' ) ");
    }
    if (paramString2.length() > 0) {
      ((StringBuilder)localObject).append(bIP(paramString2));
    }
    ((StringBuilder)localObject).append("order by case rconversation.username ");
    paramInt = j;
    while (paramInt < paramList1.size())
    {
      ((StringBuilder)localObject).append(" when '").append((String)paramList1.get(paramInt)).append("' then ").append(paramInt);
      paramInt += 1;
    }
    ((StringBuilder)localObject).append(" end");
    Log.d("MicroMsg.ConversationStorage", "getCursorByNamesInListOrder sql:".concat(String.valueOf(localObject)));
    paramList1 = this.db.rawQuery(((StringBuilder)localObject).toString().toString(), null);
    AppMethodBeat.o(292900);
    return paramList1;
  }
  
  public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.i parami)
  {
    AppMethodBeat.i(117069);
    parami = this.VEI.add(parami);
    AppMethodBeat.o(117069);
    return parami;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(117074);
    if (paramc == null)
    {
      Log.f("MicroMsg.ConversationStorage", "null notifyInfo");
      AppMethodBeat.o(117074);
      return;
    }
    if ((ab.Qg(paramc.talker)) || (ab.Qh(paramc.talker)))
    {
      AppMethodBeat.o(117074);
      return;
    }
    Object localObject1 = paramc.talker;
    ca localca = parami.aOH((String)localObject1);
    parami = new boolean[1];
    parami[0] = 0;
    this.VEI.a(localca, paramc, parami);
    if (parami[0] != 0)
    {
      AppMethodBeat.o(117074);
      return;
    }
    parami = bwx((String)localObject1);
    if (parami == null)
    {
      Log.i("MicroMsg.ConversationStorage", "create new cvs:%s", new Object[] { localObject1 });
      parami = new az((String)localObject1);
      if (as.PY((String)localObject1)) {
        parami.pI(1);
      }
      if ((localca != null) && (!Util.isNullOrNil(localca.hxy)))
      {
        localObject1 = bq.RR(localca.hxy);
        if ((localObject1 != null) && ((((bq.b)localObject1).luw & 0x40) != 0L))
        {
          Log.w("MicroMsg.ConversationStorage", "not fas msg no need to create conversation");
          AppMethodBeat.o(117074);
          return;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.VEI.a(localca, parami, bool, paramc);
      Log.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d", new Object[] { paramc.talker, paramc.EVM, Integer.valueOf(paramc.xKO) });
      long l1;
      long l2;
      if ((localca != null) && (localca.field_msgId != 0L))
      {
        if ((paramc.xKO == 1) && (((ca)paramc.kvM.get(0)).field_msgId != localca.field_msgId)) {
          Log.w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", new Object[] { Long.valueOf(localca.field_msgId), Long.valueOf(((ca)paramc.kvM.get(0)).field_msgId) });
        }
        i = localca.field_flag;
        l1 = parami.field_lastSeq;
        l2 = localca.field_msgSeq;
        Log.i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(parami.field_UnDeliverCount) });
        if (((!paramc.EVM.equals("insert")) || (paramc.xKO <= 0)) && ((!paramc.EVM.equals("update")) || (parami.field_unReadCount + paramc.xKO < 0))) {
          break label625;
        }
        parami.pH(parami.field_unReadCount + paramc.xKO);
        if (l2 > l1)
        {
          Log.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", new Object[] { Long.valueOf(l2) });
          parami.ED(l2);
        }
        if ((localca.dlT()) && (localca.field_isSend == 1))
        {
          parami.field_sightTime = localca.field_createTime;
          parami.hEx = true;
        }
      }
      Object localObject2;
      Object localObject3;
      if ((paramc.EVM.equals("insert")) && (paramc.kvM.size() > 0) && (ab.Lj(paramc.talker)))
      {
        localObject1 = z.bcZ();
        localObject2 = paramc.kvM.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label925;
          }
          localObject3 = (ca)((Iterator)localObject2).next();
          if (localObject3 == null)
          {
            Log.e("MicroMsg.ConversationStorage", "[onMsgInfoStgNotifyChange] msgInfo is null.");
            continue;
            label625:
            if ((paramc.EVO <= 0) || (l2 >= l1) || (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(parami.field_username, l1).field_msgId != 0L)) {
              break;
            }
            long l3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aPb(parami.field_username);
            Log.i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
            parami.ED(l2);
            if (l1 <= l3) {
              break;
            }
            ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aI(parami.field_username, l3);
            break;
          }
          if (((et)localObject3).field_isSend != 1) {
            if (!((ca)localObject3).hwH())
            {
              if (((ca)localObject3).getType() != 503316529) {
                break label874;
              }
              i = 1;
              label807:
              if (i == 0) {}
            }
            else
            {
              if ((!((ca)localObject3).bwY((String)localObject1)) && (!((ca)localObject3).hAk())) {
                break label879;
              }
              parami.pM(parami.field_atCount + 1);
            }
          }
          for (;;)
          {
            localObject3 = XmlParser.parseXml(((et)localObject3).field_content, "sysmsg", null);
            if (!ca.ck((Map)localObject3)) {
              break label902;
            }
            parami.pP(parami.field_UnReadInvite + 1);
            break;
            label874:
            i = 0;
            break label807;
            label879:
            if (((ca)localObject3).hAl()) {
              parami.pM(parami.field_atCount + 4096);
            }
          }
          label902:
          if (ca.cl((Map)localObject3)) {
            parami.pP(parami.field_UnReadInvite + 4096);
          }
        }
      }
      label925:
      int k = 0;
      int i = 0;
      if (paramc != null) {}
      for (localObject1 = paramc.talker;; localObject1 = null)
      {
        int j = k;
        if (paramc != null)
        {
          j = k;
          if (paramc.EVM != null)
          {
            j = k;
            if (paramc.EVM.equals("delete"))
            {
              if (paramc.EVO > 0) {
                i = paramc.EVO;
              }
              Log.i("MicroMsg.ConversationStorage", "notify delete count %d ", new Object[] { Integer.valueOf(paramc.EVO) });
              j = i;
            }
          }
        }
        if ((paramc != null) && (paramc.EVM != null) && (paramc.EVM.equals("insert"))) {
          if (paramc.EVN > 0)
          {
            i = paramc.EVN;
            Log.i("MicroMsg.ConversationStorage", "notify insert all count %d ", new Object[] { Integer.valueOf(paramc.EVN) });
          }
        }
        for (;;)
        {
          localObject2 = Util.nullAs((String)localObject1, "");
          if (localca != null) {}
          for (l1 = localca.field_msgSeq;; l1 = -1L)
          {
            Log.i("MicroMsg.ConversationStorage", "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d], ParentRef[%s]", new Object[] { localObject2, Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Thread.currentThread().getId()), parami.field_parentRef });
            if ((!bool) || (j <= 0) || (i != 0)) {
              break;
            }
            Log.i("MicroMsg.ConversationStorage", "summerdel ignore delete event [%s, %s]", new Object[] { localObject1, parami.field_username });
            AppMethodBeat.o(117074);
            return;
          }
          this.VEJ.event(parami);
          this.VEJ.doNotify();
          if (localObject1 == null)
          {
            Log.e("MicroMsg.ConversationStorage", "talker == null");
            AppMethodBeat.o(117074);
            return;
          }
          if (!((String)localObject1).equals(parami.field_username))
          {
            Log.e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
            AppMethodBeat.o(117074);
            return;
          }
          if ((localca != null) && (localca.field_msgId != 0L))
          {
            Log.v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + localca.field_msgId);
            parami.bq(localca);
            if (this.VEG != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              PInt localPInt = new PInt();
              this.VEG.a(localca, (PString)localObject2, (PString)localObject3, localPInt, parami.rp(2097152));
              Log.d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", new Object[] { ((PString)localObject3).value });
              parami.Ja(((PString)localObject2).value);
              parami.Jb(((PString)localObject3).value);
              parami.pK(localPInt.value);
              parami.IZ(Integer.toString(localca.getType()));
              if (this.VEH != null) {
                this.VEH.a(localca, parami);
              }
              parami.EC(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(parami, 1, localca.field_createTime));
              if (!bool) {
                break label1691;
              }
              localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject1);
              if ((localObject1 != null) && (!Util.isNullOrNil(((ax)localObject1).field_username)) && (((as)localObject1).ayn())) {
                parami.EC(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(parami, 2, 0L));
              }
              a(parami, j, i);
              if (localca.field_createTime == 0L) {
                break label1681;
              }
              parami.EB(localca.field_createTime);
              label1563:
              e(parami);
            }
          }
          label1681:
          label1691:
          label1756:
          do
          {
            for (;;)
            {
              this.VEK.event(parami);
              this.VEK.doNotify();
              this.VEI.b(localca, parami, bool, paramc);
              AppMethodBeat.o(117074);
              return;
              localObject2 = dj(localca.getType(), parami.field_content);
              localObject3 = Util.nullAsNil(parami.field_digest);
              if (Util.isNullOrNil((String)localObject2)) {}
              for (localObject2 = "";; localObject2 = " " + Util.nullAsNil((String)localObject2))
              {
                parami.Ja(((String)localObject3).concat((String)localObject2));
                break;
              }
              parami.EB(cm.bfC());
              break label1563;
              a(parami, j, i);
              a(parami, (String)localObject1, true);
              continue;
              Log.i("MicroMsg.ConversationStorage", "update null conversation with talker ".concat(String.valueOf(localObject1)));
              if (bool) {
                break label1756;
              }
              parami.hyE();
              a(parami, j, i);
              a(parami, (String)localObject1, true);
            }
          } while (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOW((String)localObject1) <= 0);
          if ((localca != null) && (localca.field_createTime != 0L)) {
            parami.EB(localca.field_createTime);
          }
          for (;;)
          {
            a(parami, j, i);
            e(parami);
            break;
            parami.EB(cm.bfC());
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
    this.VEH = paramh;
  }
  
  public final void a(az paramaz, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117083);
    if (!bq.RO(paramaz.field_username))
    {
      AppMethodBeat.o(117083);
      return;
    }
    if (Util.nullAsNil(paramaz.field_username).length() <= 0)
    {
      Log.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
      AppMethodBeat.o(117083);
      return;
    }
    if (paramaz.field_msgCount == 0)
    {
      paramaz.pG(bq.RN(paramaz.field_username));
      Log.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      Log.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(paramaz.field_msgCount), paramaz.field_username, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(117083);
      return;
      if (paramInt1 > 0)
      {
        paramaz.pG(paramaz.field_msgCount - paramInt1);
        if (paramaz.field_msgCount < 0)
        {
          Log.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
          paramaz.pG(0);
        }
      }
      else if (paramInt2 > 0)
      {
        paramaz.pG(paramaz.field_msgCount + paramInt2);
      }
    }
  }
  
  public final void a(bw.a parama)
  {
    AppMethodBeat.i(117070);
    this.VEK.add(parama, null);
    AppMethodBeat.o(117070);
  }
  
  public final void a(bw.b paramb)
  {
    this.VEG = paramb;
  }
  
  public final boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(117089);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117089);
      return false;
    }
    if (bwx(paramString) == null)
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
      Log.i("Conversition", "wrong add attr flag: %s, %s, %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Util.getStack() });
      f.Iyx.a(20435, new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString });
    }
    paramBoolean = this.db.execSQL("rconversation", "update " + Wf(paramString) + " set attrflag = " + i + " where username = \"" + Util.escapeSqlValue(paramString) + "\"");
    if (paramBoolean) {
      doNotify(3, this, paramString);
    }
    AppMethodBeat.o(117089);
    return paramBoolean;
  }
  
  public final boolean aHD(String paramString)
  {
    AppMethodBeat.i(117111);
    paramString = this.db.query(Wf(paramString), null, "username=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.close();
      AppMethodBeat.o(117111);
      return bool;
    }
  }
  
  public final boolean aaL(String paramString)
  {
    AppMethodBeat.i(189312);
    if (bwx(paramString) != null)
    {
      AppMethodBeat.o(189312);
      return true;
    }
    AppMethodBeat.o(189312);
    return false;
  }
  
  public final bw.b abK()
  {
    return this.VEG;
  }
  
  public final Cursor asE(int paramInt)
  {
    AppMethodBeat.i(189448);
    Log.i("MicroMsg.ConversationStorage", "getUnreadConversationCursor filterType[%d] [%s]", new Object[] { Integer.valueOf(paramInt), Util.getStack() });
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username, ");
    ((StringBuilder)localObject).append("rconversation.unReadCount, ");
    ((StringBuilder)localObject).append("rconversation.conversationTime");
    boolean bool = com.tencent.mm.contact.b.jxn.axg();
    ((StringBuilder)localObject).append(" from ").append(ab.b(bool, "rconversation", "username")).append("unReadCount > 0 AND  ( parentRef is ").append(com.tencent.mm.o.a.jxD).append(" or parentRef = '' ) ").append(ab.m(bool, paramInt));
    localObject = ((StringBuilder)localObject).toString();
    Log.i("MicroMsg.ConversationStorage", "get unread conversation with black list, sql is %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(189448);
    return localObject;
  }
  
  public final Cursor b(ArrayList<String> paramArrayList, List<String> paramList, String paramString)
  {
    AppMethodBeat.i(189401);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed");
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
    if (com.tencent.mm.o.a.jxD == paramString) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(Util.nullAsNil(ab.m(false, 1)));
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
    Log.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(189401);
    return paramArrayList;
  }
  
  public final void b(com.tencent.mm.plugin.messenger.foundation.a.i parami)
  {
    AppMethodBeat.i(189285);
    this.VEI.remove(parami);
    AppMethodBeat.o(189285);
  }
  
  public final void b(bw.a parama)
  {
    AppMethodBeat.i(117072);
    this.VEJ.add(parama, null);
    AppMethodBeat.o(117072);
  }
  
  public final void br(ca paramca)
  {
    AppMethodBeat.i(117080);
    String str = paramca.field_talker;
    int i = 0;
    az localaz2 = bwx(str);
    if ((localaz2 != null) && (localaz2.field_conversationTime > paramca.field_createTime) && (localaz2.field_conversationTime != 9223372036854775807L))
    {
      Log.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      AppMethodBeat.o(117080);
      return;
    }
    az localaz1 = localaz2;
    if (localaz2 == null)
    {
      localaz1 = new az(str);
      i = 1;
    }
    localaz1.pJ(paramca.field_isSend);
    localaz1.pH(localaz1.field_unReadCount);
    localaz1.bq(paramca);
    localaz1.IZ(Integer.toString(paramca.getType()));
    localaz1.EC(localaz1.field_flag & 0x0 | paramca.field_createTime & 0xFFFFFFFF);
    if (i != 0)
    {
      e(localaz1);
      AppMethodBeat.o(117080);
      return;
    }
    a(localaz1, str, true);
    AppMethodBeat.o(117080);
  }
  
  public final boolean bwA(String paramString)
  {
    AppMethodBeat.i(117087);
    if (paramString.length() <= 0)
    {
      Log.e("MicroMsg.ConversationStorage", "update updateUnreadByParentRef failed");
      AppMethodBeat.o(117087);
      return false;
    }
    Log.d("MicroMsg.ConversationStorage", "updateUnreadByParentRef %s", new Object[] { paramString });
    az localaz = bwx(paramString);
    if (localaz == null)
    {
      AppMethodBeat.o(117087);
      return true;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("unReadCount", Integer.valueOf(0));
    localContentValues.put("unReadMuteCount", Integer.valueOf(0));
    localContentValues.put("UnReadInvite", Integer.valueOf(0));
    localContentValues.put("atCount", Integer.valueOf(0));
    localContentValues.put("attrflag", Integer.valueOf(localaz.field_attrflag & 0xFFEFFFFF));
    int i = this.db.update(Wf(paramString), localContentValues, "parentRef= ?", new String[] { Util.escapeSqlValue(paramString) });
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
  
  public final boolean bwB(String paramString)
  {
    AppMethodBeat.i(117088);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.e("MicroMsg.ConversationStorage", "update conversation failed");
      AppMethodBeat.o(117088);
      return false;
    }
    az localaz = bwx(paramString);
    if ((localaz == null) || ((localaz.field_unReadCount > 0) && (paramString.equals(localaz.field_username))))
    {
      AppMethodBeat.o(117088);
      return true;
    }
    boolean bool = this.db.execSQL("rconversation", "update " + Wf(paramString) + " set unReadCount = 1, atCount = 0, attrflag = " + (localaz.field_attrflag | 0x100000) + " where username = \"" + Util.escapeSqlValue(paramString) + "\"");
    if (bool) {
      doNotify(3, this, paramString);
    }
    AppMethodBeat.o(117088);
    return bool;
  }
  
  public final boolean bwC(String paramString)
  {
    AppMethodBeat.i(117094);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
      AppMethodBeat.o(117094);
      return false;
    }
    paramString = bwx(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
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
    Log.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", new Object[] { Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
    long l3 = cm.bfC();
    l2 = l1;
    if (l1 > l3)
    {
      Log.w("MicroMsg.ConversationStorage", "conversationTime=%s serverTime=%s diff=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 - l1) });
      l2 = l3;
    }
    l1 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 1, l2 + 1L);
    boolean bool = this.db.execSQL("rconversation", "update " + Wf(paramString.field_username) + " set flag = " + l1 + " where username = \"" + Util.escapeSqlValue(paramString.field_username) + "\"");
    Log.i("MicroMsg.ConversationStorage", "[setMoveUp] flag=%s result=%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool) });
    if (bool) {
      doNotify(3, this, paramString.field_username);
    }
    AppMethodBeat.o(117094);
    return bool;
  }
  
  public final boolean bwD(String paramString)
  {
    AppMethodBeat.i(117095);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
      AppMethodBeat.o(117095);
      return false;
    }
    if (bwx(paramString) == null)
    {
      az localaz = new az(paramString);
      localaz.EB(System.currentTimeMillis());
      e(localaz);
      Log.i("MicroMsg.ConversationStorage", "setPlacedTop username = ".concat(String.valueOf(paramString)));
    }
    paramString = bwx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117095);
      return false;
    }
    long l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 2, 0L);
    boolean bool = this.db.execSQL("rconversation", "update " + Wf(paramString.field_username) + " set flag = " + l + " where username = \"" + Util.escapeSqlValue(paramString.field_username) + "\"");
    Log.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      doNotify(3, this, paramString.field_username);
    }
    AppMethodBeat.o(117095);
    return bool;
  }
  
  public final boolean bwE(String paramString)
  {
    AppMethodBeat.i(117096);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
      AppMethodBeat.o(117096);
      return false;
    }
    boolean bool = g(bwx(paramString));
    AppMethodBeat.o(117096);
    return bool;
  }
  
  public final boolean bwF(String paramString)
  {
    AppMethodBeat.i(117098);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
      AppMethodBeat.o(117098);
      return false;
    }
    boolean bool = h(bwx(paramString));
    AppMethodBeat.o(117098);
    return bool;
  }
  
  public final Cursor bwG(String paramString)
  {
    AppMethodBeat.i(117106);
    paramString = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + Util.nullAsNil(paramString) + " order by flag desc, conversationTime desc";
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(117106);
    return paramString;
  }
  
  public final Cursor bwH(String paramString)
  {
    AppMethodBeat.i(189453);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT rcontact.* FROM rcontact,rconversation");
    localStringBuilder.append(" WHERE unReadCount > 0 AND ( parentRef is ").append(com.tencent.mm.o.a.jxD).append(" or parentRef = '' ) ");
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(Util.nullAsNil(paramString));
    localStringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
    paramString = localStringBuilder.toString();
    Log.i("MicroMsg.ConversationStorage", "get total unread contact with black list, sql is %s", new Object[] { paramString });
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(189453);
    return paramString;
  }
  
  public final int bwI(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117119);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM rconversation");
    localStringBuilder.append(" WHERE parentRef = '").append(paramString).append("'");
    paramString = localStringBuilder.toString();
    Log.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", new Object[] { paramString });
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
  
  public final String bwJ(String paramString)
  {
    AppMethodBeat.i(117120);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = '").append(paramString).append("'");
    ((StringBuilder)localObject).append(" ORDER BY conversationTime DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    paramString = ((StringBuilder)localObject).toString();
    Log.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", new Object[] { paramString });
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
  
  public final int bwK(String paramString)
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
  
  public final az bwL(String paramString)
  {
    AppMethodBeat.i(117124);
    Cursor localCursor = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(1, null, paramString);
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        paramString = new az();
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
  
  public final int bwM(String paramString)
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
    localStringBuilder.append(" and ( parentRef is null or parentRef = '' ) ");
    paramString = localStringBuilder.toString();
    Log.d("MicroMsg.ConversationStorage", "query sql: %s", new Object[] { paramString });
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
  
  public final void bwN(String paramString)
  {
    AppMethodBeat.i(117129);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Update rconversation");
    ((StringBuilder)localObject).append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + Util.escapeSqlValue(paramString) + "\"");
    localObject = ((StringBuilder)localObject).toString();
    Log.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", new Object[] { localObject });
    if (this.db.execSQL("rconversation", (String)localObject)) {
      doNotify(3, this, paramString);
    }
    AppMethodBeat.o(117129);
  }
  
  public final void bwO(String paramString)
  {
    AppMethodBeat.i(117130);
    int i = this.db.delete(Wf(paramString), "username=? or parentRef =?", new String[] { paramString, paramString });
    Log.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i != 0) {
      doNotify(5, this, paramString);
    }
    AppMethodBeat.o(117130);
  }
  
  public final int bwP(String paramString)
  {
    int i = -1;
    AppMethodBeat.i(117131);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117131);
      return -1;
    }
    paramString = "select msgCount from rconversation where username=" + com.tencent.mm.storagebase.h.Mi(paramString);
    paramString = this.db.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117131);
    return i;
  }
  
  public final void bwv(String paramString)
  {
    AppMethodBeat.i(117076);
    Log.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", new Object[] { paramString, MMStack.getStack(true) });
    if (this.db.delete(Wf(paramString), "username=?", new String[] { paramString }) != 0) {
      doNotify(5, this, paramString);
    }
    AppMethodBeat.o(117076);
  }
  
  public final boolean bww(String paramString)
  {
    AppMethodBeat.i(117078);
    Log.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[] { paramString, MMStack.getStack(true) });
    boolean bool = this.db.execSQL("rconversation", "delete from " + Wf(paramString) + " where username like '%" + paramString + "'");
    if (bool) {
      doNotify(5, this, paramString);
    }
    AppMethodBeat.o(117078);
    return bool;
  }
  
  public final az bwx(String paramString)
  {
    AppMethodBeat.i(117079);
    Cursor localCursor = this.db.query(Wf(paramString), null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      Log.w("MicroMsg.ConversationStorage", "get null with username:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(117079);
      return null;
    }
    paramString = new az();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117079);
    return paramString;
  }
  
  public final void bwy(String paramString)
  {
    AppMethodBeat.i(117085);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, "username=?", new String[] { paramString });
    AppMethodBeat.o(117085);
  }
  
  public final boolean bwz(String paramString)
  {
    AppMethodBeat.i(117086);
    if ((paramString == null) || (paramString.length() <= 0)) {
      Log.e("MicroMsg.ConversationStorage", "update conversation failed");
    }
    int i;
    do
    {
      AppMethodBeat.o(117086);
      return false;
      Log.d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", new Object[] { paramString });
      Object localObject = bwx(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(117086);
        return true;
      }
      if ((((bb)localObject).field_unReadCount == 0) && (((bb)localObject).field_unReadMuteCount == 0) && (paramString.equals(((bb)localObject).field_username)))
      {
        a(paramString, 1048576, false, ((bb)localObject).field_attrflag);
        localObject = new ContentValues();
        ((ContentValues)localObject).put("UnReadInvite", Integer.valueOf(0));
        ((ContentValues)localObject).put("atCount", Integer.valueOf(0));
        if (this.db.update(Wf(paramString), (ContentValues)localObject, "username= ?", new String[] { Util.escapeSqlValue(paramString) }) > 0) {
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
      localContentValues.put("attrflag", Integer.valueOf(((bb)localObject).field_attrflag & 0xFFEFFFFF));
      i = this.db.update(Wf(paramString), localContentValues, "username= ?", new String[] { Util.escapeSqlValue(paramString) });
      if (i > 0) {
        doNotify(3, this, paramString);
      }
    } while (i <= 0);
    AppMethodBeat.o(117086);
    return true;
  }
  
  public final void c(bw.a parama)
  {
    AppMethodBeat.i(117073);
    this.VEJ.remove(parama);
    AppMethodBeat.o(117073);
  }
  
  public final void c(String[] paramArrayOfString, String paramString)
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
    Log.d("MicroMsg.ConversationStorage", "update sql: %s", new Object[] { paramString });
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
  
  public final void ch(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(117107);
    Log.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", new Object[] { MMStack.getStack(true) });
    if (paramLinkedList.isEmpty())
    {
      Log.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
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
    Log.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", new Object[] { localStringBuilder.toString() });
    this.db.execSQL("rconversation", localStringBuilder.toString());
    AppMethodBeat.o(117107);
  }
  
  public final Cursor d(List<String> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189383);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.o.a.jxD == paramString) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(Util.nullAsNil(ab.m(false, 1)));
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
    Log.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + localStringBuilder.toString());
    paramList = this.db;
    paramString = localStringBuilder.toString();
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      paramList = paramList.rawQuery(paramString, null, i);
      AppMethodBeat.o(189383);
      return paramList;
    }
  }
  
  public final String dj(int paramInt, String paramString)
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
        Log.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { localObject1 });
      }
    }
  }
  
  public final long e(az paramaz)
  {
    AppMethodBeat.i(117082);
    String str = Util.nullAsNil(paramaz.field_username);
    if (str.length() <= 0)
    {
      Log.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
      AppMethodBeat.o(117082);
      return -1L;
    }
    paramaz.EC(d(paramaz));
    f(paramaz);
    long l = this.db.insert(Wf(str), null, paramaz.convertTo());
    if (l != -1L) {
      doNotify(2, this, paramaz.field_username);
    }
    for (;;)
    {
      AppMethodBeat.o(117082);
      return l;
      Log.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", new Object[] { Wf(str) });
    }
  }
  
  public final boolean g(az paramaz)
  {
    AppMethodBeat.i(117097);
    if (paramaz == null)
    {
      Log.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
      AppMethodBeat.o(117097);
      return false;
    }
    long l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramaz, 3, paramaz.field_conversationTime);
    boolean bool = this.db.execSQL("rconversation", "update " + Wf(paramaz.field_username) + " set flag = " + l + " where username = \"" + Util.escapeSqlValue(paramaz.field_username) + "\"");
    Log.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      doNotify(3, this, paramaz.field_username);
    }
    AppMethodBeat.o(117097);
    return bool;
  }
  
  public final Cursor h(List<String> paramList, int paramInt1, int paramInt2)
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
  
  public final boolean h(az paramaz)
  {
    AppMethodBeat.i(117099);
    if (paramaz == null)
    {
      Log.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
      AppMethodBeat.o(117099);
      return false;
    }
    if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramaz, 4, 0L) != 0L)
    {
      AppMethodBeat.o(117099);
      return true;
    }
    AppMethodBeat.o(117099);
    return false;
  }
  
  public final boolean hyF()
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
  
  public final HashMap<String, Long> hyG()
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
    Log.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(117081);
    return localHashMap;
  }
  
  public final void hyH()
  {
    AppMethodBeat.i(117084);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.db.update("rconversation", localContentValues, null, null);
    AppMethodBeat.o(117084);
  }
  
  public final List<String> hyI()
  {
    AppMethodBeat.i(117101);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select rconversation.username from rconversation,rcontact where ");
    ((StringBuilder)localObject).append("rconversation.username = rcontact.username");
    ((StringBuilder)localObject).append(Util.nullAsNil(Util.nullAsNil(ab.lsA)));
    ((StringBuilder)localObject).append(" and ( verifyFlag & 8 ) = 0");
    ((StringBuilder)localObject).append(" and ( rconversation.parentRef is null  or rconversation.parentRef = '' ) ");
    String[] arrayOfString = ab.lsO;
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
    Log.d("MicroMsg.ConversationStorage", "user list:%s", new Object[] { localArrayList });
    AppMethodBeat.o(117101);
    return localArrayList;
  }
  
  public final List<String> hyJ()
  {
    AppMethodBeat.i(117108);
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localObject = L(" where username", (List)localObject);
    localObject = "select username from rconversation" + (String)localObject;
    localObject = (String)localObject + " order by flag desc, conversationTime desc";
    Log.i("MicroMsg.ConversationStorage", "getAllConvUserName sql %s", new Object[] { localObject });
    localObject = this.db.rawQuery((String)localObject, null);
    int i = ((Cursor)localObject).getColumnIndex("username");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117108);
    return localArrayList;
  }
  
  public final Cursor hyK()
  {
    AppMethodBeat.i(117110);
    Cursor localCursor = this.db.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    AppMethodBeat.o(117110);
    return localCursor;
  }
  
  public final int hyL()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(117117);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT SUM(rconversation.unReadCount)");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    localObject = ((StringBuilder)localObject).toString();
    Log.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", new Object[] { localObject });
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
  
  public final String hyM()
  {
    AppMethodBeat.i(117118);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts'");
    ((StringBuilder)localObject).append(" ORDER BY flag DESC, conversationTime DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    localObject = ((StringBuilder)localObject).toString();
    Log.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", new Object[] { localObject });
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
  
  public final Cursor hyN()
  {
    AppMethodBeat.i(117121);
    Log.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", new Object[] { "select count(*) from rbottleconversation where unReadCount > 0" });
    Cursor localCursor = this.db.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
    AppMethodBeat.o(117121);
    return localCursor;
  }
  
  public final Cursor hyO()
  {
    AppMethodBeat.i(117132);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username, ");
    ((StringBuilder)localObject).append("rconversation.unReadCount");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE unReadCount > 0");
    ((StringBuilder)localObject).append(" AND ( parentRef is ").append(com.tencent.mm.o.a.jxD).append(" or parentRef = '' ) ");
    localObject = this.db.rawQuery(((StringBuilder)localObject).toString(), null);
    AppMethodBeat.o(117132);
    return localObject;
  }
  
  public final Cursor nK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117113);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount");
    localStringBuilder.append(" from rconversation where username = '").append(paramString1).append("' AND (parentRef is ").append(com.tencent.mm.o.a.jxD).append(" or parentRef = '' ) ").append(Util.nullAsNil(paramString2));
    paramString1 = localStringBuilder.toString();
    Log.d("MicroMsg.ConversationStorage", "get unread by username, sql is %s", new Object[] { paramString1 });
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(117113);
    return paramString1;
  }
  
  public final Cursor nL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189521);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, conversationTime, username, flag");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.o.a.jxD == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(Util.nullAsNil(paramString1));
      localStringBuilder.append(" order by flag desc");
      localStringBuilder.append(" limit 18");
      Log.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + localStringBuilder.toString());
      paramString1 = this.db.rawQuery(localStringBuilder.toString(), null);
      AppMethodBeat.o(189521);
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
        Log.w("MicroMsg.ConversationStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(117128);
        return false;
      }
    }
    AppMethodBeat.o(117128);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ba
 * JD-Core Version:    0.7.0.1
 */