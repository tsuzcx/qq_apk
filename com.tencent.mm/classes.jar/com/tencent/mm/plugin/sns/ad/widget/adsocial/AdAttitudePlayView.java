package com.tencent.mm.plugin.sns.ad.widget.adsocial;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

public class AdAttitudePlayView
  extends FrameLayout
  implements p, AdSocialAttitudeView.b
{
  SnsInfo PJQ;
  PAGView QdG;
  private boolean QdH;
  a.b QdI;
  String QdJ;
  private int QdK;
  private b QdL;
  int QdM;
  int QdN;
  private boolean QdO;
  private String QdP;
  PAGView.PAGViewListener QdQ;
  int QdR;
  int QdS;
  int QdT;
  private final ViewTreeObserver.OnPreDrawListener QdU;
  private Context mContext;
  int mHeight;
  int mWidth;
  
  public AdAttitudePlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdAttitudePlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(310254);
    this.QdH = false;
    this.QdK = 0;
    this.QdQ = new PAGView.PAGViewListener()
    {
      public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
      
      public final void onAnimationEnd(PAGView paramAnonymousPAGView)
      {
        AppMethodBeat.i(310266);
        Log.i("AdAttitudePlayView", "onAnimationEnd");
        AdAttitudePlayView.a(AdAttitudePlayView.this, 3);
        if (AdAttitudePlayView.a(AdAttitudePlayView.this) != null) {
          AdAttitudePlayView.a(AdAttitudePlayView.this).hcC();
        }
        AppMethodBeat.o(310266);
      }
      
      public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
      
      public final void onAnimationStart(PAGView paramAnonymousPAGView)
      {
        AppMethodBeat.i(310259);
        Log.i("AdAttitudePlayView", "onAnimationStart");
        AdAttitudePlayView.a(AdAttitudePlayView.this, 2);
        if (AdAttitudePlayView.a(AdAttitudePlayView.this) != null) {
          AdAttitudePlayView.a(AdAttitudePlayView.this).hcB();
        }
        AppMethodBeat.o(310259);
      }
    };
    this.QdU = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(310280);
        AdAttitudePlayView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        AdAttitudePlayView localAdAttitudePlayView = AdAttitudePlayView.this;
        for (;;)
        {
          try
          {
            localObject4 = localAdAttitudePlayView.QdI;
            if (localObject4 != null) {
              continue;
            }
          }
          finally
          {
            Object localObject4;
            Object localObject3;
            int j;
            int[] arrayOfInt;
            Log.e("AdAttitudePlayView", localObject1.toString());
            continue;
            Object localObject2 = (FrameLayout.LayoutParams)localObject1.getLayoutParams();
            ((FrameLayout.LayoutParams)localObject2).width = localObject1.mWidth;
            ((FrameLayout.LayoutParams)localObject2).height = localObject1.mHeight;
            continue;
            localObject2 = (FrameLayout.LayoutParams)localObject1.QdG.getLayoutParams();
            ((FrameLayout.LayoutParams)localObject2).width = localObject1.mWidth;
            ((FrameLayout.LayoutParams)localObject2).height = (localObject1.mWidth * localObject1.QdN / localObject1.QdM);
            localObject1.QdG.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            int i = localObject1.QdS + localObject1.QdT / 2 - (localObject1.QdR + ((FrameLayout.LayoutParams)localObject2).height / 2) + a.fromDPToPix(localObject1.getContext(), 13);
            Log.i("AdAttitudePlayView", "offsetY is " + i + ", showAnimLayoutParams height is " + ((FrameLayout.LayoutParams)localObject2).height);
            localObject1.QdG.setTranslationY(i);
            continue;
          }
          AppMethodBeat.o(310280);
          return true;
          localObject3 = ((a.b)localObject4).Qcs;
          localObject2 = ((a.b)localObject4).Qcu;
          localObject4 = ((a.b)localObject4).Cxb;
          if ((localObject3 != null) && (localObject2 != null) && (localObject4 != null))
          {
            i = ((View)localObject4).getWidth();
            j = ((View)localObject4).getHeight();
            if ((i > 0) && (j > 0))
            {
              arrayOfInt = new int[2];
              ((View)localObject4).getLocationOnScreen(arrayOfInt);
              localAdAttitudePlayView.QdS = arrayOfInt[1];
              localAdAttitudePlayView.QdT = j;
              localAdAttitudePlayView.mWidth = (arrayOfInt[0] + i + localAdAttitudePlayView.getContext().getResources().getDimensionPixelSize(b.d.NormalPadding));
              localObject4 = new int[2];
              ((View)localObject2).getLocationOnScreen((int[])localObject4);
              arrayOfInt = new int[2];
              ((View)localObject3).getLocationOnScreen(arrayOfInt);
              localAdAttitudePlayView.QdR = arrayOfInt[1];
              localObject3 = new int[2];
              localAdAttitudePlayView.getLocationOnScreen((int[])localObject3);
              localAdAttitudePlayView.setLeftMarginOff(localObject3[0]);
              localAdAttitudePlayView.setTopMarginOff(localObject3[1] - arrayOfInt[1]);
              localAdAttitudePlayView.mHeight = (localObject4[1] + ((View)localObject2).getHeight() - arrayOfInt[1]);
              if (localAdAttitudePlayView.QdI.Qcx.source != 0) {
                continue;
              }
              localObject2 = (RelativeLayout.LayoutParams)localAdAttitudePlayView.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject2).width = localAdAttitudePlayView.mWidth;
              ((RelativeLayout.LayoutParams)localObject2).height = localAdAttitudePlayView.mHeight;
              localObject2 = localAdAttitudePlayView.getParent();
              if ((localObject2 instanceof FrameLayout))
              {
                localObject3 = ((ViewParent)localObject2).getParent();
                if ((localObject3 instanceof RelativeLayout))
                {
                  ((RelativeLayout)localObject3).setClipChildren(false);
                  ((RelativeLayout)localObject3).setClipToPadding(false);
                }
                localObject2 = (RelativeLayout.LayoutParams)((FrameLayout)localObject2).getLayoutParams();
                if (((RelativeLayout.LayoutParams)localObject2).width == 0) {
                  ((RelativeLayout.LayoutParams)localObject2).width = -1;
                }
                if (((RelativeLayout.LayoutParams)localObject2).height == 0) {
                  ((RelativeLayout.LayoutParams)localObject2).height = -1;
                }
              }
              if ((localAdAttitudePlayView.mWidth > 0) && (localAdAttitudePlayView.mHeight > 0) && (localAdAttitudePlayView.QdT > 0)) {
                continue;
              }
              Log.i("AdAttitudePlayView", "start play pagView, but can not calcPagViewDisplayParams, mWidth or mHeight or mContentContainerHeight <= 0");
              localAdAttitudePlayView.requestLayout();
            }
          }
        }
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(310254);
  }
  
  private void hcw()
  {
    AppMethodBeat.i(310260);
    try
    {
      if (this.QdH)
      {
        this.QdH = false;
        this.QdG.removeListener(this.QdQ);
        Log.i("AdAttitudePlayView", "stopListenPagView");
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310260);
    }
  }
  
  final void hcv()
  {
    AppMethodBeat.i(310313);
    try
    {
      if (!this.QdH)
      {
        this.QdH = true;
        this.QdG.addListener(this.QdQ);
        Log.i("AdAttitudePlayView", "startListenPagView");
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310313);
    }
  }
  
  final void hcx()
  {
    AppMethodBeat.i(310323);
    try
    {
      this.QdK = 3;
      setVisibility(8);
      this.QdG.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(310257);
          AdAttitudePlayView.b(AdAttitudePlayView.this).setProgress(0.0D);
          AdAttitudePlayView.b(AdAttitudePlayView.this).stop();
          AppMethodBeat.o(310257);
        }
      });
      if (this.QdL != null) {
        this.QdL.hcC();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310323);
    }
  }
  
  public final void hcy()
  {
    AppMethodBeat.i(310333);
    if ((this.QdK == 1) || (this.QdK == 2))
    {
      Log.d("AdAttitudePlayView", "onShowAttitude but pag is animating");
      AppMethodBeat.o(310333);
      return;
    }
    Log.d("AdAttitudePlayView", "onShowAttitude");
    h.OAn.kJ(1612, 76);
    int i;
    if (this.PJQ == null) {
      i = 0;
    }
    while ((i != 0) && (this.QdM > 0) && (this.QdN > 0))
    {
      setVisibility(0);
      getViewTreeObserver().removeOnPreDrawListener(this.QdU);
      getViewTreeObserver().addOnPreDrawListener(this.QdU);
      this.QdK = 1;
      Log.i("AdAttitudePlayView", "mPagFileWidth is " + this.QdM + ", mPagFileHeight is " + this.QdN);
      this.QdG.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(310256);
          AdAttitudePlayView.b(AdAttitudePlayView.this).setProgress(0.0D);
          AdAttitudePlayView.b(AdAttitudePlayView.this).play();
          AppMethodBeat.o(310256);
        }
      });
      AppMethodBeat.o(310333);
      return;
      if ((Util.nullAsNil(this.PJQ.getAdXml().adSocialInfo.QYq).equals(this.QdP)) && (this.QdO))
      {
        Log.i("AdAttitudePlayView", "checkPAGFileDownload, return true directly");
        i = 1;
      }
      else if (this.PJQ == null)
      {
        i = 0;
      }
      else
      {
        Object localObject = Util.nullAsNil(this.PJQ.getAdXml().adSocialInfo.QYq);
        String str = com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.b.lN((String)localObject, Util.nullAsNil(this.PJQ.getAdXml().adSocialInfo.QYr));
        this.QdP = ((String)localObject);
        this.QdO = false;
        if (!TextUtils.isEmpty(str))
        {
          localObject = PAGFile.Load(y.bi(str, 0, -1));
          this.QdM = ((PAGFile)localObject).width();
          this.QdN = ((PAGFile)localObject).height();
          this.QdG.setFile((PAGFile)localObject);
          this.QdG.setScaleMode(3);
          this.QdG.setRepeatCount(1);
          this.QdO = true;
          Log.i("AdAttitudePlayView", "initPagAnimViewData, use server file");
          i = 1;
        }
        else
        {
          com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.b.downloadPagFile((String)localObject);
          Log.i("AdAttitudePlayView", "initPagAnimViewData, start download pagFile");
          h.OAn.kJ(1612, 77);
          i = 0;
        }
      }
    }
    Log.w("AdAttitudePlayView", "pag file width or height <= 0 or may be download pag file");
    AppMethodBeat.o(310333);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(310355);
    super.onConfigurationChanged(paramConfiguration);
    Log.d("AdAttitudePlayView", "onConfigurationChanged: orientation = " + paramConfiguration.orientation);
    if ((this.QdK == 1) || (this.QdK == 2)) {
      hcx();
    }
    AppMethodBeat.o(310355);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310291);
    try
    {
      super.onDetachedFromWindow();
      Log.i("AdAttitudePlayView", "onDetachedFromWindow");
      a.b localb = this.QdI;
      if (localb == null) {
        return;
      }
      if (localb.Qcx.source == 0)
      {
        this.QdJ = "";
        hcw();
      }
      hcx();
      getViewTreeObserver().removeOnPreDrawListener(this.QdU);
      return;
    }
    finally
    {
      AppMethodBeat.o(310291);
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(310283);
    try
    {
      super.onFinishInflate();
      this.QdG = ((PAGView)findViewById(b.f.pag_attitude_anim));
      if ((this.mContext instanceof q)) {
        ((q)this.mContext).getLifecycle().addObserver(this);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310283);
    }
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(310309);
    try
    {
      Log.i("AdAttitudePlayView", "onUIPause");
      hcx();
      hcw();
      getViewTreeObserver().removeOnPreDrawListener(this.QdU);
      return;
    }
    finally
    {
      AppMethodBeat.o(310309);
    }
  }
  
  @z(Ho=j.a.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(310301);
    try
    {
      Log.i("AdAttitudePlayView", "onUIResume");
      hcv();
      return;
    }
    finally
    {
      AppMethodBeat.o(310301);
    }
  }
  
  void setLeftMarginOff(int paramInt)
  {
    AppMethodBeat.i(310347);
    if (this.QdI.Qcx.source == 0)
    {
      localObject = (RelativeLayout.LayoutParams)getLayoutParams();
      Log.d("AdAttitudePlayView", "leftMargin is " + ((RelativeLayout.LayoutParams)localObject).leftMargin + ", currentOffLeft is " + paramInt);
      ((RelativeLayout.LayoutParams)localObject).leftMargin -= paramInt;
      AppMethodBeat.o(310347);
      return;
    }
    Object localObject = (FrameLayout.LayoutParams)getLayoutParams();
    Log.d("AdAttitudePlayView", "leftMargin is " + ((FrameLayout.LayoutParams)localObject).leftMargin + ", currentOffLeft is " + paramInt);
    ((FrameLayout.LayoutParams)localObject).leftMargin -= paramInt;
    AppMethodBeat.o(310347);
  }
  
  public void setOnAnimationStatusListener(b paramb)
  {
    this.QdL = paramb;
  }
  
  void setTopMarginOff(int paramInt)
  {
    AppMethodBeat.i(310338);
    if (this.QdI.Qcx.source == 0)
    {
      localObject = (RelativeLayout.LayoutParams)getLayoutParams();
      Log.d("AdAttitudePlayView", "topMargin is " + ((RelativeLayout.LayoutParams)localObject).topMargin + ", currentOffTop is " + paramInt);
      ((RelativeLayout.LayoutParams)localObject).topMargin -= paramInt;
      AppMethodBeat.o(310338);
      return;
    }
    Object localObject = (FrameLayout.LayoutParams)getLayoutParams();
    Log.d("AdAttitudePlayView", "topMargin is " + ((FrameLayout.LayoutParams)localObject).topMargin + ", currentOffTop is " + paramInt);
    ((FrameLayout.LayoutParams)localObject).topMargin -= paramInt;
    AppMethodBeat.o(310338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.adsocial.AdAttitudePlayView
 * JD-Core Version:    0.7.0.1
 */