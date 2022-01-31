package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.btk;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public class SnsDetailLuckyHeader
  extends LinearLayout
{
  private View jdj = null;
  private TextView ook;
  private LinearLayout ool;
  private LinearLayout oom;
  
  public SnsDetailLuckyHeader(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SnsDetailLuckyHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SnsDetailLuckyHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    View localView = View.inflate(getContext(), i.g.lucky_sns_detail_header, this);
    this.jdj = localView.findViewById(i.f.album_list_hb_fatherview);
    this.ook = ((TextView)localView.findViewById(i.f.album_hb_reward_tip));
    this.ool = ((LinearLayout)localView.findViewById(i.f.album_hb_reward_users));
    this.oom = getLinearSeparator();
  }
  
  public final void a(n paramn, b paramb)
  {
    Object localObject2 = aj.q(paramn);
    Object localObject1 = ((bto)localObject2).tKm;
    if ((localObject1 == null) || (((bud)localObject1).tKP.size() == 0)) {
      setVisibility(8);
    }
    boolean bool;
    int k;
    int m;
    int i;
    int j;
    do
    {
      return;
      setVisibility(0);
      double d = m.b(paramn, (bto)localObject2);
      localObject2 = getContext().getString(i.j.sns_lucky_reward_tip_info, new Object[] { Integer.valueOf(((bto)localObject2).tKm.tKO), bk.A(d * 1.0D / 100.0D) });
      this.ook.setText((CharSequence)localObject2);
      this.jdj.setTag(paramn);
      this.jdj.setOnClickListener(paramb.poL);
      paramn = ((bud)localObject1).tKP;
      bool = ((bud)localObject1).tKP.isEmpty();
      k = BackwardSupportUtil.b.b(getContext(), 32.0F);
      m = BackwardSupportUtil.b.b(getContext(), 6.0F);
      i = BackwardSupportUtil.b.b(getContext(), 10.0F);
      j = BackwardSupportUtil.b.b(getContext(), 17.0F);
    } while (this.ool == null);
    int n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    float f = getResources().getDimension(i.d.NormalPadding);
    y.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
    f = n - f * 2.0F;
    if (paramn.size() <= 0)
    {
      if (this.ool.getParent() != null) {
        this.ool.setVisibility(8);
      }
      this.ool.removeAllViews();
      this.ool.setVisibility(8);
      paramn = this.ool;
      i = 8;
    }
    for (;;)
    {
      paramn.setVisibility(i);
      return;
      this.ool.getParent();
      this.ool.removeAllViews();
      this.ool.setVisibility(0);
      this.ool.setPadding(0, m, 0, m);
      localObject1 = new ImageView(getContext());
      ((ImageView)localObject1).setImageResource(i.i.friendactivity_luckymoney_icon);
      ((ImageView)localObject1).setPadding(i, j, i, 0);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 49;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setClickable(false);
      ((ImageView)localObject1).setFocusable(false);
      this.ool.addView((View)localObject1);
      n = a.fromDPToPix(getContext(), SnsCommentDetailUI.oWt);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      y.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramn.size())
      {
        localObject2 = (btk)paramn.get(i);
        TouchImageView localTouchImageView = new TouchImageView(getContext());
        localTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localTouchImageView.setImageResource(i.e.friendactivity_personalportrait);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, k);
        localLayoutParams.setMargins(0, m, m, 0);
        localTouchImageView.setLayoutParams(localLayoutParams);
        localTouchImageView.setTag(((btk)localObject2).sxM);
        a.b.p(localTouchImageView, ((btk)localObject2).sxM);
        localTouchImageView.setOnClickListener(paramb.poA);
        ((h)localObject1).addView(localTouchImageView);
        i += 1;
      }
      this.ool.addView((View)localObject1);
      paramn = this.oom;
      if (bool) {
        i = 8;
      } else {
        i = 0;
      }
    }
  }
  
  public LinearLayout getLinearSeparator()
  {
    BackwardSupportUtil.b.b(getContext(), 2.0F);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, 1);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setBackgroundResource(i.e.sns_divider_line);
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.jdj != null) {
      this.jdj.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader
 * JD-Core Version:    0.7.0.1
 */