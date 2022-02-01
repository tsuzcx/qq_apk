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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.bc.a.b;
import com.tencent.mm.be.b;
import com.tencent.mm.be.w;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ah;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

final class bc
  implements bf.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca)
  {
    AppMethodBeat.i(37366);
    bf.b localb = (bf.b)parama;
    a.b localb1 = (a.b)parama1.bC(ah.class);
    int i = localb.XkO.getContext().getResources().getColor(R.e.link_color);
    int j = localb.XkO.getContext().getResources().getColor(R.e.link_color_pressed);
    com.tencent.mm.bc.a locala = paramca.hAn();
    if (locala == null)
    {
      localb.convertView.setVisibility(8);
      parama = w.bnV().WM(parama1.getTalkerUserName());
      bh.beI();
      paramInt = ((Integer)c.aHp().b(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.lXh == -2)) && ((parama != null) || (paramInt == -2))) {
        break label696;
      }
      localb.XkO.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.chatting_to_text_color));
      localb.XkO.setBackground(parama1.WQv.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
    }
    for (;;)
    {
      localb.XkO.invalidate();
      AppMethodBeat.o(37366);
      return;
      localb.convertView.setVisibility(0);
      localb.XkO.a(l.b(localb.XkO.getContext(), Util.nullAsNil(locala.lWg), localb.XkO.getTextSize()), TextView.BufferType.SPANNABLE);
      Object localObject;
      int k;
      if ((locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) || (locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
      {
        i = localb.XkO.getContext().getResources().getColor(R.e.brand_text_color);
        j = localb.XkO.getContext().getResources().getColor(R.e.brand_text_color_pressed);
        if (!paramca.hAc())
        {
          parama = Spannable.Factory.getInstance().newSpannable("    " + localb.XkO.ikC());
          localObject = localb.XkO.getContext().getResources().getDrawable(R.k.invite_sysmsg_icon);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          com.tencent.mm.ui.widget.a locala1 = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
          locala1.Yal = ((int)((((Drawable)localObject).getIntrinsicHeight() - localb.XkO.getTextSize() + com.tencent.mm.ci.a.fromDPToPix(localb.XkO.getContext(), 2)) / 2.0F));
          parama.setSpan(locala1, 0, 3, 33);
          k = 4;
        }
      }
      for (;;)
      {
        int m = 0;
        while (m < locala.lWj.size())
        {
          localObject = new a();
          ((a)localObject).Xku = new bc.1(this, i, j, locala, localb1, localb, paramca, paramInt, m);
          ((a)localObject).start = ((Integer)locala.lWk.get(m)).intValue();
          ((a)localObject).end = ((Integer)locala.lWl.get(m)).intValue();
          parama.setSpan(((a)localObject).Xku, ((a)localObject).start + k, ((a)localObject).end + k, 18);
          m += 1;
        }
        i = localb.XkO.getContext().getResources().getColor(R.e.brand_text_color);
        j = localb.XkO.getContext().getResources().getColor(R.e.brand_text_color_pressed);
        parama = Spannable.Factory.getInstance().newSpannable(localb.XkO.ikC());
        k = 0;
        continue;
        parama = Spannable.Factory.getInstance().newSpannable(localb.XkO.ikC());
        k = 0;
      }
      localb.XkO.a(parama, TextView.BufferType.SPANNABLE);
      localb.XkO.setOnClickListener(new bc.2(this));
      break;
      label696:
      localb.XkO.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.FG_2));
      localb.XkO.setBackground(parama1.WQv.getContext().getResources().getDrawable(R.g.chat_tips_bg));
    }
  }
  
  static final class a
  {
    public ClickableSpan Xku;
    public int end;
    public int start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc
 * JD-Core Version:    0.7.0.1
 */