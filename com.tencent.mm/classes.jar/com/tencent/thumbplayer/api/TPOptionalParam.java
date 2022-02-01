package com.tencent.thumbplayer.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPOptionalParam
{
  public static final int TP_OPTIONAL_PARAM_TYPE_BOOLEAN = 1;
  public static final int TP_OPTIONAL_PARAM_TYPE_FLOAT = 6;
  public static final int TP_OPTIONAL_PARAM_TYPE_INT = 7;
  public static final int TP_OPTIONAL_PARAM_TYPE_LONG = 2;
  public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_INT = 4;
  public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_STRING = 5;
  public static final int TP_OPTIONAL_PARAM_TYPE_STRING = 3;
  public static final int TP_OPTIONAL_PARAM_TYPE_UNKNOWN = -1;
  @TPCommonEnum.TPOptionalId
  private int key;
  private OptionalParamBoolean paramBoolean;
  private OptionalParamFloat paramFloat;
  private OptionalParamInt paramInt;
  private OptionalParamLong paramLong;
  private OptionalParamQueueInt paramQueueInt;
  private OptionalParamQueueString paramQueueString;
  private OptionalParamString paramString;
  private int paramType = -1;
  
  public TPOptionalParam buildBoolean(@TPCommonEnum.TPOptionalId int paramInt1, boolean paramBoolean1)
  {
    AppMethodBeat.i(228378);
    this.paramType = 1;
    this.key = paramInt1;
    this.paramBoolean = new OptionalParamBoolean();
    this.paramBoolean.value = paramBoolean1;
    AppMethodBeat.o(228378);
    return this;
  }
  
  public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int paramInt1, float paramFloat1)
  {
    AppMethodBeat.i(228391);
    this.paramType = 6;
    this.key = paramInt1;
    this.paramFloat = new OptionalParamFloat();
    this.paramFloat.value = paramFloat1;
    AppMethodBeat.o(228391);
    return this;
  }
  
  public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(228399);
    this.paramType = 6;
    this.key = paramInt1;
    this.paramFloat = new OptionalParamFloat();
    this.paramFloat.value = paramFloat1;
    this.paramFloat.param1 = paramFloat2;
    this.paramFloat.param2 = paramFloat3;
    AppMethodBeat.o(228399);
    return this;
  }
  
  public TPOptionalParam buildInt(@TPCommonEnum.TPOptionalId int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228403);
    this.paramType = 7;
    this.key = paramInt1;
    this.paramInt = new OptionalParamInt();
    this.paramInt.value = paramInt2;
    AppMethodBeat.o(228403);
    return this;
  }
  
  public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int paramInt1, long paramLong1)
  {
    AppMethodBeat.i(228382);
    this.paramType = 2;
    this.key = paramInt1;
    this.paramLong = new OptionalParamLong();
    this.paramLong.value = paramLong1;
    AppMethodBeat.o(228382);
    return this;
  }
  
  public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int paramInt1, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(228387);
    this.paramType = 2;
    this.key = paramInt1;
    this.paramLong = new OptionalParamLong();
    this.paramLong.value = paramLong1;
    this.paramLong.param1 = paramLong2;
    this.paramLong.param2 = paramLong3;
    AppMethodBeat.o(228387);
    return this;
  }
  
  public TPOptionalParam buildQueueInt(@TPCommonEnum.TPOptionalId int paramInt1, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(228408);
    this.paramType = 4;
    this.key = paramInt1;
    this.paramQueueInt = new OptionalParamQueueInt();
    this.paramQueueInt.queueValue = paramArrayOfInt;
    AppMethodBeat.o(228408);
    return this;
  }
  
  public TPOptionalParam buildQueueString(@TPCommonEnum.TPOptionalId int paramInt1, String[] paramArrayOfString)
  {
    AppMethodBeat.i(228413);
    this.paramType = 5;
    this.key = paramInt1;
    this.paramQueueString = new OptionalParamQueueString();
    this.paramQueueString.queueValue = paramArrayOfString;
    AppMethodBeat.o(228413);
    return this;
  }
  
  public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int paramInt1, String paramString1)
  {
    AppMethodBeat.i(228418);
    this.paramType = 3;
    this.key = paramInt1;
    this.paramString = new OptionalParamString();
    this.paramString.value = paramString1;
    AppMethodBeat.o(228418);
    return this;
  }
  
  public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int paramInt1, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(228421);
    this.paramType = 3;
    this.key = paramInt1;
    this.paramString = new OptionalParamString();
    this.paramString.value = paramString1;
    this.paramString.param1 = paramString2;
    this.paramString.param2 = paramString3;
    AppMethodBeat.o(228421);
    return this;
  }
  
  @TPCommonEnum.TPOptionalId
  public int getKey()
  {
    return this.key;
  }
  
  public OptionalParamBoolean getParamBoolean()
  {
    return this.paramBoolean;
  }
  
  public OptionalParamFloat getParamFloat()
  {
    return this.paramFloat;
  }
  
  public OptionalParamInt getParamInt()
  {
    return this.paramInt;
  }
  
  public OptionalParamLong getParamLong()
  {
    return this.paramLong;
  }
  
  public OptionalParamQueueInt getParamQueueInt()
  {
    return this.paramQueueInt;
  }
  
  public OptionalParamQueueString getParamQueueString()
  {
    return this.paramQueueString;
  }
  
  public OptionalParamString getParamString()
  {
    return this.paramString;
  }
  
  public int getParamType()
  {
    return this.paramType;
  }
  
  public String toString()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(228442);
    Object localObject1 = new StringBuilder();
    switch (this.paramType)
    {
    default: 
      ((StringBuilder)localObject1).append("type:unknown");
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).toString();
      AppMethodBeat.o(228442);
      return localObject1;
      ((StringBuilder)localObject1).append("type:long, key:" + this.key + ", value:" + this.paramBoolean.value);
      continue;
      ((StringBuilder)localObject1).append("type:long, key:" + this.key + ", value:" + this.paramLong.value + ", param1:" + this.paramLong.param1 + ", param2:" + this.paramLong.param2);
      continue;
      ((StringBuilder)localObject1).append("type:float, key:" + this.key + ", value:" + this.paramFloat.value + ", param1:" + this.paramFloat.param1 + ", param2:" + this.paramFloat.param2);
      continue;
      ((StringBuilder)localObject1).append("type:int, key:" + this.key + ", value:" + this.paramInt.value);
      continue;
      ((StringBuilder)localObject1).append("type:string, key:" + this.key + ", value:" + this.paramString.value + ", param1:" + this.paramString.param1 + ", param2:" + this.paramString.param2);
      continue;
      ((StringBuilder)localObject1).append("type:quint_int, key:" + this.key + ", value:");
      if (this.paramQueueInt.queueValue != null)
      {
        Object localObject2 = this.paramQueueInt.queueValue;
        j = localObject2.length;
        int k;
        while (i < j)
        {
          k = localObject2[i];
          ((StringBuilder)localObject1).append(k + ", ");
          i += 1;
        }
        ((StringBuilder)localObject1).append("type:quint_string, key:" + this.key + ", value:");
        if (this.paramQueueString.queueValue != null)
        {
          localObject2 = this.paramQueueString.queueValue;
          k = localObject2.length;
          i = j;
          while (i < k)
          {
            String str = localObject2[i];
            ((StringBuilder)localObject1).append(str + ", ");
            i += 1;
          }
        }
      }
    }
  }
  
  public static class OptionalParamBoolean
  {
    public boolean value;
  }
  
  public static class OptionalParamFloat
  {
    public float param1;
    public float param2;
    public float value;
  }
  
  public static class OptionalParamInt
  {
    public int value;
  }
  
  public static class OptionalParamLong
  {
    public long param1;
    public long param2;
    public long value;
  }
  
  public static class OptionalParamQueueInt
  {
    public int[] queueValue;
  }
  
  public static class OptionalParamQueueString
  {
    public String[] queueValue;
  }
  
  public static class OptionalParamString
  {
    public String param1;
    public String param2;
    public String value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPOptionalParam
 * JD-Core Version:    0.7.0.1
 */