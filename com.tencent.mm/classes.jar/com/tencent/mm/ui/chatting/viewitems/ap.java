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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.vfs.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ap
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    private ap.c KBw;
    
    public static void a(Context paramContext, c.a parama, bv parambv, boolean paramBoolean)
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
        q.aIX().a(parama.KxS, parambv.field_imgPath, com.tencent.mm.cb.a.getDensity(paramContext), parambv.fmo, parambv.fmp, parama.Kzq, 2131231562, 1, null);
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
        ((View)localObject).setTag(new ap.d().E((View)localObject, true));
      }
      AppMethodBeat.o(37320);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(37321);
      this.JWz = parama1;
      ((m)parama1.bh(m.class)).bI(parambv);
      ap.d locald = (ap.d)parama;
      boolean bool = q.aIX().a(locald.KxS, parambv.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.Kkd.getContext()), parambv.fmo, parambv.fmp, locald.Kzq, 2131231559, 1, null);
      locald.KBz.setVisibility(0);
      a(locald, false, false);
      if (!bool) {
        locald.KxS.setImageBitmap(BitmapFactory.decodeResource(parama1.Kkd.getMMResources(), 2131231559));
      }
      parama = null;
      if (parama1.fJC()) {
        parama = parambv.field_talker;
      }
      locald.olI.setTag(new bk(parambv, parama1.fJC(), paramInt, paramString, parama));
      parama = locald.olI;
      if (this.KBw == null) {
        this.KBw = new ap.c(this.JWz, this);
      }
      parama.setOnClickListener(this.KBw);
      locald.olI.setOnLongClickListener(c(parama1));
      locald.olI.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
      ap.a(parambv, parama1, locald);
      AppMethodBeat.o(37321);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37324);
      if (100 == paramMenuItem.getItemId()) {
        ap.c(parambv, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37324);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          ap.b(parama, paramMenuItem, parambv);
        } else {
          ((ak)parama.bh(ak.class)).a(paramMenuItem, parambv);
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187880);
      bc.aCg();
      int k;
      Object localObject1;
      Object localObject2;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null) && (parambv != null))
      {
        k = ((bk)paramView.getTag()).position;
        localObject1 = null;
        if (parambv.field_msgId > 0L) {
          localObject1 = q.aIX().G(parambv.field_talker, parambv.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.av.g)localObject1).doE > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (parambv.field_msgSvrId > 0L) {
            localObject2 = q.aIX().F(parambv.field_talker, parambv.field_msgSvrId);
          }
        }
        if (!bn.A(parambv)) {
          paraml.a(k, 110, paramView.getContext().getString(2131762559), 2131690478);
        }
        if ((com.tencent.mm.al.g.aFQ()) && (!this.JWz.fJD())) {
          paraml.add(k, 114, 0, paramView.getContext().getString(2131757217));
        }
        if (com.tencent.mm.br.d.aJN("favorite")) {
          paraml.a(k, 116, paramView.getContext().getString(2131761941), 2131690400);
        }
        if ((localObject2 != null) && (((com.tencent.mm.av.g)localObject2).status != -1))
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
        localObject1 = new ec();
        ((ec)localObject1).dql.msgId = parambv.field_msgId;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        if ((((ec)localObject1).dqm.dpK) || (com.tencent.mm.pluginsdk.model.app.h.ap(this.JWz.Kkd.getContext(), parambv.getType()))) {
          paraml.a(k, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if (!this.JWz.fJD()) {
          paraml.a(k, 100, paramView.getContext().getString(2131757220), 2131690384);
        }
        if ((bn.z(parambv)) || (bn.B(parambv)))
        {
          paraml.clear();
          if (!this.JWz.fJD()) {
            paraml.a(k, 100, paramView.getContext().getString(2131757220), 2131690384);
          }
        }
        AppMethodBeat.o(187880);
        return true;
        label502:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      return false;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37322);
      boolean bool = parama.fJC();
      AppMethodBeat.o(37322);
      return bool;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 39) || (paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 33));
    }
    
    public final boolean fLz()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    private ap.c KBw;
    
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
        ae.e("MicroMsg.ChattingItemImgTo", "[updateImgUploadProgress] tag is null");
        AppMethodBeat.o(37330);
        return;
        paramInt1 = (int)(paramInt1 * 100L / paramInt2);
        continue;
        paramInt1 = 0;
      }
      parama = (ap.d)parama;
      if ((paramInt1 >= 100) && (parama.KBy.getVisibility() != 0))
      {
        AppMethodBeat.o(37330);
        return;
      }
      parama.KBy.setText(paramInt1 + "%");
      if (fLB()) {
        a(parama, false);
      }
      for (;;)
      {
        parama.KBy.setVisibility(0);
        parama.KBz.setVisibility(0);
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
        parama.KBy.setVisibility(4);
        parama.KBz.setVisibility(4);
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
        ((View)localObject).setTag(new ap.d().E((View)localObject, false));
      }
      AppMethodBeat.o(37326);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37332);
      parambv.fvZ();
      bc.aCg();
      com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
      ((ak)parama.bh(ak.class)).bE(parambv);
      AppMethodBeat.o(37332);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(37327);
      this.JWz = parama1;
      paramString = (ap.d)parama;
      parama = p.aIL();
      long l = parambv.field_msgId;
      boolean bool2 = parama.ieO.containsKey(Long.valueOf(l));
      Object localObject1 = q.aIX().L(parambv);
      int i;
      int j;
      boolean bool1;
      Object localObject2;
      Object localObject3;
      label168:
      int k;
      if ((localObject1 != null) && (!bool2)) {
        if (p.aIL().su(((com.tencent.mm.av.g)localObject1).doE))
        {
          parama = p.aIL().sv(((com.tencent.mm.av.g)localObject1).doE);
          i = (int)parama.dzX;
          j = (int)parama.offset;
          if (i == 0)
          {
            bool1 = true;
            localObject2 = q.aIX();
            localObject3 = paramString.KxS;
            String str = parambv.field_imgPath;
            float f = com.tencent.mm.cb.a.getDensity(parama1.Kkd.getContext());
            i = parambv.fmo;
            j = parambv.fmp;
            ImageView localImageView = paramString.Kzq;
            if (!bool1) {
              break label612;
            }
            parama = null;
            if (!((com.tencent.mm.av.i)localObject2).a((ImageView)localObject3, str, f, i, j, localImageView, 2131231559, 0, parama)) {
              paramString.KxS.setImageDrawable(com.tencent.mm.cb.a.l(parama1.Kkd.getContext(), 2131231559));
            }
            if ((localObject1 == null) && (!bool2)) {
              break label862;
            }
            if ((!bool1) && (parambv.field_status != 5)) {
              break label621;
            }
            k = 1;
            label239:
            if (!bool2) {
              break label627;
            }
            paramString.KBy.setText("0%");
            if (k != 0) {
              break label844;
            }
            bool1 = true;
            label263:
            a(paramString, bool1, false);
            parama = paramString.KBy;
            if (k == 0) {
              break label850;
            }
            i = 8;
            label287:
            parama.setVisibility(i);
            parama = paramString.KBz;
            if (k == 0) {
              break label856;
            }
            i = 8;
            label308:
            parama.setVisibility(i);
            label314:
            paramString.olI.setTag(new bk(parambv, parama1.fJC(), paramInt, parambv.field_talker, '\000'));
            parama = paramString.olI;
            if (this.KBw == null) {
              this.KBw = new ap.c(this.JWz, this);
            }
            parama.setOnClickListener(this.KBw);
            paramString.olI.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
            paramString.olI.setOnLongClickListener(c(parama1));
            paramString.KxS.setContentDescription(parama1.Kkd.getMMResources().getString(2131757186));
            if (fLB())
            {
              a(paramString, false, false);
              ae.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[] { Long.valueOf(parambv.field_msgId), Integer.valueOf(parambv.field_status) });
              if (fLB())
              {
                if ((parambv.field_status != 2) || (!b((k)parama1.bh(k.class), parambv.field_msgId))) {
                  break label893;
                }
                if (paramString.KvW != null) {
                  paramString.KvW.setVisibility(0);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, parambv, parama1.fJy(), false, parama1.fJC(), parama1, this);
        ap.a(parambv, parama1, paramString);
        AppMethodBeat.o(37327);
        return;
        if ((j == i) && (i != 0))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        bool1 = com.tencent.mm.av.h.b((com.tencent.mm.av.g)localObject1);
        break;
        bool1 = false;
        break;
        label612:
        parama = paramString.KBz;
        break label168;
        label621:
        k = 0;
        break label239;
        label627:
        parama = paramString.KBy;
        localObject2 = new StringBuilder();
        if (localObject1 != null)
        {
          j = ((com.tencent.mm.av.g)localObject1).hPI;
          i = ((com.tencent.mm.av.g)localObject1).offset;
          if (p.aIL().su(((com.tencent.mm.av.g)localObject1).doE))
          {
            localObject3 = p.aIL().sv(((com.tencent.mm.av.g)localObject1).doE);
            j = (int)((p.d)localObject3).dzX;
            i = (int)((p.d)localObject3).offset;
          }
          if (((com.tencent.mm.av.g)localObject1).aIB())
          {
            localObject3 = q.aIX().pw(((com.tencent.mm.av.g)localObject1).icz);
            if (p.aIL().su(((com.tencent.mm.av.g)localObject1).icz))
            {
              localObject1 = p.aIL().sv(((com.tencent.mm.av.g)localObject1).icz);
              j = (int)((p.d)localObject1).dzX;
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
          j = ((com.tencent.mm.av.g)localObject3).hPI;
          i = ((com.tencent.mm.av.g)localObject3).offset;
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
        paramString.KBz.setVisibility(8);
        a(paramString, false, false);
        paramString.KBy.setVisibility(8);
        break label314;
        label893:
        if (paramString.KvW != null) {
          paramString.KvW.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37329);
      if (100 == paramMenuItem.getItemId()) {
        ap.c(parambv, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37329);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          ap.b(parama, paramMenuItem, parambv);
        } else {
          ((ak)parama.bh(ak.class)).a(paramMenuItem, parambv);
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187881);
      bc.aCg();
      int k;
      Object localObject2;
      Object localObject1;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null))
      {
        k = ((bk)paramView.getTag()).position;
        localObject2 = null;
        if (parambv.field_msgId > 0L) {
          localObject2 = q.aIX().G(parambv.field_talker, parambv.field_msgId);
        }
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((com.tencent.mm.av.g)localObject2).doE > 0L) {}
        }
        else
        {
          localObject1 = localObject2;
          if (parambv.field_msgSvrId > 0L) {
            localObject1 = q.aIX().F(parambv.field_talker, parambv.field_msgSvrId);
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.av.g)localObject1).aIB())
          {
            localObject2 = localObject1;
            if (((com.tencent.mm.av.g)localObject1).hPI == 0) {
              localObject2 = q.aIX().pw(((com.tencent.mm.av.g)localObject1).icz);
            }
          }
        }
        if (!bn.A(parambv)) {
          paraml.a(k, 110, paramView.getContext().getString(2131762559), 2131690478);
        }
        if (parambv.field_status == 5) {
          paraml.a(k, 103, paramView.getContext().getString(2131757286), 2131690467);
        }
        if ((com.tencent.mm.al.g.aFQ()) && (!this.JWz.fJD())) {
          paraml.add(k, 114, 0, paramView.getContext().getString(2131757217));
        }
        if (com.tencent.mm.br.d.aJN("favorite")) {
          paraml.a(k, 116, paramView.getContext().getString(2131761941), 2131690400);
        }
        if (((com.tencent.mm.av.g)localObject2).status != -1)
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
        localObject1 = new ec();
        ((ec)localObject1).dql.msgId = parambv.field_msgId;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        if ((((ec)localObject1).dqm.dpK) || (com.tencent.mm.pluginsdk.model.app.h.ap(this.JWz.Kkd.getContext(), parambv.getType()))) {
          paraml.a(k, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if ((!parambv.fta()) && (parambv.ftg()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker)) && (!an.zd(this.JWz.getTalkerUserName()))) {
          paraml.a(k, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        if (!this.JWz.fJD()) {
          paraml.a(k, 100, paramView.getContext().getString(2131757220), 2131690384);
        }
        if ((bn.z(parambv)) || (bn.B(parambv)))
        {
          paraml.clear();
          if (!this.JWz.fJD()) {
            paraml.a(k, 100, paramView.getContext().getString(2131757220), 2131690384);
          }
        }
        AppMethodBeat.o(187881);
        return true;
        label658:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      return false;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 39) || (paramInt == 33));
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
  
  public static final class c
    extends t.e
  {
    private c KBx;
    private int scene;
    
    public c(com.tencent.mm.ui.chatting.e.a parama, c paramc)
    {
      super();
      this.scene = 0;
      this.KBx = paramc;
    }
    
    public c(com.tencent.mm.ui.chatting.e.a parama, c paramc, bv parambv, View paramView)
    {
      super();
      AppMethodBeat.i(37333);
      this.scene = 0;
      this.KBx = paramc;
      this.scene = 1;
      if (this.scene == 1)
      {
        com.tencent.mm.modelstat.b.iqT.U(parambv);
        a(new bk(parambv, this.JWz.fJC(), 0, parambv.field_talker, '\000'), paramView);
      }
      AppMethodBeat.o(37333);
    }
    
    private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37336);
      ae.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] doGetMsgImg");
      Intent localIntent = new Intent(this.JWz.Kkd.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("show_search_chat_content_result", ((aj)this.JWz.bh(aj.class)).fIP());
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.d.b.d)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ());
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGW());
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
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", an.zd(paramString1));
      paramString2 = this.JWz.getTalkerUserName();
      paramArrayOfInt = new Bundle();
      if (this.JWz.fJC()) {
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
        paramString1 = this.JWz;
        paramString2 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString1.startActivity((Intent)paramString2.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.JWz.Kkd.overridePendingTransition(0, 0);
        AppMethodBeat.o(37336);
        return;
        if (x.Ao(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    public static void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37337);
      a(parama, parambv, paramLong1, paramLong2, paramString1, paramString2, paramArrayOfInt, paramInt1, paramInt2, true, 0);
      AppMethodBeat.o(37337);
    }
    
    private static void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(37338);
      ae.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
      Intent localIntent = new Intent(parama.Kkd.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("show_search_chat_content_result", ((aj)parama.bh(aj.class)).fIP());
      localIntent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ());
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGW());
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
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", an.zd(paramString1));
      paramString2 = parama.getTalkerUserName();
      if (parambv.field_isSend == 1) {
        paramString1 = parama.fJy();
      }
      parambv = new Bundle();
      if (parama.fJB()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        parambv.putInt("stat_scene", paramInt1);
        parambv.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        parambv.putString("stat_chat_talker_username", paramString2);
        parambv.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", parambv);
        localIntent.putExtra("img_gallery_session_id", g(paramLong2, paramString1, paramString2));
        parambv = parama.Kkd;
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parambv, paramString1.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parambv.startActivity((Intent)paramString1.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parambv, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.Kkd.overridePendingTransition(0, 0);
        AppMethodBeat.o(37338);
        return;
        if (x.Ao(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    private void a(bk parambk, View paramView)
    {
      AppMethodBeat.i(37335);
      bv localbv = parambk.dCi;
      com.tencent.mm.modelstat.a.a(localbv, a.a.iqQ);
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        paramView.getLocationInWindow(arrayOfInt);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      if (localbv.field_isSend == 1)
      {
        paramView = q.aIX().G(localbv.field_talker, localbv.field_msgId);
        if (paramView.doE != 0L) {}
      }
      else
      {
        paramView = q.aIX().F(localbv.field_talker, localbv.field_msgSvrId);
      }
      for (;;)
      {
        Object localObject = bx.M(localbv.field_content, "msg");
        if (localObject != null) {
          bu.getLong((String)((Map)localObject).get(".msg.img.$hdlength"), 0L);
        }
        bc.aCg();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          t.g(this.JWz.Kkd.getContext(), this.JWz.Kkd.getContentView());
          AppMethodBeat.o(37335);
          return;
        }
        if (localbv.field_isSend == 1)
        {
          localObject = com.tencent.mm.av.h.c(paramView);
          if (o.fB(q.aIX().o((String)localObject, "", "")))
          {
            a(this.JWz, localbv, paramView.icx, paramView.dCd, parambk.userName, parambk.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          localObject = paramView.ico;
          if (o.fB(q.aIX().o((String)localObject, "", "")))
          {
            a(this.JWz, localbv, paramView.icx, paramView.dCd, parambk.userName, parambk.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          a(localbv.field_msgId, localbv.field_msgSvrId, parambk.userName, parambk.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.aIA())
        {
          String str = paramView.ico;
          localObject = str;
          if (paramView.aIB())
          {
            com.tencent.mm.av.g localg = com.tencent.mm.av.h.a(paramView);
            localObject = str;
            if (localg != null)
            {
              localObject = str;
              if (localg.doE > 0L)
              {
                localObject = str;
                if (localg.aIA())
                {
                  localObject = str;
                  if (o.fB(q.aIX().o(localg.ico, "", ""))) {
                    localObject = localg.ico;
                  }
                }
              }
            }
          }
          if (o.fB(q.aIX().o((String)localObject, "", "")))
          {
            a(this.JWz, localbv, paramView.icx, paramView.dCd, parambk.userName, parambk.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          ae.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.doE) });
          paramView.FF("SERVERID://" + localbv.field_msgSvrId);
          paramView.dEu = 16;
          paramView.pq(0);
          paramView.dEu = 8;
          paramView.setStatus(0);
          paramView.dEu = 256;
          q.aIX().a(Long.valueOf(paramView.doE), paramView);
          a(localbv.field_msgId, localbv.field_msgSvrId, parambk.userName, parambk.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.status == -1)
        {
          ae.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.doE) });
          paramView.setStatus(0);
          paramView.dEu = 256;
          q.aIX().a(Long.valueOf(paramView.doE), paramView);
        }
        a(localbv.field_msgId, localbv.field_msgSvrId, parambk.userName, parambk.chatroomName, arrayOfInt, i, j);
        AppMethodBeat.o(37335);
        return;
      }
    }
    
    private static String g(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(37339);
      String str = z.Br(String.valueOf(paramLong));
      z.b localb = z.aBG().F(str, true);
      localb.k("preUsername", paramString1);
      localb.k("preChatName", paramString2);
      int i = 3;
      if ((com.tencent.mm.al.g.Eo(paramString2)) || (an.zd(paramString2))) {
        i = 5;
      }
      localb.k("Contact_Sub_Scene", Integer.valueOf(i));
      localb.k("Contact_Scene_Note", paramString2);
      AppMethodBeat.o(37339);
      return str;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37334);
      Object localObject = (bk)paramView.getTag();
      com.tencent.mm.modelstat.b.iqT.U(((bk)localObject).dCi);
      a((bk)localObject, paramView);
      localObject = k.b.za(parambv.field_content);
      com.tencent.mm.pluginsdk.model.app.g localg;
      if ((localObject != null) && (!bu.isNullOrNil(((k.b)localObject).appId)) && (this.KBx != null))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject).appId, false, false);
        if (localg != null) {
          if (!(this.KBx instanceof ap.a)) {
            break label126;
          }
        }
      }
      label126:
      for (paramView = c.d(parama, parambv);; paramView = v.aAC())
      {
        c.a(parama, (k.b)localObject, paramView, localg, parambv.field_msgSvrId, parama.getTalkerUserName());
        com.tencent.mm.al.l.I(parambv);
        AppMethodBeat.o(37334);
        return;
      }
    }
  }
  
  static final class d
    extends c.a
  {
    TextView KBy;
    View KBz;
    ImageView KvW;
    ImageView KxS;
    ImageView Kzq;
    TextView rLB;
    
    public final c.a E(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37340);
      super.gs(paramView);
      this.fVV = ((TextView)paramView.findViewById(2131298178));
      this.KxS = ((ImageView)paramView.findViewById(2131298074));
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.hcH = paramView.findViewById(2131298147);
      this.KBz = paramView.findViewById(2131306222);
      if (paramBoolean)
      {
        this.yUp = ((TextView)paramView.findViewById(2131298185));
        this.xvJ = ((ProgressBar)paramView.findViewById(2131299229));
      }
      for (;;)
      {
        this.Kzq = ((ImageView)paramView.findViewById(2131298076));
        this.rLB = ((TextView)paramView.findViewById(2131298044));
        AppMethodBeat.o(37340);
        return this;
        this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
        this.KBy = ((TextView)paramView.findViewById(2131306221));
        this.yUp = ((TextView)paramView.findViewById(2131298185));
        this.KvW = ((ImageView)paramView.findViewById(2131298176));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap
 * JD-Core Version:    0.7.0.1
 */