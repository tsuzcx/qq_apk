package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
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

public final class cd
  extends MStorage
  implements i
{
  public static final String[] SQL_CREATE;
  private final long SECONDS_OF_DAY;
  private final MStorageEvent<i.a, i.c> acFL;
  private boolean adkW;
  private final List<e> adkX;
  private List<i.b> adkY;
  private final com.tencent.mm.b.f<Integer, cc.d> adkZ;
  private final com.tencent.mm.b.f<Integer, cc.f> adla;
  private final com.tencent.mm.b.f<Integer, cc.a> adlb;
  private final com.tencent.mm.b.f<Integer, cc.c> adlc;
  private final com.tencent.mm.b.f<Integer, Object> adld;
  private final com.tencent.mm.b.f<String, Long> adle;
  private be adlf;
  private final Map<String, i.c> adlg;
  private boolean adlh;
  private String adli;
  private long adlj;
  private final com.tencent.mm.storagebase.h omV;
  private bx psc;
  private by vdK;
  
  static
  {
    AppMethodBeat.i(117320);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status" + " INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker" + " TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer" + " BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag" + " INT, solitaireFoldInfo BLOB, historyId TEXT) " };
    AppMethodBeat.o(117320);
  }
  
  public cd(com.tencent.mm.storagebase.h paramh, bx parambx, by paramby)
  {
    AppMethodBeat.i(117202);
    this.adkW = false;
    this.adkX = new CopyOnWriteArrayList();
    this.adkZ = new com.tencent.mm.memory.a.c(100);
    this.adla = new com.tencent.mm.memory.a.c(100);
    this.adlb = new com.tencent.mm.memory.a.c(100);
    this.adlc = new com.tencent.mm.memory.a.c(100);
    this.adld = new com.tencent.mm.memory.a.c(100);
    this.adle = new com.tencent.mm.memory.a.c(100);
    this.adlf = new be();
    this.acFL = new MStorageEvent()
    {
      public final void handleNotify(List<i.c> paramAnonymousList)
      {
        AppMethodBeat.i(117187);
        if ((!isLocked()) && (cd.a(cd.this) != null))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            i.c localc = (i.c)paramAnonymousList.next();
            if (localc != null) {
              cd.a(cd.this).a(cd.this, localc);
            }
          }
        }
        AppMethodBeat.o(117187);
      }
    };
    this.adlg = new HashMap();
    this.adlh = false;
    this.adli = "";
    this.adlj = 0L;
    this.SECONDS_OF_DAY = 86400L;
    this.omV = paramh;
    this.psc = parambx;
    this.vdK = paramby;
    if (z.bBJ() == 0)
    {
      Log.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", new Object[] { Integer.valueOf(this.omV.delete("message", "msgId> ? ", new String[] { "80000000" })) });
      z.bBI();
    }
    e(paramh, "message");
    jcy();
    if (this.adkY == null) {
      this.adkY = new LinkedList();
    }
    this.adkY.clear();
    a(new i.b(1, "message", i.b.d(1L, 1000000L, 10000000L, 90000000L)));
    AppMethodBeat.o(117202);
  }
  
  private List<cc> U(int paramInt, List<i.b> paramList)
  {
    AppMethodBeat.i(248465);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Cursor localCursor = this.omV.query(((i.b)paramList.get(i)).name, null, "status=1 and isSend=1 and type IN (1,11,21,31,36,42,66,67,48," + "55,57)", null, null, null, "createTime", 100);
      while (localCursor.moveToNext())
      {
        cc localcc = new cc();
        localcc.convertFrom(localCursor);
        if (br.bCJ() - localcc.getCreateTime() > 86400000L) {
          ((List)localObject).add(localcc);
        } else {
          localArrayList.add(localcc);
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
        long l = this.omV.beginTransaction(-1L);
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext())
        {
          localObject = (cc)paramList.next();
          Log.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d time:%s talker:%s content:%s", new Object[] { Long.valueOf(((fi)localObject).field_msgId), Long.valueOf(((cc)localObject).getCreateTime()), Integer.valueOf(((cc)localObject).getType()), ((fi)localObject).field_talker, Util.secPrint(((fi)localObject).field_content) });
          ((cc)localObject).setStatus(5);
          a(((fi)localObject).field_msgId, (cc)localObject);
        }
        this.omV.endTransaction(l);
      }
      AppMethodBeat.o(248465);
      return localArrayList;
    }
  }
  
  private void b(i.b paramb)
  {
    AppMethodBeat.i(117205);
    Cursor localCursor = this.omV.rawQuery("select max(msgid) from " + paramb.name, null, 2);
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      Log.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d tableName: %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramb.oGz), paramb.name });
      if (i >= paramb.oGz) {
        paramb.aaF(i);
      }
    }
    localCursor.close();
    Log.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + paramb.oGz);
    AppMethodBeat.o(117205);
  }
  
  private static void bJ(cc paramcc)
  {
    AppMethodBeat.i(117236);
    if ((paramcc == null) || (!paramcc.fxR()))
    {
      AppMethodBeat.o(117236);
      return;
    }
    try
    {
      String str = paramcc.field_content;
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
        paramcc.BU(SemiXml.encode((Map)localObject));
      }
      AppMethodBeat.o(117236);
      return;
    }
    catch (Exception paramcc)
    {
      Log.e("MicroMsg.MsgInfoStorage", paramcc.getMessage());
      AppMethodBeat.o(117236);
    }
  }
  
  private static String bvo(String paramString)
  {
    AppMethodBeat.i(177115);
    long l = ((n)com.tencent.mm.kernel.h.ax(n.class)).bAd().aLt(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(177115);
      return paramString;
    }
    AppMethodBeat.o(177115);
    return "";
  }
  
  private i.b byA(String paramString)
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
      if (i >= this.adkY.size()) {
        break label98;
      }
      if (paramString.equals(((i.b)this.adkY.get(i)).name))
      {
        paramString = (i.b)this.adkY.get(i);
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
  
  private String byB(String paramString)
  {
    AppMethodBeat.i(117285);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Iterator localIterator = this.adkX.iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = ((e)localIterator.next()).aAD(paramString);
      } while (Util.isNullOrNil(str));
      AppMethodBeat.o(117285);
      return str;
    }
    AppMethodBeat.o(117285);
    return "message";
  }
  
  private i.b byC(String paramString)
  {
    AppMethodBeat.i(117286);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = byA(byB(paramString));
      AppMethodBeat.o(117286);
      return paramString;
    }
  }
  
  private String byw(String paramString)
  {
    AppMethodBeat.i(117216);
    String str = aLY(paramString);
    if ((this.adkW) && (str.equals("message")))
    {
      paramString = " talkerId=" + byx(paramString) + " ";
      AppMethodBeat.o(117216);
      return paramString;
    }
    paramString = " talker= '" + Util.escapeSqlValue(paramString) + "' ";
    AppMethodBeat.o(117216);
    return paramString;
  }
  
  private long byx(String paramString)
  {
    AppMethodBeat.i(117217);
    long l2 = this.psc.bxx(paramString);
    if (l2 < 0L) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = l2;
      if (bool)
      {
        l1 = l2;
        if (!ab.IN(paramString))
        {
          l1 = l2;
          if (!ab.IO(paramString))
          {
            au localau = new au(paramString);
            localau.setType(2);
            this.psc.aB(localau);
            l1 = this.psc.bxx(paramString);
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
  
  private static String byy(String paramString)
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
  
  private String byz(String paramString)
  {
    AppMethodBeat.i(117277);
    if ((paramString == null) || (!paramString.equals("message")))
    {
      AppMethodBeat.o(117277);
      return "";
    }
    if (this.adkW)
    {
      AppMethodBeat.o(117277);
      return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
    }
    AppMethodBeat.o(117277);
    return "INDEXED BY messageCreateTaklerTypeTimeIndex";
  }
  
  private void jcy()
  {
    AppMethodBeat.i(117200);
    long l1 = System.currentTimeMillis();
    long l2 = this.omV.beginTransaction(Thread.currentThread().getId());
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
    if (!this.adkW)
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
      this.omV.execSQL("message", (String)localArrayList.get(i));
      i += 1;
    }
    Log.i("MicroMsg.MsgInfoStorage", "build new index last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    this.omV.endTransaction(l2);
    Log.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(117200);
  }
  
  private static String jcz()
  {
    AppMethodBeat.i(248476);
    String str = "type & 65535 = 49";
    AppMethodBeat.o(248476);
    return str;
  }
  
  private String ze(long paramLong)
  {
    AppMethodBeat.i(117288);
    if ((paramLong == 0L) || (paramLong == -1L))
    {
      AppMethodBeat.o(117288);
      return null;
    }
    cc.zd(paramLong);
    int i = 0;
    while (i < this.adkY.size())
    {
      if (((i.b)this.adkY.get(i)).sq(paramLong))
      {
        String str = ((i.b)this.adkY.get(i)).name;
        AppMethodBeat.o(117288);
        return str;
      }
      i += 1;
    }
    Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[] { Long.valueOf(paramLong) }), false);
    AppMethodBeat.o(117288);
    return null;
  }
  
  public final Cursor F(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117244);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117244);
      return null;
    }
    String str = aLY(paramString);
    paramString = "select * from " + str + " where" + byw(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.omV.rawQuery(paramString, null, 2);
    AppMethodBeat.o(117244);
    return paramString;
  }
  
  public final Cursor G(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117246);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117246);
      return null;
    }
    String str = aLY(paramString);
    paramString = "select * from " + str + " where" + byw(paramString) + "AND type IN (3,39,13,43,62,44,49,1090519089,268435505) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.omV.rawQuery(paramString, null, 2);
    AppMethodBeat.o(117246);
    return paramString;
  }
  
  public final int H(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(117279);
    paramString = "SELECT COUNT(*) FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND type = 50 AND createTime >= " + paramLong1 + " AND createTime <= " + paramLong2 + " LIMIT 1";
    paramString = this.omV.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117279);
    return i;
  }
  
  public final long Hq(String paramString)
  {
    AppMethodBeat.i(117290);
    Object localObject = "select createTime from message where" + bvo(paramString) + byw(paramString) + "order by createTime DESC LIMIT 1 ";
    Log.d("MicroMsg.MsgInfoStorage", "get last message create time: ".concat(String.valueOf(localObject)));
    localObject = this.omV.rawQuery((String)localObject, null, 2);
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
  
  public final int I(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117294);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      Log.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      paramString = "SELECT COUNT(msgId) FROM " + aLY(paramString) + " WHERE" + bvo(paramString) + byw(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      Log.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf(paramString)));
      paramString = this.omV.rawQuery(paramString, null, 2);
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
  
  public final Cursor I(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(117264);
    paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + " AND createTime <= " + paramLong + " order by createTime ASC limit " + paramInt;
    paramString = this.omV.rawQuery(paramString, null);
    AppMethodBeat.o(117264);
    return paramString;
  }
  
  public final Cursor J(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(117266);
    StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(aLY(paramString)).append(" WHERE").append(byw(paramString));
    if (paramLong > 0L) {}
    for (String str = " AND createTime > ".concat(String.valueOf(paramLong));; str = "")
    {
      str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
      Log.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
      paramString = this.omV.rawQuery(str, null);
      AppMethodBeat.o(117266);
      return paramString;
    }
  }
  
  public final Cursor J(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117297);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime ASC ";
      Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.omV.rawQuery(paramString, null);
      AppMethodBeat.o(117297);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int JL(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117276);
    paramString = "SELECT COUNT(*) FROM " + aLY(paramString) + " WHERE" + bvo(paramString) + byw(paramString);
    paramString = this.omV.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117276);
    return i;
  }
  
  public final boolean JM(String paramString)
  {
    AppMethodBeat.i(117275);
    boolean bool = "message".equals(aLY(paramString));
    AppMethodBeat.o(117275);
    return bool;
  }
  
  public final int K(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117300);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ( SELECT * FROM ").append(aLY(paramString)).append(" WHERE").append(byw(paramString));
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
        paramString = this.omV.rawQuery(str, null, 2);
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
  
  public final int L(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117302);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT COUNT(*) FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1;
      paramString = this.omV.rawQuery(paramString, null, 2);
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
  
  public final Cursor M(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117303);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.omV.rawQuery(paramString, null);
      AppMethodBeat.o(117303);
      return paramString;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  /* Error */
  public final List<cc> N(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 806
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 6
    //   9: new 234	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 235	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: getfield 153	com/tencent/mm/storage/cd:omV	Lcom/tencent/mm/storagebase/h;
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 499	com/tencent/mm/storage/cd:aLY	(Ljava/lang/String;)Ljava/lang/String;
    //   27: aconst_null
    //   28: new 63	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 807	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 682	com/tencent/mm/storage/cd:byw	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 809
    //   46: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: iconst_2
    //   53: anewarray 61	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: lload_2
    //   59: invokestatic 766	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: lload 4
    //   67: invokestatic 766	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   70: aastore
    //   71: aconst_null
    //   72: aconst_null
    //   73: ldc_w 811
    //   76: iconst_2
    //   77: invokevirtual 255	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   80: astore_1
    //   81: aload_1
    //   82: astore 6
    //   84: aload 6
    //   86: astore_1
    //   87: aload 6
    //   89: invokeinterface 261 1 0
    //   94: ifeq +86 -> 180
    //   97: aload 6
    //   99: astore_1
    //   100: new 263	com/tencent/mm/storage/cc
    //   103: dup
    //   104: invokespecial 264	com/tencent/mm/storage/cc:<init>	()V
    //   107: astore 8
    //   109: aload 6
    //   111: astore_1
    //   112: aload 8
    //   114: aload 6
    //   116: invokevirtual 268	com/tencent/mm/storage/cc:convertFrom	(Landroid/database/Cursor;)V
    //   119: aload 6
    //   121: astore_1
    //   122: aload 7
    //   124: aload 8
    //   126: invokevirtual 812	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: goto -46 -> 84
    //   133: astore 7
    //   135: aload 6
    //   137: astore_1
    //   138: ldc 165
    //   140: aload 7
    //   142: ldc_w 814
    //   145: iconst_1
    //   146: anewarray 169	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload 7
    //   153: invokevirtual 430	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 795	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aload 6
    //   162: ifnull +10 -> 172
    //   165: aload 6
    //   167: invokeinterface 286 1 0
    //   172: ldc_w 806
    //   175: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: aload 6
    //   182: ifnull +10 -> 192
    //   185: aload 6
    //   187: invokeinterface 286 1 0
    //   192: ldc_w 806
    //   195: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 7
    //   200: areturn
    //   201: astore_1
    //   202: aload 6
    //   204: ifnull +10 -> 214
    //   207: aload 6
    //   209: invokeinterface 286 1 0
    //   214: ldc_w 806
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
    //   0	241	0	this	cd
    //   0	241	1	paramString	String
    //   0	241	2	paramLong1	long
    //   0	241	4	paramLong2	long
    //   7	230	6	str	String
    //   16	107	7	localArrayList	ArrayList
    //   133	66	7	localException1	Exception
    //   222	6	7	localObject	Object
    //   233	1	7	localException2	Exception
    //   107	18	8	localcc	cc
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
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(117296);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = new StringBuilder("SELECT * FROM ").append(aLY(paramString)).append(" WHERE").append(byw(paramString)).append("AND createTime >= ").append(paramLong2).append(" AND createTime <= ").append(paramLong1).append(" AND isSend=");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString = i + " LIMIT 1";
        Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
        paramString = this.omV.rawQuery(paramString, null);
        AppMethodBeat.o(117296);
        return paramString;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void a(long paramLong, cc paramcc)
  {
    AppMethodBeat.i(117258);
    if (paramcc.jbz())
    {
      String str = byy(paramcc.jUr);
      if (au.bwv(str))
      {
        Log.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
        paramcc.BS("notifymessage");
      }
    }
    if (paramcc.getType() == 1075839025) {
      paramcc.BS("notifymessage");
    }
    bJ(paramcc);
    if (this.omV.update(ze(paramLong), paramcc.convertTo(), "msgId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new i.c(paramcc.field_talker, "update", paramcc));
      AppMethodBeat.o(117258);
      return;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 244L, 1L, false);
    AppMethodBeat.o(117258);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(117192);
    this.acFL.remove(parama);
    AppMethodBeat.o(117192);
  }
  
  public final void a(i.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(117191);
    this.acFL.add(parama, paramLooper);
    AppMethodBeat.o(117191);
  }
  
  public final void a(i.b paramb)
  {
    AppMethodBeat.i(117203);
    synchronized (this.adkY)
    {
      this.adkY.add(paramb);
      b(paramb);
      AppMethodBeat.o(117203);
      return;
    }
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(117190);
    if (this.acFL.event(paramc)) {
      this.acFL.doNotify();
    }
    AppMethodBeat.o(117190);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(117189);
    if (!this.adkX.contains(parame))
    {
      Log.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", new Object[] { parame });
      this.adkX.add(parame);
    }
    AppMethodBeat.o(117189);
  }
  
  public final List<cc> aB(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117233);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + aLY(paramString) + " WHERE " + jcz() + " ORDER BY createTime DESC LIMIT " + paramInt1 + " , " + paramInt2;
    Log.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.omV.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      cc localcc = new cc();
      localcc.convertFrom(paramString);
      if (localcc.fxR()) {
        localArrayList.add(localcc);
      }
    }
    paramString.close();
    AppMethodBeat.o(117233);
    return localArrayList;
  }
  
  public final Cursor aC(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117243);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117243);
      return null;
    }
    String str = aLY(paramString);
    paramString = "select * from ( select * from " + str + " where" + bvo(paramString) + byw(paramString) + " AND type IN (3,39,13,43,62,44,268435505,486539313)  order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = this.omV.rawQuery(paramString, null, 2);
    AppMethodBeat.o(117243);
    return paramString;
  }
  
  public final void aLB(String paramString)
  {
    AppMethodBeat.i(117195);
    Log.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.adlh), Integer.valueOf(super.lockCount()), Integer.valueOf(this.acFL.lockCount()), Integer.valueOf(this.adlg.size()), this.adli, Long.valueOf(Util.milliSecondsToNow(this.adlj)) });
    if (Util.isNullOrNil(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (this.adlh)
    {
      Log.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", new Object[] { this.adli, Long.valueOf(Util.milliSecondsToNow(this.adlj)) });
      AppMethodBeat.o(117195);
      return;
    }
    this.adli = paramString;
    this.adlj = Util.nowMilliSecond();
    this.adlh = true;
    super.lock();
    this.acFL.lock();
    AppMethodBeat.o(117195);
  }
  
  public final void aLC(String arg1)
  {
    AppMethodBeat.i(117196);
    Log.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { ???, Boolean.valueOf(this.adlh), Integer.valueOf(super.lockCount()), Integer.valueOf(this.acFL.lockCount()), Integer.valueOf(this.adlg.size()), this.adli, Long.valueOf(Util.milliSecondsToNow(this.adlj)) });
    if (Util.isNullOrNil(???)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (!this.adlh)
    {
      Log.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", new Object[] { ???, Util.getStack() });
      AppMethodBeat.o(117196);
      return;
    }
    if (!???.equals(this.adli))
    {
      Log.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", new Object[] { this.adli, Long.valueOf(Util.milliSecondsToNow(this.adlj)), ??? });
      AppMethodBeat.o(117196);
      return;
    }
    this.adlh = false;
    this.adlj = 0L;
    this.adli = "";
    synchronized (this.adlg)
    {
      Iterator localIterator = this.adlg.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a((i.c)this.adlg.get(str));
      }
    }
    this.adlg.clear();
    super.unlock();
    this.acFL.unlock();
    doNotify();
    AppMethodBeat.o(117196);
  }
  
  public final void aLD(String paramString)
  {
    AppMethodBeat.i(117197);
    if (!this.adlh)
    {
      AppMethodBeat.o(117197);
      return;
    }
    i.c localc = null;
    synchronized (this.adlg)
    {
      if (this.adlg.containsKey(paramString)) {
        localc = (i.c)this.adlg.get(paramString);
      }
      if (localc == null)
      {
        Log.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", new Object[] { paramString, Util.getStack() });
        AppMethodBeat.o(117197);
        return;
      }
    }
    if ((localc.KRm != null) && (localc.KRm.equals("insert")) && (localc.apS > 0))
    {
      Log.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", new Object[] { paramString, Integer.valueOf(localc.apS) });
      localc.apS = 0;
    }
    AppMethodBeat.o(117197);
  }
  
  public final Cursor aLE(String paramString)
  {
    AppMethodBeat.i(117211);
    com.tencent.mm.storagebase.h localh = this.omV;
    String str = aLY(paramString);
    paramString = bvo(paramString) + byw(paramString);
    paramString = localh.query(str, new String[] { "createTime", "msgId" }, paramString, null, "createTime", null, "createTime ASC");
    AppMethodBeat.o(117211);
    return paramString;
  }
  
  public final cc aLF(String paramString)
  {
    AppMethodBeat.i(117222);
    cc localcc = new cc();
    paramString = this.omV.query(aLY(paramString), null, byw(paramString), null, null, null, "msgSvrId  DESC limit 1 ", 2);
    if (paramString.moveToFirst()) {
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117222);
    return localcc;
  }
  
  public final cc aLG(String paramString)
  {
    AppMethodBeat.i(117223);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117223);
      return null;
    }
    cc localcc = new cc();
    paramString = "select * from " + aLY(paramString) + " where" + bvo(paramString) + byw(paramString) + "order by createTime DESC limit 1";
    paramString = this.omV.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117223);
    return localcc;
  }
  
  public final cc aLH(String paramString)
  {
    AppMethodBeat.i(248657);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(248657);
      return null;
    }
    cc localcc = new cc();
    paramString = "select * from " + aLY(paramString) + " where" + bvo(paramString) + byw(paramString) + "order by createTime ASC limit 1";
    paramString = this.omV.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(248657);
    return localcc;
  }
  
  public final cc aLI(String paramString)
  {
    AppMethodBeat.i(117226);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117226);
      return null;
    }
    cc localcc = new cc();
    paramString = "select * from " + aLY(paramString) + " where" + byw(paramString) + "and isSend = 0  order by createTime DESC limit 1";
    paramString = this.omV.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117226);
    return localcc;
  }
  
  public final cc aLJ(String paramString)
  {
    AppMethodBeat.i(117230);
    if (this.adkY == null)
    {
      Log.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117230);
      return null;
    }
    cc localcc = new cc();
    long l1 = 0L;
    if (Util.isNullOrNil(paramString)) {}
    for (paramString = "";; paramString = paramString.replaceFirst("and", "where"))
    {
      int i = 0;
      while (i < this.adkY.size())
      {
        long l2 = l1;
        if ((((i.b)this.adkY.get(i)).KRj & 0x8) != 0)
        {
          Object localObject = "select * from " + ((i.b)this.adkY.get(i)).name + paramString + "  order by createTime DESC limit 1";
          localObject = this.omV.rawQuery((String)localObject, null, 2);
          l2 = l1;
          if (((Cursor)localObject).moveToFirst())
          {
            long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
            l2 = l1;
            if (l1 < l3)
            {
              localcc.convertFrom((Cursor)localObject);
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
    return localcc;
  }
  
  public final List<cc> aLL(String paramString)
  {
    cc localcc = null;
    AppMethodBeat.i(117240);
    Cursor localCursor = this.omV.rawQuery("select * from ".concat(String.valueOf(paramString)), null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(117240);
      return null;
    }
    paramString = localcc;
    if (localCursor.moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        localcc = new cc();
        localcc.convertFrom(localCursor);
        paramString.add(localcc);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(117240);
    return paramString;
  }
  
  public final Cursor aLM(String paramString)
  {
    AppMethodBeat.i(117247);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117247);
      return null;
    }
    Object localObject = aLY(paramString);
    paramString = "select * from " + (String)localObject + " " + byz((String)localObject) + " where" + byw(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime";
    localObject = this.omV.rawQuery(paramString, null);
    Log.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(117247);
    return localObject;
  }
  
  public final void aLN(String paramString)
  {
    AppMethodBeat.i(117252);
    d(paramString, "", null);
    if (this.omV.execSQL(paramString, "delete from ".concat(String.valueOf(paramString))))
    {
      doNotify("delete_all ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117252);
      return;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 247L, 1L, false);
    AppMethodBeat.o(117252);
  }
  
  public final int aLO(String paramString)
  {
    AppMethodBeat.i(117254);
    Log.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, MMStack.getStack(true) });
    d(aLY(paramString), byw(paramString), null);
    int i = this.omV.delete(aLY(paramString), byw(paramString), null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.KRp = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117254);
    return i;
  }
  
  public final int aLP(String paramString)
  {
    AppMethodBeat.i(117261);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(4));
    int i = this.omV.update(aLY(paramString), localContentValues, byw(paramString) + "AND isSend=? AND status!=? ", new String[] { "0", "4" });
    if (i != 0)
    {
      doNotify();
      a(new i.c(paramString, "update", null));
    }
    AppMethodBeat.o(117261);
    return i;
  }
  
  public final Cursor aLQ(String paramString)
  {
    AppMethodBeat.i(117263);
    paramString = this.omV.query(aLY(paramString), null, byw(paramString), null, null, null, "createTime ASC ");
    AppMethodBeat.o(117263);
    return paramString;
  }
  
  public final Cursor aLR(String paramString)
  {
    AppMethodBeat.i(117267);
    paramString = this.omV.query(aLY(paramString), null, "isSend=? AND" + byw(paramString) + "AND status!=?", new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117267);
    return paramString;
  }
  
  public final cc.d aLS(String paramString)
  {
    AppMethodBeat.i(117270);
    cc.d locald2 = (cc.d)this.adkZ.get(Integer.valueOf(paramString.hashCode()));
    cc.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = cc.d.byu(paramString);
      this.adkZ.B(Integer.valueOf(paramString.hashCode()), locald1);
    }
    AppMethodBeat.o(117270);
    return locald1;
  }
  
  public final cc.f aLT(String paramString)
  {
    AppMethodBeat.i(117271);
    cc.f localf2 = (cc.f)this.adla.get(Integer.valueOf(paramString.hashCode()));
    cc.f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = cc.f.byv(paramString);
      this.adla.B(Integer.valueOf(paramString.hashCode()), localf1);
    }
    AppMethodBeat.o(117271);
    return localf1;
  }
  
  public final cc.a aLU(String paramString)
  {
    AppMethodBeat.i(117272);
    cc.a locala1 = null;
    if ((!Util.isNullOrNil(paramString)) && (this.adlb != null)) {
      locala1 = (cc.a)this.adlb.get(Integer.valueOf(paramString.hashCode()));
    }
    for (;;)
    {
      cc.a locala2 = locala1;
      if (locala1 == null)
      {
        locala1 = cc.a.bys(paramString);
        locala2 = locala1;
        if (locala1 != null)
        {
          locala2 = locala1;
          if (this.adlb != null)
          {
            this.adlb.B(Integer.valueOf(Util.nullAs(paramString, "").hashCode()), locala1);
            locala2 = locala1;
          }
        }
      }
      AppMethodBeat.o(117272);
      return locala2;
      Log.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramString)) });
      Log.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
    }
  }
  
  public final cc.c aLV(String paramString)
  {
    AppMethodBeat.i(117273);
    cc.c localc2 = (cc.c)this.adlc.get(Integer.valueOf(paramString.hashCode()));
    cc.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = cc.c.byt(paramString);
      this.adlc.B(Integer.valueOf(paramString.hashCode()), localc1);
    }
    AppMethodBeat.o(117273);
    return localc1;
  }
  
  public final int aLW(String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(117274);
    if (JM(paramString))
    {
      i = this.vdK.byi(paramString);
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
      i = JL(paramString);
      AppMethodBeat.o(117274);
      return i;
      if (("appbrandmessage".equals(aLY(paramString))) || ("appbrandnotifymessage".equals(aLY(paramString))))
      {
        paramString = "SELECT COUNT(*) FROM " + aLY(paramString) + " WHERE" + byw(paramString);
        paramString = this.omV.rawQuery(paramString, null);
        if (paramString.moveToLast()) {
          i = paramString.getInt(0);
        }
        paramString.close();
        AppMethodBeat.o(117274);
        return i;
      }
    } while (!"bottlemessage".equals(aLY(paramString)));
    paramString = "SELECT COUNT(*) FROM " + aLY(paramString) + " WHERE" + byw(paramString);
    paramString = this.omV.rawQuery(paramString, null, 2);
    i = j;
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117274);
    return i;
  }
  
  public final int aLX(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117280);
    if (paramString == null)
    {
      Log.w("MicroMsg.MsgInfoStorage", "getImgVideoMsgCount talker is null!");
      AppMethodBeat.o(117280);
      return 0;
    }
    paramString = "SELECT COUNT(*) FROM " + aLY(paramString) + " WHERE " + bvo(paramString) + "talker= '" + Util.escapeSqlValue(paramString) + "' AND type IN (3,39,13,43,62,44,268435505,486539313)";
    paramString = this.omV.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117280);
    return i;
  }
  
  public final String aLY(String paramString)
  {
    AppMethodBeat.i(117283);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = byC(paramString).name;
      AppMethodBeat.o(117283);
      return paramString;
    }
  }
  
  public final long aLZ(String paramString)
  {
    AppMethodBeat.i(117289);
    Object localObject = "select createTime from message where" + byw(paramString) + "order by createTime LIMIT 1 OFFSET 0";
    Log.d("MicroMsg.MsgInfoStorage", "get first message create time: ".concat(String.valueOf(localObject)));
    localObject = this.omV.rawQuery((String)localObject, null, 2);
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
  
  public final long aMa(String paramString)
  {
    AppMethodBeat.i(117291);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117291);
      return 0L;
    }
    Object localObject = "select msgSeq from message where" + byw(paramString) + "order by msgSeq DESC LIMIT 1 ";
    Log.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: ".concat(String.valueOf(localObject)));
    localObject = this.omV.rawQuery((String)localObject, null, 2);
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
  
  public final cc aMb(String paramString)
  {
    AppMethodBeat.i(117293);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117293);
      return null;
    }
    Log.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", new Object[] { paramString, Boolean.FALSE });
    Object localObject1 = (Long)this.adle.get(paramString);
    if ((localObject1 != null) && (((Long)localObject1).longValue() > 0L))
    {
      Log.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", new Object[] { Long.valueOf(((Long)localObject1).longValue()) });
      localObject1 = sl(((Long)localObject1).longValue());
      if ((localObject1 != null) && ((((fi)localObject1).field_flag & 0x1) != 0))
      {
        AppMethodBeat.o(117293);
        return localObject1;
      }
      this.adle.remove(paramString);
      AppMethodBeat.o(117293);
      return null;
    }
    Log.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
    localObject1 = new cc();
    long l = System.currentTimeMillis();
    Object localObject2 = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ";
    localObject2 = this.omV.rawQuery((String)localObject2, null, 2);
    Log.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(Thread.currentThread().getId()) });
    if (localObject2 == null)
    {
      Log.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117293);
      return localObject1;
    }
    if (((Cursor)localObject2).moveToFirst()) {
      ((cc)localObject1).convertFrom((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    this.adle.B(paramString, Long.valueOf(((fi)localObject1).field_msgId));
    AppMethodBeat.o(117293);
    return localObject1;
  }
  
  public final int aMc(String paramString)
  {
    AppMethodBeat.i(117307);
    String str = " SELECT COUNT(*) FROM " + aLY(paramString) + " WHERE" + bvo(paramString) + byw(paramString) + "AND isSend=1";
    Cursor localCursor = this.omV.rawQuery(str, null, 2);
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
  public final List<cc> aMd(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 1255
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 234	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 235	java/util/ArrayList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 153	com/tencent/mm/storage/cd:omV	Lcom/tencent/mm/storagebase/h;
    //   20: ldc 71
    //   22: aconst_null
    //   23: ldc_w 1257
    //   26: iconst_2
    //   27: anewarray 61	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: invokestatic 511	com/tencent/mm/sdk/platformtools/Util:escapeSqlValue	(Ljava/lang/String;)Ljava/lang/String;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: invokestatic 583	java/lang/System:currentTimeMillis	()J
    //   42: ldc2_w 278
    //   45: lsub
    //   46: invokestatic 766	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: ldc_w 1001
    //   55: iconst_2
    //   56: invokevirtual 255	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokeinterface 261 1 0
    //   70: ifeq +75 -> 145
    //   73: aload_2
    //   74: astore_1
    //   75: new 263	com/tencent/mm/storage/cc
    //   78: dup
    //   79: invokespecial 264	com/tencent/mm/storage/cc:<init>	()V
    //   82: astore 4
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: aload_2
    //   89: invokevirtual 268	com/tencent/mm/storage/cc:convertFrom	(Landroid/database/Cursor;)V
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: aload 4
    //   97: invokevirtual 812	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto -39 -> 62
    //   104: astore_3
    //   105: aload_2
    //   106: astore_1
    //   107: ldc 165
    //   109: aload_3
    //   110: ldc_w 1259
    //   113: iconst_1
    //   114: anewarray 169	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: invokevirtual 430	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 795	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_2
    //   128: ifnull +9 -> 137
    //   131: aload_2
    //   132: invokeinterface 286 1 0
    //   137: ldc_w 1255
    //   140: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aconst_null
    //   144: areturn
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 286 1 0
    //   155: ldc_w 1255
    //   158: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_3
    //   162: areturn
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +9 -> 174
    //   168: aload_2
    //   169: invokeinterface 286 1 0
    //   174: ldc_w 1255
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
    //   0	196	0	this	cd
    //   0	196	1	paramString	String
    //   1	192	2	str	String
    //   15	80	3	localArrayList	ArrayList
    //   104	58	3	localException1	Exception
    //   182	4	3	localObject	Object
    //   190	1	3	localException2	Exception
    //   82	14	4	localcc	cc
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
  
  public final long aMe(String paramString)
  {
    AppMethodBeat.i(117317);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    paramString = byA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    long l = paramString.oGz;
    AppMethodBeat.o(117317);
    return l;
  }
  
  public final Cursor aMf(String paramString)
  {
    AppMethodBeat.i(117315);
    try
    {
      paramString = this.omV.query(aLY(paramString), null, byw(paramString) + " AND createTime>=? AND type IN (436207665,419430449" + ")", new String[] { String.valueOf(System.currentTimeMillis() - 86400000L) }, null, null, "createTime ASC", 2);
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
  
  public final long aMg(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(248950);
    paramString = "SELECT COUNT(*) FROM " + aLY(paramString) + " WHERE " + byw(paramString) + " AND type NOT IN (10000,10002,570425393,64,603979825,855638065,889192497" + ",922746929)";
    paramString = this.omV.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    long l = i;
    AppMethodBeat.o(248950);
    return l;
  }
  
  public final void aT(String paramString, long paramLong)
  {
    AppMethodBeat.i(117199);
    i.b localb = byC(paramString);
    long l = localb.oGz;
    Random localRandom = new Random();
    this.omV.execSQL("message", "BEGIN;");
    cc localcc = new cc(paramString);
    int i = 0;
    while (i < paramLong)
    {
      localcc.setCreateTime(System.currentTimeMillis());
      localcc.setType(1);
      localcc.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + Util.random());
      localcc.setMsgId(l);
      localcc.setStatus(localRandom.nextInt(4));
      localcc.pI(localRandom.nextInt(1));
      l += 1L;
      localb.oGz += 1L;
      localcc.gX(System.currentTimeMillis() + Util.random());
      this.omV.execSQL("message", "INSERT INTO " + aLY(localcc.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + localcc.field_msgId + "," + localcc.field_msgSvrId + "," + localcc.getType() + "," + localcc.field_status + "," + localcc.getCreateTime() + ",'" + localcc.field_talker + "','" + localcc.field_content + "'," + byx(paramString) + ");");
      if (i % 10000 == 0)
      {
        this.omV.execSQL("message", "COMMIT;");
        this.omV.execSQL("message", "BEGIN;");
      }
      i += 1;
    }
    this.omV.execSQL("message", "COMMIT;");
    this.vdK.bxN(paramString);
    localcc.setMsgId(1L + l);
    c(localcc, false);
    AppMethodBeat.o(117199);
  }
  
  public final cc aU(String paramString, long paramLong)
  {
    AppMethodBeat.i(117208);
    cc localcc = new cc();
    paramString = this.omV.query(aLY(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117208);
    return localcc;
  }
  
  public final cc aV(String paramString, long paramLong)
  {
    AppMethodBeat.i(117209);
    cc localcc = new cc();
    paramString = this.omV.query(aLY(paramString), null, byw(paramString) + " AND msgSeq=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117209);
    return localcc;
  }
  
  public final cc aW(String paramString, long paramLong)
  {
    AppMethodBeat.i(117210);
    cc localcc = new cc();
    paramString = this.omV.query(aLY(paramString), null, "createTime=? AND" + byw(paramString), new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117210);
    return localcc;
  }
  
  public final cc aX(String paramString, long paramLong)
  {
    AppMethodBeat.i(117214);
    cc localcc = new cc();
    paramString = "Select * From " + aLY(paramString) + " Where " + byw(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
    paramString = this.omV.rawQuery(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117214);
    return localcc;
  }
  
  public final cc aY(String paramString, long paramLong)
  {
    AppMethodBeat.i(117215);
    cc localcc = new cc();
    paramString = "Select * From " + aLY(paramString) + " Where " + byw(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
    paramString = this.omV.rawQuery(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117215);
    return localcc;
  }
  
  public final void aY(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(117219);
    long l1 = this.omV.beginTransaction(-1L);
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        long l2 = ((Long)paramArrayList.next()).longValue();
        cc localcc = sl(l2);
        if (localcc != null)
        {
          localcc.po(localcc.jUq | 0x20);
          Log.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
          a(l2, localcc);
        }
      }
      this.omV.endTransaction(l1);
    }
    finally
    {
      this.omV.endTransaction(l1);
      AppMethodBeat.o(117219);
    }
    AppMethodBeat.o(117219);
  }
  
  public final int aZ(cc paramcc)
  {
    int i = 0;
    AppMethodBeat.i(117234);
    if ((paramcc == null) || (Util.isNullOrNil(paramcc.field_talker)))
    {
      AppMethodBeat.o(117234);
      return 0;
    }
    paramcc = "SELECT count(msgId) FROM " + aLY(paramcc.field_talker) + " WHERE" + byw(paramcc.field_talker) + "AND isSend = 0 AND msgId >= " + paramcc.field_msgId + " ORDER BY createTime DESC";
    paramcc = this.omV.rawQuery(paramcc, null, 2);
    if (paramcc.moveToFirst()) {
      i = paramcc.getInt(0);
    }
    paramcc.close();
    AppMethodBeat.o(117234);
    return i;
  }
  
  public final boolean aZ(String paramString, long paramLong)
  {
    AppMethodBeat.i(117220);
    paramString = aW(paramString, paramLong);
    if ((paramString != null) && (paramString.field_msgId > 0L))
    {
      AppMethodBeat.o(117220);
      return true;
    }
    AppMethodBeat.o(117220);
    return false;
  }
  
  public final cc aaD(int paramInt)
  {
    AppMethodBeat.i(117229);
    if (this.adkY == null)
    {
      Log.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117229);
      return null;
    }
    cc localcc = new cc();
    long l1 = 0L;
    int i = 0;
    while (i < this.adkY.size())
    {
      long l2 = l1;
      if ((((i.b)this.adkY.get(i)).KRj & paramInt) != 0)
      {
        Object localObject = "select * from " + ((i.b)this.adkY.get(i)).name + "  order by createTime DESC limit 1";
        localObject = this.omV.rawQuery((String)localObject, null, 2);
        l2 = l1;
        if (((Cursor)localObject).moveToFirst())
        {
          long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
          l2 = l1;
          if (l1 < l3)
          {
            localcc.convertFrom((Cursor)localObject);
            l2 = l3;
          }
        }
        ((Cursor)localObject).close();
      }
      i += 1;
      l1 = l2;
    }
    AppMethodBeat.o(117229);
    return localcc;
  }
  
  public final List<cc> aaE(int paramInt)
  {
    AppMethodBeat.i(248692);
    Object localObject = new LinkedList();
    int i = 0;
    while (i < this.adkY.size())
    {
      String str = ((i.b)this.adkY.get(i)).name;
      if ((!str.startsWith("findermessage")) && (!str.equalsIgnoreCase("gamelifemessage"))) {
        ((List)localObject).add((i.b)this.adkY.get(i));
      }
      i += 1;
    }
    localObject = U(paramInt, (List)localObject);
    AppMethodBeat.o(248692);
    return localObject;
  }
  
  public final Cursor ar(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117304);
    String str = " SELECT * FROM " + aLY(paramString1) + " WHERE" + bvo(paramString1) + byw(paramString1) + "AND content LIKE '" + paramString2 + "%' ORDER BY createTime DESC LIMIT " + paramInt;
    Log.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), str });
    paramString1 = this.omV.rawQuery(str, null);
    AppMethodBeat.o(117304);
    return paramString1;
  }
  
  public final Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(117299);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(aLY(paramString)).append(" WHERE").append(byw(paramString));
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
        paramString = this.omV.rawQuery(str, null);
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
  
  public final void b(long paramLong, cc paramcc)
  {
    AppMethodBeat.i(117260);
    if (Util.nullAsNil(paramcc.field_talker).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("no talker set when update by svrid", bool);
      if (paramcc.jbz())
      {
        String str = byy(paramcc.jUr);
        if (au.bwv(str))
        {
          Log.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
          paramcc.BS("notifymessage");
        }
      }
      if (paramcc.getType() == 1075839025) {
        paramcc.BS("notifymessage");
      }
      bJ(paramcc);
      if (paramLong != 0L) {
        break;
      }
      Log.w("MicroMsg.MsgInfoStorage", "invalid svr id %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(117260);
      return;
    }
    if (this.omV.update(aLY(paramcc.field_talker), paramcc.convertTo(), "msgSvrId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new i.c(paramcc.field_talker, "update", paramcc));
      AppMethodBeat.o(117260);
      return;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 243L, 1L, false);
    AppMethodBeat.o(117260);
  }
  
  public final void bCI()
  {
    AppMethodBeat.i(117227);
    Cursor localCursor = this.omV.rawQuery("select * from message wherecontent like '%aaaabbbbbfdf%'", null, 2);
    localCursor.getCount();
    SystemClock.sleep(5000L);
    localCursor.close();
    AppMethodBeat.o(117227);
  }
  
  public final long ba(cc paramcc)
  {
    AppMethodBeat.i(369605);
    long l = c(paramcc, false);
    AppMethodBeat.o(369605);
    return l;
  }
  
  public final cc ba(String paramString, long paramLong)
  {
    AppMethodBeat.i(117224);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117224);
      return null;
    }
    cc localcc = new cc();
    paramString = "select * from " + aLY(paramString) + " where" + byw(paramString) + "AND msgSeq<" + paramLong + " order by msgSeq DESC limit 1";
    Cursor localCursor = this.omV.rawQuery(paramString, null, 2);
    if (localCursor.moveToFirst()) {
      localcc.convertFrom(localCursor);
    }
    localCursor.close();
    Log.d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117224);
    return localcc;
  }
  
  public final Cursor bb(String paramString, long paramLong)
  {
    AppMethodBeat.i(177113);
    paramString = this.omV.jef().rawQueryWithFactory(null, "SELECT * FROM " + paramString + " WHERE createTime < " + paramLong, null, paramString);
    AppMethodBeat.o(177113);
    return paramString;
  }
  
  public final void bb(cc paramcc)
  {
    AppMethodBeat.i(117259);
    if ((paramcc == null) || (paramcc.field_status == 4))
    {
      AppMethodBeat.o(117259);
      return;
    }
    paramcc.setStatus(4);
    String str = ze(paramcc.field_msgId);
    if ((str != null) && (str.length() > 0)) {
      if (this.omV.update(str, paramcc.convertTo(), "msgId=?", new String[] { paramcc.field_msgId }) != 0)
      {
        doNotify();
        a(new i.c(paramcc.field_talker, "update", paramcc, -1));
      }
    }
    AppMethodBeat.o(117259);
  }
  
  public final int bc(cc paramcc)
  {
    int i = 0;
    AppMethodBeat.i(117262);
    if (paramcc != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("content", paramcc.field_content);
      localContentValues.put("status", Integer.valueOf(paramcc.field_status));
      int j = this.omV.update(ze(paramcc.field_msgId), localContentValues, "msgId=?", new String[] { String.valueOf(paramcc.field_msgId) });
      i = j;
      if (j != 0)
      {
        doNotify();
        a(new i.c(paramcc.field_talker, "update", paramcc));
        i = j;
      }
    }
    AppMethodBeat.o(117262);
    return i;
  }
  
  public final long bc(String paramString, long paramLong)
  {
    AppMethodBeat.i(117241);
    paramString = "select createTime from " + aLY(paramString) + " where msgId = " + paramLong;
    paramLong = 0L;
    paramString = this.omV.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      paramLong = paramString.getLong(0);
    }
    paramString.close();
    AppMethodBeat.o(117241);
    return paramLong;
  }
  
  /* Error */
  public final int bd(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 1489
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: ldc 143
    //   10: aconst_null
    //   11: invokevirtual 1058	com/tencent/mm/storage/cd:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 153	com/tencent/mm/storage/cd:omV	Lcom/tencent/mm/storagebase/h;
    //   18: invokevirtual 1460	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   21: new 63	java/lang/StringBuilder
    //   24: dup
    //   25: ldc_w 1491
    //   28: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   31: aload_1
    //   32: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc_w 1493
    //   38: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokevirtual 1497	com/tencent/wcdb/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   47: astore 5
    //   49: aload 5
    //   51: iconst_1
    //   52: lload_2
    //   53: invokevirtual 1503	com/tencent/wcdb/database/SQLiteStatement:bindLong	(IJ)V
    //   56: aload 5
    //   58: invokevirtual 1506	com/tencent/wcdb/database/SQLiteStatement:executeUpdateDelete	()I
    //   61: istore 4
    //   63: iload 4
    //   65: ifle +17 -> 82
    //   68: aload_0
    //   69: ldc_w 1062
    //   72: aload_1
    //   73: invokestatic 720	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   76: invokevirtual 723	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   79: invokevirtual 1064	com/tencent/mm/storage/cd:doNotify	(Ljava/lang/String;)V
    //   82: aload 5
    //   84: ifnull +8 -> 92
    //   87: aload 5
    //   89: invokevirtual 1507	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   92: ldc_w 1489
    //   95: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: iload 4
    //   100: ireturn
    //   101: astore_1
    //   102: aload 5
    //   104: ifnull +8 -> 112
    //   107: aload 5
    //   109: invokevirtual 1507	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   112: ldc_w 1489
    //   115: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: getstatic 871	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   124: ldc2_w 872
    //   127: ldc2_w 1065
    //   130: lconst_1
    //   131: iconst_0
    //   132: invokevirtual 879	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   135: ldc_w 1489
    //   138: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: iconst_m1
    //   142: ireturn
    //   143: astore 5
    //   145: aload_1
    //   146: aload 5
    //   148: invokevirtual 1513	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   151: goto -39 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	cd
    //   0	154	1	paramString	String
    //   0	154	2	paramLong	long
    //   61	38	4	i	int
    //   47	61	5	localSQLiteStatement	com.tencent.wcdb.database.SQLiteStatement
    //   143	4	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   49	63	101	finally
    //   68	82	101	finally
    //   14	49	120	java/lang/RuntimeException
    //   87	92	120	java/lang/RuntimeException
    //   112	120	120	java/lang/RuntimeException
    //   145	151	120	java/lang/RuntimeException
    //   107	112	143	finally
  }
  
  public final int be(String paramString, long paramLong)
  {
    AppMethodBeat.i(117253);
    cc localcc = aU(paramString, paramLong);
    this.adlf.x((int)(Util.nowSecond() / 86400L), localcc.field_msgSvrId, localcc.getCreateTime() / 1000L);
    int i = this.omV.delete(aLY(paramString), "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      doNotify();
      a(new i.c(paramString, "delete", null, 1, (byte)0));
    }
    for (;;)
    {
      AppMethodBeat.o(117253);
      return i;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 246L, 1L, false);
    }
  }
  
  public final int bf(String paramString, long paramLong)
  {
    AppMethodBeat.i(117255);
    String str = byw(paramString) + " and createTime <= " + paramLong;
    d(aLY(paramString), str, null);
    int i = this.omV.delete(aLY(paramString), str, null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.KRp = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117255);
    return i;
  }
  
  public final int bg(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(117281);
    cc localcc = sl(paramLong);
    if ((localcc == null) || (localcc.field_msgId == 0L))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117281);
      return 0;
    }
    String str = aLY(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " " + byz(str) + " WHERE " + bvo(paramString) + byw(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + localcc.getCreateTime();
    paramString = this.omV.rawQuery(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117281);
    return i;
  }
  
  public final String bh(String paramString, long paramLong)
  {
    AppMethodBeat.i(117282);
    Object localObject1 = sl(paramLong);
    if ((localObject1 == null) || (((fi)localObject1).field_msgId == 0L))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117282);
      return null;
    }
    Object localObject2 = aLY(paramString);
    paramString = "EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + (String)localObject2 + " " + byz((String)localObject2) + " WHERE" + bvo(paramString) + byw(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + ((cc)localObject1).getCreateTime();
    localObject2 = this.omV.rawQuery(paramString, null);
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
  
  public final Cursor bi(String paramString, long paramLong)
  {
    AppMethodBeat.i(249012);
    paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC ";
    Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
    paramString = this.omV.rawQuery(paramString, null);
    AppMethodBeat.o(249012);
    return paramString;
  }
  
  public final cc bj(String paramString, long paramLong)
  {
    AppMethodBeat.i(117309);
    Log.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(1) });
    cc localcc = new cc();
    paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND createTime < " + paramLong + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1";
    Log.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.omV.rawQuery(paramString, null);
    if (paramString == null)
    {
      Log.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(117309);
      return localcc;
    }
    if (paramString.moveToLast())
    {
      localcc.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(117309);
      return localcc;
    }
    paramString.close();
    Log.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117309);
    return localcc;
  }
  
  public final cc bk(String paramString, long paramLong)
  {
    AppMethodBeat.i(249049);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(249049);
      return null;
    }
    Object localObject = "select * from message where" + byw(paramString) + " and createTime < " + paramLong + " order by createTime DESC LIMIT 1 ";
    Log.d("MicroMsg.MsgInfoStorage", "getBeforeMsg: ".concat(String.valueOf(localObject)));
    localObject = this.omV.rawQuery((String)localObject, null);
    if (localObject == null)
    {
      Log.e("MicroMsg.MsgInfoStorage", "getBeforeMsgq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(249049);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new cc();
      paramString.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(249049);
      return paramString;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(249049);
    return null;
  }
  
  public final long c(cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(117238);
    if ((paramcc == null) || (Util.isNullOrNil(paramcc.field_talker)))
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 250L, 1L, false);
      if (paramcc == null) {}
      for (localObject1 = "-1";; localObject1 = paramcc.field_talker)
      {
        Log.e("MicroMsg.MsgInfoStorage", "Error insert message msg:%s talker:%s", new Object[] { paramcc, localObject1 });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    Log.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", new Object[] { Boolean.valueOf(this.adlh), Long.valueOf(paramcc.field_msgSeq) });
    Object localObject1 = null;
    Object localObject2 = br.JP(paramcc.jUr);
    if (localObject2 != null) {
      localObject1 = ((br.b)localObject2).olO;
    }
    if (au.bwv((String)localObject1))
    {
      Log.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { localObject1 });
      if (paramcc.getType() == 436207665)
      {
        Log.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
        AppMethodBeat.o(117238);
        return -1L;
      }
      paramcc.BS("notifymessage");
    }
    if (paramcc.getType() == 1075839025) {
      paramcc.BS("notifymessage");
    }
    localObject1 = byC(paramcc.field_talker);
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 249L, 1L, false);
      Log.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", new Object[] { paramcc.field_talker });
      AppMethodBeat.o(117238);
      return -1L;
    }
    ((i.b)localObject1).bd(paramcc);
    Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[] { Long.valueOf(paramcc.field_msgId), localObject1, ze(paramcc.field_msgId) }), ((i.b)localObject1).name.equals(ze(paramcc.field_msgId)));
    if (paramcc.field_msgSvrId != 0L)
    {
      paramcc.kLk = 1;
      paramcc.jTR = true;
    }
    ??? = this.adkX.iterator();
    while (((Iterator)???).hasNext()) {
      if (!((e)((Iterator)???).next()).a(paramcc, (br.b)localObject2))
      {
        Log.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", new Object[] { paramcc.field_talker, paramcc.jUr });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    bJ(paramcc);
    if (((i.b)localObject1).name.equals("message"))
    {
      paramcc.field_talkerId = ((int)byx(paramcc.field_talker));
      paramcc.jTS = true;
    }
    localObject2 = paramcc.convertTo();
    com.tencent.mm.storagebase.f localf;
    if (paramBoolean)
    {
      localf = this.omV.jee();
      ??? = ((i.b)localObject1).name;
      if (localf.adnj != null)
      {
        localObject1 = localf.adnj;
        if (com.tencent.mm.storagebase.f.isMainThread()) {
          com.tencent.mm.storagebase.f.adno.a((SQLiteDatabase)localObject1, 32769, (String)???);
        }
      }
    }
    for (long l = ((SQLiteDatabase)localObject1).insertOrThrow((String)???, "msgId", (ContentValues)localObject2);; l = this.omV.a(((i.b)localObject1).name, "msgId", (ContentValues)localObject2, false))
    {
      Log.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", new Object[] { Long.valueOf(l), paramcc.field_talker, Long.valueOf(paramcc.field_msgId), Integer.valueOf(paramcc.getType()), Integer.valueOf(paramcc.field_status), Long.valueOf(paramcc.field_msgSvrId), Long.valueOf(paramcc.field_msgSeq), Integer.valueOf(paramcc.field_flag), Long.valueOf(paramcc.getCreateTime()), Integer.valueOf(paramcc.field_isSend), this.adli, Long.valueOf(Util.milliSecondsToNow(this.adlj)) });
      if (l != -1L) {
        break label764;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 248L, 1L, false);
      Log.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", new Object[] { Long.valueOf(paramcc.field_msgSvrId), Long.valueOf(l) });
      AppMethodBeat.o(117238);
      return -1L;
      localObject1 = localf.adnk;
      break;
    }
    label764:
    if ((this.adlh) && (Util.milliSecondsToNow(this.adlj) > 2000L) && (paramcc.field_isSend == 1) && (paramcc.field_status == 1))
    {
      Log.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", new Object[] { this.adli, Long.valueOf(Util.milliSecondsToNow(this.adlj)) });
      aLC(this.adli);
    }
    if (this.adlh)
    {
      localObject1 = null;
      if (e.acDF != null) {
        localObject1 = e.acDF.aC(paramcc);
      }
      if (!Util.isNullOrNil((String)localObject1)) {
        break label1081;
      }
    }
    label1081:
    for (localObject2 = paramcc.field_talker;; localObject2 = localObject1)
    {
      localObject1 = null;
      for (;;)
      {
        synchronized (this.adlg)
        {
          if (this.adlg.containsKey(localObject2)) {
            localObject1 = (i.c)this.adlg.get(localObject2);
          }
          if (localObject1 == null)
          {
            localObject1 = new i.c(paramcc.field_talker, "insert", paramcc);
            if (i.c.be(paramcc)) {
              ((i.c)localObject1).apS += 1;
            }
            ((i.c)localObject1).KRn += 1;
            this.adlg.put(localObject2, localObject1);
            l = paramcc.field_msgId;
            AppMethodBeat.o(117238);
            return l;
          }
          ((i.c)localObject1).mZo.add(paramcc);
        }
        localObject1 = new i.c(paramcc.field_talker, "insert", paramcc);
        if (i.c.be(paramcc)) {
          ((i.c)localObject1).apS = 1;
        }
        ((i.c)localObject1).KRn = 1;
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
      paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND createTime > " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.omV.rawQuery(paramString, null);
      AppMethodBeat.o(117301);
      return paramString;
    }
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.omV.rawQuery(paramString, null);
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
      paramString = "SELECT * FROM (SELECT * FROM " + aLY(paramString) + " WHERE" + bvo(paramString) + byw(paramString) + " AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime DESC LIMIT " + paramInt + " ) ORDER BY createTime ASC";
      Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.omV.rawQuery(paramString, null);
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
    paramString1 = this.omV.rawQuery(paramString1, paramArrayOfString, 2);
    if (paramString1.moveToFirst())
    {
      do
      {
        int i = paramString1.getInt(0);
        l = paramString1.getLong(1) / 1000L;
        paramString2.add(Integer.valueOf(i));
        ((List)localObject).add(Long.valueOf(l));
      } while (paramString1.moveToNext());
      this.adlf.U(paramString2, (List)localObject);
    }
    paramString1.close();
    AppMethodBeat.o(117250);
  }
  
  public final List<cc> e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(117242);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(117242);
      return null;
    }
    paramLong = bc(paramString, paramLong);
    if (paramLong == 0L)
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(117242);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (paramString = "select * from " + aLY(paramString) + " where" + bvo(paramString) + byw(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime > " + paramLong + " order by createTime ASC limit 10";; paramString = "select * from " + aLY(paramString) + " where" + bvo(paramString) + byw(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + paramLong + " order by createTime DESC limit 10")
    {
      paramString = this.omV.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        cc localcc = new cc();
        localcc.convertFrom(paramString);
        localArrayList.add(localcc);
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
  
  public final List<cc> fQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(117228);
    ArrayList localArrayList = new ArrayList();
    if (this.adkY != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND status = 3 AND type <> 10000" + " ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.omV.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        cc localcc = new cc();
        localcc.convertFrom(paramString);
        localArrayList.add(localcc);
      }
    }
    paramString.close();
    AppMethodBeat.o(117228);
    return localArrayList;
  }
  
  public final List<cc> fR(String paramString, int paramInt)
  {
    AppMethodBeat.i(117232);
    ArrayList localArrayList = new ArrayList();
    if (this.adkY != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.omV.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        cc localcc = new cc();
        localcc.convertFrom(paramString);
        if ((localcc.iYl()) || (localcc.jbR()) || (localcc.jbS())) {
          localArrayList.add(localcc);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(117232);
    return localArrayList;
  }
  
  public final List<cc> fS(String paramString, int paramInt)
  {
    AppMethodBeat.i(248702);
    ArrayList localArrayList = new ArrayList();
    if (this.adkY != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + " ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.omV.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        cc localcc = new cc();
        localcc.convertFrom(paramString);
        localArrayList.add(localcc);
      }
    }
    paramString.close();
    AppMethodBeat.o(248702);
    return localArrayList;
  }
  
  public final Cursor fT(String paramString, int paramInt)
  {
    AppMethodBeat.i(117248);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117248);
      return null;
    }
    String str = aLY(paramString);
    paramString = "select * from " + str + " where" + bvo(paramString) + byw(paramString) + " AND " + jcz() + "  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.omV.rawQuery(paramString, null);
    AppMethodBeat.o(117248);
    return paramString;
  }
  
  public final Cursor fU(String paramString, int paramInt)
  {
    AppMethodBeat.i(117249);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117249);
      return null;
    }
    Object localObject = aLY(paramString);
    paramString = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend,imgPath from ").append((String)localObject).append(" where").append(bvo(paramString)).append(byw(paramString)).append(" AND ");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" (type = 49");
    ((StringBuilder)localObject).append(" or type = 587202609");
    ((StringBuilder)localObject).append(" or type = 553648177) ");
    paramString = ((StringBuilder)localObject).toString() + " order by createTime DESC limit 100 OFFSET " + paramInt;
    paramString = this.omV.rawQuery(paramString, null);
    AppMethodBeat.o(117249);
    return paramString;
  }
  
  public final Cursor fV(String paramString, int paramInt)
  {
    AppMethodBeat.i(117245);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117245);
      return null;
    }
    String str = aLY(paramString);
    paramString = "select * from ( select * from " + str + " where" + byw(paramString) + " AND type IN (3,39,13,43,62,44,49,1090519089,268435505)  order by createTime DESC limit 200 OFFSET " + paramInt + ") order by createTime ASC ";
    paramString = this.omV.rawQuery(paramString, null, 2);
    AppMethodBeat.o(117245);
    return paramString;
  }
  
  public final int fW(String paramString, int paramInt)
  {
    AppMethodBeat.i(117256);
    Log.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", new Object[] { paramString, Integer.valueOf(paramInt), MMStack.getStack(true) });
    cc localcc = aU(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localcc.field_talker));
    d(aLY(paramString), "createTime<=? AND" + byw(paramString), new String[] { localcc.getCreateTime() });
    paramInt = this.omV.delete(aLY(paramString), "createTime<=? AND" + byw(paramString), new String[] { localcc.getCreateTime() });
    if (paramInt != 0)
    {
      doNotify();
      a(new i.c(paramString, "delete", null, paramInt, (byte)0));
    }
    AppMethodBeat.o(117256);
    return paramInt;
  }
  
  public final Cursor fX(String paramString, int paramInt)
  {
    AppMethodBeat.i(117257);
    cc localcc = aU(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localcc.field_talker));
    paramString = this.omV.query(aLY(paramString), null, "createTime<=? AND" + byw(paramString), new String[] { localcc.getCreateTime() }, null, null, null);
    AppMethodBeat.o(117257);
    return paramString;
  }
  
  public final Cursor fY(String paramString, int paramInt)
  {
    AppMethodBeat.i(117268);
    paramString = this.omV.query(aLY(paramString), null, "isSend=? AND" + byw(paramString) + "AND status!=?  order by msgId DESC limit " + paramInt, new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117268);
    return paramString;
  }
  
  public final int fZ(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117278);
    paramString = "SELECT COUNT(*) FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND type = " + paramInt;
    paramString = this.omV.rawQuery(paramString, null, 2);
    paramInt = i;
    if (paramString.moveToFirst()) {
      paramInt = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117278);
    return paramInt;
  }
  
  public final Cursor ga(String paramString, int paramInt)
  {
    AppMethodBeat.i(117305);
    String str = " SELECT * FROM " + aLY(paramString) + " WHERE" + bvo(paramString) + byw(paramString) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + paramInt;
    Log.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    paramString = this.omV.rawQuery(str, null);
    AppMethodBeat.o(117305);
    return paramString;
  }
  
  public final cc[] gb(String paramString, int paramInt)
  {
    AppMethodBeat.i(117311);
    if ((paramString == null) || (paramString.length() == 0) || (paramInt <= 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + paramString + ", limit = " + paramInt);
      AppMethodBeat.o(117311);
      return null;
    }
    Object localObject = "select * from " + aLY(paramString) + " where" + byw(paramString) + "order by createTime DESC limit " + paramInt;
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        cc localcc = new cc();
        localcc.convertFrom((Cursor)localObject);
        localArrayList.add(localcc);
      } while (((Cursor)localObject).moveToNext());
      ((Cursor)localObject).close();
      Log.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + paramString + ", limit = " + paramInt + ", count = " + localArrayList.size());
      Collections.reverse(localArrayList);
      paramString = (cc[])localArrayList.toArray(new cc[localArrayList.size()]);
      AppMethodBeat.o(117311);
      return paramString;
    }
    Log.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
    ((Cursor)localObject).close();
    AppMethodBeat.o(117311);
    return null;
  }
  
  public final void gbi()
  {
    AppMethodBeat.i(117201);
    z.bBH();
    AppMethodBeat.o(117201);
  }
  
  public final void gbj()
  {
    AppMethodBeat.i(117204);
    int i = 0;
    while (i < this.adkY.size())
    {
      b((i.b)this.adkY.get(i));
      i += 1;
    }
    AppMethodBeat.o(117204);
  }
  
  public final void gbk()
  {
    AppMethodBeat.i(117206);
    if (!this.adkW)
    {
      AppMethodBeat.o(117206);
      return;
    }
    Object localObject = "select count(*) from " + "message" + " where talkerId ISNULL ";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
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
        boolean bool = this.omV.execSQL("message", (String)localObject);
        Log.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
        if ((bool) && (this.adkW))
        {
          this.omV.execSQL("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
          this.omV.execSQL("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
          this.omV.execSQL("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
          this.omV.execSQL("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
          this.omV.execSQL("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
          Log.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
        }
      }
      AppMethodBeat.o(117206);
      return;
    }
  }
  
  public final ArrayList<cc> gbl()
  {
    AppMethodBeat.i(117218);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.omV.query("message", null, "createTime>=? AND status=? AND isSend=?", new String[] { String.valueOf(System.currentTimeMillis() - 172800000L), "5", "1" }, null, null, "createTime ASC", 2);
    label149:
    while (localCursor.moveToNext())
    {
      cc localcc = new cc();
      localcc.convertFrom(localCursor);
      if (!localcc.isOmittedFailResend()) {}
      for (int i = 1;; i = 0)
      {
        if (((i & 0x1) == 0) || (au.bwL(localcc.field_talker)) || (au.bwN(localcc.field_talker)) || (au.bwS(localcc.field_talker))) {
          break label149;
        }
        localArrayList.add(localcc);
        break;
      }
    }
    localCursor.close();
    AppMethodBeat.o(117218);
    return localArrayList;
  }
  
  public final List<cc> gbm()
  {
    AppMethodBeat.i(117231);
    List localList = aaE(2147483647);
    AppMethodBeat.o(117231);
    return localList;
  }
  
  public final Cursor gbn()
  {
    AppMethodBeat.i(117269);
    Cursor localCursor = this.omV.query("message", new String[] { "talker", "count(*) as unReadCount" }, "isSend=? AND status!=?", new String[] { "0", "4" }, "talker", null, null);
    AppMethodBeat.o(117269);
    return localCursor;
  }
  
  public final String gbo()
  {
    return "type IN (3,39,13,43,62,44,268435505,486539313)";
  }
  
  public final String gbp()
  {
    return "type IN (3,39,13,43,62,44,49,268435505)";
  }
  
  public final int gbq()
  {
    AppMethodBeat.i(117295);
    Log.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf("SELECT COUNT(msgId) FROM message")));
    Cursor localCursor = this.omV.rawQuery("SELECT COUNT(msgId) FROM message", null, 2);
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
  public final List<cc> gbr()
  {
    // Byte code:
    //   0: ldc_w 1965
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 234	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 235	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 153	com/tencent/mm/storage/cd:omV	Lcom/tencent/mm/storagebase/h;
    //   18: ldc 71
    //   20: aconst_null
    //   21: ldc_w 1967
    //   24: iconst_1
    //   25: anewarray 61	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: invokestatic 583	java/lang/System:currentTimeMillis	()J
    //   33: ldc2_w 278
    //   36: lsub
    //   37: invokestatic 766	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: ldc_w 1001
    //   46: iconst_2
    //   47: invokevirtual 255	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 261 1 0
    //   59: ifeq +75 -> 134
    //   62: aload_2
    //   63: astore_1
    //   64: new 263	com/tencent/mm/storage/cc
    //   67: dup
    //   68: invokespecial 264	com/tencent/mm/storage/cc:<init>	()V
    //   71: astore 4
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: aload_2
    //   78: invokevirtual 268	com/tencent/mm/storage/cc:convertFrom	(Landroid/database/Cursor;)V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload 4
    //   86: invokevirtual 812	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -39 -> 51
    //   93: astore_3
    //   94: aload_2
    //   95: astore_1
    //   96: ldc 165
    //   98: aload_3
    //   99: ldc_w 1259
    //   102: iconst_1
    //   103: anewarray 169	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_3
    //   109: invokevirtual 430	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 795	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_2
    //   117: ifnull +9 -> 126
    //   120: aload_2
    //   121: invokeinterface 286 1 0
    //   126: ldc_w 1965
    //   129: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aconst_null
    //   133: areturn
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 286 1 0
    //   144: ldc_w 1965
    //   147: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_3
    //   151: areturn
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +9 -> 165
    //   159: aload_1
    //   160: invokeinterface 286 1 0
    //   165: ldc_w 1965
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
    //   0	183	0	this	cd
    //   52	108	1	localCursor1	Cursor
    //   50	89	2	localCursor2	Cursor
    //   152	20	2	localObject1	Object
    //   173	1	2	localObject2	Object
    //   179	1	2	localObject3	Object
    //   13	71	3	localArrayList	ArrayList
    //   93	58	3	localException1	Exception
    //   177	1	3	localException2	Exception
    //   71	14	4	localcc	cc
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
  
  public final Cursor gc(String paramString, int paramInt)
  {
    AppMethodBeat.i(117319);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117319);
      return null;
    }
    String str = aLY(paramString);
    paramString = "select * from " + str + " where" + bvo(paramString) + byw(paramString) + " AND type IN (436207665,419430449)  order by createTime" + " DESC limit " + paramInt + " OFFSET 0";
    paramString = this.omV.rawQuery(paramString, null);
    AppMethodBeat.o(117319);
    return paramString;
  }
  
  public final com.tencent.mm.storagebase.h getDB()
  {
    return this.omV;
  }
  
  public final List<cc> i(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(248608);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + aLY(paramString) + " Where " + byw(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit " + paramInt;
    paramString = this.omV.rawQuery(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      cc localcc = new cc();
      localcc.convertFrom(paramString);
      localArrayList.add(localcc);
    }
    paramString.close();
    AppMethodBeat.o(248608);
    return localArrayList;
  }
  
  public final List<cc> iV(List<String> paramList)
  {
    AppMethodBeat.i(248694);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.adkY.size())
    {
      if (paramList.contains(((i.b)this.adkY.get(i)).name)) {
        localLinkedList.add((i.b)this.adkY.get(i));
      }
      i += 1;
    }
    paramList = U(2147483647, localLinkedList);
    AppMethodBeat.o(248694);
    return paramList;
  }
  
  public final List<cc> j(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(248612);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + aLY(paramString) + " Where " + byw(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit " + paramInt + ";";
    paramString = this.omV.rawQuery(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      cc localcc = new cc();
      localcc.convertFrom(paramString);
      localArrayList.add(localcc);
    }
    paramString.close();
    AppMethodBeat.o(248612);
    return localArrayList;
  }
  
  public final int k(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117221);
    String str = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime ASC LIMIT -1 OFFSET " + paramInt;
    Cursor localCursor = this.omV.rawQuery(str, null);
    paramInt = localCursor.getCount();
    localCursor.close();
    Log.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + paramString + " time:" + paramLong + " count " + paramInt + " [" + str + "]");
    AppMethodBeat.o(117221);
    return paramInt;
  }
  
  public final List<cc> ka(String paramString, int paramInt)
  {
    AppMethodBeat.i(369603);
    ArrayList localArrayList = new ArrayList();
    if (this.adkY != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND isSend = 1 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.omV.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        cc localcc = new cc();
        localcc.convertFrom(paramString);
        if ((localcc.iYl()) || (localcc.jbR()) || (localcc.jbS())) {
          localArrayList.add(localcc);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(369603);
    return localArrayList;
  }
  
  public final cc kf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117225);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", new Object[] { paramString1 });
      AppMethodBeat.o(117225);
      return null;
    }
    cc localcc = new cc();
    paramString2 = "select * from " + aLY(paramString1) + " where" + byw(paramString1) + paramString2 + " order by createTime DESC limit 1";
    paramString2 = this.omV.rawQuery(paramString2, null, 2);
    if (paramString2.moveToFirst()) {
      localcc.convertFrom(paramString2);
    }
    paramString2.close();
    Log.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", new Object[] { paramString1, Long.valueOf(localcc.field_msgId) });
    AppMethodBeat.o(117225);
    return localcc;
  }
  
  public final Cursor kg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117265);
    paramString1 = "SELECT * FROM " + aLY(paramString1) + " WHERE" + byw(paramString1) + "AND content LIKE '%" + paramString2 + "%' AND type = 1";
    paramString1 = paramString1 + " ORDER BY createTime DESC";
    paramString1 = this.omV.rawQuery(paramString1, null);
    AppMethodBeat.o(117265);
    return paramString1;
  }
  
  public final int kh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117306);
    String str = " SELECT COUNT(*) FROM " + aLY(paramString1) + " WHERE" + bvo(paramString1) + byw(paramString1) + "AND content LIKE '" + paramString2 + "%' ";
    Cursor localCursor = this.omV.rawQuery(str, null, 2);
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
  
  public final LinkedList<cc> ki(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117312);
    paramString1 = this.omV.query(aLY(paramString1), null, "talker=? AND bizClientMsgId=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
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
        cc localcc = new cc();
        localcc.convertFrom(paramString1);
        paramString2.add(localcc);
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
  
  public final long l(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117308);
    Log.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      Log.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117308);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + aLY(paramString) + " WHERE" + bvo(paramString) + byw(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime DESC  LIMIT " + paramInt;
    Log.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.omV.rawQuery(paramString, null);
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
  
  public final void lock()
  {
    AppMethodBeat.i(117193);
    Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
    AppMethodBeat.o(117193);
  }
  
  public final long m(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117310);
    Log.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      Log.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117310);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + aLY(paramString) + " WHERE" + byw(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC  LIMIT " + paramInt;
    Log.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.omV.rawQuery(paramString, null);
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
  
  public final Cursor n(String paramString, long paramLong, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(117318);
    try
    {
      paramString = "select * from " + paramString + " where msgId >= " + paramLong + "  order by msgId ASC  limit " + paramInt;
      paramString = this.omV.rawQuery(paramString, null);
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
  
  public final List<cc> n(String paramString, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(248713);
    Object localObject = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ((StringBuffer)localObject).append((Long)paramArrayList.next());
      ((StringBuffer)localObject).append(",");
    }
    paramArrayList = new ArrayList();
    paramString = "SELECT * FROM " + aLY(paramString) + " WHERE msgId IN (" + ((StringBuffer)localObject).substring(0, ((StringBuffer)localObject).length() - 1) + ") ORDER BY createTime DESC ";
    Log.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.omV.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      localObject = new cc();
      ((cc)localObject).convertFrom(paramString);
      if (((cc)localObject).fxR()) {
        paramArrayList.add(localObject);
      }
    }
    paramString.close();
    AppMethodBeat.o(248713);
    return paramArrayList;
  }
  
  public final cc sl(long paramLong)
  {
    AppMethodBeat.i(117207);
    cc localcc = new cc();
    Cursor localCursor = this.omV.query(ze(paramLong), null, "msgId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localcc.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117207);
    return localcc;
  }
  
  public final int sm(long paramLong)
  {
    AppMethodBeat.i(117239);
    cc localcc = sl(paramLong);
    Object localObject = localcc.field_talker;
    this.adlf.x((int)(Util.nowSecond() / 86400L), localcc.field_msgSvrId, localcc.getCreateTime() / 1000L);
    int i = this.omV.delete(ze(paramLong), "msgId=?", new String[] { String.valueOf(paramLong) });
    ((aw)com.tencent.mm.kernel.h.ax(aw.class)).is(paramLong);
    if (i != 0)
    {
      doNotify("delete_id ".concat(String.valueOf(paramLong)));
      localObject = new i.c((String)localObject, "delete", localcc, 1, (byte)0);
      ((i.c)localObject).KRp = paramLong;
      ((i.c)localObject).vEb = localcc.field_bizChatId;
      a((i.c)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(117239);
      return i;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 245L, 1L, false);
    }
  }
  
  public final boolean sn(long paramLong)
  {
    AppMethodBeat.i(117251);
    boolean bool = this.adlf.qe(paramLong);
    AppMethodBeat.o(117251);
    return bool;
  }
  
  public final boolean so(long paramLong)
  {
    AppMethodBeat.i(117287);
    int i = 0;
    while (i < this.adkY.size())
    {
      if (((i.b)this.adkY.get(i)).sq(paramLong))
      {
        AppMethodBeat.o(117287);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(117287);
    return false;
  }
  
  public final void sp(long paramLong)
  {
    AppMethodBeat.i(117313);
    this.adlf.b(0, paramLong, 0L, false);
    AppMethodBeat.o(117313);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(117194);
    Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    AppMethodBeat.o(117194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cd
 * JD-Core Version:    0.7.0.1
 */