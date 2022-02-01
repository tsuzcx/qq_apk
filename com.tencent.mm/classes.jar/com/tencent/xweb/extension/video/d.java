package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
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
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.u;
import com.tencent.xweb.util.g;
import com.tencent.xweb.v;
import java.util.Timer;
import java.util.TimerTask;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;

public final class d
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, b, u
{
  WebView DXF;
  private int EGr = -3;
  ScaleGestureDetector LMc;
  ImageView MOA;
  c MOB;
  private WebChromeClient.CustomViewCallback MOC;
  private boolean MOD;
  private long MOE;
  private double MOF;
  private double MOG;
  private final int MOH = 0;
  private final int MOI = 1;
  private final int MOJ = 2;
  private final int MOK = 3;
  private boolean MOL = false;
  private v MOM;
  private int MON = 0;
  private double MOO = 0.0D;
  private float MOP = 0.0F;
  private float MOQ = 0.0F;
  private a MOR;
  String MOS;
  private Timer MOT;
  private boolean MOU;
  private int MOV = 0;
  private double MOW;
  private int MOX = 200;
  private Drawable MOY;
  private boolean MOZ;
  private ViewGroup MOo;
  SurfaceView MOp;
  private View MOq;
  ViewGroup MOr;
  VideoStatusLayout MOs;
  ProgressBar MOt;
  TextView MOu;
  TextView MOv;
  ClickableFrameLayout MOw;
  LinearLayout MOx;
  ImageView MOy;
  ImageView MOz;
  private boolean MPa;
  private boolean MPb = false;
  private int MPc;
  GestureDetector PC;
  private Window WM;
  private WindowManager.LayoutParams azK;
  private double lDw;
  Activity mActivity;
  private AudioManager mAudioManager;
  private float mBrightness = 1.0F;
  private int mCurrentOrientation;
  private int mMode = 0;
  FrameLayout mRootView;
  
  private void as(Runnable paramRunnable)
  {
    AppMethodBeat.i(153601);
    if (this.MOL)
    {
      AppMethodBeat.o(153601);
      return;
    }
    Activity localActivity = gfS();
    if (localActivity != null)
    {
      localActivity.runOnUiThread(paramRunnable);
      AppMethodBeat.o(153601);
      return;
    }
    this.DXF.getView().post(paramRunnable);
    AppMethodBeat.o(153601);
  }
  
  private Activity gfS()
  {
    AppMethodBeat.i(153593);
    if (this.mActivity != null)
    {
      localObject = this.mActivity;
      AppMethodBeat.o(153593);
      return localObject;
    }
    Object localObject = this.DXF.getContext();
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
      AppMethodBeat.o(153593);
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
  public static String gfT()
  {
    // Byte code:
    //   0: ldc_w 275
    //   3: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 277
    //   9: invokestatic 283	com/tencent/xweb/xwalk/a/g:bcp	(Ljava/lang/String;)Lcom/tencent/xweb/xwalk/a/f;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +436 -> 450
    //   17: aload_1
    //   18: getfield 288	com/tencent/xweb/xwalk/a/f:MUN	I
    //   21: iconst_m1
    //   22: if_icmpeq +428 -> 450
    //   25: aload_1
    //   26: getfield 288	com/tencent/xweb/xwalk/a/f:MUN	I
    //   29: istore_0
    //   30: new 290	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: aload_1
    //   36: getfield 288	com/tencent/xweb/xwalk/a/f:MUN	I
    //   39: iconst_0
    //   40: invokevirtual 294	com/tencent/xweb/xwalk/a/f:bz	(IZ)Ljava/lang/String;
    //   43: invokespecial 297	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 301	java/io/File:isFile	()Z
    //   51: ifeq +239 -> 290
    //   54: aload_2
    //   55: invokevirtual 304	java/io/File:exists	()Z
    //   58: ifeq +232 -> 290
    //   61: new 306	java/io/FileInputStream
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 309	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +374 -> 445
    //   74: new 311	java/io/InputStreamReader
    //   77: dup
    //   78: aload_1
    //   79: ldc_w 313
    //   82: invokespecial 316	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   85: astore_3
    //   86: new 318	java/io/BufferedReader
    //   89: dup
    //   90: aload_3
    //   91: invokespecial 321	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   94: astore_2
    //   95: aload_3
    //   96: astore 5
    //   98: aload_2
    //   99: astore 4
    //   101: new 323	java/lang/StringBuffer
    //   104: dup
    //   105: ldc_w 325
    //   108: invokespecial 326	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   111: astore 6
    //   113: aload_3
    //   114: astore 5
    //   116: aload_2
    //   117: astore 4
    //   119: aload_2
    //   120: invokevirtual 329	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   123: astore 7
    //   125: aload 7
    //   127: ifnull +174 -> 301
    //   130: aload_3
    //   131: astore 5
    //   133: aload_2
    //   134: astore 4
    //   136: aload 6
    //   138: aload 7
    //   140: invokevirtual 333	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   143: pop
    //   144: aload_3
    //   145: astore 5
    //   147: aload_2
    //   148: astore 4
    //   150: aload 6
    //   152: ldc_w 335
    //   155: invokevirtual 333	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   158: pop
    //   159: goto -46 -> 113
    //   162: astore 6
    //   164: aload_3
    //   165: astore 5
    //   167: aload_2
    //   168: astore 4
    //   170: ldc_w 259
    //   173: new 337	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 339
    //   180: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload 6
    //   185: invokevirtual 343	java/io/IOException:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 266	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 352	java/io/InputStreamReader:close	()V
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 353	java/io/BufferedReader:close	()V
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 356	java/io/InputStream:close	()V
    //   221: aconst_null
    //   222: astore_1
    //   223: aload_1
    //   224: ifnull +10 -> 234
    //   227: aload_1
    //   228: invokevirtual 361	java/lang/String:isEmpty	()Z
    //   231: ifeq +158 -> 389
    //   234: ldc_w 259
    //   237: ldc_w 363
    //   240: invokestatic 365	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: ldc_w 367
    //   246: astore_1
    //   247: invokestatic 372	com/tencent/xweb/util/g:ghj	()V
    //   250: ldc_w 275
    //   253: invokestatic 204	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_1
    //   257: areturn
    //   258: astore_1
    //   259: ldc_w 259
    //   262: new 337	java/lang/StringBuilder
    //   265: dup
    //   266: ldc_w 374
    //   269: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: aload_1
    //   273: invokevirtual 375	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   276: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 266	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aconst_null
    //   286: astore_1
    //   287: goto -217 -> 70
    //   290: aload_1
    //   291: iconst_m1
    //   292: invokevirtual 379	com/tencent/xweb/xwalk/a/f:ajt	(I)Z
    //   295: pop
    //   296: aconst_null
    //   297: astore_1
    //   298: goto -228 -> 70
    //   301: aload_3
    //   302: astore 5
    //   304: aload_2
    //   305: astore 4
    //   307: aload 6
    //   309: invokevirtual 380	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   312: astore 6
    //   314: aload_3
    //   315: invokevirtual 352	java/io/InputStreamReader:close	()V
    //   318: aload_2
    //   319: invokevirtual 353	java/io/BufferedReader:close	()V
    //   322: aload_1
    //   323: ifnull +7 -> 330
    //   326: aload_1
    //   327: invokevirtual 356	java/io/InputStream:close	()V
    //   330: aload 6
    //   332: astore_1
    //   333: goto -110 -> 223
    //   336: astore_1
    //   337: aload 6
    //   339: astore_1
    //   340: goto -117 -> 223
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_1
    //   346: goto -123 -> 223
    //   349: astore_2
    //   350: aconst_null
    //   351: astore_3
    //   352: aconst_null
    //   353: astore 4
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 352	java/io/InputStreamReader:close	()V
    //   363: aload 4
    //   365: ifnull +8 -> 373
    //   368: aload 4
    //   370: invokevirtual 353	java/io/BufferedReader:close	()V
    //   373: aload_1
    //   374: ifnull +7 -> 381
    //   377: aload_1
    //   378: invokevirtual 356	java/io/InputStream:close	()V
    //   381: ldc_w 275
    //   384: invokestatic 204	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   387: aload_2
    //   388: athrow
    //   389: ldc_w 259
    //   392: ldc_w 382
    //   395: iload_0
    //   396: invokestatic 386	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   399: invokevirtual 390	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   402: invokestatic 365	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: invokestatic 393	com/tencent/xweb/util/g:ghi	()V
    //   408: goto -158 -> 250
    //   411: astore_1
    //   412: goto -31 -> 381
    //   415: astore_2
    //   416: aconst_null
    //   417: astore 4
    //   419: goto -64 -> 355
    //   422: astore_2
    //   423: aload 5
    //   425: astore_3
    //   426: goto -71 -> 355
    //   429: astore 6
    //   431: aconst_null
    //   432: astore_3
    //   433: aconst_null
    //   434: astore_2
    //   435: goto -271 -> 164
    //   438: astore 6
    //   440: aconst_null
    //   441: astore_2
    //   442: goto -278 -> 164
    //   445: aconst_null
    //   446: astore_1
    //   447: goto -224 -> 223
    //   450: iconst_m1
    //   451: istore_0
    //   452: aconst_null
    //   453: astore_1
    //   454: goto -384 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	423	0	i	int
    //   12	245	1	localObject1	Object
    //   258	15	1	localFileNotFoundException	java.io.FileNotFoundException
    //   286	47	1	localObject2	Object
    //   336	1	1	localException1	java.lang.Exception
    //   339	1	1	localObject3	Object
    //   343	1	1	localException2	java.lang.Exception
    //   345	33	1	localObject4	Object
    //   411	1	1	localException3	java.lang.Exception
    //   446	8	1	localObject5	Object
    //   46	273	2	localObject6	Object
    //   349	39	2	localObject7	Object
    //   415	1	2	localObject8	Object
    //   422	1	2	localObject9	Object
    //   434	8	2	localObject10	Object
    //   85	348	3	localObject11	Object
    //   99	319	4	localObject12	Object
    //   96	328	5	localObject13	Object
    //   111	40	6	localStringBuffer	java.lang.StringBuffer
    //   162	146	6	localIOException1	java.io.IOException
    //   312	26	6	str1	String
    //   429	1	6	localIOException2	java.io.IOException
    //   438	1	6	localIOException3	java.io.IOException
    //   123	16	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   101	113	162	java/io/IOException
    //   119	125	162	java/io/IOException
    //   136	144	162	java/io/IOException
    //   150	159	162	java/io/IOException
    //   307	314	162	java/io/IOException
    //   61	70	258	java/io/FileNotFoundException
    //   314	322	336	java/lang/Exception
    //   326	330	336	java/lang/Exception
    //   201	205	343	java/lang/Exception
    //   209	213	343	java/lang/Exception
    //   217	221	343	java/lang/Exception
    //   74	86	349	finally
    //   359	363	411	java/lang/Exception
    //   368	373	411	java/lang/Exception
    //   377	381	411	java/lang/Exception
    //   86	95	415	finally
    //   101	113	422	finally
    //   119	125	422	finally
    //   136	144	422	finally
    //   150	159	422	finally
    //   170	197	422	finally
    //   307	314	422	finally
    //   74	86	429	java/io/IOException
    //   86	95	438	java/io/IOException
  }
  
  private SurfaceView hx(View paramView)
  {
    AppMethodBeat.i(153631);
    if ((paramView instanceof SurfaceView))
    {
      paramView = (SurfaceView)paramView;
      AppMethodBeat.o(153631);
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        SurfaceView localSurfaceView = hx(paramView.getChildAt(i));
        if (localSurfaceView != null)
        {
          AppMethodBeat.o(153631);
          return localSurfaceView;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(153631);
    return null;
  }
  
  private static String q(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(153611);
    String str1 = String.format("%02d", new Object[] { Integer.valueOf((int)(paramDouble1 / 3600.0D)) });
    String str2 = String.format("%02d", new Object[] { Integer.valueOf((int)(paramDouble1 % 3600.0D) / 60) });
    String str3 = String.format("%02d", new Object[] { Integer.valueOf((int)(paramDouble1 % 3600.0D) % 60) });
    if (paramDouble2 > 3600.0D) {}
    for (str1 = String.format("%s:%s:%s", new Object[] { str1, str2, str3 });; str1 = String.format("%s:%s", new Object[] { str2, str3 }))
    {
      AppMethodBeat.o(153611);
      return str1;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(153597);
    if (this.mAudioManager == null) {
      this.mAudioManager = ((AudioManager)this.DXF.getContext().getSystemService("audio"));
    }
    this.MON = this.mAudioManager.getStreamMaxVolume(3);
    this.MOO = this.mAudioManager.getStreamVolume(3);
    if (this.MOR == null) {
      this.MOR = new a(this.DXF.getContext());
    }
    if (this.WM == null)
    {
      Activity localActivity = gfS();
      if (localActivity != null) {
        this.WM = localActivity.getWindow();
      }
    }
    if ((this.WM != null) && (this.azK == null)) {
      this.azK = this.WM.getAttributes();
    }
    if (this.azK != null)
    {
      this.mBrightness = this.azK.screenBrightness;
      if (this.mBrightness == -1.0F) {
        try
        {
          this.mBrightness = ((float)(Settings.System.getInt(this.DXF.getContext().getContentResolver(), "screen_brightness") / 256.0D));
          AppMethodBeat.o(153597);
          return;
        }
        catch (Settings.SettingNotFoundException localSettingNotFoundException)
        {
          Log.e("XWebNativeInterface", "brightness get error:" + localSettingNotFoundException.getMessage());
        }
      }
    }
    AppMethodBeat.o(153597);
  }
  
  private void u(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(207520);
    if ((this.MOM != null) && (this.MOM.tL(paramInt)))
    {
      Log.i("XWebNativeInterface", "setRequestedOrientation by wechat client");
      AppMethodBeat.o(207520);
      return;
    }
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(paramInt);
    }
    AppMethodBeat.o(207520);
  }
  
  private void zX(final boolean paramBoolean)
  {
    AppMethodBeat.i(153609);
    as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153573);
        if (paramBoolean)
        {
          d.k(d.this).setImageResource(2131234818);
          AppMethodBeat.o(153573);
          return;
        }
        d.k(d.this).setImageResource(2131234820);
        AppMethodBeat.o(153573);
      }
    });
    AppMethodBeat.o(153609);
  }
  
  private void zY(boolean paramBoolean)
  {
    AppMethodBeat.i(153632);
    Activity localActivity = gfS();
    if (localActivity == null)
    {
      AppMethodBeat.o(153632);
      return;
    }
    if (paramBoolean)
    {
      if ((localActivity.getWindow().getAttributes().flags & 0x800) != 0)
      {
        this.MPa = true;
        localActivity.getWindow().clearFlags(2048);
        if (this.MPb) {
          break label174;
        }
        if ((localActivity.getWindow().getAttributes().flags & 0x400) == 0) {
          break label107;
        }
        this.MOZ = true;
      }
      for (;;)
      {
        this.MPb = true;
        AppMethodBeat.o(153632);
        return;
        this.MPa = false;
        break;
        label107:
        this.MOZ = false;
        localActivity.getWindow().addFlags(1024);
      }
    }
    else
    {
      if (this.MPa) {
        localActivity.getWindow().addFlags(2048);
      }
      if (!this.MOZ) {
        localActivity.getWindow().clearFlags(1024);
      }
      this.MPc = 0;
      this.MPb = false;
      this.MOD = false;
    }
    label174:
    AppMethodBeat.o(153632);
  }
  
  public final void G(double paramDouble)
  {
    AppMethodBeat.i(153614);
    this.DXF.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[] { Double.valueOf(paramDouble) }), new ValueCallback() {});
    AppMethodBeat.o(153614);
  }
  
  public final void ba(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(153595);
    if ((this.DXF != null) && (paramBoolean2) && (this.MOS != null))
    {
      Log.i("XWebNativeInterface", "evaluteJavascript:".concat(String.valueOf(paramBoolean1)));
      String str = this.MOS;
      if (paramBoolean1)
      {
        str = this.MOS;
        str = "window.addEventListener('DOMContentLoaded', function() {" + str + "});this.xwebReturn = function (){return \"1\";};this.xwebReturn()";
      }
      this.DXF.evaluateJavascript(str, new ValueCallback() {});
    }
    AppMethodBeat.o(153595);
  }
  
  public final void e(final double paramDouble, final boolean paramBoolean)
  {
    AppMethodBeat.i(153610);
    as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153574);
        if ((paramBoolean) && (d.a(d.this) != 0.0D)) {
          d.l(d.this).e((int)(100.0D * (paramDouble / d.a(d.this))), false);
        }
        d.m(d.this).setText(d.a(d.this, paramDouble));
        d.o(d.this).setText(d.n(d.this));
        AppMethodBeat.o(153574);
      }
    });
    AppMethodBeat.o(153610);
  }
  
  public final void eD(Object paramObject)
  {
    AppMethodBeat.i(153594);
    new ReflectMethod(paramObject, "addJavascriptInterface", new Class[] { Object.class, String.class }).invoke(new Object[] { this, "xwebToNative" });
    AppMethodBeat.o(153594);
  }
  
  public final boolean eE(Object paramObject)
  {
    this.MOM = ((v)paramObject);
    return true;
  }
  
  public final void ewR()
  {
    AppMethodBeat.i(153613);
    this.DXF.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_NewPause();", new Object[0]), new ValueCallback() {});
    AppMethodBeat.o(153613);
  }
  
  public final void gfU()
  {
    AppMethodBeat.i(153602);
    if (this.MOT != null)
    {
      this.MOT.cancel();
      this.MOT.purge();
      this.MOT = null;
    }
    this.MOT = new Timer();
    this.MOT.schedule(new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(153590);
        d.this.gfX();
        AppMethodBeat.o(153590);
      }
    }, 4000L);
    AppMethodBeat.o(153602);
  }
  
  public final void gfV()
  {
    AppMethodBeat.i(153603);
    if (this.MOT != null)
    {
      this.MOT.cancel();
      this.MOT.purge();
      this.MOT = null;
    }
    AppMethodBeat.o(153603);
  }
  
  public final void gfW()
  {
    AppMethodBeat.i(153607);
    as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153591);
        d.a(d.this, true);
        d.j(d.this).setVisibility(0);
        d.this.gfU();
        AppMethodBeat.o(153591);
      }
    });
    AppMethodBeat.o(153607);
  }
  
  public final void gfX()
  {
    AppMethodBeat.i(153608);
    as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153592);
        d.a(d.this, false);
        d.j(d.this).setVisibility(4);
        AppMethodBeat.o(153592);
      }
    });
    AppMethodBeat.o(153608);
  }
  
  public final void gfi()
  {
    AppMethodBeat.i(153612);
    this.DXF.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_NewPlay();", new Object[0]), new ValueCallback() {});
    AppMethodBeat.o(153612);
  }
  
  public final boolean gfj()
  {
    return true;
  }
  
  public final void ln(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153633);
    Object localObject = gfS();
    if (localObject == null)
    {
      AppMethodBeat.o(153633);
      return;
    }
    if ((this.EGr == -3) && (localObject != null)) {
      this.EGr = ((Activity)localObject).getRequestedOrientation();
    }
    int i;
    Point localPoint;
    int j;
    label157:
    double d1;
    if (paramInt1 <= paramInt2)
    {
      u((Activity)localObject, 1);
      i = 1;
      this.mCurrentOrientation = i;
      if (this.MOq != null)
      {
        localObject = this.MOq;
        Display localDisplay = ((WindowManager)this.DXF.getContext().getSystemService("window")).getDefaultDisplay();
        localPoint = new Point(0, 0);
        localDisplay.getSize(localPoint);
        if (i != 0) {
          break label231;
        }
        j = Math.max(localPoint.x, localPoint.y);
        i = Math.min(localPoint.x, localPoint.y);
        d1 = paramInt1 * 1.0D / paramInt2;
        if (d1 < j * 1.0D / i) {
          break label264;
        }
        double d2 = j;
        i = (int)(1.0D / d1 * d2);
      }
    }
    for (;;)
    {
      ((View)localObject).setLayoutParams(new FrameLayout.LayoutParams(j, i, 17));
      AppMethodBeat.o(153633);
      return;
      u((Activity)localObject, 0);
      i = 0;
      break;
      label231:
      i = Math.max(localPoint.x, localPoint.y);
      j = Math.min(localPoint.x, localPoint.y);
      break label157;
      label264:
      j = (int)(d1 * i);
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    this.MOV = 0;
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(153599);
    if (this.MOC != null) {
      this.MOC.onCustomViewHidden();
    }
    Log.i("XWebNativeInterface", "detach");
    if (!this.MPb)
    {
      Log.i("XWebNativeInterface", "detach has exited fullscreen");
      AppMethodBeat.o(153599);
      return;
    }
    Activity localActivity = gfS();
    if (localActivity != null)
    {
      if (this.MOY != null)
      {
        this.DXF.getView().setBackground(this.MOY);
        this.MOY = null;
      }
      for (;;)
      {
        ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
        if (this.mRootView.getParent() == localViewGroup) {
          break;
        }
        AppMethodBeat.o(153599);
        return;
        this.DXF.getView().setBackground(new ColorDrawable(0));
      }
      if (this.DXF.isXWalkKernel())
      {
        this.mRootView.removeView(this.DXF);
        this.MOo.addView(this.DXF, 0);
      }
      if (this.MOq != null) {
        this.mRootView.removeView(this.MOq);
      }
      this.mRootView.removeView(this.MOr);
      this.MOr.setVisibility(8);
      if (this.EGr != -3)
      {
        u(localActivity, this.EGr);
        this.EGr = -3;
      }
      zY(false);
      if ((this.mRootView.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.mRootView.getParent()).removeView(this.mRootView);
      }
    }
    AppMethodBeat.o(153599);
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207519);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(207519);
  }
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(153606);
    if ((this.mMode == 1) && (this.MOq != null))
    {
      float f = paramScaleGestureDetector.getScaleFactor();
      this.MOq.getLeft();
      this.MOq.getTop();
      this.MOq.getBottom();
      this.MOq.getRight();
      int i = (int)(this.MOq.getWidth() * f);
      int j = (int)(f * this.MOq.getHeight());
      paramScaleGestureDetector = new FrameLayout.LayoutParams(-2, -2, 17);
      paramScaleGestureDetector.width = i;
      paramScaleGestureDetector.height = j;
      if (this.MOq != null) {
        this.MOq.setLayoutParams(paramScaleGestureDetector);
      }
      AppMethodBeat.o(153606);
      return true;
    }
    AppMethodBeat.o(153606);
    return false;
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(153605);
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null))
    {
      AppMethodBeat.o(153605);
      return true;
    }
    float f1 = paramMotionEvent2.getX();
    float f2 = paramMotionEvent1.getX();
    float f3 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
    if (this.MOr.getHeight() > this.MOr.getWidth())
    {
      paramFloat2 = this.MOr.getWidth();
      paramFloat1 = this.MOr.getHeight();
    }
    double d1;
    switch (this.MOV)
    {
    default: 
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(153605);
        return true;
        paramFloat2 = this.MOr.getHeight();
        paramFloat1 = this.MOr.getWidth();
        break;
        if (Math.abs(f1 - f2) - Math.abs(f3) > 1.0F)
        {
          this.MOV = 3;
        }
        else
        {
          reset();
          d1 = Math.ceil(25.0F * this.DXF.getContext().getResources().getDisplayMetrics().density);
          if ((paramMotionEvent1.getY() < 2.0D * d1) || (paramMotionEvent1.getY() > this.MOr.getHeight() - d1 * 2.0D)) {
            this.MOV = 0;
          } else if (paramMotionEvent1.getX() < this.MOr.getWidth() / 2.0F) {
            this.MOV = 2;
          } else {
            this.MOV = 1;
          }
        }
      }
    case 1: 
      paramFloat1 = f3 * -1.0F;
      d1 = this.MON * paramFloat1 / paramFloat2 * 1.2F;
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
      d1 = this.MOO;
      double d2 = i + d1;
      if (d2 > this.MON) {
        d1 = this.MON;
      }
      for (;;)
      {
        this.mAudioManager.setStreamVolume(3, (int)d1, 4);
        i = (int)(d1 / this.MON * 100.0D);
        this.MOs.setVolumnProgress(i);
        this.MOs.show();
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
        this.azK.screenBrightness = paramFloat1;
        this.WM.setAttributes(this.azK);
        this.MOs.setBrightProgress((int)(paramFloat1 * 100.0F));
        this.MOs.show();
        break;
        paramFloat1 = paramFloat2;
        if (paramFloat2 > 1.0F) {
          paramFloat1 = 1.0F;
        }
      }
    }
    paramFloat2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    this.MOQ = this.MOB.mProgress;
    if (paramFloat2 > 0.0F)
    {
      f1 = this.MOQ;
      this.MOP = ((int)(paramFloat2 / paramFloat1 * 100.0F + f1));
      if (this.MOP > 100.0F) {
        this.MOP = 100.0F;
      }
    }
    for (;;)
    {
      d1 = this.lDw * this.MOP / 100.0D;
      this.MOs.setVideoTimeProgress(q(d1, this.lDw) + "/" + q(this.lDw, this.lDw));
      this.MOs.show();
      this.MOW = d1;
      break;
      f1 = this.MOQ;
      this.MOP = ((int)(paramFloat2 / paramFloat1 * 100.0F + f1));
      if (this.MOP < 0.0F) {
        this.MOP = 0.0F;
      }
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(153598);
    Log.i("XWebNativeInterface", "onShowCustomView");
    this.MOq = paramView;
    this.MOC = paramCustomViewCallback;
    if ((this.MOq != null) || (this.DXF.isXWalkKernel()))
    {
      if (!this.DXF.isXWalkKernel()) {
        break label95;
      }
      g.ggL();
      Log.i("XWebNativeInterface", "attach");
      if (!this.MPb) {
        break label111;
      }
      Log.i("XWebNativeInterface", "attach has entered fullscreen");
    }
    for (;;)
    {
      this.DXF.requestFocus();
      AppMethodBeat.o(153598);
      return;
      label95:
      if (!this.DXF.isSysKernel()) {
        break;
      }
      g.ggP();
      break;
      label111:
      paramView = gfS();
      if (paramView != null)
      {
        reset();
        zY(true);
        paramView = (FrameLayout)paramView.getWindow().getDecorView();
        if ((this.DXF.isXWalkKernel()) && (this.mRootView.getParent() == paramView) && (this.MOq != null))
        {
          this.mRootView.addView(this.MOq, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        else if (this.mRootView.getParent() != paramView)
        {
          paramView.addView(this.mRootView, new FrameLayout.LayoutParams(-1, -1, 17));
          if (this.MOq != null)
          {
            this.mRootView.addView(this.MOq, this.mRootView.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
            if (this.DXF.isSysKernel()) {
              this.MOq.setVisibility(4);
            }
          }
          if (this.DXF.isSysKernel())
          {
            paramView = hx(this.MOq);
            if (paramView != null) {
              paramView.setZOrderMediaOverlay(true);
            }
          }
          if (this.DXF.isXWalkKernel())
          {
            this.MOo = ((ViewGroup)this.DXF.getParent());
            this.MOo.removeView(this.DXF);
            this.mRootView.addView(this.DXF, this.mRootView.getChildCount());
          }
          this.mRootView.addView(this.MOr, this.mRootView.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
          this.MOY = this.DXF.getView().getBackground();
          if (this.MOY != null) {
            this.MOY = this.MOY.getConstantState().newDrawable().mutate();
          }
          this.DXF.getView().setBackground(new ColorDrawable(-16777216));
          if (this.DXF.isSysKernel()) {
            this.mRootView.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(153585);
                if (d.r(d.this) != null) {
                  d.r(d.this).setVisibility(0);
                }
                AppMethodBeat.o(153585);
              }
            }, this.MOX);
          }
        }
      }
    }
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153604);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    gfV();
    if (this.MOU) {
      gfX();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(153604);
      return true;
      gfW();
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onSpecialVideoEnterFullscreen(int paramInt)
  {
    AppMethodBeat.i(153629);
    Log.i("XWebNativeInterface", "onSpecialVideoEnterFullscreen:".concat(String.valueOf(paramInt)));
    g.bx(paramInt, this.DXF.isXWalkKernel());
    AppMethodBeat.o(153629);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onSpecialVideoHook(int paramInt)
  {
    AppMethodBeat.i(153630);
    Log.i("XWebNativeInterface", "onSpecialVideoHook:".concat(String.valueOf(paramInt)));
    g.by(paramInt, this.DXF.isXWalkKernel());
    AppMethodBeat.o(153630);
  }
  
  @android.webkit.JavascriptInterface
  public final boolean onVideoEmptied()
  {
    AppMethodBeat.i(153623);
    Log.i("XWebNativeInterface", "onVideoEmptied");
    if (this.MOM != null)
    {
      this.MOM.bpR();
      AppMethodBeat.o(153623);
      return true;
    }
    AppMethodBeat.o(153623);
    return false;
  }
  
  @android.webkit.JavascriptInterface
  public final void onVideoEnded()
  {
    AppMethodBeat.i(153622);
    Log.i("XWebNativeInterface", "onVideoEnded");
    if (this.MOM != null) {
      this.MOM.onVideoEnded();
    }
    AppMethodBeat.o(153622);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoEnterFullscreen(final boolean paramBoolean1, long paramLong, final double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(153625);
    Log.i("XWebNativeInterface", "onVideoEnterFullscreen:isVideoTag:" + paramBoolean1 + ",width:" + paramDouble1 + ",height:" + paramDouble2 + ",pause:" + paramBoolean2 + ",seeking:" + paramBoolean3 + ",currentTime:" + paramDouble3 + ",duration:" + paramDouble4);
    if (this.MOM != null) {
      this.MOM.onVideoEnterFullscreen(paramBoolean1, paramLong, paramDouble1, paramDouble2, paramBoolean2, paramBoolean3, paramDouble3, paramDouble4, paramArrayOfDouble);
    }
    if (this.DXF.isXWalkKernel())
    {
      g.ggM();
      if (paramBoolean1)
      {
        if (!this.DXF.isXWalkKernel()) {
          break label250;
        }
        g.ggN();
        label157:
        this.MOD = true;
      }
      this.MOE = paramLong;
      this.lDw = paramDouble4;
      this.MOF = paramDouble1;
      this.MOG = paramDouble2;
      if (!paramBoolean3) {
        break label266;
      }
      onVideoSeeking();
    }
    for (;;)
    {
      as(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153582);
          if (paramBoolean1) {
            d.q(d.this).setVisibility(0);
          }
          d.this.ln((int)paramDouble1, (int)this.MPm);
          AppMethodBeat.o(153582);
        }
      });
      onVideoTimeUpdate(paramDouble3, paramDouble4, paramArrayOfDouble);
      zX(paramBoolean2);
      AppMethodBeat.o(153625);
      return;
      if (!this.DXF.isSysKernel()) {
        break;
      }
      g.ggQ();
      break;
      label250:
      if (!this.DXF.isSysKernel()) {
        break label157;
      }
      g.ggR();
      break label157;
      label266:
      onVideoSeeked();
    }
  }
  
  @android.webkit.JavascriptInterface
  public final void onVideoError(int paramInt, String paramString)
  {
    AppMethodBeat.i(153624);
    Log.i("XWebNativeInterface", "onVideoError");
    if (this.MOM != null) {
      this.MOM.onVideoError(paramInt, paramString);
    }
    AppMethodBeat.o(153624);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoExitFullscreen()
  {
    AppMethodBeat.i(153626);
    Log.i("XWebNativeInterface", "onVideoExitFullscreen");
    if (this.MOM != null) {
      this.MOM.onVideoExitFullscreen();
    }
    this.MOD = false;
    as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153583);
        d.q(d.this).setVisibility(8);
        AppMethodBeat.o(153583);
      }
    });
    AppMethodBeat.o(153626);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoGetFrame(long paramLong, double paramDouble, String paramString)
  {
    AppMethodBeat.i(153615);
    if ((paramLong == this.MOE) && (this.MOW == paramDouble) && (paramString != null) && (paramString.startsWith("data:image/png;base64,")))
    {
      paramString = Base64.decode(paramString.substring(22), 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      this.MOy.setImageBitmap(paramString);
      this.MOy.setVisibility(0);
    }
    AppMethodBeat.o(153615);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPause()
  {
    AppMethodBeat.i(153621);
    Log.i("XWebNativeInterface", "onVideoPause");
    if (this.MOM != null) {
      this.MOM.onVideoPause();
    }
    zX(true);
    AppMethodBeat.o(153621);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPlay()
  {
    AppMethodBeat.i(153620);
    Log.i("XWebNativeInterface", "onVideoPlay");
    if (this.MOM != null) {
      this.MOM.onVideoPlay();
    }
    zX(false);
    AppMethodBeat.o(153620);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPlaying()
  {
    AppMethodBeat.i(153616);
    Log.i("XWebNativeInterface", "onVideoPlaying");
    if (this.MOM != null) {
      this.MOM.onVideoPlaying();
    }
    as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153576);
        d.p(d.this).setVisibility(8);
        AppMethodBeat.o(153576);
      }
    });
    AppMethodBeat.o(153616);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoSeeked()
  {
    AppMethodBeat.i(153619);
    Log.i("XWebNativeInterface", "onVideoSeeked");
    if (this.MOM != null) {
      this.MOM.onVideoSeeked();
    }
    as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153581);
        d.p(d.this).setVisibility(8);
        AppMethodBeat.o(153581);
      }
    });
    AppMethodBeat.o(153619);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoSeeking()
  {
    AppMethodBeat.i(153618);
    Log.i("XWebNativeInterface", "onVideoSeeking");
    if (this.MOM != null) {
      this.MOM.onVideoSeeking();
    }
    as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153580);
        d.p(d.this).setVisibility(0);
        AppMethodBeat.o(153580);
      }
    });
    AppMethodBeat.o(153618);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoSizeUpdate(final double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(153628);
    if (this.MOM != null) {
      this.MOM.onVideoSizeUpdate(paramDouble1, paramDouble2);
    }
    if ((this.MOG != paramDouble2) || (this.MOF != paramDouble1))
    {
      this.MOF = paramDouble1;
      this.MOG = paramDouble2;
      Log.i("XWebNativeInterface", "onVideoSizeUpdate width:" + paramDouble1 + ", height:" + paramDouble2);
      as(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153584);
          d.this.ln((int)paramDouble1, (int)this.MPm);
          AppMethodBeat.o(153584);
        }
      });
    }
    AppMethodBeat.o(153628);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoTimeUpdate(double paramDouble1, final double paramDouble2, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(153627);
    if (this.MOM != null) {
      this.MOM.onVideoTimeUpdate(paramDouble1, paramDouble2, paramArrayOfDouble);
    }
    this.lDw = paramDouble2;
    e(paramDouble1, true);
    as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153575);
        c localc = d.l(d.this);
        double d3 = paramDouble2;
        Object localObject = this.MPi;
        double d1 = 0.0D;
        int i = 0;
        while (i < localObject.length)
        {
          double d2 = d1;
          if (localObject.length > i + 1)
          {
            d2 = d1;
            if (localObject[i] / d3 * 100.0D <= localc.mProgress)
            {
              d2 = d1;
              if (localObject[(i + 1)] / d3 * 100.0D > localc.mProgress) {
                d2 = localObject[(i + 1)] / d3 * 100.0D;
              }
            }
          }
          i += 2;
          d1 = d2;
        }
        localObject = (FrameLayout.LayoutParams)localc.lwj.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = ((int)(d1 / 100.0D * localc.lvS.getWidth()));
        localc.lwj.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localc.lwj.requestLayout();
        AppMethodBeat.o(153575);
      }
    });
    AppMethodBeat.o(153627);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(153617);
    Log.i("XWebNativeInterface", "onVideoWaiting");
    if (this.MOM != null) {
      this.MOM.onVideoWaiting();
    }
    as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153577);
        d.p(d.this).setVisibility(0);
        AppMethodBeat.o(153577);
      }
    });
    AppMethodBeat.o(153617);
  }
  
  public final void zW(boolean paramBoolean)
  {
    AppMethodBeat.i(153600);
    Log.i("XWebNativeInterface", "disableJsCallback:".concat(String.valueOf(paramBoolean)));
    this.MOL = paramBoolean;
    AppMethodBeat.o(153600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d
 * JD-Core Version:    0.7.0.1
 */