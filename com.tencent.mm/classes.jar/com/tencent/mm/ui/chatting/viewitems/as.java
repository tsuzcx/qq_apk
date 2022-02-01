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
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

final class as
  implements au.a
{
  public final void b(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final bv parambv)
  {
    AppMethodBeat.i(37366);
    final au.b localb = (au.b)parama;
    final a.b localb1 = (a.b)parama1.bh(com.tencent.mm.ui.chatting.d.b.ae.class);
    int i = localb.KCe.getContext().getResources().getColor(2131100547);
    int j = localb.KCe.getContext().getResources().getColor(2131100548);
    final com.tencent.mm.az.a locala = parambv.fwr();
    if (locala == null)
    {
      localb.uan.setVisibility(8);
      parama = t.aKt().GD(parama1.getTalkerUserName());
      bc.aCg();
      paramInt = ((Integer)c.ajA().get(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.ilF == -2)) && ((parama != null) || (paramInt == -2))) {
        break label686;
      }
      localb.KCe.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100151));
      localb.KCe.setBackground(parama1.Kkd.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      localb.KCe.invalidate();
      AppMethodBeat.o(37366);
      return;
      localb.uan.setVisibility(0);
      localb.KCe.a(k.b(localb.KCe.getContext(), bu.nullAsNil(locala.ikH), localb.KCe.getTextSize()), TextView.BufferType.SPANNABLE);
      Object localObject;
      int k;
      if ((locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) || (locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
      {
        i = localb.KCe.getContext().getResources().getColor(2131100035);
        j = localb.KCe.getContext().getResources().getColor(2131100037);
        if (!parambv.fwi())
        {
          parama = Spannable.Factory.getInstance().newSpannable("    " + localb.KCe.fXo());
          localObject = localb.KCe.getContext().getResources().getDrawable(2131690702);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          com.tencent.mm.ui.widget.a locala1 = new com.tencent.mm.ui.widget.a((Drawable)localObject);
          locala1.LmE = ((int)((((Drawable)localObject).getIntrinsicHeight() - localb.KCe.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(localb.KCe.getContext(), 2)) / 2.0F));
          parama.setSpan(locala1, 0, 3, 33);
          k = 4;
        }
      }
      for (;;)
      {
        final int m = 0;
        while (m < locala.ikJ.size())
        {
          localObject = new a();
          ((a)localObject).KBL = new o(i, j)
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37364);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[] { locala });
              localb1.a(localb.uan, parambv, locala, m);
              AppMethodBeat.o(37364);
            }
          };
          ((a)localObject).start = ((Integer)locala.ikK.get(m)).intValue();
          ((a)localObject).end = ((Integer)locala.ikL.get(m)).intValue();
          parama.setSpan(((a)localObject).KBL, ((a)localObject).start + k, ((a)localObject).end + k, 18);
          m += 1;
        }
        i = localb.KCe.getContext().getResources().getColor(2131100035);
        j = localb.KCe.getContext().getResources().getColor(2131100037);
        parama = Spannable.Factory.getInstance().newSpannable(localb.KCe.fXo());
        k = 0;
        continue;
        parama = Spannable.Factory.getInstance().newSpannable(localb.KCe.fXo());
        k = 0;
      }
      localb.KCe.a(parama, TextView.BufferType.SPANNABLE);
      localb.KCe.setOnClickListener(new as.2(this));
      break;
      label686:
      localb.KCe.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099735));
      localb.KCe.setBackground(parama1.Kkd.getContext().getResources().getDrawable(2131231582));
    }
  }
  
  static final class a
  {
    public ClickableSpan KBL;
    public int end;
    public int start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as
 * JD-Core Version:    0.7.0.1
 */