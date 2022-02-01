package com.tencent.mm.plugin.sns.storage;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/FinderSnsLiveStatusSyncSaver;", "", "()V", "SAVE_WHAT", "", "TAG", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "clearTask", "", "save", "snsinfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i QYv;
  public static final int QYw;
  private static final String TAG;
  private static final j rdm;
  
  static
  {
    AppMethodBeat.i(306587);
    QYv = new i();
    TAG = "FinderSnsLiveStatusSyncSaver";
    QYw = 1;
    rdm = k.cm((a)a.QYx);
    AppMethodBeat.o(306587);
  }
  
  public static MMHandler getHandler()
  {
    AppMethodBeat.i(306580);
    MMHandler localMMHandler = (MMHandler)rdm.getValue();
    AppMethodBeat.o(306580);
    return localMMHandler;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<MMHandler>
  {
    public static final a QYx;
    
    static
    {
      AppMethodBeat.i(306522);
      QYx = new a();
      AppMethodBeat.o(306522);
    }
    
    a()
    {
      super();
    }
    
    private static final boolean u(Message paramMessage)
    {
      AppMethodBeat.i(306519);
      s.u(paramMessage, "it");
      AppMethodBeat.o(306519);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.i
 * JD-Core Version:    0.7.0.1
 */