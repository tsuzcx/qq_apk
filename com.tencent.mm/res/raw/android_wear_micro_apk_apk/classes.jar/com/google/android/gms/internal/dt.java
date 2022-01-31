package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class dt
  implements Cloneable
{
  private dr<?, ?> Ry;
  private List<dy> Rz = new ArrayList();
  private Object value;
  
  private dt ka()
  {
    dt localdt = new dt();
    try
    {
      localdt.Ry = this.Ry;
      if (this.Rz == null) {
        localdt.Rz = null;
      }
      for (;;)
      {
        if (this.value == null) {
          return localdt;
        }
        if (!(this.value instanceof dw)) {
          break;
        }
        localdt.value = ((dw)((dw)this.value).clone());
        return localdt;
        localdt.Rz.addAll(this.Rz);
      }
      if (!(this.value instanceof byte[])) {
        break label117;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    localCloneNotSupportedException.value = ((byte[])this.value).clone();
    return localCloneNotSupportedException;
    label117:
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.value instanceof byte[][]))
    {
      localObject1 = (byte[][])this.value;
      localObject2 = new byte[localObject1.length][];
      localCloneNotSupportedException.value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((this.value instanceof boolean[]))
    {
      localCloneNotSupportedException.value = ((boolean[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof int[]))
    {
      localCloneNotSupportedException.value = ((int[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof long[]))
    {
      localCloneNotSupportedException.value = ((long[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof float[]))
    {
      localCloneNotSupportedException.value = ((float[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof double[]))
    {
      localCloneNotSupportedException.value = ((double[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof dw[]))
    {
      localObject1 = (dw[])this.value;
      localObject2 = new dw[localObject1.length];
      localCloneNotSupportedException.value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((dw)localObject1[i].clone());
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  private byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[jN()];
    a(do.c(arrayOfByte));
    return arrayOfByte;
  }
  
  final void a(do paramdo)
  {
    if (this.value != null) {
      this.Ry.a(this.value, paramdo);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.Rz.iterator();
      while (localIterator.hasNext())
      {
        dy localdy = (dy)localIterator.next();
        paramdo.bx(localdy.tag);
        paramdo.d(localdy.RC);
      }
    }
  }
  
  final void a(dy paramdy)
  {
    this.Rz.add(paramdy);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof dt));
      paramObject = (dt)paramObject;
      if ((this.value == null) || (paramObject.value == null)) {
        break;
      }
      bool1 = bool2;
    } while (this.Ry != paramObject.Ry);
    if (!this.Ry.Rs.isArray()) {
      return this.value.equals(paramObject.value);
    }
    if ((this.value instanceof byte[])) {
      return Arrays.equals((byte[])this.value, (byte[])paramObject.value);
    }
    if ((this.value instanceof int[])) {
      return Arrays.equals((int[])this.value, (int[])paramObject.value);
    }
    if ((this.value instanceof long[])) {
      return Arrays.equals((long[])this.value, (long[])paramObject.value);
    }
    if ((this.value instanceof float[])) {
      return Arrays.equals((float[])this.value, (float[])paramObject.value);
    }
    if ((this.value instanceof double[])) {
      return Arrays.equals((double[])this.value, (double[])paramObject.value);
    }
    if ((this.value instanceof boolean[])) {
      return Arrays.equals((boolean[])this.value, (boolean[])paramObject.value);
    }
    return Arrays.deepEquals((Object[])this.value, (Object[])paramObject.value);
    if ((this.Rz != null) && (paramObject.Rz != null)) {
      return this.Rz.equals(paramObject.Rz);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), paramObject.toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException(paramObject);
    }
  }
  
  public final int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  final int jN()
  {
    int j;
    if (this.value != null)
    {
      j = this.Ry.z(this.value);
      return j;
    }
    Iterator localIterator = this.Rz.iterator();
    dy localdy;
    for (int i = 0;; i = localdy.RC.length + (j + 0) + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      localdy = (dy)localIterator.next();
      j = do.by(localdy.tag);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dt
 * JD-Core Version:    0.7.0.1
 */