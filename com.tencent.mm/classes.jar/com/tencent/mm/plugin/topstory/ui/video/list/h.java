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
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
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
  public ImageView GmA;
  public TextView GoH;
  public View GoM;
  public View GoN;
  public View GoO;
  public TextView GoP;
  public TextView GoQ;
  public ImageView GoR;
  public ImageView GoS;
  public View GoT;
  public FrameLayout GoZ;
  public com.tencent.mm.plugin.topstory.ui.video.f GpP;
  public View GpQ;
  public ImageView GpR;
  public View GpS;
  public View GpT;
  public View GpU;
  public TextView GpV;
  public View GpW;
  public TextView GpX;
  public ImageView GpY;
  private boolean GpZ;
  public View Gpw;
  public View Gpx;
  public MMNeat7extView pIO;
  public View psf;
  public View rAO;
  public TextView xYx;
  
  public h(View paramView, b paramb, boolean paramBoolean)
  {
    super(paramView, paramb);
    this.GpZ = paramBoolean;
  }
  
  public final void dhM()
  {
    AppMethodBeat.i(126489);
    Log.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.GpU.animate().cancel();
    this.GpT.animate().cancel();
    this.GpS.animate().cancel();
    this.GpS.setAlpha(0.8F);
    this.GpU.setAlpha(0.8F);
    this.GpT.setAlpha(0.8F);
    AppMethodBeat.o(126489);
  }
  
  public final void fU(View paramView)
  {
    AppMethodBeat.i(126488);
    super.fU(paramView);
    this.GoZ = ((FrameLayout)paramView.findViewById(2131309842));
    this.GmA = ((ImageView)paramView.findViewById(2131308308));
    this.xYx = ((TextView)paramView.findViewById(2131308313));
    this.pIO = ((MMNeat7extView)paramView.findViewById(2131309249));
    this.GoT = paramView.findViewById(2131308307);
    this.rAO = paramView.findViewById(2131307810);
    this.GpQ = paramView.findViewById(2131310543);
    this.GpR = ((ImageView)paramView.findViewById(2131310542));
    this.GoH = ((TextView)paramView.findViewById(2131310541));
    this.Gpx = paramView.findViewById(2131304874);
    this.Gpw = paramView.findViewById(2131304887);
    this.GoM = paramView.findViewById(2131297709);
    this.GpV = ((TextView)paramView.findViewById(2131297674));
    this.GoN = paramView.findViewById(2131308853);
    this.GoO = paramView.findViewById(2131308857);
    this.GpW = paramView.findViewById(2131308861);
    this.GoP = ((TextView)paramView.findViewById(2131308854));
    this.GoQ = ((TextView)paramView.findViewById(2131308858));
    this.GpX = ((TextView)paramView.findViewById(2131308862));
    this.GoR = ((ImageView)paramView.findViewById(2131308852));
    this.GoS = ((ImageView)paramView.findViewById(2131308856));
    this.GpY = ((ImageView)paramView.findViewById(2131308860));
    this.GpS = paramView.findViewById(2131297650);
    this.GpT = paramView.findViewById(2131302297);
    this.GpU = paramView.findViewById(2131301673);
    this.psf = paramView.findViewById(2131301669);
    if (this.GpZ)
    {
      this.GoM.setVisibility(0);
      AppMethodBeat.o(126488);
      return;
    }
    this.GoM.setVisibility(8);
    AppMethodBeat.o(126488);
  }
  
  public final void fV(View paramView)
  {
    AppMethodBeat.i(126496);
    if ((com.tencent.mm.plugin.topstory.a.h.fxR()) && (paramView.getId() == this.pIO.getId())) {
      this.Gmr.fyF().Gob = true;
    }
    super.fV(paramView);
    AppMethodBeat.o(126496);
  }
  
  public final void fW(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(126497);
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == this.pIO.getId())
    {
      if ((this.GjH != null) && (!Util.isNullOrNil(this.GjH.IEH)))
      {
        paramView = this.GjH.IEH;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        com.tencent.mm.br.c.b(this.Gmr.eeF(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject1);
        if (this.Gmr.fyF().GnZ)
        {
          this.GpP.crC();
          this.Gmr.fyF().cXa();
        }
        this.Gmr.fyB().k(this.GjH);
        ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Gmr.fyD(), this.GjH, fyz(), 1, "");
        AppMethodBeat.o(126497);
      }
    }
    else
    {
      if (paramView.getId() == this.rAO.getId())
      {
        com.tencent.mm.plugin.websearch.api.a.a.pl(8);
        a(this.Gmr, this.Gmr.eeF(), this.GpP, fyz());
        AppMethodBeat.o(126497);
        return;
      }
      if (paramView.getId() == this.Gpw.getId())
      {
        this.Gmr.ay(this.Gpw, fyz());
        AppMethodBeat.o(126497);
        return;
      }
      if ((paramView.getId() == this.GoP.getId()) || (paramView.getId() == this.GoQ.getId()))
      {
        this.Gmr.fyA().Gnu = true;
        this.Gmr.fyF().stopPlay();
        this.GpP.fyY();
        paramView = (dyi)paramView.getTag();
        localObject1 = com.tencent.mm.plugin.topstory.a.h.a(this.Gmr.fyD());
        ((eit)localObject1).sGQ = UUID.randomUUID().toString();
        ((eit)localObject1).NhX = this.GjH.psI;
        ((eit)localObject1).Nib = paramView.MXW;
        ((eit)localObject1).Nic = null;
        ((eit)localObject1).Nid = paramView;
        ((eit)localObject1).guh = this.Gmr.Zx();
        ((eit)localObject1).Nie = this.Gmr.fyA().Gnu;
        localObject2 = ((eit)localObject1).IDO.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          aca localaca = (aca)((Iterator)localObject2).next();
          if ("show_tag_list".equals(localaca.key)) {
            localaca.LmD = paramView.id;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new aca();
        ((aca)localObject2).key = "show_tag_list";
        ((aca)localObject2).LmD = paramView.id;
        ((eit)localObject1).IDO.add(localObject2);
      }
      ai.a(this.Gmr.eeF(), (eit)localObject1, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.pl(28);
      ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Gmr.fyD(), this.GjH, fyz(), 4, paramView.dQx + ":" + paramView.id);
      AppMethodBeat.o(126497);
      return;
      if ((paramView.getId() == this.GmA.getId()) || (paramView.getId() == this.xYx.getId()) || (paramView.getId() == this.GoT.getId()))
      {
        if (n.a(this.GjH, this.Gmr.eeF()))
        {
          ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Gmr.fyD(), this.GjH, fyz(), 3, "");
          AppMethodBeat.o(126497);
        }
      }
      else if (paramView.getId() == this.GpQ.getId())
      {
        this.Gmr.a(this.GjH, paramView);
        if (this.GjH.NiC)
        {
          this.GpR.setImageResource(2131691661);
          this.GoH.setTextColor(this.GoH.getResources().getColor(2131101284));
          AppMethodBeat.o(126497);
          return;
        }
        this.GpR.setImageResource(2131691662);
        this.GoH.setTextColor(this.GoH.getResources().getColor(2131101427));
      }
      AppMethodBeat.o(126497);
      return;
      i = 0;
    }
  }
  
  public final void fyx()
  {
    AppMethodBeat.i(126492);
    super.fyx();
    AppMethodBeat.o(126492);
  }
  
  public final void fyy()
  {
    AppMethodBeat.i(126491);
    super.fyy();
    this.GpU.animate().cancel();
    this.GpT.animate().cancel();
    this.GpU.setAlpha(0.0F);
    this.GpT.setAlpha(0.0F);
    AppMethodBeat.o(126491);
  }
  
  public final void fzR()
  {
    AppMethodBeat.i(126490);
    Log.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", new Object[] { Integer.valueOf(hashCode()) });
    this.GpU.animate().cancel();
    this.GpT.animate().cancel();
    this.GpS.animate().cancel();
    this.GpS.setAlpha(0.0F);
    this.GpU.setAlpha(0.0F);
    this.GpT.setAlpha(0.0F);
    AppMethodBeat.o(126490);
  }
  
  public final boolean fzi()
  {
    AppMethodBeat.i(126493);
    if ((this.GpU.getAlpha() != 0.0F) && (this.GpT.getAlpha() != 0.0F))
    {
      AppMethodBeat.o(126493);
      return true;
    }
    AppMethodBeat.o(126493);
    return false;
  }
  
  public final void fzj()
  {
    AppMethodBeat.i(126495);
    if (!Util.isNullOrNil(this.GjH.title))
    {
      this.pIO.aw(this.GjH.title);
      this.pIO.setVisibility(0);
      this.pIO.requestLayout();
      this.pIO.setOnClickListener(this.ko);
      this.xYx.setText(this.GjH.source);
      if (!n.i(this.GjH)) {
        break label966;
      }
      this.GoT.setVisibility(0);
      label91:
      this.GmA.setOnClickListener(this.ko);
      this.xYx.setOnClickListener(this.ko);
      this.GoT.setOnClickListener(this.ko);
      if (Util.isNullOrNil(this.GjH.MwR)) {
        break label978;
      }
      q.bcV().a(this.GjH.MwR, this.GmA, com.tencent.mm.plugin.topstory.ui.c.GjU);
      label157:
      if (!this.Gmr.fyI()) {
        break label991;
      }
      this.rAO.setVisibility(0);
      this.rAO.setOnClickListener(this.ko);
      label188:
      if (!this.Gmr.fyJ()) {
        break label1003;
      }
      this.Gpw.setTag(this.GjH);
      this.Gpw.setOnClickListener(this.ko);
      this.Gpw.setVisibility(0);
      this.Gpx.setVisibility(0);
      label238:
      this.Gpw.setTag(this.GjH);
      this.Gpw.setOnClickListener(this.ko);
      this.psf.setOnClickListener(this.ko);
      this.GpS.setVisibility(0);
      this.GpT.setVisibility(0);
      this.GpU.setVisibility(0);
      if (this.GpP == null)
      {
        this.GpP = new f(this.Gmr.eeF(), this.Gmr, this);
        this.GoZ.removeAllViews();
        localObject = this.GoZ;
        com.tencent.mm.plugin.topstory.ui.video.f localf = this.GpP;
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", new Object[] { Integer.valueOf(this.Gmr.getVideoWidth()), Integer.valueOf(this.Gmr.getVideoHeight()) });
        ((FrameLayout)localObject).addView(localf, new FrameLayout.LayoutParams(this.Gmr.getVideoWidth(), this.Gmr.getVideoHeight()));
      }
      this.GpP.a(this.GjH, fyz());
      if (this.Gmr.fyH() == fyz()) {
        super.fyx();
      }
      this.GpV.setText(this.GjH.xDQ);
      if ((!this.GpZ) || (this.GjH.xuO.size() <= 0)) {
        break label1066;
      }
      this.GoM.setVisibility(0);
      Object localObject = (dyi)this.GjH.xuO.get(0);
      this.GoP.setTag(localObject);
      this.GoP.setText(((dyi)localObject).dQx);
      this.GoP.setVisibility(0);
      this.GoP.setOnClickListener(this.ko);
      this.GoN.setVisibility(0);
      this.GoR.setVisibility(8);
      if (!Util.isNullOrNil(((dyi)localObject).icon))
      {
        q.bcV().a(((dyi)localObject).icon, this.GoR, com.tencent.mm.plugin.topstory.ui.c.GjV);
        this.GoR.setVisibility(0);
      }
      if (this.GjH.xuO.size() <= 1) {
        break label1024;
      }
      localObject = (dyi)this.GjH.xuO.get(1);
      this.GoQ.setTag(localObject);
      this.GoQ.setText(((dyi)localObject).dQx);
      this.GoQ.setOnClickListener(this.ko);
      this.GoQ.setVisibility(0);
      this.GoO.setVisibility(0);
      this.GoS.setVisibility(8);
      if (!Util.isNullOrNil(((dyi)localObject).icon))
      {
        q.bcV().a(((dyi)localObject).icon, this.GoS, com.tencent.mm.plugin.topstory.ui.c.GjV);
        this.GoS.setVisibility(0);
      }
      label718:
      if (this.GjH.xuO.size() <= 2) {
        break label1045;
      }
      localObject = (dyi)this.GjH.xuO.get(2);
      this.GpX.setTag(localObject);
      this.GpX.setText(((dyi)localObject).dQx);
      this.GpX.setOnClickListener(this.ko);
      this.GpX.setVisibility(0);
      this.GpW.setVisibility(0);
      this.GpY.setVisibility(8);
      if (!Util.isNullOrNil(((dyi)localObject).icon))
      {
        q.bcV().a(((dyi)localObject).icon, this.GpY, com.tencent.mm.plugin.topstory.ui.c.GjV);
        this.GpY.setVisibility(0);
      }
      label837:
      if (this.Gmr.fyH() != fyz()) {
        dhM();
      }
      if ((this.GjH.Nix & 0x80) <= 0) {
        break label1111;
      }
      this.GpQ.setVisibility(0);
      this.GpQ.setOnClickListener(this.ko);
      if (!this.GjH.NiC) {
        break label1078;
      }
      this.GpR.setImageResource(2131691661);
      this.GoH.setTextColor(this.GoH.getResources().getColor(2131101284));
    }
    for (;;)
    {
      this.GoH.setText(com.tencent.mm.plugin.topstory.ui.c.abR(this.GjH.NiH));
      AppMethodBeat.o(126495);
      return;
      this.pIO.setVisibility(8);
      break;
      label966:
      this.GoT.setVisibility(8);
      break label91;
      label978:
      this.GmA.setImageResource(2131231957);
      break label157;
      label991:
      this.rAO.setVisibility(8);
      break label188;
      label1003:
      this.Gpw.setVisibility(8);
      this.Gpx.setVisibility(8);
      break label238;
      label1024:
      this.GoO.setVisibility(8);
      this.GoQ.setVisibility(8);
      break label718;
      label1045:
      this.GpW.setVisibility(8);
      this.GpX.setVisibility(8);
      break label837;
      label1066:
      this.GoM.setVisibility(8);
      break label837;
      label1078:
      this.GpR.setImageResource(2131691662);
      this.GoH.setTextColor(this.GoH.getResources().getColor(2131101427));
    }
    label1111:
    this.GpQ.setVisibility(8);
    AppMethodBeat.o(126495);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f fzk()
  {
    return this.GpP;
  }
  
  public final View getWowView()
  {
    return this.GpQ;
  }
  
  public final void wu(boolean paramBoolean)
  {
    AppMethodBeat.i(126494);
    super.wu(paramBoolean);
    fzR();
    this.Gmr.abV(fyz());
    if (this.GpP.ay(paramBoolean, false))
    {
      fyy();
      super.fyx();
    }
    AppMethodBeat.o(126494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.h
 * JD-Core Version:    0.7.0.1
 */