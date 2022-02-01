package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KAnnotatedElement;", "index", "", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "isVararg$annotations", "()V", "kind", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "Kind", "kotlin-stdlib"})
public abstract interface j
{
  public abstract boolean FI();
  
  public abstract String getName();
  
  public abstract o hyl();
  
  public abstract a hym();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/KParameter$Kind;", "", "(Ljava/lang/String;I)V", "INSTANCE", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(129544);
      a locala1 = new a("INSTANCE", 0);
      SZi = locala1;
      a locala2 = new a("EXTENSION_RECEIVER", 1);
      SZj = locala2;
      a locala3 = new a("VALUE", 2);
      SZk = locala3;
      SZl = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(129544);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.j
 * JD-Core Version:    0.7.0.1
 */