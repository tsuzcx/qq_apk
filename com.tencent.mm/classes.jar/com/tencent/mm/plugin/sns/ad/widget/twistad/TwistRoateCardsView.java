package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.ad.j.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import org.xwalk.core.Log;

public class TwistRoateCardsView
  extends FrameLayout
{
  private static HashMap<String, Bitmap> Qka;
  private boolean POw;
  private int Qic;
  private int Qid;
  private View Qif;
  private float QjZ;
  private int Qjb;
  private int Qjc;
  private int Qjd;
  private int Qjf;
  private int Qjg;
  private float Qjh;
  private int Qji;
  private String Qjj;
  private int Qjk;
  private int Qjo;
  ViewOutlineProvider Qkb;
  private a Qkc;
  private final String TAG;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(310420);
    Qka = new HashMap();
    AppMethodBeat.o(310420);
  }
  
  public TwistRoateCardsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310305);
    this.TAG = "TwistRoateCardsView";
    this.Qjb = 0;
    this.Qjc = 0;
    this.QjZ = 0.0F;
    this.Qjh = 1.0F;
    this.POw = false;
    this.Qkb = new ViewOutlineProvider()
    {
      public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
      {
        AppMethodBeat.i(310340);
        paramAnonymousOutline.setRoundRect(0, 0, TwistRoateCardsView.a(TwistRoateCardsView.this), TwistRoateCardsView.b(TwistRoateCardsView.this), TwistRoateCardsView.c(TwistRoateCardsView.this));
        AppMethodBeat.o(310340);
      }
    };
    this.Qjo = 0;
    this.mContext = paramContext;
    this.Qjf = a.fromDPToPix(this.mContext, 14);
    this.Qjg = a.fromDPToPix(this.mContext, 8);
    AppMethodBeat.o(310305);
  }
  
  private void hdG()
  {
    AppMethodBeat.i(310321);
    int i = 0;
    ImageView localImageView;
    Object localObject1;
    if (i < 12)
    {
      localImageView = new ImageView(this.mContext);
      localObject1 = new FrameLayout.LayoutParams(this.Qic, this.Qid);
      ((FrameLayout.LayoutParams)localObject1).setMargins(this.Qjf, this.Qjf, this.Qjf, this.Qjf);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localImageView.setClipToOutline(true);
      localImageView.setOutlineProvider(this.Qkb);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setBackgroundColor(this.Qjk);
      localObject1 = this.Qjj;
      int j = this.Qic;
      int k = this.Qid;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (;;)
      {
        try
        {
          localObject2 = (Bitmap)Qka.get(localObject1);
          if (localObject2 == null) {
            continue;
          }
          Log.i("TwistRoateCardsView", "setCardBackgroundImg, hit memCache");
          localImageView.setImageBitmap((Bitmap)localObject2);
        }
        finally
        {
          Object localObject2;
          Log.e("TwistRoateCardsView", "setCardBackgroundImg, exp=" + localObject3.toString());
          Log.i("TwistRoateCardsView", "setCardBackgroundImg, download img");
          c.o((String)localObject1, localImageView);
          continue;
        }
        localObject1 = new FrameLayout(this.mContext);
        ((FrameLayout)localObject1).addView(localImageView);
        ((FrameLayout)localObject1).setBackgroundResource(b.e.sns_ad_twist_card_bg);
        ((FrameLayout)localObject1).setLayoutParams(new FrameLayout.LayoutParams(this.Qic + this.Qjf * 2, this.Qid + this.Qjf * 2));
        addView((View)localObject1);
        i += 1;
        break;
        localObject2 = k.mC("adId", (String)localObject1);
        if (!y.ZC((String)localObject2)) {
          continue;
        }
        localObject2 = BitmapUtil.decodeFileWithSample((String)localObject2, j, k);
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          continue;
        }
        Log.i("TwistRoateCardsView", "setCardBackgroundImg, hit diskCache");
        localImageView.setImageBitmap((Bitmap)localObject2);
        Qka.put(localObject1, localObject2);
      }
    }
    AppMethodBeat.o(310321);
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(310430);
    Log.i("TwistRoateCardsView", "initData, defBgColor=" + paramString2 + ", imgUrl=" + paramString1 + ", isClockwise=" + paramBoolean);
    this.Qjj = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      this.Qjk = Color.parseColor(paramString2);
      if ((paramInt1 <= 0) || (paramInt2 <= 0))
      {
        Log.e("TwistRoateCardsView", "initData, size is 0, w=" + paramInt1 + ", h=" + paramInt2);
        this.Qic = a.fromDPToPix(this.mContext, 221);
        this.Qid = a.fromDPToPix(this.mContext, 375);
        this.Qjd = (a.fromDPToPix(this.mContext, 200) + this.Qid / 2);
        this.POw = paramBoolean;
        if (!this.POw) {
          break label250;
        }
        this.Qji = 3;
        removeAllViews();
        hdG();
        AppMethodBeat.o(310430);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("TwistRoateCardsView", "parseColor exp=" + paramString1.toString());
        continue;
        this.Qic = ((int)(paramInt1 * 0.75F));
        this.Qid = ((int)(paramInt2 * 0.75F));
        continue;
        label250:
        this.Qji = 9;
      }
    }
  }
  
  public final void cKI()
  {
    AppMethodBeat.i(310469);
    this.Qjo = 0;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(1500L);
    if (this.POw) {}
    for (float f = -180.0F;; f = 180.0F)
    {
      ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { f, 0.0F });
      localValueAnimator1.setDuration(1500L);
      localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(310329);
          TwistRoateCardsView.a(TwistRoateCardsView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          TwistRoateCardsView.this.invalidate();
          if (180.0F - Math.abs(TwistRoateCardsView.d(TwistRoateCardsView.this)) - TwistRoateCardsView.e(TwistRoateCardsView.this) * 30 >= 0.0F)
          {
            t.g(new long[] { 0L, 40L });
            TwistRoateCardsView.f(TwistRoateCardsView.this);
            Log.i("TwistRoateCardsView", "vabriate, idx=" + TwistRoateCardsView.e(TwistRoateCardsView.this));
          }
          AppMethodBeat.o(310329);
        }
      });
      localValueAnimator1.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(310312);
          TwistRoateCardsView.g(TwistRoateCardsView.this);
          AppMethodBeat.o(310312);
        }
      });
      ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.3F, 1.0F });
      localValueAnimator2.setDuration(1500L);
      localValueAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
      localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(310318);
          TwistRoateCardsView.b(TwistRoateCardsView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          TwistRoateCardsView.this.invalidate();
          AppMethodBeat.o(310318);
        }
      });
      localValueAnimator1.start();
      localValueAnimator2.start();
      localObjectAnimator.start();
      AppMethodBeat.o(310469);
      return;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(310458);
    paramCanvas.save();
    paramCanvas.rotate(this.QjZ, this.Qjb, this.Qjc);
    paramCanvas.scale(this.Qjh, this.Qjh, this.Qjb, this.Qjc);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(310458);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(310449);
    if ((getWidth() > 0) && (getHeight() > 0))
    {
      this.Qjb = (getWidth() / 2);
      this.Qjc = (getHeight() + a.fromDPToPix(this.mContext, 40));
      if (getChildCount() == 12)
      {
        paramInt1 = 0;
        if (paramInt1 < 12)
        {
          View localView = getChildAt(paramInt1);
          double d1;
          double d2;
          if (this.POw)
          {
            d1 = 0.5235987755982988D * paramInt1;
            paramInt3 = (int)(this.Qjd * Math.cos(d1));
            d2 = this.Qjd;
            paramInt2 = (int)(Math.sin(d1) * d2);
            localView.setRotation(90 - paramInt1 * 360 / 12);
          }
          for (;;)
          {
            paramInt3 += this.Qjb;
            paramInt2 = this.Qjc - paramInt2;
            paramInt4 = this.Qic + this.Qjf * 2;
            int i = this.Qid + this.Qjf * 2;
            localView.layout(paramInt3 - paramInt4 / 2, paramInt2 - i / 2, paramInt3 + paramInt4 / 2, paramInt2 + i / 2);
            paramInt1 += 1;
            break;
            d1 = 0.5235987755982988D * -paramInt1;
            paramInt3 = (int)(this.Qjd * Math.cos(d1));
            d2 = this.Qjd;
            paramInt2 = (int)(Math.sin(d1) * d2);
            localView.setRotation(paramInt1 * 360 / 12 + 90);
          }
        }
      }
    }
    AppMethodBeat.o(310449);
  }
  
  public void setAnimCardView(View paramView)
  {
    this.Qif = paramView;
  }
  
  public void setOnCardAnimListener(a parama)
  {
    this.Qkc = parama;
  }
  
  public static abstract interface a
  {
    public abstract void haT();
    
    public abstract void haV();
    
    public abstract void haW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView
 * JD-Core Version:    0.7.0.1
 */