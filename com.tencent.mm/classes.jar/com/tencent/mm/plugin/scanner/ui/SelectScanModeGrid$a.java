package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class SelectScanModeGrid$a
  extends BaseAdapter
{
  private Context context;
  private List<SelectScanModeGrid.b> itemList;
  int qBf;
  
  public SelectScanModeGrid$a(Context paramContext, List<SelectScanModeGrid.b> paramList)
  {
    AppMethodBeat.i(81327);
    this.qBf = -1;
    this.context = paramContext;
    this.itemList = paramList;
    ab.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.itemList.size());
    AppMethodBeat.o(81327);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(81328);
    int i = this.itemList.size();
    AppMethodBeat.o(81328);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(81329);
    if ((paramInt < 0) || (paramInt >= this.itemList.size()))
    {
      ab.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(81329);
      return null;
    }
    Object localObject = this.itemList.get(paramInt);
    AppMethodBeat.o(81329);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(81330);
    SelectScanModeGrid.a.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2130970662, null);
      locala = new SelectScanModeGrid.a.a();
      locala.qBg = ((TextView)paramView.findViewById(2131827551));
      locala.pvK = ((TextView)paramView.findViewById(2131827552));
      locala.qBh = ((ImageView)paramView.findViewById(2131827553));
      paramView.setTag(locala);
    }
    while (paramInt == paramViewGroup.getChildCount())
    {
      paramViewGroup = (SelectScanModeGrid.b)getItem(paramInt);
      if (paramViewGroup == null)
      {
        ab.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
        AppMethodBeat.o(81330);
        return paramView;
        locala = (SelectScanModeGrid.a.a)paramView.getTag();
      }
      else
      {
        locala.pvK.setText(paramViewGroup.title);
        if (paramInt != this.qBf) {
          break label188;
        }
        locala.qBg.setBackgroundResource(paramViewGroup.qBj);
        paramViewGroup.qBl = locala.qBg;
        if (!paramViewGroup.qBm) {
          break label203;
        }
        locala.qBh.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(81330);
      return paramView;
      label188:
      locala.qBg.setBackgroundResource(paramViewGroup.qBi);
      break;
      label203:
      locala.qBh.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a
 * JD-Core Version:    0.7.0.1
 */