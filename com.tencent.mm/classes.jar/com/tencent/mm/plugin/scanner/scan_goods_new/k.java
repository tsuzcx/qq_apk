package com.tencent.mm.plugin.scanner.scan_goods_new;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductResult;", "", "()V", "fullYUVImageData", "", "getFullYUVImageData", "()[B", "setFullYUVImageData", "([B)V", "needDetectByServer", "", "getNeedDetectByServer", "()Z", "setNeedDetectByServer", "(Z)V", "productInfoCount", "", "getProductInfoCount", "()I", "setProductInfoCount", "(I)V", "scanImageType", "getScanImageType$annotations", "getScanImageType", "setScanImageType", "scanProductInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "Lkotlin/collections/ArrayList;", "getScanProductInfoList", "()Ljava/util/ArrayList;", "setScanProductInfoList", "(Ljava/util/ArrayList;)V", "session", "", "getSession", "()J", "setSession", "(J)V", "source", "getSource", "setSource", "getResult", "isNotEmpty", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public int OVD;
  public ArrayList<j> OWA;
  public int OWB;
  public boolean OWC;
  public byte[] OWD;
  public long hBk;
  public int source;
  
  public k()
  {
    AppMethodBeat.i(313865);
    this.OWA = new ArrayList();
    AppMethodBeat.o(313865);
  }
  
  private boolean qn()
  {
    AppMethodBeat.i(313870);
    if (this.OWB > 0)
    {
      if (!((Collection)this.OWA).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(313870);
        return true;
      }
    }
    AppMethodBeat.o(313870);
    return false;
  }
  
  public final j gRQ()
  {
    AppMethodBeat.i(313874);
    if (qn())
    {
      j localj = (j)p.ae((List)this.OWA, 0);
      AppMethodBeat.o(313874);
      return localj;
    }
    AppMethodBeat.o(313874);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.k
 * JD-Core Version:    0.7.0.1
 */