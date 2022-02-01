package com.tencent.mm.plugin.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "mediaId", "", "path", "url", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "featureList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFeatureList", "()Ljava/util/ArrayList;", "setFeatureList", "(Ljava/util/ArrayList;)V", "imageAnimationType", "getImageAnimationType", "()I", "setImageAnimationType", "(I)V", "transitionId", "getTransitionId", "()Ljava/lang/String;", "setTransitionId", "(Ljava/lang/String;)V", "transitionLocalPath", "getTransitionLocalPath", "setTransitionLocalPath", "videoPlayRate", "", "getVideoPlayRate", "()F", "setVideoPlayRate", "(F)V", "isOnlyImage", "", "isSlowVideo", "Companion", "plugin-thumbplayer_release"})
public final class e
  extends d
{
  public static final e.a MSN;
  public float MSI;
  public String MSJ;
  public String MSK;
  public ArrayList<Integer> MSL;
  public int MSM;
  
  static
  {
    AppMethodBeat.i(192898);
    MSN = new e.a((byte)0);
    AppMethodBeat.o(192898);
  }
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    AppMethodBeat.i(192896);
    this.MSI = 1.0F;
    this.MSL = new ArrayList();
    AppMethodBeat.o(192896);
  }
  
  public final boolean gop()
  {
    AppMethodBeat.i(192892);
    boolean bool = this.MSL.contains(Integer.valueOf(1));
    AppMethodBeat.o(192892);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.e
 * JD-Core Version:    0.7.0.1
 */