package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.k.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/text/MatchResult;", "", "destructured", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "Destructured", "kotlin-stdlib"})
public abstract interface i
{
  public abstract String getValue();
  
  public abstract List<String> iQA();
  
  public abstract a iQB();
  
  public abstract e iQy();
  
  public abstract g iQz();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/text/MatchResult$Destructured;", "", "match", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)V", "getMatch", "()Lkotlin/text/MatchResult;", "component1", "", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "toList", "", "kotlin-stdlib"})
  public static final class a
  {
    public final i abvD;
    
    public a(i parami)
    {
      AppMethodBeat.i(129448);
      this.abvD = parami;
      AppMethodBeat.o(129448);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.n.i
 * JD-Core Version:    0.7.0.1
 */