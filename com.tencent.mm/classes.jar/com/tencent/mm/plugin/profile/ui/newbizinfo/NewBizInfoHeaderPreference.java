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
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public class NewBizInfoHeaderPreference
  extends Preference
  implements e.a, n.b
{
  private static long xlw = 0L;
  an contact;
  private MMActivity fNT;
  ImageView fTj;
  private ImageView heJ;
  private MMNeat7extView ovu;
  private boolean qnX;
  private TextView titleTv;
  private String xfD;
  private com.tencent.mm.api.c xfE;
  private com.tencent.mm.plugin.profile.ui.b.a xfF;
  private com.tencent.mm.plugin.profile.ui.b.b xfG;
  private ok xkU;
  View xlt;
  private FlexboxLayout xlu;
  ConstraintLayout xlv;
  boolean xlx;
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27510);
    this.xlx = false;
    this.xfF = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.xfG = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.fNT = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(27510);
  }
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27511);
    this.xlx = false;
    this.xfF = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.xfG = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.fNT = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(27511);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void initView()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27513);
    if ((!this.qnX) || (this.contact == null))
    {
      ae.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
      AppMethodBeat.o(27513);
      return;
    }
    int i;
    Object localObject1;
    label125:
    Object localObject2;
    label443:
    Object localObject3;
    if ((y.bOd()) && (com.tencent.mm.contact.c.lO(this.contact.field_type)) && (this.contact.adB()) && (com.tencent.mm.al.g.Ep(this.contact.field_username)))
    {
      i = 1;
      boolean bool2 = this.contact.fuh();
      if (i == 0) {
        break label904;
      }
      localObject1 = bu.nullAsNil(this.contact.field_nickname) + "*";
      localObject2 = localObject1;
      if (bool2) {
        localObject2 = (String)localObject1 + "*";
      }
      localObject1 = k.b(this.fNT, (CharSequence)localObject2, this.titleTv.getTextSize());
      int k = ((SpannableString)localObject1).length() - 1;
      if (bool2)
      {
        int j = k;
        if (i != 0) {
          j = k - 1;
        }
        localObject2 = this.fNT.getResources().getDrawable(2131235008);
        k = (int)(this.fNT.getResources().getDisplayMetrics().density * 6.0F + 0.5F);
        int m = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 18);
        ((Drawable)localObject2).setBounds(k, 0, m + k, m);
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), j, j + 1, 17);
      }
      if (i != 0)
      {
        localObject2 = this.fNT.getResources().getDrawable(2131231289);
        i = (int)(this.fNT.getResources().getDisplayMetrics().density * 6.0F + 0.5F);
        ((Drawable)localObject2).setBounds(i, 0, ((Drawable)localObject2).getIntrinsicWidth() + i, ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), ((SpannableString)localObject1).length() - 1, ((SpannableString)localObject1).length(), 17);
      }
      this.titleTv.setText((CharSequence)localObject1);
      if (this.xfE == null) {
        this.xfE = com.tencent.mm.al.g.eX(this.contact.field_username);
      }
      if (this.xfE != null) {
        this.xfD = this.xfE.field_brandIconURL;
      }
      this.fTj.setVisibility(0);
      if (System.currentTimeMillis() - xlw >= 2000L) {
        break label919;
      }
      i = 1;
      localObject2 = this.fTj;
      localObject3 = this.contact;
      if (!this.xlx) {
        break label924;
      }
      localObject1 = "";
      label467:
      if ((this.xlx) || (i == 0)) {
        break label933;
      }
      label478:
      d.a((ImageView)localObject2, (an)localObject3, (String)localObject1, bool1);
      if (!this.xlx) {
        break label939;
      }
      this.fTj.setClickable(false);
    }
    for (;;)
    {
      localObject2 = this.contact.signature;
      localObject1 = localObject2;
      if (bu.nullAsNil((String)localObject2).trim().length() <= 0) {
        localObject1 = this.fNT.getString(2131757606);
      }
      localObject1 = k.c(this.fNT, (CharSequence)localObject1);
      this.ovu.aq((CharSequence)localObject1);
      this.ovu.setVisibility(0);
      if ((this.xfE == null) || (this.xfE.bX(false) == null) || (this.xfE.bX(false).KR() == null) || (bu.isNullOrNil(this.xfE.bX(false).KR().cSj)))
      {
        ae.i("MicroMsg.NewBizInfoHeaderPreference", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
        this.heJ.setVisibility(8);
      }
      this.ovu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g(this.ovu, new com.tencent.mm.pluginsdk.ui.span.n())
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
      this.heJ.setImageDrawable(ao.k(this.mContext, 2131689771, this.fNT.getResources().getColor(2131099662)));
      this.heJ.setOnTouchListener(new View.OnTouchListener()
      {
        @SuppressLint({"ResourceType"})
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(27506);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this, paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(27506);
          return false;
        }
      });
      this.ovu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27507);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27507);
        }
      });
      this.heJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27508);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27508);
        }
      });
      if (this.xkU.Gcc != null)
      {
        localObject2 = this.xkU.Gcc.FZg;
        localObject1 = this.xkU.Gcc.FZh;
        this.xlu.removeAllViews();
        if (!bu.isNullOrNil((String)localObject2))
        {
          localObject3 = (TextView)this.fNT.getLayoutInflater().inflate(2131493629, this.xlu, false);
          ((TextView)localObject3).setText((CharSequence)localObject2);
          this.xlu.addView((View)localObject3);
        }
        if (!bu.isNullOrNil((String)localObject1))
        {
          localObject2 = (TextView)this.fNT.getLayoutInflater().inflate(2131493629, this.xlu, false);
          ((TextView)localObject2).setText((CharSequence)localObject1);
          this.xlu.addView((View)localObject2);
        }
      }
      this.xlv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(27509);
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int[] arrayOfInt = new int[2];
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getLocationOnScreen(arrayOfInt);
          int k = arrayOfInt[1];
          int j = com.tencent.mm.cb.a.ay(NewBizInfoHeaderPreference.this.mContext, 2131166723);
          int m = ar.jN(NewBizInfoHeaderPreference.this.mContext);
          int n = ar.dX(NewBizInfoHeaderPreference.this.mContext);
          ae.i("MicroMsg.NewBizInfoHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
          int i = j;
          if (m > 0)
          {
            i = j;
            if (n > 0) {
              i = com.tencent.mm.cb.a.ay(NewBizInfoHeaderPreference.this.mContext, 2131165289) + n;
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
      label904:
      localObject1 = bu.nullAsNil(this.contact.field_nickname);
      break label125;
      label919:
      i = 0;
      break label443;
      label924:
      localObject1 = this.xfD;
      break label467;
      label933:
      bool1 = false;
      break label478;
      label939:
      this.fTj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27504);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this).field_username;
          paramAnonymousView = new Intent(NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this), ProfileHdHeadImg.class);
          paramAnonymousView.putExtra("username", (String)localObject);
          paramAnonymousView.putExtra("brand_icon_url", NewBizInfoHeaderPreference.c(NewBizInfoHeaderPreference.this));
          localObject = NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27504);
        }
      });
    }
  }
  
  public static void yX(long paramLong)
  {
    xlw = paramLong;
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(27516);
    ae.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged user:%s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged err, user is null");
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
      ae.d("MicroMsg.NewBizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(27517);
      return;
    }
    paramn = (String)paramObject;
    if (bu.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(27517);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      bc.aCg();
      this.contact = com.tencent.mm.model.c.azF().BH(paramn);
    }
    AppMethodBeat.o(27517);
  }
  
  public final void a(an paraman, String paramString, com.tencent.mm.api.c paramc, ok paramok)
  {
    AppMethodBeat.i(27514);
    onDetach();
    this.xfD = paramString;
    this.xfE = paramc;
    this.contact = paraman;
    this.xkU = paramok;
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this.xfG);
    p.aEA().d(this.xfF);
    initView();
    AppMethodBeat.o(27514);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27512);
    this.fTj = ((ImageView)paramView.findViewById(2131297413));
    this.titleTv = ((TextView)paramView.findViewById(2131297417));
    this.ovu = ((MMNeat7extView)paramView.findViewById(2131297414));
    this.xlu = ((FlexboxLayout)paramView.findViewById(2131297415));
    this.xlv = ((ConstraintLayout)paramView.findViewById(2131297416));
    this.heJ = ((ImageView)paramView.findViewById(2131301205));
    this.qnX = true;
    initView();
    super.onBindView(paramView);
    this.xlt = paramView;
    AppMethodBeat.o(27512);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27515);
    bc.aCg();
    com.tencent.mm.model.c.azF().b(this.xfG);
    p.aEA().e(this.xfF);
    AppMethodBeat.o(27515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */