package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class WalletCardSelectUI$a
  extends BaseAdapter
{
  private Context context;
  List<ElementQuery> items;
  
  public WalletCardSelectUI$a(WalletCardSelectUI paramWalletCardSelectUI, Context paramContext)
  {
    AppMethodBeat.i(47301);
    this.items = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(47301);
  }
  
  public final ElementQuery IF(int paramInt)
  {
    AppMethodBeat.i(47305);
    ElementQuery localElementQuery = (ElementQuery)this.items.get(paramInt);
    AppMethodBeat.o(47305);
    return localElementQuery;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(47304);
    int i = this.items.size();
    AppMethodBeat.o(47304);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47303);
    paramViewGroup = new WalletCardSelectUI.a.a(this);
    View localView = View.inflate(this.context, 2130971136, null);
    paramViewGroup.upw = ((CheckedTextView)localView.findViewById(2131828976));
    ElementQuery localElementQuery = (ElementQuery)this.items.get(paramInt);
    paramView = bo.bf(localElementQuery.nLq, "");
    if (!bo.isNullOrNil(localElementQuery.uhD))
    {
      paramView = paramView + "[" + localElementQuery.uhD + "]";
      paramViewGroup.upw.setEnabled(false);
    }
    for (;;)
    {
      paramViewGroup.upw.setText(paramView);
      AppMethodBeat.o(47303);
      return localView;
      paramViewGroup.upw.setEnabled(true);
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(47302);
    boolean bool = bo.isNullOrNil(((ElementQuery)this.items.get(paramInt)).uhD);
    AppMethodBeat.o(47302);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.a
 * JD-Core Version:    0.7.0.1
 */