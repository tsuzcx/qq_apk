package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.abc.b;
import com.tencent.mm.f.a.pr;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class p
{
  public static Dialog a(Context paramContext, abc.b paramb)
  {
    AppMethodBeat.i(269011);
    paramContext = a(paramContext, paramb.title, paramb.subtitle, paramb.gaE, paramb.gay, paramb.gaz, paramb.gaA, paramb.gaD, paramb.gaC, paramb.gaB);
    AppMethodBeat.o(269011);
    return paramContext;
  }
  
  public static Dialog a(final Context paramContext, ECardInfo paramECardInfo, final int paramInt)
  {
    AppMethodBeat.i(70966);
    Object localObject1 = LayoutInflater.from(paramContext).inflate(a.g.wallet_inc_balance_amt_dialog, null);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(a.f.close_icon);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 50.0F);
    Util.expandViewTouchArea(localImageView, i, i, i, i);
    Object localObject3 = (TextView)((View)localObject1).findViewById(a.f.main_title);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(a.f.main_subtitle);
    Button localButton = (Button)((View)localObject1).findViewById(a.f.upload_btn);
    Object localObject2 = (TextView)((View)localObject1).findViewById(a.f.main_protocol_wording);
    CheckBox localCheckBox = (CheckBox)((View)localObject1).findViewById(a.f.checkbox);
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(a.f.checkbox_protocal_tv);
    ((TextView)localObject3).setText(paramECardInfo.title);
    if (!Util.isNullOrNil(paramECardInfo.subtitle))
    {
      localTextView2.setText(paramECardInfo.subtitle);
      localTextView2.setVisibility(0);
      i = paramECardInfo.OOZ.length();
      int j = (paramECardInfo.OOZ + paramECardInfo.OPa).length();
      localObject3 = new SpannableString(paramECardInfo.OOZ + paramECardInfo.OPa);
      ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(a.c.wallet_offline_link_color)), i, j, 33);
      if (Util.isNullOrNil((CharSequence)localObject3)) {
        break label537;
      }
      ((TextView)localObject2).setText((CharSequence)localObject3);
      ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70960);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = new Intent();
          localObject = this.OZg.OOY;
          Log.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", z.bcZ());
          paramAnonymousView.putExtra("pay_channel", 1);
          g.aJ(paramContext, paramAnonymousView);
          if (paramInt == 0) {
            com.tencent.mm.plugin.report.service.h.IzE.a(16500, new Object[] { Integer.valueOf(4) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70960);
            return;
            com.tencent.mm.plugin.report.service.h.IzE.a(16500, new Object[] { Integer.valueOf(6) });
          }
        }
      });
      label286:
      localObject2 = new com.tencent.mm.plugin.crashfix.b.a(paramContext, a.j.mmalertdialog);
      ((Dialog)localObject2).setContentView((View)localObject1);
      ((Dialog)localObject2).setTitle(null);
      ((Dialog)localObject2).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(70961);
          Log.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
          if ((this.JSZ != null) && (this.JSZ.isShowing())) {
            this.JSZ.dismiss();
          }
          AppMethodBeat.o(70961);
        }
      });
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70962);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((this.JSZ != null) && (this.JSZ.isShowing())) {
            this.JSZ.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70962);
        }
      });
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70963);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.WalletIdCardTip", "go to: %s", new Object[] { Integer.valueOf(this.OZg.OOV) });
          if (this.OZg.OOV == 1) {
            g.p(paramContext, this.OZg.gax, false);
          }
          for (;;)
          {
            if ((this.JSZ != null) && (this.JSZ.isShowing())) {
              this.JSZ.dismiss();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70963);
            return;
            paramAnonymousView = new pr();
            paramAnonymousView.fOq.aFX = new WeakReference(paramContext);
            EventCenter.instance.publish(paramAnonymousView);
          }
        }
      });
      if (paramECardInfo.OOQ != 1) {
        break label568;
      }
      localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(70964);
          if (!paramAnonymousBoolean)
          {
            this.OZi.setEnabled(false);
            this.OZi.setClickable(false);
            AppMethodBeat.o(70964);
            return;
          }
          this.OZi.setEnabled(true);
          this.OZi.setClickable(true);
          AppMethodBeat.o(70964);
        }
      });
      if (paramECardInfo.OOR != 1) {
        break label547;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramInt = paramECardInfo.OOS.length();
      i = (paramECardInfo.OOS + paramECardInfo.OOT).length();
      localObject1 = new SpannableString(paramECardInfo.OOS + paramECardInfo.OOT);
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(a.c.wallet_offline_link_color)), paramInt, i, 33);
      localTextView1.setText((CharSequence)localObject1);
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70956);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = new Intent();
          localObject = this.OZg.OOU;
          Log.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", z.bcZ());
          paramAnonymousView.putExtra("pay_channel", 1);
          g.aJ(paramContext, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70956);
        }
      });
      ((Dialog)localObject2).show();
      com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject2);
      AppMethodBeat.o(70966);
      return localObject2;
      localTextView2.setVisibility(8);
      break;
      label537:
      ((TextView)localObject2).setVisibility(8);
      break label286;
      label547:
      localCheckBox.setChecked(false);
      localButton.setEnabled(false);
      localButton.setClickable(false);
      continue;
      label568:
      localCheckBox.setVisibility(8);
    }
  }
  
  public static Dialog a(final Context paramContext, final String paramString1, String paramString2, List<String> paramList, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(70965);
    View localView = LayoutInflater.from(paramContext).inflate(a.g.wallet_id_card_tip, null);
    ImageView localImageView = (ImageView)localView.findViewById(a.f.close_icon);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 15.0F);
    Util.expandViewTouchArea(localImageView, i, i, i, i);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)localView.findViewById(a.f.main_title);
    TextView localTextView2 = (TextView)localView.findViewById(a.f.main_tip);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.main_tip_wording);
    Button localButton = (Button)localView.findViewById(a.f.upload_btn);
    TextView localTextView1 = (TextView)localView.findViewById(a.f.main_protocol_wording);
    localMMNeat7extView.getPaint().setFakeBoldText(true);
    localMMNeat7extView.aL(paramString1);
    localTextView2.setText(paramString2);
    localLinearLayout.removeAllViews();
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramList = LayoutInflater.from(paramContext).inflate(a.g.wallet_id_card_wordingtip, null);
      ((TextView)paramList.findViewById(a.f.wording_tip)).setText(paramString2);
      localLinearLayout.addView(paramList);
    }
    localButton.setText(paramString3);
    if (paramInt > 0)
    {
      paramInt = paramString4.length();
      i = (paramString4 + paramString5).length();
      paramString1 = new SpannableString(paramString4 + paramString5);
      paramString1.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(a.c.wallet_offline_link_color)), paramInt, i, 33);
      localTextView1.setText(paramString1);
    }
    for (;;)
    {
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70955);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = new Intent();
          localObject = this.OZf;
          Log.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", z.bcZ());
          paramAnonymousView.putExtra("pay_channel", 1);
          g.aJ(paramContext, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70955);
        }
      });
      paramString1 = new com.tencent.mm.plugin.crashfix.b.a(paramContext, a.j.mmalertdialog);
      paramString1.setContentView(localView);
      paramString1.setTitle(null);
      paramString1.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(70957);
          Log.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
          if ((this.JSZ != null) && (this.JSZ.isShowing())) {
            this.JSZ.dismiss();
          }
          AppMethodBeat.o(70957);
        }
      });
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70958);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((this.JSZ != null) && (this.JSZ.isShowing())) {
            this.JSZ.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70958);
        }
      });
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70959);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = new Intent();
          localObject = this.OZh;
          Log.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", z.bcZ());
          paramAnonymousView.putExtra("pay_channel", 1);
          g.aJ(paramContext, paramAnonymousView);
          if ((paramString1 != null) && (paramString1.isShowing())) {
            paramString1.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70959);
        }
      });
      paramString1.show();
      paramContext = paramString1.getWindow();
      paramInt = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 16);
      paramContext.getDecorView().setPadding(paramInt, 0, paramInt, 0);
      paramString2 = paramContext.getAttributes();
      paramString2.width = -1;
      paramString2.height = -2;
      paramContext.setAttributes(paramString2);
      AppMethodBeat.o(70965);
      return paramString1;
      localTextView1.setText("");
    }
  }
  
  public static void iS(Context paramContext)
  {
    AppMethodBeat.i(269013);
    d.a locala = new d.a(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.wallet_switch_wallet_dialog, null, false);
    ImageView localImageView = (ImageView)paramContext.findViewById(a.f.wswd_iv);
    TextView localTextView = (TextView)paramContext.findViewById(a.f.wswd_tv);
    localImageView.setImageResource(a.e.wallet_switch_wallet_logo);
    localTextView.setText(a.i.mall_multi_wallet_tip);
    locala.HH(true);
    locala.HG(false);
    locala.iI(paramContext);
    locala.ayc(a.i.wallet_switch_wallet_dialog_title);
    locala.ayj(a.i.welcome_i_know);
    locala.icu().show();
    AppMethodBeat.o(269013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.p
 * JD-Core Version:    0.7.0.1
 */