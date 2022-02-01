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
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
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
  private am contact;
  private long enterTime;
  private MMActivity fLP;
  private int jfq;
  private int lineHeight;
  private boolean qhs;
  private int state;
  private LinearLayout wVJ;
  private List<pb> wVK;
  private oz wVL;
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27526);
    this.state = 0;
    this.qhs = false;
    this.lineHeight = 0;
    this.jfq = 0;
    this.enterTime = 0L;
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27526);
  }
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27527);
    this.state = 0;
    this.qhs = false;
    this.lineHeight = 0;
    this.jfq = 0;
    this.enterTime = 0L;
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27527);
  }
  
  private View a(pb parampb)
  {
    AppMethodBeat.i(27531);
    View localView = View.inflate(this.fLP, 2131493605, null);
    TextView localTextView = (TextView)localView.findViewById(2131302727);
    ImageView localImageView = (ImageView)localView.findViewById(2131302726);
    this.lineHeight = ((int)localTextView.getTextSize());
    al(localImageView, (int)localTextView.getTextSize() * 3 / 4);
    switch (parampb.type)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        localTextView.setText(k.c(this.fLP, parampb.name));
        o.gU(localView);
        AppMethodBeat.o(27531);
        return localView;
        localImageView.setVisibility(0);
        localImageView.setImageDrawable(ao.k(this.fLP, 2131689769, this.fLP.getResources().getColor(2131099735)));
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
  
  private void dBh()
  {
    AppMethodBeat.i(27534);
    if ((this.wVL != null) && (this.wVL.FEO != null))
    {
      this.state = 4;
      AppMethodBeat.o(27534);
      return;
    }
    if (this.wVL != null)
    {
      if ((this.wVL != null) && (this.wVK != null) && (this.wVK.size() <= 0))
      {
        this.state = 2;
        AppMethodBeat.o(27534);
        return;
      }
      if ((this.wVL != null) && (this.wVK != null) && (this.wVK.size() > 0))
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
  
  private void dhw()
  {
    AppMethodBeat.i(27530);
    this.wVJ.removeAllViews();
    int i = 0;
    while (i < this.wVK.size())
    {
      Object localObject2 = (pb)this.wVK.get(i);
      Object localObject1 = a((pb)localObject2);
      ((View)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27523);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (this.wVM == null)
          {
            ad.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27523);
            return;
          }
          c.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, 1100, NewBizInfoMenuPreference.b(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.c(NewBizInfoMenuPreference.this));
          ad.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", new Object[] { Integer.valueOf(this.wVM.type) });
          switch (this.wVM.type)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27523);
            return;
            NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this, this.wVM);
            continue;
            g.a(this.wVM, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.wVM.id), this.wVM.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.wXT, this.wVM.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hd(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.wVM), -1), this.wVM.CVO);
            continue;
            g.b(this.wVM, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.wVM.id), this.wVM.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.wXT, this.wVM.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hd(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.wVM), -1), this.wVM.value);
          }
        }
      });
      this.wVJ.addView((View)localObject1);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -2;
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (i != this.wVK.size() - 1)
      {
        localObject1 = new ImageView(this.fLP);
        ((ImageView)localObject1).setBackgroundColor(this.fLP.getResources().getColor(2131099736));
        this.wVJ.addView((View)localObject1);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.lineHeight;
        ((LinearLayout.LayoutParams)localObject2).width = Math.round(this.fLP.getResources().getDisplayMetrics().density * 0.5F);
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
    if ((!this.qhs) || (this.wVJ == null))
    {
      AppMethodBeat.o(27529);
      return;
    }
    if ((this.state != 1) && (this.state != 2) && (this.state == 3))
    {
      this.wVJ.setVisibility(0);
      dhw();
      AppMethodBeat.o(27529);
      return;
    }
    this.wVJ.setVisibility(8);
    AppMethodBeat.o(27529);
  }
  
  public final void a(oz paramoz, am paramam, int paramInt, long paramLong)
  {
    AppMethodBeat.i(193318);
    if ((paramoz == null) || (paramoz.FKk == null))
    {
      AppMethodBeat.o(193318);
      return;
    }
    this.contact = paramam;
    this.wVL = paramoz;
    this.wVK = a.a(paramoz.FKk);
    this.jfq = paramInt;
    this.enterTime = paramLong;
    dBh();
    initView();
    AppMethodBeat.o(193318);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27528);
    super.onBindView(paramView);
    this.wVJ = ((LinearLayout)paramView.findViewById(2131298599));
    this.qhs = true;
    initView();
    AppMethodBeat.o(27528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference
 * JD-Core Version:    0.7.0.1
 */