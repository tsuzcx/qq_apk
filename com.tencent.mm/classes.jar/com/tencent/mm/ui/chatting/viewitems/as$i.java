package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;

final class as$i
  extends c.a
{
  TextView zVQ;
  View zYo = null;
  
  public static void a(i parami, bi parambi, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.d.a parama, as.h paramh, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(33429);
    if (parami == null)
    {
      AppMethodBeat.o(33429);
      return;
    }
    int i;
    if (parami.zRC != null)
    {
      ImageView localImageView = parami.zRC;
      if (parambi.field_status == 6)
      {
        i = 8;
        localImageView.setVisibility(i);
      }
    }
    else
    {
      parami.jYu.setTag(new az(parambi, parama.dJG(), paramInt, null, '\000'));
      parami.jYu.setOnClickListener(paramh);
      parami.jYu.setOnLongClickListener(paramOnLongClickListener);
      parami.jYu.setOnTouchListener(((h)parama.ay(h.class)).dHi());
      parama = parambi.dns;
      if (bo.isNullOrNil(parama)) {
        break label153;
      }
      parami.zVQ.setText(parama);
    }
    for (;;)
    {
      if (parami.zYo != null) {
        break label181;
      }
      AppMethodBeat.o(33429);
      return;
      i = 0;
      break;
      label153:
      if (paramBoolean) {
        parami.zVQ.setText(2131304621);
      } else {
        parami.zVQ.setText(2131304622);
      }
    }
    label181:
    if ((parambi.field_content.equals(bi.yOb)) || (lx(parambi.field_content)))
    {
      parami.zYo.setBackgroundResource(2131232185);
      AppMethodBeat.o(33429);
      return;
    }
    if ((parambi.field_content.equals(bi.yOc)) || (lw(parambi.field_content)))
    {
      if (paramBoolean)
      {
        parami.zYo.setBackgroundResource(2131232182);
        AppMethodBeat.o(33429);
        return;
      }
      parami.zYo.setBackgroundResource(2131232183);
    }
    AppMethodBeat.o(33429);
  }
  
  private static boolean lw(String paramString)
  {
    AppMethodBeat.i(33431);
    ux localux = new ux();
    localux.cLs.cut = 1;
    localux.cLs.content = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    if (localux.cLt.type == 2)
    {
      AppMethodBeat.o(33431);
      return true;
    }
    AppMethodBeat.o(33431);
    return false;
  }
  
  private static boolean lx(String paramString)
  {
    AppMethodBeat.i(33430);
    ux localux = new ux();
    localux.cLs.cut = 1;
    localux.cLs.content = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    if (localux.cLt.type == 3)
    {
      AppMethodBeat.o(33430);
      return true;
    }
    AppMethodBeat.o(33430);
    return false;
  }
  
  public final c.a fl(View paramView)
  {
    AppMethodBeat.i(33428);
    super.eV(paramView);
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.zVQ = ((TextView)paramView.findViewById(2131822697));
    this.jYu = paramView.findViewById(2131822580);
    this.zYo = paramView.findViewById(2131822696);
    this.zRC = ((ImageView)paramView.findViewById(2131822695));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    AppMethodBeat.o(33428);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.i
 * JD-Core Version:    0.7.0.1
 */