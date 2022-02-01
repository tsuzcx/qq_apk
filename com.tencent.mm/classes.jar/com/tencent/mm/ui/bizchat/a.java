package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static Map<String, c> aeaS;
  private b aeaT;
  a aeaU;
  public String nnS;
  public CharSequence pJG;
  public String username;
  public long vEb;
  
  static
  {
    AppMethodBeat.i(102808);
    aeaS = new HashMap();
    AppMethodBeat.o(102808);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102805);
    this.vEb = -1L;
    this.aeaT = new b();
    this.aeaU = new a();
    AppMethodBeat.o(102805);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    AppMethodBeat.i(102806);
    this.pJG = p.d(paramContext, this.pJG, com.tencent.mm.cd.a.br(paramContext, a.c.NormalTextSize));
    AppMethodBeat.o(102806);
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bVv()
  {
    return this.aeaT;
  }
  
  public final com.tencent.mm.ui.contact.a.a.a bVw()
  {
    return this.aeaU;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView lBC;
    public TextView lBD;
    public TextView plr;
    
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
      if (com.tencent.mm.cd.a.mp(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = (a.a)a.this.aeaU;
        paramViewGroup.lBC = ((ImageView)paramContext.findViewById(a.e.avatar_iv));
        paramViewGroup.lBD = ((TextView)paramContext.findViewById(a.e.title_tv));
        paramViewGroup.plr = ((TextView)paramContext.findViewById(a.e.desc_tv));
        paramViewGroup.plr.setVisibility(8);
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
      o.a(paramContext.pJG, parama.lBD);
      r.bKe().a(paramContext.nnS, parama.lBC, a.bAq(paramContext.username));
      AppMethodBeat.o(102804);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.ui.contact.a.a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.a
 * JD-Core Version:    0.7.0.1
 */