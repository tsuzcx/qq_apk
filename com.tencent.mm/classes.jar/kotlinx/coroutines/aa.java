package kotlinx.coroutines;

import a.c.a;
import a.c.e;
import a.c.e.b;
import a.c.e.b.a;
import a.c.e.c;
import a.f.a.m;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"})
public final class aa
  extends a
  implements bq<String>
{
  public static final aa.a CHz;
  final long id;
  
  static
  {
    AppMethodBeat.i(118554);
    CHz = new aa.a((byte)0);
    AppMethodBeat.o(118554);
  }
  
  public aa(long paramLong)
  {
    super((e.c)CHz);
    AppMethodBeat.i(118553);
    this.id = paramLong;
    AppMethodBeat.o(118553);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof aa)) {
        break label46;
      }
      paramObject = (aa)paramObject;
      if (this.id != paramObject.id) {
        break label48;
      }
    }
    label46:
    label48:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super e.b, ? extends R> paramm)
  {
    AppMethodBeat.i(118555);
    j.q(paramm, "operation");
    j.q(paramm, "operation");
    paramR = e.b.a.a((e.b)this, paramR, paramm);
    AppMethodBeat.o(118555);
    return paramR;
  }
  
  public final <E extends e.b> E get(e.c<E> paramc)
  {
    AppMethodBeat.i(118556);
    j.q(paramc, "key");
    j.q(paramc, "key");
    paramc = e.b.a.a((e.b)this, paramc);
    AppMethodBeat.o(118556);
    return paramc;
  }
  
  public final int hashCode()
  {
    long l = this.id;
    return (int)(l ^ l >>> 32);
  }
  
  public final e minusKey(e.c<?> paramc)
  {
    AppMethodBeat.i(118557);
    j.q(paramc, "key");
    j.q(paramc, "key");
    paramc = e.b.a.b((e.b)this, paramc);
    AppMethodBeat.o(118557);
    return paramc;
  }
  
  public final e plus(e parame)
  {
    AppMethodBeat.i(118558);
    j.q(parame, "context");
    j.q(parame, "context");
    parame = e.b.a.a((e.b)this, parame);
    AppMethodBeat.o(118558);
    return parame;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118550);
    String str = "CoroutineId(" + this.id + ')';
    AppMethodBeat.o(118550);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.aa
 * JD-Core Version:    0.7.0.1
 */