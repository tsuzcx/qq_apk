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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class SnsDetailLuckyHeader
  extends LinearLayout
{
  private View kBS;
  private TextView zfg;
  private LinearLayout zfh;
  private LinearLayout zfi;
  
  public SnsDetailLuckyHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(95202);
    this.kBS = null;
    init();
    AppMethodBeat.o(95202);
  }
  
  public SnsDetailLuckyHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(95203);
    this.kBS = null;
    init();
    AppMethodBeat.o(95203);
  }
  
  public SnsDetailLuckyHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(95201);
    this.kBS = null;
    init();
    AppMethodBeat.o(95201);
  }
  
  private void init()
  {
    AppMethodBeat.i(95204);
    View localView = View.inflate(getContext(), 2131494668, this);
    this.kBS = localView.findViewById(2131296591);
    this.zfg = ((TextView)localView.findViewById(2131296573));
    this.zfh = ((LinearLayout)localView.findViewById(2131296574));
    this.zfi = getLinearSeparator();
    AppMethodBeat.o(95204);
  }
  
  public final void a(p paramp, c paramc)
  {
    AppMethodBeat.i(95207);
    Object localObject2 = ak.v(paramp);
    Object localObject1 = ((SnsObject)localObject2).SnsRedEnvelops;
    if ((localObject1 == null) || (((dgo)localObject1).HuR.size() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(95207);
      return;
    }
    setVisibility(0);
    double d = m.b(paramp, (SnsObject)localObject2);
    localObject2 = getContext().getString(2131763903, new Object[] { Integer.valueOf(((SnsObject)localObject2).SnsRedEnvelops.HuQ), bt.C(d * 1.0D / 100.0D) });
    this.zfg.setText((CharSequence)localObject2);
    this.kBS.setTag(paramp);
    this.kBS.setOnClickListener(paramc.AyC);
    paramp = ((dgo)localObject1).HuR;
    boolean bool = ((dgo)localObject1).HuR.isEmpty();
    int k = BackwardSupportUtil.b.g(getContext(), 32.0F);
    int m = BackwardSupportUtil.b.g(getContext(), 6.0F);
    int i = BackwardSupportUtil.b.g(getContext(), 10.0F);
    int j = BackwardSupportUtil.b.g(getContext(), 17.0F);
    int n;
    float f;
    if (this.zfh != null)
    {
      n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
      f = getResources().getDimension(2131165516);
      ad.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
      f = n - f * 2.0F;
      if (paramp.size() > 0) {
        break label329;
      }
      if (this.zfh.getParent() != null) {
        this.zfh.setVisibility(8);
      }
      this.zfh.removeAllViews();
      this.zfh.setVisibility(8);
      paramp = this.zfh;
      i = 8;
    }
    for (;;)
    {
      paramp.setVisibility(i);
      AppMethodBeat.o(95207);
      return;
      label329:
      this.zfh.getParent();
      this.zfh.removeAllViews();
      this.zfh.setVisibility(0);
      this.zfh.setPadding(0, m, 0, m);
      localObject1 = new ImageView(getContext());
      ((ImageView)localObject1).setImageResource(2131690249);
      ((ImageView)localObject1).setPadding(i, j, i, 0);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 49;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setClickable(false);
      ((ImageView)localObject1).setFocusable(false);
      this.zfh.addView((View)localObject1);
      n = a.fromDPToPix(getContext(), SnsCommentDetailUI.Aba);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      ad.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramp.size())
      {
        localObject2 = (dfw)paramp.get(i);
        TouchImageView localTouchImageView = new TouchImageView(getContext());
        localTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localTouchImageView.setImageResource(2131232455);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, k);
        localLayoutParams.setMargins(0, m, m, 0);
        localTouchImageView.setLayoutParams(localLayoutParams);
        localTouchImageView.setTag(((dfw)localObject2).Username);
        a.b.w(localTouchImageView, ((dfw)localObject2).Username);
        localTouchImageView.setOnClickListener(paramc.Ayr);
        ((h)localObject1).addView(localTouchImageView);
        i += 1;
      }
      this.zfh.addView((View)localObject1);
      paramp = this.zfi;
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
    BackwardSupportUtil.b.g(getContext(), 2.0F);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, 1);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setBackgroundResource(2131234115);
    localLinearLayout.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(95205);
    return localLinearLayout;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(95206);
    super.setVisibility(paramInt);
    if (this.kBS != null) {
      this.kBS.setVisibility(paramInt);
    }
    AppMethodBeat.o(95206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader
 * JD-Core Version:    0.7.0.1
 */