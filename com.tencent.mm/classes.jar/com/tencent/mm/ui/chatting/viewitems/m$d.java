package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.i;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class m$d
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  protected m.a XfN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36930);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.edL);
      ((View)localObject).setTag(new m.b().J((View)localObject, false));
    }
    AppMethodBeat.o(36930);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36931);
    this.WBq = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).ct(paramca);
    m.b localb = (m.b)parama;
    Object localObject;
    if (paramca != null)
    {
      parama = paramca.field_content;
      localObject = be.bwQ(paramca.field_content);
      if (((be)localObject).mhL) {
        break label694;
      }
      if (parama == null) {
        break label688;
      }
      paramString = k.b.aG(parama, paramca.field_reserved);
      if (paramString == null) {
        break label683;
      }
      parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramString.llZ);
    }
    for (;;)
    {
      if ((((be)localObject).md5 != null) && (!((be)localObject).md5.equals("-1")) && (parama == null)) {
        parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(((be)localObject).md5);
      }
      for (;;)
      {
        int i;
        boolean bool;
        if ((parama != null) && (parama.hBp()))
        {
          parama.talker = paramca.field_talker;
          localb.XfH.a(parama, paramca.field_msgId);
          paramString = localb.XfH;
          if (paramString.Rpp != null) {
            paramString.Rpp.resume();
          }
          if (paramca.field_status != 1)
          {
            i = 1;
            if (i != 0) {
              break label428;
            }
            bool = true;
            label231:
            b(localb, bool);
            a(paramca, parama);
            if (hTG())
            {
              if ((paramca == null) || (paramca.field_status != 2) || (!b((k)parama1.bC(k.class), paramca.field_msgId))) {
                break label659;
              }
              if (localb.XdI != null) {
                localb.XdI.setVisibility(0);
              }
            }
          }
        }
        for (;;)
        {
          localb.XfH.setTag(new by(paramca, parama1.hRi(), paramInt, parama1.getSelfUserName(), '\000'));
          parama = localb.XfH;
          if (this.XfN == null) {
            this.XfN = new m.a(parama1);
          }
          parama.setOnClickListener(this.XfN);
          localb.XfH.setOnLongClickListener(c(parama1));
          localb.XfH.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          a(paramInt, localb, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
          AppMethodBeat.o(36931);
          return;
          i = 0;
          break;
          label428:
          bool = false;
          break label231;
          String str = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
          localObject = com.tencent.mm.ay.q.bml().Wo(str);
          if (localObject != null)
          {
            parama = (c.a)localObject;
            if (!((Bitmap)localObject).isRecycled()) {}
          }
          else
          {
            parama = BitmapUtil.decodeFile(str, null);
            com.tencent.mm.ay.q.bml().h(str, parama);
          }
          b(localb, false);
          localb.XfK.setVisibility(0);
          localb.XfJ.setVisibility(8);
          localObject = localb.XfL;
          if (paramString == null) {}
          for (long l = 0L;; l = paramString.llX)
          {
            ((TextView)localObject).setText(ae.getSizeKB(l));
            localb.XfL.setVisibility(0);
            localb.XfK.setImageResource(R.g.emoji_download_btn);
            if (parama != null)
            {
              localObject = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject = BitmapUtil.transformDrawableToBitmap(this.WBq.WQv.getMMResources().getDrawable(R.g.dlY));
            }
            localb.XfH.setImageBitmap((Bitmap)localObject);
            if ((paramString == null) || (Util.isNullOrNil(paramString.llZ))) {
              break;
            }
            m.b.XfM.put(paramString.llZ, new WeakReference(localb));
            break;
          }
          label659:
          if (localb.XdI != null) {
            localb.XdI.setVisibility(8);
          }
        }
      }
      label683:
      parama = null;
      continue;
      label688:
      paramString = null;
      break;
      label694:
      parama = null;
      paramString = null;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36933);
    boolean bool = ((com.tencent.mm.ui.chatting.d.b.q)parama.bC(com.tencent.mm.ui.chatting.d.b.q.class)).a(paramMenuItem, parama, paramca);
    AppMethodBeat.o(36933);
    return bool;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(290767);
    bh.beI();
    int i;
    Object localObject2;
    Object localObject1;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      i = ((by)paramView.getTag()).position;
      localObject2 = be.bwQ(paramca.field_content);
      localObject1 = k.b.aG(paramca.field_content, paramca.field_reserved);
      if (localObject1 != null) {
        break label610;
      }
      localObject1 = new k.b();
      ((k.b)localObject1).llZ = ((be)localObject2).md5;
    }
    label574:
    label586:
    label610:
    for (;;)
    {
      if ((!ae.isNullOrNil(((k.b)localObject1).llZ)) && (!((k.b)localObject1).llZ.equals("-1")))
      {
        localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(((k.b)localObject1).llZ);
        if (localObject2 == null) {
          break label586;
        }
        if ((((EmojiInfo)localObject2).field_catalog != EmojiInfo.YCD) && (!((EmojiInfo)localObject2).hBu())) {
          paramo.a(i, 104, paramView.getContext().getString(R.l.ewb), R.k.icons_filled_addsticker);
        }
        localObject1 = com.tencent.mm.search.c.b.UWY;
        com.tencent.mm.search.c.b.c((EmojiInfo)localObject2, this.WBq.getTalkerUserName());
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDU, true);
        if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
        {
          Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "menu add similar emoji item.");
          paramo.a(i, 115, paramView.getContext().getString(R.l.ewd), R.k.icons_filled_othersticker);
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject2).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject2).field_designerID, ((EmojiInfo)localObject2).field_groupId, "", "", "", "", ((EmojiInfo)localObject2).field_activityid });
        if (!((EmojiInfo)localObject2).hBp()) {
          break label574;
        }
        paramo.a(i, 113, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUr()) {
          paramo.a(i, 135, paramView.getContext().getString(R.l.evR), R.k.icons_filled_makesticker);
        }
      }
      for (;;)
      {
        if (paramca.field_status == 5) {
          paramo.a(i, 103, paramView.getContext().getString(R.l.ewJ), R.k.icons_filled_refresh);
        }
        if ((!paramca.hwA()) && (paramca.hzC()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker))) {
          paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
        }
        if (!this.WBq.hRj()) {
          paramo.a(i, 100, paramView.getContext().getString(R.l.evM), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(290767);
        return true;
        Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
        break;
        Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[] { ((k.b)localObject1).llZ });
      }
    }
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(290768);
    if (paramca.erk())
    {
      com.tencent.mm.pluginsdk.model.app.m.bh(paramca);
      bq.Gk(paramca.field_msgId);
      parama.Gi(true);
      AppMethodBeat.o(290768);
      return;
    }
    AppMethodBeat.o(290768);
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.d
 * JD-Core Version:    0.7.0.1
 */