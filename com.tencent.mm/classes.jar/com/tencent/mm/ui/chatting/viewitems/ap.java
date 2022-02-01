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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.p;
import com.tencent.mm.aw.p.d;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.n;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ap
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    private ap.c Kfd;
    
    public static void a(Context paramContext, c.a parama, bu parambu, boolean paramBoolean)
    {
      AppMethodBeat.i(37325);
      if (true != paramBoolean)
      {
        AppMethodBeat.o(37325);
        return;
      }
      if ((parama instanceof ap.d))
      {
        parama = (ap.d)parama;
        q.aIF().a(parama.KbA, parambu.field_imgPath, com.tencent.mm.cc.a.getDensity(paramContext), parambu.fkr, parambu.fks, parama.KcY, 2131231562, 1, null);
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
        localObject = new ah(paramLayoutInflater, 2131493457);
        ((View)localObject).setTag(new ap.d().z((View)localObject, true));
      }
      AppMethodBeat.o(37320);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(37321);
      this.JBI = parama1;
      ((m)parama1.bh(m.class)).bJ(parambu);
      ap.d locald = (ap.d)parama;
      boolean bool = q.aIF().a(locald.KbA, parambu.field_imgPath, com.tencent.mm.cc.a.getDensity(parama1.JOR.getContext()), parambu.fkr, parambu.fks, locald.KcY, 2131231559, 1, null);
      locald.Kfg.setVisibility(0);
      a(locald, false, false);
      if (!bool) {
        locald.KbA.setImageBitmap(BitmapFactory.decodeResource(parama1.JOR.getMMResources(), 2131231559));
      }
      parama = null;
      if (parama1.fFv()) {
        parama = parambu.field_talker;
      }
      locald.ofK.setTag(new bk(parambu, parama1.fFv(), paramInt, paramString, parama));
      parama = locald.ofK;
      if (this.Kfd == null) {
        this.Kfd = new ap.c(this.JBI, this);
      }
      parama.setOnClickListener(this.Kfd);
      locald.ofK.setOnLongClickListener(c(parama1));
      locald.ofK.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
      ap.a(parambu, parama1, locald);
      AppMethodBeat.o(37321);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37324);
      if (100 == paramMenuItem.getItemId()) {
        ap.c(parambu, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37324);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          ap.b(parama, paramMenuItem, parambu);
        } else {
          ((aj)parama.bh(aj.class)).a(paramMenuItem, parambu);
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194485);
      ba.aBQ();
      int k;
      Object localObject1;
      Object localObject2;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null) && (parambu != null))
      {
        k = ((bk)paramView.getTag()).position;
        localObject1 = null;
        if (parambu.field_msgId > 0L) {
          localObject1 = q.aIF().G(parambu.field_talker, parambu.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.aw.g)localObject1).dnz > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (parambu.field_msgSvrId > 0L) {
            localObject2 = q.aIF().F(parambu.field_talker, parambu.field_msgSvrId);
          }
        }
        if (!bl.A(parambu)) {
          paraml.a(k, 110, paramView.getContext().getString(2131762559), 2131690478);
        }
        if ((com.tencent.mm.am.g.aFA()) && (!this.JBI.fFw())) {
          paraml.add(k, 114, 0, paramView.getContext().getString(2131757217));
        }
        if (com.tencent.mm.bs.d.aIu("favorite")) {
          paraml.a(k, 116, paramView.getContext().getString(2131761941), 2131690400);
        }
        if ((localObject2 != null) && (((com.tencent.mm.aw.g)localObject2).status != -1))
        {
          localObject1 = paraml.a(k, 131, paramView.getContext().getString(2131757183), 2131690457);
          localObject2 = new int[2];
          if (paramView == null) {
            break label502;
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
        localObject1 = new eb();
        ((eb)localObject1).dpg.msgId = parambu.field_msgId;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        if ((((eb)localObject1).dph.doF) || (com.tencent.mm.pluginsdk.model.app.h.ap(this.JBI.JOR.getContext(), parambu.getType()))) {
          paraml.a(k, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if (!this.JBI.fFw()) {
          paraml.a(k, 100, paramView.getContext().getString(2131757220), 2131690384);
        }
        if ((bl.z(parambu)) || (bl.B(parambu)))
        {
          paraml.clear();
          if (!this.JBI.fFw()) {
            paraml.a(k, 100, paramView.getContext().getString(2131757220), 2131690384);
          }
        }
        AppMethodBeat.o(194485);
        return true;
        label502:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      return false;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37322);
      boolean bool = parama.fFv();
      AppMethodBeat.o(37322);
      return bool;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 39) || (paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 33));
    }
    
    public final boolean fHh()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    private ap.c Kfd;
    
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
      parama = (ap.d)parama;
      if ((paramInt1 >= 100) && (parama.Kff.getVisibility() != 0))
      {
        AppMethodBeat.o(37330);
        return;
      }
      parama.Kff.setText(paramInt1 + "%");
      if (fHj()) {
        a(parama, false);
      }
      for (;;)
      {
        parama.Kff.setVisibility(0);
        parama.Kfg.setVisibility(0);
        AppMethodBeat.o(37330);
        return;
        a(parama, true);
      }
    }
    
    public static void c(c.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(37331);
      if ((paramBoolean == true) && ((parama instanceof ap.d)))
      {
        parama = (ap.d)parama;
        a(parama, false);
        parama.Kff.setVisibility(4);
        parama.Kfg.setVisibility(4);
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
        localObject = new ah(paramLayoutInflater, 2131493500);
        ((View)localObject).setTag(new ap.d().z((View)localObject, false));
      }
      AppMethodBeat.o(37326);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37332);
      parambu.frY();
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
      ((aj)parama.bh(aj.class)).bF(parambu);
      AppMethodBeat.o(37332);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(37327);
      this.JBI = parama1;
      paramString = (ap.d)parama;
      parama = p.aIt();
      long l = parambu.field_msgId;
      boolean bool2 = parama.ibV.containsKey(Long.valueOf(l));
      Object localObject1 = q.aIF().L(parambu);
      int i;
      int j;
      boolean bool1;
      Object localObject2;
      Object localObject3;
      label168:
      int k;
      if ((localObject1 != null) && (!bool2)) {
        if (p.aIt().sh(((com.tencent.mm.aw.g)localObject1).dnz))
        {
          parama = p.aIt().si(((com.tencent.mm.aw.g)localObject1).dnz);
          i = (int)parama.dyS;
          j = (int)parama.offset;
          if (i == 0)
          {
            bool1 = true;
            localObject2 = q.aIF();
            localObject3 = paramString.KbA;
            String str = parambu.field_imgPath;
            float f = com.tencent.mm.cc.a.getDensity(parama1.JOR.getContext());
            i = parambu.fkr;
            j = parambu.fks;
            ImageView localImageView = paramString.KcY;
            if (!bool1) {
              break label612;
            }
            parama = null;
            if (!((com.tencent.mm.aw.i)localObject2).a((ImageView)localObject3, str, f, i, j, localImageView, 2131231559, 0, parama)) {
              paramString.KbA.setImageDrawable(com.tencent.mm.cc.a.l(parama1.JOR.getContext(), 2131231559));
            }
            if ((localObject1 == null) && (!bool2)) {
              break label862;
            }
            if ((!bool1) && (parambu.field_status != 5)) {
              break label621;
            }
            k = 1;
            label239:
            if (!bool2) {
              break label627;
            }
            paramString.Kff.setText("0%");
            if (k != 0) {
              break label844;
            }
            bool1 = true;
            label263:
            a(paramString, bool1, false);
            parama = paramString.Kff;
            if (k == 0) {
              break label850;
            }
            i = 8;
            label287:
            parama.setVisibility(i);
            parama = paramString.Kfg;
            if (k == 0) {
              break label856;
            }
            i = 8;
            label308:
            parama.setVisibility(i);
            label314:
            paramString.ofK.setTag(new bk(parambu, parama1.fFv(), paramInt, parambu.field_talker, '\000'));
            parama = paramString.ofK;
            if (this.Kfd == null) {
              this.Kfd = new ap.c(this.JBI, this);
            }
            parama.setOnClickListener(this.Kfd);
            paramString.ofK.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
            paramString.ofK.setOnLongClickListener(c(parama1));
            paramString.KbA.setContentDescription(parama1.JOR.getMMResources().getString(2131757186));
            if (fHj())
            {
              a(paramString, false, false);
              ad.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[] { Long.valueOf(parambu.field_msgId), Integer.valueOf(parambu.field_status) });
              if (fHj())
              {
                if ((parambu.field_status != 2) || (!b((k)parama1.bh(k.class), parambu.field_msgId))) {
                  break label893;
                }
                if (paramString.JZD != null) {
                  paramString.JZD.setVisibility(0);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, parambu, parama1.fFr(), false, parama1.fFv(), parama1, this);
        ap.a(parambu, parama1, paramString);
        AppMethodBeat.o(37327);
        return;
        if ((j == i) && (i != 0))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        bool1 = com.tencent.mm.aw.h.b((com.tencent.mm.aw.g)localObject1);
        break;
        bool1 = false;
        break;
        label612:
        parama = paramString.Kfg;
        break label168;
        label621:
        k = 0;
        break label239;
        label627:
        parama = paramString.Kff;
        localObject2 = new StringBuilder();
        if (localObject1 != null)
        {
          j = ((com.tencent.mm.aw.g)localObject1).hMP;
          i = ((com.tencent.mm.aw.g)localObject1).offset;
          if (p.aIt().sh(((com.tencent.mm.aw.g)localObject1).dnz))
          {
            localObject3 = p.aIt().si(((com.tencent.mm.aw.g)localObject1).dnz);
            j = (int)((p.d)localObject3).dyS;
            i = (int)((p.d)localObject3).offset;
          }
          if (((com.tencent.mm.aw.g)localObject1).aIj())
          {
            localObject3 = q.aIF().pt(((com.tencent.mm.aw.g)localObject1).hZH);
            if (p.aIt().sh(((com.tencent.mm.aw.g)localObject1).hZH))
            {
              localObject1 = p.aIt().si(((com.tencent.mm.aw.g)localObject1).hZH);
              j = (int)((p.d)localObject1).dyS;
              i = (int)((p.d)localObject1).offset;
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
          j = ((com.tencent.mm.aw.g)localObject3).hMP;
          i = ((com.tencent.mm.aw.g)localObject3).offset;
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
        paramString.Kfg.setVisibility(8);
        a(paramString, false, false);
        paramString.Kff.setVisibility(8);
        break label314;
        label893:
        if (paramString.JZD != null) {
          paramString.JZD.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37329);
      if (100 == paramMenuItem.getItemId()) {
        ap.c(parambu, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37329);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          ap.b(parama, paramMenuItem, parambu);
        } else {
          ((aj)parama.bh(aj.class)).a(paramMenuItem, parambu);
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194486);
      ba.aBQ();
      int k;
      Object localObject2;
      Object localObject1;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null))
      {
        k = ((bk)paramView.getTag()).position;
        localObject2 = null;
        if (parambu.field_msgId > 0L) {
          localObject2 = q.aIF().G(parambu.field_talker, parambu.field_msgId);
        }
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((com.tencent.mm.aw.g)localObject2).dnz > 0L) {}
        }
        else
        {
          localObject1 = localObject2;
          if (parambu.field_msgSvrId > 0L) {
            localObject1 = q.aIF().F(parambu.field_talker, parambu.field_msgSvrId);
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.aw.g)localObject1).aIj())
          {
            localObject2 = localObject1;
            if (((com.tencent.mm.aw.g)localObject1).hMP == 0) {
              localObject2 = q.aIF().pt(((com.tencent.mm.aw.g)localObject1).hZH);
            }
          }
        }
        if (!bl.A(parambu)) {
          paraml.a(k, 110, paramView.getContext().getString(2131762559), 2131690478);
        }
        if (parambu.field_status == 5) {
          paraml.a(k, 103, paramView.getContext().getString(2131757286), 2131690467);
        }
        if ((com.tencent.mm.am.g.aFA()) && (!this.JBI.fFw())) {
          paraml.add(k, 114, 0, paramView.getContext().getString(2131757217));
        }
        if (com.tencent.mm.bs.d.aIu("favorite")) {
          paraml.a(k, 116, paramView.getContext().getString(2131761941), 2131690400);
        }
        if (((com.tencent.mm.aw.g)localObject2).status != -1)
        {
          localObject1 = paraml.a(k, 131, paramView.getContext().getString(2131757183), 2131690457);
          localObject2 = new int[2];
          if (paramView == null) {
            break label658;
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
        localObject1 = new eb();
        ((eb)localObject1).dpg.msgId = parambu.field_msgId;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        if ((((eb)localObject1).dph.doF) || (com.tencent.mm.pluginsdk.model.app.h.ap(this.JBI.JOR.getContext(), parambu.getType()))) {
          paraml.a(k, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if ((!parambu.fpd()) && (parambu.fpi()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker)) && (!am.yt(this.JBI.getTalkerUserName()))) {
          paraml.a(k, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        if (!this.JBI.fFw()) {
          paraml.a(k, 100, paramView.getContext().getString(2131757220), 2131690384);
        }
        if ((bl.z(parambu)) || (bl.B(parambu)))
        {
          paraml.clear();
          if (!this.JBI.fFw()) {
            paraml.a(k, 100, paramView.getContext().getString(2131757220), 2131690384);
          }
        }
        AppMethodBeat.o(194486);
        return true;
        label658:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      return false;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 39) || (paramInt == 33));
    }
    
    public final boolean fHh()
    {
      return true;
    }
  }
  
  public static final class c
    extends s.e
  {
    private c Kfe;
    private int scene;
    
    public c(com.tencent.mm.ui.chatting.e.a parama, c paramc)
    {
      super();
      this.scene = 0;
      this.Kfe = paramc;
    }
    
    public c(com.tencent.mm.ui.chatting.e.a parama, c paramc, bu parambu, View paramView)
    {
      super();
      AppMethodBeat.i(37333);
      this.scene = 0;
      this.Kfe = paramc;
      this.scene = 1;
      if (this.scene == 1)
      {
        com.tencent.mm.modelstat.b.inZ.U(parambu);
        a(new bk(parambu, this.JBI.fFv(), 0, parambu.field_talker, '\000'), paramView);
      }
      AppMethodBeat.o(37333);
    }
    
    private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37336);
      ad.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] doGetMsgImg");
      Intent localIntent = new Intent(this.JBI.JOR.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("show_search_chat_content_result", ((ai)this.JBI.bh(ai.class)).fEM());
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.d.b.d)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH());
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCU());
      localIntent.putExtra("img_gallery_talker", paramString1);
      localIntent.putExtra("img_gallery_chatroom_name", paramString2);
      localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramInt1);
      localIntent.putExtra("img_gallery_height", paramInt2);
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((ai)this.JBI.bh(ai.class)).fEH());
      localIntent.putExtra("msg_type", this.scene);
      if (this.scene == 1) {
        localIntent.putExtra("show_enter_grid", false);
      }
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", am.yt(paramString1));
      paramString2 = this.JBI.getTalkerUserName();
      paramArrayOfInt = new Bundle();
      if (this.JBI.fFv()) {
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
        paramString1 = this.JBI;
        paramString2 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString1.startActivity((Intent)paramString2.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.JBI.JOR.overridePendingTransition(0, 0);
        AppMethodBeat.o(37336);
        return;
        if (w.zE(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    public static void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37337);
      a(parama, parambu, paramLong1, paramLong2, paramString1, paramString2, paramArrayOfInt, paramInt1, paramInt2, true, 0);
      AppMethodBeat.o(37337);
    }
    
    private static void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(37338);
      ad.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
      Intent localIntent = new Intent(parama.JOR.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("show_search_chat_content_result", ((ai)parama.bh(ai.class)).fEM());
      localIntent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH());
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCU());
      localIntent.putExtra("img_gallery_talker", paramString1);
      localIntent.putExtra("img_gallery_chatroom_name", paramString2);
      localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramInt1);
      localIntent.putExtra("img_gallery_height", paramInt2);
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((ai)parama.bh(ai.class)).fEH());
      localIntent.putExtra("img_gallery_enter_PhotoEditUI", paramBoolean);
      localIntent.putExtra("msg_type", paramInt3);
      if (paramInt3 == 1) {
        localIntent.putExtra("show_enter_grid", false);
      }
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", am.yt(paramString1));
      paramString2 = parama.getTalkerUserName();
      if (parambu.field_isSend == 1) {
        paramString1 = parama.fFr();
      }
      parambu = new Bundle();
      if (parama.fFu()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        parambu.putInt("stat_scene", paramInt1);
        parambu.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        parambu.putString("stat_chat_talker_username", paramString2);
        parambu.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", parambu);
        localIntent.putExtra("img_gallery_session_id", g(paramLong2, paramString1, paramString2));
        parambu = parama.JOR;
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parambu, paramString1.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parambu.startActivity((Intent)paramString1.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(parambu, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.JOR.overridePendingTransition(0, 0);
        AppMethodBeat.o(37338);
        return;
        if (w.zE(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    private void a(bk parambk, View paramView)
    {
      AppMethodBeat.i(37335);
      bu localbu = parambk.dBd;
      com.tencent.mm.modelstat.a.a(localbu, a.a.inW);
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        paramView.getLocationInWindow(arrayOfInt);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      if (localbu.field_isSend == 1)
      {
        paramView = q.aIF().G(localbu.field_talker, localbu.field_msgId);
        if (paramView.dnz != 0L) {}
      }
      else
      {
        paramView = q.aIF().F(localbu.field_talker, localbu.field_msgSvrId);
      }
      for (;;)
      {
        Object localObject = bw.M(localbu.field_content, "msg");
        if (localObject != null) {
          bt.getLong((String)((Map)localObject).get(".msg.img.$hdlength"), 0L);
        }
        ba.aBQ();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          t.g(this.JBI.JOR.getContext(), this.JBI.JOR.getContentView());
          AppMethodBeat.o(37335);
          return;
        }
        if (localbu.field_isSend == 1)
        {
          localObject = com.tencent.mm.aw.h.c(paramView);
          if (com.tencent.mm.vfs.i.fv(q.aIF().o((String)localObject, "", "")))
          {
            a(this.JBI, localbu, paramView.hZF, paramView.dAY, parambk.userName, parambk.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          localObject = paramView.hZw;
          if (com.tencent.mm.vfs.i.fv(q.aIF().o((String)localObject, "", "")))
          {
            a(this.JBI, localbu, paramView.hZF, paramView.dAY, parambk.userName, parambk.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          a(localbu.field_msgId, localbu.field_msgSvrId, parambk.userName, parambk.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.aIi())
        {
          String str = paramView.hZw;
          localObject = str;
          if (paramView.aIj())
          {
            com.tencent.mm.aw.g localg = com.tencent.mm.aw.h.a(paramView);
            localObject = str;
            if (localg != null)
            {
              localObject = str;
              if (localg.dnz > 0L)
              {
                localObject = str;
                if (localg.aIi())
                {
                  localObject = str;
                  if (com.tencent.mm.vfs.i.fv(q.aIF().o(localg.hZw, "", ""))) {
                    localObject = localg.hZw;
                  }
                }
              }
            }
          }
          if (com.tencent.mm.vfs.i.fv(q.aIF().o((String)localObject, "", "")))
          {
            a(this.JBI, localbu, paramView.hZF, paramView.dAY, parambk.userName, parambk.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          ad.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.dnz) });
          paramView.Fd("SERVERID://" + localbu.field_msgSvrId);
          paramView.dDp = 16;
          paramView.pn(0);
          paramView.dDp = 8;
          paramView.setStatus(0);
          paramView.dDp = 256;
          q.aIF().a(Long.valueOf(paramView.dnz), paramView);
          a(localbu.field_msgId, localbu.field_msgSvrId, parambk.userName, parambk.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.status == -1)
        {
          ad.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.dnz) });
          paramView.setStatus(0);
          paramView.dDp = 256;
          q.aIF().a(Long.valueOf(paramView.dnz), paramView);
        }
        a(localbu.field_msgId, localbu.field_msgSvrId, parambk.userName, parambk.chatroomName, arrayOfInt, i, j);
        AppMethodBeat.o(37335);
        return;
      }
    }
    
    private static String g(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(37339);
      String str = y.AH(String.valueOf(paramLong));
      y.b localb = y.aBq().F(str, true);
      localb.k("preUsername", paramString1);
      localb.k("preChatName", paramString2);
      int i = 3;
      if ((com.tencent.mm.am.g.DM(paramString2)) || (am.yt(paramString2))) {
        i = 5;
      }
      localb.k("Contact_Sub_Scene", Integer.valueOf(i));
      localb.k("Contact_Scene_Note", paramString2);
      AppMethodBeat.o(37339);
      return str;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37334);
      Object localObject = (bk)paramView.getTag();
      com.tencent.mm.modelstat.b.inZ.U(((bk)localObject).dBd);
      a((bk)localObject, paramView);
      localObject = k.b.yq(parambu.field_content);
      com.tencent.mm.pluginsdk.model.app.g localg;
      if ((localObject != null) && (!bt.isNullOrNil(((k.b)localObject).appId)) && (this.Kfe != null))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject).appId, false, false);
        if (localg != null) {
          if (!(this.Kfe instanceof ap.a)) {
            break label126;
          }
        }
      }
      label126:
      for (paramView = c.d(parama, parambu);; paramView = u.aAm())
      {
        c.a(parama, (k.b)localObject, paramView, localg, parambu.field_msgSvrId, parama.getTalkerUserName());
        com.tencent.mm.am.l.I(parambu);
        AppMethodBeat.o(37334);
        return;
      }
    }
  }
  
  static final class d
    extends c.a
  {
    ImageView JZD;
    ImageView KbA;
    ImageView KcY;
    TextView Kff;
    View Kfg;
    TextView rDq;
    
    public final c.a z(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37340);
      super.gn(paramView);
      this.fTP = ((TextView)paramView.findViewById(2131298178));
      this.KbA = ((ImageView)paramView.findViewById(2131298074));
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.gZU = paramView.findViewById(2131298147);
      this.Kfg = paramView.findViewById(2131306222);
      if (paramBoolean)
      {
        this.yEk = ((TextView)paramView.findViewById(2131298185));
        this.xfR = ((ProgressBar)paramView.findViewById(2131299229));
      }
      for (;;)
      {
        this.KcY = ((ImageView)paramView.findViewById(2131298076));
        this.rDq = ((TextView)paramView.findViewById(2131298044));
        AppMethodBeat.o(37340);
        return this;
        this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
        this.Kff = ((TextView)paramView.findViewById(2131306221));
        this.yEk = ((TextView)paramView.findViewById(2131298185));
        this.JZD = ((ImageView)paramView.findViewById(2131298176));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap
 * JD-Core Version:    0.7.0.1
 */