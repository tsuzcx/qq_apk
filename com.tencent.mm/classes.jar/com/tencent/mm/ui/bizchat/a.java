package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static Map<String, c> vew = new HashMap();
  public CharSequence eXK;
  public long idK = -1L;
  public String username;
  public String vev;
  private b vex = new b();
  a.a vey = new a.a(this);
  
  public a(int paramInt)
  {
    super(4, paramInt);
  }
  
  protected final com.tencent.mm.ui.contact.a.a.a VA()
  {
    return this.vey;
  }
  
  public final com.tencent.mm.ui.contact.a.a.b Vz()
  {
    return this.vex;
  }
  
  public final void bW(Context paramContext)
  {
    this.eXK = j.b(paramContext, this.eXK, com.tencent.mm.cb.a.aa(paramContext, a.c.NormalTextSize));
  }
  
  public final class b
    extends com.tencent.mm.ui.contact.a.a.b
  {
    public b()
    {
      super();
    }
    
    public final boolean VB()
    {
      return false;
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      if (com.tencent.mm.cb.a.fh(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = (a.a)a.this.vey;
        paramViewGroup.doU = ((ImageView)paramContext.findViewById(a.e.avatar_iv));
        paramViewGroup.doV = ((TextView)paramContext.findViewById(a.e.title_tv));
        paramViewGroup.eXP = ((TextView)paramContext.findViewById(a.e.desc_tv));
        paramViewGroup.eXP.setVisibility(8);
        paramContext.setTag(paramViewGroup);
        return paramContext;
      }
    }
    
    public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramContext = (a)parama1;
      parama = (a.a)parama;
      m.a(paramContext.eXK, parama.doV);
      o.ON().a(paramContext.vev, parama.doU, a.adi(paramContext.username));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.a
 * JD-Core Version:    0.7.0.1
 */