package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "", "path", "", "type", "", "fromCamera", "(Ljava/lang/String;II)V", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "durationMs", "", "getDurationMs", "()J", "editInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "getEditInfo", "()Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "hasTransition", "", "getHasTransition", "()Z", "id", "getId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "sourceDuration", "getSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceScale", "getSourceScale", "setSourceScale", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "timeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transAssetPath", "getTransAssetPath", "transDuration", "getTransDuration", "transEffectId", "getTransEffectId", "getType", "setType", "volume", "getVolume", "setVolume", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "setTransition", "", "transition", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "transformTransEffectId", "effectMap", "", "updateTrack", "Companion", "plugin-vlog_release"})
public final class w
{
  public static final w.a BXW;
  public int BXQ;
  public int BXR;
  public float BXS;
  public final g BXT;
  public final MediaEditReportInfo.EditItem BXU;
  public final b BXV;
  int BXz;
  public final int id;
  public String path;
  public int type;
  public final d ydt;
  
  static
  {
    AppMethodBeat.i(191272);
    BXW = new w.a((byte)0);
    Object localObject = t.BXD;
    t.dlu();
    localObject = e.LJs;
    e.fTY();
    AppMethodBeat.o(191272);
  }
  
  public w(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191271);
    this.path = paramString;
    this.type = paramInt1;
    this.BXz = paramInt2;
    this.id = hashCode();
    this.ydt = new d(0L, false, 3);
    this.BXS = 1.0F;
    this.BXT = new g();
    this.BXU = new MediaEditReportInfo.EditItem();
    ae.i("MicroMsg.VLogCompositionTrack", "create VLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id);
    String str = o.k(this.path, false);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    this.BXV = new b(paramString, this.type);
    AppMethodBeat.o(191271);
  }
  
  public final void BG(long paramLong)
  {
    AppMethodBeat.i(191264);
    this.BXV.BG(paramLong);
    AppMethodBeat.o(191264);
  }
  
  public final void BH(long paramLong)
  {
    AppMethodBeat.i(191265);
    this.BXV.BH(paramLong);
    AppMethodBeat.o(191265);
  }
  
  public final void BI(long paramLong)
  {
    AppMethodBeat.i(191266);
    this.BXV.BI(paramLong);
    AppMethodBeat.o(191266);
  }
  
  public final void BJ(long paramLong)
  {
    AppMethodBeat.i(191267);
    this.BXV.BJ(paramLong);
    AppMethodBeat.o(191267);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(191270);
    if (parama != null)
    {
      this.BXV.LJl.setPath(parama.assetPath);
      this.BXV.LJl.yeZ = parama.yeZ;
      this.BXV.LJl.duration = parama.duration;
      AppMethodBeat.o(191270);
      return;
    }
    this.BXV.LJl.setPath("");
    this.BXV.LJl.yeZ = 0L;
    this.BXV.LJl.duration = 0L;
    AppMethodBeat.o(191270);
  }
  
  public final long evQ()
  {
    return this.BXV.startTimeMs;
  }
  
  public final long evR()
  {
    return this.BXV.hlm;
  }
  
  public final boolean evS()
  {
    AppMethodBeat.i(191269);
    boolean bool = this.BXV.LJl.isValid();
    AppMethodBeat.o(191269);
    return bool;
  }
  
  public final String evT()
  {
    return this.BXV.LJl.path;
  }
  
  public final long evU()
  {
    return this.BXV.LJl.yeZ;
  }
  
  public final b evV()
  {
    return this.BXV;
  }
  
  public final long getDurationMs()
  {
    return this.BXV.hlm - this.BXV.startTimeMs;
  }
  
  public final float getPlayRate()
  {
    return this.BXV.lqb;
  }
  
  public final void setPlayRate(float paramFloat)
  {
    AppMethodBeat.i(191268);
    this.BXV.setPlayRate(paramFloat);
    AppMethodBeat.o(191268);
  }
  
  public final void setVolume(float paramFloat)
  {
    this.BXV.volume = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.w
 * JD-Core Version:    0.7.0.1
 */