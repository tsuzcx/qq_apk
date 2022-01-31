package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class aj
  extends c
{
  private ak zWO;
  private ah zWP;
  private al zWQ;
  private au zWR;
  
  public aj()
  {
    AppMethodBeat.i(33279);
    this.zWO = new ak();
    this.zWP = new ah();
    this.zWQ = new al();
    this.zWR = new au();
    AppMethodBeat.o(33279);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33280);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2130969101, null);
      paramLayoutInflater = new aj.b(this);
      paramLayoutInflater.ngZ = localView;
      paramLayoutInflater.ekh = ((TextView)localView.findViewById(2131820587));
      paramLayoutInflater.zWS = ((MMNeat7extView)localView.findViewById(2131821123));
      paramLayoutInflater.zWS.setOnTouchListener(new f(paramLayoutInflater.zWS, new m(paramLayoutInflater.zWS.getContext())));
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(33280);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33281);
    if (parambi.getType() == 10002) {
      paramString = this.zWP;
    }
    for (;;)
    {
      paramString.b(parama, paramInt, parama1, parambi);
      AppMethodBeat.o(33281);
      return;
      if (parambi.getType() == 570425393) {
        paramString = this.zWQ;
      } else if (parambi.getType() == 603979825) {
        paramString = this.zWR;
      } else {
        paramString = this.zWO;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 10000) || (paramInt == 10002) || (paramInt == 570425393) || (paramInt == 64) || (paramInt == 603979825);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  protected final boolean dLo()
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj
 * JD-Core Version:    0.7.0.1
 */