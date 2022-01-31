package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_sbcs$CharsetRecog_IBM424_he_ltr
  extends CharsetRecog_sbcs.CharsetRecog_IBM424_he
{
  private static int[] ngrams = { 4211014, 4211028, 4212049, 4212052, 4212054, 4212056, 4215128, 4215906, 4215913, 4216134, 4216145, 4216646, 4216657, 4220998, 4221009, 4223297, 4223302, 4223313, 4276293, 4276308, 4276309, 4276337, 4277568, 4277829, 4281408, 4281920, 4341829, 4341845, 4341873, 4538437, 4538449, 4538452, 4538453, 4538455, 4538472, 4538481, 4543552, 4604224, 4605248, 4735296, 5325120, 5325376, 5326144, 5521477, 5521493, 5521521, 5530176, 5531968, 5591377, 5591384, 5591400, 5652549, 5652565, 5652593, 5653056, 5653824, 6440256, 6897733, 6897749, 6897777, 6899008, 7422272, 7423296, 7423569 };
  
  public String getName()
  {
    return "IBM424_ltr";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.CharsetRecog_IBM424_he_ltr
 * JD-Core Version:    0.7.0.1
 */