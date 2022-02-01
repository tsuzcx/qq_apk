package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.g;
import java.util.Iterator;
import java.util.List;

public class OfflineAlertView
  extends LinearLayout
{
  public int GDA;
  boolean GDB;
  private a GDC;
  CountDownTimer GDD;
  private View contentView;
  ViewGroup mCC;
  i sCG;
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66351);
    this.GDA = 0;
    this.contentView = null;
    this.mCC = null;
    this.GDB = true;
    this.GDC = null;
    init();
    AppMethodBeat.o(66351);
  }
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66352);
    this.GDA = 0;
    this.contentView = null;
    this.mCC = null;
    this.GDB = true;
    this.GDC = null;
    init();
    AppMethodBeat.o(66352);
  }
  
  private static com.tencent.mm.plugin.wallet_core.model.r.a a(com.tencent.mm.plugin.wallet_core.model.r paramr, String paramString)
  {
    AppMethodBeat.i(201996);
    paramr = paramr.OQy.iterator();
    while (paramr.hasNext())
    {
      com.tencent.mm.plugin.wallet_core.model.r.a locala = (com.tencent.mm.plugin.wallet_core.model.r.a)paramr.next();
      if (locala.language.equals(paramString))
      {
        AppMethodBeat.o(201996);
        return locala;
      }
    }
    AppMethodBeat.o(201996);
    return null;
  }
  
  private void init()
  {
    AppMethodBeat.i(66353);
    this.contentView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_alert, this);
    this.mCC = ((ViewGroup)this.contentView.findViewById(a.f.offline_alert_root));
    this.mCC.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    AppMethodBeat.o(66353);
  }
  
  final void a(final View paramView, View.OnClickListener paramOnClickListener, int paramInt)
  {
    AppMethodBeat.i(66357);
    this.GDA = paramInt;
    setVisibility(0);
    this.mCC.removeAllViews();
    Object localObject2 = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_unopened_layout, null);
    if (paramInt == 6) {
      ((TextView)((View)localObject2).findViewById(a.f.alert_title)).setText(a.i.offline_need_open_again_text);
    }
    for (;;)
    {
      Object localObject1 = (ViewGroup)((View)localObject2).findViewById(a.f.safe_pay_layout);
      if (localObject1 != null)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          ((ViewGroup)localObject1).setForeground(getResources().getDrawable(a.e.offline_safe_layout_bg));
        }
        ((ViewGroup)localObject1).setOnClickListener(new OfflineAlertView.18(this, paramView));
      }
      this.mCC.addView((View)localObject2);
      localObject1 = (CheckBox)((View)localObject2).findViewById(a.f.open_contract_cb);
      TextView localTextView = (TextView)((View)localObject2).findViewById(a.f.open_contract_tv);
      Button localButton = (Button)this.contentView.findViewById(a.f.i_know_btn);
      localObject2 = (ViewGroup)((View)localObject2).findViewById(a.f.open_contract_layout);
      g.bi((View)localObject1, 50);
      ((CheckBox)localObject1).setChecked(false);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      String str = getContext().getString(a.i.offline_open_contract_text1);
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.append(getContext().getString(a.i.offline_open_contract_text2));
      localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.r(7, new com.tencent.mm.plugin.wallet_core.ui.r.a()
      {
        public final void ed(View paramAnonymousView)
        {
          AppMethodBeat.i(271078);
          g.p(OfflineAlertView.this.getContext(), "http://weixin.qq.com/cgi-bin/readtemplate?t=weixin_small_pay", false);
          AppMethodBeat.o(271078);
        }
      }), str.length(), localSpannableStringBuilder.length(), 18);
      localTextView.setText(localSpannableStringBuilder);
      localTextView.setOnTouchListener(new o(getContext()));
      localTextView.setClickable(true);
      localTextView.post(new OfflineAlertView.2(this, localTextView, (CheckBox)localObject1));
      localButton.setSelected(false);
      localButton.setOnClickListener(new OfflineAlertView.3(this, (CheckBox)localObject1, paramOnClickListener, (ViewGroup)localObject2));
      this.GDB = false;
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(270841);
          Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.a(OfflineAlertView.this).getLayoutParams();
          if (paramView.getHeight() > 0)
          {
            localLayoutParams.height = paramView.getHeight();
            OfflineAlertView.a(OfflineAlertView.this).setLayoutParams(localLayoutParams);
            OfflineAlertView.a(OfflineAlertView.this).invalidate();
          }
          if (OfflineAlertView.b(OfflineAlertView.this) != null) {
            OfflineAlertView.b(OfflineAlertView.this).onShow();
          }
          AppMethodBeat.o(270841);
        }
      });
      AppMethodBeat.o(66357);
      return;
      if (((paramInt == 3) || (paramInt == 1)) && (com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null)))) {
        ((TextView)((View)localObject2).findViewById(a.f.alert_title)).setText(a.i.offline_unopened_pay_desc_gdpr_tips);
      }
    }
  }
  
  public final void a(final View paramView, final com.tencent.mm.plugin.wallet_core.model.r paramr)
  {
    AppMethodBeat.i(201992);
    this.GDA = 8;
    setVisibility(0);
    this.GDB = false;
    this.mCC.removeAllViews();
    Object localObject = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_installment_overdue_layout, this.mCC, false);
    this.mCC.addView((View)localObject);
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
        localTextView1.setText(((com.tencent.mm.plugin.wallet_core.model.r.a)localObject).OQt);
        localTextView2.setText(((com.tencent.mm.plugin.wallet_core.model.r.a)localObject).OQu);
        localButton.setText(((com.tencent.mm.plugin.wallet_core.model.r.a)localObject).OQz);
      }
      localButton.setTextColor(getResources().getColor(a.c.color_btn_text_selector));
      localButton.setBackgroundResource(a.e.btn_solid_green);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(228913);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/OfflineAlertView$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (paramr.tpK == 2) {
            g.bA(OfflineAlertView.this.getContext(), paramr.url);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(20258, new Object[] { Integer.valueOf(2) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228913);
            return;
            if (paramr.tpK == 3) {
              g.v(paramr.OON, paramr.OOO, 0, 1000);
            }
          }
        }
      });
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186549);
          Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.a(OfflineAlertView.this).getLayoutParams();
          if (paramView.getHeight() > 0)
          {
            localLayoutParams.height = paramView.getHeight();
            OfflineAlertView.a(OfflineAlertView.this).setLayoutParams(localLayoutParams);
          }
          if (OfflineAlertView.b(OfflineAlertView.this) != null) {
            OfflineAlertView.b(OfflineAlertView.this).onShow();
          }
          AppMethodBeat.o(186549);
        }
      });
      AppMethodBeat.o(201992);
      return;
    }
  }
  
  public final void a(final View paramView, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(66354);
    this.GDA = 2;
    setVisibility(0);
    this.mCC.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_nosupport_tip, null);
    this.mCC.addView(localView);
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
  
  public final boolean aaL(int paramInt)
  {
    AppMethodBeat.i(66360);
    if (isShowing())
    {
      if (paramInt == this.GDA)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 2) && ((this.GDA == 3) || (this.GDA == 4) || (this.GDA == 2) || (this.GDA == 5)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 5) && (this.GDA == 4))
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
      if ((paramInt == 8) && ((this.GDA == 5) || (this.GDA == 4) || (this.GDA == 2)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if (paramInt == 3)
      {
        if (this.GDA == 1)
        {
          AppMethodBeat.o(66360);
          return false;
        }
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
    this.GDA = 5;
    setVisibility(0);
    this.GDB = false;
    this.mCC.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_unopened_layout, null);
    this.mCC.addView(localView);
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
        AppMethodBeat.i(174393);
        Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.a(OfflineAlertView.this).getLayoutParams();
        if (paramView.getHeight() > 0)
        {
          localLayoutParams.height = paramView.getHeight();
          OfflineAlertView.a(OfflineAlertView.this).setLayoutParams(localLayoutParams);
          OfflineAlertView.a(OfflineAlertView.this).invalidate();
        }
        if (OfflineAlertView.b(OfflineAlertView.this) != null) {
          OfflineAlertView.b(OfflineAlertView.this).onShow();
        }
        AppMethodBeat.o(174393);
      }
    });
    AppMethodBeat.o(66358);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(66361);
    if (this.mCC != null) {
      this.mCC.removeAllViews();
    }
    setVisibility(8);
    if (this.GDC != null) {
      this.GDC.onClose();
    }
    if (this.GDD != null) {
      this.GDD.cancel();
    }
    if (this.sCG != null) {
      l.b(this.sCG);
    }
    this.GDA = 0;
    this.GDB = true;
    AppMethodBeat.o(66361);
  }
  
  public final void fG(final View paramView)
  {
    AppMethodBeat.i(66355);
    setVisibility(0);
    this.mCC.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_first_guide, null);
    this.mCC.addView(localView);
    com.tencent.mm.plugin.report.service.h.IzE.a(13750, new Object[] { Integer.valueOf(1) });
    this.GDA = 4;
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204115);
        OfflineAlertView.a(OfflineAlertView.this, paramView);
        AppMethodBeat.o(204115);
      }
    });
    AppMethodBeat.o(66355);
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
  
  public void setBlurDockerView(ViewGroup paramViewGroup) {}
  
  public void setDialogState(a parama)
  {
    this.GDC = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClose();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView
 * JD-Core Version:    0.7.0.1
 */