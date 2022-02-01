package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.a.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.d.f;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

public final class z$a
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(187797);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131496164);
      ((View)localObject).setTag(new z.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(187797);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(187798);
    String str;
    if ((parama instanceof z.c))
    {
      str = parambv.field_content;
      if (str == null) {
        break label200;
      }
    }
    for (paramString = k.b.aB(str, parambv.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        ((z.c)parama).Kzl.aq(com.tencent.mm.pluginsdk.ui.span.k.c(ak.getContext(), paramString.getTitle()));
        final long l = Long.parseLong(((com.tencent.mm.live.b.l)paramString.ao(com.tencent.mm.live.b.l.class)).gRV);
        paramString = parama1.getTalkerUserName();
        ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).refreshLiveStatus(l, paramString, new a.a()
        {
          public final void c(long paramAnonymousLong, int paramAnonymousInt)
          {
            AppMethodBeat.i(187796);
            if (l == paramAnonymousLong)
            {
              if (paramAnonymousInt == 1)
              {
                ((z.c)parama1).Kzm.setText(this.KuD.Kkd.getContext().getResources().getString(2131766792));
                AppMethodBeat.o(187796);
                return;
              }
              ((z.c)parama1).Kzm.setText(this.KuD.Kkd.getContext().getResources().getString(2131766793));
            }
            AppMethodBeat.o(187796);
          }
        });
      }
      parambv = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
      parama.olI.setTag(parambv);
      parama.olI.setOnClickListener(d(parama1));
      parama.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
      parama.olI.setOnLongClickListener(c(parama1));
      ae.i("MicroMsg.ChattingItemAppMsgShareLiveFrom", "filling");
      AppMethodBeat.o(187798);
      return;
      label200:
      ae.e("MicroMsg.ChattingItemAppMsgShareLiveFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambv.field_msgId), paramString });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187799);
    paramView.getTag();
    AppMethodBeat.o(187799);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(187800);
    ((b)g.ab(b.class)).aaK(parambv.field_talker);
    paramView = parambv.field_content;
    if (paramView != null) {}
    for (paramView = k.b.aB(paramView, parambv.field_reserved);; paramView = null)
    {
      if ((paramView != null) && (paramView.type == 60)) {
        try
        {
          if ((((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.r.a.n(parama.Kkd.getContext(), true)) && (!com.tencent.mm.r.a.ch(parama.Kkd.getContext())) && (!com.tencent.mm.r.a.cf(parama.Kkd.getContext())) && (!com.tencent.mm.r.a.cj(parama.Kkd.getContext()))))
          {
            Object localObject = (com.tencent.mm.live.b.l)paramView.ao(com.tencent.mm.live.b.l.class);
            long l = Long.parseLong(((com.tencent.mm.live.b.l)localObject).gRV);
            paramView = ((com.tencent.mm.live.b.l)localObject).gJj;
            localObject = ((com.tencent.mm.live.b.l)localObject).thumbUrl;
            parambv = b(parama, parambv);
            LiveConfig.a locala = new LiveConfig.a();
            locala.gJg = LiveConfig.gJb;
            locala.thumbUrl = ((String)localObject);
            locala.gJi = parama.getTalkerUserName();
            locala.gJh = l;
            locala.gJj = paramView;
            locala.fromScene = LiveConfig.gJe;
            locala.gJl = parambv;
            paramView = locala.alq();
            ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().b(parama.Kkd.getContext(), paramView);
            f.aqn();
          }
          AppMethodBeat.o(187800);
          return true;
        }
        catch (Exception paramView)
        {
          ae.w("MicroMsg.ChattingItemAppMsgShareLiveFrom", "jump to live fail: %s", new Object[] { paramView.getMessage() });
        }
      }
      AppMethodBeat.o(187800);
      return false;
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 855638065);
  }
  
  final boolean fLA()
  {
    return false;
  }
  
  protected final boolean fLC()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.a
 * JD-Core Version:    0.7.0.1
 */