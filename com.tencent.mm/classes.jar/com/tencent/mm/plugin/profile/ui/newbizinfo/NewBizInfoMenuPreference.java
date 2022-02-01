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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMenuPreference
  extends Preference
{
  private LinearLayout BjB;
  private List<qa> BjC;
  private py BjD;
  private as contact;
  private long enterTime;
  private MMActivity gte;
  private int kgm;
  private int lineHeight;
  private boolean rFe;
  private int state;
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27526);
    this.state = 0;
    this.rFe = false;
    this.lineHeight = 0;
    this.kgm = 0;
    this.enterTime = 0L;
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27526);
  }
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27527);
    this.state = 0;
    this.rFe = false;
    this.lineHeight = 0;
    this.kgm = 0;
    this.enterTime = 0L;
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27527);
  }
  
  private View a(qa paramqa)
  {
    AppMethodBeat.i(27531);
    View localView = View.inflate(this.gte, 2131493724, null);
    TextView localTextView = (TextView)localView.findViewById(2131305294);
    ImageView localImageView = (ImageView)localView.findViewById(2131305293);
    this.lineHeight = ((int)localTextView.getTextSize());
    an(localImageView, (int)localTextView.getTextSize() * 3 / 4);
    switch (paramqa.type)
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
        localTextView.setText(l.c(this.gte, paramqa.name));
        o.hq(localView);
        AppMethodBeat.o(27531);
        return localView;
        localImageView.setVisibility(0);
        localImageView.setImageDrawable(ar.m(this.gte, 2131689780, this.gte.getResources().getColor(2131099749)));
        continue;
        localImageView.setVisibility(8);
      }
    }
    localImageView.setVisibility(0);
    if (ao.isDarkMode()) {}
    for (int i = 2131231262;; i = 2131231261)
    {
      localImageView.setImageResource(i);
      break;
    }
  }
  
  private static void an(View paramView, int paramInt)
  {
    AppMethodBeat.i(27532);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    localLayoutParams.width = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(27532);
  }
  
  private void dmp()
  {
    AppMethodBeat.i(27534);
    if ((this.BjD != null) && (this.BjD.KQV != null))
    {
      this.state = 4;
      AppMethodBeat.o(27534);
      return;
    }
    if (this.BjD != null)
    {
      if ((this.BjD != null) && (this.BjC != null) && (this.BjC.size() <= 0))
      {
        this.state = 2;
        AppMethodBeat.o(27534);
        return;
      }
      if ((this.BjD != null) && (this.BjC != null) && (this.BjC.size() > 0))
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
  
  private void eeh()
  {
    AppMethodBeat.i(27530);
    this.BjB.removeAllViews();
    int i = 0;
    while (i < this.BjC.size())
    {
      Object localObject2 = (qa)this.BjC.get(i);
      Object localObject1 = a((qa)localObject2);
      ((View)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27523);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (this.BjE == null)
          {
            Log.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27523);
            return;
          }
          c.c(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, 1100, NewBizInfoMenuPreference.b(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.c(NewBizInfoMenuPreference.this));
          Log.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", new Object[] { Integer.valueOf(this.BjE.type) });
          switch (this.BjE.type)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27523);
            return;
            NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this, this.BjE);
            continue;
            g.a(this.BjE, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.BjE.id), this.BjE.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, this.BjE.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.BjE), -1), this.BjE.HWM);
            continue;
            g.b(this.BjE, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.BjE.id), this.BjE.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, this.BjE.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.BjE), -1), this.BjE.value);
            continue;
            g.c(this.BjE, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.BjE.id), this.BjE.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, this.BjE.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.BjE), -1), this.BjE.value);
          }
        }
      });
      this.BjB.addView((View)localObject1);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -2;
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (i != this.BjC.size() - 1)
      {
        localObject1 = new ImageView(this.gte);
        ((ImageView)localObject1).setBackgroundColor(this.gte.getResources().getColor(2131099750));
        this.BjB.addView((View)localObject1);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.lineHeight;
        ((LinearLayout.LayoutParams)localObject2).width = Math.round(this.gte.getResources().getDisplayMetrics().density * 0.5F);
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
    if ((!this.rFe) || (this.BjB == null))
    {
      AppMethodBeat.o(27529);
      return;
    }
    if ((this.state != 1) && (this.state != 2) && (this.state == 3))
    {
      this.BjB.setVisibility(0);
      eeh();
      AppMethodBeat.o(27529);
      return;
    }
    this.BjB.setVisibility(8);
    AppMethodBeat.o(27529);
  }
  
  public final void a(py parampy, as paramas, int paramInt, long paramLong)
  {
    AppMethodBeat.i(231955);
    if ((parampy == null) || (parampy.KWP == null))
    {
      AppMethodBeat.o(231955);
      return;
    }
    this.contact = paramas;
    this.BjD = parampy;
    this.BjC = a.a(parampy.KWP);
    this.kgm = paramInt;
    this.enterTime = paramLong;
    dmp();
    initView();
    AppMethodBeat.o(231955);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27528);
    super.onBindView(paramView);
    this.BjB = ((LinearLayout)paramView.findViewById(2131299036));
    this.rFe = true;
    initView();
    AppMethodBeat.o(27528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference
 * JD-Core Version:    0.7.0.1
 */