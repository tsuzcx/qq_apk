package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.a.b;
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.t;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ac;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

final class aq
  implements as.a
{
  public final void b(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bl parambl)
  {
    AppMethodBeat.i(37366);
    final as.b localb = (as.b)parama;
    final a.b localb1 = (a.b)parama1.be(ac.class);
    int i = localb.GPj.getContext().getResources().getColor(2131100547);
    int j = localb.GPj.getContext().getResources().getColor(2131100548);
    final com.tencent.mm.ba.a locala = parambl.eME();
    if (locala == null)
    {
      localb.rLd.setVisibility(8);
      parama = t.azZ().yR(parama1.getTalkerUserName());
      az.arV();
      paramInt = ((Integer)c.afk().get(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.hoW == -2)) && ((parama != null) || (paramInt == -2))) {
        break label686;
      }
      localb.GPj.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131100151));
      localb.GPj.setBackground(parama1.GzJ.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      localb.GPj.invalidate();
      AppMethodBeat.o(37366);
      return;
      localb.rLd.setVisibility(0);
      localb.GPj.a(k.b(localb.GPj.getContext(), bt.nullAsNil(locala.hnX), localb.GPj.getTextSize()), TextView.BufferType.SPANNABLE);
      Object localObject;
      int k;
      if ((locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) || (locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
      {
        i = localb.GPj.getContext().getResources().getColor(2131100035);
        j = localb.GPj.getContext().getResources().getColor(2131100037);
        if (!parambl.eMz())
        {
          parama = Spannable.Factory.getInstance().newSpannable("    " + localb.GPj.fli());
          localObject = localb.GPj.getContext().getResources().getDrawable(2131690702);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          com.tencent.mm.ui.widget.a locala1 = new com.tencent.mm.ui.widget.a((Drawable)localObject);
          locala1.HyD = ((int)((((Drawable)localObject).getIntrinsicHeight() - localb.GPj.getTextSize() + com.tencent.mm.cd.a.fromDPToPix(localb.GPj.getContext(), 2)) / 2.0F));
          parama.setSpan(locala1, 0, 3, 33);
          k = 4;
        }
      }
      for (;;)
      {
        final int m = 0;
        while (m < locala.hnZ.size())
        {
          localObject = new a();
          ((a)localObject).GOQ = new o(i, j)
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37364);
              ad.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[] { locala });
              localb1.a(localb.rLd, parambl, locala, m);
              AppMethodBeat.o(37364);
            }
          };
          ((a)localObject).start = ((Integer)locala.hoa.get(m)).intValue();
          ((a)localObject).end = ((Integer)locala.hob.get(m)).intValue();
          parama.setSpan(((a)localObject).GOQ, ((a)localObject).start + k, ((a)localObject).end + k, 18);
          m += 1;
        }
        i = localb.GPj.getContext().getResources().getColor(2131100035);
        j = localb.GPj.getContext().getResources().getColor(2131100037);
        parama = Spannable.Factory.getInstance().newSpannable(localb.GPj.fli());
        k = 0;
        continue;
        parama = Spannable.Factory.getInstance().newSpannable(localb.GPj.fli());
        k = 0;
      }
      localb.GPj.a(parama, TextView.BufferType.SPANNABLE);
      localb.GPj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37365);
          ad.d("MicroMsg.ChattingItemNewXmlSysImpl", "clicked");
          AppMethodBeat.o(37365);
        }
      });
      break;
      label686:
      localb.GPj.setTextColor(ao.aD(parama1.GzJ.getContext(), 2130968586));
      localb.GPj.setBackground(parama1.GzJ.getContext().getResources().getDrawable(2131231582));
    }
  }
  
  static final class a
  {
    public ClickableSpan GOQ;
    public int end;
    public int start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq
 * JD-Core Version:    0.7.0.1
 */