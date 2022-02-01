package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.io.IOException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "cityName", "", "poiName", "longitude", "", "latitude", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;FFLandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getCityName", "()Ljava/lang/String;", "getLatitude", "()F", "getLongitude", "getPoiName", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "Companion", "plugin-recordvideo_release"})
public final class k
  extends a
{
  public static final k.a yex;
  float dBu;
  float dzE;
  String jGd;
  String yew;
  
  static
  {
    AppMethodBeat.i(206942);
    yex = new k.a((byte)0);
    AppMethodBeat.o(206942);
  }
  
  public k(ja paramja)
  {
    super(d.ydI);
    AppMethodBeat.i(206941);
    this.yew = "";
    this.jGd = "";
    try
    {
      Object localObject = (com.tencent.mm.bw.a)new bwm();
      paramja = paramja.FUv;
      p.g(paramja, "proto.itemData");
      paramja = paramja.getBuffer();
      p.g(paramja, "proto.itemData.buffer");
      paramja = paramja.getBytes();
      try
      {
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramja);
        paramja = (ja)localObject;
      }
      catch (Exception paramja)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { paramja });
          paramja = null;
        }
      }
      paramja = (bwm)paramja;
      if (paramja != null)
      {
        localObject = paramja.yew;
        p.g(localObject, "it.cityName");
        this.yew = ((String)localObject);
        localObject = paramja.jGd;
        p.g(localObject, "it.poiName");
        this.jGd = ((String)localObject);
        this.dBu = paramja.dBu;
        this.dzE = paramja.dzE;
        localObject = this.gR;
        paramja = paramja.GhB;
        p.g(paramja, "it.matrix");
        ((Matrix)localObject).setValues(a(paramja));
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.LocationItem", toString());
      AppMethodBeat.o(206941);
      return;
    }
    catch (IOException paramja)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.LocationItem", (Throwable)paramja, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(206941);
    }
  }
  
  public k(String paramString1, String paramString2, float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    super(d.ydK);
    AppMethodBeat.i(206939);
    this.yew = "";
    this.jGd = "";
    this.yew = paramString1;
    this.jGd = paramString2;
    this.dzE = paramFloat2;
    this.dBu = paramFloat1;
    p.h(paramMatrix, "<set-?>");
    this.gR = paramMatrix;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.LocationItem", toString());
    AppMethodBeat.o(206939);
  }
  
  public final com.tencent.mm.bw.a dLk()
  {
    AppMethodBeat.i(206937);
    Object localObject = new bwm();
    ((bwm)localObject).yew = this.yew;
    ((bwm)localObject).jGd = this.jGd;
    ((bwm)localObject).GhB = f(this.gR);
    ((bwm)localObject).dBu = this.dBu;
    ((bwm)localObject).dzE = this.dzE;
    localObject = (com.tencent.mm.bw.a)localObject;
    AppMethodBeat.o(206937);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206938);
    String str = "[" + hashCode() + "]poiName:" + this.jGd + " cityName:" + this.yew;
    AppMethodBeat.o(206938);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.k
 * JD-Core Version:    0.7.0.1
 */