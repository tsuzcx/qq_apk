package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/QQEmojiItem;", "Lcom/tencent/mm/smiley/IEmojiItem;", "pos", "", "key", "", "text", "name", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "codePoints", "", "getCodePoints", "()[I", "getName", "()Ljava/lang/String;", "getPos", "()I", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  implements l
{
  public final String key;
  final int[] mdx;
  final String name;
  final int pos;
  public final String text;
  
  public r(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(242830);
    this.pos = paramInt;
    this.key = paramString1;
    this.text = paramString2;
    this.name = paramString3;
    this.mdx = l.a.buB(this.text);
    AppMethodBeat.o(242830);
  }
  
  public final int[] aTW()
  {
    return this.mdx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.r
 * JD-Core Version:    0.7.0.1
 */