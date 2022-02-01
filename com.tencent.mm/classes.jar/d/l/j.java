package d.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KAnnotatedElement;", "index", "", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "isVararg$annotations", "()V", "kind", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "Kind", "kotlin-stdlib"})
public abstract interface j
{
  public abstract boolean bmP();
  
  public abstract o fOG();
  
  public abstract a fOH();
  
  public abstract String getName();
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/reflect/KParameter$Kind;", "", "(Ljava/lang/String;I)V", "INSTANCE", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(129544);
      a locala1 = new a("INSTANCE", 0);
      KVp = locala1;
      a locala2 = new a("EXTENSION_RECEIVER", 1);
      KVq = locala2;
      a locala3 = new a("VALUE", 2);
      KVr = locala3;
      KVs = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(129544);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.j
 * JD-Core Version:    0.7.0.1
 */