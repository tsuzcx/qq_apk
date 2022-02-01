package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.a.a.c;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class ae
  extends n
  implements b
{
  private static final String[] Ipp;
  public static final String[] SQL_CREATE;
  private h hHS;
  
  static
  {
    AppMethodBeat.i(116965);
    SQL_CREATE = new String[] { j.getCreateSQLs(ad.info, "ChatroomMsgSeq") };
    Ipp = new String[] { "CREATE INDEX IF NOT EXISTS  ChatroomMsgSeqTalkerIndex ON ChatroomMsgSeq ( username )" };
    AppMethodBeat.o(116965);
  }
  
  public ae(h paramh)
  {
    AppMethodBeat.i(116942);
    this.hHS = paramh;
    paramh.execSQL("ChatroomMsgSeq", Ipp[0]);
    AppMethodBeat.o(116942);
  }
  
  public final long a(ad paramad)
  {
    AppMethodBeat.i(116943);
    long l = a(paramad, false);
    AppMethodBeat.o(116943);
    return l;
  }
  
  public final long a(ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(116944);
    if (paramad == null)
    {
      AppMethodBeat.o(116944);
      return -1L;
    }
    Object localObject = paramad.convertTo();
    long l = this.hHS.a("ChatroomMsgSeq", "username", (ContentValues)localObject);
    if (l >= 0L)
    {
      localObject = new b.a();
      ((b.a)localObject).id = 4;
      ((b.a)localObject).username = paramad.field_username;
      ((b.a)localObject).vJZ = paramBoolean;
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
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChatroomMsgSeqStorage", "updateSeqBlockInfo failed");
      AppMethodBeat.o(116957);
      return false;
    }
    Object localObject = new byte[0];
    try
    {
      paramd = paramd.toByteArray();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("seqBlockInfo", paramd);
      if (this.hHS.update("ChatroomMsgSeq", (ContentValues)localObject, "username = ?", new String[] { bt.aQN(paramString) }) > 0)
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
  
  public final boolean aA(String paramString, long paramLong)
  {
    AppMethodBeat.i(116952);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116952);
      return false;
    }
    Object localObject = "update ChatroomMsgSeq set lastPushSeq =  " + paramLong + " where username = \"" + bt.aQN(paramString) + "\"";
    boolean bool = this.hHS.execSQL("ChatroomMsgSeq", (String)localObject);
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
  
  public final boolean aB(String paramString, long paramLong)
  {
    AppMethodBeat.i(116953);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116953);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalCreateTime =  " + paramLong + " where username = \"" + bt.aQN(paramString) + "\"";
    boolean bool = this.hHS.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116953);
    return bool;
  }
  
  public final boolean aC(String paramString, long paramLong)
  {
    AppMethodBeat.i(116954);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116954);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastPushCreateTime =  " + paramLong + " where username = \"" + bt.aQN(paramString) + "\"";
    boolean bool = this.hHS.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116954);
    return bool;
  }
  
  public final boolean aD(String paramString, long paramLong)
  {
    AppMethodBeat.i(116955);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116955);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalSeq =  " + paramLong + " where username = \"" + bt.aQN(paramString) + "\"";
    boolean bool = this.hHS.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116955);
    return bool;
  }
  
  public final c aE(String paramString, long paramLong)
  {
    AppMethodBeat.i(116961);
    paramString = apE(paramString);
    if (paramString.fVq.size() <= 0)
    {
      AppMethodBeat.o(116961);
      return null;
    }
    paramString = paramString.fVq.listIterator(paramString.fVq.size());
    while (paramString.hasPrevious())
    {
      c localc = (c)paramString.previous();
      if (localc.fVo < paramLong)
      {
        AppMethodBeat.o(116961);
        return localc;
      }
    }
    AppMethodBeat.o(116961);
    return null;
  }
  
  public final boolean aSH()
  {
    return true;
  }
  
  public final long apA(String paramString)
  {
    AppMethodBeat.i(116948);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116948);
      return -1L;
    }
    Object localObject = "select lastPushSeq from ChatroomMsgSeq where username = \"" + bt.aQN(String.valueOf(paramString)) + "\"";
    localObject = this.hHS.a((String)localObject, null, 2);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final long apB(String paramString)
  {
    AppMethodBeat.i(116950);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116950);
      return -1L;
    }
    Object localObject = "select lastLocalSeq from ChatroomMsgSeq where username = \"" + bt.aQN(String.valueOf(paramString)) + "\"";
    localObject = this.hHS.a((String)localObject, null, 2);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final long apC(String paramString)
  {
    AppMethodBeat.i(116949);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116949);
      return -1L;
    }
    Object localObject = "select lastPushCreateTime from ChatroomMsgSeq where username = \"" + bt.aQN(String.valueOf(paramString)) + "\"";
    localObject = this.hHS.a((String)localObject, null, 2);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final long apD(String paramString)
  {
    AppMethodBeat.i(116951);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116951);
      return -1L;
    }
    Object localObject = "select lastLocalCreateTime from ChatroomMsgSeq where username = \"" + bt.aQN(String.valueOf(paramString)) + "\"";
    localObject = this.hHS.a((String)localObject, null, 2);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final d apE(String paramString)
  {
    AppMethodBeat.i(116956);
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed username is null!");
      paramString = new d();
      AppMethodBeat.o(116956);
      return paramString;
    }
    Object localObject = "select seqBlockInfo from ChatroomMsgSeq where username = \"" + bt.aQN(String.valueOf(paramString)) + "\"";
    localObject = this.hHS.a((String)localObject, null, 2);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed ".concat(String.valueOf(paramString)));
      paramString = new d();
      AppMethodBeat.o(116956);
      return paramString;
    }
    byte[] arrayOfByte;
    if (((Cursor)localObject).moveToFirst())
    {
      arrayOfByte = ((Cursor)localObject).getBlob(0);
      if (bt.cC(arrayOfByte))
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
  
  public final boolean apF(String paramString)
  {
    AppMethodBeat.i(116958);
    Object localObject = "select count(*) from ChatroomMsgSeq where username = \"" + bt.aQN(String.valueOf(paramString)) + "\"";
    localObject = this.hHS.a((String)localObject, null, 2);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final c apG(String paramString)
  {
    AppMethodBeat.i(116959);
    paramString = apE(paramString);
    if (paramString.fVq.size() <= 0)
    {
      AppMethodBeat.o(116959);
      return null;
    }
    paramString = (c)paramString.fVq.getLast();
    AppMethodBeat.o(116959);
    return paramString;
  }
  
  public final ad apH(String paramString)
  {
    AppMethodBeat.i(116962);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChatroomMsgSeqStorage", "[getChatroomMsgSeq] username:%s", new Object[] { paramString });
    ad localad = new ad();
    paramString = "select * from ChatroomMsgSeq where username = \"" + bt.aQN(String.valueOf(paramString)) + "\"";
    paramString = this.hHS.a(paramString, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(116962);
      return localad;
    }
    if (paramString.moveToFirst()) {
      localad.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(116962);
    return localad;
  }
  
  public final StringBuilder apI(String paramString)
  {
    AppMethodBeat.i(116963);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = apH(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      AppMethodBeat.o(116963);
      return localStringBuilder;
    }
    paramString = paramString.fVq.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      localStringBuilder.append("[").append(localc.fVm).append(":").append(localc.fVn).append("][").append(localc.fVo).append(":").append(localc.fVp).append("] | ");
    }
    AppMethodBeat.o(116963);
    return localStringBuilder;
  }
  
  public final long apz(String paramString)
  {
    AppMethodBeat.i(116946);
    long l = this.hHS.delete("ChatroomMsgSeq", "username = ?", new String[] { paramString });
    AppMethodBeat.o(116946);
    return l;
  }
  
  public final long b(ad paramad)
  {
    AppMethodBeat.i(116945);
    if (paramad == null)
    {
      AppMethodBeat.o(116945);
      return -1L;
    }
    ContentValues localContentValues = paramad.convertTo();
    long l = this.hHS.update("ChatroomMsgSeq", localContentValues, "username = ?", new String[] { paramad.field_username });
    AppMethodBeat.o(116945);
    return l;
  }
  
  public final boolean dlM()
  {
    AppMethodBeat.i(116947);
    long l = this.hHS.delete("ChatroomMsgSeq", "", null);
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChatroomMsgSeqStorage", "[deleteTable] result:" + l + " table:ChatroomMsgSeq");
    if (l >= 0L)
    {
      AppMethodBeat.o(116947);
      return true;
    }
    AppMethodBeat.o(116947);
    return false;
  }
  
  public final c e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(116960);
    paramString = apE(paramString);
    if (paramString.fVq.size() <= 0)
    {
      AppMethodBeat.o(116960);
      return null;
    }
    paramString = paramString.fVq.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if (!paramBoolean)
      {
        if (localc.fVp > paramLong)
        {
          AppMethodBeat.o(116960);
          return localc;
        }
      }
      else if (localc.fVo > paramLong)
      {
        AppMethodBeat.o(116960);
        return localc;
      }
    }
    AppMethodBeat.o(116960);
    return null;
  }
  
  public final int z(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(116964);
    paramString = apH(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChatroomMsgSeqStorage", "[getBlockCount] seqBlockInfo is null!");
      AppMethodBeat.o(116964);
      return 0;
    }
    paramString = paramString.fVq.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if ((paramLong1 > localc.fVo) || (localc.fVp > paramLong2)) {
        break label107;
      }
      i += 1;
    }
    label107:
    for (;;)
    {
      break;
      AppMethodBeat.o(116964);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ae
 * JD-Core Version:    0.7.0.1
 */