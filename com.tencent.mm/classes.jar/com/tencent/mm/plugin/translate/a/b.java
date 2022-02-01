package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/translate/event/TransResult;", "", "clientMsgId", "", "TranslatedText", "", "(ILjava/lang/String;)V", "getTranslatedText", "()Ljava/lang/String;", "getClientMsgId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final int TSH;
  public final String TSI;
  
  public b(int paramInt, String paramString)
  {
    AppMethodBeat.i(260397);
    this.TSH = paramInt;
    this.TSI = paramString;
    AppMethodBeat.o(260397);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260405);
    if (this == paramObject)
    {
      AppMethodBeat.o(260405);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(260405);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.TSH != paramObject.TSH)
    {
      AppMethodBeat.o(260405);
      return false;
    }
    if (!s.p(this.TSI, paramObject.TSI))
    {
      AppMethodBeat.o(260405);
      return false;
    }
    AppMethodBeat.o(260405);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(260400);
    int i = this.TSH;
    int j = this.TSI.hashCode();
    AppMethodBeat.o(260400);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(260399);
    String str = "TransResult(clientMsgId=" + this.TSH + ", TranslatedText=" + this.TSI + ')';
    AppMethodBeat.o(260399);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.b
 * JD-Core Version:    0.7.0.1
 */