package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.h.a.a.c;
import com.tencent.mm.h.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class am
  extends MStorageEx
  implements b
{
  public static final String[] SQL_CREATE;
  private static final String[] acGS;
  private h omV;
  
  static
  {
    AppMethodBeat.i(116965);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(al.info, "ChatroomMsgSeq") };
    acGS = new String[] { "CREATE INDEX IF NOT EXISTS  ChatroomMsgSeqTalkerIndex ON ChatroomMsgSeq ( username )" };
    AppMethodBeat.o(116965);
  }
  
  public am(h paramh)
  {
    AppMethodBeat.i(116942);
    this.omV = paramh;
    paramh.execSQL("ChatroomMsgSeq", acGS[0]);
    AppMethodBeat.o(116942);
  }
  
  public final int E(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(116964);
    paramString = aLq(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      Log.i("MicroMsg.ChatroomMsgSeqStorage", "[getBlockCount] seqBlockInfo is null!");
      AppMethodBeat.o(116964);
      return 0;
    }
    paramString = paramString.lPT.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if ((paramLong1 > localc.lPR) || (localc.lPS > paramLong2)) {
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
  
  public final long a(al paramal)
  {
    AppMethodBeat.i(116943);
    long l = a(paramal, false);
    AppMethodBeat.o(116943);
    return l;
  }
  
  public final long a(al paramal, boolean paramBoolean)
  {
    AppMethodBeat.i(116944);
    if (paramal == null)
    {
      AppMethodBeat.o(116944);
      return -1L;
    }
    Object localObject = paramal.convertTo();
    long l = this.omV.a("ChatroomMsgSeq", "username", (ContentValues)localObject, false);
    if (l >= 0L)
    {
      localObject = new b.a();
      ((b.a)localObject).id = 4;
      ((b.a)localObject).username = paramal.field_username;
      ((b.a)localObject).KRh = paramBoolean;
      doNotify(4, this, localObject);
    }
    AppMethodBeat.o(116944);
    return l;
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(116957);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.e("MicroMsg.ChatroomMsgSeqStorage", "updateSeqBlockInfo failed");
      AppMethodBeat.o(116957);
      return false;
    }
    Object localObject = new byte[0];
    try
    {
      paramd = paramd.toByteArray();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("seqBlockInfo", paramd);
      if (this.omV.update("ChatroomMsgSeq", (ContentValues)localObject, "username = ?", new String[] { Util.escapeSqlValue(paramString) }) > 0)
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
  
  public final long aLi(String paramString)
  {
    AppMethodBeat.i(116946);
    long l = this.omV.delete("ChatroomMsgSeq", "username = ?", new String[] { paramString });
    AppMethodBeat.o(116946);
    return l;
  }
  
  public final long aLj(String paramString)
  {
    AppMethodBeat.i(116948);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116948);
      return -1L;
    }
    Object localObject = "select lastPushSeq from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      Log.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final long aLk(String paramString)
  {
    AppMethodBeat.i(116950);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116950);
      return -1L;
    }
    Object localObject = "select lastLocalSeq from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      Log.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final long aLl(String paramString)
  {
    AppMethodBeat.i(116949);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116949);
      return -1L;
    }
    Object localObject = "select lastPushCreateTime from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      Log.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final long aLm(String paramString)
  {
    AppMethodBeat.i(116951);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116951);
      return -1L;
    }
    Object localObject = "select lastLocalCreateTime from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      Log.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final d aLn(String paramString)
  {
    AppMethodBeat.i(116956);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed username is null!");
      paramString = new d();
      AppMethodBeat.o(116956);
      return paramString;
    }
    Object localObject = "select seqBlockInfo from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      Log.e("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed ".concat(String.valueOf(paramString)));
      paramString = new d();
      AppMethodBeat.o(116956);
      return paramString;
    }
    byte[] arrayOfByte;
    if (((Cursor)localObject).moveToFirst())
    {
      arrayOfByte = ((Cursor)localObject).getBlob(0);
      if (Util.isNullOrNil(arrayOfByte))
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
  
  public final boolean aLo(String paramString)
  {
    AppMethodBeat.i(116958);
    Object localObject = "select count(*) from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      Log.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
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
  
  public final c aLp(String paramString)
  {
    AppMethodBeat.i(116959);
    paramString = aLn(paramString);
    if ((paramString == null) || (paramString.lPT.size() <= 0))
    {
      AppMethodBeat.o(116959);
      return null;
    }
    paramString = (c)paramString.lPT.getLast();
    AppMethodBeat.o(116959);
    return paramString;
  }
  
  public final al aLq(String paramString)
  {
    AppMethodBeat.i(116962);
    Log.i("MicroMsg.ChatroomMsgSeqStorage", "[getChatroomMsgSeq] username:%s", new Object[] { paramString });
    al localal = new al();
    paramString = "select * from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    paramString = this.omV.rawQuery(paramString, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(116962);
      return localal;
    }
    if (paramString.moveToFirst()) {
      localal.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(116962);
    return localal;
  }
  
  public final StringBuilder aLr(String paramString)
  {
    AppMethodBeat.i(116963);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = aLq(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      AppMethodBeat.o(116963);
      return localStringBuilder;
    }
    paramString = paramString.lPT.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      localStringBuilder.append("[").append(localc.lPP).append(":").append(localc.lPQ).append("][").append(localc.lPR).append(":").append(localc.lPS).append("] | ");
    }
    AppMethodBeat.o(116963);
    return localStringBuilder;
  }
  
  public final boolean aM(String paramString, long paramLong)
  {
    AppMethodBeat.i(116952);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116952);
      return false;
    }
    Object localObject = "update ChatroomMsgSeq set lastPushSeq =  " + paramLong + " where username = \"" + Util.escapeSqlValue(paramString) + "\"";
    boolean bool = this.omV.execSQL("ChatroomMsgSeq", (String)localObject);
    if (bool)
    {
      localObject = new b.a();
      ((b.a)localObject).id = 4;
      ((b.a)localObject).username = paramString;
      doNotify(2, this, localObject);
    }
    AppMethodBeat.o(116952);
    return bool;
  }
  
  public final boolean aN(String paramString, long paramLong)
  {
    AppMethodBeat.i(116953);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116953);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalCreateTime =  " + paramLong + " where username = \"" + Util.escapeSqlValue(paramString) + "\"";
    boolean bool = this.omV.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116953);
    return bool;
  }
  
  public final boolean aO(String paramString, long paramLong)
  {
    AppMethodBeat.i(116954);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116954);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastPushCreateTime =  " + paramLong + " where username = \"" + Util.escapeSqlValue(paramString) + "\"";
    boolean bool = this.omV.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116954);
    return bool;
  }
  
  public final boolean aP(String paramString, long paramLong)
  {
    AppMethodBeat.i(116955);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116955);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalSeq =  " + paramLong + " where username = \"" + Util.escapeSqlValue(paramString) + "\"";
    boolean bool = this.omV.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(116955);
    return bool;
  }
  
  public final c aQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(116961);
    paramString = aLn(paramString);
    if ((paramString == null) || (paramString.lPT.size() <= 0))
    {
      AppMethodBeat.o(116961);
      return null;
    }
    paramString = paramString.lPT.listIterator(paramString.lPT.size());
    while (paramString.hasPrevious())
    {
      c localc = (c)paramString.previous();
      if (localc.lPR < paramLong)
      {
        AppMethodBeat.o(116961);
        return localc;
      }
    }
    AppMethodBeat.o(116961);
    return null;
  }
  
  public final long b(al paramal)
  {
    AppMethodBeat.i(116945);
    if (paramal == null)
    {
      AppMethodBeat.o(116945);
      return -1L;
    }
    ContentValues localContentValues = paramal.convertTo();
    long l = this.omV.update("ChatroomMsgSeq", localContentValues, "username = ?", new String[] { paramal.field_username });
    AppMethodBeat.o(116945);
    return l;
  }
  
  public final c d(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(116960);
    paramString = aLn(paramString);
    if ((paramString == null) || (paramString.lPT.size() <= 0))
    {
      AppMethodBeat.o(116960);
      return null;
    }
    paramString = paramString.lPT.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if (!paramBoolean)
      {
        if (localc.lPS > paramLong)
        {
          AppMethodBeat.o(116960);
          return localc;
        }
      }
      else if (localc.lPR > paramLong)
      {
        AppMethodBeat.o(116960);
        return localc;
      }
    }
    AppMethodBeat.o(116960);
    return null;
  }
  
  public final boolean gbb()
  {
    AppMethodBeat.i(116947);
    long l = this.omV.delete("ChatroomMsgSeq", "", null);
    Log.w("MicroMsg.ChatroomMsgSeqStorage", "[deleteTable] result:" + l + " table:ChatroomMsgSeq");
    if (l >= 0L)
    {
      AppMethodBeat.o(116947);
      return true;
    }
    AppMethodBeat.o(116947);
    return false;
  }
  
  public final boolean shouldProcessEvent()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.am
 * JD-Core Version:    0.7.0.1
 */