package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;
import java.util.List;

final class ImageGalleryUI$8
  implements n.c
{
  ImageGalleryUI$8(ImageGalleryUI paramImageGalleryUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(153866);
    ImageGalleryUI.a(this.zME).setFooterView(null);
    paraml.clear();
    int i = 0;
    if (i < this.loL.size())
    {
      if (((Integer)this.loL.get(i)).intValue() == 3) {
        ImageGalleryUI.a(this.zME).setFooterView(ImageGalleryUI.d(this.zME, (String)this.loM.get(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        paraml.e(((Integer)this.loL.get(i)).intValue(), (CharSequence)this.loM.get(i));
      }
    }
    AppMethodBeat.o(153866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.8
 * JD-Core Version:    0.7.0.1
 */