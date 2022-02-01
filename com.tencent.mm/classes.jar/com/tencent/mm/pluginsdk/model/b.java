package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.api.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveChecker;", "Lcom/tencent/mm/plugin/brandservice/api/IBizFinderLiveChecker;", "scene", "", "(I)V", "getScene", "()I", "updateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkBizFinderLives", "", "bizUserName", "", "startCheck", "stopCheck", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  private static final String TAG;
  public static final a XPr;
  final int scene;
  private MTimerHandler vXz;
  
  static
  {
    AppMethodBeat.i(244733);
    XPr = new a((byte)0);
    TAG = "MicroMsg.BizFinderLiveChecker";
    AppMethodBeat.o(244733);
  }
  
  public b(int paramInt)
  {
    this.scene = paramInt;
  }
  
  private static final boolean a(b paramb, String paramString)
  {
    AppMethodBeat.i(244731);
    s.u(paramb, "this$0");
    s.u(paramString, "bizUserName");
    Log.d(TAG, "checkBizFinderLives");
    c localc = c.XPt;
    c.a(paramString, false, paramb.scene, (q)new b(paramb));
    AppMethodBeat.o(244731);
    return true;
  }
  
  public final void aiO(String paramString)
  {
    AppMethodBeat.i(244750);
    if (paramString == null)
    {
      AppMethodBeat.o(244750);
      return;
    }
    if (this.vXz != null)
    {
      AppMethodBeat.o(244750);
      return;
    }
    Object localObject = c.XPt;
    localObject = c.iGU();
    c localc = c.XPt;
    long l = k.qu(MMKVSlotManager.decodeInt$default((MMKVSlotManager)localObject, c.bpe(paramString), 0, 2, null), 10) * 1000 / 2L;
    Log.d(TAG, s.X("startCheck interval = ", Long.valueOf(l)));
    this.vXz = new MTimerHandler(s.X(paramString, "-live-UpdateTimer"), new b..ExternalSyntheticLambda0(this, paramString), true);
    paramString = this.vXz;
    if (paramString != null) {
      paramString.startTimer(0L, l);
    }
    AppMethodBeat.o(244750);
  }
  
  public final void stopCheck()
  {
    AppMethodBeat.i(244757);
    if (this.vXz != null)
    {
      Log.d(TAG, "stopCheck");
      MTimerHandler localMTimerHandler = this.vXz;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      this.vXz = null;
    }
    AppMethodBeat.o(244757);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveChecker$Companion;", "", "()V", "TAG", "", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "bizUserName", "", "exportId", "isChange", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements q<String, String, Boolean, ah>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.b
 * JD-Core Version:    0.7.0.1
 */