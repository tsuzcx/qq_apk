package com.tencent.mm.plugin.repairer.ui.demo.refresh.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.view.c;
import com.tencent.mm.plugin.repairer.ui.b.a;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/adapter/ListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "datas", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getDatas", "()Ljava/util/List;", "isNoMore", "", "()Z", "setNoMore", "(Z)V", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends BaseAdapter
{
  private boolean OxT;
  private final Context context;
  private final List<String> lMl;
  
  public a(Context paramContext, List<String> paramList)
  {
    AppMethodBeat.i(278433);
    this.context = paramContext;
    this.lMl = paramList;
    AppMethodBeat.o(278433);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(278441);
    String str = (String)this.lMl.get(paramInt);
    AppMethodBeat.o(278441);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(278444);
    int i = this.lMl.size();
    AppMethodBeat.o(278444);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(278465);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.context).inflate(b.d.OvO, null);
    }
    if (paramViewGroup == null) {
      paramView = null;
    }
    Object localObject;
    while (paramView != null)
    {
      paramView.setText((CharSequence)getItem(paramInt));
      if ((!this.OxT) || (paramInt != this.lMl.size() - 1)) {
        break label176;
      }
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(278465);
        throw paramView;
        paramView = (TextView)paramViewGroup.findViewById(b.c.Ovj);
      }
      else
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        ((RelativeLayout.LayoutParams)localObject).height = c.dip2px(this.context, 50.0F);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (paramInt % 2 != 0) {
          break label237;
        }
        paramView.setBackgroundColor(this.context.getResources().getColor(b.a.wechat_green_disable));
      }
    }
    for (;;)
    {
      s.checkNotNull(paramViewGroup);
      AppMethodBeat.o(278465);
      return paramViewGroup;
      label176:
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(278465);
        throw paramView;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).height = c.dip2px(this.context, 100.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break;
      label237:
      paramView.setBackgroundColor(this.context.getResources().getColor(b.a.white));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.a.a
 * JD-Core Version:    0.7.0.1
 */