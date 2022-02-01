package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData;", "", "()V", "appMsgDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData$ScanBoxShareInfo;", "Lkotlin/collections/HashMap;", "clear", "", "getAppMsgData", "key", "putAppMsgData", "shareInfo", "ScanBoxShareInfo", "plugin-scan_release"})
public final class m
{
  final HashMap<String, a> CDe;
  
  public m()
  {
    AppMethodBeat.i(240291);
    this.CDe = new HashMap();
    AppMethodBeat.o(240291);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData$ScanBoxShareInfo;", "", "appMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "imageUrl", "", "(Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;Ljava/lang/String;)V", "getAppMsg", "()Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "getImageUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-scan_release"})
  public static final class a
  {
    final WXMediaMessage CDf;
    final String imageUrl;
    
    public a(WXMediaMessage paramWXMediaMessage, String paramString)
    {
      this.CDf = paramWXMediaMessage;
      this.imageUrl = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(240290);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.j(this.CDf, paramObject.CDf)) || (!p.j(this.imageUrl, paramObject.imageUrl))) {}
        }
      }
      else
      {
        AppMethodBeat.o(240290);
        return true;
      }
      AppMethodBeat.o(240290);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(240289);
      Object localObject = this.CDf;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.imageUrl;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(240289);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(240288);
      String str = "ScanBoxShareInfo(appMsg=" + this.CDf + ", imageUrl=" + this.imageUrl + ")";
      AppMethodBeat.o(240288);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.m
 * JD-Core Version:    0.7.0.1
 */