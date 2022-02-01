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
import com.tencent.mm.g.a.ob;
import com.tencent.mm.g.a.yk.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class o
{
  public static Dialog a(Context paramContext, yk.b paramb)
  {
    AppMethodBeat.i(199346);
    paramContext = a(paramContext, paramb.title, paramb.subtitle, paramb.dNd, paramb.dMX, paramb.dMY, paramb.dMZ, paramb.dNc, paramb.dNb, paramb.dNa);
    AppMethodBeat.o(199346);
    return paramContext;
  }
  
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
      i = paramECardInfo.CWc.length();
      int j = (paramECardInfo.CWc + paramECardInfo.CWd).length();
      localObject3 = new SpannableString(paramECardInfo.CWc + paramECardInfo.CWd);
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
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          paramAnonymousView = new Intent();
          localObject = this.Dgl.CWb;
          ad.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", u.aAm());
          paramAnonymousView.putExtra("pay_channel", 1);
          e.an(paramContext, paramAnonymousView);
          if (paramInt == 0) {
            g.yhR.f(16500, new Object[] { Integer.valueOf(4) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70960);
            return;
            g.yhR.f(16500, new Object[] { Integer.valueOf(6) });
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
          ad.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
          if ((this.zfb != null) && (this.zfb.isShowing())) {
            this.zfb.dismiss();
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((this.zfb != null) && (this.zfb.isShowing())) {
            this.zfb.dismiss();
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.WalletIdCardTip", "go to: %s", new Object[] { Integer.valueOf(this.Dgl.CVY) });
          if (this.Dgl.CVY == 1) {
            e.o(paramContext, this.Dgl.dMW, false);
          }
          for (;;)
          {
            if ((this.zfb != null) && (this.zfb.isShowing())) {
              this.zfb.dismiss();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70963);
            return;
            paramAnonymousView = new ob();
            paramAnonymousView.dBU.aWN = new WeakReference(paramContext);
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
          }
        }
      });
      if (paramECardInfo.CVS != 1) {
        break label557;
      }
      localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(70964);
          if (!paramAnonymousBoolean)
          {
            this.Dgn.setEnabled(false);
            this.Dgn.setClickable(false);
            AppMethodBeat.o(70964);
            return;
          }
          this.Dgn.setEnabled(true);
          this.Dgn.setClickable(true);
          AppMethodBeat.o(70964);
        }
      });
      if (paramECardInfo.CVT != 1) {
        break label536;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramInt = paramECardInfo.CVU.length();
      i = (paramECardInfo.CVU + paramECardInfo.CVW).length();
      localObject1 = new SpannableString(paramECardInfo.CVU + paramECardInfo.CVW);
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131101130)), paramInt, i, 33);
      localTextView1.setText((CharSequence)localObject1);
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70956);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          paramAnonymousView = new Intent();
          localObject = this.Dgl.CVX;
          ad.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", u.aAm());
          paramAnonymousView.putExtra("pay_channel", 1);
          e.an(paramContext, paramAnonymousView);
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
    int i = BackwardSupportUtil.b.g(paramContext, 15.0F);
    bt.n(localImageView, i, i, i, i);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)localView.findViewById(2131302000);
    TextView localTextView2 = (TextView)localView.findViewById(2131301998);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131301999);
    Button localButton = (Button)localView.findViewById(2131306217);
    TextView localTextView1 = (TextView)localView.findViewById(2131301991);
    localMMNeat7extView.getPaint().setFakeBoldText(true);
    localMMNeat7extView.ar(paramString1);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          paramAnonymousView = new Intent();
          localObject = this.Dgk;
          ad.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", u.aAm());
          paramAnonymousView.putExtra("pay_channel", 1);
          e.an(paramContext, paramAnonymousView);
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
          ad.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
          if ((this.zfb != null) && (this.zfb.isShowing())) {
            this.zfb.dismiss();
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((this.zfb != null) && (this.zfb.isShowing())) {
            this.zfb.dismiss();
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          paramAnonymousView = new Intent();
          localObject = this.Dgm;
          ad.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          paramAnonymousView.putExtra("geta8key_username", u.aAm());
          paramAnonymousView.putExtra("pay_channel", 1);
          e.an(paramContext, paramAnonymousView);
          if ((paramString1 != null) && (paramString1.isShowing())) {
            paramString1.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70959);
        }
      });
      paramString1.show();
      paramContext = paramString1.getWindow();
      paramInt = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 16);
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
  
  public static void gM(Context paramContext)
  {
    AppMethodBeat.i(199347);
    d.a locala = new d.a(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(2131496035, null, false);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131307100);
    TextView localTextView = (TextView)paramContext.findViewById(2131307101);
    localImageView.setImageResource(2131234716);
    localTextView.setText(2131761095);
    locala.yS(true);
    locala.yR(false);
    locala.gY(paramContext);
    locala.afe(2131765891);
    locala.afl(2131766205);
    locala.fMb().show();
    AppMethodBeat.o(199347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o
 * JD-Core Version:    0.7.0.1
 */