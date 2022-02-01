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
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.a.b;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.plugin.soter.a.f;
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
  com.tencent.soter.a.d.a Byu;
  boolean Lwe;
  d Lwf;
  ImageView Lwg;
  private final int Lwh;
  private int Lwi;
  private final long Lwj;
  Animation Lwk;
  Animation Lwl;
  Runnable Lwm;
  Handler mMainHandler;
  TextView qph;
  
  public b(WeakReference<Activity> paramWeakReference, com.tencent.mm.plugin.soter.d.j paramj, k paramk, Handler paramHandler)
  {
    super(paramWeakReference, paramj, paramk, paramHandler);
    AppMethodBeat.i(145958);
    this.Lwe = false;
    this.Byu = null;
    this.Lwf = null;
    this.Lwg = null;
    this.qph = null;
    this.Lwh = 3;
    this.Lwi = 0;
    this.Lwj = 500L;
    this.Lwk = null;
    this.Lwl = null;
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.Lwm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145957);
        b.this.qph.setTextColor(b.this.qph.getResources().getColor(a.b.hint_color));
        b.this.qph.setText(b.this.qph.getResources().getString(a.f.soter_mp_fingerprint_hint));
        b.this.Lwg.setImageResource(a.c.fingerprint_luggage_icon);
        AppMethodBeat.o(145957);
      }
    };
    AppMethodBeat.o(145958);
  }
  
  private boolean fZX()
  {
    AppMethodBeat.i(145960);
    fZZ();
    Log.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    Log.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.mScene);
    com.tencent.soter.a.a.a(local1, false, this.mScene, this.Lwu, this.Lwv);
    AppMethodBeat.o(145960);
    return false;
  }
  
  private void fZY()
  {
    AppMethodBeat.i(145962);
    this.Byu = new com.tencent.soter.a.d.a();
    com.tencent.soter.a.b.b local3 = new com.tencent.soter.a.b.b() {};
    com.tencent.soter.a.d.b local4 = new com.tencent.soter.a.d.b()
    {
      public final void fZU()
      {
        AppMethodBeat.i(145946);
        Log.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
        b.this.Lwe = true;
        AppMethodBeat.o(145946);
      }
      
      public final void fZV()
      {
        AppMethodBeat.i(145948);
        Log.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
        b.this.Lwe = false;
        b.this.Byu = null;
        b localb = b.this;
        localb.qph.removeCallbacks(localb.Lwm);
        localb.Lwg.setImageResource(a.c.fingerprint_luggage_icon_succes);
        localb.qph.setTextColor(localb.qph.getResources().getColor(a.b.success_color));
        localb.qph.setText(localb.qph.getResources().getString(a.f.soter_mp_fingerprint_success));
        AppMethodBeat.o(145948);
      }
      
      public final void onAuthenticationCancelled()
      {
        AppMethodBeat.i(145950);
        Log.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
        b.this.Byu = null;
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
        if (localb.Lwk == null) {
          localb.Lwk = b.jdMethod_if(localb.Lwg.getContext());
        }
        if (localb.Lwl == null) {
          localb.Lwl = b.jdMethod_if(localb.Lwg.getContext());
        }
        localb.Lwk.setAnimationListener(new b.8(localb, str));
        localb.qph.startAnimation(localb.Lwk);
        localb.Lwg.startAnimation(localb.Lwl);
        b.this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(145945);
            b.this.Lwe = false;
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
    b.a locala = new b.a().aAy(this.mScene).mf(MMApplicationContext.getContext());
    com.tencent.soter.a.d.a locala1 = this.Byu;
    locala.Ztz.Byu = locala1;
    locala = locala.bDg(this.Lws.ByB);
    locala.Ztz.Ztu = null;
    locala.Ztz.Ztw = local4;
    com.tencent.soter.a.a.a(local3, locala.Ztz);
    AppMethodBeat.o(145962);
  }
  
  public static Animation jdMethod_if(Context paramContext)
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
  
  @TargetApi(23)
  public final void aI()
  {
    AppMethodBeat.i(145959);
    if (!com.tencent.soter.core.a.mb(MMApplicationContext.getContext()))
    {
      this.Lwt.errCode = 90011;
      this.Lwt.errMsg = "no fingerprint enrolled";
      gad();
    }
    try
    {
      if (MMApplicationContext.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(new String[] { "android.permission.USE_FINGERPRINT" });
        com.tencent.mm.hellhoundlib.a.a.b(this, locala.aFh(), "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        requestPermissions((String[])locala.sf(0), ((Integer)locala.sf(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        AppMethodBeat.o(145959);
        return;
      }
      this.Lwe = true;
      AppMethodBeat.o(145959);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      Log.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
      this.Lwe = true;
      AppMethodBeat.o(145959);
    }
  }
  
  @TargetApi(16)
  public final void onPause()
  {
    AppMethodBeat.i(145964);
    if ((this.Lwe) && (this.Byu != null)) {
      this.Byu.Is(true);
    }
    if ((this.Lwf != null) && (this.Lwf.isShowing())) {
      this.Lwf.dismiss();
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
        fZX();
        this.Lwe = true;
        AppMethodBeat.o(145961);
        return;
      }
      Log.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
      this.Lwt.errCode = 90002;
      this.Lwt.errMsg = "user not grant to use fingerprint";
      gad();
    }
    AppMethodBeat.o(145961);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145963);
    if (this.Lwe) {
      fZX();
    }
    AppMethodBeat.o(145963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b
 * JD-Core Version:    0.7.0.1
 */