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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.al;

public class f
  extends a
{
  public CharSequence Krd;
  public int Kre;
  private b Krf;
  a Krg;
  public CharSequence iVn;
  public String username;
  
  public f(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102952);
    this.Kre = 0;
    this.Krf = new b();
    this.Krg = new a();
    AppMethodBeat.o(102952);
  }
  
  public void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102953);
    if ((this.Kre != 0) && (this.Krd != null))
    {
      AppMethodBeat.o(102953);
      return;
    }
    if (this.contact == null)
    {
      this.iVn = "";
      this.username = "";
      AppMethodBeat.o(102953);
      return;
    }
    this.iVn = k.b(paramContext, ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact), com.tencent.mm.cc.a.ax(paramContext, 2131165517));
    this.username = this.contact.field_username;
    AppMethodBeat.o(102953);
  }
  
  public a.b aRs()
  {
    return this.Krf;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fOf;
    public TextView fOg;
    public TextView iCV;
    public CheckBox iVs;
    
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
      if (com.tencent.mm.cc.a.im(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (f.a)f.this.Krg;
        paramViewGroup.fOf = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.fOg = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.iCV = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.iCV.setVisibility(8);
        paramViewGroup.iVs = ((CheckBox)paramContext.findViewById(2131304502));
        paramContext.setTag(paramViewGroup);
        AppMethodBeat.o(102950);
        return paramContext;
      }
    }
    
    public void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102951);
      parama1 = (f)parama1;
      parama = (f.a)parama;
      parama.fOg.setCompoundDrawables(null, null, null, null);
      if ((f.this.Kre != 0) && (f.this.Krd != null))
      {
        parama.fOf.setImageResource(f.this.Kre);
        parama.fOg.setText(f.this.Krd);
        AppMethodBeat.o(102951);
        return;
      }
      n.a(parama1.iVn, parama.fOg);
      if (am.aSQ(parama1.username))
      {
        g.ajD();
        am localam = ((l)g.ab(l.class)).azp().Bf(parama1.username);
        ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(paramContext, parama.fOg, parama1.iVn, localam.field_openImAppid, localam.field_descWordingId, (int)parama.fOg.getTextSize());
      }
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.fOf, parama1.username);
      int i;
      if (w.zm(parama1.username))
      {
        paramContext = paramContext.getResources().getDrawable(2131691000);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.fOg.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        if (!f.this.KmP) {
          break label333;
        }
        if (!paramBoolean1) {
          break label313;
        }
        parama.iVs.setChecked(true);
        parama.iVs.setEnabled(false);
        paramContext = parama.iVs;
        if (!al.isDarkMode()) {
          break label306;
        }
        i = 2131689939;
        label272:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.iVs.setVisibility(0);
        AppMethodBeat.o(102951);
        return;
        parama.fOg.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break;
        label306:
        i = 2131689938;
        break label272;
        label313:
        parama.iVs.setChecked(paramBoolean2);
        parama.iVs.setEnabled(true);
      }
      label333:
      parama.iVs.setVisibility(8);
      AppMethodBeat.o(102951);
    }
    
    public final boolean aRt()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f
 * JD-Core Version:    0.7.0.1
 */