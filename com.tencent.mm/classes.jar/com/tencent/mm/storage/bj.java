package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import junit.framework.Assert;

public final class bj
  extends j
  implements com.tencent.mm.plugin.messenger.foundation.a.a.g
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag INT) " };
  private final h dXo;
  private bd hML;
  private be hMN;
  private final long uAz = 86400L;
  private boolean uCA = false;
  private String uCB = "";
  private long uCC = 0L;
  private boolean uCp = false;
  private final List<e> uCq = new CopyOnWriteArrayList();
  private List<g.b> uCr;
  private final com.tencent.mm.a.f<Integer, bi.c> uCs = new com.tencent.mm.a.f(100);
  private final com.tencent.mm.a.f<Integer, bi.d> uCt = new com.tencent.mm.a.f(100);
  private final com.tencent.mm.a.f<Integer, bi.a> uCu = new com.tencent.mm.a.f(100);
  private final com.tencent.mm.a.f<Integer, bi.b> uCv = new com.tencent.mm.a.f(100);
  private final com.tencent.mm.a.f<Integer, Object> uCw = new com.tencent.mm.a.f(100);
  private final com.tencent.mm.a.f<String, Long> uCx = new com.tencent.mm.a.f(100);
  private an uCy = new an();
  private Map<String, g.c> uCz = new HashMap();
  private final k<g.a, g.c> umW = new k()
  {
    public final void dl(List<g.c> paramAnonymousList)
    {
      if ((!isLocked()) && (bj.a(bj.this) != null))
      {
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          g.c localc = (g.c)paramAnonymousList.next();
          if (localc != null) {
            bj.a(bj.this).b(bj.this, localc);
          }
        }
      }
    }
  };
  
  public bj(h paramh, bd parambd, be parambe)
  {
    this.dXo = paramh;
    this.hML = parambd;
    this.hMN = parambe;
    com.tencent.mm.kernel.g.DQ();
    if (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(348169, Integer.valueOf(0))).intValue() == 0)
    {
      y.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", new Object[] { Integer.valueOf(this.dXo.delete("message", "msgId> ? ", new String[] { "80000000" })) });
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(348169, Integer.valueOf(1));
    }
    a(paramh, "message");
    cvT();
    if (this.uCr == null) {
      this.uCr = new LinkedList();
    }
    this.uCr.clear();
    a(new g.b(1, "message", g.b.a(1L, 1000000L, 10000000L, 90000000L)));
  }
  
  private String acd(String paramString)
  {
    String str = HT(paramString);
    if ((this.uCp) && (str.equals("message"))) {
      return " talkerId=" + ace(paramString) + " ";
    }
    return " talker= '" + bk.pl(paramString) + "' ";
  }
  
  private long ace(String paramString)
  {
    long l = this.hML.abm(paramString);
    if (l < 0L) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        ad localad = new ad(paramString);
        localad.setType(2);
        this.hML.V(localad);
        l = this.hML.abm(paramString);
      }
      if (!b.cqm()) {
        y.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", new Object[] { paramString, Long.valueOf(l), Boolean.valueOf(bool), bk.csb() });
      }
      return l;
    }
  }
  
  private static String acf(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    try
    {
      paramString = bn.s(paramString, "msgsource");
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        paramString = (String)paramString.get(".msgsource.bizmsg.msgcluster");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.MsgInfoStorage", "exception:%s", new Object[] { bk.j(paramString) });
      y.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", new Object[] { paramString.getMessage() });
      return null;
    }
    return null;
  }
  
  private String acg(String paramString)
  {
    if ((paramString == null) || (!paramString.equals("message"))) {
      return "";
    }
    if (this.uCp) {
      return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
    }
    return "INDEXED BY messageCreateTaklerTypeTimeIndex";
  }
  
  private g.b ach(String paramString)
  {
    boolean bool;
    int i;
    if ((paramString != null) && (paramString.length() > 0))
    {
      bool = true;
      Assert.assertTrue("tableName == null", bool);
      i = 0;
    }
    for (;;)
    {
      if (i >= this.uCr.size()) {
        break label84;
      }
      if (paramString.equals(((g.b)this.uCr.get(i)).name))
      {
        return (g.b)this.uCr.get(i);
        bool = false;
        break;
      }
      i += 1;
    }
    label84:
    Assert.assertTrue("no table match", false);
    return null;
  }
  
  private g.b aci(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    label35:
    String str;
    if ((paramString != null) && (paramString.length() > 0))
    {
      bool1 = true;
      Assert.assertTrue("username == null", bool1);
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label98;
      }
      bool1 = bool2;
      Assert.assertTrue(bool1);
      Iterator localIterator = this.uCq.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = ((e)localIterator.next()).aaD(paramString);
      } while (bk.bl(str));
    }
    for (paramString = str;; paramString = "message")
    {
      return ach(paramString);
      bool1 = false;
      break;
      label98:
      bool1 = false;
      break label35;
    }
  }
  
  private static void al(bi parambi)
  {
    if ((parambi == null) || (!parambi.aVK())) {}
    for (;;)
    {
      return;
      try
      {
        String str = parambi.field_content;
        int i = str.indexOf("<msg>");
        Object localObject = str;
        if (i > 0)
        {
          localObject = str;
          if (i < str.length()) {
            localObject = str.substring(i).trim();
          }
        }
        localObject = bn.s((String)localObject, "msg");
        if ((localObject != null) && (((Map)localObject).size() > 0))
        {
          parambi.ee(ba.au((Map)localObject));
          return;
        }
      }
      catch (Exception parambi)
      {
        y.e("MicroMsg.MsgInfoStorage", parambi.getMessage());
      }
    }
  }
  
  private void b(g.b paramb)
  {
    Cursor localCursor = this.dXo.a("select max(msgid) from " + paramb.name, null, 2);
    int i;
    if (localCursor.moveToFirst())
    {
      i = localCursor.getInt(0);
      y.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramb.enx) });
      if (i >= paramb.enx)
      {
        y.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", new Object[] { Long.valueOf(paramb.enx), Integer.valueOf(i), Long.valueOf(paramb.mdp[0].mds), Long.valueOf(paramb.mdp[1].mdr), bk.csb() });
        if ((i <= paramb.mdp[0].mds) || (i >= paramb.mdp[1].mdr)) {
          break label269;
        }
        y.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", new Object[] { Long.valueOf(paramb.mdp[1].mdr) });
        paramb.enx = paramb.mdp[1].mdr;
        com.tencent.mm.plugin.report.f.nEG.a(111L, 169L, 1L, false);
      }
    }
    for (;;)
    {
      localCursor.close();
      y.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + paramb.enx);
      return;
      label269:
      paramb.enx = i;
    }
  }
  
  private void cvT()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.dXo.eV(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new String[13];
    arrayOfString[0] = ("CREATE INDEX IF NOT EXISTS " + "message" + "IdIndex ON message ( msgId )");
    arrayOfString[1] = ("CREATE INDEX IF NOT EXISTS " + "message" + "SvrIdIndex ON message ( msgSvrId )");
    arrayOfString[2] = ("CREATE INDEX IF NOT EXISTS " + "message" + "SendCreateTimeIndex ON message ( status,isSend,createTime )");
    arrayOfString[3] = ("CREATE INDEX IF NOT EXISTS " + "message" + "CreateTimeIndex ON message ( createTime )");
    arrayOfString[4] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TaklerIdTypeCreateTimeIndex ON message ( talkerId,type,createTime )");
    arrayOfString[5] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdStatusIndex ON message ( talkerId,status )");
    arrayOfString[6] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdCreateTimeIsSendIndex ON message ( talkerId,isSend,createTime )");
    arrayOfString[7] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdCreateTimeIndex ON message ( talkerId,createTime )");
    arrayOfString[8] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdSvrIdIndex ON message ( talkerId,msgSvrId )");
    arrayOfString[9] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdTypeIndex ON message ( talkerId,type )");
    arrayOfString[10] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerTypeIndex ON message ( talker,type )");
    arrayOfString[11] = ("CREATE INDEX IF NOT EXISTS " + "message" + "messageTalkerMsgSeqIndex ON message ( talker,msgSeq )");
    arrayOfString[12] = ("CREATE INDEX IF NOT EXISTS " + "message" + "messageTalkerFlagMsgSeqIndex ON message ( talker,flag,msgSeq )");
    if (!this.uCp)
    {
      arrayOfString[4] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTypeTimeIndex ON message ( talker,type,createTime )";
      arrayOfString[5] = "CREATE INDEX IF NOT EXISTS  messageTalkerStatusIndex ON message ( talker,status )";
      arrayOfString[6] = "CREATE INDEX IF NOT EXISTS  messageTalkerCreateTimeIsSendIndex ON message ( talker,isSend,createTime )";
      arrayOfString[7] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTimeIndex ON message ( talker,createTime )";
      arrayOfString[8] = "CREATE INDEX IF NOT EXISTS  messageTalkerSvrIdIndex ON message ( talker,msgSvrId )";
    }
    localArrayList.addAll(Arrays.asList(arrayOfString));
    int i = 0;
    while (i < localArrayList.size())
    {
      this.dXo.gk("message", (String)localArrayList.get(i));
      i += 1;
    }
    y.i("MicroMsg.MsgInfoStorage", "build new index last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    this.dXo.hI(l2);
    y.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
  
  private String hH(long paramLong)
  {
    if ((paramLong == 0L) || (paramLong == -1L)) {
      return null;
    }
    bi.hG(paramLong);
    int i = 0;
    while (i < this.uCr.size())
    {
      if (((g.b)this.uCr.get(i)).fi(paramLong)) {
        return ((g.b)this.uCr.get(i)).name;
      }
      i += 1;
    }
    Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[] { Long.valueOf(paramLong) }), false);
    return null;
  }
  
  public final Cursor E(String paramString1, String paramString2, int paramInt)
  {
    String str = " SELECT * FROM " + HT(paramString1) + " WHERE" + acd(paramString1) + "AND content LIKE '" + paramString2 + "%' ORDER BY createTime DESC LIMIT " + paramInt;
    y.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), str });
    return this.dXo.a(str, null, 0);
  }
  
  public final void H(ArrayList<Long> paramArrayList)
  {
    long l1 = this.dXo.eV(-1L);
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        long l2 = ((Long)paramArrayList.next()).longValue();
        bi localbi = fd(l2);
        localbi.ff(localbi.czq | 0x20);
        y.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
        a(l2, localbi);
      }
    }
    finally
    {
      this.dXo.hI(l1);
    }
  }
  
  public final bi HA(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    bi localbi = new bi();
    paramString = "select * from " + HT(paramString) + " where" + acd(paramString) + "order by createTime DESC limit 1";
    paramString = this.dXo.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbi.d(paramString);
    }
    paramString.close();
    return localbi;
  }
  
  public final bi HB(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    bi localbi = new bi();
    paramString = "select * from " + HT(paramString) + " where" + acd(paramString) + "and isSend = 0  order by createTime DESC limit 1";
    paramString = this.dXo.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbi.d(paramString);
    }
    paramString.close();
    return localbi;
  }
  
  public final bi HC(String paramString)
  {
    if (this.uCr == null)
    {
      y.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      return null;
    }
    bi localbi = new bi();
    long l1 = 0L;
    if (bk.bl(paramString)) {}
    for (paramString = "";; paramString = paramString.replaceFirst("and", "where"))
    {
      int i = 0;
      while (i < this.uCr.size())
      {
        long l2 = l1;
        if ((((g.b)this.uCr.get(i)).mdq & 0x8) != 0)
        {
          Object localObject = "select * from " + ((g.b)this.uCr.get(i)).name + paramString + "  order by createTime DESC limit 1";
          localObject = this.dXo.a((String)localObject, null, 2);
          l2 = l1;
          if (((Cursor)localObject).moveToFirst())
          {
            long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
            l2 = l1;
            if (l1 < l3)
            {
              localbi.d((Cursor)localObject);
              l2 = l3;
            }
          }
          ((Cursor)localObject).close();
        }
        i += 1;
        l1 = l2;
      }
    }
    return localbi;
  }
  
  public final List<bi> HD(String paramString)
  {
    bi localbi = null;
    Cursor localCursor = this.dXo.a("select * from " + paramString, null, 2);
    if (localCursor == null) {
      return null;
    }
    paramString = localbi;
    if (localCursor.moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        localbi = new bi();
        localbi.d(localCursor);
        paramString.add(localbi);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    return paramString;
  }
  
  public final Cursor HE(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      return null;
    }
    Object localObject = HT(paramString);
    paramString = "select * from " + (String)localObject + " " + acg((String)localObject) + " where" + acd(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime";
    localObject = this.dXo.a(paramString, null, 0);
    y.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    return localObject;
  }
  
  public final void HF(String paramString)
  {
    b(paramString, "", null);
    if (this.dXo.gk(paramString, "delete from " + paramString))
    {
      aam("delete_all " + paramString);
      return;
    }
    com.tencent.mm.plugin.report.f.nEG.a(111L, 247L, 1L, false);
  }
  
  public final int HG(String paramString)
  {
    y.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, ak.crj() });
    b(HT(paramString), acd(paramString), null);
    int i = this.dXo.delete(HT(paramString), acd(paramString), null);
    if (i != 0)
    {
      aam("delete_talker " + paramString);
      paramString = new g.c(paramString, "delete", null, i, (byte)0);
      paramString.mdy = -1L;
      a(paramString);
    }
    return i;
  }
  
  public final boolean HH(String paramString)
  {
    y.w("MicroMsg.MsgInfoStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[] { paramString, ak.crj() });
    b(HT(paramString), " talker like '%" + paramString + "'", null);
    boolean bool = this.dXo.gk(HT(paramString), "delete from " + HT(paramString) + " where talker like '%" + paramString + "'");
    if (bool) {
      doNotify();
    }
    return bool;
  }
  
  public final int HI(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(4));
    int i = this.dXo.update(HT(paramString), localContentValues, acd(paramString) + "AND isSend=? AND status!=? ", new String[] { "0", "4" });
    if (i != 0)
    {
      doNotify();
      a(new g.c(paramString, "update", null));
    }
    return i;
  }
  
  public final Cursor HJ(String paramString)
  {
    return this.dXo.query(HT(paramString), null, acd(paramString), null, null, null, "createTime ASC ");
  }
  
  public final Cursor HK(String paramString)
  {
    return this.dXo.query(HT(paramString), null, "isSend=? AND" + acd(paramString) + "AND status!=?", new String[] { "0", "4" }, null, null, null);
  }
  
  public final bi.c HL(String paramString)
  {
    bi.c localc2 = (bi.c)this.uCs.get(Integer.valueOf(paramString.hashCode()));
    bi.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = bi.c.acb(paramString);
      this.uCs.f(Integer.valueOf(paramString.hashCode()), localc1);
    }
    return localc1;
  }
  
  public final bi.d HM(String paramString)
  {
    bi.d locald2 = (bi.d)this.uCt.get(Integer.valueOf(paramString.hashCode()));
    bi.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = bi.d.acc(paramString);
      this.uCt.f(Integer.valueOf(paramString.hashCode()), locald1);
    }
    return locald1;
  }
  
  public final bi.a HN(String paramString)
  {
    bi.a locala1 = null;
    if ((!bk.bl(paramString)) && (this.uCu != null)) {
      locala1 = (bi.a)this.uCu.get(Integer.valueOf(paramString.hashCode()));
    }
    for (;;)
    {
      bi.a locala2 = locala1;
      if (locala1 == null)
      {
        locala1 = bi.a.abZ(paramString);
        locala2 = locala1;
        if (this.uCu != null)
        {
          this.uCu.f(Integer.valueOf(bk.aM(paramString, "").hashCode()), locala1);
          locala2 = locala1;
        }
      }
      return locala2;
      y.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", new Object[] { Boolean.valueOf(bk.bl(paramString)) });
      y.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
    }
  }
  
  public final bi.b HO(String paramString)
  {
    bi.b localb2 = (bi.b)this.uCv.get(Integer.valueOf(paramString.hashCode()));
    bi.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = bi.b.aca(paramString);
      this.uCv.f(Integer.valueOf(paramString.hashCode()), localb1);
    }
    return localb1;
  }
  
  public final int HP(String paramString)
  {
    int j = 0;
    int i = 0;
    if (HQ(paramString))
    {
      i = this.hMN.abO(paramString);
      if (i > 0)
      {
        y.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", new Object[] { Integer.valueOf(i) });
        return i;
      }
      y.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    }
    do
    {
      return HR(paramString);
      if ("appbrandmessage".equals(HT(paramString)))
      {
        paramString = "SELECT COUNT(*) FROM " + HT(paramString) + " WHERE" + acd(paramString);
        paramString = this.dXo.a(paramString, null, 0);
        if (paramString.moveToLast()) {
          i = paramString.getInt(0);
        }
        paramString.close();
        return i;
      }
    } while (!"bottlemessage".equals(HT(paramString)));
    paramString = "SELECT COUNT(*) FROM " + HT(paramString) + " WHERE" + acd(paramString);
    paramString = this.dXo.a(paramString, null, 2);
    i = j;
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    return i;
  }
  
  public final boolean HQ(String paramString)
  {
    return "message".equals(HT(paramString));
  }
  
  public final int HR(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ").append(HT(paramString)).append(" ");
    String str;
    if (this.uCp)
    {
      str = "INDEXED BY messageTalkerIdStatusIndex";
      paramString = str + " WHERE" + acd(paramString);
      paramString = this.dXo.a(paramString, null, 2);
      if (!paramString.moveToFirst()) {
        break label103;
      }
    }
    label103:
    for (int i = paramString.getInt(0);; i = 0)
    {
      paramString.close();
      return i;
      str = "INDEXED BY messageTalkerStatusIndex";
      break;
    }
  }
  
  public final int HS(String paramString)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      String str = aci(paramString).name;
      paramString = new StringBuilder().append(str).append("  indexed by  ").append(str).append("TalkerTypeIndex ").toString() + " WHERE talker= '" + bk.pl(paramString) + "' AND type IN (3,39,13,43,62,44,268435505)";
      paramString = this.dXo.a(paramString, null, 2);
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
      return i;
    }
  }
  
  public final String HT(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      return aci(paramString).name;
    }
  }
  
  public final long HU(String paramString)
  {
    Object localObject = "select createTime from message where" + acd(paramString) + "order by createTime LIMIT 1 OFFSET 0";
    y.d("MicroMsg.MsgInfoStorage", "get first message create time: " + (String)localObject);
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.e("MicroMsg.MsgInfoStorage", "get first message create time failed: " + paramString);
      return -1L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      return l;
    }
    ((Cursor)localObject).close();
    return -1L;
  }
  
  public final long HV(String paramString)
  {
    Object localObject = "select createTime from message where" + acd(paramString) + "order by createTime DESC LIMIT 1 ";
    y.d("MicroMsg.MsgInfoStorage", "get last message create time: " + (String)localObject);
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.e("MicroMsg.MsgInfoStorage", "get last message create time failed " + paramString);
      return -1L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      return l;
    }
    ((Cursor)localObject).close();
    return -1L;
  }
  
  public final long HW(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0L;
    }
    Object localObject = "select msgSeq from message where" + acd(paramString) + "order by msgSeq DESC LIMIT 1 ";
    y.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: " + (String)localObject);
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed " + paramString);
      return 0L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      return l;
    }
    ((Cursor)localObject).close();
    return 0L;
  }
  
  public final bi HX(String paramString)
  {
    if (bk.bl(paramString)) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      y.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", new Object[] { paramString, Boolean.valueOf(false) });
      localObject1 = (Long)this.uCx.get(paramString);
      if ((localObject1 == null) || (((Long)localObject1).longValue() <= 0L)) {
        break;
      }
      y.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", new Object[] { Long.valueOf(((Long)localObject1).longValue()) });
      localObject2 = fd(((Long)localObject1).longValue());
      localObject1 = localObject2;
    } while ((((cs)localObject2).field_flag & 0x1) != 0);
    this.uCx.remove(paramString);
    return null;
    y.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
    Object localObject1 = new bi();
    long l = System.currentTimeMillis();
    Object localObject2 = "SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ";
    localObject2 = this.dXo.a((String)localObject2, null, 2);
    y.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(Thread.currentThread().getId()) });
    if (localObject2 == null)
    {
      y.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed " + paramString);
      return localObject1;
    }
    if (((Cursor)localObject2).moveToFirst()) {
      ((bi)localObject1).d((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    this.uCx.f(paramString, Long.valueOf(((cs)localObject1).field_msgId));
    return localObject1;
  }
  
  public final int HY(String paramString)
  {
    String str = " SELECT COUNT(*) FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND isSend=1";
    Cursor localCursor = this.dXo.a(str, null, 2);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          break label143;
        }
        i = localCursor.getInt(0);
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
      }
      y.d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", new Object[] { paramString, Integer.valueOf(i), str });
      return i;
      label143:
      int i = 0;
    }
  }
  
  /* Error */
  public final List<bi> HZ(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 513	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 514	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 135	com/tencent/mm/storage/bj:dXo	Lcom/tencent/mm/cf/h;
    //   14: ldc 64
    //   16: aconst_null
    //   17: ldc_w 931
    //   20: iconst_2
    //   21: anewarray 54	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: invokestatic 260	com/tencent/mm/sdk/platformtools/bk:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: invokestatic 498	java/lang/System:currentTimeMillis	()J
    //   36: ldc2_w 932
    //   39: lsub
    //   40: invokestatic 935	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   43: aastore
    //   44: aconst_null
    //   45: aconst_null
    //   46: ldc_w 937
    //   49: iconst_2
    //   50: invokevirtual 940	com/tencent/mm/cf/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   53: astore_1
    //   54: aload_1
    //   55: astore_2
    //   56: aload_2
    //   57: astore_1
    //   58: aload_2
    //   59: invokeinterface 684 1 0
    //   64: ifeq +69 -> 133
    //   67: aload_2
    //   68: astore_1
    //   69: new 397	com/tencent/mm/storage/bi
    //   72: dup
    //   73: invokespecial 639	com/tencent/mm/storage/bi:<init>	()V
    //   76: astore 4
    //   78: aload_2
    //   79: astore_1
    //   80: aload 4
    //   82: aload_2
    //   83: invokevirtual 648	com/tencent/mm/storage/bi:d	(Landroid/database/Cursor;)V
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: aload 4
    //   91: invokevirtual 941	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: goto -39 -> 56
    //   98: astore_3
    //   99: aload_2
    //   100: astore_1
    //   101: ldc 174
    //   103: aload_3
    //   104: ldc_w 943
    //   107: iconst_1
    //   108: anewarray 178	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_3
    //   114: invokevirtual 338	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   117: aastore
    //   118: invokestatic 928	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload_2
    //   122: ifnull +9 -> 131
    //   125: aload_2
    //   126: invokeinterface 487 1 0
    //   131: aconst_null
    //   132: areturn
    //   133: aload_2
    //   134: ifnull +9 -> 143
    //   137: aload_2
    //   138: invokeinterface 487 1 0
    //   143: aload_3
    //   144: areturn
    //   145: astore_1
    //   146: aload_2
    //   147: ifnull +9 -> 156
    //   150: aload_2
    //   151: invokeinterface 487 1 0
    //   156: aload_1
    //   157: athrow
    //   158: astore_3
    //   159: aload_1
    //   160: astore_2
    //   161: aload_3
    //   162: astore_1
    //   163: goto -17 -> 146
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -70 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	bj
    //   0	172	1	paramString	String
    //   1	168	2	str	String
    //   9	80	3	localArrayList	ArrayList
    //   98	46	3	localException1	Exception
    //   158	4	3	localObject	Object
    //   166	1	3	localException2	Exception
    //   76	14	4	localbi	bi
    // Exception table:
    //   from	to	target	type
    //   58	67	98	java/lang/Exception
    //   69	78	98	java/lang/Exception
    //   80	86	98	java/lang/Exception
    //   88	95	98	java/lang/Exception
    //   2	54	145	finally
    //   58	67	158	finally
    //   69	78	158	finally
    //   80	86	158	finally
    //   88	95	158	finally
    //   101	121	158	finally
    //   2	54	166	java/lang/Exception
  }
  
  public final void Hv(String paramString)
  {
    y.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.uCA), Integer.valueOf(this.ujP.ujS), Integer.valueOf(this.umW.ujS), Integer.valueOf(this.uCz.size()), this.uCB, Long.valueOf(bk.co(this.uCC)) });
    if (bk.bl(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (this.uCA)
    {
      y.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", new Object[] { this.uCB, Long.valueOf(bk.co(this.uCC)) });
      return;
    }
    this.uCB = paramString;
    this.uCC = bk.UY();
    this.uCA = true;
    super.lock();
    this.umW.lock();
  }
  
  public final void Hw(String paramString)
  {
    y.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.uCA), Integer.valueOf(this.ujP.ujS), Integer.valueOf(this.umW.ujS), Integer.valueOf(this.uCz.size()), this.uCB, Long.valueOf(bk.co(this.uCC)) });
    if (bk.bl(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (!this.uCA)
    {
      y.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", new Object[] { paramString, bk.csb() });
      return;
    }
    if (!paramString.equals(this.uCB))
    {
      y.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", new Object[] { this.uCB, Long.valueOf(bk.co(this.uCC)), paramString });
      return;
    }
    this.uCA = false;
    this.uCC = 0L;
    this.uCB = "";
    paramString = this.uCz.keySet().iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      a((g.c)this.uCz.get(str));
    }
    this.uCz.clear();
    super.unlock();
    this.umW.unlock();
    doNotify();
  }
  
  public final void Hx(String paramString)
  {
    if (!this.uCA) {}
    g.c localc;
    do
    {
      return;
      localc = null;
      if (this.uCz.containsKey(paramString)) {
        localc = (g.c)this.uCz.get(paramString);
      }
      if (localc == null)
      {
        y.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", new Object[] { paramString, bk.csb() });
        return;
      }
    } while ((localc.mdt == null) || (!localc.mdt.equals("insert")) || (localc.mdv <= 0));
    y.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", new Object[] { paramString, Integer.valueOf(localc.mdv) });
    localc.mdv = 0;
  }
  
  public final Cursor Hy(String paramString)
  {
    h localh = this.dXo;
    String str = HT(paramString);
    paramString = acd(paramString);
    return localh.query(str, new String[] { "createTime", "msgId" }, paramString, null, "createTime", null, "createTime ASC");
  }
  
  public final bi Hz(String paramString)
  {
    bi localbi = new bi();
    paramString = this.dXo.a(HT(paramString), null, acd(paramString), null, null, null, "msgSvrId  DESC limit 1 ", 2);
    if (paramString.moveToFirst()) {
      localbi.d(paramString);
    }
    paramString.close();
    return localbi;
  }
  
  public final long Ia(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return 0L;
      paramString = ach(paramString);
    } while (paramString == null);
    return paramString.enx;
  }
  
  public final Cursor Ib(String paramString)
  {
    try
    {
      paramString = this.dXo.a(HT(paramString), null, acd(paramString) + " AND createTime>=? AND type IN (436207665,419430449)", new String[] { String.valueOf(System.currentTimeMillis() - 86400000L) }, null, null, "createTime ASC", 2);
      return paramString;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.MsgInfoStorage", paramString, "getLastDayC2CMsgByTalker error: %s", new Object[] { paramString.getMessage() });
    }
    return null;
  }
  
  public final void N(String paramString, long paramLong)
  {
    g.b localb = aci(paramString);
    long l = localb.enx;
    Random localRandom = new Random();
    this.dXo.gk("message", "BEGIN;");
    bi localbi = new bi(paramString);
    int i = 0;
    while (i < paramLong)
    {
      localbi.bg(System.currentTimeMillis());
      localbi.setType(1);
      localbi.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bk.csa());
      localbi.setMsgId(l);
      localbi.setStatus(localRandom.nextInt(4));
      localbi.fA(localRandom.nextInt(1));
      l += 1L;
      localb.enx += 1L;
      localbi.bf(System.currentTimeMillis() + bk.csa());
      this.dXo.gk("message", "INSERT INTO " + HT(localbi.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + localbi.field_msgId + "," + localbi.field_msgSvrId + "," + localbi.getType() + "," + localbi.field_status + "," + localbi.field_createTime + ",'" + localbi.field_talker + "','" + localbi.field_content + "'," + ace(paramString) + ");");
      if (i % 10000 == 0)
      {
        this.dXo.gk("message", "COMMIT;");
        this.dXo.gk("message", "BEGIN;");
      }
      i += 1;
    }
    this.dXo.gk("message", "COMMIT;");
    this.hMN.abw(paramString);
    localbi.setMsgId(1L + l);
    T(localbi);
  }
  
  public final bi O(String paramString, long paramLong)
  {
    bi localbi = new bi();
    paramString = this.dXo.a(HT(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbi.d(paramString);
    }
    paramString.close();
    return localbi;
  }
  
  public final bi P(String paramString, long paramLong)
  {
    bi localbi = new bi();
    paramString = this.dXo.a(HT(paramString), null, acd(paramString) + " AND msgSeq=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbi.d(paramString);
    }
    paramString.close();
    return localbi;
  }
  
  public final bi Q(String paramString, long paramLong)
  {
    bi localbi = new bi();
    paramString = this.dXo.a(HT(paramString), null, "createTime=? AND" + acd(paramString), new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbi.d(paramString);
    }
    paramString.close();
    return localbi;
  }
  
  public final List<bi> R(String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + HT(paramString) + " Where " + acd(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11";
    paramString = this.dXo.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bi localbi = new bi();
      localbi.d(paramString);
      localArrayList.add(localbi);
    }
    paramString.close();
    return localArrayList;
  }
  
  public final int S(bi parambi)
  {
    int i = 0;
    if ((parambi == null) || (bk.bl(parambi.field_talker))) {
      return 0;
    }
    parambi = "SELECT count(msgId) FROM " + HT(parambi.field_talker) + " WHERE" + acd(parambi.field_talker) + "AND isSend = 0 AND msgId >= " + parambi.field_msgId + " ORDER BY createTime DESC";
    parambi = this.dXo.a(parambi, null, 2);
    if (parambi.moveToFirst()) {
      i = parambi.getInt(0);
    }
    parambi.close();
    return i;
  }
  
  public final List<bi> S(String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + HT(paramString) + " Where " + acd(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11;";
    paramString = this.dXo.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bi localbi = new bi();
      localbi.d(paramString);
      localArrayList.add(localbi);
    }
    paramString.close();
    return localArrayList;
  }
  
  public final long T(bi parambi)
  {
    return b(parambi, false);
  }
  
  public final bi T(String paramString, long paramLong)
  {
    bi localbi = new bi();
    paramString = "Select * From " + HT(paramString) + " Where " + acd(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
    paramString = this.dXo.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbi.d(paramString);
    }
    paramString.close();
    return localbi;
  }
  
  public final bi U(String paramString, long paramLong)
  {
    bi localbi = new bi();
    paramString = "Select * From " + HT(paramString) + " Where " + acd(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
    paramString = this.dXo.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbi.d(paramString);
    }
    paramString.close();
    return localbi;
  }
  
  public final void U(bi parambi)
  {
    if ((parambi == null) || (parambi.field_status == 4)) {}
    String str;
    do
    {
      do
      {
        return;
        parambi.setStatus(4);
        str = hH(parambi.field_msgId);
      } while ((str == null) || (str.length() <= 0));
    } while (this.dXo.update(str, parambi.vf(), "msgId=?", new String[] { parambi.field_msgId }) == 0);
    doNotify();
    a(new g.c(parambi.field_talker, "update", parambi, -1));
  }
  
  public final int V(bi parambi)
  {
    int i = 0;
    if (parambi != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("content", parambi.field_content);
      localContentValues.put("status", Integer.valueOf(parambi.field_status));
      int j = this.dXo.update(hH(parambi.field_msgId), localContentValues, "msgId=?", new String[] { String.valueOf(parambi.field_msgId) });
      i = j;
      if (j != 0)
      {
        doNotify();
        a(new g.c(parambi.field_talker, "update", parambi));
        i = j;
      }
    }
    return i;
  }
  
  public final boolean V(String paramString, long paramLong)
  {
    return Q(paramString, paramLong).field_msgId > 0L;
  }
  
  public final bi W(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    bi localbi = new bi();
    paramString = "select * from " + HT(paramString) + " where" + acd(paramString) + "AND msgSeq<" + paramLong + " order by msgSeq DESC limit 1";
    Cursor localCursor = this.dXo.a(paramString, null, 2);
    if (localCursor.moveToFirst()) {
      localbi.d(localCursor);
    }
    localCursor.close();
    y.d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: " + paramString);
    return localbi;
  }
  
  public final List<bi> W(String paramString, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + HT(paramString) + " WHERE type = 49 ORDER BY createTime DESC LIMIT " + paramInt1 + " , " + paramInt2;
    y.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.dXo.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bi localbi = new bi();
      localbi.d(paramString);
      if (localbi.aVK()) {
        localArrayList.add(localbi);
      }
    }
    paramString.close();
    return localArrayList;
  }
  
  public final long X(String paramString, long paramLong)
  {
    paramString = "select createTime from " + HT(paramString) + " where msgId = " + paramLong;
    paramLong = 0L;
    paramString = this.dXo.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      paramLong = paramString.getLong(0);
    }
    paramString.close();
    return paramLong;
  }
  
  public final Cursor X(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      return null;
    }
    String str = HT(paramString);
    paramString = "select * from ( select * from " + str + " where" + acd(paramString) + " AND type IN (3,39,13,43,62,44,268435505)  order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    return this.dXo.a(paramString, null, 2);
  }
  
  public final int Y(String paramString, long paramLong)
  {
    bi localbi = O(paramString, paramLong);
    this.uCy.k((int)(bk.UX() / 86400L), localbi.field_msgSvrId, localbi.field_createTime / 1000L);
    int i = this.dXo.delete(HT(paramString), "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      doNotify();
      a(new g.c(paramString, "delete", null, 1, (byte)0));
      return i;
    }
    com.tencent.mm.plugin.report.f.nEG.a(111L, 246L, 1L, false);
    return i;
  }
  
  public final int Z(String paramString, long paramLong)
  {
    String str = acd(paramString) + " and createTime <= " + paramLong;
    b(HT(paramString), str, null);
    int i = this.dXo.delete(HT(paramString), str, null);
    if (i != 0)
    {
      aam("delete_talker " + paramString);
      paramString = new g.c(paramString, "delete", null, i, (byte)0);
      paramString.mdy = -1L;
      a(paramString);
    }
    return i;
  }
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = new StringBuilder("SELECT * FROM ").append(HT(paramString)).append(" WHERE").append(acd(paramString)).append("AND createTime >= ").append(paramLong2).append(" AND createTime <= ").append(paramLong1).append(" AND isSend=");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString = i + " LIMIT 1";
        y.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
        return this.dXo.a(paramString, null, 0);
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void a(long paramLong, bi parambi)
  {
    if (parambi.cvl())
    {
      String str = acf(parambi.czr);
      if (s.hQ(str))
      {
        y.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
        parambi.ec("notifymessage");
      }
    }
    al(parambi);
    if (this.dXo.update(hH(paramLong), parambi.vf(), "msgId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new g.c(parambi.field_talker, "update", parambi));
      return;
    }
    com.tencent.mm.plugin.report.f.nEG.a(111L, 244L, 1L, false);
  }
  
  public final void a(h paramh, String paramString)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    Cursor localCursor = paramh.a("PRAGMA table_info( " + paramString + " )", null, 2);
    int i5 = localCursor.getColumnIndex("name");
    while (localCursor.moveToNext()) {
      if (i5 >= 0)
      {
        String str = localCursor.getString(i5);
        if ("lvbuffer".equalsIgnoreCase(str)) {
          i = 1;
        } else if ("transContent".equalsIgnoreCase(str)) {
          j = 1;
        } else if ("transBrandWording".equalsIgnoreCase(str)) {
          k = 1;
        } else if ("talkerId".equalsIgnoreCase(str)) {
          m = 1;
        } else if ("bizClientMsgId".equalsIgnoreCase(str)) {
          n = 1;
        } else if ("bizChatId".equalsIgnoreCase(str)) {
          i1 = 1;
        } else if ("bizChatUserId".equalsIgnoreCase(str)) {
          i2 = 1;
        } else if ("msgSeq".equalsIgnoreCase(str)) {
          i3 = 1;
        } else if ("flag".equalsIgnoreCase(str)) {
          i4 = 1;
        }
      }
    }
    localCursor.close();
    long l = paramh.eV(Thread.currentThread().getId());
    if (i == 0) {
      paramh.gk(paramString, "Alter table " + paramString + " add lvbuffer BLOB ");
    }
    if (j == 0) {
      paramh.gk(paramString, "Alter table " + paramString + " add transContent TEXT ");
    }
    if (k == 0) {
      paramh.gk(paramString, "Alter table " + paramString + " add transBrandWording TEXT ");
    }
    if (m == 0) {
      paramh.gk(paramString, "Alter table " + paramString + " add talkerId INTEGER ");
    }
    if (n == 0) {
      paramh.gk(paramString, "Alter table " + paramString + " add bizClientMsgId TEXT ");
    }
    if (i1 == 0) {
      paramh.gk(paramString, "Alter table " + paramString + " add bizChatId INTEGER DEFAULT -1");
    }
    if (i2 == 0) {
      paramh.gk(paramString, "Alter table " + paramString + " add bizChatUserId TEXT ");
    }
    if (i3 == 0) {
      paramh.gk(paramString, "Alter table " + paramString + " add msgSeq INTEGER ");
    }
    if (i4 == 0) {
      paramh.gk(paramString, "Alter table " + paramString + " add flag INT DEFAULT 0 ");
    }
    paramh.hI(l);
  }
  
  public final void a(g.a parama)
  {
    this.umW.remove(parama);
  }
  
  public final void a(g.a parama, Looper paramLooper)
  {
    this.umW.a(parama, paramLooper);
  }
  
  public final void a(g.b paramb)
  {
    synchronized (this.uCr)
    {
      this.uCr.add(paramb);
      b(paramb);
      return;
    }
  }
  
  public final void a(g.c paramc)
  {
    if (this.umW.bV(paramc)) {
      this.umW.doNotify();
    }
  }
  
  public final void a(e parame)
  {
    if (!this.uCq.contains(parame))
    {
      y.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", new Object[] { parame });
      this.uCq.add(parame);
    }
  }
  
  public final int aa(String paramString, long paramLong)
  {
    int i = 0;
    bi localbi = fd(paramLong);
    if (localbi.field_msgId == 0L)
    {
      y.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      return 0;
    }
    String str = HT(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " " + acg(str) + " WHERE " + acd(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + localbi.field_createTime;
    paramString = this.dXo.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    return i;
  }
  
  public final String ab(String paramString, long paramLong)
  {
    int i = 0;
    Object localObject1 = fd(paramLong);
    if (((cs)localObject1).field_msgId == 0L)
    {
      y.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      return null;
    }
    Object localObject2 = HT(paramString);
    paramString = "EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + (String)localObject2 + " " + acg((String)localObject2) + " WHERE" + acd(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + ((cs)localObject1).field_createTime;
    localObject2 = this.dXo.a(paramString, null, 0);
    paramString = "";
    localObject1 = paramString;
    if (((Cursor)localObject2).moveToFirst()) {
      for (;;)
      {
        localObject1 = paramString;
        if (i >= ((Cursor)localObject2).getColumnCount()) {
          break;
        }
        paramString = paramString + ((Cursor)localObject2).getString(i) + " ";
        i += 1;
      }
    }
    ((Cursor)localObject2).close();
    return localObject1;
  }
  
  public final bi ac(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject = "select * from message where" + acd(paramString) + " and msgSeq < " + paramLong + " order by msgSeq DESC LIMIT 1 ";
    y.i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: " + (String)localObject);
    localObject = this.dXo.a((String)localObject, null, 0);
    if (localObject == null)
    {
      y.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed " + paramString);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new bi();
      paramString.d((Cursor)localObject);
      ((Cursor)localObject).close();
      return paramString;
    }
    ((Cursor)localObject).close();
    return null;
  }
  
  public final bi ad(String paramString, long paramLong)
  {
    y.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(1) });
    bi localbi = new bi();
    paramString = "SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime < " + paramLong + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1";
    y.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.dXo.a(paramString, null, 0);
    if (paramString == null)
    {
      y.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      return localbi;
    }
    if (paramString.moveToLast())
    {
      localbi.d(paramString);
      paramString.close();
      return localbi;
    }
    paramString.close();
    y.w("MicroMsg.MsgInfoStorage", "get result fail");
    return localbi;
  }
  
  public final long b(bi parambi, boolean paramBoolean)
  {
    if ((parambi == null) || (bk.bl(parambi.field_talker)))
    {
      com.tencent.mm.plugin.report.f.nEG.a(111L, 250L, 1L, false);
      if (parambi == null) {}
      for (localObject1 = "-1";; localObject1 = parambi.field_talker)
      {
        y.e("MicroMsg.MsgInfoStorage", "Error insert message msg:%s talker:%s", new Object[] { parambi, localObject1 });
        return -1L;
      }
    }
    y.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", new Object[] { Boolean.valueOf(this.uCA), Long.valueOf(parambi.field_msgSeq) });
    Object localObject1 = null;
    Object localObject2 = com.tencent.mm.model.bd.iM(parambi.czr);
    if (localObject2 != null) {
      localObject1 = ((bd.b)localObject2).dWv;
    }
    if (s.hQ((String)localObject1))
    {
      y.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { localObject1 });
      if (parambi.getType() == 436207665)
      {
        y.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
        return -1L;
      }
      parambi.ec("notifymessage");
    }
    localObject1 = aci(parambi.field_talker);
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.report.f.nEG.a(111L, 249L, 1L, false);
      y.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", new Object[] { parambi.field_talker });
      return -1L;
    }
    ((g.b)localObject1).bif();
    parambi.setMsgId(((g.b)localObject1).enx);
    Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[] { Long.valueOf(parambi.field_msgId), localObject1, hH(parambi.field_msgId) }), ((g.b)localObject1).name.equals(hH(parambi.field_msgId)));
    if (parambi.field_msgSvrId != 0L)
    {
      parambi.cQJ = 1;
      parambi.cyX = true;
    }
    Iterator localIterator = this.uCq.iterator();
    while (localIterator.hasNext()) {
      if (!((e)localIterator.next()).a(parambi, (bd.b)localObject2))
      {
        y.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", new Object[] { parambi.field_talker, parambi.czr });
        return -1L;
      }
    }
    al(parambi);
    if (((g.b)localObject1).name.equals("message"))
    {
      parambi.field_talkerId = ((int)ace(parambi.field_talker));
      parambi.cyY = true;
    }
    localObject2 = parambi.vf();
    long l = this.dXo.a(((g.b)localObject1).name, "msgId", (ContentValues)localObject2, paramBoolean);
    y.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", new Object[] { Long.valueOf(l), parambi.field_talker, Long.valueOf(parambi.field_msgId), Integer.valueOf(parambi.getType()), Integer.valueOf(parambi.field_status), Long.valueOf(parambi.field_msgSvrId), Long.valueOf(parambi.field_msgSeq), Integer.valueOf(parambi.field_flag), Long.valueOf(parambi.field_createTime), Integer.valueOf(parambi.field_isSend), this.uCB, Long.valueOf(bk.co(this.uCC)) });
    if (l == -1L)
    {
      com.tencent.mm.plugin.report.f.nEG.a(111L, 248L, 1L, false);
      y.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", new Object[] { Long.valueOf(parambi.field_msgSvrId), Long.valueOf(l) });
      return -1L;
    }
    if ((this.uCA) && (bk.co(this.uCC) > 2000L) && (parambi.field_isSend == 1) && (parambi.field_status == 1))
    {
      y.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", new Object[] { this.uCB, Long.valueOf(bk.co(this.uCC)) });
      Hw(this.uCB);
    }
    if (this.uCA)
    {
      localObject1 = null;
      if (e.umQ != null) {
        localObject1 = e.umQ.I(parambi);
      }
      if (!bk.bl((String)localObject1)) {
        break label924;
      }
    }
    label924:
    for (localObject2 = parambi.field_talker;; localObject2 = localObject1)
    {
      localObject1 = null;
      if (this.uCz.containsKey(localObject2)) {
        localObject1 = (g.c)this.uCz.get(localObject2);
      }
      if (localObject1 == null)
      {
        localObject1 = new g.c(parambi.field_talker, "insert", parambi);
        if (g.c.W(parambi)) {
          ((g.c)localObject1).mdv += 1;
        }
        ((g.c)localObject1).mdw += 1;
        this.uCz.put(localObject2, localObject1);
      }
      for (;;)
      {
        return parambi.field_msgId;
        ((g.c)localObject1).mdu.add(parambi);
        break;
        localObject1 = new g.c(parambi.field_talker, "insert", parambi);
        if (g.c.W(parambi)) {
          ((g.c)localObject1).mdv = 1;
        }
        ((g.c)localObject1).mdw = 1;
        doNotify();
        a((g.c)localObject1);
      }
    }
  }
  
  public final Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(HT(paramString)).append(" WHERE").append(acd(paramString));
      if (paramLong2 > 0L)
      {
        str = " AND createTime >= " + paramLong2;
        localStringBuilder = localStringBuilder.append(str);
        if (paramLong1 <= 0L) {
          break label179;
        }
      }
      label179:
      for (String str = " AND createTime <= " + paramLong1;; str = "")
      {
        str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
        y.d("MicroMsg.MsgInfoStorage", "getCursorAfterStratTimeBeforeEndTimeLimit talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
        return this.dXo.a(str, null, 0);
        str = "";
        break;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void b(long paramLong, bi parambi)
  {
    if (bk.pm(parambi.field_talker).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("no talker set when update by svrid", bool);
      if (parambi.cvl())
      {
        String str = acf(parambi.czr);
        if (s.hQ(str))
        {
          y.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
          parambi.ec("notifymessage");
        }
      }
      al(parambi);
      if (this.dXo.update(HT(parambi.field_talker), parambi.vf(), "msgSvrId=?", new String[] { String.valueOf(paramLong) }) == 0) {
        break;
      }
      doNotify();
      a(new g.c(parambi.field_talker, "update", parambi));
      return;
    }
    com.tencent.mm.plugin.report.f.nEG.a(111L, 243L, 1L, false);
  }
  
  public final void b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l = bk.UX();
    Object localObject = "SELECT msgSvrId,createTime FROM " + paramString1 + " WHERE createTime > " + (l - 172800L) * 1000L;
    paramString1 = (String)localObject;
    if (!bk.bl(paramString2)) {
      paramString1 = (String)localObject + " AND " + paramString2;
    }
    paramString2 = new ArrayList();
    localObject = new ArrayList();
    paramString1 = this.dXo.a(paramString1, paramArrayOfString, 2);
    if (paramString1.moveToFirst())
    {
      do
      {
        int i = paramString1.getInt(0);
        l = paramString1.getLong(1) / 1000L;
        paramString2.add(Integer.valueOf(i));
        ((List)localObject).add(Long.valueOf(l));
      } while (paramString1.moveToNext());
      this.uCy.k(paramString2, (List)localObject);
    }
    paramString1.close();
  }
  
  public final List<bi> bM(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.uCr != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND status = 3 AND type <> 10000 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.dXo.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bi localbi = new bi();
        localbi.d(paramString);
        localArrayList.add(localbi);
      }
    }
    paramString.close();
    return localArrayList;
  }
  
  public final List<bi> bN(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.uCr != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.dXo.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bi localbi = new bi();
        localbi.d(paramString);
        if (localbi.isText()) {
          localArrayList.add(localbi);
        }
      }
    }
    paramString.close();
    return localArrayList;
  }
  
  public final Cursor bO(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      return null;
    }
    String str = HT(paramString);
    paramString = "select * from " + str + " where" + acd(paramString) + " AND type = 49  order by createTime DESC limit " + paramInt + " OFFSET 0";
    return this.dXo.a(paramString, null, 0);
  }
  
  public final Cursor bP(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      return null;
    }
    Object localObject = HT(paramString);
    paramString = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend from ").append((String)localObject).append(" where").append(acd(paramString)).append(" AND ");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" (type = 49");
    ((StringBuilder)localObject).append(" or type = 587202609");
    ((StringBuilder)localObject).append(" or type = 553648177) ");
    paramString = ((StringBuilder)localObject).toString() + "  order by createTime DESC limit 100 OFFSET " + paramInt;
    return this.dXo.a(paramString, null, 0);
  }
  
  public final int bQ(String paramString, int paramInt)
  {
    y.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", new Object[] { paramString, Integer.valueOf(paramInt), ak.crj() });
    bi localbi = O(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbi.field_talker));
    b(HT(paramString), "createTime<=? AND" + acd(paramString), new String[] { localbi.field_createTime });
    paramInt = this.dXo.delete(HT(paramString), "createTime<=? AND" + acd(paramString), new String[] { localbi.field_createTime });
    if (paramInt != 0)
    {
      doNotify();
      a(new g.c(paramString, "delete", null, paramInt, (byte)0));
    }
    return paramInt;
  }
  
  public final Cursor bR(String paramString, int paramInt)
  {
    bi localbi = O(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbi.field_talker));
    return this.dXo.query(HT(paramString), null, "createTime<=? AND" + acd(paramString), new String[] { localbi.field_createTime }, null, null, null);
  }
  
  public final Cursor bS(String paramString, int paramInt)
  {
    return this.dXo.query(HT(paramString), null, "isSend=? AND" + acd(paramString) + "AND status!=?  order by msgId DESC limit " + paramInt, new String[] { "0", "4" }, null, null, null);
  }
  
  public final int bT(String paramString, int paramInt)
  {
    int i = 0;
    paramString = "SELECT COUNT(*) FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND type = " + paramInt;
    paramString = this.dXo.a(paramString, null, 2);
    paramInt = i;
    if (paramString.moveToFirst()) {
      paramInt = paramString.getInt(0);
    }
    paramString.close();
    return paramInt;
  }
  
  public final Cursor bU(String paramString, int paramInt)
  {
    String str = " SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + paramInt;
    y.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    return this.dXo.a(str, null, 0);
  }
  
  public final bi[] bV(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramInt <= 0))
    {
      y.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + paramString + ", limit = " + paramInt);
      return null;
    }
    Object localObject = "select * from " + HT(paramString) + " where" + acd(paramString) + "order by createTime DESC limit " + paramInt;
    localObject = this.dXo.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        bi localbi = new bi();
        localbi.d((Cursor)localObject);
        localArrayList.add(localbi);
      } while (((Cursor)localObject).moveToNext());
      ((Cursor)localObject).close();
      y.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + paramString + ", limit = " + paramInt + ", count = " + localArrayList.size());
      Collections.reverse(localArrayList);
      return (bi[])localArrayList.toArray(new bi[localArrayList.size()]);
    }
    y.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
    ((Cursor)localObject).close();
    return null;
  }
  
  public final Cursor bW(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      return null;
    }
    String str = HT(paramString);
    paramString = "select * from " + str + " where" + acd(paramString) + " AND type IN (436207665,419430449)  order by createTime DESC limit " + paramInt + " OFFSET 0";
    return this.dXo.a(paramString, null, 0);
  }
  
  public final h bhV()
  {
    return this.dXo;
  }
  
  public final void bhW()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().o(348167, Integer.valueOf(1));
  }
  
  public final void bhX()
  {
    int i = 0;
    while (i < this.uCr.size())
    {
      b((g.b)this.uCr.get(i));
      i += 1;
    }
  }
  
  public final void bhY()
  {
    if (!this.uCp) {}
    Object localObject;
    do
    {
      return;
      localObject = "select count(*) from " + "message" + " where talkerId ISNULL ";
      localObject = this.dXo.a((String)localObject, null, 2);
    } while (localObject == null);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      if (i <= 0) {
        break;
      }
      y.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", new Object[] { "message" });
      long l = System.currentTimeMillis();
      localObject = "update " + "message" + " set talkerId=(select rowid from rcontact where rcontact.username = " + "message" + ".talker)";
      boolean bool = this.dXo.gk("message", (String)localObject);
      y.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
      if ((!bool) || (!this.uCp)) {
        break;
      }
      this.dXo.gk("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
      this.dXo.gk("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
      this.dXo.gk("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
      this.dXo.gk("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
      this.dXo.gk("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
      y.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
      return;
    }
  }
  
  public final ArrayList<bi> bhZ()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.dXo.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[] { String.valueOf(System.currentTimeMillis() - 172800000L), "5", "1" }, null, null, "createTime ASC", 2);
    label143:
    while (localCursor.moveToNext())
    {
      bi localbi = new bi();
      localbi.d(localCursor);
      if (!localbi.cvA()) {}
      for (int i = 1;; i = 0)
      {
        if (((i & 0x1) == 0) || (ad.aaR(localbi.field_talker)) || (ad.aaT(localbi.field_talker)) || (ad.hd(localbi.field_talker))) {
          break label143;
        }
        localArrayList.add(localbi);
        break;
      }
    }
    localCursor.close();
    return localArrayList;
  }
  
  public final List<bi> bia()
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    Object localObject1;
    int i;
    if (this.uCr != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject1 = new ArrayList();
      i = 0;
    }
    Object localObject2;
    for (;;)
    {
      if (i >= this.uCr.size()) {
        break label201;
      }
      localObject2 = this.dXo.a(((g.b)this.uCr.get(i)).name, null, "status=1 and isSend=1", null, null, null, "createTime DESC ", 2);
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label187;
        }
        bi localbi = new bi();
        localbi.d((Cursor)localObject2);
        if ((localbi.isText()) || (localbi.cvn()) || (localbi.aVM()) || (localbi.cvv()))
        {
          if (com.tencent.mm.model.bd.HM() - localbi.field_createTime > 86400000L)
          {
            ((List)localObject1).add(localbi);
            continue;
            bool = false;
            break;
          }
          localArrayList.add(localbi);
        }
      }
      label187:
      ((Cursor)localObject2).close();
      i += 1;
    }
    label201:
    if (((List)localObject1).size() > 0)
    {
      long l = this.dXo.eV(-1L);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bi)((Iterator)localObject1).next();
        y.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", new Object[] { Long.valueOf(((cs)localObject2).field_msgId), Long.valueOf(((cs)localObject2).field_createTime), ((cs)localObject2).field_talker, bk.aac(((cs)localObject2).field_content) });
        ((bi)localObject2).setStatus(5);
        a(((cs)localObject2).field_msgId, (bi)localObject2);
      }
      this.dXo.hI(l);
    }
    return localArrayList;
  }
  
  public final Cursor bib()
  {
    return this.dXo.query("message", new String[] { "talker", "count(*) as unReadCount" }, "isSend=? AND status!=?", new String[] { "0", "4" }, "talker", null, null);
  }
  
  public final String bic()
  {
    return "type IN (3,39,13,43,62,44,268435505)";
  }
  
  public final String bid()
  {
    return "type IN (3,39,13,43,62,44,49,268435505)";
  }
  
  /* Error */
  public final List<bi> bie()
  {
    // Byte code:
    //   0: new 513	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 514	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 135	com/tencent/mm/storage/bj:dXo	Lcom/tencent/mm/cf/h;
    //   12: ldc 64
    //   14: aconst_null
    //   15: ldc_w 1620
    //   18: iconst_1
    //   19: anewarray 54	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: invokestatic 498	java/lang/System:currentTimeMillis	()J
    //   27: ldc2_w 932
    //   30: lsub
    //   31: invokestatic 935	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   34: aastore
    //   35: aconst_null
    //   36: aconst_null
    //   37: ldc_w 937
    //   40: iconst_2
    //   41: invokevirtual 940	com/tencent/mm/cf/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_2
    //   48: invokeinterface 684 1 0
    //   53: ifeq +69 -> 122
    //   56: aload_2
    //   57: astore_1
    //   58: new 397	com/tencent/mm/storage/bi
    //   61: dup
    //   62: invokespecial 639	com/tencent/mm/storage/bi:<init>	()V
    //   65: astore 4
    //   67: aload_2
    //   68: astore_1
    //   69: aload 4
    //   71: aload_2
    //   72: invokevirtual 648	com/tencent/mm/storage/bi:d	(Landroid/database/Cursor;)V
    //   75: aload_2
    //   76: astore_1
    //   77: aload_3
    //   78: aload 4
    //   80: invokevirtual 941	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   83: pop
    //   84: goto -39 -> 45
    //   87: astore_3
    //   88: aload_2
    //   89: astore_1
    //   90: ldc 174
    //   92: aload_3
    //   93: ldc_w 943
    //   96: iconst_1
    //   97: anewarray 178	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_3
    //   103: invokevirtual 338	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 928	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_2
    //   111: ifnull +9 -> 120
    //   114: aload_2
    //   115: invokeinterface 487 1 0
    //   120: aconst_null
    //   121: areturn
    //   122: aload_2
    //   123: ifnull +9 -> 132
    //   126: aload_2
    //   127: invokeinterface 487 1 0
    //   132: aload_3
    //   133: areturn
    //   134: astore_2
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull +9 -> 147
    //   141: aload_1
    //   142: invokeinterface 487 1 0
    //   147: aload_2
    //   148: athrow
    //   149: astore_2
    //   150: goto -13 -> 137
    //   153: astore_3
    //   154: aconst_null
    //   155: astore_2
    //   156: goto -68 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	bj
    //   46	96	1	localCursor1	Cursor
    //   44	83	2	localCursor2	Cursor
    //   134	14	2	localObject1	Object
    //   149	1	2	localObject2	Object
    //   155	1	2	localObject3	Object
    //   7	71	3	localArrayList	ArrayList
    //   87	46	3	localException1	Exception
    //   153	1	3	localException2	Exception
    //   65	14	4	localbi	bi
    // Exception table:
    //   from	to	target	type
    //   47	56	87	java/lang/Exception
    //   58	67	87	java/lang/Exception
    //   69	75	87	java/lang/Exception
    //   77	84	87	java/lang/Exception
    //   0	45	134	finally
    //   47	56	149	finally
    //   58	67	149	finally
    //   69	75	149	finally
    //   77	84	149	finally
    //   90	110	149	finally
    //   0	45	153	java/lang/Exception
  }
  
  public final Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong2 == 0L)
    {
      paramString = "SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime > " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      y.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
      return this.dXo.a(paramString, null, 0);
    }
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      y.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
      return this.dXo.a(paramString, null, 0);
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int d(String paramString, long paramLong, int paramInt)
  {
    String str = "SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime ASC LIMIT -1 OFFSET " + paramInt;
    Cursor localCursor = this.dXo.a(str, null, 0);
    paramInt = localCursor.getCount();
    localCursor.close();
    y.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + paramString + " time:" + paramLong + " count " + paramInt + " [" + str + "]");
    return paramInt;
  }
  
  public final Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM (SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime DESC LIMIT " + paramInt + " ) ORDER BY createTime ASC";
      y.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
      return this.dXo.a(paramString, null, 0);
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final bi dP(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", new Object[] { paramString1 });
      return null;
    }
    bi localbi = new bi();
    paramString2 = "select * from " + HT(paramString1) + " where" + acd(paramString1) + paramString2 + " order by createTime DESC limit 1";
    paramString2 = this.dXo.a(paramString2, null, 2);
    if (paramString2.moveToFirst()) {
      localbi.d(paramString2);
    }
    paramString2.close();
    y.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", new Object[] { paramString1, Long.valueOf(localbi.field_msgId) });
    return localbi;
  }
  
  public final Cursor dQ(String paramString1, String paramString2)
  {
    paramString1 = "SELECT * FROM " + HT(paramString1) + " WHERE" + acd(paramString1) + "AND content LIKE '%" + paramString2 + "%' AND type = 1";
    paramString1 = paramString1 + " ORDER BY createTime DESC";
    return this.dXo.a(paramString1, null, 0);
  }
  
  public final int dR(String paramString1, String paramString2)
  {
    String str = " SELECT COUNT(*) FROM " + HT(paramString1) + " WHERE" + acd(paramString1) + "AND content LIKE '" + paramString2 + "%' ";
    Cursor localCursor = this.dXo.a(str, null, 2);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          break label163;
        }
        i = localCursor.getInt(0);
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
      }
      y.d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(i), str });
      return i;
      label163:
      int i = 0;
    }
  }
  
  public final LinkedList<bi> dS(String paramString1, String paramString2)
  {
    paramString1 = this.dXo.a("message", null, "talker=? AND bizClientMsgId=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
    if ((paramString1 == null) || (!paramString1.moveToFirst()))
    {
      y.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
      return null;
    }
    paramString2 = new LinkedList();
    do
    {
      bi localbi = new bi();
      localbi.d(paramString1);
      paramString2.add(localbi);
    } while (paramString1.moveToNext());
    paramString1.close();
    return paramString2;
  }
  
  public final long e(String paramString, long paramLong, int paramInt)
  {
    y.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      y.w("MicroMsg.MsgInfoStorage", "error target inc count");
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime DESC  LIMIT " + paramInt;
    y.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.dXo.a(paramString, null, 0);
    if (paramString == null)
    {
      y.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      y.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      return paramLong;
    }
    paramString.close();
    y.w("MicroMsg.MsgInfoStorage", "get result fail");
    return paramLong;
  }
  
  public final long f(String paramString, long paramLong, int paramInt)
  {
    y.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      y.w("MicroMsg.MsgInfoStorage", "error target inc count");
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC  LIMIT " + paramInt;
    y.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.dXo.a(paramString, null, 0);
    if (paramString == null)
    {
      y.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      y.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      return paramLong;
    }
    paramString.close();
    y.w("MicroMsg.MsgInfoStorage", "get result fail");
    return paramLong;
  }
  
  public final Cursor f(String paramString, int paramInt, long paramLong)
  {
    paramString = "SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + " AND createTime <= " + paramLong + " order by createTime ASC limit " + paramInt;
    return this.dXo.a(paramString, null, 0);
  }
  
  public final bi fd(long paramLong)
  {
    bi localbi = new bi();
    Cursor localCursor = this.dXo.a(hH(paramLong), null, "msgId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localbi.d(localCursor);
    }
    localCursor.close();
    return localbi;
  }
  
  public final int fe(long paramLong)
  {
    bi localbi = fd(paramLong);
    Object localObject = localbi.field_talker;
    this.uCy.k((int)(bk.UX() / 86400L), localbi.field_msgSvrId, localbi.field_createTime / 1000L);
    int i = this.dXo.delete(hH(paramLong), "msgId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      aam("delete_id " + paramLong);
      localObject = new g.c((String)localObject, "delete", localbi, 1, (byte)0);
      ((g.c)localObject).mdy = paramLong;
      ((g.c)localObject).idK = localbi.field_bizChatId;
      a((g.c)localObject);
      return i;
    }
    com.tencent.mm.plugin.report.f.nEG.a(111L, 245L, 1L, false);
    return i;
  }
  
  public final boolean ff(long paramLong)
  {
    return this.uCy.hF(paramLong);
  }
  
  public final boolean fg(long paramLong)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.uCr.size())
      {
        if (((g.b)this.uCr.get(i)).fi(paramLong)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final void fh(long paramLong)
  {
    this.uCy.b(0, paramLong, 0L, false);
  }
  
  public final Cursor g(String paramString, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(HT(paramString)).append(" WHERE").append(acd(paramString));
    if (paramLong > 0L) {}
    for (String str = " AND createTime > " + paramLong;; str = "")
    {
      str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
      y.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
      return this.dXo.a(str, null, 0);
    }
  }
  
  public final Cursor g(String paramString, long paramLong, int paramInt)
  {
    try
    {
      paramString = "select * from " + paramString + " where " + "type IN (3,39,13,43,62,44,49,268435505,34)" + " AND msgId >= " + paramLong + "  order by msgId ASC  limit " + paramInt;
      paramString = this.dXo.a(paramString, null, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public final List<bi> g(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
      return null;
    }
    paramLong = X(paramString, paramLong);
    if (paramLong == 0L)
    {
      y.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (paramString = "select * from " + HT(paramString) + " where" + acd(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime > " + paramLong + "  order by createTime ASC limit 10";; paramString = "select * from " + HT(paramString) + " where" + acd(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + paramLong + "  order by createTime DESC limit 10")
    {
      paramString = this.dXo.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bi localbi = new bi();
        localbi.d(paramString);
        localArrayList.add(localbi);
      }
    }
    if (!paramBoolean) {
      Collections.reverse(localArrayList);
    }
    paramString.close();
    return localArrayList;
  }
  
  public final void lock()
  {
    Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
  }
  
  public final Cursor p(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      return null;
    }
    String str = HT(paramString);
    paramString = "select * from " + str + " where" + acd(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    return this.dXo.a(paramString, null, 2);
  }
  
  public final int q(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    paramString = "SELECT COUNT(*) FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND type = 50 AND createTime >= " + paramLong1 + " AND createTime <= " + paramLong2 + " LIMIT 1";
    paramString = this.dXo.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    return i;
  }
  
  public final int r(String paramString, long paramLong1, long paramLong2)
  {
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      y.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      paramString = "SELECT COUNT(msgId) FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      y.d("MicroMsg.MsgInfoStorage", "get count sql: " + paramString);
      paramString = this.dXo.a(paramString, null, 2);
      if (paramString == null)
      {
        y.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
        return 0;
      }
      if (paramString.moveToFirst())
      {
        int i = paramString.getInt(0);
        y.d("MicroMsg.MsgInfoStorage", "result msg count %d", new Object[] { Integer.valueOf(i) });
        paramString.close();
        return i;
      }
      paramString.close();
      return 0;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final Cursor s(String paramString, long paramLong1, long paramLong2)
  {
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime ASC ";
      y.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
      return this.dXo.a(paramString, null, 0);
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int t(String paramString, long paramLong1, long paramLong2)
  {
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ( SELECT * FROM ").append(HT(paramString)).append(" WHERE").append(acd(paramString));
      if (paramLong2 > 0L)
      {
        str = " AND createTime >= " + paramLong2;
        localStringBuilder = localStringBuilder.append(str);
        if (paramLong1 <= 0L) {
          break label190;
        }
      }
      label190:
      for (String str = " AND createTime <= " + paramLong1;; str = "")
      {
        str = str + " ORDER BY createTime)";
        y.d("MicroMsg.MsgInfoStorage", "getCountAfterStratTimeBeforeEndTime talk:%s [%s]", new Object[] { paramString, str });
        paramString = this.dXo.a(str, null, 2);
        int i = 0;
        try
        {
          if (paramString.moveToFirst()) {
            i = paramString.getInt(0);
          }
          return i;
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
          return 0;
        }
        finally
        {
          paramString.close();
        }
        str = "";
        break;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final bi tE(int paramInt)
  {
    if (this.uCr == null)
    {
      y.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      return null;
    }
    bi localbi = new bi();
    long l1 = 0L;
    int i = 0;
    while (i < this.uCr.size())
    {
      long l2 = l1;
      if ((((g.b)this.uCr.get(i)).mdq & paramInt) != 0)
      {
        Object localObject = "select * from " + ((g.b)this.uCr.get(i)).name + "  order by createTime DESC limit 1";
        localObject = this.dXo.a((String)localObject, null, 2);
        l2 = l1;
        if (((Cursor)localObject).moveToFirst())
        {
          long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
          l2 = l1;
          if (l1 < l3)
          {
            localbi.d((Cursor)localObject);
            l2 = l3;
          }
        }
        ((Cursor)localObject).close();
      }
      i += 1;
      l1 = l2;
    }
    return localbi;
  }
  
  public final int u(String paramString, long paramLong1, long paramLong2)
  {
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT COUNT(*) FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1;
      paramString = this.dXo.a(paramString, null, 2);
      for (;;)
      {
        try
        {
          if (paramString.moveToFirst())
          {
            i = paramString.getInt(0);
            return i;
          }
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
          return 0;
        }
        finally
        {
          paramString.close();
        }
        int i = 0;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void unlock()
  {
    Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
  }
  
  public final Cursor v(String paramString, long paramLong1, long paramLong2)
  {
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + HT(paramString) + " WHERE" + acd(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      y.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
      return this.dXo.a(paramString, null, 0);
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bj
 * JD-Core Version:    0.7.0.1
 */