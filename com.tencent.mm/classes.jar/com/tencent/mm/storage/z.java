package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.a.c;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class z
  extends n
  implements b
{
  private static final String[] Ffk;
  public static final String[] SQL_CREATE;
  private h gPa;
  
  static
  {
    AppMethodBeat.i(116965);
    SQL_CREATE = new String[] { j.getCreateSQLs(y.info, "ChatroomMsgSeq") };
    Ffk = new String[] { "CREATE INDEX IF NOT EXISTS  ChatroomMsgSeqTalkerIndex ON ChatroomMsgSeq ( username )" };
    AppMethodBeat.o(116965);
  }
  
  public z(h paramh)
  {
    AppMethodBeat.i(116942);
    this.gPa = paramh;
    paramh.execSQL("ChatroomMsgSeq", Ffk[0]);
    AppMethodBeat.o(116942);
  }
  
  public final int A(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(116964);
    paramString = agb(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      ad.i("MicroMsg.ChatroomMsgSeqStorage", "[getBlockCount] seqBlockInfo is null!");
      AppMethodBeat.o(116964);
      return 0;
    }
    paramString = paramString.fyv.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if ((paramLong1 > localc.fyt) || (localc.fyu > paramLong2)) {
        break label103;
      }
      i += 1;
    }
    label103:
    for (;;)
    {
      break;
      AppMethodBeat.o(116964);
      return i;
    }
  }
  
  public final long a(y paramy)
  {
    AppMethodBeat.i(116943);
    long l = a(paramy, false);
    AppMethodBeat.o(116943);
    return l;
  }
  
  public final long a(y paramy, boolean paramBoolean)
  {
    AppMethodBeat.i(116944);
    if (paramy == null)
    {
      AppMethodBeat.o(116944);
      return -1L;
    }
    Object localObject = paramy.convertTo();
    long l = this.gPa.a("ChatroomMsgSeq", "username", (ContentValues)localObject);
    if (l >= 0L)
    {
      localObject = new b.a();
      ((b.a)localObject).id = 4;
      ((b.a)localObject).username = paramy.field_username;
      ((b.a)localObject).tyy = paramBoolean;
      b(4, this, localObject);
    }
    AppMethodBeat.o(116944);
    return l;
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(116957);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ChatroomMsgSeqStorage", "updateSeqBlockInfo failed");
      AppMethodBeat.o(116957);
      return false;
    }
    Object localObject = new byte[0];
    try
    {
      paramd = paramd.toByteArray();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("seqBlockInfo", paramd);
      if (this.gPa.update("ChatroomMsgSeq", (ContentValues)localObject, "username = ?", new String[] { bt.aFQ(paramString) }) > 0)
      {
        AppMethodBeat.o(116957);
        return true;
      }
      AppMethodBeat.o(116957);
      return false;
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        paramd = (d)localObject;
      }
    }
  }
  
  public final boolean aIE()
  {
    return true;
  }
  
  public final long afT(String paramString)
  {
    AppMethodBeat.i(116946);
    long l = this.gPa.delete("ChatroomMsgSeq", "username = ?", new String[] { paramString });
    AppMethodBeat.o(116946);
    return l;
  }
  
  public final long afU(String paramString)
  {
    AppMethodBeat.i(116948);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116948);
      return -1L;
    }
    Object localObject = "select lastPushSeq from ChatroomMsgSeq where username = \"" + bt.aFQ(String.valueOf(paramString)) + "\"";
    localObject = this.gPa.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ad.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(116948);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(116948);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(116948);
    return -3L;
  }
  
  public final long afV(String paramString)
  {
    AppMethodBeat.i(116950);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116950);
      return -1L;
    }
    Object localObject = "select lastLocalSeq from ChatroomMsgSeq where username = \"" + bt.aFQ(String.valueOf(paramString)) + "\"";
    localObject = this.gPa.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ad.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(116950);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(116950);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(116950);
    return -3L;
  }
  
  public final long afW(String paramString)
  {
    AppMethodBeat.i(116949);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116949);
      return -1L;
    }
    Object localObject = "select lastPushCreateTime from ChatroomMsgSeq where username = \"" + bt.aFQ(String.valueOf(paramString)) + "\"";
    localObject = this.gPa.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ad.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(116949);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(116949);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(116949);
    return -3L;
  }
  
  public final long afX(String paramString)
  {
    AppMethodBeat.i(116951);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116951);
      return -1L;
    }
    Object localObject = "select lastLocalCreateTime from ChatroomMsgSeq where username = \"" + bt.aFQ(String.valueOf(paramString)) + "\"";
    localObject = this.gPa.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ad.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(116951);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(116951);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(116951);
    return -3L;
  }
  
  public final d afY(String paramString)
  {
    AppMethodBeat.i(116956);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed username is null!");
      paramString = new d();
      AppMethodBeat.o(116956);
      return paramString;
    }
    Object localObject = "select seqBlockInfo from ChatroomMsgSeq where username = \"" + bt.aFQ(String.valueOf(paramString)) + "\"";
    localObject = this.gPa.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ad.e("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed ".concat(String.valueOf(paramString)));
      paramString = new d();
      AppMethodBeat.o(116956);
      return paramString;
    }
    byte[] arrayOfByte;
    if (((Cursor)localObject).moveToFirst())
    {
      arrayOfByte = ((Cursor)localObject).getBlob(0);
      if (bt.cw(arrayOfByte))
      {
        ((Cursor)localObject).close();
        paramString = new d();
        AppMethodBeat.o(116956);
        return paramString;
      }
      paramString = new d();
    }
    try
    {
      paramString.parseFrom(arrayOfByte);
      label172:
      ((Cursor)localObject).close();
      AppMethodBeat.o(116956);
      return paramString;
      ((Cursor)localObject).close();
      paramString = new d();
      AppMethodBeat.o(116956);
      return paramString;
    }
    catch (Exception localException)
    {
      break label172;
    }
  }
  
  public final boolean afZ(String paramString)
  {
    AppMethodBeat.i(116958);
    Object localObject = "select count(*) from ChatroomMsgSeq where username = \"" + bt.aFQ(String.valueOf(paramString)) + "\"";
    localObject = this.gPa.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ad.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(116958);
      return false;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      if (l > 0L)
      {
        AppMethodBeat.o(116958);
        return true;
      }
      AppMethodBeat.o(116958);
      return false;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(116958);
    return false;
  }
  
  public final c aga(String paramString)
  {
    AppMethodBeat.i(116959);
    paramString = afY(paramString);
    if (paramString.fyv.size() <= 0)
    {
      AppMethodBeat.o(116959);
      return null;
    }
    paramString = (c)paramString.fyv.getLast();
    AppMethodBeat.o(116959);
    return paramString;
  }
  
  public final y agb(String paramString)
  {
    AppMethodBeat.i(116962);
    ad.i("MicroMsg.ChatroomMsgSeqStorage", "[getChatroomMsgSeq] username:%s", new Object[] { paramString });
    y localy = new y();
    paramString = "select * from ChatroomMsgSeq where username = \"" + bt.aFQ(String.valueOf(paramString)) + "\"";
    paramString = this.gPa.a(paramString, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(116962);
      return localy;
    }
    if (paramString.moveToFirst()) {
      localy.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(116962);
    return localy;
  }
  
  public final StringBuilder agc(String paramString)
  {
    AppMethodBeat.i(116963);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = agb(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      AppMethodBeat.o(116963);
      return localStringBuilder;
    }
    paramString = paramString.fyv.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      localStringBuilder.append("[").append(localc.fyr).append(":").append(localc.fys).append("][").append(localc.fyt).append(":").append(localc.fyu).append("] | ");
    }
    AppMethodBeat.o(116963);
    return localStringBuilder;
  }
  
  public final boolean av(String paramString, long paramLong)
  {
    AppMethodBeat.i(116952);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116952);
      return false;
    }
    Object localObject = "update ChatroomMsgSeq set lastPushSeq =  " + paramLong + " where username = \"" + bt.aFQ(paramString) + "\"";
    boolean bool = this.gPa.execSQL("ChatroomMsgSeq", (String)localObject);
    if (bool)
    {
      localObject = new b.a();
      ((b.a)localObject).id = 4;
      ((b.a)localObject).username = paramString;
      b(2, this, localObject);
    }
    AppMethodBeat.o(116952);
    return bool;
  }
  
  public final boolean aw(String paramString, long paramLong)
  {
    AppMethodBeat.i(116953);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116953);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalCreateTime =  " + paramLong + " where username = \"" + bt.aFQ(paramString) + "\"";
    boolean bool = this.gPa.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116953);
    return bool;
  }
  
  public final boolean ax(String paramString, long paramLong)
  {
    AppMethodBeat.i(116954);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116954);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastPushCreateTime =  " + paramLong + " where username = \"" + bt.aFQ(paramString) + "\"";
    boolean bool = this.gPa.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116954);
    return bool;
  }
  
  public final boolean ay(String paramString, long paramLong)
  {
    AppMethodBeat.i(116955);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116955);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalSeq =  " + paramLong + " where username = \"" + bt.aFQ(paramString) + "\"";
    boolean bool = this.gPa.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116955);
    return bool;
  }
  
  public final c az(String paramString, long paramLong)
  {
    AppMethodBeat.i(116961);
    paramString = afY(paramString);
    if (paramString.fyv.size() <= 0)
    {
      AppMethodBeat.o(116961);
      return null;
    }
    paramString = paramString.fyv.listIterator(paramString.fyv.size());
    while (paramString.hasPrevious())
    {
      c localc = (c)paramString.previous();
      if (localc.fyt < paramLong)
      {
        AppMethodBeat.o(116961);
        return localc;
      }
    }
    AppMethodBeat.o(116961);
    return null;
  }
  
  public final long b(y paramy)
  {
    AppMethodBeat.i(116945);
    if (paramy == null)
    {
      AppMethodBeat.o(116945);
      return -1L;
    }
    ContentValues localContentValues = paramy.convertTo();
    long l = this.gPa.update("ChatroomMsgSeq", localContentValues, "username = ?", new String[] { paramy.field_username });
    AppMethodBeat.o(116945);
    return l;
  }
  
  public final boolean cOL()
  {
    AppMethodBeat.i(116947);
    long l = this.gPa.delete("ChatroomMsgSeq", "", null);
    ad.w("MicroMsg.ChatroomMsgSeqStorage", "[deleteTable] result:" + l + " table:ChatroomMsgSeq");
    if (l >= 0L)
    {
      AppMethodBeat.o(116947);
      return true;
    }
    AppMethodBeat.o(116947);
    return false;
  }
  
  public final c f(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(116960);
    paramString = afY(paramString);
    if (paramString.fyv.size() <= 0)
    {
      AppMethodBeat.o(116960);
      return null;
    }
    paramString = paramString.fyv.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if (!paramBoolean)
      {
        if (localc.fyu > paramLong)
        {
          AppMethodBeat.o(116960);
          return localc;
        }
      }
      else if (localc.fyt > paramLong)
      {
        AppMethodBeat.o(116960);
        return localc;
      }
    }
    AppMethodBeat.o(116960);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.z
 * JD-Core Version:    0.7.0.1
 */