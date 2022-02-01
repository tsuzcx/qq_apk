package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class SelectScanModeGrid$a
  extends BaseAdapter
{
  int COe;
  private Context context;
  private List<SelectScanModeGrid.b> jzm;
  
  public SelectScanModeGrid$a(Context paramContext, List<SelectScanModeGrid.b> paramList)
  {
    AppMethodBeat.i(51981);
    this.COe = -1;
    this.context = paramContext;
    this.jzm = paramList;
    Log.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.jzm.size());
    AppMethodBeat.o(51981);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(51982);
    int i = this.jzm.size();
    AppMethodBeat.o(51982);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(51983);
    if ((paramInt < 0) || (paramInt >= this.jzm.size()))
    {
      Log.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(51983);
      return null;
    }
    Object localObject = this.jzm.get(paramInt);
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
      paramView = View.inflate(this.context, 2131496218, null);
      locala = new a();
      locala.COf = ((TextView)paramView.findViewById(2131307555));
      locala.BaI = ((TextView)paramView.findViewById(2131307560));
      locala.xXF = ((ImageView)paramView.findViewById(2131307559));
      paramView.setTag(locala);
    }
    while (paramInt == paramViewGroup.getChildCount())
    {
      paramViewGroup = (SelectScanModeGrid.b)getItem(paramInt);
      if (paramViewGroup == null)
      {
        Log.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
        AppMethodBeat.o(51984);
        return paramView;
        locala = (a)paramView.getTag();
      }
      else
      {
        locala.BaI.setText(paramViewGroup.title);
        if (paramInt != this.COe) {
          break label188;
        }
        locala.COf.setBackgroundResource(paramViewGroup.COh);
        paramViewGroup.COj = locala.COf;
        if (!paramViewGroup.COk) {
          break label203;
        }
        locala.xXF.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(51984);
      return paramView;
      label188:
      locala.COf.setBackgroundResource(paramViewGroup.COg);
      break;
      label203:
      locala.xXF.setVisibility(4);
    }
  }
  
  static final class a
  {
    public TextView BaI;
    public TextView COf;
    public ImageView xXF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a
 * JD-Core Version:    0.7.0.1
 */