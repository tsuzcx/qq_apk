package com.tencent.ttpic.util;

import com.tencent.ttpic.model.StickerItem;
import java.util.Comparator;

final class VideoTemplateParser$2
  implements Comparator<StickerItem>
{
  public final int compare(StickerItem paramStickerItem1, StickerItem paramStickerItem2)
  {
    return paramStickerItem1.zIndex - paramStickerItem2.zIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoTemplateParser.2
 * JD-Core Version:    0.7.0.1
 */