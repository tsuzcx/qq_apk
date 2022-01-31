package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.ax.a.b;
import com.tencent.mm.az.b;
import com.tencent.mm.az.r;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.e;
import java.util.LinkedList;

final class ae
  implements ag.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi)
  {
    ag.b localb = (ag.b)parama;
    a.b localb1 = (a.b)parama1.ac(w.class);
    int i = localb.vEC.getContext().getResources().getColor(R.e.link_color);
    int j = localb.vEC.getContext().getResources().getColor(R.e.link_color_pressed);
    com.tencent.mm.ax.a locala = parambi.cvL();
    if (locala == null)
    {
      localb.kKz.setVisibility(8);
      parama = r.PL().mI(parama1.getTalkerUserName());
      au.Hx();
      paramInt = ((Integer)c.Dz().get(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.ewu == -2)) && ((parama != null) || (paramInt == -2))) {
        break label694;
      }
      localb.vEC.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.black_text_color));
      localb.vEC.setBackground(parama1.vtz.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
    }
    for (;;)
    {
      localb.vEC.invalidate();
      return;
      localb.kKz.setVisibility(0);
      localb.vEC.setText(j.a(localb.vEC.getContext(), bk.pm(locala.evy), localb.vEC.getTextSize()));
      localb.vEC.setMovementMethod(new ba());
      Object localObject;
      int k;
      if ((locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) || (locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
      {
        i = localb.vEC.getContext().getResources().getColor(R.e.green_text_color);
        j = localb.vEC.getContext().getResources().getColor(R.e.btn_green_color_pressed);
        if (!parambi.cvF())
        {
          parama = Spannable.Factory.getInstance().newSpannable("    " + localb.vEC.getText());
          localObject = localb.vEC.getContext().getResources().getDrawable(R.k.invite_sysmsg_icon);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          com.tencent.mm.ui.widget.a locala1 = new com.tencent.mm.ui.widget.a((Drawable)localObject);
          locala1.wjc = ((int)((((Drawable)localObject).getIntrinsicHeight() - localb.vEC.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(localb.vEC.getContext(), 2)) / 2.0F));
          parama.setSpan(locala1, 0, 3, 33);
          k = 4;
        }
      }
      for (;;)
      {
        int m = 0;
        while (m < locala.evA.size())
        {
          localObject = new a();
          ((a)localObject).vFm = new ae.1(this, i, j, locala, localb1, localb, parambi, paramInt, m);
          ((a)localObject).start = ((Integer)locala.evB.get(m)).intValue();
          ((a)localObject).end = ((Integer)locala.evC.get(m)).intValue();
          parama.setSpan(((a)localObject).vFm, ((a)localObject).start + k, ((a)localObject).end + k, 33);
          m += 1;
        }
        i = localb.vEC.getContext().getResources().getColor(R.e.green_text_color);
        j = localb.vEC.getContext().getResources().getColor(R.e.btn_green_color_pressed);
        parama = Spannable.Factory.getInstance().newSpannable(localb.vEC.getText());
        k = 0;
        continue;
        parama = Spannable.Factory.getInstance().newSpannable(localb.vEC.getText());
        k = 0;
      }
      localb.vEC.setText(parama);
      localb.vEC.setOnClickListener(new ae.2(this));
      break;
      label694:
      localb.vEC.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.white_text_color));
      localb.vEC.setBackground(parama1.vtz.getContext().getResources().getDrawable(R.g.chat_tips_bg));
    }
  }
  
  static final class a
  {
    public int end;
    public int start;
    public ClickableSpan vFm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae
 * JD-Core Version:    0.7.0.1
 */