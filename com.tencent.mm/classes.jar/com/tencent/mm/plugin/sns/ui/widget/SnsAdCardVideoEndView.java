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
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import org.json.JSONObject;

public class SnsAdCardVideoEndView
  extends FrameLayout
{
  private String Dsr;
  private aw FdW;
  private ImageView FdX;
  private View FdY;
  private TextView FdZ;
  private TextView Fea;
  private TextView Feb;
  private View Fec;
  private ImageView Fed;
  private TextView Fee;
  private TextView Fef;
  private ImageView Feg;
  private SnsInfo Feh;
  private boolean Fei;
  private long Fej;
  private int mScene;
  
  public SnsAdCardVideoEndView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(176439);
    this.Dsr = "";
    this.Feh = null;
    this.Fei = false;
    this.Fej = 0L;
    LayoutInflater.from(paramContext).inflate(2131496501, this);
    this.FdX = ((ImageView)findViewById(2131304506));
    this.FdY = findViewById(2131309557);
    this.FdZ = ((TextView)findViewById(2131309559));
    this.Fea = ((TextView)findViewById(2131309556));
    this.Feb = ((TextView)findViewById(2131309558));
    this.Fec = findViewById(2131302632);
    this.Fed = ((ImageView)findViewById(2131302631));
    this.Fee = ((TextView)findViewById(2131302630));
    this.Fef = ((TextView)findViewById(2131302633));
    this.Feg = ((ImageView)findViewById(2131299288));
    this.FdX.setBackgroundColor(Color.parseColor("#7f000000"));
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
      k.jY("17539", paramSnsInfo);
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
  
  private void fla()
  {
    AppMethodBeat.i(179375);
    if ((this.Feh != null) && (this.FdW != null) && (this.Fej > 0L))
    {
      float f2 = (float)(System.currentTimeMillis() - this.Fej);
      float f1 = f2;
      if (f2 > this.FdW.duration) {
        f1 = this.FdW.duration;
      }
      a(this.Feh, this.Fej, f1 / 1000.0F);
      this.Fej = 0L;
    }
    AppMethodBeat.o(179375);
  }
  
  public static void i(SnsInfo paramSnsInfo, int paramInt)
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
      k.jY("17539", paramSnsInfo);
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
  
  private static void x(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(176446);
    if (!TextUtils.equals((String)paramImageView.getTag(2131307979), paramString))
    {
      paramImageView.setImageDrawable(null);
      b.loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(176446);
  }
  
  public final void a(aw paramaw, int paramInt)
  {
    AppMethodBeat.i(176440);
    if (paramaw == null) {
      eQ(false);
    }
    this.FdW = paramaw;
    this.mScene = paramInt;
    AppMethodBeat.o(176440);
  }
  
  public final boolean ac(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(176442);
    String str = paramSnsInfo.getSnsId();
    if ((TextUtils.isEmpty(this.Dsr)) || (!this.Dsr.equals(str)))
    {
      Log.i("SnsAdCardVideoEndView", "checkSnsId changed, old=" + this.Dsr + ", new=" + str);
      this.Fej = 0L;
      eQ(false);
      this.Dsr = str;
      this.Feh = paramSnsInfo;
      this.Fei = false;
      setBackgroundDrawable(null);
      AppMethodBeat.o(176442);
      return true;
    }
    AppMethodBeat.o(176442);
    return false;
  }
  
  public final void bpn()
  {
    AppMethodBeat.i(176441);
    if (this.FdW == null)
    {
      AppMethodBeat.o(176441);
      return;
    }
    if (!TextUtils.isEmpty(this.FdW.title))
    {
      this.FdZ.setText(this.FdW.title);
      this.Fea.setText(this.FdW.desc);
      this.Feb.setText(this.FdW.EwS);
      this.FdY.setVisibility(0);
      this.Fec.setVisibility(8);
    }
    while (!TextUtils.isEmpty(this.FdW.coverImgUrl))
    {
      this.Feg.setVisibility(0);
      x(this.Feg, this.FdW.coverImgUrl);
      AppMethodBeat.o(176441);
      return;
      this.Fee.setText(this.FdW.desc);
      this.Fef.setText(this.FdW.EwS);
      if (!TextUtils.isEmpty(this.FdW.EwR)) {
        x(this.Fed, this.FdW.EwR);
      }
      this.FdY.setVisibility(8);
      this.Fec.setVisibility(0);
    }
    this.Feg.setVisibility(8);
    AppMethodBeat.o(176441);
  }
  
  public final void eQ(boolean paramBoolean)
  {
    AppMethodBeat.i(176445);
    Log.i("SnsAdCardVideoEndView", "hide, anim=".concat(String.valueOf(paramBoolean)));
    if (getVisibility() == 0) {
      fla();
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
  
  public final void fkZ()
  {
    AppMethodBeat.i(176444);
    Log.i("SnsAdCardVideoEndView", "show, anim=true");
    this.Fej = System.currentTimeMillis();
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
      fla();
    }
    AppMethodBeat.o(179374);
  }
  
  public void setBlurBkg(View paramView)
  {
    AppMethodBeat.i(176443);
    try
    {
      boolean bool = this.Fei;
      if (bool)
      {
        AppMethodBeat.o(176443);
        return;
      }
      long l1 = System.currentTimeMillis();
      if ((paramView instanceof MMTextureView)) {}
      for (paramView = ((MMTextureView)paramView).getBitmap();; paramView = BitmapUtil.getBitmapFromView(paramView))
      {
        long l2 = System.currentTimeMillis();
        int i = paramView.getWidth() / 5;
        int j = paramView.getHeight() / 5;
        paramView = BitmapUtil.fastblur(Bitmap.createScaledBitmap(paramView, i, j, false), 20);
        long l3 = System.currentTimeMillis();
        setBackgroundDrawable(new BitmapDrawable(paramView));
        this.Fei = true;
        Log.i("SnsAdCardVideoEndView", "setBlurBkg, totalCost=" + (l3 - l1) + ", captureCost=" + (l2 - l1) + ", blurCost=" + (l3 - l2) + ", w=" + i + ", h=" + j);
        AppMethodBeat.o(176443);
        return;
      }
      return;
    }
    catch (Throwable paramView)
    {
      Log.e("SnsAdCardVideoEndView", "setBlurBkg, exp=" + paramView.toString());
      this.Fei = false;
      AppMethodBeat.o(176443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView
 * JD-Core Version:    0.7.0.1
 */