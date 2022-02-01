package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class SelectScanModeGrid$a
  extends BaseAdapter
{
  int Pcz;
  private Context context;
  private List<SelectScanModeGrid.b> piH;
  
  public SelectScanModeGrid$a(Context paramContext, List<SelectScanModeGrid.b> paramList)
  {
    AppMethodBeat.i(51981);
    this.Pcz = -1;
    this.context = paramContext;
    this.piH = paramList;
    Log.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.piH.size());
    AppMethodBeat.o(51981);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(51982);
    int i = this.piH.size();
    AppMethodBeat.o(51982);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(51983);
    if ((paramInt < 0) || (paramInt >= this.piH.size()))
    {
      Log.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(51983);
      return null;
    }
    Object localObject = this.piH.get(paramInt);
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
      paramView = View.inflate(this.context, l.g.OKC, null);
      locala = new a();
      locala.PcA = ((TextView)paramView.findViewById(l.f.OJG));
      locala.ElR = ((TextView)paramView.findViewById(l.f.OJL));
      locala.IWE = ((ImageView)paramView.findViewById(l.f.OJK));
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
        locala.ElR.setText(paramViewGroup.title);
        if (paramInt != this.Pcz) {
          break label192;
        }
        locala.PcA.setBackgroundResource(paramViewGroup.PcC);
        paramViewGroup.PcE = locala.PcA;
        if (!paramViewGroup.PcF) {
          break label207;
        }
        locala.IWE.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(51984);
      return paramView;
      label192:
      locala.PcA.setBackgroundResource(paramViewGroup.PcB);
      break;
      label207:
      locala.IWE.setVisibility(4);
    }
  }
  
  static final class a
  {
    public TextView ElR;
    public ImageView IWE;
    public TextView PcA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a
 * JD-Core Version:    0.7.0.1
 */