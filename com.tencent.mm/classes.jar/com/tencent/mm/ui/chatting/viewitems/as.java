package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class as
  extends c
{
  private at GPf;
  private aq GPg;
  private au GPh;
  private bd GPi;
  
  public as()
  {
    AppMethodBeat.i(37376);
    this.GPf = new at();
    this.GPg = new aq();
    this.GPh = new au();
    this.GPi = new bd();
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
      paramLayoutInflater.rLd = localView;
      paramLayoutInflater.fwS = ((TextView)localView.findViewById(2131298178));
      paramLayoutInflater.GPj = ((MMNeat7extView)localView.findViewById(2131298073));
      paramLayoutInflater.GPj.setOnTouchListener(new g(paramLayoutInflater.GPj, new n(paramLayoutInflater.GPj.getContext())));
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37377);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37378);
    if (parambl.getType() == 10002) {
      paramString = this.GPg;
    }
    for (;;)
    {
      paramString.b(parama, paramInt, parama1, parambl);
      AppMethodBeat.o(37378);
      return;
      if (parambl.getType() == 570425393) {
        paramString = this.GPh;
      } else if (parambl.getType() == 603979825) {
        paramString = this.GPi;
      } else {
        paramString = this.GPf;
      }
    }
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
    return (paramInt == 10000) || (paramInt == 10002) || (paramInt == 570425393) || (paramInt == 64) || (paramInt == 603979825);
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    return false;
  }
  
  protected final boolean faD()
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void b(c.a parama, int paramInt, a parama1, bl parambl);
  }
  
  final class b
    extends c.a
  {
    NeatTextView GPj;
    View rLd;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as
 * JD-Core Version:    0.7.0.1
 */