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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.chatting.ap;
import com.tencent.mm.vfs.i;

public class SplashWelcomeView
  extends FrameLayout
  implements ap
{
  private volatile boolean FSv;
  private volatile boolean FSw;
  private ImageView FSx;
  private int FSy;
  private Bitmap bitmap;
  private boolean hasDrawed;
  
  public SplashWelcomeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33769);
    jt(paramContext);
    AppMethodBeat.o(33769);
  }
  
  public SplashWelcomeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33770);
    jt(paramContext);
    AppMethodBeat.o(33770);
  }
  
  private void eRM()
  {
    AppMethodBeat.i(33772);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(33772);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!g.XM()))
    {
      ((Activity)getContext()).getWindow().setStatusBarColor(-1);
      AppMethodBeat.o(33772);
      return;
    }
    ((Activity)getContext()).getWindow().setStatusBarColor(am.o(Color.parseColor("#33000000"), -1));
    AppMethodBeat.o(33772);
  }
  
  /* Error */
  private void eRN()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 108
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 110	com/tencent/mm/ui/SplashWelcomeView:FSv	Z
    //   11: ifne +56 -> 67
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 110	com/tencent/mm/ui/SplashWelcomeView:FSv	Z
    //   19: aload_0
    //   20: getfield 49	com/tencent/mm/ui/SplashWelcomeView:bitmap	Landroid/graphics/Bitmap;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +42 -> 67
    //   28: new 10	com/tencent/mm/ui/SplashWelcomeView$2
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 112	com/tencent/mm/ui/SplashWelcomeView$2:<init>	(Lcom/tencent/mm/ui/SplashWelcomeView;)V
    //   36: invokestatic 118	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   39: ldc 108
    //   41: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: ldc 120
    //   50: aload_1
    //   51: ldc 122
    //   53: iconst_1
    //   54: anewarray 124	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   63: aastore
    //   64: invokestatic 134	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: ldc 108
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
  
  private boolean h(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(33771);
    this.FSy = paramSharedPreferences.getInt("launch_fail_times", 0);
    int i = paramSharedPreferences.getInt("launch_last_status", 0);
    if (i == 1)
    {
      ad.i("SplashWelcomeView", "last launch status is 'start'.");
      this.FSy += 1;
      paramSharedPreferences.edit().putInt("launch_fail_times", this.FSy).commit();
    }
    for (;;)
    {
      paramSharedPreferences.edit().putInt("launch_last_status", 1).apply();
      if (this.FSy < 3) {
        break;
      }
      ad.i("SplashWelcomeView", "launch exceed max failed times, %d", new Object[] { Integer.valueOf(this.FSy) });
      AppMethodBeat.o(33771);
      return false;
      if (i == 2) {
        ad.i("SplashWelcomeView", "last launch status is 'end'.");
      }
    }
    AppMethodBeat.o(33771);
    return true;
  }
  
  private void jt(Context paramContext)
  {
    AppMethodBeat.i(33773);
    this.FSx = new SplashImageView(paramContext);
    ((SplashImageView)this.FSx).setOnDrawListener(this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    Object localObject;
    if (aj.cbv()) {
      localObject = aj.getContext().getSharedPreferences("switch_account_preferences", 0);
    }
    try
    {
      bool = ((SharedPreferences)localObject).getBoolean("transit_to_switch_account", false);
      ad.i("SplashWelcomeView", "transit to switch account %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        byte[] arrayOfByte = i.aR(e.e.FHW, 0, (int)i.aMN(e.e.FHW));
        i.deleteFile(e.e.FHW);
        ((SharedPreferences)localObject).edit().putBoolean("transit_to_switch_account", false).commit();
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          localObject = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
          if (localObject == null) {
            break label201;
          }
          this.FSx.setImageBitmap((Bitmap)localObject);
          eRM();
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
        while (!aj.cbv())
        {
          ad.i("SplashWelcomeView", "not main process, only load default splash bitmap.");
          AppMethodBeat.o(33773);
          return;
          ad.e("SplashWelcomeView", "get switch account bg null!");
          continue;
          localException = localException;
          ad.printErrStackTrace("SplashWelcomeView", localException, "show switch account view with exception!", new Object[0]);
        }
        paramContext = aj.getContext().getSharedPreferences("system_config_prefs", 0);
        long l1 = paramContext.getLong("new_launch_image_begin_time", 0L);
        long l2 = paramContext.getLong("new_launch_image_end_time", 0L);
        long l3 = System.currentTimeMillis() / 1000L;
        ad.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
        str = com.tencent.mm.loader.j.b.ahZ() + "splashWelcomeImg";
        if ((l3 > l1) && (l3 < l2))
        {
          bool = h(paramContext);
          if (!bool)
          {
            AppMethodBeat.o(33773);
            return;
          }
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33766);
              if (i.eK(str))
              {
                try
                {
                  byte[] arrayOfByte = i.aR(str, 0, (int)i.aMN(str));
                  if ((arrayOfByte != null) && (arrayOfByte.length > 0))
                  {
                    SplashWelcomeView.a(SplashWelcomeView.this, BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
                    ad.i("SplashWelcomeView", "ready to play animation, hasDrawed %s", new Object[] { Boolean.valueOf(SplashWelcomeView.a(SplashWelcomeView.this)) });
                    SplashWelcomeView.b(SplashWelcomeView.this);
                  }
                  return;
                }
                catch (Exception localException)
                {
                  ad.printErrStackTrace("SplashWelcomeView", localException, "decode new welcome image error: %s", new Object[] { localException.getMessage() });
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
              ad.i("SplashWelcomeView", "cannot find %s", new Object[] { str });
              AppMethodBeat.o(33766);
            }
          }, "readWelcomeBg");
          AppMethodBeat.o(33773);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ad.printErrStackTrace("SplashWelcomeView", paramContext, "%s", new Object[] { paramContext.getMessage() });
        AppMethodBeat.o(33773);
        return;
      }
      ad.i("SplashWelcomeView", "change launch image activity is finished!");
      i.deleteFile(str);
      AppMethodBeat.o(33773);
    }
    addView(this.FSx, paramContext);
  }
  
  public final void cAy()
  {
    AppMethodBeat.i(33775);
    ad.i("SplashWelcomeView", "hasDrawed:%s", new Object[] { Boolean.valueOf(this.hasDrawed) });
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if ((this.FSw) && (!this.FSv)) {
        eRN();
      }
    }
    AppMethodBeat.o(33775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.SplashWelcomeView
 * JD-Core Version:    0.7.0.1
 */