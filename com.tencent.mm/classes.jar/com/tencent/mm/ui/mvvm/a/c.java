package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SearchEndAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "searchId", "", "originQuery", "subQueryList", "", "resultMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/HashMap;)V", "getOriginQuery", "()Ljava/lang/String;", "getResultMap", "()Ljava/util/HashMap;", "getSearchId", "getSubQueryList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends BaseStateAction
{
  private final String Hte;
  private final List<String> Hti;
  public final HashMap<Integer, m> afAS;
  public final String mpa;
  
  public c(String paramString1, String paramString2, List<String> paramList, HashMap<Integer, m> paramHashMap)
  {
    AppMethodBeat.i(250462);
    this.mpa = paramString1;
    this.Hte = paramString2;
    this.Hti = paramList;
    this.afAS = paramHashMap;
    AppMethodBeat.o(250462);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250477);
    if (this == paramObject)
    {
      AppMethodBeat.o(250477);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(250477);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.mpa, paramObject.mpa))
    {
      AppMethodBeat.o(250477);
      return false;
    }
    if (!s.p(this.Hte, paramObject.Hte))
    {
      AppMethodBeat.o(250477);
      return false;
    }
    if (!s.p(this.Hti, paramObject.Hti))
    {
      AppMethodBeat.o(250477);
      return false;
    }
    if (!s.p(this.afAS, paramObject.afAS))
    {
      AppMethodBeat.o(250477);
      return false;
    }
    AppMethodBeat.o(250477);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(250472);
    int i = this.mpa.hashCode();
    int j = this.Hte.hashCode();
    int k = this.Hti.hashCode();
    int m = this.afAS.hashCode();
    AppMethodBeat.o(250472);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250468);
    String str = "SearchEndAction(searchId=" + this.mpa + ", originQuery=" + this.Hte + ", subQueryList=" + this.Hti + ", resultMap=" + this.afAS + ')';
    AppMethodBeat.o(250468);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.c
 * JD-Core Version:    0.7.0.1
 */