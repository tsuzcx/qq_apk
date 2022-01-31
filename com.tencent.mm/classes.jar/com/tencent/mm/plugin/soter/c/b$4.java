package com.tencent.mm.plugin.soter.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.soter.a.b;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.plugin.soter.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class b$4
  implements com.tencent.soter.a.d.b
{
  b$4(b paramb) {}
  
  public final void aTd()
  {
    y.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
    this.psa.prR = true;
  }
  
  public final void aTe()
  {
    y.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
    this.psa.prR = false;
    this.psa.klx = null;
    b localb = this.psa;
    localb.gSp.removeCallbacks(localb.prZ);
    localb.prT.setImageResource(a.c.fingerprint_luggage_icon_succes);
    localb.gSp.setTextColor(localb.gSp.getResources().getColor(a.b.success_color));
    localb.gSp.setText(localb.gSp.getResources().getString(a.f.soter_mp_fingerprint_success));
  }
  
  public final void onAuthenticationCancelled()
  {
    y.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
    this.psa.klx = null;
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    y.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
  }
  
  public final void onAuthenticationFailed()
  {
    y.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
    b localb = this.psa;
    String str = ae.getContext().getString(a.f.soter_fingerprint_unrecognized);
    if (localb.prX == null) {
      localb.prX = b.eh(localb.prT.getContext());
    }
    if (localb.prY == null) {
      localb.prY = b.eh(localb.prT.getContext());
    }
    localb.prX.setAnimationListener(new b.8(localb, str));
    localb.gSp.startAnimation(localb.prX);
    localb.prT.startAnimation(localb.prY);
    this.psa.mMainHandler.postDelayed(new b.4.1(this), 500L);
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    y.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.4
 * JD-Core Version:    0.7.0.1
 */