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
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.am.f;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.d;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.u;
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
  private static long uFF = 0L;
  af contact;
  ImageView fuj;
  private MMActivity imP;
  private MMNeat7extView nkd;
  private boolean paC;
  private TextView titleTv;
  View uFB;
  private FlexboxLayout uFC;
  ConstraintLayout uFD;
  private ImageView uFE;
  boolean uFG;
  private ne uFd;
  private String uzM;
  private com.tencent.mm.api.c uzN;
  private com.tencent.mm.plugin.profile.ui.b.a uzO;
  private com.tencent.mm.plugin.profile.ui.b.b uzP;
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27510);
    this.uFG = false;
    this.uzO = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.uzP = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27510);
  }
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27511);
    this.uFG = false;
    this.uzO = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.uzP = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27511);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void initView()
  {
    int j = 1;
    AppMethodBeat.i(27513);
    if ((!this.paC) || (this.contact == null))
    {
      ad.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
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
    if ((u.bBQ()) && (com.tencent.mm.n.b.ls(this.contact.field_type)) && (this.contact.ZS()) && (f.wI(this.contact.field_username)))
    {
      i = 1;
      if (i == 0) {
        break label879;
      }
      localObject1 = bt.nullAsNil(this.contact.field_nickname) + "*";
      localObject1 = k.b(this.imP, (CharSequence)localObject1, this.titleTv.getTextSize());
      if (i != 0)
      {
        localObject2 = this.imP.getResources().getDrawable(2131231289);
        i = (int)(6.0F * this.imP.getResources().getDisplayMetrics().density + 0.5F);
        ((Drawable)localObject2).setBounds(i, 0, ((Drawable)localObject2).getIntrinsicWidth() + i, ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), ((SpannableString)localObject1).length() - 1, ((SpannableString)localObject1).length(), 17);
      }
      this.titleTv.setText((CharSequence)localObject1);
      if (this.uzN == null) {
        this.uzN = f.ei(this.contact.field_username);
      }
      if (this.uzN != null) {
        this.uzM = this.uzN.field_brandIconURL;
      }
      this.fuj.setVisibility(0);
      if (System.currentTimeMillis() - uFF >= 2000L) {
        break label894;
      }
      i = 1;
      localObject2 = this.fuj;
      localObject3 = this.contact;
      if (!this.uFG) {
        break label899;
      }
      localObject1 = "";
      if ((this.uFG) || (i == 0)) {
        break label908;
      }
      bool = true;
      label332:
      com.tencent.mm.plugin.brandservice.b.e.a((ImageView)localObject2, (af)localObject3, (String)localObject1, bool);
      if (!this.uFG) {
        break label913;
      }
      this.fuj.setClickable(false);
      label357:
      localObject2 = this.contact.signature;
      localObject1 = localObject2;
      if (bt.nullAsNil((String)localObject2).trim().length() <= 0) {
        localObject1 = this.imP.getString(2131757606);
      }
      if ((!this.contact.eKC()) || (this.uzN == null) || (this.uzN.bU(false) == null) || (this.uzN.bU(false).JA() == null) || (bt.isNullOrNil(this.uzN.bU(false).JA().cJa))) {
        break label931;
      }
      i = j;
      label460:
      if (i == 0) {
        break label936;
      }
      ad.i("MicroMsg.NewBizInfoHeaderPreference", "biz is personal verified and person verify info is not nil");
      localObject1 = this.uzN.bU(false).JA().cJa;
      this.nkd.setVisibility(0);
      localObject1 = k.c(this.imP, (CharSequence)localObject1);
      localObject1 = k.e(this.imP, (CharSequence)localObject1);
      this.nkd.setTextColor(this.imP.getResources().getColor(2131099664));
      this.nkd.aq((CharSequence)localObject1);
    }
    for (;;)
    {
      if ((this.uzN == null) || (this.uzN.bU(false) == null) || (this.uzN.bU(false).JB() == null) || (bt.isNullOrNil(this.uzN.bU(false).JB().cJo)))
      {
        ad.i("MicroMsg.NewBizInfoHeaderPreference", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
        this.uFE.setVisibility(8);
      }
      this.nkd.setOnTouchListener(new g(this.nkd, new com.tencent.mm.pluginsdk.ui.span.n())
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
      this.uFE.setImageDrawable(am.i(this.mContext, 2131689771, this.imP.getResources().getColor(2131099662)));
      this.uFE.setOnTouchListener(new View.OnTouchListener()
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
      this.nkd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27507);
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          AppMethodBeat.o(27507);
        }
      });
      this.uFE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27508);
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          AppMethodBeat.o(27508);
        }
      });
      if (this.uFd.CKS != null)
      {
        localObject2 = this.uFd.CKS.CIz;
        localObject1 = this.uFd.CKS.CIA;
        this.uFC.removeAllViews();
        if (!bt.isNullOrNil((String)localObject2))
        {
          localObject3 = (TextView)this.imP.getLayoutInflater().inflate(2131493629, this.uFC, false);
          ((TextView)localObject3).setText((CharSequence)localObject2);
          this.uFC.addView((View)localObject3);
        }
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject2 = (TextView)this.imP.getLayoutInflater().inflate(2131493629, this.uFC, false);
          ((TextView)localObject2).setText((CharSequence)localObject1);
          this.uFC.addView((View)localObject2);
        }
      }
      this.uFD.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(27509);
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int[] arrayOfInt = new int[2];
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getLocationOnScreen(arrayOfInt);
          int k = arrayOfInt[1];
          int j = com.tencent.mm.cd.a.ap(NewBizInfoHeaderPreference.this.mContext, 2131166723);
          int m = ap.iX(NewBizInfoHeaderPreference.this.mContext);
          int n = ap.dL(NewBizInfoHeaderPreference.this.mContext);
          ad.i("MicroMsg.NewBizInfoHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
          int i = j;
          if (m > 0)
          {
            i = j;
            if (n > 0) {
              i = com.tencent.mm.cd.a.ap(NewBizInfoHeaderPreference.this.mContext, 2131165289) + n;
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
      localObject1 = bt.nullAsNil(this.contact.field_nickname);
      break label115;
      label894:
      i = 0;
      break label295;
      label899:
      localObject1 = this.uzM;
      break label319;
      label908:
      bool = false;
      break label332;
      label913:
      this.fuj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27504);
          Object localObject = NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this).field_username;
          paramAnonymousView = new Intent(NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this), ProfileHdHeadImg.class);
          paramAnonymousView.putExtra("username", (String)localObject);
          paramAnonymousView.putExtra("brand_icon_url", NewBizInfoHeaderPreference.c(NewBizInfoHeaderPreference.this));
          localObject = NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(27504);
        }
      });
      break label357;
      label931:
      i = 0;
      break label460;
      label936:
      localObject1 = k.c(this.imP, (CharSequence)localObject1);
      this.nkd.aq((CharSequence)localObject1);
      this.nkd.setVisibility(0);
    }
  }
  
  public static void rK(long paramLong)
  {
    uFF = paramLong;
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
      az.arV();
      this.contact = com.tencent.mm.model.c.apM().aHY(paramn);
    }
    AppMethodBeat.o(27517);
  }
  
  public final void a(af paramaf, String paramString, com.tencent.mm.api.c paramc, ne paramne)
  {
    AppMethodBeat.i(27514);
    onDetach();
    this.uzM = paramString;
    this.uzN = paramc;
    this.contact = paramaf;
    this.uFd = paramne;
    az.arV();
    com.tencent.mm.model.c.apM().a(this.uzP);
    p.auq().d(this.uzO);
    initView();
    AppMethodBeat.o(27514);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27512);
    this.fuj = ((ImageView)paramView.findViewById(2131297413));
    this.titleTv = ((TextView)paramView.findViewById(2131297417));
    this.nkd = ((MMNeat7extView)paramView.findViewById(2131297414));
    this.uFC = ((FlexboxLayout)paramView.findViewById(2131297415));
    this.uFD = ((ConstraintLayout)paramView.findViewById(2131297416));
    this.uFE = ((ImageView)paramView.findViewById(2131301205));
    this.paC = true;
    initView();
    super.onBindView(paramView);
    this.uFB = paramView;
    AppMethodBeat.o(27512);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27515);
    az.arV();
    com.tencent.mm.model.c.apM().b(this.uzP);
    p.auq().e(this.uzO);
    AppMethodBeat.o(27515);
  }
  
  public final void vZ(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */