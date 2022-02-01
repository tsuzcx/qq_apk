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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.vfs.s;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class av
{
  public static final class a
    extends c
  {
    private av.c POe;
    private com.tencent.mm.ui.chatting.e.a PhN;
    
    public static void a(Context paramContext, c.a parama, ca paramca, boolean paramBoolean)
    {
      AppMethodBeat.i(37325);
      if (true != paramBoolean)
      {
        AppMethodBeat.o(37325);
        return;
      }
      if ((parama instanceof av.d))
      {
        parama = (av.d)parama;
        q.bcR().a(parama.PKi, paramca.field_imgPath, com.tencent.mm.cb.a.getDensity(paramContext), paramca.fQS, paramca.fQT, parama.PLQ, 2131231626, 1, null);
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
        localObject = new an(paramLayoutInflater, 2131493558);
        ((View)localObject).setTag(new av.d().G((View)localObject, true));
      }
      AppMethodBeat.o(37320);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(37321);
      this.PhN = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bY(paramca);
      av.d locald = (av.d)parama;
      float f = br.G(paramca);
      if (f != 1.0F)
      {
        parama = new jc();
        parama.emN = paramca.field_msgSvrId;
        parama.eLn = paramca.getType();
        parama.eQu = br.C(paramca);
        parama.ejA = 1L;
        parama.bfK();
        Log.i("MicroMsg.ChattingItemImgFrom", "img need scale:%s, %s", new Object[] { Long.valueOf(paramca.field_msgId), Float.valueOf(f) });
      }
      boolean bool = q.bcR().a(locald.PKi, paramca.field_imgPath, f * com.tencent.mm.cb.a.getDensity(parama1.Pwc.getContext()), paramca.fQS, paramca.fQT, locald.PLQ, 2131231623, 1, null);
      locald.POh.setVisibility(0);
      a(locald, false, false);
      if (!bool) {
        locald.PKi.setImageBitmap(BitmapFactory.decodeResource(parama1.Pwc.getMMResources(), 2131231623));
      }
      parama = null;
      if (parama1.gRM()) {
        parama = paramca.field_talker;
      }
      locald.clickArea.setTag(new bq(paramca, parama1.gRM(), paramInt, paramString, parama));
      parama = locald.clickArea;
      if (this.POe == null) {
        this.POe = new av.c(this.PhN, this);
      }
      av.c.a(this.POe, 0);
      if (br.D(paramca)) {
        av.c.a(this.POe, 2);
      }
      parama.setOnClickListener(this.POe);
      locald.clickArea.setOnLongClickListener(c(parama1));
      locald.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
      av.a(paramca, parama1, locald);
      AppMethodBeat.o(37321);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37324);
      if (100 == paramMenuItem.getItemId()) {
        av.c(paramca, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37324);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          av.b(parama, paramMenuItem, paramca);
        } else {
          ((com.tencent.mm.ui.chatting.d.b.an)parama.bh(com.tencent.mm.ui.chatting.d.b.an.class)).a(paramMenuItem, paramca);
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233910);
      bg.aVF();
      int k;
      Object localObject1;
      Object localObject2;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null) && (paramca != null))
      {
        k = ((bq)paramView.getTag()).position;
        localObject1 = null;
        if (paramca.field_msgId > 0L) {
          localObject1 = q.bcR().H(paramca.field_talker, paramca.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.av.g)localObject1).localId > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (paramca.field_msgSvrId > 0L) {
            localObject2 = q.bcR().G(paramca.field_talker, paramca.field_msgSvrId);
          }
        }
        if (!br.J(paramca)) {
          paramm.a(k, 110, paramView.getContext().getString(2131764628), 2131690674);
        }
        if ((com.tencent.mm.al.g.aZI()) && (!this.PhN.gRN())) {
          paramm.add(k, 114, 0, paramView.getContext().getString(2131757429));
        }
        if (com.tencent.mm.br.c.aZU("favorite")) {
          paramm.a(k, 116, paramView.getContext().getString(2131763947), 2131690551);
        }
        if ((localObject2 != null) && (((com.tencent.mm.av.g)localObject2).status != -1))
        {
          localObject1 = paramm.a(k, 131, paramView.getContext().getString(2131757388), 2131690644);
          localObject2 = new int[2];
          if (paramView == null) {
            break label565;
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
        localObject1 = new ef();
        ((ef)localObject1).dHy.msgId = paramca.field_msgId;
        EventCenter.instance.publish((IEvent)localObject1);
        if ((((ef)localObject1).dHz.dGX) || (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), paramca.getType()))) {
          paramm.a(k, 129, paramView.getContext().getString(2131757440), 2131690628);
        }
        if (!this.PhN.gRN()) {
          paramm.a(k, 100, paramView.getContext().getString(2131757432), 2131690529);
        }
        if ((br.B(paramca)) || (br.K(paramca)) || (br.E(paramca)))
        {
          paramm.clear();
          if (!this.PhN.gRN()) {
            paramm.a(k, 100, paramView.getContext().getString(2131757432), 2131690529);
          }
        }
        if (br.D(paramca))
        {
          paramm = new jc();
          paramm.emN = paramca.field_msgSvrId;
          paramm.eLn = paramca.getType();
          paramm.eQu = br.C(paramca);
          paramm.ejA = 3L;
          paramm.bfK();
        }
        AppMethodBeat.o(233910);
        return true;
        label565:
        i = 0;
        j = 0;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37322);
      boolean bool = parama.gRM();
      AppMethodBeat.o(37322);
      return bool;
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 39) || (paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 33));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean gTT()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private av.c POe;
    private com.tencent.mm.ui.chatting.e.a PhN;
    
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
      parama = (av.d)parama;
      if ((paramInt1 >= 100) && (parama.POg.getVisibility() != 0))
      {
        AppMethodBeat.o(37330);
        return;
      }
      parama.POg.setText(paramInt1 + "%");
      if (gTW()) {
        a(parama, false);
      }
      for (;;)
      {
        parama.POg.setVisibility(0);
        parama.POh.setVisibility(0);
        AppMethodBeat.o(37330);
        return;
        a(parama, true);
      }
    }
    
    public static void c(c.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(37331);
      if ((paramBoolean == true) && ((parama instanceof av.d)))
      {
        parama = (av.d)parama;
        a(parama, false);
        parama.POg.setVisibility(4);
        parama.POh.setVisibility(4);
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
        localObject = new an(paramLayoutInflater, 2131493608);
        ((View)localObject).setTag(new av.d().G((View)localObject, false));
      }
      AppMethodBeat.o(37326);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(37327);
      this.PhN = parama1;
      paramString = (av.d)parama;
      parama = p.bcF();
      long l = paramca.field_msgId;
      boolean bool2 = parama.iZJ.containsKey(Long.valueOf(l));
      Object localObject1 = q.bcR().U(paramca);
      int i;
      int j;
      boolean bool1;
      Object localObject2;
      Object localObject3;
      label259:
      int k;
      if ((localObject1 != null) && (!bool2)) {
        if (p.bcF().AA(((com.tencent.mm.av.g)localObject1).localId))
        {
          parama = p.bcF().AB(((com.tencent.mm.av.g)localObject1).localId);
          i = (int)parama.total;
          j = (int)parama.offset;
          if (i == 0)
          {
            bool1 = true;
            float f1 = br.G(paramca);
            if (f1 != 1.0F)
            {
              parama = new jc();
              parama.emN = paramca.field_msgSvrId;
              parama.eLn = paramca.getType();
              parama.eQu = br.C(paramca);
              parama.ejA = 1L;
              parama.bfK();
              Log.i("MicroMsg.ChattingItemImgTo", "img need scale:%s, %s", new Object[] { Long.valueOf(paramca.field_msgId), Float.valueOf(f1) });
            }
            localObject2 = q.bcR();
            localObject3 = paramString.PKi;
            String str = paramca.field_imgPath;
            float f2 = com.tencent.mm.cb.a.getDensity(parama1.Pwc.getContext());
            i = paramca.fQS;
            j = paramca.fQT;
            ImageView localImageView = paramString.PLQ;
            if (!bool1) {
              break label734;
            }
            parama = null;
            if (!((com.tencent.mm.av.i)localObject2).a((ImageView)localObject3, str, f1 * f2, i, j, localImageView, 2131231623, 0, parama)) {
              paramString.PKi.setImageDrawable(com.tencent.mm.cb.a.l(parama1.Pwc.getContext(), 2131231623));
            }
            if ((localObject1 == null) && (!bool2)) {
              break label984;
            }
            if ((!bool1) && (paramca.field_status != 5)) {
              break label743;
            }
            k = 1;
            label335:
            if (!bool2) {
              break label749;
            }
            paramString.POg.setText("0%");
            if (k != 0) {
              break label966;
            }
            bool1 = true;
            label359:
            a(paramString, bool1, false);
            parama = paramString.POg;
            if (k == 0) {
              break label972;
            }
            i = 8;
            label383:
            parama.setVisibility(i);
            parama = paramString.POh;
            if (k == 0) {
              break label978;
            }
            i = 8;
            label404:
            parama.setVisibility(i);
            label410:
            paramString.clickArea.setTag(new bq(paramca, parama1.gRM(), paramInt, paramca.field_talker, '\000'));
            parama = paramString.clickArea;
            if (this.POe == null) {
              this.POe = new av.c(this.PhN, this);
            }
            av.c.a(this.POe, 0);
            if (br.D(paramca)) {
              av.c.a(this.POe, 2);
            }
            parama.setOnClickListener(this.POe);
            paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.PKi.setContentDescription(parama1.Pwc.getMMResources().getString(2131757392));
            if (gTW())
            {
              a(paramString, false, false);
              Log.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[] { Long.valueOf(paramca.field_msgId), Integer.valueOf(paramca.field_status) });
              if (gTW())
              {
                if ((paramca.field_status != 2) || (!b((k)parama1.bh(k.class), paramca.field_msgId))) {
                  break label1015;
                }
                if (paramString.PIn != null) {
                  paramString.PIn.setVisibility(0);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, paramca, parama1.gRI(), false, parama1.gRM(), parama1, this);
        av.a(paramca, parama1, paramString);
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
        label734:
        parama = paramString.POh;
        break label259;
        label743:
        k = 0;
        break label335;
        label749:
        parama = paramString.POg;
        localObject2 = new StringBuilder();
        if (localObject1 != null)
        {
          j = ((com.tencent.mm.av.g)localObject1).iKP;
          i = ((com.tencent.mm.av.g)localObject1).offset;
          if (p.bcF().AA(((com.tencent.mm.av.g)localObject1).localId))
          {
            localObject3 = p.bcF().AB(((com.tencent.mm.av.g)localObject1).localId);
            j = (int)((p.d)localObject3).total;
            i = (int)((p.d)localObject3).offset;
          }
          if (((com.tencent.mm.av.g)localObject1).bcv())
          {
            localObject3 = q.bcR().tl(((com.tencent.mm.av.g)localObject1).iXx);
            if (p.bcF().AA(((com.tencent.mm.av.g)localObject1).iXx))
            {
              localObject1 = p.bcF().AB(((com.tencent.mm.av.g)localObject1).iXx);
              j = (int)((p.d)localObject1).total;
              i = (int)((p.d)localObject1).offset;
            }
          }
          else
          {
            label892:
            if (j <= 0) {
              break label960;
            }
            if (i < j) {
              break label947;
            }
            i = 100;
          }
        }
        for (;;)
        {
          parama.setText(i + "%");
          break;
          j = ((com.tencent.mm.av.g)localObject3).iKP;
          i = ((com.tencent.mm.av.g)localObject3).offset;
          break label892;
          label947:
          i = i * 100 / j;
          continue;
          label960:
          i = 0;
        }
        label966:
        bool1 = false;
        break label359;
        label972:
        i = 0;
        break label383;
        label978:
        i = 0;
        break label404;
        label984:
        paramString.POh.setVisibility(8);
        a(paramString, false, false);
        paramString.POg.setVisibility(8);
        break label410;
        label1015:
        if (paramString.PIn != null) {
          paramString.PIn.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37329);
      if (100 == paramMenuItem.getItemId()) {
        av.c(paramca, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(37329);
        return false;
        if (131 == paramMenuItem.getItemId()) {
          av.b(parama, paramMenuItem, paramca);
        } else {
          ((com.tencent.mm.ui.chatting.d.b.an)parama.bh(com.tencent.mm.ui.chatting.d.b.an.class)).a(paramMenuItem, paramca);
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233911);
      bg.aVF();
      int k;
      Object localObject2;
      Object localObject1;
      int j;
      int i;
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null))
      {
        k = ((bq)paramView.getTag()).position;
        localObject2 = null;
        if (paramca.field_msgId > 0L) {
          localObject2 = q.bcR().H(paramca.field_talker, paramca.field_msgId);
        }
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((com.tencent.mm.av.g)localObject2).localId > 0L) {}
        }
        else
        {
          localObject1 = localObject2;
          if (paramca.field_msgSvrId > 0L) {
            localObject1 = q.bcR().G(paramca.field_talker, paramca.field_msgSvrId);
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.av.g)localObject1).bcv())
          {
            localObject2 = localObject1;
            if (((com.tencent.mm.av.g)localObject1).iKP == 0) {
              localObject2 = q.bcR().tl(((com.tencent.mm.av.g)localObject1).iXx);
            }
          }
        }
        if (!br.J(paramca)) {
          paramm.a(k, 110, paramView.getContext().getString(2131764628), 2131690674);
        }
        if (paramca.field_status == 5) {
          paramm.a(k, 103, paramView.getContext().getString(2131757500), 2131690658);
        }
        if ((com.tencent.mm.al.g.aZI()) && (!this.PhN.gRN())) {
          paramm.add(k, 114, 0, paramView.getContext().getString(2131757429));
        }
        if (com.tencent.mm.br.c.aZU("favorite")) {
          paramm.a(k, 116, paramView.getContext().getString(2131763947), 2131690551);
        }
        if (((com.tencent.mm.av.g)localObject2).status != -1)
        {
          localObject1 = paramm.a(k, 131, paramView.getContext().getString(2131757388), 2131690644);
          localObject2 = new int[2];
          if (paramView == null) {
            break label718;
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
        localObject1 = new ef();
        ((ef)localObject1).dHy.msgId = paramca.field_msgId;
        EventCenter.instance.publish((IEvent)localObject1);
        if ((((ef)localObject1).dHz.dGX) || (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), paramca.getType()))) {
          paramm.a(k, 129, paramView.getContext().getString(2131757440), 2131690628);
        }
        if ((!paramca.gAt()) && (paramca.gAz()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
          paramm.a(k, 123, paramView.getContext().getString(2131757446), 2131690650);
        }
        if (!this.PhN.gRN()) {
          paramm.a(k, 100, paramView.getContext().getString(2131757432), 2131690529);
        }
        if ((br.B(paramca)) || (br.K(paramca)) || (br.E(paramca)))
        {
          paramm.clear();
          if (!this.PhN.gRN()) {
            paramm.a(k, 100, paramView.getContext().getString(2131757432), 2131690529);
          }
        }
        if (br.D(paramca))
        {
          paramm = new jc();
          paramm.emN = paramca.field_msgSvrId;
          paramm.eLn = paramca.getType();
          paramm.eQu = br.C(paramca);
          paramm.ejA = 3L;
          paramm.bfK();
        }
        AppMethodBeat.o(233911);
        return true;
        label718:
        i = 0;
        j = 0;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233912);
      paramca.unsetOmittedFailResend();
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
      ((com.tencent.mm.ui.chatting.d.b.an)parama.bh(com.tencent.mm.ui.chatting.d.b.an.class)).bU(paramca);
      AppMethodBeat.o(233912);
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 39) || (paramInt == 33));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return false;
    }
    
    public final boolean gTT()
    {
      return true;
    }
  }
  
  public static final class c
    extends t.e
  {
    private c POf;
    private int scene;
    
    public c(com.tencent.mm.ui.chatting.e.a parama, c paramc)
    {
      super();
      this.scene = 0;
      this.POf = paramc;
    }
    
    public c(com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca, View paramView)
    {
      super();
      AppMethodBeat.i(37333);
      this.scene = 0;
      this.POf = paramc;
      this.scene = 1;
      if (this.scene == 1)
      {
        b.jmd.ae(paramca);
        a(new bq(paramca, this.PhN.gRM(), 0, paramca.field_talker, '\000'), paramView);
      }
      AppMethodBeat.o(37333);
    }
    
    private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37336);
      Log.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] doGetMsgImg");
      Intent localIntent = new Intent(this.PhN.Pwc.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("show_search_chat_content_result", ((am)this.PhN.bh(am.class)).gQZ());
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("key_is_biz_chat", ((d)this.PhN.bh(d.class)).gOP());
      localIntent.putExtra("key_biz_chat_id", ((d)this.PhN.bh(d.class)).gPc());
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
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", as.HF(paramString1));
      paramString2 = this.PhN.getTalkerUserName();
      paramArrayOfInt = new Bundle();
      if (this.PhN.gRM()) {
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
        paramString1 = this.PhN;
        paramString2 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString1.startActivity((Intent)paramString2.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.PhN.Pwc.overridePendingTransition(0, 0);
        AppMethodBeat.o(37336);
        return;
        if (ab.IT(paramString2)) {
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
      Intent localIntent = new Intent(parama.Pwc.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("show_search_chat_content_result", ((am)parama.bh(am.class)).gQZ());
      localIntent.putExtra("key_is_biz_chat", ((d)parama.bh(d.class)).gOP());
      localIntent.putExtra("key_biz_chat_id", ((d)parama.bh(d.class)).gPc());
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
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", as.HF(paramString1));
      paramString2 = parama.getTalkerUserName();
      if (paramca.field_isSend == 1) {
        paramString1 = parama.gRI();
      }
      paramca = new Bundle();
      if (parama.gRL()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        paramca.putInt("stat_scene", paramInt1);
        paramca.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        paramca.putString("stat_chat_talker_username", paramString2);
        paramca.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", paramca);
        localIntent.putExtra("img_gallery_session_id", g(paramLong2, paramString1, paramString2));
        paramca = parama.Pwc;
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramca, paramString1.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramca.startActivity((Intent)paramString1.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramca, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.Pwc.overridePendingTransition(0, 0);
        AppMethodBeat.o(37338);
        return;
        if (ab.IT(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    private void a(bq parambq, View paramView)
    {
      AppMethodBeat.i(37335);
      ca localca = parambq.dTX;
      com.tencent.mm.modelstat.a.a(localca, a.a.jma);
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        if (ao.gJK())
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
          paramView = q.bcR().H(localca.field_talker, localca.field_msgId);
          if (paramView.localId != 0L) {
            break label751;
          }
        }
        paramView = q.bcR().G(localca.field_talker, localca.field_msgSvrId);
      }
      label751:
      for (;;)
      {
        Object localObject = XmlParser.parseXml(localca.field_content, "msg", null);
        if (localObject != null) {
          Util.getLong((String)((Map)localObject).get(".msg.img.$hdlength"), 0L);
        }
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
          AppMethodBeat.o(37335);
          return;
          paramView.getLocationInWindow(arrayOfInt);
          break;
        }
        if (localca.field_isSend == 1)
        {
          localObject = com.tencent.mm.av.h.c(paramView);
          if (s.YS(q.bcR().o((String)localObject, "", "")))
          {
            a(this.PhN, localca, paramView.iXv, paramView.dTS, parambq.userName, parambq.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          localObject = paramView.iXm;
          if (s.YS(q.bcR().o((String)localObject, "", "")))
          {
            a(this.PhN, localca, paramView.iXv, paramView.dTS, parambq.userName, parambq.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          a(localca.field_msgId, localca.field_msgSvrId, parambq.userName, parambq.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.bcu())
        {
          String str = paramView.iXm;
          localObject = str;
          if (paramView.bcv())
          {
            com.tencent.mm.av.g localg = com.tencent.mm.av.h.a(paramView);
            localObject = str;
            if (localg != null)
            {
              localObject = str;
              if (localg.localId > 0L)
              {
                localObject = str;
                if (localg.bcu())
                {
                  localObject = str;
                  if (s.YS(q.bcR().o(localg.iXm, "", ""))) {
                    localObject = localg.iXm;
                  }
                }
              }
            }
          }
          if (s.YS(q.bcR().o((String)localObject, "", "")))
          {
            a(this.PhN, localca, paramView.iXv, paramView.dTS, parambq.userName, parambq.chatroomName, arrayOfInt, i, j, false, this.scene);
            AppMethodBeat.o(37335);
            return;
          }
          Log.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.localId) });
          paramView.Oq("SERVERID://" + localca.field_msgSvrId);
          paramView.cSx = 16;
          paramView.tf(0);
          paramView.cSx = 8;
          paramView.setStatus(0);
          paramView.cSx = 256;
          q.bcR().a(Long.valueOf(paramView.localId), paramView);
          a(localca.field_msgId, localca.field_msgSvrId, parambq.userName, parambq.chatroomName, arrayOfInt, i, j);
          AppMethodBeat.o(37335);
          return;
        }
        if (paramView.status == -1)
        {
          Log.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.localId) });
          paramView.setStatus(0);
          paramView.cSx = 256;
          q.bcR().a(Long.valueOf(paramView.localId), paramView);
        }
        a(localca.field_msgId, localca.field_msgSvrId, parambq.userName, parambq.chatroomName, arrayOfInt, i, j);
        AppMethodBeat.o(37335);
        return;
      }
    }
    
    private static String g(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(37339);
      String str = ad.JX(String.valueOf(paramLong));
      ad.b localb = ad.aVe().G(str, true);
      localb.l("preUsername", paramString1);
      localb.l("preChatName", paramString2);
      int i = 3;
      if ((com.tencent.mm.al.g.Nc(paramString2)) || (as.HF(paramString2))) {
        i = 5;
      }
      localb.l("Contact_Sub_Scene", Integer.valueOf(i));
      localb.l("Contact_Scene_Note", paramString2);
      AppMethodBeat.o(37339);
      return str;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37334);
      Object localObject = (bq)paramView.getTag();
      b.jmd.ae(((bq)localObject).dTX);
      a((bq)localObject, paramView);
      localObject = k.b.HC(paramca.field_content);
      com.tencent.mm.pluginsdk.model.app.g localg;
      if ((localObject != null) && (!Util.isNullOrNil(((k.b)localObject).appId)) && (this.POf != null))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject).appId, false, false);
        if (localg != null) {
          if (!(this.POf instanceof av.a)) {
            break label127;
          }
        }
      }
      label127:
      for (paramView = c.d(parama, paramca);; paramView = z.aTY())
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
    ImageView PIn;
    ImageView PKi;
    ImageView PLQ;
    TextView POg;
    View POh;
    TextView tln;
    
    public final c.a G(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37340);
      super.create(paramView);
      this.timeTV = ((TextView)paramView.findViewById(2131298558));
      this.PKi = ((ImageView)paramView.findViewById(2131298417));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.maskView = paramView.findViewById(2131298508);
      this.POh = paramView.findViewById(2131309621);
      if (paramBoolean)
      {
        this.userTV = ((TextView)paramView.findViewById(2131298566));
        this.uploadingPB = ((ProgressBar)paramView.findViewById(2131299794));
      }
      for (;;)
      {
        this.PLQ = ((ImageView)paramView.findViewById(2131298419));
        this.tln = ((TextView)paramView.findViewById(2131298385));
        AppMethodBeat.o(37340);
        return this;
        this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
        this.POg = ((TextView)paramView.findViewById(2131309620));
        this.userTV = ((TextView)paramView.findViewById(2131298566));
        this.PIn = ((ImageView)paramView.findViewById(2131298556));
      }
    }
    
    public final View getMainContainerView()
    {
      return this.PKi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av
 * JD-Core Version:    0.7.0.1
 */