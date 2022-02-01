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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/MPVideoPreviewDataMgr;", "", "()V", "TAG", "", "abTestOn", "", "getAbTestOn", "()Z", "abTestOn$delegate", "Lkotlin/Lazy;", "videoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInitialParams", "", "Ljava/lang/Object;", "getOnReceiveNativeData", "getVideo", "vid", "parseNativeData", "", "nativeData", "prepareOnReceivePageData", "reportByLeaveForMPGateway", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "reportOnLeaveForMP", "json", "Lorg/json/JSONObject;", "saveVideo", "playTime", "", "expireTime", "bitmap", "Landroid/graphics/Bitmap;", "plugin-webview_release"})
public final class a
{
  private static final f QvQ;
  public static final MMKVSlotManager QvR;
  public static final a QvS;
  
  static
  {
    AppMethodBeat.i(219656);
    QvS = new a();
    QvQ = g.ar((kotlin.g.a.a)a.QvT);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("MicroMsg.MPVideoPreviewDataMgr");
    p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(TAG)");
    QvR = new MMKVSlotManager(localMultiProcessMMKV, 600L);
    AppMethodBeat.o(219656);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(219646);
    if (!hbB())
    {
      AppMethodBeat.o(219646);
      return;
    }
    Object localObject = (MultiProcessMMKV)QvR.getSlotForWrite();
    ((MultiProcessMMKV)localObject).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_playTime", paramInt1);
    ((MultiProcessMMKV)localObject).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_expire", paramInt2);
    if (paramBitmap != null)
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      paramBitmap = Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      p.j(paramBitmap, "android.util.Base64.enco…roid.util.Base64.DEFAULT)");
    }
    for (;;)
    {
      ((MultiProcessMMKV)QvR.getSlotForWrite()).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_bitmap", paramBitmap);
      AppMethodBeat.o(219646);
      return;
      paramBitmap = "";
    }
  }
  
  public static void bnh(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(219648);
    if (!hbB())
    {
      AppMethodBeat.o(219648);
      return;
    }
    Object localObject2 = bni(paramString);
    if (localObject2 == null)
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", "prepareOnReceivePageData vid not found");
      ((MultiProcessMMKV)QvR.getSlotForWrite()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
      AppMethodBeat.o(219648);
      return;
    }
    ((MultiProcessMMKV)QvR.getSlotForWrite()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", paramString);
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
    AppMethodBeat.o(219648);
  }
  
  public static Map<String, Object> bni(String paramString)
  {
    String str = null;
    AppMethodBeat.i(219652);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", "getVideo vid null");
      AppMethodBeat.o(219652);
      return null;
    }
    MMKVSlotManager localMMKVSlotManager = QvR;
    int j = localMMKVSlotManager.decodeInt("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_playTime", 0);
    int k = localMMKVSlotManager.decodeInt("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_expire", 0);
    if (System.currentTimeMillis() / 1000L > k) {}
    Object localObject;
    for (int i = 1;; i = 0)
    {
      localObject = str;
      if (j == 0) {
        break label223;
      }
      localObject = str;
      if (k == 0) {
        break label223;
      }
      localObject = str;
      if (i != 0) {
        break label223;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("videoInitialTime", (Object)Integer.valueOf(j));
      str = localMMKVSlotManager.decodeString("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_bitmap", "");
      if (str != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type java.lang.Object");
      AppMethodBeat.o(219652);
      throw paramString;
    }
    ((HashMap)localObject).put("videoInitialSnapshot", (Object)str);
    label223:
    paramString = new StringBuilder("getVideo vid = ").append(paramString).append(", map size = ");
    if (localObject != null) {}
    for (i = ((HashMap)localObject).size();; i = 0)
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", i);
      paramString = (Map)localObject;
      AppMethodBeat.o(219652);
      return paramString;
    }
  }
  
  public static boolean hbB()
  {
    AppMethodBeat.i(219635);
    boolean bool = ((Boolean)QvQ.getValue()).booleanValue();
    AppMethodBeat.o(219635);
    return bool;
  }
  
  public final void bng(String paramString)
  {
    AppMethodBeat.i(219640);
    try
    {
      paramString = new JSONObject(paramString).optString("video_data");
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "reportByLeaveForMPGateway video_data null");
        AppMethodBeat.o(219640);
        return;
      }
      paramString = new JSONObject(paramString);
      String str = paramString.optString("vid");
      int i = (int)Util.getFloat(paramString.optString("lastPlayedTime"), 0.0F);
      float f = Util.getFloat(paramString.optString("lastPlayedTimeExpiredTime"), 0.0F);
      a(str, i, (int)f, null);
      AppMethodBeat.o(219640);
      return;
    }
    catch (Exception paramString)
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", "reportByLeaveForMPGateway, ex = %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(219640);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final a QvT;
    
    static
    {
      AppMethodBeat.i(216824);
      QvT = new a();
      AppMethodBeat.o(216824);
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