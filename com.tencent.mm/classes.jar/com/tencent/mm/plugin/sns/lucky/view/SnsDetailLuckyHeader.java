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
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class SnsDetailLuckyHeader
  extends LinearLayout
{
  private View iDS;
  private TextView rcB;
  private LinearLayout rcC;
  private LinearLayout rcD;
  
  public SnsDetailLuckyHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(35905);
    this.iDS = null;
    init();
    AppMethodBeat.o(35905);
  }
  
  public SnsDetailLuckyHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(35906);
    this.iDS = null;
    init();
    AppMethodBeat.o(35906);
  }
  
  public SnsDetailLuckyHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(35904);
    this.iDS = null;
    init();
    AppMethodBeat.o(35904);
  }
  
  private void init()
  {
    AppMethodBeat.i(35907);
    View localView = View.inflate(getContext(), 2130970054, this);
    this.iDS = localView.findViewById(2131825846);
    this.rcB = ((TextView)localView.findViewById(2131825847));
    this.rcC = ((LinearLayout)localView.findViewById(2131825849));
    this.rcD = getLinearSeparator();
    AppMethodBeat.o(35907);
  }
  
  public final void a(n paramn, b paramb)
  {
    AppMethodBeat.i(35910);
    Object localObject2 = ak.q(paramn);
    Object localObject1 = ((SnsObject)localObject2).SnsRedEnvelops;
    if ((localObject1 == null) || (((ces)localObject1).xPe.size() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(35910);
      return;
    }
    setVisibility(0);
    double d = m.b(paramn, (SnsObject)localObject2);
    localObject2 = getContext().getString(2131303892, new Object[] { Integer.valueOf(((SnsObject)localObject2).SnsRedEnvelops.xPd), bo.E(d * 1.0D / 100.0D) });
    this.rcB.setText((CharSequence)localObject2);
    this.iDS.setTag(paramn);
    this.iDS.setOnClickListener(paramb.sjD);
    paramn = ((ces)localObject1).xPe;
    boolean bool = ((ces)localObject1).xPe.isEmpty();
    int k = BackwardSupportUtil.b.b(getContext(), 32.0F);
    int m = BackwardSupportUtil.b.b(getContext(), 6.0F);
    int i = BackwardSupportUtil.b.b(getContext(), 10.0F);
    int j = BackwardSupportUtil.b.b(getContext(), 17.0F);
    int n;
    float f;
    if (this.rcC != null)
    {
      n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
      f = getResources().getDimension(2131427808);
      ab.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
      f = n - f * 2.0F;
      if (paramn.size() > 0) {
        break label329;
      }
      if (this.rcC.getParent() != null) {
        this.rcC.setVisibility(8);
      }
      this.rcC.removeAllViews();
      this.rcC.setVisibility(8);
      paramn = this.rcC;
      i = 8;
    }
    for (;;)
    {
      paramn.setVisibility(i);
      AppMethodBeat.o(35910);
      return;
      label329:
      this.rcC.getParent();
      this.rcC.removeAllViews();
      this.rcC.setVisibility(0);
      this.rcC.setPadding(0, m, 0, m);
      localObject1 = new ImageView(getContext());
      ((ImageView)localObject1).setImageResource(2131231367);
      ((ImageView)localObject1).setPadding(i, j, i, 0);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 49;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setClickable(false);
      ((ImageView)localObject1).setFocusable(false);
      this.rcC.addView((View)localObject1);
      n = a.fromDPToPix(getContext(), SnsCommentDetailUI.rOR);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      ab.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramn.size())
      {
        localObject2 = (cea)paramn.get(i);
        TouchImageView localTouchImageView = new TouchImageView(getContext());
        localTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localTouchImageView.setImageResource(2130838917);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, k);
        localLayoutParams.setMargins(0, m, m, 0);
        localTouchImageView.setLayoutParams(localLayoutParams);
        localTouchImageView.setTag(((cea)localObject2).Username);
        a.b.u(localTouchImageView, ((cea)localObject2).Username);
        localTouchImageView.setOnClickListener(paramb.sjs);
        ((h)localObject1).addView(localTouchImageView);
        i += 1;
      }
      this.rcC.addView((View)localObject1);
      paramn = this.rcD;
      if (bool) {
        i = 8;
      } else {
        i = 0;
      }
    }
  }
  
  public LinearLayout getLinearSeparator()
  {
    AppMethodBeat.i(35908);
    BackwardSupportUtil.b.b(getContext(), 2.0F);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, 1);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setBackgroundResource(2130840395);
    localLinearLayout.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(35908);
    return localLinearLayout;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(35909);
    super.setVisibility(paramInt);
    if (this.iDS != null) {
      this.iDS.setVisibility(paramInt);
    }
    AppMethodBeat.o(35909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader
 * JD-Core Version:    0.7.0.1
 */