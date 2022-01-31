package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.b;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class f$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32878);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969065);
      ((View)localObject).setTag(new f.a().eZ((View)localObject));
    }
    AppMethodBeat.o(32878);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32879);
    this.zzP = parama1;
    f.a locala = (f.a)parama;
    paramString = parambi.field_content;
    if (paramString != null) {}
    for (Object localObject = j.b.ab(paramString, parambi.field_reserved);; localObject = null)
    {
      b localb;
      if (localObject != null)
      {
        f.a(parama.jYu, (j.b)localObject, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
        locala.zTl.setTypeface(Typeface.defaultFromStyle(0));
        parama1.zJz.getContext().getResources().getDimensionPixelSize(2131427854);
        parama1.zJz.getContext().getResources().getDimensionPixelSize(2131428207);
        localb = (b)((j.b)localObject).R(b.class);
        if (parambi.field_isSend != 1) {
          break label474;
        }
        paramString = localb.ffJ;
        if (!bo.isNullOrNil(paramString)) {
          break label484;
        }
        paramString = ((j.b)localObject).description;
        locala.zTl.setSingleLine(false);
        locala.zTl.setMaxLines(3);
        label162:
        locala.zTl.setText(j.b(parama1.zJz.getContext(), paramString, locala.zTq));
        locala.zTl.setTextSize(0, locala.zTq);
        if (!bo.isNullOrNil(localb.ffK)) {
          locala.zTl.setTextColor(Color.parseColor(localb.ffK));
        }
        localObject = locala.zTm;
        if (parambi.field_isSend != 1) {
          break label496;
        }
        paramString = localb.ffN;
        label252:
        ((TextView)localObject).setText(paramString);
        if (!bo.isNullOrNil(localb.ffP)) {
          locala.zTm.setTextColor(Color.parseColor(localb.ffP));
        }
        localObject = locala.zTn;
        if (parambi.field_isSend != 1) {
          break label506;
        }
      }
      label474:
      label484:
      label496:
      label506:
      for (paramString = localb.ffL;; paramString = localb.ffM)
      {
        ((TextView)localObject).setText(paramString);
        locala.zTk.setImageBitmap(null);
        if (!bo.isNullOrNil(localb.ffD))
        {
          paramString = new com.tencent.mm.at.a.a.c.a();
          aw.aaz();
          paramString.eNP = com.tencent.mm.model.c.YL();
          paramString.eNM = true;
          paramString.eOe = true;
          paramString = paramString.ahY();
          o.ahG().a(localb.ffD, locala.zTk, paramString);
        }
        parama.jYu.setOnClickListener(d(parama1));
        parama.jYu.setOnLongClickListener(c(parama1));
        parama.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
        parama1 = new az(parambi, this.zzP.dJG(), paramInt, null, '\000');
        parama.jYu.setTag(parama1);
        AppMethodBeat.o(32879);
        return;
        paramString = localb.ffI;
        break;
        locala.zTl.setSingleLine(true);
        break label162;
        paramString = localb.ffO;
        break label252;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32880);
    paramContextMenu.add(((az)paramView.getTag()).position, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    AppMethodBeat.o(32880);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32881);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(32881);
      return false;
    }
    AppMethodBeat.o(32881);
    return true;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 536870961);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32882);
    String str = parambi.field_content;
    paramView = null;
    if (str != null) {
      paramView = j.b.ab(str, parambi.field_reserved);
    }
    if (paramView != null)
    {
      ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
      paramView = Uri.parse(((b)paramView.R(b.class)).ffC).getQueryParameter("cardNo");
      parambi = new Intent();
      parambi.putExtra("key_is_payer", false);
      parambi.putExtra("key_card_no", paramView);
      d.b(parama.zJz.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", parambi);
      com.tencent.mm.plugin.report.service.h.qsU.e(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    }
    AppMethodBeat.o(32882);
    return true;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f.b
 * JD-Core Version:    0.7.0.1
 */