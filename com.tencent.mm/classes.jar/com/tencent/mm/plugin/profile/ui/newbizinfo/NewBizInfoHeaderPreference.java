package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.d;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public class NewBizInfoHeaderPreference
  extends Preference
  implements e.a, n.b
{
  private static long vOw = 0L;
  ai contact;
  ImageView fxQ;
  private ImageView gIl;
  private MMActivity iMV;
  private MMNeat7extView nMW;
  private boolean pDN;
  private TextView titleTv;
  private String vIF;
  private com.tencent.mm.api.c vIG;
  private com.tencent.mm.plugin.profile.ui.b.a vIH;
  private com.tencent.mm.plugin.profile.ui.b.b vII;
  private nl vNU;
  View vOt;
  private FlexboxLayout vOu;
  ConstraintLayout vOv;
  boolean vOx;
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27510);
    this.vOx = false;
    this.vIH = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.vII = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(27510);
  }
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27511);
    this.vOx = false;
    this.vIH = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.vII = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(27511);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void initView()
  {
    int j = 1;
    AppMethodBeat.i(27513);
    if ((!this.pDN) || (this.contact == null))
    {
      ac.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
      AppMethodBeat.o(27513);
      return;
    }
    int i;
    Object localObject1;
    label115:
    Object localObject2;
    label295:
    Object localObject3;
    label319:
    boolean bool;
    if ((v.bIO()) && (com.tencent.mm.n.b.ln(this.contact.field_type)) && (this.contact.aaN()) && (f.AO(this.contact.field_username)))
    {
      i = 1;
      if (i == 0) {
        break label879;
      }
      localObject1 = bs.nullAsNil(this.contact.field_nickname) + "*";
      localObject1 = k.b(this.iMV, (CharSequence)localObject1, this.titleTv.getTextSize());
      if (i != 0)
      {
        localObject2 = this.iMV.getResources().getDrawable(2131231289);
        i = (int)(6.0F * this.iMV.getResources().getDisplayMetrics().density + 0.5F);
        ((Drawable)localObject2).setBounds(i, 0, ((Drawable)localObject2).getIntrinsicWidth() + i, ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), ((SpannableString)localObject1).length() - 1, ((SpannableString)localObject1).length(), 17);
      }
      this.titleTv.setText((CharSequence)localObject1);
      if (this.vIG == null) {
        this.vIG = f.dX(this.contact.field_username);
      }
      if (this.vIG != null) {
        this.vIF = this.vIG.field_brandIconURL;
      }
      this.fxQ.setVisibility(0);
      if (System.currentTimeMillis() - vOw >= 2000L) {
        break label894;
      }
      i = 1;
      localObject2 = this.fxQ;
      localObject3 = this.contact;
      if (!this.vOx) {
        break label899;
      }
      localObject1 = "";
      if ((this.vOx) || (i == 0)) {
        break label908;
      }
      bool = true;
      label332:
      d.a((ImageView)localObject2, (ai)localObject3, (String)localObject1, bool);
      if (!this.vOx) {
        break label913;
      }
      this.fxQ.setClickable(false);
      label357:
      localObject2 = this.contact.signature;
      localObject1 = localObject2;
      if (bs.nullAsNil((String)localObject2).trim().length() <= 0) {
        localObject1 = this.iMV.getString(2131757606);
      }
      if ((!this.contact.fae()) || (this.vIG == null) || (this.vIG.bV(false) == null) || (this.vIG.bV(false).Jj() == null) || (bs.isNullOrNil(this.vIG.bV(false).Jj().cGh))) {
        break label931;
      }
      i = j;
      label460:
      if (i == 0) {
        break label936;
      }
      ac.i("MicroMsg.NewBizInfoHeaderPreference", "biz is personal verified and person verify info is not nil");
      localObject1 = this.vIG.bV(false).Jj().cGh;
      this.nMW.setVisibility(0);
      localObject1 = k.c(this.iMV, (CharSequence)localObject1);
      localObject1 = k.e(this.iMV, (CharSequence)localObject1);
      this.nMW.setTextColor(this.iMV.getResources().getColor(2131099664));
      this.nMW.ar((CharSequence)localObject1);
    }
    for (;;)
    {
      if ((this.vIG == null) || (this.vIG.bV(false) == null) || (this.vIG.bV(false).Jk() == null) || (bs.isNullOrNil(this.vIG.bV(false).Jk().cGv)))
      {
        ac.i("MicroMsg.NewBizInfoHeaderPreference", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
        this.gIl.setVisibility(8);
      }
      this.nMW.setOnTouchListener(new g(this.nMW, new com.tencent.mm.pluginsdk.ui.span.n())
      {
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
        
        @SuppressLint({"ResourceType"})
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(27505);
          NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this, paramAnonymousMotionEvent);
          boolean bool = super.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(27505);
          return bool;
        }
      });
      this.gIl.setImageDrawable(am.k(this.mContext, 2131689771, this.iMV.getResources().getColor(2131099662)));
      this.gIl.setOnTouchListener(new View.OnTouchListener()
      {
        @SuppressLint({"ResourceType"})
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(27506);
          NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this, paramAnonymousMotionEvent);
          AppMethodBeat.o(27506);
          return false;
        }
      });
      this.nMW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27507);
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          AppMethodBeat.o(27507);
        }
      });
      this.gIl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27508);
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          AppMethodBeat.o(27508);
        }
      });
      if (this.vNU.Edu != null)
      {
        localObject2 = this.vNU.Edu.Ebb;
        localObject1 = this.vNU.Edu.Ebc;
        this.vOu.removeAllViews();
        if (!bs.isNullOrNil((String)localObject2))
        {
          localObject3 = (TextView)this.iMV.getLayoutInflater().inflate(2131493629, this.vOu, false);
          ((TextView)localObject3).setText((CharSequence)localObject2);
          this.vOu.addView((View)localObject3);
        }
        if (!bs.isNullOrNil((String)localObject1))
        {
          localObject2 = (TextView)this.iMV.getLayoutInflater().inflate(2131493629, this.vOu, false);
          ((TextView)localObject2).setText((CharSequence)localObject1);
          this.vOu.addView((View)localObject2);
        }
      }
      this.vOv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(27509);
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int[] arrayOfInt = new int[2];
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getLocationOnScreen(arrayOfInt);
          int k = arrayOfInt[1];
          int j = com.tencent.mm.cc.a.av(NewBizInfoHeaderPreference.this.mContext, 2131166723);
          int m = ap.ji(NewBizInfoHeaderPreference.this.mContext);
          int n = ap.dT(NewBizInfoHeaderPreference.this.mContext);
          ac.i("MicroMsg.NewBizInfoHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
          int i = j;
          if (m > 0)
          {
            i = j;
            if (n > 0) {
              i = com.tencent.mm.cc.a.av(NewBizInfoHeaderPreference.this.mContext, 2131165289) + n;
            }
          }
          j = i;
          if (k == 0) {
            j = i + m;
          }
          if (j != NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getPaddingTop())
          {
            NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).setPadding(NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getPaddingLeft(), j, NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getPaddingRight(), NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getPaddingBottom());
            AppMethodBeat.o(27509);
            return false;
          }
          AppMethodBeat.o(27509);
          return true;
        }
      });
      AppMethodBeat.o(27513);
      return;
      i = 0;
      break;
      label879:
      localObject1 = bs.nullAsNil(this.contact.field_nickname);
      break label115;
      label894:
      i = 0;
      break label295;
      label899:
      localObject1 = this.vIF;
      break label319;
      label908:
      bool = false;
      break label332;
      label913:
      this.fxQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27504);
          Object localObject = NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this).field_username;
          paramAnonymousView = new Intent(NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this), ProfileHdHeadImg.class);
          paramAnonymousView.putExtra("username", (String)localObject);
          paramAnonymousView.putExtra("brand_icon_url", NewBizInfoHeaderPreference.c(NewBizInfoHeaderPreference.this));
          localObject = NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(27504);
        }
      });
      break label357;
      label931:
      i = 0;
      break label460;
      label936:
      localObject1 = k.c(this.iMV, (CharSequence)localObject1);
      this.nMW.ar((CharSequence)localObject1);
      this.nMW.setVisibility(0);
    }
  }
  
  public static void wn(long paramLong)
  {
    vOw = paramLong;
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(27516);
    ac.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged user:%s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged err, user is null");
      AppMethodBeat.o(27516);
      return;
    }
    if ((this.contact != null) && (paramString.equals(this.contact.field_username))) {
      initView();
    }
    AppMethodBeat.o(27516);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(27517);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.d("MicroMsg.NewBizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(27517);
      return;
    }
    paramn = (String)paramObject;
    if (bs.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(27517);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      az.ayM();
      this.contact = com.tencent.mm.model.c.awB().aNt(paramn);
    }
    AppMethodBeat.o(27517);
  }
  
  public final void a(ai paramai, String paramString, com.tencent.mm.api.c paramc, nl paramnl)
  {
    AppMethodBeat.i(27514);
    onDetach();
    this.vIF = paramString;
    this.vIG = paramc;
    this.contact = paramai;
    this.vNU = paramnl;
    az.ayM();
    com.tencent.mm.model.c.awB().a(this.vII);
    p.aBh().d(this.vIH);
    initView();
    AppMethodBeat.o(27514);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27512);
    this.fxQ = ((ImageView)paramView.findViewById(2131297413));
    this.titleTv = ((TextView)paramView.findViewById(2131297417));
    this.nMW = ((MMNeat7extView)paramView.findViewById(2131297414));
    this.vOu = ((FlexboxLayout)paramView.findViewById(2131297415));
    this.vOv = ((ConstraintLayout)paramView.findViewById(2131297416));
    this.gIl = ((ImageView)paramView.findViewById(2131301205));
    this.pDN = true;
    initView();
    super.onBindView(paramView);
    this.vOt = paramView;
    AppMethodBeat.o(27512);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27515);
    az.ayM();
    com.tencent.mm.model.c.awB().b(this.vII);
    p.aBh().e(this.vIH);
    AppMethodBeat.o(27515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */