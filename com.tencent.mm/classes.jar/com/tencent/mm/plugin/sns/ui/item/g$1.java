package com.tencent.mm.plugin.sns.ui.item;

import android.graphics.BitmapFactory;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;

final class g$1
  implements f.a
{
  g$1(g paramg, PhotosContent paramPhotosContent, b paramb, TagImageView paramTagImageView) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(40153);
    g.a(this.sim, (MaskImageView)this.rPx.findViewById(2131828139));
    if (g.a(this.sim) != null)
    {
      g.a(this.sim).setVisibility(0);
      paramString = BitmapFactory.decodeFile(paramString);
      g.a(this.sim).setImageBitmap(paramString);
      float f1 = i.a(this.rPy.rqx, 1, this.rPy.rqt, this.rPy.rqu);
      float f2 = i.a(this.rPy.rqy, 1, this.rPy.rqt, this.rPy.rqu);
      float f3 = i.a(this.rPy.rqz, 1, this.rPy.rqt, this.rPy.rqu);
      float f4 = i.a(this.rPy.rqA, 1, this.rPy.rqt, this.rPy.rqu);
      paramString = new FrameLayout.LayoutParams((int)f1, (int)f2);
      paramString.setMargins((int)(this.rPz.getRight() - f3 - f1), (int)(this.rPz.getBottom() - f4 - f2), 0, 0);
      g.a(this.sim).setLayoutParams(paramString);
    }
    AppMethodBeat.o(40153);
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.g.1
 * JD-Core Version:    0.7.0.1
 */