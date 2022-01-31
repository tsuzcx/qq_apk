package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.j.a.a.c;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class x
  extends n
  implements b
{
  public static final String[] SQL_CREATE;
  private static final String[] yxa;
  private h fnw;
  
  static
  {
    AppMethodBeat.i(1101);
    SQL_CREATE = new String[] { j.getCreateSQLs(w.info, "ChatroomMsgSeq") };
    yxa = new String[] { "CREATE INDEX IF NOT EXISTS  ChatroomMsgSeqTalkerIndex ON ChatroomMsgSeq ( username )" };
    AppMethodBeat.o(1101);
  }
  
  public x(h paramh)
  {
    AppMethodBeat.i(1078);
    this.fnw = paramh;
    paramh.execSQL("ChatroomMsgSeq", yxa[0]);
    AppMethodBeat.o(1078);
  }
  
  public final long SQ(String paramString)
  {
    AppMethodBeat.i(1082);
    long l = this.fnw.delete("ChatroomMsgSeq", "username = ?", new String[] { paramString });
    AppMethodBeat.o(1082);
    return l;
  }
  
  public final long SR(String paramString)
  {
    AppMethodBeat.i(1084);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1084);
      return -1L;
    }
    Object localObject = "select lastPushSeq from ChatroomMsgSeq where username = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1084);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(1084);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1084);
    return -3L;
  }
  
  public final long SS(String paramString)
  {
    AppMethodBeat.i(1086);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1086);
      return -1L;
    }
    Object localObject = "select lastLocalSeq from ChatroomMsgSeq where username = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1086);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(1086);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1086);
    return -3L;
  }
  
  public final long ST(String paramString)
  {
    AppMethodBeat.i(1085);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1085);
      return -1L;
    }
    Object localObject = "select lastPushCreateTime from ChatroomMsgSeq where username = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1085);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(1085);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1085);
    return -3L;
  }
  
  public final long SU(String paramString)
  {
    AppMethodBeat.i(1087);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1087);
      return -1L;
    }
    Object localObject = "select lastLocalCreateTime from ChatroomMsgSeq where username = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1087);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(1087);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1087);
    return -3L;
  }
  
  public final d SV(String paramString)
  {
    AppMethodBeat.i(1092);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed username is null!");
      paramString = new d();
      AppMethodBeat.o(1092);
      return paramString;
    }
    Object localObject = "select seqBlockInfo from ChatroomMsgSeq where username = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.e("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed ".concat(String.valueOf(paramString)));
      paramString = new d();
      AppMethodBeat.o(1092);
      return paramString;
    }
    byte[] arrayOfByte;
    if (((Cursor)localObject).moveToFirst())
    {
      arrayOfByte = ((Cursor)localObject).getBlob(0);
      if (bo.ce(arrayOfByte))
      {
        ((Cursor)localObject).close();
        paramString = new d();
        AppMethodBeat.o(1092);
        return paramString;
      }
      paramString = new d();
    }
    try
    {
      paramString.parseFrom(arrayOfByte);
      label169:
      ((Cursor)localObject).close();
      AppMethodBeat.o(1092);
      return paramString;
      ((Cursor)localObject).close();
      paramString = new d();
      AppMethodBeat.o(1092);
      return paramString;
    }
    catch (Exception localException)
    {
      break label169;
    }
  }
  
  public final boolean SW(String paramString)
  {
    AppMethodBeat.i(1094);
    Object localObject = "select count(*) from ChatroomMsgSeq where username = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1094);
      return false;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      if (l > 0L)
      {
        AppMethodBeat.o(1094);
        return true;
      }
      AppMethodBeat.o(1094);
      return false;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1094);
    return false;
  }
  
  public final c SX(String paramString)
  {
    AppMethodBeat.i(1095);
    paramString = SV(paramString);
    if (paramString.elE.size() <= 0)
    {
      AppMethodBeat.o(1095);
      return null;
    }
    paramString = (c)paramString.elE.getLast();
    AppMethodBeat.o(1095);
    return paramString;
  }
  
  public final w SY(String paramString)
  {
    AppMethodBeat.i(1098);
    ab.i("MicroMsg.ChatroomMsgSeqStorage", "[getChatroomMsgSeq] username:%s", new Object[] { paramString });
    w localw = new w();
    paramString = "select * from ChatroomMsgSeq where username = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    paramString = this.fnw.a(paramString, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(1098);
      return localw;
    }
    if (paramString.moveToFirst()) {
      localw.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1098);
    return localw;
  }
  
  public final StringBuilder SZ(String paramString)
  {
    AppMethodBeat.i(1099);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = SY(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      AppMethodBeat.o(1099);
      return localStringBuilder;
    }
    paramString = paramString.elE.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      localStringBuilder.append("[").append(localc.elA).append(":").append(localc.elB).append("][").append(localc.elC).append(":").append(localc.elD).append("] | ");
    }
    AppMethodBeat.o(1099);
    return localStringBuilder;
  }
  
  public final boolean Y(String paramString, long paramLong)
  {
    AppMethodBeat.i(1088);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1088);
      return false;
    }
    Object localObject = "update ChatroomMsgSeq set lastPushSeq =  " + paramLong + " where username = \"" + bo.wC(paramString) + "\"";
    boolean bool = this.fnw.execSQL("ChatroomMsgSeq", (String)localObject);
    if (bool)
    {
      localObject = new b.a();
      ((b.a)localObject).id = 4;
      ((b.a)localObject).username = paramString;
      b(2, this, localObject);
    }
    AppMethodBeat.o(1088);
    return bool;
  }
  
  public final boolean Z(String paramString, long paramLong)
  {
    AppMethodBeat.i(1089);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1089);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalCreateTime =  " + paramLong + " where username = \"" + bo.wC(paramString) + "\"";
    boolean bool = this.fnw.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(1089);
    return bool;
  }
  
  public final long a(w paramw)
  {
    AppMethodBeat.i(1079);
    long l = a(paramw, false);
    AppMethodBeat.o(1079);
    return l;
  }
  
  public final long a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(1080);
    if (paramw == null)
    {
      AppMethodBeat.o(1080);
      return -1L;
    }
    Object localObject = paramw.convertTo();
    long l = this.fnw.a("ChatroomMsgSeq", "username", (ContentValues)localObject);
    if (l >= 0L)
    {
      localObject = new b.a();
      ((b.a)localObject).id = 4;
      ((b.a)localObject).username = paramw.field_username;
      ((b.a)localObject).oDK = paramBoolean;
      b(4, this, localObject);
    }
    AppMethodBeat.o(1080);
    return l;
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(1093);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.e("MicroMsg.ChatroomMsgSeqStorage", "updateSeqBlockInfo failed");
      AppMethodBeat.o(1093);
      return false;
    }
    Object localObject = new byte[0];
    try
    {
      paramd = paramd.toByteArray();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("seqBlockInfo", paramd);
      if (this.fnw.update("ChatroomMsgSeq", (ContentValues)localObject, "username = ?", new String[] { bo.wC(paramString) }) > 0)
      {
        AppMethodBeat.o(1093);
        return true;
      }
      AppMethodBeat.o(1093);
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
  
  public final boolean aa(String paramString, long paramLong)
  {
    AppMethodBeat.i(1090);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1090);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastPushCreateTime =  " + paramLong + " where username = \"" + bo.wC(paramString) + "\"";
    boolean bool = this.fnw.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(1090);
    return bool;
  }
  
  public final boolean ab(String paramString, long paramLong)
  {
    AppMethodBeat.i(1091);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1091);
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalSeq =  " + paramLong + " where username = \"" + bo.wC(paramString) + "\"";
    boolean bool = this.fnw.execSQL("ChatroomMsgSeq", paramString);
    AppMethodBeat.o(1091);
    return bool;
  }
  
  public final c ac(String paramString, long paramLong)
  {
    AppMethodBeat.i(1097);
    paramString = SV(paramString);
    if (paramString.elE.size() <= 0)
    {
      AppMethodBeat.o(1097);
      return null;
    }
    paramString = paramString.elE.listIterator(paramString.elE.size());
    while (paramString.hasPrevious())
    {
      c localc = (c)paramString.previous();
      if (localc.elC < paramLong)
      {
        AppMethodBeat.o(1097);
        return localc;
      }
    }
    AppMethodBeat.o(1097);
    return null;
  }
  
  public final boolean aqj()
  {
    return true;
  }
  
  public final long b(w paramw)
  {
    AppMethodBeat.i(1081);
    if (paramw == null)
    {
      AppMethodBeat.o(1081);
      return -1L;
    }
    ContentValues localContentValues = paramw.convertTo();
    long l = this.fnw.update("ChatroomMsgSeq", localContentValues, "username = ?", new String[] { paramw.field_username });
    AppMethodBeat.o(1081);
    return l;
  }
  
  public final boolean bPT()
  {
    AppMethodBeat.i(1083);
    long l = this.fnw.delete("ChatroomMsgSeq", "", null);
    ab.w("MicroMsg.ChatroomMsgSeqStorage", "[deleteTable] result:" + l + " table:ChatroomMsgSeq");
    if (l >= 0L)
    {
      AppMethodBeat.o(1083);
      return true;
    }
    AppMethodBeat.o(1083);
    return false;
  }
  
  public final c f(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(1096);
    paramString = SV(paramString);
    if (paramString.elE.size() <= 0)
    {
      AppMethodBeat.o(1096);
      return null;
    }
    paramString = paramString.elE.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if (!paramBoolean)
      {
        if (localc.elD > paramLong)
        {
          AppMethodBeat.o(1096);
          return localc;
        }
      }
      else if (localc.elC > paramLong)
      {
        AppMethodBeat.o(1096);
        return localc;
      }
    }
    AppMethodBeat.o(1096);
    return null;
  }
  
  public final int v(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(1100);
    paramString = SY(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      ab.i("MicroMsg.ChatroomMsgSeqStorage", "[getBlockCount] seqBlockInfo is null!");
      AppMethodBeat.o(1100);
      return 0;
    }
    paramString = paramString.elE.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if ((paramLong1 > localc.elC) || (localc.elD > paramLong2)) {
        break label107;
      }
      i += 1;
    }
    label107:
    for (;;)
    {
      break;
      AppMethodBeat.o(1100);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.x
 * JD-Core Version:    0.7.0.1
 */