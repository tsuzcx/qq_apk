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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;

public class f
  extends a
{
  a QaA;
  public CharSequence Qax;
  public int Qay;
  private b Qaz;
  public CharSequence jVL;
  public String username;
  
  public f(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102952);
    this.Qay = 0;
    this.Qaz = new b();
    this.QaA = new a();
    AppMethodBeat.o(102952);
  }
  
  public void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102953);
    if ((this.Qay != 0) && (this.Qax != null))
    {
      AppMethodBeat.o(102953);
      return;
    }
    if (this.contact == null)
    {
      this.jVL = "";
      this.username = "";
      AppMethodBeat.o(102953);
      return;
    }
    this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, ((b)g.af(b.class)).b(this.contact), com.tencent.mm.cb.a.aG(paramContext, 2131165535));
    this.username = this.contact.field_username;
    AppMethodBeat.o(102953);
  }
  
  public a.b bmx()
  {
    return this.Qaz;
  }
  
  public final class a
    extends a.a
  {
    public ImageView gvv;
    public TextView gvw;
    public TextView jBR;
    public CheckBox jVQ;
    
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
      if (com.tencent.mm.cb.a.jk(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131496221, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131496220, paramViewGroup, false))
      {
        paramViewGroup = (f.a)f.this.QaA;
        paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
        paramViewGroup.gvw = ((TextView)paramContext.findViewById(2131309249));
        paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
        paramViewGroup.jBR.setVisibility(8);
        paramViewGroup.jVQ = ((CheckBox)paramContext.findViewById(2131307508));
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
      parama.gvw.setCompoundDrawables(null, null, null, null);
      if ((f.this.Qay != 0) && (f.this.Qax != null))
      {
        parama.gvv.setImageResource(f.this.Qay);
        parama.gvw.setText(f.this.Qax);
        AppMethodBeat.o(102951);
        return;
      }
      n.a(parama1.jVL, parama.gvw);
      if (as.bjp(parama1.username))
      {
        g.aAi();
        as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(parama1.username);
        ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).a(paramContext, parama.gvw, parama1.jVL, localas.field_openImAppid, localas.field_descWordingId, (int)parama.gvw.getTextSize());
      }
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.gvv, parama1.username);
      int i;
      if (ab.Iz(parama1.username))
      {
        paramContext = paramContext.getResources().getDrawable(2131691298);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.gvw.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        if (!f.this.PWh) {
          break label333;
        }
        if (!paramBoolean1) {
          break label313;
        }
        parama.jVQ.setChecked(true);
        parama.jVQ.setEnabled(false);
        paramContext = parama.jVQ;
        if (!ao.isDarkMode()) {
          break label306;
        }
        i = 2131689955;
        label272:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.jVQ.setVisibility(0);
        AppMethodBeat.o(102951);
        return;
        parama.gvw.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break;
        label306:
        i = 2131689954;
        break label272;
        label313:
        parama.jVQ.setChecked(paramBoolean2);
        parama.jVQ.setEnabled(true);
      }
      label333:
      parama.jVQ.setVisibility(8);
      AppMethodBeat.o(102951);
    }
    
    public final boolean bmy()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f
 * JD-Core Version:    0.7.0.1
 */