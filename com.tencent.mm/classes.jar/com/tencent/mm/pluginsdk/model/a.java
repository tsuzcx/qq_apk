package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveChecker;", "Lcom/tencent/mm/plugin/brandservice/api/IBizFinderLiveChecker;", "scene", "", "(I)V", "getScene", "()I", "updateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkBizFinderLives", "", "bizUserName", "", "startCheck", "stopCheck", "Companion", "plugin-biz_release"})
public final class a
  implements com.tencent.mm.plugin.brandservice.a.a
{
  public static final a QTn;
  static final String TAG = "MicroMsg.BizFinderLiveChecker";
  private MTimerHandler sSd;
  final int scene;
  
  static
  {
    AppMethodBeat.i(210621);
    QTn = new a((byte)0);
    TAG = "MicroMsg.BizFinderLiveChecker";
    AppMethodBeat.o(210621);
  }
  
  public a(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void apt(final String paramString)
  {
    AppMethodBeat.i(210619);
    if (paramString == null)
    {
      AppMethodBeat.o(210619);
      return;
    }
    if (this.sSd != null)
    {
      AppMethodBeat.o(210619);
      return;
    }
    Log.d(TAG, "startCheck");
    Object localObject = b.QTJ;
    localObject = b.hga();
    b localb = b.QTJ;
    long l = i.be(MMKVSlotManager.decodeLong$default((MMKVSlotManager)localObject, b.bpn(paramString), 0L, 2, null), 10L) * 1000L / 2L;
    this.sSd = new MTimerHandler(paramString + "-live-UpdateTimer", (MTimerHandler.CallBack)new c(this, paramString), true);
    paramString = this.sSd;
    if (paramString != null)
    {
      paramString.startTimer(0L, l);
      AppMethodBeat.o(210619);
      return;
    }
    AppMethodBeat.o(210619);
  }
  
  public final void stopCheck()
  {
    AppMethodBeat.i(210620);
    if (this.sSd != null)
    {
      Log.d(TAG, "stopCheck");
      MTimerHandler localMTimerHandler = this.sSd;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      this.sSd = null;
    }
    AppMethodBeat.o(210620);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveChecker$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bizUserName", "", "exportId", "isChange", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, String, Boolean, x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements MTimerHandler.CallBack
  {
    c(a parama, String paramString) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(205326);
      a locala = this.QTo;
      String str = paramString;
      p.k(str, "bizUserName");
      Log.d(a.TAG, "checkBizFinderLives");
      b localb = b.QTJ;
      b.a(str, false, locala.scene, (kotlin.g.a.q)new a.b(locala));
      AppMethodBeat.o(205326);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a
 * JD-Core Version:    0.7.0.1
 */