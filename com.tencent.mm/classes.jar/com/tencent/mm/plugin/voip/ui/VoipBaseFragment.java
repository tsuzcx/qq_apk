package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.e.i;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.ui.al;
import java.lang.ref.WeakReference;

public abstract class VoipBaseFragment
  extends Fragment
{
  protected static final int[] CAI = { -1, 2131764901, 2131764928, 2131764927 };
  static int CAM = -1;
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected ImageView CAJ;
  protected ImageView CAK;
  protected int CAL = 4096;
  protected d CAN;
  protected c CAO = new c();
  private a CAP;
  private b CAQ;
  protected WeakReference<c> CAv;
  protected long CAw = -1L;
  protected boolean Cqi;
  protected String fIQ;
  protected aq jzz;
  protected RelativeLayout lUu;
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
  
  protected static String sz(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  public final void BV(long paramLong)
  {
    this.CAw = paramLong;
  }
  
  public void Vc(int paramInt) {}
  
  public void Vd(int paramInt) {}
  
  public void Ve(int paramInt) {}
  
  void Vg(int paramInt) {}
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  public final void a(d paramd)
  {
    this.CAN = paramd;
  }
  
  @Deprecated
  public void a(CaptureView paramCaptureView) {}
  
  protected abstract void aFb(String paramString);
  
  @Deprecated
  public void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  @Deprecated
  public void eCC() {}
  
  @Deprecated
  public OpenGlRender eCD()
  {
    return null;
  }
  
  protected final void eCE()
  {
    if ((this.fIQ == null) || (this.CAJ.getVisibility() == 0)) {
      return;
    }
    this.CAJ.setVisibility(0);
    this.CAP = new a();
    com.tencent.e.h.MqF.aO(this.CAP);
  }
  
  protected final void eCF()
  {
    this.CAK.setVisibility(0);
    this.CAQ = new b();
    com.tencent.e.h.MqF.aO(this.CAQ);
  }
  
  public void eCr() {}
  
  protected abstract void eCu();
  
  public abstract void eCv();
  
  @Deprecated
  public void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  @Deprecated
  public void iv(int paramInt1, int paramInt2) {}
  
  public void iy(int paramInt1, int paramInt2)
  {
    ae.m("MicroMsg.VoipBaseFragment", "newState: " + l.Vr(paramInt2) + ", action: " + l.Vr(paramInt1) + ", lastStatus: " + l.Vr(CAM), new Object[0]);
    if ((CAM != this.mStatus) && (paramInt2 != this.mStatus)) {
      CAM = this.mStatus;
    }
    this.CAL = paramInt1;
    this.mStatus = paramInt2;
  }
  
  protected abstract void iz(int paramInt1, int paramInt2);
  
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
    this.fIQ = paramBundle.getString("key_username");
    this.Cqi = paramBundle.getBoolean("key_isoutcall");
    if (-1 == this.mStatus) {
      this.mStatus = paramBundle.getInt("key_status");
    }
    this.jzz = new aq();
  }
  
  public void onDetach()
  {
    if (this.jzz != null) {
      this.jzz.removeCallbacksAndMessages(null);
    }
    this.CAN = null;
    super.onDetach();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  protected final void r(TextView paramTextView)
  {
    if (paramTextView == null)
    {
      ae.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
      return;
    }
    paramTextView.setText(2131764927);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(j, -2147483648));
    paramTextView.setWidth(paramTextView.getMeasuredWidth());
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
    this.CAv = new WeakReference(paramc);
  }
  
  protected abstract void tA(boolean paramBoolean);
  
  public void uninit()
  {
    ae.d("MicroMsg.VoipBaseFragment", "uninit");
    this.CAO.eCG();
    c localc = this.CAO;
    ae.d("MicroMsg.DynamicTextWrap", "uninit");
    localc.eCG();
    localc.cji = null;
    if (this.CAP != null)
    {
      this.CAP.cancel();
      this.CAP = null;
    }
    if (this.CAQ != null)
    {
      this.CAQ.cancel();
      this.CAQ = null;
    }
  }
  
  public final class a
    extends b
  {
    public a() {}
    
    public final String getKey()
    {
      return "VoipBaseFragment_blurbitmap";
    }
    
    public final void run()
    {
      AppMethodBeat.i(115367);
      ae.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
      Bitmap localBitmap2 = com.tencent.mm.aj.c.a(VoipBaseFragment.this.fIQ, false, -1, null);
      if ((localBitmap2 == null) || (VoipBaseFragment.this.lUu == null))
      {
        AppMethodBeat.o(115367);
        return;
      }
      int i = 0;
      while (((VoipBaseFragment.this.lUu.getHeight() == 0) || (VoipBaseFragment.this.lUu.getWidth() == 0)) && (i < 10)) {
        try
        {
          Thread.sleep(300L);
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          ae.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
          AppMethodBeat.o(115367);
          return;
        }
      }
      final Bitmap localBitmap1 = localBitmap2;
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
      float f = al.ck(ak.getContext()).y / al.ck(ak.getContext()).x;
      i = (int)(localBitmap1.getHeight() / f);
      localBitmap1 = com.tencent.mm.sdk.platformtools.h.a(localBitmap1, localBitmap1.getHeight(), i, true, false);
      if (localBitmap1 == null)
      {
        ae.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
        AppMethodBeat.o(115367);
        return;
      }
      try
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.h.l(localBitmap1, 20);
        ae.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
        VoipBaseFragment.this.jzz.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115366);
            if (VoipBaseFragment.this.CAJ != null)
            {
              VoipBaseFragment.this.CAJ.setBackgroundDrawable(new BitmapDrawable(localBitmap1));
              VoipBaseFragment.this.CAJ.getBackground().setAlpha(128);
            }
            VoipBaseFragment.a(VoipBaseFragment.this);
            AppMethodBeat.o(115366);
          }
        });
        AppMethodBeat.o(115367);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + localException.getMessage());
        AppMethodBeat.o(115367);
      }
    }
  }
  
  public final class b
    extends b
  {
    public b() {}
    
    public final String getKey()
    {
      return "VoipBaseFragment_blurtransparentbitmap";
    }
    
    public final void run()
    {
      AppMethodBeat.i(115369);
      ae.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
      final Bitmap localBitmap = com.tencent.mm.sdk.platformtools.h.aaZ(2131234595);
      ae.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
      VoipBaseFragment.this.jzz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115368);
          if (VoipBaseFragment.this.CAK != null)
          {
            VoipBaseFragment.this.CAK.setBackgroundDrawable(new BitmapDrawable(localBitmap));
            VoipBaseFragment.this.CAK.getBackground().setAlpha(230);
            VoipBaseFragment.this.CAK.getBackground().setFilterBitmap(true);
          }
          VoipBaseFragment.b(VoipBaseFragment.this);
          AppMethodBeat.o(115368);
        }
      });
      AppMethodBeat.o(115369);
    }
  }
  
  protected static final class c
  {
    int[] CAU;
    private int CAV;
    int CAW;
    TextView Wf;
    aw cji;
    
    protected c()
    {
      AppMethodBeat.i(115371);
      this.cji = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(115370);
          int i = VoipBaseFragment.c.this.CAU[(VoipBaseFragment.c.this.CAW % VoipBaseFragment.c.this.CAU.length)];
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
            localc.CAW += 1;
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
        ae.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        AppMethodBeat.o(115372);
        return;
      }
      eCG();
      this.CAW = 0;
      this.CAU = paramArrayOfInt;
      this.Wf = paramTextView;
      this.CAV = 500;
      if (this.cji != null)
      {
        paramArrayOfInt = this.cji;
        long l = this.CAV;
        paramArrayOfInt.ay(l, l);
      }
      ae.l("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(paramTextView)), new Object[0]);
      AppMethodBeat.o(115372);
    }
    
    public final void eCG()
    {
      AppMethodBeat.i(115373);
      if (this.cji != null) {
        this.cji.stopTimer();
      }
      ae.l("MicroMsg.DynamicTextWrap", "stop textview: " + this.Wf, new Object[0]);
      this.Wf = null;
      AppMethodBeat.o(115373);
    }
  }
  
  public static abstract interface d
  {
    public abstract void aw(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment
 * JD-Core Version:    0.7.0.1
 */