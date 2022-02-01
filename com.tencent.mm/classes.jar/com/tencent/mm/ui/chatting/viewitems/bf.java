package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class bf
  extends c
{
  private bg XkK;
  private bc XkL;
  private bh XkM;
  private bq XkN;
  
  public bf()
  {
    AppMethodBeat.i(37376);
    this.XkK = new bg();
    this.XkL = new bc();
    this.XkM = new bh();
    this.XkN = new bq();
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
      localView = paramLayoutInflater.inflate(R.i.edF, null);
      paramLayoutInflater = new b();
      paramLayoutInflater.convertView = localView;
      paramLayoutInflater.timeTV = ((TextView)localView.findViewById(R.h.dzs));
      paramLayoutInflater.noMoreMsgTip = localView.findViewById(R.h.dyR);
      paramLayoutInflater.XkO = ((MMNeat7extView)localView.findViewById(R.h.chatting_content_itv));
      paramLayoutInflater.XkO.setOnTouchListener(new h(paramLayoutInflater.XkO, new com.tencent.mm.pluginsdk.ui.span.o(paramLayoutInflater.XkO.getContext())));
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37377);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37378);
    if ((paramca.getType() == 10002) || (paramca.getType() == 268445458)) {
      paramString = this.XkL;
    }
    for (;;)
    {
      paramString.b(parama, paramInt, parama1, paramca);
      AppMethodBeat.o(37378);
      return;
      if (paramca.getType() == 570425393) {
        paramString = this.XkM;
      } else if (paramca.getType() == 603979825) {
        paramString = this.XkN;
      } else {
        paramString = this.XkK;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 10000) || (paramInt == 10002) || (paramInt == 570425393) || (paramInt == 64) || (paramInt == 603979825) || (paramInt == 268445456) || (paramInt == 268445458);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  protected final boolean hTE()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void b(c.a parama, int paramInt, a parama1, ca paramca);
  }
  
  final class b
    extends c.a
  {
    NeatTextView XkO;
    View convertView;
    
    b() {}
    
    public final View getMainContainerView()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bf
 * JD-Core Version:    0.7.0.1
 */