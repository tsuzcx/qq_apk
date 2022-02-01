package com.tencent.mm.plugin.thumbplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.thumbplayer.b.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.thumbplayer.b.h;
import com.tencent.thumbplayer.b.h.a;
import d.g.b.u;
import d.g.b.w;
import d.l.k;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/thumbplayer/PluginThumbPlayer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/thumbplayer/api/IPluginThumbPlayer;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "cdnTaskController", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "getCdnTaskController", "()Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "cdnTaskController$delegate", "Lkotlin/Lazy;", "openTPPlayerFlag", "", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "initThumbPlayer", "isOpenTPPlayer", "", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "plugin-thumbplayer_release"})
public final class PluginThumbPlayer
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.thumbplayer.a.a
{
  private final String TAG;
  private final d.f zYf;
  private int zYg;
  
  static
  {
    AppMethodBeat.i(209648);
    $$delegatedProperties = new k[] { (k)w.a(new u(w.bn(PluginThumbPlayer.class), "cdnTaskController", "getCdnTaskController()Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;")) };
    AppMethodBeat.o(209648);
  }
  
  public PluginThumbPlayer()
  {
    AppMethodBeat.i(209653);
    this.TAG = "MicroMsg.TP.PluginThumbPlayer";
    this.zYf = d.g.K((d.g.a.a)a.zYh);
    AppMethodBeat.o(209653);
  }
  
  private final void initThumbPlayer()
  {
    AppMethodBeat.i(209652);
    h.a((h.a)new PluginThumbPlayer.b());
    h.cw(ai.getContext(), "60303");
    h.fFe();
    h.fFf();
    AppMethodBeat.o(209652);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final com.tencent.mm.plugin.thumbplayer.b.a getCdnTaskController()
  {
    AppMethodBeat.i(209649);
    com.tencent.mm.plugin.thumbplayer.b.a locala = (com.tencent.mm.plugin.thumbplayer.b.a)this.zYf.getValue();
    AppMethodBeat.o(209649);
    return locala;
  }
  
  public final boolean isOpenTPPlayer()
  {
    return this.zYg == 1;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(209650);
    if ((com.tencent.mm.util.c.fwX()) || (((b)com.tencent.mm.kernel.g.ab(b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbP, false))) {}
    for (int i = 1;; i = 0)
    {
      this.zYg = i;
      ac.i(this.TAG, "openTPPlayerFlag " + this.zYg);
      if (isOpenTPPlayer())
      {
        paramc = getCdnTaskController();
        ac.i(paramc.TAG, "init cdn task controller");
        paramc.zYk.clear();
        paramc.zYl.clear();
        paramc.zYi.clear();
        paramc.zYj.clear();
        com.tencent.mm.an.f.aDE().a((com.tencent.mm.an.a.a)new a.b(paramc));
        com.tencent.mm.an.f.aDE().a((com.tencent.mm.i.b.a)new com.tencent.mm.plugin.thumbplayer.b.a.a(paramc));
        initThumbPlayer();
      }
      AppMethodBeat.o(209650);
      return;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(209651);
    if (isOpenTPPlayer())
    {
      com.tencent.mm.plugin.thumbplayer.b.a locala = getCdnTaskController();
      ac.i(locala.TAG, "release cdn task controller");
      locala.zYk.clear();
      locala.zYl.clear();
      locala.zYi.clear();
      locala.zYj.clear();
      com.tencent.mm.an.f.aDE().a(null);
      com.tencent.mm.an.f.aDE().a(null);
    }
    AppMethodBeat.o(209651);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.thumbplayer.b.a>
  {
    public static final a zYh;
    
    static
    {
      AppMethodBeat.i(209642);
      zYh = new a();
      AppMethodBeat.o(209642);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer
 * JD-Core Version:    0.7.0.1
 */