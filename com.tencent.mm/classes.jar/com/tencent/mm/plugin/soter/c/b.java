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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.g.b.a;
import java.lang.ref.WeakReference;

public final class b
  extends c
{
  boolean AWG;
  d AWH;
  ImageView AWI;
  private final int AWJ;
  private int AWK;
  private final long AWL;
  Animation AWM;
  Animation AWN;
  Runnable AWO;
  Handler mMainHandler;
  TextView mdh;
  com.tencent.soter.a.d.a trR;
  
  public b(WeakReference<Activity> paramWeakReference, com.tencent.mm.plugin.soter.d.j paramj, k paramk, Handler paramHandler)
  {
    super(paramWeakReference, paramj, paramk, paramHandler);
    AppMethodBeat.i(145958);
    this.AWG = false;
    this.trR = null;
    this.AWH = null;
    this.AWI = null;
    this.mdh = null;
    this.AWJ = 3;
    this.AWK = 0;
    this.AWL = 500L;
    this.AWM = null;
    this.AWN = null;
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.AWO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145957);
        b.this.mdh.setTextColor(b.this.mdh.getResources().getColor(2131100488));
        b.this.mdh.setText(b.this.mdh.getResources().getString(2131764093));
        b.this.AWI.setImageResource(2131232387);
        AppMethodBeat.o(145957);
      }
    };
    AppMethodBeat.o(145958);
  }
  
  private boolean ejb()
  {
    AppMethodBeat.i(145960);
    ejd();
    ae.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    ae.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.mScene);
    com.tencent.soter.a.a.a(local1, false, this.mScene, this.AWW, this.AWX);
    AppMethodBeat.o(145960);
    return false;
  }
  
  private void ejc()
  {
    AppMethodBeat.i(145962);
    this.trR = new com.tencent.soter.a.d.a();
    com.tencent.soter.a.b.b local3 = new com.tencent.soter.a.b.b() {};
    com.tencent.soter.a.d.b local4 = new com.tencent.soter.a.d.b()
    {
      public final void eiY()
      {
        AppMethodBeat.i(145946);
        ae.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
        b.this.AWG = true;
        AppMethodBeat.o(145946);
      }
      
      public final void eiZ()
      {
        AppMethodBeat.i(145948);
        ae.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
        b.this.AWG = false;
        b.this.trR = null;
        b localb = b.this;
        localb.mdh.removeCallbacks(localb.AWO);
        localb.AWI.setImageResource(2131232389);
        localb.mdh.setTextColor(localb.mdh.getResources().getColor(2131101000));
        localb.mdh.setText(localb.mdh.getResources().getString(2131764094));
        AppMethodBeat.o(145948);
      }
      
      public final void onAuthenticationCancelled()
      {
        AppMethodBeat.i(145950);
        ae.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
        b.this.trR = null;
        AppMethodBeat.o(145950);
      }
      
      public final void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(145951);
        ae.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        AppMethodBeat.o(145951);
      }
      
      public final void onAuthenticationFailed()
      {
        AppMethodBeat.i(145949);
        ae.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
        b localb = b.this;
        String str = ak.getContext().getString(2131764090);
        if (localb.AWM == null) {
          localb.AWM = b.gt(localb.AWI.getContext());
        }
        if (localb.AWN == null) {
          localb.AWN = b.gt(localb.AWI.getContext());
        }
        localb.AWM.setAnimationListener(new b.8(localb, str));
        localb.mdh.startAnimation(localb.AWM);
        localb.AWI.startAnimation(localb.AWN);
        b.this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(145945);
            b.this.AWG = false;
            b.a(b.this, true);
            AppMethodBeat.o(145945);
          }
        }, 500L);
        AppMethodBeat.o(145949);
      }
      
      public final void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(145947);
        ae.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        AppMethodBeat.o(145947);
      }
    };
    b.a locala = new b.a().ahy(this.mScene).lm(ak.getContext());
    com.tencent.soter.a.d.a locala1 = this.trR;
    locala.Mox.trR = locala1;
    locala = locala.bbb(this.AWU.trY);
    locala.Mox.Mos = null;
    locala.Mox.Mou = local4;
    com.tencent.soter.a.a.a(local3, locala.Mox);
    AppMethodBeat.o(145962);
  }
  
  public static Animation gt(Context paramContext)
  {
    AppMethodBeat.i(145965);
    if (paramContext == null)
    {
      ae.e("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
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
    if (!com.tencent.soter.core.a.li(ak.getContext()))
    {
      this.AWV.errCode = 90011;
      this.AWV.errMsg = "no fingerprint enrolled";
      ejh();
    }
    try
    {
      if (ak.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bc(new String[] { "android.permission.USE_FINGERPRINT" });
        com.tencent.mm.hellhoundlib.a.a.a(this, locala.ahE(), "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        requestPermissions((String[])locala.mt(0), ((Integer)locala.mt(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        AppMethodBeat.o(145959);
        return;
      }
      this.AWG = true;
      AppMethodBeat.o(145959);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      ae.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
      this.AWG = true;
      AppMethodBeat.o(145959);
    }
  }
  
  @TargetApi(16)
  public final void onPause()
  {
    AppMethodBeat.i(145964);
    if ((this.AWG) && (this.trR != null)) {
      this.trR.zH(true);
    }
    if ((this.AWH != null) && (this.AWH.isShowing())) {
      this.AWH.dismiss();
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
        ae.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        ejb();
        this.AWG = true;
        AppMethodBeat.o(145961);
        return;
      }
      ae.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
      this.AWV.errCode = 90002;
      this.AWV.errMsg = "user not grant to use fingerprint";
      ejh();
    }
    AppMethodBeat.o(145961);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145963);
    if (this.AWG) {
      ejb();
    }
    AppMethodBeat.o(145963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b
 * JD-Core Version:    0.7.0.1
 */