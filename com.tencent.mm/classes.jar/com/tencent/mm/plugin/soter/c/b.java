package com.tencent.mm.plugin.soter.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.g.b.a;
import java.lang.ref.WeakReference;

public final class b
  extends c
{
  TextView gSp = null;
  com.tencent.soter.a.d.a klx = null;
  Handler mMainHandler = new Handler(Looper.getMainLooper());
  boolean prR = false;
  android.support.v7.app.b prS = null;
  ImageView prT = null;
  private final int prU = 3;
  private int prV = 0;
  private final long prW = 500L;
  Animation prX = null;
  Animation prY = null;
  Runnable prZ = new b.9(this);
  
  public b(WeakReference<Activity> paramWeakReference, j paramj, k paramk, Handler paramHandler)
  {
    super(paramWeakReference, paramj, paramk, paramHandler);
  }
  
  private boolean bKG()
  {
    bKI();
    y.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
    b.1 local1 = new b.1(this);
    y.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.fzn);
    com.tencent.soter.a.a.a(local1, false, this.fzn, this.psg, this.psh);
    return false;
  }
  
  private void bKH()
  {
    this.klx = new com.tencent.soter.a.d.a();
    b.3 local3 = new b.3(this);
    b.4 local4 = new b.4(this);
    b.a locala = new b.a().Js(this.fzn).hM(ae.getContext()).a(this.klx).afV(this.pse.klM);
    locala.wPV.wPR = null;
    com.tencent.soter.a.a.a(local3, locala.a(local4).wPV);
  }
  
  public static Animation eh(Context paramContext)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
      return null;
    }
    paramContext = AnimationUtils.loadAnimation(paramContext, a.a.anim_flash);
    if (-1L > 0L) {
      paramContext.setDuration(-1L);
    }
    paramContext.setInterpolator(new DecelerateInterpolator());
    return paramContext;
  }
  
  @TargetApi(23)
  public final void ef()
  {
    if (!com.tencent.soter.core.a.hH(ae.getContext()))
    {
      this.psf.errCode = 90011;
      this.psf.aox = "no fingerprint enrolled";
      bKM();
    }
    try
    {
      if (ae.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0)
      {
        A(new String[] { "android.permission.USE_FINGERPRINT" });
        return;
      }
      this.prR = true;
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      y.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
      this.prR = true;
    }
  }
  
  @TargetApi(16)
  public final void onPause()
  {
    if ((this.prR) && (this.klx != null)) {
      this.klx.ol(true);
    }
    if ((this.prS != null) && (this.prS.isShowing())) {
      this.prS.dismiss();
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 0)
    {
      if ((paramArrayOfString.length > 0) && (paramArrayOfInt.length > 0) && ("android.permission.USE_FINGERPRINT".equals(paramArrayOfString[0])) && (paramArrayOfInt[0] == 0))
      {
        y.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        bKG();
        this.prR = true;
      }
    }
    else {
      return;
    }
    y.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
    this.psf.errCode = 90002;
    this.psf.aox = "user not grant to use fingerprint";
    bKM();
  }
  
  public final void onResume()
  {
    if (this.prR) {
      bKG();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b
 * JD-Core Version:    0.7.0.1
 */