package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
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

public final class bw
  extends k
  implements i
{
  public static final String[] SQL_CREATE;
  private final com.tencent.mm.sdk.e.l<i.a, i.c> IIK;
  private final long Jfk;
  private String JhA;
  private long JhB;
  private boolean Jho;
  private final List<e> Jhp;
  private List<i.b> Jhq;
  private final com.tencent.mm.b.f<Integer, bv.c> Jhr;
  private final com.tencent.mm.b.f<Integer, bv.d> Jhs;
  private final com.tencent.mm.b.f<Integer, bv.a> Jht;
  private final com.tencent.mm.b.f<Integer, bv.b> Jhu;
  private final com.tencent.mm.b.f<Integer, Object> Jhv;
  private final com.tencent.mm.b.f<String, Long> Jhw;
  private ax Jhx;
  private final Map<String, i.c> Jhy;
  private boolean Jhz;
  private final h hKK;
  private br nFB;
  private bq nFz;
  
  static
  {
    AppMethodBeat.i(117320);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag INT, solitaireFoldInfo BLOB, historyId TEXT) " };
    AppMethodBeat.o(117320);
  }
  
  public bw(h paramh, bq parambq, br parambr)
  {
    AppMethodBeat.i(117202);
    this.Jho = false;
    this.Jhp = new CopyOnWriteArrayList();
    this.Jhr = new com.tencent.mm.memory.a.c(100);
    this.Jhs = new com.tencent.mm.memory.a.c(100);
    this.Jht = new com.tencent.mm.memory.a.c(100);
    this.Jhu = new com.tencent.mm.memory.a.c(100);
    this.Jhv = new com.tencent.mm.memory.a.c(100);
    this.Jhw = new com.tencent.mm.memory.a.c(100);
    this.Jhx = new ax();
    this.IIK = new com.tencent.mm.sdk.e.l()
    {
      public final void hu(List<i.c> paramAnonymousList)
      {
        AppMethodBeat.i(117187);
        if ((!isLocked()) && (bw.a(bw.this) != null))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            i.c localc = (i.c)paramAnonymousList.next();
            if (localc != null) {
              bw.a(bw.this).b(bw.this, localc);
            }
          }
        }
        AppMethodBeat.o(117187);
      }
    };
    this.Jhy = new HashMap();
    this.Jhz = false;
    this.JhA = "";
    this.JhB = 0L;
    this.Jfk = 86400L;
    this.hKK = paramh;
    this.nFz = parambq;
    this.nFB = parambr;
    if (v.aBs() == 0)
    {
      ae.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", new Object[] { Integer.valueOf(this.hKK.delete("message", "msgId> ? ", new String[] { "80000000" })) });
      v.aBr();
    }
    d(paramh, "message");
    fwy();
    if (this.Jhq == null) {
      this.Jhq = new LinkedList();
    }
    this.Jhq.clear();
    a(new i.b(1, "message", i.b.a(1L, 1000000L, 10000000L, 90000000L)));
    AppMethodBeat.o(117202);
  }
  
  private String Eg(long paramLong)
  {
    AppMethodBeat.i(117288);
    if ((paramLong == 0L) || (paramLong == -1L))
    {
      AppMethodBeat.o(117288);
      return null;
    }
    bv.Ef(paramLong);
    int i = 0;
    while (i < this.Jhq.size())
    {
      if (((i.b)this.Jhq.get(i)).yx(paramLong))
      {
        String str = ((i.b)this.Jhq.get(i)).name;
        AppMethodBeat.o(117288);
        return str;
      }
      i += 1;
    }
    Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[] { Long.valueOf(paramLong) }), false);
    AppMethodBeat.o(117288);
    return null;
  }
  
  private static void aN(bv parambv)
  {
    AppMethodBeat.i(117236);
    if ((parambv == null) || (!parambv.cVH()))
    {
      AppMethodBeat.o(117236);
      return;
    }
    try
    {
      String str = parambv.field_content;
      int i = str.indexOf("<msg>");
      Object localObject = str;
      if (i > 0)
      {
        localObject = str;
        if (i < str.length()) {
          localObject = str.substring(i).trim();
        }
      }
      localObject = bx.M((String)localObject, "msg");
      if ((localObject != null) && (((Map)localObject).size() > 0)) {
        parambv.uk(bk.bO((Map)localObject));
      }
      AppMethodBeat.o(117236);
      return;
    }
    catch (Exception parambv)
    {
      ae.e("MicroMsg.MsgInfoStorage", parambv.getMessage());
      AppMethodBeat.o(117236);
    }
  }
  
  private static String aTQ(String paramString)
  {
    AppMethodBeat.i(177115);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aAi().aqP(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(177115);
      return paramString;
    }
    AppMethodBeat.o(177115);
    return "";
  }
  
  private String aVG(String paramString)
  {
    AppMethodBeat.i(117216);
    String str = art(paramString);
    if ((this.Jho) && (str.equals("message")))
    {
      paramString = " talkerId=" + aVH(paramString) + " ";
      AppMethodBeat.o(117216);
      return paramString;
    }
    paramString = " talker= '" + bu.aSk(paramString) + "' ";
    AppMethodBeat.o(117216);
    return paramString;
  }
  
  private long aVH(String paramString)
  {
    AppMethodBeat.i(117217);
    long l2 = this.nFz.aUN(paramString);
    if (l2 < 0L) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = l2;
      if (bool)
      {
        l1 = l2;
        if (!x.Ai(paramString))
        {
          l1 = l2;
          if (!x.Aj(paramString))
          {
            an localan = new an(paramString);
            localan.setType(2);
            this.nFz.an(localan);
            l1 = this.nFz.aUN(paramString);
          }
        }
      }
      if (!b.fnH()) {
        ae.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", new Object[] { paramString, Long.valueOf(l1), Boolean.valueOf(bool), "" });
      }
      AppMethodBeat.o(117217);
      return l1;
    }
  }
  
  private static String aVI(String paramString)
  {
    AppMethodBeat.i(117235);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117235);
      return null;
    }
    try
    {
      paramString = bx.M(paramString, "msgsource");
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
      ae.e("MicroMsg.MsgInfoStorage", "exception:%s", new Object[] { bu.o(paramString) });
      ae.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(117235);
    }
    return null;
  }
  
  private String aVJ(String paramString)
  {
    AppMethodBeat.i(117277);
    if ((paramString == null) || (!paramString.equals("message")))
    {
      AppMethodBeat.o(117277);
      return "";
    }
    if (this.Jho)
    {
      AppMethodBeat.o(117277);
      return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
    }
    AppMethodBeat.o(117277);
    return "INDEXED BY messageCreateTaklerTypeTimeIndex";
  }
  
  private i.b aVK(String paramString)
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
      if (i >= this.Jhq.size()) {
        break label98;
      }
      if (paramString.equals(((i.b)this.Jhq.get(i)).name))
      {
        paramString = (i.b)this.Jhq.get(i);
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
  
  private String aVL(String paramString)
  {
    AppMethodBeat.i(117285);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Iterator localIterator = this.Jhp.iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = ((e)localIterator.next()).ajr(paramString);
      } while (bu.isNullOrNil(str));
      AppMethodBeat.o(117285);
      return str;
    }
    AppMethodBeat.o(117285);
    return "message";
  }
  
  private i.b aVM(String paramString)
  {
    AppMethodBeat.i(117286);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = aVK(aVL(paramString));
      AppMethodBeat.o(117286);
      return paramString;
    }
  }
  
  private void b(i.b paramb)
  {
    AppMethodBeat.i(117205);
    Cursor localCursor = this.hKK.a("select max(msgid) from " + paramb.name, null, 2);
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      ae.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d tableName: %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramb.icx), paramb.name });
      if (i >= paramb.icx) {
        paramb.Ko(i);
      }
    }
    localCursor.close();
    ae.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + paramb.icx);
    AppMethodBeat.o(117205);
  }
  
  private void fwy()
  {
    AppMethodBeat.i(117200);
    long l1 = System.currentTimeMillis();
    long l2 = this.hKK.yi(Thread.currentThread().getId());
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
    if (!this.Jho)
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
      this.hKK.execSQL("message", (String)localArrayList.get(i));
      i += 1;
    }
    ae.i("MicroMsg.MsgInfoStorage", "build new index last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    this.hKK.sW(l2);
    ae.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(117200);
  }
  
  private List<bv> r(int paramInt, List<i.b> paramList)
  {
    AppMethodBeat.i(211790);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Cursor localCursor = this.hKK.a(((i.b)paramList.get(i)).name, null, "status=1 and isSend=1 and type IN (1,11,21,31,36,42,66,48,55,57)", null, null, null, "createTime", 100);
      while (localCursor.moveToNext())
      {
        bv localbv = new bv();
        localbv.convertFrom(localCursor);
        if (bl.aCr() - localbv.field_createTime > 86400000L) {
          ((List)localObject).add(localbv);
        } else {
          localArrayList.add(localbv);
        }
      }
      localCursor.close();
      i += 1;
    }
    if (localArrayList.size() > paramInt) {}
    for (paramList = localArrayList.subList(0, paramInt);; paramList = localArrayList)
    {
      ae.i("MicroMsg.MsgInfoStorage", "getLastSendingMsgList limit:%s listMsg:%s lstTimeoutMsg:%s limitListMsg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localArrayList.size()), Integer.valueOf(((List)localObject).size()), Integer.valueOf(paramList.size()) });
      if (((List)localObject).size() > 0)
      {
        long l = this.hKK.yi(-1L);
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext())
        {
          localObject = (bv)paramList.next();
          ae.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d time:%s talker:%s content:%s", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_createTime), Integer.valueOf(((bv)localObject).getType()), ((ei)localObject).field_talker, bu.aSM(((ei)localObject).field_content) });
          ((bv)localObject).setStatus(5);
          a(((ei)localObject).field_msgId, (bv)localObject);
        }
        this.hKK.sW(l);
      }
      AppMethodBeat.o(211790);
      return localArrayList;
    }
  }
  
  public final Cursor A(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117244);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117244);
      return null;
    }
    String str = art(paramString);
    paramString = "select * from " + str + " where" + aVG(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.hKK.a(paramString, null, 2);
    AppMethodBeat.o(117244);
    return paramString;
  }
  
  public final Cursor B(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117246);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117246);
      return null;
    }
    String str = art(paramString);
    paramString = "select * from " + str + " where" + aVG(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505) AND createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.hKK.a(paramString, null, 2);
    AppMethodBeat.o(117246);
    return paramString;
  }
  
  public final int BO(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117276);
    paramString = "SELECT COUNT(*) FROM " + art(paramString) + " WHERE" + aTQ(paramString) + aVG(paramString);
    paramString = this.hKK.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117276);
    return i;
  }
  
  public final boolean BP(String paramString)
  {
    AppMethodBeat.i(117275);
    boolean bool = "message".equals(art(paramString));
    AppMethodBeat.o(117275);
    return bool;
  }
  
  public final int C(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(117279);
    paramString = "SELECT COUNT(*) FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND type = 50 AND createTime >= " + paramLong1 + " AND createTime <= " + paramLong2 + " LIMIT 1";
    paramString = this.hKK.a(paramString, null, 2);
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
      ae.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      paramString = "SELECT COUNT(msgId) FROM " + art(paramString) + " WHERE" + aTQ(paramString) + aVG(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      ae.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf(paramString)));
      paramString = this.hKK.a(paramString, null, 2);
      if (paramString == null)
      {
        ae.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
        AppMethodBeat.o(117294);
        return 0;
      }
      if (paramString.moveToFirst())
      {
        int i = paramString.getInt(0);
        ae.d("MicroMsg.MsgInfoStorage", "result msg count %d", new Object[] { Integer.valueOf(i) });
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
      paramString = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime ASC ";
      ae.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hKK.a(paramString, null, 0);
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
      StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ( SELECT * FROM ").append(art(paramString)).append(" WHERE").append(aVG(paramString));
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
        ae.d("MicroMsg.MsgInfoStorage", "getCountAfterStratTimeBeforeEndTime talk:%s [%s]", new Object[] { paramString, str });
        paramString = this.hKK.a(str, null, 2);
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
            ae.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
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
      paramString = "SELECT COUNT(*) FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1;
      paramString = this.hKK.a(paramString, null, 2);
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
          ae.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
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
    paramString = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + " AND createTime <= " + paramLong + " order by createTime ASC limit " + paramInt;
    paramString = this.hKK.a(paramString, null, 0);
    AppMethodBeat.o(117264);
    return paramString;
  }
  
  public final Cursor H(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117303);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1;
      ae.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hKK.a(paramString, null, 0);
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
    StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(art(paramString)).append(" WHERE").append(aVG(paramString));
    if (paramLong > 0L) {}
    for (String str = " AND createTime > ".concat(String.valueOf(paramLong));; str = "")
    {
      str = str + " ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
      ae.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
      paramString = this.hKK.a(str, null, 0);
      AppMethodBeat.o(117266);
      return paramString;
    }
  }
  
  /* Error */
  public final List<bv> I(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 771
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 6
    //   9: new 532	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 533	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: getfield 145	com/tencent/mm/storage/bw:hKK	Lcom/tencent/mm/storagebase/h;
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 353	com/tencent/mm/storage/bw:art	(Ljava/lang/String;)Ljava/lang/String;
    //   27: aconst_null
    //   28: new 63	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 772	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 663	com/tencent/mm/storage/bw:aVG	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 774
    //   46: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: iconst_2
    //   53: anewarray 61	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: lload_2
    //   59: invokestatic 734	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: lload 4
    //   67: invokestatic 734	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   70: aastore
    //   71: aconst_null
    //   72: aconst_null
    //   73: ldc_w 776
    //   76: iconst_2
    //   77: invokevirtual 603	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   80: astore_1
    //   81: aload_1
    //   82: astore 6
    //   84: aload 6
    //   86: astore_1
    //   87: aload 6
    //   89: invokeinterface 606 1 0
    //   94: ifeq +86 -> 180
    //   97: aload 6
    //   99: astore_1
    //   100: new 227	com/tencent/mm/storage/bv
    //   103: dup
    //   104: invokespecial 607	com/tencent/mm/storage/bv:<init>	()V
    //   107: astore 8
    //   109: aload 6
    //   111: astore_1
    //   112: aload 8
    //   114: aload 6
    //   116: invokevirtual 611	com/tencent/mm/storage/bv:convertFrom	(Landroid/database/Cursor;)V
    //   119: aload 6
    //   121: astore_1
    //   122: aload 7
    //   124: aload 8
    //   126: invokevirtual 777	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: goto -46 -> 84
    //   133: astore 7
    //   135: aload 6
    //   137: astore_1
    //   138: ldc 157
    //   140: aload 7
    //   142: ldc_w 779
    //   145: iconst_1
    //   146: anewarray 161	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload 7
    //   153: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 742	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aload 6
    //   162: ifnull +10 -> 172
    //   165: aload 6
    //   167: invokeinterface 505 1 0
    //   172: ldc_w 771
    //   175: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: aload 6
    //   182: ifnull +10 -> 192
    //   185: aload 6
    //   187: invokeinterface 505 1 0
    //   192: ldc_w 771
    //   195: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 7
    //   200: areturn
    //   201: astore_1
    //   202: aload 6
    //   204: ifnull +10 -> 214
    //   207: aload 6
    //   209: invokeinterface 505 1 0
    //   214: ldc_w 771
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
    //   0	241	0	this	bw
    //   0	241	1	paramString	String
    //   0	241	2	paramLong1	long
    //   0	241	4	paramLong2	long
    //   7	230	6	str	String
    //   16	107	7	localArrayList	ArrayList
    //   133	66	7	localException1	Exception
    //   222	6	7	localObject	Object
    //   233	1	7	localException2	Exception
    //   107	18	8	localbv	bv
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
  
  public final bv Km(int paramInt)
  {
    AppMethodBeat.i(117229);
    if (this.Jhq == null)
    {
      ae.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117229);
      return null;
    }
    bv localbv = new bv();
    long l1 = 0L;
    int i = 0;
    while (i < this.Jhq.size())
    {
      long l2 = l1;
      if ((((i.b)this.Jhq.get(i)).vWf & paramInt) != 0)
      {
        Object localObject = "select * from " + ((i.b)this.Jhq.get(i)).name + "  order by createTime DESC limit 1";
        localObject = this.hKK.a((String)localObject, null, 2);
        l2 = l1;
        if (((Cursor)localObject).moveToFirst())
        {
          long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
          l2 = l1;
          if (l1 < l3)
          {
            localbv.convertFrom((Cursor)localObject);
            l2 = l3;
          }
        }
        ((Cursor)localObject).close();
      }
      i += 1;
      l1 = l2;
    }
    AppMethodBeat.o(117229);
    return localbv;
  }
  
  public final List<bv> Kn(int paramInt)
  {
    AppMethodBeat.i(211788);
    Object localObject = new LinkedList();
    int i = 0;
    while (i < this.Jhq.size())
    {
      String str = ((i.b)this.Jhq.get(i)).name;
      if ((!str.startsWith("findermessage")) && (!str.equalsIgnoreCase("gamelifemessage"))) {
        ((List)localObject).add(this.Jhq.get(i));
      }
      i += 1;
    }
    localObject = r(paramInt, (List)localObject);
    AppMethodBeat.o(211788);
    return localObject;
  }
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(117296);
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = new StringBuilder("SELECT * FROM ").append(art(paramString)).append(" WHERE").append(aVG(paramString)).append("AND createTime >= ").append(paramLong2).append(" AND createTime <= ").append(paramLong1).append(" AND isSend=");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString = i + " LIMIT 1";
        ae.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
        paramString = this.hKK.a(paramString, null, 0);
        AppMethodBeat.o(117296);
        return paramString;
      }
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final void a(long paramLong, bv parambv)
  {
    AppMethodBeat.i(117258);
    if (parambv.fvC())
    {
      String str = aVI(parambv.eNd);
      if (x.AT(str))
      {
        ae.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
        parambv.ui("notifymessage");
      }
    }
    aN(parambv);
    if (this.hKK.update(Eg(paramLong), parambv.convertTo(), "msgId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new i.c(parambv.field_talker, "update", parambv));
      AppMethodBeat.o(117258);
      return;
    }
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 244L, 1L, false);
    AppMethodBeat.o(117258);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(117192);
    this.IIK.remove(parama);
    AppMethodBeat.o(117192);
  }
  
  public final void a(i.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(117191);
    this.IIK.a(parama, paramLooper);
    AppMethodBeat.o(117191);
  }
  
  public final void a(i.b paramb)
  {
    AppMethodBeat.i(117203);
    synchronized (this.Jhq)
    {
      this.Jhq.add(paramb);
      b(paramb);
      AppMethodBeat.o(117203);
      return;
    }
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(117190);
    if (this.IIK.dW(paramc)) {
      this.IIK.doNotify();
    }
    AppMethodBeat.o(117190);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(117189);
    if (!this.Jhp.contains(parame))
    {
      ae.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", new Object[] { parame });
      this.Jhp.add(parame);
    }
    AppMethodBeat.o(117189);
  }
  
  public final void aCq()
  {
    AppMethodBeat.i(117227);
    Cursor localCursor = this.hKK.a("select * from MsgInfo wherecontent like '%aaaabbbbbfdf%'", null, 2);
    localCursor.getCount();
    SystemClock.sleep(5000L);
    localCursor.close();
    AppMethodBeat.o(117227);
  }
  
  public final void aI(String paramString, long paramLong)
  {
    AppMethodBeat.i(117199);
    i.b localb = aVM(paramString);
    long l = localb.icx;
    Random localRandom = new Random();
    this.hKK.execSQL("message", "BEGIN;");
    bv localbv = new bv(paramString);
    int i = 0;
    while (i < paramLong)
    {
      localbv.qN(System.currentTimeMillis());
      localbv.setType(1);
      localbv.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bu.fpM());
      localbv.setMsgId(l);
      localbv.setStatus(localRandom.nextInt(4));
      localbv.kt(localRandom.nextInt(1));
      l += 1L;
      localb.icx += 1L;
      localbv.qM(System.currentTimeMillis() + bu.fpM());
      this.hKK.execSQL("message", "INSERT INTO " + art(localbv.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + localbv.field_msgId + "," + localbv.field_msgSvrId + "," + localbv.getType() + "," + localbv.field_status + "," + localbv.field_createTime + ",'" + localbv.field_talker + "','" + localbv.field_content + "'," + aVH(paramString) + ");");
      if (i % 10000 == 0)
      {
        this.hKK.execSQL("message", "COMMIT;");
        this.hKK.execSQL("message", "BEGIN;");
      }
      i += 1;
    }
    this.hKK.execSQL("message", "COMMIT;");
    this.nFB.aVb(paramString);
    localbv.setMsgId(1L + l);
    c(localbv, false);
    AppMethodBeat.o(117199);
  }
  
  public final bv aJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(117208);
    bv localbv = new bv();
    paramString = this.hKK.a(art(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117208);
    return localbv;
  }
  
  public final bv aK(String paramString, long paramLong)
  {
    AppMethodBeat.i(117209);
    bv localbv = new bv();
    paramString = this.hKK.a(art(paramString), null, aVG(paramString) + " AND msgSeq=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117209);
    return localbv;
  }
  
  public final bv aL(String paramString, long paramLong)
  {
    AppMethodBeat.i(117210);
    bv localbv = new bv();
    paramString = this.hKK.a(art(paramString), null, "createTime=? AND" + aVG(paramString), new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117210);
    return localbv;
  }
  
  public final bv aM(String paramString, long paramLong)
  {
    AppMethodBeat.i(117214);
    bv localbv = new bv();
    paramString = "Select * From " + art(paramString) + " Where " + aVG(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
    paramString = this.hKK.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117214);
    return localbv;
  }
  
  public final bv aN(String paramString, long paramLong)
  {
    AppMethodBeat.i(117215);
    bv localbv = new bv();
    paramString = "Select * From " + art(paramString) + " Where " + aVG(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
    paramString = this.hKK.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    if (paramString.moveToFirst()) {
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117215);
    return localbv;
  }
  
  public final boolean aO(String paramString, long paramLong)
  {
    AppMethodBeat.i(117220);
    if (aL(paramString, paramLong).field_msgId > 0L)
    {
      AppMethodBeat.o(117220);
      return true;
    }
    AppMethodBeat.o(117220);
    return false;
  }
  
  public final bv aP(String paramString, long paramLong)
  {
    AppMethodBeat.i(117224);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117224);
      return null;
    }
    bv localbv = new bv();
    paramString = "select * from " + art(paramString) + " where" + aVG(paramString) + "AND msgSeq<" + paramLong + " order by msgSeq DESC limit 1";
    Cursor localCursor = this.hKK.a(paramString, null, 2);
    if (localCursor.moveToFirst()) {
      localbv.convertFrom(localCursor);
    }
    localCursor.close();
    ae.d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(117224);
    return localbv;
  }
  
  public final Cursor aQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(177113);
    paramString = this.hKK.fxU().rawQueryWithFactory(null, "SELECT * FROM " + paramString + " WHERE createTime < " + paramLong, null, paramString);
    AppMethodBeat.o(177113);
    return paramString;
  }
  
  public final long aR(String paramString, long paramLong)
  {
    AppMethodBeat.i(117241);
    paramString = "select createTime from " + art(paramString) + " where msgId = " + paramLong;
    paramLong = 0L;
    paramString = this.hKK.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      paramLong = paramString.getLong(0);
    }
    paramString.close();
    AppMethodBeat.o(117241);
    return paramLong;
  }
  
  /* Error */
  public final int aS(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 1050
    //   6: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 135
    //   13: aconst_null
    //   14: invokevirtual 1053	com/tencent/mm/storage/bw:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 145	com/tencent/mm/storage/bw:hKK	Lcom/tencent/mm/storagebase/h;
    //   21: invokevirtual 1028	com/tencent/mm/storagebase/h:fxU	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   24: new 63	java/lang/StringBuilder
    //   27: dup
    //   28: ldc_w 1055
    //   31: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 1057
    //   41: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 1061	com/tencent/wcdb/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   50: astore 6
    //   52: aload 6
    //   54: iconst_1
    //   55: lload_2
    //   56: invokevirtual 1067	com/tencent/wcdb/database/SQLiteStatement:bindLong	(IJ)V
    //   59: aload 6
    //   61: invokevirtual 1070	com/tencent/wcdb/database/SQLiteStatement:executeUpdateDelete	()I
    //   64: istore 4
    //   66: iload 4
    //   68: ifle +17 -> 85
    //   71: aload_0
    //   72: ldc_w 1072
    //   75: aload_1
    //   76: invokestatic 709	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokevirtual 712	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 1074	com/tencent/mm/storage/bw:doNotify	(Ljava/lang/String;)V
    //   85: aload 6
    //   87: ifnull +8 -> 95
    //   90: aload 6
    //   92: invokevirtual 1075	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   95: ldc_w 1050
    //   98: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload 4
    //   103: ireturn
    //   104: astore 5
    //   106: ldc_w 1050
    //   109: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload 5
    //   114: athrow
    //   115: astore_1
    //   116: aload 6
    //   118: ifnull +13 -> 131
    //   121: aload 5
    //   123: ifnull +51 -> 174
    //   126: aload 6
    //   128: invokevirtual 1075	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   131: ldc_w 1050
    //   134: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: getstatic 868	com/tencent/mm/plugin/report/e:ywz	Lcom/tencent/mm/plugin/report/e;
    //   143: ldc2_w 869
    //   146: ldc2_w 1076
    //   149: lconst_1
    //   150: iconst_0
    //   151: invokevirtual 876	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   154: ldc_w 1050
    //   157: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: iconst_m1
    //   161: ireturn
    //   162: astore 6
    //   164: aload 5
    //   166: aload 6
    //   168: invokevirtual 1081	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   171: goto -40 -> 131
    //   174: aload 6
    //   176: invokevirtual 1075	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   179: goto -48 -> 131
    //   182: astore_1
    //   183: goto -67 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	bw
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
  
  public final int aT(String paramString, long paramLong)
  {
    AppMethodBeat.i(117253);
    bv localbv = aJ(paramString, paramLong);
    this.Jhx.n((int)(bu.aRi() / 86400L), localbv.field_msgSvrId, localbv.field_createTime / 1000L);
    int i = this.hKK.delete(art(paramString), "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      doNotify();
      a(new i.c(paramString, "delete", null, 1, (byte)0));
    }
    for (;;)
    {
      AppMethodBeat.o(117253);
      return i;
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 246L, 1L, false);
    }
  }
  
  public final int aU(String paramString, long paramLong)
  {
    AppMethodBeat.i(117255);
    String str = aVG(paramString) + " and createTime <= " + paramLong;
    c(art(paramString), str, null);
    int i = this.hKK.delete(art(paramString), str, null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.vWl = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117255);
    return i;
  }
  
  public final int aV(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(117281);
    bv localbv = ys(paramLong);
    if (localbv.field_msgId == 0L)
    {
      ae.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117281);
      return 0;
    }
    String str = art(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " " + aVJ(str) + " WHERE " + aTQ(paramString) + aVG(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + localbv.field_createTime;
    paramString = this.hKK.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117281);
    return i;
  }
  
  public final String aW(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(117282);
    Object localObject1 = ys(paramLong);
    if (((ei)localObject1).field_msgId == 0L)
    {
      ae.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(117282);
      return null;
    }
    Object localObject2 = art(paramString);
    paramString = "EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + (String)localObject2 + " " + aVJ((String)localObject2) + " WHERE" + aTQ(paramString) + aVG(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + ((ei)localObject1).field_createTime;
    localObject2 = this.hKK.a(paramString, null, 0);
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
  
  public final bv aX(String paramString, long paramLong)
  {
    AppMethodBeat.i(117292);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117292);
      return null;
    }
    Object localObject = "select * from message where" + aVG(paramString) + " and msgSeq < " + paramLong + " order by msgSeq DESC LIMIT 1 ";
    ae.i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: ".concat(String.valueOf(localObject)));
    localObject = this.hKK.a((String)localObject, null, 0);
    if (localObject == null)
    {
      ae.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117292);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new bv();
      paramString.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(117292);
      return paramString;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(117292);
    return null;
  }
  
  public final bv aY(String paramString, long paramLong)
  {
    AppMethodBeat.i(117309);
    ae.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(1) });
    bv localbv = new bv();
    paramString = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND createTime < " + paramLong + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1";
    ae.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hKK.a(paramString, null, 0);
    if (paramString == null)
    {
      ae.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(117309);
      return localbv;
    }
    if (paramString.moveToLast())
    {
      localbv.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(117309);
      return localbv;
    }
    paramString.close();
    ae.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117309);
    return localbv;
  }
  
  public final Cursor ab(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117304);
    String str = " SELECT * FROM " + art(paramString1) + " WHERE" + aTQ(paramString1) + aVG(paramString1) + "AND content LIKE '" + paramString2 + "%' ORDER BY createTime DESC LIMIT " + paramInt;
    ae.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), str });
    paramString1 = this.hKK.a(str, null, 0);
    AppMethodBeat.o(117304);
    return paramString1;
  }
  
  public final void ak(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(117219);
    long l1 = this.hKK.yi(-1L);
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        long l2 = ((Long)paramArrayList.next()).longValue();
        bv localbv = ys(l2);
        localbv.ka(localbv.eNc | 0x20);
        ae.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
        a(l2, localbv);
      }
      this.hKK.sW(l1);
    }
    finally
    {
      this.hKK.sW(l1);
      AppMethodBeat.o(117219);
    }
    AppMethodBeat.o(117219);
  }
  
  public final List<bv> ap(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117233);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + art(paramString) + " WHERE type & 65535 = 49" + " ORDER BY createTime DESC LIMIT " + paramInt1 + " , " + paramInt2;
    ae.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.hKK.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bv localbv = new bv();
      localbv.convertFrom(paramString);
      if (localbv.cVH()) {
        localArrayList.add(localbv);
      }
    }
    paramString.close();
    AppMethodBeat.o(117233);
    return localArrayList;
  }
  
  public final int aq(bv parambv)
  {
    int i = 0;
    AppMethodBeat.i(117234);
    if ((parambv == null) || (bu.isNullOrNil(parambv.field_talker)))
    {
      AppMethodBeat.o(117234);
      return 0;
    }
    parambv = "SELECT count(msgId) FROM " + art(parambv.field_talker) + " WHERE" + aVG(parambv.field_talker) + "AND isSend = 0 AND msgId >= " + parambv.field_msgId + " ORDER BY createTime DESC";
    parambv = this.hKK.a(parambv, null, 2);
    if (parambv.moveToFirst()) {
      i = parambv.getInt(0);
    }
    parambv.close();
    AppMethodBeat.o(117234);
    return i;
  }
  
  public final Cursor aq(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117243);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117243);
      return null;
    }
    String str = art(paramString);
    paramString = "select * from ( select * from " + str + " where" + aTQ(paramString) + aVG(paramString) + " AND type IN (3,39,13,43,62,44,268435505,486539313)  order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = this.hKK.a(paramString, null, 2);
    AppMethodBeat.o(117243);
    return paramString;
  }
  
  public final void aqX(String paramString)
  {
    AppMethodBeat.i(117195);
    ae.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.Jhz), Integer.valueOf(super.lockCount()), Integer.valueOf(this.IIK.IBP), Integer.valueOf(this.Jhy.size()), this.JhA, Long.valueOf(bu.DD(this.JhB)) });
    if (bu.isNullOrNil(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (this.Jhz)
    {
      ae.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", new Object[] { this.JhA, Long.valueOf(bu.DD(this.JhB)) });
      AppMethodBeat.o(117195);
      return;
    }
    this.JhA = paramString;
    this.JhB = bu.fpO();
    this.Jhz = true;
    super.lock();
    this.IIK.lock();
    AppMethodBeat.o(117195);
  }
  
  public final void aqY(String arg1)
  {
    AppMethodBeat.i(117196);
    ae.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { ???, Boolean.valueOf(this.Jhz), Integer.valueOf(super.lockCount()), Integer.valueOf(this.IIK.IBP), Integer.valueOf(this.Jhy.size()), this.JhA, Long.valueOf(bu.DD(this.JhB)) });
    if (bu.isNullOrNil(???)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (!this.Jhz)
    {
      ae.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", new Object[] { ???, bu.fpN() });
      AppMethodBeat.o(117196);
      return;
    }
    if (!???.equals(this.JhA))
    {
      ae.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", new Object[] { this.JhA, Long.valueOf(bu.DD(this.JhB)), ??? });
      AppMethodBeat.o(117196);
      return;
    }
    this.Jhz = false;
    this.JhB = 0L;
    this.JhA = "";
    synchronized (this.Jhy)
    {
      Iterator localIterator = this.Jhy.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a((i.c)this.Jhy.get(str));
      }
    }
    this.Jhy.clear();
    super.unlock();
    this.IIK.unlock();
    doNotify();
    AppMethodBeat.o(117196);
  }
  
  public final void aqZ(String paramString)
  {
    AppMethodBeat.i(117197);
    if (!this.Jhz)
    {
      AppMethodBeat.o(117197);
      return;
    }
    i.c localc = null;
    synchronized (this.Jhy)
    {
      if (this.Jhy.containsKey(paramString)) {
        localc = (i.c)this.Jhy.get(paramString);
      }
      if (localc == null)
      {
        ae.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", new Object[] { paramString, bu.fpN() });
        AppMethodBeat.o(117197);
        return;
      }
    }
    if ((localc.vWi != null) && (localc.vWi.equals("insert")) && (localc.slP > 0))
    {
      ae.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", new Object[] { paramString, Integer.valueOf(localc.slP) });
      localc.slP = 0;
    }
    AppMethodBeat.o(117197);
  }
  
  public final long ar(bv parambv)
  {
    AppMethodBeat.i(224453);
    long l = c(parambv, false);
    AppMethodBeat.o(224453);
    return l;
  }
  
  public final long arA(String paramString)
  {
    AppMethodBeat.i(117317);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    paramString = aVK(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117317);
      return 0L;
    }
    long l = paramString.icx;
    AppMethodBeat.o(117317);
    return l;
  }
  
  public final Cursor arB(String paramString)
  {
    AppMethodBeat.i(117315);
    try
    {
      paramString = this.hKK.a(art(paramString), null, aVG(paramString) + " AND createTime>=? AND type IN (436207665,419430449)", new String[] { String.valueOf(System.currentTimeMillis() - 86400000L) }, null, null, "createTime ASC", 2);
      AppMethodBeat.o(117315);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.MsgInfoStorage", paramString, "getLastDayC2CMsgByTalker error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(117315);
    }
    return null;
  }
  
  public final long arC(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(211793);
    paramString = "SELECT COUNT(*) FROM " + art(paramString) + " WHERE " + aVG(paramString) + " AND type NOT IN (10000,10002,570425393,64,603979825,855638065,889192497,922746929)";
    paramString = this.hKK.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    long l = i;
    AppMethodBeat.o(211793);
    return l;
  }
  
  public final Cursor ara(String paramString)
  {
    AppMethodBeat.i(117211);
    h localh = this.hKK;
    String str = art(paramString);
    paramString = aTQ(paramString) + aVG(paramString);
    paramString = localh.query(str, new String[] { "createTime", "msgId" }, paramString, null, "createTime", null, "createTime ASC");
    AppMethodBeat.o(117211);
    return paramString;
  }
  
  public final bv arb(String paramString)
  {
    AppMethodBeat.i(117222);
    bv localbv = new bv();
    paramString = this.hKK.a(art(paramString), null, aVG(paramString), null, null, null, "msgSvrId  DESC limit 1 ", 2);
    if (paramString.moveToFirst()) {
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117222);
    return localbv;
  }
  
  public final bv arc(String paramString)
  {
    AppMethodBeat.i(117223);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117223);
      return null;
    }
    bv localbv = new bv();
    paramString = "select * from " + art(paramString) + " where" + aTQ(paramString) + aVG(paramString) + "order by createTime DESC limit 1";
    paramString = this.hKK.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117223);
    return localbv;
  }
  
  public final bv ard(String paramString)
  {
    AppMethodBeat.i(211787);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(211787);
      return null;
    }
    bv localbv = new bv();
    paramString = "select * from " + art(paramString) + " where" + aTQ(paramString) + aVG(paramString) + "order by createTime ASC limit 1";
    paramString = this.hKK.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(211787);
    return localbv;
  }
  
  public final bv are(String paramString)
  {
    AppMethodBeat.i(117226);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117226);
      return null;
    }
    bv localbv = new bv();
    paramString = "select * from " + art(paramString) + " where" + aVG(paramString) + "and isSend = 0  order by createTime DESC limit 1";
    paramString = this.hKK.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117226);
    return localbv;
  }
  
  public final bv arf(String paramString)
  {
    AppMethodBeat.i(117230);
    if (this.Jhq == null)
    {
      ae.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      AppMethodBeat.o(117230);
      return null;
    }
    bv localbv = new bv();
    long l1 = 0L;
    if (bu.isNullOrNil(paramString)) {}
    for (paramString = "";; paramString = paramString.replaceFirst("and", "where"))
    {
      int i = 0;
      while (i < this.Jhq.size())
      {
        long l2 = l1;
        if ((((i.b)this.Jhq.get(i)).vWf & 0x8) != 0)
        {
          Object localObject = "select * from " + ((i.b)this.Jhq.get(i)).name + paramString + "  order by createTime DESC limit 1";
          localObject = this.hKK.a((String)localObject, null, 2);
          l2 = l1;
          if (((Cursor)localObject).moveToFirst())
          {
            long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
            l2 = l1;
            if (l1 < l3)
            {
              localbv.convertFrom((Cursor)localObject);
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
    return localbv;
  }
  
  public final List<bv> arg(String paramString)
  {
    bv localbv = null;
    AppMethodBeat.i(117240);
    Cursor localCursor = this.hKK.a("select * from ".concat(String.valueOf(paramString)), null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(117240);
      return null;
    }
    paramString = localbv;
    if (localCursor.moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        localbv = new bv();
        localbv.convertFrom(localCursor);
        paramString.add(localbv);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(117240);
    return paramString;
  }
  
  public final Cursor arh(String paramString)
  {
    AppMethodBeat.i(117247);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117247);
      return null;
    }
    Object localObject = art(paramString);
    paramString = "select * from " + (String)localObject + " " + aVJ((String)localObject) + " where" + aVG(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime";
    localObject = this.hKK.a(paramString, null, 0);
    ae.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(117247);
    return localObject;
  }
  
  public final void ari(String paramString)
  {
    AppMethodBeat.i(117252);
    c(paramString, "", null);
    if (this.hKK.execSQL(paramString, "delete from ".concat(String.valueOf(paramString))))
    {
      doNotify("delete_all ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117252);
      return;
    }
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 247L, 1L, false);
    AppMethodBeat.o(117252);
  }
  
  public final int arj(String paramString)
  {
    AppMethodBeat.i(117254);
    ae.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, au.foR() });
    c(art(paramString), aVG(paramString), null);
    int i = this.hKK.delete(art(paramString), aVG(paramString), null);
    if (i != 0)
    {
      doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.vWl = -1L;
      a(paramString);
    }
    AppMethodBeat.o(117254);
    return i;
  }
  
  public final int ark(String paramString)
  {
    AppMethodBeat.i(117261);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(4));
    int i = this.hKK.update(art(paramString), localContentValues, aVG(paramString) + "AND isSend=? AND status!=? ", new String[] { "0", "4" });
    if (i != 0)
    {
      doNotify();
      a(new i.c(paramString, "update", null));
    }
    AppMethodBeat.o(117261);
    return i;
  }
  
  public final Cursor arl(String paramString)
  {
    AppMethodBeat.i(117263);
    paramString = this.hKK.query(art(paramString), null, aVG(paramString), null, null, null, "createTime ASC ");
    AppMethodBeat.o(117263);
    return paramString;
  }
  
  public final Cursor arm(String paramString)
  {
    AppMethodBeat.i(117267);
    paramString = this.hKK.query(art(paramString), null, "isSend=? AND" + aVG(paramString) + "AND status!=?", new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117267);
    return paramString;
  }
  
  public final bv.c arn(String paramString)
  {
    AppMethodBeat.i(117270);
    bv.c localc2 = (bv.c)this.Jhr.get(Integer.valueOf(paramString.hashCode()));
    bv.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = bv.c.aVE(paramString);
      this.Jhr.q(Integer.valueOf(paramString.hashCode()), localc1);
    }
    AppMethodBeat.o(117270);
    return localc1;
  }
  
  public final bv.d aro(String paramString)
  {
    AppMethodBeat.i(117271);
    bv.d locald2 = (bv.d)this.Jhs.get(Integer.valueOf(paramString.hashCode()));
    bv.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = bv.d.aVF(paramString);
      this.Jhs.q(Integer.valueOf(paramString.hashCode()), locald1);
    }
    AppMethodBeat.o(117271);
    return locald1;
  }
  
  public final bv.a arp(String paramString)
  {
    AppMethodBeat.i(117272);
    bv.a locala1 = null;
    if ((!bu.isNullOrNil(paramString)) && (this.Jht != null)) {
      locala1 = (bv.a)this.Jht.get(Integer.valueOf(paramString.hashCode()));
    }
    for (;;)
    {
      bv.a locala2 = locala1;
      if (locala1 == null)
      {
        locala1 = bv.a.aVC(paramString);
        locala2 = locala1;
        if (this.Jht != null)
        {
          this.Jht.q(Integer.valueOf(bu.bI(paramString, "").hashCode()), locala1);
          locala2 = locala1;
        }
      }
      AppMethodBeat.o(117272);
      return locala2;
      ae.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", new Object[] { Boolean.valueOf(bu.isNullOrNil(paramString)) });
      ae.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
    }
  }
  
  public final bv.b arq(String paramString)
  {
    AppMethodBeat.i(117273);
    bv.b localb2 = (bv.b)this.Jhu.get(Integer.valueOf(paramString.hashCode()));
    bv.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = bv.b.aVD(paramString);
      this.Jhu.q(Integer.valueOf(paramString.hashCode()), localb1);
    }
    AppMethodBeat.o(117273);
    return localb1;
  }
  
  public final int arr(String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(117274);
    if (BP(paramString))
    {
      i = this.nFB.aVs(paramString);
      if (i > 0)
      {
        ae.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(117274);
        return i;
      }
      ae.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    }
    do
    {
      i = BO(paramString);
      AppMethodBeat.o(117274);
      return i;
      if (("appbrandmessage".equals(art(paramString))) || ("appbrandnotifymessage".equals(art(paramString))))
      {
        paramString = "SELECT COUNT(*) FROM " + art(paramString) + " WHERE" + aVG(paramString);
        paramString = this.hKK.a(paramString, null, 0);
        if (paramString.moveToLast()) {
          i = paramString.getInt(0);
        }
        paramString.close();
        AppMethodBeat.o(117274);
        return i;
      }
    } while (!"bottlemessage".equals(art(paramString)));
    paramString = "SELECT COUNT(*) FROM " + art(paramString) + " WHERE" + aVG(paramString);
    paramString = this.hKK.a(paramString, null, 2);
    i = j;
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117274);
    return i;
  }
  
  public final int ars(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(117280);
    if (paramString == null)
    {
      ae.w("MicroMsg.MsgInfoStorage", "getImgVideoMsgCount talker is null!");
      AppMethodBeat.o(117280);
      return 0;
    }
    paramString = "SELECT COUNT(*) FROM " + art(paramString) + " WHERE " + aTQ(paramString) + "talker= '" + bu.aSk(paramString) + "' AND type IN (3,39,13,43,62,44,268435505,486539313)";
    paramString = this.hKK.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117280);
    return i;
  }
  
  public final String art(String paramString)
  {
    AppMethodBeat.i(117283);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = aVM(paramString).name;
      AppMethodBeat.o(117283);
      return paramString;
    }
  }
  
  public final long aru(String paramString)
  {
    AppMethodBeat.i(117289);
    Object localObject = "select createTime from message where" + aVG(paramString) + "order by createTime LIMIT 1 OFFSET 0";
    ae.d("MicroMsg.MsgInfoStorage", "get first message create time: ".concat(String.valueOf(localObject)));
    localObject = this.hKK.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ae.e("MicroMsg.MsgInfoStorage", "get first message create time failed: ".concat(String.valueOf(paramString)));
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
  
  public final long arv(String paramString)
  {
    AppMethodBeat.i(117290);
    Object localObject = "select createTime from message where" + aTQ(paramString) + aVG(paramString) + "order by createTime DESC LIMIT 1 ";
    ae.d("MicroMsg.MsgInfoStorage", "get last message create time: ".concat(String.valueOf(localObject)));
    localObject = this.hKK.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ae.e("MicroMsg.MsgInfoStorage", "get last message create time failed ".concat(String.valueOf(paramString)));
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
  
  public final long arw(String paramString)
  {
    AppMethodBeat.i(117291);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117291);
      return 0L;
    }
    Object localObject = "select msgSeq from message where" + aVG(paramString) + "order by msgSeq DESC LIMIT 1 ";
    ae.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: ".concat(String.valueOf(localObject)));
    localObject = this.hKK.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ae.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed ".concat(String.valueOf(paramString)));
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
  
  public final bv arx(String paramString)
  {
    AppMethodBeat.i(117293);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117293);
      return null;
    }
    ae.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", new Object[] { paramString, Boolean.FALSE });
    Object localObject1 = (Long)this.Jhw.get(paramString);
    if ((localObject1 != null) && (((Long)localObject1).longValue() > 0L))
    {
      ae.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", new Object[] { Long.valueOf(((Long)localObject1).longValue()) });
      localObject1 = ys(((Long)localObject1).longValue());
      if ((((ei)localObject1).field_flag & 0x1) != 0)
      {
        AppMethodBeat.o(117293);
        return localObject1;
      }
      this.Jhw.remove(paramString);
      AppMethodBeat.o(117293);
      return null;
    }
    ae.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
    localObject1 = new bv();
    long l = System.currentTimeMillis();
    Object localObject2 = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ";
    localObject2 = this.hKK.a((String)localObject2, null, 2);
    ae.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(Thread.currentThread().getId()) });
    if (localObject2 == null)
    {
      ae.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117293);
      return localObject1;
    }
    if (((Cursor)localObject2).moveToFirst()) {
      ((bv)localObject1).convertFrom((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    this.Jhw.q(paramString, Long.valueOf(((ei)localObject1).field_msgId));
    AppMethodBeat.o(117293);
    return localObject1;
  }
  
  public final int ary(String paramString)
  {
    AppMethodBeat.i(117307);
    String str = " SELECT COUNT(*) FROM " + art(paramString) + " WHERE" + aTQ(paramString) + aVG(paramString) + "AND isSend=1";
    Cursor localCursor = this.hKK.a(str, null, 2);
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
        ae.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(117307);
      }
      ae.d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", new Object[] { paramString, Integer.valueOf(i), str });
      AppMethodBeat.o(117307);
      return i;
      label168:
      int i = 0;
    }
  }
  
  /* Error */
  public final List<bv> arz(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 1528
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 532	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 533	java/util/ArrayList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 145	com/tencent/mm/storage/bw:hKK	Lcom/tencent/mm/storagebase/h;
    //   20: ldc 71
    //   22: aconst_null
    //   23: ldc_w 1530
    //   26: iconst_2
    //   27: anewarray 61	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: invokestatic 371	com/tencent/mm/sdk/platformtools/bu:aSk	(Ljava/lang/String;)Ljava/lang/String;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: invokestatic 517	java/lang/System:currentTimeMillis	()J
    //   42: ldc2_w 620
    //   45: lsub
    //   46: invokestatic 734	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: ldc_w 1299
    //   55: iconst_2
    //   56: invokevirtual 603	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokeinterface 606 1 0
    //   70: ifeq +75 -> 145
    //   73: aload_2
    //   74: astore_1
    //   75: new 227	com/tencent/mm/storage/bv
    //   78: dup
    //   79: invokespecial 607	com/tencent/mm/storage/bv:<init>	()V
    //   82: astore 4
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: aload_2
    //   89: invokevirtual 611	com/tencent/mm/storage/bv:convertFrom	(Landroid/database/Cursor;)V
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: aload 4
    //   97: invokevirtual 777	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto -39 -> 62
    //   104: astore_3
    //   105: aload_2
    //   106: astore_1
    //   107: ldc 157
    //   109: aload_3
    //   110: ldc_w 1301
    //   113: iconst_1
    //   114: anewarray 161	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 742	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_2
    //   128: ifnull +9 -> 137
    //   131: aload_2
    //   132: invokeinterface 505 1 0
    //   137: ldc_w 1528
    //   140: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aconst_null
    //   144: areturn
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 505 1 0
    //   155: ldc_w 1528
    //   158: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_3
    //   162: areturn
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +9 -> 174
    //   168: aload_2
    //   169: invokeinterface 505 1 0
    //   174: ldc_w 1528
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
    //   0	196	0	this	bw
    //   0	196	1	paramString	String
    //   1	192	2	str	String
    //   15	80	3	localArrayList	ArrayList
    //   104	58	3	localException1	Exception
    //   182	4	3	localObject	Object
    //   190	1	3	localException2	Exception
    //   82	14	4	localbv	bv
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
  
  public final void as(bv parambv)
  {
    AppMethodBeat.i(117259);
    if ((parambv == null) || (parambv.field_status == 4))
    {
      AppMethodBeat.o(117259);
      return;
    }
    parambv.setStatus(4);
    String str = Eg(parambv.field_msgId);
    if ((str != null) && (str.length() > 0)) {
      if (this.hKK.update(str, parambv.convertTo(), "msgId=?", new String[] { parambv.field_msgId }) != 0)
      {
        doNotify();
        a(new i.c(parambv.field_talker, "update", parambv, -1));
      }
    }
    AppMethodBeat.o(117259);
  }
  
  public final int at(bv parambv)
  {
    int i = 0;
    AppMethodBeat.i(117262);
    if (parambv != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("content", parambv.field_content);
      localContentValues.put("status", Integer.valueOf(parambv.field_status));
      int j = this.hKK.update(Eg(parambv.field_msgId), localContentValues, "msgId=?", new String[] { String.valueOf(parambv.field_msgId) });
      i = j;
      if (j != 0)
      {
        doNotify();
        a(new i.c(parambv.field_talker, "update", parambv));
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
      StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ( SELECT * FROM ").append(art(paramString)).append(" WHERE").append(aVG(paramString));
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
        ae.d("MicroMsg.MsgInfoStorage", "getCursorAfterStratTimeBeforeEndTimeLimit talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
        paramString = this.hKK.a(str, null, 0);
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
  
  public final void b(long paramLong, bv parambv)
  {
    AppMethodBeat.i(117260);
    if (bu.nullAsNil(parambv.field_talker).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("no talker set when update by svrid", bool);
      if (parambv.fvC())
      {
        String str = aVI(parambv.eNd);
        if (x.AT(str))
        {
          ae.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
          parambv.ui("notifymessage");
        }
      }
      aN(parambv);
      if (paramLong != 0L) {
        break;
      }
      ae.w("MicroMsg.MsgInfoStorage", "invalid svr id %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(117260);
      return;
    }
    if (this.hKK.update(art(parambv.field_talker), parambv.convertTo(), "msgSvrId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new i.c(parambv.field_talker, "update", parambv));
      AppMethodBeat.o(117260);
      return;
    }
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 243L, 1L, false);
    AppMethodBeat.o(117260);
  }
  
  public final long c(bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(117238);
    if ((parambv == null) || (bu.isNullOrNil(parambv.field_talker)))
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 250L, 1L, false);
      if (parambv == null) {}
      for (localObject1 = "-1";; localObject1 = parambv.field_talker)
      {
        ae.e("MicroMsg.MsgInfoStorage", "Error insert message msg:%s talker:%s", new Object[] { parambv, localObject1 });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    ae.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", new Object[] { Boolean.valueOf(this.Jhz), Long.valueOf(parambv.field_msgSeq) });
    Object localObject1 = null;
    Object localObject2 = bl.BS(parambv.eNd);
    if (localObject2 != null) {
      localObject1 = ((bl.b)localObject2).hJE;
    }
    if (x.AT((String)localObject1))
    {
      ae.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { localObject1 });
      if (parambv.getType() == 436207665)
      {
        ae.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
        AppMethodBeat.o(117238);
        return -1L;
      }
      parambv.ui("notifymessage");
    }
    localObject1 = aVM(parambv.field_talker);
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 249L, 1L, false);
      ae.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", new Object[] { parambv.field_talker });
      AppMethodBeat.o(117238);
      return -1L;
    }
    ((i.b)localObject1).au(parambv);
    Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[] { Long.valueOf(parambv.field_msgId), localObject1, Eg(parambv.field_msgId) }), ((i.b)localObject1).name.equals(Eg(parambv.field_msgId)));
    if (parambv.field_msgSvrId != 0L)
    {
      parambv.fmr = 1;
      parambv.eMD = true;
    }
    ??? = this.Jhp.iterator();
    while (((Iterator)???).hasNext()) {
      if (!((e)((Iterator)???).next()).a(parambv, (bl.b)localObject2))
      {
        ae.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", new Object[] { parambv.field_talker, parambv.eNd });
        AppMethodBeat.o(117238);
        return -1L;
      }
    }
    aN(parambv);
    if (((i.b)localObject1).name.equals("message"))
    {
      parambv.field_talkerId = ((int)aVH(parambv.field_talker));
      parambv.eME = true;
    }
    localObject2 = parambv.convertTo();
    com.tencent.mm.storagebase.f localf;
    if (paramBoolean)
    {
      localf = this.hKK.fxT();
      ??? = ((i.b)localObject1).name;
      if (localf.Jjj != null)
      {
        localObject1 = localf.Jjj;
        if (com.tencent.mm.storagebase.f.isMainThread()) {
          com.tencent.mm.storagebase.f.Jjp.a((SQLiteDatabase)localObject1, 32769, (String)???);
        }
      }
    }
    for (long l = ((SQLiteDatabase)localObject1).insertOrThrow((String)???, "msgId", (ContentValues)localObject2);; l = this.hKK.a(((i.b)localObject1).name, "msgId", (ContentValues)localObject2))
    {
      ae.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", new Object[] { Long.valueOf(l), parambv.field_talker, Long.valueOf(parambv.field_msgId), Integer.valueOf(parambv.getType()), Integer.valueOf(parambv.field_status), Long.valueOf(parambv.field_msgSvrId), Long.valueOf(parambv.field_msgSeq), Integer.valueOf(parambv.field_flag), Long.valueOf(parambv.field_createTime), Integer.valueOf(parambv.field_isSend), this.JhA, Long.valueOf(bu.DD(this.JhB)) });
      if (l != -1L) {
        break label746;
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 248L, 1L, false);
      ae.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", new Object[] { Long.valueOf(parambv.field_msgSvrId), Long.valueOf(l) });
      AppMethodBeat.o(117238);
      return -1L;
      localObject1 = localf.Jjk;
      break;
    }
    label746:
    if ((this.Jhz) && (bu.DD(this.JhB) > 2000L) && (parambv.field_isSend == 1) && (parambv.field_status == 1))
    {
      ae.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", new Object[] { this.JhA, Long.valueOf(bu.DD(this.JhB)) });
      aqY(this.JhA);
    }
    if (this.Jhz)
    {
      localObject1 = null;
      if (e.IHT != null) {
        localObject1 = e.IHT.ab(parambv);
      }
      if (!bu.isNullOrNil((String)localObject1)) {
        break label1063;
      }
    }
    label1063:
    for (localObject2 = parambv.field_talker;; localObject2 = localObject1)
    {
      localObject1 = null;
      for (;;)
      {
        synchronized (this.Jhy)
        {
          if (this.Jhy.containsKey(localObject2)) {
            localObject1 = (i.c)this.Jhy.get(localObject2);
          }
          if (localObject1 == null)
          {
            localObject1 = new i.c(parambv.field_talker, "insert", parambv);
            if (i.c.av(parambv)) {
              ((i.c)localObject1).slP += 1;
            }
            ((i.c)localObject1).vWj += 1;
            this.Jhy.put(localObject2, localObject1);
            l = parambv.field_msgId;
            AppMethodBeat.o(117238);
            return l;
          }
          ((i.c)localObject1).gQn.add(parambv);
        }
        localObject1 = new i.c(parambv.field_talker, "insert", parambv);
        if (i.c.av(parambv)) {
          ((i.c)localObject1).slP = 1;
        }
        ((i.c)localObject1).vWj = 1;
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
      paramString = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND createTime > " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      ae.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hKK.a(paramString, null, 0);
      AppMethodBeat.o(117301);
      return paramString;
    }
    if (paramLong2 < paramLong1) {}
    for (;;)
    {
      paramString = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND createTime > " + paramLong2 + " AND createTime < " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + paramInt;
      ae.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hKK.a(paramString, null, 0);
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
    long l = bu.aRi();
    Object localObject = "SELECT msgSvrId,createTime FROM " + paramString1 + " WHERE createTime > " + (l - 172800L) * 1000L;
    paramString1 = (String)localObject;
    if (!bu.isNullOrNil(paramString2)) {
      paramString1 = (String)localObject + " AND " + paramString2;
    }
    paramString2 = new ArrayList();
    localObject = new ArrayList();
    paramString1 = this.hKK.a(paramString1, paramArrayOfString, 2);
    if (paramString1.moveToFirst())
    {
      do
      {
        int i = paramString1.getInt(0);
        l = paramString1.getLong(1) / 1000L;
        paramString2.add(Integer.valueOf(i));
        ((List)localObject).add(Long.valueOf(l));
      } while (paramString1.moveToNext());
      this.Jhx.F(paramString2, (List)localObject);
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
      paramString = "SELECT * FROM (SELECT * FROM " + art(paramString) + " WHERE" + aTQ(paramString) + aVG(paramString) + " AND createTime >= " + paramLong2 + " AND createTime <= " + paramLong1 + " ORDER BY createTime DESC LIMIT " + paramInt + " ) ORDER BY createTime ASC";
      ae.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(paramString)));
      paramString = this.hKK.a(paramString, null, 0);
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
    long l = paramh.yi(Thread.currentThread().getId());
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
    paramh.sW(l);
    AppMethodBeat.o(117198);
  }
  
  public final void doS()
  {
    AppMethodBeat.i(117201);
    v.aBq();
    AppMethodBeat.o(117201);
  }
  
  public final void doT()
  {
    AppMethodBeat.i(117204);
    int i = 0;
    while (i < this.Jhq.size())
    {
      b((i.b)this.Jhq.get(i));
      i += 1;
    }
    AppMethodBeat.o(117204);
  }
  
  public final void doU()
  {
    AppMethodBeat.i(117206);
    if (!this.Jho)
    {
      AppMethodBeat.o(117206);
      return;
    }
    Object localObject = "select count(*) from " + "message" + " where talkerId ISNULL ";
    localObject = this.hKK.a((String)localObject, null, 2);
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
        ae.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", new Object[] { "message" });
        long l = System.currentTimeMillis();
        localObject = "update " + "message" + " set talkerId=(select rowid from rcontact where rcontact.username = " + "message" + ".talker)";
        boolean bool = this.hKK.execSQL("message", (String)localObject);
        ae.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
        if ((bool) && (this.Jho))
        {
          this.hKK.execSQL("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
          this.hKK.execSQL("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
          this.hKK.execSQL("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
          this.hKK.execSQL("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
          this.hKK.execSQL("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
          ae.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
        }
      }
      AppMethodBeat.o(117206);
      return;
    }
  }
  
  public final ArrayList<bv> doV()
  {
    AppMethodBeat.i(117218);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.hKK.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[] { String.valueOf(System.currentTimeMillis() - 172800000L), "5", "1" }, null, null, "createTime ASC", 2);
    label149:
    while (localCursor.moveToNext())
    {
      bv localbv = new bv();
      localbv.convertFrom(localCursor);
      if (!localbv.fwa()) {}
      for (int i = 1;; i = 0)
      {
        if (((i & 0x1) == 0) || (an.aUn(localbv.field_talker)) || (an.aUp(localbv.field_talker)) || (an.Ac(localbv.field_talker))) {
          break label149;
        }
        localArrayList.add(localbv);
        break;
      }
    }
    localCursor.close();
    AppMethodBeat.o(117218);
    return localArrayList;
  }
  
  public final List<bv> doW()
  {
    AppMethodBeat.i(117231);
    List localList = Kn(2147483647);
    AppMethodBeat.o(117231);
    return localList;
  }
  
  public final Cursor doX()
  {
    AppMethodBeat.i(117269);
    Cursor localCursor = this.hKK.query("message", new String[] { "talker", "count(*) as unReadCount" }, "isSend=? AND status!=?", new String[] { "0", "4" }, "talker", null, null);
    AppMethodBeat.o(117269);
    return localCursor;
  }
  
  public final String doY()
  {
    return "type IN (3,39,13,43,62,44,268435505,486539313)";
  }
  
  public final String doZ()
  {
    return "type IN (3,39,13,43,62,44,49,268435505)";
  }
  
  public final int dpa()
  {
    AppMethodBeat.i(117295);
    ae.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf("SELECT COUNT(msgId) FROM message")));
    Cursor localCursor = this.hKK.a("SELECT COUNT(msgId) FROM message", null, 2);
    if (localCursor == null)
    {
      ae.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
      AppMethodBeat.o(117295);
      return 0;
    }
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getInt(0);
      ae.d("MicroMsg.MsgInfoStorage", "result getAllMsgCount count %d", new Object[] { Integer.valueOf(i) });
      localCursor.close();
      AppMethodBeat.o(117295);
      return i;
    }
    localCursor.close();
    AppMethodBeat.o(117295);
    return 0;
  }
  
  /* Error */
  public final List<bv> dpb()
  {
    // Byte code:
    //   0: ldc_w 1834
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 532	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 533	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 145	com/tencent/mm/storage/bw:hKK	Lcom/tencent/mm/storagebase/h;
    //   18: ldc 71
    //   20: aconst_null
    //   21: ldc_w 1836
    //   24: iconst_1
    //   25: anewarray 61	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: invokestatic 517	java/lang/System:currentTimeMillis	()J
    //   33: ldc2_w 620
    //   36: lsub
    //   37: invokestatic 734	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: ldc_w 1299
    //   46: iconst_2
    //   47: invokevirtual 603	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 606 1 0
    //   59: ifeq +75 -> 134
    //   62: aload_2
    //   63: astore_1
    //   64: new 227	com/tencent/mm/storage/bv
    //   67: dup
    //   68: invokespecial 607	com/tencent/mm/storage/bv:<init>	()V
    //   71: astore 4
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: aload_2
    //   78: invokevirtual 611	com/tencent/mm/storage/bv:convertFrom	(Landroid/database/Cursor;)V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload 4
    //   86: invokevirtual 777	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -39 -> 51
    //   93: astore_3
    //   94: aload_2
    //   95: astore_1
    //   96: ldc 157
    //   98: aload_3
    //   99: ldc_w 1301
    //   102: iconst_1
    //   103: anewarray 161	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_3
    //   109: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 742	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_2
    //   117: ifnull +9 -> 126
    //   120: aload_2
    //   121: invokeinterface 505 1 0
    //   126: ldc_w 1834
    //   129: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aconst_null
    //   133: areturn
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 505 1 0
    //   144: ldc_w 1834
    //   147: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_3
    //   151: areturn
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +9 -> 165
    //   159: aload_1
    //   160: invokeinterface 505 1 0
    //   165: ldc_w 1834
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
    //   0	183	0	this	bw
    //   52	108	1	localCursor1	Cursor
    //   50	89	2	localCursor2	Cursor
    //   152	20	2	localObject1	Object
    //   173	1	2	localObject2	Object
    //   179	1	2	localObject3	Object
    //   13	71	3	localArrayList	ArrayList
    //   93	58	3	localException1	Exception
    //   177	1	3	localException2	Exception
    //   71	14	4	localbv	bv
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
  
  public final List<bv> eB(List<String> paramList)
  {
    AppMethodBeat.i(211789);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.Jhq.size())
    {
      if (paramList.contains(((i.b)this.Jhq.get(i)).name)) {
        localLinkedList.add(this.Jhq.get(i));
      }
      i += 1;
    }
    paramList = r(2147483647, localLinkedList);
    AppMethodBeat.o(211789);
    return paramList;
  }
  
  public final List<bv> ei(String paramString, int paramInt)
  {
    AppMethodBeat.i(117228);
    ArrayList localArrayList = new ArrayList();
    if (this.Jhq != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND status = 3 AND type <> 10000 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hKK.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bv localbv = new bv();
        localbv.convertFrom(paramString);
        localArrayList.add(localbv);
      }
    }
    paramString.close();
    AppMethodBeat.o(117228);
    return localArrayList;
  }
  
  public final List<bv> ej(String paramString, int paramInt)
  {
    AppMethodBeat.i(117232);
    ArrayList localArrayList = new ArrayList();
    if (this.Jhq != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hKK.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bv localbv = new bv();
        localbv.convertFrom(paramString);
        if (localbv.isText()) {
          localArrayList.add(localbv);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(117232);
    return localArrayList;
  }
  
  public final List<bv> ek(String paramString, int paramInt)
  {
    AppMethodBeat.i(211791);
    ArrayList localArrayList = new ArrayList();
    if (this.Jhq != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + " ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hKK.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bv localbv = new bv();
        localbv.convertFrom(paramString);
        localArrayList.add(localbv);
      }
    }
    paramString.close();
    AppMethodBeat.o(211791);
    return localArrayList;
  }
  
  public final Cursor el(String paramString, int paramInt)
  {
    AppMethodBeat.i(117248);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117248);
      return null;
    }
    String str = art(paramString);
    paramString = "select * from " + str + " where" + aTQ(paramString) + aVG(paramString) + " AND type & 65535 = 49" + "  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.hKK.a(paramString, null, 0);
    AppMethodBeat.o(117248);
    return paramString;
  }
  
  public final Cursor em(String paramString, int paramInt)
  {
    AppMethodBeat.i(117249);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117249);
      return null;
    }
    Object localObject = art(paramString);
    paramString = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend,imgPath from ").append((String)localObject).append(" where").append(aTQ(paramString)).append(aVG(paramString)).append(" AND ");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" (type = 49");
    ((StringBuilder)localObject).append(" or type = 587202609");
    ((StringBuilder)localObject).append(" or type = 553648177) ");
    paramString = ((StringBuilder)localObject).toString() + " order by createTime DESC limit 100 OFFSET " + paramInt;
    paramString = this.hKK.a(paramString, null, 0);
    AppMethodBeat.o(117249);
    return paramString;
  }
  
  public final Cursor en(String paramString, int paramInt)
  {
    AppMethodBeat.i(117245);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
      AppMethodBeat.o(117245);
      return null;
    }
    String str = art(paramString);
    paramString = "select * from ( select * from " + str + " where" + aVG(paramString) + " AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime DESC limit 200 OFFSET " + paramInt + ") order by createTime ASC ";
    paramString = this.hKK.a(paramString, null, 2);
    AppMethodBeat.o(117245);
    return paramString;
  }
  
  public final int eo(String paramString, int paramInt)
  {
    AppMethodBeat.i(117256);
    ae.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", new Object[] { paramString, Integer.valueOf(paramInt), au.foR() });
    bv localbv = aJ(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbv.field_talker));
    c(art(paramString), "createTime<=? AND" + aVG(paramString), new String[] { localbv.field_createTime });
    paramInt = this.hKK.delete(art(paramString), "createTime<=? AND" + aVG(paramString), new String[] { localbv.field_createTime });
    if (paramInt != 0)
    {
      doNotify();
      a(new i.c(paramString, "delete", null, paramInt, (byte)0));
    }
    AppMethodBeat.o(117256);
    return paramInt;
  }
  
  public final Cursor ep(String paramString, int paramInt)
  {
    AppMethodBeat.i(117257);
    bv localbv = aJ(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localbv.field_talker));
    paramString = this.hKK.query(art(paramString), null, "createTime<=? AND" + aVG(paramString), new String[] { localbv.field_createTime }, null, null, null);
    AppMethodBeat.o(117257);
    return paramString;
  }
  
  public final Cursor eq(String paramString, int paramInt)
  {
    AppMethodBeat.i(117268);
    paramString = this.hKK.query(art(paramString), null, "isSend=? AND" + aVG(paramString) + "AND status!=?  order by msgId DESC limit " + paramInt, new String[] { "0", "4" }, null, null, null);
    AppMethodBeat.o(117268);
    return paramString;
  }
  
  public final int er(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117278);
    paramString = "SELECT COUNT(*) FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND type = " + paramInt;
    paramString = this.hKK.a(paramString, null, 2);
    paramInt = i;
    if (paramString.moveToFirst()) {
      paramInt = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(117278);
    return paramInt;
  }
  
  public final Cursor es(String paramString, int paramInt)
  {
    AppMethodBeat.i(117305);
    String str = " SELECT * FROM " + art(paramString) + " WHERE" + aTQ(paramString) + aVG(paramString) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + paramInt;
    ae.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    paramString = this.hKK.a(str, null, 0);
    AppMethodBeat.o(117305);
    return paramString;
  }
  
  public final bv[] et(String paramString, int paramInt)
  {
    AppMethodBeat.i(117311);
    if ((paramString == null) || (paramString.length() == 0) || (paramInt <= 0))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + paramString + ", limit = " + paramInt);
      AppMethodBeat.o(117311);
      return null;
    }
    Object localObject = "select * from " + art(paramString) + " where" + aVG(paramString) + "order by createTime DESC limit " + paramInt;
    localObject = this.hKK.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        bv localbv = new bv();
        localbv.convertFrom((Cursor)localObject);
        localArrayList.add(localbv);
      } while (((Cursor)localObject).moveToNext());
      ((Cursor)localObject).close();
      ae.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + paramString + ", limit = " + paramInt + ", count = " + localArrayList.size());
      Collections.reverse(localArrayList);
      paramString = (bv[])localArrayList.toArray(new bv[localArrayList.size()]);
      AppMethodBeat.o(117311);
      return paramString;
    }
    ae.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
    ((Cursor)localObject).close();
    AppMethodBeat.o(117311);
    return null;
  }
  
  public final Cursor eu(String paramString, int paramInt)
  {
    AppMethodBeat.i(117319);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(117319);
      return null;
    }
    String str = art(paramString);
    paramString = "select * from " + str + " where" + aTQ(paramString) + aVG(paramString) + " AND type IN (436207665,419430449)  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.hKK.a(paramString, null, 0);
    AppMethodBeat.o(117319);
    return paramString;
  }
  
  public final List<bv> f(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(211785);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + art(paramString) + " Where " + aVG(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit " + paramInt;
    paramString = this.hKK.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bv localbv = new bv();
      localbv.convertFrom(paramString);
      localArrayList.add(localbv);
    }
    paramString.close();
    AppMethodBeat.o(211785);
    return localArrayList;
  }
  
  public final List<bv> f(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(117242);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(117242);
      return null;
    }
    paramLong = aR(paramString, paramLong);
    if (paramLong == 0L)
    {
      ae.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(117242);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (paramString = "select * from " + art(paramString) + " where" + aTQ(paramString) + aVG(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime > " + paramLong + " order by createTime ASC limit 10";; paramString = "select * from " + art(paramString) + " where" + aTQ(paramString) + aVG(paramString) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + paramLong + " order by createTime DESC limit 10")
    {
      paramString = this.hKK.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        bv localbv = new bv();
        localbv.convertFrom(paramString);
        localArrayList.add(localbv);
      }
    }
    if (!paramBoolean) {
      Collections.reverse(localArrayList);
    }
    paramString.close();
    AppMethodBeat.o(117242);
    return localArrayList;
  }
  
  public final List<bv> g(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(211786);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + art(paramString) + " Where " + aVG(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit " + paramInt + ";";
    paramString = this.hKK.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      bv localbv = new bv();
      localbv.convertFrom(paramString);
      localArrayList.add(localbv);
    }
    paramString.close();
    AppMethodBeat.o(211786);
    return localArrayList;
  }
  
  public final h getDB()
  {
    return this.hKK;
  }
  
  public final int h(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117221);
    String str = "SELECT * FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime ASC LIMIT -1 OFFSET " + paramInt;
    Cursor localCursor = this.hKK.a(str, null, 0);
    paramInt = localCursor.getCount();
    localCursor.close();
    ae.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + paramString + " time:" + paramLong + " count " + paramInt + " [" + str + "]");
    AppMethodBeat.o(117221);
    return paramInt;
  }
  
  public final bv hX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117225);
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", new Object[] { paramString1 });
      AppMethodBeat.o(117225);
      return null;
    }
    bv localbv = new bv();
    paramString2 = "select * from " + art(paramString1) + " where" + aVG(paramString1) + paramString2 + " order by createTime DESC limit 1";
    paramString2 = this.hKK.a(paramString2, null, 2);
    if (paramString2.moveToFirst()) {
      localbv.convertFrom(paramString2);
    }
    paramString2.close();
    ae.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", new Object[] { paramString1, Long.valueOf(localbv.field_msgId) });
    AppMethodBeat.o(117225);
    return localbv;
  }
  
  public final Cursor hY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117265);
    paramString1 = "SELECT * FROM " + art(paramString1) + " WHERE" + aVG(paramString1) + "AND content LIKE '%" + paramString2 + "%' AND type = 1";
    paramString1 = paramString1 + " ORDER BY createTime DESC";
    paramString1 = this.hKK.a(paramString1, null, 0);
    AppMethodBeat.o(117265);
    return paramString1;
  }
  
  public final int hZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117306);
    String str = " SELECT COUNT(*) FROM " + art(paramString1) + " WHERE" + aTQ(paramString1) + aVG(paramString1) + "AND content LIKE '" + paramString2 + "%' ";
    Cursor localCursor = this.hKK.a(str, null, 2);
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
        ae.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(117306);
      }
      ae.d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(i), str });
      AppMethodBeat.o(117306);
      return i;
      label188:
      int i = 0;
    }
  }
  
  public final long i(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(117308);
    ae.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ae.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117308);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + art(paramString) + " WHERE" + aTQ(paramString) + aVG(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime DESC  LIMIT " + paramInt;
    ae.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hKK.a(paramString, null, 0);
    if (paramString == null)
    {
      ae.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      AppMethodBeat.o(117308);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      ae.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(117308);
      return paramLong;
    }
    paramString.close();
    ae.w("MicroMsg.MsgInfoStorage", "get result fail");
    AppMethodBeat.o(117308);
    return paramLong;
  }
  
  public final LinkedList<bv> ia(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117312);
    paramString1 = this.hKK.a(art(paramString1), null, "talker=? AND bizClientMsgId=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
    if (paramString1 != null) {}
    try
    {
      if (!paramString1.moveToFirst())
      {
        ae.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
        return null;
      }
      paramString2 = new LinkedList();
      do
      {
        bv localbv = new bv();
        localbv.convertFrom(paramString1);
        paramString2.add(localbv);
      } while (paramString1.moveToNext());
      paramString1.close();
      return paramString2;
    }
    catch (Exception paramString2)
    {
      ae.printErrStackTrace("MicroMsg.MsgInfoStorage", paramString2, "getLastDayC2CMsgByTalker error: %s", new Object[] { paramString2.getMessage() });
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
    AppMethodBeat.i(117310);
    ae.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ae.w("MicroMsg.MsgInfoStorage", "error target inc count");
      AppMethodBeat.o(117310);
      return paramLong;
    }
    paramString = "SELECT createTime FROM " + art(paramString) + " WHERE" + aVG(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC  LIMIT " + paramInt;
    ae.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hKK.a(paramString, null, 0);
    if (paramString == null)
    {
      ae.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
      AppMethodBeat.o(117310);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      ae.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(117310);
      return paramLong;
    }
    paramString.close();
    ae.w("MicroMsg.MsgInfoStorage", "get result fail");
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
      paramString = this.hKK.a(paramString, null, 0);
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
  
  public final bv ys(long paramLong)
  {
    AppMethodBeat.i(117207);
    bv localbv = new bv();
    Cursor localCursor = this.hKK.a(Eg(paramLong), null, "msgId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localbv.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(117207);
    return localbv;
  }
  
  public final int yt(long paramLong)
  {
    AppMethodBeat.i(117239);
    bv localbv = ys(paramLong);
    Object localObject = localbv.field_talker;
    this.Jhx.n((int)(bu.aRi() / 86400L), localbv.field_msgSvrId, localbv.field_createTime / 1000L);
    int i = this.hKK.delete(Eg(paramLong), "msgId=?", new String[] { String.valueOf(paramLong) });
    ((aq)g.ab(aq.class)).rU(paramLong);
    if (i != 0)
    {
      doNotify("delete_id ".concat(String.valueOf(paramLong)));
      localObject = new i.c((String)localObject, "delete", localbv, 1, (byte)0);
      ((i.c)localObject).vWl = paramLong;
      ((i.c)localObject).oex = localbv.field_bizChatId;
      a((i.c)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(117239);
      return i;
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 245L, 1L, false);
    }
  }
  
  public final boolean yu(long paramLong)
  {
    AppMethodBeat.i(117251);
    boolean bool = this.Jhx.Ee(paramLong);
    AppMethodBeat.o(117251);
    return bool;
  }
  
  public final boolean yv(long paramLong)
  {
    AppMethodBeat.i(117287);
    int i = 0;
    while (i < this.Jhq.size())
    {
      if (((i.b)this.Jhq.get(i)).yx(paramLong))
      {
        AppMethodBeat.o(117287);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(117287);
    return false;
  }
  
  public final void yw(long paramLong)
  {
    AppMethodBeat.i(117313);
    this.Jhx.b(0, paramLong, 0L, false);
    AppMethodBeat.o(117313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bw
 * JD-Core Version:    0.7.0.1
 */