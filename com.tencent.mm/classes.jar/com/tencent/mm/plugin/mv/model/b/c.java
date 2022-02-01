package com.tencent.mm.plugin.mv.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.livelist.a.a;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.protocal.protobuf.edf;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "previewItemObj", "Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "(Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;)V", "listId", "", "getListId", "()Ljava/lang/String;", "setListId", "(Ljava/lang/String;)V", "getPreviewItemObj", "()Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "selectedItemFixId", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getSelectedItemFixId", "()Ljava/util/HashSet;", "checkAlbumVideoWidth", "", "item", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "getSelectSourceList", "Lcom/tencent/mm/protocal/protobuf/PreviewItemList;", "onCreate", "Companion", "plugin-mv_release"})
public final class c
  extends a<e>
{
  public static final c.a GdV;
  public String GdS;
  private final HashSet<String> GdT;
  private final doi GdU;
  
  static
  {
    AppMethodBeat.i(226392);
    GdV = new c.a((byte)0);
    AppMethodBeat.o(226392);
  }
  
  public c(doi paramdoi)
  {
    AppMethodBeat.i(226391);
    this.GdU = paramdoi;
    this.GdT = new HashSet();
    AppMethodBeat.o(226391);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(226377);
    Object localObject = this.GdU.TVz;
    p.j(localObject, "previewItemObj.selectItemList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      edf localedf = (edf)((Iterator)localObject).next();
      dog localdog = localedf.UhH;
      if (localdog != null) {
        this.GdT.add(localedf.GdS + '-' + localdog.id);
      }
    }
    AppMethodBeat.o(226377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.c
 * JD-Core Version:    0.7.0.1
 */