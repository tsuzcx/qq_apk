package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.lang.ref.WeakReference;

public final class s
{
  static final class c
    implements l
  {
    private WeakReference<com.tencent.mm.ui.chatting.d.a> zUu;
    
    public final void dBY() {}
    
    public final void dBZ() {}
    
    public final void dCa() {}
    
    public final void dCb()
    {
      AppMethodBeat.i(33038);
      if (this.zUu == null)
      {
        AppMethodBeat.o(33038);
        return;
      }
      com.tencent.mm.ui.chatting.d.a locala = (com.tencent.mm.ui.chatting.d.a)this.zUu.get();
      if (locala != null) {
        ((e)com.tencent.mm.kernel.g.E(e.class)).ack().qh(n.bt(locala));
      }
      AppMethodBeat.o(33038);
    }
    
    public final void dCc()
    {
      AppMethodBeat.i(33039);
      if (this.zUu == null)
      {
        AppMethodBeat.o(33039);
        return;
      }
      com.tencent.mm.ui.chatting.d.a locala = (com.tencent.mm.ui.chatting.d.a)this.zUu.get();
      if (locala != null) {
        ((e)com.tencent.mm.kernel.g.E(e.class)).ack().qg(n.bt(locala));
      }
      AppMethodBeat.o(33039);
    }
    
    public final void dCd()
    {
      AppMethodBeat.i(33040);
      ab.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
      if (this.zUu == null)
      {
        AppMethodBeat.o(33040);
        return;
      }
      com.tencent.mm.ui.chatting.d.a locala = (com.tencent.mm.ui.chatting.d.a)this.zUu.get();
      if (locala != null)
      {
        v.aae().oP(n.bt(locala));
        ((com.tencent.mm.ui.chatting.c.b.g)locala.ay(com.tencent.mm.ui.chatting.c.b.g.class)).b(this);
        ((e)com.tencent.mm.kernel.g.E(e.class)).qi(n.bt(locala));
      }
      AppMethodBeat.o(33040);
    }
    
    public final void dCe() {}
    
    final void n(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(33037);
      this.zUu = new WeakReference(parama);
      ((com.tencent.mm.ui.chatting.c.b.g)parama.ay(com.tencent.mm.ui.chatting.c.b.g.class)).a(this);
      AppMethodBeat.o(33037);
    }
  }
  
  static final class d
    extends c.a
  {
    public static final int zUv;
    public static final int zUw;
    static final c zUx;
    protected ThreeDotsLoadingView iTR;
    protected ImageView kha;
    protected ImageView zRS;
    protected ImageView zRV;
    protected ImageView zRW;
    protected TextView zRY;
    protected ChattingItemFooter zRZ;
    protected ImageView zSa;
    protected LinearLayout zSb;
    protected ViewGroup zSc;
    protected TextView zSd;
    protected LinearLayout zSe;
    ImageView zSm;
    protected ImageView zSq;
    protected TextView zSr;
    protected TextView zSs;
    protected LinearLayout zSt;
    protected TextView zSw;
    protected View zUA;
    protected TextView zUy;
    protected ViewGroup zUz;
    
    static
    {
      AppMethodBeat.i(33042);
      zUv = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 240);
      zUw = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 192);
      com.tencent.mm.at.a.a.c.a locala1 = new com.tencent.mm.at.a.a.c.a();
      locala1.eNY = 2131230843;
      com.tencent.mm.at.a.a.c.a locala2 = locala1.cx(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 20));
      locala2.eOk = true;
      locala2.eNM = true;
      locala2.eNK = true;
      zUx = locala1.ahY();
      AppMethodBeat.o(33042);
    }
    
    public final d C(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(33041);
      super.eV(paramView);
      this.zRS = ((ImageView)paramView.findViewById(2131822621));
      this.zRV = ((ImageView)this.ngZ.findViewById(2131822620));
      this.zRW = ((ImageView)this.ngZ.findViewById(2131822619));
      this.zRY = ((TextView)paramView.findViewById(2131822518));
      this.zSa = ((ImageView)paramView.findViewById(2131822622));
      this.mCC = ((CheckBox)paramView.findViewById(2131820579));
      this.jbK = paramView.findViewById(2131820586);
      this.qFY = ((TextView)paramView.findViewById(2131821122));
      this.zRZ = ((ChattingItemFooter)paramView.findViewById(2131822618));
      this.zSb = ((LinearLayout)paramView.findViewById(2131822579));
      this.zSc = ((ViewGroup)paramView.findViewById(2131822576));
      this.zSd = ((TextView)paramView.findViewById(2131822578));
      this.zSe = ((LinearLayout)paramView.findViewById(2131821948));
      this.jYu = paramView.findViewById(2131822580);
      if (!paramBoolean)
      {
        this.zSm = ((ImageView)this.ngZ.findViewById(2131822729));
        this.pNd = ((ProgressBar)this.ngZ.findViewById(2131822728));
      }
      this.zSt = ((LinearLayout)paramView.findViewById(2131822581));
      this.iTR = ((ThreeDotsLoadingView)paramView.findViewById(2131821346));
      this.kha = ((ImageView)paramView.findViewById(2131821891));
      this.zSw = ((TextView)paramView.findViewById(2131822584));
      this.zUy = ((TextView)paramView.findViewById(2131822653));
      this.zSq = ((ImageView)paramView.findViewById(2131822582));
      this.zSr = ((TextView)paramView.findViewById(2131822583));
      this.zSs = ((TextView)paramView.findViewById(2131822588));
      this.zUz = ((ViewGroup)paramView.findViewById(2131822656));
      AppMethodBeat.o(33041);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s
 * JD-Core Version:    0.7.0.1
 */