package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/keywords/SnsKeywordMatcher$SnsInfoMatchResult;", "", "content", "", "contentMatchList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/sns/keywords/SnsKeywordMatcher$ContentMatchResult;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getContent", "()Ljava/lang/String;", "getContentMatchList", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
{
  final ArrayList<a.a> Qpf;
  private final String content;
  
  public a$c(String paramString, ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(306438);
    this.content = paramString;
    this.Qpf = paramArrayList;
    AppMethodBeat.o(306438);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(306457);
    if (this == paramObject)
    {
      AppMethodBeat.o(306457);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(306457);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.content, paramObject.content))
    {
      AppMethodBeat.o(306457);
      return false;
    }
    if (!s.p(this.Qpf, paramObject.Qpf))
    {
      AppMethodBeat.o(306457);
      return false;
    }
    AppMethodBeat.o(306457);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(306451);
    int i = this.content.hashCode();
    int j = this.Qpf.hashCode();
    AppMethodBeat.o(306451);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(306446);
    String str = "SnsInfoMatchResult(content=" + this.content + ", contentMatchList=" + this.Qpf + ')';
    AppMethodBeat.o(306446);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.a.c
 * JD-Core Version:    0.7.0.1
 */