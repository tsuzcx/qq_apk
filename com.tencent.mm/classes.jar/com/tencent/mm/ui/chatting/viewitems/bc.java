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
import com.tencent.mm.ax.a.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelpackage.b;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ak;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

final class bc
  extends bg.a
{
  public final void b(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc)
  {
    AppMethodBeat.i(37366);
    final bg.b localb = (bg.b)parama;
    final a.b localb1 = (a.b)parama1.cm(ak.class);
    int i = localb.aeVA.getContext().getResources().getColor(R.e.link_color);
    int j = localb.aeVA.getContext().getResources().getColor(R.e.link_color_pressed);
    final com.tencent.mm.ax.a locala = paramcc.jcu();
    if (locala == null)
    {
      localb.convertView.setVisibility(8);
      parama = u.bLI().OM(parama1.getTalkerUserName());
      bh.bCz();
      paramInt = ((Integer)c.ban().d(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.oQj == -2)) && ((parama != null) || (paramInt == -2))) {
        break label726;
      }
      localb.aeVA.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.chatting_to_text_color));
      localb.aeVA.setBackground(parama1.aezO.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
    }
    for (;;)
    {
      localb.aeVA.invalidate();
      AppMethodBeat.o(37366);
      return;
      localb.convertView.setVisibility(0);
      localb.aeVA.a(p.b(localb.aeVA.getContext(), Util.nullAsNil(locala.oPj), localb.aeVA.getTextSize()), TextView.BufferType.SPANNABLE);
      Log.i("MicroMsg.ChattingItemNewXmlSysImpl", "parseNewXmlSysMsg:source:%s, format:%s", new Object[] { locala.oPj, localb.aeVA.jPy() });
      Object localObject;
      int k;
      if ((locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) || (locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
      {
        i = localb.aeVA.getContext().getResources().getColor(R.e.brand_text_color);
        j = localb.aeVA.getContext().getResources().getColor(R.e.brand_text_color_pressed);
        if (!paramcc.jcg())
        {
          parama = Spannable.Factory.getInstance().newSpannable("    " + localb.aeVA.jPy());
          localObject = localb.aeVA.getContext().getResources().getDrawable(R.k.invite_sysmsg_icon);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          com.tencent.mm.ui.widget.a locala1 = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
          locala1.afSg = ((int)((((Drawable)localObject).getIntrinsicHeight() - localb.aeVA.getTextSize() + com.tencent.mm.cd.a.fromDPToPix(localb.aeVA.getContext(), 2)) / 2.0F));
          parama.setSpan(locala1, 0, 3, 33);
          k = 4;
        }
      }
      for (;;)
      {
        final int m = 0;
        while (m < locala.oPl.size())
        {
          localObject = new a();
          ((a)localObject).aeVf = new t(i, j)
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37364);
              Log.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[] { locala });
              localb1.a(localb.convertView, paramcc, locala, m);
              AppMethodBeat.o(37364);
            }
          };
          ((a)localObject).start = ((Integer)locala.oPm.get(m)).intValue();
          ((a)localObject).end = ((Integer)locala.oPn.get(m)).intValue();
          parama.setSpan(((a)localObject).aeVf, ((a)localObject).start + k, ((a)localObject).end + k, 18);
          m += 1;
        }
        i = localb.aeVA.getContext().getResources().getColor(R.e.brand_text_color);
        j = localb.aeVA.getContext().getResources().getColor(R.e.brand_text_color_pressed);
        parama = Spannable.Factory.getInstance().newSpannable(localb.aeVA.jPy());
        k = 0;
        continue;
        parama = Spannable.Factory.getInstance().newSpannable(localb.aeVA.jPy());
        k = 0;
      }
      localb.aeVA.a(parama, TextView.BufferType.SPANNABLE);
      localb.aeVA.setOnClickListener(new bc.2(this));
      break;
      label726:
      localb.aeVA.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.FG_2));
      localb.aeVA.setBackground(parama1.aezO.getContext().getResources().getDrawable(R.g.chat_tips_bg));
    }
  }
  
  static final class a
  {
    public ClickableSpan aeVf;
    public int end;
    public int start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc
 * JD-Core Version:    0.7.0.1
 */