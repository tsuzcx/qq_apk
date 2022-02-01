package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ab.b;
import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.ac.d;
import com.tencent.mm.plugin.ac.g.a;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"getStorage", "Lcom/tencent/mm/plugin/mvvmcomm/DefaultMvvmStorage;", "Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo1;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem1;", "ui-repairer_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final b<t, l> gNl()
  {
    AppMethodBeat.i(278572);
    Object localObject1 = a.MnH;
    localObject1 = ((g)a.a.bW(g.class)).omV;
    if (localObject1 == null)
    {
      AppMethodBeat.o(278572);
      return null;
    }
    Object localObject2 = b.MmD;
    localObject1 = (IMvvmDBProvider)new c((ISQLiteDatabase)localObject1);
    localObject2 = com.tencent.mm.plugin.ac.g.MnP;
    localObject1 = (b)g.a.a(b.class, (IMvvmDBProvider)localObject1);
    AppMethodBeat.o(278572);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.v
 * JD-Core Version:    0.7.0.1
 */