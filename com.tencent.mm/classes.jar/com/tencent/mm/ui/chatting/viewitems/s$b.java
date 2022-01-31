package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class s$b
  extends c
{
  private String vDM;
  private String vDN;
  private a vko;
  
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_card);
      ((View)localObject).setTag(new s.a().s((View)localObject, true));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    s.a locala = (s.a)parama;
    bi.a locala1;
    if (parama1.cFE())
    {
      parama = bd.iJ(parambi.field_content);
      au.Hx();
      locala1 = com.tencent.mm.model.c.Fy().HN(parama);
      if ((locala1.pyp == null) || (locala1.pyp.length() <= 0)) {
        y.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
      }
      this.vDM = locala1.pyp;
      this.vDN = "";
      if (!ah.bl(parama))
      {
        parama = bn.s(parama, "msg");
        if (parama.containsKey(".msg.$wechatid")) {
          this.vDN = ((String)parama.get(".msg.$wechatid"));
        }
      }
      b.M(this.vDM, locala1.uBV);
      s.a.Y(locala.igg, locala.vBZ);
      if (!com.tencent.mm.model.s.hI(locala1.qZn)) {
        break label427;
      }
      locala.vDK.setText(R.l.chatting_biz_card);
      locala.vDL.setVisibility(8);
      if (!d.gF(16)) {
        break label415;
      }
      locala.vDJ.setBackground(null);
      label198:
      s(locala.vDJ, this.vDM);
      label210:
      parama = this.vDN;
      if ((!ah.bl(parama)) && (!ad.aaX(parama)) && (!com.tencent.mm.model.s.hj(parama))) {
        break label480;
      }
    }
    label262:
    label415:
    label427:
    label467:
    label480:
    for (int i = 1;; i = 0)
    {
      boolean bool = com.tencent.mm.model.s.hI(locala1.qZn);
      if ((i != 0) || (bool))
      {
        parama = "";
        if (ah.bl(parama)) {
          break label467;
        }
        locala.vDL.setVisibility(0);
        locala.vDL.setText(parama);
      }
      for (;;)
      {
        locala.doV.setText(j.b(parama1.vtz.getContext(), locala1.nickname, (int)locala.doV.getTextSize()));
        s.a(parama1, this.vDM, locala1, locala);
        locala.igg.setTag(new aw(parambi, parama1.cFE(), paramInt, paramString, '\000'));
        locala.igg.setOnClickListener(d(parama1));
        locala.igg.setOnLongClickListener(c(parama1));
        locala.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
        return;
        parama = parambi.field_content;
        break;
        locala.vDJ.setBackgroundDrawable(null);
        break label198;
        locala.vDK.setText(R.l.chatting_personal_card);
        locala.vDJ.setBackgroundResource(R.g.default_avatar);
        r(locala.vDJ, this.vDM);
        break label210;
        break label262;
        locala.vDL.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    au.Hx();
    parambi = com.tencent.mm.model.c.Fy().HN(parambi.field_content);
    if ((parambi.pyp == null) || (parambi.pyp.length() <= 0)) {
      y.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
    }
    this.vDM = parambi.pyp;
    if (com.tencent.mm.model.s.hI(parambi.qZn)) {
      paramContextMenu.add(i, 118, 0, paramView.getContext().getString(R.l.retransmit));
    }
    if (!this.vko.cFF()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
    }
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    paramMenuItem = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 8);
    paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
    parama.startActivity(paramMenuItem);
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 42) || (paramInt == 66));
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    paramView = (aw)paramView.getTag();
    String str1 = paramView.userName;
    String str2 = parambi.field_content;
    boolean bool2 = paramView.vgB;
    if (parambi.field_isSend == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      s.a(parama, str1, str2, bool2, bool1);
      return true;
    }
  }
  
  protected final boolean b(a parama)
  {
    return parama.cFE();
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s.b
 * JD-Core Version:    0.7.0.1
 */