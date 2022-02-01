package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.e;
import com.tencent.mm.av.n;
import com.tencent.mm.av.n.d;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.n;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ao
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    private ao.c IoD;
    
    public static void a(Context paramContext, c.a parama, bo parambo, boolean paramBoolean)
    {
      AppMethodBeat.i(37325);
      if (true != paramBoolean)
      {
        AppMethodBeat.o(37325);
        return;
      }
      if ((parama instanceof ao.d))
      {
        parama = (ao.d)parama;
        o.aFx().a(parama.Ilc, parambo.field_imgPath, com.tencent.mm.cc.a.getDensity(paramContext), parambo.eSc, parambo.eSd, parama.ImA, 2131231562, 1, null);
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
        localObject = new ag(paramLayoutInflater, 2131493457);
        ((View)localObject).setTag(new ao.d().z((View)localObject, true));
      }
      AppMethodBeat.o(37320);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(37321);
      this.HNS = parama1;
      ((k)parama1.bf(k.class)).bD(parambo);
      ao.d locald = (ao.d)parama;
      boolean bool = o.aFx().a(locald.Ilc, parambo.field_imgPath, com.tencent.mm.cc.a.getDensity(parama1.HZF.getContext()), parambo.eSc, parambo.eSd, locald.ImA, 2131231559, 1, null);
      locald.IoG.setVisibility(0);
      a(locald, false, false);
      if (!bool) {
        locald.Ilc.setImageBitmap(BitmapFactory.decodeResource(parama1.HZF.getMMResources(), 2131231559));
      }
      parama = null;
      if (parama1.foQ()) {
        parama = parambo.field_talker;
      }
      locald.nDl.setTag(new bj(parambo, parama1.foQ(), paramInt, paramString, parama));
      parama = locald.nDl;
      if (this.IoD == null) {
        this.IoD = new ao.c(this.HNS, this);
      }
      parama.setOnClickListener(this.IoD);
      locald.nDl.setOnLongClickListener(c(parama1));
      locald.nDl.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmb());
      ao.a(parambo, parama1, locald);
      AppMethodBeat.o(37321);
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(37323);
      az.ayM();
      int k;
      Object localObject1;
      Object localObject2;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null) && (parambo != null))
      {
        k = ((bj)paramView.getTag()).position;
        localObject1 = null;
        if (parambo.field_msgId > 0L) {
          localObject1 = o.aFx().qg(parambo.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((e)localObject1).dcd > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (parambo.field_msgSvrId > 0L) {
            localObject2 = o.aFx().qf(parambo.field_msgSvrId);
          }
        }
        if (!bk.y(parambo)) {
          paramContextMenu.add(k, 110, 0, paramView.getContext().getString(2131762559));
        }
        if ((com.tencent.mm.al.f.aCx()) && (!this.HNS.foR())) {
          paramContextMenu.add(k, 114, 0, paramView.getContext().getString(2131757217));
        }
        if (com.tencent.mm.br.d.aCT("favorite")) {
          paramContextMenu.add(k, 116, 0, paramView.getContext().getString(2131761941));
        }
        localObject1 = new com.tencent.mm.g.a.dy();
        ((com.tencent.mm.g.a.dy)localObject1).ddK.msgId = parambo.field_msgId;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        if ((((com.tencent.mm.g.a.dy)localObject1).ddL.ddj) || (com.tencent.mm.pluginsdk.model.app.h.am(this.HNS.HZF.getContext(), parambo.getType()))) {
          paramContextMenu.add(k, 129, 0, paramView.getContext().getString(2131757228));
        }
        if ((localObject2 != null) && (((e)localObject2).status != -1))
        {
          localObject1 = paramContextMenu.add(k, 131, 0, paramView.getContext().getString(2131757183));
          localObject2 = new int[2];
          if (paramView == null) {
            break label498;
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
        if (!this.HNS.foR()) {
          paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131757220));
        }
        if ((bk.x(parambo)) || (bk.z(parambo)))
        {
          paramContextMenu.clear();
          if (!this.HNS.foR()) {
            paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131757220));
          }
        }
        AppMethodBeat.o(37323);
        return true;
        label498:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37324);
      if (100 == paramMenuItem.getItemId()) {
        ao.c(parambo, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37324);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          ao.b(parama, paramMenuItem, parambo);
        } else {
          ((af)parama.bf(af.class)).a(paramMenuItem, parambo);
        }
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      return false;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(37322);
      boolean bool = parama.foQ();
      AppMethodBeat.o(37322);
      return bool;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 39) || (paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 33));
    }
    
    public final boolean fqu()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    private ao.c IoD;
    
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
        ac.e("MicroMsg.ChattingItemImgTo", "[updateImgUploadProgress] tag is null");
        AppMethodBeat.o(37330);
        return;
        paramInt1 = (int)(paramInt1 * 100L / paramInt2);
        continue;
        paramInt1 = 0;
      }
      parama = (ao.d)parama;
      if ((paramInt1 >= 100) && (parama.IoF.getVisibility() != 0))
      {
        AppMethodBeat.o(37330);
        return;
      }
      parama.IoF.setText(paramInt1 + "%");
      if (fqw()) {
        a(parama, false);
      }
      for (;;)
      {
        parama.IoF.setVisibility(0);
        parama.IoG.setVisibility(0);
        AppMethodBeat.o(37330);
        return;
        a(parama, true);
      }
    }
    
    public static void c(c.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(37331);
      if ((paramBoolean == true) && ((parama instanceof ao.d)))
      {
        parama = (ao.d)parama;
        a(parama, false);
        parama.IoF.setVisibility(4);
        parama.IoG.setVisibility(4);
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
        localObject = new ag(paramLayoutInflater, 2131493500);
        ((View)localObject).setTag(new ao.d().z((View)localObject, false));
      }
      AppMethodBeat.o(37326);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37332);
      parambo.fbV();
      az.ayM();
      com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
      ((af)parama.bf(af.class)).bz(parambo);
      AppMethodBeat.o(37332);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(37327);
      this.HNS = parama1;
      paramString = (ao.d)parama;
      parama = n.aFl();
      long l = parambo.field_msgId;
      boolean bool2 = parama.hJf.containsKey(Long.valueOf(l));
      Object localObject1 = o.aFx().I(parambo);
      int i;
      int j;
      boolean bool1;
      Object localObject2;
      Object localObject3;
      label168:
      int k;
      if ((localObject1 != null) && (!bool2)) {
        if (n.aFl().qi(((e)localObject1).dcd))
        {
          parama = n.aFl().qj(((e)localObject1).dcd);
          i = (int)parama.dne;
          j = (int)parama.offset;
          if (i == 0)
          {
            bool1 = true;
            localObject2 = o.aFx();
            localObject3 = paramString.Ilc;
            String str = parambo.field_imgPath;
            float f = com.tencent.mm.cc.a.getDensity(parama1.HZF.getContext());
            i = parambo.eSc;
            j = parambo.eSd;
            ImageView localImageView = paramString.ImA;
            if (!bool1) {
              break label612;
            }
            parama = null;
            if (!((com.tencent.mm.av.g)localObject2).a((ImageView)localObject3, str, f, i, j, localImageView, 2131231559, 0, parama)) {
              paramString.Ilc.setImageDrawable(com.tencent.mm.cc.a.l(parama1.HZF.getContext(), 2131231559));
            }
            if ((localObject1 == null) && (!bool2)) {
              break label862;
            }
            if ((!bool1) && (parambo.field_status != 5)) {
              break label621;
            }
            k = 1;
            label239:
            if (!bool2) {
              break label627;
            }
            paramString.IoF.setText("0%");
            if (k != 0) {
              break label844;
            }
            bool1 = true;
            label263:
            a(paramString, bool1, false);
            parama = paramString.IoF;
            if (k == 0) {
              break label850;
            }
            i = 8;
            label287:
            parama.setVisibility(i);
            parama = paramString.IoG;
            if (k == 0) {
              break label856;
            }
            i = 8;
            label308:
            parama.setVisibility(i);
            label314:
            paramString.nDl.setTag(new bj(parambo, parama1.foQ(), paramInt, parambo.field_talker, '\000'));
            parama = paramString.nDl;
            if (this.IoD == null) {
              this.IoD = new ao.c(this.HNS, this);
            }
            parama.setOnClickListener(this.IoD);
            paramString.nDl.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmb());
            paramString.nDl.setOnLongClickListener(c(parama1));
            paramString.Ilc.setContentDescription(parama1.HZF.getMMResources().getString(2131757186));
            if (fqw())
            {
              a(paramString, false, false);
              ac.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[] { Long.valueOf(parambo.field_msgId), Integer.valueOf(parambo.field_status) });
              if (fqw())
              {
                if ((parambo.field_status != 2) || (!a((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class), parambo.field_msgId))) {
                  break label893;
                }
                if (paramString.Ijf != null) {
                  paramString.Ijf.setVisibility(0);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, parambo, parama1.foM(), false, parama1.foQ(), parama1, this);
        ao.a(parambo, parama1, paramString);
        AppMethodBeat.o(37327);
        return;
        if ((j == i) && (i != 0))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        bool1 = com.tencent.mm.av.f.b((e)localObject1);
        break;
        bool1 = false;
        break;
        label612:
        parama = paramString.IoG;
        break label168;
        label621:
        k = 0;
        break label239;
        label627:
        parama = paramString.IoF;
        localObject2 = new StringBuilder();
        if (localObject1 != null)
        {
          j = ((e)localObject1).hux;
          i = ((e)localObject1).offset;
          if (n.aFl().qi(((e)localObject1).dcd))
          {
            localObject3 = n.aFl().qj(((e)localObject1).dcd);
            j = (int)((n.d)localObject3).dne;
            i = (int)((n.d)localObject3).offset;
          }
          if (((e)localObject1).aFa())
          {
            localObject3 = o.aFx().oR(((e)localObject1).hGX);
            if (n.aFl().qi(((e)localObject1).hGX))
            {
              localObject1 = n.aFl().qj(((e)localObject1).hGX);
              j = (int)((n.d)localObject1).dne;
              i = (int)((n.d)localObject1).offset;
            }
          }
          else
          {
            label770:
            if (j <= 0) {
              break label838;
            }
            if (i < j) {
              break label825;
            }
            i = 100;
          }
        }
        for (;;)
        {
          parama.setText(i + "%");
          break;
          j = ((e)localObject3).hux;
          i = ((e)localObject3).offset;
          break label770;
          label825:
          i = i * 100 / j;
          continue;
          label838:
          i = 0;
        }
        label844:
        bool1 = false;
        break label263;
        label850:
        i = 0;
        break label287;
        label856:
        i = 0;
        break label308;
        label862:
        paramString.IoG.setVisibility(8);
        a(paramString, false, false);
        paramString.IoF.setVisibility(8);
        break label314;
        label893:
        if (paramString.Ijf != null) {
          paramString.Ijf.setVisibility(8);
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(37328);
      az.ayM();
      int k;
      Object localObject2;
      Object localObject1;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null))
      {
        k = ((bj)paramView.getTag()).position;
        localObject2 = null;
        if (parambo.field_msgId > 0L) {
          localObject2 = o.aFx().qg(parambo.field_msgId);
        }
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((e)localObject2).dcd > 0L) {}
        }
        else
        {
          localObject1 = localObject2;
          if (parambo.field_msgSvrId > 0L) {
            localObject1 = o.aFx().qf(parambo.field_msgSvrId);
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((e)localObject1).aFa())
          {
            localObject2 = localObject1;
            if (((e)localObject1).hux == 0) {
              localObject2 = o.aFx().oR(((e)localObject1).hGX);
            }
          }
        }
        if (!bk.y(parambo)) {
          paramContextMenu.add(k, 110, 0, paramView.getContext().getString(2131762559));
        }
        if (parambo.field_status == 5) {
          paramContextMenu.add(k, 103, 0, paramView.getContext().getString(2131757286));
        }
        if ((com.tencent.mm.al.f.aCx()) && (!this.HNS.foR())) {
          paramContextMenu.add(k, 114, 0, paramView.getContext().getString(2131757217));
        }
        if (com.tencent.mm.br.d.aCT("favorite")) {
          paramContextMenu.add(k, 116, 0, paramView.getContext().getString(2131761941));
        }
        localObject1 = new com.tencent.mm.g.a.dy();
        ((com.tencent.mm.g.a.dy)localObject1).ddK.msgId = parambo.field_msgId;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        if ((((com.tencent.mm.g.a.dy)localObject1).ddL.ddj) || (com.tencent.mm.pluginsdk.model.app.h.am(this.HNS.HZF.getContext(), parambo.getType()))) {
          paramContextMenu.add(k, 129, 0, paramView.getContext().getString(2131757228));
        }
        if (((e)localObject2).status != -1)
        {
          localObject1 = paramContextMenu.add(k, 131, 0, paramView.getContext().getString(2131757183));
          localObject2 = new int[2];
          if (paramView == null) {
            break label654;
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
        if ((!parambo.eZj()) && (parambo.eZm()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker)) && (!ai.vC(this.HNS.getTalkerUserName()))) {
          paramContextMenu.add(k, 123, 0, paramView.getContext().getString(2131757234));
        }
        if (!this.HNS.foR()) {
          paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131757220));
        }
        if ((bk.x(parambo)) || (bk.z(parambo)))
        {
          paramContextMenu.clear();
          if (!this.HNS.foR()) {
            paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131757220));
          }
        }
        AppMethodBeat.o(37328);
        return true;
        label654:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37329);
      if (100 == paramMenuItem.getItemId()) {
        ao.c(parambo, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37329);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          ao.b(parama, paramMenuItem, parambo);
        } else {
          ((af)parama.bf(af.class)).a(paramMenuItem, parambo);
        }
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      return false;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 39) || (paramInt == 33));
    }
    
    public final boolean fqu()
    {
      return true;
    }
  }
  
  public static final class c
    extends s.e
  {
    private c IoE;
    private int scene;
    
    public c(com.tencent.mm.ui.chatting.d.a parama, c paramc)
    {
      super();
      this.scene = 0;
      this.IoE = paramc;
    }
    
    public c(com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo, View paramView)
    {
      super();
      AppMethodBeat.i(37333);
      this.scene = 0;
      this.IoE = paramc;
      this.scene = 1;
      if (this.scene == 1)
      {
        com.tencent.mm.modelstat.b.hUE.R(parambo);
        a(new bj(parambo, this.HNS.foQ(), 0, parambo.field_talker, '\000'), paramView);
      }
      AppMethodBeat.o(37333);
    }
    
    private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37336);
      ac.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] doGetMsgImg");
      Intent localIntent = new Intent(this.HNS.HZF.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("show_search_chat_content_result", ((ae)this.HNS.bf(ae.class)).foi());
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.c.b.d)this.HNS.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo());
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.c.b.d)this.HNS.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmB());
      localIntent.putExtra("img_gallery_talker", paramString1);
      localIntent.putExtra("img_gallery_chatroom_name", paramString2);
      localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramInt1);
      localIntent.putExtra("img_gallery_height", paramInt2);
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((ae)this.HNS.bf(ae.class)).fod());
      localIntent.putExtra("msg_type", this.scene);
      if (this.scene == 1) {
        localIntent.putExtra("show_enter_grid", false);
      }
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", ai.vC(paramString1));
      paramString2 = this.HNS.getTalkerUserName();
      paramArrayOfInt = new Bundle();
      if (this.HNS.foQ()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        paramArrayOfInt.putInt("stat_scene", paramInt1);
        paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
        paramArrayOfInt.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", paramArrayOfInt);
        localIntent.putExtra("img_gallery_session_id", g(paramLong2, paramString1, paramString2));
        paramString1 = this.HNS;
        paramString2 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString1.startActivity((Intent)paramString2.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.HNS.HZF.overridePendingTransition(0, 0);
        AppMethodBeat.o(37336);
        return;
        if (w.wH(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    public static void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37337);
      a(parama, parambo, paramLong1, paramLong2, paramString1, paramString2, paramArrayOfInt, paramInt1, paramInt2, true, 0);
      AppMethodBeat.o(37337);
    }
    
    private static void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(37338);
      ac.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
      Intent localIntent = new Intent(parama.HZF.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("show_search_chat_content_result", ((ae)parama.bf(ae.class)).foi());
      localIntent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.c.b.d)parama.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo());
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.c.b.d)parama.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmB());
      localIntent.putExtra("img_gallery_talker", paramString1);
      localIntent.putExtra("img_gallery_chatroom_name", paramString2);
      localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramInt1);
      localIntent.putExtra("img_gallery_height", paramInt2);
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((ae)parama.bf(ae.class)).fod());
      localIntent.putExtra("img_gallery_enter_PhotoEditUI", paramBoolean);
      localIntent.putExtra("msg_type", paramInt3);
      if (paramInt3 == 1) {
        localIntent.putExtra("show_enter_grid", false);
      }
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", ai.vC(paramString1));
      paramString2 = parama.getTalkerUserName();
      if (parambo.field_isSend == 1) {
        paramString1 = parama.foM();
      }
      parambo = new Bundle();
      if (parama.foP()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        parambo.putInt("stat_scene", paramInt1);
        parambo.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        parambo.putString("stat_chat_talker_username", paramString2);
        parambo.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", parambo);
        localIntent.putExtra("img_gallery_session_id", g(paramLong2, paramString1, paramString2));
        parambo = parama.HZF;
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parambo, paramString1.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parambo.startActivity((Intent)paramString1.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parambo, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.HZF.overridePendingTransition(0, 0);
        AppMethodBeat.o(37338);
        return;
        if (w.wH(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    private void a(bj parambj, View paramView)
    {
      AppMethodBeat.i(37335);
      bo localbo = parambj.dpq;
      com.tencent.mm.modelstat.a.a(localbo, a.a.hUB);
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        paramView.getLocationInWindow(arrayOfInt);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      if (localbo.field_isSend == 1)
      {
        paramView = o.aFx().qg(localbo.field_msgId);
        if (paramView.dcd != 0L) {}
      }
      else
      {
        paramView = o.aFx().qf(localbo.field_msgSvrId);
      }
      for (;;)
      {
        Object localObject = bv.L(localbo.field_content, "msg");
        if (localObject != null) {
          bs.getLong((String)((Map)localObject).get(".msg.img.$hdlength"), 0L);
        }
        az.ayM();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          t.g(this.HNS.HZF.getContext(), this.HNS.HZF.getContentView());
          AppMethodBeat.o(37335);
          return;
        }
        if (localbo.field_isSend == 1)
        {
          localObject = com.tencent.mm.av.f.c(paramView);
          if (com.tencent.mm.vfs.i.eA(o.aFx().p((String)localObject, "", "")))
          {
            a(this.HNS, localbo, paramView.hGV, paramView.dpl, parambj.userName, parambj.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          localObject = paramView.hGM;
          if (com.tencent.mm.vfs.i.eA(o.aFx().p((String)localObject, "", "")))
          {
            a(this.HNS, localbo, paramView.hGV, paramView.dpl, parambj.userName, parambj.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          a(localbo.field_msgId, localbo.field_msgSvrId, parambj.userName, parambj.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.aEZ())
        {
          String str = paramView.hGM;
          localObject = str;
          if (paramView.aFa())
          {
            e locale = com.tencent.mm.av.f.a(paramView);
            localObject = str;
            if (locale != null)
            {
              localObject = str;
              if (locale.dcd > 0L)
              {
                localObject = str;
                if (locale.aEZ())
                {
                  localObject = str;
                  if (com.tencent.mm.vfs.i.eA(o.aFx().p(locale.hGM, "", ""))) {
                    localObject = locale.hGM;
                  }
                }
              }
            }
          }
          if (com.tencent.mm.vfs.i.eA(o.aFx().p((String)localObject, "", "")))
          {
            a(this.HNS, localbo, paramView.hGV, paramView.dpl, parambj.userName, parambj.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          ac.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.dcd) });
          paramView.Ce("SERVERID://" + localbo.field_msgSvrId);
          paramView.drx = 16;
          paramView.oL(0);
          paramView.drx = 8;
          paramView.setStatus(0);
          paramView.drx = 256;
          o.aFx().a(Long.valueOf(paramView.dcd), paramView);
          a(localbo.field_msgId, localbo.field_msgSvrId, parambj.userName, parambj.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.status == -1)
        {
          ac.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.dcd) });
          paramView.setStatus(0);
          paramView.drx = 256;
          o.aFx().a(Long.valueOf(paramView.dcd), paramView);
        }
        a(localbo.field_msgId, localbo.field_msgSvrId, parambj.userName, parambj.chatroomName, arrayOfInt, i, j);
        AppMethodBeat.o(37335);
        return;
      }
    }
    
    private static String g(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(37339);
      String str = y.xJ(String.valueOf(paramLong));
      y.b localb = y.ayq().F(str, true);
      localb.l("preUsername", paramString1);
      localb.l("preChatName", paramString2);
      int i = 3;
      if ((com.tencent.mm.al.f.AN(paramString2)) || (ai.vC(paramString2))) {
        i = 5;
      }
      localb.l("Contact_Sub_Scene", Integer.valueOf(i));
      localb.l("Contact_Scene_Note", paramString2);
      AppMethodBeat.o(37339);
      return str;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37334);
      Object localObject = (bj)paramView.getTag();
      com.tencent.mm.modelstat.b.hUE.R(((bj)localObject).dpq);
      a((bj)localObject, paramView);
      localObject = k.b.vz(parambo.field_content);
      com.tencent.mm.pluginsdk.model.app.g localg;
      if ((localObject != null) && (!bs.isNullOrNil(((k.b)localObject).appId)) && (this.IoE != null))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.k(((k.b)localObject).appId, false, false);
        if (localg != null) {
          if (!(this.IoE instanceof ao.a)) {
            break label122;
          }
        }
      }
      label122:
      for (paramView = c.d(parama, parambo);; paramView = u.axw())
      {
        c.a(parama, (k.b)localObject, paramView, localg, parambo.field_msgSvrId, parama.getTalkerUserName());
        AppMethodBeat.o(37334);
        return;
      }
    }
  }
  
  static final class d
    extends c.a
  {
    ImageView Ijf;
    ImageView Ilc;
    ImageView ImA;
    TextView IoF;
    View IoG;
    TextView qTn;
    
    public final c.a z(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37340);
      super.fX(paramView);
      this.fAz = ((TextView)paramView.findViewById(2131298178));
      this.Ilc = ((ImageView)paramView.findViewById(2131298074));
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.gGk = paramView.findViewById(2131298147);
      this.IoG = paramView.findViewById(2131306222);
      if (paramBoolean)
      {
        this.xpH = ((TextView)paramView.findViewById(2131298185));
        this.vYf = ((ProgressBar)paramView.findViewById(2131299229));
      }
      for (;;)
      {
        this.ImA = ((ImageView)paramView.findViewById(2131298076));
        this.qTn = ((TextView)paramView.findViewById(2131298044));
        AppMethodBeat.o(37340);
        return this;
        this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
        this.IoF = ((TextView)paramView.findViewById(2131306221));
        this.xpH = ((TextView)paramView.findViewById(2131298185));
        this.Ijf = ((ImageView)paramView.findViewById(2131298176));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao
 * JD-Core Version:    0.7.0.1
 */