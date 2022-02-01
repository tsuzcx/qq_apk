package com.tencent.mm.plugin.music.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation;", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "roundRate", "", "(F)V", "getRoundRate", "()F", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "Companion", "plugin-music_release"})
public final class FloatBallMusicView$b
  implements b.h
{
  private static final b AmJ;
  public static final a AmK;
  private final float iaU = 0.25F;
  
  static
  {
    AppMethodBeat.i(219998);
    AmK = new a((byte)0);
    AmJ = new b();
    AppMethodBeat.o(219998);
  }
  
  public final Bitmap J(Bitmap paramBitmap)
  {
    AppMethodBeat.i(219997);
    p.h(paramBitmap, "bitmap");
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      AppMethodBeat.o(219997);
      return paramBitmap;
    }
    try
    {
      Object localObject;
      if (paramBitmap.getWidth() == paramBitmap.getHeight()) {
        localObject = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, paramBitmap.getWidth() * this.iaU);
      }
      while (localObject != null)
      {
        AppMethodBeat.o(219997);
        return localObject;
        int j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
        int i = j;
        if (j <= 0) {
          i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
        }
        Bitmap localBitmap = BitmapUtil.getCenterCropBitmap(paramBitmap, i, i, true);
        localObject = localBitmap;
        if (localBitmap != null) {
          localObject = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() * this.iaU);
        }
      }
      return paramBitmap;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallMusicView", (Throwable)localException, "getRoundBitmap exception", new Object[0]);
      AppMethodBeat.o(219997);
    }
  }
  
  public final String Lb()
  {
    return "FloatBallMusicCover";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation;", "getINSTANCE", "()Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation;", "plugin-music_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicView.b
 * JD-Core Version:    0.7.0.1
 */