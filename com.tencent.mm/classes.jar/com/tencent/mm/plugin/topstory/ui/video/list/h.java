package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public final class h
  extends com.tencent.mm.plugin.topstory.ui.video.h
  implements a
{
  public TextView Ddd;
  public MMNeat7extView HyV;
  public ImageView MZm;
  public View NbA;
  public TextView NbB;
  public TextView NbC;
  public ImageView NbD;
  public ImageView NbE;
  public View NbF;
  public FrameLayout NbL;
  public TextView Nbt;
  public View Nby;
  public View Nbz;
  public com.tencent.mm.plugin.topstory.ui.video.f NcB;
  public View NcC;
  public ImageView NcD;
  public View NcE;
  public View NcF;
  public View NcG;
  public TextView NcH;
  public View NcI;
  public TextView NcJ;
  public ImageView NcK;
  private boolean NcL;
  public View Nci;
  public View Ncj;
  public View sBm;
  public View vgv;
  
  public h(View paramView, b paramb, boolean paramBoolean)
  {
    super(paramView, paramb);
    this.NcL = paramBoolean;
  }
  
  public final void Ah(boolean paramBoolean)
  {
    AppMethodBeat.i(126494);
    super.Ah(paramBoolean);
    grS();
    this.MZd.ajB(gqw());
    if (this.NcB.aL(paramBoolean, false))
    {
      gqv();
      super.gqu();
    }
    AppMethodBeat.o(126494);
  }
  
  public final void dCA()
  {
    AppMethodBeat.i(126489);
    Log.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.NcG.animate().cancel();
    this.NcF.animate().cancel();
    this.NcE.animate().cancel();
    this.NcE.setAlpha(0.8F);
    this.NcG.setAlpha(0.8F);
    this.NcF.setAlpha(0.8F);
    AppMethodBeat.o(126489);
  }
  
  public final View getWowView()
  {
    return this.NcC;
  }
  
  public final void gqu()
  {
    AppMethodBeat.i(126492);
    super.gqu();
    AppMethodBeat.o(126492);
  }
  
  public final void gqv()
  {
    AppMethodBeat.i(126491);
    super.gqv();
    this.NcG.animate().cancel();
    this.NcF.animate().cancel();
    this.NcG.setAlpha(0.0F);
    this.NcF.setAlpha(0.0F);
    AppMethodBeat.o(126491);
  }
  
  public final void grS()
  {
    AppMethodBeat.i(126490);
    Log.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.NcG.animate().cancel();
    this.NcF.animate().cancel();
    this.NcE.animate().cancel();
    this.NcE.setAlpha(0.0F);
    this.NcG.setAlpha(0.0F);
    this.NcF.setAlpha(0.0F);
    AppMethodBeat.o(126490);
  }
  
  public final boolean grh()
  {
    AppMethodBeat.i(126493);
    if ((this.NcG.getAlpha() != 0.0F) && (this.NcF.getAlpha() != 0.0F))
    {
      AppMethodBeat.o(126493);
      return true;
    }
    AppMethodBeat.o(126493);
    return false;
  }
  
  public final void gri()
  {
    AppMethodBeat.i(126495);
    if (!Util.isNullOrNil(this.MWs.title))
    {
      this.HyV.aL(this.MWs.title);
      this.HyV.setVisibility(0);
      this.HyV.requestLayout();
      this.HyV.setOnClickListener(this.bwV);
      this.Ddd.setText(this.MWs.source);
      if (!n.i(this.MWs)) {
        break label964;
      }
      this.NbF.setVisibility(0);
      label90:
      this.MZm.setOnClickListener(this.bwV);
      this.Ddd.setOnClickListener(this.bwV);
      this.NbF.setOnClickListener(this.bwV);
      if (Util.isNullOrNil(this.MWs.TIg)) {
        break label976;
      }
      q.bml().a(this.MWs.TIg, this.MZm, d.MWF);
      label156:
      if (!this.MZd.gqF()) {
        break label989;
      }
      this.vgv.setVisibility(0);
      this.vgv.setOnClickListener(this.bwV);
      label187:
      if (!this.MZd.gqG()) {
        break label1001;
      }
      this.Nci.setTag(this.MWs);
      this.Nci.setOnClickListener(this.bwV);
      this.Nci.setVisibility(0);
      this.Ncj.setVisibility(0);
      label237:
      this.Nci.setTag(this.MWs);
      this.Nci.setOnClickListener(this.bwV);
      this.sBm.setOnClickListener(this.bwV);
      this.NcE.setVisibility(0);
      this.NcF.setVisibility(0);
      this.NcG.setVisibility(0);
      if (this.NcB == null)
      {
        this.NcB = new f(this.MZd.eOa(), this.MZd, this);
        this.NbL.removeAllViews();
        localObject = this.NbL;
        com.tencent.mm.plugin.topstory.ui.video.f localf = this.NcB;
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", new Object[] { Integer.valueOf(this.MZd.getVideoWidth()), Integer.valueOf(this.MZd.getVideoHeight()) });
        ((FrameLayout)localObject).addView(localf, new FrameLayout.LayoutParams(this.MZd.getVideoWidth(), this.MZd.getVideoHeight()));
      }
      this.NcB.a(this.MWs, gqw());
      if (this.MZd.gqE() == gqw()) {
        super.gqu();
      }
      this.NcH.setText(this.MWs.CHR);
      if ((!this.NcL) || (this.MWs.Crg.size() <= 0)) {
        break label1064;
      }
      this.Nby.setVisibility(0);
      Object localObject = (eij)this.MWs.Crg.get(0);
      this.NbB.setTag(localObject);
      this.NbB.setText(((eij)localObject).wording);
      this.NbB.setVisibility(0);
      this.NbB.setOnClickListener(this.bwV);
      this.Nbz.setVisibility(0);
      this.NbD.setVisibility(8);
      if (!Util.isNullOrNil(((eij)localObject).icon))
      {
        q.bml().a(((eij)localObject).icon, this.NbD, d.MWG);
        this.NbD.setVisibility(0);
      }
      if (this.MWs.Crg.size() <= 1) {
        break label1022;
      }
      localObject = (eij)this.MWs.Crg.get(1);
      this.NbC.setTag(localObject);
      this.NbC.setText(((eij)localObject).wording);
      this.NbC.setOnClickListener(this.bwV);
      this.NbC.setVisibility(0);
      this.NbA.setVisibility(0);
      this.NbE.setVisibility(8);
      if (!Util.isNullOrNil(((eij)localObject).icon))
      {
        q.bml().a(((eij)localObject).icon, this.NbE, d.MWG);
        this.NbE.setVisibility(0);
      }
      label717:
      if (this.MWs.Crg.size() <= 2) {
        break label1043;
      }
      localObject = (eij)this.MWs.Crg.get(2);
      this.NcJ.setTag(localObject);
      this.NcJ.setText(((eij)localObject).wording);
      this.NcJ.setOnClickListener(this.bwV);
      this.NcJ.setVisibility(0);
      this.NcI.setVisibility(0);
      this.NcK.setVisibility(8);
      if (!Util.isNullOrNil(((eij)localObject).icon))
      {
        q.bml().a(((eij)localObject).icon, this.NcK, d.MWG);
        this.NcK.setVisibility(0);
      }
      label836:
      if (this.MZd.gqE() != gqw()) {
        dCA();
      }
      if ((this.MWs.Uvd & 0x80) <= 0) {
        break label1109;
      }
      this.NcC.setVisibility(0);
      this.NcC.setOnClickListener(this.bwV);
      if (!this.MWs.Uvi) {
        break label1076;
      }
      this.NcD.setImageResource(c.f.top_story_wow_selected);
      this.Nbt.setTextColor(this.Nbt.getResources().getColor(c.a.top_story_wow_like));
    }
    for (;;)
    {
      this.Nbt.setText(d.ajw(this.MWs.Uvm));
      AppMethodBeat.o(126495);
      return;
      this.HyV.setVisibility(8);
      break;
      label964:
      this.NbF.setVisibility(8);
      break label90;
      label976:
      this.MZm.setImageResource(c.c.default_avatar);
      break label156;
      label989:
      this.vgv.setVisibility(8);
      break label187;
      label1001:
      this.Nci.setVisibility(8);
      this.Ncj.setVisibility(8);
      break label237;
      label1022:
      this.NbA.setVisibility(8);
      this.NbC.setVisibility(8);
      break label717;
      label1043:
      this.NcI.setVisibility(8);
      this.NcJ.setVisibility(8);
      break label836;
      label1064:
      this.Nby.setVisibility(8);
      break label836;
      label1076:
      this.NcD.setImageResource(c.f.top_story_wow_unselected);
      this.Nbt.setTextColor(this.Nbt.getResources().getColor(c.a.white_text_color));
    }
    label1109:
    this.NcC.setVisibility(8);
    AppMethodBeat.o(126495);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f grj()
  {
    return this.NcB;
  }
  
  public final void hd(View paramView)
  {
    AppMethodBeat.i(126488);
    super.hd(paramView);
    this.NbL = ((FrameLayout)paramView.findViewById(c.d.video_view_container));
    this.MZm = ((ImageView)paramView.findViewById(c.d.source_iv));
    this.Ddd = ((TextView)paramView.findViewById(c.d.source_tv));
    this.HyV = ((MMNeat7extView)paramView.findViewById(c.d.title_tv));
    this.NbF = paramView.findViewById(c.d.source_arrow);
    this.vgv = paramView.findViewById(c.d.share_iv);
    this.NcC = paramView.findViewById(c.d.wow_iv);
    this.NcD = ((ImageView)paramView.findViewById(c.d.wow_icon_view));
    this.Nbt = ((TextView)paramView.findViewById(c.d.wow_icon_text));
    this.Ncj = paramView.findViewById(c.d.more_divider);
    this.Nci = paramView.findViewById(c.d.more_iv);
    this.Nby = paramView.findViewById(c.d.bottom_tag_layout);
    this.NcH = ((TextView)paramView.findViewById(c.d.bottom_desc_tv));
    this.Nbz = paramView.findViewById(c.d.tag_1_ll);
    this.NbA = paramView.findViewById(c.d.tag_2_ll);
    this.NcI = paramView.findViewById(c.d.tag_3_ll);
    this.NbB = ((TextView)paramView.findViewById(c.d.tag_1_tv));
    this.NbC = ((TextView)paramView.findViewById(c.d.tag_2_tv));
    this.NcJ = ((TextView)paramView.findViewById(c.d.tag_3_tv));
    this.NbD = ((ImageView)paramView.findViewById(c.d.tag_1_icon));
    this.NbE = ((ImageView)paramView.findViewById(c.d.tag_2_icon));
    this.NcK = ((ImageView)paramView.findViewById(c.d.tag_3_icon));
    this.NcE = paramView.findViewById(c.d.body_mask);
    this.NcF = paramView.findViewById(c.d.header_mask);
    this.NcG = paramView.findViewById(c.d.footer_mask);
    this.sBm = paramView.findViewById(c.d.footer_layout);
    if (this.NcL)
    {
      this.Nby.setVisibility(0);
      AppMethodBeat.o(126488);
      return;
    }
    this.Nby.setVisibility(8);
    AppMethodBeat.o(126488);
  }
  
  public final void he(View paramView)
  {
    AppMethodBeat.i(126496);
    if ((com.tencent.mm.plugin.topstory.a.h.gpM()) && (paramView.getId() == this.HyV.getId())) {
      this.MZd.gqC().NaO = true;
    }
    super.he(paramView);
    AppMethodBeat.o(126496);
  }
  
  public final void hf(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(126497);
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == this.HyV.getId())
    {
      if ((this.MWs != null) && (!Util.isNullOrNil(this.MWs.PyZ)))
      {
        paramView = this.MWs.PyZ;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        c.b(this.MZd.eOa(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject1);
        if (this.MZd.gqC().NaM)
        {
          this.NcB.cEI();
          this.MZd.gqC().dmi();
        }
        this.MZd.gqy().k(this.MWs);
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.MZd.gqA(), this.MWs, gqw(), 1, "");
        AppMethodBeat.o(126497);
      }
    }
    else
    {
      if (paramView.getId() == this.vgv.getId())
      {
        com.tencent.mm.plugin.websearch.api.a.a.rE(8);
        a(this.MZd, this.MZd.eOa(), this.NcB, gqw());
        AppMethodBeat.o(126497);
        return;
      }
      if (paramView.getId() == this.Nci.getId())
      {
        this.MZd.aD(this.Nci, gqw());
        AppMethodBeat.o(126497);
        return;
      }
      if ((paramView.getId() == this.NbB.getId()) || (paramView.getId() == this.NbC.getId()))
      {
        this.MZd.gqx().Nah = true;
        this.MZd.gqC().stopPlay();
        this.NcB.gqX();
        paramView = (eij)paramView.getTag();
        localObject1 = com.tencent.mm.plugin.topstory.a.h.a(this.MZd.gqA());
        ((esv)localObject1).wmL = UUID.randomUUID().toString();
        ((esv)localObject1).UuD = this.MWs.Crh;
        ((esv)localObject1).UuH = paramView.Ukr;
        ((esv)localObject1).UuI = null;
        ((esv)localObject1).UuJ = paramView;
        ((esv)localObject1).iYs = this.MZd.aeg();
        ((esv)localObject1).UuK = this.MZd.gqx().Nah;
        localObject2 = ((esv)localObject1).Pye.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          aci localaci = (aci)((Iterator)localObject2).next();
          if ("show_tag_list".equals(localaci.key)) {
            localaci.SnW = paramView.id;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new aci();
        ((aci)localObject2).key = "show_tag_list";
        ((aci)localObject2).SnW = paramView.id;
        ((esv)localObject1).Pye.add(localObject2);
      }
      ai.a(this.MZd.eOa(), (esv)localObject1, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.rE(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.MZd.gqA(), this.MWs, gqw(), 4, paramView.wording + ":" + paramView.id);
      AppMethodBeat.o(126497);
      return;
      if ((paramView.getId() == this.MZm.getId()) || (paramView.getId() == this.Ddd.getId()) || (paramView.getId() == this.NbF.getId()))
      {
        if (n.a(this.MWs, this.MZd.eOa()))
        {
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.MZd.gqA(), this.MWs, gqw(), 3, "");
          AppMethodBeat.o(126497);
        }
      }
      else if (paramView.getId() == this.NcC.getId())
      {
        this.MZd.a(this.MWs, paramView);
        if (this.MWs.Uvi)
        {
          this.NcD.setImageResource(c.f.top_story_wow_selected);
          this.Nbt.setTextColor(this.Nbt.getResources().getColor(c.a.top_story_wow_like));
          AppMethodBeat.o(126497);
          return;
        }
        this.NcD.setImageResource(c.f.top_story_wow_unselected);
        this.Nbt.setTextColor(this.Nbt.getResources().getColor(c.a.white_text_color));
      }
      AppMethodBeat.o(126497);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.h
 * JD-Core Version:    0.7.0.1
 */