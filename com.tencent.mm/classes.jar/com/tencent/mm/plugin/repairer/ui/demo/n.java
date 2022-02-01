package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ac.g;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoMainStorage;", "Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "Lcom/tencent/mm/plugin/repairer/ui/demo/LiveMainDemoDBInfo;", "dbProvider", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "(Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;)V", "getLogTag", "", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends g<u>
{
  public static final a OwQ;
  
  static
  {
    AppMethodBeat.i(278613);
    OwQ = new a((byte)0);
    AppMethodBeat.o(278613);
  }
  
  public n(IMvvmDBProvider paramIMvvmDBProvider)
  {
    super(paramIMvvmDBProvider);
    AppMethodBeat.i(278601);
    AppMethodBeat.o(278601);
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.DemoMainStorage";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoMainStorage$Companion;", "", "()V", "TAG", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.n
 * JD-Core Version:    0.7.0.1
 */