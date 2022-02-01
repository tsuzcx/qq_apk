package com.tencent.mm.plugin.sns.ad.widget.interactionlabel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.xw;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public class SnsAdInteractionLabelView
  extends LinearLayout
{
  private Handler PRJ;
  protected long PZu;
  protected AnimatorSet QgA;
  protected AnimatorSet QgB;
  protected b QgC;
  protected boolean QgD;
  private IListener<xw> QgE;
  protected ImageView Qgt;
  protected ImageView Qgu;
  protected TextView Qgv;
  protected TextView Qgw;
  protected ArrayList<String> Qgx;
  protected int Qgy;
  protected boolean Qgz;
  protected TextView fO;
  protected Context mContext;
  protected int xOq;
  
  public SnsAdInteractionLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnsAdInteractionLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private SnsAdInteractionLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(310227);
    this.Qgx = new ArrayList();
    this.Qgy = 0;
    this.Qgz = false;
    this.QgD = true;
    this.QgE = new IListener(f.hfK) {};
    this.PRJ = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(310220);
        paramAnonymousMessage = SnsAdInteractionLabelView.this;
        paramAnonymousMessage.Qgy += 1;
        if (SnsAdInteractionLabelView.this.Qgv.getVisibility() == 0)
        {
          SnsAdInteractionLabelView.a(SnsAdInteractionLabelView.this, SnsAdInteractionLabelView.this.Qgv);
          SnsAdInteractionLabelView.a(SnsAdInteractionLabelView.this, SnsAdInteractionLabelView.this.Qgw);
        }
        for (;;)
        {
          if (!SnsAdInteractionLabelView.this.Qgz) {
            SnsAdInteractionLabelView.a(SnsAdInteractionLabelView.this).sendEmptyMessageDelayed(1, 2300L);
          }
          AppMethodBeat.o(310220);
          return;
          SnsAdInteractionLabelView.a(SnsAdInteractionLabelView.this, SnsAdInteractionLabelView.this.Qgv);
          SnsAdInteractionLabelView.a(SnsAdInteractionLabelView.this, SnsAdInteractionLabelView.this.Qgw);
        }
      }
    };
    setOrientation(0);
    setGravity(16);
    this.mContext = paramContext;
    inflate(paramContext, b.g.sns_ad_interaction_label_view, this);
    this.Qgt = ((ImageView)findViewById(b.f.color_bg));
    this.Qgu = ((ImageView)findViewById(b.f.shake_icon));
    this.fO = ((TextView)findViewById(b.f.title));
    this.Qgv = ((TextView)findViewById(b.f.anim_txt1));
    this.Qgw = ((TextView)findViewById(b.f.anim_txt2));
    this.Qgw.setVisibility(4);
    this.QgC = new b(this.Qgu);
    this.Qgu.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(310231);
        int i = SnsAdInteractionLabelView.this.Qgu.getWidth();
        int j = SnsAdInteractionLabelView.this.Qgu.getHeight();
        if ((i > 0) && (j > 0))
        {
          SnsAdInteractionLabelView.this.QgC.cKI();
          SnsAdInteractionLabelView.this.Qgu.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        AppMethodBeat.o(310231);
        return true;
      }
    });
    AppMethodBeat.o(310227);
  }
  
  private void cKI()
  {
    AppMethodBeat.i(310243);
    Log.i("SnsAdInteractionLabelView", "--startAnim--");
    this.PRJ.removeCallbacksAndMessages(null);
    if (!this.QgD) {
      this.QgC.cKI();
    }
    this.QgD = false;
    if (this.Qgx.size() == 0)
    {
      this.Qgv.setText("");
      this.Qgw.setText("");
      this.Qgz = true;
      AppMethodBeat.o(310243);
      return;
    }
    if (this.Qgx.size() == 1)
    {
      eow();
      this.Qgv.setText((CharSequence)this.Qgx.get(0));
      this.Qgw.setText("");
      this.Qgz = true;
      AppMethodBeat.o(310243);
      return;
    }
    this.Qgz = false;
    this.Qgy = 0;
    eow();
    this.Qgv.setText((CharSequence)this.Qgx.get(0));
    this.Qgw.setText("");
    this.PRJ.sendEmptyMessageDelayed(1, 1800L);
    AppMethodBeat.o(310243);
  }
  
  private void dxz()
  {
    AppMethodBeat.i(310255);
    Log.i("SnsAdInteractionLabelView", "stopAnim");
    this.Qgz = true;
    this.PRJ.removeCallbacksAndMessages(null);
    this.QgC.dxz();
    AppMethodBeat.o(310255);
  }
  
  private void eow()
  {
    AppMethodBeat.i(310248);
    try
    {
      if (this.QgB != null) {
        this.QgB.end();
      }
      if (this.QgA != null) {
        this.QgA.end();
      }
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    this.Qgv.setVisibility(0);
    this.Qgw.setVisibility(4);
    this.Qgv.setAlpha(1.0F);
    this.Qgw.setAlpha(1.0F);
    this.Qgv.setTranslationY(0.0F);
    this.Qgw.setTranslationY(0.0F);
    AppMethodBeat.o(310248);
  }
  
  private void setEventListenerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(310236);
    Log.i("SnsAdInteractionLabelView", "setEventListenerEnabled:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean) {}
    try
    {
      this.QgE.alive();
      AppMethodBeat.o(310236);
      return;
    }
    finally
    {
      Log.e("SnsAdInteractionLabelView", "setEventListenerEnabled, exp=" + localObject.toString());
      AppMethodBeat.o(310236);
    }
    this.QgE.dead();
    AppMethodBeat.o(310236);
    return;
  }
  
  public final void a(a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(310307);
    Log.i("SnsAdInteractionLabelView", "initData, info=" + parama.hashCode() + ", snsId=" + t.uA(paramLong) + ", curSnsId=" + t.uA(this.PZu) + ", source=" + paramInt);
    this.xOq = paramInt;
    if ((this.PZu != 0L) && (this.PZu == paramLong))
    {
      Log.w("SnsAdInteractionLabelView", "initData, same snsId");
      AppMethodBeat.o(310307);
      return;
    }
    this.PZu = paramLong;
    this.fO.setText(parama.title);
    if (!TextUtils.isEmpty(parama.Qgm)) {}
    try
    {
      paramInt = Color.parseColor(parama.Qgm);
      this.fO.setTextColor(paramInt);
      Drawable localDrawable = this.Qgt.getBackground();
      if ((localDrawable instanceof GradientDrawable)) {
        ((GradientDrawable)localDrawable).setColor(paramInt);
      }
      this.Qgx.clear();
      this.Qgx.addAll(parama.Qgn);
      cKI();
      AppMethodBeat.o(310307);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("SnsAdInteractionLabelView", "initData exp=" + localObject.toString());
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(310285);
    super.onAttachedToWindow();
    Log.i("SnsAdInteractionLabelView", "onAttachedToWindow");
    if (this.xOq != 0) {
      cKI();
    }
    setEventListenerEnabled(true);
    AppMethodBeat.o(310285);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310292);
    super.onDetachedFromWindow();
    Log.i("SnsAdInteractionLabelView", "onDetachedFromWindow");
    this.PZu = 0L;
    dxz();
    setEventListenerEnabled(false);
    AppMethodBeat.o(310292);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(310297);
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("SnsAdInteractionLabelView", "onStartTemporaryDetach");
      this.PZu = 0L;
      dxz();
      setEventListenerEnabled(false);
    }
    AppMethodBeat.o(310297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.interactionlabel.SnsAdInteractionLabelView
 * JD-Core Version:    0.7.0.1
 */