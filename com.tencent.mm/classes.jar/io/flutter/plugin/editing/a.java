package io.flutter.plugin.editing;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;

final class a
{
  private final FlutterJNI aapT;
  
  public a(FlutterJNI paramFlutterJNI)
  {
    this.aapT = paramFlutterJNI;
  }
  
  private boolean aDs(int paramInt)
  {
    AppMethodBeat.i(255618);
    boolean bool = this.aapT.nativeFlutterTextUtilsIsEmoji(paramInt);
    AppMethodBeat.o(255618);
    return bool;
  }
  
  private boolean aDt(int paramInt)
  {
    AppMethodBeat.i(255622);
    boolean bool = this.aapT.nativeFlutterTextUtilsIsEmojiModifier(paramInt);
    AppMethodBeat.o(255622);
    return bool;
  }
  
  private boolean aDu(int paramInt)
  {
    AppMethodBeat.i(255624);
    boolean bool = this.aapT.nativeFlutterTextUtilsIsVariationSelector(paramInt);
    AppMethodBeat.o(255624);
    return bool;
  }
  
  private boolean aDv(int paramInt)
  {
    AppMethodBeat.i(255627);
    boolean bool = this.aapT.nativeFlutterTextUtilsIsRegionalIndicator(paramInt);
    AppMethodBeat.o(255627);
    return bool;
  }
  
  private static boolean aDw(int paramInt)
  {
    return ((48 <= paramInt) && (paramInt <= 57)) || (paramInt == 35) || (paramInt == 42);
  }
  
