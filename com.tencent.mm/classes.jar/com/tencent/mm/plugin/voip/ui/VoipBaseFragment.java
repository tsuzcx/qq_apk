package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.lang.ref.WeakReference;

public abstract class VoipBaseFragment
  extends Fragment
{
  protected static final int[] AKc = { -1, 2131764901, 2131764928, 2131764927 };
  static int AKg = -1;
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected WeakReference<c> AJQ;
  protected long AJR = -1L;
  protected ImageView AKd;
  protected ImageView AKe;
  protected int AKf = 4096;
  protected d AKh;
  protected c AKi = new c();
  private VoipBaseFragment.a AKj;
  private VoipBaseFragment.b AKk;
  protected boolean AzH;
  protected String foE;
  protected ao jdu;
  protected int mStatus = -1;
  protected RelativeLayout wRY;
  
  protected static void au(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected static String qn(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  public void SE(int paramInt) {}
  
  public void SF(int paramInt) {}
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  public final void a(d paramd)
  {
    this.AKh = paramd;
  }
  
  @Deprecated
  public void a(CaptureView paramCaptureView) {}
  
  protected abstract void ayA(String paramString);
  
  @Deprecated
  public void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  @Deprecated
  public void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void ekY() {}
  
  public void ekZ() {}
  
  void ela() {}
  
  protected abstract void elc();
  
  public abstract void eld();
  
  @Deprecated
  public void elk() {}
  
  @Deprecated
  public OpenGlRender ell()
  {
    return null;
  }
  
  protected final void elm()
  {
    if ((this.foE == null) || (this.AKd.getVisibility() == 0)) {
      return;
    }
    this.AKd.setVisibility(0);
    this.AKj = new VoipBaseFragment.a(this);
    h.JZN.aS(this.AKj);
  }
  
  protected final void eln()
  {
    this.AKe.setVisibility(0);
    this.AKk = new VoipBaseFragment.b(this);
    h.JZN.aS(this.AKk);
  }
  
  @Deprecated
  public void ie(int paramInt1, int paramInt2) {}
  
  public void ih(int paramInt1, int paramInt2)
  {
    ac.m("MicroMsg.VoipBaseFragment", "newState: " + j.SR(paramInt2) + ", action: " + j.SR(paramInt1) + ", lastStatus: " + j.SR(AKg), new Object[0]);
    if ((AKg != this.mStatus) && (paramInt2 != this.mStatus)) {
      AKg = this.mStatus;
    }
    this.AKf = paramInt1;
    this.mStatus = paramInt2;
  }
  
  protected abstract void ii(int paramInt1, int paramInt2);
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (Build.VERSION.SDK_INT < 23)
    {
      if (mScreenWidth == 0)
      {
        paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
        mScreenWidth = paramActivity.getWidth();
        mScreenHeight = paramActivity.getHeight();
      }
      return;
    }
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getRealMetrics(localDisplayMetrics);
    mScreenWidth = localDisplayMetrics.widthPixels;
    mScreenHeight = localDisplayMetrics.heightPixels;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    this.foE = paramBundle.getString("key_username");
    this.AzH = paramBundle.getBoolean("key_isoutcall");
    if (-1 == this.mStatus) {
      this.mStatus = paramBundle.getInt("key_status");
    }
    this.jdu = new ao();
  }
  
  public void onDetach()
  {
    if (this.jdu != null) {
      this.jdu.removeCallbacksAndMessages(null);
    }
    this.AKh = null;
    super.onDetach();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  @Deprecated
  public void releaseSurfaceTexture() {}
  
  @Deprecated
  public void requestRender() {}
  
  protected abstract void sK(boolean paramBoolean);
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setVoicePlayDevice(int paramInt);
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public final void setVoipUIListener(c paramc)
  {
    this.AJQ = new WeakReference(paramc);
  }
  
  protected final void t(TextView paramTextView)
  {
    if (paramTextView == null)
    {
      ac.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
      return;
    }
    paramTextView.setText(2131764927);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(j, -2147483648));
    paramTextView.setWidth(paramTextView.getMeasuredWidth());
  }
  
  public void uninit()
  {
    ac.d("MicroMsg.VoipBaseFragment", "uninit");
    this.AKi.elo();
    c localc = this.AKi;
    ac.d("MicroMsg.DynamicTextWrap", "uninit");
    localc.elo();
    localc.bYO = null;
    if (this.AKj != null)
    {
      this.AKj.cancel();
      this.AKj = null;
    }
    if (this.AKk != null)
    {
      this.AKk.cancel();
      this.AKk = null;
    }
  }
  
  public final void yQ(long paramLong)
  {
    this.AJR = paramLong;
  }
  
  protected static final class c
  {
    int[] AKo;
    private int AKp;
    int AKq;
    TextView Up;
    au bYO;
    
    protected c()
    {
      AppMethodBeat.i(115371);
      this.bYO = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(115370);
          int i = VoipBaseFragment.c.this.AKo[(VoipBaseFragment.c.this.AKq % VoipBaseFragment.c.this.AKo.length)];
          if (VoipBaseFragment.c.this.Up != null)
          {
            if (-1 != i) {
              break label78;
            }
            VoipBaseFragment.c.this.Up.setText(null);
          }
          for (;;)
          {
            VoipBaseFragment.c localc = VoipBaseFragment.c.this;
            localc.AKq += 1;
            AppMethodBeat.o(115370);
            return true;
            label78:
            VoipBaseFragment.c.this.Up.setText(i);
          }
        }
      }, true);
      AppMethodBeat.o(115371);
    }
    
    public final void a(TextView paramTextView, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(115372);
      if ((paramArrayOfInt == null) || (paramTextView == null))
      {
        ac.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        AppMethodBeat.o(115372);
        return;
      }
      elo();
      this.AKq = 0;
      this.AKo = paramArrayOfInt;
      this.Up = paramTextView;
      this.AKp = 500;
      if (this.bYO != null)
      {
        paramArrayOfInt = this.bYO;
        long l = this.AKp;
        paramArrayOfInt.au(l, l);
      }
      ac.l("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(paramTextView)), new Object[0]);
      AppMethodBeat.o(115372);
    }
    
    public final void elo()
    {
      AppMethodBeat.i(115373);
      if (this.bYO != null) {
        this.bYO.stopTimer();
      }
      ac.l("MicroMsg.DynamicTextWrap", "stop textview: " + this.Up, new Object[0]);
      this.Up = null;
      AppMethodBeat.o(115373);
    }
  }
  
  public static abstract interface d
  {
    public abstract void as(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment
 * JD-Core Version:    0.7.0.1
 */