package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter;", "Landroid/widget/BaseAdapter;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "listItems", "", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "selectItemName", "", "itemName", "selectedItemName", "getSelectedItemName", "()Ljava/lang/String;", "setSelectedItemName", "(Ljava/lang/String;)V", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setItems", "", "items", "Companion", "ViewHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DropdownListView$b
  extends BaseAdapter
{
  public static final DropdownListView.b.a Yrf;
  List<DropdownListView.c> Yrg;
  String Yrh;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(245691);
    Yrf = new DropdownListView.b.a((byte)0);
    AppMethodBeat.o(245691);
  }
  
  public DropdownListView$b(Context paramContext)
  {
    AppMethodBeat.i(245685);
    this.mContext = paramContext;
    this.Yrh = "";
    this.Yrg = ((List)new ArrayList());
    AppMethodBeat.o(245685);
  }
  
  public final DropdownListView.c axb(int paramInt)
  {
    AppMethodBeat.i(245713);
    DropdownListView.c localc = (DropdownListView.c)this.Yrg.get(paramInt);
    AppMethodBeat.o(245713);
    return localc;
  }
  
  public final void brz(String paramString)
  {
    AppMethodBeat.i(245701);
    paramString = Util.nullAs(paramString, "");
    s.s(paramString, "nullAs(itemName, \"\")");
    this.Yrh = paramString;
    AppMethodBeat.o(245701);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(245707);
    int i = this.Yrg.size();
    AppMethodBeat.o(245707);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(245739);
    s.u(paramViewGroup, "parent");
    Log.i("MicroMsg.DropdownListAdapter", s.X("duanyi test getView:", Integer.valueOf(paramInt)));
    DropdownListView.c localc = axb(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(R.i.giU, paramViewGroup, false);
      paramViewGroup = new b();
      paramViewGroup.mpe = ((WeImageView)paramView.findViewById(R.h.item_icon));
      paramViewGroup.pUL = ((TextView)paramView.findViewById(R.h.item_name));
      paramViewGroup.HNO = ((ImageView)paramView.findViewById(R.h.fVO));
      paramViewGroup.DPC = paramView.findViewById(R.h.fLE);
      paramView.setTag(paramViewGroup);
      if (!s.p(this.Yrh, localc.name)) {
        break label323;
      }
      localObject = paramViewGroup.HNO;
      s.checkNotNull(localObject);
      ((ImageView)localObject).setVisibility(0);
      label150:
      if (paramInt >= getCount() - 1) {
        break label343;
      }
      localObject = paramViewGroup.DPC;
      s.checkNotNull(localObject);
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = paramViewGroup.mpe;
      s.checkNotNull(localObject);
      ((WeImageView)localObject).setImageDrawable(this.mContext.getResources().getDrawable(localc.tus));
      localObject = paramViewGroup.mpe;
      s.checkNotNull(localObject);
      ((WeImageView)localObject).setIconColor(this.mContext.getResources().getColor(localc.iconColor));
      localObject = paramViewGroup.pUL;
      s.checkNotNull(localObject);
      ((TextView)localObject).setVisibility(0);
      paramViewGroup = paramViewGroup.pUL;
      s.checkNotNull(paramViewGroup);
      paramViewGroup.setText((CharSequence)localc.name);
      s.checkNotNull(paramView);
      AppMethodBeat.o(245739);
      return paramView;
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.DropdownListView.DropdownListAdapter.ViewHolder");
        AppMethodBeat.o(245739);
        throw paramView;
      }
      paramViewGroup = (b)paramViewGroup;
      break;
      label323:
      localObject = paramViewGroup.HNO;
      s.checkNotNull(localObject);
      ((ImageView)localObject).setVisibility(4);
      break label150;
      label343:
      localObject = paramViewGroup.DPC;
      s.checkNotNull(localObject);
      ((View)localObject).setVisibility(8);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter$ViewHolder;", "", "()V", "iconIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIV", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIV", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "line", "Landroid/view/View;", "getLine", "()Landroid/view/View;", "setLine", "(Landroid/view/View;)V", "nameTV", "Landroid/widget/TextView;", "getNameTV", "()Landroid/widget/TextView;", "setNameTV", "(Landroid/widget/TextView;)V", "selectedIV", "Landroid/widget/ImageView;", "getSelectedIV", "()Landroid/widget/ImageView;", "setSelectedIV", "(Landroid/widget/ImageView;)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    View DPC;
    ImageView HNO;
    WeImageView mpe;
    TextView pUL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.DropdownListView.b
 * JD-Core Version:    0.7.0.1
 */