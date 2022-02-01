package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.plugin.xlabeffect.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.e;
import com.tencent.mm.videocomposition.g;
import com.tencent.mm.xeffect.effect.af;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "", "path", "", "type", "", "fromCamera", "(Ljava/lang/String;II)V", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "durationMs", "", "getDurationMs", "()J", "editInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "getEditInfo", "()Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "hasTransition", "", "getHasTransition", "()Z", "id", "getId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "sourceDuration", "getSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceScale", "getSourceScale", "setSourceScale", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "timeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transAssetPath", "getTransAssetPath", "transDuration", "getTransDuration", "transEffectId", "getTransEffectId", "transId", "getTransId", "setTransId", "getType", "setType", "volume", "getVolume", "setVolume", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "setTransition", "", "transition", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "transformTransEffectId", "effectMap", "", "updateTrack", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
{
  public static final ad.a UaB;
  public final d NXR;
  public int UaC;
  public int UaD;
  public float UaE;
  public final i UaF;
  public int UaG;
  public final MediaEditReportInfo.EditItem UaH;
  public final b UaI;
  int Uaj;
  public final int id;
  public String path;
  public int type;
  
  static
  {
    AppMethodBeat.i(283633);
    UaB = new ad.a((byte)0);
    Object localObject = c.XJQ;
    c.fXr();
    localObject = e.agDJ;
    e.jLT();
    AppMethodBeat.o(283633);
  }
  
  public ad(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283617);
    this.path = paramString;
    this.type = paramInt1;
    this.Uaj = paramInt2;
    this.id = hashCode();
    this.NXR = new d(0L, false, 3);
    this.UaE = 1.0F;
    this.UaF = new i();
    this.UaG = -1;
    this.UaH = new MediaEditReportInfo.EditItem();
    Log.i("MicroMsg.VLogCompositionTrack", "create VLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id);
    String str = y.n(this.path, false);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    this.UaI = new b(paramString, this.type);
    AppMethodBeat.o(283617);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(283750);
    if (parama != null)
    {
      this.UaG = parama.order;
      this.UaI.TDy.setPath(parama.assetPath);
      this.UaI.TDy.duration = parama.duration;
      AppMethodBeat.o(283750);
      return;
    }
    this.UaG = -1;
    this.UaI.TDy.setPath("");
    this.UaI.TDy.duration = 0L;
    AppMethodBeat.o(283750);
  }
  
  public final long getDurationMs()
  {
    return this.UaI.endTimeMs - this.UaI.startTimeMs;
  }
  
  public final long getEndTimeMs()
  {
    return this.UaI.endTimeMs;
  }
  
  public final boolean hRe()
  {
    AppMethodBeat.i(283709);
    boolean bool = this.UaI.TDy.isValid();
    AppMethodBeat.o(283709);
    return bool;
  }
  
  public final String hRf()
  {
    return this.UaI.TDy.path;
  }
  
  public final long hRg()
  {
    af localaf = this.UaI.TDy.Uby;
    if (localaf == null) {
      return 0L;
    }
    return localaf.id;
  }
  
  public final b hRh()
  {
    return this.UaI;
  }
  
  public final void setPlayRate(float paramFloat)
  {
    AppMethodBeat.i(283706);
    this.UaI.setPlayRate(paramFloat);
    AppMethodBeat.o(283706);
  }
  
  public final void setStartTimeMs(long paramLong)
  {
    AppMethodBeat.i(283642);
    this.UaI.setStartTimeMs(paramLong);
    AppMethodBeat.o(283642);
  }
  
  public final void setVolume(float paramFloat)
  {
    AppMethodBeat.i(283676);
    this.UaI.setVolume(paramFloat);
    AppMethodBeat.o(283676);
  }
  
  public final void wA(long paramLong)
  {
    AppMethodBeat.i(283663);
    this.UaI.wA(paramLong);
    AppMethodBeat.o(283663);
  }
  
  public final void wB(long paramLong)
  {
    AppMethodBeat.i(283687);
    this.UaI.wB(paramLong);
    AppMethodBeat.o(283687);
  }
  
  public final void wC(long paramLong)
  {
    AppMethodBeat.i(283698);
    this.UaI.wC(paramLong);
    AppMethodBeat.o(283698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ad
 * JD-Core Version:    0.7.0.1
 */