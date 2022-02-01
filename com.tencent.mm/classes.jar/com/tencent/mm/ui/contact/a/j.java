package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.m;

public final class j
  extends a
{
  a.a IAj;
  private b IAl;
  public boolean rVH;
  public int resId;
  
  public j(int paramInt)
  {
    super(1, paramInt);
    AppMethodBeat.i(102967);
    this.IAl = new b();
    this.IAj = new a();
    AppMethodBeat.o(102967);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b aOg()
  {
    return this.IAl;
  }
  
  public final class a
    extends a.a
  {
    public TextView rAS;
    public ImageView sDT;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131495364, paramViewGroup, false);
      paramViewGroup = (j.a)j.this.IAj;
      paramViewGroup.rAS = ((TextView)paramContext.findViewById(2131302483));
      paramViewGroup.sDT = ((ImageView)paramContext.findViewById(2131302455));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102965);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102966);
      parama = (j.a)parama;
      parama1 = (j)parama1;
      paramContext = paramContext.getResources();
      if (j.this.rVH)
      {
        m.a(paramContext.getString(2131762958, new Object[] { paramContext.getString(parama1.resId) }), parama.rAS);
        parama.sDT.setRotation(0.0F);
        AppMethodBeat.o(102966);
        return;
      }
      m.a(paramContext.getString(2131762959), parama.rAS);
      parama.sDT.setRotation(180.0F);
      AppMethodBeat.o(102966);
    }
    
    public final boolean aOh()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.j
 * JD-Core Version:    0.7.0.1
 */