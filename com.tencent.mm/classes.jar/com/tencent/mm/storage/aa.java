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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class aa
  extends n
  implements b
{
  private static final String[] GCW;
  public static final String[] SQL_CREATE;
  private h hpA;
  
  static
  {
    AppMethodBeat.i(116965);
    SQL_CREATE = new String[] { j.getCreateSQLs(z.info, "ChatroomMsgSeq") };
    GCW = new String[] { "CREATE INDEX IF NOT EXISTS  ChatroomMsgSeqTalkerIndex ON ChatroomMsgSeq ( username )" };
    AppMethodBeat.o(116965);
  }
  
  public aa(h paramh)
  {
    AppMethodBeat.i(116942);
    this.hpA = paramh;
    paramh.execSQL("ChatroomMsgSeq", GCW[0]);
    AppMethodBeat.o(116942);
  }
  
  public final long a(z paramz)
  {
    AppMethodBeat.i(116943);
    long l = a(paramz, false);
    AppMethodBeat.o(116943);
    return l;
  }
  
  public final long a(z paramz, boolean paramBoolean)
  {
    AppMethodBeat.i(116944);
    if (paramz == null)
    {
      AppMethodBeat.o(116944);
      return -1L;
    }
    Object localObject = paramz.convertTo();
    long l = this.hpA.a("ChatroomMsgSeq", "username", (ContentValues)localObject);
    if (l >= 0L)
    {
      localObject = new b.a();
      ((b.a)localObject).id = 4;
      ((b.a)localObject).username = paramz.field_username;
      ((b.a)localObject).uGW = paramBoolean;
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
      ac.e("MicroMsg.ChatroomMsgSeqStorage", "updateSeqBlockInfo failed");
      AppMethodBeat.o(116957);
      return false;
    }
    Object localObject = new byte[0];
    try
    {
      paramd = paramd.toByteArray();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("seqBlockInfo", paramd);
      if (this.hpA.update("ChatroomMsgSeq", (ContentValues)localObject, "username = ?", new String[] { bs.aLh(paramString) }) > 0)
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
    AppMethodBeat.i(116955);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116955);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalSeq =  " + paramLong + " where username = \"" + bs.aLh(paramString) + "\"";
    boolean bool = this.hpA.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116955);
    return bool;
  }
  
  public final c aB(String paramString, long paramLong)
  {
    AppMethodBeat.i(116961);
    paramString = akS(paramString);
    if (paramString.fCc.size() <= 0)
    {
      AppMethodBeat.o(116961);
      return null;
    }
    paramString = paramString.fCc.listIterator(paramString.fCc.size());
    while (paramString.hasPrevious())
    {
      c localc = (c)paramString.previous();
      if (localc.fCa < paramLong)
      {
        AppMethodBeat.o(116961);
        return localc;
      }
    }
    AppMethodBeat.o(116961);
    return null;
  }
  
  public final boolean aPv()
  {
    return true;
  }
  
  public final long akN(String paramString)
  {
    AppMethodBeat.i(116946);
    long l = this.hpA.delete("ChatroomMsgSeq", "username = ?", new String[] { paramString });
    AppMethodBeat.o(116946);
    return l;
  }
  
  public final long akO(String paramString)
  {
    AppMethodBeat.i(116948);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116948);
      return -1L;
    }
    Object localObject = "select lastPushSeq from ChatroomMsgSeq where username = \"" + bs.aLh(String.valueOf(paramString)) + "\"";
    localObject = this.hpA.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ac.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final long akP(String paramString)
  {
    AppMethodBeat.i(116950);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116950);
      return -1L;
    }
    Object localObject = "select lastLocalSeq from ChatroomMsgSeq where username = \"" + bs.aLh(String.valueOf(paramString)) + "\"";
    localObject = this.hpA.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ac.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final long akQ(String paramString)
  {
    AppMethodBeat.i(116949);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116949);
      return -1L;
    }
    Object localObject = "select lastPushCreateTime from ChatroomMsgSeq where username = \"" + bs.aLh(String.valueOf(paramString)) + "\"";
    localObject = this.hpA.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ac.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final long akR(String paramString)
  {
    AppMethodBeat.i(116951);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116951);
      return -1L;
    }
    Object localObject = "select lastLocalCreateTime from ChatroomMsgSeq where username = \"" + bs.aLh(String.valueOf(paramString)) + "\"";
    localObject = this.hpA.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ac.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final d akS(String paramString)
  {
    AppMethodBeat.i(116956);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed username is null!");
      paramString = new d();
      AppMethodBeat.o(116956);
      return paramString;
    }
    Object localObject = "select seqBlockInfo from ChatroomMsgSeq where username = \"" + bs.aLh(String.valueOf(paramString)) + "\"";
    localObject = this.hpA.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ac.e("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed ".concat(String.valueOf(paramString)));
      paramString = new d();
      AppMethodBeat.o(116956);
      return paramString;
    }
    byte[] arrayOfByte;
    if (((Cursor)localObject).moveToFirst())
    {
      arrayOfByte = ((Cursor)localObject).getBlob(0);
      if (bs.cv(arrayOfByte))
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
  
  public final boolean akT(String paramString)
  {
    AppMethodBeat.i(116958);
    Object localObject = "select count(*) from ChatroomMsgSeq where username = \"" + bs.aLh(String.valueOf(paramString)) + "\"";
    localObject = this.hpA.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ac.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final c akU(String paramString)
  {
    AppMethodBeat.i(116959);
    paramString = akS(paramString);
    if (paramString.fCc.size() <= 0)
    {
      AppMethodBeat.o(116959);
      return null;
    }
    paramString = (c)paramString.fCc.getLast();
    AppMethodBeat.o(116959);
    return paramString;
  }
  
  public final z akV(String paramString)
  {
    AppMethodBeat.i(116962);
    ac.i("MicroMsg.ChatroomMsgSeqStorage", "[getChatroomMsgSeq] username:%s", new Object[] { paramString });
    z localz = new z();
    paramString = "select * from ChatroomMsgSeq where username = \"" + bs.aLh(String.valueOf(paramString)) + "\"";
    paramString = this.hpA.a(paramString, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(116962);
      return localz;
    }
    if (paramString.moveToFirst()) {
      localz.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(116962);
    return localz;
  }
  
  public final StringBuilder akW(String paramString)
  {
    AppMethodBeat.i(116963);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = akV(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      AppMethodBeat.o(116963);
      return localStringBuilder;
    }
    paramString = paramString.fCc.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      localStringBuilder.append("[").append(localc.fBY).append(":").append(localc.fBZ).append("][").append(localc.fCa).append(":").append(localc.fCb).append("] | ");
    }
    AppMethodBeat.o(116963);
    return localStringBuilder;
  }
  
  public final boolean ax(String paramString, long paramLong)
  {
    AppMethodBeat.i(116952);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116952);
      return false;
    }
    Object localObject = "update ChatroomMsgSeq set lastPushSeq =  " + paramLong + " where username = \"" + bs.aLh(paramString) + "\"";
    boolean bool = this.hpA.execSQL("ChatroomMsgSeq", (String)localObject);
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
  
  public final boolean ay(String paramString, long paramLong)
  {
    AppMethodBeat.i(116953);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116953);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalCreateTime =  " + paramLong + " where username = \"" + bs.aLh(paramString) + "\"";
    boolean bool = this.hpA.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116953);
    return bool;
  }
  
  public final boolean az(String paramString, long paramLong)
  {
    AppMethodBeat.i(116954);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116954);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastPushCreateTime =  " + paramLong + " where username = \"" + bs.aLh(paramString) + "\"";
    boolean bool = this.hpA.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116954);
    return bool;
  }
  
  public final long b(z paramz)
  {
    AppMethodBeat.i(116945);
    if (paramz == null)
    {
      AppMethodBeat.o(116945);
      return -1L;
    }
    ContentValues localContentValues = paramz.convertTo();
    long l = this.hpA.update("ChatroomMsgSeq", localContentValues, "username = ?", new String[] { paramz.field_username });
    AppMethodBeat.o(116945);
    return l;
  }
  
  public final boolean dcu()
  {
    AppMethodBeat.i(116947);
    long l = this.hpA.delete("ChatroomMsgSeq", "", null);
    ac.w("MicroMsg.ChatroomMsgSeqStorage", "[deleteTable] result:" + l + " table:ChatroomMsgSeq");
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
    paramString = akS(paramString);
    if (paramString.fCc.size() <= 0)
    {
      AppMethodBeat.o(116960);
      return null;
    }
    paramString = paramString.fCc.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if (!paramBoolean)
      {
        if (localc.fCb > paramLong)
        {
          AppMethodBeat.o(116960);
          return localc;
        }
      }
      else if (localc.fCa > paramLong)
      {
        AppMethodBeat.o(116960);
        return localc;
      }
    }
    AppMethodBeat.o(116960);
    return null;
  }
  
  public final int y(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(116964);
    paramString = akV(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      ac.i("MicroMsg.ChatroomMsgSeqStorage", "[getBlockCount] seqBlockInfo is null!");
      AppMethodBeat.o(116964);
      return 0;
    }
    paramString = paramString.fCc.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if ((paramLong1 > localc.fCa) || (localc.fCb > paramLong2)) {
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
 * Qualified Name:     com.tencent.mm.storage.aa
 * JD-Core Version:    0.7.0.1
 */