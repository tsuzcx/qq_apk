package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "cityName", "", "poiName", "longitude", "", "latitude", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;FFLandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getCityName", "()Ljava/lang/String;", "getLatitude", "()F", "getLongitude", "getPoiName", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends a
{
  public static final l.a NYR;
  String NYS;
  float latitude;
  float longitude;
  String poiName;
  
  static
  {
    AppMethodBeat.i(280397);
    NYR = new l.a((byte)0);
    AppMethodBeat.o(280397);
  }
  
  public l(jy paramjy)
  {
    super(d.NYd);
    AppMethodBeat.i(280393);
    this.NYS = "";
    this.poiName = "";
    try
    {
      Object localObject = (com.tencent.mm.bx.a)new djw();
      paramjy = paramjy.YMl.aaxD.Op;
      try
      {
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramjy);
        paramjy = (jy)localObject;
      }
      catch (Exception paramjy)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramjy });
          paramjy = null;
        }
      }
      paramjy = (djw)paramjy;
      if (paramjy != null)
      {
        localObject = paramjy.NYS;
        s.s(localObject, "it.cityName");
        this.NYS = ((String)localObject);
        localObject = paramjy.poiName;
        s.s(localObject, "it.poiName");
        this.poiName = ((String)localObject);
        this.longitude = paramjy.longitude;
        this.latitude = paramjy.latitude;
        localObject = this.matrix;
        paramjy = paramjy.Zbl;
        s.s(paramjy, "it.matrix");
        ((Matrix)localObject).setValues(a(paramjy));
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.LocationItem", toString());
      AppMethodBeat.o(280393);
      return;
    }
    catch (IOException paramjy)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.LocationItem", (Throwable)paramjy, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(280393);
    }
  }
  
  public l(String paramString1, String paramString2, float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    super(d.NYf);
    AppMethodBeat.i(280374);
    this.NYS = "";
    this.poiName = "";
    this.NYS = paramString1;
    this.poiName = paramString2;
    this.latitude = paramFloat2;
    this.longitude = paramFloat1;
    s.u(paramMatrix, "<set-?>");
    this.matrix = paramMatrix;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.LocationItem", toString());
    AppMethodBeat.o(280374);
  }
  
  public final com.tencent.mm.bx.a gKs()
  {
    AppMethodBeat.i(280404);
    Object localObject = new djw();
    ((djw)localObject).NYS = this.NYS;
    ((djw)localObject).poiName = this.poiName;
    ((djw)localObject).Zbl = h(this.matrix);
    ((djw)localObject).longitude = this.longitude;
    ((djw)localObject).latitude = this.latitude;
    localObject = (com.tencent.mm.bx.a)localObject;
    AppMethodBeat.o(280404);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280409);
    String str = "[" + hashCode() + "]poiName:" + this.poiName + " cityName:" + this.NYS;
    AppMethodBeat.o(280409);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.l
 * JD-Core Version:    0.7.0.1
 */