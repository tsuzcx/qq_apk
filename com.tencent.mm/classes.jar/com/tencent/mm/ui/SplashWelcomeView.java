package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SplashWelcomeView
  extends FrameLayout
  implements ar
{
  private Bitmap bitmap;
  private boolean hasDrawed;
  private volatile boolean uRa;
  private volatile boolean uRb;
  private ImageView uRc;
  private int uRd;
  
  public SplashWelcomeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    gu(paramContext);
  }
  
  public SplashWelcomeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    gu(paramContext);
  }
  
  /* Error */
  private void cAf()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/mm/ui/SplashWelcomeView:uRa	Z
    //   6: ifne +28 -> 34
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 54	com/tencent/mm/ui/SplashWelcomeView:uRa	Z
    //   14: aload_0
    //   15: getfield 38	com/tencent/mm/ui/SplashWelcomeView:bitmap	Landroid/graphics/Bitmap;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +14 -> 34
    //   23: new 10	com/tencent/mm/ui/SplashWelcomeView$2
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 56	com/tencent/mm/ui/SplashWelcomeView$2:<init>	(Lcom/tencent/mm/ui/SplashWelcomeView;)V
    //   31: invokestatic 62	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: ldc 64
    //   40: aload_1
    //   41: ldc 66
    //   43: iconst_1
    //   44: anewarray 68	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_1
    //   50: invokevirtual 72	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   53: aastore
    //   54: invokestatic 78	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: goto -23 -> 34
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	SplashWelcomeView
    //   18	2	1	localBitmap	Bitmap
    //   37	13	1	localException	Exception
    //   60	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	34	37	java/lang/Exception
    //   2	19	60	finally
    //   23	34	60	finally
    //   38	57	60	finally
  }
  
  private void gu(Context paramContext)
  {
    if (ae.cqV())
    {
      Object localObject1 = ae.getContext().getSharedPreferences("switch_account_preferences", 0);
      try
      {
        boolean bool = ((SharedPreferences)localObject1).getBoolean("transit_to_switch_account", false);
        y.i("SplashWelcomeView", "transit to switch account %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          ((SharedPreferences)localObject1).edit().putBoolean("transit_to_switch_account", false).commit();
          localObject1 = ((Activity)paramContext).getLayoutInflater().inflate(R.i.settings_switch_account, null);
          SwitchAccountGridView localSwitchAccountGridView = (SwitchAccountGridView)((View)localObject1).findViewById(R.h.switch_account_grid);
          localSwitchAccountGridView.setRowCount(1);
          localSwitchAccountGridView.setClickable(false);
          ((View)localObject1).findViewById(R.h.switch_account_delete_btn).setVisibility(8);
          ((View)localObject1).findViewById(R.h.switch_account_cancel_btn).setVisibility(8);
          Object localObject2 = (TextView)((View)localObject1).findViewById(R.h.switch_account_title);
          y.i("SplashWelcomeView", "activity resources %s, application resources %s", new Object[] { paramContext.getResources(), ae.getResources() });
          ((TextView)localObject2).setText(paramContext.getResources().getString(R.l.settings_switch_account_login_title));
          Object localObject3 = bv.dXJ.Ii();
          localObject2 = at.dVC.L("login_weixin_username", "");
          HashMap localHashMap = new HashMap();
          if ((!bk.bl((String)localObject2)) && (!((Set)localObject3).contains(localObject2))) {
            localHashMap.put(localObject2, new SwitchAccountModel((String)localObject2, at.dVC.L("login_user_name", ""), at.dVC.Ho(), at.dVC.L("last_logout_no_pwd_ticket", ""), bk.ZR(at.dVC.L("last_login_use_voice", ""))));
          }
          for (;;)
          {
            localSwitchAccountGridView.setUseSystemDecoder(true);
            localSwitchAccountGridView.J(localHashMap);
            localSwitchAccountGridView.setLastLoginWxUsername((String)localObject2);
            localSwitchAccountGridView.setLogoutState(true);
            localSwitchAccountGridView.bzE();
            addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
            return;
            localObject3 = ((Set)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              String str2 = (String)((Iterator)localObject3).next();
              localHashMap.put(str2, new SwitchAccountModel(str2, bv.dXJ.getString(str2, "login_user_name"), bv.dXJ.getString(str2, "last_avatar_path"), bv.dXJ.getString(str2, "last_logout_no_pwd_ticket"), bk.ZR(bv.dXJ.getString(str2, "last_login_use_voice"))));
            }
          }
        }
        this.uRc = new SplashImageView(paramContext);
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("SplashWelcomeView", localException, "show switch account view with exception!", new Object[0]);
      }
    }
    this.uRc.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ((SplashImageView)this.uRc).setOnDrawListener(this);
    addView(this.uRc, new FrameLayout.LayoutParams(-1, -1));
    try
    {
      if (!ae.cqV())
      {
        y.i("SplashWelcomeView", "not main process, only load default splash bitmap.");
        return;
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("SplashWelcomeView", paramContext, "%s", new Object[] { paramContext.getMessage() });
      return;
    }
    paramContext = ae.getContext().getSharedPreferences("system_config_prefs", 0);
    long l1 = paramContext.getLong("new_launch_image_begin_time", 0L);
    long l2 = paramContext.getLong("new_launch_image_end_time", 0L);
    long l3 = System.currentTimeMillis() / 1000L;
    y.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    final String str1 = b.dOP + "splashWelcomeImg";
    if ((l3 > l1) && (l3 < l2))
    {
      this.uRd = paramContext.getInt("launch_fail_times", 0);
      i = paramContext.getInt("launch_last_status", 0);
      if (i == 1)
      {
        y.i("SplashWelcomeView", "last launch status is 'start'.");
        this.uRd += 1;
        paramContext.edit().putInt("launch_fail_times", this.uRd).commit();
        paramContext.edit().putInt("launch_last_status", 1).apply();
        if (this.uRd < 3) {
          break label839;
        }
        y.i("SplashWelcomeView", "launch exceed max failed times, %d", new Object[] { Integer.valueOf(this.uRd) });
      }
    }
    label839:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        com.tencent.mm.sdk.f.e.post(new Runnable()
        {
          public final void run()
          {
            if (com.tencent.mm.a.e.bK(str1)) {
              try
              {
                byte[] arrayOfByte = com.tencent.mm.a.e.c(str1, 0, com.tencent.mm.a.e.bJ(str1));
                if ((arrayOfByte != null) && (arrayOfByte.length > 0))
                {
                  SplashWelcomeView.a(SplashWelcomeView.this, BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
                  y.i("SplashWelcomeView", "ready to play animation, hasDrawed %s", new Object[] { Boolean.valueOf(SplashWelcomeView.a(SplashWelcomeView.this)) });
                  SplashWelcomeView.b(SplashWelcomeView.this);
                }
                return;
              }
              catch (Exception localException)
              {
                y.printErrStackTrace("SplashWelcomeView", localException, "decode new welcome image error: %s", new Object[] { localException.getMessage() });
                return;
              }
              finally
              {
                if (SplashWelcomeView.a(SplashWelcomeView.this)) {
                  SplashWelcomeView.c(SplashWelcomeView.this);
                }
              }
            }
            y.i("SplashWelcomeView", "cannot find %s", new Object[] { str1 });
          }
        }, "readWelcomeBg");
        return;
        if (i != 2) {
          break;
        }
        y.i("SplashWelcomeView", "last launch status is 'end'.");
        break;
        y.i("SplashWelcomeView", "change launch image activity is finished!");
        com.tencent.mm.a.e.deleteFile(str1);
      }
      return;
    }
  }
  
  public final void aXH()
  {
    y.i("SplashWelcomeView", "hasDrawed:%s", new Object[] { Boolean.valueOf(this.hasDrawed) });
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if ((this.uRb) && (!this.uRa)) {
        cAf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.SplashWelcomeView
 * JD-Core Version:    0.7.0.1
 */