package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgv;
import java.util.LinkedList;

final class SDKOAuthUI$a
  extends BaseAdapter
{
  private LayoutInflater mInflater;
  private LinkedList<bgv> vbB;
  
  public SDKOAuthUI$a(Context paramContext, LinkedList<bgv> paramLinkedList)
  {
    AppMethodBeat.i(7540);
    this.mInflater = LayoutInflater.from(paramContext);
    this.vbB = paramLinkedList;
    AppMethodBeat.o(7540);
  }
  
  private bgv Ks(int paramInt)
  {
    AppMethodBeat.i(7543);
    if ((paramInt >= 0) && (paramInt < this.vbB.size()))
    {
      bgv localbgv = (bgv)this.vbB.get(paramInt);
      AppMethodBeat.o(7543);
      return localbgv;
    }
    AppMethodBeat.o(7543);
    return null;
  }
  
  public final LinkedList<String> ddG()
  {
    AppMethodBeat.i(7541);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.vbB.size())
    {
      bgv localbgv = (bgv)this.vbB.get(i);
      if ((localbgv.xwa == 2) || (localbgv.xwa == 3)) {
        localLinkedList.add(localbgv.scope);
      }
      i += 1;
    }
    AppMethodBeat.o(7541);
    return localLinkedList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(7542);
    if (this.vbB == null)
    {
      AppMethodBeat.o(7542);
      return 0;
    }
    int i = this.vbB.size();
    AppMethodBeat.o(7542);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(7544);
    if ((this.vbB == null) || (this.vbB.size() <= 0))
    {
      AppMethodBeat.o(7544);
      return null;
    }
    bgv localbgv = Ks(paramInt);
    if (localbgv == null)
    {
      AppMethodBeat.o(7544);
      return paramView;
    }
    if (paramView == null)
    {
      paramViewGroup = new SDKOAuthUI.a.a((byte)0);
      paramView = this.mInflater.inflate(2130970618, null, false);
      paramViewGroup.vbF = ((ImageView)paramView.findViewById(2131821584));
      paramViewGroup.jjj = ((TextView)paramView.findViewById(2131821585));
      paramView.setTag(paramViewGroup);
      if (localbgv.xwa != 1) {
        break label181;
      }
      paramViewGroup.vbF.setImageResource(2131231594);
    }
    for (;;)
    {
      paramViewGroup.jjj.setText(localbgv.desc);
      ImageView localImageView = paramViewGroup.vbF;
      paramViewGroup.vbF.setOnClickListener(new SDKOAuthUI.a.1(this, localbgv, localImageView));
      AppMethodBeat.o(7544);
      return paramView;
      paramViewGroup = (SDKOAuthUI.a.a)paramView.getTag();
      break;
      label181:
      if (localbgv.xwa == 3) {
        paramViewGroup.vbF.setImageResource(2131231593);
      } else {
        paramViewGroup.vbF.setImageResource(2131231592);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.a
 * JD-Core Version:    0.7.0.1
 */