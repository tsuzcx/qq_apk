package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;

public final class az$a
  extends bd.a
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37367);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493575);
      ((View)localObject).setTag(new az.c().hd((View)localObject));
    }
    AppMethodBeat.o(37367);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37368);
    this.PhN = parama1;
    parama = (az.c)parama;
    paramString = a.a.NS(paramca.field_content);
    if (paramString == null)
    {
      AppMethodBeat.o(37368);
      return;
    }
    String str = paramString.dRL;
    a(parama, parama1, paramca, str);
    a(parama, parama1, str, paramca);
    l.a(parama.PNK.getContext(), com.tencent.mm.am.a.a(paramString), (int)parama.PNK.getTextSize(), 1, null, "");
    parama.PNK.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
    parama.PNK.setOnLongClickListener(c(parama1));
    AppMethodBeat.o(37368);
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233920);
    if (paramca.gDv())
    {
      int i = ((bq)paramView.getTag()).position;
      if (paramca.field_status == 5) {
        paramm.a(i, 103, paramView.getContext().getString(2131757500), 2131690658);
      }
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, paramView.getContext().getString(2131757433), 2131690529);
      }
    }
    AppMethodBeat.o(233920);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
  
  protected final boolean gTU()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az.a
 * JD-Core Version:    0.7.0.1
 */