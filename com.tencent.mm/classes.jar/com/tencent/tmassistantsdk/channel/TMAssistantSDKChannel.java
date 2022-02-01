package com.tencent.tmassistantsdk.channel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class TMAssistantSDKChannel
{
  public long AddDataItem(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, int paramInt3, byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(101862);
      paramString1 = new TMAssistantSDKChannelDataItem(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramLong1, paramLong2, paramInt3, paramArrayOfByte);
      paramLong1 = new DBOption().insert(paramString1);
      AppMethodBeat.o(101862);
      return paramLong1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public boolean delDataItem(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 36
    //   4: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: lload_1
    //   8: lconst_0
    //   9: lcmp
    //   10: ifge +14 -> 24
    //   13: iconst_0
    //   14: istore_3
    //   15: ldc 36
    //   17: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_3
    //   23: ireturn
    //   24: new 25	com/tencent/tmassistantsdk/channel/DBOption
    //   27: dup
    //   28: invokespecial 26	com/tencent/tmassistantsdk/channel/DBOption:<init>	()V
    //   31: lload_1
    //   32: invokevirtual 39	com/tencent/tmassistantsdk/channel/DBOption:delete	(J)Z
    //   35: istore_3
    //   36: ldc 36
    //   38: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -21 -> 20
    //   44: astore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	TMAssistantSDKChannel
    //   0	51	1	paramLong	long
    //   14	22	3	bool	boolean
    //   44	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   15	20	44	finally
    //   24	41	44	finally
  }
  
  public ArrayList<TMAssistantSDKChannelDataItem> getChannelDataItemList()
  {
    try
    {
      AppMethodBeat.i(101861);
      ArrayList localArrayList = new DBOption().queryAll();
      AppMethodBeat.o(101861);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel
 * JD-Core Version:    0.7.0.1
 */