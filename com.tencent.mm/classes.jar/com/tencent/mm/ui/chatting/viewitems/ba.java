package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class ba
  extends c
{
  private bb POI;
  private ay POJ;
  private bc POK;
  private bl POL;
  
  public ba()
  {
    AppMethodBeat.i(37376);
    this.POI = new bb();
    this.POJ = new ay();
    this.POK = new bc();
    this.POL = new bl();
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
      localView = paramLayoutInflater.inflate(2131493576, null);
      paramLayoutInflater = new b();
      paramLayoutInflater.convertView = localView;
      paramLayoutInflater.timeTV = ((TextView)localView.findViewById(2131298558));
      paramLayoutInflater.noMoreMsgTip = localView.findViewById(2131298529);
      paramLayoutInflater.POM = ((MMNeat7extView)localView.findViewById(2131298416));
      paramLayoutInflater.POM.setOnTouchListener(new h(paramLayoutInflater.POM, new o(paramLayoutInflater.POM.getContext())));
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37377);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37378);
    if (paramca.getType() == 10002) {
      paramString = this.POJ;
    }
    for (;;)
    {
      paramString.b(parama, paramInt, parama1, paramca);
      AppMethodBeat.o(37378);
      return;
      if (paramca.getType() == 570425393) {
        paramString = this.POK;
      } else if (paramca.getType() == 603979825) {
        paramString = this.POL;
      } else {
        paramString = this.POI;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 10000) || (paramInt == 10002) || (paramInt == 570425393) || (paramInt == 64) || (paramInt == 603979825);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  protected final boolean gTU()
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
    NeatTextView POM;
    View convertView;
    
    b() {}
    
    public final View getMainContainerView()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba
 * JD-Core Version:    0.7.0.1
 */