package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.n;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements c, b
{
  private static final int vot;
  public com.tencent.mm.plugin.webview.stub.d igU;
  public boolean ready;
  public String uZS;
  public int uZg;
  private k voA;
  public boolean voB;
  public String voC;
  private Set<d.b> voD;
  public d.a voE;
  public String voF;
  public String voG;
  private final List<String> voH;
  volatile String voI;
  volatile int voJ;
  private JSONObject voK;
  private JSONArray voL;
  private List<String> voM;
  private ap voN;
  public long voO;
  public MMWebView vou;
  private final List<String> vov;
  private final LinkedList<i> vow;
  private ak vox;
  Map<String, Object> voy;
  public Map<String, Object> voz;
  
  static
  {
    AppMethodBeat.i(9017);
    if (com.tencent.mm.compatible.util.d.fw(19)) {}
    for (int i = 200;; i = 20)
    {
      vot = i;
      AppMethodBeat.o(9017);
      return;
    }
  }
  
  public d(MMWebView paramMMWebView, k paramk, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8934);
    this.vov = new LinkedList();
    this.vow = new LinkedList();
    this.vox = null;
    this.ready = false;
    this.voB = false;
    this.voC = "";
    this.voH = new LinkedList();
    this.voI = null;
    this.voJ = 0;
    this.voK = new JSONObject();
    this.voL = new JSONArray();
    this.voM = new LinkedList();
    this.voN = new ap(new d.28(this), false);
    this.voO = 0L;
    this.vou = paramMMWebView;
    this.voA = paramk;
    this.voy = paramMap;
    dgi();
    ab.i("MicroMsg.JsApiHandler", "JsApiHandler<init>, webview: %d, this: %d", new Object[] { Integer.valueOf(paramMMWebView.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(8934);
  }
  
  public d(MMWebView paramMMWebView, k paramk, Map<String, Object> paramMap, com.tencent.mm.plugin.webview.stub.d paramd, int paramInt)
  {
    AppMethodBeat.i(8935);
    this.vov = new LinkedList();
    this.vow = new LinkedList();
    this.vox = null;
    this.ready = false;
    this.voB = false;
    this.voC = "";
    this.voH = new LinkedList();
    this.voI = null;
    this.voJ = 0;
    this.voK = new JSONObject();
    this.voL = new JSONArray();
    this.voM = new LinkedList();
    this.voN = new ap(new d.28(this), false);
    this.voO = 0L;
    this.vou = paramMMWebView;
    this.voA = paramk;
    this.igU = paramd;
    this.voy = paramMap;
    this.uZg = paramInt;
    dgi();
    ab.i("MicroMsg.JsApiHandler", "JsApiHandler<init>, webview: %d, this: %d", new Object[] { Integer.valueOf(paramMMWebView.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(8935);
  }
  
  /* Error */
  private static boolean C(String paramString, Map<String, Integer> paramMap)
  {
    // Byte code:
    //   0: sipush 9009
    //   3: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 191	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +18 -> 32
    //   17: ldc 154
    //   19: ldc 193
    //   21: invokestatic 197	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: sipush 9009
    //   27: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_0
    //   31: ireturn
    //   32: new 199	java/io/File
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual 206	java/io/File:exists	()Z
    //   45: ifne +8 -> 53
    //   48: aload_3
    //   49: invokevirtual 209	java/io/File:createNewFile	()Z
    //   52: pop
    //   53: aconst_null
    //   54: astore 4
    //   56: new 211	java/io/BufferedOutputStream
    //   59: dup
    //   60: new 213	java/io/FileOutputStream
    //   63: dup
    //   64: aload_0
    //   65: iconst_1
    //   66: invokespecial 216	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   69: invokespecial 219	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   72: astore_3
    //   73: aload_1
    //   74: invokeinterface 225 1 0
    //   79: invokeinterface 231 1 0
    //   84: astore 4
    //   86: aload 4
    //   88: invokeinterface 236 1 0
    //   93: ifeq +152 -> 245
    //   96: aload 4
    //   98: invokeinterface 240 1 0
    //   103: checkcast 242	java/lang/String
    //   106: astore 5
    //   108: aload_1
    //   109: aload 5
    //   111: invokeinterface 246 2 0
    //   116: checkcast 162	java/lang/Integer
    //   119: invokevirtual 249	java/lang/Integer:intValue	()I
    //   122: istore_2
    //   123: aload_3
    //   124: new 251	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   131: iload_2
    //   132: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: ldc_w 258
    //   138: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 5
    //   143: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokevirtual 269	java/lang/String:getBytes	()[B
    //   152: invokevirtual 275	java/io/OutputStream:write	([B)V
    //   155: aload_3
    //   156: bipush 13
    //   158: invokevirtual 277	java/io/OutputStream:write	(I)V
    //   161: aload_3
    //   162: bipush 10
    //   164: invokevirtual 277	java/io/OutputStream:write	(I)V
    //   167: goto -81 -> 86
    //   170: astore_1
    //   171: aload_3
    //   172: astore_0
    //   173: ldc 154
    //   175: aload_1
    //   176: ldc 109
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: ldc 154
    //   187: ldc_w 283
    //   190: invokestatic 197	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_0
    //   194: ifnull +7 -> 201
    //   197: aload_0
    //   198: invokevirtual 286	java/io/OutputStream:close	()V
    //   201: sipush 9009
    //   204: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: iconst_0
    //   208: ireturn
    //   209: astore_1
    //   210: ldc 154
    //   212: ldc_w 288
    //   215: aload_0
    //   216: invokestatic 291	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   219: invokevirtual 295	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   222: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: ldc 154
    //   227: aload_1
    //   228: ldc 109
    //   230: iconst_0
    //   231: anewarray 4	java/lang/Object
    //   234: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: sipush 9009
    //   240: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: iconst_0
    //   244: ireturn
    //   245: aload_3
    //   246: invokevirtual 301	java/io/OutputStream:flush	()V
    //   249: aload_3
    //   250: invokevirtual 286	java/io/OutputStream:close	()V
    //   253: ldc 154
    //   255: ldc_w 303
    //   258: aload_0
    //   259: invokestatic 291	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   262: invokevirtual 295	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   265: invokestatic 306	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: sipush 9009
    //   271: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: iconst_1
    //   275: ireturn
    //   276: astore_1
    //   277: ldc 154
    //   279: aload_1
    //   280: ldc 109
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: goto -36 -> 253
    //   292: astore_0
    //   293: ldc 154
    //   295: aload_0
    //   296: ldc 109
    //   298: iconst_0
    //   299: anewarray 4	java/lang/Object
    //   302: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: goto -104 -> 201
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_1
    //   311: aload_1
    //   312: ifnull +7 -> 319
    //   315: aload_1
    //   316: invokevirtual 286	java/io/OutputStream:close	()V
    //   319: sipush 9009
    //   322: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   325: aload_0
    //   326: athrow
    //   327: astore_1
    //   328: ldc 154
    //   330: aload_1
    //   331: ldc 109
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: goto -21 -> 319
    //   343: astore_0
    //   344: aload_3
    //   345: astore_1
    //   346: goto -35 -> 311
    //   349: astore_3
    //   350: aload_0
    //   351: astore_1
    //   352: aload_3
    //   353: astore_0
    //   354: goto -43 -> 311
    //   357: astore_1
    //   358: aload 4
    //   360: astore_0
    //   361: goto -188 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	paramString	String
    //   0	364	1	paramMap	Map<String, Integer>
    //   122	10	2	i	int
    //   40	305	3	localObject1	Object
    //   349	4	3	localObject2	Object
    //   54	305	4	localIterator	Iterator
    //   106	36	5	str	String
    // Exception table:
    //   from	to	target	type
    //   73	86	170	java/lang/Exception
    //   86	167	170	java/lang/Exception
    //   245	249	170	java/lang/Exception
    //   48	53	209	java/io/IOException
    //   249	253	276	java/io/IOException
    //   197	201	292	java/io/IOException
    //   56	73	308	finally
    //   315	319	327	java/io/IOException
    //   73	86	343	finally
    //   86	167	343	finally
    //   245	249	343	finally
    //   173	193	349	finally
    //   56	73	357	java/lang/Exception
  }
  
  private void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt, String paramString3, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8994);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
      AppMethodBeat.o(8994);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
    JSONObject localJSONObject = new JSONObject();
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (localEntry.getValue() != null) {
          try
          {
            localJSONObject.put((String)localEntry.getKey(), new JSONObject(localEntry.getValue().toString()));
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              localJSONObject.put((String)localEntry.getKey(), new JSONArray(localEntry.getValue().toString()));
            }
            catch (JSONException localJSONException3)
            {
              try
              {
                localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
              }
              catch (JSONException localJSONException2)
              {
                ab.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException1, "", new Object[0]);
              }
            }
          }
        }
      }
    }
    try
    {
      localJSONObject.put("query", paramString1);
      localJSONObject.put("custom", paramString2);
      localJSONObject.put("tagList", paramJSONArray);
      localJSONObject.put("isBackButtonClick", paramInt);
      localJSONObject.put("sugId", paramString3);
      localJSONObject.put("sugClickType", 0);
      al.d(new d.50(this, i.a.a("onSearchInputConfirm", localJSONObject, this.voB, this.voC)));
      AppMethodBeat.o(8994);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
      }
    }
  }
  
  public static String aja(String paramString)
  {
    AppMethodBeat.i(9001);
    paramString = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[] { bo.nullAsNil(paramString) });
    AppMethodBeat.o(9001);
    return paramString;
  }
  
  private String ajc(String paramString)
  {
    AppMethodBeat.i(9008);
    String str1 = this.vou.getUrl();
    try
    {
      String str2 = n.getSHA1(str1 + paramString);
      str2 = e.esu + str2;
      ab.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[] { str1, paramString, str2 });
      AppMethodBeat.o(9008);
      return str2;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(str1)));
      ab.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
      AppMethodBeat.o(9008);
    }
    return null;
  }
  
  private void dgi()
  {
    AppMethodBeat.i(8936);
    this.vox = new d.1(this, Looper.getMainLooper());
    AppMethodBeat.o(8936);
  }
  
  private Map<String, Object> dgl()
  {
    AppMethodBeat.i(8948);
    HashMap localHashMap = new HashMap();
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.voA.ddV();
    LinkedList localLinkedList = new LinkedList();
    if (localJsapiPermissionWrapper != null)
    {
      if (localJsapiPermissionWrapper.jy(88)) {
        localLinkedList.add("menu:share:timeline");
      }
      if (localJsapiPermissionWrapper.jy(89)) {
        localLinkedList.add("menu:share:appmessage");
      }
      if (localJsapiPermissionWrapper.jy(94)) {
        localLinkedList.add("menu:share:qq");
      }
      if (localJsapiPermissionWrapper.jy(109)) {
        localLinkedList.add("menu:share:weiboApp");
      }
      if (localJsapiPermissionWrapper.jy(134)) {
        localLinkedList.add("menu:share:QZone");
      }
      if (localJsapiPermissionWrapper.jy(219)) {
        localLinkedList.add("sys:record");
      }
      localLinkedList.add("onVoiceRecordEnd");
      localLinkedList.add("onVoicePlayBegin");
      localLinkedList.add("onVoicePlayEnd");
      localLinkedList.add("onLocalImageUploadProgress");
      localLinkedList.add("onImageDownloadProgress");
      localLinkedList.add("onVoiceUploadProgress");
      localLinkedList.add("onVoiceDownloadProgress");
      localLinkedList.add("onVideoUploadProgress");
      localLinkedList.add("onMediaFileUploadProgress");
      localLinkedList.add("menu:setfont");
      localLinkedList.add("menu:haokan");
      localLinkedList.add("reportOnLeaveForMP");
      localLinkedList.add("onMPPageAction");
      localLinkedList.add("onMPVideoStateChange");
      localLinkedList.add("onReceiveMPPageData");
      localLinkedList.add("onMPAdWebviewStateChange");
      localLinkedList.add("menu:share:weibo");
      localLinkedList.add("menu:share:email");
      localLinkedList.add("wxdownload:state_change");
      localLinkedList.add("wxdownload:progress_change");
      localLinkedList.add("hdOnDeviceStateChanged");
      localLinkedList.add("activity:state_change");
      localLinkedList.add("onWXDeviceBluetoothStateChange");
      localLinkedList.add("onWXDeviceLanStateChange");
      localLinkedList.add("onWXDeviceBindStateChange");
      localLinkedList.add("onReceiveDataFromWXDevice");
      localLinkedList.add("onScanWXDeviceResult");
      localLinkedList.add("onWXDeviceStateChange");
      localLinkedList.add("onNfcTouch");
      localLinkedList.add("onBeaconMonitoring");
      localLinkedList.add("onBeaconsInRange");
      localLinkedList.add("menu:custom");
      localLinkedList.add("onSearchWAWidgetOpenApp");
      localLinkedList.add("onSearchDataReady");
      localLinkedList.add("onGetPoiInfoReturn");
      localLinkedList.add("onSearchHistoryReady");
      localLinkedList.add("onSearchWAWidgetOnTapCallback");
      localLinkedList.add("onSearchImageListReady");
      localLinkedList.add("onTeachSearchDataReady");
      localLinkedList.add("onSearchGuideDataReady");
      localLinkedList.add("onUxOplogDataReady");
      localLinkedList.add("onSearchInputChange");
      localLinkedList.add("onSearchInputConfirm");
      localLinkedList.add("onSearchSuggestionDataReady");
      localLinkedList.add("onMusicStatusChanged");
      localLinkedList.add("switchToTabSearch");
      localLinkedList.add("onVideoPlayerCallback");
      localLinkedList.add("onSelectContact");
      localLinkedList.add("onSearchWAWidgetAttrChanged");
      localLinkedList.add("onSearchWAWidgetReloadData");
      localLinkedList.add("onSearchWAWidgetReloadDataFinish");
      localLinkedList.add("onSearchWAWidgetStateChange");
      localLinkedList.add("onSearchWAWidgetDataPush");
      localLinkedList.add("emoticonIsChosen");
      localLinkedList.add("onSimilarEmoticonReady");
      localLinkedList.add("onPullDownRefresh");
      localLinkedList.add("onPageStateChange");
      localLinkedList.add("onGetKeyboardHeight");
      localLinkedList.add("onGetSmiley");
      localLinkedList.add("onAddShortcutStatus");
      localLinkedList.add("onFocusSearchInput");
      localLinkedList.add("onGetA8KeyUrl");
      localLinkedList.add("deleteAccountSuccess");
      localLinkedList.add("onGetMsgProofItems");
      localLinkedList.add("WNJSHandlerInsert");
      localLinkedList.add("WNJSHandlerMultiInsert");
      localLinkedList.add("WNJSHandlerExportData");
      localLinkedList.add("WNJSHandlerHeaderAndFooterChange");
      localLinkedList.add("WNJSHandlerEditableChange");
      localLinkedList.add("WNJSHandlerEditingChange");
      localLinkedList.add("WNJSHandlerSaveSelectionRange");
      localLinkedList.add("WNJSHandlerLoadSelectionRange");
      localLinkedList.add("onCustomGameMenuClicked");
      localLinkedList.add("showLoading");
      localLinkedList.add("getSearchEmotionDataCallBack");
      localLinkedList.add("onNavigationBarRightButtonClick");
      localLinkedList.add("onSearchActionSheetClick");
      localLinkedList.add("onGetMatchContactList");
      localLinkedList.add("onUiInit");
      localLinkedList.add("onNetWorkChange");
      localLinkedList.add("onMiniProgramData");
      localLinkedList.add("onBackgroundAudioStateChange");
      localLinkedList.add("onArticleReadingBtnClicked");
      if (!bo.es(null)) {
        localLinkedList.addAll(null);
      }
      localLinkedList.add("onReceivePageData");
      localLinkedList.add("onPageAuthOK");
      localLinkedList.add("onScrollViewDidScroll");
      localLinkedList.add("onPublishHaowanEnd");
      localLinkedList.add("onPublishHaowanProgress");
    }
    localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
    AppMethodBeat.o(8948);
    return localHashMap;
  }
  
  private void dgm()
  {
    AppMethodBeat.i(8949);
    while (dgn()) {}
    AppMethodBeat.o(8949);
  }
  
  private boolean dgn()
  {
    AppMethodBeat.i(8950);
    if (bo.es(this.vow))
    {
      ab.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
      AppMethodBeat.o(8950);
      return false;
    }
    boolean bool1;
    i locali;
    Object localObject1;
    Object localObject2;
    try
    {
      bool1 = this.igU.Kg(this.uZg);
      ab.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(bool1)));
      if (bool1)
      {
        ab.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
        AppMethodBeat.o(8950);
        return false;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ab.w("MicroMsg.JsApiHandler", "isBusy, ex = " + localException1.getMessage());
        bool1 = false;
      }
      if (this.vow.size() == 0)
      {
        ab.w("MicroMsg.JsApiHandler", "msgList size is 0.");
        AppMethodBeat.o(8950);
        return false;
      }
      locali = (i)this.vow.remove(0);
      if (locali == null)
      {
        ab.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
        AppMethodBeat.o(8950);
        return true;
      }
      if ((locali.vrQ == null) || (locali.pJb == null) || (locali.type == null) || (this.vou == null))
      {
        ab.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + locali.vrQ + ", params = " + locali.pJb + ", type = " + locali.type + ", wv = " + this.vou);
        AppMethodBeat.o(8950);
        return true;
      }
      if (locali.vrQ.equals("log"))
      {
        if ((this.voA.ddV() != null) && (this.voA.ddV().jy(0))) {
          ab.i("MicroMsg.JsApiHandler", "jslog : " + locali.pJb.get("msg"));
        }
        AppMethodBeat.o(8950);
        return true;
      }
      if ((this.voz != null) && (this.voz.get("srcUsername") != null) && (!bo.isNullOrNil(this.voz.get("srcUsername").toString()))) {
        locali.pJb.put("src_username", this.voz.get("srcUsername").toString());
      }
      if ((this.voz != null) && (this.voz.get("srcDisplayname") != null) && (!bo.isNullOrNil(this.voz.get("srcDisplayname").toString()))) {
        locali.pJb.put("src_displayname", this.voz.get("srcDisplayname").toString());
      }
      if ((this.voz != null) && (this.voz.get("KTemplateId") != null) && (!bo.isNullOrNil(this.voz.get("KTemplateId").toString()))) {
        locali.pJb.put("tempalate_id", this.voz.get("KTemplateId").toString());
      }
      if (this.voz != null)
      {
        locali.pJb.put("message_id", this.voz.get("message_id"));
        locali.pJb.put("message_index", this.voz.get("message_index"));
        locali.pJb.put("webview_scene", this.voz.get("scene"));
        locali.pJb.put("pay_channel", this.voz.get("pay_channel"));
        locali.pJb.put("pay_scene", this.voz.get("pay_scene"));
        ab.i("MicroMsg.JsApiHandler", "getPackageName %s", new Object[] { this.voz.get("pay_package") });
        if (this.voz.get("pay_package") != null) {
          locali.pJb.put("pay_packageName", this.voz.get("pay_package"));
        }
        locali.pJb.put("stastic_scene", this.voz.get("stastic_scene"));
        locali.pJb.put("open_from_scene", this.voz.get("from_scence"));
        localObject1 = locali.pJb;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("__jsapi_fw_ext_info_key_current_url", this.vou.getUrl());
        ((Map)localObject1).put("__jsapi_fw_ext_info", localObject2);
      }
      if ((!locali.vrQ.equals("shareWeibo")) && (!locali.vrQ.equals("openUrlByExtBrowser")) && (!locali.vrQ.equals("openUrlWithExtraWebview")) && (!locali.vrQ.equals("openCustomWebview")) && (!locali.vrQ.equals("openGameWebView")) && (!locali.vrQ.equals("addToEmoticon")) && (!locali.vrQ.equals("shareEmoticon")) && (!locali.vrQ.equals("openGameUrlWithExtraWebView")) && (!locali.vrQ.equals("request")))
      {
        locali.pJb.put("url", this.vou.getUrl());
        ab.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl:" + this.vou.getUrl());
      }
      if ((locali.vrQ.equalsIgnoreCase("openDesignerEmojiView")) || (locali.vrQ.equalsIgnoreCase("openEmotionDetailViewLocal")) || (locali.vrQ.equalsIgnoreCase("openDesignerEmojiView")) || (locali.vrQ.equalsIgnoreCase("openDesignerEmojiViewLocal")) || (locali.vrQ.equalsIgnoreCase("openDesignerEmojiView")) || (locali.vrQ.equalsIgnoreCase("openDesignerProfile")) || (locali.vrQ.equalsIgnoreCase("openDesignerProfileLocal")) || (locali.vrQ.equalsIgnoreCase("getSearchEmotionData")))
      {
        locali.pJb.put("searchID", Long.valueOf(dgq()));
        ab.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[] { Long.valueOf(dgq()) });
      }
      if (locali.vrQ.equals("request"))
      {
        locali.pJb.put("key_request_full_url_query", this.voF);
        locali.pJb.put("key_request_header", this.voG);
      }
      if (locali.vrQ.equals("imagePreview")) {
        j.a(locali.pJb, this.vou);
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = this.voA.ddV();
        localObject1 = new Bundle();
        if (localObject2 != null)
        {
          ((Bundle)localObject1).putByteArray("jsapi_perm_wrapper_bytes", ((JsapiPermissionWrapper)localObject2).wif);
          ((Bundle)localObject1).putInt("jsapi_perm_wrapper_hardcodePermission", ((JsapiPermissionWrapper)localObject2).wig);
          ((Bundle)localObject1).putIntArray("jsapi_perm_wrapper_blacklist", ((JsapiPermissionWrapper)localObject2).dqA());
          ((Bundle)localObject1).putIntArray("jsapi_perm_wrapper_whitelist", ((JsapiPermissionWrapper)localObject2).dqB());
        }
        localObject3 = i.aQ(locali.pJb);
        if (!bo.isNullOrNil(this.uZS)) {
          ((Bundle)localObject3).putString("key_wxapp_id", this.uZS);
        }
        localObject2 = new Bundle(2);
        ((Bundle)localObject2).putBundle("compatParams", (Bundle)localObject3);
        if (locali.vrO != null) {
          ((Bundle)localObject2).putString("rawParams", locali.vrO.toString());
        }
        ab.v("MicroMsg.JsApiHandler", "dealNextMsg start %s", new Object[] { locali.vrQ });
        if (this.voE == null) {
          break label1770;
        }
        bool1 = this.voE.b(locali);
        if (!bool1) {}
      }
      catch (Exception localException2)
      {
        Object localObject3;
        WebViewUI localWebViewUI;
        int i;
        boolean bool2;
        bool1 = false;
        ab.printErrStackTrace("MicroMsg.JsApiHandler", localException2, "", new Object[0]);
        ab.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + localException2.getMessage());
        continue;
        AppMethodBeat.o(8950);
        return false;
      }
      try
      {
        ab.v("MicroMsg.JsApiHandler", "dealNextMsg intercepted %s", new Object[] { locali.vrQ });
        j.dcK();
        ab.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[] { locali.vrQ, Boolean.valueOf(bool1) });
        if (bool1) {
          continue;
        }
        AppMethodBeat.o(8950);
        return true;
      }
      catch (Exception localException3)
      {
        continue;
        continue;
      }
      if ((this.igU != null) && (locali != null))
      {
        localObject3 = this.voA.ddW();
        if ((this.vou != null) && ((this.vou.getContext() instanceof WebViewUI)))
        {
          localWebViewUI = (WebViewUI)this.vou.getContext();
          if ((this.vou == localWebViewUI.pOd) && (localWebViewUI.veQ) && (!((GeneralControlWrapper)localObject3).dqu()))
          {
            ab.e("MicroMsg.JsApiHandler", "Can not call js api now, forbidJsApiExcuteNow:%b, canCallJsApiBeforeLoaded:%b", new Object[] { Boolean.valueOf(localWebViewUI.veQ), Boolean.valueOf(((GeneralControlWrapper)localObject3).dqu()) });
            i = 0;
            if (i != 0)
            {
              bool2 = this.igU.a(locali.type, locali.vrQ, locali.vrN, (Bundle)localObject1, (Bundle)localObject2, this.uZg);
              bool1 = bool2;
            }
          }
          else
          {
            i = 1;
            continue;
          }
        }
        else
        {
          i = 1;
          continue;
        }
      }
      label1770:
      bool1 = false;
    }
  }
  
  /* Error */
  private static boolean hA(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 9010
    //   3: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 191	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 191	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +18 -> 35
    //   20: ldc 154
    //   22: ldc 193
    //   24: invokestatic 197	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: sipush 9010
    //   30: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: iconst_0
    //   34: ireturn
    //   35: new 199	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_2
    //   44: aload_2
    //   45: invokevirtual 206	java/io/File:exists	()Z
    //   48: ifne +8 -> 56
    //   51: aload_2
    //   52: invokevirtual 209	java/io/File:createNewFile	()Z
    //   55: pop
    //   56: aconst_null
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_3
    //   60: new 211	java/io/BufferedOutputStream
    //   63: dup
    //   64: new 213	java/io/FileOutputStream
    //   67: dup
    //   68: aload_0
    //   69: iconst_1
    //   70: invokespecial 216	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   73: invokespecial 219	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   76: astore 4
    //   78: new 213	java/io/FileOutputStream
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 978	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   86: astore 5
    //   88: aload 5
    //   90: astore_3
    //   91: aload 5
    //   93: astore_2
    //   94: aload 5
    //   96: aload_1
    //   97: invokevirtual 269	java/lang/String:getBytes	()[B
    //   100: invokevirtual 275	java/io/OutputStream:write	([B)V
    //   103: aload 5
    //   105: astore_3
    //   106: aload 5
    //   108: astore_2
    //   109: aload 5
    //   111: bipush 13
    //   113: invokevirtual 277	java/io/OutputStream:write	(I)V
    //   116: aload 5
    //   118: astore_3
    //   119: aload 5
    //   121: astore_2
    //   122: aload 5
    //   124: bipush 10
    //   126: invokevirtual 277	java/io/OutputStream:write	(I)V
    //   129: aload 5
    //   131: astore_3
    //   132: aload 5
    //   134: astore_2
    //   135: aload 5
    //   137: invokevirtual 301	java/io/OutputStream:flush	()V
    //   140: aload 5
    //   142: invokevirtual 286	java/io/OutputStream:close	()V
    //   145: ldc 154
    //   147: ldc_w 303
    //   150: aload_0
    //   151: invokestatic 291	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   154: invokevirtual 295	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokestatic 306	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: sipush 9010
    //   163: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_1
    //   169: ldc 154
    //   171: ldc_w 288
    //   174: aload_0
    //   175: invokestatic 291	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   178: invokevirtual 295	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   181: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: ldc 154
    //   186: aload_1
    //   187: ldc 109
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: sipush 9010
    //   199: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_1
    //   205: ldc 154
    //   207: aload_1
    //   208: ldc 109
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: goto -72 -> 145
    //   220: astore_0
    //   221: aload_3
    //   222: astore_2
    //   223: ldc 154
    //   225: aload_0
    //   226: ldc 109
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload_3
    //   236: astore_2
    //   237: ldc 154
    //   239: ldc_w 283
    //   242: invokestatic 197	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 286	java/io/OutputStream:close	()V
    //   253: sipush 9010
    //   256: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: iconst_0
    //   260: ireturn
    //   261: astore_0
    //   262: ldc 154
    //   264: aload_0
    //   265: ldc 109
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -21 -> 253
    //   277: astore_0
    //   278: aload_2
    //   279: ifnull +7 -> 286
    //   282: aload_2
    //   283: invokevirtual 286	java/io/OutputStream:close	()V
    //   286: sipush 9010
    //   289: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: astore_1
    //   295: ldc 154
    //   297: aload_1
    //   298: ldc 109
    //   300: iconst_0
    //   301: anewarray 4	java/lang/Object
    //   304: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: goto -21 -> 286
    //   310: astore_0
    //   311: aload 4
    //   313: astore_2
    //   314: goto -36 -> 278
    //   317: astore_0
    //   318: aload 4
    //   320: astore_3
    //   321: goto -100 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramString1	String
    //   0	324	1	paramString2	String
    //   43	271	2	localObject1	Object
    //   59	262	3	localObject2	Object
    //   76	243	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   86	55	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   51	56	168	java/io/IOException
    //   140	145	204	java/io/IOException
    //   60	78	220	java/lang/Exception
    //   94	103	220	java/lang/Exception
    //   109	116	220	java/lang/Exception
    //   122	129	220	java/lang/Exception
    //   135	140	220	java/lang/Exception
    //   249	253	261	java/io/IOException
    //   60	78	277	finally
    //   94	103	277	finally
    //   109	116	277	finally
    //   122	129	277	finally
    //   135	140	277	finally
    //   223	235	277	finally
    //   237	245	277	finally
    //   282	286	294	java/io/IOException
    //   78	88	310	finally
    //   78	88	317	java/lang/Exception
  }
  
  public final void B(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(8974);
    ab.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8974);
      return;
    }
    this.voI = paramString;
    if ((paramMap != null) && (paramMap.size() != 0)) {}
    for (this.voJ = 1;; this.voJ = 0)
    {
      al.d(new d.27(this, paramMap, paramString, eb(paramString, this.voJ)));
      AppMethodBeat.o(8974);
      return;
    }
  }
  
  public final void KQ(int paramInt)
  {
    this.uZg = paramInt;
  }
  
  public final void KR(int paramInt)
  {
    AppMethodBeat.i(8953);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
      AppMethodBeat.o(8953);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("fontSize", String.valueOf(paramInt));
    localObject = i.a.b("menu:setfont", (Map)localObject, this.voB, this.voC);
    this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    AppMethodBeat.o(8953);
  }
  
  public final Bundle KS(int paramInt)
  {
    AppMethodBeat.i(8956);
    try
    {
      Object localObject = this.vou;
      if (localObject == null)
      {
        AppMethodBeat.o(8956);
        return null;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("WebViewShare_type", paramInt);
      ((Bundle)localObject).putInt("WebViewShare_BinderID", this.uZg);
      ((Bundle)localObject).putString("WebViewShare_wv_url", this.vou.getUrl());
      localObject = this.igU.i(105, (Bundle)localObject);
      ((Bundle)localObject).putBoolean("use_update_jsapi_data", true);
      AppMethodBeat.o(8956);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.JsApiHandler", "getShareData err %s", new Object[] { localRemoteException.getMessage() });
      AppMethodBeat.o(8956);
    }
    return null;
  }
  
  public final void KT(int paramInt)
  {
    AppMethodBeat.i(8971);
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(a.ar(ah.getContext(), paramInt)));
    al.d(new d.22(this, i.a.b("onGetKeyboardHeight", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8971);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(String paramString)
  {
    AppMethodBeat.i(8940);
    if (paramString != null) {
      this.vox.post(new d.71(this, paramString));
    }
    AppMethodBeat.o(8940);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String _getDgtVerifyRandomStr()
  {
    return this.voC;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(String paramString)
  {
    AppMethodBeat.i(8941);
    if (paramString != null) {
      this.vox.post(new d.72(this, paramString));
    }
    AppMethodBeat.o(8941);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final boolean _isDgtVerifyEnabled()
  {
    return this.voB;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _ready(boolean paramBoolean)
  {
    this.ready = paramBoolean;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(8939);
    if (this.vox != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      this.vox.sendMessage(localMessage);
    }
    AppMethodBeat.o(8939);
  }
  
  public final void a(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(8999);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
      AppMethodBeat.o(8999);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onUxOplogDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("reqId", Long.valueOf(paramLong));
    localHashMap.put("json", paramString);
    al.d(new d.57(this, i.a.b("onUxOplogDataReady", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8999);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(8946);
    if (this.voD == null) {
      this.voD = new HashSet();
    }
    this.voD.add(paramb);
    AppMethodBeat.o(8946);
  }
  
  public final void a(k paramk)
  {
    this.voA = paramk;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, float paramFloat)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(8976);
        if (this.voN.dtj()) {
          this.voN.ag(1000L, 1000L);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((paramDouble1 > 0.0D) && (paramDouble1 < 0.5D)) {
          try
          {
            if (!this.voM.contains(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2)))
            {
              this.voM.add(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2));
              localJSONObject.put("uuid", String.valueOf(paramString));
              localJSONObject.put("major", String.valueOf(paramInt1));
              localJSONObject.put("minor", String.valueOf(paramInt2));
              localJSONObject.put("accuracy", String.valueOf(paramDouble1));
              localJSONObject.put("rssi", String.valueOf(paramDouble2));
              localJSONObject.put("heading", String.valueOf(paramFloat));
              localJSONObject.put("proximity", String.valueOf(i));
              this.voL.put(localJSONObject);
              this.voK.put("beacons", this.voL);
              this.voK.put("err_msg", "onBeaconsInRange:ok");
            }
            i.a.a("onBeaconsInRange", this.voK, this.voB, this.voC);
            AppMethodBeat.o(8976);
            return;
          }
          catch (Exception paramString)
          {
            ab.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", new Object[] { paramString.getMessage() });
            continue;
          }
        }
        i = 0;
      }
      finally {}
    }
  }
  
  public final void a(String paramString, long paramLong, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(153337);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(153337);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", paramString);
    localHashMap.put("download_id", Long.valueOf(paramLong));
    localHashMap.put("progress", Integer.valueOf(paramInt));
    localHashMap.put("progress_float", Float.valueOf(paramFloat));
    al.d(new d.2(this, i.a.b("wxdownload:progress_change", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(153337);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(155704);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, not ready");
      AppMethodBeat.o(155704);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onEmoticonIsChosen success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("md5", paramString1);
    localHashMap.put("thumbPath", paramString2);
    localHashMap.put("tab", Integer.valueOf(paramInt1));
    localHashMap.put("asyncDownload", Integer.valueOf(paramInt2));
    localHashMap.put("emojiUrl", paramString3);
    localHashMap.put("aesKey", paramString4);
    al.d(new d.53(this, i.a.b("emoticonIsChosen", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(155704);
  }
  
  public final void a(String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(8977);
    if (!bo.isNullOrNil(paramString1)) {
      j(paramString1, paramString2, paramMap);
    }
    if (paramBoolean) {
      dda();
    }
    AppMethodBeat.o(8977);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(8989);
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    a("onSearchInputChange", localHashMap, null);
    AppMethodBeat.o(8989);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(8988);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
      AppMethodBeat.o(8988);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    localHashMap.put("isCancelButtonClick", Integer.valueOf(paramInt));
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8911);
        try
        {
          d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
          AppMethodBeat.o(8911);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(8911);
        }
      }
    });
    AppMethodBeat.o(8988);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8993);
    a(paramString1, paramString2, paramJSONArray, paramInt, "", paramMap);
    AppMethodBeat.o(8993);
  }
  
  public final void a(String paramString, Map<String, Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(8991);
    if ((!this.ready) || ((paramMap == null) && (paramJSONObject == null)))
    {
      ab.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[] { paramString });
      AppMethodBeat.o(8991);
      return;
    }
    String str1;
    String str2;
    if (paramMap == null)
    {
      str1 = "";
      if (paramJSONObject != null) {
        break label133;
      }
      str2 = "";
      label60:
      ab.i("MicroMsg.JsApiHandler", "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s", new Object[] { paramString, str1, str2 });
      if (paramMap == null) {
        break label142;
      }
    }
    label133:
    label142:
    for (paramMap = i.a.b(paramString, paramMap, this.voB, this.voC);; paramMap = i.a.a(paramString, paramJSONObject, this.voB, this.voC))
    {
      al.d(new d.48(this, paramMap, paramString));
      AppMethodBeat.o(8991);
      return;
      str1 = paramMap.toString();
      break;
      str2 = paramJSONObject.toString();
      break label60;
    }
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(8986);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
      AppMethodBeat.o(8986);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventId", paramString1);
    localHashMap.put("widgetId", paramString3);
    localHashMap.put("hitTest", Boolean.valueOf(paramBoolean));
    localHashMap.put("err_msg", paramString2);
    al.d(new d.40(this, i.a.b("onSearchWAWidgetOnTapCallback", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8986);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, JSONArray paramJSONArray, String paramString8, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8992);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, not ready");
      AppMethodBeat.o(8992);
      return false;
    }
    ab.i("MicroMsg.JsApiHandler", "switchToTabSearch success, ready %s %s %s %s %s", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5 });
    JSONObject localJSONObject = new JSONObject();
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (localEntry.getValue() != null) {
          try
          {
            localJSONObject.put((String)localEntry.getKey(), new JSONObject(localEntry.getValue().toString()));
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              localJSONObject.put((String)localEntry.getKey(), new JSONArray(localEntry.getValue().toString()));
            }
            catch (JSONException localJSONException3)
            {
              try
              {
                localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
              }
              catch (JSONException localJSONException2)
              {
                ab.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException1, "", new Object[0]);
              }
            }
          }
        }
      }
    }
    try
    {
      localJSONObject.put("type", paramString1);
      localJSONObject.put("isMostSearchBiz", paramString2);
      localJSONObject.put("isSug", paramString3);
      localJSONObject.put("isLocalSug", paramString5);
      localJSONObject.put("scene", paramString4);
      localJSONObject.put("query", paramString6);
      localJSONObject.put("custom", paramString7);
      localJSONObject.put("tagList", paramJSONArray);
      localJSONObject.put("isBackButtonClick", 0);
      localJSONObject.put("sugId", paramString8);
      localJSONObject.put("sugClickType", paramInt);
      al.d(new d.49(this, i.a.a("switchToTabSearch", localJSONObject, this.voB, this.voC)));
      AppMethodBeat.o(8992);
      return true;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
      }
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8990);
    localJSONObject = new JSONObject();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      try
      {
        localJSONObject.put("scene", paramString1);
        localJSONObject.put("type", paramString2);
        localJSONObject.put("isSug", paramString3);
        localJSONObject.put("isLocalSug", paramString4);
        localJSONObject.put("sessionId", paramString5);
        a("switchToTabSearch", null, localJSONObject);
        AppMethodBeat.o(8990);
        return true;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
        }
      }
    }
    catch (Exception paramMap)
    {
      ab.printErrStackTrace("MicroMsg.JsApiHandler", paramMap, "", new Object[0]);
    }
  }
  
  public final void aL(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8944);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onPreloadWebViewInit fail, not ready");
      AppMethodBeat.o(8944);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onPreloadWebViewInit success, ready");
    if (paramMap == null) {}
    for (String str = "";; str = paramMap.toString())
    {
      ab.i("MicroMsg.JsApiHandler", "onPreloadWebViewInit,params %s", new Object[] { str });
      al.d(new d.44(this, i.a.b("onUiInit", paramMap, this.voB, this.voC)));
      AppMethodBeat.o(8944);
      return;
    }
  }
  
  public final Bundle aM(Map<String, String> paramMap)
  {
    AppMethodBeat.i(8957);
    Bundle localBundle = new Bundle();
    String str1 = this.vou.getUrl();
    String str2;
    if (paramMap != null)
    {
      str2 = (String)paramMap.get("share_report_pre_msg_url");
      if (!bo.isNullOrNil(str2)) {
        break label272;
      }
      str2 = str1;
    }
    label272:
    for (;;)
    {
      Object localObject = (String)paramMap.get("share_report_pre_msg_title");
      if (bo.isNullOrNil((String)localObject)) {
        localObject = this.vou.getTitle();
      }
      for (;;)
      {
        String str4 = (String)paramMap.get("share_report_pre_msg_desc");
        String str3 = str4;
        if (bo.isNullOrNil(str4)) {
          str3 = str1;
        }
        localBundle.putString("link", str2);
        localBundle.putString("desc", str3);
        localBundle.putString("img_url", bo.nullAsNil((String)paramMap.get("share_report_pre_msg_icon_url")));
        if (bo.isNullOrNil((String)localObject)) {
          if (!bo.isNullOrNil(str1))
          {
            localObject = Uri.parse(str1);
            paramMap = str1;
            if (((Uri)localObject).getHost() != null) {
              paramMap = ((Uri)localObject).getHost();
            }
          }
        }
        for (;;)
        {
          localBundle.putString("title", paramMap);
          localBundle.putBoolean("use_update_jsapi_data", false);
          AppMethodBeat.o(8957);
          return localBundle;
          localObject = this.vou.getTitle();
          localBundle.putString("link", str1);
          localBundle.putString("desc", str1);
          localBundle.putString("img_url", "");
          break;
          paramMap = ah.getContext().getString(2131305871);
          continue;
          paramMap = (Map<String, String>)localObject;
        }
      }
    }
  }
  
  public final void aN(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8963);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
      AppMethodBeat.o(8963);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
    al.d(new d.9(this, i.a.b("onVoicePlayEnd", paramMap, this.voB, this.voC)));
    AppMethodBeat.o(8963);
  }
  
  public final void aO(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8964);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
      AppMethodBeat.o(8964);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
    paramMap = i.a.b("onVoiceRecordEnd", paramMap, this.voB, this.voC);
    ab.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[] { paramMap });
    al.d(new d.10(this, paramMap));
    AppMethodBeat.o(8964);
  }
  
  public final void aP(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8981);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
      AppMethodBeat.o(8981);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
    al.d(new d.31(this, i.a.b("onSelectContact", paramMap, this.voB, this.voC)));
    AppMethodBeat.o(8981);
  }
  
  public final void aU(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(8983);
    al.d(new d.35(this, i.a.a("onGetMatchContactList", paramJSONObject, this.voB, this.voC)));
    AppMethodBeat.o(8983);
  }
  
  public final void aiS(String paramString)
  {
    this.voF = paramString;
  }
  
  public final void aiT(String paramString)
  {
    this.voG = paramString;
  }
  
  public final void aiU(String paramString)
  {
    AppMethodBeat.i(153335);
    if (!this.ready)
    {
      AppMethodBeat.o(153335);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramString);
    paramString = i.a.b("onReceiveMPPageData", localHashMap, this.voB, this.voC);
    this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(153335);
  }
  
  public final void aiV(String paramString)
  {
    AppMethodBeat.i(153336);
    if (!this.ready)
    {
      AppMethodBeat.o(153336);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = i.a.b("onMPAdWebviewStateChange", localHashMap, this.voB, this.voC);
    this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(153336);
  }
  
  public final void aiW(String paramString)
  {
    AppMethodBeat.i(8962);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready");
      AppMethodBeat.o(8962);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = ".concat(String.valueOf(paramString)));
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = i.a.b("activity:state_change", localHashMap, this.voB, this.voC);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      try
      {
        this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        AppMethodBeat.o(8962);
        return;
      }
      catch (Exception paramString)
      {
        ab.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(8962);
        return;
      }
    }
    al.d(new d.8(this, paramString));
    AppMethodBeat.o(8962);
  }
  
  public final void aiX(String paramString)
  {
    AppMethodBeat.i(8970);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onGoProfile fail, not ready");
      AppMethodBeat.o(8970);
      return;
    }
    if (this.vox != null) {
      this.vox.post(new d.21(this, paramString));
    }
    AppMethodBeat.o(8970);
  }
  
  public final void aiY(String paramString)
  {
    AppMethodBeat.i(8973);
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(154915);
        try
        {
          d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
          AppMethodBeat.o(154915);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(154915);
        }
      }
    });
    AppMethodBeat.o(8973);
  }
  
  public final void aiZ(String paramString)
  {
    AppMethodBeat.i(8995);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
      AppMethodBeat.o(8995);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    al.d(new d.51(this, i.a.b("onSearchSuggestionDataReady", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8995);
  }
  
  public final boolean ait(final String paramString)
  {
    AppMethodBeat.i(8943);
    this.vou.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback() {});
    AppMethodBeat.o(8943);
    return true;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(8942);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8942);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://dispatch_message/");
    AppMethodBeat.o(8942);
    return bool;
  }
  
  public final void ajb(String paramString)
  {
    AppMethodBeat.i(9005);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(9005);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("netType", paramString);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153327);
        try
        {
          d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
          AppMethodBeat.o(153327);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(153327);
        }
      }
    });
    AppMethodBeat.o(9005);
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(8985);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
      AppMethodBeat.o(8985);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramBundle.getString("json"));
    localHashMap.put("searchId", paramBundle.getString("searchId"));
    localHashMap.put("poiId", paramBundle.getString("poiId"));
    al.d(new d.38(this, i.a.b("onGetPoiInfoReturn", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8985);
  }
  
  public final void az(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(153334);
    if (!this.ready)
    {
      AppMethodBeat.o(153334);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString1);
    localHashMap.put("vid", paramString2);
    localHashMap.put("errMsg", paramString3);
    paramString1 = i.a.b("onMPVideoStateChange", localHashMap, this.voB, this.voC);
    this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(153334);
  }
  
  public final void bG(int paramInt, String paramString)
  {
    AppMethodBeat.i(8996);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
      AppMethodBeat.o(8996);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("data", paramString);
    al.d(new d.52(this, i.a.b("onSearchImageListReady", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8996);
  }
  
  public final void bQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(8938);
    try
    {
      this.igU.j(paramString, paramBoolean, this.uZg);
      AppMethodBeat.o(8938);
      return;
    }
    catch (Exception paramString)
    {
      ab.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(8938);
    }
  }
  
  public final void dU(String paramString, int paramInt)
  {
    AppMethodBeat.i(153333);
    if (!this.ready)
    {
      AppMethodBeat.o(153333);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    localHashMap.put("shareFuncFlag", Integer.valueOf(paramInt));
    paramString = i.a.b("onMPPageAction", localHashMap, this.voB, this.voC);
    this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(153333);
  }
  
  public final void dV(String paramString, int paramInt)
  {
    AppMethodBeat.i(8961);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
      AppMethodBeat.o(8961);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.JsApiHandler", "parameter error!!!");
      AppMethodBeat.o(8961);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceId", paramString);
    if (paramInt == 2) {
      localHashMap.put("state", "connected");
    }
    for (;;)
    {
      al.d(new d.3(this, i.a.b("onWXDeviceStateChange", localHashMap, this.voB, this.voC)));
      AppMethodBeat.o(8961);
      return;
      if (paramInt == 1) {
        localHashMap.put("state", "connecting");
      } else {
        localHashMap.put("state", "disconnected");
      }
    }
  }
  
  public final void dW(String paramString, int paramInt)
  {
    AppMethodBeat.i(8965);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
      AppMethodBeat.o(8965);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    al.d(new d.13(this, i.a.b("onImageUploadProgress", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8965);
  }
  
  public final void dX(String paramString, int paramInt)
  {
    AppMethodBeat.i(8966);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
      AppMethodBeat.o(8966);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    al.d(new d.14(this, i.a.b("onImageDownloadProgress", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8966);
  }
  
  public final void dY(String paramString, int paramInt)
  {
    AppMethodBeat.i(8967);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
      AppMethodBeat.o(8967);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    al.d(new d.15(this, i.a.b("onVoiceUploadProgress", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8967);
  }
  
  public final void dZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(8968);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
      AppMethodBeat.o(8968);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    al.d(new d.16(this, i.a.b("onVoiceDownloadProgress", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8968);
  }
  
  public final void dcZ()
  {
    AppMethodBeat.i(8979);
    if (this.vow != null) {
      this.vow.clear();
    }
    AppMethodBeat.o(8979);
  }
  
  public final void dda()
  {
    AppMethodBeat.i(8978);
    if (this.vox != null) {
      this.vox.post(new d.29(this));
    }
    AppMethodBeat.o(8978);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(8951);
    this.ready = false;
    this.vow.clear();
    this.vov.clear();
    this.vox = null;
    AppMethodBeat.o(8951);
  }
  
  public final void dgj()
  {
    AppMethodBeat.i(8937);
    this.voB = true;
    this.voC = bo.Ng(16);
    ab.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", new Object[] { this.voC, Integer.valueOf(hashCode()) });
    AppMethodBeat.o(8937);
  }
  
  public final void dgk()
  {
    AppMethodBeat.i(8947);
    ab.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[] { Boolean.valueOf(this.ready) });
    if ((this.vou != null) && (this.ready)) {
      this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("sys:attach_runOn3rd_apis", dgl(), this.voB, this.voC) + ")", new d.55(this));
    }
    AppMethodBeat.o(8947);
  }
  
  public final void dgo()
  {
    AppMethodBeat.i(9004);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
      AppMethodBeat.o(9004);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("needShow", Boolean.TRUE);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8927);
        try
        {
          d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
          AppMethodBeat.o(8927);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(8927);
        }
      }
    });
    AppMethodBeat.o(9004);
  }
  
  public final void dgp()
  {
    AppMethodBeat.i(9006);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
      AppMethodBeat.o(9006);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
    String str = i.a.b("onNavigationBarRightButtonClick", new HashMap(), this.voB, this.voC);
    this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
    AppMethodBeat.o(9006);
  }
  
  public final long dgq()
  {
    AppMethodBeat.i(9007);
    ab.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[] { Long.valueOf(this.voO) });
    long l = this.voO;
    AppMethodBeat.o(9007);
    return l;
  }
  
  public final void e(com.tencent.mm.plugin.webview.stub.d paramd)
  {
    this.igU = paramd;
  }
  
  public final void ea(String paramString, int paramInt)
  {
    AppMethodBeat.i(8969);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
      AppMethodBeat.o(8969);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    al.d(new d.17(this, i.a.b("onVideoUploadProgress", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8969);
  }
  
  final String eb(String paramString, int paramInt)
  {
    AppMethodBeat.i(8975);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("url", paramString);
    localHashMap.put("set_cookie", Integer.valueOf(paramInt));
    paramString = aja(i.a.b("onGetA8KeyUrl", localHashMap, this.voB, this.voC));
    AppMethodBeat.o(8975);
    return paramString;
  }
  
  public final void ec(String paramString, int paramInt)
  {
    AppMethodBeat.i(9000);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
      AppMethodBeat.o(9000);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("snsid", paramString);
    localHashMap.put("status", Integer.valueOf(paramInt));
    al.d(new d.59(this, i.a.b("onMusicStatusChanged", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(9000);
  }
  
  public final void gQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(8982);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
      AppMethodBeat.o(8982);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("index", Integer.valueOf(paramInt1));
    localHashMap.put("actionSheetId", Integer.valueOf(paramInt2));
    al.d(new d.32(this, i.a.b("onSearchActionSheetClick", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8982);
  }
  
  public final void h(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(8958);
    if (paramBundle == null)
    {
      ab.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
      AppMethodBeat.o(8958);
      return;
    }
    if (this.vox != null) {
      this.vox.post(new d.73(this, paramBundle, paramString));
    }
    AppMethodBeat.o(8958);
  }
  
  public final void h(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(8984);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
      AppMethodBeat.o(8984);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString1);
    localHashMap.put("newQuery", Boolean.valueOf(paramBoolean));
    localHashMap.put("requestId", paramString2);
    al.d(new d.37(this, i.a.b("onSearchDataReady", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8984);
  }
  
  public final void hz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(8987);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
      AppMethodBeat.o(8987);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    al.d(new d.43(this, i.a.b("onSearchWAWidgetReloadDataFinish", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8987);
  }
  
  public final void i(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(8959);
    if ((!this.ready) || (paramBundle == null))
    {
      ab.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(8959);
      return;
    }
    long l = paramBundle.getLong("download_manager_downloadid");
    String str = paramBundle.getString("download_manager_appid", "");
    int i = paramBundle.getInt("download_manager_errcode");
    ab.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + l + ", state = " + paramString + ", errCode = " + i);
    paramBundle = new HashMap();
    paramBundle.put("appid", str);
    paramBundle.put("download_id", Long.valueOf(l));
    paramBundle.put("err_code", Integer.valueOf(i));
    paramBundle.put("state", paramString);
    al.d(new d.74(this, i.a.b("wxdownload:state_change", paramBundle, this.voB, this.voC)));
    AppMethodBeat.o(8959);
  }
  
  public final void j(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8980);
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString1 == null))
    {
      ab.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(8980);
      return;
    }
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
      AppMethodBeat.o(8980);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      ab.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + paramMap.size());
      localHashMap.putAll(paramMap);
    }
    paramString1 = i.a.a(paramString1, localHashMap, this.voB, this.voC);
    ab.i("MicroMsg.JsApiHandler", "doCallback, ret = " + paramString2 + ", cb = " + paramString1);
    if ((paramString1 != null) && (this.vou != null))
    {
      paramString1 = new d.30(this, paramString1);
      if (al.isMainThread())
      {
        paramString1.run();
        AppMethodBeat.o(8980);
        return;
      }
      al.d(paramString1);
    }
    AppMethodBeat.o(8980);
  }
  
  public final void keep_setReturnValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(8952);
    ab.i("MicroMsg.JsApiHandler", "setResultValue, scene = " + paramString1 + ", resultValue = " + paramString2);
    ab.i("MicroMsg.JsApiHandler", "edw setResultValue = threadId = " + Thread.currentThread().getId() + ", threadName = " + Thread.currentThread().getName());
    Message localMessage;
    if (this.vox != null)
    {
      localMessage = Message.obtain();
      localMessage.obj = paramString2;
      if (!paramString1.equals("SCENE_FETCHQUEUE")) {
        break label127;
      }
      localMessage.what = 1;
    }
    for (;;)
    {
      this.vox.sendMessage(localMessage);
      AppMethodBeat.o(8952);
      return;
      label127:
      if (paramString1.equals("SCENE_HANDLEMSGFROMWX")) {
        localMessage.what = 2;
      }
    }
  }
  
  public final void n(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(8998);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
      AppMethodBeat.o(8998);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    localHashMap.put("isCacheData", Integer.valueOf(paramInt1));
    localHashMap.put("isExpired", Integer.valueOf(paramInt2));
    localHashMap.put("isPreload", Integer.valueOf(paramInt3));
    al.d(new d.56(this, i.a.b("onSearchGuideDataReady", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8998);
  }
  
  public final void o(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(153331);
    if (!this.ready)
    {
      AppMethodBeat.o(153331);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("recommend", Integer.valueOf(paramInt1));
    localHashMap.put("comment", paramString);
    localHashMap.put("scene", Integer.valueOf(paramInt2));
    paramString = i.a.b("menu:haokan", localHashMap, this.voB, this.voC);
    this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(153331);
  }
  
  public final void oC(boolean paramBoolean)
  {
    AppMethodBeat.i(8945);
    this.ready = paramBoolean;
    if ((paramBoolean) && (this.voD != null))
    {
      Iterator localIterator = this.voD.iterator();
      while (localIterator.hasNext())
      {
        d.b localb = (d.b)localIterator.next();
        if (localb != null) {
          localb.onReady();
        }
      }
    }
    AppMethodBeat.o(8945);
  }
  
  public final void oD(boolean paramBoolean)
  {
    AppMethodBeat.i(8972);
    HashMap localHashMap = new HashMap();
    localHashMap.put("success", Boolean.valueOf(paramBoolean));
    al.d(new d.25(this, i.a.b("onAddShortcutStatus", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8972);
  }
  
  public final void oE(boolean paramBoolean)
  {
    AppMethodBeat.i(9003);
    ab.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[] { Boolean.valueOf(this.ready) });
    if ((this.vou != null) && (this.igU != null) && (this.ready)) {
      if (paramBoolean)
      {
        this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("sys:get_html_content", new HashMap(), this.voB, this.voC) + ")", null);
        AppMethodBeat.o(9003);
        return;
      }
    }
    try
    {
      List localList = this.igU.ddo();
      Uri localUri = Uri.parse(this.vou.getUrl());
      if (localUri != null) {
        ab.d("MicroMsg.JsApiHandler", "wv hijack url host" + localUri.getHost());
      }
      if ((localList != null) && (localUri != null) && (localList.contains(localUri.getHost()))) {
        this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("sys:get_html_content", new HashMap(), this.voB, this.voC) + ")", null);
      }
      AppMethodBeat.o(9003);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiHandler", localRemoteException, "", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public final void oq(boolean paramBoolean)
  {
    AppMethodBeat.i(9002);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
      AppMethodBeat.o(9002);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("active", String.valueOf(paramBoolean));
    al.d(new d.61(this, aja(i.a.b("onPageStateChange", localHashMap, this.voB, this.voC))));
    AppMethodBeat.o(9002);
  }
  
  public final void p(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(8997);
    if (!this.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
      AppMethodBeat.o(8997);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestType", Integer.valueOf(paramInt1));
    localHashMap.put("json", paramString);
    localHashMap.put("isCacheData", Integer.valueOf(paramInt2));
    al.d(new d.54(this, i.a.b("onTeachSearchDataReady", localHashMap, this.voB, this.voC)));
    AppMethodBeat.o(8997);
  }
  
  public final void q(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(8955);
    ab.i("MicroMsg.JsApiHandler", "onSendToFriend %b", new Object[] { Boolean.valueOf(this.ready) });
    if (!this.ready)
    {
      ab.w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
      h(aM(paramHashMap), "sendAppMessage");
      AppMethodBeat.o(8955);
      return;
    }
    paramHashMap = KS(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false)))
    {
      h(paramHashMap, "sendAppMessage");
      AppMethodBeat.o(8955);
      return;
    }
    paramHashMap = new HashMap();
    paramHashMap.put("scene", "friend");
    paramHashMap = i.a.b("menu:share:appmessage", paramHashMap, this.voB, this.voC);
    this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.igU.Q("scene", "friend", this.uZg);
      AppMethodBeat.o(8955);
      return;
    }
    catch (Exception paramHashMap)
    {
      ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(8955);
    }
  }
  
  public final void v(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(153332);
    if (!this.ready)
    {
      AppMethodBeat.o(153332);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString1);
    localHashMap.put("personal_comment_id", Integer.valueOf(paramInt));
    localHashMap.put("openid", paramString2);
    paramString1 = i.a.b("onMPPageAction", localHashMap, this.voB, this.voC);
    this.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(153332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d
 * JD-Core Version:    0.7.0.1
 */