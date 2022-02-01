package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.fkx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class ad
{
  private static Map<Integer, Long> dd(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133139);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      AppMethodBeat.o(133139);
      return null;
    }
    try
    {
      paramArrayOfByte = (fkx)new fkx().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        AppMethodBeat.o(133139);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(133139);
      return null;
    }
    Log.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + paramArrayOfByte.abBY);
    LinkedList localLinkedList = paramArrayOfByte.abBZ;
    if (localLinkedList.size() != paramArrayOfByte.abBY)
    {
      AppMethodBeat.o(133139);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.abBY)
    {
      localHashMap.put(Integer.valueOf(((dfw)localLinkedList.get(i)).OzG), Long.valueOf(0xFFFFFFFF & ((dfw)localLinkedList.get(i)).aaLu));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.abBY)
    {
      AppMethodBeat.o(133139);
      return null;
    }
    AppMethodBeat.o(133139);
    return localHashMap;
  }
  
  public static String de(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133140);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      AppMethodBeat.o(133140);
      return "";
    }
    paramArrayOfByte = dd(paramArrayOfByte);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
    {
      AppMethodBeat.o(133140);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" MsgKey:" + paramArrayOfByte.get(Integer.valueOf(2)));
    localStringBuffer.append(" profile:" + paramArrayOfByte.get(Integer.valueOf(1)));
    localStringBuffer.append(" contact:" + paramArrayOfByte.get(Integer.valueOf(3)));
    localStringBuffer.append(" chatroom:" + paramArrayOfByte.get(Integer.valueOf(11)));
    localStringBuffer.append(" Bottle:" + paramArrayOfByte.get(Integer.valueOf(7)));
    localStringBuffer.append(" QContact:" + paramArrayOfByte.get(Integer.valueOf(5)));
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(133140);
    return paramArrayOfByte;
  }
  
  public static byte[] o(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(133138);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0))
    {
      Log.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
      AppMethodBeat.o(133138);
      return paramArrayOfByte2;
    }
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0))
    {
      Log.e("MicroMsg.SyncKeyUtil", "newKey is null");
      AppMethodBeat.o(133138);
      return null;
    }
    PByteArray localPByteArray = new PByteArray();
    try
    {
      if (!MMProtocalJni.mergeSyncKey(paramArrayOfByte1, paramArrayOfByte2, localPByteArray))
      {
        Log.e("MicroMsg.SyncKeyUtil", "merge key failed");
        AppMethodBeat.o(133138);
        return null;
      }
    }
    catch (IncompatibleClassChangeError paramArrayOfByte1)
    {
      Log.printErrStackTrace("MicroMsg.Crash", paramArrayOfByte1, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
      paramArrayOfByte1 = (IncompatibleClassChangeError)new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(paramArrayOfByte1);
      AppMethodBeat.o(133138);
      throw paramArrayOfByte1;
    }
    paramArrayOfByte1 = localPByteArray.value;
    AppMethodBeat.o(133138);
    return paramArrayOfByte1;
  }
  
  public static boolean p(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(133141);
    paramArrayOfByte1 = dd(paramArrayOfByte1);
    if (paramArrayOfByte1 == null)
    {
      Log.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
      AppMethodBeat.o(133141);
      return true;
    }
    paramArrayOfByte2 = dd(paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      Log.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
      AppMethodBeat.o(133141);
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
        Log.d("MicroMsg.SyncKeyUtil", "dkpush local key null :".concat(String.valueOf(localInteger)));
        AppMethodBeat.o(133141);
        return true;
      }
      Log.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + localInteger + " sv:" + localLong2 + " lv:" + localLong1);
      if (localLong2.longValue() > localLong1.longValue())
      {
        AppMethodBeat.o(133141);
        return true;
      }
    }
    Log.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
    AppMethodBeat.o(133141);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.ad
 * JD-Core Version:    0.7.0.1
 */