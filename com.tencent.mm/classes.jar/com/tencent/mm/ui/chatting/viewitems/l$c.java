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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.br;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class l$c
  extends c
{
  protected l.a PKn;
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  private l.a m(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36924);
    if (this.PKn == null) {
      this.PKn = new l.a(parama);
    }
    parama = this.PKn;
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
      localObject = new an(paramLayoutInflater, 2131493530);
      ((View)localObject).setTag(new l.b().G((View)localObject, true));
    }
    AppMethodBeat.o(36925);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36926);
    this.PhN = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
    l.b localb = (l.b)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (Object localObject1 = k.b.aD(parama, paramca.field_reserved);; localObject1 = null)
    {
      if ((localObject1 != null) && (((k.b)localObject1).iwK != null)) {}
      for (parama = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(((k.b)localObject1).iwK);; parama = null)
      {
        long l;
        if ((parama == null) || (!parama.hRx()))
        {
          String str = com.tencent.mm.av.q.bcR().R(paramca.field_imgPath, true);
          Object localObject2 = com.tencent.mm.av.q.bcV().OQ(str);
          if (localObject2 != null)
          {
            parama = (c.a)localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            parama = BitmapUtil.decodeFile(str, null);
            com.tencent.mm.av.q.bcV().h(str, parama);
          }
          localb.PKk.setVisibility(0);
          localb.PKj.setVisibility(8);
          localObject2 = localb.PKl;
          if (localObject1 == null)
          {
            l = 0L;
            ((TextView)localObject2).setText(af.getSizeKB(l));
            localb.PKl.setVisibility(0);
            localb.PKk.setImageResource(2131232112);
            if ((localObject1 != null) && (!Util.isNullOrNil(((k.b)localObject1).iwK))) {
              l.b.PKm.put(((k.b)localObject1).iwK, new WeakReference(localb));
            }
            if (parama != null)
            {
              localObject1 = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject1 = BitmapUtil.transformDrawableToBitmap(this.PhN.Pwc.getMMResources().getDrawable(2131231098));
            }
            localb.PKh.setImageBitmap((Bitmap)localObject1);
          }
        }
        for (;;)
        {
          localb.PKh.setTag(new bq(paramca, parama1.gRM(), paramInt, paramString, '\000'));
          localb.PKh.setOnClickListener(m(parama1));
          localb.PKh.setOnLongClickListener(c(parama1));
          localb.PKh.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          localb.PKk.setOnClickListener(m(parama1));
          localb.PKk.setOnLongClickListener(c(parama1));
          localb.PKk.setTag(localb.PKh.getTag());
          AppMethodBeat.o(36926);
          return;
          l = ((k.b)localObject1).iwI;
          break;
          parama.talker = paramca.field_talker;
          localb.PKh.a(parama, paramca.field_msgId);
          localb.PKk.setVisibility(8);
          localb.PKj.setVisibility(8);
          localb.PKl.setVisibility(8);
          localb.PKk.setVisibility(8);
          if ((localObject1 != null) && (!Util.isNullOrNil(((k.b)localObject1).iwK))) {
            l.b.PKm.remove(((k.b)localObject1).iwK);
          }
          a(paramca, parama);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36929);
    boolean bool = ((com.tencent.mm.ui.chatting.d.b.q)parama.bh(com.tencent.mm.ui.chatting.d.b.q.class)).a(paramMenuItem, parama, paramca);
    AppMethodBeat.o(36929);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233627);
    int i = ((bq)paramView.getTag()).position;
    Object localObject2 = be.bkr(paramca.field_content);
    Object localObject1 = k.b.aD(paramca.field_content, paramca.field_reserved);
    if (localObject1 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).iwK = ((be)localObject2).md5;
    }
    for (;;)
    {
      if ((!af.isNullOrNil(((k.b)localObject1).iwK)) && (!((k.b)localObject1).iwK.equals("-1")))
      {
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(((k.b)localObject1).iwK);
        if (localObject1 != null)
        {
          if ((((EmojiInfo)localObject1).field_catalog != EmojiInfo.Uuv) && (!((EmojiInfo)localObject1).hRB())) {
            paramm.a(i, 104, paramView.getContext().getString(2131757447), 2131690478);
          }
          localObject2 = com.tencent.mm.search.c.b.NJx;
          com.tencent.mm.search.c.b.c((EmojiInfo)localObject1, this.PhN.getTalkerUserName());
          boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXd, true);
          if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
          {
            Log.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "menu add similar emoji item.");
            paramm.a(i, 115, paramView.getContext().getString(2131757450), 2131690630);
          }
          if (localObject1 != null) {
            h.CyF.a(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, "", "", "", "", ((EmojiInfo)localObject1).field_activityid });
          }
          if (!((EmojiInfo)localObject1).hRx()) {
            break label478;
          }
          paramm.a(i, 113, paramView.getContext().getString(2131764628), 2131690674);
        }
      }
      for (;;)
      {
        if (((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFM()) {
          paramm.a(i, 135, paramView.getContext().getString(2131757436), 2131690592);
        }
        if (br.B(paramca)) {
          paramm.clear();
        }
        if (!this.PhN.gRN()) {
          paramm.a(i, 100, paramView.getContext().getString(2131757431), 2131690529);
        }
        AppMethodBeat.o(233627);
        return true;
        label478:
        Log.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
      }
    }
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36927);
    boolean bool = parama.gRM();
    AppMethodBeat.o(36927);
    return bool;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.c
 * JD-Core Version:    0.7.0.1
 */