package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/text/MatchResult;", "", "destructured", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "Destructured", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract interface i
{
  public abstract String getValue();
  
  public abstract kotlin.k.g kBn();
  
  public abstract g kBo();
  
  public abstract List<String> kBp();
  
  public abstract a kBq();
  
  public abstract i kBr();
  
  @Metadata(d1={""}, d2={"Lkotlin/text/MatchResult$Destructured;", "", "match", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)V", "getMatch", "()Lkotlin/text/MatchResult;", "component1", "", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "toList", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
  {
    public final i ajuL;
    
    public a(i parami)
    {
      AppMethodBeat.i(129448);
      this.ajuL = parami;
      AppMethodBeat.o(129448);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.n.i
 * JD-Core Version:    0.7.0.1
 */