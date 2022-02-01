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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.g.b.a;
import java.lang.ref.WeakReference;

public final class b
  extends c
{
  TextView lzc;
  Handler mMainHandler;
  com.tencent.soter.a.d.a skw;
  boolean znj;
  d znk;
  ImageView znl;
  private final int znm;
  private int znn;
  private final long zno;
  Animation znp;
  Animation znq;
  Runnable znr;
  
  public b(WeakReference<Activity> paramWeakReference, com.tencent.mm.plugin.soter.d.j paramj, k paramk, Handler paramHandler)
  {
    super(paramWeakReference, paramj, paramk, paramHandler);
    AppMethodBeat.i(145958);
    this.znj = false;
    this.skw = null;
    this.znk = null;
    this.znl = null;
    this.lzc = null;
    this.znm = 3;
    this.znn = 0;
    this.zno = 500L;
    this.znp = null;
    this.znq = null;
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.znr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145957);
        b.this.lzc.setTextColor(b.this.lzc.getResources().getColor(2131100488));
        b.this.lzc.setText(b.this.lzc.getResources().getString(2131764093));
        b.this.znl.setImageResource(2131232387);
        AppMethodBeat.o(145957);
      }
    };
    AppMethodBeat.o(145958);
  }
  
  private boolean dTf()
  {
    AppMethodBeat.i(145960);
    dTh();
    ac.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    ac.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.mScene);
    com.tencent.soter.a.a.a(local1, false, this.mScene, this.znz, this.znA);
    AppMethodBeat.o(145960);
    return false;
  }
  
  private void dTg()
  {
    AppMethodBeat.i(145962);
    this.skw = new com.tencent.soter.a.d.a();
    com.tencent.soter.a.b.b local3 = new com.tencent.soter.a.b.b() {};
    com.tencent.soter.a.d.b local4 = new com.tencent.soter.a.d.b()
    {
      public final void dTc()
      {
        AppMethodBeat.i(145946);
        ac.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
        b.this.znj = true;
        AppMethodBeat.o(145946);
      }
      
      public final void dTd()
      {
        AppMethodBeat.i(145948);
        ac.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
        b.this.znj = false;
        b.this.skw = null;
        b localb = b.this;
        localb.lzc.removeCallbacks(localb.znr);
        localb.znl.setImageResource(2131232389);
        localb.lzc.setTextColor(localb.lzc.getResources().getColor(2131101000));
        localb.lzc.setText(localb.lzc.getResources().getString(2131764094));
        AppMethodBeat.o(145948);
      }
      
      public final void onAuthenticationCancelled()
      {
        AppMethodBeat.i(145950);
        ac.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
        b.this.skw = null;
        AppMethodBeat.o(145950);
      }
      
      public final void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(145951);
        ac.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        AppMethodBeat.o(145951);
      }
      
      public final void onAuthenticationFailed()
      {
        AppMethodBeat.i(145949);
        ac.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
        b localb = b.this;
        String str = ai.getContext().getString(2131764090);
        if (localb.znp == null) {
          localb.znp = b.gl(localb.znl.getContext());
        }
        if (localb.znq == null) {
          localb.znq = b.gl(localb.znl.getContext());
        }
        localb.znp.setAnimationListener(new b.8(localb, str));
        localb.lzc.startAnimation(localb.znp);
        localb.znl.startAnimation(localb.znq);
        b.this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(145945);
            b.this.znj = false;
            b.a(b.this, true);
            AppMethodBeat.o(145945);
          }
        }, 500L);
        AppMethodBeat.o(145949);
      }
      
      public final void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(145947);
        ac.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        AppMethodBeat.o(145947);
      }
    };
    b.a locala = new b.a().aep(this.mScene).kT(ai.getContext());
    com.tencent.soter.a.d.a locala1 = this.skw;
    locala.JXF.skw = locala1;
    locala = locala.aTy(this.znx.skD);
    locala.JXF.JXA = null;
    locala.JXF.JXC = local4;
    com.tencent.soter.a.a.a(local3, locala.JXF);
    AppMethodBeat.o(145962);
  }
  
  public static Animation gl(Context paramContext)
  {
    AppMethodBeat.i(145965);
    if (paramContext == null)
    {
      ac.e("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
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
  public final void gb()
  {
    AppMethodBeat.i(145959);
    if (!com.tencent.soter.core.a.kP(ai.getContext()))
    {
      this.zny.errCode = 90011;
      this.zny.errMsg = "no fingerprint enrolled";
      dTl();
    }
    try
    {
      if (ai.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).ba(new String[] { "android.permission.USE_FINGERPRINT" });
        com.tencent.mm.hellhoundlib.a.a.a(this, locala.aeD(), "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        requestPermissions((String[])locala.lR(0), ((Integer)locala.lR(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        AppMethodBeat.o(145959);
        return;
      }
      this.znj = true;
      AppMethodBeat.o(145959);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      ac.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
      this.znj = true;
      AppMethodBeat.o(145959);
    }
  }
  
  @TargetApi(16)
  public final void onPause()
  {
    AppMethodBeat.i(145964);
    if ((this.znj) && (this.skw != null)) {
      this.skw.yG(true);
    }
    if ((this.znk != null) && (this.znk.isShowing())) {
      this.znk.dismiss();
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
        ac.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        dTf();
        this.znj = true;
        AppMethodBeat.o(145961);
        return;
      }
      ac.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
      this.zny.errCode = 90002;
      this.zny.errMsg = "user not grant to use fingerprint";
      dTl();
    }
    AppMethodBeat.o(145961);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145963);
    if (this.znj) {
      dTf();
    }
    AppMethodBeat.o(145963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b
 * JD-Core Version:    0.7.0.1
 */