package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwv;
import java.util.LinkedList;

final class n$b
  extends BaseAdapter
{
  private LinkedList<bwv> jje;
  
  public n$b(LinkedList<bwv> paramLinkedList)
  {
    Object localObject;
    this.jje = localObject;
  }
  
  private bwv KY(int paramInt)
  {
    AppMethodBeat.i(79180);
    bwv localbwv = (bwv)this.jje.get(paramInt);
    AppMethodBeat.o(79180);
    return localbwv;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(79179);
    if (this.jje == null)
    {
      AppMethodBeat.o(79179);
      return 0;
    }
    int i = this.jje.size();
    AppMethodBeat.o(79179);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(79181);
    if ((this.jje == null) || (this.jje.size() <= 0))
    {
      AppMethodBeat.o(79181);
      return null;
    }
    bwv localbwv = KY(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new n.b.a(this, (byte)0);
      localObject = View.inflate(paramViewGroup.getContext(), 2130968791, null);
      paramView.vbF = ((ImageView)((View)localObject).findViewById(2131821584));
      paramView.jjj = ((TextView)((View)localObject).findViewById(2131821585));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      if (localbwv.xJY != 1) {
        break label174;
      }
      paramViewGroup.vbF.setImageResource(2131231594);
    }
    for (;;)
    {
      paramViewGroup.jjj.setText(localbwv.Desc);
      localObject = paramViewGroup.vbF;
      paramViewGroup.vbF.setOnClickListener(new n.b.1(this, localbwv, (ImageView)localObject));
      AppMethodBeat.o(79181);
      return paramView;
      paramViewGroup = (n.b.a)paramView.getTag();
      break;
      label174:
      if (localbwv.xJY == 3) {
        paramViewGroup.vbF.setImageResource(2131231593);
      } else {
        paramViewGroup.vbF.setImageResource(2131231592);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.b
 * JD-Core Version:    0.7.0.1
 */