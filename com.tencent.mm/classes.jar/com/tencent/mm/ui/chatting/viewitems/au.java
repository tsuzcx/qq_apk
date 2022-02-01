package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class au
  extends c
{
  private av KCa;
  private as KCb;
  private aw KCc;
  private bf KCd;
  
  public au()
  {
    AppMethodBeat.i(37376);
    this.KCa = new av();
    this.KCb = new as();
    this.KCc = new aw();
    this.KCd = new bf();
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
      paramLayoutInflater.uan = localView;
      paramLayoutInflater.fVV = ((TextView)localView.findViewById(2131298178));
      paramLayoutInflater.KuK = localView.findViewById(2131308258);
      paramLayoutInflater.KCe = ((MMNeat7extView)localView.findViewById(2131298073));
      paramLayoutInflater.KCe.setOnTouchListener(new g(paramLayoutInflater.KCe, new n(paramLayoutInflater.KCe.getContext())));
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37377);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37378);
    if (parambv.getType() == 10002) {
      paramString = this.KCb;
    }
    for (;;)
    {
      paramString.b(parama, paramInt, parama1, parambv);
      AppMethodBeat.o(37378);
      return;
      if (parambv.getType() == 570425393) {
        paramString = this.KCc;
      } else if (parambv.getType() == 603979825) {
        paramString = this.KCd;
      } else {
        paramString = this.KCa;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    return false;
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 10000) || (paramInt == 10002) || (paramInt == 570425393) || (paramInt == 64) || (paramInt == 603979825);
  }
  
  protected final boolean fLy()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void b(c.a parama, int paramInt, a parama1, bv parambv);
  }
  
  final class b
    extends c.a
  {
    NeatTextView KCe;
    View uan;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.au
 * JD-Core Version:    0.7.0.1
 */