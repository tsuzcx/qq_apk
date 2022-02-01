package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.x;

public final class d
  extends f
{
  public CharSequence IzJ;
  public boolean IzK;
  private a IzL;
  public ai contact;
  
  public d(int paramInt, ai paramai)
  {
    super(paramInt);
    AppMethodBeat.i(102941);
    this.IzL = new a();
    this.contact = paramai;
    if (paramai.exL == 1) {}
    for (;;)
    {
      this.IzK = bool;
      AppMethodBeat.o(102941);
      return;
      bool = false;
    }
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(102942);
    super.a(paramContext, parama);
    if (this.contact.exL == 1) {}
    for (;;)
    {
      this.IzK = bool;
      this.IzJ = ((c)g.ab(c.class)).awK().xO(this.contact.field_username).wk(this.contact.field_username);
      AppMethodBeat.o(102942);
      return;
      bool = false;
    }
  }
  
  public final a.b aOg()
  {
    return this.IzL;
  }
  
  final class a
    extends f.b
  {
    a()
    {
      super();
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102940);
      super.a(paramContext, parama, parama1, paramBoolean1, paramBoolean2);
      parama = (f.a)parama;
      if (!bs.aj(d.this.IzJ))
      {
        parama.ijE.setVisibility(0);
        d.this.IzJ = k.b(paramContext, d.this.IzJ, com.tencent.mm.cc.a.au(paramContext, 2131165517));
        paramContext = parama.ijE;
        parama = parama.ijE.getContext().getResources();
        if (d.this.IzK) {}
        for (int i = 2131757636;; i = 2131757635)
        {
          paramContext.setText(parama.getString(i, new Object[] { d.this.IzJ }));
          AppMethodBeat.o(102940);
          return;
        }
      }
      parama.ijE.setVisibility(8);
      AppMethodBeat.o(102940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d
 * JD-Core Version:    0.7.0.1
 */