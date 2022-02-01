package io.flutter.plugin.editing;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;

class FlutterTextUtils
{
  public static final int CANCEL_TAG = 917631;
  public static final int CARRIAGE_RETURN = 13;
  public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
  public static final int LINE_FEED = 10;
  public static final int ZERO_WIDTH_JOINER = 8205;
  private final FlutterJNI flutterJNI;
  
  public FlutterTextUtils(FlutterJNI paramFlutterJNI)
  {
    this.flutterJNI = paramFlutterJNI;
  }
  
  public int getOffsetAfter(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(189834);
    int i2 = paramCharSequence.length();
    if (paramInt >= i2 - 1)
    {
      AppMethodBeat.o(189834);
      return i2;
    }
    int k = Character.codePointAt(paramCharSequence, paramInt);
    int j = Character.charCount(k);
    int m = paramInt + j;
    if (m == 0)
    {
      AppMethodBeat.o(189834);
      return 0;
    }
    if (k == 10)
    {
      i = j;
      if (Character.codePointAt(paramCharSequence, m) == 13) {
        i = j + 1;
      }
      AppMethodBeat.o(189834);
      return paramInt + i;
    }
    if (isRegionalIndicatorSymbol(k))
    {
      if ((m >= i2 - 1) || (!isRegionalIndicatorSymbol(Character.codePointAt(paramCharSequence, m))))
      {
        AppMethodBeat.o(189834);
        return m;
      }
      k = paramInt;
      i = 0;
      while ((k > 0) && (isRegionalIndicatorSymbol(Character.codePointBefore(paramCharSequence, paramInt))))
      {
        m = Character.charCount(Character.codePointBefore(paramCharSequence, paramInt));
        i += 1;
        k -= m;
      }
      k = j;
      if (i % 2 == 0) {
        k = j + 2;
      }
      AppMethodBeat.o(189834);
      return paramInt + k;
    }
    int i = j;
    if (isKeycapBase(k)) {
      i = j + Character.charCount(k);
    }
    if (k == 8419)
    {
      k = Character.codePointBefore(paramCharSequence, m);
      j = Character.charCount(k) + m;
      if ((j < i2) && (isVariationSelector(k)))
      {
        m = Character.codePointAt(paramCharSequence, j);
        j = i;
        if (isKeycapBase(m)) {
          j = i + (Character.charCount(k) + Character.charCount(m));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(189834);
        return paramInt + j;
        j = i;
        if (isKeycapBase(k)) {
          j = i + Character.charCount(k);
        }
      }
    }
    int n;
    int i1;
    if (isEmoji(k))
    {
      n = 0;
      i1 = 0;
      j = m;
      m = n;
      if (i1 != 0)
      {
        i1 = Character.charCount(k);
        n = 0;
        i += i1 + m + 1;
        m = n;
        label391:
        n = i;
        if (!isEmojiModifier(k))
        {
          n = j;
          if (j >= i2) {
            break label713;
          }
          i1 = Character.codePointAt(paramCharSequence, j);
          j += Character.charCount(i1);
          if (i1 == 8419)
          {
            k = Character.codePointBefore(paramCharSequence, j);
            j = Character.charCount(k) + j;
            if ((j < i2) && (isVariationSelector(k)))
            {
              m = Character.codePointAt(paramCharSequence, j);
              j = i;
              if (isKeycapBase(m)) {
                j = i + (Character.charCount(k) + Character.charCount(m));
              }
            }
            for (;;)
            {
              AppMethodBeat.o(189834);
              return paramInt + j;
              j = i;
              if (isKeycapBase(k)) {
                j = i + Character.charCount(k);
              }
            }
          }
          if (!isEmojiModifier(i1)) {
            break label573;
          }
          n = i + (Character.charCount(i1) + 0);
        }
      }
    }
    for (;;)
    {
      label563:
      AppMethodBeat.o(189834);
      return paramInt + n;
      label573:
      if (isVariationSelector(i1))
      {
        n = i + (Character.charCount(i1) + 0);
      }
      else
      {
        n = j;
        k = i1;
        if (i1 == 8205)
        {
          i1 = 1;
          k = Character.codePointAt(paramCharSequence, j);
          j += Character.charCount(k);
          if ((j < i2) && (isVariationSelector(k)))
          {
            k = Character.codePointAt(paramCharSequence, j);
            m = Character.charCount(k);
            j += Character.charCount(k);
          }
        }
        for (;;)
        {
          n = i;
          if (j >= i2) {
            break label563;
          }
          n = i;
          if (i1 == 0) {
            break label563;
          }
          n = i;
          if (!isEmoji(k)) {
            break label563;
          }
          break;
          m = 0;
          continue;
          label713:
          j = 0;
          i1 = m;
          m = j;
          j = n;
        }
        m = i1;
        break label391;
        n = i;
      }
    }
  }
  
  public int getOffsetBefore(CharSequence paramCharSequence, int paramInt)
  {
    int j = 1;
    int i2 = 0;
    AppMethodBeat.i(189823);
    if (paramInt <= 1)
    {
      AppMethodBeat.o(189823);
      return 0;
    }
    int i1 = Character.codePointBefore(paramCharSequence, paramInt);
    int i = Character.charCount(i1);
    int k = paramInt - i;
    if (k == 0)
    {
      AppMethodBeat.o(189823);
      return 0;
    }
    if (i1 == 10)
    {
      j = i;
      if (Character.codePointBefore(paramCharSequence, k) == 13) {
        j = i + 1;
      }
      AppMethodBeat.o(189823);
      return paramInt - j;
    }
    if (isRegionalIndicatorSymbol(i1))
    {
      m = Character.codePointBefore(paramCharSequence, k);
      k -= Character.charCount(m);
      while ((k > 0) && (isRegionalIndicatorSymbol(m)))
      {
        m = Character.codePointBefore(paramCharSequence, k);
        k -= Character.charCount(m);
        j += 1;
      }
      k = i;
      if (j % 2 == 0) {
        k = i + 2;
      }
      AppMethodBeat.o(189823);
      return paramInt - k;
    }
    if (i1 == 8419)
    {
      m = Character.codePointBefore(paramCharSequence, k);
      j = k - Character.charCount(m);
      if ((j > 0) && (isVariationSelector(m)))
      {
        k = Character.codePointBefore(paramCharSequence, j);
        j = i;
        if (isKeycapBase(k))
        {
          j = Character.charCount(m);
          j = i + (Character.charCount(k) + j);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(189823);
        return paramInt - j;
        j = i;
        if (isKeycapBase(m)) {
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
      while ((j > 0) && (isTagSpecChar(m)))
      {
        i += Character.charCount(m);
        m = Character.codePointBefore(paramCharSequence, j);
        j -= Character.charCount(m);
      }
      if (!isEmoji(m))
      {
        AppMethodBeat.o(189823);
        return paramInt - 2;
      }
      n = i + Character.charCount(m);
    }
    i = n;
    i1 = j;
    k = m;
    if (isVariationSelector(m))
    {
      k = Character.codePointBefore(paramCharSequence, j);
      if (!isEmoji(k))
      {
        AppMethodBeat.o(189823);
        return paramInt - n;
      }
      i = n + Character.charCount(k);
      i1 = j - i;
    }
    if (isEmoji(k))
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
        label511:
        if (isEmojiModifier(n))
        {
          n = Character.codePointBefore(paramCharSequence, m);
          m -= Character.charCount(n);
          j = n;
          i = i2;
          if (m > 0)
          {
            j = n;
            i = i2;
            if (isVariationSelector(n))
            {
              j = Character.codePointBefore(paramCharSequence, m);
              if (!isEmoji(j))
              {
                AppMethodBeat.o(189823);
                return paramInt - k;
              }
              i = Character.charCount(j);
              Character.charCount(j);
            }
          }
          i1 = k;
          if (isEmojiModifierBase(j)) {
            i1 = k + (Character.charCount(j) + i);
          }
        }
      }
    }
    for (;;)
    {
      label630:
      AppMethodBeat.o(189823);
      return paramInt - i1;
      if (m > 0)
      {
        n = Character.codePointBefore(paramCharSequence, m);
        m -= Character.charCount(n);
        if (n == 8205)
        {
          n = Character.codePointBefore(paramCharSequence, m);
          m -= Character.charCount(n);
          if ((m > 0) && (isVariationSelector(n)))
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
          break label630;
        }
        i1 = k;
        if (j == 0) {
          break label630;
        }
        i1 = k;
        if (!isEmoji(n)) {
          break label630;
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
      break label511;
      i1 = i;
    }
  }
  
  public boolean isEmoji(int paramInt)
  {
    AppMethodBeat.i(189773);
    boolean bool = this.flutterJNI.nativeFlutterTextUtilsIsEmoji(paramInt);
    AppMethodBeat.o(189773);
    return bool;
  }
  
  public boolean isEmojiModifier(int paramInt)
  {
    AppMethodBeat.i(189783);
    boolean bool = this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifier(paramInt);
    AppMethodBeat.o(189783);
    return bool;
  }
  
  public boolean isEmojiModifierBase(int paramInt)
  {
    AppMethodBeat.i(189790);
    boolean bool = this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifierBase(paramInt);
    AppMethodBeat.o(189790);
    return bool;
  }
  
  public boolean isKeycapBase(int paramInt)
  {
    return ((48 <= paramInt) && (paramInt <= 57)) || (paramInt == 35) || (paramInt == 42);
  }
  
  public boolean isRegionalIndicatorSymbol(int paramInt)
  {
    AppMethodBeat.i(189805);
    boolean bool = this.flutterJNI.nativeFlutterTextUtilsIsRegionalIndicator(paramInt);
    AppMethodBeat.o(189805);
    return bool;
  }
  
  public boolean isTagSpecChar(int paramInt)
  {
    return (917536 <= paramInt) && (paramInt <= 917630);
  }
  
  public boolean isVariationSelector(int paramInt)
  {
    AppMethodBeat.i(189798);
    boolean bool = this.flutterJNI.nativeFlutterTextUtilsIsVariationSelector(paramInt);
    AppMethodBeat.o(189798);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.editing.FlutterTextUtils
 * JD-Core Version:    0.7.0.1
 */