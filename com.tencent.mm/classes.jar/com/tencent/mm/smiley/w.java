package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/SystemEmojiItem;", "Lcom/tencent/mm/smiley/IEmojiItem;", "codePointList", "", "", "picItem", "Lcom/tencent/mm/smiley/PicEmojiItem;", "(Ljava/util/List;Lcom/tencent/mm/smiley/PicEmojiItem;)V", "codePoints", "", "getCodePoints", "()[I", "getPicItem", "()Lcom/tencent/mm/smiley/PicEmojiItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  implements l
{
  final q acwN;
  public final int[] mdx;
  
  public w(List<Integer> paramList, q paramq)
  {
    AppMethodBeat.i(242868);
    this.acwN = paramq;
    this.mdx = new int[paramList.size()];
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      paramq = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      int j = ((Number)paramq).intValue();
      this.mdx[i] = j;
      i += 1;
    }
    AppMethodBeat.o(242868);
  }
  
  public final int[] aTW()
  {
    return this.mdx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.w
 * JD-Core Version:    0.7.0.1
 */