package com.tencent.mm.plugin.mvvmlist.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "T", "", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "(Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;)V", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "getRequest", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<T>
{
  public boolean ABD;
  private final c<T> DHT;
  public final ArrayList<T> pUj;
  
  public d(c<T> paramc)
  {
    AppMethodBeat.i(278742);
    this.DHT = paramc;
    this.pUj = new ArrayList();
    AppMethodBeat.o(278742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.a.d
 * JD-Core Version:    0.7.0.1
 */