package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class t
  extends BaseAdapter
{
  private List<String> EWR;
  private List<String> iVH;
  private Context mContext;
  
  public t(Context paramContext, List<String> paramList1, List<String> paramList2)
  {
    this.mContext = paramContext;
    this.iVH = paramList2;
    this.EWR = paramList1;
  }
  
  private static a fV(View paramView)
  {
    AppMethodBeat.i(31426);
    a locala = new a((byte)0);
    locala.fOf = ((ImageView)paramView.findViewById(2131297965));
    locala.jfJ = ((TextView)paramView.findViewById(2131297968));
    paramView.setTag(locala);
    AppMethodBeat.o(31426);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(31423);
    int i = this.iVH.size();
    AppMethodBeat.o(31423);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(31424);
    Object localObject = this.iVH.get(paramInt);
    AppMethodBeat.o(31424);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31425);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131493373, null);
      paramViewGroup = fV(paramView);
    }
    label260:
    for (;;)
    {
      int i = this.iVH.size();
      if ((paramInt >= 0) && (paramInt < this.iVH.size()) && (paramInt < this.EWR.size()))
      {
        paramViewGroup.fOf.setVisibility(0);
        paramViewGroup.jfJ.setVisibility(0);
        a.b.c(paramViewGroup.fOf, (String)this.EWR.get(paramInt));
        paramViewGroup.jfJ.setText((CharSequence)this.iVH.get(paramInt));
        paramViewGroup.jfJ.setText(((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, (CharSequence)this.iVH.get(paramInt), paramViewGroup.jfJ.getTextSize()));
        if ((this.iVH.size() <= 12) || (paramInt < this.iVH.size() - i % 4)) {
          break label246;
        }
        paramViewGroup.jfJ.setPadding(0, 0, 0, com.tencent.mm.cc.a.ax(this.mContext, 2131165258));
      }
      for (;;)
      {
        AppMethodBeat.o(31425);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        if (paramViewGroup != null) {
          break label260;
        }
        paramViewGroup = fV(paramView);
        break;
        label246:
        paramViewGroup.jfJ.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  static final class a
  {
    public ImageView fOf;
    public TextView jfJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.t
 * JD-Core Version:    0.7.0.1
 */