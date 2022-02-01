package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FinderIconViewTipPreference
  extends NormalIconNewTipPreference
{
  ViewGroup VUN;
  View VUO;
  View VUP;
  View VUQ;
  View VUR;
  ImageView VUS;
  ImageView VUT;
  ImageView VUU;
  ImageView VUV;
  ImageView VUW;
  ImageView VUX;
  ImageView VUY;
  ArrayList<View> VUZ;
  ArrayList<ImageView> VVa;
  private boolean VVb;
  private erx VVc;
  private boolean VVd;
  private boolean VVe;
  private boolean VVf;
  private RelativeLayout VVg;
  private WeImageView VVh;
  private LinearLayout VVi;
  private RelativeLayout VVj;
  private LinearLayout.LayoutParams VVk;
  private LinearLayout.LayoutParams VVl;
  private LinearLayout.LayoutParams VVm;
  private LinearLayout.LayoutParams VVn;
  Context mContext;
  private int mStyle;
  TextView unP;
  TextView unQ;
  
  public FinderIconViewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FinderIconViewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(291001);
    this.mContext = paramContext;
    this.Wrx = true;
    setLayoutResource(R.i.finder_mm_preference);
    AppMethodBeat.o(291001);
  }
  
  private void Fo(boolean paramBoolean)
  {
    AppMethodBeat.i(291007);
    Log.i("FinderIconViewTipPreference", "changeContentLayoutParam :".concat(String.valueOf(paramBoolean)));
    ViewGroup localViewGroup;
    if (this.jac != null)
    {
      localViewGroup = (ViewGroup)this.jac.findViewById(a.g.content);
      if (!paramBoolean) {
        break label95;
      }
      localViewGroup.setLayoutParams(this.VVm);
      this.VVi.setLayoutParams(this.VVk);
      aJ(this.VVj, 8);
      aJ(this.VVh, 0);
    }
    for (;;)
    {
      this.VVj.requestLayout();
      AppMethodBeat.o(291007);
      return;
      label95:
      localViewGroup.setLayoutParams(this.VVn);
      this.VVi.setLayoutParams(this.VVl);
      aJ(this.VVj, 0);
      aJ(this.VUN, 0);
      aJ(this.VVh, 8);
      Log.i("FinderIconViewTipPreference", "changeContentLayoutParam mThirdLayoutContainer:" + this.VVj);
    }
  }
  
  private void a(erx paramerx, boolean paramBoolean)
  {
    AppMethodBeat.i(291014);
    if (paramBoolean)
    {
      this.unP.setMaxLines(2);
      int i = (int)(ay.au(this.unP.getContext()).x * 0.4D);
      this.unP.setMaxWidth(i);
    }
    for (;;)
    {
      aJ(this.unP, 0);
      aJ(this.VUX, 0);
      aJ(this.unQ, 8);
      aJ(this.VVg, 8);
      if (this.unP != null) {
        this.unP.setText(paramerx.title);
      }
      AppMethodBeat.o(291014);
      return;
      hGv();
    }
  }
  
  private void a(erx paramerx, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(291013);
    if ((this.VUT == null) || (this.VUP == null))
    {
      AppMethodBeat.o(291013);
      return;
    }
    aJ(this.VVg, 0);
    aJ(this.VUX, 8);
    Object localObject;
    float f;
    if (paramBoolean1)
    {
      localObject = this.VUT.getLayoutParams();
      f = this.VUT.getContext().getResources().getDimension(R.f.Edge_4A);
      ((ViewGroup.LayoutParams)localObject).width = ((int)f);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f);
      this.VUT.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (Util.isNullOrNil(paramerx.url)) {
        break label415;
      }
      Log.i("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", new Object[] { paramerx.url, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = t.ztT;
      localObject = t.dJi();
      e locale = new e(paramerx.url, u.AlP);
      ImageView localImageView = this.VUT;
      t localt = t.ztT;
      ((com.tencent.mm.loader.d)localObject).a(locale, localImageView, t.a(t.a.ztZ));
      label195:
      aJ(this.VUO, 8);
      aJ(this.VUP, 0);
      aJ(this.VUT, 0);
      aJ(this.VUW, 8);
      aJ(this.VUN, 0);
      if (!paramBoolean2) {
        break label486;
      }
      aJ(this.VUY, 0);
      if (paramBoolean4) {
        break label426;
      }
      localObject = this.VUY.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -2;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      this.VUY.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.VUY.setImageResource(R.g.unread_dot_shape);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramerx.title))
      {
        if (paramBoolean3)
        {
          aJ(this.unP, 8);
          aJ(this.unQ, 0);
          if (this.unQ == null) {
            break label566;
          }
          this.unQ.setText(paramerx.title);
          AppMethodBeat.o(291013);
          return;
          localObject = this.VUT.getLayoutParams();
          f = this.VUT.getContext().getResources().getDimension(R.f.Edge_2_5_A);
          ((ViewGroup.LayoutParams)localObject).width = ((int)f);
          ((ViewGroup.LayoutParams)localObject).height = ((int)f);
          this.VUT.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break;
          label415:
          Log.w("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] tipsInfo.url is null.");
          break label195;
          label426:
          localObject = this.VUW.getLayoutParams();
          int i = com.tencent.mm.view.d.e(this.VUW.getContext(), 11.1F);
          ((ViewGroup.LayoutParams)localObject).width = i;
          ((ViewGroup.LayoutParams)localObject).height = i;
          this.VUY.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.VUY.setImageResource(R.k.finder_live_icon);
          continue;
          label486:
          aJ(this.VUY, 8);
          continue;
        }
        aJ(this.unQ, 8);
        hGv();
        aJ(this.unP, 0);
        if (this.unP == null) {
          break label566;
        }
        this.unP.setText(paramerx.title);
        AppMethodBeat.o(291013);
        return;
      }
    }
    aJ(this.unQ, 8);
    aJ(this.unP, 8);
    label566:
    AppMethodBeat.o(291013);
  }
  
  private void a(boolean paramBoolean1, erx paramerx, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Boolean paramBoolean)
  {
    AppMethodBeat.i(291019);
    aak(8);
    auD(8);
    auG(8);
    abe(8);
    FT(false);
    if (paramBoolean1) {
      b(paramerx, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean.booleanValue());
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(291019);
      return;
      aJ(this.VUN, 8);
    }
  }
  
  private void a(boolean paramBoolean1, erx paramerx, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(291020);
    aak(8);
    auD(8);
    auG(8);
    abe(8);
    FT(false);
    if (paramBoolean1) {
      a(paramerx, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(291020);
      return;
      aJ(this.VUN, 8);
    }
  }
  
  private void aJ(View paramView, int paramInt)
  {
    AppMethodBeat.i(291009);
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
    if ((paramView != null) && (paramView == this.VUN) && (paramInt == 8)) {
      Fo(true);
    }
    AppMethodBeat.o(291009);
  }
  
  private boolean atH(int paramInt)
  {
    AppMethodBeat.i(291004);
    Log.i("FinderIconViewTipPreference", "initWidgetFrame mWidgetFrame:" + this.VUN);
    Object localObject = (ViewGroup)hKH();
    hGs();
    if (localObject == null)
    {
      Log.i("FinderIconViewTipPreference", "[initWidgetFrame] fail,WidgetFrame has child!");
      AppMethodBeat.o(291004);
      return false;
    }
    this.VUN = ((ViewGroup)localObject);
    if ((paramInt == 2) || (paramInt == 5) || (paramInt == 1) || (paramInt == 4) || (paramInt == 6) || (paramInt == 7))
    {
      localObject = this.VUN;
      ((ViewGroup)localObject).removeAllViews();
      localObject = View.inflate(this.mContext, R.i.eje, (ViewGroup)localObject);
      this.VUO = ((View)localObject).findViewById(R.h.friend_avatar_1_layout);
      this.VUP = ((View)localObject).findViewById(R.h.dHG);
      this.VUS = ((ImageView)((View)localObject).findViewById(R.h.friend_avatar_1));
      this.VUT = ((ImageView)((View)localObject).findViewById(R.h.dHI));
      this.VUW = ((ImageView)((View)localObject).findViewById(R.h.right_prospect));
      auH(8);
      this.VUY = ((ImageView)((View)localObject).findViewById(R.h.dSV));
      this.unQ = ((TextView)((View)localObject).findViewById(R.h.dSW));
      this.unP = ((TextView)((View)localObject).findViewById(R.h.dLe));
      this.VUX = ((ImageView)((View)localObject).findViewById(R.h.dPx));
      this.VVg = ((RelativeLayout)((View)localObject).findViewById(R.h.avatar_container));
    }
    for (;;)
    {
      AppMethodBeat.o(291004);
      return true;
      if (paramInt == 3)
      {
        localObject = this.VUN;
        ((ViewGroup)localObject).removeAllViews();
        localObject = View.inflate(this.mContext, R.i.ejd, (ViewGroup)localObject);
        this.VUO = ((View)localObject).findViewById(R.h.friend_avatar_1_layout);
        this.VUQ = ((View)localObject).findViewById(R.h.friend_avatar_2_layout);
        this.VUR = ((View)localObject).findViewById(R.h.friend_avatar_3_layout);
        this.VUZ = new ArrayList(3);
        this.VUZ.add(this.VUO);
        this.VUZ.add(this.VUQ);
        this.VUZ.add(this.VUR);
        this.VUS = ((ImageView)((View)localObject).findViewById(R.h.friend_avatar_1));
        this.VUU = ((ImageView)((View)localObject).findViewById(R.h.friend_avatar_2));
        this.VUV = ((ImageView)((View)localObject).findViewById(R.h.friend_avatar_3));
        this.VVa = new ArrayList(3);
        this.VVa.add(this.VUS);
        this.VVa.add(this.VUU);
        this.VVa.add(this.VUV);
        this.VUW = ((ImageView)((View)localObject).findViewById(R.h.right_prospect));
      }
    }
  }
  
  private void b(erx paramerx)
  {
    AppMethodBeat.i(291016);
    paramerx = paramerx.fmW;
    int i = paramerx.size();
    Log.i("FinderIconViewTipPreference", "url size = ".concat(String.valueOf(i)));
    int j = Math.min(i, 3);
    i = 0;
    for (;;)
    {
      int k;
      if (j > 0)
      {
        j -= 1;
        View localView = (View)this.VUZ.get(j);
        ImageView localImageView = (ImageView)this.VVa.get(j);
        Object localObject = t.ztT;
        localObject = t.dJh();
        k = i + 1;
        e locale = new e((String)paramerx.get(i), u.AlP);
        t localt = t.ztT;
        ((com.tencent.mm.loader.d)localObject).a(locale, localImageView, t.a(t.a.ztX));
        if (localView != null)
        {
          localView.setVisibility(0);
          i = k;
        }
      }
      else
      {
        AppMethodBeat.o(291016);
        return;
      }
      i = k;
    }
  }
  
  private void b(erx paramerx, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(291015);
    if ((this.VUS == null) || (this.VUO == null))
    {
      AppMethodBeat.o(291015);
      return;
    }
    aJ(this.VVg, 0);
    aJ(this.VUX, 8);
    Object localObject;
    float f;
    if (paramBoolean1)
    {
      localObject = this.VUS.getLayoutParams();
      f = this.VUS.getContext().getResources().getDimension(R.f.Edge_4A);
      ((ViewGroup.LayoutParams)localObject).width = ((int)f);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f);
      this.VUS.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (Util.isNullOrNil(paramerx.url)) {
        break label419;
      }
      Log.i("FinderIconViewTipPreference", "[bindSingleAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", new Object[] { paramerx.url, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = t.ztT;
      localObject = t.dJh();
      e locale = new e(paramerx.url, u.AlP);
      ImageView localImageView = this.VUS;
      t localt = t.ztT;
      ((com.tencent.mm.loader.d)localObject).a(locale, localImageView, t.a(t.a.ztX));
      label197:
      aJ(this.VUO, 0);
      aJ(this.VUP, 8);
      aJ(this.VUT, 8);
      aJ(this.VUY, 8);
      aJ(this.VUN, 0);
      if (!paramBoolean2) {
        break label490;
      }
      aJ(this.VUW, 0);
      if (paramBoolean4) {
        break label430;
      }
      localObject = this.VUW.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -2;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      this.VUW.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.VUW.setImageResource(R.g.unread_dot_shape);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramerx.title))
      {
        if (paramBoolean3)
        {
          aJ(this.unP, 8);
          aJ(this.unQ, 0);
          if (this.unQ == null) {
            break label571;
          }
          this.unQ.setText(paramerx.title);
          AppMethodBeat.o(291015);
          return;
          localObject = this.VUS.getLayoutParams();
          f = this.VUS.getContext().getResources().getDimension(R.f.Edge_2_5_A);
          ((ViewGroup.LayoutParams)localObject).width = ((int)f);
          ((ViewGroup.LayoutParams)localObject).height = ((int)f);
          this.VUS.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break;
          label419:
          Log.w("FinderIconViewTipPreference", "[bindSingleAvatarTask] tipsInfo.url is null.");
          break label197;
          label430:
          localObject = this.VUW.getLayoutParams();
          int i = com.tencent.mm.view.d.e(this.VUW.getContext(), 11.1F);
          ((ViewGroup.LayoutParams)localObject).width = i;
          ((ViewGroup.LayoutParams)localObject).height = i;
          this.VUW.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.VUW.setImageResource(R.k.finder_live_icon);
          continue;
          label490:
          aJ(this.VUW, 8);
          continue;
        }
        aJ(this.unQ, 8);
        hGv();
        aJ(this.unP, 0);
        if (this.unP == null) {
          break label571;
        }
        this.unP.setText(paramerx.title);
        AppMethodBeat.o(291015);
        return;
      }
    }
    aJ(this.unQ, 8);
    aJ(this.unP, 8);
    label571:
    AppMethodBeat.o(291015);
  }
  
  private void e(boolean paramBoolean, erx paramerx)
  {
    AppMethodBeat.i(291021);
    aak(8);
    auD(8);
    auG(8);
    abe(8);
    FT(false);
    if (paramBoolean) {
      a(paramerx, false);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(291021);
      return;
      aJ(this.VUN, 8);
    }
  }
  
  private void f(boolean paramBoolean, erx paramerx)
  {
    AppMethodBeat.i(291022);
    aak(8);
    auD(8);
    auG(8);
    abe(8);
    FT(false);
    if (paramBoolean) {
      a(paramerx, true);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(291022);
      return;
      aJ(this.VUN, 8);
    }
  }
  
  private void g(boolean paramBoolean, erx paramerx)
  {
    AppMethodBeat.i(291024);
    Log.d("FinderIconViewTipPreference", "bindAvatars() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if ((paramerx != null) && (paramerx.fmW != null) && (paramerx.fmW.size() > 0) && (hGu()))
      {
        aak(8);
        auG(8);
        auF(8);
        auH(8);
        FT(false);
        hGt();
        b(paramerx);
        aJ(this.VUW, 0);
        aJ(this.VUN, 0);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(291024);
      return;
      aak(8);
      auD(8);
      auG(8);
      abe(8);
      aJ(this.VUN, 8);
    }
  }
  
  private void hGs()
  {
    AppMethodBeat.i(291006);
    Log.i("FinderIconViewTipPreference", "initContentLayoutParam mThirdLayoutContainer：" + this.VVj);
    if (this.jac != null)
    {
      if (this.VVm == null) {
        this.VVm = ((LinearLayout.LayoutParams)((ViewGroup)this.jac.findViewById(a.g.content)).getLayoutParams());
      }
      if (this.VVn == null) {
        this.VVn = new LinearLayout.LayoutParams(-2, this.VVm.height, 0.0F);
      }
      if (this.VVk == null) {
        this.VVk = ((LinearLayout.LayoutParams)this.VVi.getLayoutParams());
      }
      if (this.VVl == null) {
        this.VVl = new LinearLayout.LayoutParams(-1, -1, 0.0F);
      }
    }
    AppMethodBeat.o(291006);
  }
  
  private void hGt()
  {
    AppMethodBeat.i(291011);
    if (this.VUZ == null)
    {
      AppMethodBeat.o(291011);
      return;
    }
    int j = this.VUZ.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.VUZ.get(i);
      if ((localView != null) && (localView.getVisibility() == 0)) {
        localView.setVisibility(8);
      }
      i += 1;
    }
    AppMethodBeat.o(291011);
  }
  
  private boolean hGu()
  {
    AppMethodBeat.i(291012);
    if ((this.VUZ == null) || (this.VVa == null))
    {
      Log.i("FinderIconViewTipPreference", "friend avatar is null");
      AppMethodBeat.o(291012);
      return false;
    }
    int i = this.VUZ.size();
    int j = this.VVa.size();
    if ((i != 3) || (i != j))
    {
      Log.i("FinderIconViewTipPreference", "friend avatar size illegal");
      AppMethodBeat.o(291012);
      return false;
    }
    AppMethodBeat.o(291012);
    return true;
  }
  
  private void hGv()
  {
    AppMethodBeat.i(291023);
    this.unP.setMaxLines(1);
    AppMethodBeat.o(291023);
  }
  
  private void hGw()
  {
    AppMethodBeat.i(291031);
    aJ(this.VUN, 8);
    AppMethodBeat.o(291031);
  }
  
  public final void a(boolean paramBoolean1, erx paramerx, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(291008);
    Log.i("FinderIconViewTipPreference", "[showFinderAvatars] show=%s title=%s url=%s style=%s withRedDot=%s isRightTitle=%s isLiveRedDot=%s mThirdLayoutContainer:%s", new Object[] { Boolean.valueOf(paramBoolean1), paramerx.title, paramerx.url, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4), this.VVj });
    if (!atH(paramInt))
    {
      Log.w("FinderIconViewTipPreference", "showFinderAvatars return for initWidgetFrame");
      AppMethodBeat.o(291008);
      return;
    }
    if (paramInt == 1)
    {
      Fo(false);
      a(paramBoolean1, paramerx, false, paramBoolean2, paramBoolean3, Boolean.valueOf(paramBoolean4));
    }
    for (;;)
    {
      if (!paramBoolean2)
      {
        aJ(this.VUW, 8);
        auH(8);
      }
      this.VVb = paramBoolean1;
      this.VVc = paramerx;
      this.mStyle = paramInt;
      this.VVd = paramBoolean2;
      this.VVe = paramBoolean3;
      this.VVf = paramBoolean4;
      AppMethodBeat.o(291008);
      return;
      if (paramInt == 2)
      {
        Fo(false);
        a(paramBoolean1, paramerx, false, paramBoolean2, paramBoolean3, paramBoolean4);
      }
      else if (paramInt == 4)
      {
        Fo(false);
        a(paramBoolean1, paramerx, true, paramBoolean2, paramBoolean3, Boolean.valueOf(paramBoolean4));
      }
      else if (paramInt == 5)
      {
        Fo(false);
        a(paramBoolean1, paramerx, true, paramBoolean2, paramBoolean3, paramBoolean4);
      }
      else if (paramInt == 3)
      {
        Fo(false);
        g(paramBoolean1, paramerx);
      }
      else if (paramInt == 6)
      {
        Fo(false);
        e(paramBoolean1, paramerx);
      }
      else if (paramInt == 7)
      {
        Fo(false);
        f(paramBoolean1, paramerx);
      }
    }
  }
  
  public final boolean a(boolean paramBoolean, erx paramerx)
  {
    AppMethodBeat.i(291026);
    hGw();
    this.mStyle = 8;
    paramBoolean = super.a(paramBoolean, paramerx);
    AppMethodBeat.o(291026);
    return paramBoolean;
  }
  
  public final boolean d(boolean paramBoolean, erx paramerx)
  {
    AppMethodBeat.i(291028);
    hGw();
    Log.d("FinderIconViewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      abe(0);
      String str = paramerx.num;
      if (paramerx.num > 999) {
        str = "· · ·";
      }
      hH(str, w.bj(this.mContext, paramerx.num));
    }
    for (;;)
    {
      this.VVb = paramBoolean;
      this.mStyle = 9;
      this.VVc = paramerx;
      notifyDataSetChanged();
      AppMethodBeat.o(291028);
      return true;
      aak(8);
      auD(8);
      auG(8);
      abe(8);
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(291003);
    super.onBindView(paramView);
    Log.i("FinderIconViewTipPreference", "onBindView title:" + getTitle() + " hashCode:" + hashCode() + " view:" + paramView);
    this.jac = paramView;
    if (this.jac != null)
    {
      this.VVh = ((WeImageView)this.jac.findViewById(R.h.right_arrow_only));
      this.VVi = ((LinearLayout)this.jac.findViewById(R.h.second_level_container));
      this.VVj = ((RelativeLayout)this.jac.findViewById(R.h.third_level_container));
      hGs();
      Log.i("FinderIconViewTipPreference", "onBindView mStyle:" + this.mStyle + " mTipsInfo:" + this.VVc);
      if (this.VVc != null)
      {
        if (this.mStyle == 9)
        {
          d(this.VVb, this.VVc);
          AppMethodBeat.o(291003);
          return;
        }
        if ((this.mStyle > 0) && (this.mStyle <= 7)) {
          a(this.VVb, this.VVc, this.mStyle, this.VVd, this.VVe, this.VVf);
        }
      }
    }
    AppMethodBeat.o(291003);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(291002);
    paramViewGroup = super.onCreateView(paramViewGroup);
    Log.i("FinderIconViewTipPreference", "onCreateView title:" + getTitle() + " hashCode:" + hashCode() + " view:" + paramViewGroup);
    AppMethodBeat.o(291002);
    return paramViewGroup;
  }
  
  public final boolean tY(boolean paramBoolean)
  {
    AppMethodBeat.i(291025);
    if (paramBoolean) {
      hGw();
    }
    for (;;)
    {
      this.mStyle = 8;
      paramBoolean = super.tY(paramBoolean);
      AppMethodBeat.o(291025);
      return paramBoolean;
      Fo(true);
    }
  }
  
  public final boolean tZ(boolean paramBoolean)
  {
    AppMethodBeat.i(291030);
    hGw();
    this.mStyle = 8;
    paramBoolean = super.tZ(paramBoolean);
    AppMethodBeat.o(291030);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FinderIconViewTipPreference
 * JD-Core Version:    0.7.0.1
 */