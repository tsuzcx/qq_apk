package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;

public final class d
  extends f
{
  public CharSequence KqP;
  public boolean KqQ;
  private a KqR;
  public am contact;
  
  public d(int paramInt, am paramam)
  {
    super(paramInt);
    AppMethodBeat.i(102941);
    this.KqR = new a();
    this.contact = paramam;
    if (paramam.ePk == 1) {}
    for (;;)
    {
      this.KqQ = bool;
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
    if (this.contact.ePk == 1) {}
    for (;;)
    {
      this.KqQ = bool;
      this.KqP = ((c)g.ab(c.class)).azz().AO(this.contact.field_username).zf(this.contact.field_username);
      AppMethodBeat.o(102942);
      return;
      bool = false;
    }
  }
  
  public final a.b aRs()
  {
    return this.KqR;
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
      if (!bt.ai(d.this.KqP))
      {
        parama.iCV.setVisibility(0);
        d.this.KqP = k.b(paramContext, d.this.KqP, com.tencent.mm.cc.a.ax(paramContext, 2131165517));
        paramContext = parama.iCV;
        parama = parama.iCV.getContext().getResources();
        if (d.this.KqQ) {}
        for (int i = 2131757636;; i = 2131757635)
        {
          paramContext.setText(parama.getString(i, new Object[] { d.this.KqP }));
          AppMethodBeat.o(102940);
          return;
        }
      }
      parama.iCV.setVisibility(8);
      AppMethodBeat.o(102940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d
 * JD-Core Version:    0.7.0.1
 */