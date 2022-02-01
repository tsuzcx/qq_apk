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
import com.tencent.mm.g.c.av;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.nu;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
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
  private ai contact;
  private MMActivity iMV;
  private int iMg;
  private int lineHeight;
  private boolean pDN;
  private int state;
  private LinearLayout vOA;
  private List<nw> vOB;
  private nu vOC;
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27526);
    this.state = 0;
    this.pDN = false;
    this.lineHeight = 0;
    this.iMg = 0;
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(27526);
  }
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27527);
    this.state = 0;
    this.pDN = false;
    this.lineHeight = 0;
    this.iMg = 0;
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(27527);
  }
  
  private View a(nw paramnw)
  {
    AppMethodBeat.i(27531);
    View localView = View.inflate(this.iMV, 2131493605, null);
    TextView localTextView = (TextView)localView.findViewById(2131302727);
    ImageView localImageView = (ImageView)localView.findViewById(2131302726);
    this.lineHeight = ((int)localTextView.getTextSize());
    ak(localImageView, (int)localTextView.getTextSize() * 3 / 4);
    switch (paramnw.type)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        localTextView.setText(k.c(this.iMV, paramnw.name));
        o.gD(localView);
        AppMethodBeat.o(27531);
        return localView;
        localImageView.setVisibility(0);
        localImageView.setImageDrawable(am.k(this.iMV, 2131689769, this.iMV.getResources().getColor(2131099735)));
        continue;
        localImageView.setVisibility(8);
      }
    }
    localImageView.setVisibility(0);
    if (aj.DT()) {}
    for (int i = 2131231205;; i = 2131231204)
    {
      localImageView.setImageResource(i);
      break;
    }
  }
  
  private static void ak(View paramView, int paramInt)
  {
    AppMethodBeat.i(27532);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    localLayoutParams.width = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(27532);
  }
  
  private void cYk()
  {
    AppMethodBeat.i(27530);
    this.vOA.removeAllViews();
    int i = 0;
    while (i < this.vOB.size())
    {
      Object localObject2 = (nw)this.vOB.get(i);
      Object localObject1 = a((nw)localObject2);
      ((View)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27523);
          if (this.vOD == null)
          {
            ac.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
            AppMethodBeat.o(27523);
            return;
          }
          c.K(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, 1100, NewBizInfoMenuPreference.b(NewBizInfoMenuPreference.this));
          ac.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", new Object[] { Integer.valueOf(this.vOD.type) });
          switch (this.vOD.type)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(27523);
            return;
            NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this, this.vOD);
            AppMethodBeat.o(27523);
            return;
            g.a(this.vOD, NewBizInfoMenuPreference.c(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.vOD.id), this.vOD.key, b.vQJ, this.vOD.name, b.gL(NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this).indexOf(this.vOD), -1), this.vOD.Bvz);
            AppMethodBeat.o(27523);
            return;
            g.b(this.vOD, NewBizInfoMenuPreference.c(NewBizInfoMenuPreference.this), NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username);
            b.b(NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this).field_username, String.valueOf(this.vOD.id), this.vOD.key, b.vQJ, this.vOD.name, b.gL(NewBizInfoMenuPreference.d(NewBizInfoMenuPreference.this).indexOf(this.vOD), -1), this.vOD.value);
          }
        }
      });
      this.vOA.addView((View)localObject1);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -2;
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (i != this.vOB.size() - 1)
      {
        localObject1 = new ImageView(this.iMV);
        ((ImageView)localObject1).setBackgroundColor(ao.aJ(this.iMV, 2130968587));
        this.vOA.addView((View)localObject1);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.lineHeight;
        ((LinearLayout.LayoutParams)localObject2).width = Math.round(this.iMV.getResources().getDisplayMetrics().density * 0.5F);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i += 1;
    }
    AppMethodBeat.o(27530);
  }
  
  private void dqE()
  {
    AppMethodBeat.i(27534);
    if ((this.vOC != null) && (this.vOC.DZs != null))
    {
      this.state = 4;
      AppMethodBeat.o(27534);
      return;
    }
    if (this.vOC != null)
    {
      if ((this.vOC != null) && (this.vOB != null) && (this.vOB.size() <= 0))
      {
        this.state = 2;
        AppMethodBeat.o(27534);
        return;
      }
      if ((this.vOC != null) && (this.vOB != null) && (this.vOB.size() > 0))
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
    if ((!this.pDN) || (this.vOA == null))
    {
      AppMethodBeat.o(27529);
      return;
    }
    if ((this.state != 1) && (this.state != 2) && (this.state == 3))
    {
      this.vOA.setVisibility(0);
      cYk();
      AppMethodBeat.o(27529);
      return;
    }
    this.vOA.setVisibility(8);
    AppMethodBeat.o(27529);
  }
  
  public final void a(nu paramnu, ai paramai, int paramInt)
  {
    AppMethodBeat.i(27533);
    if ((paramnu == null) || (paramnu.EdL == null))
    {
      AppMethodBeat.o(27533);
      return;
    }
    this.contact = paramai;
    this.vOC = paramnu;
    this.vOB = a.a(paramnu.EdL);
    this.iMg = paramInt;
    dqE();
    initView();
    AppMethodBeat.o(27533);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27528);
    super.onBindView(paramView);
    this.vOA = ((LinearLayout)paramView.findViewById(2131298599));
    this.pDN = true;
    initView();
    AppMethodBeat.o(27528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference
 * JD-Core Version:    0.7.0.1
 */