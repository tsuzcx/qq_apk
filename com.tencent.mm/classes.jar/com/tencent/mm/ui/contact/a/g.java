package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;

public class g
  extends a
{
  public CharSequence afkb;
  public int afkc;
  private b afkd;
  a afke;
  public CharSequence pJG;
  public String username;
  
  public g(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102952);
    this.afkc = 0;
    this.afkd = new b();
    this.afke = new a();
    AppMethodBeat.o(102952);
  }
  
  public void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102953);
    if ((this.afkc != 0) && (this.afkb != null))
    {
      AppMethodBeat.o(102953);
      return;
    }
    if (this.contact == null)
    {
      this.pJG = "";
      this.username = "";
      AppMethodBeat.o(102953);
      return;
    }
    this.pJG = p.d(paramContext, ((b)h.ax(b.class)).b(this.contact), com.tencent.mm.cd.a.br(paramContext, a.c.NormalTextSize));
    this.username = this.contact.field_username;
    AppMethodBeat.o(102953);
  }
  
  public a.b bVv()
  {
    return this.afkd;
  }
  
  protected final a.a bVw()
  {
    return this.afke;
  }
  
  public final class a
    extends a.a
  {
    public View Wuc;
    public LinearLayout afkf;
    public LinearLayout afkg;
    public ImageView lBC;
    public TextView lBD;
    public CheckBox pJL;
    public TextView plr;
    
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
      if (com.tencent.mm.cd.a.mp(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = (g.a)g.this.afke;
        paramViewGroup.lBC = ((ImageView)paramContext.findViewById(a.e.avatar_iv));
        paramViewGroup.lBD = ((TextView)paramContext.findViewById(a.e.title_tv));
        paramViewGroup.plr = ((TextView)paramContext.findViewById(a.e.desc_tv));
        paramViewGroup.plr.setVisibility(8);
        paramViewGroup.pJL = ((CheckBox)paramContext.findViewById(a.e.select_cb));
        paramViewGroup.afkf = ((LinearLayout)paramContext.findViewById(a.e.divider_container));
        paramViewGroup.afkg = ((LinearLayout)paramContext.findViewById(a.e.select_item_content_layout));
        paramViewGroup.Wuc = paramContext.findViewById(a.e.right_arrow);
        paramViewGroup.lBC.setImportantForAccessibility(2);
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
      parama.lBD.setCompoundDrawables(null, null, null, null);
      if ((g.this.afkc != 0) && (g.this.afkb != null))
      {
        parama.lBC.setImageResource(g.this.afkc);
        parama.lBD.setText(g.this.afkb);
        AppMethodBeat.o(102951);
        return;
      }
      o.a(parama1.pJG, parama.lBD);
      Object localObject;
      if (au.bwO(parama1.username))
      {
        h.baF();
        localObject = ((n)h.ax(n.class)).bzA().JE(parama1.username);
        ((e)h.ax(e.class)).a(paramContext, parama.lBD, parama1.pJG, ((az)localObject).field_openImAppid, ((az)localObject).field_descWordingId, (int)parama.lBD.getTextSize());
      }
      com.tencent.mm.pluginsdk.ui.a.b.g(parama.lBC, parama1.username);
      if (ab.IG(parama1.username))
      {
        localObject = paramContext.getResources().getDrawable(a.g.open_im_main_logo);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        parama.lBD.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
        if (!au.bwz(parama1.username)) {
          break label362;
        }
        parama.Wuc.setVisibility(0);
        label250:
        if (!TextUtils.isEmpty(parama1.desc)) {
          break label374;
        }
        parama.plr.setVisibility(8);
        label269:
        if (!g.this.afey) {
          break label478;
        }
        if (!au.bwz(parama1.username)) {
          break label396;
        }
        parama.pJL.setVisibility(4);
      }
      for (;;)
      {
        if (g.this.afjC) {
          parama.afkf.setBackground(null);
        }
        if (!g.this.afjD) {
          break label490;
        }
        parama.afkg.setBackgroundColor(paramContext.getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_97));
        AppMethodBeat.o(102951);
        return;
        parama.lBD.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break;
        label362:
        parama.Wuc.setVisibility(8);
        break label250;
        label374:
        parama.plr.setVisibility(0);
        parama.plr.setText(parama1.desc);
        break label269;
        label396:
        int i;
        if (paramBoolean1)
        {
          parama.pJL.setChecked(true);
          parama.pJL.setEnabled(false);
          parama1 = parama.pJL;
          if (aw.isDarkMode())
          {
            i = a.g.checkbox_selected_grey_dark;
            label433:
            parama1.setBackgroundResource(i);
          }
        }
        for (;;)
        {
          parama.pJL.setVisibility(0);
          break;
          i = a.g.checkbox_selected_grey;
          break label433;
          parama.pJL.setChecked(paramBoolean2);
          parama.pJL.setEnabled(true);
        }
        label478:
        parama.pJL.setVisibility(8);
      }
      label490:
      parama.afkg.setBackground(null);
      AppMethodBeat.o(102951);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.g
 * JD-Core Version:    0.7.0.1
 */