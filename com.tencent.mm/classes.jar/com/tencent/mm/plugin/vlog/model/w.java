package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "", "path", "", "type", "", "fromCamera", "(Ljava/lang/String;II)V", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "durationMs", "", "getDurationMs", "()J", "editInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "getEditInfo", "()Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "hasTransition", "", "getHasTransition", "()Z", "id", "getId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "sourceDuration", "getSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceScale", "getSourceScale", "setSourceScale", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "timeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transAssetPath", "getTransAssetPath", "transDuration", "getTransDuration", "transEffectId", "getTransEffectId", "getType", "setType", "volume", "getVolume", "setVolume", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "setTransition", "", "transition", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "transformTransEffectId", "effectMap", "", "updateTrack", "Companion", "plugin-vlog_release"})
public final class w
{
  public static final w.a BGx;
  int BGb;
  public int BGr;
  public int BGs;
  public float BGt;
  public final g BGu;
  public final MediaEditReportInfo.EditItem BGv;
  public final b BGw;
  public final int id;
  public String path;
  public int type;
  public final d xNA;
  
  static
  {
    AppMethodBeat.i(195813);
    BGx = new w.a((byte)0);
    Object localObject = t.BGf;
    t.div();
    localObject = e.LmI;
    e.fPC();
    AppMethodBeat.o(195813);
  }
  
  public w(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195812);
    this.path = paramString;
    this.type = paramInt1;
    this.BGb = paramInt2;
    this.id = hashCode();
    this.xNA = new d(0L, false, 3);
    this.BGt = 1.0F;
    this.BGu = new g();
    this.BGv = new MediaEditReportInfo.EditItem();
    ad.i("MicroMsg.VLogCompositionTrack", "create VLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id);
    String str = i.k(this.path, false);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    this.BGw = new b(paramString, this.type);
    AppMethodBeat.o(195812);
  }
  
  public final void Bi(long paramLong)
  {
    AppMethodBeat.i(195805);
    this.BGw.Bi(paramLong);
    AppMethodBeat.o(195805);
  }
  
  public final void Bj(long paramLong)
  {
    AppMethodBeat.i(195806);
    this.BGw.Bj(paramLong);
    AppMethodBeat.o(195806);
  }
  
  public final void Bk(long paramLong)
  {
    AppMethodBeat.i(195807);
    this.BGw.Bk(paramLong);
    AppMethodBeat.o(195807);
  }
  
  public final void Bl(long paramLong)
  {
    AppMethodBeat.i(195808);
    this.BGw.Bl(paramLong);
    AppMethodBeat.o(195808);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(195811);
    if (parama != null)
    {
      this.BGw.LmB.setPath(parama.assetPath);
      this.BGw.LmB.xPg = parama.xPg;
      this.BGw.LmB.duration = parama.duration;
      AppMethodBeat.o(195811);
      return;
    }
    this.BGw.LmB.setPath("");
    this.BGw.LmB.xPg = 0L;
    this.BGw.LmB.duration = 0L;
    AppMethodBeat.o(195811);
  }
  
  public final long esj()
  {
    return this.BGw.startTimeMs;
  }
  
  public final long esk()
  {
    return this.BGw.hiy;
  }
  
  public final boolean esl()
  {
    AppMethodBeat.i(195810);
    boolean bool = this.BGw.LmB.isValid();
    AppMethodBeat.o(195810);
    return bool;
  }
  
  public final String esm()
  {
    return this.BGw.LmB.path;
  }
  
  public final long esn()
  {
    return this.BGw.LmB.xPg;
  }
  
  public final b eso()
  {
    return this.BGw;
  }
  
  public final long getDurationMs()
  {
    return this.BGw.hiy - this.BGw.startTimeMs;
  }
  
  public final float getPlayRate()
  {
    return this.BGw.llC;
  }
  
  public final void setPlayRate(float paramFloat)
  {
    AppMethodBeat.i(195809);
    this.BGw.setPlayRate(paramFloat);
    AppMethodBeat.o(195809);
  }
  
  public final void setVolume(float paramFloat)
  {
    this.BGw.volume = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.w
 * JD-Core Version:    0.7.0.1
 */