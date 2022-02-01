package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "cityName", "", "poiName", "longitude", "", "latitude", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;FFLandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getCityName", "()Ljava/lang/String;", "getLatitude", "()F", "getLongitude", "getPoiName", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "Companion", "plugin-recordvideo_release"})
public final class k
  extends a
{
  public static final k.a Cfz;
  String Cfy;
  float dTj;
  String kHV;
  float latitude;
  
  static
  {
    AppMethodBeat.i(237783);
    Cfz = new k.a((byte)0);
    AppMethodBeat.o(237783);
  }
  
  public k(jn paramjn)
  {
    super(d.CeK);
    AppMethodBeat.i(237782);
    this.Cfy = "";
    this.kHV = "";
    try
    {
      Object localObject = (com.tencent.mm.bw.a)new cka();
      paramjn = paramjn.KOd;
      p.g(paramjn, "proto.itemData");
      paramjn = paramjn.getBuffer();
      p.g(paramjn, "proto.itemData.buffer");
      paramjn = paramjn.zy;
      try
      {
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramjn);
        paramjn = (jn)localObject;
      }
      catch (Exception paramjn)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramjn });
          paramjn = null;
        }
      }
      paramjn = (cka)paramjn;
      if (paramjn != null)
      {
        localObject = paramjn.Cfy;
        p.g(localObject, "it.cityName");
        this.Cfy = ((String)localObject);
        localObject = paramjn.kHV;
        p.g(localObject, "it.poiName");
        this.kHV = ((String)localObject);
        this.dTj = paramjn.dTj;
        this.latitude = paramjn.latitude;
        localObject = this.gT;
        paramjn = paramjn.Lce;
        p.g(paramjn, "it.matrix");
        ((Matrix)localObject).setValues(a(paramjn));
      }
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.LocationItem", toString());
      AppMethodBeat.o(237782);
      return;
    }
    catch (IOException paramjn)
    {
      com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.LocationItem", (Throwable)paramjn, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(237782);
    }
  }
  
  public k(String paramString1, String paramString2, float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    super(d.CeM);
    AppMethodBeat.i(237780);
    this.Cfy = "";
    this.kHV = "";
    this.Cfy = paramString1;
    this.kHV = paramString2;
    this.latitude = paramFloat2;
    this.dTj = paramFloat1;
    p.h(paramMatrix, "<set-?>");
    this.gT = paramMatrix;
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.LocationItem", toString());
    AppMethodBeat.o(237780);
  }
  
  public final com.tencent.mm.bw.a eMk()
  {
    AppMethodBeat.i(237778);
    Object localObject = new cka();
    ((cka)localObject).Cfy = this.Cfy;
    ((cka)localObject).kHV = this.kHV;
    ((cka)localObject).Lce = f(this.gT);
    ((cka)localObject).dTj = this.dTj;
    ((cka)localObject).latitude = this.latitude;
    localObject = (com.tencent.mm.bw.a)localObject;
    AppMethodBeat.o(237778);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237779);
    String str = "[" + hashCode() + "]poiName:" + this.kHV + " cityName:" + this.Cfy;
    AppMethodBeat.o(237779);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.k
 * JD-Core Version:    0.7.0.1
 */