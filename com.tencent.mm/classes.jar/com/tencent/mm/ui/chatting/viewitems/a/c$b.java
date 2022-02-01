package com.tencent.mm.ui.chatting.viewitems.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$InfoItem;", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getValue", "setValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
{
  String key;
  String value;
  
  public c$b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(255435);
    this.key = paramString1;
    this.value = paramString2;
    AppMethodBeat.o(255435);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(255450);
    if (this == paramObject)
    {
      AppMethodBeat.o(255450);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(255450);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.key, paramObject.key))
    {
      AppMethodBeat.o(255450);
      return false;
    }
    if (!s.p(this.value, paramObject.value))
    {
      AppMethodBeat.o(255450);
      return false;
    }
    AppMethodBeat.o(255450);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(255444);
    int i = this.key.hashCode();
    int j = this.value.hashCode();
    AppMethodBeat.o(255444);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(255440);
    String str = "InfoItem(key=" + this.key + ", value=" + this.value + ')';
    AppMethodBeat.o(255440);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.c.b
 * JD-Core Version:    0.7.0.1
 */