package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class au
  extends c
{
  private av KfH;
  private as KfI;
  private aw KfJ;
  private bf KfK;
  
  public au()
  {
    AppMethodBeat.i(37376);
    this.KfH = new av();
    this.KfI = new as();
    this.KfJ = new aw();
    this.KfK = new bf();
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
      paramLayoutInflater.tPw = localView;
      paramLayoutInflater.fTP = ((TextView)localView.findViewById(2131298178));
      paramLayoutInflater.JYr = localView.findViewById(2131308258);
      paramLayoutInflater.KfL = ((MMNeat7extView)localView.findViewById(2131298073));
      paramLayoutInflater.KfL.setOnTouchListener(new g(paramLayoutInflater.KfL, new n(paramLayoutInflater.KfL.getContext())));
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37377);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37378);
    if (parambu.getType() == 10002) {
      paramString = this.KfI;
    }
    for (;;)
    {
      paramString.b(parama, paramInt, parama1, parambu);
      AppMethodBeat.o(37378);
      return;
      if (parambu.getType() == 570425393) {
        paramString = this.KfJ;
      } else if (parambu.getType() == 603979825) {
        paramString = this.KfK;
      } else {
        paramString = this.KfH;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    return false;
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 10000) || (paramInt == 10002) || (paramInt == 570425393) || (paramInt == 64) || (paramInt == 603979825);
  }
  
  protected final boolean fHg()
  {
    return false;
  }
  
  public final boolean fHh()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void b(c.a parama, int paramInt, a parama1, bu parambu);
  }
  
  final class b
    extends c.a
  {
    NeatTextView KfL;
    View tPw;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.au
 * JD-Core Version:    0.7.0.1
 */