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
import com.tencent.mm.plugin.sns.ad.j.a;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class SnsAdCardVideoEndView
  extends FrameLayout
{
  private String PNx;
  private az RVR;
  private ImageView RVS;
  private View RVT;
  private TextView RVU;
  private TextView RVV;
  private TextView RVW;
  private View RVX;
  private ImageView RVY;
  private TextView RVZ;
  private TextView RWa;
  private ImageView RWb;
  private SnsInfo RWc;
  private boolean RWd;
  private long RWe;
  private int mScene;
  
  public SnsAdCardVideoEndView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(176439);
    this.PNx = "";
    this.RWc = null;
    this.RWd = false;
    this.RWe = 0L;
    LayoutInflater.from(paramContext).inflate(b.g.sns_timeline_ad_cardvideo_endview, this);
    this.RVS = ((ImageView)findViewById(b.f.mask_img));
    this.RVT = findViewById(b.f.txt_style_layout);
    this.RVU = ((TextView)findViewById(b.f.txt_style_title));
    this.RVV = ((TextView)findViewById(b.f.txt_style_desc));
    this.RVW = ((TextView)findViewById(b.f.txt_style_link));
    this.RVX = findViewById(b.f.img_style_layout);
    this.RVY = ((ImageView)findViewById(b.f.img_style_icon));
    this.RVZ = ((TextView)findViewById(b.f.img_style_desc));
    this.RWa = ((TextView)findViewById(b.f.img_style_link));
    this.RWb = ((ImageView)findViewById(b.f.cover_img));
    this.RVS.setBackgroundColor(Color.parseColor("#7f000000"));
    m.q(this.RVU, b.d.sns_ad_fullcard_endview_title);
    m.q(this.RVV, b.d.sns_ad_fullcard_endview_desc);
    m.q(this.RVW, b.d.sns_ad_fullcard_endview_link);
    m.q(this.RVZ, b.d.sns_ad_fullcard_endview_img_desc);
    m.q(this.RWa, b.d.sns_ad_fullcard_endview_link);
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
      m.lU("17539", paramSnsInfo);
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
  
  private void hsI()
  {
    AppMethodBeat.i(179375);
    if ((this.RWc != null) && (this.RVR != null) && (this.RWe > 0L))
    {
      float f2 = (float)(System.currentTimeMillis() - this.RWe);
      float f1 = f2;
      if (f2 > this.RVR.duration) {
        f1 = this.RVR.duration;
      }
      a(this.RWc, this.RWe, f1 / 1000.0F);
      this.RWe = 0L;
    }
    AppMethodBeat.o(179375);
  }
  
  public static void k(SnsInfo paramSnsInfo, int paramInt)
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
      m.lU("17539", paramSnsInfo);
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
  
  public final void a(az paramaz, int paramInt)
  {
    AppMethodBeat.i(176440);
    if (paramaz == null) {
      gc(false);
    }
    this.RVR = paramaz;
    this.mScene = paramInt;
    AppMethodBeat.o(176440);
  }
  
  public final boolean ah(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(176442);
    String str = paramSnsInfo.getSnsId();
    if ((TextUtils.isEmpty(this.PNx)) || (!this.PNx.equals(str)))
    {
      Log.i("SnsAdCardVideoEndView", "checkSnsId changed, old=" + this.PNx + ", new=" + str);
      this.RWe = 0L;
      gc(false);
      this.PNx = str;
      this.RWc = paramSnsInfo;
      this.RWd = false;
      setBackgroundDrawable(null);
      AppMethodBeat.o(176442);
      return true;
    }
    AppMethodBeat.o(176442);
    return false;
  }
  
  public final void bYl()
  {
    AppMethodBeat.i(176441);
    if (this.RVR == null)
    {
      AppMethodBeat.o(176441);
      return;
    }
    if (!TextUtils.isEmpty(this.RVR.title))
    {
      this.RVU.setText(this.RVR.title);
      this.RVV.setText(this.RVR.desc);
      this.RVW.setText(this.RVR.Rkx);
      this.RVT.setVisibility(0);
      this.RVX.setVisibility(8);
    }
    while (!TextUtils.isEmpty(this.RVR.coverImgUrl))
    {
      this.RWb.setVisibility(0);
      a.o(this.RVR.coverImgUrl, this.RWb);
      AppMethodBeat.o(176441);
      return;
      this.RVZ.setText(this.RVR.desc);
      this.RWa.setText(this.RVR.Rkx);
      if (!TextUtils.isEmpty(this.RVR.Rkw)) {
        a.o(this.RVR.Rkw, this.RVY);
      }
      this.RVT.setVisibility(8);
      this.RVX.setVisibility(0);
    }
    this.RWb.setVisibility(8);
    AppMethodBeat.o(176441);
  }
  
  public final void gc(boolean paramBoolean)
  {
    AppMethodBeat.i(176445);
    Log.i("SnsAdCardVideoEndView", "hide, anim=".concat(String.valueOf(paramBoolean)));
    if (getVisibility() == 0) {
      hsI();
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
  
  public final void hsH()
  {
    AppMethodBeat.i(176444);
    Log.i("SnsAdCardVideoEndView", "show, anim=true");
    this.RWe = System.currentTimeMillis();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(100L);
    localAlphaAnimation.setDuration(300L);
    setVisibility(0);
    startAnimation(localAlphaAnimation);
    AppMethodBeat.o(176444);
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
      hsI();
    }
    AppMethodBeat.o(179374);
  }
  
  public void setBlurBkg(View paramView)
  {
    AppMethodBeat.i(176443);
    try
    {
      boolean bool = this.RWd;
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
        this.RWd = true;
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
    finally
    {
      Log.e("SnsAdCardVideoEndView", "setBlurBkg, exp=" + paramView.toString());
      this.RWd = false;
      AppMethodBeat.o(176443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView
 * JD-Core Version:    0.7.0.1
 */