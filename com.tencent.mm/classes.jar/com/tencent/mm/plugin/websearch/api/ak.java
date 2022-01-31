package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public class ak
{
  private static volatile ak qUE;
  ai eAg;
  private volatile boolean qUA = false;
  private volatile Boolean qUB;
  private l qUC = new ae();
  private Map<Integer, al> qUD;
  private volatile boolean qUz = false;
  
  public static ak bZF()
  {
    if (qUE == null) {}
    try
    {
      if (qUE == null) {
        qUE = new ak();
      }
      return qUE;
    }
    finally {}
  }
  
  public final l BD(int paramInt)
  {
    if (paramInt <= 0) {
      localObject = this.qUC;
    }
    al localal;
    do
    {
      return localObject;
      if (this.qUD == null) {
        this.qUD = new HashMap();
      }
      localal = (al)this.qUD.get(Integer.valueOf(paramInt));
      localObject = localal;
    } while (localal != null);
    Object localObject = new al(paramInt);
    this.qUD.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public final boolean bZG()
  {
    if (this.qUB != null)
    {
      y.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload cmdPreloadSwitch %b", new Object[] { this.qUB });
      return this.qUB.booleanValue();
    }
    if (aa.Bs(0) < 80007181)
    {
      y.e("MicroMsg.WebSearch.WebSearchPreloadExport", "current search template not support preload");
      return false;
    }
    return this.qUz;
  }
  
  public final boolean bZH()
  {
    if (this.qUB != null)
    {
      y.i("MicroMsg.WebSearch.WebSearchPreloadExport", "isOpenRecommendPreload cmdPreloadSwitch %b", new Object[] { this.qUB });
      return this.qUB.booleanValue();
    }
    return this.qUA;
  }
  
  public final void cL(String paramString, int paramInt)
  {
    y.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebview 1");
    if (com.tencent.mm.sdk.platformtools.ae.cqX())
    {
      BD(paramInt).Rq(paramString);
      return;
    }
    g.DS().O(new ak.1(this, paramInt, paramString));
  }
  
  public final void kY(boolean paramBoolean)
  {
    this.qUB = Boolean.valueOf(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak
 * JD-Core Version:    0.7.0.1
 */