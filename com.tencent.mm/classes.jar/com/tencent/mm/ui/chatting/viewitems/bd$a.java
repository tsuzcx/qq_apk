package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ap.a.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;

public final class bd$a
  extends bi.a
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
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
      localObject = new aq(paramLayoutInflater, R.i.edE);
      ((View)localObject).setTag(new bd.c().ip((View)localObject));
    }
    AppMethodBeat.o(37367);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37368);
    this.WBq = parama1;
    parama = (bd.c)parama;
    paramString = a.a.Vp(paramca.field_content);
    if (paramString == null)
    {
      AppMethodBeat.o(37368);
      return;
    }
    String str = paramString.fLi;
    a(parama, parama1, paramca, str);
    a(parama, parama1, str, paramca);
    l.a(parama.XjK.getContext(), com.tencent.mm.ap.a.a(paramString), (int)parama.XjK.getTextSize(), null, "");
    parama.XjK.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
    parama.XjK.setOnLongClickListener(c(parama1));
    AppMethodBeat.o(37368);
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(275977);
    if (paramca.hzK())
    {
      int i = ((by)paramView.getTag()).position;
      if (paramca.field_status == 5) {
        paramo.a(i, 103, paramView.getContext().getString(R.l.ewJ), R.k.icons_filled_refresh);
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
      }
    }
    AppMethodBeat.o(275977);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
  
  protected final boolean hTE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.a
 * JD-Core Version:    0.7.0.1
 */