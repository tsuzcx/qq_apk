package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a.b;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.t;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

final class ar
  implements at.a
{
  public final void b(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bo parambo)
  {
    AppMethodBeat.i(37366);
    final at.b localb = (at.b)parama;
    final a.b localb1 = (a.b)parama1.bf(com.tencent.mm.ui.chatting.c.b.ac.class);
    int i = localb.Ipl.getContext().getResources().getColor(2131100547);
    int j = localb.Ipl.getContext().getResources().getColor(2131100548);
    final com.tencent.mm.az.a locala = parambo.fcj();
    if (locala == null)
    {
      localb.sSS.setVisibility(8);
      parama = t.aGP().CW(parama1.getTalkerUserName());
      az.ayM();
      paramInt = ((Integer)c.agA().get(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.hPy == -2)) && ((parama != null) || (paramInt == -2))) {
        break label686;
      }
      localb.Ipl.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100151));
      localb.Ipl.setBackground(parama1.HZF.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      localb.Ipl.invalidate();
      AppMethodBeat.o(37366);
      return;
      localb.sSS.setVisibility(0);
      localb.Ipl.a(k.b(localb.Ipl.getContext(), bs.nullAsNil(locala.hOA), localb.Ipl.getTextSize()), TextView.BufferType.SPANNABLE);
      Object localObject;
      int k;
      if ((locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) || (locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
      {
        i = localb.Ipl.getContext().getResources().getColor(2131100035);
        j = localb.Ipl.getContext().getResources().getColor(2131100037);
        if (!parambo.fce())
        {
          parama = Spannable.Factory.getInstance().newSpannable("    " + localb.Ipl.fBz());
          localObject = localb.Ipl.getContext().getResources().getDrawable(2131690702);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          com.tencent.mm.ui.widget.a locala1 = new com.tencent.mm.ui.widget.a((Drawable)localObject);
          locala1.IZa = ((int)((((Drawable)localObject).getIntrinsicHeight() - localb.Ipl.getTextSize() + com.tencent.mm.cc.a.fromDPToPix(localb.Ipl.getContext(), 2)) / 2.0F));
          parama.setSpan(locala1, 0, 3, 33);
          k = 4;
        }
      }
      for (;;)
      {
        final int m = 0;
        while (m < locala.hOC.size())
        {
          localObject = new a();
          ((a)localObject).IoS = new o(i, j)
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37364);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[] { locala });
              localb1.a(localb.sSS, parambo, locala, m);
              AppMethodBeat.o(37364);
            }
          };
          ((a)localObject).start = ((Integer)locala.hOD.get(m)).intValue();
          ((a)localObject).end = ((Integer)locala.hOE.get(m)).intValue();
          parama.setSpan(((a)localObject).IoS, ((a)localObject).start + k, ((a)localObject).end + k, 18);
          m += 1;
        }
        i = localb.Ipl.getContext().getResources().getColor(2131100035);
        j = localb.Ipl.getContext().getResources().getColor(2131100037);
        parama = Spannable.Factory.getInstance().newSpannable(localb.Ipl.fBz());
        k = 0;
        continue;
        parama = Spannable.Factory.getInstance().newSpannable(localb.Ipl.fBz());
        k = 0;
      }
      localb.Ipl.a(parama, TextView.BufferType.SPANNABLE);
      localb.Ipl.setOnClickListener(new ar.2(this));
      break;
      label686:
      localb.Ipl.setTextColor(ao.aJ(parama1.HZF.getContext(), 2130968586));
      localb.Ipl.setBackground(parama1.HZF.getContext().getResources().getDrawable(2131231582));
    }
  }
  
  static final class a
  {
    public ClickableSpan IoS;
    public int end;
    public int start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar
 * JD-Core Version:    0.7.0.1
 */