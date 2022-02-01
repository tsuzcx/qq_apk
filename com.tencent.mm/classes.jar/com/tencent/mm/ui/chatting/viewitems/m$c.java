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
import com.tencent.mm.model.bs;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.ui.chatting.d.b.m;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class m$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  protected m.a XfN;
  
  private m.a m(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36924);
    if (this.XfN == null) {
      this.XfN = new m.a(parama);
    }
    parama = this.XfN;
    AppMethodBeat.o(36924);
    return parama;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36925);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.ecL);
      ((View)localObject).setTag(new m.b().J((View)localObject, true));
    }
    AppMethodBeat.o(36925);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36926);
    this.WBq = parama1;
    ((m)parama1.bC(m.class)).ct(paramca);
    m.b localb = (m.b)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (Object localObject1 = k.b.aG(parama, paramca.field_reserved);; localObject1 = null)
    {
      if ((localObject1 != null) && (((k.b)localObject1).llZ != null)) {}
      for (parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(((k.b)localObject1).llZ);; parama = null)
      {
        long l;
        if ((parama == null) || (!parama.hBp()))
        {
          String str = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
          Object localObject2 = com.tencent.mm.ay.q.bml().Wo(str);
          if (localObject2 != null)
          {
            parama = (c.a)localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            parama = BitmapUtil.decodeFile(str, null);
            com.tencent.mm.ay.q.bml().h(str, parama);
          }
          localb.XfK.setVisibility(0);
          localb.XfJ.setVisibility(8);
          localObject2 = localb.XfL;
          if (localObject1 == null)
          {
            l = 0L;
            ((TextView)localObject2).setText(ae.getSizeKB(l));
            localb.XfL.setVisibility(0);
            localb.XfK.setImageResource(R.g.emoji_download_btn);
            if ((localObject1 != null) && (!Util.isNullOrNil(((k.b)localObject1).llZ))) {
              m.b.XfM.put(((k.b)localObject1).llZ, new WeakReference(localb));
            }
            if (parama != null)
            {
              localObject1 = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject1 = BitmapUtil.transformDrawableToBitmap(this.WBq.WQv.getMMResources().getDrawable(R.g.dlY));
            }
            localb.XfH.setImageBitmap((Bitmap)localObject1);
          }
        }
        for (;;)
        {
          localb.XfH.setTag(new by(paramca, parama1.hRi(), paramInt, paramString, '\000'));
          localb.XfH.setOnClickListener(m(parama1));
          localb.XfH.setOnLongClickListener(c(parama1));
          localb.XfH.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          localb.XfK.setOnClickListener(m(parama1));
          localb.XfK.setOnLongClickListener(c(parama1));
          localb.XfK.setTag(localb.XfH.getTag());
          AppMethodBeat.o(36926);
          return;
          l = ((k.b)localObject1).llX;
          break;
          parama.talker = paramca.field_talker;
          localb.XfH.a(parama, paramca.field_msgId);
          localb.XfK.setVisibility(8);
          localb.XfJ.setVisibility(8);
          localb.XfL.setVisibility(8);
          localb.XfK.setVisibility(8);
          if ((localObject1 != null) && (!Util.isNullOrNil(((k.b)localObject1).llZ))) {
            m.b.XfM.remove(((k.b)localObject1).llZ);
          }
          a(paramca, parama);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36929);
    boolean bool = ((com.tencent.mm.ui.chatting.d.b.q)parama.bC(com.tencent.mm.ui.chatting.d.b.q.class)).a(paramMenuItem, parama, paramca);
    AppMethodBeat.o(36929);
    return bool;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(282425);
    int i = ((by)paramView.getTag()).position;
    Object localObject2 = be.bwQ(paramca.field_content);
    Object localObject1 = k.b.aG(paramca.field_content, paramca.field_reserved);
    if (localObject1 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).llZ = ((be)localObject2).md5;
    }
    for (;;)
    {
      if ((!ae.isNullOrNil(((k.b)localObject1).llZ)) && (!((k.b)localObject1).llZ.equals("-1")))
      {
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(((k.b)localObject1).llZ);
        if (localObject1 != null)
        {
          if ((((EmojiInfo)localObject1).field_catalog != EmojiInfo.YCD) && (!((EmojiInfo)localObject1).hBu())) {
            paramo.a(i, 104, paramView.getContext().getString(R.l.ewb), R.k.icons_filled_addsticker);
          }
          localObject2 = com.tencent.mm.search.c.b.UWY;
          com.tencent.mm.search.c.b.c((EmojiInfo)localObject1, this.WBq.getTalkerUserName());
          boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDU, true);
          if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
          {
            Log.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "menu add similar emoji item.");
            paramo.a(i, 115, paramView.getContext().getString(R.l.ewd), R.k.icons_filled_othersticker);
          }
          if (localObject1 != null) {
            com.tencent.mm.plugin.report.service.h.IzE.a(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, "", "", "", "", ((EmojiInfo)localObject1).field_activityid });
          }
          if ((!((EmojiInfo)localObject1).hBp()) || (bs.O(paramca))) {
            break label485;
          }
          paramo.a(i, 113, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
      for (;;)
      {
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUr()) {
          paramo.a(i, 135, paramView.getContext().getString(R.l.evR), R.k.icons_filled_makesticker);
        }
        if (bs.D(paramca)) {
          paramo.clear();
        }
        if (!this.WBq.hRj()) {
          paramo.a(i, 100, paramView.getContext().getString(R.l.evM), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(282425);
        return true;
        label485:
        Log.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
      }
    }
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36927);
    boolean bool = parama.hRi();
    AppMethodBeat.o(36927);
    return bool;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.c
 * JD-Core Version:    0.7.0.1
 */