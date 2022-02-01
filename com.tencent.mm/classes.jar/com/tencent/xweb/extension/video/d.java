package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
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
import com.tencent.xweb.util.h;
import com.tencent.xweb.v;
import java.util.Timer;
import java.util.TimerTask;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;

public final class d
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, b, u
{
  WebView IJw;
  private int JvV = -3;
  GestureDetector PO;
  ScaleGestureDetector Rkr;
  private long SBA;
  private double SBB;
  private double SBC;
  private final int SBD = 0;
  private final int SBE = 1;
  private final int SBF = 2;
  private final int SBG = 3;
  private boolean SBH = false;
  private v SBI;
  private int SBJ = 0;
  private double SBK = 0.0D;
  private float SBL = 0.0F;
  private float SBM = 0.0F;
  private a SBN;
  String SBO;
  private Timer SBP;
  private boolean SBQ;
  private int SBR = 0;
  private double SBS;
  private int SBT = 200;
  private Drawable SBU;
  private boolean SBV;
  private boolean SBW;
  private boolean SBX = false;
  private int SBY;
  private ViewGroup SBk;
  SurfaceView SBl;
  private View SBm;
  ViewGroup SBn;
  VideoStatusLayout SBo;
  ProgressBar SBp;
  TextView SBq;
  TextView SBr;
  ClickableFrameLayout SBs;
  LinearLayout SBt;
  ImageView SBu;
  ImageView SBv;
  ImageView SBw;
  c SBx;
  private WebChromeClient.CustomViewCallback SBy;
  private boolean SBz;
  private Window WZ;
  private WindowManager.LayoutParams azI;
  Activity mActivity;
  private AudioManager mAudioManager;
  private float mBrightness = 1.0F;
  private int mCurrentOrientation;
  private double mLe;
  private int mMode = 0;
  FrameLayout mRootView;
  
  private void En(final boolean paramBoolean)
  {
    AppMethodBeat.i(153609);
    aC(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153573);
        if (paramBoolean)
        {
          d.k(d.this).setImageResource(2131235810);
          AppMethodBeat.o(153573);
          return;
        }
        d.k(d.this).setImageResource(2131235812);
        AppMethodBeat.o(153573);
      }
    });
    AppMethodBeat.o(153609);
  }
  
  private void Eo(boolean paramBoolean)
  {
    AppMethodBeat.i(153632);
    Activity localActivity = htk();
    if (localActivity == null)
    {
      AppMethodBeat.o(153632);
      return;
    }
    if (paramBoolean)
    {
      if ((localActivity.getWindow().getAttributes().flags & 0x800) != 0)
      {
        this.SBW = true;
        localActivity.getWindow().clearFlags(2048);
        if (this.SBX) {
          break label171;
        }
        if ((localActivity.getWindow().getAttributes().flags & 0x400) == 0) {
          break label104;
        }
        this.SBV = true;
      }
      for (;;)
      {
        this.SBX = true;
        AppMethodBeat.o(153632);
        return;
        this.SBW = false;
        break;
        label104:
        this.SBV = false;
        localActivity.getWindow().addFlags(1024);
      }
    }
    else
    {
      if (this.SBW) {
        localActivity.getWindow().addFlags(2048);
      }
      if (!this.SBV) {
        localActivity.getWindow().clearFlags(1024);
      }
      this.SBY = 0;
      this.SBX = false;
      this.SBz = false;
    }
    label171:
    AppMethodBeat.o(153632);
  }
  
  private void aC(Runnable paramRunnable)
  {
    AppMethodBeat.i(153601);
    if (this.SBH)
    {
      AppMethodBeat.o(153601);
      return;
    }
    Activity localActivity = htk();
    if (localActivity != null)
    {
      localActivity.runOnUiThread(paramRunnable);
      AppMethodBeat.o(153601);
      return;
    }
    this.IJw.getView().post(paramRunnable);
    AppMethodBeat.o(153601);
  }
  
  private SurfaceView hQ(View paramView)
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
        SurfaceView localSurfaceView = hQ(paramView.getChildAt(i));
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
  
  private Activity htk()
  {
    AppMethodBeat.i(153593);
    if (this.mActivity != null)
    {
      localObject = this.mActivity;
      AppMethodBeat.o(153593);
      return localObject;
    }
    Object localObject = this.IJw.getContext();
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      label46:
      if (localObject == null) {
        break label98;
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
        break label46;
      }
      localObject = null;
      break label46;
      label98:
      Log.e("XWebNativeInterface", "royle:tryGetActivity but no Activity");
    }
  }
  
  /* Error */
  public static String htl()
  {
    // Byte code:
    //   0: ldc_w 329
    //   3: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 331
    //   9: invokestatic 337	com/tencent/xweb/xwalk/a/h:brX	(Ljava/lang/String;)Lcom/tencent/xweb/xwalk/a/g;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +436 -> 450
    //   17: aload_1
    //   18: getfield 342	com/tencent/xweb/xwalk/a/g:SHU	I
    //   21: iconst_m1
    //   22: if_icmpeq +428 -> 450
    //   25: aload_1
    //   26: getfield 342	com/tencent/xweb/xwalk/a/g:SHU	I
    //   29: istore_0
    //   30: new 344	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: aload_1
    //   36: getfield 342	com/tencent/xweb/xwalk/a/g:SHU	I
    //   39: iconst_0
    //   40: invokevirtual 348	com/tencent/xweb/xwalk/a/g:ca	(IZ)Ljava/lang/String;
    //   43: invokespecial 351	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 355	java/io/File:isFile	()Z
    //   51: ifeq +239 -> 290
    //   54: aload_2
    //   55: invokevirtual 358	java/io/File:exists	()Z
    //   58: ifeq +232 -> 290
    //   61: new 360	java/io/FileInputStream
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 363	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +374 -> 445
    //   74: new 365	java/io/InputStreamReader
    //   77: dup
    //   78: aload_1
    //   79: ldc_w 367
    //   82: invokespecial 370	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   85: astore_3
    //   86: new 372	java/io/BufferedReader
    //   89: dup
    //   90: aload_3
    //   91: invokespecial 375	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   94: astore_2
    //   95: aload_3
    //   96: astore 5
    //   98: aload_2
    //   99: astore 4
    //   101: new 377	java/lang/StringBuffer
    //   104: dup
    //   105: ldc_w 379
    //   108: invokespecial 380	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   111: astore 6
    //   113: aload_3
    //   114: astore 5
    //   116: aload_2
    //   117: astore 4
    //   119: aload_2
    //   120: invokevirtual 383	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   123: astore 7
    //   125: aload 7
    //   127: ifnull +174 -> 301
    //   130: aload_3
    //   131: astore 5
    //   133: aload_2
    //   134: astore 4
    //   136: aload 6
    //   138: aload 7
    //   140: invokevirtual 387	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   143: pop
    //   144: aload_3
    //   145: astore 5
    //   147: aload_2
    //   148: astore 4
    //   150: aload 6
    //   152: ldc_w 389
    //   155: invokevirtual 387	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   158: pop
    //   159: goto -46 -> 113
    //   162: astore 6
    //   164: aload_3
    //   165: astore 5
    //   167: aload_2
    //   168: astore 4
    //   170: ldc_w 313
    //   173: new 391	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 393
    //   180: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload 6
    //   185: invokevirtual 397	java/io/IOException:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 320	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 406	java/io/InputStreamReader:close	()V
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 407	java/io/BufferedReader:close	()V
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 410	java/io/InputStream:close	()V
    //   221: aconst_null
    //   222: astore_1
    //   223: aload_1
    //   224: ifnull +10 -> 234
    //   227: aload_1
    //   228: invokevirtual 415	java/lang/String:isEmpty	()Z
    //   231: ifeq +158 -> 389
    //   234: ldc_w 313
    //   237: ldc_w 417
    //   240: invokestatic 419	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: ldc_w 421
    //   246: astore_1
    //   247: invokestatic 426	com/tencent/xweb/util/h:huD	()V
    //   250: ldc_w 329
    //   253: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_1
    //   257: areturn
    //   258: astore_1
    //   259: ldc_w 313
    //   262: new 391	java/lang/StringBuilder
    //   265: dup
    //   266: ldc_w 428
    //   269: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: aload_1
    //   273: invokevirtual 429	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   276: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 320	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aconst_null
    //   286: astore_1
    //   287: goto -217 -> 70
    //   290: aload_1
    //   291: iconst_m1
    //   292: invokevirtual 433	com/tencent/xweb/xwalk/a/g:atc	(I)Z
    //   295: pop
    //   296: aconst_null
    //   297: astore_1
    //   298: goto -228 -> 70
    //   301: aload_3
    //   302: astore 5
    //   304: aload_2
    //   305: astore 4
    //   307: aload 6
    //   309: invokevirtual 434	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   312: astore 6
    //   314: aload_3
    //   315: invokevirtual 406	java/io/InputStreamReader:close	()V
    //   318: aload_2
    //   319: invokevirtual 407	java/io/BufferedReader:close	()V
    //   322: aload_1
    //   323: ifnull +7 -> 330
    //   326: aload_1
    //   327: invokevirtual 410	java/io/InputStream:close	()V
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
    //   360: invokevirtual 406	java/io/InputStreamReader:close	()V
    //   363: aload 4
    //   365: ifnull +8 -> 373
    //   368: aload 4
    //   370: invokevirtual 407	java/io/BufferedReader:close	()V
    //   373: aload_1
    //   374: ifnull +7 -> 381
    //   377: aload_1
    //   378: invokevirtual 410	java/io/InputStream:close	()V
    //   381: ldc_w 329
    //   384: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   387: aload_2
    //   388: athrow
    //   389: ldc_w 313
    //   392: ldc_w 436
    //   395: iload_0
    //   396: invokestatic 440	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   399: invokevirtual 444	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   402: invokestatic 419	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: invokestatic 447	com/tencent/xweb/util/h:huC	()V
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
      this.mAudioManager = ((AudioManager)this.IJw.getContext().getSystemService("audio"));
    }
    this.SBJ = this.mAudioManager.getStreamMaxVolume(3);
    this.SBK = this.mAudioManager.getStreamVolume(3);
    if (this.SBN == null) {
      this.SBN = new a(this.IJw.getContext());
    }
    if (this.WZ == null)
    {
      Activity localActivity = htk();
      if (localActivity != null) {
        this.WZ = localActivity.getWindow();
      }
    }
    if ((this.WZ != null) && (this.azI == null)) {
      this.azI = this.WZ.getAttributes();
    }
    if (this.azI != null)
    {
      this.mBrightness = this.azI.screenBrightness;
      if (this.mBrightness == -1.0F) {
        try
        {
          this.mBrightness = ((float)(Settings.System.getInt(this.IJw.getContext().getContentResolver(), "screen_brightness") / 256.0D));
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
  
  private void t(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(207177);
    if ((this.SBI != null) && (this.SBI.xJ(paramInt)))
    {
      Log.i("XWebNativeInterface", "setRequestedOrientation by wechat client");
      AppMethodBeat.o(207177);
      return;
    }
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(paramInt);
    }
    AppMethodBeat.o(207177);
  }
  
  public final void Em(boolean paramBoolean)
  {
    AppMethodBeat.i(153600);
    Log.i("XWebNativeInterface", "disableJsCallback:".concat(String.valueOf(paramBoolean)));
    this.SBH = paramBoolean;
    AppMethodBeat.o(153600);
  }
  
  public final void F(double paramDouble)
  {
    AppMethodBeat.i(153614);
    this.IJw.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[] { Double.valueOf(paramDouble) }), new ValueCallback() {});
    AppMethodBeat.o(153614);
  }
  
  public final void bk(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(153595);
    if ((this.IJw != null) && (paramBoolean2) && (this.SBO != null))
    {
      Log.i("XWebNativeInterface", "evaluteJavascript:".concat(String.valueOf(paramBoolean1)));
      String str = this.SBO;
      if (paramBoolean1)
      {
        str = this.SBO;
        str = "window.addEventListener('DOMContentLoaded', function() {" + str + "});this.xwebReturn = function (){return \"1\";};this.xwebReturn()";
      }
      this.IJw.evaluateJavascript(str, new d.20(this));
    }
    AppMethodBeat.o(153595);
  }
  
  public final void e(final double paramDouble, final boolean paramBoolean)
  {
    AppMethodBeat.i(153610);
    aC(new Runnable()
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
  
  public final void eJ(Object paramObject)
  {
    AppMethodBeat.i(153594);
    new ReflectMethod(paramObject, "addJavascriptInterface", new Class[] { Object.class, String.class }).invoke(new Object[] { this, "xwebToNative" });
    AppMethodBeat.o(153594);
  }
  
  public final boolean eK(Object paramObject)
  {
    this.SBI = ((v)paramObject);
    return true;
  }
  
  public final void eq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153633);
    Object localObject = htk();
    if (localObject == null)
    {
      AppMethodBeat.o(153633);
      return;
    }
    if ((this.JvV == -3) && (localObject != null)) {
      this.JvV = ((Activity)localObject).getRequestedOrientation();
    }
    int i;
    Point localPoint;
    int j;
    label157:
    double d1;
    if (paramInt1 <= paramInt2)
    {
      t((Activity)localObject, 1);
      i = 1;
      this.mCurrentOrientation = i;
      if (this.SBm != null)
      {
        localObject = this.SBm;
        Display localDisplay = ((WindowManager)this.IJw.getContext().getSystemService("window")).getDefaultDisplay();
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
      t((Activity)localObject, 0);
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
  
  public final void fDd()
  {
    AppMethodBeat.i(153613);
    this.IJw.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_NewPause();", new Object[0]), new ValueCallback() {});
    AppMethodBeat.o(153613);
  }
  
  public final boolean hsA()
  {
    return true;
  }
  
  public final void hsz()
  {
    AppMethodBeat.i(153612);
    this.IJw.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_NewPlay();", new Object[0]), new ValueCallback() {});
    AppMethodBeat.o(153612);
  }
  
  public final void htm()
  {
    AppMethodBeat.i(153602);
    if (this.SBP != null)
    {
      this.SBP.cancel();
      this.SBP.purge();
      this.SBP = null;
    }
    this.SBP = new Timer();
    this.SBP.schedule(new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(153590);
        d.this.htp();
        AppMethodBeat.o(153590);
      }
    }, 4000L);
    AppMethodBeat.o(153602);
  }
  
  public final void htn()
  {
    AppMethodBeat.i(153603);
    if (this.SBP != null)
    {
      this.SBP.cancel();
      this.SBP.purge();
      this.SBP = null;
    }
    AppMethodBeat.o(153603);
  }
  
  public final void hto()
  {
    AppMethodBeat.i(153607);
    aC(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153591);
        d.a(d.this, true);
        d.j(d.this).setVisibility(0);
        d.this.htm();
        AppMethodBeat.o(153591);
      }
    });
    AppMethodBeat.o(153607);
  }
  
  public final void htp()
  {
    AppMethodBeat.i(153608);
    aC(new Runnable()
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
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    this.SBR = 0;
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(153599);
    if (this.SBy != null) {
      this.SBy.onCustomViewHidden();
    }
    Log.i("XWebNativeInterface", "detach");
    if (!this.SBX)
    {
      Log.i("XWebNativeInterface", "detach has exited fullscreen");
      AppMethodBeat.o(153599);
      return;
    }
    Activity localActivity = htk();
    if (localActivity != null)
    {
      if (this.SBU != null)
      {
        this.IJw.getView().setBackground(this.SBU);
        this.SBU = null;
      }
      for (;;)
      {
        ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
        if (this.mRootView.getParent() == localViewGroup) {
          break;
        }
        AppMethodBeat.o(153599);
        return;
        this.IJw.getView().setBackground(new ColorDrawable(0));
      }
      if (this.IJw.isXWalkKernel())
      {
        this.mRootView.removeView(this.IJw);
        this.SBk.addView(this.IJw, 0);
      }
      if (this.SBm != null) {
        this.mRootView.removeView(this.SBm);
      }
      this.mRootView.removeView(this.SBn);
      this.SBn.setVisibility(8);
      if (this.JvV != -3)
      {
        t(localActivity, this.JvV);
        this.JvV = -3;
      }
      Eo(false);
      if ((this.mRootView.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.mRootView.getParent()).removeView(this.mRootView);
      }
    }
    AppMethodBeat.o(153599);
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207176);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(207176);
  }
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(153606);
    if ((this.mMode == 1) && (this.SBm != null))
    {
      float f = paramScaleGestureDetector.getScaleFactor();
      this.SBm.getLeft();
      this.SBm.getTop();
      this.SBm.getBottom();
      this.SBm.getRight();
      int i = (int)(this.SBm.getWidth() * f);
      int j = (int)(f * this.SBm.getHeight());
      paramScaleGestureDetector = new FrameLayout.LayoutParams(-2, -2, 17);
      paramScaleGestureDetector.width = i;
      paramScaleGestureDetector.height = j;
      if (this.SBm != null) {
        this.SBm.setLayoutParams(paramScaleGestureDetector);
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
    if (this.SBn.getHeight() > this.SBn.getWidth())
    {
      paramFloat2 = this.SBn.getWidth();
      paramFloat1 = this.SBn.getHeight();
    }
    double d1;
    switch (this.SBR)
    {
    default: 
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(153605);
        return true;
        paramFloat2 = this.SBn.getHeight();
        paramFloat1 = this.SBn.getWidth();
        break;
        if (Math.abs(f1 - f2) - Math.abs(f3) > 1.0F)
        {
          this.SBR = 3;
        }
        else
        {
          reset();
          d1 = Math.ceil(25.0F * this.IJw.getContext().getResources().getDisplayMetrics().density);
          if ((paramMotionEvent1.getY() < 2.0D * d1) || (paramMotionEvent1.getY() > this.SBn.getHeight() - d1 * 2.0D)) {
            this.SBR = 0;
          } else if (paramMotionEvent1.getX() < this.SBn.getWidth() / 2.0F) {
            this.SBR = 2;
          } else {
            this.SBR = 1;
          }
        }
      }
    case 1: 
      paramFloat1 = f3 * -1.0F;
      d1 = this.SBJ * paramFloat1 / paramFloat2 * 1.2F;
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
      d1 = this.SBK;
      double d2 = i + d1;
      if (d2 > this.SBJ) {
        d1 = this.SBJ;
      }
      for (;;)
      {
        this.mAudioManager.setStreamVolume(3, (int)d1, 4);
        i = (int)(d1 / this.SBJ * 100.0D);
        this.SBo.setVolumnProgress(i);
        this.SBo.show();
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
        this.azI.screenBrightness = paramFloat1;
        this.WZ.setAttributes(this.azI);
        this.SBo.setBrightProgress((int)(paramFloat1 * 100.0F));
        this.SBo.show();
        break;
        paramFloat1 = paramFloat2;
        if (paramFloat2 > 1.0F) {
          paramFloat1 = 1.0F;
        }
      }
    }
    paramFloat2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    this.SBM = this.SBx.mProgress;
    if (paramFloat2 > 0.0F)
    {
      f1 = this.SBM;
      this.SBL = ((int)(paramFloat2 / paramFloat1 * 100.0F + f1));
      if (this.SBL > 100.0F) {
        this.SBL = 100.0F;
      }
    }
    for (;;)
    {
      d1 = this.mLe * this.SBL / 100.0D;
      this.SBo.setVideoTimeProgress(q(d1, this.mLe) + "/" + q(this.mLe, this.mLe));
      this.SBo.show();
      this.SBS = d1;
      break;
      f1 = this.SBM;
      this.SBL = ((int)(paramFloat2 / paramFloat1 * 100.0F + f1));
      if (this.SBL < 0.0F) {
        this.SBL = 0.0F;
      }
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(153598);
    Log.i("XWebNativeInterface", "onShowCustomView");
    this.SBm = paramView;
    this.SBy = paramCustomViewCallback;
    if ((this.SBm != null) || (this.IJw.isXWalkKernel()))
    {
      if (!this.IJw.isXWalkKernel()) {
        break label95;
      }
      h.hue();
      Log.i("XWebNativeInterface", "attach");
      if (!this.SBX) {
        break label111;
      }
      Log.i("XWebNativeInterface", "attach has entered fullscreen");
    }
    for (;;)
    {
      this.IJw.requestFocus();
      AppMethodBeat.o(153598);
      return;
      label95:
      if (!this.IJw.isSysKernel()) {
        break;
      }
      h.hui();
      break;
      label111:
      paramView = htk();
      if (paramView != null)
      {
        reset();
        Eo(true);
        paramView = (FrameLayout)paramView.getWindow().getDecorView();
        if ((this.IJw.isXWalkKernel()) && (this.mRootView.getParent() == paramView) && (this.SBm != null))
        {
          this.mRootView.addView(this.SBm, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        else if (this.mRootView.getParent() != paramView)
        {
          paramView.addView(this.mRootView, new FrameLayout.LayoutParams(-1, -1, 17));
          if (this.SBm != null)
          {
            this.mRootView.addView(this.SBm, this.mRootView.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
            if (this.IJw.isSysKernel()) {
              this.SBm.setVisibility(4);
            }
          }
          if (this.IJw.isSysKernel())
          {
            paramView = hQ(this.SBm);
            if (paramView != null) {
              paramView.setZOrderMediaOverlay(true);
            }
          }
          if (this.IJw.isXWalkKernel())
          {
            this.SBk = ((ViewGroup)this.IJw.getParent());
            this.SBk.removeView(this.IJw);
            this.mRootView.addView(this.IJw, this.mRootView.getChildCount());
          }
          this.mRootView.addView(this.SBn, this.mRootView.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
          this.SBU = this.IJw.getView().getBackground();
          if (this.SBU != null) {
            this.SBU = this.SBU.getConstantState().newDrawable().mutate();
          }
          this.IJw.getView().setBackground(new ColorDrawable(-16777216));
          if (this.IJw.isSysKernel()) {
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
            }, this.SBT);
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
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    htn();
    if (this.SBQ) {
      htp();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(153604);
      return true;
      hto();
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onSpecialVideoEnterFullscreen(int paramInt)
  {
    AppMethodBeat.i(153629);
    Log.i("XWebNativeInterface", "onSpecialVideoEnterFullscreen:".concat(String.valueOf(paramInt)));
    h.bY(paramInt, this.IJw.isXWalkKernel());
    AppMethodBeat.o(153629);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onSpecialVideoHook(int paramInt)
  {
    AppMethodBeat.i(153630);
    Log.i("XWebNativeInterface", "onSpecialVideoHook:".concat(String.valueOf(paramInt)));
    h.bZ(paramInt, this.IJw.isXWalkKernel());
    AppMethodBeat.o(153630);
  }
  
  @android.webkit.JavascriptInterface
  public final boolean onVideoEmptied()
  {
    AppMethodBeat.i(153623);
    Log.i("XWebNativeInterface", "onVideoEmptied");
    if (this.SBI != null)
    {
      this.SBI.bLx();
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
    if (this.SBI != null) {
      this.SBI.onVideoEnded();
    }
    AppMethodBeat.o(153622);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoEnterFullscreen(final boolean paramBoolean1, long paramLong, final double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(153625);
    Log.i("XWebNativeInterface", "onVideoEnterFullscreen:isVideoTag:" + paramBoolean1 + ",width:" + paramDouble1 + ",height:" + paramDouble2 + ",pause:" + paramBoolean2 + ",seeking:" + paramBoolean3 + ",currentTime:" + paramDouble3 + ",duration:" + paramDouble4);
    if (this.SBI != null) {
      this.SBI.onVideoEnterFullscreen(paramBoolean1, paramLong, paramDouble1, paramDouble2, paramBoolean2, paramBoolean3, paramDouble3, paramDouble4, paramArrayOfDouble);
    }
    if (this.IJw.isXWalkKernel())
    {
      h.huf();
      if (paramBoolean1)
      {
        if (!this.IJw.isXWalkKernel()) {
          break label250;
        }
        h.hug();
        label157:
        this.SBz = true;
      }
      this.SBA = paramLong;
      this.mLe = paramDouble4;
      this.SBB = paramDouble1;
      this.SBC = paramDouble2;
      if (!paramBoolean3) {
        break label266;
      }
      onVideoSeeking();
    }
    for (;;)
    {
      aC(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153582);
          if (paramBoolean1) {
            d.q(d.this).setVisibility(0);
          }
          d.this.eq((int)paramDouble1, (int)this.SCi);
          AppMethodBeat.o(153582);
        }
      });
      onVideoTimeUpdate(paramDouble3, paramDouble4, paramArrayOfDouble);
      En(paramBoolean2);
      AppMethodBeat.o(153625);
      return;
      if (!this.IJw.isSysKernel()) {
        break;
      }
      h.huj();
      break;
      label250:
      if (!this.IJw.isSysKernel()) {
        break label157;
      }
      h.huk();
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
    if (this.SBI != null) {
      this.SBI.onVideoError(paramInt, paramString);
    }
    AppMethodBeat.o(153624);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoExitFullscreen()
  {
    AppMethodBeat.i(153626);
    Log.i("XWebNativeInterface", "onVideoExitFullscreen");
    if (this.SBI != null) {
      this.SBI.onVideoExitFullscreen();
    }
    this.SBz = false;
    aC(new Runnable()
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
    if ((paramLong == this.SBA) && (this.SBS == paramDouble) && (paramString != null) && (paramString.startsWith("data:image/png;base64,")))
    {
      paramString = Base64.decode(paramString.substring(22), 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      this.SBu.setImageBitmap(paramString);
      this.SBu.setVisibility(0);
    }
    AppMethodBeat.o(153615);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPause()
  {
    AppMethodBeat.i(153621);
    Log.i("XWebNativeInterface", "onVideoPause");
    if (this.SBI != null) {
      this.SBI.onVideoPause();
    }
    En(true);
    AppMethodBeat.o(153621);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPlay()
  {
    AppMethodBeat.i(153620);
    Log.i("XWebNativeInterface", "onVideoPlay");
    if (this.SBI != null) {
      this.SBI.onVideoPlay();
    }
    En(false);
    AppMethodBeat.o(153620);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onVideoPlaying()
  {
    AppMethodBeat.i(153616);
    Log.i("XWebNativeInterface", "onVideoPlaying");
    if (this.SBI != null) {
      this.SBI.onVideoPlaying();
    }
    aC(new Runnable()
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
    if (this.SBI != null) {
      this.SBI.onVideoSeeked();
    }
    aC(new Runnable()
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
    if (this.SBI != null) {
      this.SBI.onVideoSeeking();
    }
    aC(new Runnable()
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
    if (this.SBI != null) {
      this.SBI.onVideoSizeUpdate(paramDouble1, paramDouble2);
    }
    if ((this.SBC != paramDouble2) || (this.SBB != paramDouble1))
    {
      this.SBB = paramDouble1;
      this.SBC = paramDouble2;
      Log.i("XWebNativeInterface", "onVideoSizeUpdate width:" + paramDouble1 + ", height:" + paramDouble2);
      aC(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153584);
          d.this.eq((int)paramDouble1, (int)this.SCi);
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
    if (this.SBI != null) {
      this.SBI.onVideoTimeUpdate(paramDouble1, paramDouble2, paramArrayOfDouble);
    }
    this.mLe = paramDouble2;
    e(paramDouble1, true);
    aC(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153575);
        c localc = d.l(d.this);
        double d3 = paramDouble2;
        Object localObject = this.SCe;
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
        localObject = (FrameLayout.LayoutParams)localc.mDf.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = ((int)(d1 / 100.0D * localc.mCN.getWidth()));
        localc.mDf.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localc.mDf.requestLayout();
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
    if (this.SBI != null) {
      this.SBI.onVideoWaiting();
    }
    aC(new Runnable()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d
 * JD-Core Version:    0.7.0.1
 */