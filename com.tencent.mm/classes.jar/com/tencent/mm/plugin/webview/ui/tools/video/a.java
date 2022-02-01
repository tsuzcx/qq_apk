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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/MPVideoPreviewDataMgr;", "", "()V", "TAG", "", "abTestOn", "", "getAbTestOn", "()Z", "abTestOn$delegate", "Lkotlin/Lazy;", "videoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInitialParams", "", "Ljava/lang/Object;", "getOnReceiveNativeData", "getVideo", "vid", "parseNativeData", "", "nativeData", "prepareOnReceivePageData", "reportByLeaveForMPGateway", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "reportOnLeaveForMP", "json", "Lorg/json/JSONObject;", "saveVideo", "playTime", "", "expireTime", "bitmap", "Landroid/graphics/Bitmap;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Xok;
  private static final j Xol;
  public static final MMKVSlotManager Xom;
  
  static
  {
    AppMethodBeat.i(297193);
    Xok = new a();
    Xol = k.cm((kotlin.g.a.a)a.Xon);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("MicroMsg.MPVideoPreviewDataMgr");
    s.s(localMultiProcessMMKV, "getMMKV(TAG)");
    Xom = new MMKVSlotManager(localMultiProcessMMKV, 600L);
    AppMethodBeat.o(297193);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(297167);
    if (!iBO())
    {
      AppMethodBeat.o(297167);
      return;
    }
    Object localObject = (MultiProcessMMKV)Xom.getSlotForWrite();
    ((MultiProcessMMKV)localObject).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_playTime", paramInt1);
    ((MultiProcessMMKV)localObject).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_expire", paramInt2);
    if (paramBitmap != null)
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      paramBitmap = Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      s.s(paramBitmap, "encodeToString(os.toByte…roid.util.Base64.DEFAULT)");
    }
    for (;;)
    {
      ((MultiProcessMMKV)Xom.getSlotForWrite()).encode("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_bitmap", paramBitmap);
      AppMethodBeat.o(297167);
      return;
      paramBitmap = "";
    }
  }
  
  public static void bmN(String paramString)
  {
    AppMethodBeat.i(297163);
    try
    {
      paramString = new JSONObject(paramString).optString("video_data");
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "reportByLeaveForMPGateway video_data null");
        AppMethodBeat.o(297163);
        return;
      }
      paramString = new JSONObject(paramString);
      String str = paramString.optString("vid");
      int i = (int)Util.getFloat(paramString.optString("lastPlayedTime"), 0.0F);
      float f = Util.getFloat(paramString.optString("lastPlayedTimeExpiredTime"), 0.0F);
      a(str, i, (int)f, null);
      AppMethodBeat.o(297163);
      return;
    }
    catch (Exception paramString)
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", "reportByLeaveForMPGateway, ex = %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(297163);
    }
  }
  
  public static void bmO(String paramString)
  {
    AppMethodBeat.i(297176);
    if (!iBO())
    {
      AppMethodBeat.o(297176);
      return;
    }
    Map localMap = bmP(paramString);
    if (localMap == null)
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", "prepareOnReceivePageData vid not found");
      ((MultiProcessMMKV)Xom.getSlotForWrite()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
      AppMethodBeat.o(297176);
      return;
    }
    ((MultiProcessMMKV)Xom.getSlotForWrite()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", paramString);
    paramString = localMap.get("videoInitialSnapshot");
    if ((paramString instanceof String))
    {
      paramString = (String)paramString;
      if (paramString != null) {
        break label121;
      }
    }
    label121:
    for (paramString = null;; paramString = Integer.valueOf(paramString.length()))
    {
      Log.v("MicroMsg.MPVideoPreviewDataMgr", s.X("prepareOnReceivePageData len = ", paramString));
      AppMethodBeat.o(297176);
      return;
      paramString = null;
      break;
    }
  }
  
  public static Map<String, Object> bmP(String paramString)
  {
    String str = null;
    AppMethodBeat.i(297185);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", "getVideo vid null");
      AppMethodBeat.o(297185);
      return null;
    }
    MMKVSlotManager localMMKVSlotManager = Xom;
    int j = localMMKVSlotManager.decodeInt("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_playTime", 0);
    int k = localMMKVSlotManager.decodeInt("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_expire", 0);
    if (System.currentTimeMillis() / 1000L > k) {}
    Object localObject;
    for (int i = 1;; i = 0)
    {
      localObject = str;
      if (j == 0) {
        break label229;
      }
      localObject = str;
      if (k == 0) {
        break label229;
      }
      localObject = str;
      if (i != 0) {
        break label229;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("videoInitialTime", (Object)Integer.valueOf(j));
      str = localMMKVSlotManager.decodeString("MicroMsg.MPVideoPreviewDataMgr_" + paramString + "_bitmap", "");
      if (str != null) {
        break;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type java.lang.Object");
      AppMethodBeat.o(297185);
      throw paramString;
    }
    ((HashMap)localObject).put("videoInitialSnapshot", (Object)str);
    label229:
    paramString = new StringBuilder("getVideo vid = ").append(paramString).append(", map size = ");
    if (localObject == null) {}
    for (i = 0;; i = ((HashMap)localObject).size())
    {
      Log.i("MicroMsg.MPVideoPreviewDataMgr", i);
      paramString = (Map)localObject;
      AppMethodBeat.o(297185);
      return paramString;
    }
  }
  
  public static boolean iBO()
  {
    AppMethodBeat.i(297153);
    boolean bool = ((Boolean)Xol.getValue()).booleanValue();
    AppMethodBeat.o(297153);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final a Xon;
    
    static
    {
      AppMethodBeat.i(297154);
      Xon = new a();
      AppMethodBeat.o(297154);
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