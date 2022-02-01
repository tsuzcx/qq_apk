package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

public final class SelectScanModeGrid$a
  extends BaseAdapter
{
  private Context context;
  private List<SelectScanModeGrid.b> ihv;
  int xgp;
  
  public SelectScanModeGrid$a(Context paramContext, List<SelectScanModeGrid.b> paramList)
  {
    AppMethodBeat.i(51981);
    this.xgp = -1;
    this.context = paramContext;
    this.ihv = paramList;
    ac.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.ihv.size());
    AppMethodBeat.o(51981);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(51982);
    int i = this.ihv.size();
    AppMethodBeat.o(51982);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(51983);
    if ((paramInt < 0) || (paramInt >= this.ihv.size()))
    {
      ac.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(51983);
      return null;
    }
    Object localObject = this.ihv.get(paramInt);
    AppMethodBeat.o(51983);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51984);
    a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131495357, null);
      locala = new a();
      locala.xgq = ((TextView)paramView.findViewById(2131304532));
      locala.nyS = ((TextView)paramView.findViewById(2131304537));
      locala.xgr = ((ImageView)paramView.findViewById(2131304536));
      paramView.setTag(locala);
    }
    while (paramInt == paramViewGroup.getChildCount())
    {
      paramViewGroup = (SelectScanModeGrid.b)getItem(paramInt);
      if (paramViewGroup == null)
      {
        ac.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
        AppMethodBeat.o(51984);
        return paramView;
        locala = (a)paramView.getTag();
      }
      else
      {
        locala.nyS.setText(paramViewGroup.title);
        if (paramInt != this.xgp) {
          break label188;
        }
        locala.xgq.setBackgroundResource(paramViewGroup.xgt);
        paramViewGroup.xgv = locala.xgq;
        if (!paramViewGroup.xgw) {
          break label203;
        }
        locala.xgr.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(51984);
      return paramView;
      label188:
      locala.xgq.setBackgroundResource(paramViewGroup.xgs);
      break;
      label203:
      locala.xgr.setVisibility(4);
    }
  }
  
  static final class a
  {
    public TextView nyS;
    public TextView xgq;
    public ImageView xgr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a
 * JD-Core Version:    0.7.0.1
 */