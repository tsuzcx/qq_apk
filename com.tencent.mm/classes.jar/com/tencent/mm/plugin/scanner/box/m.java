package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData;", "", "()V", "appMsgDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData$ScanBoxShareInfo;", "Lkotlin/collections/HashMap;", "clear", "", "getAppMsgData", "key", "putAppMsgData", "shareInfo", "ScanBoxShareInfo", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  final HashMap<String, a> ONI;
  
  public m()
  {
    AppMethodBeat.i(313724);
    this.ONI = new HashMap();
    AppMethodBeat.o(313724);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData$ScanBoxShareInfo;", "", "appMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "imageUrl", "", "(Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;Ljava/lang/String;)V", "getAppMsg", "()Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "getImageUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final WXMediaMessage ONJ;
    final String imageUrl;
    
    public a(WXMediaMessage paramWXMediaMessage, String paramString)
    {
      this.ONJ = paramWXMediaMessage;
      this.imageUrl = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(313694);
      if (this == paramObject)
      {
        AppMethodBeat.o(313694);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(313694);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.ONJ, paramObject.ONJ))
      {
        AppMethodBeat.o(313694);
        return false;
      }
      if (!s.p(this.imageUrl, paramObject.imageUrl))
      {
        AppMethodBeat.o(313694);
        return false;
      }
      AppMethodBeat.o(313694);
      return true;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(313688);
      int i;
      if (this.ONJ == null)
      {
        i = 0;
        if (this.imageUrl != null) {
          break label46;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(313688);
        return i * 31 + j;
        i = this.ONJ.hashCode();
        break;
        label46:
        j = this.imageUrl.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(313683);
      String str = "ScanBoxShareInfo(appMsg=" + this.ONJ + ", imageUrl=" + this.imageUrl + ')';
      AppMethodBeat.o(313683);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.m
 * JD-Core Version:    0.7.0.1
 */