package com.tencent.mm.plugin.scanner.scan_goods_new;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageGetProductManager$Companion;", "", "()V", "TAG", "", "THREAD_LOOP_TAG", "runTask", "", "task", "Ljava/lang/Runnable;", "delay", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  public static void y(Runnable paramRunnable)
  {
    AppMethodBeat.i(313860);
    s.u(paramRunnable, "task");
    h.ahAA.g(paramRunnable, "AiScanImageGetProductManager");
    AppMethodBeat.o(313860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.b.a
 * JD-Core Version:    0.7.0.1
 */