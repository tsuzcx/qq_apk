package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
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

public final class bm
  extends com.tencent.mm.sdk.e.k
  implements com.tencent.mm.plugin.messenger.foundation.a.a.h
{
  public static final String[] SQL_CREATE;
  private Map<String, h.c> FAA;
  private boolean FAB;
  private String FAC;
  private long FAD;
  private boolean FAq;
  private final List<e> FAr;
  private List<h.b> FAs;
  private final com.tencent.mm.b.f<Integer, bl.c> FAt;
  private final com.tencent.mm.b.f<Integer, bl.d> FAu;
  private final com.tencent.mm.b.f<Integer, bl.a> FAv;
  private final com.tencent.mm.b.f<Integer, bl.b> FAw;
  private final com.tencent.mm.b.f<Integer, Object> FAx;
  private final com.tencent.mm.b.f<String, Long> FAy;
  private ap FAz;
  private final l<h.a, h.c> Feu;
  private final long Fyp;
  private final com.tencent.mm.storagebase.h gPa;
  private bg mxG;
  private bh mxI;
  
  static
  {
    AppMethodBeat.i(117320);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag INT, solitaireFoldInfo BLOB) " };
    AppMethodBeat.o(117320);
  }
  
  public bm(com.tencent.mm.storagebase.h paramh, bg parambg, bh parambh)
  {
    AppMethodBeat.i(117202);
    this.FAq = false;
    this.FAr = new CopyOnWriteArrayList();
    this.FAt = new com.tencent.mm.memory.a.c(100);
    this.FAu = new com.tencent.mm.memory.a.c(100);
    this.FAv = new com.tencent.mm.memory.a.c(100);
    this.FAw = new com.tencent.mm.memory.a.c(100);
    this.FAx = new com.tencent.mm.memory.a.c(100);
    this.FAy = new com.tencent.mm.memory.a.c(100);
    this.FAz = new ap();
    this.Feu = new l()
    {
      public final void gM(List<h.c> paramAnonymousList)
      {
        AppMethodBeat.i(117187);
        if ((!isLocked()) && (bm.a(bm.this) != null))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            h.c localc = (h.c)paramAnonymousList.next();
            if (localc != null) {
              bm.a(bm.this).b(bm.this, localc);
            }
          }
        }
        AppMethodBeat.o(117187);
      }
    };
    this.FAA = new HashMap();
    this.FAB = false;
    this.FAC = "";
    this.FAD = 0L;
    this.Fyp = 86400L;
    this.gPa = paramh;
    this.mxG = parambg;
    this.mxI = parambh;
    g.afC();
    if (((Integer)g.afB().afk().get(348169, Integer.valueOf(0))).intValue() == 0)
    {
      ad.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", new Object[] { Integer.valueOf(this.gPa.delete("message", "msgId> ? ", new String[] { "80000000" })) });
      g.afC();
      g.afB().afk().set(348169, Integer.valueOf(1));
    }
    c(paramh, "message");
    eMM();
    if (this.FAs == null) {
      this.FAs = new LinkedList();
    }
    this.FAs.clear();
    a(new h.b(1, "message", h.b.a(1L, 1000000L, 10000000L, 90000000L)));
    AppMethodBeat.o(117202);
  }
  
  private static String aHn(String paramString)
  {
    AppMethodBeat.i(177115);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).aqo().age(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(177115);
      return paramString;
    }
    AppMethodBeat.o(177115);
    return "";
  }
  
  private String aIS(String paramString)
  {
    AppMethodBeat.i(117216);
    String str = agG(paramString);
    if ((this.FAq) && (str.equals("message")))
    {
      paramString = " talkerId=" + aIT(paramString) + " ";
      AppMethodBeat.o(117216);
      return paramString;
    }
    paramString = " talker= '" + bt.aFQ(paramString) + "' ";
    AppMethodBeat.o(117216);
    return paramString;
  }
  
  private long aIT(String paramString)
  {
    AppMethodBeat.i(117217);
    long l2 = this.mxG.aIa(paramString);
    if (l2 < 0L) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = l2;
      if (bool)
      {
        l1 = l2;
        if (!w.sz(paramString))
        {
          af localaf = new af(paramString);
          localaf.setType(2);
          this.mxG.af(localaf);
          l1 = this.mxG.aIa(paramString);
        }
      }
      if (!b.eES()) {
        ad.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", new Object[] { paramString, Long.valueOf(l1), Boolean.valueOf(bool), bt.eGN() });
      }
      AppMethodBeat.o(117217);
      return l1;
    }
  }
  
  private static String aIU(String paramString)
  {
    AppMethodBeat.i(117235);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117235);
      return null;
    }
    try
    {
      paramString = bw.K(paramString, "msgsource");
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
      ad.e("MicroMsg.MsgInfoStorage", "exception:%s", new Object[] { bt.m(paramString) });
      ad.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(117235);
    }
    return null;
  }
  
  private String aIV(String paramString)
  {
    AppMethodBeat.i(117277);
    if ((paramString == null) || (!paramString.equals("message")))
    {
      AppMethodBeat.o(117277);
      return "";
    }
    if (this.FAq)
    {
      AppMethodBeat.o(117277);
      return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
    }
    AppMethodBeat.o(117277);
    return "INDEXED BY messageCreateTaklerTypeTimeIndex";
  }
  
  private h.b aIW(String paramString)
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
      if (i >= this.FAs.size()) {
        break label98;
      }
      if (paramString.equals(((h.b)this.FAs.get(i)).name))
      {
        paramString = (h.b)this.FAs.get(i);
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
  
  private String aIX(String paramString)
  {
    AppMethodBeat.i(117285);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Iterator localIterator = this.FAr.iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = ((e)localIterator.next()).aHk(paramString);
      } while (bt.isNullOrNil(str));
      AppMethodBeat.o(117285);
      return str;
    }
    AppMethodBeat.o(117285);
    return "message";
  }
  
  private h.b aIY(String paramString)
  {
    AppMethodBeat.i(117286);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = aIW(aIX(paramString));
      AppMethodBeat.o(117286);
      return paramString;
    }
  }
  
  private static void aJ(bl parambl)
  {
    AppMethodBeat.i(117236);
    if ((parambl == null) || (!parambl.cxB()))
    {
      AppMethodBeat.o(117236);
      return;
    }
    try
    {
      String str = parambl.field_content;
      int i = str.indexOf("<msg>");
      Object localObject = str;
      if (i > 0)
      {
        localObject = str;
        if (i < str.length()) {
          localObject = str.substring(i).trim();
        }
      }
      localObject = bw.K((String)localObject, "msg");
      if ((localObject != null) && (((Map)localObject).size() > 0)) {
        parambl.oa(bj.bA((Map)localObject));
      }
      AppMethodBeat.o(117236);
      return;
    }
    catch (Exception parambl)
    {
      ad.e("MicroMsg.MsgInfoStorage", parambl.getMessage());
      AppMethodBeat.o(117236);
    }
  }
  
  private void b(h.b paramb)
  {
    AppMethodBeat.i(117205);
    Cursor localCursor = this.gPa.a("select max(msgid) from " + paramb.name, null, 2);
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      ad.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d tableName: %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramb.hgs), paramb.name });
      if (i >= paramb.hgs) {
        paramb.Gv(i);
      }
    }
    localCursor.close();
    ad.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + paramb.hgs);
    AppMethodBeat.o(117205);
  }
  
  private void eMM()
  {
    AppMethodBeat.i(117200);
    long l1 = System.currentTimeMillis();
    long l2 = this.gPa.rb(Thread.currentThread().getId());
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
    if (!this.FAq)
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
      this.gPa.execSQL("message", (String)localArrayList.get(i));
      i += 1;
    }
    ad.i("MicroMsg.MsgInfoStorage", "build new index last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    this.gPa.mX(l2);
    ad.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(117200);
  }
  
  private String wo(long paramLong)
  {
    AppMethodBeat.i(117288);
    if ((paramLong == 0L) || (paramLong == -1L))
    {
      AppMethodBeat.o(117288);
      return null;
    }
    bl.wn(paramLong);
    int i = 0;
    while (i < this.FAs.size())
    {
      if (((h.b)this.FAs.get(i)).rr(paramLong))
      {
        String str = ((h.b)this.FAs.get(i)).name;
        AppMethodBeat.o(117288);
        return str;
      }
      i += 1;
    }
    Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[] { Long.valueOf(paramLong) }), false);
    AppMethodBeat.o(117288);
    return null;
  }
  
  public final Cursor B(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117244);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117244);
      return null;
    }
    String str = agG(paramString);
    paramString = "select * from " + str + " where" + aIS(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.gPa.a(paramString, null, 2);
    AppMethodBeat.o(117244);
    return paramString;
  }
  
  public final Cursor C(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117246);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117246);
      return null;
    }
    String str = agG(paramString);
    paramString = "select * from " + str + " where" + aIS(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.gPa.a(paramString, null, 2);
    AppMethodBeat.o(117246);
    return paramString;
  }
  
  public final int D(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(117279);
    paramString = "SELECT COUNT(*) FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND type = 50 AND createTime >= " + paramLong1 + " AND createTime <= " + paramLong2 + " LIMIT 1";
    paramString = this.gPa.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117279);
    return i;
  }
  
  public final int E(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117294);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      ad.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      paramString = "SELECT COUNT(msgId) FROM " + agG(paramString) + " WHERE" + aHn(paramString) + aIS(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      ad.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf(paramString)));
      paramString = this.gPa.a(paramString, null, 2);
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
  
  public final Cursor F(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117297);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime ASC ";
      ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.gPa.a(paramString, null, 0);
      AppMethodBeat.o(117297);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int G(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117300);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ( SELECT * FROM ").append(agG(paramString)).append(" WHERE").append(aIS(paramString));
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
        paramString = this.gPa.a(str, null, 2);
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
  
  public final bl Gu(int paramInt)
  {
    AppMethodBeat.i(117229);
    if (this.FAs == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117229);
      return null;
    }
    bl localbl = new bl();
    long l1 = 0L;
    int i = 0;
    while (i < this.FAs.size())
    {
      long l2 = l1;
      if ((((h.b)this.FAs.get(i)).tyA & paramInt) != 0)
      {
        Object localObject = "select * from " + ((h.b)this.FAs.get(i)).name + "  order by createTime DESC limit 1";
        localObject = this.gPa.a((String)localObject, null, 2);
        l2 = l1;
        if (((Cursor)localObject).moveToFirst())
        {
          long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
          l2 = l1;
          if (l1 < l3)
          {
            localbl.convertFrom((Cursor)localObject);
            l2 = l3;
          }
        }
        ((Cursor)localObject).close();
      }
      i += 1;
      l1 = l2;
    }
    AppMethodBeat.o(117229);
    return localbl;
  }
  
  public final int H(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117302);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT COUNT(*) FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1;
      paramString = this.gPa.a(paramString, null, 2);
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
  
  public final Cursor I(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117303);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.gPa.a(paramString, null, 0);
      AppMethodBeat.o(117303);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  /* Error */
  public final List<bl> J(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 735
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 6
    //   9: new 534	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 535	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: getfield 145	com/tencent/mm/storage/bm:gPa	Lcom/tencent/mm/storagebase/h;
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 274	com/tencent/mm/storage/bm:agG	(Ljava/lang/String;)Ljava/lang/String;
    //   27: aconst_null
    //   28: new 63	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 736	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 625	com/tencent/mm/storage/bm:aIS	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 738
    //   46: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: iconst_2
    //   53: anewarray 61	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: lload_2
    //   59: invokestatic 693	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: lload 4
    //   67: invokestatic 693	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   70: aastore
    //   71: aconst_null
    //   72: aconst_null
    //   73: ldc_w 740
    //   76: iconst_2
    //   77: invokevirtual 743	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   80: astore_1
    //   81: aload_1
    //   82: astore 6
    //   84: aload 6
    //   86: astore_1
    //   87: aload 6
    //   89: invokeinterface 746 1 0
    //   94: ifeq +86 -> 180
    //   97: aload 6
    //   99: astore_1
    //   100: new 444	com/tencent/mm/storage/bl
    //   103: dup
    //   104: invokespecial 707	com/tencent/mm/storage/bl:<init>	()V
    //   107: astore 8
    //   109: aload 6
    //   111: astore_1
    //   112: aload 8
    //   114: aload 6
    //   116: invokevirtual 726	com/tencent/mm/storage/bl:convertFrom	(Landroid/database/Cursor;)V
    //   119: aload 6
    //   121: astore_1
    //   122: aload 7
    //   124: aload 8
    //   126: invokevirtual 749	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: goto -46 -> 84
    //   133: astore 7
    //   135: aload 6
    //   137: astore_1
    //   138: ldc 184
    //   140: aload 7
    //   142: ldc_w 751
    //   145: iconst_1
    //   146: anewarray 188	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload 7
    //   153: invokevirtual 377	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 701	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aload 6
    //   162: ifnull +10 -> 172
    //   165: aload 6
    //   167: invokeinterface 507 1 0
    //   172: ldc_w 735
    //   175: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: aload 6
    //   182: ifnull +10 -> 192
    //   185: aload 6
    //   187: invokeinterface 507 1 0
    //   192: ldc_w 735
    //   195: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 7
    //   200: areturn
    //   201: astore_1
    //   202: aload 6
    //   204: ifnull +10 -> 214
    //   207: aload 6
    //   209: invokeinterface 507 1 0
    //   214: ldc_w 735
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
    //   0	241	0	this	bm
    //   0	241	1	paramString	String
    //   0	241	2	paramLong1	long
    //   0	241	4	paramLong2	long
    //   7	230	6	str	String
    //   16	107	7	localArrayList	ArrayList
    //   133	66	7	localException1	Exception
    //   222	6	7	localObject	Object
    //   233	1	7	localException2	Exception
    //   107	18	8	localbl	bl
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
  
  public final Cursor X(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117304);
    String str = " SELECT * FROM " + agG(paramString1) + " WHERE" + aHn(paramString1) + aIS(paramString1) + "AND content LIKE '" + paramString2 + "%' ORDER BY createTime DESC LIMIT " + paramInt;
    ad.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), str });
    paramString1 = this.gPa.a(str, null, 0);
    AppMethodBeat.o(117304);
    return paramString1;
  }
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117299);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(agG(paramString)).append(" WHERE").append(aIS(paramString));
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
        paramString = this.gPa.a(str, null, 0);
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
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(117296);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = new StringBuilder("SELECT * FROM ").append(agG(paramString)).append(" WHERE").append(aIS(paramString)).append("AND createTime >= ").append(paramLong2).append(" AND createTime <= ").append(paramLong1).append(" AND isSend=");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString = i + " LIMIT 1";
        ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
        paramString = this.gPa.a(paramString, null, 0);
        AppMethodBeat.o(117296);
        return paramString;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void a(long paramLong, bl parambl)
  {
    AppMethodBeat.i(117258);
    if (parambl.eLV())
    {
      String str = aIU(parambl.esh);
      if (w.tj(str))
      {
        ad.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
        parambl.nY("notifymessage");
      }
    }
    aJ(parambl);
    if (this.gPa.update(wo(paramLong), parambl.convertTo(), "msgId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new h.c(parambl.field_talker, "update", parambl));
      AppMethodBeat.o(117258);
      return;
    }
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 244L, 1L, false);
    AppMethodBeat.o(117258);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(117192);
    this.Feu.remove(parama);
    AppMethodBeat.o(117192);
  }
  
  public final void a(h.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(117191);
    this.Feu.a(parama, paramLooper);
    AppMethodBeat.o(117191);
  }
  
  public final void a(h.b paramb)
  {
    AppMethodBeat.i(117203);
    synchronized (this.FAs)
    {
      this.FAs.add(paramb);
      b(paramb);
      AppMethodBeat.o(117203);
      return;
    }
  }
  
  public final void a(h.c paramc)
  {
    AppMethodBeat.i(117190);
    if (this.Feu.dR(paramc)) {
      this.Feu.doNotify();
    }
    AppMethodBeat.o(117190);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(117189);
    if (!this.FAr.contains(parame))
    {
      ad.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", new Object[] { parame });
      this.FAr.add(parame);
    }
    AppMethodBeat.o(117189);
  }
  
  public final void aC(String paramString, long paramLong)
  {
    AppMethodBeat.i(117199);
    h.b localb = aIY(paramString);
    long l = localb.hgs;
    Random localRandom = new Random();
    this.gPa.execSQL("message", "BEGIN;");
    bl localbl = new bl(paramString);
    int i = 0;
    while (i < paramLong)
    {
      localbl.kY(System.currentTimeMillis());
      localbl.setType(1);
      localbl.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bt.eGM());
      localbl.setMsgId(l);
      localbl.setStatus(localRandom.nextInt(4));
      localbl.jV(localRandom.nextInt(1));
      l += 1L;
      localb.hgs += 1L;
      localbl.kX(System.currentTimeMillis() + bt.eGM());
      this.gPa.execSQL("message", "INSERT INTO " + agG(localbl.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + localbl.field_msgId + "," + localbl.field_msgSvrId + "," + localbl.getType() + "," + localbl.field_status + "," + localbl.field_createTime + ",'" + localbl.field_talker + "','" + localbl.field_content + "'," + aIT(paramString) + ");");
      if (i % 10000 == 0)
      {
        this.gPa.execSQL("message", "COMMIT;");
        this.gPa.execSQL("message", "BEGIN;");
      }
      i += 1;
    }
    this.gPa.execSQL("message", "COMMIT;");
    this.mxI.aIo(paramString);
    localbl.setMsgId(1L + l);
    an(localbl);
    AppMethodBeat.o(117199);
  }
  
  public final bl aD(String paramString, long paramLong)
  {
    AppMethodBeat.i(117208);
    bl localbl = new bl();
    paramString = this.gPa.a(agG(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbl.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117208);
    return localbl;
  }
  
  public final bl aE(String paramString, long paramLong)
  {
    AppMethodBeat.i(117209);
    bl localbl = new bl();
    paramString = this.gPa.a(agG(paramString), null, aIS(paramString) + " AND msgSeq=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbl.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117209);
    return localbl;
  }
  
  public final bl aF(String paramString, long paramLong)
  {
    AppMethodBeat.i(117210);
    bl localbl = new bl();
    paramString = this.gPa.a(agG(paramString), null, "createTime=? AND" + aIS(paramString), new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbl.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117210);
    return localbl;
  }
  
  public final List<bl> aG(String paramString, long paramLong)
  {
    AppMethodBeat.i(117212);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + agG(paramString) + " Where " + aIS(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11";
    paramString = this.gPa.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bl localbl = new bl();
      localbl.convertFrom(paramString);
      localArrayList.add(localbl);
    }
    paramString.close();
    AppMethodBeat.o(117212);
    return localArrayList;
  }
  
  public final List<bl> aH(String paramString, long paramLong)
  {
    AppMethodBeat.i(117213);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + agG(paramString) + " Where " + aIS(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11;";
    paramString = this.gPa.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bl localbl = new bl();
      localbl.convertFrom(paramString);
      localArrayList.add(localbl);
    }
    paramString.close();
    AppMethodBeat.o(117213);
    return localArrayList;
  }
  
  public final bl aI(String paramString, long paramLong)
  {
    AppMethodBeat.i(117214);
    bl localbl = new bl();
    paramString = "Select * From " + agG(paramString) + " Where " + aIS(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
    paramString = this.gPa.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbl.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117214);
    return localbl;
  }
  
  public final bl aJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(117215);
    bl localbl = new bl();
    paramString = "Select * From " + agG(paramString) + " Where " + aIS(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
    paramString = this.gPa.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbl.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117215);
    return localbl;
  }
  
  public final boolean aK(String paramString, long paramLong)
  {
    AppMethodBeat.i(117220);
    if (aF(paramString, paramLong).field_msgId > 0L)
    {
      AppMethodBeat.o(117220);
      return true;
    }
    AppMethodBeat.o(117220);
    return false;
  }
  
  public final bl aL(String paramString, long paramLong)
  {
    AppMethodBeat.i(117224);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117224);
      return null;
    }
    bl localbl = new bl();
    paramString = "select * from " + agG(paramString) + " where" + aIS(paramString) + "AND msgSeq<" + paramLong + " order by msgSeq DESC limit 1";
    Cursor localCursor = this.gPa.a(paramString, null, 2);
    if (localCursor.moveToFirst()) {
      localbl.convertFrom(localCursor);
    }
    localCursor.close();
    ad.d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117224);
    return localbl;
  }
  
  public final Cursor aM(String paramString, long paramLong)
  {
    AppMethodBeat.i(177113);
    paramString = this.gPa.eOh().rawQueryWithFactory(null, "SELECT * FROM " + paramString + " WHERE createTime < " + paramLong, null, paramString);
    AppMethodBeat.o(177113);
    return paramString;
  }
  
  public final long aN(String paramString, long paramLong)
  {
    AppMethodBeat.i(117241);
    paramString = "select createTime from " + agG(paramString) + " where msgId = " + paramLong;
    paramLong = 0L;
    paramString = this.gPa.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      paramLong = paramString.getLong(0);
    }
    paramString.close();
    AppMethodBeat.o(117241);
    return paramLong;
  }
  
  /* Error */
  public final int aO(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 1027
    //   6: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 135
    //   13: aconst_null
    //   14: invokevirtual 1030	com/tencent/mm/storage/bm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 145	com/tencent/mm/storage/bm:gPa	Lcom/tencent/mm/storagebase/h;
    //   21: invokevirtual 1005	com/tencent/mm/storagebase/h:eOh	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   24: new 63	java/lang/StringBuilder
    //   27: dup
    //   28: ldc_w 1032
    //   31: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 1034
    //   41: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 1038	com/tencent/wcdb/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   50: astore 6
    //   52: aload 6
    //   54: iconst_1
    //   55: lload_2
    //   56: invokevirtual 1044	com/tencent/wcdb/database/SQLiteStatement:bindLong	(IJ)V
    //   59: aload 6
    //   61: invokevirtual 1047	com/tencent/wcdb/database/SQLiteStatement:executeUpdateDelete	()I
    //   64: istore 4
    //   66: iload 4
    //   68: ifle +17 -> 85
    //   71: aload_0
    //   72: ldc_w 1049
    //   75: aload_1
    //   76: invokestatic 668	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokevirtual 671	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 1051	com/tencent/mm/storage/bm:doNotify	(Ljava/lang/String;)V
    //   85: aload 6
    //   87: ifnull +8 -> 95
    //   90: aload 6
    //   92: invokevirtual 1052	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   95: ldc_w 1027
    //   98: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload 4
    //   103: ireturn
    //   104: astore 5
    //   106: ldc_w 1027
    //   109: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload 5
    //   114: athrow
    //   115: astore_1
    //   116: aload 6
    //   118: ifnull +13 -> 131
    //   121: aload 5
    //   123: ifnull +51 -> 174
    //   126: aload 6
    //   128: invokevirtual 1052	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   131: ldc_w 1027
    //   134: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: getstatic 836	com/tencent/mm/plugin/report/e:vIY	Lcom/tencent/mm/plugin/report/e;
    //   143: ldc2_w 837
    //   146: ldc2_w 1053
    //   149: lconst_1
    //   150: iconst_0
    //   151: invokevirtual 844	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   154: ldc_w 1027
    //   157: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: iconst_m1
    //   161: ireturn
    //   162: astore 6
    //   164: aload 5
    //   166: aload 6
    //   168: invokevirtual 1058	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   171: goto -40 -> 131
    //   174: aload 6
    //   176: invokevirtual 1052	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   179: goto -48 -> 131
    //   182: astore_1
    //   183: goto -67 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	bm
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
  
  public final int aP(String paramString, long paramLong)
  {
    AppMethodBeat.i(117253);
    bl localbl = aD(paramString, paramLong);
    this.FAz.m((int)(bt.aGK() / 86400L), localbl.field_msgSvrId, localbl.field_createTime / 1000L);
    int i = this.gPa.delete(agG(paramString), "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      doNotify();
      a(new h.c(paramString, "delete", null, 1, (byte)0));
    }
    for (;;)
    {
      AppMethodBeat.o(117253);
      return i;
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 246L, 1L, false);
    }
  }
  
  public final int aQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(117255);
    String str = aIS(paramString) + " and createTime <= " + paramLong;
    b(agG(paramString), str, null);
    int i = this.gPa.delete(agG(paramString), str, null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.tyH = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117255);
    return i;
  }
  
  public final int aR(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(117281);
    bl localbl = rm(paramLong);
    if (localbl.field_msgId == 0L)
    {
      ad.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117281);
      return 0;
    }
    String str = agG(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " " + aIV(str) + " WHERE " + aHn(paramString) + aIS(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + localbl.field_createTime;
    paramString = this.gPa.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117281);
    return i;
  }
  
  public final String aS(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(117282);
    Object localObject1 = rm(paramLong);
    if (((du)localObject1).field_msgId == 0L)
    {
      ad.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117282);
      return null;
    }
    Object localObject2 = agG(paramString);
    paramString = "EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + (String)localObject2 + " " + aIV((String)localObject2) + " WHERE" + aHn(paramString) + aIS(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + ((du)localObject1).field_createTime;
    localObject2 = this.gPa.a(paramString, null, 0);
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
  
  public final bl aT(String paramString, long paramLong)
  {
    AppMethodBeat.i(117292);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117292);
      return null;
    }
    Object localObject = "select * from message where" + aIS(paramString) + " and msgSeq < " + paramLong + " order by msgSeq DESC LIMIT 1 ";
    ad.i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: ".concat(String.valueOf(localObject)));
    localObject = this.gPa.a((String)localObject, null, 0);
    if (localObject == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117292);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new bl();
      paramString.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(117292);
      return paramString;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117292);
    return null;
  }
  
  public final bl aU(String paramString, long paramLong)
  {
    AppMethodBeat.i(117309);
    ad.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(1) });
    bl localbl = new bl();
    paramString = "SELECT * FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND createTime < " + paramLong + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1";
    ad.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.gPa.a(paramString, null, 0);
    if (paramString == null)
    {
      ad.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(117309);
      return localbl;
    }
    if (paramString.moveToLast())
    {
      localbl.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(117309);
      return localbl;
    }
    paramString.close();
    ad.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117309);
    return localbl;
  }
  
  public final void aa(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(117219);
    long l1 = this.gPa.rb(-1L);
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        long l2 = ((Long)paramArrayList.next()).longValue();
        bl localbl = rm(l2);
        localbl.jC(localbl.esg | 0x20);
        ad.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
        a(l2, localbl);
      }
      this.gPa.mX(l1);
    }
    finally
    {
      this.gPa.mX(l1);
      AppMethodBeat.o(117219);
    }
    AppMethodBeat.o(117219);
  }
  
  public final bl.c agA(String paramString)
  {
    AppMethodBeat.i(117270);
    bl.c localc2 = (bl.c)this.FAt.get(Integer.valueOf(paramString.hashCode()));
    bl.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = bl.c.aIQ(paramString);
      this.FAt.o(Integer.valueOf(paramString.hashCode()), localc1);
    }
    AppMethodBeat.o(117270);
    return localc1;
  }
  
  public final bl.d agB(String paramString)
  {
    AppMethodBeat.i(117271);
    bl.d locald2 = (bl.d)this.FAu.get(Integer.valueOf(paramString.hashCode()));
    bl.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = bl.d.aIR(paramString);
      this.FAu.o(Integer.valueOf(paramString.hashCode()), locald1);
    }
    AppMethodBeat.o(117271);
    return locald1;
  }
  
  public final bl.a agC(String paramString)
  {
    AppMethodBeat.i(117272);
    bl.a locala1 = null;
    if ((!bt.isNullOrNil(paramString)) && (this.FAv != null)) {
      locala1 = (bl.a)this.FAv.get(Integer.valueOf(paramString.hashCode()));
    }
    for (;;)
    {
      bl.a locala2 = locala1;
      if (locala1 == null)
      {
        locala1 = bl.a.aIO(paramString);
        locala2 = locala1;
        if (this.FAv != null)
        {
          this.FAv.o(Integer.valueOf(bt.by(paramString, "").hashCode()), locala1);
          locala2 = locala1;
        }
      }
      AppMethodBeat.o(117272);
      return locala2;
      ad.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", new Object[] { Boolean.valueOf(bt.isNullOrNil(paramString)) });
      ad.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
    }
  }
  
  public final bl.b agD(String paramString)
  {
    AppMethodBeat.i(117273);
    bl.b localb2 = (bl.b)this.FAw.get(Integer.valueOf(paramString.hashCode()));
    bl.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = bl.b.aIP(paramString);
      this.FAw.o(Integer.valueOf(paramString.hashCode()), localb1);
    }
    AppMethodBeat.o(117273);
    return localb1;
  }
  
  public final int agE(String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(117274);
    if (ui(paramString))
    {
      i = this.mxI.aIE(paramString);
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
      i = uh(paramString);
      AppMethodBeat.o(117274);
      return i;
      if (("appbrandmessage".equals(agG(paramString))) || ("appbrandnotifymessage".equals(agG(paramString))))
      {
        paramString = "SELECT COUNT(*) FROM " + agG(paramString) + " WHERE" + aIS(paramString);
        paramString = this.gPa.a(paramString, null, 0);
        if (paramString.moveToLast()) {
          i = paramString.getInt(0);
        }
        paramString.close();
        AppMethodBeat.o(117274);
        return i;
      }
    } while (!"bottlemessage".equals(agG(paramString)));
    paramString = "SELECT COUNT(*) FROM " + agG(paramString) + " WHERE" + aIS(paramString);
    paramString = this.gPa.a(paramString, null, 2);
    i = j;
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117274);
    return i;
  }
  
  public final int agF(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117280);
    if (paramString == null)
    {
      ad.w("MicroMsg.MsgInfoStorage", "getImgVideoMsgCount talker is null!");
      AppMethodBeat.o(117280);
      return 0;
    }
    paramString = "SELECT COUNT(*) FROM " + agG(paramString) + " WHERE " + aHn(paramString) + "talker= '" + bt.aFQ(paramString) + "' AND type IN (3,39,13,43,62,44,268435505,486539313)";
    paramString = this.gPa.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117280);
    return i;
  }
  
  public final String agG(String paramString)
  {
    AppMethodBeat.i(117283);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = aIY(paramString).name;
      AppMethodBeat.o(117283);
      return paramString;
    }
  }
  
  public final long agH(String paramString)
  {
    AppMethodBeat.i(117289);
    Object localObject = "select createTime from message where" + aIS(paramString) + "order by createTime LIMIT 1 OFFSET 0";
    ad.d("MicroMsg.MsgInfoStorage", "get first message create time: ".concat(String.valueOf(localObject)));
    localObject = this.gPa.a((String)localObject, null, 2);
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
  
  public final long agI(String paramString)
  {
    AppMethodBeat.i(117290);
    Object localObject = "select createTime from message where" + aHn(paramString) + aIS(paramString) + "order by createTime DESC LIMIT 1 ";
    ad.d("MicroMsg.MsgInfoStorage", "get last message create time: ".concat(String.valueOf(localObject)));
    localObject = this.gPa.a((String)localObject, null, 2);
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
  
  public final long agJ(String paramString)
  {
    AppMethodBeat.i(117291);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117291);
      return 0L;
    }
    Object localObject = "select msgSeq from message where" + aIS(paramString) + "order by msgSeq DESC LIMIT 1 ";
    ad.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: ".concat(String.valueOf(localObject)));
    localObject = this.gPa.a((String)localObject, null, 2);
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
  
  public final bl agK(String paramString)
  {
    AppMethodBeat.i(117293);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117293);
      return null;
    }
    ad.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", new Object[] { paramString, Boolean.FALSE });
    Object localObject1 = (Long)this.FAy.get(paramString);
    if ((localObject1 != null) && (((Long)localObject1).longValue() > 0L))
    {
      ad.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", new Object[] { Long.valueOf(((Long)localObject1).longValue()) });
      localObject1 = rm(((Long)localObject1).longValue());
      if ((((du)localObject1).field_flag & 0x1) != 0)
      {
        AppMethodBeat.o(117293);
        return localObject1;
      }
      this.FAy.remove(paramString);
      AppMethodBeat.o(117293);
      return null;
    }
    ad.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
    localObject1 = new bl();
    long l = System.currentTimeMillis();
    Object localObject2 = "SELECT * FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ";
    localObject2 = this.gPa.a((String)localObject2, null, 2);
    ad.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(Thread.currentThread().getId()) });
    if (localObject2 == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117293);
      return localObject1;
    }
    if (((Cursor)localObject2).moveToFirst()) {
      ((bl)localObject1).convertFrom((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    this.FAy.o(paramString, Long.valueOf(((du)localObject1).field_msgId));
    AppMethodBeat.o(117293);
    return localObject1;
  }
  
  public final int agL(String paramString)
  {
    AppMethodBeat.i(117307);
    String str = " SELECT COUNT(*) FROM " + agG(paramString) + " WHERE" + aHn(paramString) + aIS(paramString) + "AND isSend=1";
    Cursor localCursor = this.gPa.a(str, null, 2);
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
  public final List<bl> agM(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 1301
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 534	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 535	java/util/ArrayList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 145	com/tencent/mm/storage/bm:gPa	Lcom/tencent/mm/storagebase/h;
    //   20: ldc 71
    //   22: aconst_null
    //   23: ldc_w 1303
    //   26: iconst_2
    //   27: anewarray 61	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: invokestatic 292	com/tencent/mm/sdk/platformtools/bt:aFQ	(Ljava/lang/String;)Ljava/lang/String;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: invokestatic 519	java/lang/System:currentTimeMillis	()J
    //   42: ldc2_w 1304
    //   45: lsub
    //   46: invokestatic 693	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: ldc_w 1307
    //   55: iconst_2
    //   56: invokevirtual 743	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokeinterface 746 1 0
    //   70: ifeq +75 -> 145
    //   73: aload_2
    //   74: astore_1
    //   75: new 444	com/tencent/mm/storage/bl
    //   78: dup
    //   79: invokespecial 707	com/tencent/mm/storage/bl:<init>	()V
    //   82: astore 4
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: aload_2
    //   89: invokevirtual 726	com/tencent/mm/storage/bl:convertFrom	(Landroid/database/Cursor;)V
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: aload 4
    //   97: invokevirtual 749	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto -39 -> 62
    //   104: astore_3
    //   105: aload_2
    //   106: astore_1
    //   107: ldc 184
    //   109: aload_3
    //   110: ldc_w 1309
    //   113: iconst_1
    //   114: anewarray 188	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: invokevirtual 377	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 701	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_2
    //   128: ifnull +9 -> 137
    //   131: aload_2
    //   132: invokeinterface 507 1 0
    //   137: ldc_w 1301
    //   140: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aconst_null
    //   144: areturn
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 507 1 0
    //   155: ldc_w 1301
    //   158: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_3
    //   162: areturn
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +9 -> 174
    //   168: aload_2
    //   169: invokeinterface 507 1 0
    //   174: ldc_w 1301
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
    //   0	196	0	this	bm
    //   0	196	1	paramString	String
    //   1	192	2	str	String
    //   15	80	3	localArrayList	ArrayList
    //   104	58	3	localException1	Exception
    //   182	4	3	localObject	Object
    //   190	1	3	localException2	Exception
    //   82	14	4	localbl	bl
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
  
  public final long agN(String paramString)
  {
    AppMethodBeat.i(117317);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    paramString = aIW(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    long l = paramString.hgs;
    AppMethodBeat.o(117317);
    return l;
  }
  
  public final Cursor agO(String paramString)
  {
    AppMethodBeat.i(117315);
    try
    {
      paramString = this.gPa.a(agG(paramString), null, aIS(paramString) + " AND createTime>=? AND type IN (436207665,419430449)", new String[] { String.valueOf(System.currentTimeMillis() - 86400000L) }, null, null, "createTime ASC", 2);
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
  
  public final void agl(String paramString)
  {
    AppMethodBeat.i(117195);
    ad.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.FAB), Integer.valueOf(super.lockCount()), Integer.valueOf(this.Feu.EYx), Integer.valueOf(this.FAA.size()), this.FAC, Long.valueOf(bt.vM(this.FAD)) });
    if (bt.isNullOrNil(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (this.FAB)
    {
      ad.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", new Object[] { this.FAC, Long.valueOf(bt.vM(this.FAD)) });
      AppMethodBeat.o(117195);
      return;
    }
    this.FAC = paramString;
    this.FAD = bt.eGO();
    this.FAB = true;
    super.lock();
    this.Feu.lock();
    AppMethodBeat.o(117195);
  }
  
  public final void agm(String paramString)
  {
    AppMethodBeat.i(117196);
    ad.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.FAB), Integer.valueOf(super.lockCount()), Integer.valueOf(this.Feu.EYx), Integer.valueOf(this.FAA.size()), this.FAC, Long.valueOf(bt.vM(this.FAD)) });
    if (bt.isNullOrNil(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (!this.FAB)
    {
      ad.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", new Object[] { paramString, bt.eGN() });
      AppMethodBeat.o(117196);
      return;
    }
    if (!paramString.equals(this.FAC))
    {
      ad.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", new Object[] { this.FAC, Long.valueOf(bt.vM(this.FAD)), paramString });
      AppMethodBeat.o(117196);
      return;
    }
    this.FAB = false;
    this.FAD = 0L;
    this.FAC = "";
    paramString = this.FAA.keySet().iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      a((h.c)this.FAA.get(str));
    }
    this.FAA.clear();
    super.unlock();
    this.Feu.unlock();
    doNotify();
    AppMethodBeat.o(117196);
  }
  
  public final void agn(String paramString)
  {
    AppMethodBeat.i(117197);
    if (!this.FAB)
    {
      AppMethodBeat.o(117197);
      return;
    }
    h.c localc = null;
    if (this.FAA.containsKey(paramString)) {
      localc = (h.c)this.FAA.get(paramString);
    }
    if (localc == null)
    {
      ad.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", new Object[] { paramString, bt.eGN() });
      AppMethodBeat.o(117197);
      return;
    }
    if ((localc.tyD != null) && (localc.tyD.equals("insert")) && (localc.qzn > 0))
    {
      ad.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", new Object[] { paramString, Integer.valueOf(localc.qzn) });
      localc.qzn = 0;
    }
    AppMethodBeat.o(117197);
  }
  
  public final Cursor ago(String paramString)
  {
    AppMethodBeat.i(117211);
    com.tencent.mm.storagebase.h localh = this.gPa;
    String str = agG(paramString);
    paramString = aHn(paramString) + aIS(paramString);
    paramString = localh.query(str, new String[] { "createTime", "msgId" }, paramString, null, "createTime", null, "createTime ASC");
    AppMethodBeat.o(117211);
    return paramString;
  }
  
  public final bl agp(String paramString)
  {
    AppMethodBeat.i(117222);
    bl localbl = new bl();
    paramString = this.gPa.a(agG(paramString), null, aIS(paramString), null, null, null, "msgSvrId  DESC limit 1 ", 2);
    if (paramString.moveToFirst()) {
      localbl.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117222);
    return localbl;
  }
  
  public final bl agq(String paramString)
  {
    AppMethodBeat.i(117223);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117223);
      return null;
    }
    bl localbl = new bl();
    paramString = "select * from " + agG(paramString) + " where" + aHn(paramString) + aIS(paramString) + "order by createTime DESC limit 1";
    paramString = this.gPa.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbl.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117223);
    return localbl;
  }
  
  public final bl agr(String paramString)
  {
    AppMethodBeat.i(117226);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117226);
      return null;
    }
    bl localbl = new bl();
    paramString = "select * from " + agG(paramString) + " where" + aIS(paramString) + "and isSend = 0  order by createTime DESC limit 1";
    paramString = this.gPa.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbl.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117226);
    return localbl;
  }
  
  public final bl ags(String paramString)
  {
    AppMethodBeat.i(117230);
    if (this.FAs == null)
    {
      ad.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117230);
      return null;
    }
    bl localbl = new bl();
    long l1 = 0L;
    if (bt.isNullOrNil(paramString)) {}
    for (paramString = "";; paramString = paramString.replaceFirst("and", "where"))
    {
      int i = 0;
      while (i < this.FAs.size())
      {
        long l2 = l1;
        if ((((h.b)this.FAs.get(i)).tyA & 0x8) != 0)
        {
          Object localObject = "select * from " + ((h.b)this.FAs.get(i)).name + paramString + "  order by createTime DESC limit 1";
          localObject = this.gPa.a((String)localObject, null, 2);
          l2 = l1;
          if (((Cursor)localObject).moveToFirst())
          {
            long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
            l2 = l1;
            if (l1 < l3)
            {
              localbl.convertFrom((Cursor)localObject);
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
    return localbl;
  }
  
  public final List<bl> agt(String paramString)
  {
    bl localbl = null;
    AppMethodBeat.i(117240);
    Cursor localCursor = this.gPa.a("select * from ".concat(String.valueOf(paramString)), null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(117240);
      return null;
    }
    paramString = localbl;
    if (localCursor.moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        localbl = new bl();
        localbl.convertFrom(localCursor);
        paramString.add(localbl);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(117240);
    return paramString;
  }
  
  public final Cursor agu(String paramString)
  {
    AppMethodBeat.i(117247);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117247);
      return null;
    }
    Object localObject = agG(paramString);
    paramString = "select * from " + (String)localObject + " " + aIV((String)localObject) + " where" + aIS(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime";
    localObject = this.gPa.a(paramString, null, 0);
    ad.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(117247);
    return localObject;
  }
  
  public final void agv(String paramString)
  {
    AppMethodBeat.i(117252);
    b(paramString, "", null);
    if (this.gPa.execSQL(paramString, "delete from ".concat(String.valueOf(paramString))))
    {
      doNotify("delete_all ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117252);
      return;
    }
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 247L, 1L, false);
    AppMethodBeat.o(117252);
  }
  
  public final int agw(String paramString)
  {
    AppMethodBeat.i(117254);
    ad.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, at.eFU() });
    b(agG(paramString), aIS(paramString), null);
    int i = this.gPa.delete(agG(paramString), aIS(paramString), null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.tyH = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117254);
    return i;
  }
  
  public final int agx(String paramString)
  {
    AppMethodBeat.i(117261);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(4));
    int i = this.gPa.update(agG(paramString), localContentValues, aIS(paramString) + "AND isSend=? AND status!=? ", new String[] { "0", "4" });
    if (i != 0)
    {
      doNotify();
      a(new h.c(paramString, "update", null));
    }
    AppMethodBeat.o(117261);
    return i;
  }
  
  public final Cursor agy(String paramString)
  {
    AppMethodBeat.i(117263);
    paramString = this.gPa.query(agG(paramString), null, aIS(paramString), null, null, null, "createTime ASC ");
    AppMethodBeat.o(117263);
    return paramString;
  }
  
  public final Cursor agz(String paramString)
  {
    AppMethodBeat.i(117267);
    paramString = this.gPa.query(agG(paramString), null, "isSend=? AND" + aIS(paramString) + "AND status!=?", new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117267);
    return paramString;
  }
  
  public final int am(bl parambl)
  {
    int i = 0;
    AppMethodBeat.i(117234);
    if ((parambl == null) || (bt.isNullOrNil(parambl.field_talker)))
    {
      AppMethodBeat.o(117234);
      return 0;
    }
    parambl = "SELECT count(msgId) FROM " + agG(parambl.field_talker) + " WHERE" + aIS(parambl.field_talker) + "AND isSend = 0 AND msgId >= " + parambl.field_msgId + " ORDER BY createTime DESC";
    parambl = this.gPa.a(parambl, null, 2);
    if (parambl.moveToFirst()) {
      i = parambl.getInt(0);
    }
    parambl.close();
    AppMethodBeat.o(117234);
    return i;
  }
  
  public final List<bl> am(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117233);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + agG(paramString) + " WHERE type & 65535 = 49" + " ORDER BY createTime DESC LIMIT " + paramInt1 + " , " + paramInt2;
    ad.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.gPa.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bl localbl = new bl();
      localbl.convertFrom(paramString);
      if (localbl.cxB()) {
        localArrayList.add(localbl);
      }
    }
    paramString.close();
    AppMethodBeat.o(117233);
    return localArrayList;
  }
  
  public final long an(bl parambl)
  {
    AppMethodBeat.i(117237);
    long l = c(parambl, false);
    AppMethodBeat.o(117237);
    return l;
  }
  
  public final Cursor an(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117243);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117243);
      return null;
    }
    String str = agG(paramString);
    paramString = "select * from ( select * from " + str + " where" + aHn(paramString) + aIS(paramString) + " AND type IN (3,39,13,43,62,44,268435505,486539313)  order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = this.gPa.a(paramString, null, 2);
    AppMethodBeat.o(117243);
    return paramString;
  }
  
  public final void ao(bl parambl)
  {
    AppMethodBeat.i(117259);
    if ((parambl == null) || (parambl.field_status == 4))
    {
      AppMethodBeat.o(117259);
      return;
    }
    parambl.setStatus(4);
    String str = wo(parambl.field_msgId);
    if ((str != null) && (str.length() > 0)) {
      if (this.gPa.update(str, parambl.convertTo(), "msgId=?", new String[] { parambl.field_msgId }) != 0)
      {
        doNotify();
        a(new h.c(parambl.field_talker, "update", parambl, -1));
      }
    }
    AppMethodBeat.o(117259);
  }
  
  public final int ap(bl parambl)
  {
    int i = 0;
    AppMethodBeat.i(117262);
    if (parambl != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("content", parambl.field_content);
      localContentValues.put("status", Integer.valueOf(parambl.field_status));
      int j = this.gPa.update(wo(parambl.field_msgId), localContentValues, "msgId=?", new String[] { String.valueOf(parambl.field_msgId) });
      i = j;
      if (j != 0)
      {
        doNotify();
        a(new h.c(parambl.field_talker, "update", parambl));
        i = j;
      }
    }
    AppMethodBeat.o(117262);
    return i;
  }
  
  public final void asf()
  {
    AppMethodBeat.i(117227);
    Cursor localCursor = this.gPa.a("select * from MsgInfo wherecontent like '%aaaabbbbbfdf%'", null, 2);
    localCursor.getCount();
    SystemClock.sleep(5000L);
    localCursor.close();
    AppMethodBeat.o(117227);
  }
  
  public final Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117301);
    if (paramLong2 == 0L)
    {
      paramString = "SELECT * FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND createTime > " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.gPa.a(paramString, null, 0);
      AppMethodBeat.o(117301);
      return paramString;
    }
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.gPa.a(paramString, null, 0);
      AppMethodBeat.o(117301);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void b(long paramLong, bl parambl)
  {
    AppMethodBeat.i(117260);
    if (bt.nullAsNil(parambl.field_talker).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("no talker set when update by svrid", bool);
      if (parambl.eLV())
      {
        String str = aIU(parambl.esh);
        if (w.tj(str))
        {
          ad.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
          parambl.nY("notifymessage");
        }
      }
      aJ(parambl);
      if (paramLong != 0L) {
        break;
      }
      ad.w("MicroMsg.MsgInfoStorage", "invalid svr id %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(117260);
      return;
    }
    if (this.gPa.update(agG(parambl.field_talker), parambl.convertTo(), "msgSvrId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new h.c(parambl.field_talker, "update", parambl));
      AppMethodBeat.o(117260);
      return;
    }
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 243L, 1L, false);
    AppMethodBeat.o(117260);
  }
  
  public final void b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(117250);
    long l = bt.aGK();
    Object localObject = "SELECT msgSvrId,createTime FROM " + paramString1 + " WHERE createTime > " + (l - 172800L) * 1000L;
    paramString1 = (String)localObject;
    if (!bt.isNullOrNil(paramString2)) {
      paramString1 = (String)localObject + " AND " + paramString2;
    }
    paramString2 = new ArrayList();
    localObject = new ArrayList();
    paramString1 = this.gPa.a(paramString1, paramArrayOfString, 2);
    if (paramString1.moveToFirst())
    {
      do
      {
        int i = paramString1.getInt(0);
        l = paramString1.getLong(1) / 1000L;
        paramString2.add(Integer.valueOf(i));
        ((List)localObject).add(Long.valueOf(l));
      } while (paramString1.moveToNext());
      this.FAz.E(paramString2, (List)localObject);
    }
    paramString1.close();
    AppMethodBeat.o(117250);
  }
  
  public final long c(bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(117238);
    if ((parambl == null) || (bt.isNullOrNil(parambl.field_talker)))
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 250L, 1L, false);
      if (parambl == null) {}
      for (localObject1 = "-1";; localObject1 = parambl.field_talker)
      {
        ad.e("MicroMsg.MsgInfoStorage", "Error insert message msg:%s talker:%s", new Object[] { parambl, localObject1 });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    ad.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", new Object[] { Boolean.valueOf(this.FAB), Long.valueOf(parambl.field_msgSeq) });
    Object localObject1 = null;
    Object localObject2 = bi.ul(parambl.esh);
    if (localObject2 != null) {
      localObject1 = ((bi.b)localObject2).gNU;
    }
    if (w.tj((String)localObject1))
    {
      ad.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { localObject1 });
      if (parambl.getType() == 436207665)
      {
        ad.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
        AppMethodBeat.o(117238);
        return -1L;
      }
      parambl.nY("notifymessage");
    }
    localObject1 = aIY(parambl.field_talker);
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 249L, 1L, false);
      ad.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", new Object[] { parambl.field_talker });
      AppMethodBeat.o(117238);
      return -1L;
    }
    ((h.b)localObject1).aq(parambl);
    Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[] { Long.valueOf(parambl.field_msgId), localObject1, wo(parambl.field_msgId) }), ((h.b)localObject1).name.equals(wo(parambl.field_msgId)));
    if (parambl.field_msgSvrId != 0L) {
      parambl.SN();
    }
    Iterator localIterator = this.FAr.iterator();
    while (localIterator.hasNext()) {
      if (!((e)localIterator.next()).a(parambl, (bi.b)localObject2))
      {
        ad.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", new Object[] { parambl.field_talker, parambl.esh });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    aJ(parambl);
    if (((h.b)localObject1).name.equals("message")) {
      parambl.kf((int)aIT(parambl.field_talker));
    }
    localObject2 = parambl.convertTo();
    if (paramBoolean) {}
    for (long l = this.gPa.eOg().insertOrThrow(((h.b)localObject1).name, "msgId", (ContentValues)localObject2);; l = this.gPa.a(((h.b)localObject1).name, "msgId", (ContentValues)localObject2))
    {
      ad.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", new Object[] { Long.valueOf(l), parambl.field_talker, Long.valueOf(parambl.field_msgId), Integer.valueOf(parambl.getType()), Integer.valueOf(parambl.field_status), Long.valueOf(parambl.field_msgSvrId), Long.valueOf(parambl.field_msgSeq), Integer.valueOf(parambl.field_flag), Long.valueOf(parambl.field_createTime), Integer.valueOf(parambl.field_isSend), this.FAC, Long.valueOf(bt.vM(this.FAD)) });
      if (l != -1L) {
        break;
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 248L, 1L, false);
      ad.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", new Object[] { Long.valueOf(parambl.field_msgSvrId), Long.valueOf(l) });
      AppMethodBeat.o(117238);
      return -1L;
    }
    if ((this.FAB) && (bt.vM(this.FAD) > 2000L) && (parambl.field_isSend == 1) && (parambl.field_status == 1))
    {
      ad.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", new Object[] { this.FAC, Long.valueOf(bt.vM(this.FAD)) });
      agm(this.FAC);
    }
    if (this.FAB)
    {
      localObject1 = null;
      if (e.Fef != null) {
        localObject1 = e.Fef.Z(parambl);
      }
      if (!bt.isNullOrNil((String)localObject1)) {
        break label976;
      }
    }
    label976:
    for (localObject2 = parambl.field_talker;; localObject2 = localObject1)
    {
      localObject1 = null;
      if (this.FAA.containsKey(localObject2)) {
        localObject1 = (h.c)this.FAA.get(localObject2);
      }
      if (localObject1 == null)
      {
        localObject1 = new h.c(parambl.field_talker, "insert", parambl);
        if (h.c.ar(parambl)) {
          ((h.c)localObject1).qzn += 1;
        }
        ((h.c)localObject1).tyF += 1;
        this.FAA.put(localObject2, localObject1);
      }
      for (;;)
      {
        l = parambl.field_msgId;
        AppMethodBeat.o(117238);
        return l;
        ((h.c)localObject1).tyE.add(parambl);
        break;
        localObject1 = new h.c(parambl.field_talker, "insert", parambl);
        if (h.c.ar(parambl)) {
          ((h.c)localObject1).qzn = 1;
        }
        ((h.c)localObject1).tyF = 1;
        doNotify();
        a((h.c)localObject1);
      }
    }
  }
  
  public final Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117298);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM (SELECT * FROM " + agG(paramString) + " WHERE" + aHn(paramString) + aIS(paramString) + " AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime DESC LIMIT " + paramInt + " ) ORDER BY createTime ASC";
      ad.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.gPa.a(paramString, null, 0);
      AppMethodBeat.o(117298);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void c(com.tencent.mm.storagebase.h paramh, String paramString)
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
    Cursor localCursor = paramh.a("PRAGMA table_info( " + paramString + " )", null, 2);
    int i6 = localCursor.getColumnIndex("name");
    while (localCursor.moveToNext()) {
      if (i6 >= 0)
      {
        String str = localCursor.getString(i6);
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
        }
      }
    }
    localCursor.close();
    long l = paramh.rb(Thread.currentThread().getId());
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
    paramh.mX(l);
    AppMethodBeat.o(117198);
  }
  
  public final void cOQ()
  {
    AppMethodBeat.i(117201);
    g.afC();
    g.afB().afk().set(348167, Integer.valueOf(1));
    AppMethodBeat.o(117201);
  }
  
  public final void cOR()
  {
    AppMethodBeat.i(117204);
    int i = 0;
    while (i < this.FAs.size())
    {
      b((h.b)this.FAs.get(i));
      i += 1;
    }
    AppMethodBeat.o(117204);
  }
  
  public final void cOS()
  {
    AppMethodBeat.i(117206);
    if (!this.FAq)
    {
      AppMethodBeat.o(117206);
      return;
    }
    Object localObject = "select count(*) from " + "message" + " where talkerId ISNULL ";
    localObject = this.gPa.a((String)localObject, null, 2);
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
        boolean bool = this.gPa.execSQL("message", (String)localObject);
        ad.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
        if ((bool) && (this.FAq))
        {
          this.gPa.execSQL("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
          this.gPa.execSQL("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
          this.gPa.execSQL("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
          this.gPa.execSQL("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
          this.gPa.execSQL("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
          ad.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
        }
      }
      AppMethodBeat.o(117206);
      return;
    }
  }
  
  public final ArrayList<bl> cOT()
  {
    AppMethodBeat.i(117218);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.gPa.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[] { String.valueOf(System.currentTimeMillis() - 172800000L), "5", "1" }, null, null, "createTime ASC", 2);
    label149:
    while (localCursor.moveToNext())
    {
      bl localbl = new bl();
      localbl.convertFrom(localCursor);
      if (!localbl.eMr()) {}
      for (int i = 1;; i = 0)
      {
        if (((i & 0x1) == 0) || (af.aHE(localbl.field_talker)) || (af.aHG(localbl.field_talker)) || (af.st(localbl.field_talker))) {
          break label149;
        }
        localArrayList.add(localbl);
        break;
      }
    }
    localCursor.close();
    AppMethodBeat.o(117218);
    return localArrayList;
  }
  
  public final List<bl> cOU()
  {
    AppMethodBeat.i(117231);
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    Object localObject1;
    int i;
    if (this.FAs != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject1 = new ArrayList();
      i = 0;
    }
    Object localObject2;
    for (;;)
    {
      if (i >= this.FAs.size()) {
        break label207;
      }
      localObject2 = this.gPa.a(((h.b)this.FAs.get(i)).name, null, "status=1 and isSend=1", null, null, null, "createTime", 2);
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label193;
        }
        bl localbl = new bl();
        localbl.convertFrom((Cursor)localObject2);
        if ((localbl.isText()) || (localbl.eLX()) || (localbl.cxD()) || (localbl.eMf()))
        {
          if (bi.asg() - localbl.field_createTime > 86400000L)
          {
            ((List)localObject1).add(localbl);
            continue;
            bool = false;
            break;
          }
          localArrayList.add(localbl);
        }
      }
      label193:
      ((Cursor)localObject2).close();
      i += 1;
    }
    label207:
    if (((List)localObject1).size() > 0)
    {
      long l = this.gPa.rb(-1L);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bl)((Iterator)localObject1).next();
        ad.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", new Object[] { Long.valueOf(((du)localObject2).field_msgId), Long.valueOf(((du)localObject2).field_createTime), ((du)localObject2).field_talker, bt.aGs(((du)localObject2).field_content) });
        ((bl)localObject2).setStatus(5);
        a(((du)localObject2).field_msgId, (bl)localObject2);
      }
      this.gPa.mX(l);
    }
    AppMethodBeat.o(117231);
    return localArrayList;
  }
  
  public final Cursor cOV()
  {
    AppMethodBeat.i(117269);
    Cursor localCursor = this.gPa.query("message", new String[] { "talker", "count(*) as unReadCount" }, "isSend=? AND status!=?", new String[] { "0", "4" }, "talker", null, null);
    AppMethodBeat.o(117269);
    return localCursor;
  }
  
  public final String cOW()
  {
    return "type IN (3,39,13,43,62,44,268435505,486539313)";
  }
  
  public final String cOX()
  {
    return "type IN (3,39,13,43,62,44,49,268435505)";
  }
  
  public final int cOY()
  {
    AppMethodBeat.i(117295);
    ad.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf("SELECT COUNT(msgId) FROM message")));
    Cursor localCursor = this.gPa.a("SELECT COUNT(msgId) FROM message", null, 2);
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
  public final List<bl> cOZ()
  {
    // Byte code:
    //   0: ldc_w 1795
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 534	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 535	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 145	com/tencent/mm/storage/bm:gPa	Lcom/tencent/mm/storagebase/h;
    //   18: ldc 71
    //   20: aconst_null
    //   21: ldc_w 1797
    //   24: iconst_1
    //   25: anewarray 61	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: invokestatic 519	java/lang/System:currentTimeMillis	()J
    //   33: ldc2_w 1304
    //   36: lsub
    //   37: invokestatic 693	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: ldc_w 1307
    //   46: iconst_2
    //   47: invokevirtual 743	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 746 1 0
    //   59: ifeq +75 -> 134
    //   62: aload_2
    //   63: astore_1
    //   64: new 444	com/tencent/mm/storage/bl
    //   67: dup
    //   68: invokespecial 707	com/tencent/mm/storage/bl:<init>	()V
    //   71: astore 4
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: aload_2
    //   78: invokevirtual 726	com/tencent/mm/storage/bl:convertFrom	(Landroid/database/Cursor;)V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload 4
    //   86: invokevirtual 749	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -39 -> 51
    //   93: astore_3
    //   94: aload_2
    //   95: astore_1
    //   96: ldc 184
    //   98: aload_3
    //   99: ldc_w 1309
    //   102: iconst_1
    //   103: anewarray 188	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_3
    //   109: invokevirtual 377	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 701	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_2
    //   117: ifnull +9 -> 126
    //   120: aload_2
    //   121: invokeinterface 507 1 0
    //   126: ldc_w 1795
    //   129: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aconst_null
    //   133: areturn
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 507 1 0
    //   144: ldc_w 1795
    //   147: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_3
    //   151: areturn
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +9 -> 165
    //   159: aload_1
    //   160: invokeinterface 507 1 0
    //   165: ldc_w 1795
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
    //   0	183	0	this	bm
    //   52	108	1	localCursor1	Cursor
    //   50	89	2	localCursor2	Cursor
    //   152	20	2	localObject1	Object
    //   173	1	2	localObject2	Object
    //   179	1	2	localObject3	Object
    //   13	71	3	localArrayList	ArrayList
    //   93	58	3	localException1	Exception
    //   177	1	3	localException2	Exception
    //   71	14	4	localbl	bl
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
  
  public final List<bl> dE(String paramString, int paramInt)
  {
    AppMethodBeat.i(117228);
    ArrayList localArrayList = new ArrayList();
    if (this.FAs != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND status = 3 AND type <> 10000 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.gPa.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bl localbl = new bl();
        localbl.convertFrom(paramString);
        localArrayList.add(localbl);
      }
    }
    paramString.close();
    AppMethodBeat.o(117228);
    return localArrayList;
  }
  
  public final List<bl> dF(String paramString, int paramInt)
  {
    AppMethodBeat.i(117232);
    ArrayList localArrayList = new ArrayList();
    if (this.FAs != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.gPa.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bl localbl = new bl();
        localbl.convertFrom(paramString);
        if (localbl.isText()) {
          localArrayList.add(localbl);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(117232);
    return localArrayList;
  }
  
  public final Cursor dG(String paramString, int paramInt)
  {
    AppMethodBeat.i(117248);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117248);
      return null;
    }
    String str = agG(paramString);
    paramString = "select * from " + str + " where" + aHn(paramString) + aIS(paramString) + " AND type & 65535 = 49" + "  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.gPa.a(paramString, null, 0);
    AppMethodBeat.o(117248);
    return paramString;
  }
  
  public final Cursor dH(String paramString, int paramInt)
  {
    AppMethodBeat.i(117249);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117249);
      return null;
    }
    Object localObject = agG(paramString);
    paramString = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend,imgPath from ").append((String)localObject).append(" where").append(aHn(paramString)).append(aIS(paramString)).append(" AND ");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" (type = 49");
    ((StringBuilder)localObject).append(" or type = 587202609");
    ((StringBuilder)localObject).append(" or type = 553648177) ");
    paramString = ((StringBuilder)localObject).toString() + " order by createTime DESC limit 100 OFFSET " + paramInt;
    paramString = this.gPa.a(paramString, null, 0);
    AppMethodBeat.o(117249);
    return paramString;
  }
  
  public final Cursor dI(String paramString, int paramInt)
  {
    AppMethodBeat.i(117245);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117245);
      return null;
    }
    String str = agG(paramString);
    paramString = "select * from ( select * from " + str + " where" + aIS(paramString) + " AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime DESC limit 200 OFFSET " + paramInt + ") order by createTime ASC ";
    paramString = this.gPa.a(paramString, null, 2);
    AppMethodBeat.o(117245);
    return paramString;
  }
  
  public final int dJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(117256);
    ad.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", new Object[] { paramString, Integer.valueOf(paramInt), at.eFU() });
    bl localbl = aD(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbl.field_talker));
    b(agG(paramString), "createTime<=? AND" + aIS(paramString), new String[] { localbl.field_createTime });
    paramInt = this.gPa.delete(agG(paramString), "createTime<=? AND" + aIS(paramString), new String[] { localbl.field_createTime });
    if (paramInt != 0)
    {
      doNotify();
      a(new h.c(paramString, "delete", null, paramInt, (byte)0));
    }
    AppMethodBeat.o(117256);
    return paramInt;
  }
  
  public final Cursor dK(String paramString, int paramInt)
  {
    AppMethodBeat.i(117257);
    bl localbl = aD(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbl.field_talker));
    paramString = this.gPa.query(agG(paramString), null, "createTime<=? AND" + aIS(paramString), new String[] { localbl.field_createTime }, null, null, null);
    AppMethodBeat.o(117257);
    return paramString;
  }
  
  public final Cursor dL(String paramString, int paramInt)
  {
    AppMethodBeat.i(117268);
    paramString = this.gPa.query(agG(paramString), null, "isSend=? AND" + aIS(paramString) + "AND status!=?  order by msgId DESC limit " + paramInt, new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117268);
    return paramString;
  }
  
  public final int dM(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117278);
    paramString = "SELECT COUNT(*) FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND type = " + paramInt;
    paramString = this.gPa.a(paramString, null, 2);
    paramInt = i;
    if (paramString.moveToFirst()) {
      paramInt = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117278);
    return paramInt;
  }
  
  public final Cursor dN(String paramString, int paramInt)
  {
    AppMethodBeat.i(117305);
    String str = " SELECT * FROM " + agG(paramString) + " WHERE" + aHn(paramString) + aIS(paramString) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + paramInt;
    ad.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    paramString = this.gPa.a(str, null, 0);
    AppMethodBeat.o(117305);
    return paramString;
  }
  
  public final bl[] dO(String paramString, int paramInt)
  {
    AppMethodBeat.i(117311);
    if ((paramString == null) || (paramString.length() == 0) || (paramInt <= 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + paramString + ", limit = " + paramInt);
      AppMethodBeat.o(117311);
      return null;
    }
    Object localObject = "select * from " + agG(paramString) + " where" + aIS(paramString) + "order by createTime DESC limit " + paramInt;
    localObject = this.gPa.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        bl localbl = new bl();
        localbl.convertFrom((Cursor)localObject);
        localArrayList.add(localbl);
      } while (((Cursor)localObject).moveToNext());
      ((Cursor)localObject).close();
      ad.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + paramString + ", limit = " + paramInt + ", count = " + localArrayList.size());
      Collections.reverse(localArrayList);
      paramString = (bl[])localArrayList.toArray(new bl[localArrayList.size()]);
      AppMethodBeat.o(117311);
      return paramString;
    }
    ad.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
    ((Cursor)localObject).close();
    AppMethodBeat.o(117311);
    return null;
  }
  
  public final Cursor dP(String paramString, int paramInt)
  {
    AppMethodBeat.i(117319);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117319);
      return null;
    }
    String str = agG(paramString);
    paramString = "select * from " + str + " where" + aHn(paramString) + aIS(paramString) + " AND type IN (436207665,419430449)  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.gPa.a(paramString, null, 0);
    AppMethodBeat.o(117319);
    return paramString;
  }
  
  public final int f(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117221);
    String str = "SELECT * FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime ASC LIMIT -1 OFFSET " + paramInt;
    Cursor localCursor = this.gPa.a(str, null, 0);
    paramInt = localCursor.getCount();
    localCursor.close();
    ad.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + paramString + " time:" + paramLong + " count " + paramInt + " [" + str + "]");
    AppMethodBeat.o(117221);
    return paramInt;
  }
  
  public final long g(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117308);
    ad.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ad.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117308);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + agG(paramString) + " WHERE" + aHn(paramString) + aIS(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime DESC  LIMIT " + paramInt;
    ad.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.gPa.a(paramString, null, 0);
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
  
  public final List<bl> g(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(117242);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(117242);
      return null;
    }
    paramLong = aN(paramString, paramLong);
    if (paramLong == 0L)
    {
      ad.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(117242);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (paramString = "select * from " + agG(paramString) + " where" + aHn(paramString) + aIS(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime > " + paramLong + " order by createTime ASC limit 10";; paramString = "select * from " + agG(paramString) + " where" + aHn(paramString) + aIS(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + paramLong + " order by createTime DESC limit 10")
    {
      paramString = this.gPa.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bl localbl = new bl();
        localbl.convertFrom(paramString);
        localArrayList.add(localbl);
      }
    }
    if (!paramBoolean) {
      Collections.reverse(localArrayList);
    }
    paramString.close();
    AppMethodBeat.o(117242);
    return localArrayList;
  }
  
  public final com.tencent.mm.storagebase.h getDB()
  {
    return this.gPa;
  }
  
  public final long h(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117310);
    ad.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ad.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117310);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + agG(paramString) + " WHERE" + aIS(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC  LIMIT " + paramInt;
    ad.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.gPa.a(paramString, null, 0);
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
  
  public final bl hn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117225);
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", new Object[] { paramString1 });
      AppMethodBeat.o(117225);
      return null;
    }
    bl localbl = new bl();
    paramString2 = "select * from " + agG(paramString1) + " where" + aIS(paramString1) + paramString2 + " order by createTime DESC limit 1";
    paramString2 = this.gPa.a(paramString2, null, 2);
    if (paramString2.moveToFirst()) {
      localbl.convertFrom(paramString2);
    }
    paramString2.close();
    ad.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", new Object[] { paramString1, Long.valueOf(localbl.field_msgId) });
    AppMethodBeat.o(117225);
    return localbl;
  }
  
  public final Cursor ho(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117265);
    paramString1 = "SELECT * FROM " + agG(paramString1) + " WHERE" + aIS(paramString1) + "AND content LIKE '%" + paramString2 + "%' AND type = 1";
    paramString1 = paramString1 + " ORDER BY createTime DESC";
    paramString1 = this.gPa.a(paramString1, null, 0);
    AppMethodBeat.o(117265);
    return paramString1;
  }
  
  public final int hp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117306);
    String str = " SELECT COUNT(*) FROM " + agG(paramString1) + " WHERE" + aHn(paramString1) + aIS(paramString1) + "AND content LIKE '" + paramString2 + "%' ";
    Cursor localCursor = this.gPa.a(str, null, 2);
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
  
  public final LinkedList<bl> hq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117312);
    paramString1 = this.gPa.a(agG(paramString1), null, "talker=? AND bizClientMsgId=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
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
        bl localbl = new bl();
        localbl.convertFrom(paramString1);
        paramString2.add(localbl);
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
  
  public final Cursor i(String paramString, long paramLong, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(117318);
    try
    {
      paramString = "select * from " + paramString + " where " + "type IN (3,39,13,43,62,44,49,268435505,34)" + " AND msgId >= " + paramLong + "  order by msgId ASC  limit " + paramInt;
      paramString = this.gPa.a(paramString, null, 0);
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
  
  public final Cursor m(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(117264);
    paramString = "SELECT * FROM " + agG(paramString) + " WHERE" + aIS(paramString) + " AND createTime <= " + paramLong + " order by createTime ASC limit " + paramInt;
    paramString = this.gPa.a(paramString, null, 0);
    AppMethodBeat.o(117264);
    return paramString;
  }
  
  public final Cursor n(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(117266);
    StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(agG(paramString)).append(" WHERE").append(aIS(paramString));
    if (paramLong > 0L) {}
    for (String str = " AND createTime > ".concat(String.valueOf(paramLong));; str = "")
    {
      str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
      ad.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
      paramString = this.gPa.a(str, null, 0);
      AppMethodBeat.o(117266);
      return paramString;
    }
  }
  
  public final bl rm(long paramLong)
  {
    AppMethodBeat.i(117207);
    bl localbl = new bl();
    Cursor localCursor = this.gPa.a(wo(paramLong), null, "msgId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localbl.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117207);
    return localbl;
  }
  
  public final int rn(long paramLong)
  {
    AppMethodBeat.i(117239);
    bl localbl = rm(paramLong);
    Object localObject = localbl.field_talker;
    this.FAz.m((int)(bt.aGK() / 86400L), localbl.field_msgSvrId, localbl.field_createTime / 1000L);
    int i = this.gPa.delete(wo(paramLong), "msgId=?", new String[] { String.valueOf(paramLong) });
    ((an)g.ab(an.class)).lU(paramLong);
    if (i != 0)
    {
      doNotify("delete_id ".concat(String.valueOf(paramLong)));
      localObject = new h.c((String)localObject, "delete", localbl, 1, (byte)0);
      ((h.c)localObject).tyH = paramLong;
      ((h.c)localObject).mUQ = localbl.field_bizChatId;
      a((h.c)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(117239);
      return i;
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 245L, 1L, false);
    }
  }
  
  public final boolean ro(long paramLong)
  {
    AppMethodBeat.i(117251);
    boolean bool = this.FAz.wm(paramLong);
    AppMethodBeat.o(117251);
    return bool;
  }
  
  public final boolean rp(long paramLong)
  {
    AppMethodBeat.i(117287);
    int i = 0;
    while (i < this.FAs.size())
    {
      if (((h.b)this.FAs.get(i)).rr(paramLong))
      {
        AppMethodBeat.o(117287);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(117287);
    return false;
  }
  
  public final void rq(long paramLong)
  {
    AppMethodBeat.i(117313);
    this.FAz.b(0, paramLong, 0L, false);
    AppMethodBeat.o(117313);
  }
  
  public final int uh(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117276);
    paramString = "SELECT COUNT(*) FROM " + agG(paramString) + " WHERE" + aHn(paramString) + aIS(paramString);
    paramString = this.gPa.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117276);
    return i;
  }
  
  public final boolean ui(String paramString)
  {
    AppMethodBeat.i(117275);
    boolean bool = "message".equals(agG(paramString));
    AppMethodBeat.o(117275);
    return bool;
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(117194);
    Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    AppMethodBeat.o(117194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.bm
 * JD-Core Version:    0.7.0.1
 */