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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter;", "Landroid/widget/BaseAdapter;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "listItems", "", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "selectItemName", "", "itemName", "selectedItemName", "getSelectedItemName", "()Ljava/lang/String;", "setSelectedItemName", "(Ljava/lang/String;)V", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setItems", "", "items", "Companion", "ViewHolder", "app_release"})
public final class DropdownListView$b
  extends BaseAdapter
{
  public static final a KtE;
  List<DropdownListView.c> KtC;
  String KtD;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(231027);
    KtE = new a((byte)0);
    AppMethodBeat.o(231027);
  }
  
  public DropdownListView$b(Context paramContext)
  {
    AppMethodBeat.i(231026);
    this.mContext = paramContext;
    this.KtD = "";
    this.KtC = ((List)new ArrayList());
    AppMethodBeat.o(231026);
  }
  
  public final DropdownListView.c aiO(int paramInt)
  {
    AppMethodBeat.i(231023);
    DropdownListView.c localc = (DropdownListView.c)this.KtC.get(paramInt);
    AppMethodBeat.o(231023);
    return localc;
  }
  
  public final void bfp(String paramString)
  {
    AppMethodBeat.i(231021);
    paramString = Util.nullAs(paramString, "");
    p.g(paramString, "Util.nullAs(itemName, \"\")");
    this.KtD = paramString;
    AppMethodBeat.o(231021);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(231022);
    int i = this.KtC.size();
    AppMethodBeat.o(231022);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(231025);
    p.h(paramViewGroup, "parent");
    Log.i("MicroMsg.DropdownListAdapter", "duanyi test getView:".concat(String.valueOf(paramInt)));
    DropdownListView.c localc = aiO(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131493860, paramViewGroup, false);
      paramViewGroup = new b();
      paramViewGroup.hex = ((WeImageView)paramView.findViewById(2131302812));
      paramViewGroup.kgE = ((TextView)paramView.findViewById(2131302841));
      paramViewGroup.xps = ((ImageView)paramView.findViewById(2131307568));
      paramViewGroup.KtF = paramView.findViewById(2131302827);
      p.g(paramView, "convertView");
      paramView.setTag(paramViewGroup);
      if (!p.j(this.KtD, localc.name)) {
        break label338;
      }
      localObject = paramViewGroup.xps;
      if (localObject == null) {
        p.hyc();
      }
      ((ImageView)localObject).setVisibility(0);
      label154:
      if (paramInt >= getCount() - 1) {
        break label361;
      }
      localObject = paramViewGroup.KtF;
      if (localObject == null) {
        p.hyc();
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = paramViewGroup.hex;
      if (localObject == null) {
        p.hyc();
      }
      ((WeImageView)localObject).setImageDrawable(this.mContext.getResources().getDrawable(localc.noe));
      localObject = paramViewGroup.hex;
      if (localObject == null) {
        p.hyc();
      }
      ((WeImageView)localObject).setIconColor(this.mContext.getResources().getColor(localc.uzt));
      localObject = paramViewGroup.kgE;
      if (localObject == null) {
        p.hyc();
      }
      ((TextView)localObject).setVisibility(0);
      paramViewGroup = paramViewGroup.kgE;
      if (paramViewGroup == null) {
        p.hyc();
      }
      paramViewGroup.setText((CharSequence)localc.name);
      AppMethodBeat.o(231025);
      return paramView;
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.DropdownListView.DropdownListAdapter.ViewHolder");
        AppMethodBeat.o(231025);
        throw paramView;
      }
      paramViewGroup = (b)paramViewGroup;
      break;
      label338:
      localObject = paramViewGroup.xps;
      if (localObject == null) {
        p.hyc();
      }
      ((ImageView)localObject).setVisibility(4);
      break label154;
      label361:
      localObject = paramViewGroup.KtF;
      if (localObject == null) {
        p.hyc();
      }
      ((View)localObject).setVisibility(8);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter$ViewHolder;", "", "()V", "iconIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIV", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIV", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "line", "Landroid/view/View;", "getLine", "()Landroid/view/View;", "setLine", "(Landroid/view/View;)V", "nameTV", "Landroid/widget/TextView;", "getNameTV", "()Landroid/widget/TextView;", "setNameTV", "(Landroid/widget/TextView;)V", "selectedIV", "Landroid/widget/ImageView;", "getSelectedIV", "()Landroid/widget/ImageView;", "setSelectedIV", "(Landroid/widget/ImageView;)V", "app_release"})
  static final class b
  {
    View KtF;
    WeImageView hex;
    TextView kgE;
    ImageView xps;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.DropdownListView.b
 * JD-Core Version:    0.7.0.1
 */