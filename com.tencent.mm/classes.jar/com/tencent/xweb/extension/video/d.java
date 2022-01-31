package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.f;
import java.util.Timer;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;

public final class d
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, b
{
  private int BFA = 0;
  private double BFB = 0.0D;
  private float BFC = 0.0F;
  private float BFD = 0.0F;
  private a BFE;
  String BFF;
  private Timer BFG;
  private boolean BFH;
  private int BFI = 0;
  private double BFJ;
  private int BFK = 200;
  private Drawable BFL;
  private Drawable BFM;
  private boolean BFN;
  private boolean BFO;
  private boolean BFP = false;
  private int BFQ;
  private ViewGroup BFb;
  SurfaceView BFc;
  private View BFd;
  ViewGroup BFe;
  VideoStatusLayout BFf;
  ProgressBar BFg;
  TextView BFh;
  TextView BFi;
  ClickableFrameLayout BFj;
  LinearLayout BFk;
  ImageView BFl;
  ImageView BFm;
  ImageView BFn;
  c BFo;
  private WebChromeClient.CustomViewCallback BFp;
  ScaleGestureDetector BFq;
  private boolean BFr;
  private long BFs;
  private double BFt;
  private double BFu;
  private final int BFv = 0;
  private final int BFw = 1;
  private final int BFx = 2;
  private final int BFy = 3;
  private int BFz = -3;
  GestureDetector FQ;
  private Window Na;
  private WindowManager.LayoutParams apx;
  private int hkz;
  private double iiR;
  Activity mActivity;
  private AudioManager mAudioManager;
  private float mBrightness = 1.0F;
  private int mMode = 0;
  FrameLayout osU;
  WebView uNH;
  
  private void X(Runnable paramRunnable)
  {
    AppMethodBeat.i(84603);
    Activity localActivity = dYF();
    if (localActivity != null)
    {
      localActivity.runOnUiThread(paramRunnable);
      AppMethodBeat.o(84603);
      return;
    }
    this.uNH.getView().post(paramRunnable);
    AppMethodBeat.o(84603);
  }
  
  private Activity dYF()
  {
    AppMethodBeat.i(84596);
    if (this.mActivity != null)
    {
      localObject = this.mActivity;
      AppMethodBeat.o(84596);
      return localObject;
    }
    Object localObject = this.uNH.getContext();
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      label44:
      if (localObject == null) {
        break label95;
      }
      this.mActivity = ((Activity)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(84596);
      return localObject;
      if ((localObject instanceof ContextWrapper))
      {
        Context localContext = ((ContextWrapper)localObject).getBaseContext();
        if (localContext != localObject)
        {
          localObject = localContext;
          break;
        }
        localObject = null;
        break label44;
      }
      localObject = null;
      break label44;
      label95:
      Log.e("XWebNativeInterface", "royle:tryGetActivity but no Activity");
    }
  }
  
  /* Error */
  public static String dYG()
  {
    // Byte code:
    //   0: ldc 216
    //   2: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 218
    //   7: invokestatic 224	com/tencent/xweb/xwalk/a/e:ayq	(Ljava/lang/String;)Lcom/tencent/xweb/xwalk/a/c;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +429 -> 441
    //   15: aload_1
    //   16: getfield 229	com/tencent/xweb/xwalk/a/c:BKm	I
    //   19: iconst_m1
    //   20: if_icmpeq +421 -> 441
    //   23: aload_1
    //   24: getfield 229	com/tencent/xweb/xwalk/a/c:BKm	I
    //   27: istore_0
    //   28: new 231	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: aload_1
    //   34: getfield 229	com/tencent/xweb/xwalk/a/c:BKm	I
    //   37: iconst_0
    //   38: invokevirtual 235	com/tencent/xweb/xwalk/a/c:aP	(IZ)Ljava/lang/String;
    //   41: invokespecial 238	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 242	java/io/File:isFile	()Z
    //   49: ifeq +234 -> 283
    //   52: aload_2
    //   53: invokevirtual 245	java/io/File:exists	()Z
    //   56: ifeq +227 -> 283
    //   59: new 247	java/io/FileInputStream
    //   62: dup
    //   63: aload_2
    //   64: invokespecial 250	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull +367 -> 436
    //   72: new 252	java/io/InputStreamReader
    //   75: dup
    //   76: aload_1
    //   77: ldc 254
    //   79: invokespecial 257	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   82: astore_3
    //   83: new 259	java/io/BufferedReader
    //   86: dup
    //   87: aload_3
    //   88: invokespecial 262	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   91: astore_2
    //   92: aload_3
    //   93: astore 5
    //   95: aload_2
    //   96: astore 4
    //   98: new 264	java/lang/StringBuffer
    //   101: dup
    //   102: ldc_w 266
    //   105: invokespecial 267	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   108: astore 6
    //   110: aload_3
    //   111: astore 5
    //   113: aload_2
    //   114: astore 4
    //   116: aload_2
    //   117: invokevirtual 270	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   120: astore 7
    //   122: aload 7
    //   124: ifnull +170 -> 294
    //   127: aload_3
    //   128: astore 5
    //   130: aload_2
    //   131: astore 4
    //   133: aload 6
    //   135: aload 7
    //   137: invokevirtual 274	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   140: pop
    //   141: aload_3
    //   142: astore 5
    //   144: aload_2
    //   145: astore 4
    //   147: aload 6
    //   149: ldc_w 276
    //   152: invokevirtual 274	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   155: pop
    //   156: goto -46 -> 110
    //   159: astore 6
    //   161: aload_3
    //   162: astore 5
    //   164: aload_2
    //   165: astore 4
    //   167: ldc 199
    //   169: new 278	java/lang/StringBuilder
    //   172: dup
    //   173: ldc_w 280
    //   176: invokespecial 281	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   179: aload 6
    //   181: invokevirtual 284	java/io/IOException:getMessage	()Ljava/lang/String;
    //   184: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 207	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_3
    //   194: ifnull +7 -> 201
    //   197: aload_3
    //   198: invokevirtual 293	java/io/InputStreamReader:close	()V
    //   201: aload_2
    //   202: ifnull +7 -> 209
    //   205: aload_2
    //   206: invokevirtual 294	java/io/BufferedReader:close	()V
    //   209: aload_1
    //   210: ifnull +7 -> 217
    //   213: aload_1
    //   214: invokevirtual 297	java/io/InputStream:close	()V
    //   217: aconst_null
    //   218: astore_1
    //   219: aload_1
    //   220: ifnull +10 -> 230
    //   223: aload_1
    //   224: invokevirtual 302	java/lang/String:isEmpty	()Z
    //   227: ifeq +154 -> 381
    //   230: ldc 199
    //   232: ldc_w 304
    //   235: invokestatic 306	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: ldc_w 308
    //   241: astore_1
    //   242: invokestatic 313	com/tencent/xweb/util/f:dZK	()V
    //   245: ldc 216
    //   247: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_1
    //   251: areturn
    //   252: astore_1
    //   253: ldc 199
    //   255: new 278	java/lang/StringBuilder
    //   258: dup
    //   259: ldc_w 315
    //   262: invokespecial 281	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   265: aload_1
    //   266: invokevirtual 316	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   269: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 207	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: aconst_null
    //   279: astore_1
    //   280: goto -212 -> 68
    //   283: aload_1
    //   284: iconst_m1
    //   285: invokevirtual 320	com/tencent/xweb/xwalk/a/c:TI	(I)Z
    //   288: pop
    //   289: aconst_null
    //   290: astore_1
    //   291: goto -223 -> 68
    //   294: aload_3
    //   295: astore 5
    //   297: aload_2
    //   298: astore 4
    //   300: aload 6
    //   302: invokevirtual 321	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   305: astore 6
    //   307: aload_3
    //   308: invokevirtual 293	java/io/InputStreamReader:close	()V
    //   311: aload_2
    //   312: invokevirtual 294	java/io/BufferedReader:close	()V
    //   315: aload_1
    //   316: ifnull +7 -> 323
    //   319: aload_1
    //   320: invokevirtual 297	java/io/InputStream:close	()V
    //   323: aload 6
    //   325: astore_1
    //   326: goto -107 -> 219
    //   329: astore_1
    //   330: aload 6
    //   332: astore_1
    //   333: goto -114 -> 219
    //   336: astore_1
    //   337: aconst_null
    //   338: astore_1
    //   339: goto -120 -> 219
    //   342: astore_2
    //   343: aconst_null
    //   344: astore_3
    //   345: aconst_null
    //   346: astore 4
    //   348: aload_3
    //   349: ifnull +7 -> 356
    //   352: aload_3
    //   353: invokevirtual 293	java/io/InputStreamReader:close	()V
    //   356: aload 4
    //   358: ifnull +8 -> 366
    //   361: aload 4
    //   363: invokevirtual 294	java/io/BufferedReader:close	()V
    //   366: aload_1
    //   367: ifnull +7 -> 374
    //   370: aload_1
    //   371: invokevirtual 297	java/io/InputStream:close	()V
    //   374: ldc 216
    //   376: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: aload_2
    //   380: athrow
    //   381: ldc 199
    //   383: ldc_w 323
    //   386: iload_0
    //   387: invokestatic 327	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   390: invokevirtual 331	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   393: invokestatic 306	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: invokestatic 334	com/tencent/xweb/util/f:dZJ	()V
    //   399: goto -154 -> 245
    //   402: astore_1
    //   403: goto -29 -> 374
    //   406: astore_2
    //   407: aconst_null
    //   408: astore 4
    //   410: goto -62 -> 348
    //   413: astore_2
    //   414: aload 5
    //   416: astore_3
    //   417: goto -69 -> 348
    //   420: astore 6
    //   422: aconst_null
    //   423: astore_3
    //   424: aconst_null
    //   425: astore_2
    //   426: goto -265 -> 161
    //   429: astore 6
    //   431: aconst_null
    //   432: astore_2
    //   433: goto -272 -> 161
    //   436: aconst_null
    //   437: astore_1
    //   438: goto -219 -> 219
    //   441: iconst_m1
    //   442: istore_0
    //   443: aconst_null
    //   444: astore_1
    //   445: goto -377 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	416	0	i	int
    //   10	241	1	localObject1	Object
    //   252	14	1	localFileNotFoundException	java.io.FileNotFoundException
    //   279	47	1	localObject2	Object
    //   329	1	1	localException1	java.lang.Exception
    //   332	1	1	localObject3	Object
    //   336	1	1	localException2	java.lang.Exception
    //   338	33	1	localObject4	Object
    //   402	1	1	localException3	java.lang.Exception
    //   437	8	1	localObject5	Object
    //   44	268	2	localObject6	Object
    //   342	38	2	localObject7	Object
    //   406	1	2	localObject8	Object
    //   413	1	2	localObject9	Object
    //   425	8	2	localObject10	Object
    //   82	342	3	localObject11	Object
    //   96	313	4	localObject12	Object
    //   93	322	5	localObject13	Object
    //   108	40	6	localStringBuffer	java.lang.StringBuffer
    //   159	142	6	localIOException1	java.io.IOException
    //   305	26	6	str1	String
    //   420	1	6	localIOException2	java.io.IOException
    //   429	1	6	localIOException3	java.io.IOException
    //   120	16	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   98	110	159	java/io/IOException
    //   116	122	159	java/io/IOException
    //   133	141	159	java/io/IOException
    //   147	156	159	java/io/IOException
    //   300	307	159	java/io/IOException
    //   59	68	252	java/io/FileNotFoundException
    //   307	315	329	java/lang/Exception
    //   319	323	329	java/lang/Exception
    //   197	201	336	java/lang/Exception
    //   205	209	336	java/lang/Exception
    //   213	217	336	java/lang/Exception
    //   72	83	342	finally
    //   352	356	402	java/lang/Exception
    //   361	366	402	java/lang/Exception
    //   370	374	402	java/lang/Exception
    //   83	92	406	finally
    //   98	110	413	finally
    //   116	122	413	finally
    //   133	141	413	finally
    //   147	156	413	finally
    //   167	193	413	finally
    //   300	307	413	finally
    //   72	83	420	java/io/IOException
    //   83	92	429	java/io/IOException
  }
  
  private SurfaceView fI(View paramView)
  {
    AppMethodBeat.i(84627);
    if ((paramView instanceof SurfaceView))
    {
      paramView = (SurfaceView)paramView;
      AppMethodBeat.o(84627);
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        SurfaceView localSurfaceView = fI(paramView.getChildAt(i));
        if (localSurfaceView != null)
        {
          AppMethodBeat.o(84627);
          return localSurfaceView;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(84627);
    return null;
  }
  
  private static String q(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(84613);
    String str1 = String.format("%02d", new Object[] { Integer.valueOf((int)(paramDouble1 / 3600.0D)) });
    String str2 = String.format("%02d", new Object[] { Integer.valueOf((int)(paramDouble1 % 3600.0D) / 60) });
    String str3 = String.format("%02d", new Object[] { Integer.valueOf((int)(paramDouble1 % 3600.0D) % 60) });
    if (paramDouble2 > 3600.0D) {}
    for (str1 = String.format("%s:%s:%s", new Object[] { str1, str2, str3 });; str1 = String.format("%s:%s", new Object[] { str2, str3 }))
    {
      AppMethodBeat.o(84613);
      return str1;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(84600);
    if (this.mAudioManager == null) {
      this.mAudioManager = ((AudioManager)this.uNH.getContext().getSystemService("audio"));
    }
    this.BFA = this.mAudioManager.getStreamMaxVolume(3);
    this.BFB = this.mAudioManager.getStreamVolume(3);
    if (this.BFE == null) {
      this.BFE = new a(this.uNH.getContext());
    }
    if (this.Na == null)
    {
      Activity localActivity = dYF();
      if (localActivity != null) {
        this.Na = localActivity.getWindow();
      }
    }
    if ((this.Na != null) && (this.apx == null)) {
      this.apx = this.Na.getAttributes();
    }
    if (this.apx != null)
    {
      this.mBrightness = this.apx.screenBrightness;
      if (this.mBrightness == -1.0F) {
        try
        {
          this.mBrightness = ((float)(Settings.System.getInt(this.uNH.getContext().getContentResolver(), "screen_brightness") / 256.0D));
          AppMethodBeat.o(84600);
          return;
        }
        catch (Settings.SettingNotFoundException localSettingNotFoundException)
        {
          Log.e("XWebNativeInterface", "brightness get error:" + localSettingNotFoundException.getMessage());
        }
      }
    }
    AppMethodBeat.o(84600);
  }
  
  private void sg(boolean paramBoolean)
  {
    AppMethodBeat.i(84611);
    X(new d.2(this, paramBoolean));
    AppMethodBeat.o(84611);
  }
  
  private void sh(boolean paramBoolean)
  {
    AppMethodBeat.i(84628);
    Activity localActivity = dYF();
    if (localActivity == null)
    {
      AppMethodBeat.o(84628);
      return;
    }
    if (paramBoolean)
    {
      if ((localActivity.getWindow().getAttributes().flags & 0x800) != 0)
      {
        this.BFO = true;
        localActivity.getWindow().clearFlags(2048);
        if (this.BFP) {
          break label174;
        }
        if ((localActivity.getWindow().getAttributes().flags & 0x400) == 0) {
          break label107;
        }
        this.BFN = true;
      }
      for (;;)
      {
        this.BFP = true;
        AppMethodBeat.o(84628);
        return;
        this.BFO = false;
        break;
        label107:
        this.BFN = false;
        localActivity.getWindow().addFlags(1024);
      }
    }
    else
    {
      if (this.BFO) {
        localActivity.getWindow().addFlags(2048);
      }
      if (!this.BFN) {
        localActivity.getWindow().clearFlags(1024);
      }
      this.BFQ = 0;
      this.BFP = false;
      this.BFr = false;
    }
    label174:
    AppMethodBeat.o(84628);
  }
  
  public final void ao(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(84598);
    if ((this.uNH != null) && (paramBoolean2) && (this.BFF != null))
    {
      Log.i("XWebNativeInterface", "evaluteJavascript:".concat(String.valueOf(paramBoolean1)));
      String str = this.BFF;
      if (paramBoolean1)
      {
        str = this.BFF;
        str = "window.addEventListener('DOMContentLoaded', function() {" + str + "});this.xwebReturn = function (){return \"1\";};this.xwebReturn()";
      }
      this.uNH.evaluateJavascript(str, new d.17(this));
    }
    AppMethodBeat.o(84598);
  }
  
  public final void dYH()
  {
    AppMethodBeat.i(84604);
    if (this.BFG != null)
    {
      this.BFG.cancel();
      this.BFG.purge();
      this.BFG = null;
    }
    this.BFG = new Timer();
    this.BFG.schedule(new d.18(this), 4000L);
    AppMethodBeat.o(84604);
  }
  
  public final void dYI()
  {
    AppMethodBeat.i(84605);
    if (this.BFG != null)
    {
      this.BFG.cancel();
      this.BFG.purge();
      this.BFG = null;
    }
    AppMethodBeat.o(84605);
  }
  
  public final void dYJ()
  {
    AppMethodBeat.i(84609);
    X(new d.19(this));
    AppMethodBeat.o(84609);
  }
  
  public final void dYK()
  {
    AppMethodBeat.i(84610);
    X(new d.20(this));
    AppMethodBeat.o(84610);
  }
  
  public final void da(Object paramObject)
  {
    AppMethodBeat.i(84597);
    new ReflectMethod(paramObject, "addJavascriptInterface", new Class[] { Object.class, String.class }).invoke(new Object[] { this, "xwebToNative" });
    AppMethodBeat.o(84597);
  }
  
  public final void f(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(84612);
    X(new d.3(this, paramBoolean, paramDouble));
    AppMethodBeat.o(84612);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return this.BFP;
  }
  
  public final void iA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84629);
    Object localObject = dYF();
    if (localObject == null)
    {
      AppMethodBeat.o(84629);
      return;
    }
    if ((this.BFz == -3) && (localObject != null)) {
      this.BFz = ((Activity)localObject).getRequestedOrientation();
    }
    int i;
    Point localPoint;
    int j;
    label156:
    double d1;
    if (paramInt1 <= paramInt2)
    {
      ((Activity)localObject).setRequestedOrientation(1);
      i = 1;
      this.hkz = i;
      if (this.BFd != null)
      {
        localObject = this.BFd;
        Display localDisplay = ((WindowManager)this.uNH.getContext().getSystemService("window")).getDefaultDisplay();
        localPoint = new Point(0, 0);
        localDisplay.getSize(localPoint);
        if (i != 0) {
          break label229;
        }
        j = Math.max(localPoint.x, localPoint.y);
        i = Math.min(localPoint.x, localPoint.y);
        d1 = paramInt1 * 1.0D / paramInt2;
        if (d1 < j * 1.0D / i) {
          break label262;
        }
        double d2 = j;
        i = (int)(1.0D / d1 * d2);
      }
    }
    for (;;)
    {
      ((View)localObject).setLayoutParams(new FrameLayout.LayoutParams(j, i, 17));
      AppMethodBeat.o(84629);
      return;
      ((Activity)localObject).setRequestedOrientation(0);
      i = 0;
      break;
      label229:
      i = Math.max(localPoint.x, localPoint.y);
      j = Math.min(localPoint.x, localPoint.y);
      break label156;
      label262:
      j = (int)(d1 * i);
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    this.BFI = 0;
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(84602);
    if (this.BFp != null) {
      this.BFp.onCustomViewHidden();
    }
    Log.i("XWebNativeInterface", "detach");
    if (!this.BFP)
    {
      Log.i("XWebNativeInterface", "detach has exited fullscreen");
      AppMethodBeat.o(84602);
      return;
    }
    Activity localActivity = dYF();
    if (localActivity != null)
    {
      if (this.BFL != null)
      {
        if ((this.BFL instanceof ColorDrawable)) {
          this.uNH.getWebViewUI().setBackgroundColor(((ColorDrawable)this.BFL).getColor());
        }
        this.BFL = null;
        if (this.BFM == null) {
          break label164;
        }
        this.uNH.setBackground(this.BFM);
      }
      for (;;)
      {
        ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
        if (this.osU.getParent() == localViewGroup) {
          break label175;
        }
        AppMethodBeat.o(84602);
        return;
        this.uNH.getWebViewUI().setBackgroundColor(0);
        break;
        label164:
        this.uNH.setBackgroundColor(0);
      }
      label175:
      if (this.uNH.isXWalkKernel())
      {
        this.osU.removeView(this.uNH);
        this.BFb.addView(this.uNH, 0);
      }
      if (this.BFd != null) {
        this.osU.removeView(this.BFd);
      }
      this.osU.removeView(this.BFe);
      this.BFe.setVisibility(8);
      if (this.BFz != -3)
      {
        localActivity.setRequestedOrientation(this.BFz);
        this.BFz = -3;
      }
      sh(false);
      if ((this.osU.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.osU.getParent()).removeView(this.osU);
      }
    }
    AppMethodBeat.o(84602);
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(84608);
    if ((this.mMode == 1) && (this.BFd != null))
    {
      float f = paramScaleGestureDetector.getScaleFactor();
      this.BFd.getLeft();
      this.BFd.getTop();
      this.BFd.getBottom();
      this.BFd.getRight();
      int i = (int)(this.BFd.getWidth() * f);
      int j = (int)(f * this.BFd.getHeight());
      paramScaleGestureDetector = new FrameLayout.LayoutParams(-2, -2, 17);
      paramScaleGestureDetector.width = i;
      paramScaleGestureDetector.height = j;
      if (this.BFd != null) {
        this.BFd.setLayoutParams(paramScaleGestureDetector);
      }
      AppMethodBeat.o(84608);
      return true;
    }
    AppMethodBeat.o(84608);
    return false;
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(84607);
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null))
    {
      AppMethodBeat.o(84607);
      return true;
    }
    float f1 = paramMotionEvent2.getX();
    float f2 = paramMotionEvent1.getX();
    float f3 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
    if (this.BFe.getHeight() > this.BFe.getWidth())
    {
      paramFloat2 = this.BFe.getWidth();
      paramFloat1 = this.BFe.getHeight();
    }
    double d1;
    switch (this.BFI)
    {
    default: 
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(84607);
        return true;
        paramFloat2 = this.BFe.getHeight();
        paramFloat1 = this.BFe.getWidth();
        break;
        if (Math.abs(f1 - f2) - Math.abs(f3) > 1.0F)
        {
          this.BFI = 3;
        }
        else
        {
          reset();
          d1 = Math.ceil(25.0F * this.uNH.getContext().getResources().getDisplayMetrics().density);
          if ((paramMotionEvent1.getY() < 2.0D * d1) || (paramMotionEvent1.getY() > this.BFe.getHeight() - d1 * 2.0D)) {
            this.BFI = 0;
          } else if (paramMotionEvent1.getX() < this.BFe.getWidth() / 2.0F) {
            this.BFI = 2;
          } else {
            this.BFI = 1;
          }
        }
      }
    case 1: 
      paramFloat1 = f3 * -1.0F;
      d1 = this.BFA * paramFloat1 / paramFloat2 * 1.2F;
      int j = (int)d1;
      int i = j;
      if (j == 0)
      {
        i = j;
        if (Math.abs(d1) > 0.2000000029802322D)
        {
          if (paramFloat1 <= 0.0F) {
            break label426;
          }
          i = 1;
        }
      }
      d1 = this.BFB;
      double d2 = i + d1;
      if (d2 > this.BFA) {
        d1 = this.BFA;
      }
      for (;;)
      {
        this.mAudioManager.setStreamVolume(3, (int)d1, 4);
        i = (int)(d1 / this.BFA * 100.0D);
        this.BFf.setVolumnProgress(i);
        this.BFf.show();
        break;
        i = j;
        if (paramFloat1 >= 0.0F) {
          break label347;
        }
        i = -1;
        break label347;
        d1 = d2;
        if (d2 < 0.0D) {
          d1 = 0.0D;
        }
      }
    case 2: 
      label347:
      paramFloat2 = -1.0F * f3 / paramFloat2 * 1.2F + this.mBrightness;
      label426:
      if (paramFloat2 < 0.0F) {
        paramFloat1 = 0.0F;
      }
      for (;;)
      {
        this.apx.screenBrightness = paramFloat1;
        this.Na.setAttributes(this.apx);
        this.BFf.setBrightProgress((int)(paramFloat1 * 100.0F));
        this.BFf.show();
        break;
        paramFloat1 = paramFloat2;
        if (paramFloat2 > 1.0F) {
          paramFloat1 = 1.0F;
        }
      }
    }
    paramFloat2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    this.BFD = this.BFo.Tb;
    if (paramFloat2 > 0.0F)
    {
      f1 = this.BFD;
      this.BFC = ((int)(paramFloat2 / paramFloat1 * 100.0F + f1));
      if (this.BFC > 100.0F) {
        this.BFC = 100.0F;
      }
    }
    for (;;)
    {
      d1 = this.iiR * this.BFC / 100.0D;
      this.BFf.setVideoTimeProgress(q(d1, this.iiR) + "/" + q(this.iiR, this.iiR));
      this.BFf.show();
      this.BFJ = d1;
      break;
      f1 = this.BFD;
      this.BFC = ((int)(paramFloat2 / paramFloat1 * 100.0F + f1));
      if (this.BFC < 0.0F) {
        this.BFC = 0.0F;
      }
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(84601);
    Log.i("XWebNativeInterface", "onShowCustomView");
    this.BFd = paramView;
    this.BFp = paramCustomViewCallback;
    if ((this.BFd != null) || (this.uNH.isXWalkKernel()))
    {
      if (!this.uNH.isXWalkKernel()) {
        break label92;
      }
      f.dZi();
      Log.i("XWebNativeInterface", "attach");
      if (!this.BFP) {
        break label108;
      }
      Log.i("XWebNativeInterface", "attach has entered fullscreen");
    }
    for (;;)
    {
      this.uNH.requestFocus();
      AppMethodBeat.o(84601);
      return;
      label92:
      if (!this.uNH.isSysKernel()) {
        break;
      }
      f.dZm();
      break;
      label108:
      paramView = dYF();
      if (paramView != null)
      {
        reset();
        sh(true);
        paramView = (FrameLayout)paramView.getWindow().getDecorView();
        if ((this.uNH.isXWalkKernel()) && (this.osU.getParent() == paramView) && (this.BFd != null))
        {
          this.osU.addView(this.BFd, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        else if (this.osU.getParent() != paramView)
        {
          paramView.addView(this.osU, new FrameLayout.LayoutParams(-1, -1, 17));
          if (this.BFd != null)
          {
            this.osU.addView(this.BFd, this.osU.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
            if (this.uNH.isSysKernel()) {
              this.BFd.setVisibility(4);
            }
          }
          if (this.uNH.isSysKernel())
          {
            paramView = fI(this.BFd);
            if (paramView != null) {
              paramView.setZOrderMediaOverlay(true);
            }
          }
          if (this.uNH.isXWalkKernel())
          {
            this.BFb = ((ViewGroup)this.uNH.getParent());
            this.BFb.removeView(this.uNH);
            this.osU.addView(this.uNH, this.osU.getChildCount());
          }
          this.osU.addView(this.BFe, this.osU.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
          this.BFL = this.uNH.getWebViewUI().getBackground();
          this.uNH.getWebViewUI().setBackgroundColor(-16777216);
          this.BFM = this.uNH.getBackground();
          this.uNH.setBackgroundColor(-16777216);
          if (this.uNH.isSysKernel()) {
            this.osU.postDelayed(new d.13(this), this.BFK);
          }
        }
      }
    }
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(84606);
    dYI();
    if (this.BFH) {
      dYK();
    }
    for (;;)
    {
      AppMethodBeat.o(84606);
      return true;
      dYJ();
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onSpecialVideoEnterFullscreen(int paramInt)
  {
    AppMethodBeat.i(84625);
    Log.i("XWebNativeInterface", "onSpecialVideoEnterFullscreen:".concat(String.valueOf(paramInt)));
    f.aN(paramInt, this.uNH.isXWalkKernel());
    AppMethodBeat.o(84625);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onSpecialVideoHook(int paramInt)
  {
    AppMethodBeat.i(84626);
    Log.i("XWebNativeInterface", "onSpecialVideoHook:".concat(String.valueOf(paramInt)));
    f.aO(paramInt, this.uNH.isXWalkKernel());
    AppMethodBeat.o(84626);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(84621);
    Log.i("XWebNativeInterface", "onVideoEnterFullscreen:isVideoTag:" + paramBoolean1 + ",width:" + paramDouble1 + ",height:" + paramDouble2 + ",pause:" + paramBoolean2 + ",seeking:" + paramBoolean3 + ",currentTime:" + paramDouble3 + ",duration:" + paramDouble4);
    if (this.uNH.isXWalkKernel())
    {
      f.dZj();
      if (paramBoolean1)
      {
        if (!this.uNH.isXWalkKernel()) {
          break label217;
        }
        f.dZk();
        label124:
        this.BFr = true;
      }
      this.BFs = paramLong;
      this.iiR = paramDouble4;
      this.BFt = paramDouble1;
      this.BFu = paramDouble2;
      if (!paramBoolean3) {
        break label233;
      }
      onVideoSeeking();
    }
    for (;;)
    {
      X(new d.9(this, paramBoolean1, paramDouble1, paramDouble2));
      onVideoTimeUpdate(paramDouble3, paramDouble4, paramArrayOfDouble);
      sg(paramBoolean2);
      AppMethodBeat.o(84621);
      return;
      if (!this.uNH.isSysKernel()) {
        break;
      }
      f.dZn();
      break;
      label217:
      if (!this.uNH.isSysKernel()) {
        break label124;
      }
      f.dZo();
      break label124;
      label233:
      onVideoSeeked();
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoExitFullscreen()
  {
    AppMethodBeat.i(84622);
    Log.i("XWebNativeInterface", "onVideoExitFullscreen");
    this.BFr = false;
    X(new d.10(this));
    AppMethodBeat.o(84622);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoGetFrame(long paramLong, double paramDouble, String paramString)
  {
    AppMethodBeat.i(84614);
    if ((paramLong == this.BFs) && (this.BFJ == paramDouble) && (paramString != null) && (paramString.startsWith("data:image/png;base64,")))
    {
      paramString = Base64.decode(paramString.substring(22), 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      this.BFl.setImageBitmap(paramString);
      this.BFl.setVisibility(0);
    }
    AppMethodBeat.o(84614);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPause()
  {
    AppMethodBeat.i(84620);
    Log.i("XWebNativeInterface", "onVideoPause");
    sg(true);
    AppMethodBeat.o(84620);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPlay()
  {
    AppMethodBeat.i(84619);
    Log.i("XWebNativeInterface", "onVideoPlay");
    sg(false);
    AppMethodBeat.o(84619);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPlaying()
  {
    AppMethodBeat.i(84615);
    Log.i("XWebNativeInterface", "onVideoPlaying");
    X(new d.5(this));
    AppMethodBeat.o(84615);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoSeeked()
  {
    AppMethodBeat.i(84618);
    Log.i("XWebNativeInterface", "onVideoSeeked");
    X(new d.8(this));
    AppMethodBeat.o(84618);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoSeeking()
  {
    AppMethodBeat.i(84617);
    Log.i("XWebNativeInterface", "onVideoSeeking");
    X(new d.7(this));
    AppMethodBeat.o(84617);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoSizeUpdate(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(84624);
    if ((this.BFu != paramDouble2) || (this.BFt != paramDouble1))
    {
      this.BFt = paramDouble1;
      this.BFu = paramDouble2;
      Log.i("XWebNativeInterface", "onVideoSizeUpdate width:" + paramDouble1 + ", height:" + paramDouble2);
      X(new d.11(this, paramDouble1, paramDouble2));
    }
    AppMethodBeat.o(84624);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoTimeUpdate(double paramDouble1, final double paramDouble2, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(84623);
    this.iiR = paramDouble2;
    f(paramDouble1, true);
    X(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(84578);
        c localc = d.l(d.this);
        double d3 = paramDouble2;
        Object localObject = this.BFW;
        double d1 = 0.0D;
        int i = 0;
        while (i < localObject.length)
        {
          double d2 = d1;
          if (localObject.length > i + 1)
          {
            d2 = d1;
            if (localObject[i] / d3 * 100.0D <= localc.Tb)
            {
              d2 = d1;
              if (localObject[(i + 1)] / d3 * 100.0D > localc.Tb) {
                d2 = localObject[(i + 1)] / d3 * 100.0D;
              }
            }
          }
          i += 2;
          d1 = d2;
        }
        localObject = (FrameLayout.LayoutParams)localc.idc.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = ((int)(d1 / 100.0D * localc.qTD.getWidth()));
        localc.idc.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localc.idc.requestLayout();
        AppMethodBeat.o(84578);
      }
    });
    AppMethodBeat.o(84623);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(84616);
    Log.i("XWebNativeInterface", "onVideoWaiting");
    X(new d.6(this));
    AppMethodBeat.o(84616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d
 * JD-Core Version:    0.7.0.1
 */