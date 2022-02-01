package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.pluginsdk.ui.span.l;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static Map<String, c> Wtz;
  private b WtA;
  a WtB;
  public String kLW;
  public CharSequence mMY;
  public long syu;
  public String username;
  
  static
  {
    AppMethodBeat.i(102808);
    Wtz = new HashMap();
    AppMethodBeat.o(102808);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102805);
    this.syu = -1L;
    this.WtA = new b();
    this.WtB = new a();
    AppMethodBeat.o(102805);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    AppMethodBeat.i(102806);
    this.mMY = l.d(paramContext, this.mMY, com.tencent.mm.ci.a.aY(paramContext, a.c.NormalTextSize));
    AppMethodBeat.o(102806);
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bwF()
  {
    return this.WtA;
  }
  
  public final com.tencent.mm.ui.contact.a.a.a bwG()
  {
    return this.WtB;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView iZG;
    public TextView iZH;
    public TextView mrM;
    
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
      if (com.tencent.mm.ci.a.ko(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = (a.a)a.this.WtB;
        paramViewGroup.iZG = ((ImageView)paramContext.findViewById(a.e.avatar_iv));
        paramViewGroup.iZH = ((TextView)paramContext.findViewById(a.e.title_tv));
        paramViewGroup.mrM = ((TextView)paramContext.findViewById(a.e.desc_tv));
        paramViewGroup.mrM.setVisibility(8);
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
      n.a(paramContext.mMY, parama.iZH);
      q.bml().a(paramContext.kLW, parama.iZG, a.byN(paramContext.username));
      AppMethodBeat.o(102804);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.ui.contact.a.a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.a
 * JD-Core Version:    0.7.0.1
 */