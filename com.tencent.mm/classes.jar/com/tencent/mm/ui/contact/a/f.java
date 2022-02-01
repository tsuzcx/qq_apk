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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.aj;

public class f
  extends a
{
  a IAa;
  public CharSequence IzX;
  public int IzY;
  private b IzZ;
  public CharSequence iCd;
  public String username;
  
  public f(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(102952);
    this.IzY = 0;
    this.IzZ = new b();
    this.IAa = new a();
    AppMethodBeat.o(102952);
  }
  
  public void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102953);
    if ((this.IzY != 0) && (this.IzX != null))
    {
      AppMethodBeat.o(102953);
      return;
    }
    if (this.contact == null)
    {
      this.iCd = "";
      this.username = "";
      AppMethodBeat.o(102953);
      return;
    }
    this.iCd = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact), com.tencent.mm.cc.a.au(paramContext, 2131165517));
    this.username = this.contact.field_username;
    AppMethodBeat.o(102953);
  }
  
  public a.b aOg()
  {
    return this.IzZ;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fuY;
    public TextView fuZ;
    public CheckBox iCi;
    public TextView ijE;
    
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
      if (com.tencent.mm.cc.a.id(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (f.a)f.this.IAa;
        paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.fuZ = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.ijE.setVisibility(8);
        paramViewGroup.iCi = ((CheckBox)paramContext.findViewById(2131304502));
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
      parama.fuZ.setCompoundDrawables(null, null, null, null);
      if ((f.this.IzY != 0) && (f.this.IzX != null))
      {
        parama.fuY.setImageResource(f.this.IzY);
        parama.fuZ.setText(f.this.IzX);
        AppMethodBeat.o(102951);
        return;
      }
      m.a(parama1.iCd, parama.fuZ);
      if (ai.aNc(parama1.username))
      {
        g.agS();
        ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parama1.username);
        ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(paramContext, parama.fuZ, parama1.iCd, localai.field_openImAppid, localai.field_descWordingId, (int)parama.fuZ.getTextSize());
      }
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.fuY, parama1.username);
      int i;
      if (w.wr(parama1.username))
      {
        paramContext = paramContext.getResources().getDrawable(2131691000);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.fuZ.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        if (!f.this.Iwh) {
          break label333;
        }
        if (!paramBoolean1) {
          break label313;
        }
        parama.iCi.setChecked(true);
        parama.iCi.setEnabled(false);
        paramContext = parama.iCi;
        if (!aj.DT()) {
          break label306;
        }
        i = 2131689939;
        label272:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.iCi.setVisibility(0);
        AppMethodBeat.o(102951);
        return;
        parama.fuZ.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break;
        label306:
        i = 2131689938;
        break label272;
        label313:
        parama.iCi.setChecked(paramBoolean2);
        parama.iCi.setEnabled(true);
      }
      label333:
      parama.iCi.setVisibility(8);
      AppMethodBeat.o(102951);
    }
    
    public final boolean aOh()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f
 * JD-Core Version:    0.7.0.1
 */