package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acz.b;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.Iterator;
import java.util.List;

public final class q
{
  public static Dialog a(Context paramContext, acz.b paramb)
  {
    AppMethodBeat.i(301270);
    paramContext = a(paramContext, paramb.title, paramb.igN, paramb.igO, paramb.igH, paramb.igI, paramb.igJ, paramb.igM, paramb.igL, paramb.igK);
    AppMethodBeat.o(301270);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, ECardInfo paramECardInfo, int paramInt)
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
    if (!Util.isNullOrNil(paramECardInfo.igN))
    {
      localTextView2.setText(paramECardInfo.igN);
      localTextView2.setVisibility(0);
      i = paramECardInfo.VET.length();
      int j = (paramECardInfo.VET + paramECardInfo.VEU).length();
      localObject3 = new SpannableString(paramECardInfo.VET + paramECardInfo.VEU);
      ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(a.c.wallet_offline_link_color)), i, j, 33);
      if (Util.isNullOrNil((CharSequence)localObject3)) {
        break label537;
      }
      ((TextView)localObject2).setText((CharSequence)localObject3);
      ((TextView)localObject2).setOnClickListener(new q.6(paramECardInfo, paramContext, paramInt));
      label286:
      localObject2 = new com.tencent.mm.plugin.crashfix.b.a(paramContext, a.j.mmalertdialog);
      ((Dialog)localObject2).setContentView((View)localObject1);
      ((Dialog)localObject2).setTitle(null);
      ((Dialog)localObject2).setOnCancelListener(new q.7((Dialog)localObject2));
      localImageView.setOnClickListener(new q.8((Dialog)localObject2));
      localButton.setOnClickListener(new q.9(paramECardInfo, paramContext, (Dialog)localObject2));
      if (paramECardInfo.VEK != 1) {
        break label568;
      }
      localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(70964);
          if (!paramAnonymousBoolean)
          {
            q.this.setEnabled(false);
            q.this.setClickable(false);
            AppMethodBeat.o(70964);
            return;
          }
          q.this.setEnabled(true);
          q.this.setClickable(true);
          AppMethodBeat.o(70964);
        }
      });
      if (paramECardInfo.VEL != 1) {
        break label547;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramInt = paramECardInfo.VEM.length();
      i = (paramECardInfo.VEM + paramECardInfo.VEN).length();
      localObject1 = new SpannableString(paramECardInfo.VEM + paramECardInfo.VEN);
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(a.c.wallet_offline_link_color)), paramInt, i, 33);
      localTextView1.setText((CharSequence)localObject1);
      localTextView1.setOnClickListener(new q.2(paramECardInfo, paramContext));
      ((Dialog)localObject2).show();
      k.a(paramContext, (Dialog)localObject2);
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
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, List<String> paramList, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
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
    localMMNeat7extView.aZ(paramString1);
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
      localTextView1.setOnClickListener(new q.1(paramString6, paramContext));
      paramString1 = new com.tencent.mm.plugin.crashfix.b.a(paramContext, a.j.mmalertdialog);
      paramString1.setContentView(localView);
      paramString1.setTitle(null);
      paramString1.setOnCancelListener(new q.3(paramString1));
      localImageView.setOnClickListener(new q.4(paramString1));
      localButton.setOnClickListener(new q.5(paramString7, paramContext, paramString1));
      paramString1.show();
      paramContext = paramString1.getWindow();
      paramInt = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16);
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
  
  public static void kK(Context paramContext)
  {
    AppMethodBeat.i(301273);
    e.a locala = new e.a(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.wallet_switch_wallet_dialog, null, false);
    ImageView localImageView = (ImageView)paramContext.findViewById(a.f.wswd_iv);
    TextView localTextView = (TextView)paramContext.findViewById(a.f.wswd_tv);
    localImageView.setImageResource(a.e.wallet_switch_wallet_logo);
    localTextView.setText(a.i.mall_multi_wallet_tip);
    locala.ND(true);
    locala.NC(false);
    locala.md(paramContext);
    locala.aEK(a.i.wallet_switch_wallet_dialog_title);
    locala.aER(a.i.welcome_i_know);
    locala.jHH().show();
    AppMethodBeat.o(301273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q
 * JD-Core Version:    0.7.0.1
 */