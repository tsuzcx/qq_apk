package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.w;

public final class d
  extends f
{
  public CharSequence GZr;
  public boolean GZs;
  private a GZt;
  public af contact;
  
  public d(int paramInt, af paramaf)
  {
    super(paramInt);
    AppMethodBeat.i(102941);
    this.GZt = new a();
    this.contact = paramaf;
    if (paramaf.evp == 1) {}
    for (;;)
    {
      this.GZs = bool;
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
    if (this.contact.evp == 1) {}
    for (;;)
    {
      this.GZs = bool;
      this.GZr = ((c)g.ab(c.class)).apV().tI(this.contact.field_username).sh(this.contact.field_username);
      AppMethodBeat.o(102942);
      return;
      bool = false;
    }
  }
  
  public final a.b aHr()
  {
    return this.GZt;
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
      if (!bt.ai(d.this.GZr))
      {
        parama.hJe.setVisibility(0);
        d.this.GZr = k.b(paramContext, d.this.GZr, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
        paramContext = parama.hJe;
        parama = parama.hJe.getContext().getResources();
        if (d.this.GZs) {}
        for (int i = 2131757636;; i = 2131757635)
        {
          paramContext.setText(parama.getString(i, new Object[] { d.this.GZr }));
          AppMethodBeat.o(102940);
          return;
        }
      }
      parama.hJe.setVisibility(8);
      AppMethodBeat.o(102940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d
 * JD-Core Version:    0.7.0.1
 */