package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/QQEmojiRepo;", "Lcom/tencent/mm/smiley/IEmojiRepo;", "()V", "maxLength", "", "getMaxLength", "()I", "setMaxLength", "(I)V", "rootNode", "Lcom/tencent/mm/smiley/QQEmojiItemNode;", "getRootNode", "()Lcom/tencent/mm/smiley/QQEmojiItemNode;", "append", "", "item", "Lcom/tencent/mm/smiley/QQEmojiItem;", "fixSelection", "content", "", "selection", "process", "start", "end", "matchCallback", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "processOne", "Lcom/tencent/mm/smiley/IEmojiItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public final s acyv;
  public int maxLength;
  
  public t()
  {
    AppMethodBeat.i(242827);
    this.acyv = new s();
    AppMethodBeat.o(242827);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(242828);
    kotlin.g.b.s.u(paramr, "item");
    this.acyv.a((l)paramr, 0);
    this.maxLength = Math.max(this.maxLength, paramr.mdx.length);
    AppMethodBeat.o(242828);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(242831);
    kotlin.g.b.s.u(paramm, "matchCallback");
    new f((n)this.acyv).b(paramCharSequence, paramInt1, paramInt2, paramm);
    AppMethodBeat.o(242831);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/smiley/QQEmojiRepo$fixSelection$1", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "onMatch", "", "item", "Lcom/tencent/mm/smiley/IEmojiItem;", "startIndex", "", "endIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m
  {
    public a(int paramInt, ah.d paramd) {}
    
    public final boolean a(l paraml, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242824);
      kotlin.g.b.s.u(paraml, "item");
      if (paramInt2 > this.acyw)
      {
        if (paramInt1 < this.acyw) {
          this.CGr.aixb = paramInt2;
        }
        AppMethodBeat.o(242824);
        return true;
      }
      AppMethodBeat.o(242824);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/smiley/QQEmojiRepo$processOne$1", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "onMatch", "", "item", "Lcom/tencent/mm/smiley/IEmojiItem;", "startIndex", "", "endIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements m
  {
    b(ah.f<l> paramf) {}
    
    public final boolean a(l paraml, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242803);
      kotlin.g.b.s.u(paraml, "item");
      this.Exw.aqH = paraml;
      AppMethodBeat.o(242803);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.t
 * JD-Core Version:    0.7.0.1
 */