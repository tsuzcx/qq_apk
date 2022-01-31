package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import java.lang.reflect.Array;

public final class a
  extends SpannableString
{
  private int adr;
  private Object[] rHp;
  private int[] rHq;
  
  public a(CharSequence paramCharSequence)
  {
    super(paramCharSequence.toString());
    f(paramCharSequence, paramCharSequence.length());
  }
  
  private void f(CharSequence paramCharSequence, int paramInt)
  {
    this.rHp = new Object[20];
    this.rHq = new int[60];
    if ((paramCharSequence instanceof Spanned))
    {
      paramCharSequence = (Spanned)paramCharSequence;
      Object[] arrayOfObject = paramCharSequence.getSpans(0, paramInt, Object.class);
      int n = arrayOfObject.length;
      int i = 0;
      while (i < n)
      {
        Object localObject = arrayOfObject[i];
        if (((localObject instanceof CharacterStyle)) || ((localObject instanceof ParagraphStyle)))
        {
          int k = paramCharSequence.getSpanStart(localObject);
          int m = paramCharSequence.getSpanEnd(localObject);
          int i1 = paramCharSequence.getSpanFlags(localObject);
          int j = k;
          if (k < 0) {
            j = 0;
          }
          k = m;
          if (m > paramInt) {
            k = paramInt;
          }
          setSpan(localObject, j + 0, k + 0, i1);
        }
        i += 1;
      }
    }
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    int i = this.adr;
    Object[] arrayOfObject = this.rHp;
    int[] arrayOfInt = this.rHq;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 1)];
      }
      i -= 1;
    }
    return -1;
  }
  
  public final int getSpanFlags(Object paramObject)
  {
    int i = this.adr;
    Object[] arrayOfObject = this.rHp;
    int[] arrayOfInt = this.rHq;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 2)];
      }
      i -= 1;
    }
    return 0;
  }
  
  public final int getSpanStart(Object paramObject)
  {
    int i = this.adr;
    Object[] arrayOfObject = this.rHp;
    int[] arrayOfInt = this.rHq;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 0)];
      }
      i -= 1;
    }
    return -1;
  }
  
  public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    int k = 0;
    int m = this.adr;
    Object[] arrayOfObject = this.rHp;
    int[] arrayOfInt = this.rHq;
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 0;
    if (j < m)
    {
      Object localObject3;
      Object localObject4;
      int i;
      int n;
      if (paramClass != null)
      {
        localObject3 = localObject1;
        localObject4 = localObject2;
        i = k;
        if (!paramClass.isInstance(arrayOfObject[j])) {}
      }
      else
      {
        n = arrayOfInt[(j * 3 + 0)];
        int i1 = arrayOfInt[(j * 3 + 1)];
        localObject3 = localObject1;
        localObject4 = localObject2;
        i = k;
        if (n <= paramInt2)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          i = k;
          if (i1 >= paramInt1) {
            if ((n != i1) && (paramInt1 != paramInt2))
            {
              localObject3 = localObject1;
              localObject4 = localObject2;
              i = k;
              if (n != paramInt2)
              {
                localObject3 = localObject1;
                localObject4 = localObject2;
                i = k;
                if (i1 == paramInt1) {}
              }
            }
            else
            {
              if (k != 0) {
                break label214;
              }
              localObject4 = arrayOfObject[j];
              i = k + 1;
              localObject3 = localObject1;
            }
          }
        }
      }
      for (;;)
      {
        j += 1;
        localObject1 = localObject3;
        localObject2 = localObject4;
        k = i;
        break;
        label214:
        if (k == 1)
        {
          localObject1 = (Object[])Array.newInstance(paramClass, m - j + 1);
          localObject1[0] = localObject2;
        }
        n = 0xFF0000 & arrayOfInt[(j * 3 + 2)];
        if (n != 0)
        {
          i = 0;
          while ((i < k) && (n <= (getSpanFlags(localObject1[i]) & 0xFF0000))) {
            i += 1;
          }
          System.arraycopy(localObject1, i, localObject1, i + 1, k - i);
          localObject1[i] = arrayOfObject[j];
          i = k + 1;
          localObject3 = localObject1;
          localObject4 = localObject2;
        }
        else
        {
          localObject1[k] = arrayOfObject[j];
          i = k + 1;
          localObject3 = localObject1;
          localObject4 = localObject2;
        }
      }
    }
    if (k == 0) {
      return (Object[])Array.newInstance(paramClass, 0);
    }
    if (k == 1)
    {
      paramClass = (Object[])Array.newInstance(paramClass, 1);
      paramClass[0] = localObject2;
      return (Object[])paramClass;
    }
    if (k == localObject1.length) {
      return (Object[])localObject1;
    }
    paramClass = (Object[])Array.newInstance(paramClass, k);
    System.arraycopy(localObject1, 0, paramClass, 0, k);
    return (Object[])paramClass;
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    int m = this.adr;
    Object[] arrayOfObject = this.rHp;
    int[] arrayOfInt = this.rHq;
    Object localObject = paramClass;
    if (paramClass == null) {
      localObject = Object.class;
    }
    int i = 0;
    int j;
    if (i < m)
    {
      int k = arrayOfInt[(i * 3 + 0)];
      j = arrayOfInt[(i * 3 + 1)];
      if ((k <= paramInt1) || (k >= paramInt2) || (!((Class)localObject).isInstance(arrayOfObject[i]))) {
        break label131;
      }
      paramInt2 = k;
    }
    label131:
    for (;;)
    {
      if ((j > paramInt1) && (j < paramInt2) && (((Class)localObject).isInstance(arrayOfObject[i]))) {
        paramInt2 = j;
      }
      for (;;)
      {
        i += 1;
        break;
        return paramInt2;
      }
    }
  }
  
  public final void removeSpan(Object paramObject)
  {
    int j = this.adr;
    Object[] arrayOfObject = this.rHp;
    int[] arrayOfInt = this.rHq;
    int i = j - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (arrayOfObject[i] == paramObject)
        {
          j -= i + 1;
          System.arraycopy(arrayOfObject, i + 1, arrayOfObject, i, j);
          System.arraycopy(arrayOfInt, (i + 1) * 3, arrayOfInt, i * 3, j * 3);
          this.adr -= 1;
        }
      }
      else {
        return;
      }
      i -= 1;
    }
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.adr + 1 >= this.rHp.length)
    {
      int i = this.adr + 10;
      Object[] arrayOfObject = new Object[i];
      int[] arrayOfInt = new int[i * 3];
      System.arraycopy(this.rHp, 0, arrayOfObject, 0, this.adr);
      System.arraycopy(this.rHq, 0, arrayOfInt, 0, this.adr * 3);
      this.rHp = arrayOfObject;
      this.rHq = arrayOfInt;
    }
    this.rHp[this.adr] = paramObject;
    this.rHq[(this.adr * 3 + 0)] = paramInt1;
    this.rHq[(this.adr * 3 + 1)] = paramInt2;
    this.rHq[(this.adr * 3 + 2)] = paramInt3;
    this.adr += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.a
 * JD-Core Version:    0.7.0.1
 */