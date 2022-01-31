package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

class CharsetRecog_mbcs$CharsetRecog_euc$CharsetRecog_euc_kr
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
    AppMethodBeat.i(104737);
    int i = match(paramCharsetDetector, commonChars);
    if (i == 0)
    {
      AppMethodBeat.o(104737);
      return null;
    }
    paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
    AppMethodBeat.o(104737);
    return paramCharsetDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_kr
 * JD-Core Version:    0.7.0.1
 */