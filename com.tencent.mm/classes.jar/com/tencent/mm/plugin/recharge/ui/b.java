package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  ArrayList<q> pVI;
  b.a pVJ;
  private List<String> pVK;
  
  public b()
  {
    AppMethodBeat.i(44248);
    this.pVI = null;
    this.pVJ = null;
    this.pVK = new ArrayList(bo.ih((String)g.RL().Ru().get(ac.a.yKI, ""), ","));
    AppMethodBeat.o(44248);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44249);
    if (this.pVI == null)
    {
      AppMethodBeat.o(44249);
      return 0;
    }
    int i = this.pVI.size();
    AppMethodBeat.o(44249);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(44250);
    Object localObject = this.pVI.get(paramInt);
    AppMethodBeat.o(44250);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44251);
    q localq = (q)getItem(paramInt);
    b localb;
    if (paramView == null)
    {
      paramView = w.hM(paramViewGroup.getContext()).inflate(2130970535, paramViewGroup, false);
      localb = new b((byte)0);
      localb.hsI = ((TextView)paramView.findViewById(2131821115));
      localb.gve = ((TextView)paramView.findViewById(2131820737));
      localb.pVO = ((TextView)paramView.findViewById(2131827095));
      localb.pVP = ((ImageView)paramView.findViewById(2131827094));
      paramView.setTag(localb);
      localb.gve.setText(localq.name);
      if (bo.isNullOrNil(localq.desc)) {
        break label647;
      }
      localb.hsI.setVisibility(0);
      localb.hsI.setText(localq.desc);
      label153:
      if (bo.isNullOrNil(localq.tUF)) {
        break label660;
      }
      localb.pVO.setVisibility(0);
      localb.pVO.setText(localq.tUF);
      label186:
      if (localq.status != 1) {
        break label673;
      }
      paramView.setEnabled(true);
      localb.hsI.setEnabled(true);
      localb.gve.setEnabled(true);
    }
    for (;;)
    {
      if ((localq.tUJ == 1) && (!this.pVK.contains(localq.tUK)))
      {
        ab.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", new Object[] { localq.tUK });
        localb.pVP.setVisibility(0);
      }
      if ((localq.type == 1) && (localq.tUG.equals("1")) && (!localq.tUH.equals("0")))
      {
        Object localObject1 = paramViewGroup.getContext();
        paramInt = Color.parseColor(localq.tUH);
        Object localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject2).setColor(paramInt);
        GradientDrawable localGradientDrawable1 = new GradientDrawable();
        localGradientDrawable1.setShape(0);
        localGradientDrawable1.setCornerRadius(a.fromDPToPix((Context)localObject1, 2));
        localGradientDrawable1.setStroke(2, a.m((Context)localObject1, 2131690383));
        GradientDrawable localGradientDrawable2 = new GradientDrawable();
        localGradientDrawable2.setShape(0);
        localGradientDrawable2.setCornerRadius(a.fromDPToPix((Context)localObject1, 2));
        localGradientDrawable2.setColor(a.m((Context)localObject1, 2131690381));
        localGradientDrawable2.setStroke(2, paramInt);
        localObject1 = new StateListDrawable();
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        ((StateListDrawable)localObject1).addState(new int[] { -16842910 }, localGradientDrawable1);
        ((StateListDrawable)localObject1).addState(new int[0], localGradientDrawable2);
        paramViewGroup = paramViewGroup.getContext();
        paramInt = Color.parseColor(localq.tUH);
        localObject2 = new int[] { 16842919 };
        int i = a.m(paramViewGroup, 2131690709);
        int j = a.m(paramViewGroup, 2131690379);
        paramViewGroup = new ColorStateList(new int[][] { localObject2, { -16842910 }, new int[0] }, new int[] { i, j, paramInt });
        localb.hsI.setTextColor(paramViewGroup);
        localb.gve.setTextColor(paramViewGroup);
        paramView.setBackground((Drawable)localObject1);
      }
      paramView.setOnClickListener(new b.1(this, localq, localb));
      AppMethodBeat.o(44251);
      return paramView;
      localb = (b)paramView.getTag();
      break;
      label647:
      localb.hsI.setVisibility(8);
      break label153;
      label660:
      localb.pVO.setVisibility(8);
      break label186;
      label673:
      paramView.setEnabled(false);
      localb.hsI.setEnabled(false);
      localb.gve.setEnabled(false);
    }
  }
  
  final class b
  {
    TextView gve;
    TextView hsI;
    TextView pVO;
    ImageView pVP;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b
 * JD-Core Version:    0.7.0.1
 */