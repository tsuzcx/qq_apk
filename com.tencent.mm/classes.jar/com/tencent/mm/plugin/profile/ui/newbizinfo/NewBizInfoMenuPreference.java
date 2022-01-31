package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.lt;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMenuPreference
  extends Preference
{
  private MMActivity cmc;
  private ad contact;
  private boolean lJS;
  private int lineHeight;
  private LinearLayout pDG;
  private List<lv> pDH;
  private lt pDI;
  private int state;
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23873);
    this.state = 0;
    this.lJS = false;
    this.lineHeight = 0;
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23873);
  }
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23874);
    this.state = 0;
    this.lJS = false;
    this.lineHeight = 0;
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23874);
  }
  
  private View a(lv paramlv)
  {
    AppMethodBeat.i(153598);
    View localView = View.inflate(this.cmc, 2130969219, null);
    TextView localTextView = (TextView)localView.findViewById(2131823041);
    ImageView localImageView = (ImageView)localView.findViewById(2131823040);
    this.lineHeight = ((int)localTextView.getTextSize());
    ab(localImageView, (int)localTextView.getTextSize() * 3 / 4);
    switch (paramlv.type)
    {
    }
    for (;;)
    {
      localTextView.setText(j.b(this.cmc, paramlv.name));
      AppMethodBeat.o(153598);
      return localView;
      localImageView.setVisibility(0);
      localImageView.setImageResource(2131230987);
      continue;
      localImageView.setVisibility(8);
      continue;
      localImageView.setVisibility(0);
      localImageView.setImageResource(2130837925);
    }
  }
  
  private static void ab(View paramView, int paramInt)
  {
    AppMethodBeat.i(23879);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    localLayoutParams.width = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(23879);
  }
  
  private void bMz()
  {
    AppMethodBeat.i(23877);
    this.pDG.removeAllViews();
    int i = 0;
    while (i < this.pDH.size())
    {
      Object localObject2 = (lv)this.pDH.get(i);
      Object localObject1 = a((lv)localObject2);
      ((View)localObject1).setOnClickListener(new NewBizInfoMenuPreference.1(this, (lv)localObject2));
      this.pDG.addView((View)localObject1);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -2;
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (i != this.pDH.size() - 1)
      {
        localObject1 = new ImageView(this.cmc);
        ((ImageView)localObject1).setBackgroundColor(this.cmc.getResources().getColor(2131690213));
        this.pDG.addView((View)localObject1);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.lineHeight;
        ((LinearLayout.LayoutParams)localObject2).width = Math.round(this.cmc.getResources().getDisplayMetrics().density * 0.5F);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i += 1;
    }
    AppMethodBeat.o(23877);
  }
  
  private void ccF()
  {
    AppMethodBeat.i(23881);
    if ((this.pDI != null) && (this.pDI.wwI != null))
    {
      this.state = 4;
      AppMethodBeat.o(23881);
      return;
    }
    if (this.pDI != null)
    {
      if ((this.pDI != null) && (this.pDH != null) && (this.pDH.size() <= 0))
      {
        this.state = 2;
        AppMethodBeat.o(23881);
        return;
      }
      if ((this.pDI != null) && (this.pDH != null) && (this.pDH.size() > 0))
      {
        this.state = 3;
        AppMethodBeat.o(23881);
      }
    }
    else
    {
      this.state = 0;
    }
    AppMethodBeat.o(23881);
  }
  
  private void initView()
  {
    AppMethodBeat.i(23876);
    if ((!this.lJS) || (this.pDG == null))
    {
      AppMethodBeat.o(23876);
      return;
    }
    if ((this.state != 1) && (this.state != 2) && (this.state == 3))
    {
      this.pDG.setVisibility(0);
      bMz();
      AppMethodBeat.o(23876);
      return;
    }
    this.pDG.setVisibility(8);
    AppMethodBeat.o(23876);
  }
  
  public final void a(lt paramlt, ad paramad)
  {
    AppMethodBeat.i(153599);
    if (paramlt == null)
    {
      AppMethodBeat.o(153599);
      return;
    }
    this.contact = paramad;
    this.pDI = paramlt;
    this.pDH = c.a(paramlt.wAm);
    ccF();
    initView();
    AppMethodBeat.o(153599);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23875);
    super.onBindView(paramView);
    this.pDG = ((LinearLayout)paramView.findViewById(2131823042));
    this.lJS = true;
    initView();
    AppMethodBeat.o(23875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference
 * JD-Core Version:    0.7.0.1
 */