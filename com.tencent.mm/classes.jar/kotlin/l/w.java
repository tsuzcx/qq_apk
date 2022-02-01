package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class w
{
  public static final w aixL;
  public static final w.a aixM;
  public final y aixJ;
  public final u aixK;
  
  static
  {
    AppMethodBeat.i(129547);
    aixM = new w.a((byte)0);
    aixL = new w(null, null);
    AppMethodBeat.o(129547);
  }
  
  public w(y paramy, u paramu)
  {
    AppMethodBeat.i(191286);
    this.aixJ = paramy;
    this.aixK = paramu;
    int i;
    int j;
    if (this.aixJ == null)
    {
      i = 1;
      if (this.aixK != null) {
        break label91;
      }
      j = 1;
      label41:
      if (i != j) {
        break label97;
      }
      i = k;
      label50:
      if (i != 0) {
        break label130;
      }
      if (this.aixJ != null) {
        break label102;
      }
    }
    label91:
    label97:
    label102:
    for (paramy = "Star projection must have no type specified.";; paramy = "The projection variance " + this.aixJ + " requires type to be specified.")
    {
      paramy = (Throwable)new IllegalArgumentException(paramy.toString());
      AppMethodBeat.o(191286);
      throw paramy;
      i = 0;
      break;
      j = 0;
      break label41;
      i = 0;
      break label50;
    }
    label130:
    AppMethodBeat.o(191286);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129550);
    if (this != paramObject)
    {
      if ((paramObject instanceof w))
      {
        paramObject = (w)paramObject;
        if ((!s.p(this.aixJ, paramObject.aixJ)) || (!s.p(this.aixK, paramObject.aixK))) {}
      }
    }
    else
    {
      AppMethodBeat.o(129550);
      return true;
    }
    AppMethodBeat.o(129550);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(129549);
    Object localObject = this.aixJ;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.aixK;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(129549);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129548);
    Object localObject = this.aixJ;
    if (localObject == null)
    {
      AppMethodBeat.o(129548);
      return "*";
    }
    switch (x.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      localObject = new p();
      AppMethodBeat.o(129548);
      throw ((Throwable)localObject);
    case 1: 
      localObject = String.valueOf(this.aixK);
      AppMethodBeat.o(129548);
      return localObject;
    case 2: 
      localObject = "in " + this.aixK;
      AppMethodBeat.o(129548);
      return localObject;
    }
    localObject = "out " + this.aixK;
    AppMethodBeat.o(129548);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.w
 * JD-Core Version:    0.7.0.1
 */