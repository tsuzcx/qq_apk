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
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.al;

public class f
  extends a
{
  a KNA;
  public CharSequence KNx;
  public int KNy;
  private b KNz;
  public CharSequence iYg;
  public String username;
  
  public f(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102952);
    this.KNy = 0;
    this.KNz = new b();
    this.KNA = new a();
    AppMethodBeat.o(102952);
  }
  
  public void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102953);
    if ((this.KNy != 0) && (this.KNx != null))
    {
      AppMethodBeat.o(102953);
      return;
    }
    if (this.contact == null)
    {
      this.iYg = "";
      this.username = "";
      AppMethodBeat.o(102953);
      return;
    }
    this.iYg = k.b(paramContext, ((b)g.ab(b.class)).b(this.contact), com.tencent.mm.cb.a.ax(paramContext, 2131165517));
    this.username = this.contact.field_username;
    AppMethodBeat.o(102953);
  }
  
  public a.b aRR()
  {
    return this.KNz;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fQl;
    public TextView fQm;
    public TextView iFO;
    public CheckBox iYl;
    
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
      if (com.tencent.mm.cb.a.ir(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (f.a)f.this.KNA;
        paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.fQm = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.iFO.setVisibility(8);
        paramViewGroup.iYl = ((CheckBox)paramContext.findViewById(2131304502));
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
      parama.fQm.setCompoundDrawables(null, null, null, null);
      if ((f.this.KNy != 0) && (f.this.KNx != null))
      {
        parama.fQl.setImageResource(f.this.KNy);
        parama.fQm.setText(f.this.KNx);
        AppMethodBeat.o(102951);
        return;
      }
      n.a(parama1.iYg, parama.fQm);
      if (an.aUq(parama1.username))
      {
        g.ajS();
        an localan = ((l)g.ab(l.class)).azF().BH(parama1.username);
        ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).a(paramContext, parama.fQm, parama1.iYg, localan.field_openImAppid, localan.field_descWordingId, (int)parama.fQm.getTextSize());
      }
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.fQl, parama1.username);
      int i;
      if (x.zW(parama1.username))
      {
        paramContext = paramContext.getResources().getDrawable(2131691000);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.fQm.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        if (!f.this.KJj) {
          break label333;
        }
        if (!paramBoolean1) {
          break label313;
        }
        parama.iYl.setChecked(true);
        parama.iYl.setEnabled(false);
        paramContext = parama.iYl;
        if (!al.isDarkMode()) {
          break label306;
        }
        i = 2131689939;
        label272:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.iYl.setVisibility(0);
        AppMethodBeat.o(102951);
        return;
        parama.fQm.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break;
        label306:
        i = 2131689938;
        break label272;
        label313:
        parama.iYl.setChecked(paramBoolean2);
        parama.iYl.setEnabled(true);
      }
      label333:
      parama.iYl.setVisibility(8);
      AppMethodBeat.o(102951);
    }
    
    public final boolean aRS()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f
 * JD-Core Version:    0.7.0.1
 */