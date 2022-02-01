package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.pluginsdk.ui.span.k;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static Map<String, c> JPg;
  private b JPh;
  a JPi;
  public String heD;
  public CharSequence iYg;
  public long oex;
  public String username;
  
  static
  {
    AppMethodBeat.i(102808);
    JPg = new HashMap();
    AppMethodBeat.o(102808);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102805);
    this.oex = -1L;
    this.JPh = new b();
    this.JPi = new a();
    AppMethodBeat.o(102805);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    AppMethodBeat.i(102806);
    this.iYg = k.b(paramContext, this.iYg, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
    AppMethodBeat.o(102806);
  }
  
  public final com.tencent.mm.ui.contact.a.a.b aRR()
  {
    return this.JPh;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView fQl;
    public TextView fQm;
    public TextView iFO;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends com.tencent.mm.ui.contact.a.a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102803);
      if (com.tencent.mm.cb.a.ir(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (a.a)a.this.JPi;
        paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.fQm = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.iFO.setVisibility(8);
        paramContext.setTag(paramViewGroup);
        AppMethodBeat.o(102803);
        return paramContext;
      }
    }
    
    public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102804);
      paramContext = (a)parama1;
      parama = (a.a)parama;
      n.a(paramContext.iYg, parama.fQm);
      q.aJb().a(paramContext.heD, parama.fQl, a.aXk(paramContext.username));
      AppMethodBeat.o(102804);
    }
    
    public final boolean aRS()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.a
 * JD-Core Version:    0.7.0.1
 */