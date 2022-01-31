package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import com.tencent.mm.ui.chatting.s.m;
import com.tencent.mm.ui.chatting.s.n;

public final class z
{
  public static final class b
    extends c
    implements s.n
  {
    protected z.d zVK;
    private z.c zVL;
    protected s.m zVM;
    private a zzP;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(33195);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new w(paramLayoutInflater, 2130969117);
        ((View)localObject).setTag(new z.e().A((View)localObject, false));
      }
      AppMethodBeat.o(33195);
      return localObject;
    }
    
    public final void a(a parama, bi parambi)
    {
      AppMethodBeat.i(33199);
      parambi.dye();
      aw.aaz();
      com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
      ((m)parama.ay(m.class)).bi(parambi);
      AppMethodBeat.o(33199);
    }
    
    public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
    {
      AppMethodBeat.i(33196);
      this.zzP = parama1;
      paramString = (z.e)parama;
      EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.field_imgPath);
      ImageView localImageView;
      if (localEmojiInfo != null)
      {
        parama = ap.arZ(parambi.field_content);
        localEmojiInfo.talker = parambi.field_talker;
        paramString.zTS.a(localEmojiInfo, parambi.field_msgId, parama);
        if (paramString.zVN != null)
        {
          if (!parama.yMK) {
            break label696;
          }
          paramString.zVN.setVisibility(0);
          TextView localTextView = (TextView)paramString.ngZ.findViewById(2131822732).findViewById(2131822734);
          localTextView.setText(Html.fromHtml(parama1.zJz.getMMResources().getString(2131299121)));
          localImageView = (ImageView)paramString.ngZ.findViewById(2131822732).findViewById(2131822735);
          localTextView.setTag(new az(parambi, false, paramInt, parama1.dJD(), false, "", "", "", "", localEmojiInfo.field_groupId, "", true, false));
          localTextView.setOnClickListener(i(parama1));
          if (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkT())
          {
            localImageView.setVisibility(0);
            localImageView.setTag(new az(parambi, parama1.dJG(), paramInt, parama1.dJD(), '\000'));
            if (this.zVM == null) {
              this.zVM = new s.m(parama1);
            }
            localImageView.setOnClickListener(this.zVM);
          }
        }
        else
        {
          if ((localEmojiInfo.vY()) && (!parama.fXr))
          {
            parama.fXr = true;
            parambi.setContent(parama.dxr());
            aw.aaz();
            parambi.setStatus(com.tencent.mm.model.c.YC().kB(parambi.field_msgId).field_status);
            aw.aaz();
            com.tencent.mm.model.c.YC().ab(parambi);
          }
          if (!dLr()) {
            break label730;
          }
          paramString.pNd.setVisibility(8);
          if ((parambi.field_status != 2) || (!a((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi.field_msgId))) {
            break label709;
          }
          if (paramString.zSm != null) {
            paramString.zSm.setVisibility(0);
          }
          label424:
          if (!b.z(localEmojiInfo)) {
            break label787;
          }
          paramString.zVO.setVisibility(0);
          parama = paramString.zVO;
          if (this.zVL == null) {
            this.zVL = new z.c(this.zzP);
          }
          parama.setOnClickListener(this.zVL);
        }
      }
      else
      {
        label477:
        parama = "";
        if ((localEmojiInfo == null) || (!localEmojiInfo.vY())) {
          break label907;
        }
        if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
          break label800;
        }
        parama = this.zzP.zJz.getContext().getString(2131299150);
      }
      label907:
      for (;;)
      {
        paramString.zTS.setContentDescription(this.zzP.zJz.getContext().getString(2131299253) + parama);
        paramString.zTS.setTag(new az(parambi, parama1.dJG(), paramInt, parama1.dJD(), '\000'));
        parama = paramString.zTS;
        if (this.zVK == null) {
          this.zVK = new z.d(parama1);
        }
        parama.setOnClickListener(this.zVK);
        paramString.zTS.setOnLongClickListener(c(parama1));
        paramString.zTS.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
        a(paramInt, paramString, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
        AppMethodBeat.o(33196);
        return;
        localImageView.setVisibility(8);
        break;
        label696:
        paramString.zVN.setVisibility(8);
        break;
        label709:
        if (paramString.zSm == null) {
          break label424;
        }
        paramString.zSm.setVisibility(8);
        break label424;
        label730:
        if (paramString.zSm != null) {
          paramString.zSm.setVisibility(8);
        }
        if (paramString.pNd == null) {
          break label424;
        }
        paramString.pNd.setVisibility(0);
        if (parambi.field_status < 2) {
          break label424;
        }
        paramString.pNd.setVisibility(8);
        break label424;
        label787:
        paramString.zVO.setVisibility(8);
        break label477;
        label800:
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
      AppMethodBeat.i(33197);
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
            ab.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[] { parambi.field_imgPath });
            AppMethodBeat.o(33197);
            return true;
          }
          boolean bool = localEmojiInfo.dzn();
          if ((localEmojiInfo.field_catalog != EmojiInfo.yPm) && (!localEmojiInfo.dzq()) && (!localEmojiInfo.dzr()))
          {
            if (!bool) {
              break label552;
            }
            paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131298245));
          }
          if ((localEmojiInfo.field_catalog == EmojiInfo.yPm) || (bo.isNullOrNil(localEmojiInfo.field_groupId)) || ((!bo.isNullOrNil(localEmojiInfo.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ky(localEmojiInfo.field_groupId))))
          {
            if (!bool) {
              break label564;
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
        if ((!parambi.dvV()) && (parambi.dxS()) && ((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker))) {
          paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131298244));
        }
        if (!this.zzP.dJH()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298230));
        }
        if (parambi.field_status == 5) {
          paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131298295));
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.Al(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", "", localEmojiInfo.field_activityid });
        AppMethodBeat.o(33197);
        return true;
        label552:
        ab.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
        break;
        label564:
        ab.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
    {
      AppMethodBeat.i(33198);
      boolean bool = ((m)parama.ay(m.class)).a(paramMenuItem, parama, parambi);
      AppMethodBeat.o(33198);
      return bool;
    }
    
    public final boolean aK(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 47);
    }
    
    public final boolean b(View paramView, a parama, bi parambi)
    {
      return false;
    }
    
    public final boolean dLp()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z
 * JD-Core Version:    0.7.0.1
 */