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

public final class l
  extends BaseAdapter
{
  private List<String> gpY;
  private Context mContext;
  private List<String> vUp;
  
  public l(Context paramContext, List<String> paramList1, List<String> paramList2)
  {
    this.mContext = paramContext;
    this.gpY = paramList2;
    this.vUp = paramList1;
  }
  
  private static l.a eE(View paramView)
  {
    AppMethodBeat.i(27720);
    l.a locala = new l.a((byte)0);
    locala.egq = ((ImageView)paramView.findViewById(2131822423));
    locala.gzk = ((TextView)paramView.findViewById(2131822424));
    paramView.setTag(locala);
    AppMethodBeat.o(27720);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(27717);
    int i = this.gpY.size();
    AppMethodBeat.o(27717);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(27718);
    Object localObject = this.gpY.get(paramInt);
    AppMethodBeat.o(27718);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27719);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130969023, null);
      paramViewGroup = eE(paramView);
    }
    label260:
    for (;;)
    {
      int i = this.gpY.size();
      if ((paramInt >= 0) && (paramInt < this.gpY.size()) && (paramInt < this.vUp.size()))
      {
        paramViewGroup.egq.setVisibility(0);
        paramViewGroup.gzk.setVisibility(0);
        a.b.c(paramViewGroup.egq, (String)this.vUp.get(paramInt));
        paramViewGroup.gzk.setText((CharSequence)this.gpY.get(paramInt));
        paramViewGroup.gzk.setText(((com.tencent.mm.plugin.emoji.b.a)g.E(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, (CharSequence)this.gpY.get(paramInt), paramViewGroup.gzk.getTextSize()));
        if ((this.gpY.size() <= 12) || (paramInt < this.gpY.size() - i % 4)) {
          break label246;
        }
        paramViewGroup.gzk.setPadding(0, 0, 0, com.tencent.mm.cb.a.ao(this.mContext, 2131427565));
      }
      for (;;)
      {
        AppMethodBeat.o(27719);
        return paramView;
        paramViewGroup = (l.a)paramView.getTag();
        if (paramViewGroup != null) {
          break label260;
        }
        paramViewGroup = eE(paramView);
        break;
        label246:
        paramViewGroup.gzk.setPadding(0, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.l
 * JD-Core Version:    0.7.0.1
 */