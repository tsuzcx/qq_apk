package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class m
  extends a
{
  public boolean Gxy;
  a.a afku;
  private b afkw;
  public int resId;
  
  public m(int paramInt)
  {
    super(1, paramInt);
    AppMethodBeat.i(102967);
    this.afkw = new b();
    this.afku = new a();
    AppMethodBeat.o(102967);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b bVv()
  {
    return this.afkw;
  }
  
  protected final a.a bVw()
  {
    return this.afku;
  }
  
  public final class a
    extends a.a
  {
    public TextView FwJ;
    public ImageView HAo;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102965);
      paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listmoreitem, paramViewGroup, false);
      paramViewGroup = (m.a)m.this.afku;
      paramViewGroup.FwJ = ((TextView)paramContext.findViewById(a.e.more_tv));
      paramViewGroup.HAo = ((ImageView)paramContext.findViewById(a.e.more_arrow));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102965);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102966);
      parama = (m.a)parama;
      parama1 = (m)parama1;
      paramContext = paramContext.getResources();
      if (m.this.Gxy)
      {
        o.b(paramContext.getString(a.h.search_more_contact, new Object[] { paramContext.getString(parama1.resId) }), parama.FwJ);
        parama.HAo.setRotation(0.0F);
        AppMethodBeat.o(102966);
        return;
      }
      o.b(paramContext.getString(a.h.search_more_contact_collapse), parama.FwJ);
      parama.HAo.setRotation(180.0F);
      AppMethodBeat.o(102966);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.m
 * JD-Core Version:    0.7.0.1
 */