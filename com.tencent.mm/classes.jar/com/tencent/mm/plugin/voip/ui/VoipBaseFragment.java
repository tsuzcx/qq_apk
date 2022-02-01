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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.lang.ref.WeakReference;

public abstract class VoipBaseFragment
  extends Fragment
{
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected static final int[] zrr = { -1, 2131764901, 2131764928, 2131764927 };
  static int zrv = -1;
  protected String flk;
  protected ap iDu;
  protected int mStatus = -1;
  protected RelativeLayout vHU;
  protected boolean zgY;
  protected WeakReference<c> zrd;
  protected long zre = -1L;
  protected ImageView zrs;
  protected ImageView zrt;
  protected int zru = 4096;
  protected d zrw;
  protected c zrx = new c();
  private VoipBaseFragment.a zry;
  private VoipBaseFragment.b zrz;
  
  protected static void as(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected static String mz(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  public void Qv(int paramInt) {}
  
  public void Qw(int paramInt) {}
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  public final void a(d paramd)
  {
    this.zrw = paramd;
  }
  
  @Deprecated
  public void a(CaptureView paramCaptureView) {}
  
  protected abstract void atj(String paramString);
  
  @Deprecated
  public void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void dVN() {}
  
  public void dVO() {}
  
  protected abstract void dVQ();
  
  public abstract void dVR();
  
  @Deprecated
  public void dVY() {}
  
  @Deprecated
  public OpenGlRender dVZ()
  {
    return null;
  }
  
  protected final void dWa()
  {
    if ((this.flk == null) || (this.zrs.getVisibility() == 0)) {
      return;
    }
    this.zrs.setVisibility(0);
    this.zry = new VoipBaseFragment.a(this);
    h.Iye.aP(this.zry);
  }
  
  protected final void dWb()
  {
    this.zrt.setVisibility(0);
    this.zrz = new VoipBaseFragment.b(this);
    h.Iye.aP(this.zrz);
  }
  
  @Deprecated
  public void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  @Deprecated
  public void hP(int paramInt1, int paramInt2) {}
  
  public void hS(int paramInt1, int paramInt2)
  {
    ad.m("MicroMsg.VoipBaseFragment", "newState: " + com.tencent.mm.plugin.voip.b.i.QI(paramInt2) + ", action: " + com.tencent.mm.plugin.voip.b.i.QI(paramInt1) + ", lastStatus: " + com.tencent.mm.plugin.voip.b.i.QI(zrv), new Object[0]);
    if ((zrv != this.mStatus) && (paramInt2 != this.mStatus)) {
      zrv = this.mStatus;
    }
    this.zru = paramInt1;
    this.mStatus = paramInt2;
  }
  
  protected abstract void hT(int paramInt1, int paramInt2);
  
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
    this.flk = paramBundle.getString("key_username");
    this.zgY = paramBundle.getBoolean("key_isoutcall");
    if (-1 == this.mStatus) {
      this.mStatus = paramBundle.getInt("key_status");
    }
    this.iDu = new ap();
  }
  
  public void onDetach()
  {
    if (this.iDu != null) {
      this.iDu.removeCallbacksAndMessages(null);
    }
    this.zrw = null;
    super.onDetach();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  protected abstract void rJ(boolean paramBoolean);
  
  @Deprecated
  public void releaseSurfaceTexture() {}
  
  @Deprecated
  public void requestRender() {}
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setVoicePlayDevice(int paramInt);
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public final void setVoipUIListener(c paramc)
  {
    this.zrd = new WeakReference(paramc);
  }
  
  protected final void t(TextView paramTextView)
  {
    if (paramTextView == null)
    {
      ad.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
      return;
    }
    paramTextView.setText(2131764927);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(j, -2147483648));
    paramTextView.setWidth(paramTextView.getMeasuredWidth());
  }
  
  public final void un(long paramLong)
  {
    this.zre = paramLong;
  }
  
  public void uninit()
  {
    ad.d("MicroMsg.VoipBaseFragment", "uninit");
    this.zrx.dWc();
    c localc = this.zrx;
    ad.d("MicroMsg.DynamicTextWrap", "uninit");
    localc.dWc();
    localc.cbR = null;
    if (this.zry != null)
    {
      this.zry.cancel();
      this.zry = null;
    }
    if (this.zrz != null)
    {
      this.zrz.cancel();
      this.zrz = null;
    }
  }
  
  protected static final class c
  {
    TextView Tu;
    av cbR;
    int[] zrD;
    private int zrE;
    int zrF;
    
    protected c()
    {
      AppMethodBeat.i(115371);
      this.cbR = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(115370);
          int i = VoipBaseFragment.c.this.zrD[(VoipBaseFragment.c.this.zrF % VoipBaseFragment.c.this.zrD.length)];
          if (VoipBaseFragment.c.this.Tu != null)
          {
            if (-1 != i) {
              break label78;
            }
            VoipBaseFragment.c.this.Tu.setText(null);
          }
          for (;;)
          {
            VoipBaseFragment.c localc = VoipBaseFragment.c.this;
            localc.zrF += 1;
            AppMethodBeat.o(115370);
            return true;
            label78:
            VoipBaseFragment.c.this.Tu.setText(i);
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
        ad.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        AppMethodBeat.o(115372);
        return;
      }
      dWc();
      this.zrF = 0;
      this.zrD = paramArrayOfInt;
      this.Tu = paramTextView;
      this.zrE = 500;
      if (this.cbR != null)
      {
        paramArrayOfInt = this.cbR;
        long l = this.zrE;
        paramArrayOfInt.av(l, l);
      }
      ad.l("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(paramTextView)), new Object[0]);
      AppMethodBeat.o(115372);
    }
    
    public final void dWc()
    {
      AppMethodBeat.i(115373);
      if (this.cbR != null) {
        this.cbR.stopTimer();
      }
      ad.l("MicroMsg.DynamicTextWrap", "stop textview: " + this.Tu, new Object[0]);
      this.Tu = null;
      AppMethodBeat.o(115373);
    }
  }
  
  public static abstract interface d
  {
    public abstract void ao(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment
 * JD-Core Version:    0.7.0.1
 */