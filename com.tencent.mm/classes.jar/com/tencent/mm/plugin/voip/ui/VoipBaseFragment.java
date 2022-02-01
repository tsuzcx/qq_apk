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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.lang.ref.WeakReference;

public abstract class VoipBaseFragment
  extends Fragment
{
  protected static final int[] HeB = { -1, 2131767342, 2131767369, 2131767368 };
  static int HeF = -1;
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected boolean GUf;
  protected ImageView HeC;
  protected ImageView HeD;
  protected int HeE = 4096;
  protected VoipBaseFragment.d HeG;
  protected c HeH = new c();
  private VoipBaseFragment.a HeI;
  private b HeJ;
  protected WeakReference<c> Hen;
  protected long Heo = -1L;
  protected String goe;
  protected MMHandler kAn;
  protected int mStatus = -1;
  protected RelativeLayout ncd;
  
  protected static String AF(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  protected static void aA(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public final void Li(long paramLong)
  {
    this.Heo = paramLong;
  }
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  public final void a(VoipBaseFragment.d paramd)
  {
    this.HeG = paramd;
  }
  
  @Deprecated
  public void a(CaptureView paramCaptureView) {}
  
  protected abstract void aUB(String paramString);
  
  void adB(int paramInt) {}
  
  public void adx(int paramInt) {}
  
  public void ady(int paramInt) {}
  
  public void adz(int paramInt) {}
  
  @Deprecated
  public void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  @Deprecated
  public void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  protected final void fJA()
  {
    this.HeD.setVisibility(0);
    this.HeJ = new b();
    h.RTc.aX(this.HeJ);
  }
  
  public void fJm() {}
  
  protected abstract void fJq();
  
  @Deprecated
  public void fJx() {}
  
  @Deprecated
  public OpenGlRender fJy()
  {
    return null;
  }
  
  protected final void fJz()
  {
    if ((this.goe == null) || (this.HeC.getVisibility() == 0)) {
      return;
    }
    this.HeC.setVisibility(0);
    this.HeI = new VoipBaseFragment.a(this);
    h.RTc.aX(this.HeI);
  }
  
  @Deprecated
  public OpenGlRender getSpatioTemporalFilterData()
  {
    return null;
  }
  
  @Deprecated
  public void jA(int paramInt1, int paramInt2) {}
  
  public void jD(int paramInt1, int paramInt2)
  {
    Log.printInfoStack("MicroMsg.VoipBaseFragment", "newState: " + k.adM(paramInt2) + ", action: " + k.adM(paramInt1) + ", lastStatus: " + k.adM(HeF), new Object[0]);
    if ((HeF != this.mStatus) && (paramInt2 != this.mStatus)) {
      HeF = this.mStatus;
    }
    this.HeE = paramInt1;
    this.mStatus = paramInt2;
  }
  
  protected abstract void jE(int paramInt1, int paramInt2);
  
  public abstract void m(Point paramPoint);
  
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
    this.goe = paramBundle.getString("key_username");
    this.GUf = paramBundle.getBoolean("key_isoutcall");
    if (-1 == this.mStatus) {
      this.mStatus = paramBundle.getInt("key_status");
    }
    this.kAn = new MMHandler();
  }
  
  public void onDetach()
  {
    if (this.kAn != null) {
      this.kAn.removeCallbacksAndMessages(null);
    }
    this.HeG = null;
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
  
  public void setDeviceOrientation(int paramInt) {}
  
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
    this.Hen = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    Log.d("MicroMsg.VoipBaseFragment", "uninit");
    this.HeH.fJB();
    c localc = this.HeH;
    Log.d("MicroMsg.DynamicTextWrap", "uninit");
    localc.fJB();
    localc.cve = null;
    if (this.HeI != null)
    {
      this.HeI.cancel();
      this.HeI = null;
    }
    if (this.HeJ != null)
    {
      this.HeJ.cancel();
      this.HeJ = null;
    }
  }
  
  protected abstract void xk(boolean paramBoolean);
  
  protected final void z(TextView paramTextView)
  {
    if (paramTextView == null)
    {
      Log.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
      return;
    }
    paramTextView.setText(2131767368);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(j, -2147483648));
    paramTextView.setWidth(paramTextView.getMeasuredWidth());
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
      Log.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
      final Bitmap localBitmap = BitmapUtil.getBitmapNative(2131235557);
      Log.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
      VoipBaseFragment.this.kAn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115368);
          if (VoipBaseFragment.this.HeD != null)
          {
            VoipBaseFragment.this.HeD.setBackgroundDrawable(new BitmapDrawable(localBitmap));
            VoipBaseFragment.this.HeD.getBackground().setAlpha(230);
            VoipBaseFragment.this.HeD.getBackground().setFilterBitmap(true);
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
    int[] HeN;
    private int HeO;
    int HeP;
    TextView Ws;
    MTimerHandler cve;
    
    protected c()
    {
      AppMethodBeat.i(115371);
      this.cve = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(115370);
          int i = VoipBaseFragment.c.this.HeN[(VoipBaseFragment.c.this.HeP % VoipBaseFragment.c.this.HeN.length)];
          if (VoipBaseFragment.c.this.Ws != null)
          {
            if (-1 != i) {
              break label78;
            }
            VoipBaseFragment.c.this.Ws.setText(null);
          }
          for (;;)
          {
            VoipBaseFragment.c localc = VoipBaseFragment.c.this;
            localc.HeP += 1;
            AppMethodBeat.o(115370);
            return true;
            label78:
            VoipBaseFragment.c.this.Ws.setText(i);
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
      fJB();
      this.HeP = 0;
      this.HeN = paramArrayOfInt;
      this.Ws = paramTextView;
      this.HeO = 500;
      if (this.cve != null) {
        this.cve.startTimer(this.HeO);
      }
      Log.printDebugStack("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(paramTextView)), new Object[0]);
      AppMethodBeat.o(115372);
    }
    
    public final void fJB()
    {
      AppMethodBeat.i(115373);
      if (this.cve != null) {
        this.cve.stopTimer();
      }
      Log.printDebugStack("MicroMsg.DynamicTextWrap", "stop textview: " + this.Ws, new Object[0]);
      this.Ws = null;
      AppMethodBeat.o(115373);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment
 * JD-Core Version:    0.7.0.1
 */