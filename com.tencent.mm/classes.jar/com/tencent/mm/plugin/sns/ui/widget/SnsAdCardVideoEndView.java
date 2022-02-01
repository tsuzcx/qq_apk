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
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class SnsAdCardVideoEndView
  extends FrameLayout
{
  private String JyZ;
  private ay LsB;
  private ImageView LsC;
  private View LsD;
  private TextView LsE;
  private TextView LsF;
  private TextView LsG;
  private View LsH;
  private ImageView LsI;
  private TextView LsJ;
  private TextView LsK;
  private ImageView LsL;
  private SnsInfo LsM;
  private boolean LsN;
  private long LsO;
  private int mScene;
  
  public SnsAdCardVideoEndView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(176439);
    this.JyZ = "";
    this.LsM = null;
    this.LsN = false;
    this.LsO = 0L;
    LayoutInflater.from(paramContext).inflate(i.g.sns_timeline_ad_cardvideo_endview, this);
    this.LsC = ((ImageView)findViewById(i.f.mask_img));
    this.LsD = findViewById(i.f.txt_style_layout);
    this.LsE = ((TextView)findViewById(i.f.txt_style_title));
    this.LsF = ((TextView)findViewById(i.f.txt_style_desc));
    this.LsG = ((TextView)findViewById(i.f.txt_style_link));
    this.LsH = findViewById(i.f.img_style_layout);
    this.LsI = ((ImageView)findViewById(i.f.img_style_icon));
    this.LsJ = ((TextView)findViewById(i.f.img_style_desc));
    this.LsK = ((TextView)findViewById(i.f.img_style_link));
    this.LsL = ((ImageView)findViewById(i.f.cover_img));
    this.LsC.setBackgroundColor(Color.parseColor("#7f000000"));
    AppMethodBeat.o(176439);
  }
  
  private void a(SnsInfo paramSnsInfo, long paramLong, float paramFloat)
  {
    AppMethodBeat.i(176447);
    if (paramSnsInfo == null)
    {
      Log.e("SnsAdCardVideoEndView", "reportVideoEndViewExpouse snsInfo==null");
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
      String str = Util.nullAsNil(paramSnsInfo.getUxinfo());
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("uxinfo", str);
      localJSONObject1.put("snsid", paramSnsInfo.field_snsId);
      localJSONObject1.put("scene", this.mScene);
      paramSnsInfo = localJSONObject1.toString();
      m.ks("17539", paramSnsInfo);
      Log.i("SnsAdCardVideoEndView", "reportVideoEndViewExpouse 17539, content=".concat(String.valueOf(paramSnsInfo)));
      AppMethodBeat.o(176447);
      return;
    }
    catch (Exception paramSnsInfo)
    {
      Log.e("SnsAdCardVideoEndView", "reportVideoEndViewExpouse exp:" + paramSnsInfo.toString());
      AppMethodBeat.o(176447);
    }
  }
  
  private void fZt()
  {
    AppMethodBeat.i(179375);
    if ((this.LsM != null) && (this.LsB != null) && (this.LsO > 0L))
    {
      float f2 = (float)(System.currentTimeMillis() - this.LsO);
      float f1 = f2;
      if (f2 > this.LsB.duration) {
        f1 = this.LsB.duration;
      }
      a(this.LsM, this.LsO, f1 / 1000.0F);
      this.LsO = 0L;
    }
    AppMethodBeat.o(179375);
  }
  
  public static void j(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(176448);
    if (paramSnsInfo == null)
    {
      Log.e("SnsAdCardVideoEndView", "reportVideoEndViewClick snsInfo==null, scene=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(176448);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("clickCount", 1);
      localJSONObject2.put("type", 4);
      String str = Util.nullAsNil(paramSnsInfo.getUxinfo());
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("uxinfo", str);
      localJSONObject1.put("snsid", paramSnsInfo.field_snsId);
      localJSONObject1.put("scene", paramInt);
      paramSnsInfo = localJSONObject1.toString();
      m.ks("17539", paramSnsInfo);
      Log.i("SnsAdCardVideoEndView", "reportVideoEndViewClick 17539, content=".concat(String.valueOf(paramSnsInfo)));
      AppMethodBeat.o(176448);
      return;
    }
    catch (Exception paramSnsInfo)
    {
      Log.e("SnsAdCardVideoEndView", "reportVideoEndViewClick exp:" + paramSnsInfo.toString());
      AppMethodBeat.o(176448);
    }
  }
  
  private static void z(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(176446);
    if (!TextUtils.equals((String)paramImageView.getTag(i.f.sns_ad_card_img_url), paramString))
    {
      paramImageView.setImageDrawable(null);
      c.loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(176446);
  }
  
  public final void a(ay paramay, int paramInt)
  {
    AppMethodBeat.i(176440);
    if (paramay == null) {
      fv(false);
    }
    this.LsB = paramay;
    this.mScene = paramInt;
    AppMethodBeat.o(176440);
  }
  
  public final boolean ad(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(176442);
    String str = paramSnsInfo.getSnsId();
    if ((TextUtils.isEmpty(this.JyZ)) || (!this.JyZ.equals(str)))
    {
      Log.i("SnsAdCardVideoEndView", "checkSnsId changed, old=" + this.JyZ + ", new=" + str);
      this.LsO = 0L;
      fv(false);
      this.JyZ = str;
      this.LsM = paramSnsInfo;
      this.LsN = false;
      setBackgroundDrawable(null);
      AppMethodBeat.o(176442);
      return true;
    }
    AppMethodBeat.o(176442);
    return false;
  }
  
  public final void bzz()
  {
    AppMethodBeat.i(176441);
    if (this.LsB == null)
    {
      AppMethodBeat.o(176441);
      return;
    }
    if (!TextUtils.isEmpty(this.LsB.title))
    {
      this.LsE.setText(this.LsB.title);
      this.LsF.setText(this.LsB.desc);
      this.LsG.setText(this.LsB.KKL);
      this.LsD.setVisibility(0);
      this.LsH.setVisibility(8);
    }
    while (!TextUtils.isEmpty(this.LsB.coverImgUrl))
    {
      this.LsL.setVisibility(0);
      z(this.LsL, this.LsB.coverImgUrl);
      AppMethodBeat.o(176441);
      return;
      this.LsJ.setText(this.LsB.desc);
      this.LsK.setText(this.LsB.KKL);
      if (!TextUtils.isEmpty(this.LsB.KKK)) {
        z(this.LsI, this.LsB.KKK);
      }
      this.LsD.setVisibility(8);
      this.LsH.setVisibility(0);
    }
    this.LsL.setVisibility(8);
    AppMethodBeat.o(176441);
  }
  
  public final void equ()
  {
    AppMethodBeat.i(176444);
    Log.i("SnsAdCardVideoEndView", "show, anim=true");
    this.LsO = System.currentTimeMillis();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(100L);
    localAlphaAnimation.setDuration(300L);
    setVisibility(0);
    startAnimation(localAlphaAnimation);
    AppMethodBeat.o(176444);
  }
  
  public final void fv(boolean paramBoolean)
  {
    AppMethodBeat.i(176445);
    Log.i("SnsAdCardVideoEndView", "hide, anim=".concat(String.valueOf(paramBoolean)));
    if (getVisibility() == 0) {
      fZt();
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
      Log.i("SnsAdCardVideoEndView", "onAttachedToWindow");
    }
    AppMethodBeat.o(179373);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179374);
    super.onDetachedFromWindow();
    if (getVisibility() == 0)
    {
      Log.i("SnsAdCardVideoEndView", "onDetachedFromWindow");
      fZt();
    }
    AppMethodBeat.o(179374);
  }
  
  public void setBlurBkg(View paramView)
  {
    AppMethodBeat.i(176443);
    try
    {
      boolean bool = this.LsN;
      if (bool)
      {
        AppMethodBeat.o(176443);
        return;
      }
      long l1 = System.currentTimeMillis();
      if ((paramView instanceof com.tencent.mm.ui.base.MMTextureView)) {
        paramView = ((com.tencent.mm.ui.base.MMTextureView)paramView).getBitmap();
      }
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        int i = paramView.getWidth() / 5;
        int j = paramView.getHeight() / 5;
        paramView = BitmapUtil.fastblur(Bitmap.createScaledBitmap(paramView, i, j, false), 20);
        long l3 = System.currentTimeMillis();
        setBackgroundDrawable(new BitmapDrawable(paramView));
        this.LsN = true;
        Log.i("SnsAdCardVideoEndView", "setBlurBkg, totalCost=" + (l3 - l1) + ", captureCost=" + (l2 - l1) + ", blurCost=" + (l3 - l2) + ", w=" + i + ", h=" + j);
        AppMethodBeat.o(176443);
        return;
        if ((paramView instanceof com.tencent.mm.plugin.thumbplayer.view.MMTextureView)) {
          paramView = ((com.tencent.mm.plugin.thumbplayer.view.MMTextureView)paramView).getBitmap();
        } else {
          paramView = BitmapUtil.getBitmapFromView(paramView);
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      Log.e("SnsAdCardVideoEndView", "setBlurBkg, exp=" + paramView.toString());
      this.LsN = false;
      AppMethodBeat.o(176443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView
 * JD-Core Version:    0.7.0.1
 */