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
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

public final class am
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
      localObject = new af(paramLayoutInflater, 2131493468);
      ((View)localObject).setTag(new a().gh((View)localObject));
    }
    AppMethodBeat.o(37316);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37317);
    a locala = (a)parama;
    k localk = ap.evR().vk(parambl.field_msgId);
    String str = parambl.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.ar(str, parambl.field_reserved);
      parambl = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.dcz == 3) || (paramString.gIc == 3)))
      {
        locala.ikp.setImageResource(2131232622);
        locala.GOz.setText(paramString.gIh);
      }
      parama.naN.setOnLongClickListener(c(parama1));
      parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
      parama.naN.setTag(parambl);
      AppMethodBeat.o(37317);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.e("MicroMsg.ChattingItemHardDeviceMsgPush", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambl.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37318);
    paramContextMenu.add(((bi)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(37318);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    AppMethodBeat.i(37319);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37319);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048176;
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView GOz;
    protected ImageView ikp;
    
    a() {}
    
    public final a gh(View paramView)
    {
      AppMethodBeat.i(37315);
      super.fK(paramView);
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.ikp = ((ImageView)paramView.findViewById(2131303547));
      this.GOz = ((TextView)paramView.findViewById(2131305875));
      AppMethodBeat.o(37315);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am
 * JD-Core Version:    0.7.0.1
 */