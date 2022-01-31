package com.tencent.mm.plugin.sns.ui;

import android.graphics.BitmapFactory;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.b;

final class SnsCommentDetailUI$21
  implements f.a
{
  SnsCommentDetailUI$21(SnsCommentDetailUI paramSnsCommentDetailUI, PhotosContent paramPhotosContent, b paramb, TagImageView paramTagImageView) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(38801);
    MaskImageView localMaskImageView = (MaskImageView)this.rPx.findViewById(2131828139);
    if (localMaskImageView != null)
    {
      localMaskImageView.setVisibility(0);
      localMaskImageView.setImageBitmap(BitmapFactory.decodeFile(paramString));
      float f1 = i.a(this.rPy.rqx, 1, this.rPy.rqt, this.rPy.rqu);
      float f2 = i.a(this.rPy.rqy, 1, this.rPy.rqt, this.rPy.rqu);
      float f3 = i.a(this.rPy.rqz, 1, this.rPy.rqt, this.rPy.rqu);
      float f4 = i.a(this.rPy.rqA, 1, this.rPy.rqt, this.rPy.rqu);
      paramString = new FrameLayout.LayoutParams((int)f1, (int)f2);
      paramString.setMargins((int)(this.rPz.getRight() - f3 - f1), (int)(this.rPz.getBottom() - f4 - f2), 0, 0);
      localMaskImageView.setLayoutParams(paramString);
    }
    AppMethodBeat.o(38801);
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.21
 * JD-Core Version:    0.7.0.1
 */