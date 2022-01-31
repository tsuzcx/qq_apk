package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class SightPlayAutoSizeImageView$a
  extends b
{
  private WeakReference<SightPlayAutoSizeImageView> qTS;
  
  public SightPlayAutoSizeImageView$a(SightPlayAutoSizeImageView paramSightPlayAutoSizeImageView)
  {
    super(0, paramSightPlayAutoSizeImageView);
    AppMethodBeat.i(24956);
    this.qTS = new WeakReference(paramSightPlayAutoSizeImageView);
    AppMethodBeat.o(24956);
  }
  
  public final void S(Bitmap paramBitmap)
  {
    AppMethodBeat.i(24957);
    SightPlayAutoSizeImageView localSightPlayAutoSizeImageView = (SightPlayAutoSizeImageView)this.qTS.get();
    if (localSightPlayAutoSizeImageView == null)
    {
      ab.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
      clear();
      AppMethodBeat.o(24957);
      return;
    }
    localSightPlayAutoSizeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localSightPlayAutoSizeImageView.setImageBitmap(paramBitmap);
    AppMethodBeat.o(24957);
  }
  
  public final int cmz()
  {
    return 2131034258;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayAutoSizeImageView.a
 * JD-Core Version:    0.7.0.1
 */