package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.fts.ui.m;

public final class a$b
  extends com.tencent.mm.ui.contact.a.a.b
{
  public a$b(a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105184);
    if (com.tencent.mm.cb.a.gt(paramContext)) {}
    for (paramContext = LayoutInflater.from(paramContext).inflate(2130970665, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2130970664, paramViewGroup, false))
    {
      paramViewGroup = (a.a)this.zsY.zsX;
      paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
      paramViewGroup.egr = ((TextView)paramContext.findViewById(2131821212));
      paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
      paramViewGroup.gpM.setVisibility(8);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(105184);
      return paramContext;
    }
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(105185);
    paramContext = (a)parama1;
    parama = (a.a)parama;
    m.a(paramContext.gpH, parama.egr);
    o.ahG().a(paramContext.zsU, parama.egq, a.atD(paramContext.username));
    AppMethodBeat.o(105185);
  }
  
  public final boolean aoZ()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.a.b
 * JD-Core Version:    0.7.0.1
 */