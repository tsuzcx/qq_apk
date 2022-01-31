package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.k.a.a.c;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class x
  extends m
  implements b
{
  public static final String[] dXp = { i.a(w.buS, "ChatroomMsgSeq") };
  private static final String[] uno = { "CREATE INDEX IF NOT EXISTS  ChatroomMsgSeqTalkerIndex ON ChatroomMsgSeq ( username )" };
  private h dXo;
  
  public x(h paramh)
  {
    this.dXo = paramh;
    paramh.gk("ChatroomMsgSeq", uno[0]);
  }
  
  public final boolean G(String paramString, long paramLong)
  {
    boolean bool1;
    if (bk.bl(paramString)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      localObject = "update ChatroomMsgSeq set lastPushSeq =  " + paramLong + " where username = \"" + bk.pl(paramString) + "\"";
      bool2 = this.dXo.gk("ChatroomMsgSeq", (String)localObject);
      bool1 = bool2;
    } while (!bool2);
    Object localObject = new b.a();
    ((b.a)localObject).id = 4;
    ((b.a)localObject).username = paramString;
    b(2, this, localObject);
    return bool2;
  }
  
  public final boolean H(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalCreateTime =  " + paramLong + " where username = \"" + bk.pl(paramString) + "\"";
    return this.dXo.gk("ChatroomMsgSeq", paramString);
  }
  
  public final long He(String paramString)
  {
    return this.dXo.delete("ChatroomMsgSeq", "username = ?", new String[] { paramString });
  }
  
  public final long Hf(String paramString)
  {
    if (bk.bl(paramString)) {
      return -1L;
    }
    Object localObject = "select lastPushSeq from ChatroomMsgSeq where username = \"" + bk.pl(paramString) + "\"";
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed " + paramString);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      return l;
    }
    ((Cursor)localObject).close();
    return -3L;
  }
  
  public final long Hg(String paramString)
  {
    if (bk.bl(paramString)) {
      return -1L;
    }
    Object localObject = "select lastLocalSeq from ChatroomMsgSeq where username = \"" + bk.pl(paramString) + "\"";
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed " + paramString);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      return l;
    }
    ((Cursor)localObject).close();
    return -3L;
  }
  
  public final long Hh(String paramString)
  {
    if (bk.bl(paramString)) {
      return -1L;
    }
    Object localObject = "select lastPushCreateTime from ChatroomMsgSeq where username = \"" + bk.pl(paramString) + "\"";
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed " + paramString);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      return l;
    }
    ((Cursor)localObject).close();
    return -3L;
  }
  
  public final long Hi(String paramString)
  {
    if (bk.bl(paramString)) {
      return -1L;
    }
    Object localObject = "select lastLocalCreateTime from ChatroomMsgSeq where username = \"" + bk.pl(paramString) + "\"";
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed " + paramString);
      return -2L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      return l;
    }
    ((Cursor)localObject).close();
    return -3L;
  }
  
  public final d Hj(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed username is null!");
      return new d();
    }
    Object localObject = "select seqBlockInfo from ChatroomMsgSeq where username = \"" + bk.pl(paramString) + "\"";
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.e("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed " + paramString);
      return new d();
    }
    byte[] arrayOfByte;
    if (((Cursor)localObject).moveToFirst())
    {
      arrayOfByte = ((Cursor)localObject).getBlob(0);
      if (bk.bE(arrayOfByte))
      {
        ((Cursor)localObject).close();
        return new d();
      }
      paramString = new d();
    }
    try
    {
      paramString.aH(arrayOfByte);
      label143:
      ((Cursor)localObject).close();
      return paramString;
      ((Cursor)localObject).close();
      return new d();
    }
    catch (Exception localException)
    {
      break label143;
    }
  }
  
  public final boolean Hk(String paramString)
  {
    Object localObject = "select count(*) from ChatroomMsgSeq where username = \"" + bk.pl(paramString) + "\"";
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null) {
      y.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed " + paramString);
    }
    long l;
    do
    {
      return false;
      if (!((Cursor)localObject).moveToFirst()) {
        break;
      }
      l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
    } while (l <= 0L);
    return true;
    ((Cursor)localObject).close();
    return false;
  }
  
  public final c Hl(String paramString)
  {
    paramString = Hj(paramString);
    if (paramString.dtR.size() <= 0) {
      return null;
    }
    return (c)paramString.dtR.getLast();
  }
  
  public final w Hm(String paramString)
  {
    y.i("MicroMsg.ChatroomMsgSeqStorage", "[getChatroomMsgSeq] username:%s", new Object[] { paramString });
    w localw = new w();
    paramString = "select * from ChatroomMsgSeq where username = \"" + bk.pl(paramString) + "\"";
    paramString = this.dXo.a(paramString, null, 2);
    if (paramString == null) {
      return localw;
    }
    if (paramString.moveToFirst()) {
      localw.d(paramString);
    }
    paramString.close();
    return localw;
  }
  
  public final StringBuilder Hn(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = Hm(paramString).field_seqBlockInfo;
    if (paramString == null) {
      return localStringBuilder;
    }
    paramString = paramString.dtR.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      localStringBuilder.append("[").append(localc.dtN).append(":").append(localc.dtO).append("][").append(localc.dtP).append(":").append(localc.dtQ).append("] | ");
    }
    return localStringBuilder;
  }
  
  public final boolean I(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastPushCreateTime =  " + paramLong + " where username = \"" + bk.pl(paramString) + "\"";
    return this.dXo.gk("ChatroomMsgSeq", paramString);
  }
  
  public final boolean J(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    paramString = "update ChatroomMsgSeq set lastLocalSeq =  " + paramLong + " where username = \"" + bk.pl(paramString) + "\"";
    return this.dXo.gk("ChatroomMsgSeq", paramString);
  }
  
  public final c K(String paramString, long paramLong)
  {
    paramString = Hj(paramString);
    if (paramString.dtR.size() <= 0) {
      return null;
    }
    paramString = paramString.dtR.listIterator(paramString.dtR.size());
    while (paramString.hasPrevious())
    {
      c localc = (c)paramString.previous();
      if (localc.dtP < paramLong) {
        return localc;
      }
    }
    return null;
  }
  
  protected final boolean WH()
  {
    return true;
  }
  
  public final long a(w paramw)
  {
    return a(paramw, false);
  }
  
  public final long a(w paramw, boolean paramBoolean)
  {
    long l1;
    if (paramw == null) {
      l1 = -1L;
    }
    long l2;
    do
    {
      return l1;
      localObject = paramw.vf();
      l2 = this.dXo.a("ChatroomMsgSeq", "username", (ContentValues)localObject, false);
      l1 = l2;
    } while (l2 < 0L);
    Object localObject = new b.a();
    ((b.a)localObject).id = 4;
    ((b.a)localObject).username = paramw.field_username;
    ((b.a)localObject).mdo = paramBoolean;
    b(4, this, localObject);
    return l2;
  }
  
  public final boolean a(String paramString, d paramd)
  {
    if ((paramString == null) || (paramString.length() <= 0))
    {
      y.e("MicroMsg.ChatroomMsgSeqStorage", "updateSeqBlockInfo failed");
      return false;
    }
    Object localObject = new byte[0];
    try
    {
      paramd = paramd.toByteArray();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("seqBlockInfo", paramd);
      return this.dXo.update("ChatroomMsgSeq", (ContentValues)localObject, "username = ?", new String[] { bk.pl(paramString) }) > 0;
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        paramd = (d)localObject;
      }
    }
  }
  
  public final long b(w paramw)
  {
    if (paramw == null) {
      return -1L;
    }
    ContentValues localContentValues = paramw.vf();
    return this.dXo.update("ChatroomMsgSeq", localContentValues, "username = ?", new String[] { paramw.field_username });
  }
  
  public final boolean bhR()
  {
    long l = this.dXo.delete("ChatroomMsgSeq", "", null);
    y.w("MicroMsg.ChatroomMsgSeqStorage", "[deleteTable] result:" + l + " table:ChatroomMsgSeq");
    return l >= 0L;
  }
  
  public final c f(String paramString, long paramLong, boolean paramBoolean)
  {
    paramString = Hj(paramString);
    if (paramString.dtR.size() <= 0) {
      return null;
    }
    paramString = paramString.dtR.iterator();
    while (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if (!paramBoolean)
      {
        if (localc.dtQ > paramLong) {
          return localc;
        }
      }
      else if (localc.dtP > paramLong) {
        return localc;
      }
    }
    return null;
  }
  
  public final int o(String paramString, long paramLong1, long paramLong2)
  {
    paramString = Hm(paramString).field_seqBlockInfo;
    if (paramString == null)
    {
      y.i("MicroMsg.ChatroomMsgSeqStorage", "[getBlockCount] seqBlockInfo is null!");
      return 0;
    }
    paramString = paramString.dtR.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      c localc = (c)paramString.next();
      if ((paramLong1 > localc.dtP) || (localc.dtQ > paramLong2)) {
        break label89;
      }
      i += 1;
    }
    label89:
    for (;;)
    {
      break;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.x
 * JD-Core Version:    0.7.0.1
 */