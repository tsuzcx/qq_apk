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
  private List<String> BZw;
  private List<String> ico;
  private Context mContext;
  
  public t(Context paramContext, List<String> paramList1, List<String> paramList2)
  {
    this.mContext = paramContext;
    this.ico = paramList2;
    this.BZw = paramList1;
  }
  
  private static a ft(View paramView)
  {
    AppMethodBeat.i(31426);
    a locala = new a((byte)0);
    locala.frr = ((ImageView)paramView.findViewById(2131297965));
    locala.imt = ((TextView)paramView.findViewById(2131297968));
    paramView.setTag(locala);
    AppMethodBeat.o(31426);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(31423);
    int i = this.ico.size();
    AppMethodBeat.o(31423);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(31424);
    Object localObject = this.ico.get(paramInt);
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
      paramViewGroup = ft(paramView);
    }
    label260:
    for (;;)
    {
      int i = this.ico.size();
      if ((paramInt >= 0) && (paramInt < this.ico.size()) && (paramInt < this.BZw.size()))
      {
        paramViewGroup.frr.setVisibility(0);
        paramViewGroup.imt.setVisibility(0);
        a.b.c(paramViewGroup.frr, (String)this.BZw.get(paramInt));
        paramViewGroup.imt.setText((CharSequence)this.ico.get(paramInt));
        paramViewGroup.imt.setText(((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, (CharSequence)this.ico.get(paramInt), paramViewGroup.imt.getTextSize()));
        if ((this.ico.size() <= 12) || (paramInt < this.ico.size() - i % 4)) {
          break label246;
        }
        paramViewGroup.imt.setPadding(0, 0, 0, com.tencent.mm.cd.a.ao(this.mContext, 2131165258));
      }
      for (;;)
      {
        AppMethodBeat.o(31425);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        if (paramViewGroup != null) {
          break label260;
        }
        paramViewGroup = ft(paramView);
        break;
        label246:
        paramViewGroup.imt.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  static final class a
  {
    public ImageView frr;
    public TextView imt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.t
 * JD-Core Version:    0.7.0.1
 */