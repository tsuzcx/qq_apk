package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.plugin.xlabeffect.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.e;
import com.tencent.mm.videocomposition.g;
import com.tencent.mm.xeffect.effect.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "", "path", "", "type", "", "fromCamera", "(Ljava/lang/String;II)V", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "durationMs", "", "getDurationMs", "()J", "editInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "getEditInfo", "()Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "hasTransition", "", "getHasTransition", "()Z", "id", "getId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "sourceDuration", "getSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceScale", "getSourceScale", "setSourceScale", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "timeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transAssetPath", "getTransAssetPath", "transDuration", "getTransDuration", "transEffectId", "getTransEffectId", "transId", "getTransId", "setTransId", "getType", "setType", "volume", "getVolume", "setVolume", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "setTransition", "", "transition", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "transformTransEffectId", "effectMap", "", "updateTrack", "Companion", "plugin-vlog_release"})
public final class ad
{
  public static final a Nnh;
  public final d Ibr;
  int NmG;
  public int Nna;
  public int Nnb;
  public float Nnc;
  public final j Nnd;
  public int Nne;
  public final MediaEditReportInfo.EditItem Nnf;
  public final b Nng;
  public final int id;
  public String path;
  public int type;
  
  static
  {
    AppMethodBeat.i(227689);
    Nnh = new a((byte)0);
    Object localObject = c.QPp;
    c.eON();
    localObject = e.YIc;
    e.igF();
    AppMethodBeat.o(227689);
  }
  
  public ad(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227688);
    this.path = paramString;
    this.type = paramInt1;
    this.NmG = paramInt2;
    this.id = hashCode();
    this.Ibr = new d(0L, false, 3);
    this.Nnc = 1.0F;
    this.Nnd = new j();
    this.Nne = -1;
    this.Nnf = new MediaEditReportInfo.EditItem();
    Log.i("MicroMsg.VLogCompositionTrack", "create VLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id);
    String str = u.n(this.path, false);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    p.j(paramString, "VFSFileOp.exportExternalPath(path, false) ?: \"\"");
    this.Nng = new b(paramString, this.type);
    AppMethodBeat.o(227688);
  }
  
  public final void Sl(long paramLong)
  {
    AppMethodBeat.i(227676);
    this.Nng.Sl(paramLong);
    AppMethodBeat.o(227676);
  }
  
  public final void Sm(long paramLong)
  {
    AppMethodBeat.i(227677);
    this.Nng.Sm(paramLong);
    AppMethodBeat.o(227677);
  }
  
  public final void Sn(long paramLong)
  {
    AppMethodBeat.i(227679);
    this.Nng.Sn(paramLong);
    AppMethodBeat.o(227679);
  }
  
  public final void So(long paramLong)
  {
    AppMethodBeat.i(227680);
    this.Nng.So(paramLong);
    AppMethodBeat.o(227680);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(227687);
    if (parama != null)
    {
      this.Nne = parama.order;
      this.Nng.MQX.setPath(parama.assetPath);
      this.Nng.MQX.duration = parama.duration;
      AppMethodBeat.o(227687);
      return;
    }
    this.Nne = -1;
    this.Nng.MQX.setPath("");
    this.Nng.MQX.duration = 0L;
    AppMethodBeat.o(227687);
  }
  
  public final long getDurationMs()
  {
    return this.Nng.endTimeMs - this.Nng.startTimeMs;
  }
  
  public final boolean gtD()
  {
    AppMethodBeat.i(227683);
    boolean bool = this.Nng.MQX.isValid();
    AppMethodBeat.o(227683);
    return bool;
  }
  
  public final String gtE()
  {
    return this.Nng.MQX.path;
  }
  
  public final long gtF()
  {
    af localaf = this.Nng.MQX.NnT;
    if (localaf != null) {
      return localaf.id;
    }
    return 0L;
  }
  
  public final void setPlayRate(float paramFloat)
  {
    AppMethodBeat.i(227681);
    this.Nng.setPlayRate(paramFloat);
    AppMethodBeat.o(227681);
  }
  
  public final void setVolume(float paramFloat)
  {
    AppMethodBeat.i(227678);
    this.Nng.setVolume(paramFloat);
    AppMethodBeat.o(227678);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack$Companion;", "", "()V", "TAG", "", "TypeAudio", "", "TypeImage", "TypeUnknown", "TypeVideo", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ad
 * JD-Core Version:    0.7.0.1
 */