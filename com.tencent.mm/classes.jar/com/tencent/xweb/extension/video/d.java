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
import android.view.ViewGroup;
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
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.e;
import java.util.Timer;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;

public final class d
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, b
{
  GestureDetector Fh;
  private Window Nk;
  private WindowManager.LayoutParams anh;
  private AudioManager dzw;
  private int fOo;
  Activity mActivity;
  private float mBrightness = 1.0F;
  private int mMode = 0;
  FrameLayout rbC;
  WebView vWc;
  private ViewGroup xhO;
  SurfaceView xhP;
  private View xhQ;
  ViewGroup xhR;
  VideoStatusLayout xhS;
  ProgressBar xhT;
  TextView xhU;
  TextView xhV;
  ClickableFrameLayout xhW;
  LinearLayout xhX;
  ImageView xhY;
  ImageView xhZ;
  private Drawable xiA;
  private boolean xiB;
  private boolean xiC;
  private boolean xiD = false;
  private int xiE;
  ImageView xia;
  c xib;
  private WebChromeClient.CustomViewCallback xic;
  ScaleGestureDetector xid;
  private boolean xie;
  private long xif;
  private double xig;
  private double xih;
  private double xii;
  private final int xij = 0;
  private final int xik = 1;
  private final int xil = 2;
  private final int xim = 3;
  private int xin = -3;
  private int xio = 0;
  private double xip = 0.0D;
  private float xiq = 0.0F;
  private float xir = 0.0F;
  private a xis;
  String xit;
  private Timer xiu;
  private boolean xiv;
  private int xiw = 0;
  private double xix;
  private int xiy = 200;
  private Drawable xiz;
  
  private void al(Runnable paramRunnable)
  {
    Activity localActivity = cSy();
    if (localActivity != null)
    {
      localActivity.runOnUiThread(paramRunnable);
      return;
    }
    this.vWc.getView().post(paramRunnable);
  }
  
  private Activity cSy()
  {
    if (this.mActivity != null) {
      return this.mActivity;
    }
    Object localObject = this.vWc.getContext();
    if ((localObject instanceof Activity)) {
      localObject = (Activity)localObject;
    }
    for (;;)
    {
      if (localObject == null) {
        break label78;
      }
      this.mActivity = ((Activity)localObject);
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
        continue;
      }
      localObject = null;
    }
    label78:
    Log.e("XWebNativeInterface", "royle:tryGetActivity but no Activity");
    return localObject;
  }
  
  /* Error */
  public static String cSz()
  {
    // Byte code:
    //   0: ldc 199
    //   2: invokestatic 205	com/tencent/xweb/xwalk/plugin/XWalkPluginManager:ahg	(Ljava/lang/String;)Lcom/tencent/xweb/xwalk/plugin/b;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnull +422 -> 429
    //   10: aload_1
    //   11: getfield 210	com/tencent/xweb/xwalk/plugin/b:xmr	I
    //   14: iconst_m1
    //   15: if_icmpeq +414 -> 429
    //   18: aload_1
    //   19: getfield 210	com/tencent/xweb/xwalk/plugin/b:xmr	I
    //   22: istore_0
    //   23: new 212	java/io/File
    //   26: dup
    //   27: aload_1
    //   28: aload_1
    //   29: getfield 210	com/tencent/xweb/xwalk/plugin/b:xmr	I
    //   32: iconst_0
    //   33: invokevirtual 216	com/tencent/xweb/xwalk/plugin/b:az	(IZ)Ljava/lang/String;
    //   36: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 223	java/io/File:isFile	()Z
    //   44: ifeq +226 -> 270
    //   47: aload_2
    //   48: invokevirtual 226	java/io/File:exists	()Z
    //   51: ifeq +219 -> 270
    //   54: new 228	java/io/FileInputStream
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 231	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +360 -> 424
    //   67: new 233	java/io/InputStreamReader
    //   70: dup
    //   71: aload_1
    //   72: ldc 235
    //   74: invokespecial 238	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   77: astore_3
    //   78: new 240	java/io/BufferedReader
    //   81: dup
    //   82: aload_3
    //   83: invokespecial 243	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   86: astore_2
    //   87: aload_3
    //   88: astore 5
    //   90: aload_2
    //   91: astore 4
    //   93: new 245	java/lang/StringBuffer
    //   96: dup
    //   97: ldc 247
    //   99: invokespecial 248	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   102: astore 6
    //   104: aload_3
    //   105: astore 5
    //   107: aload_2
    //   108: astore 4
    //   110: aload_2
    //   111: invokevirtual 251	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   114: astore 7
    //   116: aload 7
    //   118: ifnull +163 -> 281
    //   121: aload_3
    //   122: astore 5
    //   124: aload_2
    //   125: astore 4
    //   127: aload 6
    //   129: aload 7
    //   131: invokevirtual 255	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   134: pop
    //   135: aload_3
    //   136: astore 5
    //   138: aload_2
    //   139: astore 4
    //   141: aload 6
    //   143: ldc_w 257
    //   146: invokevirtual 255	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   149: pop
    //   150: goto -46 -> 104
    //   153: astore 6
    //   155: aload_3
    //   156: astore 5
    //   158: aload_2
    //   159: astore 4
    //   161: ldc 181
    //   163: new 259	java/lang/StringBuilder
    //   166: dup
    //   167: ldc_w 261
    //   170: invokespecial 262	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: aload 6
    //   175: invokevirtual 265	java/io/IOException:getMessage	()Ljava/lang/String;
    //   178: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 189	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 274	java/io/InputStreamReader:close	()V
    //   195: aload_2
    //   196: ifnull +7 -> 203
    //   199: aload_2
    //   200: invokevirtual 275	java/io/BufferedReader:close	()V
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 278	java/io/InputStream:close	()V
    //   211: aconst_null
    //   212: astore_1
    //   213: aload_1
    //   214: ifnull +10 -> 224
    //   217: aload_1
    //   218: invokevirtual 283	java/lang/String:isEmpty	()Z
    //   221: ifeq +142 -> 363
    //   224: ldc 181
    //   226: ldc_w 285
    //   229: invokestatic 288	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: invokestatic 293	com/tencent/xweb/util/e:cTu	()V
    //   235: ldc_w 295
    //   238: areturn
    //   239: astore_1
    //   240: ldc 181
    //   242: new 259	java/lang/StringBuilder
    //   245: dup
    //   246: ldc_w 297
    //   249: invokespecial 262	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   252: aload_1
    //   253: invokevirtual 298	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   256: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 189	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aconst_null
    //   266: astore_1
    //   267: goto -204 -> 63
    //   270: aload_1
    //   271: iconst_m1
    //   272: invokevirtual 302	com/tencent/xweb/xwalk/plugin/b:KJ	(I)Z
    //   275: pop
    //   276: aconst_null
    //   277: astore_1
    //   278: goto -215 -> 63
    //   281: aload_3
    //   282: astore 5
    //   284: aload_2
    //   285: astore 4
    //   287: aload 6
    //   289: invokevirtual 303	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   292: astore 6
    //   294: aload_3
    //   295: invokevirtual 274	java/io/InputStreamReader:close	()V
    //   298: aload_2
    //   299: invokevirtual 275	java/io/BufferedReader:close	()V
    //   302: aload_1
    //   303: ifnull +7 -> 310
    //   306: aload_1
    //   307: invokevirtual 278	java/io/InputStream:close	()V
    //   310: aload 6
    //   312: astore_1
    //   313: goto -100 -> 213
    //   316: astore_1
    //   317: aload 6
    //   319: astore_1
    //   320: goto -107 -> 213
    //   323: astore_1
    //   324: aconst_null
    //   325: astore_1
    //   326: goto -113 -> 213
    //   329: astore_2
    //   330: aconst_null
    //   331: astore_3
    //   332: aconst_null
    //   333: astore 4
    //   335: aload_3
    //   336: ifnull +7 -> 343
    //   339: aload_3
    //   340: invokevirtual 274	java/io/InputStreamReader:close	()V
    //   343: aload 4
    //   345: ifnull +8 -> 353
    //   348: aload 4
    //   350: invokevirtual 275	java/io/BufferedReader:close	()V
    //   353: aload_1
    //   354: ifnull +7 -> 361
    //   357: aload_1
    //   358: invokevirtual 278	java/io/InputStream:close	()V
    //   361: aload_2
    //   362: athrow
    //   363: ldc 181
    //   365: new 259	java/lang/StringBuilder
    //   368: dup
    //   369: ldc_w 305
    //   372: invokespecial 262	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   375: iload_0
    //   376: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 288	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: invokestatic 311	com/tencent/xweb/util/e:cTt	()V
    //   388: aload_1
    //   389: areturn
    //   390: astore_1
    //   391: goto -30 -> 361
    //   394: astore_2
    //   395: aconst_null
    //   396: astore 4
    //   398: goto -63 -> 335
    //   401: astore_2
    //   402: aload 5
    //   404: astore_3
    //   405: goto -70 -> 335
    //   408: astore 6
    //   410: aconst_null
    //   411: astore_3
    //   412: aconst_null
    //   413: astore_2
    //   414: goto -259 -> 155
    //   417: astore 6
    //   419: aconst_null
    //   420: astore_2
    //   421: goto -266 -> 155
    //   424: aconst_null
    //   425: astore_1
    //   426: goto -213 -> 213
    //   429: iconst_m1
    //   430: istore_0
    //   431: aconst_null
    //   432: astore_1
    //   433: goto -370 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	409	0	i	int
    //   5	213	1	localObject1	Object
    //   239	14	1	localFileNotFoundException	java.io.FileNotFoundException
    //   266	47	1	localObject2	Object
    //   316	1	1	localException1	java.lang.Exception
    //   319	1	1	localObject3	Object
    //   323	1	1	localException2	java.lang.Exception
    //   325	64	1	str1	String
    //   390	1	1	localException3	java.lang.Exception
    //   425	8	1	localObject4	Object
    //   39	260	2	localObject5	Object
    //   329	33	2	localObject6	Object
    //   394	1	2	localObject7	Object
    //   401	1	2	localObject8	Object
    //   413	8	2	localObject9	Object
    //   77	335	3	localObject10	Object
    //   91	306	4	localObject11	Object
    //   88	315	5	localObject12	Object
    //   102	40	6	localStringBuffer	java.lang.StringBuffer
    //   153	135	6	localIOException1	java.io.IOException
    //   292	26	6	str2	String
    //   408	1	6	localIOException2	java.io.IOException
    //   417	1	6	localIOException3	java.io.IOException
    //   114	16	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   93	104	153	java/io/IOException
    //   110	116	153	java/io/IOException
    //   127	135	153	java/io/IOException
    //   141	150	153	java/io/IOException
    //   287	294	153	java/io/IOException
    //   54	63	239	java/io/FileNotFoundException
    //   294	302	316	java/lang/Exception
    //   306	310	316	java/lang/Exception
    //   191	195	323	java/lang/Exception
    //   199	203	323	java/lang/Exception
    //   207	211	323	java/lang/Exception
    //   67	78	329	finally
    //   339	343	390	java/lang/Exception
    //   348	353	390	java/lang/Exception
    //   357	361	390	java/lang/Exception
    //   78	87	394	finally
    //   93	104	401	finally
    //   110	116	401	finally
    //   127	135	401	finally
    //   141	150	401	finally
    //   161	187	401	finally
    //   287	294	401	finally
    //   67	78	408	java/io/IOException
    //   78	87	417	java/io/IOException
  }
  
  private SurfaceView eu(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return (SurfaceView)paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        SurfaceView localSurfaceView = eu(paramView.getChildAt(i));
        if (localSurfaceView != null) {
          return localSurfaceView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private static String n(double paramDouble1, double paramDouble2)
  {
    String str1 = String.format("%02d", new Object[] { Integer.valueOf((int)(paramDouble1 / 3600.0D)) });
    String str2 = String.format("%02d", new Object[] { Integer.valueOf((int)(paramDouble1 % 3600.0D) / 60) });
    String str3 = String.format("%02d", new Object[] { Integer.valueOf((int)(paramDouble1 % 3600.0D) % 60) });
    if (paramDouble2 > 3600.0D) {
      return String.format("%s:%s:%s", new Object[] { str1, str2, str3 });
    }
    return String.format("%s:%s", new Object[] { str2, str3 });
  }
  
  private void ot(boolean paramBoolean)
  {
    al(new d.2(this, paramBoolean));
  }
  
  private void ou(boolean paramBoolean)
  {
    Activity localActivity = cSy();
    if (localActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      if ((localActivity.getWindow().getAttributes().flags & 0x800) != 0)
      {
        this.xiC = true;
        localActivity.getWindow().clearFlags(2048);
        label46:
        if (this.xiD) {
          break label87;
        }
        if ((localActivity.getWindow().getAttributes().flags & 0x400) == 0) {
          break label89;
        }
        this.xiB = true;
      }
      for (;;)
      {
        this.xiD = true;
        return;
        this.xiC = false;
        break label46;
        label87:
        break;
        label89:
        this.xiB = false;
        localActivity.getWindow().addFlags(1024);
      }
    }
    if (this.xiC) {
      localActivity.getWindow().addFlags(2048);
    }
    if (!this.xiB) {
      localActivity.getWindow().clearFlags(1024);
    }
    this.xiE = 0;
    this.xiD = false;
    this.xie = false;
  }
  
  private void reset()
  {
    if (this.dzw == null) {
      this.dzw = ((AudioManager)this.vWc.getContext().getSystemService("audio"));
    }
    this.xio = this.dzw.getStreamMaxVolume(3);
    this.xip = this.dzw.getStreamVolume(3);
    if (this.xis == null) {
      this.xis = new a(this.vWc.getContext());
    }
    if (this.Nk == null)
    {
      Activity localActivity = cSy();
      if (localActivity != null) {
        this.Nk = localActivity.getWindow();
      }
    }
    if ((this.Nk != null) && (this.anh == null)) {
      this.anh = this.Nk.getAttributes();
    }
    if (this.anh != null)
    {
      this.mBrightness = this.anh.screenBrightness;
      if (this.mBrightness != -1.0F) {}
    }
    try
    {
      this.mBrightness = ((float)(Settings.System.getInt(this.vWc.getContext().getContentResolver(), "screen_brightness") / 256.0D));
      return;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      Log.e("XWebNativeInterface", "brightness get error:" + localSettingNotFoundException.getMessage());
    }
  }
  
  public final void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.vWc != null) && (paramBoolean2) && (this.xit != null))
    {
      Log.i("XWebNativeInterface", "evaluteJavascript:" + paramBoolean1);
      String str = this.xit;
      if (paramBoolean1)
      {
        str = this.xit;
        str = "window.addEventListener('DOMContentLoaded', function() {" + str + "});this.xwebReturn = function (){return \"1\";};this.xwebReturn()";
      }
      this.vWc.evaluateJavascript(str, new d.17(this));
    }
  }
  
  public final void cSA()
  {
    if (this.xiu != null)
    {
      this.xiu.cancel();
      this.xiu.purge();
      this.xiu = null;
    }
    this.xiu = new Timer();
    this.xiu.schedule(new d.18(this), 4000L);
  }
  
  public final void cSB()
  {
    if (this.xiu != null)
    {
      this.xiu.cancel();
      this.xiu.purge();
      this.xiu = null;
    }
  }
  
  public final void cSC()
  {
    al(new d.19(this));
  }
  
  public final void cSD()
  {
    al(new d.20(this));
  }
  
  public final void cv(Object paramObject)
  {
    new ReflectMethod(paramObject, "addJavascriptInterface", new Class[] { Object.class, String.class }).invoke(new Object[] { this, "xwebToNative" });
  }
  
  public final void e(double paramDouble, boolean paramBoolean)
  {
    al(new d.3(this, paramBoolean, paramDouble));
  }
  
  public final void gq(int paramInt1, int paramInt2)
  {
    Object localObject = cSy();
    if (localObject == null) {}
    int i;
    do
    {
      return;
      if ((this.xin == -3) && (localObject != null)) {
        this.xin = ((Activity)localObject).getRequestedOrientation();
      }
      if (paramInt1 > paramInt2) {
        break;
      }
      ((Activity)localObject).setRequestedOrientation(1);
      i = 1;
      this.fOo = i;
    } while (this.xhQ == null);
    localObject = this.xhQ;
    Display localDisplay = ((WindowManager)this.vWc.getContext().getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point(0, 0);
    localDisplay.getSize(localPoint);
    int j;
    label144:
    double d1;
    if (i == 0)
    {
      j = Math.max(localPoint.x, localPoint.y);
      i = Math.min(localPoint.x, localPoint.y);
      d1 = paramInt1 * 1.0D / paramInt2;
      if (d1 < j * 1.0D / i) {
        break label244;
      }
      double d2 = j;
      i = (int)(1.0D / d1 * d2);
    }
    for (;;)
    {
      ((View)localObject).setLayoutParams(new FrameLayout.LayoutParams(j, i, 17));
      return;
      ((Activity)localObject).setRequestedOrientation(0);
      i = 0;
      break;
      i = Math.max(localPoint.x, localPoint.y);
      j = Math.min(localPoint.x, localPoint.y);
      break label144;
      label244:
      j = (int)(d1 * i);
    }
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return this.xiD;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    this.xiw = 0;
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onHideCustomView()
  {
    if (this.xic != null) {
      this.xic.onCustomViewHidden();
    }
    Log.i("XWebNativeInterface", "detach");
    if (!this.xiD) {
      Log.i("XWebNativeInterface", "detach has exited fullscreen");
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = cSy();
    } while (localActivity == null);
    if (this.xiz != null)
    {
      if ((this.xiz instanceof ColorDrawable)) {
        this.vWc.getWebViewUI().setBackgroundColor(((ColorDrawable)this.xiz).getColor());
      }
      this.xiz = null;
      label91:
      if (this.xiA == null) {
        break label275;
      }
      this.vWc.setBackground(this.xiA);
    }
    for (;;)
    {
      ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
      if (this.rbC.getParent() != localViewGroup) {
        break;
      }
      if (this.vWc.isXWalkKernel())
      {
        this.rbC.removeView(this.vWc);
        this.xhO.addView(this.vWc, 0);
      }
      if (this.xhQ != null) {
        this.rbC.removeView(this.xhQ);
      }
      this.rbC.removeView(this.xhR);
      this.xhR.setVisibility(8);
      if (this.xin != -3)
      {
        localActivity.setRequestedOrientation(this.xin);
        this.xin = -3;
      }
      ou(false);
      if (!(this.rbC.getParent() instanceof ViewGroup)) {
        break;
      }
      ((ViewGroup)this.rbC.getParent()).removeView(this.rbC);
      return;
      this.vWc.getWebViewUI().setBackgroundColor(0);
      break label91;
      label275:
      this.vWc.setBackgroundColor(0);
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.mMode == 1) && (this.xhQ != null))
    {
      float f = paramScaleGestureDetector.getScaleFactor();
      this.xhQ.getLeft();
      this.xhQ.getTop();
      this.xhQ.getBottom();
      this.xhQ.getRight();
      int i = (int)(this.xhQ.getWidth() * f);
      int j = (int)(f * this.xhQ.getHeight());
      paramScaleGestureDetector = new FrameLayout.LayoutParams(-2, -2, 17);
      paramScaleGestureDetector.width = i;
      paramScaleGestureDetector.height = j;
      if (this.xhQ != null) {
        this.xhQ.setLayoutParams(paramScaleGestureDetector);
      }
      return true;
    }
    return false;
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return true;
    }
    float f1 = paramMotionEvent2.getX();
    float f2 = paramMotionEvent1.getX();
    float f3 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
    if (this.xhR.getHeight() > this.xhR.getWidth())
    {
      paramFloat2 = this.xhR.getWidth();
      paramFloat1 = this.xhR.getHeight();
    }
    double d1;
    switch (this.xiw)
    {
    default: 
    case 0: 
      for (;;)
      {
        return true;
        paramFloat2 = this.xhR.getHeight();
        paramFloat1 = this.xhR.getWidth();
        break;
        if (Math.abs(f1 - f2) - Math.abs(f3) > 1.0F)
        {
          this.xiw = 3;
        }
        else
        {
          reset();
          d1 = Math.ceil(25.0F * this.vWc.getContext().getResources().getDisplayMetrics().density);
          if ((paramMotionEvent1.getY() < 2.0D * d1) || (paramMotionEvent1.getY() > this.xhR.getHeight() - d1 * 2.0D)) {
            this.xiw = 0;
          } else if (paramMotionEvent1.getX() < this.xhR.getWidth() / 2.0F) {
            this.xiw = 2;
          } else {
            this.xiw = 1;
          }
        }
      }
    case 1: 
      paramFloat1 = f3 * -1.0F;
      d1 = this.xio * paramFloat1 / paramFloat2 * 1.2F;
      int j = (int)d1;
      int i = j;
      if (j == 0)
      {
        i = j;
        if (Math.abs(d1) > 0.2000000029802322D)
        {
          if (paramFloat1 <= 0.0F) {
            break label414;
          }
          i = 1;
        }
      }
      d1 = this.xip;
      double d2 = i + d1;
      if (d2 > this.xio) {
        d1 = this.xio;
      }
      for (;;)
      {
        this.dzw.setStreamVolume(3, (int)d1, 4);
        i = (int)(d1 / Float.valueOf(this.xio).floatValue() * 100.0D);
        this.xhS.setVolumnProgress(i);
        this.xhS.show();
        break;
        i = j;
        if (paramFloat1 >= 0.0F) {
          break label329;
        }
        i = -1;
        break label329;
        d1 = d2;
        if (d2 < 0.0D) {
          d1 = 0.0D;
        }
      }
    case 2: 
      label329:
      paramFloat2 = -1.0F * f3 / paramFloat2 * 1.2F + this.mBrightness;
      label414:
      if (paramFloat2 < 0.0F) {
        paramFloat1 = 0.0F;
      }
      for (;;)
      {
        this.anh.screenBrightness = paramFloat1;
        this.Nk.setAttributes(this.anh);
        this.xhS.setBrightProgress((int)(paramFloat1 * 100.0F));
        this.xhS.show();
        break;
        paramFloat1 = paramFloat2;
        if (paramFloat2 > 1.0F) {
          paramFloat1 = 1.0F;
        }
      }
    }
    paramFloat2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    this.xir = this.xib.St;
    if (paramFloat2 > 0.0F)
    {
      f1 = this.xir;
      this.xiq = ((int)(paramFloat2 / paramFloat1 * 100.0F + f1));
      if (this.xiq > 100.0F) {
        this.xiq = 100.0F;
      }
    }
    for (;;)
    {
      d1 = this.xig * this.xiq / 100.0D;
      this.xhS.setVideoTimeProgress(n(d1, this.xig) + "/" + n(this.xig, this.xig));
      this.xhS.show();
      this.xix = d1;
      break;
      f1 = this.xir;
      this.xiq = ((int)(paramFloat2 / paramFloat1 * 100.0F + f1));
      if (this.xiq < 0.0F) {
        this.xiq = 0.0F;
      }
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    Log.i("XWebNativeInterface", "onShowCustomView");
    this.xhQ = paramView;
    this.xic = paramCustomViewCallback;
    if ((this.xhQ != null) || (this.vWc.isXWalkKernel()))
    {
      if (!this.vWc.isXWalkKernel()) {
        break label80;
      }
      e.cSR();
      Log.i("XWebNativeInterface", "attach");
      if (!this.xiD) {
        break label96;
      }
      Log.i("XWebNativeInterface", "attach has entered fullscreen");
    }
    for (;;)
    {
      this.vWc.requestFocus();
      return;
      label80:
      if (!this.vWc.isSysKernel()) {
        break;
      }
      e.cSV();
      break;
      label96:
      paramView = cSy();
      if (paramView != null)
      {
        reset();
        ou(true);
        paramView = (FrameLayout)paramView.getWindow().getDecorView();
        if ((this.vWc.isXWalkKernel()) && (this.rbC.getParent() == paramView) && (this.xhQ != null))
        {
          this.rbC.addView(this.xhQ, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        else if (this.rbC.getParent() != paramView)
        {
          paramView.addView(this.rbC, new FrameLayout.LayoutParams(-1, -1, 17));
          if (this.xhQ != null)
          {
            this.rbC.addView(this.xhQ, this.rbC.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
            if (this.vWc.isSysKernel()) {
              this.xhQ.setVisibility(4);
            }
          }
          if (this.vWc.isSysKernel())
          {
            paramView = eu(this.xhQ);
            if (paramView != null) {
              paramView.setZOrderMediaOverlay(true);
            }
          }
          if (this.vWc.isXWalkKernel())
          {
            this.xhO = ((ViewGroup)this.vWc.getParent());
            this.xhO.removeView(this.vWc);
            this.rbC.addView(this.vWc, this.rbC.getChildCount());
          }
          this.rbC.addView(this.xhR, this.rbC.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
          this.xiz = this.vWc.getWebViewUI().getBackground();
          this.vWc.getWebViewUI().setBackgroundColor(-16777216);
          this.xiA = this.vWc.getBackground();
          this.vWc.setBackgroundColor(-16777216);
          if (this.vWc.isSysKernel()) {
            this.rbC.postDelayed(new d.13(this), this.xiy);
          }
        }
      }
    }
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    cSB();
    if (this.xiv) {
      cSD();
    }
    for (;;)
    {
      return true;
      cSC();
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onSpecialVideoEnterFullscreen(int paramInt)
  {
    Log.i("XWebNativeInterface", "onSpecialVideoEnterFullscreen:" + paramInt);
    e.ax(paramInt, this.vWc.isXWalkKernel());
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onSpecialVideoHook(int paramInt)
  {
    Log.i("XWebNativeInterface", "onSpecialVideoHook:" + paramInt);
    e.ay(paramInt, this.vWc.isXWalkKernel());
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
  {
    Log.i("XWebNativeInterface", "onVideoEnterFullscreen:isVideoTag:" + paramBoolean1 + ",width:" + paramDouble1 + ",height:" + paramDouble2 + ",pause:" + paramBoolean2 + ",seeking:" + paramBoolean3 + ",currentTime:" + paramDouble3 + ",duration:" + paramDouble4);
    if (this.vWc.isXWalkKernel())
    {
      e.cSS();
      if (paramBoolean1)
      {
        if (!this.vWc.isXWalkKernel()) {
          break label205;
        }
        e.cST();
        label118:
        this.xie = true;
      }
      this.xif = paramLong;
      this.xig = paramDouble4;
      this.xih = paramDouble1;
      this.xii = paramDouble2;
      if (!paramBoolean3) {
        break label221;
      }
      onVideoSeeking();
    }
    for (;;)
    {
      al(new d.9(this, paramBoolean1, paramDouble1, paramDouble2));
      onVideoTimeUpdate(paramDouble3, paramDouble4, paramArrayOfDouble);
      ot(paramBoolean2);
      return;
      if (!this.vWc.isSysKernel()) {
        break;
      }
      e.cSW();
      break;
      label205:
      if (!this.vWc.isSysKernel()) {
        break label118;
      }
      e.cSX();
      break label118;
      label221:
      onVideoSeeked();
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoExitFullscreen()
  {
    Log.i("XWebNativeInterface", "onVideoExitFullscreen");
    this.xie = false;
    al(new d.10(this));
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoGetFrame(long paramLong, double paramDouble, String paramString)
  {
    if ((paramLong == this.xif) && (this.xix == paramDouble) && (paramString != null) && (paramString.startsWith("data:image/png;base64,")))
    {
      paramString = Base64.decode(paramString.substring(22), 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      this.xhY.setImageBitmap(paramString);
      this.xhY.setVisibility(0);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPause()
  {
    Log.i("XWebNativeInterface", "onVideoPause");
    ot(true);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPlay()
  {
    Log.i("XWebNativeInterface", "onVideoPlay");
    ot(false);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPlaying()
  {
    Log.i("XWebNativeInterface", "onVideoPlaying");
    al(new d.5(this));
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoSeeked()
  {
    Log.i("XWebNativeInterface", "onVideoSeeked");
    al(new d.8(this));
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoSeeking()
  {
    Log.i("XWebNativeInterface", "onVideoSeeking");
    al(new d.7(this));
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoSizeUpdate(double paramDouble1, double paramDouble2)
  {
    if ((this.xii != paramDouble2) || (this.xih != paramDouble1))
    {
      this.xih = paramDouble1;
      this.xii = paramDouble2;
      Log.i("XWebNativeInterface", "onVideoSizeUpdate width:" + paramDouble1 + ", height:" + paramDouble2);
      al(new d.11(this, paramDouble1, paramDouble2));
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoTimeUpdate(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble)
  {
    this.xig = paramDouble2;
    e(paramDouble1, true);
    al(new d.4(this, paramDouble2, paramArrayOfDouble));
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoWaiting()
  {
    Log.i("XWebNativeInterface", "onVideoWaiting");
    al(new d.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d
 * JD-Core Version:    0.7.0.1
 */