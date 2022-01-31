package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

class CharsetRecog_sbcs$CharsetRecog_IBM420_ar_rtl
  extends CharsetRecog_sbcs.CharsetRecog_IBM420_ar
{
  private static int[] ngrams = { 4216497, 4216509, 4216918, 4233905, 4238300, 4239793, 4242365, 4247382, 5652566, 5654080, 5661504, 5666112, 5681472, 5681481, 5681494, 5681496, 5681507, 5681511, 5681513, 5681523, 5681528, 5681562, 5681581, 5681595, 5681615, 5681628, 5684032, 5684544, 5684579, 5783638, 6438998, 6439083, 6439089, 6439099, 6439119, 6504534, 7553110, 7561792, 7684182, 7692864, 7880790, 10109014, 10138074, 11263040, 11616342, 11625024, 11655744, 11656256, 12271702, 12277312, 12280384, 12303680, 12402774, 12533846, 12539456, 13588145, 13614400, 14303318, 14434390, 14434491, 14434511, 14443072, 14447936, 14466368 };
  
  public String getName()
  {
    return "IBM420_rtl";
  }
  
  public CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    AppMethodBeat.i(104715);
    int i = matchIBM420(paramCharsetDetector, ngrams, byteMap, (byte)64);
    if (i == 0)
    {
      AppMethodBeat.o(104715);
      return null;
    }
    paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
    AppMethodBeat.o(104715);
    return paramCharsetDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.CharsetRecog_IBM420_ar_rtl
 * JD-Core Version:    0.7.0.1
 */