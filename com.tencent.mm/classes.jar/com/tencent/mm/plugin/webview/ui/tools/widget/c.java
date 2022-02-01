package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewOption;", "", "heightPercent", "", "extData", "", "reuseWebView", "", "showMenu", "backMode", "", "immersiveUIStyle", "openType", "(FLjava/lang/String;ZZIZI)V", "getBackMode", "()I", "getExtData", "()Ljava/lang/String;", "getHeightPercent", "()F", "getImmersiveUIStyle", "()Z", "getOpenType", "getReuseWebView", "getShowMenu", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a Xpq;
  final boolean Xpr;
  final int Xps;
  final boolean Xpt;
  final String extData;
  final float heightPercent;
  final int icP;
  final boolean rvh;
  
  static
  {
    AppMethodBeat.i(298028);
    Xpq = new a((byte)0);
    AppMethodBeat.o(298028);
  }
  
  public c()
  {
    this(0.0F, null, false, false, 0, 127);
  }
  
  public c(float paramFloat, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, int paramInt2)
  {
    this.heightPercent = paramFloat;
    this.extData = paramString;
    this.Xpr = paramBoolean1;
    this.rvh = paramBoolean2;
    this.Xps = paramInt1;
    this.Xpt = paramBoolean3;
    this.icP = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(298038);
    if (this == paramObject)
    {
      AppMethodBeat.o(298038);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(298038);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(Float.valueOf(this.heightPercent), Float.valueOf(paramObject.heightPercent)))
    {
      AppMethodBeat.o(298038);
      return false;
    }
    if (!s.p(this.extData, paramObject.extData))
    {
      AppMethodBeat.o(298038);
      return false;
    }
    if (this.Xpr != paramObject.Xpr)
    {
      AppMethodBeat.o(298038);
      return false;
    }
    if (this.rvh != paramObject.rvh)
    {
      AppMethodBeat.o(298038);
      return false;
    }
    if (this.Xps != paramObject.Xps)
    {
      AppMethodBeat.o(298038);
      return false;
    }
    if (this.Xpt != paramObject.Xpt)
    {
      AppMethodBeat.o(298038);
      return false;
    }
    if (this.icP != paramObject.icP)
    {
      AppMethodBeat.o(298038);
      return false;
    }
    AppMethodBeat.o(298038);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(298033);
    String str = "HalfScreenWebViewOption(heightPercent=" + this.heightPercent + ", extData=" + this.extData + ", reuseWebView=" + this.Xpr + ", showMenu=" + this.rvh + ", backMode=" + this.Xps + ", immersiveUIStyle=" + this.Xpt + ", openType=" + this.icP + ')';
    AppMethodBeat.o(298033);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewOption$Companion;", "", "()V", "backModeDefault", "", "backModeForceBack", "backModeForceDown", "backModeNone", "bottomToTopSlowAnimation", "rightToLeftAnimation", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.c
 * JD-Core Version:    0.7.0.1
 */