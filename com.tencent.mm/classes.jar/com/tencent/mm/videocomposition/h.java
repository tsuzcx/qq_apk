package com.tencent.mm.videocomposition;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"saveTexture", "Landroid/graphics/Bitmap;", "texture", "", "width", "height", "centerCrop", "", "Landroid/graphics/Rect;", "target", "targetWidth", "targetHeight", "centerInside", "copy", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "Lcom/tencent/mm/videocomposition/TrackTransition;", "Lcom/tencent/mm/videocomposition/VideoComposition;", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "scale", "", "toFloatArray", "", "Lorg/json/JSONArray;", "toIntArray", "", "toLongArray", "", "video_composition_release"}, k=2, mv={1, 1, 15})
public final class h
{
  public static final void b(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(233480);
    s.t(paramRect, "$this$scale");
    paramRect.bottom = ((int)(paramRect.bottom * paramFloat));
    paramRect.left = ((int)(paramRect.left * paramFloat));
    paramRect.right = ((int)(paramRect.right * paramFloat));
    paramRect.top = ((int)(paramRect.top * paramFloat));
    AppMethodBeat.o(233480);
  }
  
  public static final void g(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(233474);
    s.t(paramRect1, "$this$centerCrop");
    s.t(paramRect2, "target");
    float f1 = paramRect2.width() * 1.0F / paramRect1.width();
    float f2 = paramRect2.height() * 1.0F / paramRect1.height();
    if (f1 > f2)
    {
      i = (int)((f1 * paramRect1.height() - paramRect2.height()) / 2.0F);
      paramRect1.set(paramRect2);
      paramRect1.top -= i;
      paramRect1.bottom = (i + paramRect1.bottom);
      AppMethodBeat.o(233474);
      return;
    }
    int i = (int)((paramRect1.width() * f2 - paramRect2.width()) / 2.0F);
    paramRect1.set(paramRect2);
    paramRect1.left -= i;
    paramRect1.right = (i + paramRect1.right);
    AppMethodBeat.o(233474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.h
 * JD-Core Version:    0.7.0.1
 */