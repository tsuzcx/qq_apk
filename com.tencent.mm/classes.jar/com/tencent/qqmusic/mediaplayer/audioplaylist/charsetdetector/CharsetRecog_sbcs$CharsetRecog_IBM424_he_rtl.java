package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_sbcs$CharsetRecog_IBM424_he_rtl
  extends CharsetRecog_sbcs.CharsetRecog_IBM424_he
{
  private static int[] ngrams = { 4211014, 4211016, 4211025, 4211057, 4211281, 4211286, 4212033, 4212038, 4212049, 4212054, 4212066, 4212073, 4212081, 4215873, 4215877, 4216385, 4219476, 4221268, 4288832, 4538433, 4538434, 4538437, 4538452, 4538454, 4538473, 4539969, 4604224, 4609344, 4609856, 4614208, 4616512, 5324869, 5326144, 5326449, 5329237, 5330240, 5330752, 5335104, 5337408, 5521473, 5521477, 5521728, 5522752, 5587009, 5587010, 5587013, 5587028, 5587030, 5587049, 5653824, 5718085, 5784896, 5787968, 5787989, 6444096, 6832197, 6836565, 6902848, 7422017, 7422018, 7422021, 7422036, 7422038, 7422057 };
  
  public String getName()
  {
    return "IBM424_rtl";
  }
  
  public CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    int i = match(paramCharsetDetector, ngrams, byteMap, (byte)64);
    if (i == 0) {
      return null;
    }
    return new CharsetMatch(paramCharsetDetector, this, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.CharsetRecog_IBM424_he_rtl
 * JD-Core Version:    0.7.0.1
 */