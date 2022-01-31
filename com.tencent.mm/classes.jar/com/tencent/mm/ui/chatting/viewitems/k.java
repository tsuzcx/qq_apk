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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.c.b.m;
import com.tencent.mm.ui.chatting.s.n;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class k
{
  public static final class c
    extends c
  {
    protected k.a zTY;
    private com.tencent.mm.ui.chatting.d.a zzP;
    
    private k.a m(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(32940);
      if (this.zTY == null) {
        this.zTY = new k.a(parama);
      }
      parama = this.zTY;
      AppMethodBeat.o(32940);
      return parama;
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(32941);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new w(paramLayoutInflater, 2130969068);
        ((View)localObject).setTag(new k.b().A((View)localObject, true));
      }
      AppMethodBeat.o(32941);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
    {
      AppMethodBeat.i(32942);
      this.zzP = parama1;
      ((j)parama1.ay(j.class)).bh(parambi);
      k.b localb = (k.b)parama;
      parama = parambi.field_content;
      if (parama != null) {}
      for (Object localObject1 = j.b.ab(parama, parambi.field_reserved);; localObject1 = null)
      {
        if ((localObject1 != null) && (((j.b)localObject1).fgy != null)) {}
        for (parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(((j.b)localObject1).fgy);; parama = null)
        {
          long l;
          if ((parama == null) || (!parama.dzn()))
          {
            String str = o.ahC().J(parambi.field_imgPath, true);
            Object localObject2 = o.ahG().tx(str);
            if (localObject2 != null)
            {
              parama = (c.a)localObject2;
              if (!((Bitmap)localObject2).isRecycled()) {}
            }
            else
            {
              parama = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
              o.ahG().j(str, parama);
            }
            localb.zTV.setVisibility(0);
            localb.zTU.setVisibility(8);
            localObject2 = localb.zTW;
            if (localObject1 == null)
            {
              l = 0L;
              ((TextView)localObject2).setText(ah.hk(l));
              localb.zTW.setVisibility(0);
              localb.zTV.setImageResource(2130838610);
              if ((localObject1 != null) && (!bo.isNullOrNil(((j.b)localObject1).fgy))) {
                k.b.zTX.put(((j.b)localObject1).fgy, new WeakReference(localb));
              }
              if (parama != null)
              {
                localObject1 = parama;
                if (!parama.isRecycled()) {}
              }
              else
              {
                localObject1 = com.tencent.mm.sdk.platformtools.d.u(this.zzP.zJz.getMMResources().getDrawable(2130837807));
              }
              localb.zTS.setImageBitmap((Bitmap)localObject1);
            }
          }
          for (;;)
          {
            localb.zTS.setTag(new az(parambi, parama1.dJG(), paramInt, paramString, '\000'));
            localb.zTS.setOnClickListener(m(parama1));
            localb.zTS.setOnLongClickListener(c(parama1));
            localb.zTS.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
            localb.zTV.setOnClickListener(m(parama1));
            localb.zTV.setOnLongClickListener(c(parama1));
            localb.zTV.setTag(localb.zTS.getTag());
            AppMethodBeat.o(32942);
            return;
            l = ((j.b)localObject1).fgw;
            break;
            parama.talker = parambi.field_talker;
            localb.zTS.a(parama, parambi.field_msgId);
            localb.zTV.setVisibility(8);
            localb.zTU.setVisibility(8);
            localb.zTW.setVisibility(8);
            localb.zTV.setVisibility(8);
            if ((localObject1 != null) && (!bo.isNullOrNil(((j.b)localObject1).fgy))) {
              k.b.zTX.remove(((j.b)localObject1).fgy);
            }
            a(parambi, parama);
          }
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
    {
      AppMethodBeat.i(32944);
      int i = ((az)paramView.getTag()).position;
      ap localap = ap.arZ(parambi.field_content);
      Object localObject = j.b.ab(parambi.field_content, parambi.field_reserved);
      if (localObject == null)
      {
        localObject = new j.b();
        ((j.b)localObject).fgy = localap.cqq;
      }
      for (;;)
      {
        if ((!ah.isNullOrNil(((j.b)localObject).fgy)) && (!((j.b)localObject).fgy.equals("-1")))
        {
          localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(((j.b)localObject).fgy);
          if (localObject != null)
          {
            if ((((EmojiInfo)localObject).field_catalog != EmojiInfo.yPm) && (!((EmojiInfo)localObject).dzq())) {
              paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131298245));
            }
            if (localObject != null) {
              com.tencent.mm.plugin.report.service.h.qsU.e(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject).Al(), Integer.valueOf(0), ((EmojiInfo)localObject).field_designerID, ((EmojiInfo)localObject).field_groupId, "", "", "", "", ((EmojiInfo)localObject).field_activityid });
            }
            boolean bool = ((EmojiInfo)localObject).dzn();
            if ((((EmojiInfo)localObject).field_catalog == EmojiInfo.yPm) || (bo.isNullOrNil(((EmojiInfo)localObject).field_groupId)) || ((!bo.isNullOrNil(((EmojiInfo)localObject).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ky(((EmojiInfo)localObject).field_groupId))))
            {
              if (!bool) {
                break label436;
              }
              paramContextMenu.add(i, 113, 0, 2131302650);
            }
          }
        }
        for (;;)
        {
          if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkX()) {
            paramContextMenu.add(i, 135, 0, paramView.getContext().getString(2131298235));
          }
          if (bh.o(parambi)) {
            paramContextMenu.clear();
          }
          if (!this.zzP.dJH()) {
            paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298230));
          }
          AppMethodBeat.o(32944);
          return true;
          label436:
          ab.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(32945);
      boolean bool = ((m)parama.ay(m.class)).a(paramMenuItem, parama, parambi);
      AppMethodBeat.o(32945);
      return bool;
    }
    
    public final boolean aK(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1048625);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      return false;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(32943);
      boolean bool = parama.dJG();
      AppMethodBeat.o(32943);
      return bool;
    }
    
    public final boolean dLp()
    {
      return false;
    }
  }
  
  public static final class d
    extends c
    implements s.n
  {
    protected k.a zTY;
    private com.tencent.mm.ui.chatting.d.a zzP;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(32946);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new w(paramLayoutInflater, 2130969106);
        ((View)localObject).setTag(new k.b().A((View)localObject, false));
      }
      AppMethodBeat.o(32946);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(32950);
      if (parambi.bCn())
      {
        l.al(parambi);
        bf.gw(parambi.field_msgId);
        parama.qT(true);
        AppMethodBeat.o(32950);
        return;
      }
      AppMethodBeat.o(32950);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
    {
      AppMethodBeat.i(32947);
      this.zzP = parama1;
      ((j)parama1.ay(j.class)).bh(parambi);
      k.b localb = (k.b)parama;
      String str1 = null;
      paramString = null;
      String str2;
      if (parambi != null)
      {
        String str3 = parambi.field_content;
        ap localap = ap.arZ(parambi.field_content);
        str2 = null;
        parama = str2;
        if (!localap.fXr)
        {
          if (str3 != null) {
            paramString = j.b.ab(str3, parambi.field_reserved);
          }
          parama = str2;
          str1 = paramString;
          if (paramString != null)
          {
            parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramString.fgy);
            str1 = paramString;
          }
        }
        if ((localap.cqq == null) || (localap.cqq.equals("-1")) || (parama != null)) {
          break label716;
        }
        parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(localap.cqq);
      }
      label265:
      label695:
      label716:
      for (;;)
      {
        int i;
        if ((parama != null) && (parama.dzn()))
        {
          parama.talker = parambi.field_talker;
          localb.zTS.a(parama, parambi.field_msgId);
          paramString = localb.zTS;
          if (paramString.wak != null) {
            paramString.wak.resume();
          }
          if (parambi.field_status != 1)
          {
            i = 1;
            paramString = localb.pNd;
            if (i == 0) {
              break label461;
            }
            i = 8;
            paramString.setVisibility(i);
            a(parambi, parama);
            if (dLr())
            {
              if ((parambi == null) || (parambi.field_status != 2) || (!a((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi.field_msgId))) {
                break label695;
              }
              if (localb.zSm != null) {
                localb.zSm.setVisibility(0);
              }
            }
          }
        }
        for (;;)
        {
          localb.zTS.setTag(new az(parambi, parama1.dJG(), paramInt, parama1.dJD(), '\000'));
          parama = localb.zTS;
          if (this.zTY == null) {
            this.zTY = new k.a(parama1);
          }
          parama.setOnClickListener(this.zTY);
          localb.zTS.setOnLongClickListener(c(parama1));
          localb.zTS.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
          a(paramInt, localb, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
          AppMethodBeat.o(32947);
          return;
          i = 0;
          break;
          label461:
          i = 0;
          break label265;
          str2 = o.ahC().J(parambi.field_imgPath, true);
          paramString = o.ahG().tx(str2);
          if (paramString != null)
          {
            parama = paramString;
            if (!paramString.isRecycled()) {}
          }
          else
          {
            parama = com.tencent.mm.sdk.platformtools.d.decodeFile(str2, null);
            o.ahG().j(str2, parama);
          }
          localb.pNd.setVisibility(8);
          localb.zTV.setVisibility(0);
          localb.zTU.setVisibility(8);
          paramString = localb.zTW;
          if (str1 == null) {}
          for (long l = 0L;; l = str1.fgw)
          {
            paramString.setText(ah.hk(l));
            localb.zTW.setVisibility(0);
            localb.zTV.setImageResource(2130838610);
            if (parama != null)
            {
              paramString = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              paramString = com.tencent.mm.sdk.platformtools.d.u(this.zzP.zJz.getMMResources().getDrawable(2130837807));
            }
            localb.zTS.setImageBitmap(paramString);
            if ((str1 == null) || (bo.isNullOrNil(str1.fgy))) {
              break;
            }
            k.b.zTX.put(str1.fgy, new WeakReference(localb));
            break;
          }
          if (localb.zSm != null) {
            localb.zSm.setVisibility(8);
          }
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
    {
      AppMethodBeat.i(32948);
      aw.aaz();
      int i;
      Object localObject;
      j.b localb;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        i = ((az)paramView.getTag()).position;
        localObject = ap.arZ(parambi.field_content);
        localb = j.b.ab(parambi.field_content, parambi.field_reserved);
        if (localb != null) {
          break label566;
        }
        localb = new j.b();
        localb.fgy = ((ap)localObject).cqq;
      }
      label530:
      label542:
      label566:
      for (;;)
      {
        if ((!ah.isNullOrNil(localb.fgy)) && (!localb.fgy.equals("-1")))
        {
          localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(localb.fgy);
          if (localObject == null) {
            break label542;
          }
          if ((((EmojiInfo)localObject).field_catalog != EmojiInfo.yPm) && (!((EmojiInfo)localObject).dzq())) {
            paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131298245));
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject).Al(), Integer.valueOf(0), ((EmojiInfo)localObject).field_designerID, ((EmojiInfo)localObject).field_groupId, "", "", "", "", ((EmojiInfo)localObject).field_activityid });
          boolean bool = ((EmojiInfo)localObject).dzn();
          if ((((EmojiInfo)localObject).field_catalog == EmojiInfo.yPm) || (bo.isNullOrNil(((EmojiInfo)localObject).field_groupId)) || ((!bo.isNullOrNil(((EmojiInfo)localObject).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ky(((EmojiInfo)localObject).field_groupId))))
          {
            if (!bool) {
              break label530;
            }
            paramContextMenu.add(i, 113, 0, 2131302650);
          }
          if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkX()) {
            paramContextMenu.add(i, 135, 0, paramView.getContext().getString(2131298235));
          }
        }
        for (;;)
        {
          if (parambi.field_status == 5) {
            paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131298295));
          }
          if ((!parambi.dvV()) && (parambi.dxT()) && ((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker))) {
            paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131298244));
          }
          if (!this.zzP.dJH()) {
            paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298230));
          }
          AppMethodBeat.o(32948);
          return true;
          ab.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
          break;
          ab.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[] { localb.fgy });
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(32949);
      boolean bool = ((m)parama.ay(m.class)).a(paramMenuItem, parama, parambi);
      AppMethodBeat.o(32949);
      return bool;
    }
    
    public final boolean aK(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1048625);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      return false;
    }
    
    public final boolean dLp()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k
 * JD-Core Version:    0.7.0.1
 */