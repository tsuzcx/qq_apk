package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;

public class SplashWelcomeView
  extends FrameLayout
  implements com.tencent.mm.ui.chatting.ar
{
  private volatile boolean OLm;
  private volatile boolean OLn;
  private ImageView OLo;
  private int OLp;
  private Bitmap bitmap;
  private boolean hasDrawed;
  
  public SplashWelcomeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33769);
    jT(paramContext);
    AppMethodBeat.o(33769);
  }
  
  public SplashWelcomeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33770);
    jT(paramContext);
    AppMethodBeat.o(33770);
  }
  
  private boolean e(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(33771);
    this.OLp = paramSharedPreferences.getInt("launch_fail_times", 0);
    int i = paramSharedPreferences.getInt("launch_last_status", 0);
    if (i == 1)
    {
      Log.i("SplashWelcomeView", "last launch status is 'start'.");
      this.OLp += 1;
      paramSharedPreferences.edit().putInt("launch_fail_times", this.OLp).commit();
    }
    for (;;)
    {
      paramSharedPreferences.edit().putInt("launch_last_status", 1).apply();
      if (this.OLp < 3) {
        break;
      }
      Log.i("SplashWelcomeView", "launch exceed max failed times, %d", new Object[] { Integer.valueOf(this.OLp) });
      AppMethodBeat.o(33771);
      return false;
      if (i == 2) {
        Log.i("SplashWelcomeView", "last launch status is 'end'.");
      }
    }
    AppMethodBeat.o(33771);
    return true;
  }
  
  private void gJE()
  {
    AppMethodBeat.i(33772);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(33772);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!g.isMIUIV8()))
    {
      ((Activity)getContext()).getWindow().setStatusBarColor(-1);
      AppMethodBeat.o(33772);
      return;
    }
    ((Activity)getContext()).getWindow().setStatusBarColor(ar.v(Color.parseColor("#33000000"), -1));
    AppMethodBeat.o(33772);
  }
  
  /* Error */
  private void gJF()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 164
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 166	com/tencent/mm/ui/SplashWelcomeView:OLm	Z
    //   11: ifne +56 -> 67
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 166	com/tencent/mm/ui/SplashWelcomeView:OLm	Z
    //   19: aload_0
    //   20: getfield 49	com/tencent/mm/ui/SplashWelcomeView:bitmap	Landroid/graphics/Bitmap;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +42 -> 67
    //   28: new 10	com/tencent/mm/ui/SplashWelcomeView$2
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 168	com/tencent/mm/ui/SplashWelcomeView$2:<init>	(Lcom/tencent/mm/ui/SplashWelcomeView;)V
    //   36: invokestatic 174	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   39: ldc 164
    //   41: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: ldc 81
    //   50: aload_1
    //   51: ldc 176
    //   53: iconst_1
    //   54: anewarray 109	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   63: aastore
    //   64: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: ldc 164
    //   69: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -28 -> 44
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	SplashWelcomeView
    //   23	2	1	localBitmap	Bitmap
    //   47	13	1	localException	Exception
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	39	47	java/lang/Exception
    //   2	24	75	finally
    //   28	39	75	finally
    //   39	44	75	finally
    //   48	67	75	finally
    //   67	72	75	finally
  }
  
  private void jT(Context paramContext)
  {
    AppMethodBeat.i(33773);
    this.OLo = new SplashImageView(paramContext);
    ((SplashImageView)this.OLo).setOnDrawListener(this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    Object localObject;
    if (MMApplicationContext.isMMProcess()) {
      localObject = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0);
    }
    try
    {
      bool = ((SharedPreferences)localObject).getBoolean("transit_to_switch_account", false);
      Log.i("SplashWelcomeView", "transit to switch account %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        byte[] arrayOfByte = s.aW(e.g.Ozb, 0, (int)s.boW(e.g.Ozb));
        s.deleteFile(e.g.Ozb);
        ((SharedPreferences)localObject).edit().putBoolean("transit_to_switch_account", false).commit();
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          localObject = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
          if (localObject == null) {
            break label201;
          }
          this.OLo.setImageBitmap((Bitmap)localObject);
          gJE();
        }
      }
    }
    catch (Exception localException)
    {
      label201:
      final String str;
      try
      {
        boolean bool;
        while (!MMApplicationContext.isMMProcess())
        {
          Log.i("SplashWelcomeView", "not main process, only load default splash bitmap.");
          AppMethodBeat.o(33773);
          return;
          Log.e("SplashWelcomeView", "get switch account bg null!");
          continue;
          localException = localException;
          Log.printErrStackTrace("SplashWelcomeView", localException, "show switch account view with exception!", new Object[0]);
        }
        paramContext = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
        long l1 = paramContext.getLong("new_launch_image_begin_time", 0L);
        long l2 = paramContext.getLong("new_launch_image_end_time", 0L);
        long l3 = System.currentTimeMillis() / 1000L;
        Log.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
        str = b.aKB() + "splashWelcomeImg";
        if ((l3 > l1) && (l3 < l2))
        {
          bool = e(paramContext);
          if (!bool)
          {
            AppMethodBeat.o(33773);
            return;
          }
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33766);
              if (s.YS(str))
              {
                try
                {
                  byte[] arrayOfByte = s.aW(str, 0, (int)s.boW(str));
                  if ((arrayOfByte != null) && (arrayOfByte.length > 0))
                  {
                    SplashWelcomeView.a(SplashWelcomeView.this, BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
                    Log.i("SplashWelcomeView", "ready to play animation, hasDrawed %s", new Object[] { Boolean.valueOf(SplashWelcomeView.a(SplashWelcomeView.this)) });
                    SplashWelcomeView.b(SplashWelcomeView.this);
                  }
                  return;
                }
                catch (Exception localException)
                {
                  Log.printErrStackTrace("SplashWelcomeView", localException, "decode new welcome image error: %s", new Object[] { localException.getMessage() });
                  return;
                }
                finally
                {
                  if (SplashWelcomeView.a(SplashWelcomeView.this)) {
                    SplashWelcomeView.c(SplashWelcomeView.this);
                  }
                  AppMethodBeat.o(33766);
                }
                AppMethodBeat.o(33766);
                return;
              }
              Log.i("SplashWelcomeView", "cannot find %s", new Object[] { str });
              AppMethodBeat.o(33766);
            }
          }, "readWelcomeBg");
          AppMethodBeat.o(33773);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("SplashWelcomeView", paramContext, "%s", new Object[] { paramContext.getMessage() });
        AppMethodBeat.o(33773);
        return;
      }
      Log.i("SplashWelcomeView", "change launch image activity is finished!");
      s.deleteFile(str);
      AppMethodBeat.o(33773);
    }
    addView(this.OLo, paramContext);
  }
  
  public final void dSa()
  {
    AppMethodBeat.i(33775);
    Log.i("SplashWelcomeView", "hasDrawed:%s", new Object[] { Boolean.valueOf(this.hasDrawed) });
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if ((this.OLn) && (!this.OLm)) {
        gJF();
      }
    }
    AppMethodBeat.o(33775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.SplashWelcomeView
 * JD-Core Version:    0.7.0.1
 */