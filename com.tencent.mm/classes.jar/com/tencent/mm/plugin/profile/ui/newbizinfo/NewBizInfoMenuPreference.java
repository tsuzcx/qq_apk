package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMenuPreference
  extends Preference
{
  private af contact;
  private MMActivity imP;
  private int ima;
  private int lineHeight;
  private boolean paC;
  private int state;
  private LinearLayout uFJ;
  private List<np> uFK;
  private nn uFL;
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27526);
    this.state = 0;
    this.paC = false;
    this.lineHeight = 0;
    this.ima = 0;
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27526);
  }
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27527);
    this.state = 0;
    this.paC = false;
    this.lineHeight = 0;
    this.ima = 0;
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27527);
  }
  
  private View a(np paramnp)
  {
    AppMethodBeat.i(27531);
    View localView = View.inflate(this.imP, 2131493605, null);
    TextView localTextView = (TextView)localView.findViewById(2131302727);
    ImageView localImageView = (ImageView)localView.findViewById(2131302726);
    this.lineHeight = ((int)localTextView.getTextSize());
    aj(localImageView, (int)localTextView.getTextSize() * 3 / 4);
    switch (paramnp.type)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        localTextView.setText(k.c(this.imP, paramnp.name));
        o.gp(localView);
        AppMethodBeat.o(27531);
        return localView;
        localImageView.setVisibility(0);
        localImageView.setImageDrawable(am.i(this.imP, 2131689769, this.imP.getResources().getColor(2131099735)));
        continue;
        localImageView.setVisibility(8);
      }
    }
    localImageView.setVisibility(0);
    if (ai.Eq()) {}
    for (int i = 2131231205;; i = 2131231204)
    {
      localImageView.setImageResource(i);
      break;
    }
  }
  
  private static void aj(View paramView, int paramInt)
  {
    AppMethodBeat.i(27532);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    localLayoutParams.width = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(27532);
  }
  
  private void cKF()
  {
    AppMethodBeat.i(27530);
    this.uFJ.removeAllViews();
    int i = 0;
    while (i < this.uFK.size())
    {
      Object localObject2 = (np)this.uFK.get(i);
      Object localObject1 = a((np)localObject2);
      ((View)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27523);
          if (this.uFM == null)
          {
            ad.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
            AppMethodBeat.o(27523);
            return;
          }
          c.L(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, 1100, NewBizInfoMenuPreference.b(NewBizInfoMenuPreference.this));
          ad.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", new Object[] { Integer.valueOf(this.uFM.type) });
          switch (this.uFM.type)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(27523);
            return;
            NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this, this.uFM);
            AppMethodBeat.o(27523);
            return;
            g.a(this.uFM, NewBizInfoMenuPreference.c(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.uFM.id), this.uFM.key, b.uHS, this.uFM.name, b.gE(NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this).indexOf(this.uFM), -1), this.uFM.Adf);
            AppMethodBeat.o(27523);
            return;
            g.b(this.uFM, NewBizInfoMenuPreference.c(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.uFM.id), this.uFM.key, b.uHS, this.uFM.name, b.gE(NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this).indexOf(this.uFM), -1), this.uFM.value);
          }
        }
      });
      this.uFJ.addView((View)localObject1);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -2;
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (i != this.uFK.size() - 1)
      {
        localObject1 = new ImageView(this.imP);
        ((ImageView)localObject1).setBackgroundColor(ao.aD(this.imP, 2130968587));
        this.uFJ.addView((View)localObject1);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.lineHeight;
        ((LinearLayout.LayoutParams)localObject2).width = Math.round(this.imP.getResources().getDisplayMetrics().density * 0.5F);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i += 1;
    }
    AppMethodBeat.o(27530);
  }
  
  private void dcW()
  {
    AppMethodBeat.i(27534);
    if ((this.uFL != null) && (this.uFL.CGS != null))
    {
      this.state = 4;
      AppMethodBeat.o(27534);
      return;
    }
    if (this.uFL != null)
    {
      if ((this.uFL != null) && (this.uFK != null) && (this.uFK.size() <= 0))
      {
        this.state = 2;
        AppMethodBeat.o(27534);
        return;
      }
      if ((this.uFL != null) && (this.uFK != null) && (this.uFK.size() > 0))
      {
        this.state = 3;
        AppMethodBeat.o(27534);
      }
    }
    else
    {
      this.state = 0;
    }
    AppMethodBeat.o(27534);
  }
  
  private void initView()
  {
    AppMethodBeat.i(27529);
    if ((!this.paC) || (this.uFJ == null))
    {
      AppMethodBeat.o(27529);
      return;
    }
    if ((this.state != 1) && (this.state != 2) && (this.state == 3))
    {
      this.uFJ.setVisibility(0);
      cKF();
      AppMethodBeat.o(27529);
      return;
    }
    this.uFJ.setVisibility(8);
    AppMethodBeat.o(27529);
  }
  
  public final void a(nn paramnn, af paramaf, int paramInt)
  {
    AppMethodBeat.i(27533);
    if ((paramnn == null) || (paramnn.CLj == null))
    {
      AppMethodBeat.o(27533);
      return;
    }
    this.contact = paramaf;
    this.uFL = paramnn;
    this.uFK = a.a(paramnn.CLj);
    this.ima = paramInt;
    dcW();
    initView();
    AppMethodBeat.o(27533);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27528);
    super.onBindView(paramView);
    this.uFJ = ((LinearLayout)paramView.findViewById(2131298599));
    this.paC = true;
    initView();
    AppMethodBeat.o(27528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference
 * JD-Core Version:    0.7.0.1
 */