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
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.chatting.ao;

public class SplashWelcomeView
  extends FrameLayout
  implements ao
{
  private Bitmap bitmap;
  private boolean hasDrawed;
  private volatile boolean zfm;
  private volatile boolean zfn;
  private ImageView zfo;
  private int zfp;
  
  public SplashWelcomeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29915);
    hN(paramContext);
    AppMethodBeat.o(29915);
  }
  
  public SplashWelcomeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29916);
    hN(paramContext);
    AppMethodBeat.o(29916);
  }
  
  private void dDi()
  {
    AppMethodBeat.i(153822);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(153822);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!h.Mo()))
    {
      ((Activity)getContext()).getWindow().setStatusBarColor(-1);
      AppMethodBeat.o(153822);
      return;
    }
    ((Activity)getContext()).getWindow().setStatusBarColor(aj.n(Color.parseColor("#33000000"), -1));
    AppMethodBeat.o(153822);
  }
  
  /* Error */
  private void dDj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 29919
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 107	com/tencent/mm/ui/SplashWelcomeView:zfm	Z
    //   12: ifne +57 -> 69
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 107	com/tencent/mm/ui/SplashWelcomeView:zfm	Z
    //   20: aload_0
    //   21: getfield 47	com/tencent/mm/ui/SplashWelcomeView:bitmap	Landroid/graphics/Bitmap;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +43 -> 69
    //   29: new 10	com/tencent/mm/ui/SplashWelcomeView$2
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 109	com/tencent/mm/ui/SplashWelcomeView$2:<init>	(Lcom/tencent/mm/ui/SplashWelcomeView;)V
    //   37: invokestatic 114	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   40: sipush 29919
    //   43: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: ldc 116
    //   52: aload_1
    //   53: ldc 118
    //   55: iconst_1
    //   56: anewarray 120	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: invokevirtual 124	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: sipush 29919
    //   72: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: goto -29 -> 46
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	SplashWelcomeView
    //   24	2	1	localBitmap	Bitmap
    //   49	13	1	localException	Exception
    //   78	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	40	49	java/lang/Exception
    //   2	25	78	finally
    //   29	40	78	finally
    //   40	46	78	finally
    //   50	69	78	finally
    //   69	75	78	finally
  }
  
  private boolean h(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(29917);
    this.zfp = paramSharedPreferences.getInt("launch_fail_times", 0);
    int i = paramSharedPreferences.getInt("launch_last_status", 0);
    if (i == 1)
    {
      ab.i("SplashWelcomeView", "last launch status is 'start'.");
      this.zfp += 1;
      paramSharedPreferences.edit().putInt("launch_fail_times", this.zfp).commit();
    }
    for (;;)
    {
      paramSharedPreferences.edit().putInt("launch_last_status", 1).apply();
      if (this.zfp < 3) {
        break;
      }
      ab.i("SplashWelcomeView", "launch exceed max failed times, %d", new Object[] { Integer.valueOf(this.zfp) });
      AppMethodBeat.o(29917);
      return false;
      if (i == 2) {
        ab.i("SplashWelcomeView", "last launch status is 'end'.");
      }
    }
    AppMethodBeat.o(29917);
    return true;
  }
  
  private void hN(Context paramContext)
  {
    AppMethodBeat.i(29918);
    this.zfo = new SplashImageView(paramContext);
    this.zfo.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ((SplashImageView)this.zfo).setOnDrawListener(this);
    if (ah.brt()) {
      paramContext = ah.getContext().getSharedPreferences("switch_account_preferences", 0);
    }
    try
    {
      bool = paramContext.getBoolean("transit_to_switch_account", false);
      ab.i("SplashWelcomeView", "transit to switch account %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        localObject = com.tencent.mm.vfs.e.i(e.c.yVa, 0, com.tencent.mm.a.e.cM(e.c.yVa));
        com.tencent.mm.vfs.e.deleteFile(e.c.yVa);
        paramContext.edit().putBoolean("transit_to_switch_account", false).commit();
        if ((localObject != null) && (localObject.length > 0))
        {
          paramContext = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
          if (paramContext == null) {
            break label204;
          }
          this.zfo.setImageBitmap(paramContext);
          dDi();
        }
      }
    }
    catch (Exception paramContext)
    {
      Object localObject;
      try
      {
        boolean bool;
        while (!ah.brt())
        {
          ab.i("SplashWelcomeView", "not main process, only load default splash bitmap.");
          AppMethodBeat.o(29918);
          return;
          label204:
          ab.e("SplashWelcomeView", "get switch account bg null!");
          continue;
          paramContext = paramContext;
          ab.printErrStackTrace("SplashWelcomeView", paramContext, "show switch account view with exception!", new Object[0]);
        }
        paramContext = ah.getContext().getSharedPreferences("system_config_prefs", 0);
        long l1 = paramContext.getLong("new_launch_image_begin_time", 0L);
        long l2 = paramContext.getLong("new_launch_image_end_time", 0L);
        long l3 = System.currentTimeMillis() / 1000L;
        ab.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
        localObject = b.eQv + "splashWelcomeImg";
        if ((l3 > l1) && (l3 < l2))
        {
          bool = h(paramContext);
          if (!bool)
          {
            AppMethodBeat.o(29918);
            return;
          }
          d.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29912);
              if (com.tencent.mm.a.e.cN(this.zfq))
              {
                try
                {
                  byte[] arrayOfByte = com.tencent.mm.a.e.i(this.zfq, 0, com.tencent.mm.a.e.cM(this.zfq));
                  if ((arrayOfByte != null) && (arrayOfByte.length > 0))
                  {
                    SplashWelcomeView.a(SplashWelcomeView.this, BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
                    ab.i("SplashWelcomeView", "ready to play animation, hasDrawed %s", new Object[] { Boolean.valueOf(SplashWelcomeView.a(SplashWelcomeView.this)) });
                    SplashWelcomeView.b(SplashWelcomeView.this);
                  }
                  return;
                }
                catch (Exception localException)
                {
                  ab.printErrStackTrace("SplashWelcomeView", localException, "decode new welcome image error: %s", new Object[] { localException.getMessage() });
                  return;
                }
                finally
                {
                  if (SplashWelcomeView.a(SplashWelcomeView.this)) {
                    SplashWelcomeView.c(SplashWelcomeView.this);
                  }
                  AppMethodBeat.o(29912);
                }
                AppMethodBeat.o(29912);
                return;
              }
              ab.i("SplashWelcomeView", "cannot find %s", new Object[] { this.zfq });
              AppMethodBeat.o(29912);
            }
          }, "readWelcomeBg");
          AppMethodBeat.o(29918);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ab.printErrStackTrace("SplashWelcomeView", paramContext, "%s", new Object[] { paramContext.getMessage() });
        AppMethodBeat.o(29918);
        return;
      }
      ab.i("SplashWelcomeView", "change launch image activity is finished!");
      com.tencent.mm.a.e.deleteFile((String)localObject);
      AppMethodBeat.o(29918);
    }
    addView(this.zfo, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public final void bEm()
  {
    AppMethodBeat.i(29920);
    ab.i("SplashWelcomeView", "hasDrawed:%s", new Object[] { Boolean.valueOf(this.hasDrawed) });
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if ((this.zfn) && (!this.zfm)) {
        dDj();
      }
    }
    AppMethodBeat.o(29920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.SplashWelcomeView
 * JD-Core Version:    0.7.0.1
 */