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
import com.tencent.mm.ba.a.b;
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.t;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

final class as
  implements au.a
{
  public final void b(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final bu parambu)
  {
    AppMethodBeat.i(37366);
    final au.b localb = (au.b)parama;
    final a.b localb1 = (a.b)parama1.bh(ae.class);
    int i = localb.KfL.getContext().getResources().getColor(2131100547);
    int j = localb.KfL.getContext().getResources().getColor(2131100548);
    final com.tencent.mm.ba.a locala = parambu.fsq();
    if (locala == null)
    {
      localb.tPw.setVisibility(8);
      parama = t.aKa().Gb(parama1.getTalkerUserName());
      ba.aBQ();
      paramInt = ((Integer)c.ajl().get(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.iiM == -2)) && ((parama != null) || (paramInt == -2))) {
        break label686;
      }
      localb.KfL.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100151));
      localb.KfL.setBackground(parama1.JOR.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      localb.KfL.invalidate();
      AppMethodBeat.o(37366);
      return;
      localb.tPw.setVisibility(0);
      localb.KfL.a(k.b(localb.KfL.getContext(), bt.nullAsNil(locala.ihO), localb.KfL.getTextSize()), TextView.BufferType.SPANNABLE);
      Object localObject;
      int k;
      if ((locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) || (locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
      {
        i = localb.KfL.getContext().getResources().getColor(2131100035);
        j = localb.KfL.getContext().getResources().getColor(2131100037);
        if (!parambu.fsh())
        {
          parama = Spannable.Factory.getInstance().newSpannable("    " + localb.KfL.fSO());
          localObject = localb.KfL.getContext().getResources().getDrawable(2131690702);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          com.tencent.mm.ui.widget.a locala1 = new com.tencent.mm.ui.widget.a((Drawable)localObject);
          locala1.KQg = ((int)((((Drawable)localObject).getIntrinsicHeight() - localb.KfL.getTextSize() + com.tencent.mm.cc.a.fromDPToPix(localb.KfL.getContext(), 2)) / 2.0F));
          parama.setSpan(locala1, 0, 3, 33);
          k = 4;
        }
      }
      for (;;)
      {
        final int m = 0;
        while (m < locala.ihQ.size())
        {
          localObject = new a();
          ((a)localObject).Kfs = new o(i, j)
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37364);
              ad.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[] { locala });
              localb1.a(localb.tPw, parambu, locala, m);
              AppMethodBeat.o(37364);
            }
          };
          ((a)localObject).start = ((Integer)locala.ihR.get(m)).intValue();
          ((a)localObject).end = ((Integer)locala.ihS.get(m)).intValue();
          parama.setSpan(((a)localObject).Kfs, ((a)localObject).start + k, ((a)localObject).end + k, 18);
          m += 1;
        }
        i = localb.KfL.getContext().getResources().getColor(2131100035);
        j = localb.KfL.getContext().getResources().getColor(2131100037);
        parama = Spannable.Factory.getInstance().newSpannable(localb.KfL.fSO());
        k = 0;
        continue;
        parama = Spannable.Factory.getInstance().newSpannable(localb.KfL.fSO());
        k = 0;
      }
      localb.KfL.a(parama, TextView.BufferType.SPANNABLE);
      localb.KfL.setOnClickListener(new as.2(this));
      break;
      label686:
      localb.KfL.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099735));
      localb.KfL.setBackground(parama1.JOR.getContext().getResources().getDrawable(2131231582));
    }
  }
  
  static final class a
  {
    public ClickableSpan Kfs;
    public int end;
    public int start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as
 * JD-Core Version:    0.7.0.1
 */