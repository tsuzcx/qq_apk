package com.tencent.mm.plugin.scanner.box.a.a;

import com.tencent.mm.plugin.webview.jsapi.c.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "controlByte", "", "getControlByte", "()I", "lastShowToastTimestamp", "", "canShowToast", "", "current", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends a
{
  public static final a OOj = new a((byte)0);
  private final int OOk = 10007;
  private long OOl;
  
  public final int gPZ()
  {
    return this.OOk;
  }
  
  protected final boolean tQ(long paramLong)
  {
    if ((this.OOl == 0L) || (System.currentTimeMillis() - this.OOl >= 2000L))
    {
      this.OOl = paramLong;
      return true;
    }
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi$Companion;", "", "()V", "SHOW_TOAST_TIME_MIN_LIMIT", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.a.b
 * JD-Core Version:    0.7.0.1
 */