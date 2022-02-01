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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.f;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMenuPreference
  extends Preference
{
  private LinearLayout HdX;
  private List<pw> HdY;
  private pu HdZ;
  private as contact;
  private long enterTime;
  private MMActivity iXq;
  private int lineHeight;
  private int mXL;
  private int state;
  private boolean vkO;
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27526);
    this.state = 0;
    this.vkO = false;
    this.lineHeight = 0;
    this.mXL = 0;
    this.enterTime = 0L;
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27526);
  }
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27527);
    this.state = 0;
    this.vkO = false;
    this.lineHeight = 0;
    this.mXL = 0;
    this.enterTime = 0L;
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27527);
  }
  
  private View a(pw parampw)
  {
    AppMethodBeat.i(27531);
    View localView = View.inflate(this.iXq, R.i.eeV, null);
    TextView localTextView = (TextView)localView.findViewById(R.h.dNy);
    ImageView localImageView = (ImageView)localView.findViewById(R.h.dNx);
    this.lineHeight = ((int)localTextView.getTextSize());
    ar(localImageView, (int)localTextView.getTextSize() * 3 / 4);
    switch (parampw.type)
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
        localTextView.setText(l.c(this.iXq, parampw.name));
        p.E(localView, 0.7F);
        AppMethodBeat.o(27531);
        return localView;
        localImageView.setVisibility(0);
        localImageView.setImageDrawable(au.o(this.iXq, R.k.biz_menu_show_sub_menu_icon, this.iXq.getResources().getColor(R.e.FG_2)));
        continue;
        localImageView.setVisibility(8);
      }
    }
    localImageView.setVisibility(0);
    if (ar.isDarkMode()) {}
    for (int i = R.g.biz_menu_show_miniprogram_icon_dark;; i = R.g.biz_menu_show_miniprogram_icon)
    {
      localImageView.setImageResource(i);
      break;
    }
  }
  
  private static void ar(View paramView, int paramInt)
  {
    AppMethodBeat.i(27532);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    localLayoutParams.width = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(27532);
  }
  
  private void bXG()
  {
    AppMethodBeat.i(27530);
    this.HdX.removeAllViews();
    int i = 0;
    while (i < this.HdY.size())
    {
      Object localObject2 = (pw)this.HdY.get(i);
      Object localObject1 = a((pw)localObject2);
      ((View)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27523);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (this.Hea == null)
          {
            Log.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27523);
            return;
          }
          c.c(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, 1100, NewBizInfoMenuPreference.b(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.c(NewBizInfoMenuPreference.this));
          Log.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", new Object[] { Integer.valueOf(this.Hea.type) });
          switch (this.Hea.type)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27523);
            return;
            NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this, this.Hea);
            continue;
            f.a(this.Hea, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.Hea.id), this.Hea.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.HfW, this.Hea.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.iU(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.Hea), -1), this.Hea.OOM);
            continue;
            f.b(this.Hea, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.Hea.id), this.Hea.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.HfW, this.Hea.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.iU(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.Hea), -1), this.Hea.value);
            continue;
            f.c(this.Hea, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.Hea.id), this.Hea.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.HfW, this.Hea.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.iU(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.Hea), -1), this.Hea.value);
          }
        }
      });
      this.HdX.addView((View)localObject1);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -2;
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (i != this.HdY.size() - 1)
      {
        localObject1 = new ImageView(this.iXq);
        ((ImageView)localObject1).setBackgroundColor(this.iXq.getResources().getColor(R.e.FG_3));
        this.HdX.addView((View)localObject1);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.lineHeight;
        ((LinearLayout.LayoutParams)localObject2).width = Math.round(this.iXq.getResources().getDisplayMetrics().density * 0.5F);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i += 1;
    }
    AppMethodBeat.o(27530);
  }
  
  private void dFf()
  {
    AppMethodBeat.i(27534);
    if ((this.HdZ != null) && (this.HdZ.RRT != null))
    {
      this.state = 4;
      AppMethodBeat.o(27534);
      return;
    }
    if (this.HdZ != null)
    {
      if ((this.HdZ != null) && (this.HdY != null) && (this.HdY.size() <= 0))
      {
        this.state = 2;
        AppMethodBeat.o(27534);
        return;
      }
      if ((this.HdZ != null) && (this.HdY != null) && (this.HdY.size() > 0))
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
    if ((!this.vkO) || (this.HdX == null))
    {
      AppMethodBeat.o(27529);
      return;
    }
    if ((this.state != 1) && (this.state != 2) && (this.state == 3))
    {
      this.HdX.setVisibility(0);
      bXG();
      AppMethodBeat.o(27529);
      return;
    }
    this.HdX.setVisibility(8);
    AppMethodBeat.o(27529);
  }
  
  public final void a(pu parampu, as paramas, int paramInt, long paramLong)
  {
    AppMethodBeat.i(226093);
    if ((parampu == null) || (parampu.RYd == null))
    {
      AppMethodBeat.o(226093);
      return;
    }
    this.contact = paramas;
    this.HdZ = parampu;
    this.HdY = a.a(parampu.RYd);
    this.mXL = paramInt;
    this.enterTime = paramLong;
    dFf();
    initView();
    AppMethodBeat.o(226093);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27528);
    super.onBindView(paramView);
    this.HdX = ((LinearLayout)paramView.findViewById(R.h.dAM));
    this.vkO = true;
    initView();
    AppMethodBeat.o(27528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference
 * JD-Core Version:    0.7.0.1
 */