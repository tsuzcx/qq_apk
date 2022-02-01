package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class l
  extends a
{
  public boolean AUY;
  a.a Xyh;
  private b Xyj;
  public int resId;
  
  public l(int paramInt)
  {
    super(1, paramInt);
    AppMethodBeat.i(102967);
    this.Xyj = new b();
    this.Xyh = new a();
    AppMethodBeat.o(102967);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b bwF()
  {
    return this.Xyj;
  }
  
  protected final a.a bwG()
  {
    return this.Xyh;
  }
  
  public final class a
    extends a.a
  {
    public TextView Aba;
    public ImageView BOy;
    
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
      paramViewGroup = (l.a)l.this.Xyh;
      paramViewGroup.Aba = ((TextView)paramContext.findViewById(a.e.more_tv));
      paramViewGroup.BOy = ((ImageView)paramContext.findViewById(a.e.more_arrow));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102965);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102966);
      parama = (l.a)parama;
      parama1 = (l)parama1;
      paramContext = paramContext.getResources();
      if (l.this.AUY)
      {
        n.a(paramContext.getString(a.h.search_more_contact, new Object[] { paramContext.getString(parama1.resId) }), parama.Aba);
        parama.BOy.setRotation(0.0F);
        AppMethodBeat.o(102966);
        return;
      }
      n.a(paramContext.getString(a.h.search_more_contact_collapse), parama.Aba);
      parama.BOy.setRotation(180.0F);
      AppMethodBeat.o(102966);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.l
 * JD-Core Version:    0.7.0.1
 */