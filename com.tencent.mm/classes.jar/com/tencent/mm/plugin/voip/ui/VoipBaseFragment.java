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
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.b.l;
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
  protected static final int[] Cje = { -1, 2131764901, 2131764928, 2131764927 };
  static int Cji = -1;
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected boolean BYH;
  protected WeakReference<c> CiR;
  protected long CiS = -1L;
  protected ImageView Cjf;
  protected ImageView Cjg;
  protected int Cjh = 4096;
  protected VoipBaseFragment.d Cjj;
  protected c Cjk = new c();
  private VoipBaseFragment.a Cjl;
  private VoipBaseFragment.b Cjm;
  protected String fGM;
  protected ap jwD;
  protected RelativeLayout lPT;
  protected int mStatus = -1;
  
  protected static void av(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected static String sm(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  public final void Bx(long paramLong)
  {
    this.CiS = paramLong;
  }
  
  public void Uv(int paramInt) {}
  
  public void Uw(int paramInt) {}
  
  public void Ux(int paramInt) {}
  
  void Uz(int paramInt) {}
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  public final void a(VoipBaseFragment.d paramd)
  {
    this.Cjj = paramd;
  }
  
  @Deprecated
  public void a(CaptureView paramCaptureView) {}
  
  protected abstract void aDI(String paramString);
  
  @Deprecated
  public void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  @Deprecated
  public void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void eyJ() {}
  
  protected abstract void eyM();
  
  public abstract void eyN();
  
  @Deprecated
  public void eyU() {}
  
  @Deprecated
  public OpenGlRender eyV()
  {
    return null;
  }
  
  protected final void eyW()
  {
    if ((this.fGM == null) || (this.Cjf.getVisibility() == 0)) {
      return;
    }
    this.Cjf.setVisibility(0);
    this.Cjl = new VoipBaseFragment.a(this);
    h.LTJ.aR(this.Cjl);
  }
  
  protected final void eyX()
  {
    this.Cjg.setVisibility(0);
    this.Cjm = new VoipBaseFragment.b(this);
    h.LTJ.aR(this.Cjm);
  }
  
  @Deprecated
  public void ir(int paramInt1, int paramInt2) {}
  
  public void iu(int paramInt1, int paramInt2)
  {
    ad.m("MicroMsg.VoipBaseFragment", "newState: " + l.UK(paramInt2) + ", action: " + l.UK(paramInt1) + ", lastStatus: " + l.UK(Cji), new Object[0]);
    if ((Cji != this.mStatus) && (paramInt2 != this.mStatus)) {
      Cji = this.mStatus;
    }
    this.Cjh = paramInt1;
    this.mStatus = paramInt2;
  }
  
  protected abstract void iv(int paramInt1, int paramInt2);
  
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
    this.fGM = paramBundle.getString("key_username");
    this.BYH = paramBundle.getBoolean("key_isoutcall");
    if (-1 == this.mStatus) {
      this.mStatus = paramBundle.getInt("key_status");
    }
    this.jwD = new ap();
  }
  
  public void onDetach()
  {
    if (this.jwD != null) {
      this.jwD.removeCallbacksAndMessages(null);
    }
    this.Cjj = null;
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
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setVoicePlayDevice(int paramInt);
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public final void setVoipUIListener(c paramc)
  {
    this.CiR = new WeakReference(paramc);
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
  
  protected abstract void tt(boolean paramBoolean);
  
  public void uninit()
  {
    ad.d("MicroMsg.VoipBaseFragment", "uninit");
    this.Cjk.eyY();
    c localc = this.Cjk;
    ad.d("MicroMsg.DynamicTextWrap", "uninit");
    localc.eyY();
    localc.cjg = null;
    if (this.Cjl != null)
    {
      this.Cjl.cancel();
      this.Cjl = null;
    }
    if (this.Cjm != null)
    {
      this.Cjm.cancel();
      this.Cjm = null;
    }
  }
  
  protected static final class c
  {
    int[] Cjq;
    private int Cjr;
    int Cjs;
    TextView Wf;
    av cjg;
    
    protected c()
    {
      AppMethodBeat.i(115371);
      this.cjg = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(115370);
          int i = VoipBaseFragment.c.this.Cjq[(VoipBaseFragment.c.this.Cjs % VoipBaseFragment.c.this.Cjq.length)];
          if (VoipBaseFragment.c.this.Wf != null)
          {
            if (-1 != i) {
              break label78;
            }
            VoipBaseFragment.c.this.Wf.setText(null);
          }
          for (;;)
          {
            VoipBaseFragment.c localc = VoipBaseFragment.c.this;
            localc.Cjs += 1;
            AppMethodBeat.o(115370);
            return true;
            label78:
            VoipBaseFragment.c.this.Wf.setText(i);
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
      eyY();
      this.Cjs = 0;
      this.Cjq = paramArrayOfInt;
      this.Wf = paramTextView;
      this.Cjr = 500;
      if (this.cjg != null)
      {
        paramArrayOfInt = this.cjg;
        long l = this.Cjr;
        paramArrayOfInt.az(l, l);
      }
      ad.l("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(paramTextView)), new Object[0]);
      AppMethodBeat.o(115372);
    }
    
    public final void eyY()
    {
      AppMethodBeat.i(115373);
      if (this.cjg != null) {
        this.cjg.stopTimer();
      }
      ad.l("MicroMsg.DynamicTextWrap", "stop textview: " + this.Wf, new Object[0]);
      this.Wf = null;
      AppMethodBeat.o(115373);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment
 * JD-Core Version:    0.7.0.1
 */