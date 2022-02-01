package com.tencent.mm.plugin.sns.ad.widget.shakead;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.p.a;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.b.a.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;
import org.xwalk.core.Log;

public class ShakeCardAnimView
  extends FrameLayout
{
  private final String JNA;
  private int JNB;
  public int JNC;
  public PAGView JND;
  public int JNE;
  public View JNF;
  public View JNG;
  private ArrayList<View> JNH;
  public com.tencent.mm.plugin.sns.ad.landingpage.component.b.b.a JNI;
  public a JNJ;
  private final String OdJ;
  private final String TAG;
  public Context mContext;
  
  public ShakeCardAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(270485);
    this.TAG = "ShakeCardAnimView";
    this.JNA = "assets://sns/sns_ad_shake_landing_page_anim.pag";
    this.OdJ = "assets://sns/sns_ad_shake_landing_page_anim_low.pag";
    this.JNH = new ArrayList();
    this.mContext = paramContext;
    this.JNB = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 32);
    this.JNC = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 54);
    this.JNE = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 72);
    hZ(this.mContext);
    this.JND = new PAGView(this.mContext);
    addView(this.JND, new FrameLayout.LayoutParams(-1, -1));
    this.JND.addListener(new PAGView.PAGViewListener()
    {
      public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
      
      public final void onAnimationEnd(PAGView paramAnonymousPAGView)
      {
        AppMethodBeat.i(253604);
        ShakeCardAnimView.this.setVisibility(8);
        AppMethodBeat.o(253604);
      }
      
      public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
      
      public final void onAnimationStart(PAGView paramAnonymousPAGView) {}
    });
    AppMethodBeat.o(270485);
  }
  
  public static ArrayList<b.a.a> bc(ArrayList<b.a.a> paramArrayList)
  {
    AppMethodBeat.i(270488);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(paramArrayList.get(3));
      localArrayList.add(paramArrayList.get(1));
      localArrayList.add(paramArrayList.get(0));
      localArrayList.add(paramArrayList.get(2));
      localArrayList.add(paramArrayList.get(4));
      label63:
      AppMethodBeat.o(270488);
      return localArrayList;
    }
    catch (Exception paramArrayList)
    {
      break label63;
    }
  }
  
  private boolean gEC()
  {
    AppMethodBeat.i(293254);
    try
    {
      int[] arrayOfInt = ao.ib(this.mContext);
      Log.i("ShakeCardAnimView", "w=" + arrayOfInt[0] + ", h=" + arrayOfInt[1]);
      int i = arrayOfInt[0];
      if ((arrayOfInt[1] * i <= 921600) || (gEu()))
      {
        Log.i("ShakeCardAnimView", "isLowPerformanceDevice, ret=true");
        com.tencent.mm.plugin.report.service.h.IzE.el(1572, 9);
        AppMethodBeat.o(293254);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("ShakeCardAnimView", "isForceLocalLowPag, exp=" + localThrowable.toString());
      Log.i("ShakeCardAnimView", "isLowPerformanceDevice, ret=false");
      AppMethodBeat.o(293254);
    }
    return false;
  }
  
  private static boolean gEu()
  {
    AppMethodBeat.i(293253);
    try
    {
      String str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.GWA, "");
      String str2 = Build.MODEL;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (str1.toLowerCase().contains(str2.toLowerCase()))) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("ShakeCardAnimView", "isInBlackList, blackList=" + str1 + ", curDev=" + str2 + ", ret=" + bool);
        AppMethodBeat.o(293253);
        return bool;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ShakeCardAnimView", "isInBlackList, exp=" + localThrowable.toString());
      AppMethodBeat.o(293253);
    }
  }
  
  private void hZ(Context paramContext)
  {
    AppMethodBeat.i(270486);
    int j = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 1.2F);
    int i = 0;
    while (i < 5)
    {
      MMRoundCornerImageView localMMRoundCornerImageView = new MMRoundCornerImageView(paramContext);
      localMMRoundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localMMRoundCornerImageView.setLayoutParams(new FrameLayout.LayoutParams(this.JNB, this.JNC));
      localMMRoundCornerImageView.setRadius(j);
      addView(localMMRoundCornerImageView);
      this.JNH.add(localMMRoundCornerImageView);
      i += 1;
    }
    AppMethodBeat.o(270486);
  }
  
  public final void bb(ArrayList<b.a.a> paramArrayList)
  {
    AppMethodBeat.i(270487);
    int i = 0;
    for (;;)
    {
      if (i < 5)
      {
        ImageView localImageView = (ImageView)this.JNH.get(i);
        b.a.a locala = (b.a.a)paramArrayList.get(i);
        if (!TextUtils.isEmpty(locala.lmL)) {}
        try
        {
          localImageView.setImageDrawable(new ColorDrawable(Color.parseColor(locala.lmL)));
          if (!TextUtils.isEmpty(locala.xei)) {
            c.a(locala.xei, localImageView, 0.0F);
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("ShakeCardAnimView", "loadCardImg err=" + localException.toString() + ", value=" + locala.lmL);
          }
        }
      }
    }
    AppMethodBeat.o(270487);
  }
  
  public final void fMv()
  {
    AppMethodBeat.i(270490);
    if (this.JND == null)
    {
      AppMethodBeat.o(270490);
      return;
    }
    this.JND.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252517);
        try
        {
          ShakeCardAnimView.c(ShakeCardAnimView.this).play();
          AppMethodBeat.o(252517);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("ShakeCardAnimView", "startPAGAnim, exp=" + localThrowable.toString());
          AppMethodBeat.o(252517);
        }
      }
    });
    AppMethodBeat.o(270490);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(270489);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getWidth();
    paramInt1 = getHeight();
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      AppMethodBeat.o(270489);
      return;
    }
    paramInt1 = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 80);
    paramInt4 = paramInt2 / 2 - this.JNB / 2;
    paramInt2 = -(this.JNE + this.JNC);
    paramInt3 = -this.JNE;
    getChildAt(2).layout(paramInt4, paramInt2, this.JNB + paramInt4, paramInt3);
    int i = paramInt4 - (this.JNB + paramInt1);
    getChildAt(1).layout(i, paramInt2, this.JNB + i, paramInt3);
    i = paramInt4 - (this.JNB + paramInt1) * 2;
    getChildAt(0).layout(i, paramInt2, this.JNB + i, paramInt3);
    i = this.JNB + paramInt1 + paramInt4;
    getChildAt(3).layout(i, paramInt2, this.JNB + i, paramInt3);
    paramInt1 = paramInt4 + (paramInt1 + this.JNB) * 2;
    getChildAt(4).layout(paramInt1, paramInt2, this.JNB + paramInt1, paramInt3);
    AppMethodBeat.o(270489);
  }
  
  public void setAnimCardView(View paramView)
  {
    AppMethodBeat.i(270494);
    StringBuilder localStringBuilder = new StringBuilder("setAnimCardView, target=null?");
    if (paramView == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("ShakeCardAnimView", bool);
      this.JNF = paramView;
      AppMethodBeat.o(270494);
      return;
    }
  }
  
  public void setOnCardAnimListener(a parama)
  {
    this.JNJ = parama;
  }
  
  public final void w(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270492);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, getHeight() / 2 + this.JNC / 2 + this.JNE });
    localObjectAnimator1.setDuration(500L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 3.0F });
    localObjectAnimator2.setDuration(500L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 3.0F });
    localObjectAnimator3.setDuration(500L);
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, paramInt2 });
    paramView.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
    localAnimatorSet.play(paramView).after(localObjectAnimator1);
    localAnimatorSet.setStartDelay(paramInt1);
    localAnimatorSet.start();
    AppMethodBeat.o(270492);
  }
  
  public static abstract interface a
  {
    public abstract void fKF();
    
    public abstract void fKG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCardAnimView
 * JD-Core Version:    0.7.0.1
 */