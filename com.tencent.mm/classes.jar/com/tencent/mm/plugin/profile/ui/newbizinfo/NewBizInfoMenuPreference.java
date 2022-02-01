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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.tools.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMenuPreference
  extends Preference
{
  private LinearLayout NbN;
  private List<rg> NbO;
  private au contact;
  private long enterTime;
  private int lineHeight;
  private MMActivity lzt;
  private int pUt;
  private int state;
  private boolean yxr;
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27526);
    this.state = 0;
    this.yxr = false;
    this.lineHeight = 0;
    this.pUt = 0;
    this.enterTime = 0L;
    this.lzt = ((MMActivity)paramContext);
    this.yxr = false;
    AppMethodBeat.o(27526);
  }
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27527);
    this.state = 0;
    this.yxr = false;
    this.lineHeight = 0;
    this.pUt = 0;
    this.enterTime = 0L;
    this.lzt = ((MMActivity)paramContext);
    this.yxr = false;
    AppMethodBeat.o(27527);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27528);
    super.onBindView(paramView);
    this.NbN = ((LinearLayout)paramView.findViewById(R.h.fBN));
    this.yxr = true;
    if ((!this.yxr) || (this.NbN == null))
    {
      AppMethodBeat.o(27528);
      return;
    }
    if ((this.state != 1) && (this.state != 2) && (this.state == 3))
    {
      this.NbN.setVisibility(0);
      this.NbN.removeAllViews();
      int i = 0;
      if (i < this.NbO.size())
      {
        Object localObject = (rg)this.NbO.get(i);
        paramView = View.inflate(this.lzt, R.i.ghO, null);
        TextView localTextView = (TextView)paramView.findViewById(R.h.fPt);
        ImageView localImageView = (ImageView)paramView.findViewById(R.h.fPs);
        this.lineHeight = ((int)localTextView.getTextSize());
        int j = (int)localTextView.getTextSize() * 3 / 4;
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        localLayoutParams.height = j;
        localLayoutParams.width = j;
        localImageView.setLayoutParams(localLayoutParams);
        switch (((rg)localObject).type)
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
            localTextView.setText(p.b(this.lzt, ((rg)localObject).name));
            o.F(paramView, 0.7F);
            paramView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(27523);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                if (this.NbP == null)
                {
                  Log.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(27523);
                  return;
                }
                c.a(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, 1100, NewBizInfoMenuPreference.b(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.c(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this).getIntent());
                Log.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", new Object[] { Integer.valueOf(this.NbP.type) });
                switch (this.NbP.type)
                {
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(27523);
                  return;
                  NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this, this.NbP);
                  continue;
                  com.tencent.mm.plugin.profile.ui.newbizinfo.b.b.a(this.NbP, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
                  com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.NbP.id), this.NbP.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.NcF, this.NbP.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.kA(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.NbP), -1), this.NbP.VEG);
                  continue;
                  com.tencent.mm.plugin.profile.ui.newbizinfo.b.b.b(this.NbP, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
                  com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.NbP.id), this.NbP.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.NcF, this.NbP.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.kA(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.NbP), -1), this.NbP.value);
                  continue;
                  com.tencent.mm.plugin.profile.ui.newbizinfo.b.b.c(this.NbP, NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
                  com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.NbP.id), this.NbP.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.NcF, this.NbP.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.kA(NewBizInfoMenuPreference.e(NewBizInfoMenuPreference.this).indexOf(this.NbP), -1), this.NbP.value);
                }
              }
            });
            this.NbN.addView(paramView);
            localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).height = -2;
            ((LinearLayout.LayoutParams)localObject).width = -1;
            ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
            ((LinearLayout.LayoutParams)localObject).gravity = 16;
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            if (i != this.NbO.size() - 1)
            {
              paramView = new ImageView(this.lzt);
              paramView.setBackgroundColor(this.lzt.getResources().getColor(R.e.FG_3));
              this.NbN.addView(paramView);
              localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
              ((LinearLayout.LayoutParams)localObject).height = this.lineHeight;
              ((LinearLayout.LayoutParams)localObject).width = Math.round(this.lzt.getResources().getDisplayMetrics().density * 0.5F);
              ((LinearLayout.LayoutParams)localObject).gravity = 16;
              paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            i += 1;
            break;
            localImageView.setVisibility(0);
            localImageView.setImageDrawable(bb.m(this.lzt, R.k.biz_menu_show_sub_menu_icon, this.lzt.getResources().getColor(R.e.FG_2)));
            continue;
            localImageView.setVisibility(8);
          }
        }
        localImageView.setVisibility(0);
        if (aw.isDarkMode()) {}
        for (j = R.g.biz_menu_show_miniprogram_icon_dark;; j = R.g.biz_menu_show_miniprogram_icon)
        {
          localImageView.setImageResource(j);
          break;
        }
      }
      AppMethodBeat.o(27528);
      return;
    }
    this.NbN.setVisibility(8);
    AppMethodBeat.o(27528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference
 * JD-Core Version:    0.7.0.1
 */