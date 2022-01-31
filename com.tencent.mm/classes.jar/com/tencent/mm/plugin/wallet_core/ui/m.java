package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.crashfix.b.a;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.List;

public final class m
{
  public static Dialog a(Context paramContext, ECardInfo paramECardInfo, int paramInt)
  {
    AppMethodBeat.i(47402);
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2130971191, null);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131822762);
    int i = BackwardSupportUtil.b.b(paramContext, 50.0F);
    bo.n(localImageView, i, i, i, i);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131828932);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131828933);
    Button localButton = (Button)((View)localObject1).findViewById(2131829145);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131829146);
    CheckBox localCheckBox = (CheckBox)((View)localObject1).findViewById(2131820950);
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131829149);
    ((TextView)localObject3).setText(paramECardInfo.title);
    if (!bo.isNullOrNil(paramECardInfo.subtitle))
    {
      localTextView2.setText(paramECardInfo.subtitle);
      localTextView2.setVisibility(0);
      i = paramECardInfo.uhl.length();
      int j = (paramECardInfo.uhl + paramECardInfo.uhm).length();
      localObject3 = new SpannableString(paramECardInfo.uhl + paramECardInfo.uhm);
      ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131690662)), i, j, 33);
      if (bo.aa((CharSequence)localObject3)) {
        break label526;
      }
      ((TextView)localObject2).setText((CharSequence)localObject3);
      ((TextView)localObject2).setOnClickListener(new m.6(paramECardInfo, paramContext, paramInt));
      label277:
      localObject2 = new a(paramContext, 2131493881);
      ((Dialog)localObject2).setContentView((View)localObject1);
      ((Dialog)localObject2).setTitle(null);
      ((Dialog)localObject2).setOnCancelListener(new m.7((Dialog)localObject2));
      localImageView.setOnClickListener(new m.8((Dialog)localObject2));
      localButton.setOnClickListener(new m.9(paramECardInfo, paramContext, (Dialog)localObject2));
      if (paramECardInfo.uhc != 1) {
        break label557;
      }
      localCheckBox.setOnCheckedChangeListener(new m.10(localButton));
      if (paramECardInfo.uhd != 1) {
        break label536;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramInt = paramECardInfo.uhe.length();
      i = (paramECardInfo.uhe + paramECardInfo.uhf).length();
      localObject1 = new SpannableString(paramECardInfo.uhe + paramECardInfo.uhf);
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131690662)), paramInt, i, 33);
      localTextView1.setText((CharSequence)localObject1);
      localTextView1.setOnClickListener(new m.2(paramECardInfo, paramContext));
      ((Dialog)localObject2).show();
      h.a(paramContext, (Dialog)localObject2);
      AppMethodBeat.o(47402);
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
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, List<String> paramList, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(142508);
    View localView = LayoutInflater.from(paramContext).inflate(2130971189, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131822762);
    int i = BackwardSupportUtil.b.b(paramContext, 15.0F);
    bo.n(localImageView, i, i, i, i);
    TextView localTextView2 = (TextView)localView.findViewById(2131828932);
    TextView localTextView3 = (TextView)localView.findViewById(2131829143);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131829144);
    Button localButton = (Button)localView.findViewById(2131829145);
    TextView localTextView1 = (TextView)localView.findViewById(2131829146);
    localTextView2.setText(paramString1);
    localTextView3.setText(paramString2);
    localLinearLayout.removeAllViews();
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramList = LayoutInflater.from(paramContext).inflate(2130971190, null);
      ((TextView)paramList.findViewById(2131829147)).setText(paramString2);
      localLinearLayout.addView(paramList);
    }
    localButton.setText(paramString3);
    if (paramInt > 0)
    {
      paramInt = paramString4.length();
      i = (paramString4 + paramString5).length();
      paramString1 = new SpannableString(paramString4 + paramString5);
      paramString1.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131690662)), paramInt, i, 33);
      localTextView1.setText(paramString1);
    }
    for (;;)
    {
      localTextView1.setOnClickListener(new m.1(paramString6, paramContext));
      paramString1 = new a(paramContext, 2131493881);
      paramString1.setContentView(localView);
      paramString1.setTitle(null);
      paramString1.setOnCancelListener(new m.3(paramString1));
      localImageView.setOnClickListener(new m.4(paramString1));
      localButton.setOnClickListener(new m.5(paramString7, paramContext, paramString1));
      paramString1.show();
      AppMethodBeat.o(142508);
      return paramString1;
      localTextView1.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m
 * JD-Core Version:    0.7.0.1
 */