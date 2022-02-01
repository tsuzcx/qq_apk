package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class at
  extends c
{
  private au Iph;
  private ar Ipi;
  private av Ipj;
  private be Ipk;
  
  public at()
  {
    AppMethodBeat.i(37376);
    this.Iph = new au();
    this.Ipi = new ar();
    this.Ipj = new av();
    this.Ipk = new be();
    AppMethodBeat.o(37376);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37377);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2131493474, null);
      paramLayoutInflater = new b();
      paramLayoutInflater.sSS = localView;
      paramLayoutInflater.fAz = ((TextView)localView.findViewById(2131298178));
      paramLayoutInflater.Ipl = ((MMNeat7extView)localView.findViewById(2131298073));
      paramLayoutInflater.Ipl.setOnTouchListener(new g(paramLayoutInflater.Ipl, new n(paramLayoutInflater.Ipl.getContext())));
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37377);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37378);
    if (parambo.getType() == 10002) {
      paramString = this.Ipi;
    }
    for (;;)
    {
      paramString.b(parama, paramInt, parama1, parambo);
      AppMethodBeat.o(37378);
      return;
      if (parambo.getType() == 570425393) {
        paramString = this.Ipj;
      } else if (parambo.getType() == 603979825) {
        paramString = this.Ipk;
      } else {
        paramString = this.Iph;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 10000) || (paramInt == 10002) || (paramInt == 570425393) || (paramInt == 64) || (paramInt == 603979825);
  }
  
  protected final boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void b(c.a parama, int paramInt, a parama1, bo parambo);
  }
  
  final class b
    extends c.a
  {
    NeatTextView Ipl;
    View sSS;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at
 * JD-Core Version:    0.7.0.1
 */