package com.tencent.mm.plugin.scanner.scan_goods_new;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "", "()V", "categoryId", "", "getCategoryId", "()I", "setCategoryId", "(I)V", "goodsRect", "Landroid/graphics/RectF;", "getGoodsRect", "()Landroid/graphics/RectF;", "setGoodsRect", "(Landroid/graphics/RectF;)V", "imageEncodeType", "getImageEncodeType", "setImageEncodeType", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "reqKey", "getReqKey", "setReqKey", "scanImageType", "getScanImageType$annotations", "getScanImageType", "setScanImageType", "scanProductRequestInfo", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "getScanProductRequestInfo", "()Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "setScanProductRequestInfo", "(Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;)V", "session", "", "getSession", "()J", "setSession", "(J)V", "showImageData", "", "getShowImageData", "()[B", "setShowImageData", "([B)V", "source", "getSource", "setSource", "state", "getState", "setState", "status", "getStatus$annotations", "getStatus", "setStatus", "title", "getTitle", "setTitle", "trackId", "getTrackId", "setTrackId", "toString", "Companion", "State", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h.a OWa;
  public int ORl = -1;
  public int OVD;
  public j OVE;
  public byte[] OWb;
  public RectF OWc;
  public int OWd;
  public String hAT = "";
  public long hBk;
  public String imageUrl = "";
  public int source;
  public int state;
  public int status;
  public String title = "";
  public int trackId = -1;
  
  static
  {
    AppMethodBeat.i(313873);
    OWa = new h.a((byte)0);
    AppMethodBeat.o(313873);
  }
  
  public final void setImageUrl(String paramString)
  {
    AppMethodBeat.i(313885);
    s.u(paramString, "<set-?>");
    this.imageUrl = paramString;
    AppMethodBeat.o(313885);
  }
  
  public final void setReqKey(String paramString)
  {
    AppMethodBeat.i(313878);
    s.u(paramString, "<set-?>");
    this.hAT = paramString;
    AppMethodBeat.o(313878);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(313881);
    s.u(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(313881);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(313893);
    Object localObject = am.aixg;
    localObject = String.format("ScanProductRecognizeItem state: %s, trackId: %s, reqKey: %s, title: %s, imageUrl: %s, status: %s, categoryId: %s", Arrays.copyOf(new Object[] { Integer.valueOf(this.state), Integer.valueOf(this.trackId), this.hAT, this.title, this.imageUrl, Integer.valueOf(this.status), Integer.valueOf(this.OWd) }, 7));
    s.s(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(313893);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.h
 * JD-Core Version:    0.7.0.1
 */