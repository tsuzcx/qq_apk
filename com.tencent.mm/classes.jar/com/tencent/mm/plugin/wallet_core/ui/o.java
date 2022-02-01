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
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.yq.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.f;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class o
{
  public static Dialog a(Context paramContext, yq.b paramb)
  {
    AppMethodBeat.i(190226);
    paramContext = a(paramContext, paramb.title, paramb.subtitle, paramb.dOt, paramb.dOn, paramb.dOo, paramb.dOp, paramb.dOs, paramb.dOr, paramb.dOq);
    AppMethodBeat.o(190226);
    return paramContext;
  }
  
  public static Dialog a(final Context paramContext, ECardInfo paramECardInfo, final int paramInt)
  {
    AppMethodBeat.i(70966);
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131495967, null);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131298370);
    int i = BackwardSupportUtil.b.h(paramContext, 50.0F);
    bu.n(localImageView, i, i, i, i);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131302000);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131301996);
    Button localButton = (Button)((View)localObject1).findViewById(2131306217);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131301991);
    CheckBox localCheckBox = (CheckBox)((View)localObject1).findViewById(2131298255);
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131298261);
    ((TextView)localObject3).setText(paramECardInfo.title);
    if (!bu.isNullOrNil(paramECardInfo.subtitle))
    {
      localTextView2.setText(paramECardInfo.subtitle);
      localTextView2.setVisibility(0);
      i = paramECardInfo.DnH.length();
      int j = (paramECardInfo.DnH + paramECardInfo.DnI).length();
      localObject3 = new SpannableString(paramECardInfo.DnH + paramECardInfo.DnI);
      ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131101130)), i, j, 33);
      if (bu.ah((CharSequence)localObject3)) {
        break label526;
      }
      ((TextView)localObject2).setText((CharSequence)localObject3);
      ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70960);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          paramAnonymousView = new Intent();
          localObject = this.DxP.DnG;
          ae.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", v.aAC());
          paramAnonymousView.putExtra("pay_channel", 1);
          f.an(paramContext, paramAnonymousView);
          if (paramInt == 0) {
            g.yxI.f(16500, new Object[] { Integer.valueOf(4) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70960);
            return;
            g.yxI.f(16500, new Object[] { Integer.valueOf(6) });
          }
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
          ae.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
          if ((this.zvQ != null) && (this.zvQ.isShowing())) {
            this.zvQ.dismiss();
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
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((this.zvQ != null) && (this.zvQ.isShowing())) {
            this.zvQ.dismiss();
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
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.WalletIdCardTip", "go to: %s", new Object[] { Integer.valueOf(this.DxP.DnD) });
          if (this.DxP.DnD == 1) {
            f.p(paramContext, this.DxP.dOm, false);
          }
          for (;;)
          {
            if ((this.zvQ != null) && (this.zvQ.isShowing())) {
              this.zvQ.dismiss();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70963);
            return;
            paramAnonymousView = new oc();
            paramAnonymousView.dCZ.aWN = new WeakReference(paramContext);
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
          }
        }
      });
      if (paramECardInfo.Dny != 1) {
        break label557;
      }
      localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(70964);
          if (!paramAnonymousBoolean)
          {
            this.DxR.setEnabled(false);
            this.DxR.setClickable(false);
            AppMethodBeat.o(70964);
            return;
          }
          this.DxR.setEnabled(true);
          this.DxR.setClickable(true);
          AppMethodBeat.o(70964);
        }
      });
      if (paramECardInfo.Dnz != 1) {
        break label536;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramInt = paramECardInfo.DnA.length();
      i = (paramECardInfo.DnA + paramECardInfo.DnB).length();
      localObject1 = new SpannableString(paramECardInfo.DnA + paramECardInfo.DnB);
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131101130)), paramInt, i, 33);
      localTextView1.setText((CharSequence)localObject1);
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70956);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          paramAnonymousView = new Intent();
          localObject = this.DxP.DnC;
          ae.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", v.aAC());
          paramAnonymousView.putExtra("pay_channel", 1);
          f.an(paramContext, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70956);
        }
      });
      ((Dialog)localObject2).show();
      h.a(paramContext, (Dialog)localObject2);
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
    int i = BackwardSupportUtil.b.h(paramContext, 15.0F);
    bu.n(localImageView, i, i, i, i);
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
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          paramAnonymousView = new Intent();
          localObject = this.DxO;
          ae.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", v.aAC());
          paramAnonymousView.putExtra("pay_channel", 1);
          f.an(paramContext, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
          ae.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
          if ((this.zvQ != null) && (this.zvQ.isShowing())) {
            this.zvQ.dismiss();
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
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((this.zvQ != null) && (this.zvQ.isShowing())) {
            this.zvQ.dismiss();
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
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          paramAnonymousView = new Intent();
          localObject = this.DxQ;
          ae.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", v.aAC());
          paramAnonymousView.putExtra("pay_channel", 1);
          f.an(paramContext, paramAnonymousView);
          if ((paramString1 != null) && (paramString1.isShowing())) {
            paramString1.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70959);
        }
      });
      paramString1.show();
      paramContext = paramString1.getWindow();
      paramInt = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 16);
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
  
  public static void gR(Context paramContext)
  {
    AppMethodBeat.i(190227);
    d.a locala = new d.a(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(2131496035, null, false);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131307100);
    TextView localTextView = (TextView)paramContext.findViewById(2131307101);
    localImageView.setImageResource(2131234716);
    localTextView.setText(2131761095);
    locala.zg(true);
    locala.zf(false);
    locala.hd(paramContext);
    locala.afN(2131765891);
    locala.afU(2131766205);
    locala.fQv().show();
    AppMethodBeat.o(190227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o
 * JD-Core Version:    0.7.0.1
 */