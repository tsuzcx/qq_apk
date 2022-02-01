package com.tencent.mm.sdk.a;

import com.tencent.mm.sdk.platformtools.f;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class e<T extends d>
{
  protected int YU = 0;
  private final int priority;
  
  public e()
  {
    this(0);
  }
  
  public e(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public abstract boolean b(T paramT);
  
  final int getPriority()
  {
    return this.priority;
  }
  
  final int ln()
  {
    if (this.YU == 0)
    {
      long l = System.currentTimeMillis();
      Type localType2 = getClass().getGenericSuperclass();
      Type localType1 = localType2;
      if (!(localType2 instanceof ParameterizedType)) {
        localType1 = getClass().getSuperclass().getGenericSuperclass();
      }
      localType1 = ((ParameterizedType)localType1).getActualTypeArguments()[0];
      this.YU = ((Class)localType1).getName().hashCode();
      f.e("IListener", "genEventID, %s<%s>, useTime:%d", new Object[] { getClass().getName(), localType1, Long.valueOf(System.currentTimeMillis() - l) });
    }
    return this.YU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a.e
 * JD-Core Version:    0.7.0.1
 */