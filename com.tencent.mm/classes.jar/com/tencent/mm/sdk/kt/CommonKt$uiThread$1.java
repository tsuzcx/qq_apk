package com.tencent.mm.sdk.kt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/sdk/kt/CommonKt$uiThread$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CommonKt$uiThread$1
  implements j
{
  CommonKt$uiThread$1(a<ah> parama) {}
  
  public final String getKey()
  {
    return "";
  }
  
  public final boolean isLogging()
  {
    return false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(243135);
    this.$block.invoke();
    AppMethodBeat.o(243135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.kt.CommonKt.uiThread.1
 * JD-Core Version:    0.7.0.1
 */