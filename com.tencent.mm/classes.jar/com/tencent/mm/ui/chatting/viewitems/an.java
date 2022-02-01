package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

public final class an
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
      localObject = new ag(paramLayoutInflater, 2131493468);
      ((View)localObject).setTag(new a().gu((View)localObject));
    }
    AppMethodBeat.o(37316);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37317);
    a locala = (a)parama;
    k localk = ap.eLl().zN(parambo.field_msgId);
    String str = parambo.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.az(str, parambo.field_reserved);
      parambo = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.cZX == 3) || (paramString.hiD == 3)))
      {
        locala.iKw.setImageResource(2131232622);
        locala.IoB.setText(paramString.hiI);
      }
      parama.nDl.setOnLongClickListener(c(parama1));
      parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
      parama.nDl.setTag(parambo);
      AppMethodBeat.o(37317);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.e("MicroMsg.ChattingItemHardDeviceMsgPush", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambo.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37318);
    paramContextMenu.add(((bj)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(37318);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    AppMethodBeat.i(37319);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37319);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048176;
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView IoB;
    protected ImageView iKw;
    
    a() {}
    
    public final a gu(View paramView)
    {
      AppMethodBeat.i(37315);
      super.fX(paramView);
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.iKw = ((ImageView)paramView.findViewById(2131303547));
      this.IoB = ((TextView)paramView.findViewById(2131305875));
      AppMethodBeat.o(37315);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an
 * JD-Core Version:    0.7.0.1
 */