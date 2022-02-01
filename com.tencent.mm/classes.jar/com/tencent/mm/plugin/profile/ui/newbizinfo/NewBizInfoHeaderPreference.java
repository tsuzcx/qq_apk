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
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private static long wVF = 0L;
  am contact;
  private MMActivity fLP;
  ImageView fRd;
  private ImageView hbV;
  private MMNeat7extView opC;
  private boolean qhs;
  private TextView titleTv;
  private String wPM;
  private com.tencent.mm.api.c wPN;
  private com.tencent.mm.plugin.profile.ui.b.a wPO;
  private com.tencent.mm.plugin.profile.ui.b.b wPP;
  View wVC;
  private FlexboxLayout wVD;
  ConstraintLayout wVE;
  boolean wVG;
  private oi wVd;
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27510);
    this.wVG = false;
    this.wPO = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.wPP = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27510);
  }
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27511);
    this.wVG = false;
    this.wPO = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.wPP = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27511);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void initView()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27513);
    if ((!this.qhs) || (this.contact == null))
    {
      ad.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
      AppMethodBeat.o(27513);
      return;
    }
    int i;
    Object localObject1;
    label125:
    Object localObject2;
    label443:
    Object localObject3;
    if ((y.bNf()) && (com.tencent.mm.o.b.lM(this.contact.field_type)) && (this.contact.adq()) && (com.tencent.mm.am.g.DN(this.contact.field_username)))
    {
      i = 1;
      boolean bool2 = this.contact.fqh();
      if (i == 0) {
        break label904;
      }
      localObject1 = bt.nullAsNil(this.contact.field_nickname) + "*";
      localObject2 = localObject1;
      if (bool2) {
        localObject2 = (String)localObject1 + "*";
      }
      localObject1 = k.b(this.fLP, (CharSequence)localObject2, this.titleTv.getTextSize());
      int k = ((SpannableString)localObject1).length() - 1;
      if (bool2)
      {
        int j = k;
        if (i != 0) {
          j = k - 1;
        }
        localObject2 = this.fLP.getResources().getDrawable(2131235008);
        k = (int)(this.fLP.getResources().getDisplayMetrics().density * 6.0F + 0.5F);
        int m = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 18);
        ((Drawable)localObject2).setBounds(k, 0, m + k, m);
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), j, j + 1, 17);
      }
      if (i != 0)
      {
        localObject2 = this.fLP.getResources().getDrawable(2131231289);
        i = (int)(this.fLP.getResources().getDisplayMetrics().density * 6.0F + 0.5F);
        ((Drawable)localObject2).setBounds(i, 0, ((Drawable)localObject2).getIntrinsicWidth() + i, ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), ((SpannableString)localObject1).length() - 1, ((SpannableString)localObject1).length(), 17);
      }
      this.titleTv.setText((CharSequence)localObject1);
      if (this.wPN == null) {
        this.wPN = com.tencent.mm.am.g.eS(this.contact.field_username);
      }
      if (this.wPN != null) {
        this.wPM = this.wPN.field_brandIconURL;
      }
      this.fRd.setVisibility(0);
      if (System.currentTimeMillis() - wVF >= 2000L) {
        break label919;
      }
      i = 1;
      localObject2 = this.fRd;
      localObject3 = this.contact;
      if (!this.wVG) {
        break label924;
      }
      localObject1 = "";
      label467:
      if ((this.wVG) || (i == 0)) {
        break label933;
      }
      label478:
      d.a((ImageView)localObject2, (am)localObject3, (String)localObject1, bool1);
      if (!this.wVG) {
        break label939;
      }
      this.fRd.setClickable(false);
    }
    for (;;)
    {
      localObject2 = this.contact.signature;
      localObject1 = localObject2;
      if (bt.nullAsNil((String)localObject2).trim().length() <= 0) {
        localObject1 = this.fLP.getString(2131757606);
      }
      localObject1 = k.c(this.fLP, (CharSequence)localObject1);
      this.opC.ar((CharSequence)localObject1);
      this.opC.setVisibility(0);
      if ((this.wPN == null) || (this.wPN.bX(false) == null) || (this.wPN.bX(false).KJ() == null) || (bt.isNullOrNil(this.wPN.bX(false).KJ().cRz)))
      {
        ad.i("MicroMsg.NewBizInfoHeaderPreference", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
        this.hbV.setVisibility(8);
      }
      this.opC.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g(this.opC, new com.tencent.mm.pluginsdk.ui.span.n())
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
      this.hbV.setImageDrawable(ao.k(this.mContext, 2131689771, this.fLP.getResources().getColor(2131099662)));
      this.hbV.setOnTouchListener(new View.OnTouchListener()
      {
        @SuppressLint({"ResourceType"})
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(27506);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this, paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(27506);
          return false;
        }
      });
      this.opC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27507);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27507);
        }
      });
      this.hbV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27508);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27508);
        }
      });
      if (this.wVd.FJD != null)
      {
        localObject2 = this.wVd.FJD.FGK;
        localObject1 = this.wVd.FJD.FGL;
        this.wVD.removeAllViews();
        if (!bt.isNullOrNil((String)localObject2))
        {
          localObject3 = (TextView)this.fLP.getLayoutInflater().inflate(2131493629, this.wVD, false);
          ((TextView)localObject3).setText((CharSequence)localObject2);
          this.wVD.addView((View)localObject3);
        }
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject2 = (TextView)this.fLP.getLayoutInflater().inflate(2131493629, this.wVD, false);
          ((TextView)localObject2).setText((CharSequence)localObject1);
          this.wVD.addView((View)localObject2);
        }
      }
      this.wVE.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(27509);
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int[] arrayOfInt = new int[2];
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getLocationOnScreen(arrayOfInt);
          int k = arrayOfInt[1];
          int j = com.tencent.mm.cc.a.ay(NewBizInfoHeaderPreference.this.mContext, 2131166723);
          int m = ar.jG(NewBizInfoHeaderPreference.this.mContext);
          int n = ar.dT(NewBizInfoHeaderPreference.this.mContext);
          ad.i("MicroMsg.NewBizInfoHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
          int i = j;
          if (m > 0)
          {
            i = j;
            if (n > 0) {
              i = com.tencent.mm.cc.a.ay(NewBizInfoHeaderPreference.this.mContext, 2131165289) + n;
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
      localObject1 = bt.nullAsNil(this.contact.field_nickname);
      break label125;
      label919:
      i = 0;
      break label443;
      label924:
      localObject1 = this.wPM;
      break label467;
      label933:
      bool1 = false;
      break label478;
      label939:
      this.fRd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27504);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this).field_username;
          paramAnonymousView = new Intent(NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this), ProfileHdHeadImg.class);
          paramAnonymousView.putExtra("username", (String)localObject);
          paramAnonymousView.putExtra("brand_icon_url", NewBizInfoHeaderPreference.c(NewBizInfoHeaderPreference.this));
          localObject = NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27504);
        }
      });
    }
  }
  
  public static void yy(long paramLong)
  {
    wVF = paramLong;
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(27516);
    ad.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged user:%s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged err, user is null");
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
      ad.d("MicroMsg.NewBizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(27517);
      return;
    }
    paramn = (String)paramObject;
    if (bt.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(27517);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      ba.aBQ();
      this.contact = com.tencent.mm.model.c.azp().Bf(paramn);
    }
    AppMethodBeat.o(27517);
  }
  
  public final void a(am paramam, String paramString, com.tencent.mm.api.c paramc, oi paramoi)
  {
    AppMethodBeat.i(27514);
    onDetach();
    this.wPM = paramString;
    this.wPN = paramc;
    this.contact = paramam;
    this.wVd = paramoi;
    ba.aBQ();
    com.tencent.mm.model.c.azp().a(this.wPP);
    p.aEk().d(this.wPO);
    initView();
    AppMethodBeat.o(27514);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27512);
    this.fRd = ((ImageView)paramView.findViewById(2131297413));
    this.titleTv = ((TextView)paramView.findViewById(2131297417));
    this.opC = ((MMNeat7extView)paramView.findViewById(2131297414));
    this.wVD = ((FlexboxLayout)paramView.findViewById(2131297415));
    this.wVE = ((ConstraintLayout)paramView.findViewById(2131297416));
    this.hbV = ((ImageView)paramView.findViewById(2131301205));
    this.qhs = true;
    initView();
    super.onBindView(paramView);
    this.wVC = paramView;
    AppMethodBeat.o(27512);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27515);
    ba.aBQ();
    com.tencent.mm.model.c.azp().b(this.wPP);
    p.aEk().e(this.wPO);
    AppMethodBeat.o(27515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */