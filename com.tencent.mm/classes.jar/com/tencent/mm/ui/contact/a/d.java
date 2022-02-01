package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;

public final class d
  extends f
{
  public CharSequence KNj;
  public boolean KNk;
  private a KNl;
  public an contact;
  
  public d(int paramInt, an paraman)
  {
    super(paramInt);
    AppMethodBeat.i(102941);
    this.KNl = new a();
    this.contact = paraman;
    if (paraman.eQV == 1) {}
    for (;;)
    {
      this.KNk = bool;
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
    if (this.contact.eQV == 1) {}
    for (;;)
    {
      this.KNk = bool;
      this.KNj = ((c)g.ab(c.class)).azP().By(this.contact.field_username).zP(this.contact.field_username);
      AppMethodBeat.o(102942);
      return;
      bool = false;
    }
  }
  
  public final a.b aRR()
  {
    return this.KNl;
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
      if (!bu.ah(d.this.KNj))
      {
        parama.iFO.setVisibility(0);
        d.this.KNj = k.b(paramContext, d.this.KNj, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
        paramContext = parama.iFO;
        parama = parama.iFO.getContext().getResources();
        if (d.this.KNk) {}
        for (int i = 2131757636;; i = 2131757635)
        {
          paramContext.setText(parama.getString(i, new Object[] { d.this.KNj }));
          AppMethodBeat.o(102940);
          return;
        }
      }
      parama.iFO.setVisibility(8);
      AppMethodBeat.o(102940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d
 * JD-Core Version:    0.7.0.1
 */