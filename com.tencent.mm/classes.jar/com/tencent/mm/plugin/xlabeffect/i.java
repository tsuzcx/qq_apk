package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/WeVisModelUtil;", "", "()V", "TAG", "", "defaultKeyList", "", "getModelMap", "", "keyArray", "tryUseMiniSegmentModel", "", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  private static final String TAG;
  public static final i XKn;
  private static final List<String> XKo;
  
  static
  {
    AppMethodBeat.i(261644);
    XKn = new i();
    TAG = "MicroMsg.WeVisModelUtil";
    XKo = p.listOf(new String[] { "MODEL_FACE_ALIGNMENT", "MODEL_FACE_DETECT", "MODEL_FACE_OCCULASIONSEG", "MODEL_HAND", "MODEL_PORTRAITSEGMENT", "MODEL_FACE3D_XBIN" });
    AppMethodBeat.o(261644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.i
 * JD-Core Version:    0.7.0.1
 */