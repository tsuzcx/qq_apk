package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
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

public final class bp
  extends com.tencent.mm.sdk.e.k
  implements com.tencent.mm.plugin.messenger.foundation.a.a.h
{
  public static final String[] SQL_CREATE;
  private final l<h.a, h.c> GCe;
  private final long GXp;
  private final com.tencent.mm.b.f<String, Long> GZA;
  private as GZB;
  private Map<String, h.c> GZC;
  private boolean GZD;
  private String GZE;
  private long GZF;
  private boolean GZs;
  private final List<e> GZt;
  private List<h.b> GZu;
  private final com.tencent.mm.b.f<Integer, bo.c> GZv;
  private final com.tencent.mm.b.f<Integer, bo.d> GZw;
  private final com.tencent.mm.b.f<Integer, bo.a> GZx;
  private final com.tencent.mm.b.f<Integer, bo.b> GZy;
  private final com.tencent.mm.b.f<Integer, Object> GZz;
  private final com.tencent.mm.storagebase.h hpA;
  private bj mZH;
  private bk mZJ;
  
  static
  {
    AppMethodBeat.i(117320);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag INT, solitaireFoldInfo BLOB) " };
    AppMethodBeat.o(117320);
  }
  
  public bp(com.tencent.mm.storagebase.h paramh, bj parambj, bk parambk)
  {
    AppMethodBeat.i(117202);
    this.GZs = false;
    this.GZt = new CopyOnWriteArrayList();
    this.GZv = new com.tencent.mm.memory.a.c(100);
    this.GZw = new com.tencent.mm.memory.a.c(100);
    this.GZx = new com.tencent.mm.memory.a.c(100);
    this.GZy = new com.tencent.mm.memory.a.c(100);
    this.GZz = new com.tencent.mm.memory.a.c(100);
    this.GZA = new com.tencent.mm.memory.a.c(100);
    this.GZB = new as();
    this.GCe = new l()
    {
      public final void gZ(List<h.c> paramAnonymousList)
      {
        AppMethodBeat.i(117187);
        if ((!isLocked()) && (bp.a(bp.this) != null))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            h.c localc = (h.c)paramAnonymousList.next();
            if (localc != null) {
              bp.a(bp.this).b(bp.this, localc);
            }
          }
        }
        AppMethodBeat.o(117187);
      }
    };
    this.GZC = new HashMap();
    this.GZD = false;
    this.GZE = "";
    this.GZF = 0L;
    this.GXp = 86400L;
    this.hpA = paramh;
    this.mZH = parambj;
    this.mZJ = parambk;
    g.agS();
    if (((Integer)g.agR().agA().get(348169, Integer.valueOf(0))).intValue() == 0)
    {
      ac.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", new Object[] { Integer.valueOf(this.hpA.delete("message", "msgId> ? ", new String[] { "80000000" })) });
      g.agS();
      g.agR().agA().set(348169, Integer.valueOf(1));
    }
    c(paramh, "message");
    fcq();
    if (this.GZu == null) {
      this.GZu = new LinkedList();
    }
    this.GZu.clear();
    a(new h.b(1, "message", h.b.a(1L, 1000000L, 10000000L, 90000000L)));
    AppMethodBeat.o(117202);
  }
  
  private String AR(long paramLong)
  {
    AppMethodBeat.i(117288);
    if ((paramLong == 0L) || (paramLong == -1L))
    {
      AppMethodBeat.o(117288);
      return null;
    }
    bo.AQ(paramLong);
    int i = 0;
    while (i < this.GZu.size())
    {
      if (((h.b)this.GZu.get(i)).vU(paramLong))
      {
        String str = ((h.b)this.GZu.get(i)).name;
        AppMethodBeat.o(117288);
        return str;
      }
      i += 1;
    }
    Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[] { Long.valueOf(paramLong) }), false);
    AppMethodBeat.o(117288);
    return null;
  }
  
  private static void aL(bo parambo)
  {
    AppMethodBeat.i(117236);
    if ((parambo == null) || (!parambo.cKN()))
    {
      AppMethodBeat.o(117236);
      return;
    }
    try
    {
      String str = parambo.field_content;
      int i = str.indexOf("<msg>");
      Object localObject = str;
      if (i > 0)
      {
        localObject = str;
        if (i < str.length()) {
          localObject = str.substring(i).trim();
        }
      }
      localObject = bv.L((String)localObject, "msg");
      if ((localObject != null) && (((Map)localObject).size() > 0)) {
        parambo.rg(com.tencent.mm.sdk.platformtools.bi.bF((Map)localObject));
      }
      AppMethodBeat.o(117236);
      return;
    }
    catch (Exception parambo)
    {
      ac.e("MicroMsg.MsgInfoStorage", parambo.getMessage());
      AppMethodBeat.o(117236);
    }
  }
  
  private static String aMH(String paramString)
  {
    AppMethodBeat.i(177115);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).axd().akY(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(177115);
      return paramString;
    }
    AppMethodBeat.o(177115);
    return "";
  }
  
  private String aOo(String paramString)
  {
    AppMethodBeat.i(117216);
    String str = alA(paramString);
    if ((this.GZs) && (str.equals("message")))
    {
      paramString = " talkerId=" + aOp(paramString) + " ";
      AppMethodBeat.o(117216);
      return paramString;
    }
    paramString = " talker= '" + bs.aLh(paramString) + "' ";
    AppMethodBeat.o(117216);
    return paramString;
  }
  
  private long aOp(String paramString)
  {
    AppMethodBeat.i(117217);
    long l2 = this.mZH.aNv(paramString);
    if (l2 < 0L) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = l2;
      if (bool)
      {
        l1 = l2;
        if (!w.wC(paramString))
        {
          ai localai = new ai(paramString);
          localai.setType(2);
          this.mZH.ag(localai);
          l1 = this.mZH.aNv(paramString);
        }
      }
      if (!b.eUm()) {
        ac.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", new Object[] { paramString, Long.valueOf(l1), Boolean.valueOf(bool), bs.eWi() });
      }
      AppMethodBeat.o(117217);
      return l1;
    }
  }
  
  private static String aOq(String paramString)
  {
    AppMethodBeat.i(117235);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117235);
      return null;
    }
    try
    {
      paramString = bv.L(paramString, "msgsource");
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
      ac.e("MicroMsg.MsgInfoStorage", "exception:%s", new Object[] { bs.m(paramString) });
      ac.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(117235);
    }
    return null;
  }
  
  private String aOr(String paramString)
  {
    AppMethodBeat.i(117277);
    if ((paramString == null) || (!paramString.equals("message")))
    {
      AppMethodBeat.o(117277);
      return "";
    }
    if (this.GZs)
    {
      AppMethodBeat.o(117277);
      return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
    }
    AppMethodBeat.o(117277);
    return "INDEXED BY messageCreateTaklerTypeTimeIndex";
  }
  
  private h.b aOs(String paramString)
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
      if (i >= this.GZu.size()) {
        break label98;
      }
      if (paramString.equals(((h.b)this.GZu.get(i)).name))
      {
        paramString = (h.b)this.GZu.get(i);
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
  
  private String aOt(String paramString)
  {
    AppMethodBeat.i(117285);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Iterator localIterator = this.GZt.iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = ((e)localIterator.next()).aME(paramString);
      } while (bs.isNullOrNil(str));
      AppMethodBeat.o(117285);
      return str;
    }
    AppMethodBeat.o(117285);
    return "message";
  }
  
  private h.b aOu(String paramString)
  {
    AppMethodBeat.i(117286);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = aOs(aOt(paramString));
      AppMethodBeat.o(117286);
      return paramString;
    }
  }
  
  private void b(h.b paramb)
  {
    AppMethodBeat.i(117205);
    Cursor localCursor = this.hpA.a("select max(msgid) from " + paramb.name, null, 2);
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      ac.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d tableName: %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramb.hGV), paramb.name });
      if (i >= paramb.hGV) {
        paramb.Ir(i);
      }
    }
    localCursor.close();
    ac.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + paramb.hGV);
    AppMethodBeat.o(117205);
  }
  
  private void fcq()
  {
    AppMethodBeat.i(117200);
    long l1 = System.currentTimeMillis();
    long l2 = this.hpA.vE(Thread.currentThread().getId());
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
    if (!this.GZs)
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
      this.hpA.execSQL("message", (String)localArrayList.get(i));
      i += 1;
    }
    ac.i("MicroMsg.MsgInfoStorage", "build new index last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    this.hpA.qL(l2);
    ac.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(117200);
  }
  
  public final Cursor A(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117246);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117246);
      return null;
    }
    String str = alA(paramString);
    paramString = "select * from " + str + " where" + aOo(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.hpA.a(paramString, null, 2);
    AppMethodBeat.o(117246);
    return paramString;
  }
  
  public final int B(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(117279);
    paramString = "SELECT COUNT(*) FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND type = 50 AND createTime >= " + paramLong1 + " AND createTime <= " + paramLong2 + " LIMIT 1";
    paramString = this.hpA.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117279);
    return i;
  }
  
  public final int C(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117294);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      ac.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      paramString = "SELECT COUNT(msgId) FROM " + alA(paramString) + " WHERE" + aMH(paramString) + aOo(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      ac.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf(paramString)));
      paramString = this.hpA.a(paramString, null, 2);
      if (paramString == null)
      {
        ac.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
        AppMethodBeat.o(117294);
        return 0;
      }
      if (paramString.moveToFirst())
      {
        int i = paramString.getInt(0);
        ac.d("MicroMsg.MsgInfoStorage", "result msg count %d", new Object[] { Integer.valueOf(i) });
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
  
  public final Cursor D(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117297);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime ASC ";
      ac.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hpA.a(paramString, null, 0);
      AppMethodBeat.o(117297);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int E(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117300);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ( SELECT * FROM ").append(alA(paramString)).append(" WHERE").append(aOo(paramString));
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
        ac.d("MicroMsg.MsgInfoStorage", "getCountAfterStratTimeBeforeEndTime talk:%s [%s]", new Object[] { paramString, str });
        paramString = this.hpA.a(str, null, 2);
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
            ac.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
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
  
  public final int F(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117302);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT COUNT(*) FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1;
      paramString = this.hpA.a(paramString, null, 2);
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
          ac.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
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
  
  public final Cursor G(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117303);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      ac.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hpA.a(paramString, null, 0);
      AppMethodBeat.o(117303);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  /* Error */
  public final List<bo> H(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 706
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 6
    //   9: new 553	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 554	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: getfield 145	com/tencent/mm/storage/bp:hpA	Lcom/tencent/mm/storagebase/h;
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 372	com/tencent/mm/storage/bp:alA	(Ljava/lang/String;)Ljava/lang/String;
    //   27: aconst_null
    //   28: new 63	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 707	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 625	com/tencent/mm/storage/bp:aOo	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 709
    //   46: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: iconst_2
    //   53: anewarray 61	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: lload_2
    //   59: invokestatic 687	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: lload 4
    //   67: invokestatic 687	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   70: aastore
    //   71: aconst_null
    //   72: aconst_null
    //   73: ldc_w 711
    //   76: iconst_2
    //   77: invokevirtual 714	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   80: astore_1
    //   81: aload_1
    //   82: astore 6
    //   84: aload 6
    //   86: astore_1
    //   87: aload 6
    //   89: invokeinterface 717 1 0
    //   94: ifeq +86 -> 180
    //   97: aload 6
    //   99: astore_1
    //   100: new 249	com/tencent/mm/storage/bo
    //   103: dup
    //   104: invokespecial 718	com/tencent/mm/storage/bo:<init>	()V
    //   107: astore 8
    //   109: aload 6
    //   111: astore_1
    //   112: aload 8
    //   114: aload 6
    //   116: invokevirtual 722	com/tencent/mm/storage/bo:convertFrom	(Landroid/database/Cursor;)V
    //   119: aload 6
    //   121: astore_1
    //   122: aload 7
    //   124: aload 8
    //   126: invokevirtual 725	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: goto -46 -> 84
    //   133: astore 7
    //   135: aload 6
    //   137: astore_1
    //   138: ldc 184
    //   140: aload 7
    //   142: ldc_w 727
    //   145: iconst_1
    //   146: anewarray 188	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload 7
    //   153: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 695	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aload 6
    //   162: ifnull +10 -> 172
    //   165: aload 6
    //   167: invokeinterface 526 1 0
    //   172: ldc_w 706
    //   175: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: aload 6
    //   182: ifnull +10 -> 192
    //   185: aload 6
    //   187: invokeinterface 526 1 0
    //   192: ldc_w 706
    //   195: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 7
    //   200: areturn
    //   201: astore_1
    //   202: aload 6
    //   204: ifnull +10 -> 214
    //   207: aload 6
    //   209: invokeinterface 526 1 0
    //   214: ldc_w 706
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
    //   0	241	0	this	bp
    //   0	241	1	paramString	String
    //   0	241	2	paramLong1	long
    //   0	241	4	paramLong2	long
    //   7	230	6	str	String
    //   16	107	7	localArrayList	ArrayList
    //   133	66	7	localException1	Exception
    //   222	6	7	localObject	Object
    //   233	1	7	localException2	Exception
    //   107	18	8	localbo	bo
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
  
  public final bo Iq(int paramInt)
  {
    AppMethodBeat.i(117229);
    if (this.GZu == null)
    {
      ac.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117229);
      return null;
    }
    bo localbo = new bo();
    long l1 = 0L;
    int i = 0;
    while (i < this.GZu.size())
    {
      long l2 = l1;
      if ((((h.b)this.GZu.get(i)).uGY & paramInt) != 0)
      {
        Object localObject = "select * from " + ((h.b)this.GZu.get(i)).name + "  order by createTime DESC limit 1";
        localObject = this.hpA.a((String)localObject, null, 2);
        l2 = l1;
        if (((Cursor)localObject).moveToFirst())
        {
          long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
          l2 = l1;
          if (l1 < l3)
          {
            localbo.convertFrom((Cursor)localObject);
            l2 = l3;
          }
        }
        ((Cursor)localObject).close();
      }
      i += 1;
      l1 = l2;
    }
    AppMethodBeat.o(117229);
    return localbo;
  }
  
  public final Cursor Y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117304);
    String str = " SELECT * FROM " + alA(paramString1) + " WHERE" + aMH(paramString1) + aOo(paramString1) + "AND content LIKE '" + paramString2 + "%' ORDER BY createTime DESC LIMIT " + paramInt;
    ac.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), str });
    paramString1 = this.hpA.a(str, null, 0);
    AppMethodBeat.o(117304);
    return paramString1;
  }
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(117296);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = new StringBuilder("SELECT * FROM ").append(alA(paramString)).append(" WHERE").append(aOo(paramString)).append("AND createTime >= ").append(paramLong2).append(" AND createTime <= ").append(paramLong1).append(" AND isSend=");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString = i + " LIMIT 1";
        ac.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
        paramString = this.hpA.a(paramString, null, 0);
        AppMethodBeat.o(117296);
        return paramString;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void a(long paramLong, bo parambo)
  {
    AppMethodBeat.i(117258);
    if (parambo.fbz())
    {
      String str = aOq(parambo.eul);
      if (w.xm(str))
      {
        ac.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
        parambo.re("notifymessage");
      }
    }
    aL(parambo);
    if (this.hpA.update(AR(paramLong), parambo.convertTo(), "msgId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new h.c(parambo.field_talker, "update", parambo));
      AppMethodBeat.o(117258);
      return;
    }
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 244L, 1L, false);
    AppMethodBeat.o(117258);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(117192);
    this.GCe.remove(parama);
    AppMethodBeat.o(117192);
  }
  
  public final void a(h.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(117191);
    this.GCe.a(parama, paramLooper);
    AppMethodBeat.o(117191);
  }
  
  public final void a(h.b paramb)
  {
    AppMethodBeat.i(117203);
    synchronized (this.GZu)
    {
      this.GZu.add(paramb);
      b(paramb);
      AppMethodBeat.o(117203);
      return;
    }
  }
  
  public final void a(h.c paramc)
  {
    AppMethodBeat.i(117190);
    if (this.GCe.dS(paramc)) {
      this.GCe.doNotify();
    }
    AppMethodBeat.o(117190);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(117189);
    if (!this.GZt.contains(parame))
    {
      ac.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", new Object[] { parame });
      this.GZt.add(parame);
    }
    AppMethodBeat.o(117189);
  }
  
  public final void aE(String paramString, long paramLong)
  {
    AppMethodBeat.i(117199);
    h.b localb = aOu(paramString);
    long l = localb.hGV;
    Random localRandom = new Random();
    this.hpA.execSQL("message", "BEGIN;");
    bo localbo = new bo(paramString);
    int i = 0;
    while (i < paramLong)
    {
      localbo.oA(System.currentTimeMillis());
      localbo.setType(1);
      localbo.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bs.eWh());
      localbo.setMsgId(l);
      localbo.setStatus(localRandom.nextInt(4));
      localbo.jT(localRandom.nextInt(1));
      l += 1L;
      localb.hGV += 1L;
      localbo.oz(System.currentTimeMillis() + bs.eWh());
      this.hpA.execSQL("message", "INSERT INTO " + alA(localbo.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + localbo.field_msgId + "," + localbo.field_msgSvrId + "," + localbo.getType() + "," + localbo.field_status + "," + localbo.field_createTime + ",'" + localbo.field_talker + "','" + localbo.field_content + "'," + aOp(paramString) + ");");
      if (i % 10000 == 0)
      {
        this.hpA.execSQL("message", "COMMIT;");
        this.hpA.execSQL("message", "BEGIN;");
      }
      i += 1;
    }
    this.hpA.execSQL("message", "COMMIT;");
    this.mZJ.aNJ(paramString);
    localbo.setMsgId(1L + l);
    ap(localbo);
    AppMethodBeat.o(117199);
  }
  
  public final bo aF(String paramString, long paramLong)
  {
    AppMethodBeat.i(117208);
    bo localbo = new bo();
    paramString = this.hpA.a(alA(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbo.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117208);
    return localbo;
  }
  
  public final bo aG(String paramString, long paramLong)
  {
    AppMethodBeat.i(117209);
    bo localbo = new bo();
    paramString = this.hpA.a(alA(paramString), null, aOo(paramString) + " AND msgSeq=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbo.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117209);
    return localbo;
  }
  
  public final bo aH(String paramString, long paramLong)
  {
    AppMethodBeat.i(117210);
    bo localbo = new bo();
    paramString = this.hpA.a(alA(paramString), null, "createTime=? AND" + aOo(paramString), new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbo.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117210);
    return localbo;
  }
  
  public final List<bo> aI(String paramString, long paramLong)
  {
    AppMethodBeat.i(117212);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + alA(paramString) + " Where " + aOo(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11";
    paramString = this.hpA.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bo localbo = new bo();
      localbo.convertFrom(paramString);
      localArrayList.add(localbo);
    }
    paramString.close();
    AppMethodBeat.o(117212);
    return localArrayList;
  }
  
  public final List<bo> aJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(117213);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + alA(paramString) + " Where " + aOo(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11;";
    paramString = this.hpA.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bo localbo = new bo();
      localbo.convertFrom(paramString);
      localArrayList.add(localbo);
    }
    paramString.close();
    AppMethodBeat.o(117213);
    return localArrayList;
  }
  
  public final bo aK(String paramString, long paramLong)
  {
    AppMethodBeat.i(117214);
    bo localbo = new bo();
    paramString = "Select * From " + alA(paramString) + " Where " + aOo(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
    paramString = this.hpA.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbo.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117214);
    return localbo;
  }
  
  public final bo aL(String paramString, long paramLong)
  {
    AppMethodBeat.i(117215);
    bo localbo = new bo();
    paramString = "Select * From " + alA(paramString) + " Where " + aOo(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
    paramString = this.hpA.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbo.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117215);
    return localbo;
  }
  
  public final boolean aM(String paramString, long paramLong)
  {
    AppMethodBeat.i(117220);
    if (aH(paramString, paramLong).field_msgId > 0L)
    {
      AppMethodBeat.o(117220);
      return true;
    }
    AppMethodBeat.o(117220);
    return false;
  }
  
  public final bo aN(String paramString, long paramLong)
  {
    AppMethodBeat.i(117224);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117224);
      return null;
    }
    bo localbo = new bo();
    paramString = "select * from " + alA(paramString) + " where" + aOo(paramString) + "AND msgSeq<" + paramLong + " order by msgSeq DESC limit 1";
    Cursor localCursor = this.hpA.a(paramString, null, 2);
    if (localCursor.moveToFirst()) {
      localbo.convertFrom(localCursor);
    }
    localCursor.close();
    ac.d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117224);
    return localbo;
  }
  
  public final Cursor aO(String paramString, long paramLong)
  {
    AppMethodBeat.i(177113);
    paramString = this.hpA.fdL().rawQueryWithFactory(null, "SELECT * FROM " + paramString + " WHERE createTime < " + paramLong, null, paramString);
    AppMethodBeat.o(177113);
    return paramString;
  }
  
  public final long aP(String paramString, long paramLong)
  {
    AppMethodBeat.i(117241);
    paramString = "select createTime from " + alA(paramString) + " where msgId = " + paramLong;
    paramLong = 0L;
    paramString = this.hpA.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      paramLong = paramString.getLong(0);
    }
    paramString.close();
    AppMethodBeat.o(117241);
    return paramLong;
  }
  
  /* Error */
  public final int aQ(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 1013
    //   6: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 135
    //   13: aconst_null
    //   14: invokevirtual 1016	com/tencent/mm/storage/bp:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 145	com/tencent/mm/storage/bp:hpA	Lcom/tencent/mm/storagebase/h;
    //   21: invokevirtual 991	com/tencent/mm/storagebase/h:fdL	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   24: new 63	java/lang/StringBuilder
    //   27: dup
    //   28: ldc_w 1018
    //   31: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 1020
    //   41: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 1024	com/tencent/wcdb/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   50: astore 6
    //   52: aload 6
    //   54: iconst_1
    //   55: lload_2
    //   56: invokevirtual 1030	com/tencent/wcdb/database/SQLiteStatement:bindLong	(IJ)V
    //   59: aload 6
    //   61: invokevirtual 1033	com/tencent/wcdb/database/SQLiteStatement:executeUpdateDelete	()I
    //   64: istore 4
    //   66: iload 4
    //   68: ifle +17 -> 85
    //   71: aload_0
    //   72: ldc_w 1035
    //   75: aload_1
    //   76: invokestatic 662	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokevirtual 665	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 1037	com/tencent/mm/storage/bp:doNotify	(Ljava/lang/String;)V
    //   85: aload 6
    //   87: ifnull +8 -> 95
    //   90: aload 6
    //   92: invokevirtual 1038	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   95: ldc_w 1013
    //   98: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload 4
    //   103: ireturn
    //   104: astore 5
    //   106: ldc_w 1013
    //   109: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload 5
    //   114: athrow
    //   115: astore_1
    //   116: aload 6
    //   118: ifnull +13 -> 131
    //   121: aload 5
    //   123: ifnull +51 -> 174
    //   126: aload 6
    //   128: invokevirtual 1038	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   131: ldc_w 1013
    //   134: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: getstatic 822	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   143: ldc2_w 823
    //   146: ldc2_w 1039
    //   149: lconst_1
    //   150: iconst_0
    //   151: invokevirtual 830	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   154: ldc_w 1013
    //   157: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: iconst_m1
    //   161: ireturn
    //   162: astore 6
    //   164: aload 5
    //   166: aload 6
    //   168: invokevirtual 1044	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   171: goto -40 -> 131
    //   174: aload 6
    //   176: invokevirtual 1038	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   179: goto -48 -> 131
    //   182: astore_1
    //   183: goto -67 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	bp
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
  
  public final int aR(String paramString, long paramLong)
  {
    AppMethodBeat.i(117253);
    bo localbo = aF(paramString, paramLong);
    this.GZB.m((int)(bs.aNx() / 86400L), localbo.field_msgSvrId, localbo.field_createTime / 1000L);
    int i = this.hpA.delete(alA(paramString), "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      doNotify();
      a(new h.c(paramString, "delete", null, 1, (byte)0));
    }
    for (;;)
    {
      AppMethodBeat.o(117253);
      return i;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 246L, 1L, false);
    }
  }
  
  public final int aS(String paramString, long paramLong)
  {
    AppMethodBeat.i(117255);
    String str = aOo(paramString) + " and createTime <= " + paramLong;
    b(alA(paramString), str, null);
    int i = this.hpA.delete(alA(paramString), str, null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.uHe = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117255);
    return i;
  }
  
  public final int aT(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(117281);
    bo localbo = vP(paramLong);
    if (localbo.field_msgId == 0L)
    {
      ac.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117281);
      return 0;
    }
    String str = alA(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " " + aOr(str) + " WHERE " + aMH(paramString) + aOo(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + localbo.field_createTime;
    paramString = this.hpA.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117281);
    return i;
  }
  
  public final String aU(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(117282);
    Object localObject1 = vP(paramLong);
    if (((dy)localObject1).field_msgId == 0L)
    {
      ac.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117282);
      return null;
    }
    Object localObject2 = alA(paramString);
    paramString = "EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + (String)localObject2 + " " + aOr((String)localObject2) + " WHERE" + aMH(paramString) + aOo(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + ((dy)localObject1).field_createTime;
    localObject2 = this.hpA.a(paramString, null, 0);
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
  
  public final bo aV(String paramString, long paramLong)
  {
    AppMethodBeat.i(117292);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117292);
      return null;
    }
    Object localObject = "select * from message where" + aOo(paramString) + " and msgSeq < " + paramLong + " order by msgSeq DESC LIMIT 1 ";
    ac.i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: ".concat(String.valueOf(localObject)));
    localObject = this.hpA.a((String)localObject, null, 0);
    if (localObject == null)
    {
      ac.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117292);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new bo();
      paramString.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(117292);
      return paramString;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117292);
    return null;
  }
  
  public final bo aW(String paramString, long paramLong)
  {
    AppMethodBeat.i(117309);
    ac.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(1) });
    bo localbo = new bo();
    paramString = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND createTime < " + paramLong + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1";
    ac.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hpA.a(paramString, null, 0);
    if (paramString == null)
    {
      ac.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(117309);
      return localbo;
    }
    if (paramString.moveToLast())
    {
      localbo.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(117309);
      return localbo;
    }
    paramString.close();
    ac.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117309);
    return localbo;
  }
  
  public final List<bo> al(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117233);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + alA(paramString) + " WHERE type & 65535 = 49" + " ORDER BY createTime DESC LIMIT " + paramInt1 + " , " + paramInt2;
    ac.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.hpA.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bo localbo = new bo();
      localbo.convertFrom(paramString);
      if (localbo.cKN()) {
        localArrayList.add(localbo);
      }
    }
    paramString.close();
    AppMethodBeat.o(117233);
    return localArrayList;
  }
  
  public final void al(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(117219);
    long l1 = this.hpA.vE(-1L);
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        long l2 = ((Long)paramArrayList.next()).longValue();
        bo localbo = vP(l2);
        localbo.jA(localbo.euk | 0x20);
        ac.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
        a(l2, localbo);
      }
      this.hpA.qL(l1);
    }
    finally
    {
      this.hpA.qL(l1);
      AppMethodBeat.o(117219);
    }
    AppMethodBeat.o(117219);
  }
  
  public final String alA(String paramString)
  {
    AppMethodBeat.i(117283);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = aOu(paramString).name;
      AppMethodBeat.o(117283);
      return paramString;
    }
  }
  
  public final long alB(String paramString)
  {
    AppMethodBeat.i(117289);
    Object localObject = "select createTime from message where" + aOo(paramString) + "order by createTime LIMIT 1 OFFSET 0";
    ac.d("MicroMsg.MsgInfoStorage", "get first message create time: ".concat(String.valueOf(localObject)));
    localObject = this.hpA.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ac.e("MicroMsg.MsgInfoStorage", "get first message create time failed: ".concat(String.valueOf(paramString)));
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
  
  public final long alC(String paramString)
  {
    AppMethodBeat.i(117290);
    Object localObject = "select createTime from message where" + aMH(paramString) + aOo(paramString) + "order by createTime DESC LIMIT 1 ";
    ac.d("MicroMsg.MsgInfoStorage", "get last message create time: ".concat(String.valueOf(localObject)));
    localObject = this.hpA.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ac.e("MicroMsg.MsgInfoStorage", "get last message create time failed ".concat(String.valueOf(paramString)));
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
  
  public final long alD(String paramString)
  {
    AppMethodBeat.i(117291);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117291);
      return 0L;
    }
    Object localObject = "select msgSeq from message where" + aOo(paramString) + "order by msgSeq DESC LIMIT 1 ";
    ac.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: ".concat(String.valueOf(localObject)));
    localObject = this.hpA.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ac.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed ".concat(String.valueOf(paramString)));
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
  
  public final bo alE(String paramString)
  {
    AppMethodBeat.i(117293);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117293);
      return null;
    }
    ac.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", new Object[] { paramString, Boolean.FALSE });
    Object localObject1 = (Long)this.GZA.get(paramString);
    if ((localObject1 != null) && (((Long)localObject1).longValue() > 0L))
    {
      ac.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", new Object[] { Long.valueOf(((Long)localObject1).longValue()) });
      localObject1 = vP(((Long)localObject1).longValue());
      if ((((dy)localObject1).field_flag & 0x1) != 0)
      {
        AppMethodBeat.o(117293);
        return localObject1;
      }
      this.GZA.remove(paramString);
      AppMethodBeat.o(117293);
      return null;
    }
    ac.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
    localObject1 = new bo();
    long l = System.currentTimeMillis();
    Object localObject2 = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ";
    localObject2 = this.hpA.a((String)localObject2, null, 2);
    ac.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(Thread.currentThread().getId()) });
    if (localObject2 == null)
    {
      ac.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117293);
      return localObject1;
    }
    if (((Cursor)localObject2).moveToFirst()) {
      ((bo)localObject1).convertFrom((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    this.GZA.o(paramString, Long.valueOf(((dy)localObject1).field_msgId));
    AppMethodBeat.o(117293);
    return localObject1;
  }
  
  public final int alF(String paramString)
  {
    AppMethodBeat.i(117307);
    String str = " SELECT COUNT(*) FROM " + alA(paramString) + " WHERE" + aMH(paramString) + aOo(paramString) + "AND isSend=1";
    Cursor localCursor = this.hpA.a(str, null, 2);
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
        ac.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(117307);
      }
      ac.d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", new Object[] { paramString, Integer.valueOf(i), str });
      AppMethodBeat.o(117307);
      return i;
      label168:
      int i = 0;
    }
  }
  
  /* Error */
  public final List<bo> alG(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 1226
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 553	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 554	java/util/ArrayList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 145	com/tencent/mm/storage/bp:hpA	Lcom/tencent/mm/storagebase/h;
    //   20: ldc 71
    //   22: aconst_null
    //   23: ldc_w 1228
    //   26: iconst_2
    //   27: anewarray 61	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: invokestatic 390	com/tencent/mm/sdk/platformtools/bs:aLh	(Ljava/lang/String;)Ljava/lang/String;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: invokestatic 538	java/lang/System:currentTimeMillis	()J
    //   42: ldc2_w 1229
    //   45: lsub
    //   46: invokestatic 687	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: ldc_w 1232
    //   55: iconst_2
    //   56: invokevirtual 714	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokeinterface 717 1 0
    //   70: ifeq +75 -> 145
    //   73: aload_2
    //   74: astore_1
    //   75: new 249	com/tencent/mm/storage/bo
    //   78: dup
    //   79: invokespecial 718	com/tencent/mm/storage/bo:<init>	()V
    //   82: astore 4
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: aload_2
    //   89: invokevirtual 722	com/tencent/mm/storage/bo:convertFrom	(Landroid/database/Cursor;)V
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: aload 4
    //   97: invokevirtual 725	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto -39 -> 62
    //   104: astore_3
    //   105: aload_2
    //   106: astore_1
    //   107: ldc 184
    //   109: aload_3
    //   110: ldc_w 1234
    //   113: iconst_1
    //   114: anewarray 188	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 695	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_2
    //   128: ifnull +9 -> 137
    //   131: aload_2
    //   132: invokeinterface 526 1 0
    //   137: ldc_w 1226
    //   140: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aconst_null
    //   144: areturn
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 526 1 0
    //   155: ldc_w 1226
    //   158: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_3
    //   162: areturn
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +9 -> 174
    //   168: aload_2
    //   169: invokeinterface 526 1 0
    //   174: ldc_w 1226
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
    //   0	196	0	this	bp
    //   0	196	1	paramString	String
    //   1	192	2	str	String
    //   15	80	3	localArrayList	ArrayList
    //   104	58	3	localException1	Exception
    //   182	4	3	localObject	Object
    //   190	1	3	localException2	Exception
    //   82	14	4	localbo	bo
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
  
  public final long alH(String paramString)
  {
    AppMethodBeat.i(117317);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    paramString = aOs(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    long l = paramString.hGV;
    AppMethodBeat.o(117317);
    return l;
  }
  
  public final Cursor alI(String paramString)
  {
    AppMethodBeat.i(117315);
    try
    {
      paramString = this.hpA.a(alA(paramString), null, aOo(paramString) + " AND createTime>=? AND type IN (436207665,419430449)", new String[] { String.valueOf(System.currentTimeMillis() - 86400000L) }, null, null, "createTime ASC", 2);
      AppMethodBeat.o(117315);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.MsgInfoStorage", paramString, "getLastDayC2CMsgByTalker error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(117315);
    }
    return null;
  }
  
  public final void alf(String paramString)
  {
    AppMethodBeat.i(117195);
    ac.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.GZD), Integer.valueOf(super.lockCount()), Integer.valueOf(this.GCe.GvJ), Integer.valueOf(this.GZC.size()), this.GZE, Long.valueOf(bs.Ap(this.GZF)) });
    if (bs.isNullOrNil(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (this.GZD)
    {
      ac.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", new Object[] { this.GZE, Long.valueOf(bs.Ap(this.GZF)) });
      AppMethodBeat.o(117195);
      return;
    }
    this.GZE = paramString;
    this.GZF = bs.eWj();
    this.GZD = true;
    super.lock();
    this.GCe.lock();
    AppMethodBeat.o(117195);
  }
  
  public final void alg(String paramString)
  {
    AppMethodBeat.i(117196);
    ac.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.GZD), Integer.valueOf(super.lockCount()), Integer.valueOf(this.GCe.GvJ), Integer.valueOf(this.GZC.size()), this.GZE, Long.valueOf(bs.Ap(this.GZF)) });
    if (bs.isNullOrNil(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (!this.GZD)
    {
      ac.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", new Object[] { paramString, bs.eWi() });
      AppMethodBeat.o(117196);
      return;
    }
    if (!paramString.equals(this.GZE))
    {
      ac.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", new Object[] { this.GZE, Long.valueOf(bs.Ap(this.GZF)), paramString });
      AppMethodBeat.o(117196);
      return;
    }
    this.GZD = false;
    this.GZF = 0L;
    this.GZE = "";
    paramString = this.GZC.keySet().iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      a((h.c)this.GZC.get(str));
    }
    this.GZC.clear();
    super.unlock();
    this.GCe.unlock();
    doNotify();
    AppMethodBeat.o(117196);
  }
  
  public final void alh(String paramString)
  {
    AppMethodBeat.i(117197);
    if (!this.GZD)
    {
      AppMethodBeat.o(117197);
      return;
    }
    h.c localc = null;
    if (this.GZC.containsKey(paramString)) {
      localc = (h.c)this.GZC.get(paramString);
    }
    if (localc == null)
    {
      ac.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", new Object[] { paramString, bs.eWi() });
      AppMethodBeat.o(117197);
      return;
    }
    if ((localc.uHb != null) && (localc.uHb.equals("insert")) && (localc.rnT > 0))
    {
      ac.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", new Object[] { paramString, Integer.valueOf(localc.rnT) });
      localc.rnT = 0;
    }
    AppMethodBeat.o(117197);
  }
  
  public final Cursor ali(String paramString)
  {
    AppMethodBeat.i(117211);
    com.tencent.mm.storagebase.h localh = this.hpA;
    String str = alA(paramString);
    paramString = aMH(paramString) + aOo(paramString);
    paramString = localh.query(str, new String[] { "createTime", "msgId" }, paramString, null, "createTime", null, "createTime ASC");
    AppMethodBeat.o(117211);
    return paramString;
  }
  
  public final bo alj(String paramString)
  {
    AppMethodBeat.i(117222);
    bo localbo = new bo();
    paramString = this.hpA.a(alA(paramString), null, aOo(paramString), null, null, null, "msgSvrId  DESC limit 1 ", 2);
    if (paramString.moveToFirst()) {
      localbo.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117222);
    return localbo;
  }
  
  public final bo alk(String paramString)
  {
    AppMethodBeat.i(117223);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117223);
      return null;
    }
    bo localbo = new bo();
    paramString = "select * from " + alA(paramString) + " where" + aMH(paramString) + aOo(paramString) + "order by createTime DESC limit 1";
    paramString = this.hpA.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbo.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117223);
    return localbo;
  }
  
  public final bo all(String paramString)
  {
    AppMethodBeat.i(117226);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117226);
      return null;
    }
    bo localbo = new bo();
    paramString = "select * from " + alA(paramString) + " where" + aOo(paramString) + "and isSend = 0  order by createTime DESC limit 1";
    paramString = this.hpA.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbo.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117226);
    return localbo;
  }
  
  public final bo alm(String paramString)
  {
    AppMethodBeat.i(117230);
    if (this.GZu == null)
    {
      ac.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117230);
      return null;
    }
    bo localbo = new bo();
    long l1 = 0L;
    if (bs.isNullOrNil(paramString)) {}
    for (paramString = "";; paramString = paramString.replaceFirst("and", "where"))
    {
      int i = 0;
      while (i < this.GZu.size())
      {
        long l2 = l1;
        if ((((h.b)this.GZu.get(i)).uGY & 0x8) != 0)
        {
          Object localObject = "select * from " + ((h.b)this.GZu.get(i)).name + paramString + "  order by createTime DESC limit 1";
          localObject = this.hpA.a((String)localObject, null, 2);
          l2 = l1;
          if (((Cursor)localObject).moveToFirst())
          {
            long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
            l2 = l1;
            if (l1 < l3)
            {
              localbo.convertFrom((Cursor)localObject);
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
    return localbo;
  }
  
  public final List<bo> aln(String paramString)
  {
    bo localbo = null;
    AppMethodBeat.i(117240);
    Cursor localCursor = this.hpA.a("select * from ".concat(String.valueOf(paramString)), null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(117240);
      return null;
    }
    paramString = localbo;
    if (localCursor.moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        localbo = new bo();
        localbo.convertFrom(localCursor);
        paramString.add(localbo);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(117240);
    return paramString;
  }
  
  public final Cursor alo(String paramString)
  {
    AppMethodBeat.i(117247);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117247);
      return null;
    }
    Object localObject = alA(paramString);
    paramString = "select * from " + (String)localObject + " " + aOr((String)localObject) + " where" + aOo(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime";
    localObject = this.hpA.a(paramString, null, 0);
    ac.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(117247);
    return localObject;
  }
  
  public final void alp(String paramString)
  {
    AppMethodBeat.i(117252);
    b(paramString, "", null);
    if (this.hpA.execSQL(paramString, "delete from ".concat(String.valueOf(paramString))))
    {
      doNotify("delete_all ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117252);
      return;
    }
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 247L, 1L, false);
    AppMethodBeat.o(117252);
  }
  
  public final int alq(String paramString)
  {
    AppMethodBeat.i(117254);
    ac.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, com.tencent.mm.sdk.platformtools.as.eVp() });
    b(alA(paramString), aOo(paramString), null);
    int i = this.hpA.delete(alA(paramString), aOo(paramString), null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.uHe = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117254);
    return i;
  }
  
  public final int alr(String paramString)
  {
    AppMethodBeat.i(117261);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(4));
    int i = this.hpA.update(alA(paramString), localContentValues, aOo(paramString) + "AND isSend=? AND status!=? ", new String[] { "0", "4" });
    if (i != 0)
    {
      doNotify();
      a(new h.c(paramString, "update", null));
    }
    AppMethodBeat.o(117261);
    return i;
  }
  
  public final Cursor als(String paramString)
  {
    AppMethodBeat.i(117263);
    paramString = this.hpA.query(alA(paramString), null, aOo(paramString), null, null, null, "createTime ASC ");
    AppMethodBeat.o(117263);
    return paramString;
  }
  
  public final Cursor alt(String paramString)
  {
    AppMethodBeat.i(117267);
    paramString = this.hpA.query(alA(paramString), null, "isSend=? AND" + aOo(paramString) + "AND status!=?", new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117267);
    return paramString;
  }
  
  public final bo.c alu(String paramString)
  {
    AppMethodBeat.i(117270);
    bo.c localc2 = (bo.c)this.GZv.get(Integer.valueOf(paramString.hashCode()));
    bo.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = bo.c.aOm(paramString);
      this.GZv.o(Integer.valueOf(paramString.hashCode()), localc1);
    }
    AppMethodBeat.o(117270);
    return localc1;
  }
  
  public final bo.d alv(String paramString)
  {
    AppMethodBeat.i(117271);
    bo.d locald2 = (bo.d)this.GZw.get(Integer.valueOf(paramString.hashCode()));
    bo.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = bo.d.aOn(paramString);
      this.GZw.o(Integer.valueOf(paramString.hashCode()), locald1);
    }
    AppMethodBeat.o(117271);
    return locald1;
  }
  
  public final bo.a alw(String paramString)
  {
    AppMethodBeat.i(117272);
    bo.a locala1 = null;
    if ((!bs.isNullOrNil(paramString)) && (this.GZx != null)) {
      locala1 = (bo.a)this.GZx.get(Integer.valueOf(paramString.hashCode()));
    }
    for (;;)
    {
      bo.a locala2 = locala1;
      if (locala1 == null)
      {
        locala1 = bo.a.aOk(paramString);
        locala2 = locala1;
        if (this.GZx != null)
        {
          this.GZx.o(Integer.valueOf(bs.bG(paramString, "").hashCode()), locala1);
          locala2 = locala1;
        }
      }
      AppMethodBeat.o(117272);
      return locala2;
      ac.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", new Object[] { Boolean.valueOf(bs.isNullOrNil(paramString)) });
      ac.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
    }
  }
  
  public final bo.b alx(String paramString)
  {
    AppMethodBeat.i(117273);
    bo.b localb2 = (bo.b)this.GZy.get(Integer.valueOf(paramString.hashCode()));
    bo.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = bo.b.aOl(paramString);
      this.GZy.o(Integer.valueOf(paramString.hashCode()), localb1);
    }
    AppMethodBeat.o(117273);
    return localb1;
  }
  
  public final int aly(String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(117274);
    if (yo(paramString))
    {
      i = this.mZJ.aOa(paramString);
      if (i > 0)
      {
        ac.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(117274);
        return i;
      }
      ac.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    }
    do
    {
      i = yn(paramString);
      AppMethodBeat.o(117274);
      return i;
      if (("appbrandmessage".equals(alA(paramString))) || ("appbrandnotifymessage".equals(alA(paramString))))
      {
        paramString = "SELECT COUNT(*) FROM " + alA(paramString) + " WHERE" + aOo(paramString);
        paramString = this.hpA.a(paramString, null, 0);
        if (paramString.moveToLast()) {
          i = paramString.getInt(0);
        }
        paramString.close();
        AppMethodBeat.o(117274);
        return i;
      }
    } while (!"bottlemessage".equals(alA(paramString)));
    paramString = "SELECT COUNT(*) FROM " + alA(paramString) + " WHERE" + aOo(paramString);
    paramString = this.hpA.a(paramString, null, 2);
    i = j;
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117274);
    return i;
  }
  
  public final int alz(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117280);
    if (paramString == null)
    {
      ac.w("MicroMsg.MsgInfoStorage", "getImgVideoMsgCount talker is null!");
      AppMethodBeat.o(117280);
      return 0;
    }
    paramString = "SELECT COUNT(*) FROM " + alA(paramString) + " WHERE " + aMH(paramString) + "talker= '" + bs.aLh(paramString) + "' AND type IN (3,39,13,43,62,44,268435505,486539313)";
    paramString = this.hpA.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117280);
    return i;
  }
  
  public final Cursor am(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117243);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117243);
      return null;
    }
    String str = alA(paramString);
    paramString = "select * from ( select * from " + str + " where" + aMH(paramString) + aOo(paramString) + " AND type IN (3,39,13,43,62,44,268435505,486539313)  order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = this.hpA.a(paramString, null, 2);
    AppMethodBeat.o(117243);
    return paramString;
  }
  
  public final int ao(bo parambo)
  {
    int i = 0;
    AppMethodBeat.i(117234);
    if ((parambo == null) || (bs.isNullOrNil(parambo.field_talker)))
    {
      AppMethodBeat.o(117234);
      return 0;
    }
    parambo = "SELECT count(msgId) FROM " + alA(parambo.field_talker) + " WHERE" + aOo(parambo.field_talker) + "AND isSend = 0 AND msgId >= " + parambo.field_msgId + " ORDER BY createTime DESC";
    parambo = this.hpA.a(parambo, null, 2);
    if (parambo.moveToFirst()) {
      i = parambo.getInt(0);
    }
    parambo.close();
    AppMethodBeat.o(117234);
    return i;
  }
  
  public final long ap(bo parambo)
  {
    AppMethodBeat.i(117237);
    long l = c(parambo, false);
    AppMethodBeat.o(117237);
    return l;
  }
  
  public final void aq(bo parambo)
  {
    AppMethodBeat.i(117259);
    if ((parambo == null) || (parambo.field_status == 4))
    {
      AppMethodBeat.o(117259);
      return;
    }
    parambo.setStatus(4);
    String str = AR(parambo.field_msgId);
    if ((str != null) && (str.length() > 0)) {
      if (this.hpA.update(str, parambo.convertTo(), "msgId=?", new String[] { parambo.field_msgId }) != 0)
      {
        doNotify();
        a(new h.c(parambo.field_talker, "update", parambo, -1));
      }
    }
    AppMethodBeat.o(117259);
  }
  
  public final int ar(bo parambo)
  {
    int i = 0;
    AppMethodBeat.i(117262);
    if (parambo != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("content", parambo.field_content);
      localContentValues.put("status", Integer.valueOf(parambo.field_status));
      int j = this.hpA.update(AR(parambo.field_msgId), localContentValues, "msgId=?", new String[] { String.valueOf(parambo.field_msgId) });
      i = j;
      if (j != 0)
      {
        doNotify();
        a(new h.c(parambo.field_talker, "update", parambo));
        i = j;
      }
    }
    AppMethodBeat.o(117262);
    return i;
  }
  
  public final void ayW()
  {
    AppMethodBeat.i(117227);
    Cursor localCursor = this.hpA.a("select * from MsgInfo wherecontent like '%aaaabbbbbfdf%'", null, 2);
    localCursor.getCount();
    SystemClock.sleep(5000L);
    localCursor.close();
    AppMethodBeat.o(117227);
  }
  
  public final Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117299);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(alA(paramString)).append(" WHERE").append(aOo(paramString));
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
        ac.d("MicroMsg.MsgInfoStorage", "getCursorAfterStratTimeBeforeEndTimeLimit talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
        paramString = this.hpA.a(str, null, 0);
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
  
  public final void b(long paramLong, bo parambo)
  {
    AppMethodBeat.i(117260);
    if (bs.nullAsNil(parambo.field_talker).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("no talker set when update by svrid", bool);
      if (parambo.fbz())
      {
        String str = aOq(parambo.eul);
        if (w.xm(str))
        {
          ac.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
          parambo.re("notifymessage");
        }
      }
      aL(parambo);
      if (paramLong != 0L) {
        break;
      }
      ac.w("MicroMsg.MsgInfoStorage", "invalid svr id %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(117260);
      return;
    }
    if (this.hpA.update(alA(parambo.field_talker), parambo.convertTo(), "msgSvrId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new h.c(parambo.field_talker, "update", parambo));
      AppMethodBeat.o(117260);
      return;
    }
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 243L, 1L, false);
    AppMethodBeat.o(117260);
  }
  
  public final void b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(117250);
    long l = bs.aNx();
    Object localObject = "SELECT msgSvrId,createTime FROM " + paramString1 + " WHERE createTime > " + (l - 172800L) * 1000L;
    paramString1 = (String)localObject;
    if (!bs.isNullOrNil(paramString2)) {
      paramString1 = (String)localObject + " AND " + paramString2;
    }
    paramString2 = new ArrayList();
    localObject = new ArrayList();
    paramString1 = this.hpA.a(paramString1, paramArrayOfString, 2);
    if (paramString1.moveToFirst())
    {
      do
      {
        int i = paramString1.getInt(0);
        l = paramString1.getLong(1) / 1000L;
        paramString2.add(Integer.valueOf(i));
        ((List)localObject).add(Long.valueOf(l));
      } while (paramString1.moveToNext());
      this.GZB.E(paramString2, (List)localObject);
    }
    paramString1.close();
    AppMethodBeat.o(117250);
  }
  
  public final long c(bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(117238);
    if ((parambo == null) || (bs.isNullOrNil(parambo.field_talker)))
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 250L, 1L, false);
      if (parambo == null) {}
      for (localObject1 = "-1";; localObject1 = parambo.field_talker)
      {
        ac.e("MicroMsg.MsgInfoStorage", "Error insert message msg:%s talker:%s", new Object[] { parambo, localObject1 });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    ac.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", new Object[] { Boolean.valueOf(this.GZD), Long.valueOf(parambo.field_msgSeq) });
    Object localObject1 = null;
    Object localObject2 = com.tencent.mm.model.bi.yr(parambo.eul);
    if (localObject2 != null) {
      localObject1 = ((bi.b)localObject2).hou;
    }
    if (w.xm((String)localObject1))
    {
      ac.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { localObject1 });
      if (parambo.getType() == 436207665)
      {
        ac.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
        AppMethodBeat.o(117238);
        return -1L;
      }
      parambo.re("notifymessage");
    }
    localObject1 = aOu(parambo.field_talker);
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 249L, 1L, false);
      ac.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", new Object[] { parambo.field_talker });
      AppMethodBeat.o(117238);
      return -1L;
    }
    ((h.b)localObject1).as(parambo);
    Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[] { Long.valueOf(parambo.field_msgId), localObject1, AR(parambo.field_msgId) }), ((h.b)localObject1).name.equals(AR(parambo.field_msgId)));
    if (parambo.field_msgSvrId != 0L) {
      parambo.TH();
    }
    Iterator localIterator = this.GZt.iterator();
    while (localIterator.hasNext()) {
      if (!((e)localIterator.next()).a(parambo, (bi.b)localObject2))
      {
        ac.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", new Object[] { parambo.field_talker, parambo.eul });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    aL(parambo);
    if (((h.b)localObject1).name.equals("message")) {
      parambo.kd((int)aOp(parambo.field_talker));
    }
    localObject2 = parambo.convertTo();
    if (paramBoolean) {}
    for (long l = this.hpA.fdK().insertOrThrow(((h.b)localObject1).name, "msgId", (ContentValues)localObject2);; l = this.hpA.a(((h.b)localObject1).name, "msgId", (ContentValues)localObject2))
    {
      ac.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", new Object[] { Long.valueOf(l), parambo.field_talker, Long.valueOf(parambo.field_msgId), Integer.valueOf(parambo.getType()), Integer.valueOf(parambo.field_status), Long.valueOf(parambo.field_msgSvrId), Long.valueOf(parambo.field_msgSeq), Integer.valueOf(parambo.field_flag), Long.valueOf(parambo.field_createTime), Integer.valueOf(parambo.field_isSend), this.GZE, Long.valueOf(bs.Ap(this.GZF)) });
      if (l != -1L) {
        break;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 248L, 1L, false);
      ac.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", new Object[] { Long.valueOf(parambo.field_msgSvrId), Long.valueOf(l) });
      AppMethodBeat.o(117238);
      return -1L;
    }
    if ((this.GZD) && (bs.Ap(this.GZF) > 2000L) && (parambo.field_isSend == 1) && (parambo.field_status == 1))
    {
      ac.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", new Object[] { this.GZE, Long.valueOf(bs.Ap(this.GZF)) });
      alg(this.GZE);
    }
    if (this.GZD)
    {
      localObject1 = null;
      if (e.GBO != null) {
        localObject1 = e.GBO.Z(parambo);
      }
      if (!bs.isNullOrNil((String)localObject1)) {
        break label976;
      }
    }
    label976:
    for (localObject2 = parambo.field_talker;; localObject2 = localObject1)
    {
      localObject1 = null;
      if (this.GZC.containsKey(localObject2)) {
        localObject1 = (h.c)this.GZC.get(localObject2);
      }
      if (localObject1 == null)
      {
        localObject1 = new h.c(parambo.field_talker, "insert", parambo);
        if (h.c.at(parambo)) {
          ((h.c)localObject1).rnT += 1;
        }
        ((h.c)localObject1).uHc += 1;
        this.GZC.put(localObject2, localObject1);
      }
      for (;;)
      {
        l = parambo.field_msgId;
        AppMethodBeat.o(117238);
        return l;
        ((h.c)localObject1).gtT.add(parambo);
        break;
        localObject1 = new h.c(parambo.field_talker, "insert", parambo);
        if (h.c.at(parambo)) {
          ((h.c)localObject1).rnT = 1;
        }
        ((h.c)localObject1).uHc = 1;
        doNotify();
        a((h.c)localObject1);
      }
    }
  }
  
  public final Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117301);
    if (paramLong2 == 0L)
    {
      paramString = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND createTime > " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      ac.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hpA.a(paramString, null, 0);
      AppMethodBeat.o(117301);
      return paramString;
    }
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      ac.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hpA.a(paramString, null, 0);
      AppMethodBeat.o(117301);
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
    long l = paramh.vE(Thread.currentThread().getId());
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
    paramh.qL(l);
    AppMethodBeat.o(117198);
  }
  
  public final Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117298);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM (SELECT * FROM " + alA(paramString) + " WHERE" + aMH(paramString) + aOo(paramString) + " AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime DESC LIMIT " + paramInt + " ) ORDER BY createTime ASC";
      ac.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hpA.a(paramString, null, 0);
      AppMethodBeat.o(117298);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final List<bo> dK(String paramString, int paramInt)
  {
    AppMethodBeat.i(117228);
    ArrayList localArrayList = new ArrayList();
    if (this.GZu != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND status = 3 AND type <> 10000 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hpA.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bo localbo = new bo();
        localbo.convertFrom(paramString);
        localArrayList.add(localbo);
      }
    }
    paramString.close();
    AppMethodBeat.o(117228);
    return localArrayList;
  }
  
  public final List<bo> dL(String paramString, int paramInt)
  {
    AppMethodBeat.i(117232);
    ArrayList localArrayList = new ArrayList();
    if (this.GZu != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hpA.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bo localbo = new bo();
        localbo.convertFrom(paramString);
        if (localbo.isText()) {
          localArrayList.add(localbo);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(117232);
    return localArrayList;
  }
  
  public final List<bo> dM(String paramString, int paramInt)
  {
    AppMethodBeat.i(209619);
    ArrayList localArrayList = new ArrayList();
    if (this.GZu != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + " ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hpA.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bo localbo = new bo();
        localbo.convertFrom(paramString);
        localArrayList.add(localbo);
      }
    }
    paramString.close();
    AppMethodBeat.o(209619);
    return localArrayList;
  }
  
  public final Cursor dN(String paramString, int paramInt)
  {
    AppMethodBeat.i(117248);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117248);
      return null;
    }
    String str = alA(paramString);
    paramString = "select * from " + str + " where" + aMH(paramString) + aOo(paramString) + " AND type & 65535 = 49" + "  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.hpA.a(paramString, null, 0);
    AppMethodBeat.o(117248);
    return paramString;
  }
  
  public final Cursor dO(String paramString, int paramInt)
  {
    AppMethodBeat.i(117249);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117249);
      return null;
    }
    Object localObject = alA(paramString);
    paramString = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend,imgPath from ").append((String)localObject).append(" where").append(aMH(paramString)).append(aOo(paramString)).append(" AND ");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" (type = 49");
    ((StringBuilder)localObject).append(" or type = 587202609");
    ((StringBuilder)localObject).append(" or type = 553648177) ");
    paramString = ((StringBuilder)localObject).toString() + " order by createTime DESC limit 100 OFFSET " + paramInt;
    paramString = this.hpA.a(paramString, null, 0);
    AppMethodBeat.o(117249);
    return paramString;
  }
  
  public final Cursor dP(String paramString, int paramInt)
  {
    AppMethodBeat.i(117245);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117245);
      return null;
    }
    String str = alA(paramString);
    paramString = "select * from ( select * from " + str + " where" + aOo(paramString) + " AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime DESC limit 200 OFFSET " + paramInt + ") order by createTime ASC ";
    paramString = this.hpA.a(paramString, null, 2);
    AppMethodBeat.o(117245);
    return paramString;
  }
  
  public final int dQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(117256);
    ac.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", new Object[] { paramString, Integer.valueOf(paramInt), com.tencent.mm.sdk.platformtools.as.eVp() });
    bo localbo = aF(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbo.field_talker));
    b(alA(paramString), "createTime<=? AND" + aOo(paramString), new String[] { localbo.field_createTime });
    paramInt = this.hpA.delete(alA(paramString), "createTime<=? AND" + aOo(paramString), new String[] { localbo.field_createTime });
    if (paramInt != 0)
    {
      doNotify();
      a(new h.c(paramString, "delete", null, paramInt, (byte)0));
    }
    AppMethodBeat.o(117256);
    return paramInt;
  }
  
  public final Cursor dR(String paramString, int paramInt)
  {
    AppMethodBeat.i(117257);
    bo localbo = aF(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbo.field_talker));
    paramString = this.hpA.query(alA(paramString), null, "createTime<=? AND" + aOo(paramString), new String[] { localbo.field_createTime }, null, null, null);
    AppMethodBeat.o(117257);
    return paramString;
  }
  
  public final Cursor dS(String paramString, int paramInt)
  {
    AppMethodBeat.i(117268);
    paramString = this.hpA.query(alA(paramString), null, "isSend=? AND" + aOo(paramString) + "AND status!=?  order by msgId DESC limit " + paramInt, new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117268);
    return paramString;
  }
  
  public final int dT(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117278);
    paramString = "SELECT COUNT(*) FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND type = " + paramInt;
    paramString = this.hpA.a(paramString, null, 2);
    paramInt = i;
    if (paramString.moveToFirst()) {
      paramInt = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117278);
    return paramInt;
  }
  
  public final Cursor dU(String paramString, int paramInt)
  {
    AppMethodBeat.i(117305);
    String str = " SELECT * FROM " + alA(paramString) + " WHERE" + aMH(paramString) + aOo(paramString) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + paramInt;
    ac.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    paramString = this.hpA.a(str, null, 0);
    AppMethodBeat.o(117305);
    return paramString;
  }
  
  public final bo[] dV(String paramString, int paramInt)
  {
    AppMethodBeat.i(117311);
    if ((paramString == null) || (paramString.length() == 0) || (paramInt <= 0))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + paramString + ", limit = " + paramInt);
      AppMethodBeat.o(117311);
      return null;
    }
    Object localObject = "select * from " + alA(paramString) + " where" + aOo(paramString) + "order by createTime DESC limit " + paramInt;
    localObject = this.hpA.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        bo localbo = new bo();
        localbo.convertFrom((Cursor)localObject);
        localArrayList.add(localbo);
      } while (((Cursor)localObject).moveToNext());
      ((Cursor)localObject).close();
      ac.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + paramString + ", limit = " + paramInt + ", count = " + localArrayList.size());
      Collections.reverse(localArrayList);
      paramString = (bo[])localArrayList.toArray(new bo[localArrayList.size()]);
      AppMethodBeat.o(117311);
      return paramString;
    }
    ac.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
    ((Cursor)localObject).close();
    AppMethodBeat.o(117311);
    return null;
  }
  
  public final Cursor dW(String paramString, int paramInt)
  {
    AppMethodBeat.i(117319);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117319);
      return null;
    }
    String str = alA(paramString);
    paramString = "select * from " + str + " where" + aMH(paramString) + aOo(paramString) + " AND type IN (436207665,419430449)  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.hpA.a(paramString, null, 0);
    AppMethodBeat.o(117319);
    return paramString;
  }
  
  public final void dcA()
  {
    AppMethodBeat.i(117204);
    int i = 0;
    while (i < this.GZu.size())
    {
      b((h.b)this.GZu.get(i));
      i += 1;
    }
    AppMethodBeat.o(117204);
  }
  
  public final void dcB()
  {
    AppMethodBeat.i(117206);
    if (!this.GZs)
    {
      AppMethodBeat.o(117206);
      return;
    }
    Object localObject = "select count(*) from " + "message" + " where talkerId ISNULL ";
    localObject = this.hpA.a((String)localObject, null, 2);
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
        ac.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", new Object[] { "message" });
        long l = System.currentTimeMillis();
        localObject = "update " + "message" + " set talkerId=(select rowid from rcontact where rcontact.username = " + "message" + ".talker)";
        boolean bool = this.hpA.execSQL("message", (String)localObject);
        ac.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
        if ((bool) && (this.GZs))
        {
          this.hpA.execSQL("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
          this.hpA.execSQL("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
          this.hpA.execSQL("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
          this.hpA.execSQL("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
          this.hpA.execSQL("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
          ac.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
        }
      }
      AppMethodBeat.o(117206);
      return;
    }
  }
  
  public final ArrayList<bo> dcC()
  {
    AppMethodBeat.i(117218);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.hpA.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[] { String.valueOf(System.currentTimeMillis() - 172800000L), "5", "1" }, null, null, "createTime ASC", 2);
    label149:
    while (localCursor.moveToNext())
    {
      bo localbo = new bo();
      localbo.convertFrom(localCursor);
      if (!localbo.fbW()) {}
      for (int i = 1;; i = 0)
      {
        if (((i & 0x1) == 0) || (ai.aMZ(localbo.field_talker)) || (ai.aNb(localbo.field_talker)) || (ai.ww(localbo.field_talker))) {
          break label149;
        }
        localArrayList.add(localbo);
        break;
      }
    }
    localCursor.close();
    AppMethodBeat.o(117218);
    return localArrayList;
  }
  
  public final List<bo> dcD()
  {
    AppMethodBeat.i(117231);
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    Object localObject1;
    int i;
    if (this.GZu != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject1 = new ArrayList();
      i = 0;
    }
    Object localObject2;
    for (;;)
    {
      if (i >= this.GZu.size()) {
        break label176;
      }
      localObject2 = this.hpA.a(((h.b)this.GZu.get(i)).name, null, "status=1 and isSend=1 and type IN (1,11,21,31,36,42,66,48,55,57)", null, null, null, "createTime", 100);
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label162;
        }
        bo localbo = new bo();
        localbo.convertFrom((Cursor)localObject2);
        if (com.tencent.mm.model.bi.ayX() - localbo.field_createTime > 86400000L)
        {
          ((List)localObject1).add(localbo);
          continue;
          bool = false;
          break;
        }
        localArrayList.add(localbo);
      }
      label162:
      ((Cursor)localObject2).close();
      i += 1;
    }
    label176:
    ac.i("MicroMsg.MsgInfoStorage", "getLastSendingMsgList listMsg:%s lstTimeoutMsg:%s", new Object[] { Integer.valueOf(localArrayList.size()), Integer.valueOf(((List)localObject1).size()) });
    if (((List)localObject1).size() > 0)
    {
      long l = this.hpA.vE(-1L);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bo)((Iterator)localObject1).next();
        ac.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d time:%s talker:%s content:%s", new Object[] { Long.valueOf(((dy)localObject2).field_msgId), Long.valueOf(((dy)localObject2).field_createTime), Integer.valueOf(((bo)localObject2).getType()), ((dy)localObject2).field_talker, bs.aLJ(((dy)localObject2).field_content) });
        ((bo)localObject2).setStatus(5);
        a(((dy)localObject2).field_msgId, (bo)localObject2);
      }
      this.hpA.qL(l);
    }
    AppMethodBeat.o(117231);
    return localArrayList;
  }
  
  public final Cursor dcE()
  {
    AppMethodBeat.i(117269);
    Cursor localCursor = this.hpA.query("message", new String[] { "talker", "count(*) as unReadCount" }, "isSend=? AND status!=?", new String[] { "0", "4" }, "talker", null, null);
    AppMethodBeat.o(117269);
    return localCursor;
  }
  
  public final String dcF()
  {
    return "type IN (3,39,13,43,62,44,268435505,486539313)";
  }
  
  public final String dcG()
  {
    return "type IN (3,39,13,43,62,44,49,268435505)";
  }
  
  public final int dcH()
  {
    AppMethodBeat.i(117295);
    ac.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf("SELECT COUNT(msgId) FROM message")));
    Cursor localCursor = this.hpA.a("SELECT COUNT(msgId) FROM message", null, 2);
    if (localCursor == null)
    {
      ac.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
      AppMethodBeat.o(117295);
      return 0;
    }
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      ac.d("MicroMsg.MsgInfoStorage", "result getAllMsgCount count %d", new Object[] { Integer.valueOf(i) });
      localCursor.close();
      AppMethodBeat.o(117295);
      return i;
    }
    localCursor.close();
    AppMethodBeat.o(117295);
    return 0;
  }
  
  /* Error */
  public final List<bo> dcI()
  {
    // Byte code:
    //   0: ldc_w 1875
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 553	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 554	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 145	com/tencent/mm/storage/bp:hpA	Lcom/tencent/mm/storagebase/h;
    //   18: ldc 71
    //   20: aconst_null
    //   21: ldc_w 1877
    //   24: iconst_1
    //   25: anewarray 61	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: invokestatic 538	java/lang/System:currentTimeMillis	()J
    //   33: ldc2_w 1229
    //   36: lsub
    //   37: invokestatic 687	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: ldc_w 1232
    //   46: iconst_2
    //   47: invokevirtual 714	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 717 1 0
    //   59: ifeq +75 -> 134
    //   62: aload_2
    //   63: astore_1
    //   64: new 249	com/tencent/mm/storage/bo
    //   67: dup
    //   68: invokespecial 718	com/tencent/mm/storage/bo:<init>	()V
    //   71: astore 4
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: aload_2
    //   78: invokevirtual 722	com/tencent/mm/storage/bo:convertFrom	(Landroid/database/Cursor;)V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload 4
    //   86: invokevirtual 725	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -39 -> 51
    //   93: astore_3
    //   94: aload_2
    //   95: astore_1
    //   96: ldc 184
    //   98: aload_3
    //   99: ldc_w 1234
    //   102: iconst_1
    //   103: anewarray 188	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_3
    //   109: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 695	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_2
    //   117: ifnull +9 -> 126
    //   120: aload_2
    //   121: invokeinterface 526 1 0
    //   126: ldc_w 1875
    //   129: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aconst_null
    //   133: areturn
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 526 1 0
    //   144: ldc_w 1875
    //   147: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_3
    //   151: areturn
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +9 -> 165
    //   159: aload_1
    //   160: invokeinterface 526 1 0
    //   165: ldc_w 1875
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
    //   0	183	0	this	bp
    //   52	108	1	localCursor1	Cursor
    //   50	89	2	localCursor2	Cursor
    //   152	20	2	localObject1	Object
    //   173	1	2	localObject2	Object
    //   179	1	2	localObject3	Object
    //   13	71	3	localArrayList	ArrayList
    //   93	58	3	localException1	Exception
    //   177	1	3	localException2	Exception
    //   71	14	4	localbo	bo
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
  
  public final void dcz()
  {
    AppMethodBeat.i(117201);
    g.agS();
    g.agR().agA().set(348167, Integer.valueOf(1));
    AppMethodBeat.o(117201);
  }
  
  public final int f(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117221);
    String str = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime ASC LIMIT -1 OFFSET " + paramInt;
    Cursor localCursor = this.hpA.a(str, null, 0);
    paramInt = localCursor.getCount();
    localCursor.close();
    ac.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + paramString + " time:" + paramLong + " count " + paramInt + " [" + str + "]");
    AppMethodBeat.o(117221);
    return paramInt;
  }
  
  public final long g(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117308);
    ac.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ac.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117308);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + alA(paramString) + " WHERE" + aMH(paramString) + aOo(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime DESC  LIMIT " + paramInt;
    ac.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hpA.a(paramString, null, 0);
    if (paramString == null)
    {
      ac.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(117308);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      ac.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(117308);
      return paramLong;
    }
    paramString.close();
    ac.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117308);
    return paramLong;
  }
  
  public final List<bo> g(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(117242);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(117242);
      return null;
    }
    paramLong = aP(paramString, paramLong);
    if (paramLong == 0L)
    {
      ac.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(117242);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (paramString = "select * from " + alA(paramString) + " where" + aMH(paramString) + aOo(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime > " + paramLong + " order by createTime ASC limit 10";; paramString = "select * from " + alA(paramString) + " where" + aMH(paramString) + aOo(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + paramLong + " order by createTime DESC limit 10")
    {
      paramString = this.hpA.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bo localbo = new bo();
        localbo.convertFrom(paramString);
        localArrayList.add(localbo);
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
    return this.hpA;
  }
  
  public final long h(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117310);
    ac.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ac.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117310);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + alA(paramString) + " WHERE" + aOo(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC  LIMIT " + paramInt;
    ac.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hpA.a(paramString, null, 0);
    if (paramString == null)
    {
      ac.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
      AppMethodBeat.o(117310);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      ac.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(117310);
      return paramLong;
    }
    paramString.close();
    ac.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117310);
    return paramLong;
  }
  
  public final bo hG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117225);
    if (bs.isNullOrNil(paramString1))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", new Object[] { paramString1 });
      AppMethodBeat.o(117225);
      return null;
    }
    bo localbo = new bo();
    paramString2 = "select * from " + alA(paramString1) + " where" + aOo(paramString1) + paramString2 + " order by createTime DESC limit 1";
    paramString2 = this.hpA.a(paramString2, null, 2);
    if (paramString2.moveToFirst()) {
      localbo.convertFrom(paramString2);
    }
    paramString2.close();
    ac.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", new Object[] { paramString1, Long.valueOf(localbo.field_msgId) });
    AppMethodBeat.o(117225);
    return localbo;
  }
  
  public final Cursor hH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117265);
    paramString1 = "SELECT * FROM " + alA(paramString1) + " WHERE" + aOo(paramString1) + "AND content LIKE '%" + paramString2 + "%' AND type = 1";
    paramString1 = paramString1 + " ORDER BY createTime DESC";
    paramString1 = this.hpA.a(paramString1, null, 0);
    AppMethodBeat.o(117265);
    return paramString1;
  }
  
  public final int hI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117306);
    String str = " SELECT COUNT(*) FROM " + alA(paramString1) + " WHERE" + aMH(paramString1) + aOo(paramString1) + "AND content LIKE '" + paramString2 + "%' ";
    Cursor localCursor = this.hpA.a(str, null, 2);
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
        ac.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(117306);
      }
      ac.d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(i), str });
      AppMethodBeat.o(117306);
      return i;
      label188:
      int i = 0;
    }
  }
  
  public final LinkedList<bo> hJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117312);
    paramString1 = this.hpA.a(alA(paramString1), null, "talker=? AND bizClientMsgId=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
    if (paramString1 != null) {}
    try
    {
      if (!paramString1.moveToFirst())
      {
        ac.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
        return null;
      }
      paramString2 = new LinkedList();
      do
      {
        bo localbo = new bo();
        localbo.convertFrom(paramString1);
        paramString2.add(localbo);
      } while (paramString1.moveToNext());
      paramString1.close();
      return paramString2;
    }
    catch (Exception paramString2)
    {
      ac.printErrStackTrace("MicroMsg.MsgInfoStorage", paramString2, "getLastDayC2CMsgByTalker error: %s", new Object[] { paramString2.getMessage() });
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
      paramString = this.hpA.a(paramString, null, 0);
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
    paramString = "SELECT * FROM " + alA(paramString) + " WHERE" + aOo(paramString) + " AND createTime <= " + paramLong + " order by createTime ASC limit " + paramInt;
    paramString = this.hpA.a(paramString, null, 0);
    AppMethodBeat.o(117264);
    return paramString;
  }
  
  public final Cursor n(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(117266);
    StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(alA(paramString)).append(" WHERE").append(aOo(paramString));
    if (paramLong > 0L) {}
    for (String str = " AND createTime > ".concat(String.valueOf(paramLong));; str = "")
    {
      str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
      ac.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
      paramString = this.hpA.a(str, null, 0);
      AppMethodBeat.o(117266);
      return paramString;
    }
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(117194);
    Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    AppMethodBeat.o(117194);
  }
  
  public final bo vP(long paramLong)
  {
    AppMethodBeat.i(117207);
    bo localbo = new bo();
    Cursor localCursor = this.hpA.a(AR(paramLong), null, "msgId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localbo.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117207);
    return localbo;
  }
  
  public final int vQ(long paramLong)
  {
    AppMethodBeat.i(117239);
    bo localbo = vP(paramLong);
    Object localObject = localbo.field_talker;
    this.GZB.m((int)(bs.aNx() / 86400L), localbo.field_msgSvrId, localbo.field_createTime / 1000L);
    int i = this.hpA.delete(AR(paramLong), "msgId=?", new String[] { String.valueOf(paramLong) });
    ((an)g.ab(an.class)).pI(paramLong);
    if (i != 0)
    {
      doNotify("delete_id ".concat(String.valueOf(paramLong)));
      localObject = new h.c((String)localObject, "delete", localbo, 1, (byte)0);
      ((h.c)localObject).uHe = paramLong;
      ((h.c)localObject).nxq = localbo.field_bizChatId;
      a((h.c)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(117239);
      return i;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 245L, 1L, false);
    }
  }
  
  public final boolean vR(long paramLong)
  {
    AppMethodBeat.i(117251);
    boolean bool = this.GZB.AP(paramLong);
    AppMethodBeat.o(117251);
    return bool;
  }
  
  public final boolean vS(long paramLong)
  {
    AppMethodBeat.i(117287);
    int i = 0;
    while (i < this.GZu.size())
    {
      if (((h.b)this.GZu.get(i)).vU(paramLong))
      {
        AppMethodBeat.o(117287);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(117287);
    return false;
  }
  
  public final void vT(long paramLong)
  {
    AppMethodBeat.i(117313);
    this.GZB.b(0, paramLong, 0L, false);
    AppMethodBeat.o(117313);
  }
  
  public final int yn(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117276);
    paramString = "SELECT COUNT(*) FROM " + alA(paramString) + " WHERE" + aMH(paramString) + aOo(paramString);
    paramString = this.hpA.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117276);
    return i;
  }
  
  public final boolean yo(String paramString)
  {
    AppMethodBeat.i(117275);
    boolean bool = "message".equals(alA(paramString));
    AppMethodBeat.o(117275);
    return bool;
  }
  
  public final Cursor z(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117244);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117244);
      return null;
    }
    String str = alA(paramString);
    paramString = "select * from " + str + " where" + aOo(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.hpA.a(paramString, null, 2);
    AppMethodBeat.o(117244);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bp
 * JD-Core Version:    0.7.0.1
 */