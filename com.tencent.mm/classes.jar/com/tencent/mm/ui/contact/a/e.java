package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;

public final class e
  extends g
{
  public CharSequence afjP;
  public boolean afjQ;
  private a afjR;
  public au contact;
  
  public e(int paramInt, au paramau)
  {
    super(paramInt);
    AppMethodBeat.i(102941);
    this.afjR = new a();
    this.contact = paramau;
    if (paramau.sex == 1) {}
    for (;;)
    {
      this.afjQ = bool;
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
      this.afjQ = bool;
      this.afjP = ((b)h.ax(b.class)).bzK().Jv(this.contact.field_username).getDisplayName(this.contact.field_username);
      AppMethodBeat.o(102942);
      return;
      bool = false;
    }
  }
  
  public final a.b bVv()
  {
    return this.afjR;
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
      if (!Util.isNullOrNil(e.this.afjP))
      {
        parama.plr.setVisibility(0);
        e.this.afjP = p.d(paramContext, e.this.afjP, com.tencent.mm.cd.a.br(paramContext, a.c.NormalTextSize));
        paramContext = parama.plr;
        parama = parama.plr.getContext().getResources();
        if (e.this.afjQ) {}
        for (int i = a.h.contact_info_common_chatroom_name_male;; i = a.h.contact_info_common_chatroom_name_female)
        {
          paramContext.setText(parama.getString(i, new Object[] { e.this.afjP }));
          AppMethodBeat.o(102940);
          return;
        }
      }
      parama.plr.setVisibility(8);
      AppMethodBeat.o(102940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.e
 * JD-Core Version:    0.7.0.1
 */