package com.tencent.mm.plugin.websearch.widget;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.widget.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final e qXg = new e();
  boolean LQ;
  Set<WidgetData> qXh = new HashSet();
  b qXi;
  
  public e()
  {
    g.DQ();
    this.qXi = new b(g.DP().dKu);
    bZV();
  }
  
  public static e cag()
  {
    if (!ae.cqV()) {
      throw new RuntimeException("can not call this out of mm process");
    }
    return qXg;
  }
  
  public static void cah() {}
  
  final void bZV()
  {
    com.tencent.mm.sdk.f.e.post(new e.1(this), "WidgetSafeModeProxyImpl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.e
 * JD-Core Version:    0.7.0.1
 */