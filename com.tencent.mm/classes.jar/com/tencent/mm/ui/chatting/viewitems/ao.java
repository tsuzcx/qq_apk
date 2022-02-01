package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.e.a;

public final class ao
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37316);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493468);
      ((View)localObject).setTag(new a().gQ((View)localObject));
    }
    AppMethodBeat.o(37316);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37317);
    a locala = (a)parama;
    com.tencent.mm.ah.k localk = com.tencent.mm.pluginsdk.model.app.ao.fdU().yb(parambv.field_msgId);
    String str = parambv.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.aB(str, parambv.field_reserved);
      parambv = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.dmr == 3) || (paramString.hDA == 3)))
      {
        locala.jgy.setImageResource(2131232622);
        locala.KBu.setText(paramString.hDF);
      }
      parama.olI.setOnLongClickListener(c(parama1));
      parama.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
      parama.olI.setTag(parambv);
      AppMethodBeat.o(37317);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.e("MicroMsg.ChattingItemHardDeviceMsgPush", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambv.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    AppMethodBeat.i(37319);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37319);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187879);
    paraml.a(((bk)paramView.getTag()).position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(187879);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048176;
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView KBu;
    protected ImageView jgy;
    
    a() {}
    
    public final a gQ(View paramView)
    {
      AppMethodBeat.i(37315);
      super.gs(paramView);
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.jgy = ((ImageView)paramView.findViewById(2131303547));
      this.KBu = ((TextView)paramView.findViewById(2131305875));
      AppMethodBeat.o(37315);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao
 * JD-Core Version:    0.7.0.1
 */