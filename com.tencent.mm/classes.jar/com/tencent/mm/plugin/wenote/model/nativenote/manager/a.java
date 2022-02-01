package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class a
  extends SpannableString
{
  private int bWl;
  private Object[] xyN;
  private int[] xyO;
  
  public a(CharSequence paramCharSequence)
  {
    super(paramCharSequence.toString());
    AppMethodBeat.i(30401);
    e(paramCharSequence, paramCharSequence.length());
    AppMethodBeat.o(30401);
  }
  
  private void e(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(30402);
    this.xyN = new Object[20];
    this.xyO = new int[60];
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
    AppMethodBeat.o(30402);
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    int i = this.bWl;
    Object[] arrayOfObject = this.xyN;
    int[] arrayOfInt = this.xyO;
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
    int i = this.bWl;
    Object[] arrayOfObject = this.xyN;
    int[] arrayOfInt = this.xyO;
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
    int i = this.bWl;
    Object[] arrayOfObject = this.xyN;
    int[] arrayOfInt = this.xyO;
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
    AppMethodBeat.i(30405);
    int i = 0;
    int m = this.bWl;
    Object[] arrayOfObject2 = this.xyN;
    int[] arrayOfInt = this.xyO;
    Object[] arrayOfObject1 = null;
    Object localObject = null;
    int j = 0;
    int k;
    int n;
    if (j < m)
    {
      if ((paramClass != null) && (!paramClass.isInstance(arrayOfObject2[j]))) {
        break label378;
      }
      k = arrayOfInt[(j * 3 + 0)];
      n = arrayOfInt[(j * 3 + 1)];
      if ((k > paramInt2) || (n < paramInt1) || ((k != n) && (paramInt1 != paramInt2) && ((k == paramInt2) || (n == paramInt1)))) {
        break label378;
      }
      if (i == 0)
      {
        localObject = arrayOfObject2[j];
        i += 1;
      }
    }
    label378:
    for (;;)
    {
      j += 1;
      break;
      if (i == 1)
      {
        arrayOfObject1 = (Object[])Array.newInstance(paramClass, m - j + 1);
        arrayOfObject1[0] = localObject;
      }
      n = 0xFF0000 & arrayOfInt[(j * 3 + 2)];
      if (n != 0)
      {
        k = 0;
        while ((k < i) && (n <= (getSpanFlags(arrayOfObject1[k]) & 0xFF0000))) {
          k += 1;
        }
        System.arraycopy(arrayOfObject1, k, arrayOfObject1, k + 1, i - k);
        arrayOfObject1[k] = arrayOfObject2[j];
        i += 1;
      }
      else
      {
        arrayOfObject1[i] = arrayOfObject2[j];
        i += 1;
        continue;
        if (i == 0)
        {
          paramClass = (Object[])Array.newInstance(paramClass, 0);
          AppMethodBeat.o(30405);
          return paramClass;
        }
        if (i == 1)
        {
          paramClass = (Object[])Array.newInstance(paramClass, 1);
          paramClass[0] = localObject;
          AppMethodBeat.o(30405);
          return paramClass;
        }
        if (i == arrayOfObject1.length)
        {
          AppMethodBeat.o(30405);
          return arrayOfObject1;
        }
        paramClass = (Object[])Array.newInstance(paramClass, i);
        System.arraycopy(arrayOfObject1, 0, paramClass, 0, i);
        AppMethodBeat.o(30405);
        return paramClass;
      }
    }
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    AppMethodBeat.i(30406);
    int m = this.bWl;
    Object[] arrayOfObject = this.xyN;
    int[] arrayOfInt = this.xyO;
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
        break label143;
      }
      paramInt2 = k;
    }
    label143:
    for (;;)
    {
      if ((j > paramInt1) && (j < paramInt2) && (((Class)localObject).isInstance(arrayOfObject[i]))) {
        paramInt2 = j;
      }
      for (;;)
      {
        i += 1;
        break;
        AppMethodBeat.o(30406);
        return paramInt2;
      }
    }
  }
  
  public final void removeSpan(Object paramObject)
  {
    AppMethodBeat.i(30404);
    int j = this.bWl;
    Object[] arrayOfObject = this.xyN;
    int[] arrayOfInt = this.xyO;
    int i = j - 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject)
      {
        j -= i + 1;
        System.arraycopy(arrayOfObject, i + 1, arrayOfObject, i, j);
        System.arraycopy(arrayOfInt, (i + 1) * 3, arrayOfInt, i * 3, j * 3);
        this.bWl -= 1;
        AppMethodBeat.o(30404);
        return;
      }
      i -= 1;
    }
    AppMethodBeat.o(30404);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(30403);
    if (this.bWl + 1 >= this.xyN.length)
    {
      int i = this.bWl + 10;
      Object[] arrayOfObject = new Object[i];
      int[] arrayOfInt = new int[i * 3];
      System.arraycopy(this.xyN, 0, arrayOfObject, 0, this.bWl);
      System.arraycopy(this.xyO, 0, arrayOfInt, 0, this.bWl * 3);
      this.xyN = arrayOfObject;
      this.xyO = arrayOfInt;
    }
    this.xyN[this.bWl] = paramObject;
    this.xyO[(this.bWl * 3 + 0)] = paramInt1;
    this.xyO[(this.bWl * 3 + 1)] = paramInt2;
    this.xyO[(this.bWl * 3 + 2)] = paramInt3;
    this.bWl += 1;
    AppMethodBeat.o(30403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.a
 * JD-Core Version:    0.7.0.1
 */