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
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public final class h
  extends com.tencent.mm.plugin.topstory.ui.video.h
  implements a
{
  public TextView IXv;
  public ImageView TLV;
  public View TOS;
  public View TOT;
  public TextView TOc;
  public View TOh;
  public View TOi;
  public View TOj;
  public TextView TOk;
  public TextView TOl;
  public ImageView TOm;
  public ImageView TOn;
  public View TOo;
  public FrameLayout TOu;
  public com.tencent.mm.plugin.topstory.ui.video.f TPl;
  public View TPm;
  public ImageView TPn;
  public View TPo;
  public View TPp;
  public View TPq;
  public TextView TPr;
  public View TPs;
  public TextView TPt;
  public ImageView TPu;
  private boolean TPv;
  public TextView titleTv;
  public View uiE;
  public View ysv;
  
  public h(View paramView, b paramb, boolean paramBoolean)
  {
    super(paramView, paramb);
    this.TPv = paramBoolean;
  }
  
  public final void FD(boolean paramBoolean)
  {
    AppMethodBeat.i(126494);
    super.FD(paramBoolean);
    hOT();
    this.TLM.aoU(hNv());
    if (this.TPl.bi(paramBoolean, false))
    {
      hNu();
      super.hNt();
    }
    AppMethodBeat.o(126494);
  }
  
  public final void esa()
  {
    AppMethodBeat.i(126489);
    Log.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.TPq.animate().cancel();
    this.TPp.animate().cancel();
    this.TPo.animate().cancel();
    this.TPo.setAlpha(0.8F);
    this.TPq.setAlpha(0.8F);
    this.TPp.setAlpha(0.8F);
    AppMethodBeat.o(126489);
  }
  
  public final View getWowView()
  {
    return this.TPm;
  }
  
  public final void hNt()
  {
    AppMethodBeat.i(126492);
    super.hNt();
    AppMethodBeat.o(126492);
  }
  
  public final void hNu()
  {
    AppMethodBeat.i(126491);
    super.hNu();
    this.TPq.animate().cancel();
    this.TPp.animate().cancel();
    this.TPq.setAlpha(0.0F);
    this.TPp.setAlpha(0.0F);
    AppMethodBeat.o(126491);
  }
  
  public final void hOT()
  {
    AppMethodBeat.i(126490);
    Log.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.TPq.animate().cancel();
    this.TPp.animate().cancel();
    this.TPo.animate().cancel();
    this.TPo.setAlpha(0.0F);
    this.TPq.setAlpha(0.0F);
    this.TPp.setAlpha(0.0F);
    AppMethodBeat.o(126490);
  }
  
  public final boolean hOg()
  {
    AppMethodBeat.i(126493);
    if ((this.TPq.getAlpha() != 0.0F) && (this.TPp.getAlpha() != 0.0F))
    {
      AppMethodBeat.o(126493);
      return true;
    }
    AppMethodBeat.o(126493);
    return false;
  }
  
  public final void hOh()
  {
    AppMethodBeat.i(126495);
    if (!Util.isNullOrNil(this.TIW.title))
    {
      this.titleTv.setText(this.TIW.title);
      this.titleTv.setVisibility(0);
      this.titleTv.requestLayout();
      this.titleTv.setOnClickListener(this.dpY);
      this.IXv.setText(this.TIW.source);
      if (!n.i(this.TIW)) {
        break label964;
      }
      this.TOo.setVisibility(0);
      label90:
      this.TLV.setOnClickListener(this.dpY);
      this.IXv.setOnClickListener(this.dpY);
      this.TOo.setOnClickListener(this.dpY);
      if (Util.isNullOrNil(this.TIW.aaXP)) {
        break label976;
      }
      com.tencent.mm.modelimage.r.bKe().a(this.TIW.aaXP, this.TLV, d.TJj);
      label156:
      if (!this.TLM.hNE()) {
        break label989;
      }
      this.ysv.setVisibility(0);
      this.ysv.setOnClickListener(this.dpY);
      label187:
      if (!this.TLM.hNF()) {
        break label1001;
      }
      this.TOS.setTag(this.TIW);
      this.TOS.setOnClickListener(this.dpY);
      this.TOS.setVisibility(0);
      this.TOT.setVisibility(0);
      label237:
      this.TOS.setTag(this.TIW);
      this.TOS.setOnClickListener(this.dpY);
      this.uiE.setOnClickListener(this.dpY);
      this.TPo.setVisibility(0);
      this.TPp.setVisibility(0);
      this.TPq.setVisibility(0);
      if (this.TPl == null)
      {
        this.TPl = new f(this.TLM.fWt(), this.TLM, this);
        this.TOu.removeAllViews();
        localObject = this.TOu;
        com.tencent.mm.plugin.topstory.ui.video.f localf = this.TPl;
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", new Object[] { Integer.valueOf(this.TLM.getVideoWidth()), Integer.valueOf(this.TLM.getVideoHeight()) });
        ((FrameLayout)localObject).addView(localf, new FrameLayout.LayoutParams(this.TLM.getVideoWidth(), this.TLM.getVideoHeight()));
      }
      this.TPl.a(this.TIW, hNv());
      if (this.TLM.hND() == hNv()) {
        super.hNt();
      }
      this.TPr.setText(this.TIW.ICb);
      if ((!this.TPv) || (this.TIW.Idn.size() <= 0)) {
        break label1064;
      }
      this.TOh.setVisibility(0);
      Object localObject = (fcl)this.TIW.Idn.get(0);
      this.TOk.setTag(localObject);
      this.TOk.setText(((fcl)localObject).wording);
      this.TOk.setVisibility(0);
      this.TOk.setOnClickListener(this.dpY);
      this.TOi.setVisibility(0);
      this.TOm.setVisibility(8);
      if (!Util.isNullOrNil(((fcl)localObject).icon))
      {
        com.tencent.mm.modelimage.r.bKe().a(((fcl)localObject).icon, this.TOm, d.TJk);
        this.TOm.setVisibility(0);
      }
      if (this.TIW.Idn.size() <= 1) {
        break label1022;
      }
      localObject = (fcl)this.TIW.Idn.get(1);
      this.TOl.setTag(localObject);
      this.TOl.setText(((fcl)localObject).wording);
      this.TOl.setOnClickListener(this.dpY);
      this.TOl.setVisibility(0);
      this.TOj.setVisibility(0);
      this.TOn.setVisibility(8);
      if (!Util.isNullOrNil(((fcl)localObject).icon))
      {
        com.tencent.mm.modelimage.r.bKe().a(((fcl)localObject).icon, this.TOn, d.TJk);
        this.TOn.setVisibility(0);
      }
      label717:
      if (this.TIW.Idn.size() <= 2) {
        break label1043;
      }
      localObject = (fcl)this.TIW.Idn.get(2);
      this.TPt.setTag(localObject);
      this.TPt.setText(((fcl)localObject).wording);
      this.TPt.setOnClickListener(this.dpY);
      this.TPt.setVisibility(0);
      this.TPs.setVisibility(0);
      this.TPu.setVisibility(8);
      if (!Util.isNullOrNil(((fcl)localObject).icon))
      {
        com.tencent.mm.modelimage.r.bKe().a(((fcl)localObject).icon, this.TPu, d.TJk);
        this.TPu.setVisibility(0);
      }
      label836:
      if (this.TLM.hND() != hNv()) {
        esa();
      }
      if ((this.TIW.abOE & 0x80) <= 0) {
        break label1109;
      }
      this.TPm.setVisibility(0);
      this.TPm.setOnClickListener(this.dpY);
      if (!this.TIW.abOJ) {
        break label1076;
      }
      this.TPn.setImageResource(c.f.top_story_wow_selected);
      this.TOc.setTextColor(this.TOc.getResources().getColor(c.a.top_story_wow_like));
    }
    for (;;)
    {
      this.TOc.setText(d.aoN(this.TIW.abON));
      AppMethodBeat.o(126495);
      return;
      this.titleTv.setVisibility(8);
      break;
      label964:
      this.TOo.setVisibility(8);
      break label90;
      label976:
      this.TLV.setImageResource(c.c.default_avatar);
      break label156;
      label989:
      this.ysv.setVisibility(8);
      break label187;
      label1001:
      this.TOS.setVisibility(8);
      this.TOT.setVisibility(8);
      break label237;
      label1022:
      this.TOj.setVisibility(8);
      this.TOl.setVisibility(8);
      break label717;
      label1043:
      this.TPs.setVisibility(8);
      this.TPt.setVisibility(8);
      break label836;
      label1064:
      this.TOh.setVisibility(8);
      break label836;
      label1076:
      this.TPn.setImageResource(c.f.top_story_wow_unselected);
      this.TOc.setTextColor(this.TOc.getResources().getColor(c.a.white_text_color));
    }
    label1109:
    this.TPm.setVisibility(8);
    AppMethodBeat.o(126495);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f hOi()
  {
    return this.TPl;
  }
  
  public final void ko(View paramView)
  {
    AppMethodBeat.i(126488);
    super.ko(paramView);
    this.TOu = ((FrameLayout)paramView.findViewById(c.d.video_view_container));
    this.TLV = ((ImageView)paramView.findViewById(c.d.source_iv));
    this.IXv = ((TextView)paramView.findViewById(c.d.source_tv));
    this.titleTv = ((TextView)paramView.findViewById(c.d.title_tv));
    this.TOo = paramView.findViewById(c.d.source_arrow);
    this.ysv = paramView.findViewById(c.d.share_iv);
    this.TPm = paramView.findViewById(c.d.wow_iv);
    this.TPn = ((ImageView)paramView.findViewById(c.d.wow_icon_view));
    this.TOc = ((TextView)paramView.findViewById(c.d.wow_icon_text));
    this.TOT = paramView.findViewById(c.d.more_divider);
    this.TOS = paramView.findViewById(c.d.more_iv);
    this.TOh = paramView.findViewById(c.d.bottom_tag_layout);
    this.TPr = ((TextView)paramView.findViewById(c.d.bottom_desc_tv));
    this.TOi = paramView.findViewById(c.d.tag_1_ll);
    this.TOj = paramView.findViewById(c.d.tag_2_ll);
    this.TPs = paramView.findViewById(c.d.tag_3_ll);
    this.TOk = ((TextView)paramView.findViewById(c.d.tag_1_tv));
    this.TOl = ((TextView)paramView.findViewById(c.d.tag_2_tv));
    this.TPt = ((TextView)paramView.findViewById(c.d.tag_3_tv));
    this.TOm = ((ImageView)paramView.findViewById(c.d.tag_1_icon));
    this.TOn = ((ImageView)paramView.findViewById(c.d.tag_2_icon));
    this.TPu = ((ImageView)paramView.findViewById(c.d.tag_3_icon));
    this.TPo = paramView.findViewById(c.d.body_mask);
    this.TPp = paramView.findViewById(c.d.header_mask);
    this.TPq = paramView.findViewById(c.d.footer_mask);
    this.uiE = paramView.findViewById(c.d.footer_layout);
    if (this.TPv)
    {
      this.TOh.setVisibility(0);
      AppMethodBeat.o(126488);
      return;
    }
    this.TOh.setVisibility(8);
    AppMethodBeat.o(126488);
  }
  
  public final void kp(View paramView)
  {
    AppMethodBeat.i(126496);
    if ((g.hMI()) && (paramView.getId() == this.titleTv.getId())) {
      this.TLM.hNB().TNx = true;
    }
    super.kp(paramView);
    AppMethodBeat.o(126496);
  }
  
  public final void kq(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(126497);
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == this.titleTv.getId())
    {
      if ((this.TIW != null) && (!Util.isNullOrNil(this.TIW.Wpi)))
      {
        paramView = this.TIW.Wpi;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        c.b(this.TLM.fWt(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject1);
        if (this.TLM.hNB().TNv)
        {
          this.TPl.hOb();
          this.TLM.hNB().bck();
        }
        this.TLM.hNx().k(this.TIW);
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.TLM.hNz(), this.TIW, hNv(), 1, "");
        AppMethodBeat.o(126497);
      }
    }
    else
    {
      if (paramView.getId() == this.ysv.getId())
      {
        com.tencent.mm.plugin.websearch.api.a.a.rG(8);
        a(this.TLM, this.TLM.fWt(), this.TPl, hNv());
        AppMethodBeat.o(126497);
        return;
      }
      if (paramView.getId() == this.TOS.getId())
      {
        this.TLM.aZ(this.TOS, hNv());
        AppMethodBeat.o(126497);
        return;
      }
      if ((paramView.getId() == this.TOk.getId()) || (paramView.getId() == this.TOl.getId()))
      {
        this.TLM.hNw().TMQ = true;
        this.TLM.hNB().stopPlay();
        this.TPl.hNV();
        paramView = (fcl)paramView.getTag();
        localObject1 = g.a(this.TLM.hNz());
        ((foe)localObject1).zIO = UUID.randomUUID().toString();
        ((foe)localObject1).abOf = this.TIW.Ido;
        ((foe)localObject1).abOj = paramView.abCa;
        ((foe)localObject1).abOk = null;
        ((foe)localObject1).abOl = paramView;
        ((foe)localObject1).lAj = this.TLM.aGe();
        ((foe)localObject1).abOm = this.TLM.hNw().TMQ;
        localObject2 = ((foe)localObject1).Wol.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          aem localaem = (aem)((Iterator)localObject2).next();
          if ("show_tag_list".equals(localaem.key)) {
            localaem.Zmy = paramView.id;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new aem();
        ((aem)localObject2).key = "show_tag_list";
        ((aem)localObject2).Zmy = paramView.id;
        ((foe)localObject1).Wol.add(localObject2);
      }
      aj.a(this.TLM.fWt(), (foe)localObject1, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.rG(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.TLM.hNz(), this.TIW, hNv(), 4, paramView.wording + ":" + paramView.id);
      AppMethodBeat.o(126497);
      return;
      if ((paramView.getId() == this.TLV.getId()) || (paramView.getId() == this.IXv.getId()) || (paramView.getId() == this.TOo.getId()))
      {
        if (n.a(this.TIW, this.TLM.fWt()))
        {
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.TLM.hNz(), this.TIW, hNv(), 3, "");
          AppMethodBeat.o(126497);
        }
      }
      else if (paramView.getId() == this.TPm.getId())
      {
        this.TLM.a(this.TIW, paramView);
        if (this.TIW.abOJ)
        {
          this.TPn.setImageResource(c.f.top_story_wow_selected);
          this.TOc.setTextColor(this.TOc.getResources().getColor(c.a.top_story_wow_like));
          AppMethodBeat.o(126497);
          return;
        }
        this.TPn.setImageResource(c.f.top_story_wow_unselected);
        this.TOc.setTextColor(this.TOc.getResources().getColor(c.a.white_text_color));
      }
      AppMethodBeat.o(126497);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.h
 * JD-Core Version:    0.7.0.1
 */