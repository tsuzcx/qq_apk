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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMenuPreference
  extends Preference
{
  private an contact;
  private long enterTime;
  private MMActivity fNT;
  private int jij;
  private int lineHeight;
  private boolean qnX;
  private int state;
  private LinearLayout xlA;
  private List<pd> xlB;
  private pb xlC;
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27526);
    this.state = 0;
    this.qnX = false;
    this.lineHeight = 0;
    this.jij = 0;
    this.enterTime = 0L;
    this.fNT = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(27526);
  }
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27527);
    this.state = 0;
    this.qnX = false;
    this.lineHeight = 0;
    this.jij = 0;
    this.enterTime = 0L;
    this.fNT = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(27527);
  }
  
  private View a(pd parampd)
  {
    AppMethodBeat.i(27531);
    View localView = View.inflate(this.fNT, 2131493605, null);
    TextView localTextView = (TextView)localView.findViewById(2131302727);
    ImageView localImageView = (ImageView)localView.findViewById(2131302726);
    this.lineHeight = ((int)localTextView.getTextSize());
    al(localImageView, (int)localTextView.getTextSize() * 3 / 4);
    switch (parampd.type)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
    case 0: 
    case 2: 
    case 6: 
      for (;;)
      {
        localTextView.setText(k.c(this.fNT, parampd.name));
        o.gZ(localView);
        AppMethodBeat.o(27531);
        return localView;
        localImageView.setVisibility(0);
        localImageView.setImageDrawable(ao.k(this.fNT, 2131689769, this.fNT.getResources().getColor(2131099735)));
        continue;
        localImageView.setVisibility(8);
      }
    }
    localImageView.setVisibility(0);
    if (al.isDarkMode()) {}
    for (int i = 2131231205;; i = 2131231204)
    {
      localImageView.setImageResource(i);
      break;
    }
  }
  
  private static void al(View paramView, int paramInt)
  {
    AppMethodBeat.i(27532);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    localLayoutParams.width = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(27532);
  }
  
  private void dEy()
  {
    AppMethodBeat.i(27534);
    if ((this.xlC != null) && (this.xlC.FXj != null))
    {
      this.state = 4;
      AppMethodBeat.o(27534);
      return;
    }
    if (this.xlC != null)
    {
      if ((this.xlC != null) && (this.xlB != null) && (this.xlB.size() <= 0))
      {
        this.state = 2;
        AppMethodBeat.o(27534);
        return;
      }
      if ((this.xlC != null) && (this.xlB != null) && (this.xlB.size() > 0))
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
  
  private void dkv()
  {
    AppMethodBeat.i(27530);
    this.xlA.removeAllViews();
    int i = 0;
    while (i < this.xlB.size())
    {
      Object localObject2 = (pd)this.xlB.get(i);
      Object localObject1 = a((pd)localObject2);
      ((View)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27523);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (this.xlD == null)
          {
            ae.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27523);
            return;
          }
          c.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, 1100, NewBizInfoMenuPreference.b(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.c(NewBizInfoMenuPreference.this));
          ae.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", new Object[] { Integer.valueOf(this.xlD.type) });
          switch (this.xlD.type)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27523);
            return;
            NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this, this.xlD);
            continue;
            g.a(this.xlD, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.xlD.id), this.xlD.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.xnK, this.xlD.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hf(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.xlD), -1), this.xlD.Dnu);
            continue;
            g.b(this.xlD, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.xlD.id), this.xlD.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.xnK, this.xlD.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hf(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.xlD), -1), this.xlD.value);
            continue;
            g.c(this.xlD, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.xlD.id), this.xlD.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.xnK, this.xlD.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hf(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.xlD), -1), this.xlD.value);
          }
        }
      });
      this.xlA.addView((View)localObject1);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -2;
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (i != this.xlB.size() - 1)
      {
        localObject1 = new ImageView(this.fNT);
        ((ImageView)localObject1).setBackgroundColor(this.fNT.getResources().getColor(2131099736));
        this.xlA.addView((View)localObject1);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.lineHeight;
        ((LinearLayout.LayoutParams)localObject2).width = Math.round(this.fNT.getResources().getDisplayMetrics().density * 0.5F);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i += 1;
    }
    AppMethodBeat.o(27530);
  }
  
  private void initView()
  {
    AppMethodBeat.i(27529);
    if ((!this.qnX) || (this.xlA == null))
    {
      AppMethodBeat.o(27529);
      return;
    }
    if ((this.state != 1) && (this.state != 2) && (this.state == 3))
    {
      this.xlA.setVisibility(0);
      dkv();
      AppMethodBeat.o(27529);
      return;
    }
    this.xlA.setVisibility(8);
    AppMethodBeat.o(27529);
  }
  
  public final void a(pb parampb, an paraman, int paramInt, long paramLong)
  {
    AppMethodBeat.i(186592);
    if ((parampb == null) || (parampb.GcJ == null))
    {
      AppMethodBeat.o(186592);
      return;
    }
    this.contact = paraman;
    this.xlC = parampb;
    this.xlB = a.a(parampb.GcJ);
    this.jij = paramInt;
    this.enterTime = paramLong;
    dEy();
    initView();
    AppMethodBeat.o(186592);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27528);
    super.onBindView(paramView);
    this.xlA = ((LinearLayout)paramView.findViewById(2131298599));
    this.qnX = true;
    initView();
    AppMethodBeat.o(27528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference
 * JD-Core Version:    0.7.0.1
 */