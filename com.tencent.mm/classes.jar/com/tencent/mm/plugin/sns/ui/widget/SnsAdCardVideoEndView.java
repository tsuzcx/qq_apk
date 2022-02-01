package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.item.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.MMTextureView;
import org.json.JSONObject;

public class SnsAdCardVideoEndView
  extends FrameLayout
{
  private int mScene;
  private String xIb;
  private aq xWT;
  private ImageView xWU;
  private View xWV;
  private TextView xWW;
  private TextView xWX;
  private TextView xWY;
  private View xWZ;
  private ImageView xXa;
  private TextView xXb;
  private TextView xXc;
  private ImageView xXd;
  private p xXe;
  private boolean xXf;
  private long xXg;
  
  public SnsAdCardVideoEndView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(176439);
    this.xIb = "";
    this.xXe = null;
    this.xXf = false;
    this.xXg = 0L;
    LayoutInflater.from(paramContext).inflate(2131495602, this);
    this.xWU = ((ImageView)findViewById(2131302164));
    this.xWV = findViewById(2131306171);
    this.xWW = ((TextView)findViewById(2131306173));
    this.xWX = ((TextView)findViewById(2131306170));
    this.xWY = ((TextView)findViewById(2131306172));
    this.xWZ = findViewById(2131300991);
    this.xXa = ((ImageView)findViewById(2131300990));
    this.xXb = ((TextView)findViewById(2131300989));
    this.xXc = ((TextView)findViewById(2131300992));
    this.xXd = ((ImageView)findViewById(2131298823));
    this.xWU.setBackgroundColor(Color.parseColor("#7f000000"));
    AppMethodBeat.o(176439);
  }
  
  private void a(p paramp, long paramLong, float paramFloat)
  {
    AppMethodBeat.i(176447);
    if (paramp == null)
    {
      ad.e("SnsAdCardVideoEndView", "reportVideoEndViewExpouse snsInfo==null");
      AppMethodBeat.o(176447);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("exposureDuration", paramFloat);
      localJSONObject2.put("startTimestamp", paramLong);
      localJSONObject2.put("type", 5);
      String str = bt.nullAsNil(paramp.dyg());
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("uxinfo", str);
      localJSONObject1.put("snsid", paramp.field_snsId);
      localJSONObject1.put("scene", this.mScene);
      paramp = localJSONObject1.toString();
      j.ix("17539", paramp);
      ad.i("SnsAdCardVideoEndView", "reportVideoEndViewExpouse 17539, content=".concat(String.valueOf(paramp)));
      AppMethodBeat.o(176447);
      return;
    }
    catch (Exception paramp)
    {
      ad.e("SnsAdCardVideoEndView", "reportVideoEndViewExpouse exp:" + paramp.toString());
      AppMethodBeat.o(176447);
    }
  }
  
  private void dEb()
  {
    AppMethodBeat.i(179375);
    if ((this.xXe != null) && (this.xWT != null) && (this.xXg > 0L))
    {
      float f2 = (float)(System.currentTimeMillis() - this.xXg);
      float f1 = f2;
      if (f2 > this.xWT.duration) {
        f1 = this.xWT.duration;
      }
      a(this.xXe, this.xXg, f1 / 1000.0F);
      this.xXg = 0L;
    }
    AppMethodBeat.o(179375);
  }
  
  public static void h(p paramp, int paramInt)
  {
    AppMethodBeat.i(176448);
    if (paramp == null)
    {
      ad.e("SnsAdCardVideoEndView", "reportVideoEndViewClick snsInfo==null, scene=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(176448);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("clickCount", 1);
      localJSONObject2.put("type", 4);
      String str = bt.nullAsNil(paramp.dyg());
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("uxinfo", str);
      localJSONObject1.put("snsid", paramp.field_snsId);
      localJSONObject1.put("scene", paramInt);
      paramp = localJSONObject1.toString();
      j.ix("17539", paramp);
      ad.i("SnsAdCardVideoEndView", "reportVideoEndViewClick 17539, content=".concat(String.valueOf(paramp)));
      AppMethodBeat.o(176448);
      return;
    }
    catch (Exception paramp)
    {
      ad.e("SnsAdCardVideoEndView", "reportVideoEndViewClick exp:" + paramp.toString());
      AppMethodBeat.o(176448);
    }
  }
  
  private static void u(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(176446);
    if (!TextUtils.equals((String)paramImageView.getTag(2131304892), paramString))
    {
      paramImageView.setImageDrawable(null);
      c.loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(176446);
  }
  
  public final boolean S(p paramp)
  {
    AppMethodBeat.i(176442);
    String str = paramp.getSnsId();
    if ((TextUtils.isEmpty(this.xIb)) || (!this.xIb.equals(str)))
    {
      ad.i("SnsAdCardVideoEndView", "checkSnsId changed, old=" + this.xIb + ", new=" + str);
      this.xXg = 0L;
      hH(false);
      this.xIb = str;
      this.xXe = paramp;
      this.xXf = false;
      setBackgroundDrawable(null);
      AppMethodBeat.o(176442);
      return true;
    }
    AppMethodBeat.o(176442);
    return false;
  }
  
  public final void a(aq paramaq, int paramInt)
  {
    AppMethodBeat.i(176440);
    if (paramaq == null) {
      hH(false);
    }
    this.xWT = paramaq;
    this.mScene = paramInt;
    AppMethodBeat.o(176440);
  }
  
  public final void aJY()
  {
    AppMethodBeat.i(176441);
    if (this.xWT == null)
    {
      AppMethodBeat.o(176441);
      return;
    }
    if (!TextUtils.isEmpty(this.xWT.title))
    {
      this.xWW.setText(this.xWT.title);
      this.xWX.setText(this.xWT.desc);
      this.xWY.setText(this.xWT.xsN);
      this.xWV.setVisibility(0);
      this.xWZ.setVisibility(8);
    }
    while (!TextUtils.isEmpty(this.xWT.coverImgUrl))
    {
      this.xXd.setVisibility(0);
      u(this.xXd, this.xWT.coverImgUrl);
      AppMethodBeat.o(176441);
      return;
      this.xXb.setText(this.xWT.desc);
      this.xXc.setText(this.xWT.xsN);
      if (!TextUtils.isEmpty(this.xWT.xsM)) {
        u(this.xXa, this.xWT.xsM);
      }
      this.xWV.setVisibility(8);
      this.xWZ.setVisibility(0);
    }
    this.xXd.setVisibility(8);
    AppMethodBeat.o(176441);
  }
  
  public final void dEa()
  {
    AppMethodBeat.i(176444);
    ad.i("SnsAdCardVideoEndView", "show, anim=true");
    this.xXg = System.currentTimeMillis();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(100L);
    localAlphaAnimation.setDuration(300L);
    setVisibility(0);
    startAnimation(localAlphaAnimation);
    AppMethodBeat.o(176444);
  }
  
  public final void hH(boolean paramBoolean)
  {
    AppMethodBeat.i(176445);
    ad.i("SnsAdCardVideoEndView", "hide, anim=".concat(String.valueOf(paramBoolean)));
    if (getVisibility() == 0) {
      dEb();
    }
    if (!paramBoolean)
    {
      setVisibility(8);
      AppMethodBeat.o(176445);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(250L);
    localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(176438);
        SnsAdCardVideoEndView.this.setVisibility(8);
        AppMethodBeat.o(176438);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    startAnimation(localAlphaAnimation);
    AppMethodBeat.o(176445);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(179373);
    super.onAttachedToWindow();
    if (getVisibility() == 0) {
      ad.i("SnsAdCardVideoEndView", "onAttachedToWindow");
    }
    AppMethodBeat.o(179373);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179374);
    super.onDetachedFromWindow();
    if (getVisibility() == 0)
    {
      ad.i("SnsAdCardVideoEndView", "onDetachedFromWindow");
      dEb();
    }
    AppMethodBeat.o(179374);
  }
  
  public void setBlurBkg(View paramView)
  {
    AppMethodBeat.i(176443);
    try
    {
      boolean bool = this.xXf;
      if (bool)
      {
        AppMethodBeat.o(176443);
        return;
      }
      long l1 = System.currentTimeMillis();
      if ((paramView instanceof MMTextureView)) {}
      for (paramView = ((MMTextureView)paramView).getBitmap();; paramView = f.fy(paramView))
      {
        long l2 = System.currentTimeMillis();
        int i = paramView.getWidth() / 5;
        int j = paramView.getHeight() / 5;
        paramView = f.l(Bitmap.createScaledBitmap(paramView, i, j, false), 20);
        long l3 = System.currentTimeMillis();
        setBackgroundDrawable(new BitmapDrawable(paramView));
        this.xXf = true;
        ad.i("SnsAdCardVideoEndView", "setBlurBkg, totalCost=" + (l3 - l1) + ", captureCost=" + (l2 - l1) + ", blurCost=" + (l3 - l2) + ", w=" + i + ", h=" + j);
        AppMethodBeat.o(176443);
        return;
      }
      return;
    }
    catch (Throwable paramView)
    {
      ad.e("SnsAdCardVideoEndView", "setBlurBkg, exp=" + paramView.toString());
      this.xXf = false;
      AppMethodBeat.o(176443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView
 * JD-Core Version:    0.7.0.1
 */