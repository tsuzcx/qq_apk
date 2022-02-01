package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.dmh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class ad
{
  private static Map<Integer, Long> cs(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133139);
    if (bu.cF(paramArrayOfByte))
    {
      AppMethodBeat.o(133139);
      return null;
    }
    try
    {
      paramArrayOfByte = (dmh)new dmh().parseFrom(paramArrayOfByte);
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
    ae.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + paramArrayOfByte.HMk);
    LinkedList localLinkedList = paramArrayOfByte.HMl;
    if (localLinkedList.size() != paramArrayOfByte.HMk)
    {
      AppMethodBeat.o(133139);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.HMk)
    {
      localHashMap.put(Integer.valueOf(((btl)localLinkedList.get(i)).yxe), Long.valueOf(0xFFFFFFFF & ((btl)localLinkedList.get(i)).HgL));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.HMk)
    {
      AppMethodBeat.o(133139);
      return null;
    }
    AppMethodBeat.o(133139);
    return localHashMap;
  }
  
  public static String ct(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133140);
    if (bu.cF(paramArrayOfByte))
    {
      AppMethodBeat.o(133140);
      return "";
    }
    paramArrayOfByte = cs(paramArrayOfByte);
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
  
  public static byte[] l(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(133138);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0))
    {
      ae.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
      AppMethodBeat.o(133138);
      return paramArrayOfByte2;
    }
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0))
    {
      ae.e("MicroMsg.SyncKeyUtil", "newKey is null");
      AppMethodBeat.o(133138);
      return null;
    }
    PByteArray localPByteArray = new PByteArray();
    try
    {
      if (!MMProtocalJni.mergeSyncKey(paramArrayOfByte1, paramArrayOfByte2, localPByteArray))
      {
        ae.e("MicroMsg.SyncKeyUtil", "merge key failed");
        AppMethodBeat.o(133138);
        return null;
      }
    }
    catch (IncompatibleClassChangeError paramArrayOfByte1)
    {
      ae.printErrStackTrace("MicroMsg.Crash", paramArrayOfByte1, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
      paramArrayOfByte1 = (IncompatibleClassChangeError)new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(paramArrayOfByte1);
      AppMethodBeat.o(133138);
      throw paramArrayOfByte1;
    }
    paramArrayOfByte1 = localPByteArray.value;
    AppMethodBeat.o(133138);
    return paramArrayOfByte1;
  }
  
  public static boolean m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(133141);
    paramArrayOfByte1 = cs(paramArrayOfByte1);
    if (paramArrayOfByte1 == null)
    {
      ae.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
      AppMethodBeat.o(133141);
      return true;
    }
    paramArrayOfByte2 = cs(paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      ae.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
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
        ae.d("MicroMsg.SyncKeyUtil", "dkpush local key null :".concat(String.valueOf(localInteger)));
        AppMethodBeat.o(133141);
        return true;
      }
      ae.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + localInteger + " sv:" + localLong2 + " lv:" + localLong1);
      if (localLong2.longValue() > localLong1.longValue())
      {
        AppMethodBeat.o(133141);
        return true;
      }
    }
    ae.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
    AppMethodBeat.o(133141);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.ad
 * JD-Core Version:    0.7.0.1
 */