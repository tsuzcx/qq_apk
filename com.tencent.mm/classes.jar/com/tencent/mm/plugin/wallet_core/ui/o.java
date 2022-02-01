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
import com.tencent.mm.g.a.nk;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class o
{
  public static Dialog a(final Context paramContext, ECardInfo paramECardInfo, final int paramInt)
  {
    AppMethodBeat.i(70966);
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131495967, null);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131298370);
    int i = BackwardSupportUtil.b.g(paramContext, 50.0F);
    bt.n(localImageView, i, i, i, i);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131302000);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131301996);
    Button localButton = (Button)((View)localObject1).findViewById(2131306217);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131301991);
    CheckBox localCheckBox = (CheckBox)((View)localObject1).findViewById(2131298255);
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131298261);
    ((TextView)localObject3).setText(paramECardInfo.title);
    if (!bt.isNullOrNil(paramECardInfo.subtitle))
    {
      localTextView2.setText(paramECardInfo.subtitle);
      localTextView2.setVisibility(0);
      i = paramECardInfo.Ads.length();
      int j = (paramECardInfo.Ads + paramECardInfo.Adt).length();
      localObject3 = new SpannableString(paramECardInfo.Ads + paramECardInfo.Adt);
      ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131101130)), i, j, 33);
      if (bt.ai((CharSequence)localObject3)) {
        break label526;
      }
      ((TextView)localObject2).setText((CharSequence)localObject3);
      ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70960);
          paramAnonymousView = new Intent();
          String str = this.Anz.Adr;
          ad.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { str });
          paramAnonymousView.putExtra("rawUrl", str);
          paramAnonymousView.putExtra("geta8key_username", u.aqG());
          paramAnonymousView.putExtra("pay_channel", 1);
          e.X(paramContext, paramAnonymousView);
          if (paramInt == 0)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(16500, new Object[] { Integer.valueOf(4) });
            AppMethodBeat.o(70960);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(16500, new Object[] { Integer.valueOf(6) });
          AppMethodBeat.o(70960);
        }
      });
      label277:
      localObject2 = new com.tencent.mm.plugin.crashfix.b.a(paramContext, 2131821723);
      ((Dialog)localObject2).setContentView((View)localObject1);
      ((Dialog)localObject2).setTitle(null);
      ((Dialog)localObject2).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(70961);
          ad.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
          if ((this.wCM != null) && (this.wCM.isShowing())) {
            this.wCM.dismiss();
          }
          AppMethodBeat.o(70961);
        }
      });
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70962);
          if ((this.wCM != null) && (this.wCM.isShowing())) {
            this.wCM.dismiss();
          }
          AppMethodBeat.o(70962);
        }
      });
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70963);
          ad.i("MicroMsg.WalletIdCardTip", "go to: %s", new Object[] { Integer.valueOf(this.Anz.Ado) });
          if (this.Anz.Ado == 1) {
            e.p(paramContext, this.Anz.dCX, false);
          }
          for (;;)
          {
            if ((this.wCM != null) && (this.wCM.isShowing())) {
              this.wCM.dismiss();
            }
            AppMethodBeat.o(70963);
            return;
            paramAnonymousView = new nk();
            paramAnonymousView.dsx.aLG = new WeakReference(paramContext);
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
          }
        }
      });
      if (paramECardInfo.Adj != 1) {
        break label557;
      }
      localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(70964);
          if (!paramAnonymousBoolean)
          {
            this.AnB.setEnabled(false);
            this.AnB.setClickable(false);
            AppMethodBeat.o(70964);
            return;
          }
          this.AnB.setEnabled(true);
          this.AnB.setClickable(true);
          AppMethodBeat.o(70964);
        }
      });
      if (paramECardInfo.Adk != 1) {
        break label536;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramInt = paramECardInfo.Adl.length();
      i = (paramECardInfo.Adl + paramECardInfo.Adm).length();
      localObject1 = new SpannableString(paramECardInfo.Adl + paramECardInfo.Adm);
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131101130)), paramInt, i, 33);
      localTextView1.setText((CharSequence)localObject1);
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70956);
          paramAnonymousView = new Intent();
          String str = this.Anz.Adn;
          ad.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { str });
          paramAnonymousView.putExtra("rawUrl", str);
          paramAnonymousView.putExtra("geta8key_username", u.aqG());
          paramAnonymousView.putExtra("pay_channel", 1);
          e.X(paramContext, paramAnonymousView);
          AppMethodBeat.o(70956);
        }
      });
      ((Dialog)localObject2).show();
      com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject2);
      AppMethodBeat.o(70966);
      return localObject2;
      localTextView2.setVisibility(8);
      break;
      label526:
      ((TextView)localObject2).setVisibility(8);
      break label277;
      label536:
      localCheckBox.setChecked(false);
      localButton.setEnabled(false);
      localButton.setClickable(false);
      continue;
      label557:
      localCheckBox.setVisibility(8);
    }
  }
  
  public static Dialog a(final Context paramContext, final String paramString1, String paramString2, List<String> paramList, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(70965);
    View localView = LayoutInflater.from(paramContext).inflate(2131495965, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131298370);
    int i = BackwardSupportUtil.b.g(paramContext, 15.0F);
    bt.n(localImageView, i, i, i, i);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)localView.findViewById(2131302000);
    TextView localTextView2 = (TextView)localView.findViewById(2131301998);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131301999);
    Button localButton = (Button)localView.findViewById(2131306217);
    TextView localTextView1 = (TextView)localView.findViewById(2131301991);
    localMMNeat7extView.getPaint().setFakeBoldText(true);
    localMMNeat7extView.aq(paramString1);
    localTextView2.setText(paramString2);
    localLinearLayout.removeAllViews();
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramList = LayoutInflater.from(paramContext).inflate(2131495966, null);
      ((TextView)paramList.findViewById(2131307007)).setText(paramString2);
      localLinearLayout.addView(paramList);
    }
    localButton.setText(paramString3);
    if (paramInt > 0)
    {
      paramInt = paramString4.length();
      i = (paramString4 + paramString5).length();
      paramString1 = new SpannableString(paramString4 + paramString5);
      paramString1.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131101130)), paramInt, i, 33);
      localTextView1.setText(paramString1);
    }
    for (;;)
    {
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70955);
          paramAnonymousView = new Intent();
          String str = this.Any;
          ad.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { str });
          paramAnonymousView.putExtra("rawUrl", str);
          paramAnonymousView.putExtra("geta8key_username", u.aqG());
          paramAnonymousView.putExtra("pay_channel", 1);
          e.X(paramContext, paramAnonymousView);
          AppMethodBeat.o(70955);
        }
      });
      paramString1 = new com.tencent.mm.plugin.crashfix.b.a(paramContext, 2131821723);
      paramString1.setContentView(localView);
      paramString1.setTitle(null);
      paramString1.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(70957);
          ad.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
          if ((this.wCM != null) && (this.wCM.isShowing())) {
            this.wCM.dismiss();
          }
          AppMethodBeat.o(70957);
        }
      });
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70958);
          if ((this.wCM != null) && (this.wCM.isShowing())) {
            this.wCM.dismiss();
          }
          AppMethodBeat.o(70958);
        }
      });
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70959);
          paramAnonymousView = new Intent();
          String str = this.AnA;
          ad.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { str });
          paramAnonymousView.putExtra("rawUrl", str);
          paramAnonymousView.putExtra("geta8key_username", u.aqG());
          paramAnonymousView.putExtra("pay_channel", 1);
          e.X(paramContext, paramAnonymousView);
          if ((paramString1 != null) && (paramString1.isShowing())) {
            paramString1.dismiss();
          }
          AppMethodBeat.o(70959);
        }
      });
      paramString1.show();
      paramContext = paramString1.getWindow();
      paramInt = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 16);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o
 * JD-Core Version:    0.7.0.1
 */