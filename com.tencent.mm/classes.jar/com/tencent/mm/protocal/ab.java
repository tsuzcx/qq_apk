package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class ab
{
  private static Map<Integer, Long> bR(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58880);
    if (bo.ce(paramArrayOfByte))
    {
      AppMethodBeat.o(58880);
      return null;
    }
    try
    {
      paramArrayOfByte = (cja)new cja().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        AppMethodBeat.o(58880);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(58880);
      return null;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + paramArrayOfByte.xNb);
    LinkedList localLinkedList = paramArrayOfByte.xNc;
    if (localLinkedList.size() != paramArrayOfByte.xNb)
    {
      AppMethodBeat.o(58880);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.xNb)
    {
      localHashMap.put(Integer.valueOf(((azb)localLinkedList.get(i)).qsk), Long.valueOf(0xFFFFFFFF & ((azb)localLinkedList.get(i)).xoy));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.xNb)
    {
      AppMethodBeat.o(58880);
      return null;
    }
    AppMethodBeat.o(58880);
    return localHashMap;
  }
  
  public static String bS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58881);
    if (bo.ce(paramArrayOfByte))
    {
      AppMethodBeat.o(58881);
      return "";
    }
    paramArrayOfByte = bR(paramArrayOfByte);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
    {
      AppMethodBeat.o(58881);
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
    AppMethodBeat.o(58881);
    return paramArrayOfByte;
  }
  
  public static byte[] j(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(58879);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
      AppMethodBeat.o(58879);
      return paramArrayOfByte2;
    }
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SyncKeyUtil", "newKey is null");
      AppMethodBeat.o(58879);
      return null;
    }
    PByteArray localPByteArray = new PByteArray();
    try
    {
      if (!MMProtocalJni.mergeSyncKey(paramArrayOfByte1, paramArrayOfByte2, localPByteArray))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SyncKeyUtil", "merge key failed");
        AppMethodBeat.o(58879);
        return null;
      }
    }
    catch (IncompatibleClassChangeError paramArrayOfByte1)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.Crash", paramArrayOfByte1, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
      paramArrayOfByte1 = (IncompatibleClassChangeError)new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(paramArrayOfByte1);
      AppMethodBeat.o(58879);
      throw paramArrayOfByte1;
    }
    paramArrayOfByte1 = localPByteArray.value;
    AppMethodBeat.o(58879);
    return paramArrayOfByte1;
  }
  
  public static boolean k(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(58882);
    paramArrayOfByte1 = bR(paramArrayOfByte1);
    if (paramArrayOfByte1 == null)
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
      AppMethodBeat.o(58882);
      return true;
    }
    paramArrayOfByte2 = bR(paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
      AppMethodBeat.o(58882);
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
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SyncKeyUtil", "dkpush local key null :".concat(String.valueOf(localInteger)));
        AppMethodBeat.o(58882);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + localInteger + " sv:" + localLong2 + " lv:" + localLong1);
      if (localLong2.longValue() > localLong1.longValue())
      {
        AppMethodBeat.o(58882);
        return true;
      }
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
    AppMethodBeat.o(58882);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.ab
 * JD-Core Version:    0.7.0.1
 */