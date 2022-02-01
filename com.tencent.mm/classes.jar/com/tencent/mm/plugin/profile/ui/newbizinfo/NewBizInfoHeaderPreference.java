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
import com.tencent.mm.al.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public class NewBizInfoHeaderPreference
  extends Preference
  implements e.a, MStorageEx.IOnStorageChange
{
  private static long Bjx = 0L;
  private String Bdj;
  private com.tencent.mm.api.c Bdk;
  private com.tencent.mm.plugin.profile.ui.b.a Bdl;
  private com.tencent.mm.plugin.profile.ui.b.b Bdm;
  private ph BiU;
  View Bju;
  private FlexboxLayout Bjv;
  ConstraintLayout Bjw;
  boolean Bjy;
  as contact;
  private MMActivity gte;
  ImageView gyr;
  private ImageView hXw;
  private MMNeat7extView pIP;
  private boolean rFe;
  private TextView titleTv;
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27510);
    this.Bjy = false;
    this.Bdl = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.Bdm = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27510);
  }
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27511);
    this.Bjy = false;
    this.Bdl = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.Bdm = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27511);
  }
  
  public static void HN(long paramLong)
  {
    Bjx = paramLong;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void initView()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27513);
    if ((!this.rFe) || (this.contact == null))
    {
      Log.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
      AppMethodBeat.o(27513);
      return;
    }
    int i;
    Object localObject1;
    label125:
    Object localObject2;
    label443:
    Object localObject3;
    if ((ab.clc()) && (com.tencent.mm.contact.c.oR(this.contact.field_type)) && (this.contact.arE()) && (g.Nd(this.contact.field_username)))
    {
      i = 1;
      boolean bool2 = this.contact.gBN();
      if (i == 0) {
        break label904;
      }
      localObject1 = Util.nullAsNil(this.contact.field_nickname) + "*";
      localObject2 = localObject1;
      if (bool2) {
        localObject2 = (String)localObject1 + "*";
      }
      localObject1 = l.b(this.gte, (CharSequence)localObject2, this.titleTv.getTextSize());
      int k = ((SpannableString)localObject1).length() - 1;
      if (bool2)
      {
        int j = k;
        if (i != 0) {
          j = k - 1;
        }
        localObject2 = this.gte.getResources().getDrawable(2131233123);
        k = (int)(this.gte.getResources().getDisplayMetrics().density * 6.0F + 0.5F);
        int m = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 18);
        ((Drawable)localObject2).setBounds(k, 0, m + k, m);
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), j, j + 1, 17);
      }
      if (i != 0)
      {
        localObject2 = this.gte.getResources().getDrawable(2131231352);
        i = (int)(this.gte.getResources().getDisplayMetrics().density * 6.0F + 0.5F);
        ((Drawable)localObject2).setBounds(i, 0, ((Drawable)localObject2).getIntrinsicWidth() + i, ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), ((SpannableString)localObject1).length() - 1, ((SpannableString)localObject1).length(), 17);
      }
      this.titleTv.setText((CharSequence)localObject1);
      if (this.Bdk == null) {
        this.Bdk = g.fJ(this.contact.field_username);
      }
      if (this.Bdk != null) {
        this.Bdj = this.Bdk.field_brandIconURL;
      }
      this.gyr.setVisibility(0);
      if (System.currentTimeMillis() - Bjx >= 2000L) {
        break label919;
      }
      i = 1;
      localObject2 = this.gyr;
      localObject3 = this.contact;
      if (!this.Bjy) {
        break label924;
      }
      localObject1 = "";
      label467:
      if ((this.Bjy) || (i == 0)) {
        break label933;
      }
      label478:
      d.a((ImageView)localObject2, (as)localObject3, (String)localObject1, bool1);
      if (!this.Bjy) {
        break label939;
      }
      this.gyr.setClickable(false);
    }
    for (;;)
    {
      localObject2 = this.contact.signature;
      localObject1 = localObject2;
      if (Util.nullAsNil((String)localObject2).trim().length() <= 0) {
        localObject1 = this.gte.getString(2131757834);
      }
      localObject1 = l.c(this.gte, (CharSequence)localObject1);
      this.pIP.aw((CharSequence)localObject1);
      this.pIP.setVisibility(0);
      if ((this.Bdk == null) || (this.Bdk.cG(false) == null) || (this.Bdk.cG(false).Vb() == null) || (Util.isNullOrNil(this.Bdk.cG(false).Vb().diD)))
      {
        Log.i("MicroMsg.NewBizInfoHeaderPreference", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
        this.hXw.setVisibility(8);
      }
      this.pIP.setOnTouchListener(new h(this.pIP, new o())
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
      this.hXw.setImageDrawable(ar.m(this.mContext, 2131689782, this.gte.getResources().getColor(2131099665)));
      this.hXw.setOnTouchListener(new View.OnTouchListener()
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
      this.pIP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27507);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27507);
        }
      });
      this.hXw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27508);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27508);
        }
      });
      if (this.BiU.KWf != null)
      {
        localObject2 = this.BiU.KWf.KTb;
        localObject1 = this.BiU.KWf.KTc;
        this.Bjv.removeAllViews();
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject3 = (TextView)this.gte.getLayoutInflater().inflate(2131493756, this.Bjv, false);
          ((TextView)localObject3).setText((CharSequence)localObject2);
          this.Bjv.addView((View)localObject3);
        }
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = (TextView)this.gte.getLayoutInflater().inflate(2131493756, this.Bjv, false);
          ((TextView)localObject2).setText((CharSequence)localObject1);
          this.Bjv.addView((View)localObject2);
        }
      }
      this.Bjw.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(27509);
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int[] arrayOfInt = new int[2];
          NewBizInfoHeaderPreference.e(NewBizInfoHeaderPreference.this).getLocationOnScreen(arrayOfInt);
          int k = arrayOfInt[1];
          int j = com.tencent.mm.cb.a.aH(NewBizInfoHeaderPreference.this.mContext, 2131166843);
          int m = au.getStatusBarHeight(NewBizInfoHeaderPreference.this.mContext);
          int n = au.eu(NewBizInfoHeaderPreference.this.mContext);
          Log.i("MicroMsg.NewBizInfoHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
          int i = j;
          if (m > 0)
          {
            i = j;
            if (n > 0) {
              i = com.tencent.mm.cb.a.aH(NewBizInfoHeaderPreference.this.mContext, 2131165296) + n;
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
      localObject1 = Util.nullAsNil(this.contact.field_nickname);
      break label125;
      label919:
      i = 0;
      break label443;
      label924:
      localObject1 = this.Bdj;
      break label467;
      label933:
      bool1 = false;
      break label478;
      label939:
      this.gyr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27504);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this).field_username;
          paramAnonymousView = new Intent(NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this), ProfileHdHeadImg.class);
          paramAnonymousView.putExtra("username", (String)localObject);
          paramAnonymousView.putExtra("brand_icon_url", NewBizInfoHeaderPreference.c(NewBizInfoHeaderPreference.this));
          localObject = NewBizInfoHeaderPreference.b(NewBizInfoHeaderPreference.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27504);
        }
      });
    }
  }
  
  public final void Mr(String paramString)
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
  
  public final void a(as paramas, String paramString, com.tencent.mm.api.c paramc, ph paramph)
  {
    AppMethodBeat.i(27514);
    onDetach();
    this.Bdj = paramString;
    this.Bdk = paramc;
    this.contact = paramas;
    this.BiU = paramph;
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this.Bdm);
    p.aYn().d(this.Bdl);
    initView();
    AppMethodBeat.o(27514);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27512);
    this.gyr = ((ImageView)paramView.findViewById(2131297631));
    this.titleTv = ((TextView)paramView.findViewById(2131297635));
    this.pIP = ((MMNeat7extView)paramView.findViewById(2131297632));
    this.Bjv = ((FlexboxLayout)paramView.findViewById(2131297633));
    this.Bjw = ((ConstraintLayout)paramView.findViewById(2131297634));
    this.hXw = ((ImageView)paramView.findViewById(2131302879));
    this.rFe = true;
    initView();
    super.onBindView(paramView);
    this.Bju = paramView;
    AppMethodBeat.o(27512);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27515);
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this.Bdm);
    p.aYn().e(this.Bdl);
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
      bg.aVF();
      this.contact = com.tencent.mm.model.c.aSN().Kn(paramMStorageEx);
    }
    AppMethodBeat.o(27517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */