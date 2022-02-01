package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.e.a;

public final class ay
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
      localObject = new aq(paramLayoutInflater, R.i.edz);
      ((View)localObject).setTag(new a().is((View)localObject));
    }
    AppMethodBeat.o(37316);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37317);
    a locala = (a)parama;
    com.tencent.mm.aj.k localk = ao.hhH().NR(paramca.field_msgId);
    String str = paramca.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.aG(str, paramca.field_reserved);
      paramca = new by(paramca, parama1.hRi(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.fwp == 3) || (paramString.lmU == 3)))
      {
        locala.mWb.setImageResource(R.g.dnz);
        locala.yoy.setText(paramString.lmZ);
      }
      parama.clickArea.setOnLongClickListener(c(parama1));
      parama.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
      parama.clickArea.setTag(paramca);
      AppMethodBeat.o(37317);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.e("MicroMsg.ChattingItemHardDeviceMsgPush", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), Util.secPrint(str), Long.valueOf(paramca.field_msgId), paramString });
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
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(258157);
    paramo.a(((by)paramView.getTag()).position, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
    AppMethodBeat.o(258157);
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048176;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected ImageView mWb;
    protected TextView yoy;
    
    a() {}
    
    public final a is(View paramView)
    {
      AppMethodBeat.i(37315);
      super.create(paramView);
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.mWb = ((ImageView)paramView.findViewById(R.h.dRI));
      this.yoy = ((TextView)paramView.findViewById(R.h.dXt));
      AppMethodBeat.o(37315);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay
 * JD-Core Version:    0.7.0.1
 */