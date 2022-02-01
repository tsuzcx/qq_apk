package com.tencent.mm.videocomposition;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 15}, hxE={""}, hxF={"saveTexture", "Landroid/graphics/Bitmap;", "texture", "", "width", "height", "centerCrop", "", "Landroid/graphics/Rect;", "target", "targetWidth", "targetHeight", "copy", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "Lcom/tencent/mm/videocomposition/TrackTransition;", "Lcom/tencent/mm/videocomposition/VideoComposition;", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "scale", "", "toFloatArray", "", "Lorg/json/JSONArray;", "toIntArray", "", "toLongArray", "", "video_composition_release"})
public final class l
{
  public static final void c(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(216763);
    p.h(paramRect1, "$this$centerCrop");
    p.h(paramRect2, "target");
    float f1 = paramRect2.width() * 1.0F / paramRect1.width();
    float f2 = paramRect2.height() * 1.0F / paramRect1.height();
    if (f1 > f2)
    {
      i = (int)((f1 * paramRect1.height() - paramRect2.height()) / 2.0F);
      paramRect1.set(paramRect2);
      paramRect1.top -= i;
      paramRect1.bottom = (i + paramRect1.bottom);
      AppMethodBeat.o(216763);
      return;
    }
    int i = (int)((paramRect1.width() * f2 - paramRect2.width()) / 2.0F);
    paramRect1.set(paramRect2);
    paramRect1.left -= i;
    paramRect1.right = (i + paramRect1.right);
    AppMethodBeat.o(216763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.videocomposition.l
 * JD-Core Version:    0.7.0.1
 */