package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class TbsCoreLoadStat$TbsSequenceQueue
{
  private int b;
  private int c;
  private int[] d;
  private int e;
  private int f;
  
  public TbsCoreLoadStat$TbsSequenceQueue(TbsCoreLoadStat paramTbsCoreLoadStat)
  {
    AppMethodBeat.i(54378);
    this.b = 10;
    this.e = 0;
    this.f = 0;
    this.c = this.b;
    this.d = new int[this.c];
    AppMethodBeat.o(54378);
  }
  
  public TbsCoreLoadStat$TbsSequenceQueue(TbsCoreLoadStat paramTbsCoreLoadStat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54379);
    this.b = 10;
    this.e = 0;
    this.f = 0;
    this.c = paramInt2;
    this.d = new int[this.c];
    this.d[0] = paramInt1;
    this.f += 1;
    AppMethodBeat.o(54379);
  }
  
  public void add(int paramInt)
  {
    AppMethodBeat.i(54380);
    if (this.f > this.c - 1)
    {
      localObject = new IndexOutOfBoundsException("sequeue is full");
      AppMethodBeat.o(54380);
      throw ((Throwable)localObject);
    }
    Object localObject = this.d;
    int i = this.f;
    this.f = (i + 1);
    localObject[i] = paramInt;
    AppMethodBeat.o(54380);
  }
  
  public void clear()
  {
    AppMethodBeat.i(54383);
    Arrays.fill(this.d, 0);
    this.e = 0;
    this.f = 0;
    AppMethodBeat.o(54383);
  }
  
  public int element()
  {
    AppMethodBeat.i(54382);
    if (empty())
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("sequeue is null");
      AppMethodBeat.o(54382);
      throw localIndexOutOfBoundsException;
    }
    int i = this.d[this.e];
    AppMethodBeat.o(54382);
    return i;
  }
  
  public boolean empty()
  {
    return this.f == this.e;
  }
  
  public int length()
  {
    return this.f - this.e;
  }
  
  public int remove()
  {
    AppMethodBeat.i(54381);
    if (empty())
    {
      localObject = new IndexOutOfBoundsException("sequeue is null");
      AppMethodBeat.o(54381);
      throw ((Throwable)localObject);
    }
    int i = this.d[this.e];
    Object localObject = this.d;
    int j = this.e;
    this.e = (j + 1);
    localObject[j] = 0;
    AppMethodBeat.o(54381);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(54384);
    if (empty())
    {
      AppMethodBeat.o(54384);
      return "";
    }
    Object localObject = new StringBuilder("[");
    int i = this.e;
    while (i < this.f)
    {
      ((StringBuilder)localObject).append(String.valueOf(this.d[i]) + ",");
      i += 1;
    }
    i = ((StringBuilder)localObject).length();
    localObject = "]";
    AppMethodBeat.o(54384);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreLoadStat.TbsSequenceQueue
 * JD-Core Version:    0.7.0.1
 */