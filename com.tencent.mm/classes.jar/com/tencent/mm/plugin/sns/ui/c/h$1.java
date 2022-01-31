package com.tencent.mm.plugin.sns.ui.c;

import android.graphics.BitmapFactory;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;

final class h$1
  implements f.a
{
  h$1(h paramh, PhotosContent paramPhotosContent, b paramb, TagImageView paramTagImageView) {}
  
  public final void Op(String paramString)
  {
    this.pnZ.pnY = ((MaskImageView)this.oWZ.findViewById(i.f.media_icon));
    if (this.pnZ.pnY != null)
    {
      this.pnZ.pnY.setVisibility(0);
      paramString = BitmapFactory.decodeFile(paramString);
      this.pnZ.pnY.setImageBitmap(paramString);
      float f1 = i.a(this.oXa.oBn, 1, this.oXa.oBj, this.oXa.oBk);
      float f2 = i.a(this.oXa.oBo, 1, this.oXa.oBj, this.oXa.oBk);
      float f3 = i.a(this.oXa.oBp, 1, this.oXa.oBj, this.oXa.oBk);
      float f4 = i.a(this.oXa.oBq, 1, this.oXa.oBj, this.oXa.oBk);
      paramString = new FrameLayout.LayoutParams((int)f1, (int)f2);
      paramString.setMargins((int)(this.oXb.getRight() - f3 - f1), (int)(this.oXb.getBottom() - f4 - f2), 0, 0);
      this.pnZ.pnY.setLayoutParams(paramString);
    }
  }
  
  public final void bCF() {}
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.h.1
 * JD-Core Version:    0.7.0.1
 */