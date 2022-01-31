package com.tencent.ttpic.filter;

import com.tencent.ttpic.face.Face;
import java.util.Comparator;

class VideoFilterList$1
  implements Comparator<Face>
{
  VideoFilterList$1(VideoFilterList paramVideoFilterList) {}
  
  public int compare(Face paramFace1, Face paramFace2)
  {
    return paramFace1.faceIndex - paramFace2.faceIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFilterList.1
 * JD-Core Version:    0.7.0.1
 */