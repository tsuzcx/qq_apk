package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

class CharsetRecog_sbcs$CharsetRecog_windows_1256
  extends CharsetRecog_sbcs
{
  private static byte[] byteMap = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 32, 32, 32, 32, 32, 32, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 32, 32, 32, 32, 32, 32, -127, 32, -125, 32, 32, 32, 32, -120, 32, -118, 32, -100, -115, -114, -113, -112, 32, 32, 32, 32, 32, 32, 32, -104, 32, -102, 32, -100, 32, 32, -97, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, -86, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, -75, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, -64, -63, -62, -61, -60, -59, -58, -57, -56, -55, -54, -53, -52, -51, -50, -49, -48, -47, -46, -45, -44, -43, -42, 32, -40, -39, -38, -37, -36, -35, -34, -33, -32, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -21, -20, -19, -18, -17, 32, 32, 32, 32, -12, 32, 32, 32, 32, -7, 32, -5, -4, 32, 32, -1 };
  private static int[] ngrams = { 2148321, 2148324, 2148551, 2153185, 2153965, 2154977, 2155492, 2156231, 13050055, 13091104, 13093408, 13095200, 13099296, 13099459, 13099463, 13099464, 13099466, 13099468, 13099469, 13099471, 13099475, 13099482, 13099486, 13099491, 13099494, 13099501, 13099808, 13100064, 13100234, 13115591, 13181127, 13181149, 13181153, 13181155, 13181158, 13246663, 13574343, 13617440, 13705415, 13748512, 13836487, 14295239, 14344684, 14544160, 14753991, 14797088, 14806048, 14806304, 14885063, 14927648, 14928160, 14935072, 14950599, 15016135, 15058720, 15124449, 15131680, 15474887, 15540423, 15540451, 15540454, 15583520, 15585568, 15590432 };
  
  public String getLanguage()
  {
    return "ar";
  }
  
  public String getName()
  {
    return "windows-1256";
  }
  
  public CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    AppMethodBeat.i(104726);
    int i = match(paramCharsetDetector, ngrams, byteMap);
    if (i == 0)
    {
      AppMethodBeat.o(104726);
      return null;
    }
    paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
    AppMethodBeat.o(104726);
    return paramCharsetDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.CharsetRecog_windows_1256
 * JD-Core Version:    0.7.0.1
 */