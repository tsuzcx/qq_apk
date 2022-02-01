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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.n;
import com.tencent.mm.aw.n.d;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.n;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class an
{
  public static final class a
    extends c
  {
    private an.c GOB;
    private com.tencent.mm.ui.chatting.d.a Gob;
    
    public static void a(Context paramContext, c.a parama, bl parambl, boolean paramBoolean)
    {
      AppMethodBeat.i(37325);
      if (true != paramBoolean)
      {
        AppMethodBeat.o(37325);
        return;
      }
      if ((parama instanceof an.d))
      {
        parama = (an.d)parama;
        o.ayF().a(parama.GLf, parambl.field_imgPath, com.tencent.mm.cd.a.getDensity(paramContext), parambl.eOU, parambl.eOV, parama.GMy, 2131231562, 1, null);
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
        localObject = new af(paramLayoutInflater, 2131493457);
        ((View)localObject).setTag(new an.d().z((View)localObject, true));
      }
      AppMethodBeat.o(37320);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(37321);
      this.Gob = parama1;
      ((k)parama1.be(k.class)).bB(parambl);
      an.d locald = (an.d)parama;
      boolean bool = o.ayF().a(locald.GLf, parambl.field_imgPath, com.tencent.mm.cd.a.getDensity(parama1.GzJ.getContext()), parambl.eOU, parambl.eOV, locald.GMy, 2131231559, 1, null);
      locald.GOE.setVisibility(0);
      locald.uPp.setVisibility(8);
      if (!bool) {
        locald.GLf.setImageBitmap(BitmapFactory.decodeResource(parama1.GzJ.getMMResources(), 2131231559));
      }
      parama = null;
      if (parama1.eZb()) {
        parama = parambl.field_talker;
      }
      locald.naN.setTag(new bi(parambl, parama1.eZb(), paramInt, paramString, parama));
      parama = locald.naN;
      if (this.GOB == null) {
        this.GOB = new an.c(this.Gob, this);
      }
      parama.setOnClickListener(this.GOB);
      locald.naN.setOnLongClickListener(c(parama1));
      locald.naN.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWp());
      an.a(parambl, parama1, locald);
      AppMethodBeat.o(37321);
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(37323);
      az.arV();
      int k;
      Object localObject1;
      Object localObject2;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null) && (parambl != null))
      {
        k = ((bi)paramView.getTag()).position;
        localObject1 = null;
        if (parambl.field_msgId > 0L) {
          localObject1 = o.ayF().ms(parambl.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((e)localObject1).deI > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (parambl.field_msgSvrId > 0L) {
            localObject2 = o.ayF().mr(parambl.field_msgSvrId);
          }
        }
        if (!bk.y(parambl)) {
          paramContextMenu.add(k, 110, 0, paramView.getContext().getString(2131762559));
        }
        if ((com.tencent.mm.am.f.avF()) && (!this.Gob.eZc())) {
          paramContextMenu.add(k, 114, 0, paramView.getContext().getString(2131757217));
        }
        if (com.tencent.mm.bs.d.axB("favorite")) {
          paramContextMenu.add(k, 116, 0, paramView.getContext().getString(2131761941));
        }
        localObject1 = new dx();
        ((dx)localObject1).dgp.msgId = parambl.field_msgId;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        if ((((dx)localObject1).dgq.dfO) || (com.tencent.mm.pluginsdk.model.app.h.ag(this.Gob.GzJ.getContext(), parambl.getType()))) {
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
        if (!this.Gob.eZc()) {
          paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131757220));
        }
        if ((bk.x(parambl)) || (bk.z(parambl)))
        {
          paramContextMenu.clear();
          if (!this.Gob.eZc()) {
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
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37324);
      if (100 == paramMenuItem.getItemId()) {
        an.c(parambl, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37324);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          an.b(parama, paramMenuItem, parambl);
        } else {
          ((com.tencent.mm.ui.chatting.c.b.af)parama.be(com.tencent.mm.ui.chatting.c.b.af.class)).a(paramMenuItem, parambl);
        }
      }
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 39) || (paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 33));
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      return false;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(37322);
      boolean bool = parama.eZb();
      AppMethodBeat.o(37322);
      return bool;
    }
    
    public final boolean faE()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private an.c GOB;
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        ad.e("MicroMsg.ChattingItemImgTo", "[updateImgUploadProgress] tag is null");
        AppMethodBeat.o(37330);
        return;
        paramInt1 = (int)(paramInt1 * 100L / paramInt2);
        continue;
        paramInt1 = 0;
      }
      parama = (an.d)parama;
      if ((paramInt1 >= 100) && (parama.GOD.getVisibility() != 0))
      {
        AppMethodBeat.o(37330);
        return;
      }
      parama.GOD.setText(paramInt1 + "%");
      if (faG()) {
        parama.uPp.setVisibility(8);
      }
      for (;;)
      {
        parama.GOD.setVisibility(0);
        parama.GOE.setVisibility(0);
        AppMethodBeat.o(37330);
        return;
        parama.uPp.setVisibility(0);
      }
    }
    
    public static void a(c.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(37331);
      if ((paramBoolean == true) && ((parama instanceof an.d)))
      {
        parama = (an.d)parama;
        parama.uPp.setVisibility(4);
        parama.GOD.setVisibility(4);
        parama.GOE.setVisibility(4);
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
        localObject = new af(paramLayoutInflater, 2131493500);
        ((View)localObject).setTag(new an.d().z((View)localObject, false));
      }
      AppMethodBeat.o(37326);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37332);
      parambl.eMq();
      az.arV();
      com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
      ((com.tencent.mm.ui.chatting.c.b.af)parama.be(com.tencent.mm.ui.chatting.c.b.af.class)).bx(parambl);
      AppMethodBeat.o(37332);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(37327);
      this.Gob = parama1;
      paramString = (an.d)parama;
      parama = n.ayt();
      long l = parambl.field_msgId;
      boolean bool2 = parama.hiC.containsKey(Long.valueOf(l));
      Object localObject1 = o.ayF().I(parambl);
      int i;
      int j;
      boolean bool1;
      Object localObject2;
      Object localObject3;
      label168:
      int k;
      if ((localObject1 != null) && (!bool2)) {
        if (n.ayt().mu(((e)localObject1).deI))
        {
          parama = n.ayt().mv(((e)localObject1).deI);
          i = (int)parama.dpt;
          j = (int)parama.offset;
          if (i == 0)
          {
            bool1 = true;
            localObject2 = o.ayF();
            localObject3 = paramString.GLf;
            String str = parambl.field_imgPath;
            float f = com.tencent.mm.cd.a.getDensity(parama1.GzJ.getContext());
            i = parambl.eOU;
            j = parambl.eOV;
            ImageView localImageView = paramString.GMy;
            if (!bool1) {
              break label617;
            }
            parama = null;
            if (!((com.tencent.mm.aw.g)localObject2).a((ImageView)localObject3, str, f, i, j, localImageView, 2131231559, 0, parama)) {
              paramString.GLf.setImageDrawable(com.tencent.mm.cd.a.l(parama1.GzJ.getContext(), 2131231559));
            }
            if ((localObject1 == null) && (!bool2)) {
              break label867;
            }
            if ((!bool1) && (parambl.field_status != 5)) {
              break label626;
            }
            k = 1;
            label239:
            if (!bool2) {
              break label632;
            }
            paramString.GOD.setText("0%");
            parama = paramString.uPp;
            if (k == 0) {
              break label849;
            }
            i = 8;
            label270:
            parama.setVisibility(i);
            parama = paramString.GOD;
            if (k == 0) {
              break label855;
            }
            i = 8;
            label291:
            parama.setVisibility(i);
            parama = paramString.GOE;
            if (k == 0) {
              break label861;
            }
            i = 8;
            label312:
            parama.setVisibility(i);
            label318:
            paramString.naN.setTag(new bi(parambl, parama1.eZb(), paramInt, parambl.field_talker, '\000'));
            parama = paramString.naN;
            if (this.GOB == null) {
              this.GOB = new an.c(this.Gob, this);
            }
            parama.setOnClickListener(this.GOB);
            paramString.naN.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWp());
            paramString.naN.setOnLongClickListener(c(parama1));
            paramString.GLf.setContentDescription(parama1.GzJ.getMMResources().getString(2131757186));
            if (faG())
            {
              paramString.uPp.setVisibility(8);
              ad.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[] { Long.valueOf(parambl.field_msgId), Integer.valueOf(parambl.field_status) });
              if (faG())
              {
                if ((parambl.field_status != 2) || (!a((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class), parambl.field_msgId))) {
                  break label900;
                }
                if (paramString.GJi != null) {
                  paramString.GJi.setVisibility(0);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
        an.a(parambl, parama1, paramString);
        AppMethodBeat.o(37327);
        return;
        if ((j == i) && (i != 0))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        bool1 = com.tencent.mm.aw.f.b((e)localObject1);
        break;
        bool1 = false;
        break;
        label617:
        parama = paramString.GOE;
        break label168;
        label626:
        k = 0;
        break label239;
        label632:
        parama = paramString.GOD;
        localObject2 = new StringBuilder();
        if (localObject1 != null)
        {
          j = ((e)localObject1).gTY;
          i = ((e)localObject1).offset;
          if (n.ayt().mu(((e)localObject1).deI))
          {
            localObject3 = n.ayt().mv(((e)localObject1).deI);
            j = (int)((n.d)localObject3).dpt;
            i = (int)((n.d)localObject3).offset;
          }
          if (((e)localObject1).ayi())
          {
            localObject3 = o.ayF().od(((e)localObject1).hgu);
            if (n.ayt().mu(((e)localObject1).hgu))
            {
              localObject1 = n.ayt().mv(((e)localObject1).hgu);
              j = (int)((n.d)localObject1).dpt;
              i = (int)((n.d)localObject1).offset;
            }
          }
          else
          {
            label775:
            if (j <= 0) {
              break label843;
            }
            if (i < j) {
              break label830;
            }
            i = 100;
          }
        }
        for (;;)
        {
          parama.setText(i + "%");
          break;
          j = ((e)localObject3).gTY;
          i = ((e)localObject3).offset;
          break label775;
          label830:
          i = i * 100 / j;
          continue;
          label843:
          i = 0;
        }
        label849:
        i = 0;
        break label270;
        label855:
        i = 0;
        break label291;
        label861:
        i = 0;
        break label312;
        label867:
        paramString.GOE.setVisibility(8);
        paramString.uPp.setVisibility(8);
        paramString.GOD.setVisibility(8);
        break label318;
        label900:
        if (paramString.GJi != null) {
          paramString.GJi.setVisibility(8);
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(37328);
      az.arV();
      int k;
      Object localObject2;
      Object localObject1;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null))
      {
        k = ((bi)paramView.getTag()).position;
        localObject2 = null;
        if (parambl.field_msgId > 0L) {
          localObject2 = o.ayF().ms(parambl.field_msgId);
        }
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((e)localObject2).deI > 0L) {}
        }
        else
        {
          localObject1 = localObject2;
          if (parambl.field_msgSvrId > 0L) {
            localObject1 = o.ayF().mr(parambl.field_msgSvrId);
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((e)localObject1).ayi())
          {
            localObject2 = localObject1;
            if (((e)localObject1).gTY == 0) {
              localObject2 = o.ayF().od(((e)localObject1).hgu);
            }
          }
        }
        if (!bk.y(parambl)) {
          paramContextMenu.add(k, 110, 0, paramView.getContext().getString(2131762559));
        }
        if (parambl.field_status == 5) {
          paramContextMenu.add(k, 103, 0, paramView.getContext().getString(2131757286));
        }
        if ((com.tencent.mm.am.f.avF()) && (!this.Gob.eZc())) {
          paramContextMenu.add(k, 114, 0, paramView.getContext().getString(2131757217));
        }
        if (com.tencent.mm.bs.d.axB("favorite")) {
          paramContextMenu.add(k, 116, 0, paramView.getContext().getString(2131761941));
        }
        localObject1 = new dx();
        ((dx)localObject1).dgp.msgId = parambl.field_msgId;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        if ((((dx)localObject1).dgq.dfO) || (com.tencent.mm.pluginsdk.model.app.h.ag(this.Gob.GzJ.getContext(), parambl.getType()))) {
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
        if ((!parambl.eJL()) && (parambl.eJO()) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker)) && (!com.tencent.mm.storage.af.rz(this.Gob.getTalkerUserName()))) {
          paramContextMenu.add(k, 123, 0, paramView.getContext().getString(2131757234));
        }
        if (!this.Gob.eZc()) {
          paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131757220));
        }
        if ((bk.x(parambl)) || (bk.z(parambl)))
        {
          paramContextMenu.clear();
          if (!this.Gob.eZc()) {
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
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37329);
      if (100 == paramMenuItem.getItemId()) {
        an.c(parambl, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37329);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          an.b(parama, paramMenuItem, parambl);
        } else {
          ((com.tencent.mm.ui.chatting.c.b.af)parama.be(com.tencent.mm.ui.chatting.c.b.af.class)).a(paramMenuItem, parambl);
        }
      }
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 39) || (paramInt == 33));
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      return false;
    }
    
    public final boolean faE()
    {
      return true;
    }
  }
  
  public static final class c
    extends s.e
  {
    private c GOC;
    private int scene;
    
    public c(com.tencent.mm.ui.chatting.d.a parama, c paramc)
    {
      super();
      this.scene = 0;
      this.GOC = paramc;
    }
    
    public c(com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl, View paramView)
    {
      super();
      AppMethodBeat.i(37333);
      this.scene = 0;
      this.GOC = paramc;
      this.scene = 1;
      if (this.scene == 1)
      {
        com.tencent.mm.modelstat.b.huc.R(parambl);
        a(new bi(parambl, this.Gob.eZb(), 0, parambl.field_talker, '\000'), paramView);
      }
      AppMethodBeat.o(37333);
    }
    
    private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37336);
      ad.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] doGetMsgImg");
      Intent localIntent = new Intent(this.Gob.GzJ.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("show_search_chat_content_result", ((ae)this.Gob.be(ae.class)).eYw());
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.c.b.d)this.Gob.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC());
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.c.b.d)this.Gob.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWP());
      localIntent.putExtra("img_gallery_talker", paramString1);
      localIntent.putExtra("img_gallery_chatroom_name", paramString2);
      localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramInt1);
      localIntent.putExtra("img_gallery_height", paramInt2);
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((ae)this.Gob.be(ae.class)).eYr());
      localIntent.putExtra("msg_type", this.scene);
      if (this.scene == 1) {
        localIntent.putExtra("show_enter_grid", false);
      }
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.af.rz(paramString1));
      paramString2 = this.Gob.getTalkerUserName();
      paramArrayOfInt = new Bundle();
      if (this.Gob.eZb()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        paramArrayOfInt.putInt("stat_scene", paramInt1);
        paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
        paramArrayOfInt.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", paramArrayOfInt);
        localIntent.putExtra("img_gallery_session_id", f(paramLong2, paramString1, paramString2));
        paramString1 = this.Gob;
        paramString2 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString1.startActivity((Intent)paramString2.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.Gob.GzJ.overridePendingTransition(0, 0);
        AppMethodBeat.o(37336);
        return;
        if (w.sE(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    public static void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37337);
      a(parama, parambl, paramLong1, paramLong2, paramString1, paramString2, paramArrayOfInt, paramInt1, paramInt2, true, 0);
      AppMethodBeat.o(37337);
    }
    
    private static void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(37338);
      ad.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
      Intent localIntent = new Intent(parama.GzJ.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("show_search_chat_content_result", ((ae)parama.be(ae.class)).eYw());
      localIntent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC());
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWP());
      localIntent.putExtra("img_gallery_talker", paramString1);
      localIntent.putExtra("img_gallery_chatroom_name", paramString2);
      localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramInt1);
      localIntent.putExtra("img_gallery_height", paramInt2);
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((ae)parama.be(ae.class)).eYr());
      localIntent.putExtra("img_gallery_enter_PhotoEditUI", paramBoolean);
      localIntent.putExtra("msg_type", paramInt3);
      if (paramInt3 == 1) {
        localIntent.putExtra("show_enter_grid", false);
      }
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.af.rz(paramString1));
      paramString2 = parama.getTalkerUserName();
      if (parambl.field_isSend == 1) {
        paramString1 = parama.eYX();
      }
      parambl = new Bundle();
      if (parama.eZa()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        parambl.putInt("stat_scene", paramInt1);
        parambl.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        parambl.putString("stat_chat_talker_username", paramString2);
        parambl.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", parambl);
        localIntent.putExtra("img_gallery_session_id", f(paramLong2, paramString1, paramString2));
        parambl = parama.GzJ;
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parambl, paramString1.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parambl.startActivity((Intent)paramString1.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(parambl, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.GzJ.overridePendingTransition(0, 0);
        AppMethodBeat.o(37338);
        return;
        if (w.sE(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    private void a(bi parambi, View paramView)
    {
      AppMethodBeat.i(37335);
      bl localbl = parambi.drF;
      com.tencent.mm.modelstat.a.a(localbl, a.a.htZ);
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        paramView.getLocationInWindow(arrayOfInt);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      if (localbl.field_isSend == 1)
      {
        paramView = o.ayF().ms(localbl.field_msgId);
        if (paramView.deI != 0L) {}
      }
      else
      {
        paramView = o.ayF().mr(localbl.field_msgSvrId);
      }
      for (;;)
      {
        Object localObject = bw.K(localbl.field_content, "msg");
        if (localObject != null) {
          bt.getLong((String)((Map)localObject).get(".msg.img.$hdlength"), 0L);
        }
        az.arV();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          t.g(this.Gob.GzJ.getContext(), this.Gob.GzJ.getContentView());
          AppMethodBeat.o(37335);
          return;
        }
        if (localbl.field_isSend == 1)
        {
          localObject = com.tencent.mm.aw.f.c(paramView);
          if (com.tencent.mm.vfs.i.eK(o.ayF().p((String)localObject, "", "")))
          {
            a(this.Gob, localbl, paramView.hgs, paramView.drA, parambi.userName, parambi.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          localObject = paramView.hgj;
          if (com.tencent.mm.vfs.i.eK(o.ayF().p((String)localObject, "", "")))
          {
            a(this.Gob, localbl, paramView.hgs, paramView.drA, parambi.userName, parambi.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          a(localbl.field_msgId, localbl.field_msgSvrId, parambi.userName, parambi.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.ayh())
        {
          String str = paramView.hgj;
          localObject = str;
          if (paramView.ayi())
          {
            e locale = com.tencent.mm.aw.f.a(paramView);
            localObject = str;
            if (locale != null)
            {
              localObject = str;
              if (locale.deI > 0L)
              {
                localObject = str;
                if (locale.ayh())
                {
                  localObject = str;
                  if (com.tencent.mm.vfs.i.eK(o.ayF().p(locale.hgj, "", ""))) {
                    localObject = locale.hgj;
                  }
                }
              }
            }
          }
          if (com.tencent.mm.vfs.i.eK(o.ayF().p((String)localObject, "", "")))
          {
            a(this.Gob, localbl, paramView.hgs, paramView.drA, parambi.userName, parambi.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          ad.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.deI) });
          paramView.xZ("SERVERID://" + localbl.field_msgSvrId);
          paramView.dtM = 16;
          paramView.nX(0);
          paramView.dtM = 8;
          paramView.setStatus(0);
          paramView.dtM = 256;
          o.ayF().a(Long.valueOf(paramView.deI), paramView);
          a(localbl.field_msgId, localbl.field_msgSvrId, parambi.userName, parambi.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.status == -1)
        {
          ad.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.deI) });
          paramView.setStatus(0);
          paramView.dtM = 256;
          o.ayF().a(Long.valueOf(paramView.deI), paramView);
        }
        a(localbl.field_msgId, localbl.field_msgSvrId, parambi.userName, parambi.chatroomName, arrayOfInt, i, j);
        AppMethodBeat.o(37335);
        return;
      }
    }
    
    private static String f(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(37339);
      String str = y.tD(String.valueOf(paramLong));
      y.b localb = y.arz().E(str, true);
      localb.m("preUsername", paramString1);
      localb.m("preChatName", paramString2);
      int i = 3;
      if ((com.tencent.mm.am.f.wH(paramString2)) || (com.tencent.mm.storage.af.rz(paramString2))) {
        i = 5;
      }
      localb.m("Contact_Sub_Scene", Integer.valueOf(i));
      localb.m("Contact_Scene_Note", paramString2);
      AppMethodBeat.o(37339);
      return str;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37334);
      Object localObject = (bi)paramView.getTag();
      com.tencent.mm.modelstat.b.huc.R(((bi)localObject).drF);
      a((bi)localObject, paramView);
      localObject = k.b.rw(parambl.field_content);
      com.tencent.mm.pluginsdk.model.app.g localg;
      if ((localObject != null) && (!bt.isNullOrNil(((k.b)localObject).appId)) && (this.GOC != null))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.j(((k.b)localObject).appId, false, false);
        if (localg != null) {
          if (!(this.GOC instanceof an.a)) {
            break label122;
          }
        }
      }
      label122:
      for (paramView = c.d(parama, parambl);; paramView = u.aqG())
      {
        c.a(parama, (k.b)localObject, paramView, localg, parambl.field_msgSvrId, parama.getTalkerUserName());
        AppMethodBeat.o(37334);
        return;
      }
    }
  }
  
  static final class d
    extends c.a
  {
    ImageView GJi;
    ImageView GLf;
    ImageView GMy;
    TextView GOD;
    View GOE;
    TextView qkL;
    ProgressBar uPp;
    
    public final c.a z(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37340);
      super.fK(paramView);
      this.fwS = ((TextView)paramView.findViewById(2131298178));
      this.GLf = ((ImageView)paramView.findViewById(2131298074));
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.lRB = paramView.findViewById(2131298147);
      this.GOE = paramView.findViewById(2131306222);
      if (paramBoolean)
      {
        this.wet = ((TextView)paramView.findViewById(2131298185));
        this.uPp = ((ProgressBar)paramView.findViewById(2131299229));
      }
      for (;;)
      {
        this.GMy = ((ImageView)paramView.findViewById(2131298076));
        this.qkL = ((TextView)paramView.findViewById(2131298044));
        AppMethodBeat.o(37340);
        return this;
        this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
        this.GOD = ((TextView)paramView.findViewById(2131306221));
        this.wet = ((TextView)paramView.findViewById(2131298185));
        this.GJi = ((ImageView)paramView.findViewById(2131298176));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an
 * JD-Core Version:    0.7.0.1
 */