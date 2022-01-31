package com.tencent.mm.plugin.order.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class MallOrderDetailInfoUI$a
  extends BaseAdapter
{
  private MallOrderDetailInfoUI$a(MallOrderDetailInfoUI paramMallOrderDetailInfoUI) {}
  
  private MallOrderDetailObject.a Bg(int paramInt)
  {
    AppMethodBeat.i(43805);
    MallOrderDetailObject.a locala = (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(this.pqU).get(paramInt);
    AppMethodBeat.o(43805);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(43804);
    int i = MallOrderDetailInfoUI.e(this.pqU).size();
    AppMethodBeat.o(43804);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(43807);
    paramInt = Bg(paramInt).type;
    AppMethodBeat.o(43807);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43806);
    MallOrderDetailObject.a locala = Bg(paramInt);
    switch (locala.type)
    {
    default: 
      if (paramView == null)
      {
        paramView = View.inflate(this.pqU, 2130970089, null);
        paramViewGroup = new MallOrderDetailInfoUI.b(this.pqU, (byte)0);
        paramViewGroup.kxu = ((TextView)paramView.findViewById(2131825967));
        paramViewGroup.kyw = ((TextView)paramView.findViewById(2131825968));
        paramViewGroup.kyx = ((TextView)paramView.findViewById(2131825964));
        paramViewGroup.jIo = paramView.findViewById(2131825966);
        paramView.setTag(paramViewGroup);
        paramViewGroup.kxu.setText(locala.name);
        if (!TextUtils.isEmpty(locala.value)) {
          break label432;
        }
        paramViewGroup.kyw.setVisibility(4);
        label153:
        if (!locala.kmy) {
          break label455;
        }
        paramViewGroup.kyx.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (paramInt + 1 < getCount())
      {
        locala = Bg(paramInt + 1);
        MallOrderDetailInfoUI.b(paramViewGroup.jIo, locala);
      }
      AppMethodBeat.o(43806);
      return paramView;
      paramView = View.inflate(this.pqU, 2130970091, null);
      paramViewGroup = paramView.findViewById(2131825966);
      MallOrderDetailInfoUI.a(this.pqU, (CheckedTextView)paramView.findViewById(2131825970));
      MallOrderDetailInfoUI.b(this.pqU, (CheckedTextView)paramView.findViewById(2131825969));
      MallOrderDetailInfoUI.f(this.pqU).setOnClickListener(this.pqU.pqT);
      MallOrderDetailInfoUI.g(this.pqU).setOnClickListener(this.pqU.pqT);
      if (paramInt + 1 < getCount()) {
        MallOrderDetailInfoUI.b(paramViewGroup, Bg(paramInt + 1));
      }
      AppMethodBeat.o(43806);
      return paramView;
      paramView = View.inflate(this.pqU, 2130970090, null);
      paramViewGroup = (TextView)paramView.findViewById(2131825969);
      View localView = paramView.findViewById(2131825966);
      if (bo.getInt(locala.value, 0) >= 0)
      {
        paramViewGroup.setText(2131301454);
        paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131231623, 0);
      }
      for (;;)
      {
        if (paramInt + 1 < getCount()) {
          MallOrderDetailInfoUI.b(localView, Bg(paramInt + 1));
        }
        AppMethodBeat.o(43806);
        return paramView;
        paramViewGroup.setText(2131301453);
        paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131231619, 0);
      }
      paramViewGroup = (MallOrderDetailInfoUI.b)paramView.getTag();
      break;
      label432:
      paramViewGroup.kyw.setVisibility(0);
      paramViewGroup.kyw.setText(locala.value);
      break label153;
      label455:
      paramViewGroup.kyx.setVisibility(8);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.a
 * JD-Core Version:    0.7.0.1
 */