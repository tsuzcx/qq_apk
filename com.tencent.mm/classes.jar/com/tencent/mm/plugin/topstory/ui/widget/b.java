package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
  extends i
{
  private View contentView;
  private Set<adl> tmq;
  private View tmr;
  private View tms;
  private TextView tmt;
  private FlowLayout tmu;
  private final adl tmv;
  
  public b(Context paramContext, List<adl> paramList, b.a parama)
  {
    super(paramContext, 2131493694);
    AppMethodBeat.i(2230);
    this.tmq = new HashSet();
    this.tmv = new adl();
    this.tmv.id = "101";
    this.tmv.cyA = paramContext.getString(2131304331);
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (adl)((Iterator)localObject1).next();
      if (((adl)localObject2).wWx)
      {
        this.tmv.id = ((adl)localObject2).id;
        this.tmv.cyA = ((adl)localObject2).cyA;
        paramList.remove(localObject2);
      }
    }
    this.contentView = LayoutInflater.from(paramContext).inflate(2130971008, null, false);
    this.tmr = this.contentView.findViewById(2131828515);
    this.tms = this.contentView.findViewById(2131828520);
    this.tmt = ((TextView)this.contentView.findViewById(2131828517));
    this.tmt.setOnClickListener(new b.1(this, parama));
    this.tmu = ((FlowLayout)this.contentView.findViewById(2131828518));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (adl)paramList.next();
      localObject2 = LayoutInflater.from(paramContext).inflate(2130971009, this.tmu, false);
      TextView localTextView = (TextView)((View)localObject2).findViewById(2131828521);
      localTextView.setText(((adl)localObject1).cyA);
      localTextView.setOnClickListener(new b.2(this, (adl)localObject1, localTextView, paramContext));
      this.tmu.addView((View)localObject2);
    }
    setContentView(this.contentView);
    setCanceledOnTouchOutside(true);
    setOnDismissListener(new b.3(this, parama));
    AppMethodBeat.o(2230);
  }
  
  public final void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2231);
    super.show();
    Object localObject = paramView.getContext();
    View localView = this.contentView;
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    paramView.getLocationOnScreen(arrayOfInt2);
    int i = paramView.getHeight();
    int j = af.hQ((Context)localObject).x;
    localView.measure(0, 0);
    int k = localView.getMeasuredHeight();
    int m = localView.getMeasuredWidth();
    if (paramBoolean)
    {
      arrayOfInt1[0] = (j - m);
      arrayOfInt2[1] -= k;
      if (!paramBoolean) {
        break label235;
      }
      this.tms.setVisibility(0);
      this.tmr.setVisibility(8);
    }
    for (;;)
    {
      arrayOfInt1[0] += paramInt1;
      arrayOfInt1[1] += paramInt2;
      paramView = getWindow();
      paramView.setLayout(-2, -2);
      localObject = paramView.getAttributes();
      ((WindowManager.LayoutParams)localObject).width = -2;
      ((WindowManager.LayoutParams)localObject).height = -2;
      ((WindowManager.LayoutParams)localObject).x = arrayOfInt1[0];
      ((WindowManager.LayoutParams)localObject).y = arrayOfInt1[1];
      ((WindowManager.LayoutParams)localObject).gravity = 8388659;
      paramView.setAttributes((WindowManager.LayoutParams)localObject);
      AppMethodBeat.o(2231);
      return;
      arrayOfInt1[0] = (j - m);
      arrayOfInt2[1] += i;
      break;
      label235:
      this.tms.setVisibility(8);
      this.tmr.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */