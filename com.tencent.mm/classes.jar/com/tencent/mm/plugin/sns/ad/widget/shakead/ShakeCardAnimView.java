package com.tencent.mm.plugin.sns.ad.widget.shakead;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.adxml.d.a;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.vfs.y;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;
import org.xwalk.core.Log;

public class ShakeCardAnimView
  extends FrameLayout
{
  private a Qij;
  private final String Qiq;
  private final String Qir;
  private PAGView Qis;
  private d.a Qit;
  public CardAnimView Qiu;
  public GLCardAnimView Qiv;
  public boolean Qiw;
  public boolean Qix;
  private final String TAG;
  private Context mContext;
  
  public ShakeCardAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310543);
    this.TAG = "ShakeCardAnimView";
    this.Qiq = "assets://sns/sns_ad_shake_landing_page_anim_low.pag";
    this.Qir = "assets://sns/sns_ad_shake_landing_page_anim_low.pag";
    this.Qiw = false;
    this.Qix = false;
    this.mContext = paramContext;
    this.Qiw = hdt();
    paramContext = this.mContext;
    if (this.Qiw)
    {
      this.Qiv = new GLCardAnimView(paramContext);
      addView(this.Qiv, new FrameLayout.LayoutParams(-1, -1));
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 15);
    }
    for (;;)
    {
      this.Qis = new PAGView(this.mContext);
      this.Qis.addListener(new PAGView.PAGViewListener()
      {
        public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationEnd(PAGView paramAnonymousPAGView)
        {
          AppMethodBeat.i(310579);
          Log.i("ShakeCardAnimView", "PagView onAnimationEnd");
          ShakeCardAnimView.a(ShakeCardAnimView.this, false);
          if (ShakeCardAnimView.a(ShakeCardAnimView.this) != null) {
            ShakeCardAnimView.a(ShakeCardAnimView.this).haU();
          }
          ShakeCardAnimView.b(ShakeCardAnimView.this).removeListener(this);
          ShakeCardAnimView.b(ShakeCardAnimView.this).stop();
          ShakeCardAnimView.this.removeView(ShakeCardAnimView.b(ShakeCardAnimView.this));
          AppMethodBeat.o(310579);
        }
        
        public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationStart(PAGView paramAnonymousPAGView)
        {
          AppMethodBeat.i(310564);
          ShakeCardAnimView.a(ShakeCardAnimView.this, true);
          AppMethodBeat.o(310564);
        }
      });
      addView(this.Qis, new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(310543);
      return;
      this.Qiu = new CardAnimView(paramContext);
      addView(this.Qiu, new FrameLayout.LayoutParams(-1, -1));
    }
  }
  
  private static boolean hdt()
  {
    AppMethodBeat.i(310553);
    try
    {
      int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yIv, 0);
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("ShakeCardAnimView", "isUseGLCardView, exptValue=".concat(String.valueOf(i)));
        AppMethodBeat.o(310553);
        return bool;
      }
      return false;
    }
    finally
    {
      Log.e("ShakeCardAnimView", "isUseGLCardView, exp=" + localObject.toString());
      AppMethodBeat.o(310553);
    }
  }
  
  private static boolean hdu()
  {
    AppMethodBeat.i(310559);
    try
    {
      String str1 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yIr, "");
      String str2 = q.aPo();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (str1.toLowerCase().contains(str2.toLowerCase()))) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("ShakeCardAnimView", "isInBlackList, blackList=" + str1 + ", curDev=" + str2 + ", ret=" + bool);
        AppMethodBeat.o(310559);
        return bool;
      }
      return false;
    }
    finally
    {
      Log.e("ShakeCardAnimView", "isInBlackList, exp=" + localObject.toString());
      AppMethodBeat.o(310559);
    }
  }
  
  private boolean hdv()
  {
    AppMethodBeat.i(310565);
    try
    {
      int[] arrayOfInt = ar.jR(this.mContext);
      Log.i("ShakeCardAnimView", "w=" + arrayOfInt[0] + ", h=" + arrayOfInt[1]);
      int i = arrayOfInt[0];
      if ((arrayOfInt[1] * i <= 921600) || (hdu()))
      {
        Log.i("ShakeCardAnimView", "isLowPerformanceDevice, ret=true");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 9);
        AppMethodBeat.o(310565);
        return true;
      }
    }
    finally
    {
      Log.e("ShakeCardAnimView", "isForceLocalLowPag, exp=" + localObject.toString());
      Log.i("ShakeCardAnimView", "isLowPerformanceDevice, ret=false");
      AppMethodBeat.o(310565);
    }
    return false;
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(310596);
    if (parama == null)
    {
      Log.e("ShakeCardAnimView", "initData, ShakeCardInfo==null");
      AppMethodBeat.o(310596);
      return;
    }
    Log.i("ShakeCardAnimView", "initData");
    this.Qit = parama;
    if (this.Qiw) {
      this.Qiv.a(parama);
    }
    for (;;)
    {
      lR(this.Qit.PMq, this.Qit.PMr);
      AppMethodBeat.o(310596);
      return;
      this.Qiu.a(parama);
    }
  }
  
  public final void eow()
  {
    AppMethodBeat.i(310613);
    Log.i("ShakeCardAnimView", "resetAnim");
    if (this.Qiw)
    {
      this.Qiv.eow();
      AppMethodBeat.o(310613);
      return;
    }
    this.Qiu.eow();
    AppMethodBeat.o(310613);
  }
  
  public final void hds()
  {
    AppMethodBeat.i(310618);
    Log.i("ShakeCardAnimView", "startCardAnim");
    if (this.Qiw)
    {
      this.Qiv.hds();
      AppMethodBeat.o(310618);
      return;
    }
    this.Qiu.hds();
    AppMethodBeat.o(310618);
  }
  
  public final void hdw()
  {
    AppMethodBeat.i(310607);
    Log.i("ShakeCardAnimView", "startPAGAnim");
    if (this.Qis == null)
    {
      AppMethodBeat.o(310607);
      return;
    }
    this.Qis.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310573);
        try
        {
          ShakeCardAnimView.b(ShakeCardAnimView.this).play();
          AppMethodBeat.o(310573);
          return;
        }
        finally
        {
          Log.e("ShakeCardAnimView", "startPAGAnim, exp=" + localObject.toString());
          AppMethodBeat.o(310573);
        }
      }
    });
    AppMethodBeat.o(310607);
  }
  
  public final void lR(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(310603);
    if (this.Qis == null)
    {
      Log.e("ShakeCardAnimView", "initPagAnimViewData, mPAGAnimView==null");
      AppMethodBeat.o(310603);
      return;
    }
    this.Qis.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310571);
        for (;;)
        {
          try
          {
            if (ShakeCardAnimView.c(ShakeCardAnimView.this))
            {
              ShakeCardAnimView.b(ShakeCardAnimView.this).setPath("assets://sns/sns_ad_shake_landing_page_anim_low.pag");
              Log.i("ShakeCardAnimView", "initPagAnimViewData, force use local low file");
              ShakeCardAnimView.b(ShakeCardAnimView.this).setScaleMode(3);
              ShakeCardAnimView.b(ShakeCardAnimView.this).setRepeatCount(1);
              AppMethodBeat.o(310571);
              return;
            }
            Object localObject1 = b.lN(paramString1, paramString2);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = PAGFile.Load(y.bi((String)localObject1, 0, -1));
              ShakeCardAnimView.b(ShakeCardAnimView.this).setFile((PAGFile)localObject1);
              Log.i("ShakeCardAnimView", "initPagAnimViewData, use sever file");
              continue;
            }
            AdLandingPagesProxy.getInstance().downloadPagFile(paramString1);
          }
          finally
          {
            Log.e("ShakeCardAnimView", "initPagAnimViewData , exp=" + localObject2.toString());
            AppMethodBeat.o(310571);
            return;
          }
          ShakeCardAnimView.b(ShakeCardAnimView.this).setPath("assets://sns/sns_ad_shake_landing_page_anim_low.pag");
          Log.i("ShakeCardAnimView", "initPagAnimViewData, use local file");
        }
      }
    });
    AppMethodBeat.o(310603);
  }
  
  public void setAnimCardView(View paramView)
  {
    AppMethodBeat.i(310628);
    Log.i("ShakeCardAnimView", "setAnimCardView");
    if (this.Qiw)
    {
      this.Qiv.setAnimCardView(paramView);
      AppMethodBeat.o(310628);
      return;
    }
    this.Qiu.setAnimCardView(paramView);
    AppMethodBeat.o(310628);
  }
  
  public void setOnCardAnimListener(a parama)
  {
    AppMethodBeat.i(310635);
    this.Qij = parama;
    if (this.Qiw)
    {
      this.Qiv.setOnCardAnimListener(parama);
      AppMethodBeat.o(310635);
      return;
    }
    this.Qiu.setOnCardAnimListener(parama);
    AppMethodBeat.o(310635);
  }
  
  public static abstract interface a
  {
    public abstract void haT();
    
    public abstract void haU();
    
    public abstract void haV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCardAnimView
 * JD-Core Version:    0.7.0.1
 */