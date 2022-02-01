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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ejx;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class SnsDetailLuckyHeader
  extends LinearLayout
{
  private TextView JTe;
  private LinearLayout JTf;
  private LinearLayout JTg;
  private View oFW;
  
  public SnsDetailLuckyHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(95202);
    this.oFW = null;
    init();
    AppMethodBeat.o(95202);
  }
  
  public SnsDetailLuckyHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(95203);
    this.oFW = null;
    init();
    AppMethodBeat.o(95203);
  }
  
  public SnsDetailLuckyHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(95201);
    this.oFW = null;
    init();
    AppMethodBeat.o(95201);
  }
  
  private void init()
  {
    AppMethodBeat.i(95204);
    View localView = View.inflate(getContext(), i.g.lucky_sns_detail_header, this);
    this.oFW = localView.findViewById(i.f.album_list_hb_fatherview);
    this.JTe = ((TextView)localView.findViewById(i.f.album_hb_reward_tip));
    this.JTf = ((LinearLayout)localView.findViewById(i.f.album_hb_reward_users));
    this.JTg = getLinearSeparator();
    AppMethodBeat.o(95204);
  }
  
  public final void a(SnsInfo paramSnsInfo, c paramc)
  {
    AppMethodBeat.i(95207);
    Object localObject2 = an.D(paramSnsInfo);
    Object localObject1 = ((SnsObject)localObject2).SnsRedEnvelops;
    if ((localObject1 == null) || (((ekr)localObject1).Umz.size() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(95207);
      return;
    }
    setVisibility(0);
    double d = m.b(paramSnsInfo, (SnsObject)localObject2);
    localObject2 = getContext().getString(i.j.sns_lucky_reward_tip_info, new Object[] { Integer.valueOf(((SnsObject)localObject2).SnsRedEnvelops.Umy), Util.formatMoney2f(d * 1.0D / 100.0D) });
    this.JTe.setText((CharSequence)localObject2);
    this.oFW.setTag(paramSnsInfo);
    this.oFW.setOnClickListener(paramc.Lpb);
    paramSnsInfo = ((ekr)localObject1).Umz;
    boolean bool = ((ekr)localObject1).Umz.isEmpty();
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 32.0F);
    int m = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 6.0F);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 10.0F);
    int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 17.0F);
    int n;
    float f;
    if (this.JTf != null)
    {
      n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
      f = getResources().getDimension(i.d.NormalPadding);
      Log.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
      f = n - f * 2.0F;
      if (paramSnsInfo.size() > 0) {
        break label331;
      }
      if (this.JTf.getParent() != null) {
        this.JTf.setVisibility(8);
      }
      this.JTf.removeAllViews();
      this.JTf.setVisibility(8);
      paramSnsInfo = this.JTf;
      i = 8;
    }
    for (;;)
    {
      paramSnsInfo.setVisibility(i);
      AppMethodBeat.o(95207);
      return;
      label331:
      this.JTf.getParent();
      this.JTf.removeAllViews();
      this.JTf.setVisibility(0);
      this.JTf.setPadding(0, m, 0, m);
      localObject1 = new ImageView(getContext());
      ((ImageView)localObject1).setImageResource(i.i.friendactivity_luckymoney_icon);
      ((ImageView)localObject1).setPadding(i, j, i, 0);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 49;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setClickable(false);
      ((ImageView)localObject1).setFocusable(false);
      this.JTf.addView((View)localObject1);
      n = a.fromDPToPix(getContext(), SnsCommentDetailUI.KPk);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      Log.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramSnsInfo.size())
      {
        localObject2 = (ejx)paramSnsInfo.get(i);
        TouchImageView localTouchImageView = new TouchImageView(getContext());
        localTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localTouchImageView.setImageResource(i.e.friendactivity_personalportrait);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, k);
        localLayoutParams.setMargins(0, m, m, 0);
        localTouchImageView.setLayoutParams(localLayoutParams);
        localTouchImageView.setTag(((ejx)localObject2).Username);
        a.b.C(localTouchImageView, ((ejx)localObject2).Username);
        localTouchImageView.setOnClickListener(paramc.LoQ);
        ((h)localObject1).addView(localTouchImageView);
        i += 1;
      }
      this.JTf.addView((View)localObject1);
      paramSnsInfo = this.JTg;
      if (bool) {
        i = 8;
      } else {
        i = 0;
      }
    }
  }
  
  public LinearLayout getLinearSeparator()
  {
    AppMethodBeat.i(95205);
    BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 2.0F);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, 1);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setBackgroundResource(i.e.sns_divider_line);
    localLinearLayout.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(95205);
    return localLinearLayout;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(95206);
    super.setVisibility(paramInt);
    if (this.oFW != null) {
      this.oFW.setVisibility(paramInt);
    }
    AppMethodBeat.o(95206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader
 * JD-Core Version:    0.7.0.1
 */