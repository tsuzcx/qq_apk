package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SearchQueryAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "searchId", "", "query", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "getSearchId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends BaseStateAction
{
  public final String mpa;
  public final String query;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(250441);
    this.mpa = paramString1;
    this.query = paramString2;
    AppMethodBeat.o(250441);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250461);
    if (this == paramObject)
    {
      AppMethodBeat.o(250461);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(250461);
      return false;
    }
    paramObject = (f)paramObject;
    if (!s.p(this.mpa, paramObject.mpa))
    {
      AppMethodBeat.o(250461);
      return false;
    }
    if (!s.p(this.query, paramObject.query))
    {
      AppMethodBeat.o(250461);
      return false;
    }
    AppMethodBeat.o(250461);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(250455);
    int i = this.mpa.hashCode();
    int j = this.query.hashCode();
    AppMethodBeat.o(250455);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250448);
    String str = "SearchQueryAction(searchId=" + this.mpa + ", query=" + this.query + ')';
    AppMethodBeat.o(250448);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.f
 * JD-Core Version:    0.7.0.1
 */