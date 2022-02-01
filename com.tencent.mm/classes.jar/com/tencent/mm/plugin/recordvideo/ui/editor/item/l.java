package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "cityName", "", "poiName", "longitude", "", "latitude", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;FFLandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getCityName", "()Ljava/lang/String;", "getLatitude", "()F", "getLongitude", "getPoiName", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "Companion", "plugin-recordvideo_release"})
public final class l
  extends a
{
  public static final a Icw;
  String Icv;
  float latitude;
  float longitude;
  String poiName;
  
  static
  {
    AppMethodBeat.i(221547);
    Icw = new a((byte)0);
    AppMethodBeat.o(221547);
  }
  
  public l(jc paramjc)
  {
    super(d.IbG);
    AppMethodBeat.i(221545);
    this.Icv = "";
    this.poiName = "";
    try
    {
      Object localObject = (com.tencent.mm.cd.a)new csu();
      paramjc = paramjc.ROY;
      p.j(paramjc, "proto.itemData");
      paramjc = paramjc.Tkb;
      p.j(paramjc, "proto.itemData.buffer");
      paramjc = paramjc.UH;
      try
      {
        ((com.tencent.mm.cd.a)localObject).parseFrom(paramjc);
        paramjc = (jc)localObject;
      }
      catch (Exception paramjc)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramjc });
          paramjc = null;
        }
      }
      paramjc = (csu)paramjc;
      if (paramjc != null)
      {
        localObject = paramjc.Icv;
        p.j(localObject, "it.cityName");
        this.Icv = ((String)localObject);
        localObject = paramjc.poiName;
        p.j(localObject, "it.poiName");
        this.poiName = ((String)localObject);
        this.longitude = paramjc.longitude;
        this.latitude = paramjc.latitude;
        localObject = this.aHZ;
        paramjc = paramjc.Sdr;
        p.j(paramjc, "it.matrix");
        ((Matrix)localObject).setValues(a(paramjc));
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.LocationItem", toString());
      AppMethodBeat.o(221545);
      return;
    }
    catch (IOException paramjc)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.LocationItem", (Throwable)paramjc, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(221545);
    }
  }
  
  public l(String paramString1, String paramString2, float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    super(d.IbI);
    AppMethodBeat.i(221534);
    this.Icv = "";
    this.poiName = "";
    this.Icv = paramString1;
    this.poiName = paramString2;
    this.latitude = paramFloat2;
    this.longitude = paramFloat1;
    p.k(paramMatrix, "<set-?>");
    this.aHZ = paramMatrix;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.LocationItem", toString());
    AppMethodBeat.o(221534);
  }
  
  public final com.tencent.mm.cd.a fyG()
  {
    AppMethodBeat.i(221521);
    Object localObject = new csu();
    ((csu)localObject).Icv = this.Icv;
    ((csu)localObject).poiName = this.poiName;
    ((csu)localObject).Sdr = f(this.aHZ);
    ((csu)localObject).longitude = this.longitude;
    ((csu)localObject).latitude = this.latitude;
    localObject = (com.tencent.mm.cd.a)localObject;
    AppMethodBeat.o(221521);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221525);
    String str = "[" + hashCode() + "]poiName:" + this.poiName + " cityName:" + this.Icv;
    AppMethodBeat.o(221525);
    return str;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.l
 * JD-Core Version:    0.7.0.1
 */