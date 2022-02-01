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
  private List<String> Kgd;
  private List<String> jWf;
  private Context mContext;
  
  public t(Context paramContext, List<String> paramList1, List<String> paramList2)
  {
    this.mContext = paramContext;
    this.jWf = paramList2;
    this.Kgd = paramList1;
  }
  
  private static a gn(View paramView)
  {
    AppMethodBeat.i(31426);
    a locala = new a((byte)0);
    locala.gvv = ((ImageView)paramView.findViewById(2131298303));
    locala.kgE = ((TextView)paramView.findViewById(2131298306));
    paramView.setTag(locala);
    AppMethodBeat.o(31426);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(31423);
    int i = this.jWf.size();
    AppMethodBeat.o(31423);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(31424);
    Object localObject = this.jWf.get(paramInt);
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
      paramView = View.inflate(this.mContext, 2131493464, null);
      paramViewGroup = gn(paramView);
    }
    label260:
    for (;;)
    {
      int i = this.jWf.size();
      if ((paramInt >= 0) && (paramInt < this.jWf.size()) && (paramInt < this.Kgd.size()))
      {
        paramViewGroup.gvv.setVisibility(0);
        paramViewGroup.kgE.setVisibility(0);
        a.b.c(paramViewGroup.gvv, (String)this.Kgd.get(paramInt));
        paramViewGroup.kgE.setText((CharSequence)this.jWf.get(paramInt));
        paramViewGroup.kgE.setText(((com.tencent.mm.plugin.emoji.b.a)g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, (CharSequence)this.jWf.get(paramInt), paramViewGroup.kgE.getTextSize()));
        if ((this.jWf.size() <= 12) || (paramInt < this.jWf.size() - i % 4)) {
          break label246;
        }
        paramViewGroup.kgE.setPadding(0, 0, 0, com.tencent.mm.cb.a.aG(this.mContext, 2131165262));
      }
      for (;;)
      {
        AppMethodBeat.o(31425);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        if (paramViewGroup != null) {
          break label260;
        }
        paramViewGroup = gn(paramView);
        break;
        label246:
        paramViewGroup.kgE.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  static final class a
  {
    public ImageView gvv;
    public TextView kgE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.t
 * JD-Core Version:    0.7.0.1
 */