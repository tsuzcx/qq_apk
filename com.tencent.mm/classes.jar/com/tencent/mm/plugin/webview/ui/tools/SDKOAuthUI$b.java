package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.bgs;
import java.util.LinkedList;

final class SDKOAuthUI$b
  extends BaseAdapter
{
  private LayoutInflater mInflater;
  LinkedList<bgs> vbW;
  private c.a vbX;
  private Context vbY;
  private int vbZ;
  
  public SDKOAuthUI$b(Context paramContext, LinkedList<bgs> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(7546);
    this.vbY = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.vbW = paramLinkedList;
    this.vbX = new c.a();
    this.vbX.eNY = 2131231748;
    paramContext = this.vbX;
    paramContext.eOk = true;
    paramContext.eOl = this.vbY.getResources().getDimension(2131428649);
    this.vbZ = paramInt;
    AppMethodBeat.o(7546);
  }
  
  public final bgs Kt(int paramInt)
  {
    AppMethodBeat.i(7548);
    if ((paramInt >= 0) && (paramInt < this.vbW.size()))
    {
      bgs localbgs = (bgs)this.vbW.get(paramInt);
      AppMethodBeat.o(7548);
      return localbgs;
    }
    AppMethodBeat.o(7548);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(7547);
    if (this.vbW == null)
    {
      AppMethodBeat.o(7547);
      return 0;
    }
    int i = this.vbW.size();
    AppMethodBeat.o(7547);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(7549);
    bgs localbgs = Kt(paramInt);
    if (localbgs == null)
    {
      AppMethodBeat.o(7549);
      return paramView;
    }
    View localView;
    if (paramView == null)
    {
      paramView = new SDKOAuthUI.b.a((byte)0);
      localView = this.mInflater.inflate(2130968797, null, false);
      paramView.vca = ((ImageView)localView.findViewById(2131821596));
      paramView.vcb = ((TextView)localView.findViewById(2131821597));
      paramView.vcc = ((TextView)localView.findViewById(2131821598));
      paramView.vcd = ((ImageView)localView.findViewById(2131821599));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.vcb.setText(j.b(this.vbY, localbgs.nickname, paramViewGroup.vcb.getTextSize()));
      o.ahG().a(localbgs.xeE, paramViewGroup.vca, this.vbX.ahY());
      if (localbgs.desc == null) {
        break label235;
      }
      paramViewGroup.vcc.setText(localbgs.desc);
      paramViewGroup.vcc.setVisibility(0);
      label192:
      if (localbgs.id != this.vbZ) {
        break label247;
      }
      paramViewGroup.vcd.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(7549);
      return localView;
      paramViewGroup = (SDKOAuthUI.b.a)paramView.getTag();
      localView = paramView;
      break;
      label235:
      paramViewGroup.vcc.setVisibility(8);
      break label192;
      label247:
      paramViewGroup.vcd.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.b
 * JD-Core Version:    0.7.0.1
 */