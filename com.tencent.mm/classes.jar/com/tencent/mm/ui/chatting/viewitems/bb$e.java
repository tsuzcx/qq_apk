package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.d.a;

public final class bb$e
  extends bb.b
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37525);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new af(paramLayoutInflater, 2131493506);
      ((View)localObject).setTag(new bb.i().ge((View)localObject));
    }
    AppMethodBeat.o(37525);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37526);
    bb.i.a((bb.i)parama, parambl, false, paramInt, parama1, o(parama1), c(parama1));
    AppMethodBeat.o(37526);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 53);
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bb.e
 * JD-Core Version:    0.7.0.1
 */