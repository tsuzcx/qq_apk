package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.ata;
import com.tencent.mm.protocal.c.bwr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class z
{
  private static Map<Integer, Long> bq(byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte)) {
      return null;
    }
    try
    {
      paramArrayOfByte = (bwr)new bwr().aH(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    y.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + paramArrayOfByte.tIN);
    LinkedList localLinkedList = paramArrayOfByte.tIO;
    if (localLinkedList.size() != paramArrayOfByte.tIN) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.tIN)
    {
      localHashMap.put(Integer.valueOf(((ata)localLinkedList.get(i)).nFi), Long.valueOf(0xFFFFFFFF & ((ata)localLinkedList.get(i)).toF));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.tIN) {
      return null;
    }
    return localHashMap;
  }
  
  public static String br(byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte)) {
      return "";
    }
    paramArrayOfByte = bq(paramArrayOfByte);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" MsgKey:" + paramArrayOfByte.get(Integer.valueOf(2)));
    localStringBuffer.append(" profile:" + paramArrayOfByte.get(Integer.valueOf(1)));
    localStringBuffer.append(" contact:" + paramArrayOfByte.get(Integer.valueOf(3)));
    localStringBuffer.append(" chatroom:" + paramArrayOfByte.get(Integer.valueOf(11)));
    localStringBuffer.append(" Bottle:" + paramArrayOfByte.get(Integer.valueOf(7)));
    localStringBuffer.append(" QContact:" + paramArrayOfByte.get(Integer.valueOf(5)));
    return localStringBuffer.toString();
  }
  
  public static byte[] g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0))
    {
      y.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
      return paramArrayOfByte2;
    }
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0))
    {
      y.e("MicroMsg.SyncKeyUtil", "newKey is null");
      return null;
    }
    PByteArray localPByteArray = new PByteArray();
    try
    {
      if (!MMProtocalJni.mergeSyncKey(paramArrayOfByte1, paramArrayOfByte2, localPByteArray))
      {
        y.e("MicroMsg.SyncKeyUtil", "merge key failed");
        return null;
      }
    }
    catch (IncompatibleClassChangeError paramArrayOfByte1)
    {
      y.printErrStackTrace("MicroMsg.Crash", paramArrayOfByte1, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
      throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(paramArrayOfByte1));
    }
    return localPByteArray.value;
  }
  
  public static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = bq(paramArrayOfByte1);
    if (paramArrayOfByte1 == null)
    {
      y.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
      return true;
    }
    paramArrayOfByte2 = bq(paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      y.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
      return false;
    }
    Iterator localIterator = paramArrayOfByte2.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      Long localLong1 = (Long)paramArrayOfByte1.get(localInteger);
      Long localLong2 = (Long)paramArrayOfByte2.get(localInteger);
      if (localLong1 == null)
      {
        y.d("MicroMsg.SyncKeyUtil", "dkpush local key null :" + localInteger);
        return true;
      }
      y.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + localInteger + " sv:" + localLong2 + " lv:" + localLong1);
      if (localLong2.longValue() > localLong1.longValue()) {
        return true;
      }
    }
    y.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.z
 * JD-Core Version:    0.7.0.1
 */