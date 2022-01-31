package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import java.util.Map;

public final class g$b
  extends c
{
  private final int zTE = 1;
  private a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32892);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969066);
      ((View)localObject).setTag(new g.a().fa((View)localObject));
    }
    AppMethodBeat.o(32892);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32893);
    this.zzP = parama1;
    paramString = parambi.field_content;
    if (paramString != null) {}
    for (paramString = j.b.ab(paramString, parambi.field_reserved);; paramString = null)
    {
      g.a locala = (g.a)parama;
      paramString = (com.tencent.mm.af.d)paramString.R(com.tencent.mm.af.d.class);
      if (paramString.cMR == 0)
      {
        locala.zTC.setBackgroundResource(2130839453);
        locala.zTD.setBackgroundResource(2130839440);
        locala.zTB.setVisibility(8);
      }
      for (;;)
      {
        parama.jYu.setOnClickListener(d(parama1));
        parama.jYu.setOnLongClickListener(c(parama1));
        parama.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
        parama1 = new az(parambi, this.zzP.dJG(), paramInt, null, '\000');
        parama.jYu.setTag(parama1);
        AppMethodBeat.o(32893);
        return;
        locala.zTC.setBackgroundResource(2130839454);
        locala.zTD.setBackgroundResource(2130839439);
        locala.zTB.setVisibility(0);
        if (paramString.cMR == 1) {
          locala.zTB.setText(ah.getContext().getString(2131301260));
        } else if (paramString.cMR == 2) {
          locala.zTB.setText(ah.getContext().getString(2131301262));
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32894);
    paramContextMenu.add(((az)paramView.getTag()).position, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    AppMethodBeat.o(32894);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    AppMethodBeat.i(32895);
    paramMenuItem.getItemId();
    AppMethodBeat.o(32895);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    AppMethodBeat.i(32896);
    paramView = parambi.field_content;
    if (paramView != null)
    {
      paramView = j.b.ab(paramView, parambi.field_reserved);
      if (!bo.isNullOrNil(paramView.fih))
      {
        ab.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
        com.tencent.mm.af.d locald = (com.tencent.mm.af.d)paramView.R(com.tencent.mm.af.d.class);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_native_url", paramView.fih);
        localIntent.putExtra("key_username", parama.getTalkerUserName());
        localIntent.putExtra("key_image_id", paramView.fik);
        localIntent.putExtra("key_image_aes_key", paramView.fil);
        localIntent.putExtra("key_image_length", paramView.fim);
        localIntent.putExtra("key_msgid", parambi.field_msgId);
        localIntent.putExtra("key_msg_newyear_localreceivestatus", locald.cMR);
        if (locald.evH != null) {
          localIntent.putExtra("key_emoji_md5", locald.evH.field_md5);
        }
        com.tencent.mm.bq.d.b(parama.zJz.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", localIntent);
        paramView.fii = 1;
        parambi.setContent(j.b.a(paramView, null, null));
        if ((parambi != null) && (parambi.bCn())) {
          break label241;
        }
      }
    }
    for (;;)
    {
      aw.aaz();
      com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
      AppMethodBeat.o(32896);
      return true;
      try
      {
        label241:
        parama = parambi.field_content;
        int i = parama.indexOf("<msg>");
        paramView = parama;
        if (i > 0)
        {
          paramView = parama;
          if (i < parama.length()) {
            paramView = parama.substring(i).trim();
          }
        }
        paramView = br.F(paramView, "msg");
        if ((paramView != null) && (paramView.size() > 0)) {
          parambi.kl(be.aT(paramView));
        }
      }
      catch (Exception paramView)
      {
        ab.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", paramView.getMessage());
      }
    }
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g.b
 * JD-Core Version:    0.7.0.1
 */