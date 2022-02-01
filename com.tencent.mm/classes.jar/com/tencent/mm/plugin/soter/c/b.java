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
  TextView kXs;
  Handler mMainHandler;
  com.tencent.soter.a.d.a rcc;
  boolean yaj;
  d yak;
  ImageView yal;
  private final int yam;
  private int yan;
  private final long yao;
  Animation yap;
  Animation yaq;
  Runnable yar;
  
  public b(WeakReference<Activity> paramWeakReference, com.tencent.mm.plugin.soter.d.j paramj, k paramk, Handler paramHandler)
  {
    super(paramWeakReference, paramj, paramk, paramHandler);
    AppMethodBeat.i(145958);
    this.yaj = false;
    this.rcc = null;
    this.yak = null;
    this.yal = null;
    this.kXs = null;
    this.yam = 3;
    this.yan = 0;
    this.yao = 500L;
    this.yap = null;
    this.yaq = null;
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.yar = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145957);
        b.this.kXs.setTextColor(b.this.kXs.getResources().getColor(2131100488));
        b.this.kXs.setText(b.this.kXs.getResources().getString(2131764093));
        b.this.yal.setImageResource(2131232387);
        AppMethodBeat.o(145957);
      }
    };
    AppMethodBeat.o(145958);
  }
  
  private boolean dEG()
  {
    AppMethodBeat.i(145960);
    dEI();
    ad.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    ad.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.mScene);
    com.tencent.soter.a.a.a(local1, false, this.mScene, this.yaA, this.yaB);
    AppMethodBeat.o(145960);
    return false;
  }
  
  private void dEH()
  {
    AppMethodBeat.i(145962);
    this.rcc = new com.tencent.soter.a.d.a();
    com.tencent.soter.a.b.b local3 = new com.tencent.soter.a.b.b() {};
    com.tencent.soter.a.d.b local4 = new com.tencent.soter.a.d.b()
    {
      public final void dED()
      {
        AppMethodBeat.i(145946);
        ad.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
        b.this.yaj = true;
        AppMethodBeat.o(145946);
      }
      
      public final void dEE()
      {
        AppMethodBeat.i(145948);
        ad.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
        b.this.yaj = false;
        b.this.rcc = null;
        b localb = b.this;
        localb.kXs.removeCallbacks(localb.yar);
        localb.yal.setImageResource(2131232389);
        localb.kXs.setTextColor(localb.kXs.getResources().getColor(2131101000));
        localb.kXs.setText(localb.kXs.getResources().getString(2131764094));
        AppMethodBeat.o(145948);
      }
      
      public final void onAuthenticationCancelled()
      {
        AppMethodBeat.i(145950);
        ad.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
        b.this.rcc = null;
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
        if (localb.yap == null) {
          localb.yap = b.fZ(localb.yal.getContext());
        }
        if (localb.yaq == null) {
          localb.yaq = b.fZ(localb.yal.getContext());
        }
        localb.yap.setAnimationListener(new b.8(localb, str));
        localb.kXs.startAnimation(localb.yap);
        localb.yal.startAnimation(localb.yaq);
        b.this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(145945);
            b.this.yaj = false;
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
    b.a locala = new b.a().abW(this.mScene).kH(aj.getContext());
    com.tencent.soter.a.d.a locala1 = this.rcc;
    locala.IvW.rcc = locala1;
    locala = locala.aNV(this.yay.rcj);
    locala.IvW.IvR = null;
    locala.IvW.IvT = local4;
    com.tencent.soter.a.a.a(local3, locala.IvW);
    AppMethodBeat.o(145962);
  }
  
  public static Animation fZ(Context paramContext)
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
  public final void fT()
  {
    AppMethodBeat.i(145959);
    if (!com.tencent.soter.core.a.kD(aj.getContext()))
    {
      this.yaz.errCode = 90011;
      this.yaz.errMsg = "no fingerprint enrolled";
      dEM();
    }
    try
    {
      if (aj.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bd(new String[] { "android.permission.USE_FINGERPRINT" });
        com.tencent.mm.hellhoundlib.a.a.a(this, locala.adn(), "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        requestPermissions((String[])locala.lS(0), ((Integer)locala.lS(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        AppMethodBeat.o(145959);
        return;
      }
      this.yaj = true;
      AppMethodBeat.o(145959);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      ad.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
      this.yaj = true;
      AppMethodBeat.o(145959);
    }
  }
  
  @TargetApi(16)
  public final void onPause()
  {
    AppMethodBeat.i(145964);
    if ((this.yaj) && (this.rcc != null)) {
      this.rcc.xw(true);
    }
    if ((this.yak != null) && (this.yak.isShowing())) {
      this.yak.dismiss();
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
        dEG();
        this.yaj = true;
        AppMethodBeat.o(145961);
        return;
      }
      ad.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
      this.yaz.errCode = 90002;
      this.yaz.errMsg = "user not grant to use fingerprint";
      dEM();
    }
    AppMethodBeat.o(145961);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145963);
    if (this.yaj) {
      dEG();
    }
    AppMethodBeat.o(145963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b
 * JD-Core Version:    0.7.0.1
 */