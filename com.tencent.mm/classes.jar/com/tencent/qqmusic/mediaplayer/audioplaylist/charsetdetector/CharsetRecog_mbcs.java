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
    iteratedChar localiteratedChar = new iteratedChar();
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
  
  abstract boolean nextChar(iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector);
  
  static class CharsetRecog_big5
    extends CharsetRecog_mbcs
  {
    static int[] commonChars = { 41280, 41281, 41282, 41283, 41287, 41289, 41333, 41334, 42048, 42054, 42055, 42056, 42065, 42068, 42071, 42084, 42090, 42092, 42103, 42147, 42148, 42151, 42177, 42190, 42193, 42207, 42216, 42237, 42304, 42312, 42328, 42345, 42445, 42471, 42583, 42593, 42594, 42600, 42608, 42664, 42675, 42681, 42707, 42715, 42726, 42738, 42816, 42833, 42841, 42970, 43171, 43173, 43181, 43217, 43219, 43236, 43260, 43456, 43474, 43507, 43627, 43706, 43710, 43724, 43772, 44103, 44111, 44208, 44242, 44377, 44745, 45024, 45290, 45423, 45747, 45764, 45935, 46156, 46158, 46412, 46501, 46525, 46544, 46552, 46705, 47085, 47207, 47428, 47832, 47940, 48033, 48593, 49860, 50105, 50240, 50271 };
    
    public String getLanguage()
    {
      return "zh";
    }
    
    String getName()
    {
      return "Big5";
    }
    
    CharsetMatch match(CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(76650);
      int i = match(paramCharsetDetector, commonChars);
      if (i == 0)
      {
        AppMethodBeat.o(76650);
        return null;
      }
      paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
      AppMethodBeat.o(76650);
      return paramCharsetDetector;
    }
    
    boolean nextChar(CharsetRecog_mbcs.iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(76649);
      paramiteratedChar.error = false;
      int i = paramiteratedChar.nextByte(paramCharsetDetector);
      paramiteratedChar.charValue = i;
      if (i < 0)
      {
        AppMethodBeat.o(76649);
        return false;
      }
      if ((i <= 127) || (i == 255))
      {
        AppMethodBeat.o(76649);
        return true;
      }
      i = paramiteratedChar.nextByte(paramCharsetDetector);
      if (i < 0)
      {
        AppMethodBeat.o(76649);
        return false;
      }
      paramiteratedChar.charValue = (paramiteratedChar.charValue << 8 | i);
      if ((i < 64) || (i == 127) || (i == 255)) {
        paramiteratedChar.error = true;
      }
      AppMethodBeat.o(76649);
      return true;
    }
  }
  
  static abstract class CharsetRecog_euc
    extends CharsetRecog_mbcs
  {
    boolean nextChar(CharsetRecog_mbcs.iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector)
    {
      paramiteratedChar.error = false;
      int i = paramiteratedChar.nextByte(paramCharsetDetector);
      paramiteratedChar.charValue = i;
      if (i < 0) {
        paramiteratedChar.done = true;
      }
      while (!paramiteratedChar.done)
      {
        return true;
        if (i > 141)
        {
          int j = paramiteratedChar.nextByte(paramCharsetDetector);
          paramiteratedChar.charValue = (paramiteratedChar.charValue << 8 | j);
          if ((i >= 161) && (i <= 254))
          {
            if (j < 161) {
              paramiteratedChar.error = true;
            }
          }
          else if (i == 142)
          {
            if (j < 161) {
              paramiteratedChar.error = true;
            }
          }
          else if (i == 143)
          {
            i = paramiteratedChar.nextByte(paramCharsetDetector);
            paramiteratedChar.charValue = (paramiteratedChar.charValue << 8 | i);
            if (i < 161) {
              paramiteratedChar.error = true;
            }
          }
        }
      }
      return false;
    }
    
    static class CharsetRecog_euc_jp
      extends CharsetRecog_mbcs.CharsetRecog_euc
    {
      static int[] commonChars = { 41377, 41378, 41379, 41382, 41404, 41418, 41419, 41430, 41431, 42146, 42148, 42150, 42152, 42154, 42155, 42156, 42157, 42159, 42161, 42163, 42165, 42167, 42169, 42171, 42173, 42175, 42176, 42177, 42179, 42180, 42182, 42183, 42184, 42185, 42186, 42187, 42190, 42191, 42192, 42206, 42207, 42209, 42210, 42212, 42216, 42217, 42218, 42219, 42220, 42223, 42226, 42227, 42402, 42403, 42404, 42406, 42407, 42410, 42413, 42415, 42416, 42419, 42421, 42423, 42424, 42425, 42431, 42435, 42438, 42439, 42440, 42441, 42443, 42448, 42453, 42454, 42455, 42462, 42464, 42465, 42469, 42473, 42474, 42475, 42476, 42477, 42483, 47273, 47572, 47854, 48072, 48880, 49079, 50410, 50940, 51133, 51896, 51955, 52188, 52689 };
      
      public String getLanguage()
      {
        return "ja";
      }
      
      String getName()
      {
        return "EUC-JP";
      }
      
      CharsetMatch match(CharsetDetector paramCharsetDetector)
      {
        AppMethodBeat.i(76639);
        int i = match(paramCharsetDetector, commonChars);
        if (i == 0)
        {
          AppMethodBeat.o(76639);
          return null;
        }
        paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
        AppMethodBeat.o(76639);
        return paramCharsetDetector;
      }
    }
    
    static class CharsetRecog_euc_kr
      extends CharsetRecog_mbcs.CharsetRecog_euc
    {
      static int[] commonChars = { 45217, 45235, 45253, 45261, 45268, 45286, 45293, 45304, 45306, 45308, 45496, 45497, 45511, 45527, 45538, 45994, 46011, 46274, 46287, 46297, 46315, 46501, 46517, 46527, 46535, 46569, 46835, 47023, 47042, 47054, 47270, 47278, 47286, 47288, 47291, 47337, 47531, 47534, 47564, 47566, 47613, 47800, 47822, 47824, 47857, 48103, 48115, 48125, 48301, 48314, 48338, 48374, 48570, 48576, 48579, 48581, 48838, 48840, 48863, 48878, 48888, 48890, 49057, 49065, 49088, 49124, 49131, 49132, 49144, 49319, 49327, 49336, 49338, 49339, 49341, 49351, 49356, 49358, 49359, 49366, 49370, 49381, 49403, 49404, 49572, 49574, 49590, 49622, 49631, 49654, 49656, 50337, 50637, 50862, 51151, 51153, 51154, 51160, 51173, 51373 };
      
      public String getLanguage()
      {
        return "ko";
      }
      
      String getName()
      {
        return "EUC-KR";
      }
      
      CharsetMatch match(CharsetDetector paramCharsetDetector)
      {
        AppMethodBeat.i(76614);
        int i = match(paramCharsetDetector, commonChars);
        if (i == 0)
        {
          AppMethodBeat.o(76614);
          return null;
        }
        paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
        AppMethodBeat.o(76614);
        return paramCharsetDetector;
      }
    }
  }
  
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
      AppMethodBeat.i(76666);
      int i = match(paramCharsetDetector, commonChars);
      if (i == 0)
      {
        AppMethodBeat.o(76666);
        return null;
      }
      paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
      AppMethodBeat.o(76666);
      return paramCharsetDetector;
    }
    
    boolean nextChar(CharsetRecog_mbcs.iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(76665);
      paramiteratedChar.error = false;
      int i = paramiteratedChar.nextByte(paramCharsetDetector);
      paramiteratedChar.charValue = i;
      if (i < 0) {
        paramiteratedChar.done = true;
      }
      while (!paramiteratedChar.done)
      {
        AppMethodBeat.o(76665);
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
      AppMethodBeat.o(76665);
      return false;
    }
  }
  
  static class CharsetRecog_sjis
    extends CharsetRecog_mbcs
  {
    static int[] commonChars = { 33088, 33089, 33090, 33093, 33115, 33129, 33130, 33141, 33142, 33440, 33442, 33444, 33449, 33450, 33451, 33453, 33455, 33457, 33459, 33461, 33463, 33469, 33470, 33473, 33476, 33477, 33478, 33480, 33481, 33484, 33485, 33500, 33504, 33511, 33512, 33513, 33514, 33520, 33521, 33601, 33603, 33614, 33615, 33624, 33630, 33634, 33639, 33653, 33654, 33673, 33674, 33675, 33677, 33683, 36502, 37882, 38314 };
    
    public String getLanguage()
    {
      return "ja";
    }
    
    String getName()
    {
      return "Shift_JIS";
    }
    
    CharsetMatch match(CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(76664);
      int i = match(paramCharsetDetector, commonChars);
      if (i == 0)
      {
        AppMethodBeat.o(76664);
        return null;
      }
      paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
      AppMethodBeat.o(76664);
      return paramCharsetDetector;
    }
    
    boolean nextChar(CharsetRecog_mbcs.iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(76663);
      paramiteratedChar.error = false;
      int i = paramiteratedChar.nextByte(paramCharsetDetector);
      paramiteratedChar.charValue = i;
      if (i < 0)
      {
        AppMethodBeat.o(76663);
        return false;
      }
      if ((i <= 127) || ((i > 160) && (i <= 223)))
      {
        AppMethodBeat.o(76663);
        return true;
      }
      int j = paramiteratedChar.nextByte(paramCharsetDetector);
      if (j < 0)
      {
        AppMethodBeat.o(76663);
        return false;
      }
      paramiteratedChar.charValue = (i << 8 | j);
      if (((j < 64) || (j > 127)) && ((j < 128) || (j > 255))) {
        paramiteratedChar.error = true;
      }
      AppMethodBeat.o(76663);
      return true;
    }
  }
  
  static class iteratedChar
  {
    int charValue = 0;
    boolean done = false;
    boolean error = false;
    int nextIndex = 0;
    
    int nextByte(CharsetDetector paramCharsetDetector)
    {
      if (this.nextIndex >= paramCharsetDetector.fRawLength)
      {
        this.done = true;
        return -1;
      }
      paramCharsetDetector = paramCharsetDetector.fRawInput;
      int i = this.nextIndex;
      this.nextIndex = (i + 1);
      return paramCharsetDetector[i] & 0xFF;
    }
    
    void reset()
    {
      this.charValue = 0;
      this.nextIndex = 0;
      this.error = false;
      this.done = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
 * JD-Core Version:    0.7.0.1
 */