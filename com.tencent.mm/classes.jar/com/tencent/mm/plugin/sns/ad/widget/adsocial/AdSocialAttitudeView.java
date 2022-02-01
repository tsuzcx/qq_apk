package com.tencent.mm.plugin.sns.ad.widget.adsocial;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.ui.item.f.a;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.lang.ref.WeakReference;

public class AdSocialAttitudeView
  extends RoundedCornerFrameLayout
  implements b
{
  private View KKP;
  public SnsInfo PJQ;
  private c PZr;
  ImageView QdW;
  TextView QdX;
  private RelativeLayout QdY;
  private LinearLayout QdZ;
  private LinearLayout Qea;
  ImageView Qeb;
  TextView Qec;
  private b Qed;
  com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b Qee;
  g Qef;
  ViewGroup Qeg;
  LinearLayout Qeh;
  LinearLayout Qei;
  int Qej;
  int Qek;
  private int Qel;
  private int Qem;
  private int Qen;
  private int Qeo;
  private int Qep;
  private int Qeq;
  private int Qer;
  private int Qes;
  private int Qet;
  private int Qeu;
  private int Qev;
  private long Qew;
  private boolean Qex;
  Drawable Qey;
  String Qez;
  
  public AdSocialAttitudeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdSocialAttitudeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  final void ajU(int paramInt)
  {
    AppMethodBeat.i(310463);
    if (this.Qee.Qcx.source == 0)
    {
      Object localObject = getTag();
      if ((localObject instanceof f.a)) {
        ((f.a)localObject).RKy = paramInt;
      }
    }
    this.PJQ.setLikeFlag(paramInt);
    AppMethodBeat.o(310463);
  }
  
  public final void hcA()
  {
    AppMethodBeat.i(310486);
    if ((this.Qef == null) || (this.Qee == null))
    {
      AppMethodBeat.o(310486);
      return;
    }
    if ((this.Qeg == null) || (this.Qeh == null))
    {
      AppMethodBeat.o(310486);
      return;
    }
    if (!this.Qex)
    {
      getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(310288);
          try
          {
            AdSocialAttitudeView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            if (AdSocialAttitudeView.h(AdSocialAttitudeView.this).Qcx.source == 0)
            {
              i = AdSocialAttitudeView.i(AdSocialAttitudeView.this).getWidth() - AdSocialAttitudeView.j(AdSocialAttitudeView.this).getWidth() - AdSocialAttitudeView.k(AdSocialAttitudeView.this);
              Log.i("AdSocialAttitudeView", "parentViewGroupWidth is " + AdSocialAttitudeView.i(AdSocialAttitudeView.this).getWidth() + ", adSocialLeftViewWidth is " + AdSocialAttitudeView.j(AdSocialAttitudeView.this).getWidth() + ", remainSpaceWidth is " + i);
              j = AdSocialAttitudeView.e(AdSocialAttitudeView.this).getWidth() + AdSocialAttitudeView.m(AdSocialAttitudeView.this).getWidth() + AdSocialAttitudeView.n(AdSocialAttitudeView.this) + AdSocialAttitudeView.o(AdSocialAttitudeView.this) + 1;
              Log.i("AdSocialAttitudeView", "cheerTextMax is " + AdSocialAttitudeView.n(AdSocialAttitudeView.this) + ", commentTextMax is " + AdSocialAttitudeView.o(AdSocialAttitudeView.this) + ", contentWidth is " + j);
              i -= j;
              Log.i("AdSocialAttitudeView", "marginWidth is " + i + ", maxMarginWidth is " + AdSocialAttitudeView.p(AdSocialAttitudeView.this) + ", minMarginWidth is " + AdSocialAttitudeView.q(AdSocialAttitudeView.this));
              if (i < AdSocialAttitudeView.q(AdSocialAttitudeView.this)) {
                break label533;
              }
              float f = 1.0F;
              if (i < AdSocialAttitudeView.p(AdSocialAttitudeView.this)) {
                f = i / AdSocialAttitudeView.p(AdSocialAttitudeView.this);
              }
              i = (int)(AdSocialAttitudeView.r(AdSocialAttitudeView.this) * f);
              j = (int)(AdSocialAttitudeView.s(AdSocialAttitudeView.this) * f);
              AdSocialAttitudeView.a(AdSocialAttitudeView.this, i, j);
              AdSocialAttitudeView.a(AdSocialAttitudeView.this, false, 0);
              Log.i("AdSocialAttitudeView", "marginOuter is " + i + ", marginInner is " + j + ", rate is " + f);
              if (AdSocialAttitudeView.h(AdSocialAttitudeView.this).Qcx.source != 0) {
                break label503;
              }
              AdSocialAttitudeView.t(AdSocialAttitudeView.this);
              FrameLayout localFrameLayout = (FrameLayout)AdSocialAttitudeView.i(AdSocialAttitudeView.this);
              FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-2, -2);
              localLayoutParams1.gravity = 8388629;
              localFrameLayout.addView(AdSocialAttitudeView.this, localLayoutParams1);
            }
            for (;;)
            {
              AdSocialAttitudeView.x(AdSocialAttitudeView.this);
              AdSocialAttitudeView.this.requestLayout();
              AppMethodBeat.o(310288);
              return true;
              i = AdSocialAttitudeView.i(AdSocialAttitudeView.this).getWidth() - AdSocialAttitudeView.j(AdSocialAttitudeView.this).getWidth() - AdSocialAttitudeView.l(AdSocialAttitudeView.this);
              break;
              label503:
              AdSocialAttitudeView.a(AdSocialAttitudeView.this, false);
            }
            if (AdSocialAttitudeView.h(AdSocialAttitudeView.this).Qcx.source != 0) {
              break label699;
            }
          }
          finally
          {
            Log.e("AdSocialAttitudeView", localObject.toString());
            AppMethodBeat.o(310288);
            return false;
          }
          label533:
          AdSocialAttitudeView.t(AdSocialAttitudeView.this);
          int j = AdSocialAttitudeView.u(AdSocialAttitudeView.this).getWidth();
          int i = 0;
          for (;;)
          {
            if (i < AdSocialAttitudeView.u(AdSocialAttitudeView.this).getChildCount())
            {
              if (AdSocialAttitudeView.u(AdSocialAttitudeView.this).getChildAt(i).getId() != b.f.base_info_view) {}
            }
            else {
              for (;;)
              {
                LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
                localLayoutParams.topMargin = (AdSocialAttitudeView.v(AdSocialAttitudeView.this) / 2);
                AdSocialAttitudeView.u(AdSocialAttitudeView.this).addView(AdSocialAttitudeView.this, i + 1, localLayoutParams);
                i = j;
                for (;;)
                {
                  i = (i - 1 - AdSocialAttitudeView.w(AdSocialAttitudeView.this) * 4) / 2;
                  AdSocialAttitudeView.a(AdSocialAttitudeView.this, AdSocialAttitudeView.w(AdSocialAttitudeView.this), AdSocialAttitudeView.s(AdSocialAttitudeView.this));
                  AdSocialAttitudeView.a(AdSocialAttitudeView.this, true, i);
                  break;
                  label699:
                  i = AdSocialAttitudeView.i(AdSocialAttitudeView.this).getWidth();
                  AdSocialAttitudeView.a(AdSocialAttitudeView.this, true);
                }
                i = 0;
              }
            }
            i += 1;
          }
        }
      });
      this.Qex = true;
    }
    AppMethodBeat.o(310486);
  }
  
  public final void hcB()
  {
    AppMethodBeat.i(310501);
    if (this.QdZ != null) {
      this.QdZ.setEnabled(false);
    }
    AppMethodBeat.o(310501);
  }
  
  public final void hcC()
  {
    AppMethodBeat.i(310506);
    if (this.QdZ != null) {
      this.QdZ.setEnabled(true);
    }
    AppMethodBeat.o(310506);
  }
  
  final boolean hcz()
  {
    AppMethodBeat.i(310472);
    if ((this.Qee == null) || (this.PJQ == null))
    {
      AppMethodBeat.o(310472);
      return false;
    }
    if (this.Qee.Qcx.source == 0)
    {
      Object localObject = getTag();
      if ((localObject instanceof f.a))
      {
        if (((f.a)localObject).RKy == 0)
        {
          AppMethodBeat.o(310472);
          return true;
        }
        AppMethodBeat.o(310472);
        return false;
      }
    }
    else
    {
      if (this.PJQ.getLikeFlag() == 0)
      {
        AppMethodBeat.o(310472);
        return true;
      }
      AppMethodBeat.o(310472);
      return false;
    }
    AppMethodBeat.o(310472);
    return false;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(310479);
    super.onConfigurationChanged(paramConfiguration);
    hcA();
    AppMethodBeat.o(310479);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(310453);
    super.onFinishInflate();
    try
    {
      this.QdY = ((RelativeLayout)findViewById(b.f.content));
      this.QdZ = ((LinearLayout)findViewById(b.f.cheer_container));
      this.QdW = ((ImageView)findViewById(b.f.album_like_icon));
      this.QdX = ((TextView)findViewById(b.f.cheer_tv));
      this.Qeb = ((ImageView)findViewById(b.f.comment_icon));
      this.KKP = findViewById(b.f.divider);
      this.Qea = ((LinearLayout)findViewById(b.f.comment_container));
      this.Qec = ((TextView)findViewById(b.f.comment_tv));
      this.Qel = com.tencent.mm.cd.a.fromDPToPix(getContext(), 12);
      this.Qem = com.tencent.mm.cd.a.fromDPToPix(getContext(), 4);
      this.Qen = com.tencent.mm.cd.a.fromDPToPix(getContext(), 6);
      this.Qeo = com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
      this.Qep = com.tencent.mm.cd.a.fromDPToPix(getContext(), 32);
      this.Qeq = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
      this.Qer = 56;
      this.Qes = com.tencent.mm.cd.a.fromDPToPix(getContext(), this.Qer);
      this.Qet = (this.Qer / 2);
      this.Qeu = com.tencent.mm.cd.a.fromDPToPix(getContext(), this.Qet);
      this.Qev = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
      this.QdZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(310249);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/widget/adsocial/AdSocialAttitudeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          for (;;)
          {
            try
            {
              if (System.currentTimeMillis() - AdSocialAttitudeView.a(AdSocialAttitudeView.this) <= 800L) {
                continue;
              }
              AdSocialAttitudeView.a(AdSocialAttitudeView.this, System.currentTimeMillis());
              if ((AdSocialAttitudeView.b(AdSocialAttitudeView.this) != null) && (AdSocialAttitudeView.c(AdSocialAttitudeView.this))) {
                AdSocialAttitudeView.b(AdSocialAttitudeView.this).hcy();
              }
              if ((AdSocialAttitudeView.d(AdSocialAttitudeView.this) != null) && (AdSocialAttitudeView.d(AdSocialAttitudeView.this).RQc != null)) {
                AdSocialAttitudeView.d(AdSocialAttitudeView.this).RQc.onClick(paramAnonymousView);
              }
            }
            finally
            {
              continue;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/widget/adsocial/AdSocialAttitudeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(310249);
            return;
            Log.w("AdSocialAttitudeView", "you must click button slowly");
          }
        }
      });
      return;
    }
    finally
    {
      AppMethodBeat.o(310453);
    }
  }
  
  public void setOnCommentClickListener(c paramc)
  {
    AppMethodBeat.i(310495);
    if ((this.Qea != null) && (paramc != null))
    {
      this.PZr = paramc;
      this.Qea.setOnClickListener(paramc.RQb);
    }
    AppMethodBeat.o(310495);
  }
  
  public void setOnShowAttitudeListener(b paramb)
  {
    this.Qed = paramb;
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(310491);
    super.setTag(paramObject);
    if (this.Qea != null) {
      this.Qea.setTag(paramObject);
    }
    if (this.QdZ != null) {
      this.QdZ.setTag(paramObject);
    }
    AppMethodBeat.o(310491);
  }
  
  static final class a
    implements com.tencent.mm.plugin.sns.ad.j.a.b
  {
    private WeakReference<AdSocialAttitudeView> QeB;
    private int Qev;
    
    public a(AdSocialAttitudeView paramAdSocialAttitudeView)
    {
      AppMethodBeat.i(310238);
      this.QeB = new WeakReference(paramAdSocialAttitudeView);
      this.Qev = com.tencent.mm.cd.a.fromDPToPix(paramAdSocialAttitudeView.getContext(), 16);
      AppMethodBeat.o(310238);
    }
    
    public final void g(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(310247);
      try
      {
        Object localObject = this.QeB;
        if (localObject == null)
        {
          AppMethodBeat.o(310247);
          return;
        }
        AdSocialAttitudeView localAdSocialAttitudeView = (AdSocialAttitudeView)this.QeB.get();
        if (localAdSocialAttitudeView == null)
        {
          AppMethodBeat.o(310247);
          return;
        }
        localObject = AdSocialAttitudeView.e(localAdSocialAttitudeView).getTag(b.f.sns_ad_social_img_url);
        if ((localObject instanceof String))
        {
          localObject = (String)localObject;
          if ((!TextUtils.isEmpty(AdSocialAttitudeView.f(localAdSocialAttitudeView))) && (AdSocialAttitudeView.f(localAdSocialAttitudeView).equals(localObject)) && (AdSocialAttitudeView.e(localAdSocialAttitudeView) != null))
          {
            Drawable localDrawable = AdSocialAttitudeView.g(localAdSocialAttitudeView);
            localObject = localDrawable;
            if (paramBoolean)
            {
              localObject = localDrawable;
              if (paramBitmap != null)
              {
                localObject = new BitmapDrawable(MMApplicationContext.getContext().getResources(), paramBitmap);
                ((BitmapDrawable)localObject).setBounds(0, 0, this.Qev, this.Qev);
              }
            }
            ((Drawable)localObject).setColorFilter(localAdSocialAttitudeView.getResources().getColor(b.c.Link), PorterDuff.Mode.SRC_ATOP);
            AdSocialAttitudeView.e(localAdSocialAttitudeView).setImageDrawable((Drawable)localObject);
          }
        }
        AppMethodBeat.o(310247);
        return;
      }
      finally
      {
        Log.e("AdSocialAttitudeView", "onDownloadResult, exp=" + paramBitmap.toString());
        AppMethodBeat.o(310247);
      }
    }
  }
  
  static abstract interface b
  {
    public abstract void hcy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.adsocial.AdSocialAttitudeView
 * JD-Core Version:    0.7.0.1
 */