package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static Map<String, c> HGA;
  private b HGB;
  a HGC;
  public String gIf;
  public CharSequence iCd;
  public long nxq;
  public String username;
  
  static
  {
    AppMethodBeat.i(102808);
    HGA = new HashMap();
    AppMethodBeat.o(102808);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102805);
    this.nxq = -1L;
    this.HGB = new b();
    this.HGC = new a();
    AppMethodBeat.o(102805);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    AppMethodBeat.i(102806);
    this.iCd = k.b(paramContext, this.iCd, com.tencent.mm.cc.a.au(paramContext, 2131165517));
    AppMethodBeat.o(102806);
  }
  
  public final com.tencent.mm.ui.contact.a.a.b aOg()
  {
    return this.HGB;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView fuY;
    public TextView fuZ;
    public TextView ijE;
    
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
      if (com.tencent.mm.cc.a.id(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (a.a)a.this.HGC;
        paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.fuZ = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.ijE.setVisibility(8);
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
      m.a(paramContext.iCd, parama.fuZ);
      o.aFB().a(paramContext.gIf, parama.fuY, a.aPT(paramContext.username));
      AppMethodBeat.o(102804);
    }
    
    public final boolean aOh()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.a
 * JD-Core Version:    0.7.0.1
 */