package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
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
      ((View)localObject).setTag(new a().gL((View)localObject));
    }
    AppMethodBeat.o(37316);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37317);
    a locala = (a)parama;
    com.tencent.mm.ai.k localk = com.tencent.mm.pluginsdk.model.app.ao.fag().xH(parambu.field_msgId);
    String str = parambu.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.aA(str, parambu.field_reserved);
      parambu = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.dlp == 3) || (paramString.hAM == 3)))
      {
        locala.jdF.setImageResource(2131232622);
        locala.Kfb.setText(paramString.hAR);
      }
      parama.ofK.setOnLongClickListener(c(parama1));
      parama.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
      parama.ofK.setTag(parambu);
      AppMethodBeat.o(37317);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.e("MicroMsg.ChattingItemHardDeviceMsgPush", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambu.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    AppMethodBeat.i(37319);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37319);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194484);
    paraml.a(((bk)paramView.getTag()).position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(194484);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048176;
  }
  
  public final boolean fHh()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView Kfb;
    protected ImageView jdF;
    
    a() {}
    
    public final a gL(View paramView)
    {
      AppMethodBeat.i(37315);
      super.gn(paramView);
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.jdF = ((ImageView)paramView.findViewById(2131303547));
      this.Kfb = ((TextView)paramView.findViewById(2131305875));
      AppMethodBeat.o(37315);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao
 * JD-Core Version:    0.7.0.1
 */