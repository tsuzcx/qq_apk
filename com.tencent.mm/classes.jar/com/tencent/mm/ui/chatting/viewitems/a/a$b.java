package com.tencent.mm.ui.chatting.viewitems.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$InfoItem;", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getValue", "setValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
public final class a$b
{
  String key;
  String value;
  
  public a$b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(280331);
    this.key = paramString1;
    this.value = paramString2;
    AppMethodBeat.o(280331);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(280334);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.h(this.key, paramObject.key)) || (!p.h(this.value, paramObject.value))) {}
      }
    }
    else
    {
      AppMethodBeat.o(280334);
      return true;
    }
    AppMethodBeat.o(280334);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(280333);
    String str = this.key;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.value;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(280333);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280332);
    String str = "InfoItem(key=" + this.key + ", value=" + this.value + ")";
    AppMethodBeat.o(280332);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.a.b
 * JD-Core Version:    0.7.0.1
 */