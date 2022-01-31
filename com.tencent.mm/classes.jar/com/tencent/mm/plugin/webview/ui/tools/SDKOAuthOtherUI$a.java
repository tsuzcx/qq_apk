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

final class SDKOAuthOtherUI$a
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  LinkedList<bgv> vbB;
  
  public SDKOAuthOtherUI$a(Context paramContext, LinkedList<bgv> paramLinkedList)
  {
    AppMethodBeat.i(7511);
    this.mInflater = LayoutInflater.from(paramContext);
    this.vbB = paramLinkedList;
    this.mContext = paramContext;
    AppMethodBeat.o(7511);
  }
  
  private bgv Ks(int paramInt)
  {
    AppMethodBeat.i(7513);
    if ((paramInt >= 0) && (paramInt < this.vbB.size()))
    {
      bgv localbgv = (bgv)this.vbB.get(paramInt);
      AppMethodBeat.o(7513);
      return localbgv;
    }
    AppMethodBeat.o(7513);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(7512);
    if (this.vbB == null)
    {
      AppMethodBeat.o(7512);
      return 0;
    }
    int i = this.vbB.size();
    AppMethodBeat.o(7512);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(7514);
    if ((this.vbB == null) || (this.vbB.size() <= 0))
    {
      AppMethodBeat.o(7514);
      return null;
    }
    bgv localbgv = Ks(paramInt);
    if (localbgv == null)
    {
      AppMethodBeat.o(7514);
      return paramView;
    }
    if (paramView == null)
    {
      paramViewGroup = new SDKOAuthOtherUI.a.a((byte)0);
      paramView = this.mInflater.inflate(2130970619, null, false);
      paramViewGroup.vbF = ((ImageView)paramView.findViewById(2131821584));
      paramViewGroup.jjj = ((TextView)paramView.findViewById(2131821585));
      paramView.setTag(paramViewGroup);
      if (localbgv.xwa != 1) {
        break label181;
      }
      paramViewGroup.vbF.setImageResource(2131231597);
    }
    for (;;)
    {
      paramViewGroup.jjj.setText(localbgv.desc);
      ImageView localImageView = paramViewGroup.vbF;
      paramViewGroup.vbF.setOnClickListener(new SDKOAuthOtherUI.a.1(this, localbgv, localImageView));
      AppMethodBeat.o(7514);
      return paramView;
      paramViewGroup = (SDKOAuthOtherUI.a.a)paramView.getTag();
      break;
      label181:
      if (localbgv.xwa == 3) {
        paramViewGroup.vbF.setImageResource(2131231596);
      } else {
        paramViewGroup.vbF.setImageResource(2131231595);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.a
 * JD-Core Version:    0.7.0.1
 */