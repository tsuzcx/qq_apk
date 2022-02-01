package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storagebase.f.a;
import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.database.SQLiteDatabase;
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

public final class bv
  extends k
  implements i
{
  public static final String[] SQL_CREATE;
  private final long IKD;
  private boolean IMH;
  private final List<e> IMI;
  private List<i.b> IMJ;
  private final com.tencent.mm.b.f<Integer, bu.c> IMK;
  private final com.tencent.mm.b.f<Integer, bu.d> IML;
  private final com.tencent.mm.b.f<Integer, bu.a> IMM;
  private final com.tencent.mm.b.f<Integer, bu.b> IMN;
  private final com.tencent.mm.b.f<Integer, Object> IMO;
  private final com.tencent.mm.b.f<String, Long> IMP;
  private aw IMQ;
  private final Map<String, i.c> IMR;
  private boolean IMS;
  private String IMT;
  private long IMU;
  private final com.tencent.mm.sdk.e.l<i.a, i.c> Iou;
  private final h hHS;
  private bp nAe;
  private bq nAg;
  
  static
  {
    AppMethodBeat.i(117320);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag INT, solitaireFoldInfo BLOB, historyId TEXT) " };
    AppMethodBeat.o(117320);
  }
  
  public bv(h paramh, bp parambp, bq parambq)
  {
    AppMethodBeat.i(117202);
    this.IMH = false;
    this.IMI = new CopyOnWriteArrayList();
    this.IMK = new com.tencent.mm.memory.a.c(100);
    this.IML = new com.tencent.mm.memory.a.c(100);
    this.IMM = new com.tencent.mm.memory.a.c(100);
    this.IMN = new com.tencent.mm.memory.a.c(100);
    this.IMO = new com.tencent.mm.memory.a.c(100);
    this.IMP = new com.tencent.mm.memory.a.c(100);
    this.IMQ = new aw();
    this.Iou = new com.tencent.mm.sdk.e.l()
    {
      public final void hk(List<i.c> paramAnonymousList)
      {
        AppMethodBeat.i(117187);
        if ((!isLocked()) && (bv.a(bv.this) != null))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            i.c localc = (i.c)paramAnonymousList.next();
            if (localc != null) {
              bv.a(bv.this).b(bv.this, localc);
            }
          }
        }
        AppMethodBeat.o(117187);
      }
    };
    this.IMR = new HashMap();
    this.IMS = false;
    this.IMT = "";
    this.IMU = 0L;
    this.IKD = 86400L;
    this.hHS = paramh;
    this.nAe = parambp;
    this.nAg = parambq;
    if (u.aBc() == 0)
    {
      ad.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", new Object[] { Integer.valueOf(this.hHS.delete("message", "msgId> ? ", new String[] { "80000000" })) });
      u.aBb();
    }
    d(paramh, "message");
    fsx();
    if (this.IMJ == null) {
      this.IMJ = new LinkedList();
    }
    this.IMJ.clear();
    a(new i.b(1, "message", i.b.a(1L, 1000000L, 10000000L, 90000000L)));
    AppMethodBeat.o(117202);
  }
  
  private String DH(long paramLong)
  {
    AppMethodBeat.i(117288);
    if ((paramLong == 0L) || (paramLong == -1L))
    {
      AppMethodBeat.o(117288);
      return null;
    }
    bu.DG(paramLong);
    int i = 0;
    while (i < this.IMJ.size())
    {
      if (((i.b)this.IMJ.get(i)).yd(paramLong))
      {
        String str = ((i.b)this.IMJ.get(i)).name;
        AppMethodBeat.o(117288);
        return str;
      }
      i += 1;
    }
    Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[] { Long.valueOf(paramLong) }), false);
    AppMethodBeat.o(117288);
    return null;
  }
  
  private static void aO(bu parambu)
  {
    AppMethodBeat.i(117236);
    if ((parambu == null) || (!parambu.cTc()))
    {
      AppMethodBeat.o(117236);
      return;
    }
    try
    {
      String str = parambu.field_content;
      int i = str.indexOf("<msg>");
      Object localObject = str;
      if (i > 0)
      {
        localObject = str;
        if (i < str.length()) {
          localObject = str.substring(i).trim();
        }
      }
      localObject = bw.M((String)localObject, "msg");
      if ((localObject != null) && (((Map)localObject).size() > 0)) {
        parambu.tP(com.tencent.mm.sdk.platformtools.bj.bI((Map)localObject));
      }
      AppMethodBeat.o(117236);
      return;
    }
    catch (Exception parambu)
    {
      ad.e("MicroMsg.MsgInfoStorage", parambu.getMessage());
      AppMethodBeat.o(117236);
    }
  }
  
  private static String aSt(String paramString)
  {
    AppMethodBeat.i(177115);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azS().apK(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(177115);
      return paramString;
    }
    AppMethodBeat.o(177115);
    return "";
  }
  
  private String aUf(String paramString)
  {
    AppMethodBeat.i(117216);
    String str = aqo(paramString);
    if ((this.IMH) && (str.equals("message")))
    {
      paramString = " talkerId=" + aUg(paramString) + " ";
      AppMethodBeat.o(117216);
      return paramString;
    }
    paramString = " talker= '" + bt.aQN(paramString) + "' ";
    AppMethodBeat.o(117216);
    return paramString;
  }
  
  private long aUg(String paramString)
  {
    AppMethodBeat.i(117217);
    long l2 = this.nAe.aTm(paramString);
    if (l2 < 0L) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = l2;
      if (bool)
      {
        l1 = l2;
        if (!w.zy(paramString))
        {
          l1 = l2;
          if (!w.zz(paramString))
          {
            am localam = new am(paramString);
            localam.setType(2);
            this.nAe.ag(localam);
            l1 = this.nAe.aTm(paramString);
          }
        }
      }
      if (!b.fjP()) {
        ad.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", new Object[] { paramString, Long.valueOf(l1), Boolean.valueOf(bool), "" });
      }
      AppMethodBeat.o(117217);
      return l1;
    }
  }
  
  private static String aUh(String paramString)
  {
    AppMethodBeat.i(117235);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117235);
      return null;
    }
    try
    {
      paramString = bw.M(paramString, "msgsource");
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(117235);
        return null;
      }
      paramString = (String)paramString.get(".msgsource.bizmsg.msgcluster");
      AppMethodBeat.o(117235);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.MsgInfoStorage", "exception:%s", new Object[] { bt.n(paramString) });
      ad.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(117235);
    }
    return null;
  }
  
  private String aUi(String paramString)
  {
    AppMethodBeat.i(117277);
    if ((paramString == null) || (!paramString.equals("message")))
    {
      AppMethodBeat.o(117277);
      return "";
    }
    if (this.IMH)
    {
      AppMethodBeat.o(117277);
      return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
    }
    AppMethodBeat.o(117277);
    return "INDEXED BY messageCreateTaklerTypeTimeIndex";
  }
  
  private i.b aUj(String paramString)
  {
    AppMethodBeat.i(117284);
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
      if (i >= this.IMJ.size()) {
        break label98;
      }
      if (paramString.equals(((i.b)this.IMJ.get(i)).name))
      {
        paramString = (i.b)this.IMJ.get(i);
        AppMethodBeat.o(117284);
        return paramString;
        bool = false;
        break;
      }
      i += 1;
    }
    label98:
    Assert.assertTrue("no table match", false);
    AppMethodBeat.o(117284);
    return null;
  }
  
  private String aUk(String paramString)
  {
    AppMethodBeat.i(117285);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Iterator localIterator = this.IMI.iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = ((e)localIterator.next()).aiu(paramString);
      } while (bt.isNullOrNil(str));
      AppMethodBeat.o(117285);
      return str;
    }
    AppMethodBeat.o(117285);
    return "message";
  }
  
  private i.b aUl(String paramString)
  {
    AppMethodBeat.i(117286);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = aUj(aUk(paramString));
      AppMethodBeat.o(117286);
      return paramString;
    }
  }
  
  private void b(i.b paramb)
  {
    AppMethodBeat.i(117205);
    Cursor localCursor = this.hHS.a("select max(msgid) from " + paramb.name, null, 2);
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      ad.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d tableName: %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramb.hZF), paramb.name });
      if (i >= paramb.hZF) {
        paramb.JO(i);
      }
    }
    localCursor.close();
    ad.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + paramb.hZF);
    AppMethodBeat.o(117205);
  }
  
  private void fsx()
  {
    AppMethodBeat.i(117200);
    long l1 = System.currentTimeMillis();
    long l2 = this.hHS.xO(Thread.currentThread().getId());
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
    if (!this.IMH)
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
      this.hHS.execSQL("message", (String)localArrayList.get(i));
      i += 1;
    }
    ad.i("MicroMsg.MsgInfoStorage", "build new index last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    this.hHS.sJ(l2);
    ad.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(117200);
  }
  
  public final Cursor A(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117244);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117244);
      return null;
    }
    String str = aqo(paramString);
    paramString = "select * from " + str + " where" + aUf(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.hHS.a(paramString, null, 2);
    AppMethodBeat.o(117244);
    return paramString;
  }
  
  public final Cursor B(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117246);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117246);
      return null;
    }
    String str = aqo(paramString);
    paramString = "select * from " + str + " where" + aUf(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.hHS.a(paramString, null, 2);
    AppMethodBeat.o(117246);
    return paramString;
  }
  
  public final int Bm(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117276);
    paramString = "SELECT COUNT(*) FROM " + aqo(paramString) + " WHERE" + aSt(paramString) + aUf(paramString);
    paramString = this.hHS.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117276);
    return i;
  }
  
  public final boolean Bn(String paramString)
  {
    AppMethodBeat.i(117275);
    boolean bool = "message".equals(aqo(paramString));
    AppMethodBeat.o(117275);
    return bool;
  }
  
  public final int C(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(117279);
    paramString = "SELECT COUNT(*) FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND type = 50 AND createTime >= " + paramLong1 + " AND createTime <= " + paramLong2 + " LIMIT 1";
    paramString = this.hHS.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117279);
    return i;
  }
  
  public final int D(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117294);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      ad.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      paramString = "SELECT COUNT(msgId) FROM " + aqo(paramString) + " WHERE" + aSt(paramString) + aUf(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      ad.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf(paramString)));
      paramString = this.hHS.a(paramString, null, 2);
      if (paramString == null)
      {
        ad.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
        AppMethodBeat.o(117294);
        return 0;
      }
      if (paramString.moveToFirst())
      {
        int i = paramString.getInt(0);
        ad.d("MicroMsg.MsgInfoStorage", "result msg count %d", new Object[] { Integer.valueOf(i) });
        paramString.close();
        AppMethodBeat.o(117294);
        return i;
      }
      paramString.close();
      AppMethodBeat.o(117294);
      return 0;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final Cursor E(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117297);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime ASC ";
      ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hHS.a(paramString, null, 0);
      AppMethodBeat.o(117297);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int F(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117300);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ( SELECT * FROM ").append(aqo(paramString)).append(" WHERE").append(aUf(paramString));
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
        ad.d("MicroMsg.MsgInfoStorage", "getCountAfterStratTimeBeforeEndTime talk:%s [%s]", new Object[] { paramString, str });
        paramString = this.hHS.a(str, null, 2);
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
            ad.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
            paramString.close();
            i = j;
          }
        }
        finally
        {
          paramString.close();
          AppMethodBeat.o(117300);
        }
        AppMethodBeat.o(117300);
        return i;
        str = "";
        break;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int G(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117302);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT COUNT(*) FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1;
      paramString = this.hHS.a(paramString, null, 2);
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
          ad.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
          paramString.close();
          i = 0;
          continue;
        }
        finally
        {
          paramString.close();
          AppMethodBeat.o(117302);
        }
        AppMethodBeat.o(117302);
        return i;
        label158:
        int i = 0;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final Cursor H(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117303);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hHS.a(paramString, null, 0);
      AppMethodBeat.o(117303);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final Cursor I(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(117264);
    paramString = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + " AND createTime <= " + paramLong + " order by createTime ASC limit " + paramInt;
    paramString = this.hHS.a(paramString, null, 0);
    AppMethodBeat.o(117264);
    return paramString;
  }
  
  /* Error */
  public final List<bu> I(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 702
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 6
    //   9: new 533	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 534	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: getfield 145	com/tencent/mm/storage/bv:hHS	Lcom/tencent/mm/storagebase/h;
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 353	com/tencent/mm/storage/bv:aqo	(Ljava/lang/String;)Ljava/lang/String;
    //   27: aconst_null
    //   28: new 63	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 703	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 605	com/tencent/mm/storage/bv:aUf	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 705
    //   46: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: iconst_2
    //   53: anewarray 61	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: lload_2
    //   59: invokestatic 676	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: lload 4
    //   67: invokestatic 676	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   70: aastore
    //   71: aconst_null
    //   72: aconst_null
    //   73: ldc_w 707
    //   76: iconst_2
    //   77: invokevirtual 710	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   80: astore_1
    //   81: aload_1
    //   82: astore 6
    //   84: aload 6
    //   86: astore_1
    //   87: aload 6
    //   89: invokeinterface 713 1 0
    //   94: ifeq +86 -> 180
    //   97: aload 6
    //   99: astore_1
    //   100: new 227	com/tencent/mm/storage/bu
    //   103: dup
    //   104: invokespecial 714	com/tencent/mm/storage/bu:<init>	()V
    //   107: astore 8
    //   109: aload 6
    //   111: astore_1
    //   112: aload 8
    //   114: aload 6
    //   116: invokevirtual 718	com/tencent/mm/storage/bu:convertFrom	(Landroid/database/Cursor;)V
    //   119: aload 6
    //   121: astore_1
    //   122: aload 7
    //   124: aload 8
    //   126: invokevirtual 721	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: goto -46 -> 84
    //   133: astore 7
    //   135: aload 6
    //   137: astore_1
    //   138: ldc 157
    //   140: aload 7
    //   142: ldc_w 723
    //   145: iconst_1
    //   146: anewarray 161	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload 7
    //   153: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 684	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aload 6
    //   162: ifnull +10 -> 172
    //   165: aload 6
    //   167: invokeinterface 506 1 0
    //   172: ldc_w 702
    //   175: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: aload 6
    //   182: ifnull +10 -> 192
    //   185: aload 6
    //   187: invokeinterface 506 1 0
    //   192: ldc_w 702
    //   195: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 7
    //   200: areturn
    //   201: astore_1
    //   202: aload 6
    //   204: ifnull +10 -> 214
    //   207: aload 6
    //   209: invokeinterface 506 1 0
    //   214: ldc_w 702
    //   217: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_1
    //   221: athrow
    //   222: astore 7
    //   224: aload_1
    //   225: astore 6
    //   227: aload 7
    //   229: astore_1
    //   230: goto -28 -> 202
    //   233: astore 7
    //   235: aconst_null
    //   236: astore 6
    //   238: goto -103 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	bv
    //   0	241	1	paramString	String
    //   0	241	2	paramLong1	long
    //   0	241	4	paramLong2	long
    //   7	230	6	str	String
    //   16	107	7	localArrayList	ArrayList
    //   133	66	7	localException1	Exception
    //   222	6	7	localObject	Object
    //   233	1	7	localException2	Exception
    //   107	18	8	localbu	bu
    // Exception table:
    //   from	to	target	type
    //   87	97	133	java/lang/Exception
    //   100	109	133	java/lang/Exception
    //   112	119	133	java/lang/Exception
    //   122	130	133	java/lang/Exception
    //   9	81	201	finally
    //   87	97	222	finally
    //   100	109	222	finally
    //   112	119	222	finally
    //   122	130	222	finally
    //   138	160	222	finally
    //   9	81	233	java/lang/Exception
  }
  
  public final Cursor J(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(117266);
    StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(aqo(paramString)).append(" WHERE").append(aUf(paramString));
    if (paramLong > 0L) {}
    for (String str = " AND createTime > ".concat(String.valueOf(paramLong));; str = "")
    {
      str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
      ad.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
      paramString = this.hHS.a(str, null, 0);
      AppMethodBeat.o(117266);
      return paramString;
    }
  }
  
  public final bu JN(int paramInt)
  {
    AppMethodBeat.i(117229);
    if (this.IMJ == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117229);
      return null;
    }
    bu localbu = new bu();
    long l1 = 0L;
    int i = 0;
    while (i < this.IMJ.size())
    {
      long l2 = l1;
      if ((((i.b)this.IMJ.get(i)).vKb & paramInt) != 0)
      {
        Object localObject = "select * from " + ((i.b)this.IMJ.get(i)).name + "  order by createTime DESC limit 1";
        localObject = this.hHS.a((String)localObject, null, 2);
        l2 = l1;
        if (((Cursor)localObject).moveToFirst())
        {
          long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
          l2 = l1;
          if (l1 < l3)
          {
            localbu.convertFrom((Cursor)localObject);
            l2 = l3;
          }
        }
        ((Cursor)localObject).close();
      }
      i += 1;
      l1 = l2;
    }
    AppMethodBeat.o(117229);
    return localbu;
  }
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(117296);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = new StringBuilder("SELECT * FROM ").append(aqo(paramString)).append(" WHERE").append(aUf(paramString)).append("AND createTime >= ").append(paramLong2).append(" AND createTime <= ").append(paramLong1).append(" AND isSend=");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString = i + " LIMIT 1";
        ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
        paramString = this.hHS.a(paramString, null, 0);
        AppMethodBeat.o(117296);
        return paramString;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void a(long paramLong, bu parambu)
  {
    AppMethodBeat.i(117258);
    if (parambu.frC())
    {
      String str = aUh(parambu.eLs);
      if (w.Aj(str))
      {
        ad.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
        parambu.tN("notifymessage");
      }
    }
    aO(parambu);
    if (this.hHS.update(DH(paramLong), parambu.convertTo(), "msgId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new i.c(parambu.field_talker, "update", parambu));
      AppMethodBeat.o(117258);
      return;
    }
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 244L, 1L, false);
    AppMethodBeat.o(117258);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(117192);
    this.Iou.remove(parama);
    AppMethodBeat.o(117192);
  }
  
  public final void a(i.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(117191);
    this.Iou.a(parama, paramLooper);
    AppMethodBeat.o(117191);
  }
  
  public final void a(i.b paramb)
  {
    AppMethodBeat.i(117203);
    synchronized (this.IMJ)
    {
      this.IMJ.add(paramb);
      b(paramb);
      AppMethodBeat.o(117203);
      return;
    }
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(117190);
    if (this.Iou.dV(paramc)) {
      this.Iou.doNotify();
    }
    AppMethodBeat.o(117190);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(117189);
    if (!this.IMI.contains(parame))
    {
      ad.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", new Object[] { parame });
      this.IMI.add(parame);
    }
    AppMethodBeat.o(117189);
  }
  
  public final void aCa()
  {
    AppMethodBeat.i(117227);
    Cursor localCursor = this.hHS.a("select * from MsgInfo wherecontent like '%aaaabbbbbfdf%'", null, 2);
    localCursor.getCount();
    SystemClock.sleep(5000L);
    localCursor.close();
    AppMethodBeat.o(117227);
  }
  
  public final void aH(String paramString, long paramLong)
  {
    AppMethodBeat.i(117199);
    i.b localb = aUl(paramString);
    long l = localb.hZF;
    Random localRandom = new Random();
    this.hHS.execSQL("message", "BEGIN;");
    bu localbu = new bu(paramString);
    int i = 0;
    while (i < paramLong)
    {
      localbu.qA(System.currentTimeMillis());
      localbu.setType(1);
      localbu.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bt.flR());
      localbu.setMsgId(l);
      localbu.setStatus(localRandom.nextInt(4));
      localbu.kr(localRandom.nextInt(1));
      l += 1L;
      localb.hZF += 1L;
      localbu.qz(System.currentTimeMillis() + bt.flR());
      this.hHS.execSQL("message", "INSERT INTO " + aqo(localbu.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + localbu.field_msgId + "," + localbu.field_msgSvrId + "," + localbu.getType() + "," + localbu.field_status + "," + localbu.field_createTime + ",'" + localbu.field_talker + "','" + localbu.field_content + "'," + aUg(paramString) + ");");
      if (i % 10000 == 0)
      {
        this.hHS.execSQL("message", "COMMIT;");
        this.hHS.execSQL("message", "BEGIN;");
      }
      i += 1;
    }
    this.hHS.execSQL("message", "COMMIT;");
    this.nAg.aTA(paramString);
    localbu.setMsgId(1L + l);
    c(localbu, false);
    AppMethodBeat.o(117199);
  }
  
  public final bu aI(String paramString, long paramLong)
  {
    AppMethodBeat.i(117208);
    bu localbu = new bu();
    paramString = this.hHS.a(aqo(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117208);
    return localbu;
  }
  
  public final bu aJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(117209);
    bu localbu = new bu();
    paramString = this.hHS.a(aqo(paramString), null, aUf(paramString) + " AND msgSeq=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117209);
    return localbu;
  }
  
  public final bu aK(String paramString, long paramLong)
  {
    AppMethodBeat.i(117210);
    bu localbu = new bu();
    paramString = this.hHS.a(aqo(paramString), null, "createTime=? AND" + aUf(paramString), new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117210);
    return localbu;
  }
  
  public final bu aL(String paramString, long paramLong)
  {
    AppMethodBeat.i(117214);
    bu localbu = new bu();
    paramString = "Select * From " + aqo(paramString) + " Where " + aUf(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
    paramString = this.hHS.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117214);
    return localbu;
  }
  
  public final bu aM(String paramString, long paramLong)
  {
    AppMethodBeat.i(117215);
    bu localbu = new bu();
    paramString = "Select * From " + aqo(paramString) + " Where " + aUf(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
    paramString = this.hHS.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117215);
    return localbu;
  }
  
  public final boolean aN(String paramString, long paramLong)
  {
    AppMethodBeat.i(117220);
    if (aK(paramString, paramLong).field_msgId > 0L)
    {
      AppMethodBeat.o(117220);
      return true;
    }
    AppMethodBeat.o(117220);
    return false;
  }
  
  public final bu aO(String paramString, long paramLong)
  {
    AppMethodBeat.i(117224);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117224);
      return null;
    }
    bu localbu = new bu();
    paramString = "select * from " + aqo(paramString) + " where" + aUf(paramString) + "AND msgSeq<" + paramLong + " order by msgSeq DESC limit 1";
    Cursor localCursor = this.hHS.a(paramString, null, 2);
    if (localCursor.moveToFirst()) {
      localbu.convertFrom(localCursor);
    }
    localCursor.close();
    ad.d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117224);
    return localbu;
  }
  
  public final Cursor aP(String paramString, long paramLong)
  {
    AppMethodBeat.i(177113);
    paramString = this.hHS.ftT().rawQueryWithFactory(null, "SELECT * FROM " + paramString + " WHERE createTime < " + paramLong, null, paramString);
    AppMethodBeat.o(177113);
    return paramString;
  }
  
  public final long aQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(117241);
    paramString = "select createTime from " + aqo(paramString) + " where msgId = " + paramLong;
    paramLong = 0L;
    paramString = this.hHS.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      paramLong = paramString.getLong(0);
    }
    paramString.close();
    AppMethodBeat.o(117241);
    return paramLong;
  }
  
  /* Error */
  public final int aR(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 1009
    //   6: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 135
    //   13: aconst_null
    //   14: invokevirtual 1012	com/tencent/mm/storage/bv:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 145	com/tencent/mm/storage/bv:hHS	Lcom/tencent/mm/storagebase/h;
    //   21: invokevirtual 987	com/tencent/mm/storagebase/h:ftT	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   24: new 63	java/lang/StringBuilder
    //   27: dup
    //   28: ldc_w 1014
    //   31: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 1016
    //   41: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 1020	com/tencent/wcdb/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   50: astore 6
    //   52: aload 6
    //   54: iconst_1
    //   55: lload_2
    //   56: invokevirtual 1026	com/tencent/wcdb/database/SQLiteStatement:bindLong	(IJ)V
    //   59: aload 6
    //   61: invokevirtual 1029	com/tencent/wcdb/database/SQLiteStatement:executeUpdateDelete	()I
    //   64: istore 4
    //   66: iload 4
    //   68: ifle +17 -> 85
    //   71: aload_0
    //   72: ldc_w 1031
    //   75: aload_1
    //   76: invokestatic 651	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokevirtual 654	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 1033	com/tencent/mm/storage/bv:doNotify	(Ljava/lang/String;)V
    //   85: aload 6
    //   87: ifnull +8 -> 95
    //   90: aload 6
    //   92: invokevirtual 1034	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   95: ldc_w 1009
    //   98: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload 4
    //   103: ireturn
    //   104: astore 5
    //   106: ldc_w 1009
    //   109: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload 5
    //   114: athrow
    //   115: astore_1
    //   116: aload 6
    //   118: ifnull +13 -> 131
    //   121: aload 5
    //   123: ifnull +51 -> 174
    //   126: aload 6
    //   128: invokevirtual 1034	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   131: ldc_w 1009
    //   134: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: getstatic 814	com/tencent/mm/plugin/report/e:ygI	Lcom/tencent/mm/plugin/report/e;
    //   143: ldc2_w 815
    //   146: ldc2_w 1035
    //   149: lconst_1
    //   150: iconst_0
    //   151: invokevirtual 822	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   154: ldc_w 1009
    //   157: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: iconst_m1
    //   161: ireturn
    //   162: astore 6
    //   164: aload 5
    //   166: aload 6
    //   168: invokevirtual 1040	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   171: goto -40 -> 131
    //   174: aload 6
    //   176: invokevirtual 1034	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   179: goto -48 -> 131
    //   182: astore_1
    //   183: goto -67 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	bv
    //   0	186	1	paramString	String
    //   0	186	2	paramLong	long
    //   64	38	4	i	int
    //   1	1	5	localObject	Object
    //   104	61	5	localThrowable1	java.lang.Throwable
    //   50	77	6	localSQLiteStatement	com.tencent.wcdb.database.SQLiteStatement
    //   162	13	6	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   52	66	104	java/lang/Throwable
    //   71	85	104	java/lang/Throwable
    //   106	115	115	finally
    //   17	52	139	java/lang/RuntimeException
    //   90	95	139	java/lang/RuntimeException
    //   126	131	139	java/lang/RuntimeException
    //   131	139	139	java/lang/RuntimeException
    //   164	171	139	java/lang/RuntimeException
    //   174	179	139	java/lang/RuntimeException
    //   126	131	162	java/lang/Throwable
    //   52	66	182	finally
    //   71	85	182	finally
  }
  
  public final int aS(String paramString, long paramLong)
  {
    AppMethodBeat.i(117253);
    bu localbu = aI(paramString, paramLong);
    this.IMQ.n((int)(bt.aQJ() / 86400L), localbu.field_msgSvrId, localbu.field_createTime / 1000L);
    int i = this.hHS.delete(aqo(paramString), "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      doNotify();
      a(new i.c(paramString, "delete", null, 1, (byte)0));
    }
    for (;;)
    {
      AppMethodBeat.o(117253);
      return i;
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 246L, 1L, false);
    }
  }
  
  public final int aT(String paramString, long paramLong)
  {
    AppMethodBeat.i(117255);
    String str = aUf(paramString) + " and createTime <= " + paramLong;
    c(aqo(paramString), str, null);
    int i = this.hHS.delete(aqo(paramString), str, null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.vKh = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117255);
    return i;
  }
  
  public final int aU(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(117281);
    bu localbu = xY(paramLong);
    if (localbu.field_msgId == 0L)
    {
      ad.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117281);
      return 0;
    }
    String str = aqo(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " " + aUi(str) + " WHERE " + aSt(paramString) + aUf(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + localbu.field_createTime;
    paramString = this.hHS.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117281);
    return i;
  }
  
  public final String aV(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(117282);
    Object localObject1 = xY(paramLong);
    if (((ei)localObject1).field_msgId == 0L)
    {
      ad.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117282);
      return null;
    }
    Object localObject2 = aqo(paramString);
    paramString = "EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + (String)localObject2 + " " + aUi((String)localObject2) + " WHERE" + aSt(paramString) + aUf(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + ((ei)localObject1).field_createTime;
    localObject2 = this.hHS.a(paramString, null, 0);
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
    AppMethodBeat.o(117282);
    return localObject1;
  }
  
  public final bu aW(String paramString, long paramLong)
  {
    AppMethodBeat.i(117292);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117292);
      return null;
    }
    Object localObject = "select * from message where" + aUf(paramString) + " and msgSeq < " + paramLong + " order by msgSeq DESC LIMIT 1 ";
    ad.i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: ".concat(String.valueOf(localObject)));
    localObject = this.hHS.a((String)localObject, null, 0);
    if (localObject == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117292);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new bu();
      paramString.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(117292);
      return paramString;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117292);
    return null;
  }
  
  public final bu aX(String paramString, long paramLong)
  {
    AppMethodBeat.i(117309);
    ad.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(1) });
    bu localbu = new bu();
    paramString = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND createTime < " + paramLong + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1";
    ad.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hHS.a(paramString, null, 0);
    if (paramString == null)
    {
      ad.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(117309);
      return localbu;
    }
    if (paramString.moveToLast())
    {
      localbu.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(117309);
      return localbu;
    }
    paramString.close();
    ad.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117309);
    return localbu;
  }
  
  public final Cursor ab(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117304);
    String str = " SELECT * FROM " + aqo(paramString1) + " WHERE" + aSt(paramString1) + aUf(paramString1) + "AND content LIKE '" + paramString2 + "%' ORDER BY createTime DESC LIMIT " + paramInt;
    ad.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), str });
    paramString1 = this.hHS.a(str, null, 0);
    AppMethodBeat.o(117304);
    return paramString1;
  }
  
  public final void ak(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(117219);
    long l1 = this.hHS.xO(-1L);
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        long l2 = ((Long)paramArrayList.next()).longValue();
        bu localbu = xY(l2);
        localbu.jY(localbu.eLr | 0x20);
        ad.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
        a(l2, localbu);
      }
      this.hHS.sJ(l1);
    }
    finally
    {
      this.hHS.sJ(l1);
      AppMethodBeat.o(117219);
    }
    AppMethodBeat.o(117219);
  }
  
  public final List<bu> ap(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117233);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + aqo(paramString) + " WHERE type & 65535 = 49" + " ORDER BY createTime DESC LIMIT " + paramInt1 + " , " + paramInt2;
    ad.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.hHS.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bu localbu = new bu();
      localbu.convertFrom(paramString);
      if (localbu.cTc()) {
        localArrayList.add(localbu);
      }
    }
    paramString.close();
    AppMethodBeat.o(117233);
    return localArrayList;
  }
  
  public final void apS(String paramString)
  {
    AppMethodBeat.i(117195);
    ad.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.IMS), Integer.valueOf(super.lockCount()), Integer.valueOf(this.Iou.IhE), Integer.valueOf(this.IMR.size()), this.IMT, Long.valueOf(bt.Df(this.IMU)) });
    if (bt.isNullOrNil(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (this.IMS)
    {
      ad.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", new Object[] { this.IMT, Long.valueOf(bt.Df(this.IMU)) });
      AppMethodBeat.o(117195);
      return;
    }
    this.IMT = paramString;
    this.IMU = bt.flT();
    this.IMS = true;
    super.lock();
    this.Iou.lock();
    AppMethodBeat.o(117195);
  }
  
  public final void apT(String arg1)
  {
    AppMethodBeat.i(117196);
    ad.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { ???, Boolean.valueOf(this.IMS), Integer.valueOf(super.lockCount()), Integer.valueOf(this.Iou.IhE), Integer.valueOf(this.IMR.size()), this.IMT, Long.valueOf(bt.Df(this.IMU)) });
    if (bt.isNullOrNil(???)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (!this.IMS)
    {
      ad.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", new Object[] { ???, bt.flS() });
      AppMethodBeat.o(117196);
      return;
    }
    if (!???.equals(this.IMT))
    {
      ad.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", new Object[] { this.IMT, Long.valueOf(bt.Df(this.IMU)), ??? });
      AppMethodBeat.o(117196);
      return;
    }
    this.IMS = false;
    this.IMU = 0L;
    this.IMT = "";
    synchronized (this.IMR)
    {
      Iterator localIterator = this.IMR.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a((i.c)this.IMR.get(str));
      }
    }
    this.IMR.clear();
    super.unlock();
    this.Iou.unlock();
    doNotify();
    AppMethodBeat.o(117196);
  }
  
  public final void apU(String paramString)
  {
    AppMethodBeat.i(117197);
    if (!this.IMS)
    {
      AppMethodBeat.o(117197);
      return;
    }
    i.c localc = null;
    synchronized (this.IMR)
    {
      if (this.IMR.containsKey(paramString)) {
        localc = (i.c)this.IMR.get(paramString);
      }
      if (localc == null)
      {
        ad.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", new Object[] { paramString, bt.flS() });
        AppMethodBeat.o(117197);
        return;
      }
    }
    if ((localc.vKe != null) && (localc.vKe.equals("insert")) && (localc.scY > 0))
    {
      ad.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", new Object[] { paramString, Integer.valueOf(localc.scY) });
      localc.scY = 0;
    }
    AppMethodBeat.o(117197);
  }
  
  public final Cursor apV(String paramString)
  {
    AppMethodBeat.i(117211);
    h localh = this.hHS;
    String str = aqo(paramString);
    paramString = aSt(paramString) + aUf(paramString);
    paramString = localh.query(str, new String[] { "createTime", "msgId" }, paramString, null, "createTime", null, "createTime ASC");
    AppMethodBeat.o(117211);
    return paramString;
  }
  
  public final bu apW(String paramString)
  {
    AppMethodBeat.i(117222);
    bu localbu = new bu();
    paramString = this.hHS.a(aqo(paramString), null, aUf(paramString), null, null, null, "msgSvrId  DESC limit 1 ", 2);
    if (paramString.moveToFirst()) {
      localbu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117222);
    return localbu;
  }
  
  public final bu apX(String paramString)
  {
    AppMethodBeat.i(117223);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117223);
      return null;
    }
    bu localbu = new bu();
    paramString = "select * from " + aqo(paramString) + " where" + aSt(paramString) + aUf(paramString) + "order by createTime DESC limit 1";
    paramString = this.hHS.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117223);
    return localbu;
  }
  
  public final bu apY(String paramString)
  {
    AppMethodBeat.i(217618);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(217618);
      return null;
    }
    bu localbu = new bu();
    paramString = "select * from " + aqo(paramString) + " where" + aSt(paramString) + aUf(paramString) + "order by createTime ASC limit 1";
    paramString = this.hHS.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(217618);
    return localbu;
  }
  
  public final bu apZ(String paramString)
  {
    AppMethodBeat.i(117226);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117226);
      return null;
    }
    bu localbu = new bu();
    paramString = "select * from " + aqo(paramString) + " where" + aUf(paramString) + "and isSend = 0  order by createTime DESC limit 1";
    paramString = this.hHS.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117226);
    return localbu;
  }
  
  public final Cursor aq(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117243);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117243);
      return null;
    }
    String str = aqo(paramString);
    paramString = "select * from ( select * from " + str + " where" + aSt(paramString) + aUf(paramString) + " AND type IN (3,39,13,43,62,44,268435505,486539313)  order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = this.hHS.a(paramString, null, 2);
    AppMethodBeat.o(117243);
    return paramString;
  }
  
  public final bu aqa(String paramString)
  {
    AppMethodBeat.i(117230);
    if (this.IMJ == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117230);
      return null;
    }
    bu localbu = new bu();
    long l1 = 0L;
    if (bt.isNullOrNil(paramString)) {}
    for (paramString = "";; paramString = paramString.replaceFirst("and", "where"))
    {
      int i = 0;
      while (i < this.IMJ.size())
      {
        long l2 = l1;
        if ((((i.b)this.IMJ.get(i)).vKb & 0x8) != 0)
        {
          Object localObject = "select * from " + ((i.b)this.IMJ.get(i)).name + paramString + "  order by createTime DESC limit 1";
          localObject = this.hHS.a((String)localObject, null, 2);
          l2 = l1;
          if (((Cursor)localObject).moveToFirst())
          {
            long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
            l2 = l1;
            if (l1 < l3)
            {
              localbu.convertFrom((Cursor)localObject);
              l2 = l3;
            }
          }
          ((Cursor)localObject).close();
        }
        i += 1;
        l1 = l2;
      }
    }
    AppMethodBeat.o(117230);
    return localbu;
  }
  
  public final List<bu> aqb(String paramString)
  {
    bu localbu = null;
    AppMethodBeat.i(117240);
    Cursor localCursor = this.hHS.a("select * from ".concat(String.valueOf(paramString)), null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(117240);
      return null;
    }
    paramString = localbu;
    if (localCursor.moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        localbu = new bu();
        localbu.convertFrom(localCursor);
        paramString.add(localbu);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(117240);
    return paramString;
  }
  
  public final Cursor aqc(String paramString)
  {
    AppMethodBeat.i(117247);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117247);
      return null;
    }
    Object localObject = aqo(paramString);
    paramString = "select * from " + (String)localObject + " " + aUi((String)localObject) + " where" + aUf(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime";
    localObject = this.hHS.a(paramString, null, 0);
    ad.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(117247);
    return localObject;
  }
  
  public final void aqd(String paramString)
  {
    AppMethodBeat.i(117252);
    c(paramString, "", null);
    if (this.hHS.execSQL(paramString, "delete from ".concat(String.valueOf(paramString))))
    {
      doNotify("delete_all ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117252);
      return;
    }
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 247L, 1L, false);
    AppMethodBeat.o(117252);
  }
  
  public final int aqe(String paramString)
  {
    AppMethodBeat.i(117254);
    ad.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, at.fkW() });
    c(aqo(paramString), aUf(paramString), null);
    int i = this.hHS.delete(aqo(paramString), aUf(paramString), null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.vKh = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117254);
    return i;
  }
  
  public final int aqf(String paramString)
  {
    AppMethodBeat.i(117261);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(4));
    int i = this.hHS.update(aqo(paramString), localContentValues, aUf(paramString) + "AND isSend=? AND status!=? ", new String[] { "0", "4" });
    if (i != 0)
    {
      doNotify();
      a(new i.c(paramString, "update", null));
    }
    AppMethodBeat.o(117261);
    return i;
  }
  
  public final Cursor aqg(String paramString)
  {
    AppMethodBeat.i(117263);
    paramString = this.hHS.query(aqo(paramString), null, aUf(paramString), null, null, null, "createTime ASC ");
    AppMethodBeat.o(117263);
    return paramString;
  }
  
  public final Cursor aqh(String paramString)
  {
    AppMethodBeat.i(117267);
    paramString = this.hHS.query(aqo(paramString), null, "isSend=? AND" + aUf(paramString) + "AND status!=?", new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117267);
    return paramString;
  }
  
  public final bu.c aqi(String paramString)
  {
    AppMethodBeat.i(117270);
    bu.c localc2 = (bu.c)this.IMK.get(Integer.valueOf(paramString.hashCode()));
    bu.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = bu.c.aUd(paramString);
      this.IMK.q(Integer.valueOf(paramString.hashCode()), localc1);
    }
    AppMethodBeat.o(117270);
    return localc1;
  }
  
  public final bu.d aqj(String paramString)
  {
    AppMethodBeat.i(117271);
    bu.d locald2 = (bu.d)this.IML.get(Integer.valueOf(paramString.hashCode()));
    bu.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = bu.d.aUe(paramString);
      this.IML.q(Integer.valueOf(paramString.hashCode()), locald1);
    }
    AppMethodBeat.o(117271);
    return locald1;
  }
  
  public final bu.a aqk(String paramString)
  {
    AppMethodBeat.i(117272);
    bu.a locala1 = null;
    if ((!bt.isNullOrNil(paramString)) && (this.IMM != null)) {
      locala1 = (bu.a)this.IMM.get(Integer.valueOf(paramString.hashCode()));
    }
    for (;;)
    {
      bu.a locala2 = locala1;
      if (locala1 == null)
      {
        locala1 = bu.a.aUb(paramString);
        locala2 = locala1;
        if (this.IMM != null)
        {
          this.IMM.q(Integer.valueOf(bt.bI(paramString, "").hashCode()), locala1);
          locala2 = locala1;
        }
      }
      AppMethodBeat.o(117272);
      return locala2;
      ad.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", new Object[] { Boolean.valueOf(bt.isNullOrNil(paramString)) });
      ad.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
    }
  }
  
  public final bu.b aql(String paramString)
  {
    AppMethodBeat.i(117273);
    bu.b localb2 = (bu.b)this.IMN.get(Integer.valueOf(paramString.hashCode()));
    bu.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = bu.b.aUc(paramString);
      this.IMN.q(Integer.valueOf(paramString.hashCode()), localb1);
    }
    AppMethodBeat.o(117273);
    return localb1;
  }
  
  public final int aqm(String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(117274);
    if (Bn(paramString))
    {
      i = this.nAg.aTR(paramString);
      if (i > 0)
      {
        ad.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(117274);
        return i;
      }
      ad.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    }
    do
    {
      i = Bm(paramString);
      AppMethodBeat.o(117274);
      return i;
      if (("appbrandmessage".equals(aqo(paramString))) || ("appbrandnotifymessage".equals(aqo(paramString))))
      {
        paramString = "SELECT COUNT(*) FROM " + aqo(paramString) + " WHERE" + aUf(paramString);
        paramString = this.hHS.a(paramString, null, 0);
        if (paramString.moveToLast()) {
          i = paramString.getInt(0);
        }
        paramString.close();
        AppMethodBeat.o(117274);
        return i;
      }
    } while (!"bottlemessage".equals(aqo(paramString)));
    paramString = "SELECT COUNT(*) FROM " + aqo(paramString) + " WHERE" + aUf(paramString);
    paramString = this.hHS.a(paramString, null, 2);
    i = j;
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117274);
    return i;
  }
  
  public final int aqn(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117280);
    if (paramString == null)
    {
      ad.w("MicroMsg.MsgInfoStorage", "getImgVideoMsgCount talker is null!");
      AppMethodBeat.o(117280);
      return 0;
    }
    paramString = "SELECT COUNT(*) FROM " + aqo(paramString) + " WHERE " + aSt(paramString) + "talker= '" + bt.aQN(paramString) + "' AND type IN (3,39,13,43,62,44,268435505,486539313)";
    paramString = this.hHS.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117280);
    return i;
  }
  
  public final String aqo(String paramString)
  {
    AppMethodBeat.i(117283);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = aUl(paramString).name;
      AppMethodBeat.o(117283);
      return paramString;
    }
  }
  
  public final long aqp(String paramString)
  {
    AppMethodBeat.i(117289);
    Object localObject = "select createTime from message where" + aUf(paramString) + "order by createTime LIMIT 1 OFFSET 0";
    ad.d("MicroMsg.MsgInfoStorage", "get first message create time: ".concat(String.valueOf(localObject)));
    localObject = this.hHS.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "get first message create time failed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117289);
      return -1L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(117289);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117289);
    return -1L;
  }
  
  public final long aqq(String paramString)
  {
    AppMethodBeat.i(117290);
    Object localObject = "select createTime from message where" + aSt(paramString) + aUf(paramString) + "order by createTime DESC LIMIT 1 ";
    ad.d("MicroMsg.MsgInfoStorage", "get last message create time: ".concat(String.valueOf(localObject)));
    localObject = this.hHS.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "get last message create time failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117290);
      return -1L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(117290);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117290);
    return -1L;
  }
  
  public final long aqr(String paramString)
  {
    AppMethodBeat.i(117291);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117291);
      return 0L;
    }
    Object localObject = "select msgSeq from message where" + aUf(paramString) + "order by msgSeq DESC LIMIT 1 ";
    ad.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: ".concat(String.valueOf(localObject)));
    localObject = this.hHS.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117291);
      return 0L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(117291);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117291);
    return 0L;
  }
  
  public final bu aqs(String paramString)
  {
    AppMethodBeat.i(117293);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117293);
      return null;
    }
    ad.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", new Object[] { paramString, Boolean.FALSE });
    Object localObject1 = (Long)this.IMP.get(paramString);
    if ((localObject1 != null) && (((Long)localObject1).longValue() > 0L))
    {
      ad.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", new Object[] { Long.valueOf(((Long)localObject1).longValue()) });
      localObject1 = xY(((Long)localObject1).longValue());
      if ((((ei)localObject1).field_flag & 0x1) != 0)
      {
        AppMethodBeat.o(117293);
        return localObject1;
      }
      this.IMP.remove(paramString);
      AppMethodBeat.o(117293);
      return null;
    }
    ad.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
    localObject1 = new bu();
    long l = System.currentTimeMillis();
    Object localObject2 = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ";
    localObject2 = this.hHS.a((String)localObject2, null, 2);
    ad.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(Thread.currentThread().getId()) });
    if (localObject2 == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117293);
      return localObject1;
    }
    if (((Cursor)localObject2).moveToFirst()) {
      ((bu)localObject1).convertFrom((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    this.IMP.q(paramString, Long.valueOf(((ei)localObject1).field_msgId));
    AppMethodBeat.o(117293);
    return localObject1;
  }
  
  public final int aqt(String paramString)
  {
    AppMethodBeat.i(117307);
    String str = " SELECT COUNT(*) FROM " + aqo(paramString) + " WHERE" + aSt(paramString) + aUf(paramString) + "AND isSend=1";
    Cursor localCursor = this.hHS.a(str, null, 2);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          break label168;
        }
        i = localCursor.getInt(0);
        localCursor.close();
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(117307);
      }
      ad.d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", new Object[] { paramString, Integer.valueOf(i), str });
      AppMethodBeat.o(117307);
      return i;
      label168:
      int i = 0;
    }
  }
  
  /* Error */
  public final List<bu> aqu(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 1464
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 533	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 534	java/util/ArrayList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 145	com/tencent/mm/storage/bv:hHS	Lcom/tencent/mm/storagebase/h;
    //   20: ldc 71
    //   22: aconst_null
    //   23: ldc_w 1466
    //   26: iconst_2
    //   27: anewarray 61	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: invokestatic 371	com/tencent/mm/sdk/platformtools/bt:aQN	(Ljava/lang/String;)Ljava/lang/String;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: invokestatic 518	java/lang/System:currentTimeMillis	()J
    //   42: ldc2_w 1467
    //   45: lsub
    //   46: invokestatic 676	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: ldc_w 1235
    //   55: iconst_2
    //   56: invokevirtual 710	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokeinterface 713 1 0
    //   70: ifeq +75 -> 145
    //   73: aload_2
    //   74: astore_1
    //   75: new 227	com/tencent/mm/storage/bu
    //   78: dup
    //   79: invokespecial 714	com/tencent/mm/storage/bu:<init>	()V
    //   82: astore 4
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: aload_2
    //   89: invokevirtual 718	com/tencent/mm/storage/bu:convertFrom	(Landroid/database/Cursor;)V
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: aload 4
    //   97: invokevirtual 721	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto -39 -> 62
    //   104: astore_3
    //   105: aload_2
    //   106: astore_1
    //   107: ldc 157
    //   109: aload_3
    //   110: ldc_w 1470
    //   113: iconst_1
    //   114: anewarray 161	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 684	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_2
    //   128: ifnull +9 -> 137
    //   131: aload_2
    //   132: invokeinterface 506 1 0
    //   137: ldc_w 1464
    //   140: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aconst_null
    //   144: areturn
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 506 1 0
    //   155: ldc_w 1464
    //   158: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_3
    //   162: areturn
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +9 -> 174
    //   168: aload_2
    //   169: invokeinterface 506 1 0
    //   174: ldc_w 1464
    //   177: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	196	0	this	bv
    //   0	196	1	paramString	String
    //   1	192	2	str	String
    //   15	80	3	localArrayList	ArrayList
    //   104	58	3	localException1	Exception
    //   182	4	3	localObject	Object
    //   190	1	3	localException2	Exception
    //   82	14	4	localbu	bu
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
  
  public final long aqv(String paramString)
  {
    AppMethodBeat.i(117317);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    paramString = aUj(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    long l = paramString.hZF;
    AppMethodBeat.o(117317);
    return l;
  }
  
  public final Cursor aqw(String paramString)
  {
    AppMethodBeat.i(117315);
    try
    {
      paramString = this.hHS.a(aqo(paramString), null, aUf(paramString) + " AND createTime>=? AND type IN (436207665,419430449)", new String[] { String.valueOf(System.currentTimeMillis() - 86400000L) }, null, null, "createTime ASC", 2);
      AppMethodBeat.o(117315);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.MsgInfoStorage", paramString, "getLastDayC2CMsgByTalker error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(117315);
    }
    return null;
  }
  
  public final long aqx(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(217621);
    paramString = "SELECT COUNT(*) FROM " + aqo(paramString) + " WHERE " + aUf(paramString) + " AND type NOT IN (10000,10002,570425393,64,603979825,855638065,889192497,922746929)";
    paramString = this.hHS.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    long l = i;
    AppMethodBeat.o(217621);
    return l;
  }
  
  public final int ar(bu parambu)
  {
    int i = 0;
    AppMethodBeat.i(117234);
    if ((parambu == null) || (bt.isNullOrNil(parambu.field_talker)))
    {
      AppMethodBeat.o(117234);
      return 0;
    }
    parambu = "SELECT count(msgId) FROM " + aqo(parambu.field_talker) + " WHERE" + aUf(parambu.field_talker) + "AND isSend = 0 AND msgId >= " + parambu.field_msgId + " ORDER BY createTime DESC";
    parambu = this.hHS.a(parambu, null, 2);
    if (parambu.moveToFirst()) {
      i = parambu.getInt(0);
    }
    parambu.close();
    AppMethodBeat.o(117234);
    return i;
  }
  
  public final long as(bu parambu)
  {
    AppMethodBeat.i(221255);
    long l = c(parambu, false);
    AppMethodBeat.o(221255);
    return l;
  }
  
  public final void at(bu parambu)
  {
    AppMethodBeat.i(117259);
    if ((parambu == null) || (parambu.field_status == 4))
    {
      AppMethodBeat.o(117259);
      return;
    }
    parambu.setStatus(4);
    String str = DH(parambu.field_msgId);
    if ((str != null) && (str.length() > 0)) {
      if (this.hHS.update(str, parambu.convertTo(), "msgId=?", new String[] { parambu.field_msgId }) != 0)
      {
        doNotify();
        a(new i.c(parambu.field_talker, "update", parambu, -1));
      }
    }
    AppMethodBeat.o(117259);
  }
  
  public final int au(bu parambu)
  {
    int i = 0;
    AppMethodBeat.i(117262);
    if (parambu != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("content", parambu.field_content);
      localContentValues.put("status", Integer.valueOf(parambu.field_status));
      int j = this.hHS.update(DH(parambu.field_msgId), localContentValues, "msgId=?", new String[] { String.valueOf(parambu.field_msgId) });
      i = j;
      if (j != 0)
      {
        doNotify();
        a(new i.c(parambu.field_talker, "update", parambu));
        i = j;
      }
    }
    AppMethodBeat.o(117262);
    return i;
  }
  
  public final Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117299);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(aqo(paramString)).append(" WHERE").append(aUf(paramString));
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
        ad.d("MicroMsg.MsgInfoStorage", "getCursorAfterStratTimeBeforeEndTimeLimit talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
        paramString = this.hHS.a(str, null, 0);
        AppMethodBeat.o(117299);
        return paramString;
        str = "";
        break;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void b(long paramLong, bu parambu)
  {
    AppMethodBeat.i(117260);
    if (bt.nullAsNil(parambu.field_talker).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("no talker set when update by svrid", bool);
      if (parambu.frC())
      {
        String str = aUh(parambu.eLs);
        if (w.Aj(str))
        {
          ad.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
          parambu.tN("notifymessage");
        }
      }
      aO(parambu);
      if (paramLong != 0L) {
        break;
      }
      ad.w("MicroMsg.MsgInfoStorage", "invalid svr id %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(117260);
      return;
    }
    if (this.hHS.update(aqo(parambu.field_talker), parambu.convertTo(), "msgSvrId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new i.c(parambu.field_talker, "update", parambu));
      AppMethodBeat.o(117260);
      return;
    }
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 243L, 1L, false);
    AppMethodBeat.o(117260);
  }
  
  public final long c(bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(117238);
    if ((parambu == null) || (bt.isNullOrNil(parambu.field_talker)))
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 250L, 1L, false);
      if (parambu == null) {}
      for (localObject1 = "-1";; localObject1 = parambu.field_talker)
      {
        ad.e("MicroMsg.MsgInfoStorage", "Error insert message msg:%s talker:%s", new Object[] { parambu, localObject1 });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    ad.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", new Object[] { Boolean.valueOf(this.IMS), Long.valueOf(parambu.field_msgSeq) });
    Object localObject1 = null;
    Object localObject2 = com.tencent.mm.model.bj.Bq(parambu.eLs);
    if (localObject2 != null) {
      localObject1 = ((bj.b)localObject2).hGM;
    }
    if (w.Aj((String)localObject1))
    {
      ad.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { localObject1 });
      if (parambu.getType() == 436207665)
      {
        ad.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
        AppMethodBeat.o(117238);
        return -1L;
      }
      parambu.tN("notifymessage");
    }
    localObject1 = aUl(parambu.field_talker);
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 249L, 1L, false);
      ad.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", new Object[] { parambu.field_talker });
      AppMethodBeat.o(117238);
      return -1L;
    }
    ((i.b)localObject1).av(parambu);
    Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[] { Long.valueOf(parambu.field_msgId), localObject1, DH(parambu.field_msgId) }), ((i.b)localObject1).name.equals(DH(parambu.field_msgId)));
    if (parambu.field_msgSvrId != 0L)
    {
      parambu.fku = 1;
      parambu.eKU = true;
    }
    ??? = this.IMI.iterator();
    while (((Iterator)???).hasNext()) {
      if (!((e)((Iterator)???).next()).a(parambu, (bj.b)localObject2))
      {
        ad.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", new Object[] { parambu.field_talker, parambu.eLs });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    aO(parambu);
    if (((i.b)localObject1).name.equals("message"))
    {
      parambu.field_talkerId = ((int)aUg(parambu.field_talker));
      parambu.eKV = true;
    }
    localObject2 = parambu.convertTo();
    com.tencent.mm.storagebase.f localf;
    if (paramBoolean)
    {
      localf = this.hHS.ftS();
      ??? = ((i.b)localObject1).name;
      if (localf.IOD != null)
      {
        localObject1 = localf.IOD;
        if (com.tencent.mm.storagebase.f.isMainThread()) {
          com.tencent.mm.storagebase.f.IOJ.a((SQLiteDatabase)localObject1, 32769, (String)???);
        }
      }
    }
    for (long l = ((SQLiteDatabase)localObject1).insertOrThrow((String)???, "msgId", (ContentValues)localObject2);; l = this.hHS.a(((i.b)localObject1).name, "msgId", (ContentValues)localObject2))
    {
      ad.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", new Object[] { Long.valueOf(l), parambu.field_talker, Long.valueOf(parambu.field_msgId), Integer.valueOf(parambu.getType()), Integer.valueOf(parambu.field_status), Long.valueOf(parambu.field_msgSvrId), Long.valueOf(parambu.field_msgSeq), Integer.valueOf(parambu.field_flag), Long.valueOf(parambu.field_createTime), Integer.valueOf(parambu.field_isSend), this.IMT, Long.valueOf(bt.Df(this.IMU)) });
      if (l != -1L) {
        break label746;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 248L, 1L, false);
      ad.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", new Object[] { Long.valueOf(parambu.field_msgSvrId), Long.valueOf(l) });
      AppMethodBeat.o(117238);
      return -1L;
      localObject1 = localf.IOE;
      break;
    }
    label746:
    if ((this.IMS) && (bt.Df(this.IMU) > 2000L) && (parambu.field_isSend == 1) && (parambu.field_status == 1))
    {
      ad.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", new Object[] { this.IMT, Long.valueOf(bt.Df(this.IMU)) });
      apT(this.IMT);
    }
    if (this.IMS)
    {
      localObject1 = null;
      if (e.InI != null) {
        localObject1 = e.InI.ac(parambu);
      }
      if (!bt.isNullOrNil((String)localObject1)) {
        break label1063;
      }
    }
    label1063:
    for (localObject2 = parambu.field_talker;; localObject2 = localObject1)
    {
      localObject1 = null;
      for (;;)
      {
        synchronized (this.IMR)
        {
          if (this.IMR.containsKey(localObject2)) {
            localObject1 = (i.c)this.IMR.get(localObject2);
          }
          if (localObject1 == null)
          {
            localObject1 = new i.c(parambu.field_talker, "insert", parambu);
            if (i.c.aw(parambu)) {
              ((i.c)localObject1).scY += 1;
            }
            ((i.c)localObject1).vKf += 1;
            this.IMR.put(localObject2, localObject1);
            l = parambu.field_msgId;
            AppMethodBeat.o(117238);
            return l;
          }
          ((i.c)localObject1).gNE.add(parambu);
        }
        localObject1 = new i.c(parambu.field_talker, "insert", parambu);
        if (i.c.aw(parambu)) {
          ((i.c)localObject1).scY = 1;
        }
        ((i.c)localObject1).vKf = 1;
        doNotify();
        a((i.c)localObject1);
      }
    }
  }
  
  public final Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117301);
    if (paramLong2 == 0L)
    {
      paramString = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND createTime > " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hHS.a(paramString, null, 0);
      AppMethodBeat.o(117301);
      return paramString;
    }
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hHS.a(paramString, null, 0);
      AppMethodBeat.o(117301);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void c(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(117250);
    long l = bt.aQJ();
    Object localObject = "SELECT msgSvrId,createTime FROM " + paramString1 + " WHERE createTime > " + (l - 172800L) * 1000L;
    paramString1 = (String)localObject;
    if (!bt.isNullOrNil(paramString2)) {
      paramString1 = (String)localObject + " AND " + paramString2;
    }
    paramString2 = new ArrayList();
    localObject = new ArrayList();
    paramString1 = this.hHS.a(paramString1, paramArrayOfString, 2);
    if (paramString1.moveToFirst())
    {
      do
      {
        int i = paramString1.getInt(0);
        l = paramString1.getLong(1) / 1000L;
        paramString2.add(Integer.valueOf(i));
        ((List)localObject).add(Long.valueOf(l));
      } while (paramString1.moveToNext());
      this.IMQ.G(paramString2, (List)localObject);
    }
    paramString1.close();
    AppMethodBeat.o(117250);
  }
  
  public final Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117298);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM (SELECT * FROM " + aqo(paramString) + " WHERE" + aSt(paramString) + aUf(paramString) + " AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime DESC LIMIT " + paramInt + " ) ORDER BY createTime ASC";
      ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hHS.a(paramString, null, 0);
      AppMethodBeat.o(117298);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void d(h paramh, String paramString)
  {
    AppMethodBeat.i(117198);
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    Cursor localCursor = paramh.a("PRAGMA table_info( " + paramString + " )", null, 2);
    int i7 = localCursor.getColumnIndex("name");
    while (localCursor.moveToNext()) {
      if (i7 >= 0)
      {
        String str = localCursor.getString(i7);
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
        } else if ("solitaireFoldInfo".equalsIgnoreCase(str)) {
          i5 = 1;
        } else if ("historyId".equalsIgnoreCase(str)) {
          i6 = 1;
        }
      }
    }
    localCursor.close();
    long l = paramh.xO(Thread.currentThread().getId());
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
    if (i5 == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add solitaireFoldInfo BLOB ");
    }
    if (i6 == 0) {
      paramh.execSQL(paramString, "Alter table " + paramString + " add historyId TEXT ");
    }
    paramh.sJ(l);
    AppMethodBeat.o(117198);
  }
  
  public final void dlT()
  {
    AppMethodBeat.i(117201);
    u.aBa();
    AppMethodBeat.o(117201);
  }
  
  public final void dlU()
  {
    AppMethodBeat.i(117204);
    int i = 0;
    while (i < this.IMJ.size())
    {
      b((i.b)this.IMJ.get(i));
      i += 1;
    }
    AppMethodBeat.o(117204);
  }
  
  public final void dlV()
  {
    AppMethodBeat.i(117206);
    if (!this.IMH)
    {
      AppMethodBeat.o(117206);
      return;
    }
    Object localObject = "select count(*) from " + "message" + " where talkerId ISNULL ";
    localObject = this.hHS.a((String)localObject, null, 2);
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
        ad.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", new Object[] { "message" });
        long l = System.currentTimeMillis();
        localObject = "update " + "message" + " set talkerId=(select rowid from rcontact where rcontact.username = " + "message" + ".talker)";
        boolean bool = this.hHS.execSQL("message", (String)localObject);
        ad.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
        if ((bool) && (this.IMH))
        {
          this.hHS.execSQL("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
          this.hHS.execSQL("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
          this.hHS.execSQL("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
          this.hHS.execSQL("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
          this.hHS.execSQL("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
          ad.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
        }
      }
      AppMethodBeat.o(117206);
      return;
    }
  }
  
  public final ArrayList<bu> dlW()
  {
    AppMethodBeat.i(117218);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.hHS.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[] { String.valueOf(System.currentTimeMillis() - 172800000L), "5", "1" }, null, null, "createTime ASC", 2);
    label149:
    while (localCursor.moveToNext())
    {
      bu localbu = new bu();
      localbu.convertFrom(localCursor);
      if (!localbu.frZ()) {}
      for (int i = 1;; i = 0)
      {
        if (((i & 0x1) == 0) || (am.aSN(localbu.field_talker)) || (am.aSP(localbu.field_talker)) || (am.zs(localbu.field_talker))) {
          break label149;
        }
        localArrayList.add(localbu);
        break;
      }
    }
    localCursor.close();
    AppMethodBeat.o(117218);
    return localArrayList;
  }
  
  public final List<bu> dlX()
  {
    AppMethodBeat.i(117231);
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    Object localObject1;
    int i;
    if (this.IMJ != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject1 = new ArrayList();
      i = 0;
    }
    Object localObject2;
    for (;;)
    {
      if (i >= this.IMJ.size()) {
        break label176;
      }
      localObject2 = this.hHS.a(((i.b)this.IMJ.get(i)).name, null, "status=1 and isSend=1 and type IN (1,11,21,31,36,42,66,48,55,57)", null, null, null, "createTime", 100);
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label162;
        }
        bu localbu = new bu();
        localbu.convertFrom((Cursor)localObject2);
        if (com.tencent.mm.model.bj.aCb() - localbu.field_createTime > 86400000L)
        {
          ((List)localObject1).add(localbu);
          continue;
          bool = false;
          break;
        }
        localArrayList.add(localbu);
      }
      label162:
      ((Cursor)localObject2).close();
      i += 1;
    }
    label176:
    ad.i("MicroMsg.MsgInfoStorage", "getLastSendingMsgList listMsg:%s lstTimeoutMsg:%s", new Object[] { Integer.valueOf(localArrayList.size()), Integer.valueOf(((List)localObject1).size()) });
    if (((List)localObject1).size() > 0)
    {
      long l = this.hHS.xO(-1L);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bu)((Iterator)localObject1).next();
        ad.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d time:%s talker:%s content:%s", new Object[] { Long.valueOf(((ei)localObject2).field_msgId), Long.valueOf(((ei)localObject2).field_createTime), Integer.valueOf(((bu)localObject2).getType()), ((ei)localObject2).field_talker, bt.aRp(((ei)localObject2).field_content) });
        ((bu)localObject2).setStatus(5);
        a(((ei)localObject2).field_msgId, (bu)localObject2);
      }
      this.hHS.sJ(l);
    }
    AppMethodBeat.o(117231);
    return localArrayList;
  }
  
  public final Cursor dlY()
  {
    AppMethodBeat.i(117269);
    Cursor localCursor = this.hHS.query("message", new String[] { "talker", "count(*) as unReadCount" }, "isSend=? AND status!=?", new String[] { "0", "4" }, "talker", null, null);
    AppMethodBeat.o(117269);
    return localCursor;
  }
  
  public final String dlZ()
  {
    return "type IN (3,39,13,43,62,44,268435505,486539313)";
  }
  
  public final String dma()
  {
    return "type IN (3,39,13,43,62,44,49,268435505)";
  }
  
  public final int dmb()
  {
    AppMethodBeat.i(117295);
    ad.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf("SELECT COUNT(msgId) FROM message")));
    Cursor localCursor = this.hHS.a("SELECT COUNT(msgId) FROM message", null, 2);
    if (localCursor == null)
    {
      ad.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
      AppMethodBeat.o(117295);
      return 0;
    }
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      ad.d("MicroMsg.MsgInfoStorage", "result getAllMsgCount count %d", new Object[] { Integer.valueOf(i) });
      localCursor.close();
      AppMethodBeat.o(117295);
      return i;
    }
    localCursor.close();
    AppMethodBeat.o(117295);
    return 0;
  }
  
  /* Error */
  public final List<bu> dmc()
  {
    // Byte code:
    //   0: ldc_w 1811
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 533	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 534	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 145	com/tencent/mm/storage/bv:hHS	Lcom/tencent/mm/storagebase/h;
    //   18: ldc 71
    //   20: aconst_null
    //   21: ldc_w 1813
    //   24: iconst_1
    //   25: anewarray 61	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: invokestatic 518	java/lang/System:currentTimeMillis	()J
    //   33: ldc2_w 1467
    //   36: lsub
    //   37: invokestatic 676	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: ldc_w 1235
    //   46: iconst_2
    //   47: invokevirtual 710	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 713 1 0
    //   59: ifeq +75 -> 134
    //   62: aload_2
    //   63: astore_1
    //   64: new 227	com/tencent/mm/storage/bu
    //   67: dup
    //   68: invokespecial 714	com/tencent/mm/storage/bu:<init>	()V
    //   71: astore 4
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: aload_2
    //   78: invokevirtual 718	com/tencent/mm/storage/bu:convertFrom	(Landroid/database/Cursor;)V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload 4
    //   86: invokevirtual 721	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -39 -> 51
    //   93: astore_3
    //   94: aload_2
    //   95: astore_1
    //   96: ldc 157
    //   98: aload_3
    //   99: ldc_w 1470
    //   102: iconst_1
    //   103: anewarray 161	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_3
    //   109: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 684	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_2
    //   117: ifnull +9 -> 126
    //   120: aload_2
    //   121: invokeinterface 506 1 0
    //   126: ldc_w 1811
    //   129: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aconst_null
    //   133: areturn
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 506 1 0
    //   144: ldc_w 1811
    //   147: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_3
    //   151: areturn
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +9 -> 165
    //   159: aload_1
    //   160: invokeinterface 506 1 0
    //   165: ldc_w 1811
    //   168: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	183	0	this	bv
    //   52	108	1	localCursor1	Cursor
    //   50	89	2	localCursor2	Cursor
    //   152	20	2	localObject1	Object
    //   173	1	2	localObject2	Object
    //   179	1	2	localObject3	Object
    //   13	71	3	localArrayList	ArrayList
    //   93	58	3	localException1	Exception
    //   177	1	3	localException2	Exception
    //   71	14	4	localbu	bu
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
  
  public final List<bu> eb(String paramString, int paramInt)
  {
    AppMethodBeat.i(117228);
    ArrayList localArrayList = new ArrayList();
    if (this.IMJ != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND status = 3 AND type <> 10000 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hHS.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bu localbu = new bu();
        localbu.convertFrom(paramString);
        localArrayList.add(localbu);
      }
    }
    paramString.close();
    AppMethodBeat.o(117228);
    return localArrayList;
  }
  
  public final List<bu> ec(String paramString, int paramInt)
  {
    AppMethodBeat.i(117232);
    ArrayList localArrayList = new ArrayList();
    if (this.IMJ != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hHS.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bu localbu = new bu();
        localbu.convertFrom(paramString);
        if (localbu.isText()) {
          localArrayList.add(localbu);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(117232);
    return localArrayList;
  }
  
  public final List<bu> ed(String paramString, int paramInt)
  {
    AppMethodBeat.i(217619);
    ArrayList localArrayList = new ArrayList();
    if (this.IMJ != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + " ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hHS.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bu localbu = new bu();
        localbu.convertFrom(paramString);
        localArrayList.add(localbu);
      }
    }
    paramString.close();
    AppMethodBeat.o(217619);
    return localArrayList;
  }
  
  public final Cursor ee(String paramString, int paramInt)
  {
    AppMethodBeat.i(117248);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117248);
      return null;
    }
    String str = aqo(paramString);
    paramString = "select * from " + str + " where" + aSt(paramString) + aUf(paramString) + " AND type & 65535 = 49" + "  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.hHS.a(paramString, null, 0);
    AppMethodBeat.o(117248);
    return paramString;
  }
  
  public final Cursor ef(String paramString, int paramInt)
  {
    AppMethodBeat.i(117249);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117249);
      return null;
    }
    Object localObject = aqo(paramString);
    paramString = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend,imgPath from ").append((String)localObject).append(" where").append(aSt(paramString)).append(aUf(paramString)).append(" AND ");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" (type = 49");
    ((StringBuilder)localObject).append(" or type = 587202609");
    ((StringBuilder)localObject).append(" or type = 553648177) ");
    paramString = ((StringBuilder)localObject).toString() + " order by createTime DESC limit 100 OFFSET " + paramInt;
    paramString = this.hHS.a(paramString, null, 0);
    AppMethodBeat.o(117249);
    return paramString;
  }
  
  public final Cursor eg(String paramString, int paramInt)
  {
    AppMethodBeat.i(117245);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117245);
      return null;
    }
    String str = aqo(paramString);
    paramString = "select * from ( select * from " + str + " where" + aUf(paramString) + " AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime DESC limit 200 OFFSET " + paramInt + ") order by createTime ASC ";
    paramString = this.hHS.a(paramString, null, 2);
    AppMethodBeat.o(117245);
    return paramString;
  }
  
  public final int eh(String paramString, int paramInt)
  {
    AppMethodBeat.i(117256);
    ad.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", new Object[] { paramString, Integer.valueOf(paramInt), at.fkW() });
    bu localbu = aI(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbu.field_talker));
    c(aqo(paramString), "createTime<=? AND" + aUf(paramString), new String[] { localbu.field_createTime });
    paramInt = this.hHS.delete(aqo(paramString), "createTime<=? AND" + aUf(paramString), new String[] { localbu.field_createTime });
    if (paramInt != 0)
    {
      doNotify();
      a(new i.c(paramString, "delete", null, paramInt, (byte)0));
    }
    AppMethodBeat.o(117256);
    return paramInt;
  }
  
  public final Cursor ei(String paramString, int paramInt)
  {
    AppMethodBeat.i(117257);
    bu localbu = aI(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbu.field_talker));
    paramString = this.hHS.query(aqo(paramString), null, "createTime<=? AND" + aUf(paramString), new String[] { localbu.field_createTime }, null, null, null);
    AppMethodBeat.o(117257);
    return paramString;
  }
  
  public final Cursor ej(String paramString, int paramInt)
  {
    AppMethodBeat.i(117268);
    paramString = this.hHS.query(aqo(paramString), null, "isSend=? AND" + aUf(paramString) + "AND status!=?  order by msgId DESC limit " + paramInt, new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117268);
    return paramString;
  }
  
  public final int ek(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117278);
    paramString = "SELECT COUNT(*) FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND type = " + paramInt;
    paramString = this.hHS.a(paramString, null, 2);
    paramInt = i;
    if (paramString.moveToFirst()) {
      paramInt = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117278);
    return paramInt;
  }
  
  public final Cursor el(String paramString, int paramInt)
  {
    AppMethodBeat.i(117305);
    String str = " SELECT * FROM " + aqo(paramString) + " WHERE" + aSt(paramString) + aUf(paramString) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + paramInt;
    ad.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    paramString = this.hHS.a(str, null, 0);
    AppMethodBeat.o(117305);
    return paramString;
  }
  
  public final bu[] em(String paramString, int paramInt)
  {
    AppMethodBeat.i(117311);
    if ((paramString == null) || (paramString.length() == 0) || (paramInt <= 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + paramString + ", limit = " + paramInt);
      AppMethodBeat.o(117311);
      return null;
    }
    Object localObject = "select * from " + aqo(paramString) + " where" + aUf(paramString) + "order by createTime DESC limit " + paramInt;
    localObject = this.hHS.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        bu localbu = new bu();
        localbu.convertFrom((Cursor)localObject);
        localArrayList.add(localbu);
      } while (((Cursor)localObject).moveToNext());
      ((Cursor)localObject).close();
      ad.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + paramString + ", limit = " + paramInt + ", count = " + localArrayList.size());
      Collections.reverse(localArrayList);
      paramString = (bu[])localArrayList.toArray(new bu[localArrayList.size()]);
      AppMethodBeat.o(117311);
      return paramString;
    }
    ad.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
    ((Cursor)localObject).close();
    AppMethodBeat.o(117311);
    return null;
  }
  
  public final Cursor en(String paramString, int paramInt)
  {
    AppMethodBeat.i(117319);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117319);
      return null;
    }
    String str = aqo(paramString);
    paramString = "select * from " + str + " where" + aSt(paramString) + aUf(paramString) + " AND type IN (436207665,419430449)  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.hHS.a(paramString, null, 0);
    AppMethodBeat.o(117319);
    return paramString;
  }
  
  public final List<bu> f(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(217616);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + aqo(paramString) + " Where " + aUf(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit " + paramInt;
    paramString = this.hHS.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bu localbu = new bu();
      localbu.convertFrom(paramString);
      localArrayList.add(localbu);
    }
    paramString.close();
    AppMethodBeat.o(217616);
    return localArrayList;
  }
  
  public final List<bu> f(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(117242);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(117242);
      return null;
    }
    paramLong = aQ(paramString, paramLong);
    if (paramLong == 0L)
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(117242);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (paramString = "select * from " + aqo(paramString) + " where" + aSt(paramString) + aUf(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime > " + paramLong + " order by createTime ASC limit 10";; paramString = "select * from " + aqo(paramString) + " where" + aSt(paramString) + aUf(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + paramLong + " order by createTime DESC limit 10")
    {
      paramString = this.hHS.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bu localbu = new bu();
        localbu.convertFrom(paramString);
        localArrayList.add(localbu);
      }
    }
    if (!paramBoolean) {
      Collections.reverse(localArrayList);
    }
    paramString.close();
    AppMethodBeat.o(117242);
    return localArrayList;
  }
  
  public final List<bu> g(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(217617);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + aqo(paramString) + " Where " + aUf(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit " + paramInt + ";";
    paramString = this.hHS.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bu localbu = new bu();
      localbu.convertFrom(paramString);
      localArrayList.add(localbu);
    }
    paramString.close();
    AppMethodBeat.o(217617);
    return localArrayList;
  }
  
  public final h getDB()
  {
    return this.hHS;
  }
  
  public final int h(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117221);
    String str = "SELECT * FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime ASC LIMIT -1 OFFSET " + paramInt;
    Cursor localCursor = this.hHS.a(str, null, 0);
    paramInt = localCursor.getCount();
    localCursor.close();
    ad.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + paramString + " time:" + paramLong + " count " + paramInt + " [" + str + "]");
    AppMethodBeat.o(117221);
    return paramInt;
  }
  
  public final bu hQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117225);
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", new Object[] { paramString1 });
      AppMethodBeat.o(117225);
      return null;
    }
    bu localbu = new bu();
    paramString2 = "select * from " + aqo(paramString1) + " where" + aUf(paramString1) + paramString2 + " order by createTime DESC limit 1";
    paramString2 = this.hHS.a(paramString2, null, 2);
    if (paramString2.moveToFirst()) {
      localbu.convertFrom(paramString2);
    }
    paramString2.close();
    ad.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", new Object[] { paramString1, Long.valueOf(localbu.field_msgId) });
    AppMethodBeat.o(117225);
    return localbu;
  }
  
  public final Cursor hR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117265);
    paramString1 = "SELECT * FROM " + aqo(paramString1) + " WHERE" + aUf(paramString1) + "AND content LIKE '%" + paramString2 + "%' AND type = 1";
    paramString1 = paramString1 + " ORDER BY createTime DESC";
    paramString1 = this.hHS.a(paramString1, null, 0);
    AppMethodBeat.o(117265);
    return paramString1;
  }
  
  public final int hS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117306);
    String str = " SELECT COUNT(*) FROM " + aqo(paramString1) + " WHERE" + aSt(paramString1) + aUf(paramString1) + "AND content LIKE '" + paramString2 + "%' ";
    Cursor localCursor = this.hHS.a(str, null, 2);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          break label188;
        }
        i = localCursor.getInt(0);
        localCursor.close();
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(117306);
      }
      ad.d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(i), str });
      AppMethodBeat.o(117306);
      return i;
      label188:
      int i = 0;
    }
  }
  
  public final LinkedList<bu> hT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117312);
    paramString1 = this.hHS.a(aqo(paramString1), null, "talker=? AND bizClientMsgId=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
    if (paramString1 != null) {}
    try
    {
      if (!paramString1.moveToFirst())
      {
        ad.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
        return null;
      }
      paramString2 = new LinkedList();
      do
      {
        bu localbu = new bu();
        localbu.convertFrom(paramString1);
        paramString2.add(localbu);
      } while (paramString1.moveToNext());
      paramString1.close();
      return paramString2;
    }
    catch (Exception paramString2)
    {
      ad.printErrStackTrace("MicroMsg.MsgInfoStorage", paramString2, "getLastDayC2CMsgByTalker error: %s", new Object[] { paramString2.getMessage() });
      paramString2 = new LinkedList();
      return paramString2;
    }
    finally
    {
      if (paramString1 != null) {
        paramString1.close();
      }
      AppMethodBeat.o(117312);
    }
  }
  
  public final long i(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117308);
    ad.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ad.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117308);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + aqo(paramString) + " WHERE" + aSt(paramString) + aUf(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime DESC  LIMIT " + paramInt;
    ad.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hHS.a(paramString, null, 0);
    if (paramString == null)
    {
      ad.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(117308);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      ad.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(117308);
      return paramLong;
    }
    paramString.close();
    ad.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117308);
    return paramLong;
  }
  
  public final long j(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117310);
    ad.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ad.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117310);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + aqo(paramString) + " WHERE" + aUf(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC  LIMIT " + paramInt;
    ad.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hHS.a(paramString, null, 0);
    if (paramString == null)
    {
      ad.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
      AppMethodBeat.o(117310);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      ad.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(117310);
      return paramLong;
    }
    paramString.close();
    ad.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117310);
    return paramLong;
  }
  
  public final Cursor k(String paramString, long paramLong, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(117318);
    try
    {
      paramString = "select * from " + paramString + " where " + "type IN (3,39,13,43,62,44,49,268435505,34)" + " AND msgId >= " + paramLong + "  order by msgId ASC  limit " + paramInt;
      paramString = this.hHS.a(paramString, null, 0);
      AppMethodBeat.o(117318);
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
  
  public final void lock()
  {
    AppMethodBeat.i(117193);
    Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
    AppMethodBeat.o(117193);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(117194);
    Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    AppMethodBeat.o(117194);
  }
  
  public final bu xY(long paramLong)
  {
    AppMethodBeat.i(117207);
    bu localbu = new bu();
    Cursor localCursor = this.hHS.a(DH(paramLong), null, "msgId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localbu.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117207);
    return localbu;
  }
  
  public final int xZ(long paramLong)
  {
    AppMethodBeat.i(117239);
    bu localbu = xY(paramLong);
    Object localObject = localbu.field_talker;
    this.IMQ.n((int)(bt.aQJ() / 86400L), localbu.field_msgSvrId, localbu.field_createTime / 1000L);
    int i = this.hHS.delete(DH(paramLong), "msgId=?", new String[] { String.valueOf(paramLong) });
    ((ao)g.ab(ao.class)).rH(paramLong);
    if (i != 0)
    {
      doNotify("delete_id ".concat(String.valueOf(paramLong)));
      localObject = new i.c((String)localObject, "delete", localbu, 1, (byte)0);
      ((i.c)localObject).vKh = paramLong;
      ((i.c)localObject).nYO = localbu.field_bizChatId;
      a((i.c)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(117239);
      return i;
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 245L, 1L, false);
    }
  }
  
  public final boolean ya(long paramLong)
  {
    AppMethodBeat.i(117251);
    boolean bool = this.IMQ.DF(paramLong);
    AppMethodBeat.o(117251);
    return bool;
  }
  
  public final boolean yb(long paramLong)
  {
    AppMethodBeat.i(117287);
    int i = 0;
    while (i < this.IMJ.size())
    {
      if (((i.b)this.IMJ.get(i)).yd(paramLong))
      {
        AppMethodBeat.o(117287);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(117287);
    return false;
  }
  
  public final void yc(long paramLong)
  {
    AppMethodBeat.i(117313);
    this.IMQ.b(0, paramLong, 0L, false);
    AppMethodBeat.o(117313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bv
 * JD-Core Version:    0.7.0.1
 */