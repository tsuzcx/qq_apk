package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.i.a.b;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.view.NinePatchCropImageView;
import java.util.List;

public final class n
{
  static final class a
    extends c.a
  {
    public ImageIndicatorView Ahv;
    public ImageView Kyb;
    public ImageView Kyc;
    public TextView Kyd;
    public ImageView Kye;
    public TextView Kyf;
    public TextView Kyg;
    public ImageView Kyh;
    public ImageView Kyi;
    public View Kyj;
    public int width;
    
    public final a H(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(163338);
      super.gs(paramView);
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131298069);
      Object localObject = paramView.getContext();
      this.width = ((int)((((Context)localObject).getResources().getDisplayMetrics().widthPixels - ((Context)localObject).getResources().getDimension(2131165284)) / 2.0F));
      localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = this.width;
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.Kyc = ((ImageView)paramView.findViewById(2131298122));
      this.Kyd = ((TextView)paramView.findViewById(2131298126));
      this.Kye = ((ImageView)paramView.findViewById(2131298128));
      this.Kyf = ((TextView)paramView.findViewById(2131298123));
      this.Kyg = ((TextView)paramView.findViewById(2131298127));
      this.Kyh = ((ImageView)paramView.findViewById(2131298124));
      this.Kyi = ((ImageView)paramView.findViewById(2131298125));
      this.Ahv = ((ImageIndicatorView)paramView.findViewById(2131308257));
      this.yUp = ((TextView)paramView.findViewById(2131298185));
      this.Kyj = paramView.findViewById(2131298053);
      int i;
      if (!((t)g.ad(t.class)).showFinderEntry())
      {
        i = 1;
        if (i == 0)
        {
          this.iFD = ((CheckBox)paramView.findViewById(2131298068));
          this.hcH = paramView.findViewById(2131298147);
        }
        if (!paramBoolean) {
          break label350;
        }
        this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
        this.Kyb = ((ImageView)paramView.findViewById(2131298176));
        if ((this.Kye instanceof NinePatchCropImageView)) {
          ((NinePatchCropImageView)this.Kye).setNinePatchId(2131234981);
        }
      }
      for (;;)
      {
        this.Kyh.setImageDrawable(ao.k(this.Kyh.getContext(), 2131690572, com.tencent.mm.cb.a.n(this.Kyh.getContext(), 2131099777)));
        AppMethodBeat.o(163338);
        return this;
        i = 0;
        break;
        label350:
        if ((this.Kye instanceof NinePatchCropImageView)) {
          ((NinePatchCropImageView)this.Kye).setNinePatchId(2131234979);
        }
      }
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(163339);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ah(paramLayoutInflater, 2131493437);
        ((View)localObject).setTag(new n.a().H((View)localObject, false));
      }
      AppMethodBeat.o(163339);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(163340);
      this.JWz = parama1;
      paramString = (n.a)parama;
      paramString.Kyj.animate().cancel();
      paramString.Kyj.setTag(Long.valueOf(System.currentTimeMillis()));
      parama = parambv.field_content;
      if (parama != null) {}
      for (parama = k.b.aB(parama, parambv.field_reserved);; parama = null)
      {
        Object localObject;
        if (parama != null)
        {
          parama = (b)parama.ao(b.class);
          if (parama != null)
          {
            localObject = i.srW;
            localObject = i.cEo();
            com.tencent.mm.plugin.finder.loader.l locall = new com.tencent.mm.plugin.finder.loader.l(parama.ipW.ssR, r.sJv);
            ImageView localImageView = paramString.Kyc;
            i locali = i.srW;
            ((com.tencent.mm.loader.d)localObject).a(locall, localImageView, i.a(i.a.ssc));
            paramString.Kyd.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.ipW.nickname));
            al.a(paramString.Kyd.getPaint(), 0.8F);
            localObject = parama.ipW.mediaList;
            if (!((List)localObject).isEmpty())
            {
              ((t)g.ad(t.class)).loadImage(((arx)((List)localObject).get(0)).thumbUrl, paramString.Kye);
              n.a(paramString, (List)localObject);
            }
            if (parama.ipW.GIy != 1) {
              break label380;
            }
            paramString.Kyf.setVisibility(8);
            paramString.Kye.setVisibility(8);
            paramString.Kyg.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.ipW.desc));
            paramString.Kyg.setVisibility(0);
          }
        }
        for (;;)
        {
          paramString.olI.setOnClickListener(d(parama1));
          paramString.olI.setOnLongClickListener(c(parama1));
          paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
          paramString.olI.setTag(parama);
          AppMethodBeat.o(163340);
          return;
          label380:
          if (!bu.isNullOrNil(parama.ipW.desc))
          {
            paramString.Kyf.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.ipW.desc));
            paramString.Kyf.setVisibility(0);
          }
          for (;;)
          {
            paramString.Kye.setVisibility(0);
            paramString.Kyg.setVisibility(8);
            if ((parama.ipW.GIy != 4) && (parama.ipW.GIy != 6)) {
              break label504;
            }
            paramString.Kyi.setVisibility(0);
            paramString.Ahv.setVisibility(8);
            break;
            paramString.Kyf.setVisibility(8);
          }
          label504:
          if (parama.ipW.GIy == 2)
          {
            paramString.Kyi.setVisibility(8);
            paramString.Ahv.setVisibility(0);
            paramString.Ahv.ASU = ((List)localObject).size();
          }
          else
          {
            paramString.Kyi.setVisibility(8);
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163342);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163342);
        return false;
      }
      n.b(parama.Kkd.getContext(), parambv);
      AppMethodBeat.o(163342);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187739);
      int j = ((bk)paramView.getTag()).position;
      if (!((t)g.ad(t.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((parambv != null) && (com.tencent.mm.br.d.aJN("favorite")) && (i == 0))
        {
          paraml.a(j, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
          paraml.a(j, 116, this.JWz.Kkd.getMMResources().getString(2131761941), 2131690400);
        }
        AppMethodBeat.o(187739);
        return true;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163343);
      Object localObject2 = parambv.field_content;
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aB((String)localObject2, parambv.field_reserved);
      }
      if (localObject1 != null)
      {
        localObject1 = (b)((k.b)localObject1).ao(b.class);
        if (localObject1 != null)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ac.c.xQ(((b)localObject1).ipW.objectId));
          ((Intent)localObject2).putExtra("feed_object_nonceId", ((b)localObject1).ipW.objectNonceId);
          if (!x.wb(parambv.field_talker)) {
            break label204;
          }
          ((Intent)localObject2).putExtra("report_scene", 2);
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("from_user", parambv.field_talker);
        p localp = p.sXz;
        ((Intent)localObject2).putExtra("key_from_user_name", p.al(parambv));
        localp = p.sXz;
        ((Intent)localObject2).putExtra("key_to_user_name", p.am(parambv));
        ((Intent)localObject2).putExtra("tab_type", 6);
        n.a(paramView, parama, (b)localObject1, (Intent)localObject2, false, x.wb(parambv.field_talker));
        AppMethodBeat.o(163343);
        return false;
        label204:
        ((Intent)localObject2).putExtra("report_scene", 1);
      }
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 754974769);
    }
    
    public final boolean fLz()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(163344);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ah(paramLayoutInflater, 2131493481);
        ((View)localObject).setTag(new n.a().H((View)localObject, true));
      }
      AppMethodBeat.o(163344);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163346);
      if (parambv.cVH())
      {
        m.aF(parambv);
        bl.rW(parambv.field_msgId);
        parama.xY(true);
      }
      AppMethodBeat.o(163346);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(163345);
      this.JWz = parama1;
      paramString = (n.a)parama;
      paramString.Kyj.animate().cancel();
      paramString.Kyj.setTag(Long.valueOf(System.currentTimeMillis()));
      Object localObject = parambv.field_content;
      parama = null;
      if (localObject != null) {
        parama = k.b.aB((String)localObject, parambv.field_reserved);
      }
      if (parama != null)
      {
        parama = (b)parama.ao(b.class);
        if (parama != null)
        {
          localObject = i.srW;
          localObject = i.cEo();
          com.tencent.mm.plugin.finder.loader.l locall = new com.tencent.mm.plugin.finder.loader.l(parama.ipW.ssR, r.sJv);
          ImageView localImageView = paramString.Kyc;
          i locali = i.srW;
          ((com.tencent.mm.loader.d)localObject).a(locall, localImageView, i.a(i.a.ssc));
          paramString.Kyd.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.ipW.nickname));
          al.a(paramString.Kyd.getPaint(), 0.8F);
          localObject = parama.ipW.mediaList;
          if (!((List)localObject).isEmpty())
          {
            ((t)g.ad(t.class)).loadImage(((arx)((List)localObject).get(0)).thumbUrl, paramString.Kye);
            n.a(paramString, (List)localObject);
          }
          if (parama.ipW.GIy == 1)
          {
            paramString.Kyf.setVisibility(8);
            paramString.Kye.setVisibility(8);
            paramString.Kyg.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.ipW.desc));
            paramString.Kyg.setVisibility(0);
          }
        }
        else
        {
          paramString.olI.setOnClickListener(d(parama1));
          paramString.olI.setOnLongClickListener(c(parama1));
          paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
          paramString.olI.setTag(parama);
        }
      }
      else
      {
        if (!fLB()) {
          break label684;
        }
        if (paramString.xvJ != null) {
          paramString.xvJ.setVisibility(8);
        }
        if ((parambv.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv.field_msgId))) {
          break label663;
        }
        if (paramString.Kyb != null) {
          paramString.Kyb.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, paramString, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
        AppMethodBeat.o(163345);
        return;
        if (!bu.isNullOrNil(parama.ipW.desc))
        {
          paramString.Kyf.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.ipW.desc));
          paramString.Kyf.setVisibility(0);
        }
        for (;;)
        {
          paramString.Kye.setVisibility(0);
          paramString.Kyg.setVisibility(8);
          if ((parama.ipW.GIy != 4) && (parama.ipW.GIy != 6)) {
            break label602;
          }
          paramString.Kyi.setVisibility(0);
          paramString.Ahv.setVisibility(8);
          break;
          paramString.Kyf.setVisibility(8);
        }
        label602:
        if (parama.ipW.GIy == 2)
        {
          paramString.Kyi.setVisibility(8);
          paramString.Ahv.setVisibility(0);
          paramString.Ahv.ASU = ((List)localObject).size();
          break;
        }
        paramString.Kyi.setVisibility(8);
        break;
        label663:
        if (paramString.Kyb != null)
        {
          paramString.Kyb.setVisibility(8);
          continue;
          label684:
          if (paramString.Kyb != null) {
            paramString.Kyb.setVisibility(8);
          }
          if (parambv.field_status < 2) {
            bool = true;
          }
          b(paramString, bool);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163348);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163348);
        return false;
      }
      n.b(parama.Kkd.getContext(), parambv);
      AppMethodBeat.o(163348);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187740);
      int j = ((bk)paramView.getTag()).position;
      if (!((t)g.ad(t.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((parambv != null) && (i == 0))
        {
          paraml.a(j, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
          if (com.tencent.mm.br.d.aJN("favorite")) {
            paraml.a(j, 116, this.JWz.Kkd.getMMResources().getString(2131761941), 2131690400);
          }
          if (((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker)) && (!an.zd(this.JWz.getTalkerUserName()))) {
            paraml.a(j, 123, paramView.getContext().getString(2131757234), 2131690462);
          }
        }
        AppMethodBeat.o(187740);
        return true;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163349);
      Object localObject2 = parambv.field_content;
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aB((String)localObject2, parambv.field_reserved);
      }
      if (localObject1 != null)
      {
        localObject1 = (b)((k.b)localObject1).ao(b.class);
        if (localObject1 != null)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ac.c.xQ(((b)localObject1).ipW.objectId));
          ((Intent)localObject2).putExtra("feed_object_nonceId", ((b)localObject1).ipW.objectNonceId);
          if (!x.wb(parambv.field_talker)) {
            break label204;
          }
          ((Intent)localObject2).putExtra("report_scene", 2);
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("from_user", parambv.field_talker);
        p localp = p.sXz;
        ((Intent)localObject2).putExtra("key_from_user_name", p.al(parambv));
        localp = p.sXz;
        ((Intent)localObject2).putExtra("key_to_user_name", p.am(parambv));
        ((Intent)localObject2).putExtra("tab_type", 6);
        n.a(paramView, parama, (b)localObject1, (Intent)localObject2, true, x.wb(parambv.field_talker));
        AppMethodBeat.o(163349);
        return false;
        label204:
        ((Intent)localObject2).putExtra("report_scene", 1);
      }
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 754974769);
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n
 * JD-Core Version:    0.7.0.1
 */