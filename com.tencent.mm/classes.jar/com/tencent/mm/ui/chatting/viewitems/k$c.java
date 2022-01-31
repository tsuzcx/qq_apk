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
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.b.b.l;
import com.tencent.mm.ui.chatting.e;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class k$c
  extends c
{
  protected k.a vCV;
  private com.tencent.mm.ui.chatting.c.a vko;
  
  private k.a i(com.tencent.mm.ui.chatting.c.a parama)
  {
    if (this.vCV == null) {
      this.vCV = new k.a(parama);
    }
    return this.vCV;
  }
  
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_appmsg_emoji);
      ((View)localObject).setTag(new k.b().s((View)localObject, true));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    ((i)parama1.ac(i.class)).aW(parambi);
    k.b localb = (k.b)parama;
    parama = parambi.field_content;
    if (parama != null) {}
    for (g.a locala = g.a.M(parama, parambi.field_reserved);; locala = null)
    {
      if ((locala != null) && (locala.dQx != null)) {}
      for (Object localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(locala.dQx);; localObject = null)
      {
        long l;
        if ((localObject == null) || (!((EmojiInfo)localObject).cwz()))
        {
          String str = o.OJ().F(parambi.field_imgPath, true);
          Bitmap localBitmap = o.ON().mr(str);
          if (localBitmap != null)
          {
            parama = localBitmap;
            if (!localBitmap.isRecycled()) {}
          }
          else
          {
            parama = com.tencent.mm.sdk.platformtools.c.decodeFile(str, null);
            o.ON().i(str, parama);
          }
          if (localObject == null)
          {
            localb.vCS.setVisibility(0);
            localb.vCR.setVisibility(8);
            localObject = localb.vCT;
            if (locala == null)
            {
              l = 0L;
              ((TextView)localObject).setText(ah.cm(l));
              localb.vCT.setVisibility(0);
              localb.vCS.setImageResource(R.g.emoji_download_btn);
              label224:
              if ((locala != null) && (!bk.bl(locala.dQx))) {
                k.b.vCU.put(locala.dQx, new WeakReference(localb));
              }
              if ((parama != null) && (!parama.isRecycled())) {
                break label577;
              }
              parama = com.tencent.mm.sdk.platformtools.c.q(this.vko.vtz.getMMResources().getDrawable(R.g.appshareimage_icon));
            }
          }
        }
        label577:
        for (;;)
        {
          localb.vCP.setImageBitmap(parama);
          for (;;)
          {
            localb.vCP.setTag(new aw(parambi, parama1.cFE(), paramInt, paramString, '\000'));
            localb.vCP.setOnClickListener(i(parama1));
            localb.vCP.setOnLongClickListener(c(parama1));
            localb.vCP.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
            localb.vCS.setOnClickListener(i(parama1));
            localb.vCS.setOnLongClickListener(c(parama1));
            localb.vCS.setTag(localb.vCP.getTag());
            return;
            l = locala.dQv;
            break;
            localb.vCR.setVisibility(0);
            localb.vCT.setVisibility(8);
            localb.vCS.setVisibility(8);
            localb.vCR.setProgress(0);
            localb.vCT.setVisibility(8);
            break label224;
            localb.vCP.a((EmojiInfo)localObject, parambi.field_msgId);
            localb.vCS.setVisibility(8);
            localb.vCR.setVisibility(8);
            localb.vCT.setVisibility(8);
            localb.vCS.setVisibility(8);
            if ((locala != null) && (!bk.bl(locala.dQx))) {
              k.b.vCU.remove(locala.dQx);
            }
            a(parambi, (EmojiInfo)localObject);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    ap localap = ap.abP(parambi.field_content);
    Object localObject = g.a.M(parambi.field_content, parambi.field_reserved);
    if (localObject == null)
    {
      localObject = new g.a();
      ((g.a)localObject).dQx = localap.bIW;
    }
    for (;;)
    {
      if ((!ah.bl(((g.a)localObject).dQx)) && (!((g.a)localObject).dQx.equals("-1")))
      {
        localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(((g.a)localObject).dQx);
        if (localObject != null)
        {
          if ((((EmojiInfo)localObject).field_catalog != EmojiInfo.uCZ) && (!((EmojiInfo)localObject).cwC())) {
            paramContextMenu.add(i, 104, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_save_emoji));
          }
          if (localObject != null) {
            h.nFQ.f(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject).Wv(), Integer.valueOf(0), ((EmojiInfo)localObject).field_designerID, ((EmojiInfo)localObject).field_groupId, "", "", "", "", ((EmojiInfo)localObject).field_activityid });
          }
          boolean bool = ((EmojiInfo)localObject).cwz();
          if ((((EmojiInfo)localObject).field_catalog == EmojiInfo.uCZ) || (bk.bl(((EmojiInfo)localObject).field_groupId)) || ((!bk.bl(((EmojiInfo)localObject).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ax(((EmojiInfo)localObject).field_groupId))))
          {
            if (!bool) {
              break label426;
            }
            paramContextMenu.add(i, 113, 0, R.l.retransmit);
          }
        }
      }
      for (;;)
      {
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().h((EmojiInfo)localObject)) {
          paramContextMenu.add(i, 135, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_imitate_emoji));
        }
        if (bf.k(parambi)) {
          paramContextMenu.clear();
        }
        if (!this.vko.cFF()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_emoji));
        }
        return true;
        label426:
        y.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return ((l)parama.ac(l.class)).a(paramMenuItem, parama, parambi);
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return false;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.c.a parama)
  {
    return parama.cFE();
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.c
 * JD-Core Version:    0.7.0.1
 */