package com.tencent.mm.plugin.offline.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint.FontMetrics;
import android.os.Build.VERSION;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.r.a;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.model.c.a;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import java.util.Iterator;
import java.util.List;

public class OfflineAlertView
  extends LinearLayout
{
  public int MzP;
  boolean MzQ;
  private a MzR;
  CountDownTimer MzS;
  private View contentView;
  ViewGroup pzj;
  m vIA;
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66351);
    this.MzP = 0;
    this.contentView = null;
    this.pzj = null;
    this.MzQ = true;
    this.MzR = null;
    init();
    AppMethodBeat.o(66351);
  }
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66352);
    this.MzP = 0;
    this.contentView = null;
    this.pzj = null;
    this.MzQ = true;
    this.MzR = null;
    init();
    AppMethodBeat.o(66352);
  }
  
  private static r.a a(r paramr, String paramString)
  {
    AppMethodBeat.i(269186);
    paramr = paramr.VGs.iterator();
    while (paramr.hasNext())
    {
      r.a locala = (r.a)paramr.next();
      if (locala.language.equals(paramString))
      {
        AppMethodBeat.o(269186);
        return locala;
      }
    }
    AppMethodBeat.o(269186);
    return null;
  }
  
  private void init()
  {
    AppMethodBeat.i(66353);
    this.contentView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_alert, this);
    this.pzj = ((ViewGroup)this.contentView.findViewById(a.f.offline_alert_root));
    this.pzj.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    AppMethodBeat.o(66353);
  }
  
  final void a(final View paramView, final View.OnClickListener paramOnClickListener, int paramInt)
  {
    AppMethodBeat.i(66357);
    this.MzP = paramInt;
    setVisibility(0);
    this.pzj.removeAllViews();
    Object localObject1 = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_unopened_layout, this.pzj, false);
    if (paramInt == 6) {
      ((TextView)((View)localObject1).findViewById(a.f.alert_title)).setText(a.i.offline_need_open_again_text);
    }
    for (;;)
    {
      Object localObject2 = (ViewGroup)((View)localObject1).findViewById(a.f.safe_pay_layout);
      if (localObject2 != null)
      {
        localTextView = (TextView)((View)localObject1).findViewById(a.f.safe_pay_tip);
        localObject3 = (ImageView)((View)localObject1).findViewById(a.f.safe_pay_icon);
        localObject4 = (ImageView)((View)localObject1).findViewById(a.f.safe_pay_arrow);
        localTextView.setMaxWidth(a.ms(getContext()) - a.br(getContext(), a.d.Edge_3A) * 2 - a.br(getContext(), a.d.Edge_2A) * 2 - a.br(getContext(), a.d.Edge_2A) - a.br(getContext(), a.d.Edge_A) - a.br(getContext(), a.d.Edge_0_5_A));
        ((ViewGroup)localObject2).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66349);
            if (localTextView.getLineCount() > 1)
            {
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a.br(OfflineAlertView.this.getContext(), a.d.Edge_2A), a.br(OfflineAlertView.this.getContext(), a.d.Edge_2A));
              int i = a.fromDPToPix(OfflineAlertView.this.getContext(), 2);
              localLayoutParams.gravity = 48;
              localLayoutParams.topMargin = i;
              this.uRM.setLayoutParams(localLayoutParams);
              localLayoutParams = new LinearLayout.LayoutParams(a.br(OfflineAlertView.this.getContext(), a.d.Edge_A), a.br(OfflineAlertView.this.getContext(), a.d.Edge_2A));
              localLayoutParams.gravity = 48;
              localLayoutParams.topMargin = i;
              this.MAj.setLayoutParams(localLayoutParams);
            }
            AppMethodBeat.o(66349);
          }
        });
        if (Build.VERSION.SDK_INT >= 23) {
          ((ViewGroup)localObject2).setForeground(getResources().getDrawable(a.e.offline_safe_layout_bg));
        }
        ((ViewGroup)localObject2).setOnClickListener(new k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(269140);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("wallet_lock_jsapi_scene", 2);
            c.b(paramView.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramAnonymousView);
            AppMethodBeat.o(269140);
          }
        });
        i.bG((View)localObject2, a.br(getContext(), a.d.Edge_1_5_A));
      }
      this.pzj.addView((View)localObject1);
      localObject2 = (CheckBox)((View)localObject1).findViewById(a.f.open_contract_cb);
      final TextView localTextView = (TextView)((View)localObject1).findViewById(a.f.open_contract_tv);
      Object localObject3 = (Button)this.contentView.findViewById(a.f.i_know_btn);
      localObject1 = (ViewGroup)((View)localObject1).findViewById(a.f.open_contract_layout);
      ((ViewGroup)localObject1).setVisibility(0);
      if (com.tencent.mm.ce.b.iRp()) {
        ((CheckBox)localObject2).setBackgroundResource(a.e.offline_contract_checkbox_bg_for_care);
      }
      i.bG((View)localObject2, 50);
      ((CheckBox)localObject2).setChecked(false);
      Object localObject4 = new SpannableStringBuilder();
      String str = getContext().getString(a.i.offline_open_contract_text1);
      ((SpannableStringBuilder)localObject4).append(str);
      ((SpannableStringBuilder)localObject4).append(getContext().getString(a.i.offline_open_contract_text2));
      ((SpannableStringBuilder)localObject4).setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(7, new s.a()
      {
        public final void eS(View paramAnonymousView)
        {
          AppMethodBeat.i(269208);
          i.p(OfflineAlertView.this.getContext(), "http://weixin.qq.com/cgi-bin/readtemplate?t=weixin_small_pay", false);
          AppMethodBeat.o(269208);
        }
      }), str.length(), ((SpannableStringBuilder)localObject4).length(), 18);
      localTextView.setText((CharSequence)localObject4);
      localTextView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(getContext()));
      localTextView.setClickable(true);
      localTextView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(269209);
          if (localTextView.getLineCount() > 1)
          {
            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.MzV.getLayoutParams();
            if (localLayoutParams != null)
            {
              Paint.FontMetrics localFontMetrics = localTextView.getPaint().getFontMetrics();
              int i = (int)(localTextView.getLineHeight() + 15 - (localFontMetrics.bottom - localFontMetrics.top)) / 2;
              localLayoutParams.gravity = 48;
              localLayoutParams.topMargin = i;
              this.MzV.setLayoutParams(localLayoutParams);
            }
          }
          AppMethodBeat.o(269209);
        }
      });
      ((Button)localObject3).setSelected(false);
      ((Button)localObject3).setOnClickListener(new k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269211);
          if (this.MzV.isChecked())
          {
            paramOnClickListener.onClick(paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.OAn.b(22805, new Object[] { Integer.valueOf(2) });
            AppMethodBeat.o(269211);
            return;
          }
          int i = OfflineAlertView.this.getResources().getDimensionPixelOffset(a.d.Edge_A);
          paramAnonymousView = ObjectAnimator.ofFloat(this.MzX, "translationX", new float[] { 0.0F, -i, i, -i, 0.0F }).setDuration(300L);
          paramAnonymousView.setInterpolator(new LinearInterpolator());
          paramAnonymousView.start();
          com.tencent.mm.plugin.report.service.h.OAn.b(22805, new Object[] { Integer.valueOf(1) });
          this.MzY.announceForAccessibility(OfflineAlertView.this.getContext().getString(a.i.wallet_contract_unchecked_when_click_open_btn_accessibility));
          AppMethodBeat.o(269211);
        }
      });
      this.MzQ = false;
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174393);
          Object localObject1 = (LinearLayout)OfflineAlertView.this.findViewById(a.f.content_root);
          if (localObject1 == null)
          {
            AppMethodBeat.o(174393);
            return;
          }
          Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(((LinearLayout)localObject1).getHeight()) });
          Object localObject2 = (FrameLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
          if (((LinearLayout)localObject1).getHeight() > paramView.getHeight())
          {
            Log.w("MicroMsg.OfflineAlertView", "don't modify alert height");
            OfflineAlertView.this.requestLayout();
          }
          for (;;)
          {
            if (OfflineAlertView.a(OfflineAlertView.this) != null) {
              OfflineAlertView.a(OfflineAlertView.this).onShow();
            }
            AppMethodBeat.o(174393);
            return;
            if (((LinearLayout)localObject1).getHeight() > 0)
            {
              ((FrameLayout.LayoutParams)localObject2).height = paramView.getHeight();
              ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              localObject2 = OfflineAlertView.this.findViewById(a.f.view_space_1);
              localObject1 = OfflineAlertView.this.findViewById(a.f.view_space_2);
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
              localLayoutParams.weight = 67.0F;
              ((View)localObject2).setLayoutParams(localLayoutParams);
              localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
              ((LinearLayout.LayoutParams)localObject2).weight = 56.0F;
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
        }
      });
      AppMethodBeat.o(66357);
      return;
      if (((paramInt == 3) || (paramInt == 1)) && (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))) {
        ((TextView)((View)localObject1).findViewById(a.f.alert_title)).setText(a.i.offline_unopened_pay_desc_gdpr_tips);
      }
    }
  }
  
  public final void a(final View paramView, final r paramr)
  {
    AppMethodBeat.i(269240);
    this.MzP = 8;
    setVisibility(0);
    this.MzQ = false;
    this.pzj.removeAllViews();
    Object localObject = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_installment_overdue_layout, this.pzj, false);
    this.pzj.addView((View)localObject);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(a.f.main_title_tv);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(a.f.sub_title_tv);
    Button localButton = (Button)((View)localObject).findViewById(a.f.i_know_btn);
    localObject = (WeImageView)((View)localObject).findViewById(a.f.icon_tip_iv);
    ((WeImageView)localObject).setImageResource(a.h.icons_outlined_info);
    ((WeImageView)localObject).setIconColor(getResources().getColor(a.c.wallet_offline_first_icon));
    localObject = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    if ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_HK")) || (((String)localObject).equals("zh_TW"))) {}
    for (localObject = a(paramr, (String)localObject);; localObject = a(paramr, "en"))
    {
      if (localObject != null)
      {
        localTextView1.setText(((r.a)localObject).VGn);
        localTextView2.setText(((r.a)localObject).VGo);
        localButton.setText(((r.a)localObject).VGt);
      }
      localButton.setTextColor(getResources().getColor(a.c.color_btn_text_selector));
      localButton.setBackgroundResource(a.e.btn_solid_green);
      localButton.setOnClickListener(new k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269180);
          if (paramr.wuj == 2) {
            i.bC(OfflineAlertView.this.getContext(), paramr.url);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(20258, new Object[] { Integer.valueOf(2) });
            AppMethodBeat.o(269180);
            return;
            if (paramr.wuj == 3) {
              i.y(paramr.VEH, paramr.VEI, 0, 1000);
            }
          }
        }
      });
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(269185);
          Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.b(OfflineAlertView.this).getLayoutParams();
          if (paramView.getHeight() > 0)
          {
            localLayoutParams.height = paramView.getHeight();
            OfflineAlertView.b(OfflineAlertView.this).setLayoutParams(localLayoutParams);
          }
          if (OfflineAlertView.a(OfflineAlertView.this) != null) {
            OfflineAlertView.a(OfflineAlertView.this).onShow();
          }
          AppMethodBeat.o(269185);
        }
      });
      AppMethodBeat.o(269240);
      return;
    }
  }
  
  public final void a(View paramView, anq paramanq, final View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(269247);
    Log.i("MicroMsg.OfflineAlertView", "showEnableTokenAlert");
    this.MzP = 9;
    this.MzQ = false;
    setVisibility(0);
    this.pzj.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_unopened_layout, this.pzj, false);
    this.pzj.addView(localView);
    Object localObject = localView.findViewById(a.f.open_contract_layout);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (WeImageView)localView.findViewById(a.f.icon_tip);
    TextView localTextView = (TextView)localView.findViewById(a.f.alert_title);
    Button localButton = (Button)localView.findViewById(a.f.i_know_btn);
    ((WeImageView)localObject).setImageResource(a.h.pay_safe);
    if (!Util.isNullOrNil(paramanq.text)) {
      localTextView.setText(paramanq.text);
    }
    if (!Util.isNullOrNil(paramanq.Zvo)) {
      localButton.setText(paramanq.Zvo);
    }
    ((ViewGroup)localView.findViewById(a.f.safe_pay_layout)).setVisibility(8);
    localButton.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(269184);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(269184);
      }
    });
    paramView.post(new OfflineAlertView..ExternalSyntheticLambda0(this, paramView));
    AppMethodBeat.o(269247);
  }
  
  public final void a(final View paramView, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(66354);
    this.MzP = 2;
    setVisibility(0);
    this.pzj.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_nosupport_tip, null);
    this.pzj.addView(localView);
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66343);
        OfflineAlertView.a(OfflineAlertView.this, paramView, paramRunnable1, paramRunnable2);
        AppMethodBeat.o(66343);
      }
    });
    AppMethodBeat.o(66354);
  }
  
  public final boolean afe(int paramInt)
  {
    AppMethodBeat.i(66360);
    if (isShowing())
    {
      if (paramInt == this.MzP)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if (paramInt == 1)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 2) && ((this.MzP == 3) || (this.MzP == 4) || (this.MzP == 5)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 5) && (this.MzP == 4))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if (paramInt == 6)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if (paramInt == 7)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 8) && ((this.MzP == 5) || (this.MzP == 4) || (this.MzP == 2)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if (paramInt == 3)
      {
        if (this.MzP == 1)
        {
          AppMethodBeat.o(66360);
          return false;
        }
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 9) && ((this.MzP == 4) || (this.MzP == 5) || (this.MzP == 2)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      AppMethodBeat.o(66360);
      return false;
    }
    AppMethodBeat.o(66360);
    return true;
  }
  
  public final void b(View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(66356);
    a(paramView, paramOnClickListener, 6);
    AppMethodBeat.o(66356);
  }
  
  public final void c(final View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(66358);
    this.MzP = 5;
    setVisibility(0);
    this.MzQ = false;
    this.pzj.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_unopened_layout, null);
    this.pzj.addView(localView);
    ((TextView)localView.findViewById(a.f.alert_title)).setText(a.i.offline_empty_code_text);
    Button localButton = (Button)localView.findViewById(a.f.i_know_btn);
    localButton.setText(a.i.offline_empty_code_btn_text);
    localButton.setOnClickListener(paramOnClickListener);
    paramOnClickListener = (ViewGroup)localView.findViewById(a.f.safe_pay_layout);
    if (paramOnClickListener != null) {
      paramOnClickListener.setVisibility(8);
    }
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269205);
        Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.b(OfflineAlertView.this).getLayoutParams();
        if (paramView.getHeight() > 0)
        {
          localLayoutParams.height = paramView.getHeight();
          OfflineAlertView.b(OfflineAlertView.this).setLayoutParams(localLayoutParams);
          OfflineAlertView.b(OfflineAlertView.this).invalidate();
        }
        if (OfflineAlertView.a(OfflineAlertView.this) != null) {
          OfflineAlertView.a(OfflineAlertView.this).onShow();
        }
        AppMethodBeat.o(269205);
      }
    });
    AppMethodBeat.o(66358);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(66361);
    if (this.pzj != null) {
      this.pzj.removeAllViews();
    }
    setVisibility(8);
    if (this.MzR != null) {
      this.MzR.bfj();
    }
    if (this.MzS != null) {
      this.MzS.cancel();
    }
    if (this.vIA != null) {
      p.b(this.vIA);
    }
    this.MzP = 0;
    this.MzQ = true;
    AppMethodBeat.o(66361);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(66359);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(66359);
      return true;
    }
    AppMethodBeat.o(66359);
    return false;
  }
  
  public final void iy(final View paramView)
  {
    AppMethodBeat.i(66355);
    setVisibility(0);
    this.pzj.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_first_guide, null);
    this.pzj.addView(localView);
    com.tencent.mm.plugin.report.service.h.OAn.b(13750, new Object[] { Integer.valueOf(1) });
    this.MzP = 4;
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269182);
        OfflineAlertView.a(OfflineAlertView.this, paramView);
        AppMethodBeat.o(269182);
      }
    });
    AppMethodBeat.o(66355);
  }
  
  public void setBlurDockerView(ViewGroup paramViewGroup) {}
  
  public void setDialogState(a parama)
  {
    this.MzR = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bfj();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView
 * JD-Core Version:    0.7.0.1
 */