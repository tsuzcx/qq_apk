package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.R.f;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.e;

public final class f$c
  extends c
{
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg_c2c);
      ((View)localObject).setTag(new f.a().dP((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    f.a locala = (f.a)parama;
    paramString = parambi.field_content;
    if (paramString != null) {}
    for (Object localObject = g.a.M(paramString, parambi.field_reserved);; localObject = null)
    {
      b localb;
      if (localObject != null)
      {
        f.a(parama.igg, (g.a)localObject, "MicroMsg.ChattingItemAppMsgC2CTo", true);
        locala.vCo.setTypeface(Typeface.defaultFromStyle(0));
        int i = parama1.vtz.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding);
        int j = parama1.vtz.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding);
        locala.igg.setPadding(j, 0, i, 0);
        localb = (b)((g.a)localObject).A(b.class);
        if (parambi.field_isSend != 1) {
          break label482;
        }
        paramString = localb.dQb;
        if (!bk.bl(paramString)) {
          break label492;
        }
        paramString = ((g.a)localObject).description;
        locala.vCo.setSingleLine(false);
        locala.vCo.setMaxLines(3);
        label175:
        locala.vCo.setText(j.b(parama1.vtz.getContext(), paramString, locala.vCr));
        locala.vCo.setTextSize(0, locala.vCr);
        if (!bk.bl(localb.dQc)) {
          locala.vCo.setTextColor(Color.parseColor(localb.dQc));
        }
        localObject = locala.vCp;
        if (parambi.field_isSend != 1) {
          break label504;
        }
        paramString = localb.dQf;
        label265:
        ((TextView)localObject).setText(paramString);
        if (!bk.bl(localb.dQh)) {
          locala.vCp.setTextColor(Color.parseColor(localb.dQh));
        }
        localObject = locala.vCq;
        if (parambi.field_isSend != 1) {
          break label514;
        }
      }
      label514:
      for (paramString = localb.dQd;; paramString = localb.dQe)
      {
        ((TextView)localObject).setText(paramString);
        locala.vCn.setImageBitmap(null);
        if (!bk.bl(localb.dPV))
        {
          paramString = new com.tencent.mm.as.a.a.c.a();
          au.Hx();
          paramString.eri = com.tencent.mm.model.c.FH();
          paramString.erf = true;
          paramString.erC = true;
          paramString = paramString.OV();
          o.ON().a(localb.dPV, locala.vCn, paramString);
        }
        parama.igg.setOnClickListener(d(parama1));
        parama.igg.setOnLongClickListener(c(parama1));
        parama.igg.setOnTouchListener(((g)parama1.ac(g.class)).cDu());
        parama1 = new aw(parambi, this.vko.cFE(), paramInt, null, '\000');
        parama.igg.setTag(parama1);
        return;
        label482:
        paramString = localb.dQa;
        break;
        label492:
        locala.vCo.setSingleLine(true);
        break label175;
        label504:
        paramString = localb.dQg;
        break label265;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    paramContextMenu.add(((aw)paramView.getTag()).position, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
    return false;
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.c.a parama, final bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    case 101: 
    case 102: 
    default: 
      return false;
    case 100: 
      bd.bC(parambi.field_msgId);
      return true;
    }
    final String str1 = parambi.field_content;
    paramMenuItem = null;
    if (str1 != null) {
      paramMenuItem = g.a.M(str1, parambi.field_reserved);
    }
    if (paramMenuItem != null)
    {
      parambi = parambi.field_talker;
      str1 = paramMenuItem.dSb;
      final String str2 = paramMenuItem.dSc;
      final String str3 = paramMenuItem.dSd;
      final String str4 = paramMenuItem.dSe;
      final String str5 = paramMenuItem.dRZ;
      final String str6 = paramMenuItem.dSg;
      paramMenuItem = paramMenuItem.dSh;
      h.a(parama.vtz.getContext(), parama.vtz.getMMResources().getString(R.l.chatting_resend_content), parama.vtz.getMMResources().getString(R.l.app_remind), parama.vtz.getMMResources().getString(R.l.chatting_resend_title), parama.vtz.getMMResources().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("key_scene", 1);
          paramAnonymousDialogInterface.putExtra("key_receiver", parambi);
          paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
          paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
          paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
          paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
          paramAnonymousDialogInterface.putExtra("key_url", str5);
          paramAnonymousDialogInterface.putExtra("key_templateid", str6);
          paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
          d.b(parama.vtz.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    return true;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 536870961);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    String str = parambi.field_content;
    paramView = null;
    if (str != null) {
      paramView = g.a.M(str, parambi.field_reserved);
    }
    if (paramView != null)
    {
      y.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
      paramView = Uri.parse(((b)paramView.A(b.class)).dPS).getQueryParameter("cardNo");
      parambi = new Intent();
      parambi.putExtra("key_is_payer", true);
      parambi.putExtra("key_card_no", paramView);
      d.b(parama.vtz.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", parambi);
    }
    return true;
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f.c
 * JD-Core Version:    0.7.0.1
 */