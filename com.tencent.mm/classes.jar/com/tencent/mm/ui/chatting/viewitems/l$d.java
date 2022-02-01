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
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class l$d
  extends c
  implements t.n
{
  protected l.a PKn;
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493581);
      ((View)localObject).setTag(new l.b().G((View)localObject, false));
    }
    AppMethodBeat.o(36930);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36931);
    this.PhN = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
    l.b localb = (l.b)parama;
    Object localObject;
    if (paramca != null)
    {
      parama = paramca.field_content;
      localObject = be.bkr(paramca.field_content);
      if (((be)localObject).jsi) {
        break label694;
      }
      if (parama == null) {
        break label688;
      }
      paramString = k.b.aD(parama, paramca.field_reserved);
      if (paramString == null) {
        break label683;
      }
      parama = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramString.iwK);
    }
    for (;;)
    {
      if ((((be)localObject).md5 != null) && (!((be)localObject).md5.equals("-1")) && (parama == null)) {
        parama = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(((be)localObject).md5);
      }
      for (;;)
      {
        int i;
        boolean bool;
        if ((parama != null) && (parama.hRx()))
        {
          parama.talker = paramca.field_talker;
          localb.PKh.a(parama, paramca.field_msgId);
          paramString = localb.PKh;
          if (paramString.KoD != null) {
            paramString.KoD.resume();
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
            if (gTW())
            {
              if ((paramca == null) || (paramca.field_status != 2) || (!b((k)parama1.bh(k.class), paramca.field_msgId))) {
                break label659;
              }
              if (localb.PIn != null) {
                localb.PIn.setVisibility(0);
              }
            }
          }
        }
        for (;;)
        {
          localb.PKh.setTag(new bq(paramca, parama1.gRM(), paramInt, parama1.gRI(), '\000'));
          parama = localb.PKh;
          if (this.PKn == null) {
            this.PKn = new l.a(parama1);
          }
          parama.setOnClickListener(this.PKn);
          localb.PKh.setOnLongClickListener(c(parama1));
          localb.PKh.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          a(paramInt, localb, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
          AppMethodBeat.o(36931);
          return;
          i = 0;
          break;
          label428:
          bool = false;
          break label231;
          String str = com.tencent.mm.av.q.bcR().R(paramca.field_imgPath, true);
          localObject = com.tencent.mm.av.q.bcV().OQ(str);
          if (localObject != null)
          {
            parama = (c.a)localObject;
            if (!((Bitmap)localObject).isRecycled()) {}
          }
          else
          {
            parama = BitmapUtil.decodeFile(str, null);
            com.tencent.mm.av.q.bcV().h(str, parama);
          }
          b(localb, false);
          localb.PKk.setVisibility(0);
          localb.PKj.setVisibility(8);
          localObject = localb.PKl;
          if (paramString == null) {}
          for (long l = 0L;; l = paramString.iwI)
          {
            ((TextView)localObject).setText(af.getSizeKB(l));
            localb.PKl.setVisibility(0);
            localb.PKk.setImageResource(2131232112);
            if (parama != null)
            {
              localObject = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject = BitmapUtil.transformDrawableToBitmap(this.PhN.Pwc.getMMResources().getDrawable(2131231098));
            }
            localb.PKh.setImageBitmap((Bitmap)localObject);
            if ((paramString == null) || (Util.isNullOrNil(paramString.iwK))) {
              break;
            }
            l.b.PKm.put(paramString.iwK, new WeakReference(localb));
            break;
          }
          label659:
          if (localb.PIn != null) {
            localb.PIn.setVisibility(8);
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
    boolean bool = ((com.tencent.mm.ui.chatting.d.b.q)parama.bh(com.tencent.mm.ui.chatting.d.b.q.class)).a(paramMenuItem, parama, paramca);
    AppMethodBeat.o(36933);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233628);
    bg.aVF();
    int i;
    Object localObject2;
    Object localObject1;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      i = ((bq)paramView.getTag()).position;
      localObject2 = be.bkr(paramca.field_content);
      localObject1 = k.b.aD(paramca.field_content, paramca.field_reserved);
      if (localObject1 != null) {
        break label610;
      }
      localObject1 = new k.b();
      ((k.b)localObject1).iwK = ((be)localObject2).md5;
    }
    label574:
    label586:
    label610:
    for (;;)
    {
      if ((!af.isNullOrNil(((k.b)localObject1).iwK)) && (!((k.b)localObject1).iwK.equals("-1")))
      {
        localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(((k.b)localObject1).iwK);
        if (localObject2 == null) {
          break label586;
        }
        if ((((EmojiInfo)localObject2).field_catalog != EmojiInfo.Uuv) && (!((EmojiInfo)localObject2).hRB())) {
          paramm.a(i, 104, paramView.getContext().getString(2131757447), 2131690478);
        }
        localObject1 = com.tencent.mm.search.c.b.NJx;
        com.tencent.mm.search.c.b.c((EmojiInfo)localObject2, this.PhN.getTalkerUserName());
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXd, true);
        if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
        {
          Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "menu add similar emoji item.");
          paramm.a(i, 115, paramView.getContext().getString(2131757450), 2131690630);
        }
        h.CyF.a(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject2).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject2).field_designerID, ((EmojiInfo)localObject2).field_groupId, "", "", "", "", ((EmojiInfo)localObject2).field_activityid });
        if (!((EmojiInfo)localObject2).hRx()) {
          break label574;
        }
        paramm.a(i, 113, paramView.getContext().getString(2131764628), 2131690674);
        if (((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFM()) {
          paramm.a(i, 135, paramView.getContext().getString(2131757436), 2131690592);
        }
      }
      for (;;)
      {
        if (paramca.field_status == 5) {
          paramm.a(i, 103, paramView.getContext().getString(2131757500), 2131690658);
        }
        if ((!paramca.gAt()) && (paramca.gDo()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker))) {
          paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
        }
        if (!this.PhN.gRN()) {
          paramm.a(i, 100, paramView.getContext().getString(2131757431), 2131690529);
        }
        AppMethodBeat.o(233628);
        return true;
        Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
        break;
        Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[] { ((k.b)localObject1).iwK });
      }
    }
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233629);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
      AppMethodBeat.o(233629);
      return;
    }
    AppMethodBeat.o(233629);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.d
 * JD-Core Version:    0.7.0.1
 */