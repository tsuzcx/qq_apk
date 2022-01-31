package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.t.m;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class k$d
  extends c
  implements t.m
{
  protected k.a vCV;
  private com.tencent.mm.ui.chatting.c.a vko;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg_emoji);
      ((View)localObject).setTag(new k.b().s((View)localObject, false));
    }
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    if (parambi.aVK())
    {
      com.tencent.mm.pluginsdk.model.app.l.ae(parambi);
      bd.bC(parambi.field_msgId);
      parama.cCW();
    }
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    ((i)parama1.ac(i.class)).aW(parambi);
    k.b localb = (k.b)parama;
    Object localObject;
    if (parambi != null)
    {
      parama = parambi.field_content;
      localObject = ap.abP(parambi.field_content);
      if (((ap)localObject).eHB) {
        break label685;
      }
      if (parama == null) {
        break label679;
      }
      paramString = g.a.M(parama, parambi.field_reserved);
      if (paramString == null) {
        break label674;
      }
      parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramString.dQx);
    }
    for (;;)
    {
      if ((((ap)localObject).bIW != null) && (!((ap)localObject).bIW.equals("-1")) && (parama == null)) {
        parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(((ap)localObject).bIW);
      }
      for (;;)
      {
        int i;
        if ((parama != null) && (parama.cwz()))
        {
          localb.vCP.a(parama, parambi.field_msgId);
          paramString = localb.vCP;
          if (paramString.shS != null) {
            paramString.shS.resume();
          }
          if (parambi.field_status != 1)
          {
            i = 1;
            paramString = localb.nhQ;
            if (i == 0) {
              break label416;
            }
            i = 8;
            label225:
            paramString.setVisibility(i);
            a(parambi, parama);
            if (cHc())
            {
              if ((parambi == null) || (parambi.field_status != 2) || (!a((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi.field_msgId))) {
                break label650;
              }
              if (localb.vBN != null) {
                localb.vBN.setVisibility(0);
              }
            }
          }
        }
        for (;;)
        {
          localb.vCP.setTag(new aw(parambi, parama1.cFE(), paramInt, parama1.cFB(), '\000'));
          parama = localb.vCP;
          if (this.vCV == null) {
            this.vCV = new k.a(parama1);
          }
          parama.setOnClickListener(this.vCV);
          localb.vCP.setOnLongClickListener(c(parama1));
          localb.vCP.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
          a(paramInt, localb, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
          return;
          i = 0;
          break;
          label416:
          i = 0;
          break label225;
          String str = o.OJ().F(parambi.field_imgPath, true);
          localObject = o.ON().mr(str);
          if (localObject != null)
          {
            parama = (c.a)localObject;
            if (!((Bitmap)localObject).isRecycled()) {}
          }
          else
          {
            parama = com.tencent.mm.sdk.platformtools.c.decodeFile(str, null);
            o.ON().i(str, parama);
          }
          localb.nhQ.setVisibility(8);
          localb.vCS.setVisibility(0);
          localb.vCR.setVisibility(8);
          localObject = localb.vCT;
          if (paramString == null) {}
          for (long l = 0L;; l = paramString.dQv)
          {
            ((TextView)localObject).setText(ah.cm(l));
            localb.vCT.setVisibility(0);
            localb.vCS.setImageResource(R.g.emoji_download_btn);
            if (parama != null)
            {
              localObject = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject = com.tencent.mm.sdk.platformtools.c.q(this.vko.vtz.getMMResources().getDrawable(R.g.appshareimage_icon));
            }
            localb.vCP.setImageBitmap((Bitmap)localObject);
            if ((paramString == null) || (bk.bl(paramString.dQx))) {
              break;
            }
            k.b.vCU.put(paramString.dQx, new WeakReference(localb));
            break;
          }
          label650:
          if (localb.vBN != null) {
            localb.vBN.setVisibility(8);
          }
        }
      }
      label674:
      parama = null;
      continue;
      label679:
      paramString = null;
      break;
      label685:
      parama = null;
      paramString = null;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    au.Hx();
    int i;
    Object localObject;
    g.a locala;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      i = ((aw)paramView.getTag()).position;
      localObject = ap.abP(parambi.field_content);
      locala = g.a.M(parambi.field_content, parambi.field_reserved);
      if (locala != null) {
        break label556;
      }
      locala = new g.a();
      locala.dQx = ((ap)localObject).bIW;
    }
    label520:
    label532:
    label556:
    for (;;)
    {
      if ((!ah.bl(locala.dQx)) && (!locala.dQx.equals("-1")))
      {
        localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(locala.dQx);
        if (localObject == null) {
          break label532;
        }
        if ((((EmojiInfo)localObject).field_catalog != EmojiInfo.uCZ) && (!((EmojiInfo)localObject).cwC())) {
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_save_emoji));
        }
        h.nFQ.f(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject).Wv(), Integer.valueOf(0), ((EmojiInfo)localObject).field_designerID, ((EmojiInfo)localObject).field_groupId, "", "", "", "", ((EmojiInfo)localObject).field_activityid });
        boolean bool = ((EmojiInfo)localObject).cwz();
        if ((((EmojiInfo)localObject).field_catalog == EmojiInfo.uCZ) || (bk.bl(((EmojiInfo)localObject).field_groupId)) || ((!bk.bl(((EmojiInfo)localObject).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ax(((EmojiInfo)localObject).field_groupId))))
        {
          if (!bool) {
            break label520;
          }
          paramContextMenu.add(i, 113, 0, R.l.retransmit);
        }
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().h((EmojiInfo)localObject)) {
          paramContextMenu.add(i, 135, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_imitate_emoji));
        }
      }
      for (;;)
      {
        if (parambi.field_status == 5) {
          paramContextMenu.add(i, 103, 0, paramView.getContext().getString(R.l.chatting_resend_title));
        }
        if ((!parambi.ctz()) && (parambi.cvp()) && ((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
          paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
        }
        if (!this.vko.cFF()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_emoji));
        }
        return true;
        y.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
        break;
        y.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[] { locala.dQx });
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return ((com.tencent.mm.ui.chatting.b.b.l)parama.ac(com.tencent.mm.ui.chatting.b.b.l.class)).a(paramMenuItem, parama, parambi);
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.d
 * JD-Core Version:    0.7.0.1
 */