  public final int r(CharSequence paramCharSequence, int paramInt)
  {
    int j = 1;
    int i2 = 0;
    AppMethodBeat.i(255638);
    if (paramInt <= 1)
    {
      AppMethodBeat.o(255638);
      return 0;
    }
    int i1 = Character.codePointBefore(paramCharSequence, paramInt);
    int i = Character.charCount(i1);
    int k = paramInt - i;
    if (k == 0)
    {
      AppMethodBeat.o(255638);
      return 0;
    }
    if (i1 == 10)
    {
      j = i;
      if (Character.codePointBefore(paramCharSequence, k) == 13) {
        j = i + 1;
      }
      AppMethodBeat.o(255638);
      return paramInt - j;
    }
    if (aDv(i1))
    {
      m = Character.codePointBefore(paramCharSequence, k);
      k -= Character.charCount(m);
      while ((k > 0) && (aDv(m)))
      {
        m = Character.codePointBefore(paramCharSequence, k);
        k -= Character.charCount(m);
        j += 1;
      }
      k = i;
      if (j % 2 == 0) {
        k = i + 2;
      }
      AppMethodBeat.o(255638);
      return paramInt - k;
    }
    if (i1 == 8419)
    {
      m = Character.codePointBefore(paramCharSequence, k);
      j = k - Character.charCount(m);
      if ((j > 0) && (aDu(m)))
      {
        k = Character.codePointBefore(paramCharSequence, j);
        j = i;
        if (aDw(k))
        {
          j = Character.charCount(m);
          j = i + (Character.charCount(k) + j);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(255638);
        return paramInt - j;
        j = i;
        if (aDw(m)) {
          j = i + Character.charCount(m);
        }
      }
    }
    int n = i;
    j = k;
    int m = i1;
    if (i1 == 917631)
    {
      m = Character.codePointBefore(paramCharSequence, k);
      j = k - Character.charCount(m);
      if (j > 0)
      {
        if ((917536 <= m) && (m <= 917630)) {}
        for (k = 1;; k = 0)
        {
          if (k == 0) {
            break label395;
          }
          k = Character.charCount(m);
          m = Character.codePointBefore(paramCharSequence, j);
          j -= Character.charCount(m);
          i = k + i;
          break;
        }
      }
      label395:
      if (!aDs(m))
      {
        AppMethodBeat.o(255638);
        return paramInt - 2;
      }
      n = Character.charCount(m) + i;
    }
    i = n;
    i1 = j;
    k = m;
    if (aDu(m))
    {
      k = Character.codePointBefore(paramCharSequence, j);
      if (!aDs(k))
      {
        AppMethodBeat.o(255638);
        return paramInt - n;
      }
      i = n + Character.charCount(k);
      i1 = j - i;
    }
    if (aDs(k))
    {
      n = 0;
      j = 0;
      m = i1;
      i1 = n;
      n = k;
      if (j != 0)
      {
        k = i + (Character.charCount(n) + i1 + 1);
        i = 0;
        label532:
        if (aDt(n))
        {
          n = Character.codePointBefore(paramCharSequence, m);
          m -= Character.charCount(n);
          j = n;
          i = i2;
          if (m > 0)
          {
            j = n;
            i = i2;
            if (aDu(n))
            {
              j = Character.codePointBefore(paramCharSequence, m);
              if (!aDs(j))
              {
                AppMethodBeat.o(255638);
                return paramInt - k;
              }
              i = Character.charCount(j);
              Character.charCount(j);
            }
          }
          i1 = k;
          if (this.aapT.nativeFlutterTextUtilsIsEmojiModifierBase(j)) {
            i1 = k + (Character.charCount(j) + i);
          }
        }
      }
    }
    for (;;)
    {
      label654:
      AppMethodBeat.o(255638);
      return paramInt - i1;
      if (m > 0)
      {
        n = Character.codePointBefore(paramCharSequence, m);
        m -= Character.charCount(n);
        if (n == 8205)
        {
          n = Character.codePointBefore(paramCharSequence, m);
          m -= Character.charCount(n);
          if ((m > 0) && (aDu(n)))
          {
            n = Character.codePointBefore(paramCharSequence, m);
            i = Character.charCount(n);
            i1 = Character.charCount(n);
            j = 1;
            m -= i1;
          }
        }
      }
      for (;;)
      {
        i1 = k;
        if (m == 0) {
          break label654;
        }
        i1 = k;
        if (j == 0) {
          break label654;
        }
        i1 = k;
        if (!aDs(n)) {
          break label654;
        }
        i1 = i;
        i = k;
        break;
        i = 0;
        j = 1;
        continue;
        i1 = 0;
        j = i;
        i = i1;
        continue;
        i1 = 0;
        j = i;
        i = i1;
      }
      k = i;
      i = j;
      break label532;
      i1 = i;
    }
  }
  
  public final int s(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(255645);
    int i3 = paramCharSequence.length();
    if (paramInt >= i3 - 1)
    {
      AppMethodBeat.o(255645);
      return i3;
    }
    int k = Character.codePointAt(paramCharSequence, paramInt);
    int j = Character.charCount(k);
    int m = paramInt + j;
    if (m == 0)
    {
      AppMethodBeat.o(255645);
      return 0;
    }
    if (k == 10)
    {
      i = j;
      if (Character.codePointAt(paramCharSequence, m) == 13) {
        i = j + 1;
      }
      AppMethodBeat.o(255645);
      return paramInt + i;
    }
    if (aDv(k))
    {
      if ((m >= i3 - 1) || (!aDv(Character.codePointAt(paramCharSequence, m))))
      {
        AppMethodBeat.o(255645);
        return paramInt + j;
      }
      k = paramInt;
      i = 0;
      while ((k > 0) && (aDv(Character.codePointBefore(paramCharSequence, paramInt))))
      {
        m = Character.charCount(Character.codePointBefore(paramCharSequence, paramInt));
        i += 1;
        k -= m;
      }
      k = j;
      if (i % 2 == 0) {
        k = j + 2;
      }
      AppMethodBeat.o(255645);
      return paramInt + k;
    }
    int i = j;
    if (aDw(k)) {
      i = j + Character.charCount(k);
    }
    if (k == 8419)
    {
      k = Character.codePointBefore(paramCharSequence, m);
      j = Character.charCount(k) + m;
      if ((j < i3) && (aDu(k)))
      {
        m = Character.codePointAt(paramCharSequence, j);
        j = i;
        if (aDw(m)) {
          j = i + (Character.charCount(k) + Character.charCount(m));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(255645);
        return paramInt + j;
        j = i;
        if (aDw(k)) {
          j = i + Character.charCount(k);
        }
      }
    }
    int i2;
    int i1;
    int n;
    if (aDs(k))
    {
      i2 = 0;
      i1 = 0;
      n = i;
      if (i1 != 0)
      {
        i = Character.charCount(k);
        i1 = 0;
        i = n + (i + i2 + 1);
        label380:
        n = i;
        if (!aDt(k))
        {
          j = m;
          n = k;
          if (m >= i3) {
            break label715;
          }
          i2 = Character.codePointAt(paramCharSequence, m);
          k = m + Character.charCount(i2);
          if (i2 == 8419)
          {
            m = Character.codePointBefore(paramCharSequence, k);
            j = Character.charCount(m) + k;
            if ((j < i3) && (aDu(m)))
            {
              k = Character.codePointAt(paramCharSequence, j);
              j = i;
              if (aDw(k)) {
                j = i + (Character.charCount(m) + Character.charCount(k));
              }
            }
            for (;;)
            {
              AppMethodBeat.o(255645);
              return paramInt + j;
              j = i;
              if (aDw(m)) {
                j = i + Character.charCount(m);
              }
            }
          }
          if (!aDt(i2)) {
            break label564;
          }
          n = i + (Character.charCount(i2) + 0);
        }
      }
    }
    for (;;)
    {
      label554:
      AppMethodBeat.o(255645);
      return paramInt + n;
      label564:
      if (aDu(i2))
      {
        n = i + (Character.charCount(i2) + 0);
      }
      else
      {
        j = k;
        n = i2;
        if (i2 == 8205)
        {
          i1 = 1;
          j = Character.codePointAt(paramCharSequence, k);
          m = k + Character.charCount(j);
          if ((m < i3) && (aDu(j)))
          {
            j = Character.codePointAt(paramCharSequence, m);
            k = Character.charCount(j);
            m += Character.charCount(j);
          }
        }
        for (;;)
        {
          n = i;
          if (m >= i3) {
            break label554;
          }
          n = i;
          if (i1 == 0) {
            break label554;
          }
          n = i;
          i2 = k;
          k = j;
          if (aDs(j)) {
            break;
          }
          n = i;
          break label554;
          k = 0;
          continue;
          label715:
          k = 0;
          m = j;
          j = n;
        }
        i = n;
        break label380;
        n = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.editing.a
 * JD-Core Version:    0.7.0.1
 */