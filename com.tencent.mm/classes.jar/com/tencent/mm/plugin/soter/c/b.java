package com.tencent.mm.plugin.soter.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.g.b.a;
import java.lang.ref.WeakReference;

public final class b
  extends c
{
  boolean AFd;
  d AFe;
  ImageView AFf;
  private final int AFg;
  private int AFh;
  private final long AFi;
  Animation AFj;
  Animation AFk;
  Runnable AFl;
  TextView lYA;
  Handler mMainHandler;
  com.tencent.soter.a.d.a tgY;
  
  public b(WeakReference<Activity> paramWeakReference, com.tencent.mm.plugin.soter.d.j paramj, k paramk, Handler paramHandler)
  {
    super(paramWeakReference, paramj, paramk, paramHandler);
    AppMethodBeat.i(145958);
    this.AFd = false;
    this.tgY = null;
    this.AFe = null;
    this.AFf = null;
    this.lYA = null;
    this.AFg = 3;
    this.AFh = 0;
    this.AFi = 500L;
    this.AFj = null;
    this.AFk = null;
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.AFl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145957);
        b.this.lYA.setTextColor(b.this.lYA.getResources().getColor(2131100488));
        b.this.lYA.setText(b.this.lYA.getResources().getString(2131764093));
        b.this.AFf.setImageResource(2131232387);
        AppMethodBeat.o(145957);
      }
    };
    AppMethodBeat.o(145958);
  }
  
  private boolean eft()
  {
    AppMethodBeat.i(145960);
    efv();
    ad.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    ad.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.mScene);
    com.tencent.soter.a.a.a(local1, false, this.mScene, this.AFt, this.AFu);
    AppMethodBeat.o(145960);
    return false;
  }
  
  private void efu()
  {
    AppMethodBeat.i(145962);
    this.tgY = new com.tencent.soter.a.d.a();
    com.tencent.soter.a.b.b local3 = new com.tencent.soter.a.b.b() {};
    com.tencent.soter.a.d.b local4 = new com.tencent.soter.a.d.b()
    {
      public final void efq()
      {
        AppMethodBeat.i(145946);
        ad.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
        b.this.AFd = true;
        AppMethodBeat.o(145946);
      }
      
      public final void efr()
      {
        AppMethodBeat.i(145948);
        ad.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
        b.this.AFd = false;
        b.this.tgY = null;
        b localb = b.this;
        localb.lYA.removeCallbacks(localb.AFl);
        localb.AFf.setImageResource(2131232389);
        localb.lYA.setTextColor(localb.lYA.getResources().getColor(2131101000));
        localb.lYA.setText(localb.lYA.getResources().getString(2131764094));
        AppMethodBeat.o(145948);
      }
      
      public final void onAuthenticationCancelled()
      {
        AppMethodBeat.i(145950);
        ad.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
        b.this.tgY = null;
        AppMethodBeat.o(145950);
      }
      
      public final void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(145951);
        ad.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        AppMethodBeat.o(145951);
      }
      
      public final void onAuthenticationFailed()
      {
        AppMethodBeat.i(145949);
        ad.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
        b localb = b.this;
        String str = aj.getContext().getString(2131764090);
        if (localb.AFj == null) {
          localb.AFj = b.go(localb.AFf.getContext());
        }
        if (localb.AFk == null) {
          localb.AFk = b.go(localb.AFf.getContext());
        }
        localb.AFj.setAnimationListener(new b.8(localb, str));
        localb.lYA.startAnimation(localb.AFj);
        localb.AFf.startAnimation(localb.AFk);
        b.this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(145945);
            b.this.AFd = false;
            b.a(b.this, true);
            AppMethodBeat.o(145945);
          }
        }, 500L);
        AppMethodBeat.o(145949);
      }
      
      public final void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(145947);
        ad.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        AppMethodBeat.o(145947);
      }
    };
    b.a locala = new b.a().agP(this.mScene).lg(aj.getContext());
    com.tencent.soter.a.d.a locala1 = this.tgY;
    locala.LRA.tgY = locala1;
    locala = locala.aZy(this.AFr.thf);
    locala.LRA.LRv = null;
    locala.LRA.LRx = local4;
    com.tencent.soter.a.a.a(local3, locala.LRA);
    AppMethodBeat.o(145962);
  }
  
  public static Animation go(Context paramContext)
  {
    AppMethodBeat.i(145965);
    if (paramContext == null)
    {
      ad.e("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
      AppMethodBeat.o(145965);
      return null;
    }
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130771985);
    if (-1L > 0L) {
      paramContext.setDuration(-1L);
    }
    paramContext.setInterpolator(new DecelerateInterpolator());
    AppMethodBeat.o(145965);
    return paramContext;
  }
  
  @TargetApi(23)
  public final void gt()
  {
    AppMethodBeat.i(145959);
    if (!com.tencent.soter.core.a.lc(aj.getContext()))
    {
      this.AFs.errCode = 90011;
      this.AFs.errMsg = "no fingerprint enrolled";
      efz();
    }
    try
    {
      if (aj.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bc(new String[] { "android.permission.USE_FINGERPRINT" });
        com.tencent.mm.hellhoundlib.a.a.a(this, locala.ahp(), "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        requestPermissions((String[])locala.mq(0), ((Integer)locala.mq(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        AppMethodBeat.o(145959);
        return;
      }
      this.AFd = true;
      AppMethodBeat.o(145959);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      ad.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
      this.AFd = true;
      AppMethodBeat.o(145959);
    }
  }
  
  @TargetApi(16)
  public final void onPause()
  {
    AppMethodBeat.i(145964);
    if ((this.AFd) && (this.tgY != null)) {
      this.tgY.zt(true);
    }
    if ((this.AFe != null) && (this.AFe.isShowing())) {
      this.AFe.dismiss();
    }
    AppMethodBeat.o(145964);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(145961);
    if (paramInt == 0)
    {
      if ((paramArrayOfString.length > 0) && (paramArrayOfInt.length > 0) && ("android.permission.USE_FINGERPRINT".equals(paramArrayOfString[0])) && (paramArrayOfInt[0] == 0))
      {
        ad.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        eft();
        this.AFd = true;
        AppMethodBeat.o(145961);
        return;
      }
      ad.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
      this.AFs.errCode = 90002;
      this.AFs.errMsg = "user not grant to use fingerprint";
      efz();
    }
    AppMethodBeat.o(145961);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145963);
    if (this.AFd) {
      eft();
    }
    AppMethodBeat.o(145963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b
 * JD-Core Version:    0.7.0.1
 */