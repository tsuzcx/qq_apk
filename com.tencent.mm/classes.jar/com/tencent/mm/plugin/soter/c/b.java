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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.g.b.a;
import java.lang.ref.WeakReference;

public final class b
  extends c
{
  d FhA;
  ImageView FhB;
  private final int FhC;
  private int FhD;
  private final long FhE;
  Animation FhF;
  Animation FhG;
  Runnable FhH;
  boolean Fhz;
  Handler mMainHandler;
  TextView nnA;
  com.tencent.soter.a.d.a wFx;
  
  public b(WeakReference<Activity> paramWeakReference, com.tencent.mm.plugin.soter.d.j paramj, k paramk, Handler paramHandler)
  {
    super(paramWeakReference, paramj, paramk, paramHandler);
    AppMethodBeat.i(145958);
    this.Fhz = false;
    this.wFx = null;
    this.FhA = null;
    this.FhB = null;
    this.nnA = null;
    this.FhC = 3;
    this.FhD = 0;
    this.FhE = 500L;
    this.FhF = null;
    this.FhG = null;
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.FhH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145957);
        b.this.nnA.setTextColor(b.this.nnA.getResources().getColor(2131100592));
        b.this.nnA.setText(b.this.nnA.getResources().getString(2131766335));
        b.this.FhB.setImageResource(2131232760);
        AppMethodBeat.o(145957);
      }
    };
    AppMethodBeat.o(145958);
  }
  
  private boolean flB()
  {
    AppMethodBeat.i(145960);
    flD();
    Log.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    Log.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.mScene);
    com.tencent.soter.a.a.a(local1, false, this.mScene, this.FhP, this.FhQ);
    AppMethodBeat.o(145960);
    return false;
  }
  
  private void flC()
  {
    AppMethodBeat.i(145962);
    this.wFx = new com.tencent.soter.a.d.a();
    com.tencent.soter.a.b.b local3 = new com.tencent.soter.a.b.b() {};
    com.tencent.soter.a.d.b local4 = new com.tencent.soter.a.d.b()
    {
      public final void fly()
      {
        AppMethodBeat.i(145946);
        Log.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
        b.this.Fhz = true;
        AppMethodBeat.o(145946);
      }
      
      public final void flz()
      {
        AppMethodBeat.i(145948);
        Log.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
        b.this.Fhz = false;
        b.this.wFx = null;
        b localb = b.this;
        localb.nnA.removeCallbacks(localb.FhH);
        localb.FhB.setImageResource(2131232762);
        localb.nnA.setTextColor(localb.nnA.getResources().getColor(2131101230));
        localb.nnA.setText(localb.nnA.getResources().getString(2131766336));
        AppMethodBeat.o(145948);
      }
      
      public final void onAuthenticationCancelled()
      {
        AppMethodBeat.i(145950);
        Log.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
        b.this.wFx = null;
        AppMethodBeat.o(145950);
      }
      
      public final void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(145951);
        Log.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        AppMethodBeat.o(145951);
      }
      
      public final void onAuthenticationFailed()
      {
        AppMethodBeat.i(145949);
        Log.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
        b localb = b.this;
        String str = MMApplicationContext.getContext().getString(2131766332);
        if (localb.FhF == null) {
          localb.FhF = b.he(localb.FhB.getContext());
        }
        if (localb.FhG == null) {
          localb.FhG = b.he(localb.FhB.getContext());
        }
        localb.FhF.setAnimationListener(new b.8(localb, str));
        localb.nnA.startAnimation(localb.FhF);
        localb.FhB.startAnimation(localb.FhG);
        b.this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(145945);
            b.this.Fhz = false;
            b.a(b.this, true);
            AppMethodBeat.o(145945);
          }
        }, 500L);
        AppMethodBeat.o(145949);
      }
      
      public final void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(145947);
        Log.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        AppMethodBeat.o(145947);
      }
    };
    b.a locala = new b.a().aqL(this.mScene).lh(MMApplicationContext.getContext());
    com.tencent.soter.a.d.a locala1 = this.wFx;
    locala.RQV.wFx = locala1;
    locala = locala.bqn(this.FhN.wFE);
    locala.RQV.RQQ = null;
    locala.RQV.RQS = local4;
    com.tencent.soter.a.a.a(local3, locala.RQV);
    AppMethodBeat.o(145962);
  }
  
  public static Animation he(Context paramContext)
  {
    AppMethodBeat.i(145965);
    if (paramContext == null)
    {
      Log.e("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
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
  public final void gA()
  {
    AppMethodBeat.i(145959);
    if (!com.tencent.soter.core.a.ld(MMApplicationContext.getContext()))
    {
      this.FhO.errCode = 90011;
      this.FhO.errMsg = "no fingerprint enrolled";
      flH();
    }
    try
    {
      if (MMApplicationContext.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(new String[] { "android.permission.USE_FINGERPRINT" });
        com.tencent.mm.hellhoundlib.a.a.a(this, locala.axQ(), "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        requestPermissions((String[])locala.pG(0), ((Integer)locala.pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        AppMethodBeat.o(145959);
        return;
      }
      this.Fhz = true;
      AppMethodBeat.o(145959);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      Log.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
      this.Fhz = true;
      AppMethodBeat.o(145959);
    }
  }
  
  @TargetApi(16)
  public final void onPause()
  {
    AppMethodBeat.i(145964);
    if ((this.Fhz) && (this.wFx != null)) {
      this.wFx.DR(true);
    }
    if ((this.FhA != null) && (this.FhA.isShowing())) {
      this.FhA.dismiss();
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
        Log.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        flB();
        this.Fhz = true;
        AppMethodBeat.o(145961);
        return;
      }
      Log.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
      this.FhO.errCode = 90002;
      this.FhO.errMsg = "user not grant to use fingerprint";
      flH();
    }
    AppMethodBeat.o(145961);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145963);
    if (this.Fhz) {
      flB();
    }
    AppMethodBeat.o(145963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b
 * JD-Core Version:    0.7.0.1
 */