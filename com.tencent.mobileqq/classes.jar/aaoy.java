import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.open.ArkView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;
import com.tencent.gdtad.api.interstitial.GdtInterstitialView.2;
import org.json.JSONObject;

public final class aaoy
  implements aang
{
  private ArkView a;
  
  public aaoy(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    this.a = a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus);
  }
  
  /* Error */
  private static ArkView a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    // Byte code:
    //   0: new 23	java/lang/ref/WeakReference
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 26	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   8: astore 7
    //   10: new 23	java/lang/ref/WeakReference
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 26	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   18: astore 8
    //   20: aload_1
    //   21: ifnull +220 -> 241
    //   24: aload_1
    //   25: invokevirtual 31	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:a	()Ljava/lang/String;
    //   28: astore_2
    //   29: iconst_0
    //   30: istore_3
    //   31: invokestatic 36	aaoq:a	()Laaoq;
    //   34: invokevirtual 39	aaoq:a	()Laaoi;
    //   37: astore 9
    //   39: iconst_1
    //   40: istore_3
    //   41: aload_0
    //   42: aload_1
    //   43: invokestatic 42	aaoy:a	(Landroid/content/Context;Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;)Ljava/lang/String;
    //   46: astore 10
    //   48: ldc 44
    //   50: ldc 46
    //   52: iconst_3
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload 9
    //   60: getfield 51	aaoi:a	Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload 9
    //   68: getfield 54	aaoi:b	Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_2
    //   74: aload 9
    //   76: getfield 57	aaoi:c	Ljava/lang/String;
    //   79: aastore
    //   80: invokestatic 63	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokestatic 68	aase:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   89: lstore 5
    //   91: new 76	com/tencent/ark/open/ArkView
    //   94: dup
    //   95: aload_0
    //   96: aconst_null
    //   97: invokespecial 79	com/tencent/ark/open/ArkView:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   100: astore_0
    //   101: iconst_3
    //   102: istore 4
    //   104: aload_1
    //   105: ifnull +57 -> 162
    //   108: iload 4
    //   110: istore_3
    //   111: aload_1
    //   112: getfield 82	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:b	I
    //   115: iflt +47 -> 162
    //   118: iload 4
    //   120: istore_3
    //   121: aload_1
    //   122: getfield 84	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:c	I
    //   125: iflt +37 -> 162
    //   128: iload 4
    //   130: istore_3
    //   131: new 86	com/tencent/ark/open/ArkAppInfo$Size
    //   134: dup
    //   135: aload_1
    //   136: getfield 82	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:b	I
    //   139: aload_1
    //   140: getfield 84	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:c	I
    //   143: invokespecial 89	com/tencent/ark/open/ArkAppInfo$Size:<init>	(II)V
    //   146: astore 11
    //   148: iload 4
    //   150: istore_3
    //   151: aload_0
    //   152: aload 11
    //   154: aload 11
    //   156: aload 11
    //   158: invokevirtual 93	com/tencent/ark/open/ArkView:setSize	(Lcom/tencent/ark/open/ArkAppInfo$Size;Lcom/tencent/ark/open/ArkAppInfo$Size;Lcom/tencent/ark/open/ArkAppInfo$Size;)Z
    //   161: pop
    //   162: iconst_4
    //   163: istore_3
    //   164: aload_0
    //   165: iconst_0
    //   166: invokevirtual 97	com/tencent/ark/open/ArkView:setBorderType	(I)V
    //   169: aload_0
    //   170: aload 9
    //   172: getfield 51	aaoi:a	Ljava/lang/String;
    //   175: aload 9
    //   177: getfield 54	aaoi:b	Ljava/lang/String;
    //   180: aload 9
    //   182: getfield 57	aaoi:c	Ljava/lang/String;
    //   185: aload 10
    //   187: aconst_null
    //   188: new 99	aaoz
    //   191: dup
    //   192: lload 5
    //   194: aload_2
    //   195: aload 8
    //   197: aload 7
    //   199: aload_1
    //   200: invokespecial 102	aaoz:<init>	(JLjava/lang/String;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;)V
    //   203: invokevirtual 106	com/tencent/ark/open/ArkView:load	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ark/ArkViewImplement$LoadCallback;)Z
    //   206: pop
    //   207: bipush 6
    //   209: istore_3
    //   210: aload 8
    //   212: invokevirtual 110	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   215: ifnull +24 -> 239
    //   218: aload 7
    //   220: invokevirtual 110	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   223: checkcast 112	android/content/Context
    //   226: aload_1
    //   227: aload 8
    //   229: invokevirtual 110	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   232: checkcast 114	com/tencent/gdtad/api/interstitial/GdtInterstitialStatus
    //   235: iload_3
    //   236: invokestatic 119	aasr:a	(Landroid/content/Context;Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;Lcom/tencent/gdtad/api/interstitial/GdtInterstitialStatus;I)V
    //   239: aload_0
    //   240: areturn
    //   241: aconst_null
    //   242: astore_2
    //   243: goto -214 -> 29
    //   246: astore_2
    //   247: aconst_null
    //   248: astore_0
    //   249: ldc 44
    //   251: ldc 121
    //   253: aload_2
    //   254: invokestatic 127	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   257: goto -47 -> 210
    //   260: astore_2
    //   261: aconst_null
    //   262: astore_0
    //   263: iconst_2
    //   264: istore_3
    //   265: goto -16 -> 249
    //   268: astore_2
    //   269: goto -20 -> 249
    //   272: astore_2
    //   273: iconst_5
    //   274: istore_3
    //   275: goto -26 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramContext	Context
    //   0	278	1	paramGdtInterstitialParams	GdtInterstitialParams
    //   0	278	2	paramGdtInterstitialStatus	GdtInterstitialStatus
    //   30	245	3	i	int
    //   102	47	4	j	int
    //   89	104	5	l	long
    //   8	211	7	localWeakReference1	java.lang.ref.WeakReference
    //   18	210	8	localWeakReference2	java.lang.ref.WeakReference
    //   37	144	9	localaaoi	aaoi
    //   46	140	10	str	String
    //   146	11	11	localSize	com.tencent.ark.open.ArkAppInfo.Size
    // Exception table:
    //   from	to	target	type
    //   31	39	246	java/lang/Throwable
    //   41	48	246	java/lang/Throwable
    //   48	101	260	java/lang/Throwable
    //   111	118	268	java/lang/Throwable
    //   121	128	268	java/lang/Throwable
    //   131	148	268	java/lang/Throwable
    //   151	162	268	java/lang/Throwable
    //   164	169	268	java/lang/Throwable
    //   169	207	272	java/lang/Throwable
  }
  
  private static String a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    if ((paramGdtInterstitialParams == null) || (!paramGdtInterstitialParams.b()))
    {
      aase.d("GdtInterstitialView", "getMetaData error");
      return null;
    }
    String str;
    if (paramGdtInterstitialParams.jdField_a_of_type_Int == 1) {
      str = "vertical";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str))
      {
        aase.d("GdtInterstitialView", "getMetaData error");
        return null;
        if ((paramGdtInterstitialParams.jdField_a_of_type_Int == 0) || (paramGdtInterstitialParams.jdField_a_of_type_Int == 8)) {
          str = "horizontal";
        }
      }
      else
      {
        int i = aatp.a(paramContext, paramGdtInterstitialParams.b);
        int j = aatp.a(paramContext, paramGdtInterstitialParams.c);
        aase.b("GdtInterstitialView", String.format("getMetaData width:%d height:%d ptWidth:%d ptHeight:%d", new Object[] { Integer.valueOf(paramGdtInterstitialParams.b), Integer.valueOf(paramGdtInterstitialParams.c), Integer.valueOf(i), Integer.valueOf(j) }));
        try
        {
          paramContext = new JSONObject();
          paramContext.put("screenType", str);
          paramGdtInterstitialParams = aasd.a(paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a.info);
          if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams != JSONObject.NULL)) {
            paramContext.put("adInfo", paramGdtInterstitialParams);
          }
          paramContext.put("viewWidth", i);
          paramContext.put("viewHeight", j);
          paramGdtInterstitialParams = new JSONObject();
          paramGdtInterstitialParams.put("gdt", paramContext);
          paramContext = paramGdtInterstitialParams.toString();
          return paramContext;
        }
        catch (Throwable paramContext)
        {
          aase.d("GdtInterstitialView", "getMetaData", paramContext);
          return null;
        }
      }
      str = null;
    }
  }
  
  private static void b(int paramInt1, int paramInt2, String paramString)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialView.2(paramString, paramInt1, paramInt2), 0);
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(Context paramContext)
  {
    aase.b("GdtInterstitialView", "pause");
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void b(Context paramContext)
  {
    aase.b("GdtInterstitialView", "resume");
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  public void c(Context paramContext)
  {
    aase.b("GdtInterstitialView", "destroy");
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaoy
 * JD-Core Version:    0.7.0.1
 */