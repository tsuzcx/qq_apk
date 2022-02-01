package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c.k;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.lang.ref.WeakReference;

public abstract class VoipBaseFragment
  extends Fragment
{
  protected static final int[] NVs = { -1, b.g.voip_one_dot, b.g.voip_two_dot, b.g.voip_three_dot };
  static int NVw = -1;
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected TextView DZt;
  private Runnable FAr = new VoipBaseFragment.2(this);
  protected ImageView FwW;
  protected boolean FzP = false;
  protected boolean NKr;
  private VoipBaseFragment.b NVA;
  protected WeakReference<c> NVe;
  protected long NVf = -1L;
  protected ImageView NVt;
  protected ImageView NVu;
  protected int NVv = 4096;
  protected VoipBaseFragment.d NVx;
  protected c NVy = new c();
  private VoipBaseFragment.a NVz;
  protected String iSn;
  protected int mStatus = -1;
  protected MMHandler ntw;
  protected RelativeLayout qcr;
  
  protected static String GN(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  protected static void aF(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected abstract void Bc(boolean paramBoolean);
  
  public final void SG(long paramLong)
  {
    this.NVf = paramLong;
  }
  
  final void XK(int paramInt)
  {
    if (this.DZt != null)
    {
      this.FzP = true;
      if (this.qcr.findViewById(b.d.net_tip_layout) != null) {
        this.qcr.findViewById(b.d.net_tip_layout).setOnClickListener(new VoipBaseFragment.3(this));
      }
      this.FwW.setVisibility(0);
      this.DZt.setVisibility(0);
      this.DZt.setText(b.g.voip_auduo_auto_switch_to_mobile_net);
      this.ntw.removeCallbacks(this.FAr);
      this.ntw.postDelayed(this.FAr, paramInt * 1000);
    }
  }
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  public final void a(VoipBaseFragment.d paramd)
  {
    this.NVx = paramd;
  }
  
  @Deprecated
  public void a(CaptureView paramCaptureView) {}
  
  public void ali(int paramInt) {}
  
  public void alj(int paramInt) {}
  
  public void alk(int paramInt) {}
  
  public void aln(int paramInt) {}
  
  final void alo(int paramInt)
  {
    com.tencent.mm.plugin.voip.c.gxs();
    if (u.gAI())
    {
      this.FwW.setVisibility(8);
      this.DZt.setVisibility(0);
      if (this.qcr.findViewById(b.d.net_tip_layout) != null) {
        this.qcr.findViewById(b.d.net_tip_layout).setOnClickListener(new VoipBaseFragment.1(this));
      }
      this.DZt.setText(b.g.voip_audio_network_data_cost_max);
      this.ntw.removeCallbacks(this.FAr);
      this.ntw.postDelayed(this.FAr, paramInt * 1000);
    }
  }
  
  @Deprecated
  public void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  protected abstract void bgj(String paramString);
  
  @Deprecated
  public void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void gBJ() {}
  
  protected abstract void gBM();
  
  @Deprecated
  public void gBT() {}
  
  @Deprecated
  public OpenGlRender gBU()
  {
    return null;
  }
  
  protected final void gBV()
  {
    if ((this.iSn == null) || (this.NVt.getVisibility() == 0)) {
      return;
    }
    this.NVt.setVisibility(0);
    this.NVz = new VoipBaseFragment.a(this);
    h.ZvG.be(this.NVz);
  }
  
  protected final void gBW()
  {
    this.NVu.setVisibility(0);
    this.NVA = new VoipBaseFragment.b(this);
    h.ZvG.be(this.NVA);
  }
  
  @Deprecated
  public OpenGlRender getSpatioTemporalFilterData()
  {
    return null;
  }
  
  @Deprecated
  public void kN(int paramInt1, int paramInt2) {}
  
  public void kR(int paramInt1, int paramInt2)
  {
    Log.printInfoStack("MicroMsg.VoipBaseFragment", "newState: " + k.alz(paramInt2) + ", action: " + k.alz(paramInt1) + ", lastStatus: " + k.alz(NVw), new Object[0]);
    if ((NVw != this.mStatus) && (paramInt2 != this.mStatus)) {
      NVw = this.mStatus;
    }
    this.NVv = paramInt1;
    this.mStatus = paramInt2;
  }
  
  protected abstract void kS(int paramInt1, int paramInt2);
  
  public abstract void l(Point paramPoint);
  
  protected final void o(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null)
    {
      Log.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
      return;
    }
    paramTextView.setText(paramInt);
    paramInt = getResources().getDisplayMetrics().widthPixels;
    int i = getResources().getDisplayMetrics().heightPixels;
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(paramInt, -2147483648), View.MeasureSpec.makeMeasureSpec(i, -2147483648));
    paramTextView.setWidth(paramTextView.getMeasuredWidth());
  }
  
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
    this.iSn = paramBundle.getString("key_username");
    this.NKr = paramBundle.getBoolean("key_isoutcall");
    if (-1 == this.mStatus) {
      this.mStatus = paramBundle.getInt("key_status");
    }
    this.ntw = new MMHandler();
  }
  
  public void onDetach()
  {
    if (this.ntw != null) {
      this.ntw.removeCallbacksAndMessages(null);
    }
    this.NVx = null;
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
  
  @Deprecated
  public void setSpatiotemporalDenosing(int paramInt) {}
  
  public abstract void setVoicePlayDevice(int paramInt);
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public final void setVoipUIListener(c paramc)
  {
    this.NVe = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    Log.d("MicroMsg.VoipBaseFragment", "uninit");
    this.NVy.gBX();
    c localc = this.NVy;
    Log.d("MicroMsg.DynamicTextWrap", "uninit");
    localc.gBX();
    localc.cts = null;
    if (this.NVz != null)
    {
      this.NVz.cancel();
      this.NVz = null;
    }
    if (this.NVA != null)
    {
      this.NVA.cancel();
      this.NVA = null;
    }
  }
  
  protected static final class c
  {
    int[] NVF;
    private int NVG;
    int NVH;
    MTimerHandler cts;
    TextView rR;
    
    protected c()
    {
      AppMethodBeat.i(115371);
      this.cts = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(115370);
          int i = VoipBaseFragment.c.this.NVF[(VoipBaseFragment.c.this.NVH % VoipBaseFragment.c.this.NVF.length)];
          if (VoipBaseFragment.c.this.rR != null)
          {
            if (-1 != i) {
              break label78;
            }
            VoipBaseFragment.c.this.rR.setText(null);
          }
          for (;;)
          {
            VoipBaseFragment.c localc = VoipBaseFragment.c.this;
            localc.NVH += 1;
            AppMethodBeat.o(115370);
            return true;
            label78:
            VoipBaseFragment.c.this.rR.setText(i);
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
        Log.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        AppMethodBeat.o(115372);
        return;
      }
      gBX();
      this.NVH = 0;
      this.NVF = paramArrayOfInt;
      this.rR = paramTextView;
      this.NVG = 500;
      if (this.cts != null) {
        this.cts.startTimer(this.NVG);
      }
      Log.printDebugStack("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(paramTextView)), new Object[0]);
      AppMethodBeat.o(115372);
    }
    
    public final void gBX()
    {
      AppMethodBeat.i(115373);
      if (this.cts != null) {
        this.cts.stopTimer();
      }
      Log.printDebugStack("MicroMsg.DynamicTextWrap", "stop textview: " + this.rR, new Object[0]);
      this.rR = null;
      AppMethodBeat.o(115373);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment
 * JD-Core Version:    0.7.0.1
 */