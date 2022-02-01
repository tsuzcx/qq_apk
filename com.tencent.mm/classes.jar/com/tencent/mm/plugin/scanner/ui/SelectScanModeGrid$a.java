package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

public final class SelectScanModeGrid$a
  extends BaseAdapter
{
  private Context context;
  private List<SelectScanModeGrid.b> hGT;
  int vVD;
  
  public SelectScanModeGrid$a(Context paramContext, List<SelectScanModeGrid.b> paramList)
  {
    AppMethodBeat.i(51981);
    this.vVD = -1;
    this.context = paramContext;
    this.hGT = paramList;
    ad.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.hGT.size());
    AppMethodBeat.o(51981);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(51982);
    int i = this.hGT.size();
    AppMethodBeat.o(51982);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(51983);
    if ((paramInt < 0) || (paramInt >= this.hGT.size()))
    {
      ad.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(51983);
      return null;
    }
    Object localObject = this.hGT.get(paramInt);
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
      locala.vVE = ((TextView)paramView.findViewById(2131304532));
      locala.mWt = ((TextView)paramView.findViewById(2131304537));
      locala.vVF = ((ImageView)paramView.findViewById(2131304536));
      paramView.setTag(locala);
    }
    while (paramInt == paramViewGroup.getChildCount())
    {
      paramViewGroup = (SelectScanModeGrid.b)getItem(paramInt);
      if (paramViewGroup == null)
      {
        ad.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
        AppMethodBeat.o(51984);
        return paramView;
        locala = (a)paramView.getTag();
      }
      else
      {
        locala.mWt.setText(paramViewGroup.title);
        if (paramInt != this.vVD) {
          break label188;
        }
        locala.vVE.setBackgroundResource(paramViewGroup.vVH);
        paramViewGroup.vVJ = locala.vVE;
        if (!paramViewGroup.vVK) {
          break label203;
        }
        locala.vVF.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(51984);
      return paramView;
      label188:
      locala.vVE.setBackgroundResource(paramViewGroup.vVG);
      break;
      label203:
      locala.vVF.setVisibility(4);
    }
  }
  
  static final class a
  {
    public TextView mWt;
    public TextView vVE;
    public ImageView vVF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a
 * JD-Core Version:    0.7.0.1
 */