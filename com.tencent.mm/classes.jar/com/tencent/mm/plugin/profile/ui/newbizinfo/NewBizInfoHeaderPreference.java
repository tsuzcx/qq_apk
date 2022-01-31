package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.profile.ui.b.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;

public class NewBizInfoHeaderPreference
  extends Preference
  implements d.a, n.b
{
  private static long pDC = 0L;
  private MMActivity cmc;
  ad contact;
  ImageView ehv;
  private boolean lJS;
  private FlexboxLayout pDA;
  ConstraintLayout pDB;
  boolean pDD;
  private lj pDf;
  View pDy;
  private MMCollapsibleTextView pDz;
  private String pyc;
  private com.tencent.mm.aj.d pyd;
  private com.tencent.mm.plugin.profile.ui.b.a pye;
  private b pyf;
  private TextView titleTv;
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23855);
    this.pDD = false;
    this.pye = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.pyf = new b(this);
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23855);
  }
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23856);
    this.pDD = false;
    this.pye = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.pyf = new b(this);
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23856);
  }
  
  private void initView()
  {
    AppMethodBeat.i(23858);
    if ((!this.lJS) || (this.contact == null))
    {
      ab.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
      AppMethodBeat.o(23858);
      return;
    }
    int i;
    Object localObject1;
    label112:
    boolean bool;
    if ((s.aWl()) && (com.tencent.mm.n.a.je(this.contact.field_type)) && (this.contact.Oa()) && (f.rU(this.contact.field_username)))
    {
      i = 1;
      if (i == 0) {
        break label584;
      }
      localObject1 = bo.nullAsNil(this.contact.field_nickname) + "*";
      localObject1 = j.b(this.cmc, (CharSequence)localObject1, this.titleTv.getTextSize());
      if (i != 0)
      {
        localObject2 = this.cmc.getResources().getDrawable(2130837986);
        i = (int)(6.0F * this.cmc.getResources().getDisplayMetrics().density + 0.5F);
        ((Drawable)localObject2).setBounds(i, 0, ((Drawable)localObject2).getIntrinsicWidth() + i, ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), ((SpannableString)localObject1).length() - 1, ((SpannableString)localObject1).length(), 17);
      }
      this.titleTv.setText((CharSequence)localObject1);
      if (this.pyd == null) {
        this.pyd = f.rS(this.contact.field_username);
      }
      if (this.pyd != null) {
        this.pyc = this.pyd.field_brandIconURL;
      }
      this.ehv.setVisibility(0);
      if (System.currentTimeMillis() - pDC >= 2000L) {
        break label599;
      }
      i = 1;
      label289:
      Object localObject2 = this.ehv;
      ad localad = this.contact;
      if (!this.pDD) {
        break label604;
      }
      localObject1 = "";
      label313:
      if ((!this.pDD) || (i == 0)) {
        break label613;
      }
      bool = true;
      label326:
      com.tencent.mm.plugin.brandservice.b.a.a((ImageView)localObject2, localad, (String)localObject1, bool);
      if (!this.pDD) {
        break label618;
      }
      this.ehv.setClickable(false);
      label351:
      if (bo.nullAsNil(this.contact.signature).trim().length() > 0) {
        break label636;
      }
      this.pDz.setVisibility(8);
    }
    for (;;)
    {
      if (this.pDf.wzI != null)
      {
        i = this.pDf.wzI.wxQ;
        int j = this.pDf.wzI.wxR;
        this.pDA.removeAllViews();
        if (i > 0)
        {
          localObject1 = (TextView)this.cmc.getLayoutInflater().inflate(2130969241, this.pDA, false);
          ((TextView)localObject1).setText(String.format(this.cmc.getResources().getString(2131298558), new Object[] { String.valueOf(i) }));
          this.pDA.addView((View)localObject1);
        }
        if (j > 0)
        {
          localObject1 = (TextView)this.cmc.getLayoutInflater().inflate(2130969241, this.pDA, false);
          ((TextView)localObject1).setText(String.format(this.cmc.getResources().getString(2131298540), new Object[] { String.valueOf(j) }));
          this.pDA.addView((View)localObject1);
        }
      }
      this.pDB.getViewTreeObserver().addOnPreDrawListener(new NewBizInfoHeaderPreference.2(this));
      AppMethodBeat.o(23858);
      return;
      i = 0;
      break;
      label584:
      localObject1 = bo.nullAsNil(this.contact.field_nickname);
      break label112;
      label599:
      i = 0;
      break label289;
      label604:
      localObject1 = this.pyc;
      break label313;
      label613:
      bool = false;
      break label326;
      label618:
      this.ehv.setOnClickListener(new NewBizInfoHeaderPreference.1(this));
      break label351;
      label636:
      this.pDz.setText(j.b(this.cmc, this.contact.signature));
      this.pDz.setVisibility(0);
    }
  }
  
  public static void kT(long paramLong)
  {
    pDC = paramLong;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(23863);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.NewBizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(23863);
      return;
    }
    paramn = (String)paramObject;
    if (bo.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(23863);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      aw.aaz();
      this.contact = c.YA().arw(paramn);
    }
    AppMethodBeat.o(23863);
  }
  
  public final void a(ad paramad, String paramString, com.tencent.mm.aj.d paramd, lj paramlj)
  {
    AppMethodBeat.i(153597);
    onDetach();
    this.pyc = paramString;
    this.pyd = paramd;
    this.contact = paramad;
    this.pDf = paramlj;
    aw.aaz();
    c.YA().a(this.pyf);
    o.acQ().d(this.pye);
    initView();
    AppMethodBeat.o(153597);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23857);
    this.ehv = ((ImageView)paramView.findViewById(2131823107));
    this.titleTv = ((TextView)paramView.findViewById(2131823108));
    this.pDz = ((MMCollapsibleTextView)paramView.findViewById(2131823103));
    this.pDA = ((FlexboxLayout)paramView.findViewById(2131823102));
    this.pDB = ((ConstraintLayout)paramView.findViewById(2131823106));
    this.lJS = true;
    initView();
    super.onBindView(paramView);
    this.pDy = paramView;
    AppMethodBeat.o(23857);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(23861);
    aw.aaz();
    c.YA().b(this.pyf);
    o.acQ().e(this.pye);
    AppMethodBeat.o(23861);
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(23862);
    ab.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged user:%s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged err, user is null");
      AppMethodBeat.o(23862);
      return;
    }
    if ((this.contact != null) && (paramString.equals(this.contact.field_username))) {
      initView();
    }
    AppMethodBeat.o(23862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */