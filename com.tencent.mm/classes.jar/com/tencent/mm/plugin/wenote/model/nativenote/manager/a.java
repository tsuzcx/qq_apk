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
  private int afG;
  private Object[] vxX;
  private int[] vxY;
  
  public a(CharSequence paramCharSequence)
  {
    super(paramCharSequence.toString());
    AppMethodBeat.i(26708);
    o(paramCharSequence, paramCharSequence.length());
    AppMethodBeat.o(26708);
  }
  
  private void o(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(26709);
    this.vxX = new Object[20];
    this.vxY = new int[60];
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
    AppMethodBeat.o(26709);
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    int i = this.afG;
    Object[] arrayOfObject = this.vxX;
    int[] arrayOfInt = this.vxY;
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
    int i = this.afG;
    Object[] arrayOfObject = this.vxX;
    int[] arrayOfInt = this.vxY;
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
    int i = this.afG;
    Object[] arrayOfObject = this.vxX;
    int[] arrayOfInt = this.vxY;
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
    AppMethodBeat.i(26712);
    int k = 0;
    int m = this.afG;
    Object[] arrayOfObject = this.vxX;
    int[] arrayOfInt = this.vxY;
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
                break label220;
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
        label220:
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
    if (k == 0)
    {
      paramClass = (Object[])Array.newInstance(paramClass, 0);
      AppMethodBeat.o(26712);
      return paramClass;
    }
    if (k == 1)
    {
      paramClass = (Object[])Array.newInstance(paramClass, 1);
      paramClass[0] = localObject2;
      paramClass = (Object[])paramClass;
      AppMethodBeat.o(26712);
      return paramClass;
    }
    if (k == localObject1.length)
    {
      paramClass = (Object[])localObject1;
      AppMethodBeat.o(26712);
      return paramClass;
    }
    paramClass = (Object[])Array.newInstance(paramClass, k);
    System.arraycopy(localObject1, 0, paramClass, 0, k);
    paramClass = (Object[])paramClass;
    AppMethodBeat.o(26712);
    return paramClass;
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    AppMethodBeat.i(26713);
    int m = this.afG;
    Object[] arrayOfObject = this.vxX;
    int[] arrayOfInt = this.vxY;
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
        AppMethodBeat.o(26713);
        return paramInt2;
      }
    }
  }
  
  public final void removeSpan(Object paramObject)
  {
    AppMethodBeat.i(26711);
    int j = this.afG;
    Object[] arrayOfObject = this.vxX;
    int[] arrayOfInt = this.vxY;
    int i = j - 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject)
      {
        j -= i + 1;
        System.arraycopy(arrayOfObject, i + 1, arrayOfObject, i, j);
        System.arraycopy(arrayOfInt, (i + 1) * 3, arrayOfInt, i * 3, j * 3);
        this.afG -= 1;
        AppMethodBeat.o(26711);
        return;
      }
      i -= 1;
    }
    AppMethodBeat.o(26711);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26710);
    if (this.afG + 1 >= this.vxX.length)
    {
      int i = this.afG + 10;
      Object[] arrayOfObject = new Object[i];
      int[] arrayOfInt = new int[i * 3];
      System.arraycopy(this.vxX, 0, arrayOfObject, 0, this.afG);
      System.arraycopy(this.vxY, 0, arrayOfInt, 0, this.afG * 3);
      this.vxX = arrayOfObject;
      this.vxY = arrayOfInt;
    }
    this.vxX[this.afG] = paramObject;
    this.vxY[(this.afG * 3 + 0)] = paramInt1;
    this.vxY[(this.afG * 3 + 1)] = paramInt2;
    this.vxY[(this.afG * 3 + 2)] = paramInt3;
    this.afG += 1;
    AppMethodBeat.o(26710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.a
 * JD-Core Version:    0.7.0.1
 */