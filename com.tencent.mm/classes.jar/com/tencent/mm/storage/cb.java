package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storagebase.f.a;
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

public final class cb
  extends MStorage
  implements i
{
  public static final String[] SQL_CREATE;
  private final long SECONDS_OF_DAY;
  private boolean VHb;
  private final List<e> VHc;
  private List<i.b> VHd;
  private final com.tencent.mm.b.f<Integer, ca.c> VHe;
  private final com.tencent.mm.b.f<Integer, ca.d> VHf;
  private final com.tencent.mm.b.f<Integer, ca.a> VHg;
  private final com.tencent.mm.b.f<Integer, ca.b> VHh;
  private final com.tencent.mm.b.f<Integer, Object> VHi;
  private final com.tencent.mm.b.f<String, Long> VHj;
  private bc VHk;
  private final Map<String, i.c> VHl;
  private boolean VHm;
  private String VHn;
  private long VHo;
  private final MStorageEvent<i.a, i.c> Vep;
  private final com.tencent.mm.storagebase.h lvy;
  private bv rSt;
  private bw rSv;
  
  static
  {
    AppMethodBeat.i(117320);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status" + " INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker" + " TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer" + " BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag" + " INT, solitaireFoldInfo BLOB, historyId TEXT) " };
    AppMethodBeat.o(117320);
  }
  
  public cb(com.tencent.mm.storagebase.h paramh, bv parambv, bw parambw)
  {
    AppMethodBeat.i(117202);
    this.VHb = false;
    this.VHc = new CopyOnWriteArrayList();
    this.VHe = new com.tencent.mm.memory.a.c(100);
    this.VHf = new com.tencent.mm.memory.a.c(100);
    this.VHg = new com.tencent.mm.memory.a.c(100);
    this.VHh = new com.tencent.mm.memory.a.c(100);
    this.VHi = new com.tencent.mm.memory.a.c(100);
    this.VHj = new com.tencent.mm.memory.a.c(100);
    this.VHk = new bc();
    this.Vep = new MStorageEvent()
    {
      public final void handleNotify(List<i.c> paramAnonymousList)
      {
        AppMethodBeat.i(117187);
        if ((!isLocked()) && (cb.a(cb.this) != null))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            i.c localc = (i.c)paramAnonymousList.next();
            if (localc != null) {
              cb.a(cb.this).a(cb.this, localc);
            }
          }
        }
        AppMethodBeat.o(117187);
      }
    };
    this.VHl = new HashMap();
    this.VHm = false;
    this.VHn = "";
    this.VHo = 0L;
    this.SECONDS_OF_DAY = 86400L;
    this.lvy = paramh;
    this.rSt = parambv;
    this.rSv = parambw;
    if (z.bdR() == 0)
    {
      Log.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", new Object[] { Integer.valueOf(this.lvy.delete("message", "msgId> ? ", new String[] { "80000000" })) });
      z.bdQ();
    }
    e(paramh, "message");
    hAu();
    if (this.VHd == null) {
      this.VHd = new LinkedList();
    }
    this.VHd.clear();
    a(new i.b(1, "message", i.b.b(1L, 1000000L, 10000000L, 90000000L)));
    AppMethodBeat.o(117202);
  }
  
  private String UW(long paramLong)
  {
    AppMethodBeat.i(117288);
    if ((paramLong == 0L) || (paramLong == -1L))
    {
      AppMethodBeat.o(117288);
      return null;
    }
    ca.UV(paramLong);
    int i = 0;
    while (i < this.VHd.size())
    {
      if (((i.b)this.VHd.get(i)).Ov(paramLong))
      {
        String str = ((i.b)this.VHd.get(i)).name;
        AppMethodBeat.o(117288);
        return str;
      }
      i += 1;
    }
    Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[] { Long.valueOf(paramLong) }), false);
    AppMethodBeat.o(117288);
    return null;
  }
  
  private void b(i.b paramb)
  {
    AppMethodBeat.i(117205);
    Cursor localCursor = this.lvy.rawQuery("select max(msgid) from " + paramb.name, null, 2);
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      Log.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d tableName: %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramb.lNP), paramb.name });
      if (i >= paramb.lNP) {
        paramb.WD(i);
      }
    }
    localCursor.close();
    Log.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + paramb.lNP);
    AppMethodBeat.o(117205);
  }
  
  private static void bt(ca paramca)
  {
    AppMethodBeat.i(117236);
    if ((paramca == null) || (!paramca.erk()))
    {
      AppMethodBeat.o(117236);
      return;
    }
    try
    {
      String str = paramca.field_content;
      int i = str.indexOf("<msg>");
      Object localObject = str;
      if (i > 0)
      {
        localObject = str;
        if (i < str.length()) {
          localObject = str.substring(i).trim();
        }
      }
      localObject = XmlParser.parseXml((String)localObject, "msg", null);
      if ((localObject != null) && (((Map)localObject).size() > 0)) {
        paramca.Jo(SemiXml.encode((Map)localObject));
      }
      AppMethodBeat.o(117236);
      return;
    }
    catch (Exception paramca)
    {
      Log.e("MicroMsg.MsgInfoStorage", paramca.getMessage());
      AppMethodBeat.o(117236);
    }
  }
  
  private static String bvg(String paramString)
  {
    AppMethodBeat.i(177115);
    long l = ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aOu(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(177115);
      return paramString;
    }
    AppMethodBeat.o(177115);
    return "";
  }
  
  private String bxd(String paramString)
  {
    AppMethodBeat.i(117216);
    String str = aOY(paramString);
    if ((this.VHb) && (str.equals("message")))
    {
      paramString = " talkerId=" + bxe(paramString) + " ";
      AppMethodBeat.o(117216);
      return paramString;
    }
    paramString = " talker= '" + Util.escapeSqlValue(paramString) + "' ";
    AppMethodBeat.o(117216);
    return paramString;
  }
  
  private long bxe(String paramString)
  {
    AppMethodBeat.i(117217);
    long l2 = this.rSt.bwk(paramString);
    if (l2 < 0L) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = l2;
      if (bool)
      {
        l1 = l2;
        if (!ab.Qg(paramString))
        {
          l1 = l2;
          if (!ab.Qh(paramString))
          {
            as localas = new as(paramString);
            localas.setType(2);
            this.rSt.av(localas);
            l1 = this.rSt.bwk(paramString);
          }
        }
      }
      if (!CrashReportFactory.isBackupMerge()) {
        Log.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", new Object[] { paramString, Long.valueOf(l1), Boolean.valueOf(bool), "" });
      }
      AppMethodBeat.o(117217);
      return l1;
    }
  }
  
  private static String bxf(String paramString)
  {
    AppMethodBeat.i(117235);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117235);
      return null;
    }
    try
    {
      paramString = XmlParser.parseXml(paramString, "msgsource", null);
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
      Log.e("MicroMsg.MsgInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      Log.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(117235);
    }
    return null;
  }
  
  private String bxg(String paramString)
  {
    AppMethodBeat.i(117277);
    if ((paramString == null) || (!paramString.equals("message")))
    {
      AppMethodBeat.o(117277);
      return "";
    }
    if (this.VHb)
    {
      AppMethodBeat.o(117277);
      return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
    }
    AppMethodBeat.o(117277);
    return "INDEXED BY messageCreateTaklerTypeTimeIndex";
  }
  
  private i.b bxh(String paramString)
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
      if (i >= this.VHd.size()) {
        break label98;
      }
      if (paramString.equals(((i.b)this.VHd.get(i)).name))
      {
        paramString = (i.b)this.VHd.get(i);
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
  
  private String bxi(String paramString)
  {
    AppMethodBeat.i(117285);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Iterator localIterator = this.VHc.iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = ((e)localIterator.next()).aEK(paramString);
      } while (Util.isNullOrNil(str));
      AppMethodBeat.o(117285);
      return str;
    }
    AppMethodBeat.o(117285);
    return "message";
  }
  
  private i.b bxj(String paramString)
  {
    AppMethodBeat.i(117286);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = bxh(bxi(paramString));
      AppMethodBeat.o(117286);
      return paramString;
    }
  }
  
  private void hAu()
  {
    AppMethodBeat.i(117200);
    long l1 = System.currentTimeMillis();
    long l2 = this.lvy.beginTransaction(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new String[13];
    arrayOfString[0] = ("CREATE INDEX IF NOT EXISTS " + "message" + "IdIndex ON message ( msgId )");
    arrayOfString[1] = ("CREATE INDEX IF NOT EXISTS " + "message" + "SvrIdIndex ON message ( msgSvrId )");
    arrayOfString[2] = ("CREATE INDEX IF NOT EXISTS " + "message" + "SendCreateTimeIndex ON message ( status,isSend,createTime" + " )");
    arrayOfString[3] = ("CREATE INDEX IF NOT EXISTS " + "message" + "CreateTimeIndex ON message ( createTime )");
    arrayOfString[4] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TaklerIdTypeCreateTimeIndex ON message ( talkerId,type,createTime" + " )");
    arrayOfString[5] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdStatusIndex ON message ( talkerId,status )");
    arrayOfString[6] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdCreateTimeIsSendIndex ON message ( talkerId,isSend,createTime" + " )");
    arrayOfString[7] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdCreateTimeIndex ON message ( talkerId,createTime )");
    arrayOfString[8] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdSvrIdIndex ON message ( talkerId,msgSvrId )");
    arrayOfString[9] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdTypeIndex ON message ( talkerId,type )");
    arrayOfString[10] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerTypeIndex ON message ( talker,type )");
    arrayOfString[11] = ("CREATE INDEX IF NOT EXISTS " + "message" + "messageTalkerMsgSeqIndex ON message ( talker,msgSeq )");
    arrayOfString[12] = ("CREATE INDEX IF NOT EXISTS " + "message" + "messageTalkerFlagMsgSeqIndex ON message ( talker,flag,msgSeq" + " )");
    if (!this.VHb)
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
      this.lvy.execSQL("message", (String)localArrayList.get(i));
      i += 1;
    }
    Log.i("MicroMsg.MsgInfoStorage", "build new index last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    this.lvy.endTransaction(l2);
    Log.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(117200);
  }
  
  private static String hAv()
  {
    AppMethodBeat.i(189071);
    String str = "type & 65535 = 49";
    AppMethodBeat.o(189071);
    return str;
  }
  
  private List<ca> z(int paramInt, List<i.b> paramList)
  {
    AppMethodBeat.i(188896);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Cursor localCursor = this.lvy.query(((i.b)paramList.get(i)).name, null, "status=1 and isSend=1 and type IN (1,11,21,31,36,42,66,48," + "55,57)", null, null, null, "createTime", 100);
      while (localCursor.moveToNext())
      {
        ca localca = new ca();
        localca.convertFrom(localCursor);
        if (bq.beS() - localca.field_createTime > 86400000L) {
          ((List)localObject).add(localca);
        } else {
          localArrayList.add(localca);
        }
      }
      localCursor.close();
      i += 1;
    }
    if (localArrayList.size() > paramInt) {}
    for (paramList = localArrayList.subList(0, paramInt);; paramList = localArrayList)
    {
      Log.i("MicroMsg.MsgInfoStorage", "getLastSendingMsgList limit:%s listMsg:%s lstTimeoutMsg:%s limitListMsg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localArrayList.size()), Integer.valueOf(((List)localObject).size()), Integer.valueOf(paramList.size()) });
      if (((List)localObject).size() > 0)
      {
        long l = this.lvy.beginTransaction(-1L);
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext())
        {
          localObject = (ca)paramList.next();
          Log.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d time:%s talker:%s content:%s", new Object[] { Long.valueOf(((et)localObject).field_msgId), Long.valueOf(((et)localObject).field_createTime), Integer.valueOf(((ca)localObject).getType()), ((et)localObject).field_talker, Util.secPrint(((et)localObject).field_content) });
          ((ca)localObject).setStatus(5);
          a(((et)localObject).field_msgId, (ca)localObject);
        }
        this.lvy.endTransaction(l);
      }
      AppMethodBeat.o(188896);
      return localArrayList;
    }
  }
  
  public final Cursor A(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117244);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117244);
      return null;
    }
    String str = aOY(paramString);
    paramString = "select * from " + str + " where" + bxd(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.lvy.rawQuery(paramString, null, 2);
    AppMethodBeat.o(117244);
    return paramString;
  }
  
  public final Cursor B(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117246);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117246);
      return null;
    }
    String str = aOY(paramString);
    paramString = "select * from " + str + " where" + bxd(paramString) + "AND type IN (3,39,13,43,62,44,49,1090519089,268435505) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.lvy.rawQuery(paramString, null, 2);
    AppMethodBeat.o(117246);
    return paramString;
  }
  
  public final int C(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(117279);
    paramString = "SELECT COUNT(*) FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND type = 50 AND createTime >= " + paramLong1 + " AND createTime <= " + paramLong2 + " LIMIT 1";
    paramString = this.lvy.rawQuery(paramString, null, 2);
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
      Log.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      paramString = "SELECT COUNT(msgId) FROM " + aOY(paramString) + " WHERE" + bvg(paramString) + bxd(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      Log.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf(paramString)));
      paramString = this.lvy.rawQuery(paramString, null, 2);
      if (paramString == null)
      {
        Log.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
        AppMethodBeat.o(117294);
        return 0;
      }
      if (paramString.moveToFirst())
      {
        int i = paramString.getInt(0);
        Log.d("MicroMsg.MsgInfoStorage", "result msg count %d", new Object[] { Integer.valueOf(i) });
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
      paramString = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime ASC ";
      Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.lvy.rawQuery(paramString, null);
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
      StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ( SELECT * FROM ").append(aOY(paramString)).append(" WHERE").append(bxd(paramString));
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
        Log.d("MicroMsg.MsgInfoStorage", "getCountAfterStratTimeBeforeEndTime talk:%s [%s]", new Object[] { paramString, str });
        paramString = this.lvy.rawQuery(str, null, 2);
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
            Log.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
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
      paramString = "SELECT COUNT(*) FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1;
      paramString = this.lvy.rawQuery(paramString, null, 2);
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
          Log.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
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
  
  public final Cursor H(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(117264);
    paramString = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + " AND createTime <= " + paramLong + " order by createTime ASC limit " + paramInt;
    paramString = this.lvy.rawQuery(paramString, null);
    AppMethodBeat.o(117264);
    return paramString;
  }
  
  public final Cursor H(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117303);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.lvy.rawQuery(paramString, null);
      AppMethodBeat.o(117303);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final Cursor I(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(117266);
    StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(aOY(paramString)).append(" WHERE").append(bxd(paramString));
    if (paramLong > 0L) {}
    for (String str = " AND createTime > ".concat(String.valueOf(paramLong));; str = "")
    {
      str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
      Log.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
      paramString = this.lvy.rawQuery(str, null);
      AppMethodBeat.o(117266);
      return paramString;
    }
  }
  
  /* Error */
  public final List<ca> I(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 789
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 6
    //   9: new 541	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 542	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: getfield 153	com/tencent/mm/storage/cb:lvy	Lcom/tencent/mm/storagebase/h;
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 393	com/tencent/mm/storage/cb:aOY	(Ljava/lang/String;)Ljava/lang/String;
    //   27: aconst_null
    //   28: new 63	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 790	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 681	com/tencent/mm/storage/cb:bxd	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 792
    //   46: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: iconst_2
    //   53: anewarray 61	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: lload_2
    //   59: invokestatic 752	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: lload 4
    //   67: invokestatic 752	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   70: aastore
    //   71: aconst_null
    //   72: aconst_null
    //   73: ldc_w 794
    //   76: iconst_2
    //   77: invokevirtual 621	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   80: astore_1
    //   81: aload_1
    //   82: astore 6
    //   84: aload 6
    //   86: astore_1
    //   87: aload 6
    //   89: invokeinterface 624 1 0
    //   94: ifeq +86 -> 180
    //   97: aload 6
    //   99: astore_1
    //   100: new 236	com/tencent/mm/storage/ca
    //   103: dup
    //   104: invokespecial 625	com/tencent/mm/storage/ca:<init>	()V
    //   107: astore 8
    //   109: aload 6
    //   111: astore_1
    //   112: aload 8
    //   114: aload 6
    //   116: invokevirtual 629	com/tencent/mm/storage/ca:convertFrom	(Landroid/database/Cursor;)V
    //   119: aload 6
    //   121: astore_1
    //   122: aload 7
    //   124: aload 8
    //   126: invokevirtual 795	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: goto -46 -> 84
    //   133: astore 7
    //   135: aload 6
    //   137: astore_1
    //   138: ldc 165
    //   140: aload 7
    //   142: ldc_w 797
    //   145: iconst_1
    //   146: anewarray 169	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload 7
    //   153: invokevirtual 361	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 760	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aload 6
    //   162: ifnull +10 -> 172
    //   165: aload 6
    //   167: invokeinterface 300 1 0
    //   172: ldc_w 789
    //   175: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: aload 6
    //   182: ifnull +10 -> 192
    //   185: aload 6
    //   187: invokeinterface 300 1 0
    //   192: ldc_w 789
    //   195: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 7
    //   200: areturn
    //   201: astore_1
    //   202: aload 6
    //   204: ifnull +10 -> 214
    //   207: aload 6
    //   209: invokeinterface 300 1 0
    //   214: ldc_w 789
    //   217: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	241	0	this	cb
    //   0	241	1	paramString	String
    //   0	241	2	paramLong1	long
    //   0	241	4	paramLong2	long
    //   7	230	6	str	String
    //   16	107	7	localArrayList	ArrayList
    //   133	66	7	localException1	Exception
    //   222	6	7	localObject	Object
    //   233	1	7	localException2	Exception
    //   107	18	8	localca	ca
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
  
  public final ca Oq(long paramLong)
  {
    AppMethodBeat.i(117207);
    ca localca = new ca();
    Cursor localCursor = this.lvy.query(UW(paramLong), null, "msgId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localca.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117207);
    return localca;
  }
  
  public final int Or(long paramLong)
  {
    AppMethodBeat.i(117239);
    ca localca = Oq(paramLong);
    Object localObject = localca.field_talker;
    this.VHk.y((int)(Util.nowSecond() / 86400L), localca.field_msgSvrId, localca.field_createTime / 1000L);
    int i = this.lvy.delete(UW(paramLong), "msgId=?", new String[] { String.valueOf(paramLong) });
    ((av)com.tencent.mm.kernel.h.ae(av.class)).Gi(paramLong);
    if (i != 0)
    {
      doNotify("delete_id ".concat(String.valueOf(paramLong)));
      localObject = new i.c((String)localObject, "delete", localca, 1, (byte)0);
      ((i.c)localObject).EVP = paramLong;
      ((i.c)localObject).syu = localca.field_bizChatId;
      a((i.c)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(117239);
      return i;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 245L, 1L, false);
    }
  }
  
  public final boolean Os(long paramLong)
  {
    AppMethodBeat.i(117251);
    boolean bool = this.VHk.UU(paramLong);
    AppMethodBeat.o(117251);
    return bool;
  }
  
  public final boolean Ot(long paramLong)
  {
    AppMethodBeat.i(117287);
    int i = 0;
    while (i < this.VHd.size())
    {
      if (((i.b)this.VHd.get(i)).Ov(paramLong))
      {
        AppMethodBeat.o(117287);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(117287);
    return false;
  }
  
  public final void Ou(long paramLong)
  {
    AppMethodBeat.i(117313);
    this.VHk.b(0, paramLong, 0L, false);
    AppMethodBeat.o(117313);
  }
  
  public final int RN(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117276);
    paramString = "SELECT COUNT(*) FROM " + aOY(paramString) + " WHERE" + bvg(paramString) + bxd(paramString);
    paramString = this.lvy.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117276);
    return i;
  }
  
  public final boolean RO(String paramString)
  {
    AppMethodBeat.i(117275);
    boolean bool = "message".equals(aOY(paramString));
    AppMethodBeat.o(117275);
    return bool;
  }
  
  public final ca WB(int paramInt)
  {
    AppMethodBeat.i(117229);
    if (this.VHd == null)
    {
      Log.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117229);
      return null;
    }
    ca localca = new ca();
    long l1 = 0L;
    int i = 0;
    while (i < this.VHd.size())
    {
      long l2 = l1;
      if ((((i.b)this.VHd.get(i)).EVJ & paramInt) != 0)
      {
        Object localObject = "select * from " + ((i.b)this.VHd.get(i)).name + "  order by createTime DESC limit 1";
        localObject = this.lvy.rawQuery((String)localObject, null, 2);
        l2 = l1;
        if (((Cursor)localObject).moveToFirst())
        {
          long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
          l2 = l1;
          if (l1 < l3)
          {
            localca.convertFrom((Cursor)localObject);
            l2 = l3;
          }
        }
        ((Cursor)localObject).close();
      }
      i += 1;
      l1 = l2;
    }
    AppMethodBeat.o(117229);
    return localca;
  }
  
  public final List<ca> WC(int paramInt)
  {
    AppMethodBeat.i(188890);
    Object localObject = new LinkedList();
    int i = 0;
    while (i < this.VHd.size())
    {
      String str = ((i.b)this.VHd.get(i)).name;
      if ((!str.startsWith("findermessage")) && (!str.equalsIgnoreCase("gamelifemessage"))) {
        ((List)localObject).add(this.VHd.get(i));
      }
      i += 1;
    }
    localObject = z(paramInt, (List)localObject);
    AppMethodBeat.o(188890);
    return localObject;
  }
  
  public final void a(long paramLong, ca paramca)
  {
    AppMethodBeat.i(117258);
    if (paramca.hzw())
    {
      String str = bxf(paramca.hxy);
      if (ab.QR(str))
      {
        Log.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
        paramca.Jm("notifymessage");
      }
    }
    if (paramca.getType() == 1075839025) {
      paramca.Jm("notifymessage");
    }
    bt(paramca);
    if (this.lvy.update(UW(paramLong), paramca.convertTo(), "msgId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new i.c(paramca.field_talker, "update", paramca));
      AppMethodBeat.o(117258);
      return;
    }
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 244L, 1L, false);
    AppMethodBeat.o(117258);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(117192);
    this.Vep.remove(parama);
    AppMethodBeat.o(117192);
  }
  
  public final void a(i.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(117191);
    this.Vep.add(parama, paramLooper);
    AppMethodBeat.o(117191);
  }
  
  public final void a(i.b paramb)
  {
    AppMethodBeat.i(117203);
    synchronized (this.VHd)
    {
      this.VHd.add(paramb);
      b(paramb);
      AppMethodBeat.o(117203);
      return;
    }
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(117190);
    if (this.Vep.event(paramc)) {
      this.Vep.doNotify();
    }
    AppMethodBeat.o(117190);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(117189);
    if (!this.VHc.contains(parame))
    {
      Log.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", new Object[] { parame });
      this.VHc.add(parame);
    }
    AppMethodBeat.o(117189);
  }
  
  public final void aF(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(117219);
    long l1 = this.lvy.beginTransaction(-1L);
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        long l2 = ((Long)paramArrayList.next()).longValue();
        ca localca = Oq(l2);
        localca.pp(localca.hxx | 0x20);
        Log.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
        a(l2, localca);
      }
      this.lvy.endTransaction(l1);
    }
    finally
    {
      this.lvy.endTransaction(l1);
      AppMethodBeat.o(117219);
    }
    AppMethodBeat.o(117219);
  }
  
  public final void aK(String paramString, long paramLong)
  {
    AppMethodBeat.i(117199);
    i.b localb = bxj(paramString);
    long l = localb.lNP;
    Random localRandom = new Random();
    this.lvy.execSQL("message", "BEGIN;");
    ca localca = new ca(paramString);
    int i = 0;
    while (i < paramLong)
    {
      localca.setCreateTime(System.currentTimeMillis());
      localca.setType(1);
      localca.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + Util.random());
      localca.setMsgId(l);
      localca.setStatus(localRandom.nextInt(4));
      localca.pJ(localRandom.nextInt(1));
      l += 1L;
      localb.lNP += 1L;
      localca.EG(System.currentTimeMillis() + Util.random());
      this.lvy.execSQL("message", "INSERT INTO " + aOY(localca.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + localca.field_msgId + "," + localca.field_msgSvrId + "," + localca.getType() + "," + localca.field_status + "," + localca.field_createTime + ",'" + localca.field_talker + "','" + localca.field_content + "'," + bxe(paramString) + ");");
      if (i % 10000 == 0)
      {
        this.lvy.execSQL("message", "COMMIT;");
        this.lvy.execSQL("message", "BEGIN;");
      }
      i += 1;
    }
    this.lvy.execSQL("message", "COMMIT;");
    this.rSv.bwy(paramString);
    localca.setMsgId(1L + l);
    c(localca, false);
    AppMethodBeat.o(117199);
  }
  
  public final int aL(ca paramca)
  {
    int i = 0;
    AppMethodBeat.i(117234);
    if ((paramca == null) || (Util.isNullOrNil(paramca.field_talker)))
    {
      AppMethodBeat.o(117234);
      return 0;
    }
    paramca = "SELECT count(msgId) FROM " + aOY(paramca.field_talker) + " WHERE" + bxd(paramca.field_talker) + "AND isSend = 0 AND msgId >= " + paramca.field_msgId + " ORDER BY createTime DESC";
    paramca = this.lvy.rawQuery(paramca, null, 2);
    if (paramca.moveToFirst()) {
      i = paramca.getInt(0);
    }
    paramca.close();
    AppMethodBeat.o(117234);
    return i;
  }
  
  public final ca aL(String paramString, long paramLong)
  {
    AppMethodBeat.i(117208);
    ca localca = new ca();
    paramString = this.lvy.query(aOY(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localca.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117208);
    return localca;
  }
  
  public final long aM(ca paramca)
  {
    AppMethodBeat.i(292897);
    long l = c(paramca, false);
    AppMethodBeat.o(292897);
    return l;
  }
  
  public final ca aM(String paramString, long paramLong)
  {
    AppMethodBeat.i(117209);
    ca localca = new ca();
    paramString = this.lvy.query(aOY(paramString), null, bxd(paramString) + " AND msgSeq=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localca.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117209);
    return localca;
  }
  
  public final ca aN(String paramString, long paramLong)
  {
    AppMethodBeat.i(117210);
    ca localca = new ca();
    paramString = this.lvy.query(aOY(paramString), null, "createTime=? AND" + bxd(paramString), new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localca.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117210);
    return localca;
  }
  
  public final void aN(ca paramca)
  {
    AppMethodBeat.i(117259);
    if ((paramca == null) || (paramca.field_status == 4))
    {
      AppMethodBeat.o(117259);
      return;
    }
    paramca.setStatus(4);
    String str = UW(paramca.field_msgId);
    if ((str != null) && (str.length() > 0)) {
      if (this.lvy.update(str, paramca.convertTo(), "msgId=?", new String[] { paramca.field_msgId }) != 0)
      {
        doNotify();
        a(new i.c(paramca.field_talker, "update", paramca, -1));
      }
    }
    AppMethodBeat.o(117259);
  }
  
  public final int aO(ca paramca)
  {
    int i = 0;
    AppMethodBeat.i(117262);
    if (paramca != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("content", paramca.field_content);
      localContentValues.put("status", Integer.valueOf(paramca.field_status));
      int j = this.lvy.update(UW(paramca.field_msgId), localContentValues, "msgId=?", new String[] { String.valueOf(paramca.field_msgId) });
      i = j;
      if (j != 0)
      {
        doNotify();
        a(new i.c(paramca.field_talker, "update", paramca));
        i = j;
      }
    }
    AppMethodBeat.o(117262);
    return i;
  }
  
  public final ca aO(String paramString, long paramLong)
  {
    AppMethodBeat.i(117214);
    ca localca = new ca();
    paramString = "Select * From " + aOY(paramString) + " Where " + bxd(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
    paramString = this.lvy.rawQuery(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localca.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117214);
    return localca;
  }
  
  public final void aOC(String paramString)
  {
    AppMethodBeat.i(117195);
    Log.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.VHm), Integer.valueOf(super.lockCount()), Integer.valueOf(this.Vep.lockCount()), Integer.valueOf(this.VHl.size()), this.VHn, Long.valueOf(Util.milliSecondsToNow(this.VHo)) });
    if (Util.isNullOrNil(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (this.VHm)
    {
      Log.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", new Object[] { this.VHn, Long.valueOf(Util.milliSecondsToNow(this.VHo)) });
      AppMethodBeat.o(117195);
      return;
    }
    this.VHn = paramString;
    this.VHo = Util.nowMilliSecond();
    this.VHm = true;
    super.lock();
    this.Vep.lock();
    AppMethodBeat.o(117195);
  }
  
  public final void aOD(String arg1)
  {
    AppMethodBeat.i(117196);
    Log.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { ???, Boolean.valueOf(this.VHm), Integer.valueOf(super.lockCount()), Integer.valueOf(this.Vep.lockCount()), Integer.valueOf(this.VHl.size()), this.VHn, Long.valueOf(Util.milliSecondsToNow(this.VHo)) });
    if (Util.isNullOrNil(???)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (!this.VHm)
    {
      Log.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", new Object[] { ???, Util.getStack() });
      AppMethodBeat.o(117196);
      return;
    }
    if (!???.equals(this.VHn))
    {
      Log.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", new Object[] { this.VHn, Long.valueOf(Util.milliSecondsToNow(this.VHo)), ??? });
      AppMethodBeat.o(117196);
      return;
    }
    this.VHm = false;
    this.VHo = 0L;
    this.VHn = "";
    synchronized (this.VHl)
    {
      Iterator localIterator = this.VHl.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a((i.c)this.VHl.get(str));
      }
    }
    this.VHl.clear();
    super.unlock();
    this.Vep.unlock();
    doNotify();
    AppMethodBeat.o(117196);
  }
  
  public final void aOE(String paramString)
  {
    AppMethodBeat.i(117197);
    if (!this.VHm)
    {
      AppMethodBeat.o(117197);
      return;
    }
    i.c localc = null;
    synchronized (this.VHl)
    {
      if (this.VHl.containsKey(paramString)) {
        localc = (i.c)this.VHl.get(paramString);
      }
      if (localc == null)
      {
        Log.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", new Object[] { paramString, Util.getStack() });
        AppMethodBeat.o(117197);
        return;
      }
    }
    if ((localc.EVM != null) && (localc.EVM.equals("insert")) && (localc.xKO > 0))
    {
      Log.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", new Object[] { paramString, Integer.valueOf(localc.xKO) });
      localc.xKO = 0;
    }
    AppMethodBeat.o(117197);
  }
  
  public final Cursor aOF(String paramString)
  {
    AppMethodBeat.i(117211);
    com.tencent.mm.storagebase.h localh = this.lvy;
    String str = aOY(paramString);
    paramString = bvg(paramString) + bxd(paramString);
    paramString = localh.query(str, new String[] { "createTime", "msgId" }, paramString, null, "createTime", null, "createTime ASC");
    AppMethodBeat.o(117211);
    return paramString;
  }
  
  public final ca aOG(String paramString)
  {
    AppMethodBeat.i(117222);
    ca localca = new ca();
    paramString = this.lvy.query(aOY(paramString), null, bxd(paramString), null, null, null, "msgSvrId  DESC limit 1 ", 2);
    if (paramString.moveToFirst()) {
      localca.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117222);
    return localca;
  }
  
  public final ca aOH(String paramString)
  {
    AppMethodBeat.i(117223);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117223);
      return null;
    }
    ca localca = new ca();
    paramString = "select * from " + aOY(paramString) + " where" + bvg(paramString) + bxd(paramString) + "order by createTime DESC limit 1";
    paramString = this.lvy.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localca.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117223);
    return localca;
  }
  
  public final ca aOI(String paramString)
  {
    AppMethodBeat.i(188874);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(188874);
      return null;
    }
    ca localca = new ca();
    paramString = "select * from " + aOY(paramString) + " where" + bvg(paramString) + bxd(paramString) + "order by createTime ASC limit 1";
    paramString = this.lvy.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localca.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(188874);
    return localca;
  }
  
  public final ca aOJ(String paramString)
  {
    AppMethodBeat.i(117226);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117226);
      return null;
    }
    ca localca = new ca();
    paramString = "select * from " + aOY(paramString) + " where" + bxd(paramString) + "and isSend = 0  order by createTime DESC limit 1";
    paramString = this.lvy.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localca.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117226);
    return localca;
  }
  
  public final ca aOK(String paramString)
  {
    AppMethodBeat.i(117230);
    if (this.VHd == null)
    {
      Log.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117230);
      return null;
    }
    ca localca = new ca();
    long l1 = 0L;
    if (Util.isNullOrNil(paramString)) {}
    for (paramString = "";; paramString = paramString.replaceFirst("and", "where"))
    {
      int i = 0;
      while (i < this.VHd.size())
      {
        long l2 = l1;
        if ((((i.b)this.VHd.get(i)).EVJ & 0x8) != 0)
        {
          Object localObject = "select * from " + ((i.b)this.VHd.get(i)).name + paramString + "  order by createTime DESC limit 1";
          localObject = this.lvy.rawQuery((String)localObject, null, 2);
          l2 = l1;
          if (((Cursor)localObject).moveToFirst())
          {
            long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
            l2 = l1;
            if (l1 < l3)
            {
              localca.convertFrom((Cursor)localObject);
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
    return localca;
  }
  
  public final List<ca> aOL(String paramString)
  {
    ca localca = null;
    AppMethodBeat.i(117240);
    Cursor localCursor = this.lvy.rawQuery("select * from ".concat(String.valueOf(paramString)), null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(117240);
      return null;
    }
    paramString = localca;
    if (localCursor.moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        localca = new ca();
        localca.convertFrom(localCursor);
        paramString.add(localca);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(117240);
    return paramString;
  }
  
  public final Cursor aOM(String paramString)
  {
    AppMethodBeat.i(117247);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117247);
      return null;
    }
    Object localObject = aOY(paramString);
    paramString = "select * from " + (String)localObject + " " + bxg((String)localObject) + " where" + bxd(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime";
    localObject = this.lvy.rawQuery(paramString, null);
    Log.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(117247);
    return localObject;
  }
  
  public final void aON(String paramString)
  {
    AppMethodBeat.i(117252);
    d(paramString, "", null);
    if (this.lvy.execSQL(paramString, "delete from ".concat(String.valueOf(paramString))))
    {
      doNotify("delete_all ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117252);
      return;
    }
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 247L, 1L, false);
    AppMethodBeat.o(117252);
  }
  
  public final int aOO(String paramString)
  {
    AppMethodBeat.i(117254);
    Log.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, MMStack.getStack(true) });
    d(aOY(paramString), bxd(paramString), null);
    int i = this.lvy.delete(aOY(paramString), bxd(paramString), null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.EVP = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117254);
    return i;
  }
  
  public final int aOP(String paramString)
  {
    AppMethodBeat.i(117261);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(4));
    int i = this.lvy.update(aOY(paramString), localContentValues, bxd(paramString) + "AND isSend=? AND status!=? ", new String[] { "0", "4" });
    if (i != 0)
    {
      doNotify();
      a(new i.c(paramString, "update", null));
    }
    AppMethodBeat.o(117261);
    return i;
  }
  
  public final Cursor aOQ(String paramString)
  {
    AppMethodBeat.i(117263);
    paramString = this.lvy.query(aOY(paramString), null, bxd(paramString), null, null, null, "createTime ASC ");
    AppMethodBeat.o(117263);
    return paramString;
  }
  
  public final Cursor aOR(String paramString)
  {
    AppMethodBeat.i(117267);
    paramString = this.lvy.query(aOY(paramString), null, "isSend=? AND" + bxd(paramString) + "AND status!=?", new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117267);
    return paramString;
  }
  
  public final ca.c aOS(String paramString)
  {
    AppMethodBeat.i(117270);
    ca.c localc2 = (ca.c)this.VHe.get(Integer.valueOf(paramString.hashCode()));
    ca.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = ca.c.bxb(paramString);
      this.VHe.q(Integer.valueOf(paramString.hashCode()), localc1);
    }
    AppMethodBeat.o(117270);
    return localc1;
  }
  
  public final ca.d aOT(String paramString)
  {
    AppMethodBeat.i(117271);
    ca.d locald2 = (ca.d)this.VHf.get(Integer.valueOf(paramString.hashCode()));
    ca.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = ca.d.bxc(paramString);
      this.VHf.q(Integer.valueOf(paramString.hashCode()), locald1);
    }
    AppMethodBeat.o(117271);
    return locald1;
  }
  
  public final ca.a aOU(String paramString)
  {
    AppMethodBeat.i(117272);
    ca.a locala1 = null;
    if ((!Util.isNullOrNil(paramString)) && (this.VHg != null)) {
      locala1 = (ca.a)this.VHg.get(Integer.valueOf(paramString.hashCode()));
    }
    for (;;)
    {
      ca.a locala2 = locala1;
      if (locala1 == null)
      {
        locala1 = ca.a.bwZ(paramString);
        locala2 = locala1;
        if (this.VHg != null)
        {
          this.VHg.q(Integer.valueOf(Util.nullAs(paramString, "").hashCode()), locala1);
          locala2 = locala1;
        }
      }
      AppMethodBeat.o(117272);
      return locala2;
      Log.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramString)) });
      Log.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
    }
  }
  
  public final ca.b aOV(String paramString)
  {
    AppMethodBeat.i(117273);
    ca.b localb2 = (ca.b)this.VHh.get(Integer.valueOf(paramString.hashCode()));
    ca.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = ca.b.bxa(paramString);
      this.VHh.q(Integer.valueOf(paramString.hashCode()), localb1);
    }
    AppMethodBeat.o(117273);
    return localb1;
  }
  
  public final int aOW(String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(117274);
    if (RO(paramString))
    {
      i = this.rSv.bwP(paramString);
      if (i > 0)
      {
        Log.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(117274);
        return i;
      }
      Log.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    }
    do
    {
      i = RN(paramString);
      AppMethodBeat.o(117274);
      return i;
      if (("appbrandmessage".equals(aOY(paramString))) || ("appbrandnotifymessage".equals(aOY(paramString))))
      {
        paramString = "SELECT COUNT(*) FROM " + aOY(paramString) + " WHERE" + bxd(paramString);
        paramString = this.lvy.rawQuery(paramString, null);
        if (paramString.moveToLast()) {
          i = paramString.getInt(0);
        }
        paramString.close();
        AppMethodBeat.o(117274);
        return i;
      }
    } while (!"bottlemessage".equals(aOY(paramString)));
    paramString = "SELECT COUNT(*) FROM " + aOY(paramString) + " WHERE" + bxd(paramString);
    paramString = this.lvy.rawQuery(paramString, null, 2);
    i = j;
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117274);
    return i;
  }
  
  public final int aOX(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117280);
    if (paramString == null)
    {
      Log.w("MicroMsg.MsgInfoStorage", "getImgVideoMsgCount talker is null!");
      AppMethodBeat.o(117280);
      return 0;
    }
    paramString = "SELECT COUNT(*) FROM " + aOY(paramString) + " WHERE " + bvg(paramString) + "talker= '" + Util.escapeSqlValue(paramString) + "' AND type IN (3,39,13,43,62,44,268435505,486539313)";
    paramString = this.lvy.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117280);
    return i;
  }
  
  public final String aOY(String paramString)
  {
    AppMethodBeat.i(117283);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = bxj(paramString).name;
      AppMethodBeat.o(117283);
      return paramString;
    }
  }
  
  public final long aOZ(String paramString)
  {
    AppMethodBeat.i(117289);
    Object localObject = "select createTime from message where" + bxd(paramString) + "order by createTime LIMIT 1 OFFSET 0";
    Log.d("MicroMsg.MsgInfoStorage", "get first message create time: ".concat(String.valueOf(localObject)));
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      Log.e("MicroMsg.MsgInfoStorage", "get first message create time failed: ".concat(String.valueOf(paramString)));
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
  
  public final ca aP(String paramString, long paramLong)
  {
    AppMethodBeat.i(117215);
    ca localca = new ca();
    paramString = "Select * From " + aOY(paramString) + " Where " + bxd(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
    paramString = this.lvy.rawQuery(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localca.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117215);
    return localca;
  }
  
  public final long aPa(String paramString)
  {
    AppMethodBeat.i(117290);
    Object localObject = "select createTime from message where" + bvg(paramString) + bxd(paramString) + "order by createTime DESC LIMIT 1 ";
    Log.d("MicroMsg.MsgInfoStorage", "get last message create time: ".concat(String.valueOf(localObject)));
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      Log.e("MicroMsg.MsgInfoStorage", "get last message create time failed ".concat(String.valueOf(paramString)));
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
  
  public final long aPb(String paramString)
  {
    AppMethodBeat.i(117291);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117291);
      return 0L;
    }
    Object localObject = "select msgSeq from message where" + bxd(paramString) + "order by msgSeq DESC LIMIT 1 ";
    Log.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: ".concat(String.valueOf(localObject)));
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      Log.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed ".concat(String.valueOf(paramString)));
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
  
  public final ca aPc(String paramString)
  {
    AppMethodBeat.i(117293);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117293);
      return null;
    }
    Log.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", new Object[] { paramString, Boolean.FALSE });
    Object localObject1 = (Long)this.VHj.get(paramString);
    if ((localObject1 != null) && (((Long)localObject1).longValue() > 0L))
    {
      Log.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", new Object[] { Long.valueOf(((Long)localObject1).longValue()) });
      localObject1 = Oq(((Long)localObject1).longValue());
      if ((((et)localObject1).field_flag & 0x1) != 0)
      {
        AppMethodBeat.o(117293);
        return localObject1;
      }
      this.VHj.remove(paramString);
      AppMethodBeat.o(117293);
      return null;
    }
    Log.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
    localObject1 = new ca();
    long l = System.currentTimeMillis();
    Object localObject2 = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ";
    localObject2 = this.lvy.rawQuery((String)localObject2, null, 2);
    Log.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(Thread.currentThread().getId()) });
    if (localObject2 == null)
    {
      Log.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117293);
      return localObject1;
    }
    if (((Cursor)localObject2).moveToFirst()) {
      ((ca)localObject1).convertFrom((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    this.VHj.q(paramString, Long.valueOf(((et)localObject1).field_msgId));
    AppMethodBeat.o(117293);
    return localObject1;
  }
  
  public final int aPd(String paramString)
  {
    AppMethodBeat.i(117307);
    String str = " SELECT COUNT(*) FROM " + aOY(paramString) + " WHERE" + bvg(paramString) + bxd(paramString) + "AND isSend=1";
    Cursor localCursor = this.lvy.rawQuery(str, null, 2);
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
        Log.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(117307);
      }
      Log.d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", new Object[] { paramString, Integer.valueOf(i), str });
      AppMethodBeat.o(117307);
      return i;
      label168:
      int i = 0;
    }
  }
  
  /* Error */
  public final List<ca> aPe(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 1409
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 541	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 542	java/util/ArrayList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 153	com/tencent/mm/storage/cb:lvy	Lcom/tencent/mm/storagebase/h;
    //   20: ldc 71
    //   22: aconst_null
    //   23: ldc_w 1411
    //   26: iconst_2
    //   27: anewarray 61	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: invokestatic 411	com/tencent/mm/sdk/platformtools/Util:escapeSqlValue	(Ljava/lang/String;)Ljava/lang/String;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: invokestatic 526	java/lang/System:currentTimeMillis	()J
    //   42: ldc2_w 638
    //   45: lsub
    //   46: invokestatic 752	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: ldc_w 1178
    //   55: iconst_2
    //   56: invokevirtual 621	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokeinterface 624 1 0
    //   70: ifeq +75 -> 145
    //   73: aload_2
    //   74: astore_1
    //   75: new 236	com/tencent/mm/storage/ca
    //   78: dup
    //   79: invokespecial 625	com/tencent/mm/storage/ca:<init>	()V
    //   82: astore 4
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: aload_2
    //   89: invokevirtual 629	com/tencent/mm/storage/ca:convertFrom	(Landroid/database/Cursor;)V
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: aload 4
    //   97: invokevirtual 795	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto -39 -> 62
    //   104: astore_3
    //   105: aload_2
    //   106: astore_1
    //   107: ldc 165
    //   109: aload_3
    //   110: ldc_w 1413
    //   113: iconst_1
    //   114: anewarray 169	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: invokevirtual 361	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 760	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_2
    //   128: ifnull +9 -> 137
    //   131: aload_2
    //   132: invokeinterface 300 1 0
    //   137: ldc_w 1409
    //   140: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aconst_null
    //   144: areturn
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 300 1 0
    //   155: ldc_w 1409
    //   158: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_3
    //   162: areturn
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +9 -> 174
    //   168: aload_2
    //   169: invokeinterface 300 1 0
    //   174: ldc_w 1409
    //   177: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	196	0	this	cb
    //   0	196	1	paramString	String
    //   1	192	2	str	String
    //   15	80	3	localArrayList	ArrayList
    //   104	58	3	localException1	Exception
    //   182	4	3	localObject	Object
    //   190	1	3	localException2	Exception
    //   82	14	4	localca	ca
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
  
  public final long aPf(String paramString)
  {
    AppMethodBeat.i(117317);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    paramString = bxh(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    long l = paramString.lNP;
    AppMethodBeat.o(117317);
    return l;
  }
  
  public final Cursor aPg(String paramString)
  {
    AppMethodBeat.i(117315);
    try
    {
      paramString = this.lvy.query(aOY(paramString), null, bxd(paramString) + " AND createTime>=? AND type IN (436207665,419430449" + ")", new String[] { String.valueOf(System.currentTimeMillis() - 86400000L) }, null, null, "createTime ASC", 2);
      AppMethodBeat.o(117315);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.MsgInfoStorage", paramString, "getLastDayC2CMsgByTalker error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(117315);
    }
    return null;
  }
  
  public final long aPh(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(189032);
    paramString = "SELECT COUNT(*) FROM " + aOY(paramString) + " WHERE " + bxd(paramString) + " AND type NOT IN (10000,10002,570425393,64,603979825,855638065,889192497" + ",922746929)";
    paramString = this.lvy.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    long l = i;
    AppMethodBeat.o(189032);
    return l;
  }
  
  public final boolean aQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(117220);
    if (aN(paramString, paramLong).field_msgId > 0L)
    {
      AppMethodBeat.o(117220);
      return true;
    }
    AppMethodBeat.o(117220);
    return false;
  }
  
  public final ca aR(String paramString, long paramLong)
  {
    AppMethodBeat.i(117224);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117224);
      return null;
    }
    ca localca = new ca();
    paramString = "select * from " + aOY(paramString) + " where" + bxd(paramString) + "AND msgSeq<" + paramLong + " order by msgSeq DESC limit 1";
    Cursor localCursor = this.lvy.rawQuery(paramString, null, 2);
    if (localCursor.moveToFirst()) {
      localca.convertFrom(localCursor);
    }
    localCursor.close();
    Log.d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117224);
    return localca;
  }
  
  public final Cursor aS(String paramString, long paramLong)
  {
    AppMethodBeat.i(177113);
    paramString = this.lvy.hBZ().rawQueryWithFactory(null, "SELECT * FROM " + paramString + " WHERE createTime < " + paramLong, null, paramString);
    AppMethodBeat.o(177113);
    return paramString;
  }
  
  public final long aT(String paramString, long paramLong)
  {
    AppMethodBeat.i(117241);
    paramString = "select createTime from " + aOY(paramString) + " where msgId = " + paramLong;
    paramLong = 0L;
    paramString = this.lvy.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      paramLong = paramString.getLong(0);
    }
    paramString.close();
    AppMethodBeat.o(117241);
    return paramLong;
  }
  
  /* Error */
  public final int aU(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 1469
    //   6: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 143
    //   13: aconst_null
    //   14: invokevirtual 1225	com/tencent/mm/storage/cb:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 153	com/tencent/mm/storage/cb:lvy	Lcom/tencent/mm/storagebase/h;
    //   21: invokevirtual 1447	com/tencent/mm/storagebase/h:hBZ	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   24: new 63	java/lang/StringBuilder
    //   27: dup
    //   28: ldc_w 1471
    //   31: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 1473
    //   41: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 1477	com/tencent/wcdb/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   50: astore 6
    //   52: aload 6
    //   54: iconst_1
    //   55: lload_2
    //   56: invokevirtual 1483	com/tencent/wcdb/database/SQLiteStatement:bindLong	(IJ)V
    //   59: aload 6
    //   61: invokevirtual 1486	com/tencent/wcdb/database/SQLiteStatement:executeUpdateDelete	()I
    //   64: istore 4
    //   66: iload 4
    //   68: ifle +17 -> 85
    //   71: aload_0
    //   72: ldc_w 1229
    //   75: aload_1
    //   76: invokestatic 724	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokevirtual 727	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 831	com/tencent/mm/storage/cb:doNotify	(Ljava/lang/String;)V
    //   85: aload 6
    //   87: ifnull +8 -> 95
    //   90: aload 6
    //   92: invokevirtual 1487	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   95: ldc_w 1469
    //   98: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload 4
    //   103: ireturn
    //   104: astore 5
    //   106: ldc_w 1469
    //   109: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload 5
    //   114: athrow
    //   115: astore_1
    //   116: aload 6
    //   118: ifnull +13 -> 131
    //   121: aload 5
    //   123: ifnull +51 -> 174
    //   126: aload 6
    //   128: invokevirtual 1487	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   131: ldc_w 1469
    //   134: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: getstatic 855	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   143: ldc2_w 856
    //   146: ldc2_w 1230
    //   149: lconst_1
    //   150: iconst_0
    //   151: invokevirtual 863	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   154: ldc_w 1469
    //   157: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: iconst_m1
    //   161: ireturn
    //   162: astore 6
    //   164: aload 5
    //   166: aload 6
    //   168: invokevirtual 1491	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   171: goto -40 -> 131
    //   174: aload 6
    //   176: invokevirtual 1487	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   179: goto -48 -> 131
    //   182: astore_1
    //   183: goto -67 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	cb
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
  
  public final int aV(String paramString, long paramLong)
  {
    AppMethodBeat.i(117253);
    ca localca = aL(paramString, paramLong);
    this.VHk.y((int)(Util.nowSecond() / 86400L), localca.field_msgSvrId, localca.field_createTime / 1000L);
    int i = this.lvy.delete(aOY(paramString), "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      doNotify();
      a(new i.c(paramString, "delete", null, 1, (byte)0));
    }
    for (;;)
    {
      AppMethodBeat.o(117253);
      return i;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 246L, 1L, false);
    }
  }
  
  public final int aW(String paramString, long paramLong)
  {
    AppMethodBeat.i(117255);
    String str = bxd(paramString) + " and createTime <= " + paramLong;
    d(aOY(paramString), str, null);
    int i = this.lvy.delete(aOY(paramString), str, null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.EVP = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117255);
    return i;
  }
  
  public final int aX(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(117281);
    ca localca = Oq(paramLong);
    if (localca.field_msgId == 0L)
    {
      Log.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117281);
      return 0;
    }
    String str = aOY(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " " + bxg(str) + " WHERE " + bvg(paramString) + bxd(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + localca.field_createTime;
    paramString = this.lvy.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117281);
    return i;
  }
  
  public final String aY(String paramString, long paramLong)
  {
    AppMethodBeat.i(117282);
    Object localObject1 = Oq(paramLong);
    if (((et)localObject1).field_msgId == 0L)
    {
      Log.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117282);
      return null;
    }
    Object localObject2 = aOY(paramString);
    paramString = "EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + (String)localObject2 + " " + bxg((String)localObject2) + " WHERE" + bvg(paramString) + bxd(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + ((et)localObject1).field_createTime;
    localObject2 = this.lvy.rawQuery(paramString, null);
    paramString = "";
    localObject1 = paramString;
    if (((Cursor)localObject2).moveToFirst())
    {
      int i = 0;
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
  
  public final Cursor aZ(String paramString, long paramLong)
  {
    AppMethodBeat.i(189140);
    paramString = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC ";
    Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
    paramString = this.lvy.rawQuery(paramString, null);
    AppMethodBeat.o(189140);
    return paramString;
  }
  
  public final Cursor aj(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117304);
    String str = " SELECT * FROM " + aOY(paramString1) + " WHERE" + bvg(paramString1) + bxd(paramString1) + "AND content LIKE '" + paramString2 + "%' ORDER BY createTime DESC LIMIT " + paramInt;
    Log.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), str });
    paramString1 = this.lvy.rawQuery(str, null);
    AppMethodBeat.o(117304);
    return paramString1;
  }
  
  public final List<ca> au(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117233);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + aOY(paramString) + " WHERE " + hAv() + " ORDER BY createTime DESC LIMIT " + paramInt1 + " , " + paramInt2;
    Log.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.lvy.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      ca localca = new ca();
      localca.convertFrom(paramString);
      if (localca.erk()) {
        localArrayList.add(localca);
      }
    }
    paramString.close();
    AppMethodBeat.o(117233);
    return localArrayList;
  }
  
  public final Cursor av(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117243);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117243);
      return null;
    }
    String str = aOY(paramString);
    paramString = "select * from ( select * from " + str + " where" + bvg(paramString) + bxd(paramString) + " AND type IN (3,39,13,43,62,44,268435505,486539313)  order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = this.lvy.rawQuery(paramString, null, 2);
    AppMethodBeat.o(117243);
    return paramString;
  }
  
  public final Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117299);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(aOY(paramString)).append(" WHERE").append(bxd(paramString));
      if (paramLong2 > 0L)
      {
        str = " AND createTime >= ".concat(String.valueOf(paramLong2));
        localStringBuilder = localStringBuilder.append(str);
        if (paramLong1 <= 0L) {
          break label178;
        }
      }
      label178:
      for (String str = " AND createTime <= ".concat(String.valueOf(paramLong1));; str = "")
      {
        str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
        Log.d("MicroMsg.MsgInfoStorage", "getCursorAfterStratTimeBeforeEndTimeLimit talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
        paramString = this.lvy.rawQuery(str, null);
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
  
  public final Cursor b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(117296);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = new StringBuilder("SELECT * FROM ").append(aOY(paramString)).append(" WHERE").append(bxd(paramString)).append("AND createTime >= ").append(paramLong2).append(" AND createTime <= ").append(paramLong1).append(" AND isSend=");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString = i + " LIMIT 1";
        Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
        paramString = this.lvy.rawQuery(paramString, null);
        AppMethodBeat.o(117296);
        return paramString;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void b(long paramLong, ca paramca)
  {
    AppMethodBeat.i(117260);
    if (Util.nullAsNil(paramca.field_talker).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("no talker set when update by svrid", bool);
      if (paramca.hzw())
      {
        String str = bxf(paramca.hxy);
        if (ab.QR(str))
        {
          Log.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
          paramca.Jm("notifymessage");
        }
      }
      if (paramca.getType() == 1075839025) {
        paramca.Jm("notifymessage");
      }
      bt(paramca);
      if (paramLong != 0L) {
        break;
      }
      Log.w("MicroMsg.MsgInfoStorage", "invalid svr id %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(117260);
      return;
    }
    if (this.lvy.update(aOY(paramca.field_talker), paramca.convertTo(), "msgSvrId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new i.c(paramca.field_talker, "update", paramca));
      AppMethodBeat.o(117260);
      return;
    }
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 243L, 1L, false);
    AppMethodBeat.o(117260);
  }
  
  public final ca ba(String paramString, long paramLong)
  {
    AppMethodBeat.i(117309);
    Log.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(1) });
    ca localca = new ca();
    paramString = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND createTime < " + paramLong + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1";
    Log.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.lvy.rawQuery(paramString, null);
    if (paramString == null)
    {
      Log.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(117309);
      return localca;
    }
    if (paramString.moveToLast())
    {
      localca.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(117309);
      return localca;
    }
    paramString.close();
    Log.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117309);
    return localca;
  }
  
  public final void beR()
  {
    AppMethodBeat.i(117227);
    Cursor localCursor = this.lvy.rawQuery("select * from MsgInfo wherecontent like '%aaaabbbbbfdf%'", null, 2);
    localCursor.getCount();
    SystemClock.sleep(5000L);
    localCursor.close();
    AppMethodBeat.o(117227);
  }
  
  public final long c(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(117238);
    if ((paramca == null) || (Util.isNullOrNil(paramca.field_talker)))
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 250L, 1L, false);
      if (paramca == null) {}
      for (localObject1 = "-1";; localObject1 = paramca.field_talker)
      {
        Log.e("MicroMsg.MsgInfoStorage", "Error insert message msg:%s talker:%s", new Object[] { paramca, localObject1 });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    Log.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", new Object[] { Boolean.valueOf(this.VHm), Long.valueOf(paramca.field_msgSeq) });
    Object localObject1 = null;
    Object localObject2 = bq.RR(paramca.hxy);
    if (localObject2 != null) {
      localObject1 = ((bq.b)localObject2).lup;
    }
    if (ab.QR((String)localObject1))
    {
      Log.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { localObject1 });
      if (paramca.getType() == 436207665)
      {
        Log.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
        AppMethodBeat.o(117238);
        return -1L;
      }
      paramca.Jm("notifymessage");
    }
    if (paramca.getType() == 1075839025) {
      paramca.Jm("notifymessage");
    }
    localObject1 = bxj(paramca.field_talker);
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 249L, 1L, false);
      Log.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", new Object[] { paramca.field_talker });
      AppMethodBeat.o(117238);
      return -1L;
    }
    ((i.b)localObject1).aP(paramca);
    Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[] { Long.valueOf(paramca.field_msgId), localObject1, UW(paramca.field_msgId) }), ((i.b)localObject1).name.equals(UW(paramca.field_msgId)));
    if (paramca.field_msgSvrId != 0L)
    {
      paramca.ill = 1;
      paramca.hwY = true;
    }
    ??? = this.VHc.iterator();
    while (((Iterator)???).hasNext()) {
      if (!((e)((Iterator)???).next()).a(paramca, (bq.b)localObject2))
      {
        Log.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", new Object[] { paramca.field_talker, paramca.hxy });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    bt(paramca);
    if (((i.b)localObject1).name.equals("message"))
    {
      paramca.field_talkerId = ((int)bxe(paramca.field_talker));
      paramca.hwZ = true;
    }
    localObject2 = paramca.convertTo();
    com.tencent.mm.storagebase.f localf;
    if (paramBoolean)
    {
      localf = this.lvy.hBY();
      ??? = ((i.b)localObject1).name;
      if (localf.VJf != null)
      {
        localObject1 = localf.VJf;
        if (com.tencent.mm.storagebase.f.isMainThread()) {
          com.tencent.mm.storagebase.f.VJl.a((SQLiteDatabase)localObject1, 32769, (String)???);
        }
      }
    }
    for (long l = ((SQLiteDatabase)localObject1).insertOrThrow((String)???, "msgId", (ContentValues)localObject2);; l = this.lvy.a(((i.b)localObject1).name, "msgId", (ContentValues)localObject2))
    {
      Log.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", new Object[] { Long.valueOf(l), paramca.field_talker, Long.valueOf(paramca.field_msgId), Integer.valueOf(paramca.getType()), Integer.valueOf(paramca.field_status), Long.valueOf(paramca.field_msgSvrId), Long.valueOf(paramca.field_msgSeq), Integer.valueOf(paramca.field_flag), Long.valueOf(paramca.field_createTime), Integer.valueOf(paramca.field_isSend), this.VHn, Long.valueOf(Util.milliSecondsToNow(this.VHo)) });
      if (l != -1L) {
        break label763;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 248L, 1L, false);
      Log.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", new Object[] { Long.valueOf(paramca.field_msgSvrId), Long.valueOf(l) });
      AppMethodBeat.o(117238);
      return -1L;
      localObject1 = localf.VJg;
      break;
    }
    label763:
    if ((this.VHm) && (Util.milliSecondsToNow(this.VHo) > 2000L) && (paramca.field_isSend == 1) && (paramca.field_status == 1))
    {
      Log.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", new Object[] { this.VHn, Long.valueOf(Util.milliSecondsToNow(this.VHo)) });
      aOD(this.VHn);
    }
    if (this.VHm)
    {
      localObject1 = null;
      if (e.Vcv != null) {
        localObject1 = e.Vcv.au(paramca);
      }
      if (!Util.isNullOrNil((String)localObject1)) {
        break label1080;
      }
    }
    label1080:
    for (localObject2 = paramca.field_talker;; localObject2 = localObject1)
    {
      localObject1 = null;
      for (;;)
      {
        synchronized (this.VHl)
        {
          if (this.VHl.containsKey(localObject2)) {
            localObject1 = (i.c)this.VHl.get(localObject2);
          }
          if (localObject1 == null)
          {
            localObject1 = new i.c(paramca.field_talker, "insert", paramca);
            if (i.c.aQ(paramca)) {
              ((i.c)localObject1).xKO += 1;
            }
            ((i.c)localObject1).EVN += 1;
            this.VHl.put(localObject2, localObject1);
            l = paramca.field_msgId;
            AppMethodBeat.o(117238);
            return l;
          }
          ((i.c)localObject1).kvM.add(paramca);
        }
        localObject1 = new i.c(paramca.field_talker, "insert", paramca);
        if (i.c.aQ(paramca)) {
          ((i.c)localObject1).xKO = 1;
        }
        ((i.c)localObject1).EVN = 1;
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
      paramString = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND createTime > " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.lvy.rawQuery(paramString, null);
      AppMethodBeat.o(117301);
      return paramString;
    }
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.lvy.rawQuery(paramString, null);
      AppMethodBeat.o(117301);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117298);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM (SELECT * FROM " + aOY(paramString) + " WHERE" + bvg(paramString) + bxd(paramString) + " AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime DESC LIMIT " + paramInt + " ) ORDER BY createTime ASC";
      Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.lvy.rawQuery(paramString, null);
      AppMethodBeat.o(117298);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void d(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(117250);
    long l = Util.nowSecond();
    Object localObject = "SELECT msgSvrId,createTime FROM " + paramString1 + " WHERE createTime > " + (l - 172800L) * 1000L;
    paramString1 = (String)localObject;
    if (!Util.isNullOrNil(paramString2)) {
      paramString1 = (String)localObject + " AND " + paramString2;
    }
    paramString2 = new ArrayList();
    localObject = new ArrayList();
    paramString1 = this.lvy.rawQuery(paramString1, paramArrayOfString, 2);
    if (paramString1.moveToFirst())
    {
      do
      {
        int i = paramString1.getInt(0);
        l = paramString1.getLong(1) / 1000L;
        paramString2.add(Integer.valueOf(i));
        ((List)localObject).add(Long.valueOf(l));
      } while (paramString1.moveToNext());
      this.VHk.H(paramString2, (List)localObject);
    }
    paramString1.close();
    AppMethodBeat.o(117250);
  }
  
  public final List<ca> e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(117242);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(117242);
      return null;
    }
    paramLong = aT(paramString, paramLong);
    if (paramLong == 0L)
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(117242);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (paramString = "select * from " + aOY(paramString) + " where" + bvg(paramString) + bxd(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime > " + paramLong + " order by createTime ASC limit 10";; paramString = "select * from " + aOY(paramString) + " where" + bvg(paramString) + bxd(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + paramLong + " order by createTime DESC limit 10")
    {
      paramString = this.lvy.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        ca localca = new ca();
        localca.convertFrom(paramString);
        localArrayList.add(localca);
      }
    }
    if (!paramBoolean) {
      Collections.reverse(localArrayList);
    }
    paramString.close();
    AppMethodBeat.o(117242);
    return localArrayList;
  }
  
  public final void e(com.tencent.mm.storagebase.h paramh, String paramString)
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
    Cursor localCursor = paramh.rawQuery("PRAGMA table_info( " + paramString + " )", null, 2);
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
    long l = paramh.beginTransaction(Thread.currentThread().getId());
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
    paramh.endTransaction(l);
    AppMethodBeat.o(117198);
  }
  
  public final void eSn()
  {
    AppMethodBeat.i(117201);
    z.bdP();
    AppMethodBeat.o(117201);
  }
  
  public final void eSo()
  {
    AppMethodBeat.i(117204);
    int i = 0;
    while (i < this.VHd.size())
    {
      b((i.b)this.VHd.get(i));
      i += 1;
    }
    AppMethodBeat.o(117204);
  }
  
  public final void eSp()
  {
    AppMethodBeat.i(117206);
    if (!this.VHb)
    {
      AppMethodBeat.o(117206);
      return;
    }
    Object localObject = "select count(*) from " + "message" + " where talkerId ISNULL ";
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
    if (localObject != null) {
      if (!((Cursor)localObject).moveToFirst()) {
        break label294;
      }
    }
    label294:
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      if (i > 0)
      {
        Log.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", new Object[] { "message" });
        long l = System.currentTimeMillis();
        localObject = "update " + "message" + " set talkerId=(select rowid from rcontact where rcontact.username" + " = " + "message" + ".talker)";
        boolean bool = this.lvy.execSQL("message", (String)localObject);
        Log.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
        if ((bool) && (this.VHb))
        {
          this.lvy.execSQL("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
          this.lvy.execSQL("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
          this.lvy.execSQL("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
          this.lvy.execSQL("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
          this.lvy.execSQL("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
          Log.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
        }
      }
      AppMethodBeat.o(117206);
      return;
    }
  }
  
  public final ArrayList<ca> eSq()
  {
    AppMethodBeat.i(117218);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.lvy.query("message", null, "createTime>=? AND status=? AND isSend=?", new String[] { String.valueOf(System.currentTimeMillis() - 172800000L), "5", "1" }, null, null, "createTime ASC", 2);
    label149:
    while (localCursor.moveToNext())
    {
      ca localca = new ca();
      localca.convertFrom(localCursor);
      if (!localca.isOmittedFailResend()) {}
      for (int i = 1;; i = 0)
      {
        if (((i & 0x1) == 0) || (as.bvH(localca.field_talker)) || (as.bvJ(localca.field_talker)) || (as.PY(localca.field_talker))) {
          break label149;
        }
        localArrayList.add(localca);
        break;
      }
    }
    localCursor.close();
    AppMethodBeat.o(117218);
    return localArrayList;
  }
  
  public final List<ca> eSr()
  {
    AppMethodBeat.i(117231);
    List localList = WC(2147483647);
    AppMethodBeat.o(117231);
    return localList;
  }
  
  public final Cursor eSs()
  {
    AppMethodBeat.i(117269);
    Cursor localCursor = this.lvy.query("message", new String[] { "talker", "count(*) as unReadCount" }, "isSend=? AND status!=?", new String[] { "0", "4" }, "talker", null, null);
    AppMethodBeat.o(117269);
    return localCursor;
  }
  
  public final String eSt()
  {
    return "type IN (3,39,13,43,62,44,268435505,486539313)";
  }
  
  public final String eSu()
  {
    return "type IN (3,39,13,43,62,44,49,268435505)";
  }
  
  public final int eSv()
  {
    AppMethodBeat.i(117295);
    Log.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf("SELECT COUNT(msgId) FROM message")));
    Cursor localCursor = this.lvy.rawQuery("SELECT COUNT(msgId) FROM message", null, 2);
    if (localCursor == null)
    {
      Log.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
      AppMethodBeat.o(117295);
      return 0;
    }
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      Log.d("MicroMsg.MsgInfoStorage", "result getAllMsgCount count %d", new Object[] { Integer.valueOf(i) });
      localCursor.close();
      AppMethodBeat.o(117295);
      return i;
    }
    localCursor.close();
    AppMethodBeat.o(117295);
    return 0;
  }
  
  /* Error */
  public final List<ca> eSw()
  {
    // Byte code:
    //   0: ldc_w 1895
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 541	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 542	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 153	com/tencent/mm/storage/cb:lvy	Lcom/tencent/mm/storagebase/h;
    //   18: ldc 71
    //   20: aconst_null
    //   21: ldc_w 1897
    //   24: iconst_1
    //   25: anewarray 61	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: invokestatic 526	java/lang/System:currentTimeMillis	()J
    //   33: ldc2_w 638
    //   36: lsub
    //   37: invokestatic 752	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: ldc_w 1178
    //   46: iconst_2
    //   47: invokevirtual 621	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 624 1 0
    //   59: ifeq +75 -> 134
    //   62: aload_2
    //   63: astore_1
    //   64: new 236	com/tencent/mm/storage/ca
    //   67: dup
    //   68: invokespecial 625	com/tencent/mm/storage/ca:<init>	()V
    //   71: astore 4
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: aload_2
    //   78: invokevirtual 629	com/tencent/mm/storage/ca:convertFrom	(Landroid/database/Cursor;)V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload 4
    //   86: invokevirtual 795	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -39 -> 51
    //   93: astore_3
    //   94: aload_2
    //   95: astore_1
    //   96: ldc 165
    //   98: aload_3
    //   99: ldc_w 1413
    //   102: iconst_1
    //   103: anewarray 169	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_3
    //   109: invokevirtual 361	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 760	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_2
    //   117: ifnull +9 -> 126
    //   120: aload_2
    //   121: invokeinterface 300 1 0
    //   126: ldc_w 1895
    //   129: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aconst_null
    //   133: areturn
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 300 1 0
    //   144: ldc_w 1895
    //   147: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_3
    //   151: areturn
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +9 -> 165
    //   159: aload_1
    //   160: invokeinterface 300 1 0
    //   165: ldc_w 1895
    //   168: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	183	0	this	cb
    //   52	108	1	localCursor1	Cursor
    //   50	89	2	localCursor2	Cursor
    //   152	20	2	localObject1	Object
    //   173	1	2	localObject2	Object
    //   179	1	2	localObject3	Object
    //   13	71	3	localArrayList	ArrayList
    //   93	58	3	localException1	Exception
    //   177	1	3	localException2	Exception
    //   71	14	4	localca	ca
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
  
  public final List<ca> eX(String paramString, int paramInt)
  {
    AppMethodBeat.i(117228);
    ArrayList localArrayList = new ArrayList();
    if (this.VHd != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND status = 3 AND type <> 10000" + " ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.lvy.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        ca localca = new ca();
        localca.convertFrom(paramString);
        localArrayList.add(localca);
      }
    }
    paramString.close();
    AppMethodBeat.o(117228);
    return localArrayList;
  }
  
  public final List<ca> eY(String paramString, int paramInt)
  {
    AppMethodBeat.i(117232);
    ArrayList localArrayList = new ArrayList();
    if (this.VHd != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.lvy.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        ca localca = new ca();
        localca.convertFrom(paramString);
        if ((localca.hwH()) || (localca.hzM()) || (localca.hzN())) {
          localArrayList.add(localca);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(117232);
    return localArrayList;
  }
  
  public final List<ca> eZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(188900);
    ArrayList localArrayList = new ArrayList();
    if (this.VHd != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + " ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.lvy.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        ca localca = new ca();
        localca.convertFrom(paramString);
        localArrayList.add(localca);
      }
    }
    paramString.close();
    AppMethodBeat.o(188900);
    return localArrayList;
  }
  
  public final List<ca> fY(List<String> paramList)
  {
    AppMethodBeat.i(188892);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.VHd.size())
    {
      if (paramList.contains(((i.b)this.VHd.get(i)).name)) {
        localLinkedList.add(this.VHd.get(i));
      }
      i += 1;
    }
    paramList = z(2147483647, localLinkedList);
    AppMethodBeat.o(188892);
    return paramList;
  }
  
  public final Cursor fa(String paramString, int paramInt)
  {
    AppMethodBeat.i(117248);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117248);
      return null;
    }
    String str = aOY(paramString);
    paramString = "select * from " + str + " where" + bvg(paramString) + bxd(paramString) + " AND " + hAv() + "  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.lvy.rawQuery(paramString, null);
    AppMethodBeat.o(117248);
    return paramString;
  }
  
  public final Cursor fb(String paramString, int paramInt)
  {
    AppMethodBeat.i(117249);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117249);
      return null;
    }
    Object localObject = aOY(paramString);
    paramString = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend,imgPath from ").append((String)localObject).append(" where").append(bvg(paramString)).append(bxd(paramString)).append(" AND ");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" (type = 49");
    ((StringBuilder)localObject).append(" or type = 587202609");
    ((StringBuilder)localObject).append(" or type = 553648177) ");
    paramString = ((StringBuilder)localObject).toString() + " order by createTime DESC limit 100 OFFSET " + paramInt;
    paramString = this.lvy.rawQuery(paramString, null);
    AppMethodBeat.o(117249);
    return paramString;
  }
  
  public final Cursor fc(String paramString, int paramInt)
  {
    AppMethodBeat.i(117245);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117245);
      return null;
    }
    String str = aOY(paramString);
    paramString = "select * from ( select * from " + str + " where" + bxd(paramString) + " AND type IN (3,39,13,43,62,44,49,1090519089,268435505)  order by createTime DESC limit 200 OFFSET " + paramInt + ") order by createTime ASC ";
    paramString = this.lvy.rawQuery(paramString, null, 2);
    AppMethodBeat.o(117245);
    return paramString;
  }
  
  public final int fd(String paramString, int paramInt)
  {
    AppMethodBeat.i(117256);
    Log.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", new Object[] { paramString, Integer.valueOf(paramInt), MMStack.getStack(true) });
    ca localca = aL(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localca.field_talker));
    d(aOY(paramString), "createTime<=? AND" + bxd(paramString), new String[] { localca.field_createTime });
    paramInt = this.lvy.delete(aOY(paramString), "createTime<=? AND" + bxd(paramString), new String[] { localca.field_createTime });
    if (paramInt != 0)
    {
      doNotify();
      a(new i.c(paramString, "delete", null, paramInt, (byte)0));
    }
    AppMethodBeat.o(117256);
    return paramInt;
  }
  
  public final Cursor fe(String paramString, int paramInt)
  {
    AppMethodBeat.i(117257);
    ca localca = aL(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localca.field_talker));
    paramString = this.lvy.query(aOY(paramString), null, "createTime<=? AND" + bxd(paramString), new String[] { localca.field_createTime }, null, null, null);
    AppMethodBeat.o(117257);
    return paramString;
  }
  
  public final Cursor ff(String paramString, int paramInt)
  {
    AppMethodBeat.i(117268);
    paramString = this.lvy.query(aOY(paramString), null, "isSend=? AND" + bxd(paramString) + "AND status!=?  order by msgId DESC limit " + paramInt, new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117268);
    return paramString;
  }
  
  public final int fg(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117278);
    paramString = "SELECT COUNT(*) FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND type = " + paramInt;
    paramString = this.lvy.rawQuery(paramString, null, 2);
    paramInt = i;
    if (paramString.moveToFirst()) {
      paramInt = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117278);
    return paramInt;
  }
  
  public final Cursor fh(String paramString, int paramInt)
  {
    AppMethodBeat.i(117305);
    String str = " SELECT * FROM " + aOY(paramString) + " WHERE" + bvg(paramString) + bxd(paramString) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + paramInt;
    Log.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    paramString = this.lvy.rawQuery(str, null);
    AppMethodBeat.o(117305);
    return paramString;
  }
  
  public final ca[] fi(String paramString, int paramInt)
  {
    AppMethodBeat.i(117311);
    if ((paramString == null) || (paramString.length() == 0) || (paramInt <= 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + paramString + ", limit = " + paramInt);
      AppMethodBeat.o(117311);
      return null;
    }
    Object localObject = "select * from " + aOY(paramString) + " where" + bxd(paramString) + "order by createTime DESC limit " + paramInt;
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        ca localca = new ca();
        localca.convertFrom((Cursor)localObject);
        localArrayList.add(localca);
      } while (((Cursor)localObject).moveToNext());
      ((Cursor)localObject).close();
      Log.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + paramString + ", limit = " + paramInt + ", count = " + localArrayList.size());
      Collections.reverse(localArrayList);
      paramString = (ca[])localArrayList.toArray(new ca[localArrayList.size()]);
      AppMethodBeat.o(117311);
      return paramString;
    }
    Log.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
    ((Cursor)localObject).close();
    AppMethodBeat.o(117311);
    return null;
  }
  
  public final Cursor fj(String paramString, int paramInt)
  {
    AppMethodBeat.i(117319);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117319);
      return null;
    }
    String str = aOY(paramString);
    paramString = "select * from " + str + " where" + bvg(paramString) + bxd(paramString) + " AND type IN (436207665,419430449)  order by createTime" + " DESC limit " + paramInt + " OFFSET 0";
    paramString = this.lvy.rawQuery(paramString, null);
    AppMethodBeat.o(117319);
    return paramString;
  }
  
  public final List<ca> g(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(188866);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + aOY(paramString) + " Where " + bxd(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit " + paramInt;
    paramString = this.lvy.rawQuery(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      ca localca = new ca();
      localca.convertFrom(paramString);
      localArrayList.add(localca);
    }
    paramString.close();
    AppMethodBeat.o(188866);
    return localArrayList;
  }
  
  public final com.tencent.mm.storagebase.h getDB()
  {
    return this.lvy;
  }
  
  public final List<ca> h(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(188868);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + aOY(paramString) + " Where " + bxd(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit " + paramInt + ";";
    paramString = this.lvy.rawQuery(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      ca localca = new ca();
      localca.convertFrom(paramString);
      localArrayList.add(localca);
    }
    paramString.close();
    AppMethodBeat.o(188868);
    return localArrayList;
  }
  
  public final int i(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117221);
    String str = "SELECT * FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime ASC LIMIT -1 OFFSET " + paramInt;
    Cursor localCursor = this.lvy.rawQuery(str, null);
    paramInt = localCursor.getCount();
    localCursor.close();
    Log.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + paramString + " time:" + paramLong + " count " + paramInt + " [" + str + "]");
    AppMethodBeat.o(117221);
    return paramInt;
  }
  
  public final ca iR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117225);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", new Object[] { paramString1 });
      AppMethodBeat.o(117225);
      return null;
    }
    ca localca = new ca();
    paramString2 = "select * from " + aOY(paramString1) + " where" + bxd(paramString1) + paramString2 + " order by createTime DESC limit 1";
    paramString2 = this.lvy.rawQuery(paramString2, null, 2);
    if (paramString2.moveToFirst()) {
      localca.convertFrom(paramString2);
    }
    paramString2.close();
    Log.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", new Object[] { paramString1, Long.valueOf(localca.field_msgId) });
    AppMethodBeat.o(117225);
    return localca;
  }
  
  public final Cursor iS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117265);
    paramString1 = "SELECT * FROM " + aOY(paramString1) + " WHERE" + bxd(paramString1) + "AND content LIKE '%" + paramString2 + "%' AND type = 1";
    paramString1 = paramString1 + " ORDER BY createTime DESC";
    paramString1 = this.lvy.rawQuery(paramString1, null);
    AppMethodBeat.o(117265);
    return paramString1;
  }
  
  public final int iT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117306);
    String str = " SELECT COUNT(*) FROM " + aOY(paramString1) + " WHERE" + bvg(paramString1) + bxd(paramString1) + "AND content LIKE '" + paramString2 + "%' ";
    Cursor localCursor = this.lvy.rawQuery(str, null, 2);
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
        Log.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(117306);
      }
      Log.d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(i), str });
      AppMethodBeat.o(117306);
      return i;
      label188:
      int i = 0;
    }
  }
  
  public final LinkedList<ca> iU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117312);
    paramString1 = this.lvy.query(aOY(paramString1), null, "talker=? AND bizClientMsgId=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
    if (paramString1 != null) {}
    try
    {
      if (!paramString1.moveToFirst())
      {
        Log.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
        return null;
      }
      paramString2 = new LinkedList();
      do
      {
        ca localca = new ca();
        localca.convertFrom(paramString1);
        paramString2.add(localca);
      } while (paramString1.moveToNext());
      paramString1.close();
      return paramString2;
    }
    catch (Exception paramString2)
    {
      Log.printErrStackTrace("MicroMsg.MsgInfoStorage", paramString2, "getLastDayC2CMsgByTalker error: %s", new Object[] { paramString2.getMessage() });
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
  
  public final long j(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117308);
    Log.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      Log.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117308);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + aOY(paramString) + " WHERE" + bvg(paramString) + bxd(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime DESC  LIMIT " + paramInt;
    Log.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.lvy.rawQuery(paramString, null);
    if (paramString == null)
    {
      Log.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(117308);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      Log.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(117308);
      return paramLong;
    }
    paramString.close();
    Log.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117308);
    return paramLong;
  }
  
  public final long k(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117310);
    Log.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      Log.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117310);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + aOY(paramString) + " WHERE" + bxd(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC  LIMIT " + paramInt;
    Log.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.lvy.rawQuery(paramString, null);
    if (paramString == null)
    {
      Log.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
      AppMethodBeat.o(117310);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      Log.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(117310);
      return paramLong;
    }
    paramString.close();
    Log.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117310);
    return paramLong;
  }
  
  public final Cursor l(String paramString, long paramLong, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(117318);
    try
    {
      paramString = "select * from " + paramString + " where msgId >= " + paramLong + "  order by msgId ASC  limit " + paramInt;
      paramString = this.lvy.rawQuery(paramString, null);
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
  
  public final List<ca> m(String paramString, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(188903);
    Object localObject = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ((StringBuffer)localObject).append((Long)paramArrayList.next());
      ((StringBuffer)localObject).append(",");
    }
    paramArrayList = new ArrayList();
    paramString = "SELECT * FROM " + aOY(paramString) + " WHERE msgId IN (" + ((StringBuffer)localObject).substring(0, ((StringBuffer)localObject).length() - 1) + ") ORDER BY createTime DESC ";
    Log.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.lvy.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      localObject = new ca();
      ((ca)localObject).convertFrom(paramString);
      if (((ca)localObject).erk()) {
        paramArrayList.add(localObject);
      }
    }
    paramString.close();
    AppMethodBeat.o(188903);
    return paramArrayList;
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(117194);
    Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    AppMethodBeat.o(117194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cb
 * JD-Core Version:    0.7.0.1
 */