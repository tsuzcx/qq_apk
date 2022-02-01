package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.p;
import com.tencent.mm.ay.p.d;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.b.a.ll;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.vfs.u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class az
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    private az.c Xkf;
    
    public static void a(Context paramContext, c.a parama, ca paramca, boolean paramBoolean)
    {
      AppMethodBeat.i(37325);
      if (true != paramBoolean)
      {
        AppMethodBeat.o(37325);
        return;
      }
      if ((parama instanceof az.d))
      {
        parama = (az.d)parama;
        q.bmh().a(parama.XfI, paramca.field_imgPath, com.tencent.mm.ci.a.getDensity(paramContext), paramca.ili, paramca.ilj, R.g.chat_img_template, parama.XhK, R.g.chat_img_from_default_bg, 1, null);
      }
      AppMethodBeat.o(37325);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37320);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.edo);
        ((View)localObject).setTag(new az.d().J((View)localObject, true));
      }
      AppMethodBeat.o(37320);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(37321);
      this.WBq = parama1;
      ((m)parama1.bC(m.class)).cs(paramca);
      az.d locald = (az.d)parama;
      float f = bs.I(paramca);
      if (f != 1.0F)
      {
        parama = new ll();
        parama.ghT = paramca.field_msgSvrId;
        parama.gKR = paramca.getType();
        parama.gQQ = bs.E(paramca);
        parama.gef = 1L;
        parama.bpa();
        Log.i("MicroMsg.ChattingItemImgFrom", "img need scale:%s, %s", new Object[] { Long.valueOf(paramca.field_msgId), Float.valueOf(f) });
      }
      boolean bool = q.bmh().a(locald.XfI, paramca.field_imgPath, f * com.tencent.mm.ci.a.getDensity(parama1.WQv.getContext()), paramca.ili, paramca.ilj, R.g.chat_img_template, locald.XhK, R.g.chat_img_default_bg, 1, null);
      locald.Xki.setVisibility(0);
      a(locald, false, false);
      if (!bool) {
        locald.XfI.setImageBitmap(BitmapFactory.decodeResource(parama1.WQv.getMMResources(), R.g.chat_img_default_bg));
      }
      parama = null;
      if (parama1.hRi()) {
        parama = paramca.field_talker;
      }
      locald.clickArea.setTag(new by(paramca, parama1.hRi(), paramInt, paramString, parama));
      parama = locald.clickArea;
      if (this.Xkf == null) {
        this.Xkf = new az.c(this.WBq, this);
      }
      az.c.a(this.Xkf, 0);
      if (bs.F(paramca)) {
        az.c.a(this.Xkf, 2);
      }
      parama.setOnClickListener(this.Xkf);
      locald.clickArea.setOnLongClickListener(c(parama1));
      locald.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
      az.a(paramca, parama1, locald);
      AppMethodBeat.o(37321);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37324);
      if (100 == paramMenuItem.getItemId()) {
        az.c(paramca, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37324);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          az.b(parama, paramMenuItem, paramca);
        } else {
          ((ao)parama.bC(ao.class)).a(paramMenuItem, paramca);
        }
      }
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(284366);
      bh.beI();
      int k;
      Object localObject1;
      Object localObject2;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null) && (paramca != null))
      {
        k = ((by)paramView.getTag()).position;
        localObject1 = null;
        if (paramca.field_msgId > 0L) {
          localObject1 = q.bmh().D(paramca.field_talker, paramca.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.ay.g)localObject1).localId > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (paramca.field_msgSvrId > 0L) {
            localObject2 = q.bmh().C(paramca.field_talker, paramca.field_msgSvrId);
          }
        }
        if ((!bs.L(paramca)) && (!bs.O(paramca))) {
          paramo.a(k, 110, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        if ((com.tencent.mm.ao.g.biY()) && (!this.WBq.hRj())) {
          paramo.add(k, 114, 0, paramView.getContext().getString(R.l.evJ));
        }
        if (com.tencent.mm.by.c.blP("favorite")) {
          paramo.a(k, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        if ((localObject2 != null) && (((com.tencent.mm.ay.g)localObject2).status != -1))
        {
          localObject1 = paramo.a(k, 131, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit), R.k.icons_filled_pencil);
          localObject2 = new int[2];
          if (paramView == null) {
            break label572;
          }
          j = paramView.getWidth();
          i = paramView.getHeight();
          paramView.getLocationOnScreen((int[])localObject2);
        }
      }
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
        ((MenuItem)localObject1).setIntent(localIntent);
        localObject1 = new em();
        ((em)localObject1).fAp.msgId = paramca.field_msgId;
        EventCenter.instance.publish((IEvent)localObject1);
        if ((((em)localObject1).fAq.fzO) || (com.tencent.mm.pluginsdk.model.app.h.aQ(this.WBq.WQv.getContext(), paramca.getType()))) {
          paramo.a(k, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
        }
        if (!this.WBq.hRj()) {
          paramo.a(k, 100, paramView.getContext().getString(R.l.evN), R.k.icons_filled_delete);
        }
        if ((bs.D(paramca)) || (bs.M(paramca)) || (bs.G(paramca)))
        {
          paramo.clear();
          if (!this.WBq.hRj()) {
            paramo.a(k, 100, paramView.getContext().getString(R.l.evN), R.k.icons_filled_delete);
          }
        }
        if (bs.F(paramca))
        {
          paramo = new ll();
          paramo.ghT = paramca.field_msgSvrId;
          paramo.gKR = paramca.getType();
          paramo.gQQ = bs.E(paramca);
          paramo.gef = 3L;
          paramo.bpa();
        }
        AppMethodBeat.o(284366);
        return true;
        label572:
        i = 0;
        j = 0;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37322);
      boolean bool = parama.hRi();
      AppMethodBeat.o(37322);
      return bool;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 39) || (paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 33));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean hTD()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    private az.c Xkf;
    
    public static void a(c.a parama, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37330);
      if (paramInt2 > 0) {
        if (paramInt1 >= paramInt2) {
          paramInt1 = 100;
        }
      }
      while (parama == null)
      {
        Log.e("MicroMsg.ChattingItemImgTo", "[updateImgUploadProgress] tag is null");
        AppMethodBeat.o(37330);
        return;
        paramInt1 = (int)(paramInt1 * 100L / paramInt2);
        continue;
        paramInt1 = 0;
      }
      parama = (az.d)parama;
      if ((paramInt1 >= 100) && (parama.Xkh.getVisibility() != 0))
      {
        AppMethodBeat.o(37330);
        return;
      }
      parama.Xkh.setText(paramInt1 + "%");
      if (hTG()) {
        a(parama, false);
      }
      for (;;)
      {
        parama.Xkh.setVisibility(0);
        parama.Xki.setVisibility(0);
        AppMethodBeat.o(37330);
        return;
        a(parama, true);
      }
    }
    
    public static void c(c.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(37331);
      if ((paramBoolean == true) && ((parama instanceof az.d)))
      {
        parama = (az.d)parama;
        a(parama, false);
        parama.Xkh.setVisibility(4);
        parama.Xki.setVisibility(4);
      }
      AppMethodBeat.o(37331);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37326);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.eem);
        ((View)localObject).setTag(new az.d().J((View)localObject, false));
      }
      AppMethodBeat.o(37326);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(37327);
      this.WBq = parama1;
      paramString = (az.d)parama;
      parama = p.blV();
      long l = paramca.field_msgId;
      boolean bool2 = parama.lQe.containsKey(Long.valueOf(l));
      Object localObject1 = q.bmh().aa(paramca);
      int i;
      int j;
      boolean bool1;
      Object localObject2;
      Object localObject3;
      int k;
      if ((localObject1 != null) && (!bool2)) {
        if (p.blV().GI(((com.tencent.mm.ay.g)localObject1).localId))
        {
          parama = p.blV().GJ(((com.tencent.mm.ay.g)localObject1).localId);
          i = (int)parama.total;
          j = (int)parama.offset;
          if (i == 0)
          {
            bool1 = true;
            float f1 = bs.I(paramca);
            if (f1 != 1.0F)
            {
              parama = new ll();
              parama.ghT = paramca.field_msgSvrId;
              parama.gKR = paramca.getType();
              parama.gQQ = bs.E(paramca);
              parama.gef = 1L;
              parama.bpa();
              Log.i("MicroMsg.ChattingItemImgTo", "img need scale:%s, %s", new Object[] { Long.valueOf(paramca.field_msgId), Float.valueOf(f1) });
            }
            localObject2 = q.bmh();
            localObject3 = paramString.XfI;
            String str = paramca.field_imgPath;
            float f2 = com.tencent.mm.ci.a.getDensity(parama1.WQv.getContext());
            i = paramca.ili;
            j = paramca.ilj;
            k = R.g.chat_img_template;
            ImageView localImageView = paramString.XhK;
            int m = R.g.chat_img_default_bg;
            if (!bool1) {
              break label745;
            }
            parama = null;
            label269:
            if (!((com.tencent.mm.ay.i)localObject2).a((ImageView)localObject3, str, f1 * f2, i, j, k, localImageView, m, 0, parama)) {
              paramString.XfI.setImageDrawable(com.tencent.mm.ci.a.m(parama1.WQv.getContext(), R.g.chat_img_default_bg));
            }
            if ((localObject1 == null) && (!bool2)) {
              break label995;
            }
            if ((!bool1) && (paramca.field_status != 5)) {
              break label754;
            }
            k = 1;
            label346:
            if (!bool2) {
              break label760;
            }
            paramString.Xkh.setText("0%");
            if (k != 0) {
              break label977;
            }
            bool1 = true;
            label370:
            a(paramString, bool1, false);
            parama = paramString.Xkh;
            if (k == 0) {
              break label983;
            }
            i = 8;
            label394:
            parama.setVisibility(i);
            parama = paramString.Xki;
            if (k == 0) {
              break label989;
            }
            i = 8;
            label415:
            parama.setVisibility(i);
            label421:
            paramString.clickArea.setTag(new by(paramca, parama1.hRi(), paramInt, paramca.field_talker, '\000'));
            parama = paramString.clickArea;
            if (this.Xkf == null) {
              this.Xkf = new az.c(this.WBq, this);
            }
            az.c.a(this.Xkf, 0);
            if (bs.F(paramca)) {
              az.c.a(this.Xkf, 2);
            }
            parama.setOnClickListener(this.Xkf);
            paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.XfI.setContentDescription(parama1.WQv.getMMResources().getString(R.l.chatting_img_item_desc));
            if (hTG())
            {
              a(paramString, false, false);
              Log.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[] { Long.valueOf(paramca.field_msgId), Integer.valueOf(paramca.field_status) });
              if (hTG())
              {
                if ((paramca.field_status != 2) || (!b((k)parama1.bC(k.class), paramca.field_msgId))) {
                  break label1026;
                }
                if (paramString.XdI != null) {
                  paramString.XdI.setVisibility(0);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, paramca, parama1.getSelfUserName(), false, parama1.hRi(), parama1, this);
        az.a(paramca, parama1, paramString);
        AppMethodBeat.o(37327);
        return;
        if ((j == i) && (i != 0))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        bool1 = com.tencent.mm.ay.h.b((com.tencent.mm.ay.g)localObject1);
        break;
        bool1 = false;
        break;
        label745:
        parama = paramString.Xki;
        break label269;
        label754:
        k = 0;
        break label346;
        label760:
        parama = paramString.Xkh;
        localObject2 = new StringBuilder();
        if (localObject1 != null)
        {
          j = ((com.tencent.mm.ay.g)localObject1).lAW;
          i = ((com.tencent.mm.ay.g)localObject1).offset;
          if (p.blV().GI(((com.tencent.mm.ay.g)localObject1).localId))
          {
            localObject3 = p.blV().GJ(((com.tencent.mm.ay.g)localObject1).localId);
            j = (int)((p.d)localObject3).total;
            i = (int)((p.d)localObject3).offset;
          }
          if (((com.tencent.mm.ay.g)localObject1).blK())
          {
            localObject3 = q.bmh().wl(((com.tencent.mm.ay.g)localObject1).lNR);
            if (p.blV().GI(((com.tencent.mm.ay.g)localObject1).lNR))
            {
              localObject1 = p.blV().GJ(((com.tencent.mm.ay.g)localObject1).lNR);
              j = (int)((p.d)localObject1).total;
              i = (int)((p.d)localObject1).offset;
            }
          }
          else
          {
            label903:
            if (j <= 0) {
              break label971;
            }
            if (i < j) {
              break label958;
            }
            i = 100;
          }
        }
        for (;;)
        {
          parama.setText(i + "%");
          break;
          j = ((com.tencent.mm.ay.g)localObject3).lAW;
          i = ((com.tencent.mm.ay.g)localObject3).offset;
          break label903;
          label958:
          i = i * 100 / j;
          continue;
          label971:
          i = 0;
        }
        label977:
        bool1 = false;
        break label370;
        label983:
        i = 0;
        break label394;
        label989:
        i = 0;
        break label415;
        label995:
        paramString.Xki.setVisibility(8);
        a(paramString, false, false);
        paramString.Xkh.setVisibility(8);
        break label421;
        label1026:
        if (paramString.XdI != null) {
          paramString.XdI.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37329);
      if (100 == paramMenuItem.getItemId()) {
        az.c(paramca, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37329);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          az.b(parama, paramMenuItem, paramca);
        } else {
          ((ao)parama.bC(ao.class)).a(paramMenuItem, paramca);
        }
      }
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(290064);
      bh.beI();
      int k;
      Object localObject2;
      Object localObject1;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null))
      {
        k = ((by)paramView.getTag()).position;
        localObject2 = null;
        if (paramca.field_msgId > 0L) {
          localObject2 = q.bmh().D(paramca.field_talker, paramca.field_msgId);
        }
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((com.tencent.mm.ay.g)localObject2).localId > 0L) {}
        }
        else
        {
          localObject1 = localObject2;
          if (paramca.field_msgSvrId > 0L) {
            localObject1 = q.bmh().C(paramca.field_talker, paramca.field_msgSvrId);
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.ay.g)localObject1).blK())
          {
            localObject2 = localObject1;
            if (((com.tencent.mm.ay.g)localObject1).lAW == 0) {
              localObject2 = q.bmh().wl(((com.tencent.mm.ay.g)localObject1).lNR);
            }
          }
        }
        if ((!bs.L(paramca)) && (!bs.O(paramca))) {
          paramo.a(k, 110, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        if (paramca.field_status == 5) {
          paramo.a(k, 103, paramView.getContext().getString(R.l.ewJ), R.k.icons_filled_refresh);
        }
        if ((com.tencent.mm.ao.g.biY()) && (!this.WBq.hRj())) {
          paramo.add(k, 114, 0, paramView.getContext().getString(R.l.evJ));
        }
        if (com.tencent.mm.by.c.blP("favorite")) {
          paramo.a(k, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        if (((com.tencent.mm.ay.g)localObject2).status != -1)
        {
          localObject1 = paramo.a(k, 131, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit), R.k.icons_filled_pencil);
          localObject2 = new int[2];
          if (paramView == null) {
            break label725;
          }
          j = paramView.getWidth();
          i = paramView.getHeight();
          paramView.getLocationOnScreen((int[])localObject2);
        }
      }
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
        ((MenuItem)localObject1).setIntent(localIntent);
        localObject1 = new em();
        ((em)localObject1).fAp.msgId = paramca.field_msgId;
        EventCenter.instance.publish((IEvent)localObject1);
        if ((((em)localObject1).fAq.fzO) || (com.tencent.mm.pluginsdk.model.app.h.aQ(this.WBq.WQv.getContext(), paramca.getType()))) {
          paramo.a(k, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
        }
        if ((!paramca.hwA()) && (paramca.hwG()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
          paramo.a(k, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
        }
        if (!this.WBq.hRj()) {
          paramo.a(k, 100, paramView.getContext().getString(R.l.evN), R.k.icons_filled_delete);
        }
        if ((bs.D(paramca)) || (bs.M(paramca)) || (bs.G(paramca)))
        {
          paramo.clear();
          if (!this.WBq.hRj()) {
            paramo.a(k, 100, paramView.getContext().getString(R.l.evN), R.k.icons_filled_delete);
          }
        }
        if (bs.F(paramca))
        {
          paramo = new ll();
          paramo.ghT = paramca.field_msgSvrId;
          paramo.gKR = paramca.getType();
          paramo.gQQ = bs.E(paramca);
          paramo.gef = 3L;
          paramo.bpa();
        }
        AppMethodBeat.o(290064);
        return true;
        label725:
        i = 0;
        j = 0;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(290068);
      paramca.unsetOmittedFailResend();
      bh.beI();
      com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
      ((ao)parama.bC(ao.class)).co(paramca);
      AppMethodBeat.o(290068);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 39) || (paramInt == 33));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
  
  public static final class c
    extends t.e
  {
    private c Xkg;
    private int scene;
    
    public c(com.tencent.mm.ui.chatting.e.a parama, c paramc)
    {
      super();
      this.scene = 0;
      this.Xkg = paramc;
    }
    
    public c(com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca, View paramView)
    {
      super();
      AppMethodBeat.i(37333);
      this.scene = 0;
      this.Xkg = paramc;
      this.scene = 1;
      if (this.scene == 1)
      {
        b.mcf.am(paramca);
        a(new by(paramca, this.WBq.hRi(), 0, paramca.field_talker, '\000'), paramView);
      }
      AppMethodBeat.o(37333);
    }
    
    private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37336);
      Log.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] doGetMsgImg");
      Intent localIntent = new Intent(this.WBq.WQv.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("show_search_chat_content_result", ((an)this.WBq.bC(an.class)).hQw());
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("key_is_biz_chat", ((d)this.WBq.bC(d.class)).hOe());
      localIntent.putExtra("key_biz_chat_id", ((d)this.WBq.bC(d.class)).hOs());
      localIntent.putExtra("img_gallery_talker", paramString1);
      localIntent.putExtra("img_gallery_chatroom_name", paramString2);
      localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramInt1);
      localIntent.putExtra("img_gallery_height", paramInt2);
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", true);
      localIntent.putExtra("msg_type", this.scene);
      if (this.scene == 1) {
        localIntent.putExtra("show_enter_grid", false);
      }
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", as.OS(paramString1));
      paramString2 = this.WBq.getTalkerUserName();
      paramArrayOfInt = new Bundle();
      if (this.WBq.hRi()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        paramArrayOfInt.putInt("stat_scene", paramInt1);
        paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
        paramArrayOfInt.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", paramArrayOfInt);
        localIntent.putExtra("img_gallery_session_id", i(paramLong2, paramString1, paramString2));
        paramString1 = this.WBq;
        paramString2 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString1.startActivity((Intent)paramString2.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.WBq.WQv.overridePendingTransition(0, 0);
        AppMethodBeat.o(37336);
        return;
        if (ab.Qm(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    public static void a(com.tencent.mm.ui.chatting.e.a parama, ca paramca, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37337);
      a(parama, paramca, paramLong1, paramLong2, paramString1, paramString2, paramArrayOfInt, paramInt1, paramInt2, true, 0);
      AppMethodBeat.o(37337);
    }
    
    private static void a(com.tencent.mm.ui.chatting.e.a parama, ca paramca, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(37338);
      Log.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
      Intent localIntent = new Intent(parama.WQv.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("show_search_chat_content_result", ((an)parama.bC(an.class)).hQw());
      localIntent.putExtra("key_is_biz_chat", ((d)parama.bC(d.class)).hOe());
      localIntent.putExtra("key_biz_chat_id", ((d)parama.bC(d.class)).hOs());
      localIntent.putExtra("img_gallery_talker", paramString1);
      localIntent.putExtra("img_gallery_chatroom_name", paramString2);
      localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramInt1);
      localIntent.putExtra("img_gallery_height", paramInt2);
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", true);
      localIntent.putExtra("img_gallery_enter_PhotoEditUI", paramBoolean);
      localIntent.putExtra("msg_type", paramInt3);
      if (paramInt3 == 1) {
        localIntent.putExtra("show_enter_grid", false);
      }
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", as.OS(paramString1));
      paramString2 = parama.getTalkerUserName();
      if (paramca.field_isSend == 1) {
        paramString1 = parama.getSelfUserName();
      }
      paramca = new Bundle();
      if (parama.hRh()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        paramca.putInt("stat_scene", paramInt1);
        paramca.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        paramca.putString("stat_chat_talker_username", paramString2);
        paramca.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", paramca);
        localIntent.putExtra("img_gallery_session_id", i(paramLong2, paramString1, paramString2));
        paramca = parama.WQv;
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramca, paramString1.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramca.startActivity((Intent)paramString1.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramca, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.WQv.overridePendingTransition(0, 0);
        AppMethodBeat.o(37338);
        return;
        if (ab.Qm(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    private void a(by paramby, View paramView)
    {
      AppMethodBeat.i(37335);
      ca localca = paramby.fNz;
      com.tencent.mm.modelstat.a.a(localca, a.a.mcb);
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        if (ar.hIH())
        {
          paramView.getLocationOnScreen(arrayOfInt);
          i = paramView.getWidth();
          j = paramView.getHeight();
        }
      }
      else
      {
        if (localca.field_isSend == 1)
        {
          paramView = q.bmh().D(localca.field_talker, localca.field_msgId);
          if (paramView.localId != 0L) {
            break label819;
          }
        }
        paramView = q.bmh().C(localca.field_talker, localca.field_msgSvrId);
      }
      label819:
      for (;;)
      {
        Object localObject = XmlParser.parseXml(localca.field_content, "msg", null);
        if (localObject != null) {
          Util.getLong((String)((Map)localObject).get(".msg.img.$hdlength"), 0L);
        }
        bh.beI();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          w.g(this.WBq.WQv.getContext(), this.WBq.WQv.getContentView());
          AppMethodBeat.o(37335);
          return;
          paramView.getLocationInWindow(arrayOfInt);
          break;
        }
        long l1;
        long l2;
        String str;
        if (localca.field_isSend == 1)
        {
          localObject = com.tencent.mm.ay.h.c(paramView);
          if (u.agG(q.bmh().r((String)localObject, "", "")))
          {
            paramView.blK();
            localObject = this.WBq;
            l1 = paramView.lNP;
            l2 = paramView.fNu;
            str = paramby.userName;
            paramView.blK();
            a((com.tencent.mm.ui.chatting.e.a)localObject, localca, l1, l2, str, paramby.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          localObject = paramView.lNH;
          if (u.agG(q.bmh().r((String)localObject, "", "")))
          {
            localObject = this.WBq;
            l1 = paramView.lNP;
            l2 = paramView.fNu;
            str = paramby.userName;
            paramView.blK();
            a((com.tencent.mm.ui.chatting.e.a)localObject, localca, l1, l2, str, paramby.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          a(localca.field_msgId, localca.field_msgSvrId, paramby.userName, paramby.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.blJ())
        {
          str = paramView.lNH;
          localObject = str;
          if (paramView.blK())
          {
            com.tencent.mm.ay.g localg = com.tencent.mm.ay.h.a(paramView);
            localObject = str;
            if (localg != null)
            {
              localObject = str;
              if (localg.localId > 0L)
              {
                localObject = str;
                if (localg.blJ())
                {
                  localObject = str;
                  if (u.agG(q.bmh().r(localg.lNH, "", ""))) {
                    localObject = localg.lNH;
                  }
                }
              }
            }
          }
          if (u.agG(q.bmh().r((String)localObject, "", "")))
          {
            localObject = this.WBq;
            l1 = paramView.lNP;
            l2 = paramView.fNu;
            str = paramby.userName;
            paramView.blK();
            a((com.tencent.mm.ui.chatting.e.a)localObject, localca, l1, l2, str, paramby.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          Log.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.localId) });
          paramView.VN("SERVERID://" + localca.field_msgSvrId);
          paramView.cUP = 16;
          paramView.wf(0);
          paramView.cUP = 8;
          paramView.setStatus(0);
          paramView.cUP = 256;
          q.bmh().a(Long.valueOf(paramView.localId), paramView);
          a(localca.field_msgId, localca.field_msgSvrId, paramby.userName, paramby.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.status == -1)
        {
          Log.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.localId) });
          paramView.setStatus(0);
          paramView.cUP = 256;
          q.bmh().a(Long.valueOf(paramView.localId), paramView);
        }
        a(localca.field_msgId, localca.field_msgSvrId, paramby.userName, paramby.chatroomName, arrayOfInt, i, j);
        AppMethodBeat.o(37335);
        return;
      }
    }
    
    private static String i(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(37339);
      String str = ad.Rp(String.valueOf(paramLong));
      ad.b localb = ad.beh().I(str, true);
      localb.k("preUsername", paramString1);
      localb.k("preChatName", paramString2);
      int i = 3;
      if ((com.tencent.mm.ao.g.Uy(paramString2)) || (as.OS(paramString2))) {
        i = 5;
      }
      localb.k("Contact_Sub_Scene", Integer.valueOf(i));
      localb.k("Contact_Scene_Note", paramString2);
      AppMethodBeat.o(37339);
      return str;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37334);
      Object localObject = (by)paramView.getTag();
      b.mcf.am(((by)localObject).fNz);
      a((by)localObject, paramView);
      localObject = k.b.OP(paramca.field_content);
      com.tencent.mm.pluginsdk.model.app.g localg;
      if ((localObject != null) && (!Util.isNullOrNil(((k.b)localObject).appId)) && (this.Xkg != null))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject).appId, false, false);
        if (localg != null) {
          if (!(this.Xkg instanceof az.a)) {
            break label127;
          }
        }
      }
      label127:
      for (paramView = c.d(parama, paramca);; paramView = z.bcZ())
      {
        c.a(parama, (k.b)localObject, paramView, localg, paramca.field_msgSvrId, parama.getTalkerUserName());
        c.c(parama, paramca);
        AppMethodBeat.o(37334);
        return;
      }
    }
  }
  
  static final class d
    extends c.a
  {
    ImageView XdI;
    ImageView XfI;
    ImageView XhK;
    TextView Xkh;
    View Xki;
    TextView wRL;
    
    public final c.a J(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37340);
      super.create(paramView);
      this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
      this.XfI = ((ImageView)paramView.findViewById(R.h.dxe));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.maskView = paramView.findViewById(R.h.dyD);
      this.Xki = paramView.findViewById(R.h.dYB);
      if (paramBoolean)
      {
        this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.downloading_pb));
      }
      for (;;)
      {
        this.XhK = ((ImageView)paramView.findViewById(R.h.dxg));
        this.wRL = ((TextView)paramView.findViewById(R.h.dwI));
        AppMethodBeat.o(37340);
        return this;
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
        this.Xkh = ((TextView)paramView.findViewById(R.h.dYA));
        this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
        this.XdI = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      }
    }
    
    public final View getMainContainerView()
    {
      return this.XfI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az
 * JD-Core Version:    0.7.0.1
 */