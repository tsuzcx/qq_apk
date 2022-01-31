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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.soter.a.g.b.a;
import java.lang.ref.WeakReference;

public final class b
  extends c
{
  TextView iuP;
  com.tencent.soter.a.d.a mGl;
  Handler mMainHandler;
  boolean snT;
  android.support.v7.app.b snU;
  ImageView snV;
  private final int snW;
  private int snX;
  private final long snY;
  Animation snZ;
  Animation soa;
  Runnable sob;
  
  public b(WeakReference<Activity> paramWeakReference, j paramj, k paramk, Handler paramHandler)
  {
    super(paramWeakReference, paramj, paramk, paramHandler);
    AppMethodBeat.i(73881);
    this.snT = false;
    this.mGl = null;
    this.snU = null;
    this.snV = null;
    this.iuP = null;
    this.snW = 3;
    this.snX = 0;
    this.snY = 500L;
    this.snZ = null;
    this.soa = null;
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.sob = new b.9(this);
    AppMethodBeat.o(73881);
  }
  
  private boolean cxS()
  {
    AppMethodBeat.i(73883);
    cxU();
    ab.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
    b.1 local1 = new b.1(this);
    ab.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.mScene);
    com.tencent.soter.a.a.a(local1, false, this.mScene, this.soi, this.soj);
    AppMethodBeat.o(73883);
    return false;
  }
  
  private void cxT()
  {
    AppMethodBeat.i(73885);
    this.mGl = new com.tencent.soter.a.d.a();
    b.3 local3 = new b.3(this);
    b.4 local4 = new b.4(this);
    b.a locala = new b.a().So(this.mScene).jn(ah.getContext()).a(this.mGl).awQ(this.sog.mGC);
    locala.Bnv.Bnr = null;
    com.tencent.soter.a.a.a(local3, locala.a(local4).Bnv);
    AppMethodBeat.o(73885);
  }
  
  public static Animation eY(Context paramContext)
  {
    AppMethodBeat.i(73888);
    if (paramContext == null)
    {
      ab.e("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
      AppMethodBeat.o(73888);
      return null;
    }
    paramContext = AnimationUtils.loadAnimation(paramContext, 2131034129);
    if (-1L > 0L) {
      paramContext.setDuration(-1L);
    }
    paramContext.setInterpolator(new DecelerateInterpolator());
    AppMethodBeat.o(73888);
    return paramContext;
  }
  
  @TargetApi(23)
  public final void eB()
  {
    AppMethodBeat.i(73882);
    if (!com.tencent.soter.core.a.ji(ah.getContext()))
    {
      this.soh.errCode = 90011;
      this.soh.errMsg = "no fingerprint enrolled";
      cxY();
    }
    try
    {
      if (ah.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0)
      {
        G(new String[] { "android.permission.USE_FINGERPRINT" });
        AppMethodBeat.o(73882);
        return;
      }
      this.snT = true;
      AppMethodBeat.o(73882);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      ab.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
      this.snT = true;
      AppMethodBeat.o(73882);
    }
  }
  
  @TargetApi(16)
  public final void onPause()
  {
    AppMethodBeat.i(73887);
    if ((this.snT) && (this.mGl != null)) {
      this.mGl.rX(true);
    }
    if ((this.snU != null) && (this.snU.isShowing())) {
      this.snU.dismiss();
    }
    AppMethodBeat.o(73887);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(73884);
    if (paramInt == 0)
    {
      if ((paramArrayOfString.length > 0) && (paramArrayOfInt.length > 0) && ("android.permission.USE_FINGERPRINT".equals(paramArrayOfString[0])) && (paramArrayOfInt[0] == 0))
      {
        ab.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        cxS();
        this.snT = true;
        AppMethodBeat.o(73884);
        return;
      }
      ab.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
      this.soh.errCode = 90002;
      this.soh.errMsg = "user not grant to use fingerprint";
      cxY();
    }
    AppMethodBeat.o(73884);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(73886);
    if (this.snT) {
      cxS();
    }
    AppMethodBeat.o(73886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b
 * JD-Core Version:    0.7.0.1
 */