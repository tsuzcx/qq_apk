package com.tencent.mm.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.e;
import com.tencent.mm.modelpackage.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/easteregg/EasterEggMatchInfo;", "", "eggInfo", "Lcom/tencent/mm/modelpackage/EggInfo;", "keyword", "Lcom/tencent/mm/modelpackage/EggKeyWord;", "start", "", "end", "(Lcom/tencent/mm/modelpackage/EggInfo;Lcom/tencent/mm/modelpackage/EggKeyWord;II)V", "getEggInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "getEnd", "()I", "setEnd", "(I)V", "getKeyword", "()Lcom/tencent/mm/modelpackage/EggKeyWord;", "getStart", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private int end;
  public final e mdu;
  public final f mdw;
  private final int start;
  
  public c(e parame, f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231290);
    this.mdu = parame;
    this.mdw = paramf;
    this.start = paramInt1;
    this.end = paramInt2;
    AppMethodBeat.o(231290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.q.c
 * JD-Core Version:    0.7.0.1
 */