package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;

public final class d
  extends f
{
  public CharSequence Qaj;
  public boolean Qak;
  private a Qal;
  public as contact;
  
  public d(int paramInt, as paramas)
  {
    super(paramInt);
    AppMethodBeat.i(102941);
    this.Qal = new a();
    this.contact = paramas;
    if (paramas.fuA == 1) {}
    for (;;)
    {
      this.Qak = bool;
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
    if (this.contact.fuA == 1) {}
    for (;;)
    {
      this.Qak = bool;
      this.Qaj = ((c)g.af(c.class)).aSX().Ke(this.contact.field_username).getDisplayName(this.contact.field_username);
      AppMethodBeat.o(102942);
      return;
      bool = false;
    }
  }
  
  public final a.b bmx()
  {
    return this.Qal;
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
      if (!Util.isNullOrNil(d.this.Qaj))
      {
        parama.jBR.setVisibility(0);
        d.this.Qaj = l.e(paramContext, d.this.Qaj, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
        paramContext = parama.jBR;
        parama = parama.jBR.getContext().getResources();
        if (d.this.Qak) {}
        for (int i = 2131757864;; i = 2131757863)
        {
          paramContext.setText(parama.getString(i, new Object[] { d.this.Qaj }));
          AppMethodBeat.o(102940);
          return;
        }
      }
      parama.jBR.setVisibility(8);
      AppMethodBeat.o(102940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d
 * JD-Core Version:    0.7.0.1
 */