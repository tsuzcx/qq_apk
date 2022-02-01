package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.i;
import com.tencent.mm.videocomposition.k;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "", "path", "", "type", "", "fromCamera", "(Ljava/lang/String;II)V", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "durationMs", "", "getDurationMs", "()J", "editInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "getEditInfo", "()Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "hasTransition", "", "getHasTransition", "()Z", "id", "getId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "sourceDuration", "getSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceScale", "getSourceScale", "setSourceScale", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "timeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transAssetPath", "getTransAssetPath", "transDuration", "getTransDuration", "transEffectId", "getTransEffectId", "transId", "getTransId", "setTransId", "getType", "setType", "volume", "getVolume", "setVolume", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "setTransition", "", "transition", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "transformTransEffectId", "effectMap", "", "updateTrack", "Companion", "plugin-vlog_release"})
public final class ad
{
  public static final ad.a GzB;
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d Cev;
  public final com.tencent.mm.videocomposition.d GzA;
  int Gze;
  public int Gzu;
  public int Gzv;
  public float Gzw;
  public final j Gzx;
  public int Gzy;
  public final MediaEditReportInfo.EditItem Gzz;
  public final int id;
  public String path;
  public int type;
  
  static
  {
    AppMethodBeat.i(190711);
    GzB = new ad.a((byte)0);
    Object localObject = aa.Gzi;
    aa.efp();
    localObject = i.Rhj;
    i.hfm();
    AppMethodBeat.o(190711);
  }
  
  public ad(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190710);
    this.path = paramString;
    this.type = paramInt1;
    this.Gze = paramInt2;
    this.id = hashCode();
    this.Cev = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(0L, false, 3);
    this.Gzw = 1.0F;
    this.Gzx = new j();
    this.Gzy = -1;
    this.Gzz = new MediaEditReportInfo.EditItem();
    Log.i("MicroMsg.VLogCompositionTrack", "create VLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id);
    String str = s.k(this.path, false);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    p.g(paramString, "VFSFileOp.exportExternalPath(path, false) ?: \"\"");
    this.GzA = new com.tencent.mm.videocomposition.d(paramString, this.type);
    AppMethodBeat.o(190710);
  }
  
  public final void KO(long paramLong)
  {
    AppMethodBeat.i(190703);
    this.GzA.KO(paramLong);
    AppMethodBeat.o(190703);
  }
  
  public final void KP(long paramLong)
  {
    AppMethodBeat.i(190704);
    this.GzA.KP(paramLong);
    AppMethodBeat.o(190704);
  }
  
  public final void KQ(long paramLong)
  {
    AppMethodBeat.i(190705);
    this.GzA.KQ(paramLong);
    AppMethodBeat.o(190705);
  }
  
  public final void KR(long paramLong)
  {
    AppMethodBeat.i(190706);
    this.GzA.KR(paramLong);
    AppMethodBeat.o(190706);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(190709);
    if (parama != null)
    {
      this.Gzy = parama.order;
      this.GzA.Rhc.setPath(parama.assetPath);
      this.GzA.Rhc.duration = parama.duration;
      AppMethodBeat.o(190709);
      return;
    }
    this.Gzy = -1;
    this.GzA.Rhc.setPath("");
    this.GzA.Rhc.duration = 0L;
    AppMethodBeat.o(190709);
  }
  
  public final boolean fBG()
  {
    AppMethodBeat.i(190708);
    boolean bool = this.GzA.Rhc.isValid();
    AppMethodBeat.o(190708);
    return bool;
  }
  
  public final String fBH()
  {
    return this.GzA.Rhc.path;
  }
  
  public final long fBI()
  {
    com.tencent.mm.xeffect.effect.ad localad = this.GzA.Rhc.GAn;
    if (localad != null) {
      return localad.id;
    }
    return 0L;
  }
  
  public final long getDurationMs()
  {
    return this.GzA.endTimeMs - this.GzA.startTimeMs;
  }
  
  public final void setPlayRate(float paramFloat)
  {
    AppMethodBeat.i(190707);
    this.GzA.setPlayRate(paramFloat);
    AppMethodBeat.o(190707);
  }
  
  public final void setVolume(float paramFloat)
  {
    this.GzA.volume = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ad
 * JD-Core Version:    0.7.0.1
 */