package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.e.a;

public final class au
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
      localObject = new an(paramLayoutInflater, 2131493570);
      ((View)localObject).setTag(new a().hg((View)localObject));
    }
    AppMethodBeat.o(37316);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37317);
    a locala = (a)parama;
    com.tencent.mm.ag.k localk = ao.gnf().GL(paramca.field_msgId);
    String str = paramca.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.aD(str, paramca.field_reserved);
      paramca = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.dDG == 3) || (paramString.ixF == 3)))
      {
        locala.keC.setImageResource(2131233024);
        locala.POc.setText(paramString.ixK);
      }
      parama.clickArea.setOnLongClickListener(c(parama1));
      parama.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
      parama.clickArea.setTag(paramca);
      AppMethodBeat.o(37317);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.e("MicroMsg.ChattingItemHardDeviceMsgPush", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(paramca.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37319);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37319);
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233909);
    paramm.a(((bq)paramView.getTag()).position, 100, paramView.getContext().getString(2131757433), 2131690529);
    AppMethodBeat.o(233909);
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048176;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView POc;
    protected ImageView keC;
    
    a() {}
    
    public final a hg(View paramView)
    {
      AppMethodBeat.i(37315);
      super.create(paramView);
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.keC = ((ImageView)paramView.findViewById(2131306322));
      this.POc = ((TextView)paramView.findViewById(2131309157));
      AppMethodBeat.o(37315);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.au
 * JD-Core Version:    0.7.0.1
 */