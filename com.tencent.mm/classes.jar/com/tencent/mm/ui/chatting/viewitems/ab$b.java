package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.as.n;
import com.tencent.mm.as.n.d;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.z;
import com.tencent.mm.ui.chatting.t.m;
import java.util.concurrent.ConcurrentHashMap;

public final class ab$b
  extends c
  implements t.m
{
  private ab.c vEW;
  private com.tencent.mm.ui.chatting.c.a vko;
  
  public static void a(c.a parama, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      if (paramInt1 >= paramInt2) {
        paramInt1 = 100;
      }
    }
    for (;;)
    {
      parama = (ab.d)parama;
      if ((paramInt1 < 100) || (parama.vEY.getVisibility() == 0)) {
        break;
      }
      return;
      paramInt1 = (int)(paramInt1 * 100L / paramInt2);
      continue;
      paramInt1 = 0;
    }
    parama.vEY.setText(paramInt1 + "%");
    if (cHc()) {
      parama.nhQ.setVisibility(8);
    }
    for (;;)
    {
      parama.vEY.setVisibility(0);
      parama.vFa.setVisibility(0);
      return;
      parama.nhQ.setVisibility(0);
    }
  }
  
  public static void a(c.a parama, boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      parama = (ab.d)parama;
      parama.nhQ.setVisibility(4);
      parama.vEY.setVisibility(4);
      parama.vFa.setVisibility(4);
    }
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_picture);
      ((View)localObject).setTag(new ab.d().s((View)localObject, false));
    }
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    parambi.cvz();
    au.Hx();
    com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
    ((z)parama.ac(z.class)).aR(parambi);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    paramString = (ab.d)parama;
    parama = n.OA();
    long l = parambi.field_msgId;
    boolean bool2 = parama.epC.containsKey(Long.valueOf(l));
    Object localObject1 = o.OJ().q(parambi);
    int i;
    int j;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    int k;
    if ((localObject1 != null) && (!bool2)) {
      if (n.OA().ca(((com.tencent.mm.as.e)localObject1).enp))
      {
        parama = n.OA().cb(((com.tencent.mm.as.e)localObject1).enp);
        i = (int)parama.bRM;
        j = (int)parama.pj;
        if (i == 0)
        {
          bool1 = true;
          localObject2 = o.OJ();
          localObject3 = paramString.vCQ;
          String str = parambi.field_imgPath;
          float f = com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext());
          i = parambi.cQG;
          j = parambi.cQH;
          k = R.g.chat_img_template;
          ImageView localImageView = paramString.vEZ;
          int m = R.g.chat_img_default_bg;
          if (!bool1) {
            break label627;
          }
          parama = null;
          label173:
          if ((!((com.tencent.mm.as.g)localObject2).a((ImageView)localObject3, str, f, i, j, k, localImageView, m, 0, parama)) && (!this.khG)) {
            paramString.vCQ.setImageDrawable(com.tencent.mm.cb.a.g(parama1.vtz.getContext(), R.g.nosdcard_pic));
          }
          if ((localObject1 == null) && (!bool2)) {
            break label877;
          }
          if ((!bool1) && (parambi.field_status != 5)) {
            break label636;
          }
          k = 1;
          label254:
          if (!bool2) {
            break label642;
          }
          paramString.vEY.setText("0%");
          parama = paramString.nhQ;
          if (k == 0) {
            break label859;
          }
          i = 8;
          label285:
          parama.setVisibility(i);
          parama = paramString.vEY;
          if (k == 0) {
            break label865;
          }
          i = 8;
          label306:
          parama.setVisibility(i);
          parama = paramString.vFa;
          if (k == 0) {
            break label871;
          }
          i = 8;
          label327:
          parama.setVisibility(i);
          label333:
          paramString.igg.setTag(new aw(parambi, parama1.cFE(), paramInt, parambi.field_talker, '\000'));
          parama = paramString.igg;
          if (this.vEW == null) {
            this.vEW = new ab.c(this.vko, this);
          }
          parama.setOnClickListener(this.vEW);
          paramString.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
          paramString.igg.setOnLongClickListener(c(parama1));
          paramString.vCQ.setContentDescription(parama1.vtz.getMMResources().getString(R.l.chatting_img_item_desc));
          if (cHc())
          {
            paramString.nhQ.setVisibility(8);
            y.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[] { Long.valueOf(parambi.field_msgId), Integer.valueOf(parambi.field_status) });
            if (cHc())
            {
              if ((parambi.field_status != 2) || (!a((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi.field_msgId))) {
                break label910;
              }
              if (paramString.vBN != null) {
                paramString.vBN.setVisibility(0);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      a(paramInt, paramString, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
      ab.a(parambi, parama1, paramString);
      return;
      if ((j == i) && (i != 0))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      bool1 = com.tencent.mm.as.f.b((com.tencent.mm.as.e)localObject1);
      break;
      bool1 = false;
      break;
      label627:
      parama = paramString.vFa;
      break label173;
      label636:
      k = 0;
      break label254;
      label642:
      parama = paramString.vEY;
      localObject2 = new StringBuilder();
      if (localObject1 != null)
      {
        i = ((com.tencent.mm.as.e)localObject1).ebK;
        j = ((com.tencent.mm.as.e)localObject1).offset;
        if (n.OA().ca(((com.tencent.mm.as.e)localObject1).enp))
        {
          localObject3 = n.OA().cb(((com.tencent.mm.as.e)localObject1).enp);
          i = (int)((n.d)localObject3).bRM;
          j = (int)((n.d)localObject3).pj;
        }
        if (((com.tencent.mm.as.e)localObject1).Or())
        {
          localObject3 = o.OJ().iH(((com.tencent.mm.as.e)localObject1).enz);
          if (n.OA().ca(((com.tencent.mm.as.e)localObject1).enz))
          {
            localObject1 = n.OA().cb(((com.tencent.mm.as.e)localObject1).enz);
            i = (int)((n.d)localObject1).bRM;
            j = (int)((n.d)localObject1).pj;
          }
        }
        else
        {
          label785:
          if (i <= 0) {
            break label853;
          }
          if (j < i) {
            break label840;
          }
          i = 100;
        }
      }
      for (;;)
      {
        parama.setText(i + "%");
        break;
        i = ((com.tencent.mm.as.e)localObject3).ebK;
        j = ((com.tencent.mm.as.e)localObject3).offset;
        break label785;
        label840:
        i = j * 100 / i;
        continue;
        label853:
        i = 0;
      }
      label859:
      i = 0;
      break label285;
      label865:
      i = 0;
      break label306;
      label871:
      i = 0;
      break label327;
      label877:
      paramString.vFa.setVisibility(8);
      paramString.nhQ.setVisibility(8);
      paramString.vEY.setVisibility(8);
      break label333;
      label910:
      if (paramString.vBN != null) {
        paramString.vBN.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    au.Hx();
    int k;
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null))
    {
      k = ((aw)paramView.getTag()).position;
      localObject2 = null;
      if (parambi.field_msgId > 0L) {
        localObject2 = o.OJ().bY(parambi.field_msgId);
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((com.tencent.mm.as.e)localObject2).enp > 0L) {}
      }
      else
      {
        localObject1 = localObject2;
        if (parambi.field_msgSvrId > 0L) {
          localObject1 = o.OJ().bX(parambi.field_msgSvrId);
        }
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.as.e)localObject1).Or())
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.as.e)localObject1).ebK == 0) {
            localObject2 = o.OJ().iH(((com.tencent.mm.as.e)localObject1).enz);
          }
        }
      }
      paramContextMenu.add(k, 110, 0, paramView.getContext().getString(R.l.retransmit));
      if (parambi.field_status == 5) {
        paramContextMenu.add(k, 103, 0, paramView.getContext().getString(R.l.chatting_resend_title));
      }
      if ((com.tencent.mm.ai.f.Mi()) && (!this.vko.cFF())) {
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
      if (((com.tencent.mm.as.e)localObject2).status != -1)
      {
        localObject1 = paramContextMenu.add(k, 131, 0, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit));
        localObject2 = new int[2];
        if (paramView == null) {
          break label570;
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
      if ((!parambi.ctz()) && (parambi.ctB()) && ((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
        paramContextMenu.add(k, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(k, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_img));
      }
      return true;
      label570:
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
    return (paramBoolean) && ((paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 39) || (paramInt == 33));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.b
 * JD-Core Version:    0.7.0.1
 */