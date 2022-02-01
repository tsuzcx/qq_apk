package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/IEmojiItem;", "", "codePoints", "", "getCodePoints", "()[I", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface l
{
  public static final a acym = a.acyn;
  
  public abstract int[] aTW();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/IEmojiItem$Companion;", "", "()V", "stringToCodePoints", "", "text", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(242817);
      acyn = new a();
      AppMethodBeat.o(242817);
    }
    
    public static int[] buB(String paramString)
    {
      AppMethodBeat.i(242815);
      s.u(paramString, "text");
      int j = paramString.length();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < j)
      {
        int k = paramString.codePointAt(i);
        localLinkedList.add(Integer.valueOf(k));
        i += Character.charCount(k);
      }
      paramString = p.I((Collection)localLinkedList);
      AppMethodBeat.o(242815);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.l
 * JD-Core Version:    0.7.0.1
 */