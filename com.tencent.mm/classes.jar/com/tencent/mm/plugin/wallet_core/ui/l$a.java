package com.tencent.mm.plugin.wallet_core.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.r.a;
import com.tencent.mm.plugin.wallet_core.model.r.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

final class l$a
  extends BaseAdapter
{
  int uqt;
  List<t> uqu;
  j uqv;
  r<String> uqw;
  
  public l$a(l paraml)
  {
    AppMethodBeat.i(47380);
    this.uqt = -1;
    this.uqu = new LinkedList();
    this.uqv = null;
    this.uqw = new l.a.1(this);
    AppMethodBeat.o(47380);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(47381);
    int i = this.uqu.size();
    AppMethodBeat.o(47381);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(47382);
    Object localObject = this.uqu.get(paramInt);
    AppMethodBeat.o(47382);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47383);
    Object localObject3;
    label154:
    label185:
    Object localObject1;
    Object localObject2;
    int i;
    if (paramView == null)
    {
      paramView = l.c(this.uqs).inflate(2130971165, paramViewGroup, false);
      paramViewGroup = new l.c();
      paramViewGroup.uqy = paramView.findViewById(2131829093);
      paramViewGroup.iJG = ((TextView)paramView.findViewById(2131829095));
      paramViewGroup.ksU = ((TextView)paramView.findViewById(2131829096));
      paramViewGroup.kPB = ((TextView)paramView.findViewById(2131829097));
      paramViewGroup.uqA = ((CheckBox)paramView.findViewById(2131829098));
      paramViewGroup.uqz = ((ImageView)paramView.findViewById(2131829094));
      paramView.setTag(paramViewGroup);
      localObject3 = (t)getItem(paramInt);
      if ((paramInt != this.uqt) || (this.uqt <= 0)) {
        break label418;
      }
      paramViewGroup.uqy.setVisibility(0);
      paramViewGroup.uqz.setVisibility(8);
      if (bo.isNullOrNil(((t)localObject3).tUY)) {
        break label438;
      }
      paramViewGroup.iJG.setText(((t)localObject3).tUY);
      paramViewGroup.iJG.setVisibility(0);
      localObject1 = ((t)localObject3).tTZ;
      if ((this.uqv == null) || (this.uqv.tUx == null)) {
        break label459;
      }
      localObject2 = this.uqv.tUx;
      i = 0;
      label221:
      if (i >= ((List)localObject2).size()) {
        break label459;
      }
      if (!((String)localObject1).equals(((f)((List)localObject2).get(i)).tTZ)) {
        break label450;
      }
      localObject1 = (f)((List)localObject2).get(i);
      label270:
      localObject2 = ((t)localObject3).tUa;
      localObject3 = ((t)localObject3).tUb;
      if (localObject1 == null) {
        break label527;
      }
      localObject3 = ((f)localObject1).tUa;
      localObject2 = ((f)localObject1).tUb;
      localObject1 = localObject3;
    }
    for (;;)
    {
      if (!bo.isNullOrNil((String)localObject1))
      {
        paramViewGroup.ksU.setText((CharSequence)localObject1);
        paramViewGroup.ksU.setVisibility(0);
        label332:
        if (bo.isNullOrNil((String)localObject2)) {
          break label477;
        }
        paramViewGroup.kPB.setText((CharSequence)localObject2);
        paramViewGroup.kPB.setVisibility(0);
        label357:
        localObject1 = ((r.b)this.uqw.uiz.get(paramInt)).uiH;
        if (localObject1 != r.a.uiC) {
          break label489;
        }
        paramViewGroup.uqA.setChecked(false);
        paramViewGroup.uqA.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(47383);
        return paramView;
        paramViewGroup = (l.c)paramView.getTag();
        break;
        label418:
        paramViewGroup.uqy.setVisibility(8);
        paramViewGroup.uqz.setVisibility(0);
        break label154;
        label438:
        paramViewGroup.iJG.setVisibility(8);
        break label185;
        label450:
        i += 1;
        break label221;
        label459:
        localObject1 = null;
        break label270;
        paramViewGroup.ksU.setVisibility(8);
        break label332;
        label477:
        paramViewGroup.kPB.setVisibility(8);
        break label357;
        label489:
        paramViewGroup.uqA.setEnabled(true);
        if (localObject1 == r.a.uiD) {
          paramViewGroup.uqA.setChecked(true);
        } else {
          paramViewGroup.uqA.setChecked(false);
        }
      }
      label527:
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.l.a
 * JD-Core Version:    0.7.0.1
 */