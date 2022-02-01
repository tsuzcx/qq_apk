package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"State_Done", "", "Lkotlin/sequences/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", "T", "builderAction", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "iterator", "block", "sequence", "SequenceBuilder", "Lkotlin/Deprecated;", "message", "Use SequenceScope class instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "SequenceScope<T>", "level", "Lkotlin/DeprecationLevel;", "ERROR", "State", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/sequences/SequencesKt")
public class l
{
  public static final <T> h<T> w(m<? super j<? super T>, ? super d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(190936);
    s.u(paramm, "block");
    paramm = (h)new a(paramm);
    AppMethodBeat.o(190936);
    return paramm;
  }
  
  @Metadata(d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements h<T>
  {
    public a(m paramm) {}
    
    public final Iterator<T> iterator()
    {
      AppMethodBeat.i(190939);
      Object localObject = this.aMg;
      s.u(localObject, "block");
      i locali = new i();
      locali.ajuo = b.a((m)localObject, locali, (d)locali);
      localObject = (Iterator)locali;
      AppMethodBeat.o(190939);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.m.l
 * JD-Core Version:    0.7.0.1
 */