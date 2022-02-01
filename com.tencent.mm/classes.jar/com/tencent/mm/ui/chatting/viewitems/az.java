package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.ol;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.q;
import com.tencent.mm.modelimage.q.d;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.av;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.o;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.v.e;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.vfs.y;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class az
{
  public static final class a
    extends c
  {
    private az.c aeUQ;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public static void a(Context paramContext, c.a parama, cc paramcc, boolean paramBoolean)
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
        r.bKa().a(parama.aePK, paramcc.field_imgPath, com.tencent.mm.cd.a.getDensity(paramContext), paramcc.kLh, paramcc.kLi, R.g.chat_img_template, parama.aeRQ, R.g.chat_img_from_default_bg, 1, null);
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
        localObject = new ap(paramLayoutInflater, R.i.gge);
        ((View)localObject).setTag(new az.d().P((View)localObject, true));
      }
      AppMethodBeat.o(37320);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(37321);
      this.aeiK = parama1;
      ((o)parama1.cm(o.class)).cO(paramcc);
      az.d locald = (az.d)parama;
      float f = bt.K(paramcc);
      if (f != 1.0F)
      {
        parama = new ol();
        parama.inO = paramcc.field_msgSvrId;
        parama.iUM = paramcc.getType();
        parama.jjm = bt.G(paramcc);
        parama.ikE = 1L;
        parama.bMH();
        Log.i("MicroMsg.ChattingItemImgFrom", "img need scale:%s, %s", new Object[] { Long.valueOf(paramcc.field_msgId), Float.valueOf(f) });
      }
      boolean bool = r.bKa().a(locald.aePK, paramcc.field_imgPath, f * com.tencent.mm.cd.a.getDensity(parama1.aezO.getContext()), paramcc.kLh, paramcc.kLi, R.g.chat_img_template, locald.aeRQ, R.g.chat_img_default_bg, 1, null);
      locald.aeUT.setVisibility(0);
      a(locald, false, false);
      if (!bool) {
        locald.aePK.setImageBitmap(BitmapFactory.decodeResource(parama1.aezO.getMMResources(), R.g.chat_img_default_bg));
      }
      parama = null;
      if (parama1.juG()) {
        parama = paramcc.field_talker;
      }
      locald.clickArea.setTag(new bz(paramcc, parama1.juG(), paramInt, paramString, parama));
      parama = locald.clickArea;
      if (this.aeUQ == null) {
        this.aeUQ = new az.c(this.aeiK, this);
      }
      az.c.a(this.aeUQ, 0);
      if (bt.H(paramcc)) {
        az.c.a(this.aeUQ, 2);
      }
      parama.setOnClickListener(this.aeUQ);
      locald.clickArea.setOnLongClickListener(c(parama1));
      locald.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
      locald.aePK.setContentDescription(parama1.aezO.getMMResources().getString(R.l.chatting_img_item_desc));
      az.a(paramcc, parama1, locald);
      AppMethodBeat.o(37321);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37324);
      if (100 == paramMenuItem.getItemId()) {
        az.d(paramcc, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37324);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          az.b(parama, paramMenuItem, paramcc);
        } else {
          ((av)parama.cm(av.class)).a(paramMenuItem, paramcc);
        }
      }
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255761);
      bh.bCz();
      int k;
      Object localObject;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null) && (paramcc != null))
      {
        k = ((bz)paramView.getTag()).position;
        paramContextMenuInfo = null;
        if (paramcc.field_msgId > 0L) {
          paramContextMenuInfo = r.bKa().H(paramcc.field_talker, paramcc.field_msgId);
        }
        if (paramContextMenuInfo != null)
        {
          localObject = paramContextMenuInfo;
          if (paramContextMenuInfo.localId > 0L) {}
        }
        else
        {
          localObject = paramContextMenuInfo;
          if (paramcc.field_msgSvrId > 0L) {
            localObject = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
          }
        }
        if ((!bt.N(paramcc)) && (!bt.Q(paramcc))) {
          params.a(k, 110, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        if ((com.tencent.mm.an.g.bGI()) && (!this.aeiK.juH())) {
          params.add(k, 114, 0, paramView.getContext().getString(R.l.gyk));
        }
        if (com.tencent.mm.br.c.blq("favorite")) {
          params.a(k, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        if ((localObject != null) && (((com.tencent.mm.modelimage.h)localObject).status != -1))
        {
          paramContextMenuInfo = params.a(k, 131, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit), R.k.icons_filled_pencil);
          localObject = new int[2];
          if (paramView == null) {
            break label575;
          }
          j = paramView.getWidth();
          i = paramView.getHeight();
          paramView.getLocationOnScreen((int[])localObject);
        }
      }
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", localObject[0]).putExtra("img_gallery_top", localObject[1]);
        paramContextMenuInfo.setIntent(localIntent);
        paramContextMenuInfo = new ex();
        paramContextMenuInfo.hFc.msgId = paramcc.field_msgId;
        paramContextMenuInfo.publish();
        if ((paramContextMenuInfo.hFd.hEn) || (com.tencent.mm.pluginsdk.model.app.h.bj(this.aeiK.aezO.getContext(), paramcc.getType()))) {
          params.a(k, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
        }
        if (!this.aeiK.juH()) {
          params.a(k, 100, paramView.getContext().getString(R.l.gyn), R.k.icons_filled_delete);
        }
        if ((bt.F(paramcc)) || (bt.O(paramcc)) || (bt.I(paramcc)))
        {
          params.clear();
          if (!this.aeiK.juH()) {
            params.a(k, 100, paramView.getContext().getString(R.l.gyn), R.k.icons_filled_delete);
          }
        }
        if (bt.H(paramcc))
        {
          params = new ol();
          params.inO = paramcc.field_msgSvrId;
          params.iUM = paramcc.getType();
          params.jjm = bt.G(paramcc);
          params.ikE = 3L;
          params.bMH();
        }
        AppMethodBeat.o(255761);
        return true;
        label575:
        i = 0;
        j = 0;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(37322);
      boolean bool = parama.juG();
      AppMethodBeat.o(37322);
      return bool;
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 39) || (paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 33));
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements v.n
  {
    private az.c aeUQ;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
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
      if ((paramInt1 >= 100) && (parama.aeUS.getVisibility() != 0))
      {
        AppMethodBeat.o(37330);
        return;
      }
      parama.aeUS.setText(paramInt1 + "%");
      if (jxj()) {
        a(parama, false);
      }
      for (;;)
      {
        parama.aeUS.setVisibility(0);
        parama.aeUT.setVisibility(0);
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
        parama.aeUS.setVisibility(4);
        parama.aeUT.setVisibility(4);
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
        localObject = new ap(paramLayoutInflater, R.i.ghc);
        ((View)localObject).setTag(new az.d().P((View)localObject, false));
      }
      AppMethodBeat.o(37326);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(37327);
      this.aeiK = parama1;
      paramString = (az.d)parama;
      parama = q.bJO();
      long l = paramcc.field_msgId;
      boolean bool2 = parama.oIO.containsKey(Long.valueOf(l));
      Object localObject1 = r.bKa().af(paramcc);
      int i;
      int j;
      boolean bool1;
      Object localObject2;
      Object localObject3;
      int k;
      if ((localObject1 != null) && (!bool2)) {
        if (q.bJO().iT(((com.tencent.mm.modelimage.h)localObject1).localId))
        {
          parama = q.bJO().iU(((com.tencent.mm.modelimage.h)localObject1).localId);
          i = (int)parama.total;
          j = (int)parama.offset;
          if (i == 0)
          {
            bool1 = true;
            float f1 = bt.K(paramcc);
            if (f1 != 1.0F)
            {
              parama = new ol();
              parama.inO = paramcc.field_msgSvrId;
              parama.iUM = paramcc.getType();
              parama.jjm = bt.G(paramcc);
              parama.ikE = 1L;
              parama.bMH();
              Log.i("MicroMsg.ChattingItemImgTo", "img need scale:%s, %s", new Object[] { Long.valueOf(paramcc.field_msgId), Float.valueOf(f1) });
            }
            localObject2 = r.bKa();
            localObject3 = paramString.aePK;
            String str = paramcc.field_imgPath;
            float f2 = com.tencent.mm.cd.a.getDensity(parama1.aezO.getContext());
            i = paramcc.kLh;
            j = paramcc.kLi;
            k = R.g.chat_img_template;
            ImageView localImageView = paramString.aeRQ;
            int m = R.g.chat_img_default_bg;
            if (!bool1) {
              break label745;
            }
            parama = null;
            label269:
            if (!((j)localObject2).a((ImageView)localObject3, str, f1 * f2, i, j, k, localImageView, m, 0, parama)) {
              paramString.aePK.setImageDrawable(com.tencent.mm.cd.a.m(parama1.aezO.getContext(), R.g.chat_img_default_bg));
            }
            if ((localObject1 == null) && (!bool2)) {
              break label995;
            }
            if ((!bool1) && (paramcc.field_status != 5)) {
              break label754;
            }
            k = 1;
            label346:
            if (!bool2) {
              break label760;
            }
            paramString.aeUS.setText("0%");
            if (k != 0) {
              break label977;
            }
            bool1 = true;
            label370:
            a(paramString, bool1, false);
            parama = paramString.aeUS;
            if (k == 0) {
              break label983;
            }
            i = 8;
            label394:
            parama.setVisibility(i);
            parama = paramString.aeUT;
            if (k == 0) {
              break label989;
            }
            i = 8;
            label415:
            parama.setVisibility(i);
            label421:
            paramString.clickArea.setTag(new bz(paramcc, parama1.juG(), paramInt, paramcc.field_talker, '\000'));
            parama = paramString.clickArea;
            if (this.aeUQ == null) {
              this.aeUQ = new az.c(this.aeiK, this);
            }
            az.c.a(this.aeUQ, 0);
            if (bt.H(paramcc)) {
              az.c.a(this.aeUQ, 2);
            }
            parama.setOnClickListener(this.aeUQ);
            paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.aePK.setContentDescription(parama1.aezO.getMMResources().getString(R.l.chatting_img_item_desc));
            if (jxj())
            {
              a(paramString, false, false);
              Log.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[] { Long.valueOf(paramcc.field_msgId), Integer.valueOf(paramcc.field_status) });
              if (jxj())
              {
                if ((paramcc.field_status != 2) || (!b((m)parama1.cm(m.class), paramcc.field_msgId))) {
                  break label1026;
                }
                if (paramString.aeNG != null) {
                  paramString.aeNG.setVisibility(0);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, paramcc, parama1.getSelfUserName(), false, parama1.juG(), parama1, this);
        az.a(paramcc, parama1, paramString);
        AppMethodBeat.o(37327);
        return;
        if ((j == i) && (i != 0))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        bool1 = com.tencent.mm.modelimage.i.b((com.tencent.mm.modelimage.h)localObject1);
        break;
        bool1 = false;
        break;
        label745:
        parama = paramString.aeUT;
        break label269;
        label754:
        k = 0;
        break label346;
        label760:
        parama = paramString.aeUS;
        localObject2 = new StringBuilder();
        if (localObject1 != null)
        {
          j = ((com.tencent.mm.modelimage.h)localObject1).osy;
          i = ((com.tencent.mm.modelimage.h)localObject1).offset;
          if (q.bJO().iT(((com.tencent.mm.modelimage.h)localObject1).localId))
          {
            localObject3 = q.bJO().iU(((com.tencent.mm.modelimage.h)localObject1).localId);
            j = (int)((q.d)localObject3).total;
            i = (int)((q.d)localObject3).offset;
          }
          if (((com.tencent.mm.modelimage.h)localObject1).bJE())
          {
            localObject3 = r.bKa().wq(((com.tencent.mm.modelimage.h)localObject1).oGB);
            if (q.bJO().iT(((com.tencent.mm.modelimage.h)localObject1).oGB))
            {
              localObject1 = q.bJO().iU(((com.tencent.mm.modelimage.h)localObject1).oGB);
              j = (int)((q.d)localObject1).total;
              i = (int)((q.d)localObject1).offset;
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
          j = ((com.tencent.mm.modelimage.h)localObject3).osy;
          i = ((com.tencent.mm.modelimage.h)localObject3).offset;
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
        paramString.aeUT.setVisibility(8);
        a(paramString, false, false);
        paramString.aeUS.setVisibility(8);
        break label421;
        label1026:
        if (paramString.aeNG != null) {
          paramString.aeNG.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37329);
      if (100 == paramMenuItem.getItemId()) {
        az.d(paramcc, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37329);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          az.b(parama, paramMenuItem, paramcc);
        } else {
          ((av)parama.cm(av.class)).a(paramMenuItem, paramcc);
        }
      }
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255770);
      bh.bCz();
      int k;
      Object localObject;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null))
      {
        k = ((bz)paramView.getTag()).position;
        localObject = null;
        if (paramcc.field_msgId > 0L) {
          localObject = r.bKa().H(paramcc.field_talker, paramcc.field_msgId);
        }
        if (localObject != null)
        {
          paramContextMenuInfo = (ContextMenu.ContextMenuInfo)localObject;
          if (((com.tencent.mm.modelimage.h)localObject).localId > 0L) {}
        }
        else
        {
          paramContextMenuInfo = (ContextMenu.ContextMenuInfo)localObject;
          if (paramcc.field_msgSvrId > 0L) {
            paramContextMenuInfo = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
          }
        }
        localObject = paramContextMenuInfo;
        if (paramContextMenuInfo != null)
        {
          localObject = paramContextMenuInfo;
          if (paramContextMenuInfo.bJE())
          {
            localObject = paramContextMenuInfo;
            if (paramContextMenuInfo.osy == 0) {
              localObject = r.bKa().wq(paramContextMenuInfo.oGB);
            }
          }
        }
        if ((!bt.N(paramcc)) && (!bt.Q(paramcc))) {
          params.a(k, 110, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        if (paramcc.field_status == 5) {
          params.a(k, 103, paramView.getContext().getString(R.l.gzm), R.k.icons_filled_refresh);
        }
        if ((com.tencent.mm.an.g.bGI()) && (!this.aeiK.juH())) {
          params.add(k, 114, 0, paramView.getContext().getString(R.l.gyk));
        }
        if (com.tencent.mm.br.c.blq("favorite")) {
          params.a(k, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        if (((com.tencent.mm.modelimage.h)localObject).status != -1)
        {
          paramContextMenuInfo = params.a(k, 131, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit), R.k.icons_filled_pencil);
          localObject = new int[2];
          if (paramView == null) {
            break label822;
          }
          j = paramView.getWidth();
          i = paramView.getHeight();
          paramView.getLocationOnScreen((int[])localObject);
        }
      }
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", localObject[0]).putExtra("img_gallery_top", localObject[1]);
        paramContextMenuInfo.setIntent(localIntent);
        paramContextMenuInfo = new ex();
        paramContextMenuInfo.hFc.msgId = paramcc.field_msgId;
        paramContextMenuInfo.publish();
        if ((paramContextMenuInfo.hFd.hEn) || (com.tencent.mm.pluginsdk.model.app.h.bj(this.aeiK.aezO.getContext(), paramcc.getType()))) {
          params.a(k, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
        }
        if ((!paramcc.iYe()) && (paramcc.iYk()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!com.tencent.mm.storage.au.Hh(this.aeiK.getTalkerUserName()))) {
          params.a(k, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
        }
        if (!this.aeiK.juH())
        {
          if ((!paramcc.iYe()) && (paramcc.iYk()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!com.tencent.mm.storage.au.Hh(this.aeiK.getTalkerUserName()))) {
            params.a(k, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
          }
          params.a(k, 100, paramView.getContext().getString(R.l.gyn), R.k.icons_filled_delete);
        }
        if ((bt.F(paramcc)) || (bt.O(paramcc)) || (bt.I(paramcc)))
        {
          params.clear();
          if (!this.aeiK.juH()) {
            params.a(k, 100, paramView.getContext().getString(R.l.gyn), R.k.icons_filled_delete);
          }
        }
        if (bt.H(paramcc))
        {
          params = new ol();
          params.inO = paramcc.field_msgSvrId;
          params.iUM = paramcc.getType();
          params.jjm = bt.G(paramcc);
          params.ikE = 3L;
          params.bMH();
        }
        AppMethodBeat.o(255770);
        return true;
        label822:
        i = 0;
        j = 0;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255783);
      paramcc.unsetOmittedFailResend();
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
      ((av)parama.cm(av.class)).cK(paramcc);
      AppMethodBeat.o(255783);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 39) || (paramInt == 33));
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
  
  public static final class c
    extends v.e
  {
    private c aeUR;
    private int scene;
    
    public c(com.tencent.mm.ui.chatting.d.a parama, c paramc)
    {
      super();
      this.scene = 0;
      this.aeUR = paramc;
    }
    
    public c(com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc, View paramView)
    {
      super();
      AppMethodBeat.i(37333);
      this.scene = 0;
      this.aeUR = paramc;
      this.scene = 1;
      if (this.scene == 1)
      {
        b.oUZ.ar(paramcc);
        a(new bz(paramcc, this.aeiK.juG(), 0, paramcc.field_talker, '\000'), paramView);
      }
      AppMethodBeat.o(37333);
    }
    
    private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37336);
      Log.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] doGetMsgImg");
      Intent localIntent = new Intent(this.aeiK.aezO.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("show_search_chat_content_result", ((com.tencent.mm.ui.chatting.component.api.au)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jty());
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("key_is_biz_chat", ((e)this.aeiK.cm(e.class)).jqV());
      localIntent.putExtra("key_biz_chat_id", ((e)this.aeiK.cm(e.class)).jrk());
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
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.au.Hh(paramString1));
      paramString2 = this.aeiK.getTalkerUserName();
      paramArrayOfInt = new Bundle();
      if (this.aeiK.juG()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        paramArrayOfInt.putInt("stat_scene", paramInt1);
        paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
        paramArrayOfInt.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", paramArrayOfInt);
        localIntent.putExtra("img_gallery_session_id", k(paramLong2, paramString1, paramString2));
        paramString1 = this.aeiK;
        paramString2 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString1.startActivity((Intent)paramString2.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.aeiK.aezO.overridePendingTransition(0, 0);
        AppMethodBeat.o(37336);
        return;
        if (ab.IS(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    public static void a(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37337);
      a(parama, paramcc, paramLong1, paramLong2, paramString1, paramString2, paramArrayOfInt, paramInt1, paramInt2, true, 0);
      AppMethodBeat.o(37337);
    }
    
    private static void a(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(37338);
      Log.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
      Intent localIntent = new Intent(parama.aezO.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("show_search_chat_content_result", ((com.tencent.mm.ui.chatting.component.api.au)parama.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jty());
      localIntent.putExtra("key_is_biz_chat", ((e)parama.cm(e.class)).jqV());
      localIntent.putExtra("key_biz_chat_id", ((e)parama.cm(e.class)).jrk());
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
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.au.Hh(paramString1));
      paramString2 = parama.getTalkerUserName();
      if (paramcc.field_isSend == 1) {
        paramString1 = parama.getSelfUserName();
      }
      paramcc = new Bundle();
      if (parama.juF()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        paramcc.putInt("stat_scene", paramInt1);
        paramcc.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        paramcc.putString("stat_chat_talker_username", paramString2);
        paramcc.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", paramcc);
        localIntent.putExtra("img_gallery_session_id", k(paramLong2, paramString1, paramString2));
        paramcc = parama.aezO;
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramcc, paramString1.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramcc.startActivity((Intent)paramString1.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramcc, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.aezO.overridePendingTransition(0, 0);
        AppMethodBeat.o(37338);
        return;
        if (ab.IS(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    private void a(bz parambz, View paramView)
    {
      AppMethodBeat.i(37335);
      cc localcc = parambz.hTm;
      com.tencent.mm.modelstat.a.a(localcc, a.a.oUW);
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        if (aw.jkS())
        {
          paramView.getLocationOnScreen(arrayOfInt);
          i = paramView.getWidth();
          j = paramView.getHeight();
        }
      }
      else
      {
        if (localcc.field_isSend != 1) {
          break label203;
        }
        paramView = r.bKa().H(localcc.field_talker, localcc.field_msgId);
        if ((paramView != null) && (paramView.localId != 0L)) {
          break label847;
        }
        paramView = r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
      }
      label203:
      label847:
      for (;;)
      {
        Object localObject = XmlParser.parseXml(localcc.field_content, "msg", null);
        if (localObject != null) {
          Util.getLong((String)((Map)localObject).get(".msg.img.$hdlength"), 0L);
        }
        if (paramView != null)
        {
          bh.bCz();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            aa.j(this.aeiK.aezO.getContext(), this.aeiK.aezO.getContentView());
            AppMethodBeat.o(37335);
            return;
            paramView.getLocationInWindow(arrayOfInt);
            break;
            paramView = r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
            continue;
          }
          long l1;
          long l2;
          String str;
          if (localcc.field_isSend == 1)
          {
            localObject = com.tencent.mm.modelimage.i.c(paramView);
            if (y.ZC(r.bKa().v((String)localObject, "", "")))
            {
              paramView.bJE();
              localObject = this.aeiK;
              l1 = paramView.oGz;
              l2 = paramView.hTh;
              str = parambz.userName;
              paramView.bJE();
              a((com.tencent.mm.ui.chatting.d.a)localObject, localcc, l1, l2, str, parambz.chatroomName, arrayOfInt, i, j, false, this.scene);
              AppMethodBeat.o(37335);
              return;
            }
            localObject = paramView.oGr;
            if (y.ZC(r.bKa().v((String)localObject, "", "")))
            {
              localObject = this.aeiK;
              l1 = paramView.oGz;
              l2 = paramView.hTh;
              str = parambz.userName;
              paramView.bJE();
              a((com.tencent.mm.ui.chatting.d.a)localObject, localcc, l1, l2, str, parambz.chatroomName, arrayOfInt, i, j, false, this.scene);
              AppMethodBeat.o(37335);
              return;
            }
            a(localcc.field_msgId, localcc.field_msgSvrId, parambz.userName, parambz.chatroomName, arrayOfInt, i, j);
            AppMethodBeat.o(37335);
            return;
          }
          if (paramView.bJD())
          {
            str = paramView.oGr;
            localObject = str;
            if (paramView.bJE())
            {
              com.tencent.mm.modelimage.h localh = com.tencent.mm.modelimage.i.a(paramView);
              localObject = str;
              if (localh != null)
              {
                localObject = str;
                if (localh.localId > 0L)
                {
                  localObject = str;
                  if (localh.bJD())
                  {
                    localObject = str;
                    if (y.ZC(r.bKa().v(localh.oGr, "", ""))) {
                      localObject = localh.oGr;
                    }
                  }
                }
              }
            }
            if (y.ZC(r.bKa().v((String)localObject, "", "")))
            {
              localObject = this.aeiK;
              l1 = paramView.oGz;
              l2 = paramView.hTh;
              str = parambz.userName;
              paramView.bJE();
              a((com.tencent.mm.ui.chatting.d.a)localObject, localcc, l1, l2, str, parambz.chatroomName, arrayOfInt, i, j, false, this.scene);
              AppMethodBeat.o(37335);
              return;
            }
            Log.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.localId) });
            paramView.NQ("SERVERID://" + localcc.field_msgSvrId);
            paramView.eQp = 16;
            paramView.wk(0);
            paramView.eQp = 8;
            paramView.setStatus(0);
            paramView.eQp = 256;
            r.bKa().a(Long.valueOf(paramView.localId), paramView);
            a(localcc.field_msgId, localcc.field_msgSvrId, parambz.userName, parambz.chatroomName, arrayOfInt, i, j);
            AppMethodBeat.o(37335);
            return;
          }
          if (paramView.status == -1)
          {
            Log.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.localId) });
            paramView.setStatus(0);
            paramView.eQp = 256;
            r.bKa().a(Long.valueOf(paramView.localId), paramView);
          }
          a(localcc.field_msgId, localcc.field_msgSvrId, parambz.userName, parambz.chatroomName, arrayOfInt, i, j);
        }
        AppMethodBeat.o(37335);
        return;
      }
    }
    
    private static String k(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(37339);
      String str = ad.Jo(String.valueOf(paramLong));
      ad.b localb = ad.bCb().M(str, true);
      localb.q("preUsername", paramString1);
      localb.q("preChatName", paramString2);
      int i = 3;
      if ((com.tencent.mm.an.g.Mx(paramString2)) || (com.tencent.mm.storage.au.Hh(paramString2))) {
        i = 5;
      }
      localb.q("Contact_Sub_Scene", Integer.valueOf(i));
      localb.q("Contact_Scene_Note", paramString2);
      AppMethodBeat.o(37339);
      return str;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37334);
      Object localObject = (bz)paramView.getTag();
      b.oUZ.ar(((bz)localObject).hTm);
      a((bz)localObject, paramView);
      localObject = k.b.M(2, paramcc.field_content);
      com.tencent.mm.pluginsdk.model.app.g localg;
      if ((localObject != null) && (!Util.isNullOrNil(((k.b)localObject).appId)) && (this.aeUR != null))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.s(((k.b)localObject).appId, false, false);
        if (localg != null) {
          if (!(this.aeUR instanceof az.a)) {
            break label128;
          }
        }
      }
      label128:
      for (paramView = c.d(parama, paramcc);; paramView = z.bAM())
      {
        c.a(parama, (k.b)localObject, paramView, localg, paramcc.field_msgSvrId, parama.getTalkerUserName());
        c.c(parama, paramcc);
        AppMethodBeat.o(37334);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az
 * JD-Core Version:    0.7.0.1
 */