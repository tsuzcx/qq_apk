package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.k.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/text/MatchResult;", "", "destructured", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "Destructured", "kotlin-stdlib"})
public abstract interface i
{
  public abstract String getValue();
  
  public abstract f hMg();
  
  public abstract g hMh();
  
  public abstract List<String> hMi();
  
  public abstract a hMj();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/text/MatchResult$Destructured;", "", "match", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)V", "getMatch", "()Lkotlin/text/MatchResult;", "component1", "", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "toList", "", "kotlin-stdlib"})
  public static final class a
  {
    public final i TTa;
    
    public a(i parami)
    {
      AppMethodBeat.i(129448);
      this.TTa = parami;
      AppMethodBeat.o(129448);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.i
 * JD-Core Version:    0.7.0.1
 */