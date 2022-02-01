package com.tencent.mm.plugin.scanner.box.a.a;

import com.tencent.mm.plugin.webview.d.c.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "controlByte", "", "getControlByte", "()I", "lastShowToastTimestamp", "", "canShowToast", "", "current", "Companion", "plugin-scan_release"})
public abstract class b
  extends a
{
  public static final a CDL = new a((byte)0);
  private final int CDJ = 10007;
  private long CDK;
  
  protected final boolean Iu(long paramLong)
  {
    if ((this.CDK == 0L) || (System.currentTimeMillis() - this.CDK >= 2000L))
    {
      this.CDK = paramLong;
      return true;
    }
    return false;
  }
  
  public final int ePA()
  {
    return this.CDJ;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi$Companion;", "", "()V", "SHOW_TOAST_TIME_MIN_LIMIT", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.a.b
 * JD-Core Version:    0.7.0.1
 */