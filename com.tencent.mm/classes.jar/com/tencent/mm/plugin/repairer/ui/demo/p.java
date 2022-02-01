package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ac.g;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoStorage;", "Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo;", "dbProvider", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "(Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;)V", "getLogTag", "", "getPageList", "", "offset", "", "pageSize", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends g<s>
{
  public static final a OwR;
  
  static
  {
    AppMethodBeat.i(278629);
    OwR = new a((byte)0);
    AppMethodBeat.o(278629);
  }
  
  public p(IMvvmDBProvider paramIMvvmDBProvider)
  {
    super(paramIMvvmDBProvider);
    AppMethodBeat.i(278622);
    AppMethodBeat.o(278622);
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.DemoStorage";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoStorage$Companion;", "", "()V", "TAG", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.p
 * JD-Core Version:    0.7.0.1
 */