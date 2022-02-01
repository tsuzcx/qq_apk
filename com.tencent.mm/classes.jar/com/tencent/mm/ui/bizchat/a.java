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
import com.tencent.mm.pluginsdk.ui.span.l;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static Map<String, c> Pam;
  private b Pan;
  a Pao;
  public String hXq;
  public CharSequence jVL;
  public long ppv;
  public String username;
  
  static
  {
    AppMethodBeat.i(102808);
    Pam = new HashMap();
    AppMethodBeat.o(102808);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102805);
    this.ppv = -1L;
    this.Pan = new b();
    this.Pao = new a();
    AppMethodBeat.o(102805);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    AppMethodBeat.i(102806);
    this.jVL = l.e(paramContext, this.jVL, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
    AppMethodBeat.o(102806);
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bmx()
  {
    return this.Pan;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView gvv;
    public TextView gvw;
    public TextView jBR;
    
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
      if (com.tencent.mm.cb.a.jk(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131496221, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131496220, paramViewGroup, false))
      {
        paramViewGroup = (a.a)a.this.Pao;
        paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
        paramViewGroup.gvw = ((TextView)paramContext.findViewById(2131309249));
        paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
        paramViewGroup.jBR.setVisibility(8);
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
      n.a(paramContext.jVL, parama.gvw);
      q.bcV().a(paramContext.hXq, parama.gvv, a.bmo(paramContext.username));
      AppMethodBeat.o(102804);
    }
    
    public final boolean bmy()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.a
 * JD-Core Version:    0.7.0.1
 */