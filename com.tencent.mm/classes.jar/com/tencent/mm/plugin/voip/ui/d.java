package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.res.Resources;
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
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public abstract class d
  extends Fragment
{
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected static final int[] pWP = { -1, a.e.voip_one_dot, a.e.voip_two_dot, a.e.voip_three_dot };
  static int pWU = -1;
  protected String djD;
  protected ah hcZ;
  protected int mStatus = -1;
  protected boolean pSc;
  protected long pWA = -1L;
  protected RelativeLayout pWQ;
  protected ImageView pWR;
  protected ImageView pWS;
  protected int pWT = 4096;
  protected d.d pWV;
  protected d.c pWW = new d.c();
  private d.a pWX;
  private d.b pWY;
  protected WeakReference<c> pWz;
  
  protected static void Q(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected static String ce(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  public abstract void Ap(int paramInt);
  
  protected abstract void Qa(String paramString);
  
  public final void a(d.d paramd)
  {
    this.pWV = paramd;
  }
  
  public abstract void a(CaptureView paramCaptureView);
  
  public abstract void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract void bQK();
  
  protected abstract void bRY();
  
  protected abstract void bRZ();
  
  protected final void bSa()
  {
    if ((this.djD == null) || (this.pWR.getVisibility() == 0)) {
      return;
    }
    this.pWR.setVisibility(0);
    this.pWX = new d.a(this);
    e.post(this.pWX, "VoipBaseFragment_blurbitmap");
  }
  
  protected final void bSb()
  {
    this.pWS.setVisibility(0);
    this.pWY = new d.b(this);
    e.post(this.pWY, "VoipBaseFragment_blurtransparentbitmap");
  }
  
  public abstract void c(int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  protected final void c(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (bk.bl(paramString)))
    {
      y.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
      return;
    }
    paramTextView.setText(paramString);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(j, -2147483648));
    paramTextView.setWidth(paramTextView.getMeasuredWidth());
  }
  
  protected abstract void cD(String paramString, int paramInt);
  
  public void en(int paramInt1, int paramInt2)
  {
    y.l("MicroMsg.VoipBaseFragment", "newState: " + b.At(paramInt2) + ", action: " + b.At(paramInt1) + ", lastStatus: " + b.At(pWU), new Object[0]);
    if ((pWU != this.mStatus) && (paramInt2 != this.mStatus)) {
      pWU = this.mStatus;
    }
    this.pWT = paramInt1;
    this.mStatus = paramInt2;
  }
  
  public final void gK(long paramLong)
  {
    this.pWA = paramLong;
  }
  
  public abstract OpenGlRender getFilterData();
  
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
    this.djD = paramBundle.getString("key_username");
    this.pSc = paramBundle.getBoolean("key_isoutcall");
    if (-1 == this.mStatus) {
      this.mStatus = paramBundle.getInt("key_status");
    }
    this.hcZ = new ah();
  }
  
  public void onDetach()
  {
    if (this.hcZ != null) {
      this.hcZ.removeCallbacksAndMessages(null);
    }
    this.pWV = null;
    super.onDetach();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public abstract void setHWDecMode(int paramInt);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setVoipBeauty(int paramInt);
  
  public final void setVoipUIListener(c paramc)
  {
    this.pWz = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    y.d("MicroMsg.VoipBaseFragment", "uninit");
    this.pWW.bSc();
    d.c localc = this.pWW;
    y.d("MicroMsg.DynamicTextWrap", "uninit");
    localc.bSc();
    localc.fjC = null;
    if (this.pWX != null)
    {
      e.remove(this.pWX);
      this.pWX = null;
    }
    if (this.pWY != null)
    {
      e.remove(this.pWY);
      this.pWY = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d
 * JD-Core Version:    0.7.0.1
 */