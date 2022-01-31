package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

final class ImageGalleryUI$3
  implements n.c
{
  ImageGalleryUI$3(ImageGalleryUI paramImageGalleryUI, List paramList1, List paramList2) {}
  
  public final void a(l paraml)
  {
    paraml.clear();
    int i = 0;
    while (i < this.jfS.size())
    {
      paraml.e(((Integer)this.jfS.get(i)).intValue(), (CharSequence)this.jfT.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */