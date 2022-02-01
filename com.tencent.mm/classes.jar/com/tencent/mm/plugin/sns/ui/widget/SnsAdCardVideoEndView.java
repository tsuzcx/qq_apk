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
import com.tencent.mm.plugin.sns.ad.f.b;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.base.MMTextureView;
import org.json.JSONObject;

public class SnsAdCardVideoEndView
  extends FrameLayout
{
  private String ADO;
  private ImageView ATA;
  private p ATB;
  private boolean ATC;
  private long ATD;
  private at ATq;
  private ImageView ATr;
  private View ATs;
  private TextView ATt;
  private TextView ATu;
  private TextView ATv;
  private View ATw;
  private ImageView ATx;
  private TextView ATy;
  private TextView ATz;
  private int mScene;
  
  public SnsAdCardVideoEndView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(176439);
    this.ADO = "";
    this.ATB = null;
    this.ATC = false;
    this.ATD = 0L;
    LayoutInflater.from(paramContext).inflate(2131495602, this);
    this.ATr = ((ImageView)findViewById(2131302164));
    this.ATs = findViewById(2131306171);
    this.ATt = ((TextView)findViewById(2131306173));
    this.ATu = ((TextView)findViewById(2131306170));
    this.ATv = ((TextView)findViewById(2131306172));
    this.ATw = findViewById(2131300991);
    this.ATx = ((ImageView)findViewById(2131300990));
    this.ATy = ((TextView)findViewById(2131300989));
    this.ATz = ((TextView)findViewById(2131300992));
    this.ATA = ((ImageView)findViewById(2131298823));
    this.ATr.setBackgroundColor(Color.parseColor("#7f000000"));
    AppMethodBeat.o(176439);
  }
  
  private void a(p paramp, long paramLong, float paramFloat)
  {
    AppMethodBeat.i(176447);
    if (paramp == null)
    {
      ae.e("SnsAdCardVideoEndView", "reportVideoEndViewExpouse snsInfo==null");
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
      String str = bu.nullAsNil(paramp.ecx());
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("uxinfo", str);
      localJSONObject1.put("snsid", paramp.field_snsId);
      localJSONObject1.put("scene", this.mScene);
      paramp = localJSONObject1.toString();
      k.jm("17539", paramp);
      ae.i("SnsAdCardVideoEndView", "reportVideoEndViewExpouse 17539, content=".concat(String.valueOf(paramp)));
      AppMethodBeat.o(176447);
      return;
    }
    catch (Exception paramp)
    {
      ae.e("SnsAdCardVideoEndView", "reportVideoEndViewExpouse exp:" + paramp.toString());
      AppMethodBeat.o(176447);
    }
  }
  
  private void eiA()
  {
    AppMethodBeat.i(179375);
    if ((this.ATB != null) && (this.ATq != null) && (this.ATD > 0L))
    {
      float f2 = (float)(System.currentTimeMillis() - this.ATD);
      float f1 = f2;
      if (f2 > this.ATq.duration) {
        f1 = this.ATq.duration;
      }
      a(this.ATB, this.ATD, f1 / 1000.0F);
      this.ATD = 0L;
    }
    AppMethodBeat.o(179375);
  }
  
  public static void i(p paramp, int paramInt)
  {
    AppMethodBeat.i(176448);
    if (paramp == null)
    {
      ae.e("SnsAdCardVideoEndView", "reportVideoEndViewClick snsInfo==null, scene=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(176448);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("clickCount", 1);
      localJSONObject2.put("type", 4);
      String str = bu.nullAsNil(paramp.ecx());
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("uxinfo", str);
      localJSONObject1.put("snsid", paramp.field_snsId);
      localJSONObject1.put("scene", paramInt);
      paramp = localJSONObject1.toString();
      k.jm("17539", paramp);
      ae.i("SnsAdCardVideoEndView", "reportVideoEndViewClick 17539, content=".concat(String.valueOf(paramp)));
      AppMethodBeat.o(176448);
      return;
    }
    catch (Exception paramp)
    {
      ae.e("SnsAdCardVideoEndView", "reportVideoEndViewClick exp:" + paramp.toString());
      AppMethodBeat.o(176448);
    }
  }
  
  private static void u(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(176446);
    if (!TextUtils.equals((String)paramImageView.getTag(2131304892), paramString))
    {
      paramImageView.setImageDrawable(null);
      b.loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(176446);
  }
  
  public final boolean V(p paramp)
  {
    AppMethodBeat.i(176442);
    String str = paramp.getSnsId();
    if ((TextUtils.isEmpty(this.ADO)) || (!this.ADO.equals(str)))
    {
      ae.i("SnsAdCardVideoEndView", "checkSnsId changed, old=" + this.ADO + ", new=" + str);
      this.ATD = 0L;
      dX(false);
      this.ADO = str;
      this.ATB = paramp;
      this.ATC = false;
      setBackgroundDrawable(null);
      AppMethodBeat.o(176442);
      return true;
    }
    AppMethodBeat.o(176442);
    return false;
  }
  
  public final void a(at paramat, int paramInt)
  {
    AppMethodBeat.i(176440);
    if (paramat == null) {
      dX(false);
    }
    this.ATq = paramat;
    this.mScene = paramInt;
    AppMethodBeat.o(176440);
  }
  
  public final void aUA()
  {
    AppMethodBeat.i(176441);
    if (this.ATq == null)
    {
      AppMethodBeat.o(176441);
      return;
    }
    if (!TextUtils.isEmpty(this.ATq.title))
    {
      this.ATt.setText(this.ATq.title);
      this.ATu.setText(this.ATq.desc);
      this.ATv.setText(this.ATq.Aoh);
      this.ATs.setVisibility(0);
      this.ATw.setVisibility(8);
    }
    while (!TextUtils.isEmpty(this.ATq.coverImgUrl))
    {
      this.ATA.setVisibility(0);
      u(this.ATA, this.ATq.coverImgUrl);
      AppMethodBeat.o(176441);
      return;
      this.ATy.setText(this.ATq.desc);
      this.ATz.setText(this.ATq.Aoh);
      if (!TextUtils.isEmpty(this.ATq.Aog)) {
        u(this.ATx, this.ATq.Aog);
      }
      this.ATs.setVisibility(8);
      this.ATw.setVisibility(0);
    }
    this.ATA.setVisibility(8);
    AppMethodBeat.o(176441);
  }
  
  public final void dX(boolean paramBoolean)
  {
    AppMethodBeat.i(176445);
    ae.i("SnsAdCardVideoEndView", "hide, anim=".concat(String.valueOf(paramBoolean)));
    if (getVisibility() == 0) {
      eiA();
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
  
  public final void eiz()
  {
    AppMethodBeat.i(176444);
    ae.i("SnsAdCardVideoEndView", "show, anim=true");
    this.ATD = System.currentTimeMillis();
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
      ae.i("SnsAdCardVideoEndView", "onAttachedToWindow");
    }
    AppMethodBeat.o(179373);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179374);
    super.onDetachedFromWindow();
    if (getVisibility() == 0)
    {
      ae.i("SnsAdCardVideoEndView", "onDetachedFromWindow");
      eiA();
    }
    AppMethodBeat.o(179374);
  }
  
  public void setBlurBkg(View paramView)
  {
    AppMethodBeat.i(176443);
    try
    {
      boolean bool = this.ATC;
      if (bool)
      {
        AppMethodBeat.o(176443);
        return;
      }
      long l1 = System.currentTimeMillis();
      if ((paramView instanceof MMTextureView)) {}
      for (paramView = ((MMTextureView)paramView).getBitmap();; paramView = h.fZ(paramView))
      {
        long l2 = System.currentTimeMillis();
        int i = paramView.getWidth() / 5;
        int j = paramView.getHeight() / 5;
        paramView = h.l(Bitmap.createScaledBitmap(paramView, i, j, false), 20);
        long l3 = System.currentTimeMillis();
        setBackgroundDrawable(new BitmapDrawable(paramView));
        this.ATC = true;
        ae.i("SnsAdCardVideoEndView", "setBlurBkg, totalCost=" + (l3 - l1) + ", captureCost=" + (l2 - l1) + ", blurCost=" + (l3 - l2) + ", w=" + i + ", h=" + j);
        AppMethodBeat.o(176443);
        return;
      }
      return;
    }
    catch (Throwable paramView)
    {
      ae.e("SnsAdCardVideoEndView", "setBlurBkg, exp=" + paramView.toString());
      this.ATC = false;
      AppMethodBeat.o(176443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView
 * JD-Core Version:    0.7.0.1
 */