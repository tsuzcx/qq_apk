package com.tencent.mm.plugin.soter.c;

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
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.a.b;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.plugin.soter.a.f;
import com.tencent.mm.plugin.soter.model.g;
import com.tencent.mm.plugin.soter.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public final class b
  extends c
{
  com.tencent.soter.a.d.a HfW;
  boolean RZD;
  com.tencent.mm.ui.widget.a.e RZE;
  ImageView RZF;
  private final int RZG;
  private int RZH;
  private final long RZI;
  Animation RZJ;
  Animation RZK;
  Runnable RZL;
  Handler mMainHandler;
  TextView ttK;
  
  public b(WeakReference<Activity> paramWeakReference, g paramg, h paramh, Handler paramHandler)
  {
    super(paramWeakReference, paramg, paramh, paramHandler);
    AppMethodBeat.i(145958);
    this.RZD = false;
    this.HfW = null;
    this.RZE = null;
    this.RZF = null;
    this.ttK = null;
    this.RZG = 3;
    this.RZH = 0;
    this.RZI = 500L;
    this.RZJ = null;
    this.RZK = null;
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.RZL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145957);
        b.this.ttK.setTextColor(b.this.ttK.getResources().getColor(a.b.hint_color));
        b.this.ttK.setText(b.this.ttK.getResources().getString(a.f.soter_mp_fingerprint_hint));
        b.this.RZF.setImageResource(a.c.fingerprint_luggage_icon);
        AppMethodBeat.o(145957);
      }
    };
    AppMethodBeat.o(145958);
  }
  
  private boolean hto()
  {
    AppMethodBeat.i(145960);
    htq();
    Log.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    Log.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.mScene);
    com.tencent.soter.a.a.a(local1, false, this.mScene, this.RZT, this.RZU);
    AppMethodBeat.o(145960);
    return false;
  }
  
  private void htp()
  {
    AppMethodBeat.i(145962);
    this.HfW = new com.tencent.soter.a.d.a();
    com.tencent.soter.a.b.b local3 = new com.tencent.soter.a.b.b() {};
    com.tencent.soter.a.d.b local4 = new com.tencent.soter.a.d.b()
    {
      public final void htl()
      {
        AppMethodBeat.i(145946);
        Log.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
        b.this.RZD = true;
        AppMethodBeat.o(145946);
      }
      
      public final void htm()
      {
        AppMethodBeat.i(145948);
        Log.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
        b.this.RZD = false;
        b.this.HfW = null;
        b localb = b.this;
        localb.ttK.removeCallbacks(localb.RZL);
        localb.RZF.setImageResource(a.c.fingerprint_luggage_icon_succes);
        localb.ttK.setTextColor(localb.ttK.getResources().getColor(a.b.success_color));
        localb.ttK.setText(localb.ttK.getResources().getString(a.f.soter_mp_fingerprint_success));
        AppMethodBeat.o(145948);
      }
      
      public final void onAuthenticationCancelled()
      {
        AppMethodBeat.i(145950);
        Log.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
        b.this.HfW = null;
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
        String str = MMApplicationContext.getContext().getString(a.f.soter_fingerprint_unrecognized);
        if (localb.RZJ == null) {
          localb.RZJ = b.jV(localb.RZF.getContext());
        }
        if (localb.RZK == null) {
          localb.RZK = b.jV(localb.RZF.getContext());
        }
        localb.RZJ.setAnimationListener(new b.8(localb, str));
        localb.ttK.startAnimation(localb.RZJ);
        localb.RZF.startAnimation(localb.RZK);
        b.this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(145945);
            b.this.RZD = false;
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
    b.a locala = new b.a().aHk(this.mScene).os(MMApplicationContext.getContext());
    com.tencent.soter.a.d.a locala1 = this.HfW;
    locala.ahys.HfW = locala1;
    locala = locala.bFL(this.RZR.Hgd);
    locala.ahys.ahyi = null;
    locala.ahys.ahyp = local4;
    com.tencent.soter.a.a.a(local3, locala.ahys);
    AppMethodBeat.o(145962);
  }
  
  public static Animation jV(Context paramContext)
  {
    AppMethodBeat.i(145965);
    if (paramContext == null)
    {
      Log.e("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
      AppMethodBeat.o(145965);
      return null;
    }
    paramContext = AnimationUtils.loadAnimation(paramContext, a.a.anim_flash);
    if (-1L > 0L) {
      paramContext.setDuration(-1L);
    }
    paramContext.setInterpolator(new DecelerateInterpolator());
    AppMethodBeat.o(145965);
    return paramContext;
  }
  
  public final void bB()
  {
    AppMethodBeat.i(145959);
    if (!com.tencent.soter.core.a.oo(MMApplicationContext.getContext()))
    {
      this.RZS.errCode = 90011;
      this.RZS.errMsg = "no fingerprint enrolled";
      htu();
    }
    try
    {
      if (MMApplicationContext.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).cG(new String[] { "android.permission.USE_FINGERPRINT" });
        com.tencent.mm.hellhoundlib.a.a.b(this, locala.aYi(), "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        requestPermissions((String[])locala.sb(0), ((Integer)locala.sb(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        AppMethodBeat.o(145959);
        return;
      }
      this.RZD = true;
      AppMethodBeat.o(145959);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      Log.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
      this.RZD = true;
      AppMethodBeat.o(145959);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(145964);
    if ((this.RZD) && (this.HfW != null)) {
      this.HfW.Ou(true);
    }
    if ((this.RZE != null) && (this.RZE.isShowing())) {
      this.RZE.dismiss();
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
        hto();
        this.RZD = true;
        AppMethodBeat.o(145961);
        return;
      }
      Log.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
      this.RZS.errCode = 90002;
      this.RZS.errMsg = "user not grant to use fingerprint";
      htu();
    }
    AppMethodBeat.o(145961);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145963);
    if (this.RZD) {
      hto();
    }
    AppMethodBeat.o(145963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b
 * JD-Core Version:    0.7.0.1
 */