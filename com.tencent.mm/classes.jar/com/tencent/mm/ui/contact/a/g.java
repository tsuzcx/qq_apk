package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;

public class g
  extends a
{
  public CharSequence XxU;
  public int XxV;
  private b XxW;
  a XxX;
  public CharSequence mMY;
  public String username;
  
  public g(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102952);
    this.XxV = 0;
    this.XxW = new b();
    this.XxX = new a();
    AppMethodBeat.o(102952);
  }
  
  public void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102953);
    if ((this.XxV != 0) && (this.XxU != null))
    {
      AppMethodBeat.o(102953);
      return;
    }
    if (this.contact == null)
    {
      this.mMY = "";
      this.username = "";
      AppMethodBeat.o(102953);
      return;
    }
    this.mMY = l.d(paramContext, ((b)h.ae(b.class)).b(this.contact), com.tencent.mm.ci.a.aY(paramContext, a.c.NormalTextSize));
    this.username = this.contact.field_username;
    AppMethodBeat.o(102953);
  }
  
  public a.b bwF()
  {
    return this.XxW;
  }
  
  protected final a.a bwG()
  {
    return this.XxX;
  }
  
  public final class a
    extends a.a
  {
    public ImageView iZG;
    public TextView iZH;
    public CheckBox mNd;
    public TextView mrM;
    
    public a()
    {
      super();
    }
  }
  
  public class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102950);
      if (com.tencent.mm.ci.a.ko(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = (g.a)g.this.XxX;
        paramViewGroup.iZG = ((ImageView)paramContext.findViewById(a.e.avatar_iv));
        paramViewGroup.iZH = ((TextView)paramContext.findViewById(a.e.title_tv));
        paramViewGroup.mrM = ((TextView)paramContext.findViewById(a.e.desc_tv));
        paramViewGroup.mrM.setVisibility(8);
        paramViewGroup.mNd = ((CheckBox)paramContext.findViewById(a.e.select_cb));
        paramContext.setTag(paramViewGroup);
        AppMethodBeat.o(102950);
        return paramContext;
      }
    }
    
    public void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102951);
      parama1 = (g)parama1;
      parama = (g.a)parama;
      parama.iZH.setCompoundDrawables(null, null, null, null);
      if ((g.this.XxV != 0) && (g.this.XxU != null))
      {
        parama.iZG.setImageResource(g.this.XxV);
        parama.iZH.setText(g.this.XxU);
        AppMethodBeat.o(102951);
        return;
      }
      com.tencent.mm.plugin.fts.ui.n.a(parama1.mMY, parama.iZH);
      if (as.bvK(parama1.username))
      {
        h.aHH();
        as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(parama1.username);
        ((com.tencent.mm.openim.a.a)h.ae(com.tencent.mm.openim.a.a.class)).a(paramContext, parama.iZH, parama1.mMY, localas.field_openImAppid, localas.field_descWordingId, (int)parama.iZH.getTextSize());
      }
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.iZG, parama1.username);
      int i;
      if (ab.PR(parama1.username))
      {
        paramContext = paramContext.getResources().getDrawable(a.g.open_im_main_logo);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.iZH.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        if (!g.this.XsX) {
          break label336;
        }
        if (!paramBoolean1) {
          break label316;
        }
        parama.mNd.setChecked(true);
        parama.mNd.setEnabled(false);
        paramContext = parama.mNd;
        if (!ar.isDarkMode()) {
          break label308;
        }
        i = a.g.checkbox_selected_grey_dark;
        label274:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.mNd.setVisibility(0);
        AppMethodBeat.o(102951);
        return;
        parama.iZH.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break;
        label308:
        i = a.g.checkbox_selected_grey;
        break label274;
        label316:
        parama.mNd.setChecked(paramBoolean2);
        parama.mNd.setEnabled(true);
      }
      label336:
      parama.mNd.setVisibility(8);
      AppMethodBeat.o(102951);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.g
 * JD-Core Version:    0.7.0.1
 */