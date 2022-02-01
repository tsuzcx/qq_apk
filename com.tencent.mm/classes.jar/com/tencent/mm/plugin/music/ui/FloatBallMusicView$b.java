package com.tencent.mm.plugin.music.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation;", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "roundRate", "", "(F)V", "getRoundRate", "()F", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "Companion", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FloatBallMusicView$b
  implements b.h
{
  public static final FloatBallMusicView.b.a LOP;
  private static final b LOQ;
  private final float nrd = 0.16F;
  
  static
  {
    AppMethodBeat.i(270920);
    LOP = new FloatBallMusicView.b.a((byte)0);
    LOQ = new b();
    AppMethodBeat.o(270920);
  }
  
  public final Bitmap P(Bitmap paramBitmap)
  {
    AppMethodBeat.i(270924);
    s.u(paramBitmap, "bitmap");
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      AppMethodBeat.o(270924);
      return paramBitmap;
    }
    try
    {
      Object localObject;
      if (paramBitmap.getWidth() == paramBitmap.getHeight()) {
        localObject = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, paramBitmap.getWidth() * this.nrd);
      }
      while (localObject != null)
      {
        AppMethodBeat.o(270924);
        return localObject;
        int j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
        int i = j;
        if (j <= 0) {
          i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
        }
        Bitmap localBitmap = BitmapUtil.getCenterCropBitmap(paramBitmap, i, i, true);
        localObject = localBitmap;
        if (localBitmap != null) {
          localObject = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() * this.nrd);
        }
      }
      return paramBitmap;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallMusicView", (Throwable)localException, "getRoundBitmap exception", new Object[0]);
      AppMethodBeat.o(270924);
    }
  }
  
  public final String key()
  {
    return "FloatBallMusicCover";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicView.b
 * JD-Core Version:    0.7.0.1
 */