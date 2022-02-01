package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static Map<String, c> GgL;
  public String GgK;
  private b GgM;
  a GgN;
  public CharSequence ibW;
  public long mUQ;
  public String username;
  
  static
  {
    AppMethodBeat.i(102808);
    GgL = new HashMap();
    AppMethodBeat.o(102808);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102805);
    this.mUQ = -1L;
    this.GgM = new b();
    this.GgN = new a();
    AppMethodBeat.o(102805);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    AppMethodBeat.i(102806);
    this.ibW = k.b(paramContext, this.ibW, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
    AppMethodBeat.o(102806);
  }
  
  public final com.tencent.mm.ui.contact.a.a.b aHr()
  {
    return this.GgM;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView frr;
    public TextView frs;
    public TextView hJe;
    
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
      if (com.tencent.mm.cd.a.hS(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (a.a)a.this.GgN;
        paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.frs = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.hJe = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.hJe.setVisibility(8);
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
      m.a(paramContext.ibW, parama.frs);
      o.ayJ().a(paramContext.GgK, parama.frr, a.aKq(paramContext.username));
      AppMethodBeat.o(102804);
    }
    
    public final boolean aHs()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.a
 * JD-Core Version:    0.7.0.1
 */