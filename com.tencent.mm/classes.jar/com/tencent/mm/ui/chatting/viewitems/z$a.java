package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.m;
import com.tencent.mm.ui.chatting.d.a;

public final class z$a
  extends c
{
  protected z.d zVK;
  private z.c zVL;
  private a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33190);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969079);
      ((View)localObject).setTag(new z.e().A((View)localObject, true));
    }
    AppMethodBeat.o(33190);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33191);
    if (parambi == null)
    {
      ab.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", new Object[] { paramString });
      AppMethodBeat.o(33191);
      return;
    }
    this.zzP = parama1;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.field_imgPath);
    z.e locale = (z.e)parama;
    boolean bool;
    if (localEmojiInfo == null)
    {
      parama = parambi.field_imgPath;
      if (localEmojiInfo == null)
      {
        bool = true;
        ab.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: db emoji %s, %s, msgId %s", new Object[] { parama, Boolean.valueOf(bool), Long.valueOf(parambi.field_msgId) });
      }
    }
    else
    {
      if (localEmojiInfo != null)
      {
        localEmojiInfo.talker = parambi.field_talker;
        parama = ap.arZ(parambi.field_content);
        locale.zTS.a(localEmojiInfo, parambi.field_msgId, parama);
        if ((localEmojiInfo.vY()) && (!parama.fXr))
        {
          aw.aaz();
          bi localbi = com.tencent.mm.model.c.YC().kB(parambi.field_msgId);
          parama.fXr = true;
          parambi.setContent(parama.dxr());
          if (localbi.getType() == 10000) {
            break label483;
          }
          aw.aaz();
          com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
        }
        label239:
        if (!b.z(localEmojiInfo)) {
          break label494;
        }
        locale.zVO.setVisibility(0);
        parama = locale.zVO;
        if (this.zVL == null) {
          this.zVL = new z.c(this.zzP);
        }
        parama.setOnClickListener(this.zVL);
      }
      label292:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.vY())) {
        break label614;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label507;
      }
      parama = this.zzP.zJz.getContext().getString(2131299150);
    }
    label483:
    label614:
    for (;;)
    {
      locale.zTS.setContentDescription(this.zzP.zJz.getContext().getString(2131299253) + parama);
      locale.zTS.setTag(new az(parambi, parama1.dJG(), paramInt, paramString, '\000'));
      parama = locale.zTS;
      if (this.zVK == null) {
        this.zVK = new z.d(parama1);
      }
      parama.setOnClickListener(this.zVK);
      locale.zTS.setOnLongClickListener(c(parama1));
      locale.zTS.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
      AppMethodBeat.o(33191);
      return;
      bool = false;
      break;
      ab.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
      break label239;
      label494:
      locale.zVO.setVisibility(8);
      break label292;
      label507:
      if (localEmojiInfo.field_name.startsWith("jsb_s"))
      {
        parama = this.zzP.zJz.getContext().getString(2131299151);
      }
      else if (localEmojiInfo.field_name.startsWith("jsb_b"))
      {
        parama = this.zzP.zJz.getContext().getString(2131299149);
      }
      else if (localEmojiInfo.field_name.startsWith("dice"))
      {
        parama = localEmojiInfo.field_name.replace("dice_", "").replace(".png", "");
        continue;
        if (localEmojiInfo != null) {
          parama = bo.bf(((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(localEmojiInfo.Al()), "");
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33193);
    int i;
    EmojiInfo localEmojiInfo;
    if (parambi.dxS())
    {
      aw.aaz();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        i = ((az)paramView.getTag()).position;
        localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.field_imgPath);
        if (localEmojiInfo == null)
        {
          ab.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[] { parambi.field_imgPath });
          AppMethodBeat.o(33193);
          return true;
        }
        boolean bool = localEmojiInfo.dzn();
        if ((localEmojiInfo.field_catalog != EmojiInfo.yPm) && (!localEmojiInfo.dzq()) && (!localEmojiInfo.dzr()))
        {
          if (!bool) {
            break label442;
          }
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131298245));
        }
        if ((localEmojiInfo.field_catalog == EmojiInfo.yPm) || (bo.isNullOrNil(localEmojiInfo.field_groupId)) || ((!bo.isNullOrNil(localEmojiInfo.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ky(localEmojiInfo.field_groupId))))
        {
          if (!bool) {
            break label453;
          }
          paramContextMenu.add(i, 113, 0, 2131302650);
        }
      }
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkX()) {
        paramContextMenu.add(i, 135, 0, paramView.getContext().getString(2131298235));
      }
      if ((b.Ll(localEmojiInfo.field_groupId)) && (!localEmojiInfo.vY()) && (!localEmojiInfo.dzr())) {
        paramContextMenu.add(i, 128, 0, 2131298247);
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298230));
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.Al(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(33193);
      return true;
      label442:
      ab.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
      break;
      label453:
      ab.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    AppMethodBeat.i(33194);
    boolean bool = ((m)parama.ay(m.class)).a(paramMenuItem, parama, parambi);
    AppMethodBeat.o(33194);
    return bool;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 47);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(33192);
    boolean bool = parama.dJG();
    AppMethodBeat.o(33192);
    return bool;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.a
 * JD-Core Version:    0.7.0.1
 */