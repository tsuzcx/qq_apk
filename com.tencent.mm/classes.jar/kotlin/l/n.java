package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KAnnotatedElement;", "index", "", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "isVararg$annotations", "()V", "kind", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "Kind", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract interface n
{
  public abstract boolean ahk();
  
  public abstract String getName();
  
  public abstract u klN();
  
  public abstract a klO();
  
  public abstract boolean klP();
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/KParameter$Kind;", "", "(Ljava/lang/String;I)V", "INSTANCE", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(129544);
      a locala1 = new a("INSTANCE", 0);
      aixF = locala1;
      a locala2 = new a("EXTENSION_RECEIVER", 1);
      aixG = locala2;
      a locala3 = new a("VALUE", 2);
      aixH = locala3;
      aixI = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(129544);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.n
 * JD-Core Version:    0.7.0.1
 */