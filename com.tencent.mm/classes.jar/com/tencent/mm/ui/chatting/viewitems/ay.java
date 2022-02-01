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
import com.tencent.mm.bb.v;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ah;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

final class ay
  implements ba.a
{
  public final void b(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final ca paramca)
  {
    AppMethodBeat.i(37366);
    final ba.b localb = (ba.b)parama;
    final a.b localb1 = (a.b)parama1.bh(ah.class);
    int i = localb.POM.getContext().getResources().getColor(2131100685);
    int j = localb.POM.getContext().getResources().getColor(2131100687);
    final com.tencent.mm.az.a locala = paramca.gDX();
    if (locala == null)
    {
      localb.convertView.setVisibility(8);
      parama = v.bew().Pp(parama1.getTalkerUserName());
      bg.aVF();
      paramInt = ((Integer)c.azQ().get(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.jgE == -2)) && ((parama != null) || (paramInt == -2))) {
        break label686;
      }
      localb.POM.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100184));
      localb.POM.setBackground(parama1.Pwc.getContext().getResources().getDrawable(2131231647));
    }
    for (;;)
    {
      localb.POM.invalidate();
      AppMethodBeat.o(37366);
      return;
      localb.convertView.setVisibility(0);
      localb.POM.a(l.b(localb.POM.getContext(), Util.nullAsNil(locala.jfG), localb.POM.getTextSize()), TextView.BufferType.SPANNABLE);
      Object localObject;
      int k;
      if ((locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) || (locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
      {
        i = localb.POM.getContext().getResources().getColor(2131100063);
        j = localb.POM.getContext().getResources().getColor(2131100065);
        if (!paramca.gDO())
        {
          parama = Spannable.Factory.getInstance().newSpannable("    " + localb.POM.hiT());
          localObject = localb.POM.getContext().getResources().getDrawable(2131690972);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          com.tencent.mm.ui.widget.a locala1 = new com.tencent.mm.ui.widget.a((Drawable)localObject);
          locala1.QBM = ((int)((((Drawable)localObject).getIntrinsicHeight() - localb.POM.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(localb.POM.getContext(), 2)) / 2.0F));
          parama.setSpan(locala1, 0, 3, 33);
          k = 4;
        }
      }
      for (;;)
      {
        final int m = 0;
        while (m < locala.jfI.size())
        {
          localObject = new a();
          ((a)localObject).POt = new p(i, j)
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37364);
              Log.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[] { locala });
              localb1.a(localb.convertView, paramca, locala, m);
              AppMethodBeat.o(37364);
            }
          };
          ((a)localObject).start = ((Integer)locala.jfJ.get(m)).intValue();
          ((a)localObject).end = ((Integer)locala.jfK.get(m)).intValue();
          parama.setSpan(((a)localObject).POt, ((a)localObject).start + k, ((a)localObject).end + k, 18);
          m += 1;
        }
        i = localb.POM.getContext().getResources().getColor(2131100063);
        j = localb.POM.getContext().getResources().getColor(2131100065);
        parama = Spannable.Factory.getInstance().newSpannable(localb.POM.hiT());
        k = 0;
        continue;
        parama = Spannable.Factory.getInstance().newSpannable(localb.POM.hiT());
        k = 0;
      }
      localb.POM.a(parama, TextView.BufferType.SPANNABLE);
      localb.POM.setOnClickListener(new ay.2(this));
      break;
      label686:
      localb.POM.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099749));
      localb.POM.setBackground(parama1.Pwc.getContext().getResources().getDrawable(2131231646));
    }
  }
  
  static final class a
  {
    public ClickableSpan POt;
    public int end;
    public int start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay
 * JD-Core Version:    0.7.0.1
 */