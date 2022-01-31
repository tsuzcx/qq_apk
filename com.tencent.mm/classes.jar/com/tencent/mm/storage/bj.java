package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
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
  extends k
  implements com.tencent.mm.plugin.messenger.foundation.a.a.h
{
  public static final String[] SQL_CREATE;
  private final com.tencent.mm.cg.h fnw;
  private bd jGn;
  private be jGp;
  private final long yMI;
  private boolean yOB;
  private final List<e> yOC;
  private List<h.b> yOD;
  private final com.tencent.mm.a.f<Integer, bi.c> yOE;
  private final com.tencent.mm.a.f<Integer, bi.d> yOF;
  private final com.tencent.mm.a.f<Integer, bi.a> yOG;
  private final com.tencent.mm.a.f<Integer, bi.b> yOH;
  private final com.tencent.mm.a.f<Integer, Object> yOI;
  private final com.tencent.mm.a.f<String, Long> yOJ;
  private an yOK;
  private Map<String, h.c> yOL;
  private boolean yOM;
  private String yON;
  private long yOO;
  private final com.tencent.mm.sdk.e.l<h.a, h.c> ywD;
  
  static
  {
    AppMethodBeat.i(1450);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag INT) " };
    AppMethodBeat.o(1450);
  }
  
  public bj(com.tencent.mm.cg.h paramh, bd parambd, be parambe)
  {
    AppMethodBeat.i(1334);
    this.yOB = false;
    this.yOC = new CopyOnWriteArrayList();
    this.yOE = new c(100);
    this.yOF = new c(100);
    this.yOG = new c(100);
    this.yOH = new c(100);
    this.yOI = new c(100);
    this.yOJ = new c(100);
    this.yOK = new an();
    this.ywD = new com.tencent.mm.sdk.e.l()
    {
      public final void et(List<h.c> paramAnonymousList)
      {
        AppMethodBeat.i(1319);
        if ((!isLocked()) && (bj.a(bj.this) != null))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            h.c localc = (h.c)paramAnonymousList.next();
            if (localc != null) {
              bj.a(bj.this).b(bj.this, localc);
            }
          }
        }
        AppMethodBeat.o(1319);
      }
    };
    this.yOL = new HashMap();
    this.yOM = false;
    this.yON = "";
    this.yOO = 0L;
    this.yMI = 86400L;
    this.fnw = paramh;
    this.jGn = parambd;
    this.jGp = parambe;
    g.RM();
    if (((Integer)g.RL().Ru().get(348169, Integer.valueOf(0))).intValue() == 0)
    {
      ab.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", new Object[] { Integer.valueOf(this.fnw.delete("message", "msgId> ? ", new String[] { "80000000" })) });
      g.RM();
      g.RL().Ru().set(348169, Integer.valueOf(1));
    }
    a(paramh, "message");
    dyB();
    if (this.yOD == null) {
      this.yOD = new LinkedList();
    }
    this.yOD.clear();
    a(new h.b(1, "message", h.b.a(1L, 1000000L, 10000000L, 90000000L)));
    AppMethodBeat.o(1334);
  }
  
  private String asn(String paramString)
  {
    AppMethodBeat.i(1348);
    String str = TC(paramString);
    if ((this.yOB) && (str.equals("message")))
    {
      paramString = " talkerId=" + aso(paramString) + " ";
      AppMethodBeat.o(1348);
      return paramString;
    }
    paramString = " talker= '" + bo.wC(paramString) + "' ";
    AppMethodBeat.o(1348);
    return paramString;
  }
  
  private long aso(String paramString)
  {
    AppMethodBeat.i(1349);
    long l = this.jGn.arx(paramString);
    if (l < 0L) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        ad localad = new ad(paramString);
        localad.setType(2);
        this.jGn.Y(localad);
        l = this.jGn.arx(paramString);
      }
      if (!b.dsh()) {
        ab.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", new Object[] { paramString, Long.valueOf(l), Boolean.valueOf(bool), bo.dtY() });
      }
      AppMethodBeat.o(1349);
      return l;
    }
  }
  
  private static String asp(String paramString)
  {
    AppMethodBeat.i(1366);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1366);
      return null;
    }
    try
    {
      paramString = br.F(paramString, "msgsource");
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(1366);
        return null;
      }
      paramString = (String)paramString.get(".msgsource.bizmsg.msgcluster");
      AppMethodBeat.o(1366);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.MsgInfoStorage", "exception:%s", new Object[] { bo.l(paramString) });
      ab.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(1366);
    }
    return null;
  }
  
  private String asq(String paramString)
  {
    AppMethodBeat.i(1408);
    if ((paramString == null) || (!paramString.equals("message")))
    {
      AppMethodBeat.o(1408);
      return "";
    }
    if (this.yOB)
    {
      AppMethodBeat.o(1408);
      return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
    }
    AppMethodBeat.o(1408);
    return "INDEXED BY messageCreateTaklerTypeTimeIndex";
  }
  
  private h.b asr(String paramString)
  {
    AppMethodBeat.i(1415);
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
      if (i >= this.yOD.size()) {
        break label98;
      }
      if (paramString.equals(((h.b)this.yOD.get(i)).name))
      {
        paramString = (h.b)this.yOD.get(i);
        AppMethodBeat.o(1415);
        return paramString;
        bool = false;
        break;
      }
      i += 1;
    }
    label98:
    Assert.assertTrue("no table match", false);
    AppMethodBeat.o(1415);
    return null;
  }
  
  private String ass(String paramString)
  {
    AppMethodBeat.i(1416);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Iterator localIterator = this.yOC.iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = ((e)localIterator.next()).aqO(paramString);
      } while (bo.isNullOrNil(str));
      AppMethodBeat.o(1416);
      return str;
    }
    AppMethodBeat.o(1416);
    return "message";
  }
  
  private h.b ast(String paramString)
  {
    AppMethodBeat.i(1417);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = asr(ass(paramString));
      AppMethodBeat.o(1417);
      return paramString;
    }
  }
  
  private static void at(bi parambi)
  {
    AppMethodBeat.i(1367);
    if ((parambi == null) || (!parambi.bCn()))
    {
      AppMethodBeat.o(1367);
      return;
    }
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
      localObject = br.F((String)localObject, "msg");
      if ((localObject != null) && (((Map)localObject).size() > 0)) {
        parambi.kl(com.tencent.mm.sdk.platformtools.be.aT((Map)localObject));
      }
      AppMethodBeat.o(1367);
      return;
    }
    catch (Exception parambi)
    {
      ab.e("MicroMsg.MsgInfoStorage", parambi.getMessage());
      AppMethodBeat.o(1367);
    }
  }
  
  private void b(h.b paramb)
  {
    AppMethodBeat.i(1337);
    Cursor localCursor = this.fnw.a("select max(msgid) from " + paramb.name, null, 2);
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      ab.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramb.fDU) });
      if (i >= paramb.fDU) {
        paramb.yV(i);
      }
    }
    localCursor.close();
    ab.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + paramb.fDU);
    AppMethodBeat.o(1337);
  }
  
  private void dyB()
  {
    AppMethodBeat.i(1332);
    long l1 = System.currentTimeMillis();
    long l2 = this.fnw.kr(Thread.currentThread().getId());
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
    if (!this.yOB)
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
      this.fnw.execSQL("message", (String)localArrayList.get(i));
      i += 1;
    }
    ab.i("MicroMsg.MsgInfoStorage", "build new index last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    this.fnw.nY(l2);
    ab.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(1332);
  }
  
  private String dyC()
  {
    if (this.yOB) {
      return "INDEXED BY messageTalkerIdStatusIndex";
    }
    return "INDEXED BY messageTalkerStatusIndex";
  }
  
  private String oq(long paramLong)
  {
    AppMethodBeat.i(1419);
    if ((paramLong == 0L) || (paramLong == -1L))
    {
      AppMethodBeat.o(1419);
      return null;
    }
    bi.op(paramLong);
    int i = 0;
    while (i < this.yOD.size())
    {
      if (((h.b)this.yOD.get(i)).kG(paramLong))
      {
        String str = ((h.b)this.yOD.get(i)).name;
        AppMethodBeat.o(1419);
        return str;
      }
      i += 1;
    }
    Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[] { Long.valueOf(paramLong) }), false);
    AppMethodBeat.o(1419);
    return null;
  }
  
  public final Cursor A(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(1427);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime ASC ";
      ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.fnw.a(paramString, null, 0);
      AppMethodBeat.o(1427);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int B(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(1430);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ( SELECT * FROM ").append(TC(paramString)).append(" WHERE").append(asn(paramString));
      if (paramLong2 > 0L)
      {
        str = " AND createTime >= ".concat(String.valueOf(paramLong2));
        localStringBuilder = localStringBuilder.append(str);
        if (paramLong1 <= 0L) {
          break label191;
        }
      }
      int j;
      int i;
      label191:
      for (String str = " AND createTime <= ".concat(String.valueOf(paramLong1));; str = "")
      {
        str = str + " ORDER BY createTime)";
        ab.d("MicroMsg.MsgInfoStorage", "getCountAfterStratTimeBeforeEndTime talk:%s [%s]", new Object[] { paramString, str });
        paramString = this.fnw.a(str, null, 2);
        j = 0;
        i = 0;
        try
        {
          if (paramString.moveToFirst()) {
            i = paramString.getInt(0);
          }
          paramString.close();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
            paramString.close();
            i = j;
          }
        }
        finally
        {
          paramString.close();
          AppMethodBeat.o(1430);
        }
        AppMethodBeat.o(1430);
        return i;
        str = "";
        break;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int C(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(1432);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT COUNT(*) FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1;
      paramString = this.fnw.a(paramString, null, 2);
      for (;;)
      {
        try
        {
          if (!paramString.moveToFirst()) {
            break label158;
          }
          i = paramString.getInt(0);
          paramString.close();
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
          paramString.close();
          i = 0;
          continue;
        }
        finally
        {
          paramString.close();
          AppMethodBeat.o(1432);
        }
        AppMethodBeat.o(1432);
        return i;
        label158:
        int i = 0;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final Cursor D(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(1433);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.fnw.a(paramString, null, 0);
      AppMethodBeat.o(1433);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void J(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(1351);
    long l1 = this.fnw.kr(-1L);
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        long l2 = ((Long)paramArrayList.next()).longValue();
        bi localbi = kB(l2);
        localbi.hr(localbi.dnr | 0x20);
        ab.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
        a(l2, localbi);
      }
      this.fnw.nY(l1);
    }
    finally
    {
      this.fnw.nY(l1);
      AppMethodBeat.o(1351);
    }
    AppMethodBeat.o(1351);
  }
  
  public final Cursor L(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(1434);
    String str = " SELECT * FROM " + TC(paramString1) + " WHERE" + asn(paramString1) + "AND content LIKE '" + paramString2 + "%' ORDER BY createTime DESC LIMIT " + paramInt;
    ab.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), str });
    paramString1 = this.fnw.a(str, null, 0);
    AppMethodBeat.o(1434);
    return paramString1;
  }
  
  public final int TA(String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(1405);
    if (px(paramString))
    {
      i = this.jGp.arY(paramString);
      if (i > 0)
      {
        ab.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(1405);
        return i;
      }
      ab.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    }
    do
    {
      i = pw(paramString);
      AppMethodBeat.o(1405);
      return i;
      if ("appbrandmessage".equals(TC(paramString)))
      {
        paramString = "SELECT COUNT(*) FROM " + TC(paramString) + " WHERE" + asn(paramString);
        paramString = this.fnw.a(paramString, null, 0);
        if (paramString.moveToLast()) {
          i = paramString.getInt(0);
        }
        paramString.close();
        AppMethodBeat.o(1405);
        return i;
      }
    } while (!"bottlemessage".equals(TC(paramString)));
    paramString = "SELECT COUNT(*) FROM " + TC(paramString) + " WHERE" + asn(paramString);
    paramString = this.fnw.a(paramString, null, 2);
    i = j;
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(1405);
    return i;
  }
  
  public final int TB(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(1411);
    if (paramString == null)
    {
      ab.w("MicroMsg.MsgInfoStorage", "getImgVideoMsgCount talker is null!");
      AppMethodBeat.o(1411);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      String str = ast(paramString).name;
      paramString = new StringBuilder().append(str).append("  indexed by  ").append(str).append("TalkerTypeIndex ").toString() + " WHERE talker= '" + bo.wC(paramString) + "' AND type IN (3,39,13,43,62,44,268435505)";
      paramString = this.fnw.a(paramString, null, 2);
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
      AppMethodBeat.o(1411);
      return i;
    }
  }
  
  public final String TC(String paramString)
  {
    AppMethodBeat.i(1414);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = ast(paramString).name;
      AppMethodBeat.o(1414);
      return paramString;
    }
  }
  
  public final long TD(String paramString)
  {
    AppMethodBeat.i(1420);
    Object localObject = "select createTime from message where" + asn(paramString) + "order by createTime LIMIT 1 OFFSET 0";
    ab.d("MicroMsg.MsgInfoStorage", "get first message create time: ".concat(String.valueOf(localObject)));
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.e("MicroMsg.MsgInfoStorage", "get first message create time failed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1420);
      return -1L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(1420);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1420);
    return -1L;
  }
  
  public final long TE(String paramString)
  {
    AppMethodBeat.i(1421);
    Object localObject = "select createTime from message where" + asn(paramString) + "order by createTime DESC LIMIT 1 ";
    ab.d("MicroMsg.MsgInfoStorage", "get last message create time: ".concat(String.valueOf(localObject)));
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.e("MicroMsg.MsgInfoStorage", "get last message create time failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1421);
      return -1L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(1421);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1421);
    return -1L;
  }
  
  public final long TF(String paramString)
  {
    AppMethodBeat.i(1422);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1422);
      return 0L;
    }
    Object localObject = "select msgSeq from message where" + asn(paramString) + "order by msgSeq DESC LIMIT 1 ";
    ab.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: ".concat(String.valueOf(localObject)));
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1422);
      return 0L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(1422);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1422);
    return 0L;
  }
  
  public final bi TG(String paramString)
  {
    AppMethodBeat.i(1424);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1424);
      return null;
    }
    ab.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", new Object[] { paramString, Boolean.FALSE });
    Object localObject1 = (Long)this.yOJ.get(paramString);
    if ((localObject1 != null) && (((Long)localObject1).longValue() > 0L))
    {
      ab.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", new Object[] { Long.valueOf(((Long)localObject1).longValue()) });
      localObject1 = kB(((Long)localObject1).longValue());
      if ((((dd)localObject1).field_flag & 0x1) != 0)
      {
        AppMethodBeat.o(1424);
        return localObject1;
      }
      this.yOJ.remove(paramString);
      AppMethodBeat.o(1424);
      return null;
    }
    ab.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
    localObject1 = new bi();
    long l = System.currentTimeMillis();
    Object localObject2 = "SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ";
    localObject2 = this.fnw.a((String)localObject2, null, 2);
    ab.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(Thread.currentThread().getId()) });
    if (localObject2 == null)
    {
      ab.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1424);
      return localObject1;
    }
    if (((Cursor)localObject2).moveToFirst()) {
      ((bi)localObject1).convertFrom((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    this.yOJ.f(paramString, Long.valueOf(((dd)localObject1).field_msgId));
    AppMethodBeat.o(1424);
    return localObject1;
  }
  
  public final int TH(String paramString)
  {
    AppMethodBeat.i(1437);
    String str = " SELECT COUNT(*) FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND isSend=1";
    Cursor localCursor = this.fnw.a(str, null, 2);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          break label161;
        }
        i = localCursor.getInt(0);
        localCursor.close();
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(1437);
      }
      ab.d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", new Object[] { paramString, Integer.valueOf(i), str });
      AppMethodBeat.o(1437);
      return i;
      label161:
      int i = 0;
    }
  }
  
  /* Error */
  public final List<bi> TI(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: sipush 1444
    //   5: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 495	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 496	java/util/ArrayList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 143	com/tencent/mm/storage/bj:fnw	Lcom/tencent/mm/cg/h;
    //   20: ldc 70
    //   22: aconst_null
    //   23: ldc_w 784
    //   26: iconst_2
    //   27: anewarray 60	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: invokestatic 267	com/tencent/mm/sdk/platformtools/bo:wC	(Ljava/lang/String;)Ljava/lang/String;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: invokestatic 480	java/lang/System:currentTimeMillis	()J
    //   42: ldc2_w 785
    //   45: lsub
    //   46: invokestatic 612	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: ldc_w 788
    //   55: iconst_2
    //   56: invokevirtual 791	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokeinterface 794 1 0
    //   70: ifeq +75 -> 145
    //   73: aload_2
    //   74: astore_1
    //   75: new 407	com/tencent/mm/storage/bi
    //   78: dup
    //   79: invokespecial 756	com/tencent/mm/storage/bi:<init>	()V
    //   82: astore 4
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: aload_2
    //   89: invokevirtual 766	com/tencent/mm/storage/bi:convertFrom	(Landroid/database/Cursor;)V
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: aload 4
    //   97: invokevirtual 797	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto -39 -> 62
    //   104: astore_3
    //   105: aload_2
    //   106: astore_1
    //   107: ldc 182
    //   109: aload_3
    //   110: ldc_w 799
    //   113: iconst_1
    //   114: anewarray 186	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: invokevirtual 345	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 622	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_2
    //   128: ifnull +9 -> 137
    //   131: aload_2
    //   132: invokeinterface 469 1 0
    //   137: sipush 1444
    //   140: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aconst_null
    //   144: areturn
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 469 1 0
    //   155: sipush 1444
    //   158: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_3
    //   162: areturn
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +9 -> 174
    //   168: aload_2
    //   169: invokeinterface 469 1 0
    //   174: sipush 1444
    //   177: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload_1
    //   181: athrow
    //   182: astore_3
    //   183: aload_1
    //   184: astore_2
    //   185: aload_3
    //   186: astore_1
    //   187: goto -23 -> 164
    //   190: astore_3
    //   191: aconst_null
    //   192: astore_2
    //   193: goto -88 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	bj
    //   0	196	1	paramString	String
    //   1	192	2	str	String
    //   15	80	3	localArrayList	ArrayList
    //   104	58	3	localException1	Exception
    //   182	4	3	localObject	Object
    //   190	1	3	localException2	Exception
    //   82	14	4	localbi	bi
    // Exception table:
    //   from	to	target	type
    //   64	73	104	java/lang/Exception
    //   75	84	104	java/lang/Exception
    //   86	92	104	java/lang/Exception
    //   94	101	104	java/lang/Exception
    //   8	60	163	finally
    //   64	73	182	finally
    //   75	84	182	finally
    //   86	92	182	finally
    //   94	101	182	finally
    //   107	127	182	finally
    //   8	60	190	java/lang/Exception
  }
  
  public final long TJ(String paramString)
  {
    AppMethodBeat.i(1447);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1447);
      return 0L;
    }
    paramString = asr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(1447);
      return 0L;
    }
    long l = paramString.fDU;
    AppMethodBeat.o(1447);
    return l;
  }
  
  public final Cursor TK(String paramString)
  {
    AppMethodBeat.i(1445);
    try
    {
      paramString = this.fnw.a(TC(paramString), null, asn(paramString) + " AND createTime>=? AND type IN (436207665,419430449)", new String[] { String.valueOf(System.currentTimeMillis() - 86400000L) }, null, null, "createTime ASC", 2);
      AppMethodBeat.o(1445);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.MsgInfoStorage", paramString, "getLastDayC2CMsgByTalker error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(1445);
    }
    return null;
  }
  
  public final void Th(String paramString)
  {
    AppMethodBeat.i(1327);
    ab.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.yOM), Integer.valueOf(super.lockCount()), Integer.valueOf(this.ywD.yrO), Integer.valueOf(this.yOL.size()), this.yON, Long.valueOf(bo.hl(this.yOO)) });
    if (bo.isNullOrNil(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (this.yOM)
    {
      ab.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", new Object[] { this.yON, Long.valueOf(bo.hl(this.yOO)) });
      AppMethodBeat.o(1327);
      return;
    }
    this.yON = paramString;
    this.yOO = bo.aoy();
    this.yOM = true;
    super.lock();
    this.ywD.lock();
    AppMethodBeat.o(1327);
  }
  
  public final void Ti(String paramString)
  {
    AppMethodBeat.i(1328);
    ab.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.yOM), Integer.valueOf(super.lockCount()), Integer.valueOf(this.ywD.yrO), Integer.valueOf(this.yOL.size()), this.yON, Long.valueOf(bo.hl(this.yOO)) });
    if (bo.isNullOrNil(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (!this.yOM)
    {
      ab.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", new Object[] { paramString, bo.dtY() });
      AppMethodBeat.o(1328);
      return;
    }
    if (!paramString.equals(this.yON))
    {
      ab.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", new Object[] { this.yON, Long.valueOf(bo.hl(this.yOO)), paramString });
      AppMethodBeat.o(1328);
      return;
    }
    this.yOM = false;
    this.yOO = 0L;
    this.yON = "";
    paramString = this.yOL.keySet().iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      a((h.c)this.yOL.get(str));
    }
    this.yOL.clear();
    super.unlock();
    this.ywD.unlock();
    doNotify();
    AppMethodBeat.o(1328);
  }
  
  public final void Tj(String paramString)
  {
    AppMethodBeat.i(1329);
    if (!this.yOM)
    {
      AppMethodBeat.o(1329);
      return;
    }
    h.c localc = null;
    if (this.yOL.containsKey(paramString)) {
      localc = (h.c)this.yOL.get(paramString);
    }
    if (localc == null)
    {
      ab.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", new Object[] { paramString, bo.dtY() });
      AppMethodBeat.o(1329);
      return;
    }
    if ((localc.oDP != null) && (localc.oDP.equals("insert")) && (localc.oDR > 0))
    {
      ab.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", new Object[] { paramString, Integer.valueOf(localc.oDR) });
      localc.oDR = 0;
    }
    AppMethodBeat.o(1329);
  }
  
  public final Cursor Tk(String paramString)
  {
    AppMethodBeat.i(1343);
    com.tencent.mm.cg.h localh = this.fnw;
    String str = TC(paramString);
    paramString = asn(paramString);
    paramString = localh.query(str, new String[] { "createTime", "msgId" }, paramString, null, "createTime", null, "createTime ASC");
    AppMethodBeat.o(1343);
    return paramString;
  }
  
  public final bi Tl(String paramString)
  {
    AppMethodBeat.i(1354);
    bi localbi = new bi();
    paramString = this.fnw.a(TC(paramString), null, asn(paramString), null, null, null, "msgSvrId  DESC limit 1 ", 2);
    if (paramString.moveToFirst()) {
      localbi.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1354);
    return localbi;
  }
  
  public final bi Tm(String paramString)
  {
    AppMethodBeat.i(1355);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1355);
      return null;
    }
    bi localbi = new bi();
    paramString = "select * from " + TC(paramString) + " where" + asn(paramString) + "order by createTime DESC limit 1";
    paramString = this.fnw.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbi.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1355);
    return localbi;
  }
  
  public final bi Tn(String paramString)
  {
    AppMethodBeat.i(1358);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1358);
      return null;
    }
    bi localbi = new bi();
    paramString = "select * from " + TC(paramString) + " where" + asn(paramString) + "and isSend = 0  order by createTime DESC limit 1";
    paramString = this.fnw.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbi.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1358);
    return localbi;
  }
  
  public final bi To(String paramString)
  {
    AppMethodBeat.i(1361);
    if (this.yOD == null)
    {
      ab.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(1361);
      return null;
    }
    bi localbi = new bi();
    long l1 = 0L;
    if (bo.isNullOrNil(paramString)) {}
    for (paramString = "";; paramString = paramString.replaceFirst("and", "where"))
    {
      int i = 0;
      while (i < this.yOD.size())
      {
        long l2 = l1;
        if ((((h.b)this.yOD.get(i)).oDM & 0x8) != 0)
        {
          Object localObject = "select * from " + ((h.b)this.yOD.get(i)).name + paramString + "  order by createTime DESC limit 1";
          localObject = this.fnw.a((String)localObject, null, 2);
          l2 = l1;
          if (((Cursor)localObject).moveToFirst())
          {
            long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
            l2 = l1;
            if (l1 < l3)
            {
              localbi.convertFrom((Cursor)localObject);
              l2 = l3;
            }
          }
          ((Cursor)localObject).close();
        }
        i += 1;
        l1 = l2;
      }
    }
    AppMethodBeat.o(1361);
    return localbi;
  }
  
  public final List<bi> Tp(String paramString)
  {
    bi localbi = null;
    AppMethodBeat.i(1371);
    Cursor localCursor = this.fnw.a("select * from ".concat(String.valueOf(paramString)), null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(1371);
      return null;
    }
    paramString = localbi;
    if (localCursor.moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        localbi = new bi();
        localbi.convertFrom(localCursor);
        paramString.add(localbi);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(1371);
    return paramString;
  }
  
  public final Cursor Tq(String paramString)
  {
    AppMethodBeat.i(1378);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(1378);
      return null;
    }
    Object localObject = TC(paramString);
    paramString = "select * from " + (String)localObject + " " + asq((String)localObject) + " where" + asn(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime";
    localObject = this.fnw.a(paramString, null, 0);
    ab.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(1378);
    return localObject;
  }
  
  public final void Tr(String paramString)
  {
    AppMethodBeat.i(1383);
    b(paramString, "", null);
    if (this.fnw.execSQL(paramString, "delete from ".concat(String.valueOf(paramString))))
    {
      doNotify("delete_all ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1383);
      return;
    }
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 247L, 1L, false);
    AppMethodBeat.o(1383);
  }
  
  public final int Ts(String paramString)
  {
    AppMethodBeat.i(1385);
    ab.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, com.tencent.mm.sdk.platformtools.an.dth() });
    b(TC(paramString), asn(paramString), null);
    int i = this.fnw.delete(TC(paramString), asn(paramString), null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.oDU = -1L;
      a(paramString);
    }
    AppMethodBeat.o(1385);
    return i;
  }
  
  public final int Tt(String paramString)
  {
    AppMethodBeat.i(1392);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(4));
    int i = this.fnw.update(TC(paramString), localContentValues, asn(paramString) + "AND isSend=? AND status!=? ", new String[] { "0", "4" });
    if (i != 0)
    {
      doNotify();
      a(new h.c(paramString, "update", null));
    }
    AppMethodBeat.o(1392);
    return i;
  }
  
  public final Cursor Tu(String paramString)
  {
    AppMethodBeat.i(1394);
    paramString = this.fnw.query(TC(paramString), null, asn(paramString), null, null, null, "createTime ASC ");
    AppMethodBeat.o(1394);
    return paramString;
  }
  
  public final Cursor Tv(String paramString)
  {
    AppMethodBeat.i(1398);
    paramString = this.fnw.query(TC(paramString), null, "isSend=? AND" + asn(paramString) + "AND status!=?", new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(1398);
    return paramString;
  }
  
  public final bi.c Tw(String paramString)
  {
    AppMethodBeat.i(1401);
    bi.c localc2 = (bi.c)this.yOE.get(Integer.valueOf(paramString.hashCode()));
    bi.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = bi.c.asl(paramString);
      this.yOE.f(Integer.valueOf(paramString.hashCode()), localc1);
    }
    AppMethodBeat.o(1401);
    return localc1;
  }
  
  public final bi.d Tx(String paramString)
  {
    AppMethodBeat.i(1402);
    bi.d locald2 = (bi.d)this.yOF.get(Integer.valueOf(paramString.hashCode()));
    bi.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = bi.d.asm(paramString);
      this.yOF.f(Integer.valueOf(paramString.hashCode()), locald1);
    }
    AppMethodBeat.o(1402);
    return locald1;
  }
  
  public final bi.a Ty(String paramString)
  {
    AppMethodBeat.i(1403);
    bi.a locala1 = null;
    if ((!bo.isNullOrNil(paramString)) && (this.yOG != null)) {
      locala1 = (bi.a)this.yOG.get(Integer.valueOf(paramString.hashCode()));
    }
    for (;;)
    {
      bi.a locala2 = locala1;
      if (locala1 == null)
      {
        locala1 = bi.a.asj(paramString);
        locala2 = locala1;
        if (this.yOG != null)
        {
          this.yOG.f(Integer.valueOf(bo.bf(paramString, "").hashCode()), locala1);
          locala2 = locala1;
        }
      }
      AppMethodBeat.o(1403);
      return locala2;
      ab.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", new Object[] { Boolean.valueOf(bo.isNullOrNil(paramString)) });
      ab.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
    }
  }
  
  public final bi.b Tz(String paramString)
  {
    AppMethodBeat.i(1404);
    bi.b localb2 = (bi.b)this.yOH.get(Integer.valueOf(paramString.hashCode()));
    bi.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = bi.b.ask(paramString);
      this.yOH.f(Integer.valueOf(paramString.hashCode()), localb1);
    }
    AppMethodBeat.o(1404);
    return localb1;
  }
  
  public final int Y(bi parambi)
  {
    int i = 0;
    AppMethodBeat.i(1365);
    if ((parambi == null) || (bo.isNullOrNil(parambi.field_talker)))
    {
      AppMethodBeat.o(1365);
      return 0;
    }
    parambi = "SELECT count(msgId) FROM " + TC(parambi.field_talker) + " WHERE" + asn(parambi.field_talker) + "AND isSend = 0 AND msgId >= " + parambi.field_msgId + " ORDER BY createTime DESC";
    parambi = this.fnw.a(parambi, null, 2);
    if (parambi.moveToFirst()) {
      i = parambi.getInt(0);
    }
    parambi.close();
    AppMethodBeat.o(1365);
    return i;
  }
  
  public final long Z(bi parambi)
  {
    AppMethodBeat.i(1368);
    long l = c(parambi, false);
    AppMethodBeat.o(1368);
    return l;
  }
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(1426);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = new StringBuilder("SELECT * FROM ").append(TC(paramString)).append(" WHERE").append(asn(paramString)).append("AND createTime >= ").append(paramLong2).append(" AND createTime <= ").append(paramLong1).append(" AND isSend=");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString = i + " LIMIT 1";
        ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
        paramString = this.fnw.a(paramString, null, 0);
        AppMethodBeat.o(1426);
        return paramString;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void a(long paramLong, bi parambi)
  {
    AppMethodBeat.i(1389);
    if (parambi.dxP())
    {
      String str = asp(parambi.dns);
      if (t.oz(str))
      {
        ab.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
        parambi.kj("notifymessage");
      }
    }
    at(parambi);
    if (this.fnw.update(oq(paramLong), parambi.convertTo(), "msgId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new h.c(parambi.field_talker, "update", parambi));
      AppMethodBeat.o(1389);
      return;
    }
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 244L, 1L, false);
    AppMethodBeat.o(1389);
  }
  
  public final void a(com.tencent.mm.cg.h paramh, String paramString)
  {
    AppMethodBeat.i(1330);
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
    long l = paramh.kr(Thread.currentThread().getId());
    if (i == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add lvbuffer BLOB ");
    }
    if (j == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add transContent TEXT ");
    }
    if (k == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add transBrandWording TEXT ");
    }
    if (m == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add talkerId INTEGER ");
    }
    if (n == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add bizClientMsgId TEXT ");
    }
    if (i1 == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add bizChatId INTEGER DEFAULT -1");
    }
    if (i2 == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add bizChatUserId TEXT ");
    }
    if (i3 == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add msgSeq INTEGER ");
    }
    if (i4 == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add flag INT DEFAULT 0 ");
    }
    paramh.nY(l);
    AppMethodBeat.o(1330);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(1324);
    this.ywD.remove(parama);
    AppMethodBeat.o(1324);
  }
  
  public final void a(h.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(1323);
    this.ywD.a(parama, paramLooper);
    AppMethodBeat.o(1323);
  }
  
  public final void a(h.b paramb)
  {
    AppMethodBeat.i(1335);
    synchronized (this.yOD)
    {
      this.yOD.add(paramb);
      b(paramb);
      AppMethodBeat.o(1335);
      return;
    }
  }
  
  public final void a(h.c paramc)
  {
    AppMethodBeat.i(1322);
    if (this.ywD.cy(paramc)) {
      this.ywD.doNotify();
    }
    AppMethodBeat.o(1322);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(1321);
    if (!this.yOC.contains(parame))
    {
      ab.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", new Object[] { parame });
      this.yOC.add(parame);
    }
    AppMethodBeat.o(1321);
  }
  
  public final void aa(bi parambi)
  {
    AppMethodBeat.i(1390);
    if ((parambi == null) || (parambi.field_status == 4))
    {
      AppMethodBeat.o(1390);
      return;
    }
    parambi.setStatus(4);
    String str = oq(parambi.field_msgId);
    if ((str != null) && (str.length() > 0)) {
      if (this.fnw.update(str, parambi.convertTo(), "msgId=?", new String[] { parambi.field_msgId }) != 0)
      {
        doNotify();
        a(new h.c(parambi.field_talker, "update", parambi, -1));
      }
    }
    AppMethodBeat.o(1390);
  }
  
  public final void aaL()
  {
    AppMethodBeat.i(139747);
    Cursor localCursor = this.fnw.a("select * from MsgInfo wherecontent like '%aaaabbbbbfdf%'", null, 2);
    localCursor.getCount();
    SystemClock.sleep(5000L);
    localCursor.close();
    AppMethodBeat.o(139747);
  }
  
  public final int ab(bi parambi)
  {
    int i = 0;
    AppMethodBeat.i(1393);
    if (parambi != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("content", parambi.field_content);
      localContentValues.put("status", Integer.valueOf(parambi.field_status));
      int j = this.fnw.update(oq(parambi.field_msgId), localContentValues, "msgId=?", new String[] { String.valueOf(parambi.field_msgId) });
      i = j;
      if (j != 0)
      {
        doNotify();
        a(new h.c(parambi.field_talker, "update", parambi));
        i = j;
      }
    }
    AppMethodBeat.o(1393);
    return i;
  }
  
  public final void af(String paramString, long paramLong)
  {
    AppMethodBeat.i(1331);
    h.b localb = ast(paramString);
    long l = localb.fDU;
    Random localRandom = new Random();
    this.fnw.execSQL("message", "BEGIN;");
    bi localbi = new bi(paramString);
    int i = 0;
    while (i < paramLong)
    {
      localbi.fQ(System.currentTimeMillis());
      localbi.setType(1);
      localbi.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bo.dtX());
      localbi.setMsgId(l);
      localbi.setStatus(localRandom.nextInt(4));
      localbi.hL(localRandom.nextInt(1));
      l += 1L;
      localb.fDU += 1L;
      localbi.fP(System.currentTimeMillis() + bo.dtX());
      this.fnw.execSQL("message", "INSERT INTO " + TC(localbi.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + localbi.field_msgId + "," + localbi.field_msgSvrId + "," + localbi.getType() + "," + localbi.field_status + "," + localbi.field_createTime + ",'" + localbi.field_talker + "','" + localbi.field_content + "'," + aso(paramString) + ");");
      if (i % 10000 == 0)
      {
        this.fnw.execSQL("message", "COMMIT;");
        this.fnw.execSQL("message", "BEGIN;");
      }
      i += 1;
    }
    this.fnw.execSQL("message", "COMMIT;");
    this.jGp.arI(paramString);
    localbi.setMsgId(1L + l);
    Z(localbi);
    AppMethodBeat.o(1331);
  }
  
  public final bi ag(String paramString, long paramLong)
  {
    AppMethodBeat.i(1340);
    bi localbi = new bi();
    paramString = this.fnw.a(TC(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbi.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1340);
    return localbi;
  }
  
  public final bi ah(String paramString, long paramLong)
  {
    AppMethodBeat.i(1341);
    bi localbi = new bi();
    paramString = this.fnw.a(TC(paramString), null, asn(paramString) + " AND msgSeq=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbi.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1341);
    return localbi;
  }
  
  public final bi ai(String paramString, long paramLong)
  {
    AppMethodBeat.i(1342);
    bi localbi = new bi();
    paramString = this.fnw.a(TC(paramString), null, "createTime=? AND" + asn(paramString), new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbi.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1342);
    return localbi;
  }
  
  public final List<bi> aj(String paramString, long paramLong)
  {
    AppMethodBeat.i(1344);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + TC(paramString) + " Where " + asn(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11";
    paramString = this.fnw.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bi localbi = new bi();
      localbi.convertFrom(paramString);
      localArrayList.add(localbi);
    }
    paramString.close();
    AppMethodBeat.o(1344);
    return localArrayList;
  }
  
  public final List<bi> ak(String paramString, long paramLong)
  {
    AppMethodBeat.i(1345);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + TC(paramString) + " Where " + asn(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11;";
    paramString = this.fnw.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bi localbi = new bi();
      localbi.convertFrom(paramString);
      localArrayList.add(localbi);
    }
    paramString.close();
    AppMethodBeat.o(1345);
    return localArrayList;
  }
  
  public final bi al(String paramString, long paramLong)
  {
    AppMethodBeat.i(1346);
    bi localbi = new bi();
    paramString = "Select * From " + TC(paramString) + " Where " + asn(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
    paramString = this.fnw.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbi.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1346);
    return localbi;
  }
  
  public final bi am(String paramString, long paramLong)
  {
    AppMethodBeat.i(1347);
    bi localbi = new bi();
    paramString = "Select * From " + TC(paramString) + " Where " + asn(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
    paramString = this.fnw.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbi.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1347);
    return localbi;
  }
  
  public final List<bi> am(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1364);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + TC(paramString) + " WHERE type = 49 ORDER BY createTime DESC LIMIT " + paramInt1 + " , " + paramInt2;
    ab.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.fnw.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bi localbi = new bi();
      localbi.convertFrom(paramString);
      if (localbi.bCn()) {
        localArrayList.add(localbi);
      }
    }
    paramString.close();
    AppMethodBeat.o(1364);
    return localArrayList;
  }
  
  public final Cursor an(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1374);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(1374);
      return null;
    }
    String str = TC(paramString);
    paramString = "select * from ( select * from " + str + " where" + asn(paramString) + " AND type IN (3,39,13,43,62,44,268435505)  order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = this.fnw.a(paramString, null, 2);
    AppMethodBeat.o(1374);
    return paramString;
  }
  
  public final boolean an(String paramString, long paramLong)
  {
    AppMethodBeat.i(1352);
    if (ai(paramString, paramLong).field_msgId > 0L)
    {
      AppMethodBeat.o(1352);
      return true;
    }
    AppMethodBeat.o(1352);
    return false;
  }
  
  public final bi ao(String paramString, long paramLong)
  {
    AppMethodBeat.i(1356);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1356);
      return null;
    }
    bi localbi = new bi();
    paramString = "select * from " + TC(paramString) + " where" + asn(paramString) + "AND msgSeq<" + paramLong + " order by msgSeq DESC limit 1";
    Cursor localCursor = this.fnw.a(paramString, null, 2);
    if (localCursor.moveToFirst()) {
      localbi.convertFrom(localCursor);
    }
    localCursor.close();
    ab.d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(1356);
    return localbi;
  }
  
  public final long ap(String paramString, long paramLong)
  {
    AppMethodBeat.i(1372);
    paramString = "select createTime from " + TC(paramString) + " where msgId = " + paramLong;
    paramLong = 0L;
    paramString = this.fnw.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      paramLong = paramString.getLong(0);
    }
    paramString.close();
    AppMethodBeat.o(1372);
    return paramLong;
  }
  
  public final int aq(String paramString, long paramLong)
  {
    AppMethodBeat.i(1384);
    bi localbi = ag(paramString, paramLong);
    this.yOK.m((int)(bo.aox() / 86400L), localbi.field_msgSvrId, localbi.field_createTime / 1000L);
    int i = this.fnw.delete(TC(paramString), "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      doNotify();
      a(new h.c(paramString, "delete", null, 1, (byte)0));
    }
    for (;;)
    {
      AppMethodBeat.o(1384);
      return i;
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 246L, 1L, false);
    }
  }
  
  public final int ar(String paramString, long paramLong)
  {
    AppMethodBeat.i(1386);
    String str = asn(paramString) + " and createTime <= " + paramLong;
    b(TC(paramString), str, null);
    int i = this.fnw.delete(TC(paramString), str, null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.oDU = -1L;
      a(paramString);
    }
    AppMethodBeat.o(1386);
    return i;
  }
  
  public final int as(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(1412);
    bi localbi = kB(paramLong);
    if (localbi.field_msgId == 0L)
    {
      ab.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(1412);
      return 0;
    }
    String str = TC(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " " + asq(str) + " WHERE " + asn(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + localbi.field_createTime;
    paramString = this.fnw.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(1412);
    return i;
  }
  
  public final String at(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(1413);
    Object localObject1 = kB(paramLong);
    if (((dd)localObject1).field_msgId == 0L)
    {
      ab.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(1413);
      return null;
    }
    Object localObject2 = TC(paramString);
    paramString = "EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + (String)localObject2 + " " + asq((String)localObject2) + " WHERE" + asn(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + ((dd)localObject1).field_createTime;
    localObject2 = this.fnw.a(paramString, null, 0);
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
    AppMethodBeat.o(1413);
    return localObject1;
  }
  
  public final bi au(String paramString, long paramLong)
  {
    AppMethodBeat.i(1423);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1423);
      return null;
    }
    Object localObject = "select * from message where" + asn(paramString) + " and msgSeq < " + paramLong + " order by msgSeq DESC LIMIT 1 ";
    ab.i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: ".concat(String.valueOf(localObject)));
    localObject = this.fnw.a((String)localObject, null, 0);
    if (localObject == null)
    {
      ab.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1423);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new bi();
      paramString.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(1423);
      return paramString;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1423);
    return null;
  }
  
  public final bi av(String paramString, long paramLong)
  {
    AppMethodBeat.i(1439);
    ab.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(1) });
    bi localbi = new bi();
    paramString = "SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime < " + paramLong + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1";
    ab.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.fnw.a(paramString, null, 0);
    if (paramString == null)
    {
      ab.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(1439);
      return localbi;
    }
    if (paramString.moveToLast())
    {
      localbi.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(1439);
      return localbi;
    }
    paramString.close();
    ab.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(1439);
    return localbi;
  }
  
  public final Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(1429);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(TC(paramString)).append(" WHERE").append(asn(paramString));
      if (paramLong2 > 0L)
      {
        str = " AND createTime >= ".concat(String.valueOf(paramLong2));
        localStringBuilder = localStringBuilder.append(str);
        if (paramLong1 <= 0L) {
          break label179;
        }
      }
      label179:
      for (String str = " AND createTime <= ".concat(String.valueOf(paramLong1));; str = "")
      {
        str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
        ab.d("MicroMsg.MsgInfoStorage", "getCursorAfterStratTimeBeforeEndTimeLimit talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
        paramString = this.fnw.a(str, null, 0);
        AppMethodBeat.o(1429);
        return paramString;
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
    AppMethodBeat.i(1391);
    if (bo.nullAsNil(parambi.field_talker).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("no talker set when update by svrid", bool);
      if (parambi.dxP())
      {
        String str = asp(parambi.dns);
        if (t.oz(str))
        {
          ab.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
          parambi.kj("notifymessage");
        }
      }
      at(parambi);
      if (this.fnw.update(TC(parambi.field_talker), parambi.convertTo(), "msgSvrId=?", new String[] { String.valueOf(paramLong) }) == 0) {
        break;
      }
      doNotify();
      a(new h.c(parambi.field_talker, "update", parambi));
      AppMethodBeat.o(1391);
      return;
    }
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 243L, 1L, false);
    AppMethodBeat.o(1391);
  }
  
  public final void b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(1381);
    long l = bo.aox();
    Object localObject = "SELECT msgSvrId,createTime FROM " + paramString1 + " WHERE createTime > " + (l - 172800L) * 1000L;
    paramString1 = (String)localObject;
    if (!bo.isNullOrNil(paramString2)) {
      paramString1 = (String)localObject + " AND " + paramString2;
    }
    paramString2 = new ArrayList();
    localObject = new ArrayList();
    paramString1 = this.fnw.a(paramString1, paramArrayOfString, 2);
    if (paramString1.moveToFirst())
    {
      do
      {
        int i = paramString1.getInt(0);
        l = paramString1.getLong(1) / 1000L;
        paramString2.add(Integer.valueOf(i));
        ((List)localObject).add(Long.valueOf(l));
      } while (paramString1.moveToNext());
      this.yOK.t(paramString2, (List)localObject);
    }
    paramString1.close();
    AppMethodBeat.o(1381);
  }
  
  public final com.tencent.mm.cg.h bPX()
  {
    return this.fnw;
  }
  
  public final void bPY()
  {
    AppMethodBeat.i(1333);
    g.RM();
    g.RL().Ru().set(348167, Integer.valueOf(1));
    AppMethodBeat.o(1333);
  }
  
  public final void bPZ()
  {
    AppMethodBeat.i(1336);
    int i = 0;
    while (i < this.yOD.size())
    {
      b((h.b)this.yOD.get(i));
      i += 1;
    }
    AppMethodBeat.o(1336);
  }
  
  public final void bQa()
  {
    AppMethodBeat.i(1338);
    if (!this.yOB)
    {
      AppMethodBeat.o(1338);
      return;
    }
    Object localObject = "select count(*) from " + "message" + " where talkerId ISNULL ";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject != null) {
      if (!((Cursor)localObject).moveToFirst()) {
        break label288;
      }
    }
    label288:
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      if (i > 0)
      {
        ab.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", new Object[] { "message" });
        long l = System.currentTimeMillis();
        localObject = "update " + "message" + " set talkerId=(select rowid from rcontact where rcontact.username = " + "message" + ".talker)";
        boolean bool = this.fnw.execSQL("message", (String)localObject);
        ab.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
        if ((bool) && (this.yOB))
        {
          this.fnw.execSQL("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
          this.fnw.execSQL("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
          this.fnw.execSQL("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
          this.fnw.execSQL("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
          this.fnw.execSQL("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
          ab.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
        }
      }
      AppMethodBeat.o(1338);
      return;
    }
  }
  
  public final ArrayList<bi> bQb()
  {
    AppMethodBeat.i(1350);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.fnw.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[] { String.valueOf(System.currentTimeMillis() - 172800000L), "5", "1" }, null, null, "createTime ASC", 2);
    label149:
    while (localCursor.moveToNext())
    {
      bi localbi = new bi();
      localbi.convertFrom(localCursor);
      if (!localbi.dyf()) {}
      for (int i = 1;; i = 0)
      {
        if (((i & 0x1) == 0) || (ad.arc(localbi.field_talker)) || (ad.are(localbi.field_talker)) || (ad.nM(localbi.field_talker))) {
          break label149;
        }
        localArrayList.add(localbi);
        break;
      }
    }
    localCursor.close();
    AppMethodBeat.o(1350);
    return localArrayList;
  }
  
  public final List<bi> bQc()
  {
    AppMethodBeat.i(1362);
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    Object localObject1;
    int i;
    if (this.yOD != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject1 = new ArrayList();
      i = 0;
    }
    Object localObject2;
    for (;;)
    {
      if (i >= this.yOD.size()) {
        break label207;
      }
      localObject2 = this.fnw.a(((h.b)this.yOD.get(i)).name, null, "status=1 and isSend=1", null, null, null, "createTime DESC ", 2);
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label193;
        }
        bi localbi = new bi();
        localbi.convertFrom((Cursor)localObject2);
        if ((localbi.isText()) || (localbi.dxR()) || (localbi.bCp()) || (localbi.dxZ()))
        {
          if (bf.aaM() - localbi.field_createTime > 86400000L)
          {
            ((List)localObject1).add(localbi);
            continue;
            bool = false;
            break;
          }
          localArrayList.add(localbi);
        }
      }
      label193:
      ((Cursor)localObject2).close();
      i += 1;
    }
    label207:
    if (((List)localObject1).size() > 0)
    {
      long l = this.fnw.kr(-1L);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bi)((Iterator)localObject1).next();
        ab.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", new Object[] { Long.valueOf(((dd)localObject2).field_msgId), Long.valueOf(((dd)localObject2).field_createTime), ((dd)localObject2).field_talker, bo.aqg(((dd)localObject2).field_content) });
        ((bi)localObject2).setStatus(5);
        a(((dd)localObject2).field_msgId, (bi)localObject2);
      }
      this.fnw.nY(l);
    }
    AppMethodBeat.o(1362);
    return localArrayList;
  }
  
  public final Cursor bQd()
  {
    AppMethodBeat.i(1400);
    Cursor localCursor = this.fnw.query("message", new String[] { "talker", "count(*) as unReadCount" }, "isSend=? AND status!=?", new String[] { "0", "4" }, "talker", null, null);
    AppMethodBeat.o(1400);
    return localCursor;
  }
  
  public final String bQe()
  {
    return "type IN (3,39,13,43,62,44,268435505)";
  }
  
  public final String bQf()
  {
    return "type IN (3,39,13,43,62,44,49,268435505)";
  }
  
  /* Error */
  public final List<bi> bQg()
  {
    // Byte code:
    //   0: sipush 1446
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 495	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 496	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 143	com/tencent/mm/storage/bj:fnw	Lcom/tencent/mm/cg/h;
    //   18: ldc 70
    //   20: aconst_null
    //   21: ldc_w 1496
    //   24: iconst_1
    //   25: anewarray 60	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: invokestatic 480	java/lang/System:currentTimeMillis	()J
    //   33: ldc2_w 785
    //   36: lsub
    //   37: invokestatic 612	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: ldc_w 788
    //   46: iconst_2
    //   47: invokevirtual 791	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 794 1 0
    //   59: ifeq +75 -> 134
    //   62: aload_2
    //   63: astore_1
    //   64: new 407	com/tencent/mm/storage/bi
    //   67: dup
    //   68: invokespecial 756	com/tencent/mm/storage/bi:<init>	()V
    //   71: astore 4
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: aload_2
    //   78: invokevirtual 766	com/tencent/mm/storage/bi:convertFrom	(Landroid/database/Cursor;)V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload 4
    //   86: invokevirtual 797	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -39 -> 51
    //   93: astore_3
    //   94: aload_2
    //   95: astore_1
    //   96: ldc 182
    //   98: aload_3
    //   99: ldc_w 799
    //   102: iconst_1
    //   103: anewarray 186	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_3
    //   109: invokevirtual 345	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 622	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_2
    //   117: ifnull +9 -> 126
    //   120: aload_2
    //   121: invokeinterface 469 1 0
    //   126: sipush 1446
    //   129: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aconst_null
    //   133: areturn
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 469 1 0
    //   144: sipush 1446
    //   147: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_3
    //   151: areturn
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +9 -> 165
    //   159: aload_1
    //   160: invokeinterface 469 1 0
    //   165: sipush 1446
    //   168: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_2
    //   172: athrow
    //   173: astore_2
    //   174: goto -19 -> 155
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_2
    //   180: goto -86 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	bj
    //   52	108	1	localCursor1	Cursor
    //   50	89	2	localCursor2	Cursor
    //   152	20	2	localObject1	Object
    //   173	1	2	localObject2	Object
    //   179	1	2	localObject3	Object
    //   13	71	3	localArrayList	ArrayList
    //   93	58	3	localException1	Exception
    //   177	1	3	localException2	Exception
    //   71	14	4	localbi	bi
    // Exception table:
    //   from	to	target	type
    //   53	62	93	java/lang/Exception
    //   64	73	93	java/lang/Exception
    //   75	81	93	java/lang/Exception
    //   83	90	93	java/lang/Exception
    //   6	51	152	finally
    //   53	62	173	finally
    //   64	73	173	finally
    //   75	81	173	finally
    //   83	90	173	finally
    //   96	116	173	finally
    //   6	51	177	java/lang/Exception
  }
  
  public final long c(bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(1369);
    if ((parambi == null) || (bo.isNullOrNil(parambi.field_talker)))
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 250L, 1L, false);
      if (parambi == null) {}
      for (localObject1 = "-1";; localObject1 = parambi.field_talker)
      {
        ab.e("MicroMsg.MsgInfoStorage", "Error insert message msg:%s talker:%s", new Object[] { parambi, localObject1 });
        AppMethodBeat.o(1369);
        return -1L;
      }
    }
    ab.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", new Object[] { Boolean.valueOf(this.yOM), Long.valueOf(parambi.field_msgSeq) });
    Object localObject1 = null;
    Object localObject2 = bf.pA(parambi.dns);
    if (localObject2 != null) {
      localObject1 = ((bf.b)localObject2).fmD;
    }
    if (t.oz((String)localObject1))
    {
      ab.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { localObject1 });
      if (parambi.getType() == 436207665)
      {
        ab.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
        AppMethodBeat.o(1369);
        return -1L;
      }
      parambi.kj("notifymessage");
    }
    localObject1 = ast(parambi.field_talker);
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 249L, 1L, false);
      ab.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", new Object[] { parambi.field_talker });
      AppMethodBeat.o(1369);
      return -1L;
    }
    ((h.b)localObject1).ac(parambi);
    Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[] { Long.valueOf(parambi.field_msgId), localObject1, oq(parambi.field_msgId) }), ((h.b)localObject1).name.equals(oq(parambi.field_msgId)));
    if (parambi.field_msgSvrId != 0L) {
      parambi.HG();
    }
    Iterator localIterator = this.yOC.iterator();
    while (localIterator.hasNext()) {
      if (!((e)localIterator.next()).a(parambi, (bf.b)localObject2))
      {
        ab.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", new Object[] { parambi.field_talker, parambi.dns });
        AppMethodBeat.o(1369);
        return -1L;
      }
    }
    at(parambi);
    if (((h.b)localObject1).name.equals("message")) {
      parambi.hU((int)aso(parambi.field_talker));
    }
    localObject2 = parambi.convertTo();
    if (paramBoolean) {}
    for (long l = this.fnw.dzU().insertOrThrow(((h.b)localObject1).name, "msgId", (ContentValues)localObject2);; l = this.fnw.a(((h.b)localObject1).name, "msgId", (ContentValues)localObject2))
    {
      ab.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", new Object[] { Long.valueOf(l), parambi.field_talker, Long.valueOf(parambi.field_msgId), Integer.valueOf(parambi.getType()), Integer.valueOf(parambi.field_status), Long.valueOf(parambi.field_msgSvrId), Long.valueOf(parambi.field_msgSeq), Integer.valueOf(parambi.field_flag), Long.valueOf(parambi.field_createTime), Integer.valueOf(parambi.field_isSend), this.yON, Long.valueOf(bo.hl(this.yOO)) });
      if (l != -1L) {
        break;
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 248L, 1L, false);
      ab.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", new Object[] { Long.valueOf(parambi.field_msgSvrId), Long.valueOf(l) });
      AppMethodBeat.o(1369);
      return -1L;
    }
    if ((this.yOM) && (bo.hl(this.yOO) > 2000L) && (parambi.field_isSend == 1) && (parambi.field_status == 1))
    {
      ab.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", new Object[] { this.yON, Long.valueOf(bo.hl(this.yOO)) });
      Ti(this.yON);
    }
    if (this.yOM)
    {
      localObject1 = null;
      if (e.yww != null) {
        localObject1 = e.yww.N(parambi);
      }
      if (!bo.isNullOrNil((String)localObject1)) {
        break label976;
      }
    }
    label976:
    for (localObject2 = parambi.field_talker;; localObject2 = localObject1)
    {
      localObject1 = null;
      if (this.yOL.containsKey(localObject2)) {
        localObject1 = (h.c)this.yOL.get(localObject2);
      }
      if (localObject1 == null)
      {
        localObject1 = new h.c(parambi.field_talker, "insert", parambi);
        if (h.c.ad(parambi)) {
          ((h.c)localObject1).oDR += 1;
        }
        ((h.c)localObject1).oDS += 1;
        this.yOL.put(localObject2, localObject1);
      }
      for (;;)
      {
        l = parambi.field_msgId;
        AppMethodBeat.o(1369);
        return l;
        ((h.c)localObject1).oDQ.add(parambi);
        break;
        localObject1 = new h.c(parambi.field_talker, "insert", parambi);
        if (h.c.ad(parambi)) {
          ((h.c)localObject1).oDR = 1;
        }
        ((h.c)localObject1).oDS = 1;
        doNotify();
        a((h.c)localObject1);
      }
    }
  }
  
  public final Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(1431);
    if (paramLong2 == 0L)
    {
      paramString = "SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime > " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.fnw.a(paramString, null, 0);
      AppMethodBeat.o(1431);
      return paramString;
    }
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.fnw.a(paramString, null, 0);
      AppMethodBeat.o(1431);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final List<bi> cC(String paramString, int paramInt)
  {
    AppMethodBeat.i(1359);
    ArrayList localArrayList = new ArrayList();
    if (this.yOD != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND status = 3 AND type <> 10000 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.fnw.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bi localbi = new bi();
        localbi.convertFrom(paramString);
        localArrayList.add(localbi);
      }
    }
    paramString.close();
    AppMethodBeat.o(1359);
    return localArrayList;
  }
  
  public final List<bi> cD(String paramString, int paramInt)
  {
    AppMethodBeat.i(1363);
    ArrayList localArrayList = new ArrayList();
    if (this.yOD != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.fnw.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bi localbi = new bi();
        localbi.convertFrom(paramString);
        if (localbi.isText()) {
          localArrayList.add(localbi);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(1363);
    return localArrayList;
  }
  
  public final Cursor cE(String paramString, int paramInt)
  {
    AppMethodBeat.i(1379);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(1379);
      return null;
    }
    String str = TC(paramString);
    paramString = "select * from " + str + " where" + asn(paramString) + " AND type = 49  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.fnw.a(paramString, null, 0);
    AppMethodBeat.o(1379);
    return paramString;
  }
  
  public final Cursor cF(String paramString, int paramInt)
  {
    AppMethodBeat.i(1380);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(1380);
      return null;
    }
    Object localObject = TC(paramString);
    paramString = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend,imgPath from ").append((String)localObject).append(" where").append(asn(paramString)).append(" AND ");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" (type = 49");
    ((StringBuilder)localObject).append(" or type = 587202609");
    ((StringBuilder)localObject).append(" or type = 553648177) ");
    paramString = ((StringBuilder)localObject).toString() + "  order by createTime DESC limit 100 OFFSET " + paramInt;
    paramString = this.fnw.a(paramString, null, 0);
    AppMethodBeat.o(1380);
    return paramString;
  }
  
  public final Cursor cG(String paramString, int paramInt)
  {
    AppMethodBeat.i(1376);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(1376);
      return null;
    }
    String str = TC(paramString);
    paramString = "select * from ( select * from " + str + " where" + asn(paramString) + " AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime DESC limit 200 OFFSET " + paramInt + ") order by createTime ASC ";
    paramString = this.fnw.a(paramString, null, 2);
    AppMethodBeat.o(1376);
    return paramString;
  }
  
  public final int cH(String paramString, int paramInt)
  {
    AppMethodBeat.i(1387);
    ab.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", new Object[] { paramString, Integer.valueOf(paramInt), com.tencent.mm.sdk.platformtools.an.dth() });
    bi localbi = ag(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbi.field_talker));
    b(TC(paramString), "createTime<=? AND" + asn(paramString), new String[] { localbi.field_createTime });
    paramInt = this.fnw.delete(TC(paramString), "createTime<=? AND" + asn(paramString), new String[] { localbi.field_createTime });
    if (paramInt != 0)
    {
      doNotify();
      a(new h.c(paramString, "delete", null, paramInt, (byte)0));
    }
    AppMethodBeat.o(1387);
    return paramInt;
  }
  
  public final Cursor cI(String paramString, int paramInt)
  {
    AppMethodBeat.i(1388);
    bi localbi = ag(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbi.field_talker));
    paramString = this.fnw.query(TC(paramString), null, "createTime<=? AND" + asn(paramString), new String[] { localbi.field_createTime }, null, null, null);
    AppMethodBeat.o(1388);
    return paramString;
  }
  
  public final Cursor cJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(1399);
    paramString = this.fnw.query(TC(paramString), null, "isSend=? AND" + asn(paramString) + "AND status!=?  order by msgId DESC limit " + paramInt, new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(1399);
    return paramString;
  }
  
  public final int cK(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(1409);
    paramString = "SELECT COUNT(*) FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND type = " + paramInt;
    paramString = this.fnw.a(paramString, null, 2);
    paramInt = i;
    if (paramString.moveToFirst()) {
      paramInt = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(1409);
    return paramInt;
  }
  
  public final Cursor cL(String paramString, int paramInt)
  {
    AppMethodBeat.i(1435);
    String str = " SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + paramInt;
    ab.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    paramString = this.fnw.a(str, null, 0);
    AppMethodBeat.o(1435);
    return paramString;
  }
  
  public final bi[] cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(1441);
    if ((paramString == null) || (paramString.length() == 0) || (paramInt <= 0))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + paramString + ", limit = " + paramInt);
      AppMethodBeat.o(1441);
      return null;
    }
    Object localObject = "select * from " + TC(paramString) + " where" + asn(paramString) + "order by createTime DESC limit " + paramInt;
    localObject = this.fnw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        bi localbi = new bi();
        localbi.convertFrom((Cursor)localObject);
        localArrayList.add(localbi);
      } while (((Cursor)localObject).moveToNext());
      ((Cursor)localObject).close();
      ab.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + paramString + ", limit = " + paramInt + ", count = " + localArrayList.size());
      Collections.reverse(localArrayList);
      paramString = (bi[])localArrayList.toArray(new bi[localArrayList.size()]);
      AppMethodBeat.o(1441);
      return paramString;
    }
    ab.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
    ((Cursor)localObject).close();
    AppMethodBeat.o(1441);
    return null;
  }
  
  public final Cursor cN(String paramString, int paramInt)
  {
    AppMethodBeat.i(1449);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(1449);
      return null;
    }
    String str = TC(paramString);
    paramString = "select * from " + str + " where" + asn(paramString) + " AND type IN (436207665,419430449)  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.fnw.a(paramString, null, 0);
    AppMethodBeat.o(1449);
    return paramString;
  }
  
  public final Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(1428);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM (SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime DESC LIMIT " + paramInt + " ) ORDER BY createTime ASC";
      ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.fnw.a(paramString, null, 0);
      AppMethodBeat.o(1428);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int f(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(1353);
    String str = "SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime ASC LIMIT -1 OFFSET " + paramInt;
    Cursor localCursor = this.fnw.a(str, null, 0);
    paramInt = localCursor.getCount();
    localCursor.close();
    ab.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + paramString + " time:" + paramLong + " count " + paramInt + " [" + str + "]");
    AppMethodBeat.o(1353);
    return paramInt;
  }
  
  public final bi fi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1357);
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", new Object[] { paramString1 });
      AppMethodBeat.o(1357);
      return null;
    }
    bi localbi = new bi();
    paramString2 = "select * from " + TC(paramString1) + " where" + asn(paramString1) + paramString2 + " order by createTime DESC limit 1";
    paramString2 = this.fnw.a(paramString2, null, 2);
    if (paramString2.moveToFirst()) {
      localbi.convertFrom(paramString2);
    }
    paramString2.close();
    ab.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", new Object[] { paramString1, Long.valueOf(localbi.field_msgId) });
    AppMethodBeat.o(1357);
    return localbi;
  }
  
  public final Cursor fj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1396);
    paramString1 = "SELECT * FROM " + TC(paramString1) + " WHERE" + asn(paramString1) + "AND content LIKE '%" + paramString2 + "%' AND type = 1";
    paramString1 = paramString1 + " ORDER BY createTime DESC";
    paramString1 = this.fnw.a(paramString1, null, 0);
    AppMethodBeat.o(1396);
    return paramString1;
  }
  
  public final int fk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1436);
    String str = " SELECT COUNT(*) FROM " + TC(paramString1) + " WHERE" + asn(paramString1) + "AND content LIKE '" + paramString2 + "%' ";
    Cursor localCursor = this.fnw.a(str, null, 2);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          break label181;
        }
        i = localCursor.getInt(0);
        localCursor.close();
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(1436);
      }
      ab.d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(i), str });
      AppMethodBeat.o(1436);
      return i;
      label181:
      int i = 0;
    }
  }
  
  public final LinkedList<bi> fl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1442);
    paramString1 = this.fnw.a("message", null, "talker=? AND bizClientMsgId=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
    if ((paramString1 == null) || (!paramString1.moveToFirst()))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
      AppMethodBeat.o(1442);
      return null;
    }
    paramString2 = new LinkedList();
    do
    {
      bi localbi = new bi();
      localbi.convertFrom(paramString1);
      paramString2.add(localbi);
    } while (paramString1.moveToNext());
    paramString1.close();
    AppMethodBeat.o(1442);
    return paramString2;
  }
  
  public final long g(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(1438);
    ab.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ab.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(1438);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime DESC  LIMIT " + paramInt;
    ab.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.fnw.a(paramString, null, 0);
    if (paramString == null)
    {
      ab.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(1438);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      ab.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(1438);
      return paramLong;
    }
    paramString.close();
    ab.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(1438);
    return paramLong;
  }
  
  public final List<bi> g(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(1373);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(1373);
      return null;
    }
    paramLong = ap(paramString, paramLong);
    if (paramLong == 0L)
    {
      ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(1373);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (paramString = "select * from " + TC(paramString) + " where" + asn(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime > " + paramLong + "  order by createTime ASC limit 10";; paramString = "select * from " + TC(paramString) + " where" + asn(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + paramLong + "  order by createTime DESC limit 10")
    {
      paramString = this.fnw.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bi localbi = new bi();
        localbi.convertFrom(paramString);
        localArrayList.add(localbi);
      }
    }
    if (!paramBoolean) {
      Collections.reverse(localArrayList);
    }
    paramString.close();
    AppMethodBeat.o(1373);
    return localArrayList;
  }
  
  public final long h(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(1440);
    ab.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ab.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(1440);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC  LIMIT " + paramInt;
    ab.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.fnw.a(paramString, null, 0);
    if (paramString == null)
    {
      ab.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
      AppMethodBeat.o(1440);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      ab.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(1440);
      return paramLong;
    }
    paramString.close();
    ab.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(1440);
    return paramLong;
  }
  
  public final Cursor i(String paramString, long paramLong, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(1448);
    try
    {
      paramString = "select * from " + paramString + " where " + "type IN (3,39,13,43,62,44,49,268435505,34)" + " AND msgId >= " + paramLong + "  order by msgId ASC  limit " + paramInt;
      paramString = this.fnw.a(paramString, null, 0);
      AppMethodBeat.o(1448);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  public final Cursor j(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(1395);
    paramString = "SELECT * FROM " + TC(paramString) + " WHERE" + asn(paramString) + " AND createTime <= " + paramLong + " order by createTime ASC limit " + paramInt;
    paramString = this.fnw.a(paramString, null, 0);
    AppMethodBeat.o(1395);
    return paramString;
  }
  
  public final Cursor k(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(1397);
    StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(TC(paramString)).append(" WHERE").append(asn(paramString));
    if (paramLong > 0L) {}
    for (String str = " AND createTime > ".concat(String.valueOf(paramLong));; str = "")
    {
      str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
      ab.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
      paramString = this.fnw.a(str, null, 0);
      AppMethodBeat.o(1397);
      return paramString;
    }
  }
  
  public final bi kB(long paramLong)
  {
    AppMethodBeat.i(1339);
    bi localbi = new bi();
    Cursor localCursor = this.fnw.a(oq(paramLong), null, "msgId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localbi.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(1339);
    return localbi;
  }
  
  public final int kC(long paramLong)
  {
    AppMethodBeat.i(1370);
    bi localbi = kB(paramLong);
    Object localObject = localbi.field_talker;
    this.yOK.m((int)(bo.aox() / 86400L), localbi.field_msgSvrId, localbi.field_createTime / 1000L);
    int i = this.fnw.delete(oq(paramLong), "msgId=?", new String[] { String.valueOf(paramLong) });
    ((ak)g.E(ak.class)).gu(paramLong);
    if (i != 0)
    {
      doNotify("delete_id ".concat(String.valueOf(paramLong)));
      localObject = new h.c((String)localObject, "delete", localbi, 1, (byte)0);
      ((h.c)localObject).oDU = paramLong;
      ((h.c)localObject).jUy = localbi.field_bizChatId;
      a((h.c)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(1370);
      return i;
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 245L, 1L, false);
    }
  }
  
  public final boolean kD(long paramLong)
  {
    AppMethodBeat.i(1382);
    boolean bool = this.yOK.oo(paramLong);
    AppMethodBeat.o(1382);
    return bool;
  }
  
  public final boolean kE(long paramLong)
  {
    AppMethodBeat.i(1418);
    int i = 0;
    while (i < this.yOD.size())
    {
      if (((h.b)this.yOD.get(i)).kG(paramLong))
      {
        AppMethodBeat.o(1418);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(1418);
    return false;
  }
  
  public final void kF(long paramLong)
  {
    AppMethodBeat.i(1443);
    this.yOK.b(0, paramLong, 0L, false);
    AppMethodBeat.o(1443);
  }
  
  public final void lock()
  {
    AppMethodBeat.i(1325);
    Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
    AppMethodBeat.o(1325);
  }
  
  public final int pw(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(1407);
    paramString = "SELECT COUNT(*) FROM " + TC(paramString) + " " + dyC() + " WHERE" + asn(paramString);
    paramString = this.fnw.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(1407);
    return i;
  }
  
  public final boolean px(String paramString)
  {
    AppMethodBeat.i(1406);
    boolean bool = "message".equals(TC(paramString));
    AppMethodBeat.o(1406);
    return bool;
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(1326);
    Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    AppMethodBeat.o(1326);
  }
  
  public final Cursor w(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(1375);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(1375);
      return null;
    }
    String str = TC(paramString);
    paramString = "select * from " + str + " where" + asn(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.fnw.a(paramString, null, 2);
    AppMethodBeat.o(1375);
    return paramString;
  }
  
  public final Cursor x(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(1377);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(1377);
      return null;
    }
    String str = TC(paramString);
    paramString = "select * from " + str + " where" + asn(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.fnw.a(paramString, null, 2);
    AppMethodBeat.o(1377);
    return paramString;
  }
  
  public final int y(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(1410);
    paramString = "SELECT COUNT(*) FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND type = 50 AND createTime >= " + paramLong1 + " AND createTime <= " + paramLong2 + " LIMIT 1";
    paramString = this.fnw.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(1410);
    return i;
  }
  
  public final bi yU(int paramInt)
  {
    AppMethodBeat.i(1360);
    if (this.yOD == null)
    {
      ab.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(1360);
      return null;
    }
    bi localbi = new bi();
    long l1 = 0L;
    int i = 0;
    while (i < this.yOD.size())
    {
      long l2 = l1;
      if ((((h.b)this.yOD.get(i)).oDM & paramInt) != 0)
      {
        Object localObject = "select * from " + ((h.b)this.yOD.get(i)).name + "  order by createTime DESC limit 1";
        localObject = this.fnw.a((String)localObject, null, 2);
        l2 = l1;
        if (((Cursor)localObject).moveToFirst())
        {
          long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
          l2 = l1;
          if (l1 < l3)
          {
            localbi.convertFrom((Cursor)localObject);
            l2 = l3;
          }
        }
        ((Cursor)localObject).close();
      }
      i += 1;
      l1 = l2;
    }
    AppMethodBeat.o(1360);
    return localbi;
  }
  
  public final int z(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(1425);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      ab.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      paramString = "SELECT COUNT(msgId) FROM " + TC(paramString) + " WHERE" + asn(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      ab.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf(paramString)));
      paramString = this.fnw.a(paramString, null, 2);
      if (paramString == null)
      {
        ab.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
        AppMethodBeat.o(1425);
        return 0;
      }
      if (paramString.moveToFirst())
      {
        int i = paramString.getInt(0);
        ab.d("MicroMsg.MsgInfoStorage", "result msg count %d", new Object[] { Integer.valueOf(i) });
        paramString.close();
        AppMethodBeat.o(1425);
        return i;
      }
      paramString.close();
      AppMethodBeat.o(1425);
      return 0;
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