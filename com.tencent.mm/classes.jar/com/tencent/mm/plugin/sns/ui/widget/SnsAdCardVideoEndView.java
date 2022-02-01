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
import com.tencent.mm.plugin.sns.ad.e.a;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.MMTextureView;
import org.json.JSONObject;

public class SnsAdCardVideoEndView
  extends FrameLayout
{
  private int mScene;
  private String yUR;
  private aq zjO;
  private ImageView zjP;
  private View zjQ;
  private TextView zjR;
  private TextView zjS;
  private TextView zjT;
  private View zjU;
  private ImageView zjV;
  private TextView zjW;
  private TextView zjX;
  private ImageView zjY;
  private p zjZ;
  private boolean zka;
  private long zkb;
  
  public SnsAdCardVideoEndView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(176439);
    this.yUR = "";
    this.zjZ = null;
    this.zka = false;
    this.zkb = 0L;
    LayoutInflater.from(paramContext).inflate(2131495602, this);
    this.zjP = ((ImageView)findViewById(2131302164));
    this.zjQ = findViewById(2131306171);
    this.zjR = ((TextView)findViewById(2131306173));
    this.zjS = ((TextView)findViewById(2131306170));
    this.zjT = ((TextView)findViewById(2131306172));
    this.zjU = findViewById(2131300991);
    this.zjV = ((ImageView)findViewById(2131300990));
    this.zjW = ((TextView)findViewById(2131300989));
    this.zjX = ((TextView)findViewById(2131300992));
    this.zjY = ((ImageView)findViewById(2131298823));
    this.zjP.setBackgroundColor(Color.parseColor("#7f000000"));
    AppMethodBeat.o(176439);
  }
  
  private void a(p paramp, long paramLong, float paramFloat)
  {
    AppMethodBeat.i(176447);
    if (paramp == null)
    {
      ac.e("SnsAdCardVideoEndView", "reportVideoEndViewExpouse snsInfo==null");
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
      String str = bs.nullAsNil(paramp.dMD());
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("uxinfo", str);
      localJSONObject1.put("snsid", paramp.field_snsId);
      localJSONObject1.put("scene", this.mScene);
      paramp = localJSONObject1.toString();
      j.iU("17539", paramp);
      ac.i("SnsAdCardVideoEndView", "reportVideoEndViewExpouse 17539, content=".concat(String.valueOf(paramp)));
      AppMethodBeat.o(176447);
      return;
    }
    catch (Exception paramp)
    {
      ac.e("SnsAdCardVideoEndView", "reportVideoEndViewExpouse exp:" + paramp.toString());
      AppMethodBeat.o(176447);
    }
  }
  
  private void dSz()
  {
    AppMethodBeat.i(179375);
    if ((this.zjZ != null) && (this.zjO != null) && (this.zkb > 0L))
    {
      float f2 = (float)(System.currentTimeMillis() - this.zkb);
      float f1 = f2;
      if (f2 > this.zjO.duration) {
        f1 = this.zjO.duration;
      }
      a(this.zjZ, this.zkb, f1 / 1000.0F);
      this.zkb = 0L;
    }
    AppMethodBeat.o(179375);
  }
  
  public static void h(p paramp, int paramInt)
  {
    AppMethodBeat.i(176448);
    if (paramp == null)
    {
      ac.e("SnsAdCardVideoEndView", "reportVideoEndViewClick snsInfo==null, scene=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(176448);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("clickCount", 1);
      localJSONObject2.put("type", 4);
      String str = bs.nullAsNil(paramp.dMD());
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("uxinfo", str);
      localJSONObject1.put("snsid", paramp.field_snsId);
      localJSONObject1.put("scene", paramInt);
      paramp = localJSONObject1.toString();
      j.iU("17539", paramp);
      ac.i("SnsAdCardVideoEndView", "reportVideoEndViewClick 17539, content=".concat(String.valueOf(paramp)));
      AppMethodBeat.o(176448);
      return;
    }
    catch (Exception paramp)
    {
      ac.e("SnsAdCardVideoEndView", "reportVideoEndViewClick exp:" + paramp.toString());
      AppMethodBeat.o(176448);
    }
  }
  
  private static void u(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(176446);
    if (!TextUtils.equals((String)paramImageView.getTag(2131304892), paramString))
    {
      paramImageView.setImageDrawable(null);
      a.loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(176446);
  }
  
  public final boolean T(p paramp)
  {
    AppMethodBeat.i(176442);
    String str = paramp.getSnsId();
    if ((TextUtils.isEmpty(this.yUR)) || (!this.yUR.equals(str)))
    {
      ac.i("SnsAdCardVideoEndView", "checkSnsId changed, old=" + this.yUR + ", new=" + str);
      this.zkb = 0L;
      dT(false);
      this.yUR = str;
      this.zjZ = paramp;
      this.zka = false;
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
      dT(false);
    }
    this.zjO = paramaq;
    this.mScene = paramInt;
    AppMethodBeat.o(176440);
  }
  
  public final void aQP()
  {
    AppMethodBeat.i(176441);
    if (this.zjO == null)
    {
      AppMethodBeat.o(176441);
      return;
    }
    if (!TextUtils.isEmpty(this.zjO.title))
    {
      this.zjR.setText(this.zjO.title);
      this.zjS.setText(this.zjO.desc);
      this.zjT.setText(this.zjO.yFE);
      this.zjQ.setVisibility(0);
      this.zjU.setVisibility(8);
    }
    while (!TextUtils.isEmpty(this.zjO.coverImgUrl))
    {
      this.zjY.setVisibility(0);
      u(this.zjY, this.zjO.coverImgUrl);
      AppMethodBeat.o(176441);
      return;
      this.zjW.setText(this.zjO.desc);
      this.zjX.setText(this.zjO.yFE);
      if (!TextUtils.isEmpty(this.zjO.yFD)) {
        u(this.zjV, this.zjO.yFD);
      }
      this.zjQ.setVisibility(8);
      this.zjU.setVisibility(0);
    }
    this.zjY.setVisibility(8);
    AppMethodBeat.o(176441);
  }
  
  public final void dSy()
  {
    AppMethodBeat.i(176444);
    ac.i("SnsAdCardVideoEndView", "show, anim=true");
    this.zkb = System.currentTimeMillis();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(100L);
    localAlphaAnimation.setDuration(300L);
    setVisibility(0);
    startAnimation(localAlphaAnimation);
    AppMethodBeat.o(176444);
  }
  
  public final void dT(boolean paramBoolean)
  {
    AppMethodBeat.i(176445);
    ac.i("SnsAdCardVideoEndView", "hide, anim=".concat(String.valueOf(paramBoolean)));
    if (getVisibility() == 0) {
      dSz();
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
      ac.i("SnsAdCardVideoEndView", "onAttachedToWindow");
    }
    AppMethodBeat.o(179373);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179374);
    super.onDetachedFromWindow();
    if (getVisibility() == 0)
    {
      ac.i("SnsAdCardVideoEndView", "onDetachedFromWindow");
      dSz();
    }
    AppMethodBeat.o(179374);
  }
  
  public void setBlurBkg(View paramView)
  {
    AppMethodBeat.i(176443);
    try
    {
      boolean bool = this.zka;
      if (bool)
      {
        AppMethodBeat.o(176443);
        return;
      }
      long l1 = System.currentTimeMillis();
      if ((paramView instanceof MMTextureView)) {}
      for (paramView = ((MMTextureView)paramView).getBitmap();; paramView = f.fL(paramView))
      {
        long l2 = System.currentTimeMillis();
        int i = paramView.getWidth() / 5;
        int j = paramView.getHeight() / 5;
        paramView = f.l(Bitmap.createScaledBitmap(paramView, i, j, false), 20);
        long l3 = System.currentTimeMillis();
        setBackgroundDrawable(new BitmapDrawable(paramView));
        this.zka = true;
        ac.i("SnsAdCardVideoEndView", "setBlurBkg, totalCost=" + (l3 - l1) + ", captureCost=" + (l2 - l1) + ", blurCost=" + (l3 - l2) + ", w=" + i + ", h=" + j);
        AppMethodBeat.o(176443);
        return;
      }
      return;
    }
    catch (Throwable paramView)
    {
      ac.e("SnsAdCardVideoEndView", "setBlurBkg, exp=" + paramView.toString());
      this.zka = false;
      AppMethodBeat.o(176443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView
 * JD-Core Version:    0.7.0.1
 */