package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.h.a.tk.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.List;

public final class k
{
  public static Dialog a(Context paramContext, tk.b paramb)
  {
    Object localObject3 = paramb.title;
    String str3 = paramb.cdw;
    Object localObject4 = paramb.cdx;
    Object localObject2 = paramb.cdq;
    int i = paramb.cdr;
    String str1 = paramb.cds;
    String str2 = paramb.cdv;
    Object localObject1 = paramb.cdu;
    paramb = paramb.cdt;
    View localView = LayoutInflater.from(paramContext).inflate(a.g.wallet_id_card_tip, null);
    ImageView localImageView = (ImageView)localView.findViewById(a.f.close_icon);
    int j = BackwardSupportUtil.b.b(paramContext, 15.0F);
    bk.j(localImageView, j, j, j, j);
    TextView localTextView2 = (TextView)localView.findViewById(a.f.main_title);
    TextView localTextView3 = (TextView)localView.findViewById(a.f.main_tip);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.main_tip_wording);
    Button localButton = (Button)localView.findViewById(a.f.upload_btn);
    TextView localTextView1 = (TextView)localView.findViewById(a.f.main_protocol_wording);
    localTextView2.setText((CharSequence)localObject3);
    localTextView3.setText(str3);
    localLinearLayout.removeAllViews();
    localObject3 = ((List)localObject4).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str3 = (String)((Iterator)localObject3).next();
      localObject4 = LayoutInflater.from(paramContext).inflate(a.g.wallet_id_card_wordingtip, null);
      ((TextView)((View)localObject4).findViewById(a.f.wording_tip)).setText(str3);
      localLinearLayout.addView((View)localObject4);
    }
    localButton.setText((CharSequence)localObject2);
    if (i > 0)
    {
      i = str1.length();
      j = (str1 + str2).length();
      localObject2 = new SpannableString(str1 + str2);
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(a.c.wallet_offline_link_color)), i, j, 33);
      localTextView1.setText((CharSequence)localObject2);
    }
    for (;;)
    {
      localTextView1.setOnClickListener(new k.1((String)localObject1, paramContext));
      localObject1 = new Dialog(paramContext, a.j.mmalertdialog);
      ((Dialog)localObject1).setContentView(localView);
      ((Dialog)localObject1).setTitle(null);
      ((Dialog)localObject1).setOnCancelListener(new k.3((Dialog)localObject1));
      localImageView.setOnClickListener(new k.4((Dialog)localObject1));
      localButton.setOnClickListener(new k.5(paramb, paramContext, (Dialog)localObject1));
      ((Dialog)localObject1).show();
      return localObject1;
      localTextView1.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k
 * JD-Core Version:    0.7.0.1
 */