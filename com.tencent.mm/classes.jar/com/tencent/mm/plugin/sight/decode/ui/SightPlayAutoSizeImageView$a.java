package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class SightPlayAutoSizeImageView$a
  extends b
{
  private WeakReference<SightPlayAutoSizeImageView> ofE;
  
  public SightPlayAutoSizeImageView$a(SightPlayAutoSizeImageView paramSightPlayAutoSizeImageView)
  {
    super(0, paramSightPlayAutoSizeImageView);
    this.ofE = new WeakReference(paramSightPlayAutoSizeImageView);
  }
  
  public final void G(Bitmap paramBitmap)
  {
    SightPlayAutoSizeImageView localSightPlayAutoSizeImageView = (SightPlayAutoSizeImageView)this.ofE.get();
    if (localSightPlayAutoSizeImageView == null)
    {
      y.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
      clear();
      return;
    }
    localSightPlayAutoSizeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localSightPlayAutoSizeImageView.setImageBitmap(paramBitmap);
  }
  
  protected final int bAZ()
  {
    return R.a.sight_loop;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayAutoSizeImageView.a
 * JD-Core Version:    0.7.0.1
 */