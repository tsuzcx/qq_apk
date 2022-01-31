package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
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
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class l$b
  extends c
{
  private final long vCY = 259200000L;
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_appmsg_img);
      ((View)localObject).setTag(new l.a().dS((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    l.a locala = (l.a)parama;
    this.vko = parama1;
    ((i)parama1.ac(i.class)).aW(parambi);
    parama = null;
    String str = parambi.field_content;
    paramString = str;
    if (parama1.cFE())
    {
      int i = parambi.field_content.indexOf(':');
      paramString = str;
      if (i != -1) {
        paramString = parambi.field_content.substring(i + 1);
      }
    }
    if (paramString != null) {
      parama = g.a.M(paramString, parambi.field_reserved);
    }
    f localf;
    if (parama != null)
    {
      localf = com.tencent.mm.pluginsdk.model.app.g.dh(parama.appId, parama.cau);
      if ((localf != null) && (localf.ZH())) {
        b(parama1, parama, parambi);
      }
      if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
        break label453;
      }
      paramString = parama.appName;
      if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.ct(paramString))) {
        break label479;
      }
      locala.kiv.setText(com.tencent.mm.pluginsdk.model.app.g.b(parama1.vtz.getContext(), localf, paramString));
      locala.kiv.setVisibility(0);
      if ((localf == null) || (!localf.ZH())) {
        break label463;
      }
      a(parama1, locala.kiv, parambi, parama, localf.field_packageName, parambi.field_msgSvrId);
      label260:
      a(parama1, locala.kiv, parama.appId);
      label273:
      if ((parama.cQF != null) && (parama.cQF.length() != 0)) {
        break label492;
      }
      locala.vBz.setVisibility(8);
      label300:
      switch (parama.type)
      {
      default: 
        label324:
        if (!parama1.cFE()) {
          if (com.tencent.mm.pluginsdk.model.app.g.g(localf))
          {
            locala.vCX.setVisibility(0);
            locala.vBz.setVisibility(8);
            c(parama1, locala.vCX, aw.a(parama, parambi));
          }
        }
        break;
      }
    }
    for (;;)
    {
      locala.igg.setTag(new aw(parambi, parama1.cFE(), paramInt, null, '\000'));
      locala.igg.setOnClickListener(d(parama1));
      if (this.khG)
      {
        locala.igg.setOnLongClickListener(c(parama1));
        locala.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      }
      return;
      label453:
      paramString = localf.field_appName;
      break;
      label463:
      a(parama1, locala.kiv, parama.appId);
      break label260;
      label479:
      locala.kiv.setVisibility(8);
      break label273;
      label492:
      locala.vBz.setVisibility(0);
      b(parama1, locala.vBz, aw.adO(parama.cQF));
      break label300;
      locala.kHQ.setVisibility(0);
      com.tencent.mm.pluginsdk.model.app.b localb = ap.avh().VQ(parama.bFE);
      str = parambi.field_imgPath;
      paramString = Boolean.valueOf(false);
      if (localb != null)
      {
        str = localb.field_fileFullPath;
        paramString = Boolean.valueOf(true);
      }
      if (o.OJ().a(locala.kHQ, str, paramString.booleanValue(), com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), parama.dQO, parama.dQN, R.g.chat_img_template, locala.kHU, R.g.chat_img_default_bg, 1, null)) {
        break label324;
      }
      if (this.khG) {
        locala.kHQ.setImageResource(R.k.chatfrom_bg_pic);
      }
      for (;;)
      {
        locala.kHQ.post(new l.b.1(this, locala));
        break;
        locala.kHQ.setImageBitmap(BitmapFactory.decodeResource(parama1.vtz.getMMResources(), R.g.nosdcard_pic));
      }
      locala.vCX.setVisibility(8);
      continue;
      locala.vCX.setVisibility(8);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    if ((paramView == null) || (parambi == null)) {
      return true;
    }
    int k = ((aw)paramView.getTag()).position;
    com.tencent.mm.pluginsdk.model.app.l.VW(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.by(g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend)).appId, false))) {
      paramContextMenu.add(k, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
    }
    if (d.SP("favorite")) {
      paramContextMenu.add(k, 116, 0, this.vko.vtz.getMMResources().getString(R.l.plugin_favorite_opt));
    }
    Object localObject = new do();
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
        break label397;
      }
      j = paramView.getWidth();
      i = paramView.getHeight();
      paramView.getLocationInWindow(arrayOfInt);
    }
    for (;;)
    {
      paramView = new Intent();
      paramView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
      ((MenuItem)localObject).setIntent(paramView);
      if (bf.k(parambi)) {
        paramContextMenu.clear();
      }
      if (this.vko.cFF()) {
        break;
      }
      paramContextMenu.add(k, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
      return true;
      label397:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, final bi parambi)
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
          do
          {
            return false;
            com.tencent.mm.pluginsdk.model.app.l.ha(parambi.field_msgId);
            bd.bC(parambi.field_msgId);
          } while (localObject1 == null);
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
        if (!parambi.cvx()) {
          if ((System.currentTimeMillis() - parambi.field_createTime <= 259200000L) || ((!bk.bl(paramMenuItem)) && (com.tencent.mm.vfs.e.bK(paramMenuItem)))) {
            break label273;
          }
        }
        label273:
        for (int i = 1; i != 0; i = 0)
        {
          y.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
          h.a(parama.vtz.getContext(), parama.vtz.getContext().getString(R.l.imgdownload_fail_or_cleaned), parama.vtz.getContext().getString(R.l.app_tip), new l.b.2(this));
          return false;
        }
        new ah().post(new Runnable()
        {
          public final void run()
          {
            com.tencent.mm.pluginsdk.model.app.l.a(parambi, null);
          }
        });
        localObject1 = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
        ((Intent)localObject1).putExtra("Retr_Msg_content", bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend));
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
    return (!paramBoolean) && (paramInt == 268435505);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.gM(parama.vtz.getContext());
      return true;
    }
    Object localObject1 = null;
    Object localObject2 = bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend);
    if (localObject2 != null) {
      localObject1 = g.a.gp((String)localObject2);
    }
    if (localObject1 == null)
    {
      y.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
      return true;
    }
    localObject2 = new int[2];
    int j;
    int i;
    if (paramView != null)
    {
      paramView.getLocationInWindow((int[])localObject2);
      j = paramView.getWidth();
      i = paramView.getHeight();
    }
    for (;;)
    {
      paramView = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject1).appId, true);
      if ((paramView != null) && (paramView.ZH())) {
        a(parama, (g.a)localObject1, d(parama, parambi), paramView, parambi.field_msgSvrId);
      }
      if ((((g.a)localObject1).bFE != null) && (((g.a)localObject1).bFE.length() > 0))
      {
        paramView = ap.avh().VQ(((g.a)localObject1).bFE);
        if ((paramView == null) || (!paramView.aXY())) {
          if (parambi.field_isSend == 0)
          {
            l1 = parambi.field_msgId;
            paramView = new Intent();
            paramView.setClassName(this.vko.vtz.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            paramView.putExtra("app_msg_id", l1);
            this.vko.startActivity(paramView);
          }
        }
      }
      while ((((g.a)localObject1).url == null) || (((g.a)localObject1).url.length() <= 0))
      {
        for (;;)
        {
          return true;
          paramView = paramView.field_fileFullPath;
          if (!com.tencent.mm.vfs.e.bK(paramView))
          {
            y.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgSvrId) });
            paramView = new Intent();
            paramView.setClassName(parama.vtz.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
            paramView.putExtra("clean_view_type", 1);
            parama.startActivity(paramView);
            return true;
          }
          if ((paramView != null) && (!paramView.equals("")) && (com.tencent.mm.vfs.e.bK(paramView))) {
            break;
          }
          y.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
        }
        long l1 = parambi.field_msgId;
        long l2 = parambi.field_msgSvrId;
        parama = parambi.field_talker;
        paramView = new Intent(this.vko.vtz.getContext(), ImageGalleryUI.class);
        paramView.putExtra("img_gallery_msg_id", l1);
        paramView.putExtra("img_gallery_talker", parama);
        paramView.putExtra("img_gallery_left", localObject2[0]);
        paramView.putExtra("img_gallery_top", localObject2[1]);
        paramView.putExtra("img_gallery_width", j);
        paramView.putExtra("img_gallery_height", i);
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
      }
      localObject2 = p.u(((g.a)localObject1).url, "message");
      PackageInfo localPackageInfo = getPackageInfo(parama.vtz.getContext(), ((g.a)localObject1).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        label651:
        if (localPackageInfo != null) {
          break label698;
        }
      }
      label698:
      for (i = 0;; i = localPackageInfo.versionCode)
      {
        a(parama, (String)localObject2, (String)localObject2, paramView, i, ((g.a)localObject1).appId, false, parambi.field_msgId, parambi.field_msgSvrId, parambi);
        break;
        paramView = localPackageInfo.versionName;
        break label651;
      }
      i = 0;
      j = 0;
    }
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.b
 * JD-Core Version:    0.7.0.1
 */