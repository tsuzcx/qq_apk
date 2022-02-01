package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.ao.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public class NewBizInfoHeaderPreference
  extends Preference
  implements f.a, MStorageEx.IOnStorageChange
{
  private static long HdT = 0L;
  private String GXi;
  private com.tencent.mm.api.c GXj;
  private com.tencent.mm.plugin.profile.ui.b.a GXk;
  private com.tencent.mm.plugin.profile.ui.b.b GXl;
  private MMNeat7extView HdL;
  private View HdQ;
  private FlexboxLayout HdR;
  private ConstraintLayout HdS;
  boolean HdU;
  private pd Hdu;
  as contact;
  private MMActivity iXq;
  ImageView jiu;
  private ImageView kMb;
  private TextView titleTv;
  private boolean vkO;
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27510);
    this.HdU = false;
    this.GXk = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.GXl = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27510);
  }
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27511);
    this.HdU = false;
    this.GXk = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.GXl = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27511);
  }
  
  public static void Pi(long paramLong)
  {
    HdT = paramLong;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void initView()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27513);
    if ((!this.vkO) || (this.contact == null))
    {
      Log.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
      AppMethodBeat.o(27513);
      return;
    }
    int i;
    Object localObject1;
    label120:
    Object localObject2;
    label438:
    Object localObject3;
    if ((d.rk(this.contact.field_type)) && (this.contact.ayn()) && (g.Uz(this.contact.field_username)))
    {
      i = 1;
      boolean bool2 = this.contact.hxY();
      if (i == 0) {
        break label901;
      }
      localObject1 = Util.nullAsNil(this.contact.field_nickname) + "*";
      localObject2 = localObject1;
      if (bool2) {
        localObject2 = (String)localObject1 + "*";
      }
      localObject1 = l.b(this.iXq, (CharSequence)localObject2, this.titleTv.getTextSize());
      int k = ((SpannableString)localObject1).length() - 1;
      if (bool2)
      {
        int j = k;
        if (i != 0) {
          j = k - 1;
        }
        localObject2 = this.iXq.getResources().getDrawable(R.g.dnD);
        k = (int)(this.iXq.getResources().getDisplayMetrics().density * 6.0F + 0.5F);
        int m = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 18);
        ((Drawable)localObject2).setBounds(k, 0, m + k, m);
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), j, j + 1, 17);
      }
      if (i != 0)
      {
        localObject2 = this.iXq.getResources().getDrawable(R.g.biz_timeline_star_icon);
        i = (int)(this.iXq.getResources().getDisplayMetrics().density * 6.0F + 0.5F);
        ((Drawable)localObject2).setBounds(i, 0, ((Drawable)localObject2).getIntrinsicWidth() + i, ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), ((SpannableString)localObject1).length() - 1, ((SpannableString)localObject1).length(), 17);
      }
      this.titleTv.setText((CharSequence)localObject1);
      if (this.GXj == null) {
        this.GXj = g.gu(this.contact.field_username);
      }
      if (this.GXj != null) {
        this.GXi = this.GXj.field_brandIconURL;
      }
      this.jiu.setVisibility(0);
      if (System.currentTimeMillis() - HdT >= 2000L) {
        break label916;
      }
      i = 1;
      localObject2 = this.jiu;
      localObject3 = this.contact;
      if (!this.HdU) {
        break label921;
      }
      localObject1 = "";
      label462:
      if ((this.HdU) || (i == 0)) {
        break label930;
      }
      label473:
      e.a((ImageView)localObject2, (as)localObject3, (String)localObject1, bool1);
      if (!this.HdU) {
        break label936;
      }
      this.jiu.setClickable(false);
    }
    for (;;)
    {
      localObject2 = this.contact.signature;
      localObject1 = localObject2;
      if (Util.nullAsNil((String)localObject2).trim().length() <= 0) {
        localObject1 = this.iXq.getString(R.l.exZ);
      }
      localObject1 = l.c(this.iXq, (CharSequence)localObject1);
      this.HdL.aL((CharSequence)localObject1);
      this.HdL.setVisibility(0);
      if ((this.GXj == null) || (this.GXj.dc(false) == null) || (this.GXj.dc(false).Zt() == null) || (Util.isNullOrNil(this.GXj.dc(false).Zt().faj)))
      {
        Log.i("MicroMsg.NewBizInfoHeaderPreference", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
        this.kMb.setVisibility(8);
      }
      this.HdL.setOnTouchListener(new h(this.HdL, new o())
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
      this.kMb.setImageDrawable(au.o(this.mContext, R.k.biz_profile_jump_arrow_normal, this.iXq.getResources().getColor(R.e.BW_0_Alpha_0_5)));
      this.kMb.setOnTouchListener(new View.OnTouchListener()
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
      this.HdL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27507);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27507);
        }
      });
      this.kMb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27508);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27508);
        }
      });
      if (this.Hdu.RXt != null)
      {
        localObject2 = this.Hdu.RXt.RTY;
        localObject1 = this.Hdu.RXt.RTZ;
        this.HdR.removeAllViews();
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject3 = (TextView)this.iXq.getLayoutInflater().inflate(R.i.efk, this.HdR, false);
          ((TextView)localObject3).setText((CharSequence)localObject2);
          this.HdR.addView((View)localObject3);
        }
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = (TextView)this.iXq.getLayoutInflater().inflate(R.i.efk, this.HdR, false);
          ((TextView)localObject2).setText((CharSequence)localObject1);
          this.HdR.addView((View)localObject2);
        }
      }
      this.HdS.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(27509);
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int[] arrayOfInt = new int[2];
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getLocationOnScreen(arrayOfInt);
          int k = arrayOfInt[1];
          int j = com.tencent.mm.ci.a.aZ(NewBizInfoHeaderPreference.this.mContext, R.f.dlD);
          int m = com.tencent.mm.ui.ax.getStatusBarHeight(NewBizInfoHeaderPreference.this.mContext);
          int n = com.tencent.mm.ui.ax.ew(NewBizInfoHeaderPreference.this.mContext);
          Log.i("MicroMsg.NewBizInfoHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
          int i = j;
          if (m > 0)
          {
            i = j;
            if (n > 0) {
              i = com.tencent.mm.ci.a.aZ(NewBizInfoHeaderPreference.this.mContext, R.f.Edge_2A) + n;
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
      label901:
      localObject1 = Util.nullAsNil(this.contact.field_nickname);
      break label120;
      label916:
      i = 0;
      break label438;
      label921:
      localObject1 = this.GXi;
      break label462;
      label930:
      bool1 = false;
      break label473;
      label936:
      this.jiu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27504);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this).field_username;
          paramAnonymousView = new Intent(NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this), ProfileHdHeadImg.class);
          paramAnonymousView.putExtra("username", (String)localObject);
          paramAnonymousView.putExtra("brand_icon_url", NewBizInfoHeaderPreference.c(NewBizInfoHeaderPreference.this));
          localObject = NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27504);
        }
      });
    }
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(27516);
    Log.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged user:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged err, user is null");
      AppMethodBeat.o(27516);
      return;
    }
    if ((this.contact != null) && (paramString.equals(this.contact.field_username))) {
      initView();
    }
    AppMethodBeat.o(27516);
  }
  
  public final void a(as paramas, String paramString, com.tencent.mm.api.c paramc, pd parampd)
  {
    AppMethodBeat.i(27514);
    onDetach();
    this.GXi = paramString;
    this.GXj = paramc;
    this.contact = paramas;
    this.Hdu = parampd;
    bh.beI();
    com.tencent.mm.model.c.bbL().add(this.GXl);
    q.bhz().d(this.GXk);
    initView();
    AppMethodBeat.o(27514);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27512);
    this.jiu = ((ImageView)paramView.findViewById(R.h.dup));
    this.titleTv = ((TextView)paramView.findViewById(R.h.duu));
    this.HdL = ((MMNeat7extView)paramView.findViewById(R.h.duq));
    this.HdR = ((FlexboxLayout)paramView.findViewById(R.h.dur));
    this.HdS = ((ConstraintLayout)paramView.findViewById(R.h.dut));
    this.kMb = ((ImageView)paramView.findViewById(R.h.dKr));
    this.vkO = true;
    initView();
    super.onBindView(paramView);
    this.HdQ = paramView;
    AppMethodBeat.o(27512);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27515);
    bh.beI();
    com.tencent.mm.model.c.bbL().remove(this.GXl);
    q.bhz().e(this.GXk);
    AppMethodBeat.o(27515);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27517);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.NewBizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(27517);
      return;
    }
    paramMStorageEx = (String)paramObject;
    if (Util.nullAsNil(paramMStorageEx).length() <= 0)
    {
      AppMethodBeat.o(27517);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramMStorageEx)))
    {
      bh.beI();
      this.contact = com.tencent.mm.model.c.bbL().RG(paramMStorageEx);
    }
    AppMethodBeat.o(27517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */