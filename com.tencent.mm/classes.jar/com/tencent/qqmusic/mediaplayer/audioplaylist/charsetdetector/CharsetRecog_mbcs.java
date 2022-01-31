package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

abstract class CharsetRecog_mbcs
  extends CharsetRecognizer
{
  abstract String getName();
  
  int match(CharsetDetector paramCharsetDetector, int[] paramArrayOfInt)
  {
    int i3 = 0;
    CharsetRecog_mbcs.iteratedChar localiteratedChar = new CharsetRecog_mbcs.iteratedChar();
    localiteratedChar.reset();
    int i2 = 0;
    int k = 0;
    int i = 0;
    int j = 0;
    int m;
    int i1;
    int n;
    for (;;)
    {
      if (nextChar(localiteratedChar, paramCharsetDetector))
      {
        int i4 = i2 + 1;
        if (localiteratedChar.error)
        {
          m = k + 1;
          i1 = j;
          n = i;
          i2 = i4;
          k = m;
          i = n;
          j = i1;
          if (m < 2) {
            continue;
          }
          i2 = i4;
          k = m;
          i = n;
          j = i1;
          if (m * 5 < i1) {
            continue;
          }
          m = i3;
        }
      }
    }
    label235:
    label238:
    do
    {
      do
      {
        do
        {
          return m;
          long l = localiteratedChar.charValue & 0xFFFFFFFF;
          m = k;
          n = i;
          i1 = j;
          if (l <= 255L) {
            break;
          }
          j += 1;
          m = k;
          n = i;
          i1 = j;
          if (paramArrayOfInt == null) {
            break;
          }
          m = k;
          n = i;
          i1 = j;
          if (Arrays.binarySearch(paramArrayOfInt, (int)l) < 0) {
            break;
          }
          n = i + 1;
          m = k;
          i1 = j;
          break;
          if ((j > 10) || (k != 0)) {
            break label238;
          }
          if (j != 0) {
            break label235;
          }
          m = i3;
        } while (i2 < 10);
        return 10;
        m = i3;
      } while (j < k * 20);
      if (paramArrayOfInt != null) {
        break label280;
      }
      i = j + 30 - k * 20;
      m = i;
    } while (i <= 100);
    return 100;
    label280:
    return Math.min((int)(90.0D / Math.log(j / 4.0F) * Math.log(i + 1) + 10.0D), 100);
  }
  
  abstract boolean nextChar(CharsetRecog_mbcs.iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector);
  
  static class CharsetRecog_gb_18030
    extends CharsetRecog_mbcs
  {
    static int[] commonChars = { 41377, 41378, 41379, 41380, 41392, 41393, 41457, 41459, 41889, 41900, 41914, 45480, 45496, 45502, 45755, 46025, 46070, 46323, 46525, 46532, 46563, 46767, 46804, 46816, 47010, 47016, 47037, 47062, 47069, 47284, 47327, 47350, 47531, 47561, 47576, 47610, 47613, 47821, 48039, 48086, 48097, 48122, 48316, 48347, 48382, 48588, 48845, 48861, 49076, 49094, 49097, 49332, 49389, 49611, 49883, 50119, 50396, 50410, 50636, 50935, 51192, 51371, 51403, 51413, 51431, 51663, 51706, 51889, 51893, 51911, 51920, 51926, 51957, 51965, 52460, 52728, 52906, 52932, 52946, 52965, 53173, 53186, 53206, 53442, 53445, 53456, 53460, 53671, 53930, 53938, 53941, 53947, 53972, 54211, 54224, 54269, 54466, 54490, 54754, 54992 };
    
    public String getLanguage()
    {
      return "zh";
    }
    
    String getName()
    {
      return "GB18030";
    }
    
    CharsetMatch match(CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(104763);
      int i = match(paramCharsetDetector, commonChars);
      if (i == 0)
      {
        AppMethodBeat.o(104763);
        return null;
      }
      paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
      AppMethodBeat.o(104763);
      return paramCharsetDetector;
    }
    
    boolean nextChar(CharsetRecog_mbcs.iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(104762);
      paramiteratedChar.error = false;
      int i = paramiteratedChar.nextByte(paramCharsetDetector);
      paramiteratedChar.charValue = i;
      if (i < 0) {
        paramiteratedChar.done = true;
      }
      while (!paramiteratedChar.done)
      {
        AppMethodBeat.o(104762);
        return true;
        if (i > 128)
        {
          int j = paramiteratedChar.nextByte(paramCharsetDetector);
          paramiteratedChar.charValue = (paramiteratedChar.charValue << 8 | j);
          if ((i >= 129) && (i <= 254) && ((j < 64) || (j > 126)) && ((j < 80) || (j > 254)))
          {
            if ((j >= 48) && (j <= 57))
            {
              i = paramiteratedChar.nextByte(paramCharsetDetector);
              if ((i >= 129) && (i <= 254))
              {
                j = paramiteratedChar.nextByte(paramCharsetDetector);
                if ((j >= 48) && (j <= 57))
                {
                  paramiteratedChar.charValue = (i << 8 | paramiteratedChar.charValue << 16 | j);
                  continue;
                }
              }
            }
            paramiteratedChar.error = true;
          }
        }
      }
      AppMethodBeat.o(104762);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
 * JD-Core Version:    0.7.0.1
 */