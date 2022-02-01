package com.tencent.mm.ui.conversation.fold;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.by;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/fold/PluginFold;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "()V", "convBoxExt", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFold
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c
{
  public static final PluginFold.a afuc;
  private final i afud;
  
  static
  {
    AppMethodBeat.i(256878);
    afuc = new PluginFold.a((byte)0);
    AppMethodBeat.o(256878);
  }
  
  public PluginFold()
  {
    AppMethodBeat.i(256875);
    this.afud = ((i)new com.tencent.mm.ui.conversation.c());
    AppMethodBeat.o(256875);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(256895);
    s.u(paramg, "profile");
    AppMethodBeat.o(256895);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(256884);
    s.u(paramc, "upgrade");
    paramc = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.g)h.ax(com.tencent.mm.plugin.messenger.foundation.a.g.class)).addContactAssembler((com.tencent.mm.plugin.messenger.foundation.a.f)paramc);
    ((n)h.ax(n.class)).bzG().a(this.afud);
    AppMethodBeat.o(256884);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(256891);
    ((n)h.ax(n.class)).bzG().b(this.afud);
    AppMethodBeat.o(256891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.fold.PluginFold
 * JD-Core Version:    0.7.0.1
 */