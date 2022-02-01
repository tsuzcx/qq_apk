package com.tencent.mm.plugin.webview.ui.tools.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/video/MPVideoPreviewDataMgr;", "", "()V", "TAG", "", "abTestOn", "", "getAbTestOn", "()Z", "abTestOn$delegate", "Lkotlin/Lazy;", "videoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInitialParams", "", "Ljava/lang/Object;", "getOnReceiveNativeData", "getVideo", "vid", "parseNativeData", "", "nativeData", "prepareOnReceivePageData", "reportByLeaveForMPGateway", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "reportOnLeaveForMP", "json", "Lorg/json/JSONObject;", "saveVideo", "playTime", "", "expireTime", "bitmap", "Landroid/graphics/Bitmap;", "plugin-webview_release"})
public final class a
{
  public static final as EHW;
  public static final a EHX;
  private static final f ovN;
  
  static
  {
    AppMethodBeat.i(199451);
    EHX = new a();
    ovN = g.O((d.g.a.a)a.EHY);
    ay localay = ay.aRW("MicroMsg.MPVideoPreviewDataMgr");
    p.g(localay, "MultiProcessMMKV.getMMKV(TAG)");
    EHW = new as(localay, 600L);
    AppMethodBeat.o(199451);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(199448);
    if (!bSZ())
    {
      AppMethodBeat.o(199448);
      return;
    }
    Object localObject = (ay)EHW.fnP();
    ((ay)localObject).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_playTime", paramInt1);
    ((ay)localObject).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_expire", paramInt2);
    if (paramBitmap != null)
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      paramBitmap = Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      p.g(paramBitmap, "android.util.Base64.enco…roid.util.Base64.DEFAULT)");
    }
    for (;;)
    {
      ((ay)EHW.fnP()).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_bitmap", paramBitmap);
      AppMethodBeat.o(199448);
      return;
      paramBitmap = "";
    }
  }
  
  public static void aKR(String paramString)
  {
    AppMethodBeat.i(199447);
    try
    {
      paramString = new JSONObject(paramString).optString("video_data");
      if (bu.isNullOrNil(paramString))
      {
        ae.i("MicroMsg.MPVideoPreviewDataMgr", "reportByLeaveForMPGateway video_data null");
        AppMethodBeat.o(199447);
        return;
      }
      paramString = new JSONObject(paramString);
      String str = paramString.optString("vid");
      int i = (int)bu.getFloat(paramString.optString("lastPlayedTime"), 0.0F);
      float f = bu.getFloat(paramString.optString("lastPlayedTimeExpiredTime"), 0.0F);
      a(str, i, (int)f, null);
      AppMethodBeat.o(199447);
      return;
    }
    catch (Exception paramString)
    {
      ae.i("MicroMsg.MPVideoPreviewDataMgr", "reportByLeaveForMPGateway, ex = %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(199447);
    }
  }
  
  public static void aKS(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(199449);
    if (!bSZ())
    {
      AppMethodBeat.o(199449);
      return;
    }
    Object localObject2 = aKT(paramString);
    if (localObject2 == null)
    {
      ae.i("MicroMsg.MPVideoPreviewDataMgr", "prepareOnReceivePageData vid not found");
      ((ay)EHW.fnP()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
      AppMethodBeat.o(199449);
      return;
    }
    ((ay)EHW.fnP()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", paramString);
    StringBuilder localStringBuilder = new StringBuilder("prepareOnReceivePageData len = ");
    localObject2 = ((Map)localObject2).get("videoInitialSnapshot");
    paramString = (String)localObject2;
    if (!(localObject2 instanceof String)) {
      paramString = null;
    }
    localObject2 = (String)paramString;
    paramString = localObject1;
    if (localObject2 != null) {
      paramString = Integer.valueOf(((String)localObject2).length());
    }
    ae.v("MicroMsg.MPVideoPreviewDataMgr", paramString);
    AppMethodBeat.o(199449);
  }
  
  public static Map<String, Object> aKT(String paramString)
  {
    AppMethodBeat.i(199450);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.MPVideoPreviewDataMgr", "getVideo vid null");
      AppMethodBeat.o(199450);
      return null;
    }
    Object localObject = (ay)EHW.fnP();
    int j = ((ay)localObject).getInt("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_playTime", 0);
    int k = ((ay)localObject).getInt("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_expire", 0);
    int i;
    if (System.currentTimeMillis() / 1000L > k) {
      i = 1;
    }
    HashMap localHashMap;
    while ((j != 0) && (k != 0) && (i == 0))
    {
      localHashMap = new HashMap();
      localHashMap.put("videoInitialTime", (Object)Integer.valueOf(j));
      localObject = ((ay)localObject).getString("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_bitmap", "");
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type java.lang.Object");
        AppMethodBeat.o(199450);
        throw paramString;
        i = 0;
      }
      else
      {
        localHashMap.put("videoInitialSnapshot", (Object)localObject);
      }
    }
    for (;;)
    {
      paramString = new StringBuilder("getVideo vid = ").append(paramString).append(", map size = ");
      if (localHashMap != null) {}
      for (i = localHashMap.size();; i = 0)
      {
        ae.i("MicroMsg.MPVideoPreviewDataMgr", i);
        paramString = (Map)localHashMap;
        AppMethodBeat.o(199450);
        return paramString;
      }
      localHashMap = null;
    }
  }
  
  public static boolean bSZ()
  {
    AppMethodBeat.i(199446);
    boolean bool = ((Boolean)ovN.getValue()).booleanValue();
    AppMethodBeat.o(199446);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final a EHY;
    
    static
    {
      AppMethodBeat.i(199445);
      EHY = new a();
      AppMethodBeat.o(199445);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.a
 * JD-Core Version:    0.7.0.1
 */