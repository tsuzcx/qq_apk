package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebTransData;", "", "()V", "WebTransNode", "WebTransPack", "plugin-webview_release"})
public abstract class f
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebTransData$WebTransNode;", "", "()V", "brand", "", "getBrand", "()Ljava/lang/String;", "setBrand", "(Ljava/lang/String;)V", "hashCode", "getHashCode", "setHashCode", "orgText", "getOrgText", "setOrgText", "transText", "getTransText", "setTransText", "plugin-webview_release"})
  public static final class a
  {
    String PDW;
    String PDX;
    String PDY;
    String brand;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebTransData$WebTransPack;", "", "()V", "nodeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/WebTransData$WebTransNode;", "Lkotlin/collections/ArrayList;", "getNodeList", "()Ljava/util/ArrayList;", "setNodeList", "(Ljava/util/ArrayList;)V", "addSubList", "", "list", "from", "", "to", "plugin-webview_release"})
  public static final class b
  {
    ArrayList<f.a> PDZ;
    
    public b()
    {
      AppMethodBeat.i(267245);
      this.PDZ = new ArrayList();
      AppMethodBeat.o(267245);
    }
    
    public final void e(ArrayList<f.a> paramArrayList, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(267244);
      p.k(paramArrayList, "list");
      paramArrayList = paramArrayList.subList(paramInt1, paramInt2);
      p.j(paramArrayList, "list.subList(from, to)");
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        f.a locala = (f.a)paramArrayList.next();
        this.PDZ.add(locala);
      }
      AppMethodBeat.o(267244);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f
 * JD-Core Version:    0.7.0.1
 */