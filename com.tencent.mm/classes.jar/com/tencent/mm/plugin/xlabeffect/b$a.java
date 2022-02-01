package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffect$Companion;", "", "()V", "CW_ROTATE_0", "", "CW_ROTATE_180", "CW_ROTATE_270", "CW_ROTATE_90", "DEFAULT_STICKER_INTERVAL", "", "EFFECT_TYPE_EYE_BRIGHT", "EFFECT_TYPE_EYE_MORPH", "EFFECT_TYPE_FACE_MORPH", "EFFECT_TYPE_FACE_MORPH_LIVE", "EFFECT_TYPE_FILTER", "EFFECT_TYPE_MAKEUP_BLUSHER", "EFFECT_TYPE_MAKEUP_CONTOURS", "EFFECT_TYPE_MAKEUP_EYEBROW", "EFFECT_TYPE_MAKEUP_EYESHADOW", "EFFECT_TYPE_MAKEUP_LIP", "EFFECT_TYPE_REMOVE_BG", "EFFECT_TYPE_ROSY", "EFFECT_TYPE_SKIN_BRIGHT", "EFFECT_TYPE_SKIN_BRIGHT_LIVE", "EFFECT_TYPE_SKIN_SMOOTH", "EFFECT_TYPE_SKIN_SMOOTH_LIVE", "EFFECT_TYPE_STICKER_BACK", "EFFECT_TYPE_STICKER_FACE", "EFFECT_TYPE_STICKER_FRONT", "MAKEUP_TYPE_BLUSHER", "MAKEUP_TYPE_CONTOURS", "MAKEUP_TYPE_EYEBROW", "MAKEUP_TYPE_EYESHADOW", "MAKEUP_TYPE_LIP", "MM_KVSTAT_RunWithGPU", "RENDER_FORMAT_BGR", "RENDER_FORMAT_BGRA", "RENDER_FORMAT_NV12", "RENDER_FORMAT_NV21", "RENDER_FORMAT_RGB", "RENDER_FORMAT_RGBA", "STICKER_TYPE_DEFORMATION", "STICKER_TYPE_FIXED", "STICKER_TYPE_NORMAL", "STICKER_TYPE_SEGMENT", "TAG", "", "TRACKER_CAT", "getTRACKER_CAT", "()I", "TRACKER_FACE", "getTRACKER_FACE", "TRACKER_FACE_ACTION", "getTRACKER_FACE_ACTION", "TRACKER_GESTURE", "getTRACKER_GESTURE", "TRACKER_MIRROR", "getTRACKER_MIRROR", "TRACKER_NORMAL", "getTRACKER_NORMAL", "TRACKER_SCENE_CLS", "getTRACKER_SCENE_CLS", "TRACKER_SEGMENT", "getTRACKER_SEGMENT", "TRACKER_STICKER_2D", "getTRACKER_STICKER_2D", "TRACKER_STICKER_3D", "getTRACKER_STICKER_3D", "VIDEO_LABEL_NUM", "isEnabled", "", "tryLoadLibrary", "", "plugin-xlabeffect_release"})
public final class b$a
{
  public static boolean isEnabled()
  {
    AppMethodBeat.i(90506);
    com.tencent.mm.plugin.expansions.d locald = com.tencent.mm.plugin.expansions.d.rNG;
    boolean bool = com.tencent.mm.plugin.expansions.d.aoc("xlab");
    AppMethodBeat.o(90506);
    return bool;
  }
  
  public static void tryLoadLibrary()
  {
    AppMethodBeat.i(90507);
    if (isEnabled())
    {
      com.tencent.mm.plugin.expansions.d locald = com.tencent.mm.plugin.expansions.d.rNG;
      com.tencent.mm.plugin.expansions.d.aoa("xlabeffect");
      d.gls();
    }
    AppMethodBeat.o(90507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.b.a
 * JD-Core Version:    0.7.0.1
 */