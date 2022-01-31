package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import com.tencent.mm.a.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements com.tencent.mm.plugin.websearch.api.c, b
{
  private static final int rxA;
  public com.tencent.mm.plugin.webview.stub.d gGn;
  public boolean ready = false;
  public int rjN;
  public String rkx;
  public MMWebView rxB;
  private final List<String> rxC = new LinkedList();
  private final LinkedList<i> rxD = new LinkedList();
  private ah rxE = null;
  Map<String, Object> rxF;
  public Map<String, Object> rxG;
  public f rxH;
  public boolean rxI = false;
  public String rxJ = "";
  private Set<d.a> rxK;
  public String rxL;
  public String rxM;
  private final List<String> rxN = new LinkedList();
  volatile String rxO = null;
  volatile int rxP = 0;
  private JSONObject rxQ = new JSONObject();
  private JSONArray rxR = new JSONArray();
  private List<String> rxS = new LinkedList();
  private am rxT = new am(new am.a()
  {
    public final boolean tC()
    {
      String str = i.a.a("onBeaconsInRange", d.j(d.this), d.k(d.this), d.l(d.this));
      d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
      d.m(d.this).clear();
      d.a(d.this, new JSONObject());
      d.a(d.this, new JSONArray());
      return false;
    }
  }, false);
  public long rxU = 0L;
  
  static
  {
    if (com.tencent.mm.compatible.util.d.gG(19)) {}
    for (int i = 200;; i = 20)
    {
      rxA = i;
      return;
    }
  }
  
  public d(MMWebView paramMMWebView, f paramf, Map<String, Object> paramMap)
  {
    this.rxB = paramMMWebView;
    this.rxH = paramf;
    this.rxF = paramMap;
    cfW();
  }
  
  public d(MMWebView paramMMWebView, f paramf, Map<String, Object> paramMap, com.tencent.mm.plugin.webview.stub.d paramd, int paramInt)
  {
    this.rxB = paramMMWebView;
    this.rxH = paramf;
    this.gGn = paramd;
    this.rxF = paramMap;
    this.rjN = paramInt;
    cfW();
  }
  
  public static String TQ(String paramString)
  {
    return String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[] { bk.pm(paramString) });
  }
  
  private String TS(String paramString)
  {
    String str1 = this.rxB.getUrl();
    try
    {
      String str2 = m.getSHA1(str1 + paramString);
      str2 = e.dzG + str2;
      y.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[] { str1, paramString, str2 });
      return str2;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is " + str1);
      y.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
    }
    return null;
  }
  
  private void cfW()
  {
    this.rxE = new d.1(this, Looper.getMainLooper());
  }
  
  private void cga()
  {
    while (cgb()) {}
  }
  
  private boolean cgb()
  {
    if (bk.dk(this.rxD)) {
      y.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
    }
    do
    {
      return false;
      i locali;
      Object localObject1;
      Object localObject2;
      try
      {
        bool = this.gGn.Cn(this.rjN);
        y.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = " + bool);
        if (bool)
        {
          y.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
          return false;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          y.w("MicroMsg.JsApiHandler", "isBusy, ex = " + localException1.getMessage());
          bool = false;
        }
        if (this.rxD.size() == 0)
        {
          y.w("MicroMsg.JsApiHandler", "msgList size is 0.");
          return false;
        }
        locali = (i)this.rxD.remove(0);
        if (locali == null)
        {
          y.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
          return true;
        }
        if ((locali.rAO == null) || (locali.ndL == null) || (locali.type == null) || (this.rxB == null))
        {
          y.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + locali.rAO + ", params = " + locali.ndL + ", type = " + locali.type + ", wv = " + this.rxB);
          return true;
        }
        if ((this.rxG != null) && (this.rxG.get("srcUsername") != null) && (!bk.bl(this.rxG.get("srcUsername").toString()))) {
          locali.ndL.put("src_username", this.rxG.get("srcUsername").toString());
        }
        if ((this.rxG != null) && (this.rxG.get("srcDisplayname") != null) && (!bk.bl(this.rxG.get("srcDisplayname").toString()))) {
          locali.ndL.put("src_displayname", this.rxG.get("srcDisplayname").toString());
        }
        if ((this.rxG != null) && (this.rxG.get("KTemplateId") != null) && (!bk.bl(this.rxG.get("KTemplateId").toString()))) {
          locali.ndL.put("tempalate_id", this.rxG.get("KTemplateId").toString());
        }
        if (this.rxG != null)
        {
          locali.ndL.put("message_id", this.rxG.get("message_id"));
          locali.ndL.put("message_index", this.rxG.get("message_index"));
          locali.ndL.put("webview_scene", this.rxG.get("scene"));
          locali.ndL.put("pay_channel", this.rxG.get("pay_channel"));
          locali.ndL.put("pay_scene", this.rxG.get("pay_scene"));
          y.i("MicroMsg.JsApiHandler", "getPackageName %s", new Object[] { this.rxG.get("pay_package") });
          if (this.rxG.get("pay_package") != null) {
            locali.ndL.put("pay_packageName", this.rxG.get("pay_package"));
          }
          locali.ndL.put("stastic_scene", this.rxG.get("stastic_scene"));
          locali.ndL.put("open_from_scene", this.rxG.get("from_scence"));
          localObject1 = locali.ndL;
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("__jsapi_fw_ext_info_key_current_url", this.rxB.getUrl());
          ((Map)localObject1).put("__jsapi_fw_ext_info", localObject2);
        }
        if ((!locali.rAO.equals("shareWeibo")) && (!locali.rAO.equals("openUrlByExtBrowser")) && (!locali.rAO.equals("openUrlWithExtraWebview")) && (!locali.rAO.equals("openCustomWebview")) && (!locali.rAO.equals("openGameWebView")) && (!locali.rAO.equals("addToEmoticon")) && (!locali.rAO.equals("shareEmoticon")) && (!locali.rAO.equals("openGameUrlWithExtraWebView")) && (!locali.rAO.equals("request")))
        {
          locali.ndL.put("url", this.rxB.getUrl());
          y.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl" + this.rxB.getUrl());
        }
        if ((locali.rAO.equalsIgnoreCase("openDesignerEmojiView")) || (locali.rAO.equalsIgnoreCase("openEmotionDetailViewLocal")) || (locali.rAO.equalsIgnoreCase("openDesignerEmojiView")) || (locali.rAO.equalsIgnoreCase("openDesignerEmojiViewLocal")) || (locali.rAO.equalsIgnoreCase("openDesignerEmojiView")) || (locali.rAO.equalsIgnoreCase("openDesignerProfile")) || (locali.rAO.equalsIgnoreCase("openDesignerProfileLocal")) || (locali.rAO.equalsIgnoreCase("getSearchEmotionData")))
        {
          locali.ndL.put("searchID", Long.valueOf(cge()));
          y.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[] { Long.valueOf(cge()) });
        }
        if (locali.rAO.equals("request"))
        {
          locali.ndL.put("key_request_full_url_query", this.rxL);
          locali.ndL.put("key_request_header", this.rxM);
        }
      }
      try
      {
        localObject2 = this.rxH.cdI();
        localObject1 = new Bundle();
        if (localObject2 != null) {
          ((JsapiPermissionWrapper)localObject2).toBundle((Bundle)localObject1);
        }
        localObject2 = i.aq(locali.ndL);
        if (!bk.bl(this.rkx)) {
          ((Bundle)localObject2).putString("key_wxapp_id", this.rkx);
        }
        Bundle localBundle = new Bundle(2);
        localBundle.putBundle("compatParams", (Bundle)localObject2);
        localBundle.putString("rawParams", locali.rAM.toString());
        bool = this.gGn.a(locali.type, locali.rAO, locali.rAL, (Bundle)localObject1, localBundle, this.rjN);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.JsApiHandler", localException2, "", new Object[0]);
          y.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + localException2.getMessage());
          bool = false;
        }
      }
      y.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[] { locali.rAO, Boolean.valueOf(bool) });
    } while (bool);
    return true;
  }
  
  /* Error */
  private static boolean fD(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 394	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 394	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   11: ifeq +13 -> 24
    //   14: ldc 244
    //   16: ldc_w 561
    //   19: invokestatic 353	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iconst_0
    //   23: ireturn
    //   24: new 563	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 564	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 567	java/io/File:exists	()Z
    //   37: ifne +8 -> 45
    //   40: aload_2
    //   41: invokevirtual 570	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: aconst_null
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_3
    //   49: new 572	java/io/BufferedOutputStream
    //   52: dup
    //   53: new 574	java/io/FileOutputStream
    //   56: dup
    //   57: aload_0
    //   58: iconst_1
    //   59: invokespecial 577	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   62: invokespecial 580	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore 4
    //   67: new 574	java/io/FileOutputStream
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 581	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   75: astore 5
    //   77: aload 5
    //   79: astore_3
    //   80: aload 5
    //   82: astore_2
    //   83: aload 5
    //   85: aload_1
    //   86: invokevirtual 585	java/lang/String:getBytes	()[B
    //   89: invokevirtual 591	java/io/OutputStream:write	([B)V
    //   92: aload 5
    //   94: astore_3
    //   95: aload 5
    //   97: astore_2
    //   98: aload 5
    //   100: bipush 13
    //   102: invokevirtual 593	java/io/OutputStream:write	(I)V
    //   105: aload 5
    //   107: astore_3
    //   108: aload 5
    //   110: astore_2
    //   111: aload 5
    //   113: bipush 10
    //   115: invokevirtual 593	java/io/OutputStream:write	(I)V
    //   118: aload 5
    //   120: astore_3
    //   121: aload 5
    //   123: astore_2
    //   124: aload 5
    //   126: invokevirtual 596	java/io/OutputStream:flush	()V
    //   129: aload 5
    //   131: invokevirtual 599	java/io/OutputStream:close	()V
    //   134: ldc 244
    //   136: new 224	java/lang/StringBuilder
    //   139: dup
    //   140: ldc_w 601
    //   143: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 603	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: ldc 244
    //   161: new 224	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 605
    //   168: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload_0
    //   172: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 261	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: ldc 244
    //   183: aload_1
    //   184: ldc 114
    //   186: iconst_0
    //   187: anewarray 4	java/lang/Object
    //   190: invokestatic 265	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: iconst_0
    //   194: ireturn
    //   195: astore_1
    //   196: ldc 244
    //   198: aload_1
    //   199: ldc 114
    //   201: iconst_0
    //   202: anewarray 4	java/lang/Object
    //   205: invokestatic 265	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: goto -74 -> 134
    //   211: astore_0
    //   212: aload_3
    //   213: astore_2
    //   214: ldc 244
    //   216: aload_0
    //   217: ldc 114
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 265	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: aload_3
    //   227: astore_2
    //   228: ldc 244
    //   230: ldc_w 607
    //   233: invokestatic 353	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_3
    //   237: ifnull -215 -> 22
    //   240: aload_3
    //   241: invokevirtual 599	java/io/OutputStream:close	()V
    //   244: iconst_0
    //   245: ireturn
    //   246: astore_0
    //   247: ldc 244
    //   249: aload_0
    //   250: ldc 114
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 265	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: iconst_0
    //   260: ireturn
    //   261: astore_0
    //   262: aload_2
    //   263: ifnull +7 -> 270
    //   266: aload_2
    //   267: invokevirtual 599	java/io/OutputStream:close	()V
    //   270: aload_0
    //   271: athrow
    //   272: astore_1
    //   273: ldc 244
    //   275: aload_1
    //   276: ldc 114
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 265	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: goto -15 -> 270
    //   288: astore_0
    //   289: aload 4
    //   291: astore_2
    //   292: goto -30 -> 262
    //   295: astore_0
    //   296: aload 4
    //   298: astore_3
    //   299: goto -87 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramString1	String
    //   0	302	1	paramString2	String
    //   32	260	2	localObject1	Object
    //   48	251	3	localObject2	Object
    //   65	232	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   75	55	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   40	45	158	java/io/IOException
    //   129	134	195	java/io/IOException
    //   49	67	211	java/lang/Exception
    //   83	92	211	java/lang/Exception
    //   98	105	211	java/lang/Exception
    //   111	118	211	java/lang/Exception
    //   124	129	211	java/lang/Exception
    //   240	244	246	java/io/IOException
    //   49	67	261	finally
    //   83	92	261	finally
    //   98	105	261	finally
    //   111	118	261	finally
    //   124	129	261	finally
    //   214	226	261	finally
    //   228	236	261	finally
    //   266	270	272	java/io/IOException
    //   67	77	288	finally
    //   67	77	295	java/lang/Exception
  }
  
  /* Error */
  private static boolean t(String paramString, Map<String, Integer> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 394	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +13 -> 21
    //   11: ldc 244
    //   13: ldc_w 561
    //   16: invokestatic 353	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: iconst_0
    //   20: ireturn
    //   21: new 563	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 564	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 567	java/io/File:exists	()Z
    //   34: ifne +8 -> 42
    //   37: aload_3
    //   38: invokevirtual 570	java/io/File:createNewFile	()Z
    //   41: pop
    //   42: aconst_null
    //   43: astore 4
    //   45: new 572	java/io/BufferedOutputStream
    //   48: dup
    //   49: new 574	java/io/FileOutputStream
    //   52: dup
    //   53: aload_0
    //   54: iconst_1
    //   55: invokespecial 577	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   58: invokespecial 580	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   61: astore_3
    //   62: aload_1
    //   63: invokeinterface 174 1 0
    //   68: invokeinterface 627 1 0
    //   73: astore 4
    //   75: aload 4
    //   77: invokeinterface 632 1 0
    //   82: ifeq +147 -> 229
    //   85: aload 4
    //   87: invokeinterface 636 1 0
    //   92: checkcast 209	java/lang/String
    //   95: astore 5
    //   97: aload_1
    //   98: aload 5
    //   100: invokeinterface 184 2 0
    //   105: checkcast 186	java/lang/Integer
    //   108: invokevirtual 190	java/lang/Integer:intValue	()I
    //   111: istore_2
    //   112: aload_3
    //   113: new 224	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   120: iload_2
    //   121: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: ldc_w 638
    //   127: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 5
    //   132: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokevirtual 585	java/lang/String:getBytes	()[B
    //   141: invokevirtual 591	java/io/OutputStream:write	([B)V
    //   144: aload_3
    //   145: bipush 13
    //   147: invokevirtual 593	java/io/OutputStream:write	(I)V
    //   150: aload_3
    //   151: bipush 10
    //   153: invokevirtual 593	java/io/OutputStream:write	(I)V
    //   156: goto -81 -> 75
    //   159: astore_1
    //   160: aload_3
    //   161: astore_0
    //   162: ldc 244
    //   164: aload_1
    //   165: ldc 114
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 265	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: ldc 244
    //   176: ldc_w 607
    //   179: invokestatic 353	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 599	java/io/OutputStream:close	()V
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_1
    //   193: ldc 244
    //   195: new 224	java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w 605
    //   202: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: aload_0
    //   206: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 261	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: ldc 244
    //   217: aload_1
    //   218: ldc 114
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 265	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: iconst_0
    //   228: ireturn
    //   229: aload_3
    //   230: invokevirtual 596	java/io/OutputStream:flush	()V
    //   233: aload_3
    //   234: invokevirtual 599	java/io/OutputStream:close	()V
    //   237: ldc 244
    //   239: new 224	java/lang/StringBuilder
    //   242: dup
    //   243: ldc_w 601
    //   246: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   249: aload_0
    //   250: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 603	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: iconst_1
    //   260: ireturn
    //   261: astore_1
    //   262: ldc 244
    //   264: aload_1
    //   265: ldc 114
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 265	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -37 -> 237
    //   277: astore_0
    //   278: ldc 244
    //   280: aload_0
    //   281: ldc 114
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 265	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   290: goto -100 -> 190
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_1
    //   296: aload_1
    //   297: ifnull +7 -> 304
    //   300: aload_1
    //   301: invokevirtual 599	java/io/OutputStream:close	()V
    //   304: aload_0
    //   305: athrow
    //   306: astore_1
    //   307: ldc 244
    //   309: aload_1
    //   310: ldc 114
    //   312: iconst_0
    //   313: anewarray 4	java/lang/Object
    //   316: invokestatic 265	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   319: goto -15 -> 304
    //   322: astore_0
    //   323: aload_3
    //   324: astore_1
    //   325: goto -29 -> 296
    //   328: astore_3
    //   329: aload_0
    //   330: astore_1
    //   331: aload_3
    //   332: astore_0
    //   333: goto -37 -> 296
    //   336: astore_1
    //   337: aload 4
    //   339: astore_0
    //   340: goto -178 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	paramString	String
    //   0	343	1	paramMap	Map<String, Integer>
    //   111	10	2	i	int
    //   29	295	3	localObject1	Object
    //   328	4	3	localObject2	Object
    //   43	295	4	localIterator	Iterator
    //   95	36	5	str	String
    // Exception table:
    //   from	to	target	type
    //   62	75	159	java/lang/Exception
    //   75	156	159	java/lang/Exception
    //   229	233	159	java/lang/Exception
    //   37	42	192	java/io/IOException
    //   233	237	261	java/io/IOException
    //   186	190	277	java/io/IOException
    //   45	62	293	finally
    //   300	304	306	java/io/IOException
    //   62	75	322	finally
    //   75	156	322	finally
    //   229	233	322	finally
    //   162	182	328	finally
    //   45	62	336	java/lang/Exception
  }
  
  public final Bundle CV(int paramInt)
  {
    try
    {
      if (this.rxB == null) {
        return null;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("WebViewShare_type", paramInt);
      localBundle.putInt("WebViewShare_BinderID", this.rjN);
      localBundle.putString("WebViewShare_wv_url", this.rxB.getUrl());
      localBundle = this.gGn.f(105, localBundle);
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.JsApiHandler", "getShareData err %s", new Object[] { localRemoteException.getMessage() });
    }
    return null;
  }
  
  public final void CW(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(a.ad(ae.getContext(), paramInt)));
    ai.d(new d.21(this, i.a.a("onGetKeyboardHeight", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void TN(String paramString)
  {
    try
    {
      Bundle localBundle = new Bundle();
      JsapiPermissionWrapper localJsapiPermissionWrapper = this.rxH.cdI();
      if (localJsapiPermissionWrapper != null) {
        localJsapiPermissionWrapper.toBundle(localBundle);
      }
      this.gGn.a(paramString, localBundle, this.rjN);
      return;
    }
    catch (Exception paramString)
    {
      y.w("MicroMsg.JsApiHandler", "doProfile, ex = " + paramString.getMessage());
    }
  }
  
  public final void TO(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString);
    ai.d(new d.25(this, i.a.a("onBeaconMonitoring", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void TP(String paramString)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    ai.d(new d.50(this, i.a.a("onSearchSuggestionDataReady", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void TR(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("netType", paramString);
    ai.d(new d.60(this, i.a.a("onNetWorkChange", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final boolean Tq(String paramString)
  {
    this.rxB.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new d.12(this, paramString));
    return true;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://dispatch_message/");
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(final String paramString)
  {
    if (paramString != null) {
      this.rxE.post(new Runnable()
      {
        public final void run()
        {
          Map localMap = d.D(paramString.split(","));
          String str = d.a(d.this, "hosts");
          if (d.u(str, localMap))
          {
            if ((d.n(d.this) != null) && (d.d(d.this) != null)) {}
            try
            {
              d.n(d.this).z(0, d.d(d.this).getUrl(), str);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              y.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              return;
            }
          }
          y.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
        }
      });
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(final String paramString)
  {
    if (paramString != null) {
      this.rxE.post(new Runnable()
      {
        public final void run()
        {
          String str = d.a(d.this, "html");
          if (d.fE(str, paramString))
          {
            if ((d.n(d.this) != null) && (d.d(d.this) != null)) {}
            try
            {
              d.n(d.this).z(1, d.d(d.this).getUrl(), str);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              y.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              return;
            }
          }
          y.e("MicroMsg.JsApiHandler", "failed to write Html file");
        }
      });
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    if (this.rxE != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      this.rxE.sendMessage(localMessage);
    }
  }
  
  public final void a(d.a parama)
  {
    if (this.rxK == null) {
      this.rxK = new HashSet();
    }
    this.rxK.add(parama);
  }
  
  /* Error */
  public final void a(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 144	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxT	Lcom/tencent/mm/sdk/platformtools/am;
    //   6: invokevirtual 783	com/tencent/mm/sdk/platformtools/am:crl	()Z
    //   9: ifeq +16 -> 25
    //   12: aload_0
    //   13: getfield 144	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxT	Lcom/tencent/mm/sdk/platformtools/am;
    //   16: ldc2_w 784
    //   19: ldc2_w 784
    //   22: invokevirtual 789	com/tencent/mm/sdk/platformtools/am:S	(JJ)V
    //   25: new 124	org/json/JSONObject
    //   28: dup
    //   29: invokespecial 125	org/json/JSONObject:<init>	()V
    //   32: astore 11
    //   34: iconst_0
    //   35: istore 10
    //   37: iload 10
    //   39: istore 9
    //   41: dload 4
    //   43: dconst_0
    //   44: dcmpl
    //   45: ifle +19 -> 64
    //   48: iload 10
    //   50: istore 9
    //   52: dload 4
    //   54: ldc2_w 790
    //   57: dcmpg
    //   58: ifge +6 -> 64
    //   61: iconst_1
    //   62: istore 9
    //   64: aload_0
    //   65: getfield 134	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxS	Ljava/util/List;
    //   68: new 224	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   75: aload_1
    //   76: invokestatic 794	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: iload_2
    //   83: invokestatic 797	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   86: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: iload_3
    //   90: invokestatic 797	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   93: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokeinterface 798 2 0
    //   104: ifne +178 -> 282
    //   107: aload_0
    //   108: getfield 134	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxS	Ljava/util/List;
    //   111: new 224	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   118: aload_1
    //   119: invokestatic 794	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   122: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload_2
    //   126: invokestatic 797	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   129: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload_3
    //   133: invokestatic 797	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   136: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokeinterface 799 2 0
    //   147: pop
    //   148: aload 11
    //   150: ldc_w 801
    //   153: aload_1
    //   154: invokestatic 794	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   157: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload 11
    //   163: ldc_w 806
    //   166: iload_2
    //   167: invokestatic 797	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   170: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: aload 11
    //   176: ldc_w 808
    //   179: iload_3
    //   180: invokestatic 797	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   183: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   186: pop
    //   187: aload 11
    //   189: ldc_w 810
    //   192: dload 4
    //   194: invokestatic 813	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   197: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   200: pop
    //   201: aload 11
    //   203: ldc_w 815
    //   206: dload 6
    //   208: invokestatic 813	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   211: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   214: pop
    //   215: aload 11
    //   217: ldc_w 817
    //   220: fload 8
    //   222: invokestatic 820	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   225: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload 11
    //   231: ldc_w 822
    //   234: iload 9
    //   236: invokestatic 797	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   239: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   242: pop
    //   243: aload_0
    //   244: getfield 132	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxR	Lorg/json/JSONArray;
    //   247: aload 11
    //   249: invokevirtual 825	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   252: pop
    //   253: aload_0
    //   254: getfield 127	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxQ	Lorg/json/JSONObject;
    //   257: ldc_w 827
    //   260: aload_0
    //   261: getfield 132	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxR	Lorg/json/JSONArray;
    //   264: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload_0
    //   269: getfield 127	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxQ	Lorg/json/JSONObject;
    //   272: ldc_w 703
    //   275: ldc_w 829
    //   278: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   281: pop
    //   282: ldc_w 831
    //   285: aload_0
    //   286: getfield 127	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxQ	Lorg/json/JSONObject;
    //   289: aload_0
    //   290: getfield 112	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxI	Z
    //   293: aload_0
    //   294: getfield 116	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxJ	Ljava/lang/String;
    //   297: invokestatic 834	com/tencent/mm/plugin/webview/ui/tools/jsapi/i$a:a	(Ljava/lang/String;Lorg/json/JSONObject;ZLjava/lang/String;)Ljava/lang/String;
    //   300: pop
    //   301: aload_0
    //   302: monitorexit
    //   303: return
    //   304: astore_1
    //   305: ldc 244
    //   307: ldc_w 836
    //   310: iconst_1
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload_1
    //   317: invokevirtual 358	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   320: aastore
    //   321: invokestatic 664	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: goto -42 -> 282
    //   327: astore_1
    //   328: aload_0
    //   329: monitorexit
    //   330: aload_1
    //   331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	d
    //   0	332	1	paramString	String
    //   0	332	2	paramInt1	int
    //   0	332	3	paramInt2	int
    //   0	332	4	paramDouble1	double
    //   0	332	6	paramDouble2	double
    //   0	332	8	paramFloat	float
    //   39	196	9	i	int
    //   35	14	10	j	int
    //   32	216	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   64	282	304	java/lang/Exception
    //   2	25	327	finally
    //   25	34	327	finally
    //   64	282	327	finally
    //   282	301	327	finally
    //   305	324	327	finally
  }
  
  public final void a(final String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean)
  {
    if (!bk.bl(paramString1))
    {
      if ((paramString2 != null) && (paramString2.length() != 0) && (paramString1 != null)) {
        break label54;
      }
      y.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = " + paramString2);
    }
    for (;;)
    {
      if (paramBoolean) {
        cdf();
      }
      return;
      label54:
      HashMap localHashMap = new HashMap();
      localHashMap.put("err_msg", paramString2);
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        y.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + paramMap.size());
        localHashMap.putAll(paramMap);
      }
      paramString1 = i.a.a("callback", paramString1, localHashMap, null, this.rxI, this.rxJ);
      y.i("MicroMsg.JsApiHandler", "doCallback, ret = " + paramString2 + ", cb = " + paramString1);
      if ((paramString1 != null) && (this.rxB != null)) {
        ai.d(new Runnable()
        {
          public final void run()
          {
            try
            {
              d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
              return;
            }
            catch (Exception localException)
            {
              y.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[] { localException.getMessage() });
            }
          }
        });
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    a("onSearchInputChange", localHashMap, null);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    localHashMap.put("isCancelButtonClick", Integer.valueOf(paramInt));
    ai.d(new d.46(this, i.a.a("onSearchInputChange", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt, Map<String, Object> paramMap)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
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
                y.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException1, "", new Object[0]);
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
      localJSONObject.put("sugId", "");
      localJSONObject.put("sugClickType", 0);
      ai.d(new d.49(this, i.a.a("onSearchInputConfirm", localJSONObject, this.rxI, this.rxJ)));
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
      }
    }
  }
  
  public final void a(String paramString, Map<String, Object> paramMap, JSONObject paramJSONObject)
  {
    if ((!this.ready) || ((paramMap == null) && (paramJSONObject == null)))
    {
      y.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[] { paramString });
      return;
    }
    String str1;
    String str2;
    if (paramMap == null)
    {
      str1 = "";
      if (paramJSONObject != null) {
        break label115;
      }
      str2 = "";
      label48:
      y.i("MicroMsg.JsApiHandler", "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s", new Object[] { paramString, str1, str2 });
      if (paramMap == null) {
        break label124;
      }
    }
    label115:
    label124:
    for (paramMap = i.a.a(paramString, paramMap, this.rxI, this.rxJ);; paramMap = i.a.a(paramString, paramJSONObject, this.rxI, this.rxJ))
    {
      ai.d(new d.47(this, paramMap, paramString));
      return;
      str1 = paramMap.toString();
      break;
      str2 = paramJSONObject.toString();
      break label48;
    }
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventId", paramString1);
    localHashMap.put("widgetId", paramString3);
    localHashMap.put("hitTest", Boolean.valueOf(paramBoolean));
    localHashMap.put("err_msg", paramString2);
    ai.d(new Runnable()
    {
      public final void run()
      {
        try
        {
          d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fZS + ")", null);
          return;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", new Object[] { localException.getMessage() });
        }
      }
    });
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, JSONArray paramJSONArray, String paramString8, int paramInt, Map<String, Object> paramMap)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, not ready");
      return false;
    }
    y.i("MicroMsg.JsApiHandler", "switchToTabSearch success, ready %s %s %s %s %s", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5 });
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
                y.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException1, "", new Object[0]);
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
      ai.d(new d.48(this, i.a.a("switchToTabSearch", localJSONObject, this.rxI, this.rxJ)));
      return true;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
      }
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, Object> paramMap)
  {
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
        return true;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
        }
      }
    }
    catch (Exception paramMap)
    {
      y.printErrStackTrace("MicroMsg.JsApiHandler", paramMap, "", new Object[0]);
    }
  }
  
  public final void aZ(int paramInt, String paramString)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("data", paramString);
    ai.d(new d.51(this, i.a.a("onSearchImageListReady", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void am(Map<String, Object> paramMap)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onPreloadWebViewInit fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onPreloadWebViewInit success, ready");
    if (paramMap == null) {}
    for (String str = "";; str = paramMap.toString())
    {
      y.i("MicroMsg.JsApiHandler", "onPreloadWebViewInit,params %s", new Object[] { str });
      ai.d(new d.44(this, i.a.a("onUiInit", paramMap, this.rxI, this.rxJ)));
      return;
    }
  }
  
  public final void an(Map<String, Object> paramMap)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
    ai.d(new Runnable()
    {
      public final void run()
      {
        try
        {
          d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fZS + ")", null);
          return;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[] { localException.getMessage() });
        }
      }
    });
  }
  
  public final void ao(Map<String, Object> paramMap)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
    paramMap = i.a.a("onVoiceRecordEnd", paramMap, this.rxI, this.rxJ);
    y.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[] { paramMap });
    ai.d(new d.10(this, paramMap));
  }
  
  public final void ap(Map<String, Object> paramMap)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
    ai.d(new d.30(this, i.a.a("onSelectContact", paramMap, this.rxI, this.rxJ)));
  }
  
  public final void bp(String paramString, boolean paramBoolean)
  {
    try
    {
      this.gGn.h(paramString, paramBoolean, this.rjN);
      return;
    }
    catch (Exception paramString)
    {
      y.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = " + paramString);
    }
  }
  
  public final void cU(String paramString, int paramInt)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.JsApiHandler", "parameter error!!!");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceId", paramString);
    if (paramInt == 2) {
      localHashMap.put("state", "connected");
    }
    for (;;)
    {
      ai.d(new Runnable()
      {
        public final void run()
        {
          try
          {
            d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fZS + ")", null);
            return;
          }
          catch (Exception localException)
          {
            y.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", new Object[] { localException.getMessage() });
          }
        }
      });
      return;
      if (paramInt == 1) {
        localHashMap.put("state", "connecting");
      } else {
        localHashMap.put("state", "disconnected");
      }
    }
  }
  
  public final void cV(String paramString, int paramInt)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ai.d(new d.13(this, i.a.a("onImageUploadProgress", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void cW(String paramString, int paramInt)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ai.d(new d.14(this, i.a.a("onImageDownloadProgress", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void cX(String paramString, int paramInt)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ai.d(new Runnable()
    {
      public final void run()
      {
        try
        {
          d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fZS + ")", null);
          return;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
        }
      }
    });
  }
  
  public final void cY(String paramString, int paramInt)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ai.d(new d.16(this, i.a.a("onVoiceDownloadProgress", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void cZ(String paramString, int paramInt)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ai.d(new d.17(this, i.a.a("onVideoUploadProgress", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void cde()
  {
    if (this.rxD != null) {
      this.rxD.clear();
    }
  }
  
  public final void cdf()
  {
    if (this.rxE != null) {
      this.rxE.post(new Runnable()
      {
        public final void run()
        {
          d.f(d.this);
        }
      });
    }
  }
  
  public final void cfX()
  {
    this.rxI = true;
    this.rxJ = bk.Fe(16);
    y.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s", new Object[] { this.rxJ });
  }
  
  public final void cfY()
  {
    this.ready = true;
    if (this.rxK != null)
    {
      Iterator localIterator = this.rxK.iterator();
      while (localIterator.hasNext())
      {
        d.a locala = (d.a)localIterator.next();
        if (locala != null) {
          locala.onReady();
        }
      }
    }
  }
  
  public final void cfZ()
  {
    y.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[] { Boolean.valueOf(this.ready) });
    if ((this.rxB != null) && (this.ready))
    {
      MMWebView localMMWebView = this.rxB;
      StringBuilder localStringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      HashMap localHashMap = new HashMap();
      JsapiPermissionWrapper localJsapiPermissionWrapper = this.rxH.cdI();
      LinkedList localLinkedList = new LinkedList();
      if (localJsapiPermissionWrapper != null)
      {
        if (localJsapiPermissionWrapper.hi(88)) {
          localLinkedList.add("menu:share:timeline");
        }
        if (localJsapiPermissionWrapper.hi(89)) {
          localLinkedList.add("menu:share:appmessage");
        }
        if (localJsapiPermissionWrapper.hi(94)) {
          localLinkedList.add("menu:share:qq");
        }
        if (localJsapiPermissionWrapper.hi(109)) {
          localLinkedList.add("menu:share:weiboApp");
        }
        if (localJsapiPermissionWrapper.hi(134)) {
          localLinkedList.add("menu:share:QZone");
        }
        if (localJsapiPermissionWrapper.hi(219)) {
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
        if (!bk.dk(null)) {
          localLinkedList.addAll(null);
        }
        localLinkedList.add("onReceivePageData");
        localLinkedList.add("onPageAuthOK");
      }
      localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
      localMMWebView.evaluateJavascript(i.a.a("sys:attach_runOn3rd_apis", localHashMap, this.rxI, this.rxJ) + ")", new d.55(this));
    }
  }
  
  public final void cgc()
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSendToFriend fail, not ready");
      return;
    }
    Object localObject = CV(1);
    if ((localObject != null) && (((Bundle)localObject).getBoolean("WebViewShare_reslut", false)))
    {
      g((Bundle)localObject, "sendAppMessage");
      return;
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("scene", "friend");
    localObject = i.a.a("menu:share:appmessage", (Map)localObject, this.rxI, this.rxJ);
    this.rxB.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    try
    {
      this.gGn.I("scene", "friend", this.rjN);
      return;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException.getMessage());
    }
  }
  
  public final void cgd()
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("needShow", Boolean.valueOf(true));
    ai.d(new d.58(this, i.a.a("showLoading", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final long cge()
  {
    y.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[] { Long.valueOf(this.rxU) });
    return this.rxU;
  }
  
  final String da(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("url", paramString);
    localHashMap.put("set_cookie", Integer.valueOf(paramInt));
    return TQ(i.a.a("onGetA8KeyUrl", localHashMap, this.rxI, this.rxJ));
  }
  
  public final void db(String paramString, int paramInt)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("snsid", paramString);
    localHashMap.put("status", Integer.valueOf(paramInt));
    ai.d(new d.54(this, i.a.a("onMusicStatusChanged", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void detach()
  {
    this.ready = false;
    this.rxD.clear();
    this.rxC.clear();
    this.rxE = null;
  }
  
  public final void f(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString1);
    localHashMap.put("newQuery", Boolean.valueOf(paramBoolean));
    localHashMap.put("requestId", paramString2);
    ai.d(new d.36(this, i.a.a("onSearchDataReady", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void fC(String paramString1, String paramString2)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    ai.d(new d.42(this, i.a.a("onSearchWAWidgetReloadDataFinish", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void g(final Bundle paramBundle, final String paramString)
  {
    if (paramBundle == null) {
      y.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
    }
    while (this.rxE == null) {
      return;
    }
    this.rxE.post(new Runnable()
    {
      public final void run()
      {
        i locali = new i();
        locali.ndL = new HashMap();
        locali.ndL.put("link", paramBundle.getString("link"));
        locali.ndL.put("title", paramBundle.getString("title"));
        locali.ndL.put("desc", paramBundle.getString("desc"));
        locali.rAM = new JSONObject();
        locali.ndL.put("img_url", paramBundle.getString("img_url"));
        locali.ndL.put("use_update_jsapi_data", Boolean.valueOf(true));
        locali.type = "call";
        locali.rAL = "";
        locali.rAO = paramString;
        d.e(d.this).add(locali);
        d.f(d.this);
      }
    });
  }
  
  public final void h(Bundle paramBundle, String paramString)
  {
    if ((!this.ready) || (paramBundle == null))
    {
      y.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      return;
    }
    long l = paramBundle.getLong("download_manager_downloadid");
    String str = paramBundle.getString("download_manager_appid", "");
    int i = paramBundle.getInt("download_manager_errcode");
    y.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + l + ", state = " + paramString + ", errCode = " + i);
    paramBundle = new HashMap();
    paramBundle.put("appid", str);
    paramBundle.put("download_id", Long.valueOf(l));
    paramBundle.put("err_code", Integer.valueOf(i));
    paramBundle.put("state", paramString);
    ai.d(new d.67(this, i.a.a("wxdownload:state_change", paramBundle, this.rxI, this.rxJ)));
  }
  
  public final void j(String paramString, long paramLong, int paramInt)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", paramString);
    localHashMap.put("download_id", Long.valueOf(paramLong));
    localHashMap.put("progress", Integer.valueOf(paramInt));
    ai.d(new d.2(this, i.a.a("wxdownload:progress_change", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void k(int paramInt1, String paramString, int paramInt2)
  {
    if (!this.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestType", Integer.valueOf(paramInt1));
    localHashMap.put("json", paramString);
    localHashMap.put("isCacheData", Integer.valueOf(paramInt2));
    ai.d(new Runnable()
    {
      public final void run()
      {
        try
        {
          d.d(d.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fZS + ")", null);
          return;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
        }
      }
    });
  }
  
  public final void keep_setReturnValue(String paramString1, String paramString2)
  {
    y.i("MicroMsg.JsApiHandler", "setResultValue, scene = " + paramString1 + ", resultValue = " + paramString2);
    y.i("MicroMsg.JsApiHandler", "edw setResultValue = threadId = " + Thread.currentThread().getId() + ", threadName = " + Thread.currentThread().getName());
    Message localMessage;
    if (this.rxE != null)
    {
      localMessage = Message.obtain();
      localMessage.obj = paramString2;
      if (!paramString1.equals("SCENE_FETCHQUEUE")) {
        break label115;
      }
      localMessage.what = 1;
    }
    for (;;)
    {
      this.rxE.sendMessage(localMessage);
      return;
      label115:
      if (paramString1.equals("SCENE_HANDLEMSGFROMWX")) {
        localMessage.what = 2;
      }
    }
  }
  
  public final void lt(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("success", Boolean.valueOf(paramBoolean));
    ai.d(new d.24(this, i.a.a("onAddShortcutStatus", localHashMap, this.rxI, this.rxJ)));
  }
  
  public final void lu(boolean paramBoolean)
  {
    y.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[] { Boolean.valueOf(this.ready) });
    if ((this.rxB != null) && (this.gGn != null) && (this.ready))
    {
      if (!paramBoolean) {
        break label99;
      }
      this.rxB.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("sys:get_html_content", new HashMap(), this.rxI, this.rxJ) + ")", null);
    }
    for (;;)
    {
      return;
      try
      {
        label99:
        List localList = this.gGn.cdt();
        Uri localUri = Uri.parse(this.rxB.getUrl());
        if (localUri != null) {
          y.d("MicroMsg.JsApiHandler", "wv hijack url host" + localUri.getHost());
        }
        if ((localList == null) || (localUri == null) || (!localList.contains(localUri.getHost()))) {
          continue;
        }
        this.rxB.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("sys:get_html_content", new HashMap(), this.rxI, this.rxJ) + ")", null);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.JsApiHandler", localRemoteException, "", new Object[0]);
          Object localObject = null;
        }
      }
    }
  }
  
  public final void s(final String paramString, final Map<String, String> paramMap)
  {
    y.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[] { paramString });
    if (bk.bl(paramString)) {
      return;
    }
    this.rxO = paramString;
    if ((paramMap != null) && (paramMap.size() != 0)) {}
    for (this.rxP = 1;; this.rxP = 0)
    {
      ai.d(new Runnable()
      {
        public final void run()
        {
          label178:
          do
          {
            try
            {
              if ((paramMap == null) || (paramMap.size() == 0)) {
                break label178;
              }
              com.tencent.xweb.c.il(ae.getContext());
              com.tencent.xweb.b localb = com.tencent.xweb.b.cSe();
              Iterator localIterator = paramMap.keySet().iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                localb.setCookie(bk.aai(paramString), str + "=" + (String)paramMap.get(str));
              }
              localException.setCookie(bk.aai(paramString), "httponly");
            }
            catch (Exception localException)
            {
              y.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[] { localException.getMessage() });
              return;
            }
            com.tencent.xweb.c.cSg();
            com.tencent.xweb.c.sync();
            y.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[] { localException.getCookie(bk.aai(paramString)) });
            d.d(d.this).evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[] { paramString }), null);
            d.d(d.this).evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
          } while (!d.g(d.this));
          d.d(d.this).evaluateJavascript(this.rxX, null);
          d.h(d.this);
          d.i(d.this);
        }
      });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d
 * JD-Core Version:    0.7.0.1
 */