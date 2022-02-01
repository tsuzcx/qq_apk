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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public class SnsDetailLuckyHeader
  extends LinearLayout
{
  private View kFh;
  private TextView zvV;
  private LinearLayout zvW;
  private LinearLayout zvX;
  
  public SnsDetailLuckyHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(95202);
    this.kFh = null;
    init();
    AppMethodBeat.o(95202);
  }
  
  public SnsDetailLuckyHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(95203);
    this.kFh = null;
    init();
    AppMethodBeat.o(95203);
  }
  
  public SnsDetailLuckyHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(95201);
    this.kFh = null;
    init();
    AppMethodBeat.o(95201);
  }
  
  private void init()
  {
    AppMethodBeat.i(95204);
    View localView = View.inflate(getContext(), 2131494668, this);
    this.kFh = localView.findViewById(2131296591);
    this.zvV = ((TextView)localView.findViewById(2131296573));
    this.zvW = ((LinearLayout)localView.findViewById(2131296574));
    this.zvX = getLinearSeparator();
    AppMethodBeat.o(95204);
  }
  
  public final void a(p paramp, c paramc)
  {
    AppMethodBeat.i(95207);
    Object localObject2 = al.v(paramp);
    Object localObject1 = ((SnsObject)localObject2).SnsRedEnvelops;
    if ((localObject1 == null) || (((dhi)localObject1).HOu.size() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(95207);
      return;
    }
    setVisibility(0);
    double d = m.b(paramp, (SnsObject)localObject2);
    localObject2 = getContext().getString(2131763903, new Object[] { Integer.valueOf(((SnsObject)localObject2).SnsRedEnvelops.HOt), bu.C(d * 1.0D / 100.0D) });
    this.zvV.setText((CharSequence)localObject2);
    this.kFh.setTag(paramp);
    this.kFh.setOnClickListener(paramc.APY);
    paramp = ((dhi)localObject1).HOu;
    boolean bool = ((dhi)localObject1).HOu.isEmpty();
    int k = BackwardSupportUtil.b.h(getContext(), 32.0F);
    int m = BackwardSupportUtil.b.h(getContext(), 6.0F);
    int i = BackwardSupportUtil.b.h(getContext(), 10.0F);
    int j = BackwardSupportUtil.b.h(getContext(), 17.0F);
    int n;
    float f;
    if (this.zvW != null)
    {
      n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
      f = getResources().getDimension(2131165516);
      ae.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
      f = n - f * 2.0F;
      if (paramp.size() > 0) {
        break label329;
      }
      if (this.zvW.getParent() != null) {
        this.zvW.setVisibility(8);
      }
      this.zvW.removeAllViews();
      this.zvW.setVisibility(8);
      paramp = this.zvW;
      i = 8;
    }
    for (;;)
    {
      paramp.setVisibility(i);
      AppMethodBeat.o(95207);
      return;
      label329:
      this.zvW.getParent();
      this.zvW.removeAllViews();
      this.zvW.setVisibility(0);
      this.zvW.setPadding(0, m, 0, m);
      localObject1 = new ImageView(getContext());
      ((ImageView)localObject1).setImageResource(2131690249);
      ((ImageView)localObject1).setPadding(i, j, i, 0);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 49;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setClickable(false);
      ((ImageView)localObject1).setFocusable(false);
      this.zvW.addView((View)localObject1);
      n = a.fromDPToPix(getContext(), SnsCommentDetailUI.Asn);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      ae.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramp.size())
      {
        localObject2 = (dgq)paramp.get(i);
        TouchImageView localTouchImageView = new TouchImageView(getContext());
        localTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localTouchImageView.setImageResource(2131232455);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, k);
        localLayoutParams.setMargins(0, m, m, 0);
        localTouchImageView.setLayoutParams(localLayoutParams);
        localTouchImageView.setTag(((dgq)localObject2).Username);
        a.b.w(localTouchImageView, ((dgq)localObject2).Username);
        localTouchImageView.setOnClickListener(paramc.APM);
        ((h)localObject1).addView(localTouchImageView);
        i += 1;
      }
      this.zvW.addView((View)localObject1);
      paramp = this.zvX;
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
    BackwardSupportUtil.b.h(getContext(), 2.0F);
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
    if (this.kFh != null) {
      this.kFh.setVisibility(paramInt);
    }
    AppMethodBeat.o(95206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader
 * JD-Core Version:    0.7.0.1
 */