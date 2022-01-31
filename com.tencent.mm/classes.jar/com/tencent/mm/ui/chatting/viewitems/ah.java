package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.view.View;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.b;
import com.tencent.mm.ba.b;
import com.tencent.mm.ba.r;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.x;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

final class ah
  implements aj.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi)
  {
    AppMethodBeat.i(33270);
    aj.b localb = (aj.b)parama;
    a.b localb1 = (a.b)parama1.ay(x.class);
    int i = localb.zWS.getContext().getResources().getColor(2131690214);
    int j = localb.zWS.getContext().getResources().getColor(2131690215);
    com.tencent.mm.ay.a locala = parambi.dys();
    if (locala == null)
    {
      localb.ngZ.setVisibility(8);
      parama = r.aiQ().tS(parama1.getTalkerUserName());
      aw.aaz();
      paramInt = ((Integer)c.Ru().get(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.fMk == -2)) && ((parama != null) || (paramInt == -2))) {
        break label686;
      }
      localb.zWS.setTextColor(parama1.zJz.getContext().getResources().getColor(2131689766));
      localb.zWS.setBackground(parama1.zJz.getContext().getResources().getDrawable(2130838246));
    }
    for (;;)
    {
      localb.zWS.invalidate();
      AppMethodBeat.o(33270);
      return;
      localb.ngZ.setVisibility(0);
      localb.zWS.a(j.b(localb.zWS.getContext(), bo.nullAsNil(locala.fLl), localb.zWS.getTextSize()), TextView.BufferType.SPANNABLE);
      Object localObject;
      int k;
      if ((locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) || (locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
      {
        i = localb.zWS.getContext().getResources().getColor(2131689778);
        j = localb.zWS.getContext().getResources().getColor(2131689780);
        if (!parambi.dyn())
        {
          parama = Spannable.Factory.getInstance().newSpannable("    " + localb.zWS.dTB());
          localObject = localb.zWS.getContext().getResources().getDrawable(2131231561);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          com.tencent.mm.ui.widget.a locala1 = new com.tencent.mm.ui.widget.a((Drawable)localObject);
          locala1.ACa = ((int)((((Drawable)localObject).getIntrinsicHeight() - localb.zWS.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(localb.zWS.getContext(), 2)) / 2.0F));
          parama.setSpan(locala1, 0, 3, 33);
          k = 4;
        }
      }
      for (;;)
      {
        int m = 0;
        while (m < locala.fLn.size())
        {
          localObject = new ah.a();
          ((ah.a)localObject).zWz = new ah.1(this, i, j, locala, localb1, localb, parambi, paramInt, m);
          ((ah.a)localObject).start = ((Integer)locala.fLo.get(m)).intValue();
          ((ah.a)localObject).end = ((Integer)locala.fLp.get(m)).intValue();
          parama.setSpan(((ah.a)localObject).zWz, ((ah.a)localObject).start + k, ((ah.a)localObject).end + k, 18);
          m += 1;
        }
        i = localb.zWS.getContext().getResources().getColor(2131689778);
        j = localb.zWS.getContext().getResources().getColor(2131689780);
        parama = Spannable.Factory.getInstance().newSpannable(localb.zWS.dTB());
        k = 0;
        continue;
        parama = Spannable.Factory.getInstance().newSpannable(localb.zWS.dTB());
        k = 0;
      }
      localb.zWS.a(parama, TextView.BufferType.SPANNABLE);
      localb.zWS.setOnClickListener(new ah.2(this));
      break;
      label686:
      localb.zWS.setTextColor(parama1.zJz.getContext().getResources().getColor(2131690564));
      localb.zWS.setBackground(parama1.zJz.getContext().getResources().getDrawable(2130838245));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah
 * JD-Core Version:    0.7.0.1
 */