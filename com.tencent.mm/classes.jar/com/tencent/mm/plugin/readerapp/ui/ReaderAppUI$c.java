package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bm;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.ui.base.n.d;

@Deprecated
final class ReaderAppUI$c
  extends a<String>
{
  private Context context;
  private int eke;
  private int jVy;
  private int kxm;
  private int pUl;
  
  public ReaderAppUI$c(ReaderAppUI paramReaderAppUI, Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    AppMethodBeat.i(76839);
    this.context = paramContext;
    this.kxm = 3;
    this.eke = this.kxm;
    this.pUl = paramContext.getResources().getDimensionPixelSize(2131427496);
    this.jVy = paramContext.getResources().getDimensionPixelSize(2131427854);
    AppMethodBeat.o(76839);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(76842);
    this.eke = g.cfl().kH(ReaderAppUI.a(this.pUg));
    setCursor(g.cfl().ct(this.kxm, ReaderAppUI.a(this.pUg)));
    super.notifyDataSetChanged();
    AppMethodBeat.o(76842);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(76840);
    Ku();
    AppMethodBeat.o(76840);
  }
  
  public final boolean bem()
  {
    return this.kxm >= this.eke;
  }
  
  public final int ben()
  {
    AppMethodBeat.i(76841);
    if (bem())
    {
      AppMethodBeat.o(76841);
      return 0;
    }
    this.kxm += 3;
    if (this.kxm <= this.eke)
    {
      AppMethodBeat.o(76841);
      return 3;
    }
    this.kxm = this.eke;
    int i = this.eke;
    AppMethodBeat.o(76841);
    return i % 3;
  }
  
  public final int getShowCount()
  {
    return this.kxm;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(76843);
    if (paramView == null)
    {
      paramViewGroup = new ReaderAppUI.c.a(this);
      paramView = View.inflate(this.context, 2130970509, null);
      paramViewGroup.pUv = ((ReaderItemListView)paramView.findViewById(2131827036));
      paramViewGroup.nxi = ((TextView)paramView.findViewById(2131827031));
      paramView.setTag(paramViewGroup);
      getItem(paramInt);
      paramViewGroup.nxi.setText(h.c(this.context, 0L, false));
      ReaderItemListView localReaderItemListView = paramViewGroup.pUv;
      String str = (String)getItem(paramInt);
      View.OnCreateContextMenuListener localOnCreateContextMenuListener = ReaderAppUI.a(this.pUg, false);
      n.d locald = ReaderAppUI.g(this.pUg);
      localReaderItemListView.position = paramInt;
      localReaderItemListView.pUz = localOnCreateContextMenuListener;
      localReaderItemListView.jWw = locald;
      localReaderItemListView.pUx = g.cfl().R(str, localReaderItemListView.type);
      localReaderItemListView.pUy.notifyDataSetChanged();
      if (ReaderAppUI.h(this.pUg) != null)
      {
        paramViewGroup.nxi.setTextColor(ReaderAppUI.h(this.pUg).vQa);
        if (!ReaderAppUI.h(this.pUg).vQb) {
          break label288;
        }
        paramViewGroup.nxi.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.h(this.pUg).vQc);
        label225:
        if (!ReaderAppUI.h(this.pUg).vQd) {
          break label302;
        }
        paramViewGroup.nxi.setBackgroundResource(2130838245);
        paramViewGroup.nxi.setPadding(this.jVy, this.pUl, this.jVy, this.pUl);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(76843);
      return paramView;
      paramViewGroup = (ReaderAppUI.c.a)paramView.getTag();
      break;
      label288:
      paramViewGroup.nxi.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label225;
      label302:
      paramViewGroup.nxi.setBackgroundColor(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.c
 * JD-Core Version:    0.7.0.1
 */