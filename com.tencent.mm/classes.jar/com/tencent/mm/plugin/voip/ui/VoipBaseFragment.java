package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public abstract class VoipBaseFragment
  extends Fragment
{
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected static final int[] tCt = { -1, 2131304719, 2131304745, 2131304744 };
  static int tCy = -1;
  protected String eaX;
  protected ak iMP;
  protected int mStatus = -1;
  protected VoipBaseFragment.c tCA = new VoipBaseFragment.c();
  private a tCB;
  private VoipBaseFragment.b tCC;
  protected WeakReference<c> tCc;
  protected long tCd = -1L;
  protected RelativeLayout tCu;
  protected ImageView tCv;
  protected ImageView tCw;
  protected int tCx = 4096;
  protected VoipBaseFragment.d tCz;
  protected boolean txk;
  
  protected static void ai(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected static String ha(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  public abstract void HF(int paramInt);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture, int paramInt);
  
  public final void a(VoipBaseFragment.d paramd)
  {
    this.tCz = paramd;
  }
  
  public abstract void a(CaptureView paramCaptureView);
  
  public abstract void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  protected abstract void aeH(String paramString);
  
  public abstract void cNc();
  
  public abstract void cOQ();
  
  public abstract OpenGlRender cOU();
  
  protected abstract void cOV();
  
  public abstract void cOW();
  
  protected final void cOX()
  {
    if ((this.eaX == null) || (this.tCv.getVisibility() == 0)) {
      return;
    }
    this.tCv.setVisibility(0);
    this.tCB = new a();
    com.tencent.mm.sdk.g.d.post(this.tCB, "VoipBaseFragment_blurbitmap");
  }
  
  protected final void cOY()
  {
    this.tCw.setVisibility(0);
    this.tCC = new VoipBaseFragment.b(this);
    com.tencent.mm.sdk.g.d.post(this.tCC, "VoipBaseFragment_blurtransparentbitmap");
  }
  
  public abstract void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract OpenGlRender getFilterData();
  
  public abstract void gj(int paramInt1, int paramInt2);
  
  public void gl(int paramInt1, int paramInt2)
  {
    ab.b("MicroMsg.VoipBaseFragment", "newState: " + com.tencent.mm.plugin.voip.a.b.HN(paramInt2) + ", action: " + com.tencent.mm.plugin.voip.a.b.HN(paramInt1) + ", lastStatus: " + com.tencent.mm.plugin.voip.a.b.HN(tCy), new Object[0]);
    if ((tCy != this.mStatus) && (paramInt2 != this.mStatus)) {
      tCy = this.mStatus;
    }
    this.tCx = paramInt1;
    this.mStatus = paramInt2;
  }
  
  protected abstract void gm(int paramInt1, int paramInt2);
  
  protected final void j(TextView paramTextView)
  {
    if (paramTextView == null)
    {
      ab.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
      return;
    }
    paramTextView.setText(2131304744);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(j, -2147483648));
    paramTextView.setWidth(paramTextView.getMeasuredWidth());
  }
  
  protected abstract void mZ(boolean paramBoolean);
  
  public final void ng(long paramLong)
  {
    this.tCd = paramLong;
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
    this.eaX = paramBundle.getString("key_username");
    this.txk = paramBundle.getBoolean("key_isoutcall");
    if (-1 == this.mStatus) {
      this.mStatus = paramBundle.getInt("key_status");
    }
    this.iMP = new ak();
  }
  
  public void onDetach()
  {
    if (this.iMP != null) {
      this.iMP.removeCallbacksAndMessages(null);
    }
    this.tCz = null;
    super.onDetach();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public abstract void requestRender();
  
  public abstract void setHWDecMode(int paramInt);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setVoipBeauty(int paramInt);
  
  public final void setVoipUIListener(c paramc)
  {
    this.tCc = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    ab.d("MicroMsg.VoipBaseFragment", "uninit");
    this.tCA.cOZ();
    VoipBaseFragment.c localc = this.tCA;
    ab.d("MicroMsg.DynamicTextWrap", "uninit");
    localc.cOZ();
    localc.bAz = null;
    if (this.tCB != null)
    {
      com.tencent.mm.sdk.g.d.ysm.remove(this.tCB);
      this.tCB = null;
    }
    if (this.tCC != null)
    {
      com.tencent.mm.sdk.g.d.ysm.remove(this.tCC);
      this.tCC = null;
    }
  }
  
  public final class a
    implements Runnable
  {
    public a() {}
    
    public final void run()
    {
      AppMethodBeat.i(4845);
      ab.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
      Bitmap localBitmap2 = com.tencent.mm.ah.b.b(VoipBaseFragment.this.eaX, false, -1);
      if ((localBitmap2 == null) || (VoipBaseFragment.this.tCu == null))
      {
        AppMethodBeat.o(4845);
        return;
      }
      int i = 0;
      while (((VoipBaseFragment.this.tCu.getHeight() == 0) || (VoipBaseFragment.this.tCu.getWidth() == 0)) && (i < 10)) {
        try
        {
          Thread.sleep(300L);
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
          AppMethodBeat.o(4845);
          return;
        }
      }
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2.getHeight() <= localBitmap2.getWidth())
      {
        localBitmap1 = localBitmap2;
        if (localBitmap2.getHeight() / 5 > 0)
        {
          localBitmap1 = localBitmap2;
          if ((int)(localBitmap2.getHeight() * 0.6D) > 0) {
            localBitmap1 = Bitmap.createBitmap(localBitmap2, localBitmap2.getWidth() / 5, localBitmap2.getHeight() / 5, (int)(localBitmap2.getHeight() * 0.6D), (int)(localBitmap2.getHeight() * 0.6D), null, false);
          }
        }
      }
      float f = 1.0F * VoipBaseFragment.this.tCu.getHeight() / VoipBaseFragment.this.tCu.getWidth();
      i = (int)(localBitmap1.getHeight() / f);
      localBitmap1 = com.tencent.mm.sdk.platformtools.d.a(localBitmap1, localBitmap1.getHeight(), i, true, false);
      if (localBitmap1 == null)
      {
        ab.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
        AppMethodBeat.o(4845);
        return;
      }
      try
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.d.g(localBitmap1, 20);
        ab.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
        VoipBaseFragment.this.iMP.post(new VoipBaseFragment.a.1(this, localBitmap1));
        AppMethodBeat.o(4845);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + localException.getMessage());
        AppMethodBeat.o(4845);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment
 * JD-Core Version:    0.7.0.1
 */