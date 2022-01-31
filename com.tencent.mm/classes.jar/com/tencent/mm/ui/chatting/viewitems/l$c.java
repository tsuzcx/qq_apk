package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class l$c
  extends c
  implements t.m
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg_img);
      ((View)localObject).setTag(new l.a().dS((View)localObject));
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
    l.a locala = (l.a)parama;
    this.vko = parama1;
    ((i)parama1.ac(i.class)).aW(parambi);
    parama = null;
    String str = parambi.field_content;
    if (str != null) {
      parama = g.a.M(str, parambi.field_reserved);
    }
    Object localObject;
    label193:
    label206:
    label228:
    int i;
    if (parama != null)
    {
      localObject = com.tencent.mm.pluginsdk.model.app.g.dh(parama.appId, parama.cau);
      if ((localObject == null) || (((f)localObject).field_appName == null) || (((f)localObject).field_appName.trim().length() <= 0))
      {
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.ct(paramString))) {
          break label419;
        }
        locala.kiv.setText(com.tencent.mm.pluginsdk.model.app.g.b(parama1.vtz.getContext(), (f)localObject, paramString));
        locala.kiv.setVisibility(0);
        if ((localObject == null) || (!((f)localObject).ZH())) {
          break label403;
        }
        a(parama1, locala.kiv, parambi, parama, ((f)localObject).field_packageName, parambi.field_msgSvrId);
        a(parama1, locala.kiv, parama.appId);
      }
    }
    else
    {
      switch (parama.type)
      {
      default: 
        locala.igg.setTag(new aw(parambi, parama1.cFE(), paramInt, null, '\000'));
        locala.igg.setOnClickListener(d(parama1));
        if (this.khG)
        {
          locala.igg.setOnLongClickListener(c(parama1));
          locala.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
        }
        i = com.tencent.mm.pluginsdk.model.app.l.VW(str);
        if ((i == -1) || (i >= 100) || (parama.dQv <= 0) || (parambi.field_status == 5))
        {
          locala.kfh.setVisibility(8);
          locala.kHQ.setAlpha(255);
          locala.kHQ.setBackgroundDrawable(null);
        }
        break;
      }
    }
    for (;;)
    {
      a(paramInt, locala, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
      return;
      paramString = ((f)localObject).field_appName;
      break;
      label403:
      a(parama1, locala.kiv, parama.appId);
      break label193;
      label419:
      locala.kiv.setVisibility(8);
      break label206;
      locala.kHQ.setVisibility(0);
      com.tencent.mm.pluginsdk.model.app.b localb = ap.avh().VQ(parama.bFE);
      localObject = parambi.field_imgPath;
      paramString = Boolean.valueOf(false);
      if (localb != null)
      {
        localObject = localb.field_fileFullPath;
        paramString = Boolean.valueOf(true);
      }
      if (o.OJ().a(locala.kHQ, (String)localObject, paramString.booleanValue(), com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), parama.dQQ, parama.dQP, R.g.chat_img_template, locala.kHU, R.g.chat_img_default_bg, 0, null)) {
        break label228;
      }
      if (this.khG) {
        locala.kHQ.setImageResource(R.k.chatfrom_bg_pic);
      }
      for (;;)
      {
        locala.kHQ.post(new l.c.1(this, locala));
        break;
        locala.kHQ.setImageBitmap(BitmapFactory.decodeResource(parama1.vtz.getMMResources(), R.g.nosdcard_pic));
      }
      locala.kfh.setVisibility(0);
      locala.vCW.setText(i + "%");
      locala.kHQ.setAlpha(64);
      locala.kHQ.setBackgroundResource(R.g.sendimage_mask);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    if (paramView == null)
    {
      y.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
      return false;
    }
    Object localObject = (aw)paramView.getTag();
    if (localObject == null)
    {
      y.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
      return false;
    }
    int k = ((aw)localObject).position;
    localObject = parambi.field_content;
    localObject = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    if ((localObject != null) && (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject).appId, false)))) {
      paramContextMenu.add(k, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
    }
    if (d.SP("favorite")) {
      paramContextMenu.add(k, 116, 0, this.vko.vtz.getMMResources().getString(R.l.plugin_favorite_opt));
    }
    localObject = new do();
    ((do)localObject).bJZ.bIt = parambi.field_msgId;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    boolean bool = com.tencent.mm.pluginsdk.model.app.g.m(this.vko.vtz.getContext(), 2L);
    if ((((do)localObject).bKa.bJy) || (bool)) {
      paramContextMenu.add(k, 129, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_open));
    }
    int[] arrayOfInt;
    int j;
    int i;
    if (parambi.field_status != 5)
    {
      localObject = paramContextMenu.add(k, 131, 0, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit));
      arrayOfInt = new int[2];
      if (paramView == null) {
        break label478;
      }
      j = paramView.getWidth();
      i = paramView.getHeight();
      paramView.getLocationInWindow(arrayOfInt);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
      ((MenuItem)localObject).setIntent(localIntent);
      if ((!parambi.ctz()) && (parambi.cvr()) && ((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
        paramContextMenu.add(k, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(k, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
      }
      return true;
      label478:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    Object localObject2 = null;
    Object localObject1 = parambi.field_content;
    if (localObject1 != null) {}
    for (localObject1 = g.a.gp((String)localObject1);; localObject1 = null)
    {
      switch (paramMenuItem.getItemId())
      {
      default: 
      case 100: 
        do
        {
          return false;
          if (localObject1 != null) {
            com.tencent.mm.pluginsdk.model.app.l.ha(parambi.field_msgId);
          }
          bd.bC(parambi.field_msgId);
          paramMenuItem = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject1).appId, false);
        } while ((paramMenuItem == null) || (!paramMenuItem.ZH()));
        a(parama, (g.a)localObject1, parambi, paramMenuItem);
        return false;
      case 111: 
        paramMenuItem = localObject2;
        if (localObject1 != null)
        {
          paramMenuItem = localObject2;
          if (((g.a)localObject1).bFE != null)
          {
            paramMenuItem = localObject2;
            if (((g.a)localObject1).bFE.length() > 0)
            {
              localObject1 = ap.avh().VQ(((g.a)localObject1).bFE);
              paramMenuItem = localObject2;
              if (localObject1 != null) {
                paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;
              }
            }
          }
        }
        localObject1 = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_Msg_content", parambi.field_content);
        ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
        ((Intent)localObject1).putExtra("Retr_Msg_Id", parambi.field_msgId);
        parama.startActivity((Intent)localObject1);
        return false;
      }
      l.a(parama, paramMenuItem, parambi);
      return false;
    }
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 268435505);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.gM(parama.vtz.getContext());
      return true;
    }
    if (paramView == null) {
      return true;
    }
    paramView.getTag();
    Object localObject1 = null;
    Object localObject2 = parambi.field_content;
    if (localObject2 != null) {
      localObject1 = g.a.gp((String)localObject2);
    }
    if (localObject1 == null)
    {
      y.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
      return true;
    }
    localObject2 = new int[2];
    paramView.getLocationInWindow((int[])localObject2);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    paramView = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject1).appId, false);
    if ((paramView != null) && (paramView.ZH())) {
      a(parama, (g.a)localObject1, q.Gj(), paramView, parambi.field_msgSvrId);
    }
    label477:
    PackageInfo localPackageInfo;
    if ((((g.a)localObject1).bFE != null) && (((g.a)localObject1).bFE.length() > 0))
    {
      paramView = ap.avh().VQ(((g.a)localObject1).bFE);
      if (paramView != null)
      {
        au.Hx();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          com.tencent.mm.ui.base.s.gM(parama.vtz.getContext());
        }
        for (;;)
        {
          return true;
          if (parambi.field_isSend == 1)
          {
            paramView = paramView.field_fileFullPath;
            if (!com.tencent.mm.vfs.e.bK(paramView)) {
              break label477;
            }
            if ((paramView != null) && (!paramView.equals("")) && (com.tencent.mm.vfs.e.bK(paramView))) {
              break;
            }
            y.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
          }
        }
        long l1 = parambi.field_msgId;
        long l2 = parambi.field_msgSvrId;
        parama = parambi.field_talker;
        paramView = new Intent(this.vko.vtz.getContext(), ImageGalleryUI.class);
        paramView.putExtra("img_gallery_msg_id", l1);
        paramView.putExtra("img_gallery_talker", parama);
        paramView.putExtra("img_gallery_left", localObject2[0]);
        paramView.putExtra("img_gallery_top", localObject2[1]);
        paramView.putExtra("img_gallery_width", i);
        paramView.putExtra("img_gallery_height", j);
        parama = this.vko.getTalkerUserName();
        parambi = b(this.vko, parambi);
        localObject1 = new Bundle();
        if (this.vko.cFE()) {
          i = 2;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("stat_scene", i);
          ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
          ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
          ((Bundle)localObject1).putString("stat_send_msg_user", parambi);
          paramView.putExtra("_stat_obj", (Bundle)localObject1);
          this.vko.startActivity(paramView);
          break;
          if (com.tencent.mm.model.s.hl(parama)) {
            i = 7;
          } else {
            i = 1;
          }
        }
        y.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgSvrId) });
        paramView = new Intent();
        paramView.setClassName(parama.vtz.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
        paramView.putExtra("clean_view_type", 1);
        parama.startActivity(paramView);
        return true;
      }
    }
    else if ((((g.a)localObject1).url != null) && (((g.a)localObject1).url.length() > 0))
    {
      localObject2 = p.u(((g.a)localObject1).url, "message");
      localPackageInfo = getPackageInfo(parama.vtz.getContext(), ((g.a)localObject1).appId);
      if (localPackageInfo != null) {
        break label646;
      }
      paramView = null;
      if (localPackageInfo != null) {
        break label655;
      }
    }
    label646:
    label655:
    for (i = 0;; i = localPackageInfo.versionCode)
    {
      a(parama, (String)localObject2, (String)localObject2, paramView, i, ((g.a)localObject1).appId, false, parambi.field_msgId, parambi.field_msgSvrId, parambi);
      return false;
      paramView = localPackageInfo.versionName;
      break;
    }
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.c
 * JD-Core Version:    0.7.0.1
 */