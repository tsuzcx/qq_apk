package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.b.b.z;

public final class ab$a
  extends c
{
  private ab.c vEW;
  private com.tencent.mm.ui.chatting.c.a vko;
  
  public static void a(Context paramContext, c.a parama, bi parambi, boolean paramBoolean)
  {
    if (true != paramBoolean) {
      return;
    }
    parama = (ab.d)parama;
    o.OJ().a(parama.vCQ, parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(paramContext), parambi.cQG, parambi.cQH, R.g.chat_img_template, parama.vEZ, R.g.chat_img_from_default_bg, 1, null);
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_picture);
      ((View)localObject).setTag(new ab.d().s((View)localObject, true));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    ((i)parama1.ac(i.class)).aV(parambi);
    ab.d locald = (ab.d)parama;
    boolean bool = o.OJ().a(locald.vCQ, parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), parambi.cQG, parambi.cQH, R.g.chat_img_template, locald.vEZ, R.g.chat_img_default_bg, 1, null);
    locald.vFa.setVisibility(0);
    locald.nhQ.setVisibility(8);
    if ((!bool) && (!this.khG)) {
      locald.vCQ.setImageBitmap(BitmapFactory.decodeResource(parama1.vtz.getMMResources(), R.g.nosdcard_pic));
    }
    parama = null;
    if (parama1.cFE()) {
      parama = parambi.field_talker;
    }
    locald.igg.setTag(new aw(parambi, parama1.cFE(), paramInt, paramString, parama));
    parama = locald.igg;
    if (this.vEW == null) {
      this.vEW = new ab.c(this.vko, this);
    }
    parama.setOnClickListener(this.vEW);
    locald.igg.setOnLongClickListener(c(parama1));
    locald.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
    ab.a(parambi, parama1, locald);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    au.Hx();
    int k;
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null) && (parambi != null))
    {
      k = ((aw)paramView.getTag()).position;
      localObject1 = null;
      if (parambi.field_msgId > 0L) {
        localObject1 = o.OJ().bY(parambi.field_msgId);
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.as.e)localObject1).enp > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (parambi.field_msgSvrId > 0L) {
          localObject2 = o.OJ().bX(parambi.field_msgSvrId);
        }
      }
      paramContextMenu.add(k, 110, 0, paramView.getContext().getString(R.l.retransmit));
      if ((f.Mi()) && (!this.vko.cFF())) {
        paramContextMenu.add(k, 114, 0, paramView.getContext().getString(R.l.chatting_long_click_brand_service));
      }
      if (d.SP("favorite")) {
        paramContextMenu.add(k, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
      }
      localObject1 = new do();
      ((do)localObject1).bJZ.bIt = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
      if ((((do)localObject1).bKa.bJy) || (com.tencent.mm.pluginsdk.model.app.g.S(this.vko.vtz.getContext(), parambi.getType()))) {
        paramContextMenu.add(k, 129, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_open));
      }
      if ((localObject2 != null) && (((com.tencent.mm.as.e)localObject2).status != -1))
      {
        localObject1 = paramContextMenu.add(k, 131, 0, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit));
        localObject2 = new int[2];
        if (paramView == null) {
          break label443;
        }
        j = paramView.getWidth();
        i = paramView.getHeight();
        paramView.getLocationInWindow((int[])localObject2);
      }
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
      ((MenuItem)localObject1).setIntent(localIntent);
      if (bf.k(parambi)) {
        paramContextMenu.clear();
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(k, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_img));
      }
      return true;
      label443:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    if (100 == paramMenuItem.getItemId()) {
      ab.b(parambi, parama);
    }
    for (;;)
    {
      return false;
      if (131 == paramMenuItem.getItemId()) {
        ab.b(parama, paramMenuItem, parambi);
      } else {
        ((z)parama.ac(z.class)).a(paramMenuItem, parambi);
      }
    }
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 39) || (paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 33));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.a
 * JD-Core Version:    0.7.0.1
 */