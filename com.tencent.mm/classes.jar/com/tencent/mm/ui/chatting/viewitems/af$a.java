package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.a.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.y;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

public final class af$a
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233794);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493559);
      ((View)localObject).setTag(new af.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(233794);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(233795);
    String str;
    if ((parama instanceof af.c))
    {
      str = paramca.field_content;
      if (str == null) {
        break label243;
      }
    }
    for (paramString = k.b.aD(str, paramca.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        ((af.c)parama).PLK.aw(l.c(MMApplicationContext.getContext(), paramString.getTitle()));
        final long l = Long.parseLong(((y)paramString.as(y.class)).hJs);
        paramString = parama1.getTalkerUserName();
        ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).refreshLiveStatus(l, paramString, new a.a()
        {
          public final void c(long paramAnonymousLong, int paramAnonymousInt)
          {
            AppMethodBeat.i(233793);
            if (l == paramAnonymousLong)
            {
              if (paramAnonymousInt == 1)
              {
                ((af.c)parama1).PLL.setText(this.PHb.Pwc.getContext().getResources().getString(2131764667));
                AppMethodBeat.o(233793);
                return;
              }
              ((af.c)parama1).PLL.setText(this.PHb.Pwc.getContext().getResources().getString(2131764669));
            }
            AppMethodBeat.o(233793);
          }
        });
      }
      ((af.c)parama).PLM.setImageDrawable(ar.m(((af.c)parama).PLM.getContext(), 2131691403, ((af.c)parama).PLM.getContext().getResources().getColor(2131101009)));
      paramca = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
      parama.clickArea.setTag(paramca);
      parama.clickArea.setOnClickListener(d(parama1));
      parama.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
      parama.clickArea.setOnLongClickListener(c(parama1));
      Log.i("MicroMsg.ChattingItemAppMsgShareLiveFrom", "filling");
      AppMethodBeat.o(233795);
      return;
      label243:
      Log.e("MicroMsg.ChattingItemAppMsgShareLiveFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233796);
    paramView.getTag();
    AppMethodBeat.o(233796);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 855638065);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233797);
    ((com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
    Object localObject = paramca.field_content;
    if (localObject != null) {}
    for (localObject = k.b.aD((String)localObject, paramca.field_reserved);; localObject = null)
    {
      if ((localObject != null) && (((k.b)localObject).type == 60))
      {
        if (!WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(paramView.getContext()))
        {
          AppMethodBeat.o(233797);
          return true;
        }
        try
        {
          if ((((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.q.a.o(parama.Pwc.getContext(), true)) && (!com.tencent.mm.q.a.cC(parama.Pwc.getContext())) && (!com.tencent.mm.q.a.cA(parama.Pwc.getContext())) && (!com.tencent.mm.q.a.cE(parama.Pwc.getContext()))))
          {
            localObject = (y)((k.b)localObject).as(y.class);
            long l = Long.parseLong(((y)localObject).hJs);
            paramView = ((y)localObject).hwb;
            localObject = ((y)localObject).thumbUrl;
            paramca = a(parama, paramca);
            LiveConfig.a locala = new LiveConfig.a();
            locala.hvZ = LiveConfig.hvU;
            locala.thumbUrl = ((String)localObject);
            locala.hwa = parama.getTalkerUserName();
            locala.liveId = l;
            locala.hwb = paramView;
            locala.fromScene = LiveConfig.hvX;
            locala.hwd = paramca;
            localObject = locala.aBR();
            paramView = paramca;
            if (paramca == null) {
              paramView = parama.GUe.field_username;
            }
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = paramView;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs((int)parama.GUe.gMZ);
            ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().b(parama.Pwc.getContext(), (LiveConfig)localObject);
            f.aIL();
          }
          AppMethodBeat.o(233797);
          return true;
        }
        catch (Exception paramView)
        {
          Log.w("MicroMsg.ChattingItemAppMsgShareLiveFrom", "jump to live fail: %s", new Object[] { paramView.getMessage() });
        }
      }
      AppMethodBeat.o(233797);
      return false;
    }
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  final boolean gTV()
  {
    return false;
  }
  
  protected final boolean gTX()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.a
 * JD-Core Version:    0.7.0.1
 */