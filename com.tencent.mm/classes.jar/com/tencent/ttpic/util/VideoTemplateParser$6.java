package com.tencent.ttpic.util;

import com.tencent.ttpic.model.GridModel;
import java.util.Comparator;

final class VideoTemplateParser$6
  implements Comparator<GridModel>
{
  public final int compare(GridModel paramGridModel1, GridModel paramGridModel2)
  {
    return paramGridModel1.zIndex - paramGridModel2.zIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoTemplateParser.6
 * JD-Core Version:    0.7.0.1
 */