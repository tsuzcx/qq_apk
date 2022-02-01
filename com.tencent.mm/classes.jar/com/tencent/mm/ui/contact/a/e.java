package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;

public final class e
  extends g
{
  public CharSequence XxG;
  public boolean XxH;
  private a XxI;
  public as contact;
  
  public e(int paramInt, as paramas)
  {
    super(paramInt);
    AppMethodBeat.i(102941);
    this.XxI = new a();
    this.contact = paramas;
    if (paramas.sex == 1) {}
    for (;;)
    {
      this.XxH = bool;
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
    if (this.contact.sex == 1) {}
    for (;;)
    {
      this.XxH = bool;
      this.XxG = ((b)h.ae(b.class)).bbV().Rx(this.contact.field_username).PJ(this.contact.field_username);
      AppMethodBeat.o(102942);
      return;
      bool = false;
    }
  }
  
  public final a.b bwF()
  {
    return this.XxI;
  }
  
  final class a
    extends g.b
  {
    a()
    {
      super();
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102940);
      super.a(paramContext, parama, parama1, paramBoolean1, paramBoolean2);
      parama = (g.a)parama;
      if (!Util.isNullOrNil(e.this.XxG))
      {
        parama.mrM.setVisibility(0);
        e.this.XxG = l.d(paramContext, e.this.XxG, com.tencent.mm.ci.a.aY(paramContext, a.c.NormalTextSize));
        paramContext = parama.mrM;
        parama = parama.mrM.getContext().getResources();
        if (e.this.XxH) {}
        for (int i = a.h.contact_info_common_chatroom_name_male;; i = a.h.contact_info_common_chatroom_name_female)
        {
          paramContext.setText(parama.getString(i, new Object[] { e.this.XxG }));
          AppMethodBeat.o(102940);
          return;
        }
      }
      parama.mrM.setVisibility(8);
      AppMethodBeat.o(102940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.e
 * JD-Core Version:    0.7.0.1
 */