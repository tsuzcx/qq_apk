package com.tencent.mm.plugin.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.a.b;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "mediaId", "", "path", "url", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "featureList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFeatureList", "()Ljava/util/ArrayList;", "setFeatureList", "(Ljava/util/ArrayList;)V", "imageAnimationType", "getImageAnimationType", "()I", "setImageAnimationType", "(I)V", "transitionId", "getTransitionId", "()Ljava/lang/String;", "setTransitionId", "(Ljava/lang/String;)V", "transitionLocalPath", "getTransitionLocalPath", "setTransitionLocalPath", "videoPlayRate", "", "getVideoPlayRate", "()F", "setVideoPlayRate", "(F)V", "isOnlyImage", "", "isSlowVideo", "Companion", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b
{
  public static final d.a TEU;
  public float TEV;
  public String TEW;
  public String TEX;
  public ArrayList<Integer> TEY;
  public int TEZ;
  
  static
  {
    AppMethodBeat.i(272065);
    TEU = new d.a((byte)0);
    AppMethodBeat.o(272065);
  }
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    AppMethodBeat.i(272058);
    this.TEV = 1.0F;
    this.TEY = new ArrayList();
    AppMethodBeat.o(272058);
  }
  
  public final boolean hLc()
  {
    AppMethodBeat.i(272068);
    boolean bool = this.TEY.contains(Integer.valueOf(1));
    AppMethodBeat.o(272068);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.d
 * JD-Core Version:    0.7.0.1
 */