package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.IOException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "cityName", "", "poiName", "longitude", "", "latitude", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;FFLandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getCityName", "()Ljava/lang/String;", "getLatitude", "()F", "getLongitude", "getPoiName", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "Companion", "plugin-recordvideo_release"})
public final class k
  extends a
{
  public static final k.a xOE;
  float dAp;
  float dyz;
  String jDf;
  String xOD;
  
  static
  {
    AppMethodBeat.i(200684);
    xOE = new k.a((byte)0);
    AppMethodBeat.o(200684);
  }
  
  public k(ja paramja)
  {
    super(d.xNP);
    AppMethodBeat.i(200683);
    this.xOD = "";
    this.jDf = "";
    try
    {
      Object localObject = (com.tencent.mm.bx.a)new bvs();
      paramja = paramja.FCa;
      p.g(paramja, "proto.itemData");
      paramja = paramja.getBuffer();
      p.g(paramja, "proto.itemData.buffer");
      paramja = paramja.getBytes();
      try
      {
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramja);
        paramja = (ja)localObject;
      }
      catch (Exception paramja)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { paramja });
          paramja = null;
        }
      }
      paramja = (bvs)paramja;
      if (paramja != null)
      {
        localObject = paramja.xOD;
        p.g(localObject, "it.cityName");
        this.xOD = ((String)localObject);
        localObject = paramja.jDf;
        p.g(localObject, "it.poiName");
        this.jDf = ((String)localObject);
        this.dAp = paramja.dAp;
        this.dyz = paramja.dyz;
        localObject = this.gR;
        paramja = paramja.FPc;
        p.g(paramja, "it.matrix");
        ((Matrix)localObject).setValues(a(paramja));
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.LocationItem", toString());
      AppMethodBeat.o(200683);
      return;
    }
    catch (IOException paramja)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.LocationItem", (Throwable)paramja, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(200683);
    }
  }
  
  public k(String paramString1, String paramString2, float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    super(d.xNR);
    AppMethodBeat.i(200681);
    this.xOD = "";
    this.jDf = "";
    this.xOD = paramString1;
    this.jDf = paramString2;
    this.dyz = paramFloat2;
    this.dAp = paramFloat1;
    p.h(paramMatrix, "<set-?>");
    this.gR = paramMatrix;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.LocationItem", toString());
    AppMethodBeat.o(200681);
  }
  
  public final com.tencent.mm.bx.a dHT()
  {
    AppMethodBeat.i(200679);
    Object localObject = new bvs();
    ((bvs)localObject).xOD = this.xOD;
    ((bvs)localObject).jDf = this.jDf;
    ((bvs)localObject).FPc = f(this.gR);
    ((bvs)localObject).dAp = this.dAp;
    ((bvs)localObject).dyz = this.dyz;
    localObject = (com.tencent.mm.bx.a)localObject;
    AppMethodBeat.o(200679);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200680);
    String str = "[" + hashCode() + "]poiName:" + this.jDf + " cityName:" + this.xOD;
    AppMethodBeat.o(200680);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.k
 * JD-Core Version:    0.7.0.1
 */