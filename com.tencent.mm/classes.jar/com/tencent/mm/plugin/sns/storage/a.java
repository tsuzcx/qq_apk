package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/AdBreakFrameClickInfo;", "", "areaLeft", "", "areaTop", "areaWidth", "areaHeight", "clickStartTime", "", "clickEndTime", "clickActionInfo", "Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;", "(IIIIFFLcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;)V", "getAreaHeight", "()I", "getAreaLeft", "getAreaTop", "getAreaWidth", "getClickActionInfo", "()Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;", "getClickEndTime", "()F", "getClickStartTime", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a QIn;
  public final int QIo;
  public final int QIp;
  public final int QIq;
  public final int QIr;
  public final float QIs;
  public final float QIt;
  public final AdClickActionInfo clickActionInfo;
  
  static
  {
    AppMethodBeat.i(306612);
    QIn = new a.a((byte)0);
    AppMethodBeat.o(306612);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, AdClickActionInfo paramAdClickActionInfo)
  {
    AppMethodBeat.i(306608);
    this.QIo = paramInt1;
    this.QIp = paramInt2;
    this.QIq = paramInt3;
    this.QIr = paramInt4;
    this.QIs = paramFloat1;
    this.QIt = paramFloat2;
    this.clickActionInfo = paramAdClickActionInfo;
    AppMethodBeat.o(306608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a
 * JD-Core Version:    0.7.0.1
 */