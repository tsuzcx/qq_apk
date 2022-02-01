package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransData;", "", "()V", "WebTransNode", "WebTransPack", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransData$WebTransNode;", "", "()V", "brand", "", "getBrand", "()Ljava/lang/String;", "setBrand", "(Ljava/lang/String;)V", "hashCode", "getHashCode", "setHashCode", "orgText", "getOrgText", "setOrgText", "transText", "getTransText", "setTransText", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    String WuA;
    String WuB;
    String Wuz;
    String brand;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransData$WebTransPack;", "", "()V", "nodeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/WebTransData$WebTransNode;", "Lkotlin/collections/ArrayList;", "getNodeList", "()Ljava/util/ArrayList;", "setNodeList", "(Ljava/util/ArrayList;)V", "addSubList", "", "list", "from", "", "to", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    ArrayList<f.a> WuC;
    
    public b()
    {
      AppMethodBeat.i(294582);
      this.WuC = new ArrayList();
      AppMethodBeat.o(294582);
    }
    
    public final void h(ArrayList<f.a> paramArrayList, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(294586);
      s.u(paramArrayList, "list");
      paramArrayList = paramArrayList.subList(paramInt1, paramInt2);
      s.s(paramArrayList, "list.subList(from, to)");
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        f.a locala = (f.a)paramArrayList.next();
        this.WuC.add(locala);
      }
      AppMethodBeat.o(294586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f
 * JD-Core Version:    0.7.0.1
 */