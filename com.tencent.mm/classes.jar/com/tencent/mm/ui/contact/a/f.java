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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ai;

public class f
  extends a
{
  public CharSequence GZF;
  public int GZG;
  private b GZH;
  a GZI;
  public CharSequence ibW;
  public String username;
  
  public f(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102952);
    this.GZG = 0;
    this.GZH = new b();
    this.GZI = new a();
    AppMethodBeat.o(102952);
  }
  
  public void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102953);
    if ((this.GZG != 0) && (this.GZF != null))
    {
      AppMethodBeat.o(102953);
      return;
    }
    if (this.contact == null)
    {
      this.ibW = "";
      this.username = "";
      AppMethodBeat.o(102953);
      return;
    }
    this.ibW = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact), com.tencent.mm.cd.a.ao(paramContext, 2131165517));
    this.username = this.contact.field_username;
    AppMethodBeat.o(102953);
  }
  
  public a.b aHr()
  {
    return this.GZH;
  }
  
  public final class a
    extends a.a
  {
    public ImageView frr;
    public TextView frs;
    public TextView hJe;
    public CheckBox icb;
    
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
      if (com.tencent.mm.cd.a.hS(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (f.a)f.this.GZI;
        paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.frs = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.hJe = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.hJe.setVisibility(8);
        paramViewGroup.icb = ((CheckBox)paramContext.findViewById(2131304502));
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
      parama.frs.setCompoundDrawables(null, null, null, null);
      if ((f.this.GZG != 0) && (f.this.GZF != null))
      {
        parama.frr.setImageResource(f.this.GZG);
        parama.frs.setText(f.this.GZF);
        AppMethodBeat.o(102951);
        return;
      }
      m.a(parama1.ibW, parama.frs);
      if (af.aHH(parama1.username))
      {
        g.afC();
        af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parama1.username);
        ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(paramContext, parama.frs, parama1.ibW, localaf.field_openImAppid, localaf.field_descWordingId, (int)parama.frs.getTextSize());
      }
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.frr, parama1.username);
      int i;
      if (w.so(parama1.username))
      {
        paramContext = paramContext.getResources().getDrawable(2131691000);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.frs.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        if (!f.this.GVT) {
          break label333;
        }
        if (!paramBoolean1) {
          break label313;
        }
        parama.icb.setChecked(true);
        parama.icb.setEnabled(false);
        paramContext = parama.icb;
        if (!ai.Eq()) {
          break label306;
        }
        i = 2131689939;
        label272:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.icb.setVisibility(0);
        AppMethodBeat.o(102951);
        return;
        parama.frs.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break;
        label306:
        i = 2131689938;
        break label272;
        label313:
        parama.icb.setChecked(paramBoolean2);
        parama.icb.setEnabled(true);
      }
      label333:
      parama.icb.setVisibility(8);
      AppMethodBeat.o(102951);
    }
    
    public final boolean aHs()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f
 * JD-Core Version:    0.7.0.1
 */