package com.tencent.mm.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.e;
import com.tencent.mm.modelpackage.f;
import com.tencent.mm.smiley.l;
import com.tencent.mm.smiley.l.a;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/easteregg/EasterEggItem;", "Lcom/tencent/mm/smiley/IEmojiItem;", "eggInfo", "Lcom/tencent/mm/modelpackage/EggInfo;", "eggIndex", "", "keyword", "Lcom/tencent/mm/modelpackage/EggKeyWord;", "(Lcom/tencent/mm/modelpackage/EggInfo;ILcom/tencent/mm/modelpackage/EggKeyWord;)V", "codePoints", "", "getCodePoints", "()[I", "getEggIndex", "()I", "getEggInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "getKeyword", "()Lcom/tencent/mm/modelpackage/EggKeyWord;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements l
{
  final e mdu;
  private final int mdv;
  final f mdw;
  private final int[] mdx;
  
  public a(e parame, int paramInt, f paramf)
  {
    AppMethodBeat.i(231287);
    this.mdu = parame;
    this.mdv = paramInt;
    this.mdw = paramf;
    parame = this.mdw.oQy;
    s.s(parame, "keyword.keyWord");
    paramf = Locale.getDefault();
    s.s(paramf, "getDefault()");
    parame = parame.toLowerCase(paramf);
    s.s(parame, "(this as java.lang.String).toLowerCase(locale)");
    this.mdx = l.a.buB(parame);
    AppMethodBeat.o(231287);
  }
  
  public final int[] aTW()
  {
    return this.mdx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.q.a
 * JD-Core Version:    0.7.0.1
 */