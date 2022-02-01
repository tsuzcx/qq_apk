package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/keywords/SnsKeywordMatcher$ContentMatchResult;", "", "startPos", "", "endPos", "keyword", "", "(IILjava/lang/String;)V", "getEndPos", "()I", "getKeyword", "()Ljava/lang/String;", "getStartPos", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  final int dIY;
  final int endPos;
  final String hAB;
  
  public a$a(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(306443);
    this.dIY = paramInt1;
    this.endPos = paramInt2;
    this.hAB = paramString;
    AppMethodBeat.o(306443);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(306460);
    if (this == paramObject)
    {
      AppMethodBeat.o(306460);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(306460);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.dIY != paramObject.dIY)
    {
      AppMethodBeat.o(306460);
      return false;
    }
    if (this.endPos != paramObject.endPos)
    {
      AppMethodBeat.o(306460);
      return false;
    }
    if (!s.p(this.hAB, paramObject.hAB))
    {
      AppMethodBeat.o(306460);
      return false;
    }
    AppMethodBeat.o(306460);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(306455);
    int i = this.dIY;
    int j = this.endPos;
    int k = this.hAB.hashCode();
    AppMethodBeat.o(306455);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(306450);
    String str = "ContentMatchResult(startPos=" + this.dIY + ", endPos=" + this.endPos + ", keyword=" + this.hAB + ')';
    AppMethodBeat.o(306450);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.a.a
 * JD-Core Version:    0.7.0.1
 */