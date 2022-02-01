package com.tencent.mm.plugin.webview.ui.tools.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/video/MPVideoPreviewDataMgr;", "", "()V", "TAG", "", "abTestOn", "", "getAbTestOn", "()Z", "abTestOn$delegate", "Lkotlin/Lazy;", "videoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInitialParams", "", "Ljava/lang/Object;", "getOnReceiveNativeData", "getVideo", "vid", "parseNativeData", "", "nativeData", "prepareOnReceivePageData", "reportByLeaveForMPGateway", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "reportOnLeaveForMP", "json", "Lorg/json/JSONObject;", "saveVideo", "playTime", "", "expireTime", "bitmap", "Landroid/graphics/Bitmap;", "plugin-webview_release"})
public final class a
{
  private static final f JxL;
  public static final MMKVSlotManager JxM;
  public static final a JxN;
  
  static
  {
    AppMethodBeat.i(210674);
    JxN = new a();
    JxL = g.ah((kotlin.g.a.a)a.JxO);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("MicroMsg.MPVideoPreviewDataMgr");
    p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(TAG)");
    JxM = new MMKVSlotManager(localMultiProcessMMKV, 600L);
    AppMethodBeat.o(210674);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(210671);
    if (!gic())
    {
      AppMethodBeat.o(210671);
      return;
    }
    Object localObject = (MultiProcessMMKV)JxM.getSlot();
    ((MultiProcessMMKV)localObject).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_playTime", paramInt1);
    ((MultiProcessMMKV)localObject).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_expire", paramInt2);
    if (paramBitmap != null)
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      paramBitmap = Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      p.g(paramBitmap, "android.util.Base64.enco…roid.util.Base64.DEFAULT)");
    }
    for (;;)
    {
      ((MultiProcessMMKV)JxM.getSlot()).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_bitmap", paramBitmap);
      AppMethodBeat.o(210671);
      return;
      paramBitmap = "";
    }
  }
  
  public static void bbi(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(210672);
    if (!gic())
    {
      AppMethodBeat.o(210672);
      return;
    }
    Object localObject2 = bbj(paramString);
    if (localObject2 == null)
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", "prepareOnReceivePageData vid not found");
      ((MultiProcessMMKV)JxM.getSlot()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
      AppMethodBeat.o(210672);
      return;
    }
    ((MultiProcessMMKV)JxM.getSlot()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", paramString);
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
    Log.v("MicroMsg.MPVideoPreviewDataMgr", paramString);
    AppMethodBeat.o(210672);
  }
  
  public static Map<String, Object> bbj(String paramString)
  {
    AppMethodBeat.i(210673);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", "getVideo vid null");
      AppMethodBeat.o(210673);
      return null;
    }
    Object localObject = (MultiProcessMMKV)JxM.getSlot();
    int j = ((MultiProcessMMKV)localObject).getInt("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_playTime", 0);
    int k = ((MultiProcessMMKV)localObject).getInt("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_expire", 0);
    int i;
    if (System.currentTimeMillis() / 1000L > k) {
      i = 1;
    }
    HashMap localHashMap;
    while ((j != 0) && (k != 0) && (i == 0))
    {
      localHashMap = new HashMap();
      localHashMap.put("videoInitialTime", (Object)Integer.valueOf(j));
      localObject = ((MultiProcessMMKV)localObject).getString("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_bitmap", "");
      if (localObject == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.Object");
        AppMethodBeat.o(210673);
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
        Log.i("MicroMsg.MPVideoPreviewDataMgr", i);
        paramString = (Map)localHashMap;
        AppMethodBeat.o(210673);
        return paramString;
      }
      localHashMap = null;
    }
  }
  
  public static boolean gic()
  {
    AppMethodBeat.i(210669);
    boolean bool = ((Boolean)JxL.getValue()).booleanValue();
    AppMethodBeat.o(210669);
    return bool;
  }
  
  public final void bbh(String paramString)
  {
    AppMethodBeat.i(210670);
    try
    {
      paramString = new JSONObject(paramString).optString("video_data");
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "reportByLeaveForMPGateway video_data null");
        AppMethodBeat.o(210670);
        return;
      }
      paramString = new JSONObject(paramString);
      String str = paramString.optString("vid");
      int i = (int)Util.getFloat(paramString.optString("lastPlayedTime"), 0.0F);
      float f = Util.getFloat(paramString.optString("lastPlayedTimeExpiredTime"), 0.0F);
      a(str, i, (int)f, null);
      AppMethodBeat.o(210670);
      return;
    }
    catch (Exception paramString)
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", "reportByLeaveForMPGateway, ex = %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(210670);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final a JxO;
    
    static
    {
      AppMethodBeat.i(210668);
      JxO = new a();
      AppMethodBeat.o(210668);
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