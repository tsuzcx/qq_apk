package com.tencent.mm.plugin.sns.ad.widget.shakead;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.ad.adxml.d.a;
import com.tencent.mm.plugin.sns.ad.adxml.d.a.a;
import com.tencent.mm.plugin.sns.ad.d.t.a;
import com.tencent.mm.plugin.sns.ad.j.c;
import com.tencent.mm.plugin.sns.ad.widget.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import java.util.ArrayList;

public class CardAnimView
  extends FrameLayout
{
  private int Qic;
  private int Qid;
  private int Qie;
  private View Qif;
  private View Qig;
  private ArrayList<View> Qih;
  public boolean Qii;
  private ShakeCardAnimView.a Qij;
  private final String TAG;
  private Context mContext;
  
  public CardAnimView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(310538);
    this.TAG = "ShakeCardAnimView";
    this.Qih = new ArrayList();
    this.Qii = false;
    init(paramContext);
    AppMethodBeat.o(310538);
  }
  
  public CardAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310554);
    this.TAG = "ShakeCardAnimView";
    this.Qih = new ArrayList();
    this.Qii = false;
    init(paramContext);
    AppMethodBeat.o(310554);
  }
  
  private void B(final View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310626);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { -(getHeight() / 2 + this.Qid / 2 + this.Qie), 0.0F });
    localObjectAnimator1.setDuration(500L);
    localObjectAnimator1.addListener(new b()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(310591);
        paramView.setVisibility(0);
        AppMethodBeat.o(310591);
      }
    });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.3333333F, 1.0F });
    localObjectAnimator2.setDuration(500L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.3333333F, 1.0F });
    localObjectAnimator3.setDuration(500L);
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, paramInt2 });
    paramView.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
    localAnimatorSet.play(paramView).after(localObjectAnimator1);
    localAnimatorSet.setStartDelay(paramInt1);
    localAnimatorSet.start();
    AppMethodBeat.o(310626);
  }
  
  private static ArrayList<d.a.a> bA(ArrayList<d.a.a> paramArrayList)
  {
    AppMethodBeat.i(310600);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add((d.a.a)paramArrayList.get(3));
      localArrayList.add((d.a.a)paramArrayList.get(1));
      localArrayList.add((d.a.a)paramArrayList.get(0));
      localArrayList.add((d.a.a)paramArrayList.get(2));
      localArrayList.add((d.a.a)paramArrayList.get(4));
      label78:
      AppMethodBeat.o(310600);
      return localArrayList;
    }
    catch (Exception paramArrayList)
    {
      break label78;
    }
  }
  
  private void bz(ArrayList<d.a.a> paramArrayList)
  {
    AppMethodBeat.i(310590);
    int i = 0;
    for (;;)
    {
      if (i < 5)
      {
        ImageView localImageView = (ImageView)this.Qih.get(i);
        d.a.a locala = (d.a.a)paramArrayList.get(i);
        if (!TextUtils.isEmpty(locala.nRQ)) {}
        try
        {
          localImageView.setImageDrawable(new ColorDrawable(Color.parseColor(locala.nRQ)));
          if (!TextUtils.isEmpty(locala.ADt)) {
            c.a(locala.ADt, localImageView, 0.0F);
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("ShakeCardAnimView", "loadCardImg err=" + localException.toString() + ", value=" + locala.nRQ);
          }
        }
      }
    }
    AppMethodBeat.o(310590);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(310563);
    this.mContext = paramContext;
    this.Qic = a.fromDPToPix(this.mContext, 96);
    this.Qid = a.fromDPToPix(this.mContext, 162);
    this.Qie = a.fromDPToPix(this.mContext, 72);
    jN(this.mContext);
    AppMethodBeat.o(310563);
  }
  
  private void jN(Context paramContext)
  {
    AppMethodBeat.i(310580);
    int j = a.fromDPToPix(this.mContext, 3.6F);
    int i = 0;
    while (i < 5)
    {
      MMRoundCornerImageView localMMRoundCornerImageView = new MMRoundCornerImageView(paramContext);
      localMMRoundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localMMRoundCornerImageView.setLayoutParams(new FrameLayout.LayoutParams(this.Qic, this.Qid));
      localMMRoundCornerImageView.setRadius(j);
      addView(localMMRoundCornerImageView);
      this.Qih.add(localMMRoundCornerImageView);
      i += 1;
    }
    setCardVisibility(4);
    AppMethodBeat.o(310580);
  }
  
  private void setCardVisibility(int paramInt)
  {
    AppMethodBeat.i(310608);
    int i = 0;
    while (i < this.Qih.size())
    {
      ((View)this.Qih.get(i)).setVisibility(paramInt);
      i += 1;
    }
    AppMethodBeat.o(310608);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(310669);
    if (parama == null)
    {
      Log.e("ShakeCardAnimView", "initData, ShakeCardInfo==null");
      AppMethodBeat.o(310669);
      return;
    }
    if ((parama.PMp == null) || (parama.PMp.size() != 5))
    {
      StringBuilder localStringBuilder = new StringBuilder("initData, cardItem.size=");
      if (parama.PMp == null) {}
      for (int i = 0;; i = parama.PMp.size())
      {
        Log.e("ShakeCardAnimView", i);
        AppMethodBeat.o(310669);
        return;
      }
    }
    bz(bA(parama.PMp));
    AppMethodBeat.o(310669);
  }
  
  public final void eow()
  {
    AppMethodBeat.i(310692);
    int i = 0;
    while (i < this.Qih.size())
    {
      View localView = (View)this.Qih.get(i);
      localView.setAlpha(1.0F);
      localView.setRotation(0.0F);
      localView.setRotationY(0.0F);
      localView.setTranslationX(0.0F);
      localView.setTranslationY(0.0F);
      localView.setScaleX(1.0F);
      localView.setScaleY(1.0F);
      i += 1;
    }
    AppMethodBeat.o(310692);
  }
  
  public final void hds()
  {
    AppMethodBeat.i(310703);
    this.Qii = true;
    int i = a.fromDPToPix(this.mContext, 140);
    Object localObject1 = getChildAt(0);
    Object localObject2 = getChildAt(4);
    B((View)localObject1, 0, -i);
    B((View)localObject2, 0, i);
    Object localObject3 = getChildAt(2);
    this.Qig = ((View)localObject3);
    this.Qig.setAlpha(1.0F);
    localObject1 = ObjectAnimator.ofFloat(localObject3, "translationY", new float[] { -(getHeight() / 2 + this.Qid / 2 + this.Qie), 0.0F });
    ((ObjectAnimator)localObject1).setDuration(500L);
    ((ObjectAnimator)localObject1).addListener(new b()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(310598);
        this.val$v.setVisibility(0);
        AppMethodBeat.o(310598);
      }
    });
    localObject2 = ObjectAnimator.ofFloat(localObject3, "scaleX", new float[] { 0.3333333F, 1.0F });
    ((ObjectAnimator)localObject2).setDuration(500L);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject3, "scaleY", new float[] { 0.3333333F, 1.0F });
    localObjectAnimator1.setDuration(500L);
    ((ObjectAnimator)localObject1).addListener(new b()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(310601);
        if (CardAnimView.a(CardAnimView.this) != null)
        {
          Log.i("ShakeCardAnimView", "onPrepareCard");
          CardAnimView.a(CardAnimView.this).haV();
        }
        if (CardAnimView.b(CardAnimView.this) == null)
        {
          Log.e("ShakeCardAnimView", "playMainCardAnim, targetView==null");
          AppMethodBeat.o(310601);
          return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310593);
            Log.i("ShakeCardAnimView", "startFlip");
            CardAnimView.c(CardAnimView.this);
            AppMethodBeat.o(310593);
          }
        }, 100L);
        AppMethodBeat.o(310601);
      }
    });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject3, "scaleX", new float[] { 1.0F, 3.333333F });
    localObjectAnimator2.setDuration(500L);
    localObject3 = ObjectAnimator.ofFloat(localObject3, "scaleY", new float[] { 1.0F, 3.333333F });
    ((ObjectAnimator)localObject3).setDuration(500L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.Qif, "scaleX", new float[] { 0.3333333F, 1.0F });
    localObjectAnimator3.setDuration(500L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.Qif, "scaleY", new float[] { 0.3333333F, 1.0F });
    localObjectAnimator4.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2, localObjectAnimator1 });
    localAnimatorSet.play(localObjectAnimator2).with((Animator)localObject3).with(localObjectAnimator3).with(localObjectAnimator4).after((Animator)localObject2);
    localAnimatorSet.setStartDelay(100L);
    localAnimatorSet.start();
    localObject1 = getChildAt(1);
    localObject2 = getChildAt(3);
    B((View)localObject1, 50, -i);
    B((View)localObject2, 50, i);
    AppMethodBeat.o(310703);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(310683);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getWidth();
    paramInt1 = getHeight();
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      AppMethodBeat.o(310683);
      return;
    }
    paramInt1 = a.fromDPToPix(this.mContext, 16);
    paramInt3 = paramInt2 / 2 - this.Qic / 2;
    paramInt4 = getHeight() / 2;
    paramInt2 = paramInt4 - this.Qid / 2;
    paramInt4 += this.Qid / 2;
    getChildAt(2).layout(paramInt3, paramInt2, this.Qic + paramInt3, paramInt4);
    int i = paramInt3 - (this.Qic + paramInt1);
    getChildAt(1).layout(i, paramInt2, this.Qic + i, paramInt4);
    i = paramInt3 - (this.Qic + paramInt1) * 2;
    getChildAt(0).layout(i, paramInt2, this.Qic + i, paramInt4);
    i = this.Qic + paramInt1 + paramInt3;
    getChildAt(3).layout(i, paramInt2, this.Qic + i, paramInt4);
    paramInt1 = paramInt3 + (paramInt1 + this.Qic) * 2;
    getChildAt(4).layout(paramInt1, paramInt2, this.Qic + paramInt1, paramInt4);
    AppMethodBeat.o(310683);
  }
  
  public void setAnimCardView(View paramView)
  {
    AppMethodBeat.i(310716);
    StringBuilder localStringBuilder = new StringBuilder("setAnimCardView, target=null?");
    if (paramView == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("ShakeCardAnimView", bool);
      this.Qif = paramView;
      AppMethodBeat.o(310716);
      return;
    }
  }
  
  public void setOnCardAnimListener(ShakeCardAnimView.a parama)
  {
    this.Qij = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.shakead.CardAnimView
 * JD-Core Version:    0.7.0.1
 */