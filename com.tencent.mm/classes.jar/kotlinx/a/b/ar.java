package kotlinx.a.b;

import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/internal/TaggedDecoder;", "", "rootName", "(Ljava/lang/String;)V", "getRootName", "()Ljava/lang/String;", "composeName", "parentName", "childName", "elementName", "desc", "Lkotlinx/serialization/SerialDescriptor;", "index", "", "nested", "nestedName", "getTag", "kotlinx-serialization-runtime"})
public abstract class ar
  extends bg<String>
{
  private final String abBV;
  
  private ar(String paramString)
  {
    this.abBV = paramString;
  }
  
  protected final String k(n paramn, int paramInt)
  {
    p.k(paramn, "$this$getTag");
    String str2 = m(paramn, paramInt);
    p.k(str2, "nestedName");
    String str1 = (String)iTQ();
    paramn = str1;
    if (str1 == null) {
      paramn = this.abBV;
    }
    return pA(paramn, str2);
  }
  
  public String m(n paramn, int paramInt)
  {
    p.k(paramn, "desc");
    return paramn.aFX(paramInt);
  }
  
  public String pA(String paramString1, String paramString2)
  {
    p.k(paramString1, "parentName");
    p.k(paramString2, "childName");
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramString2;
    }
    return paramString1 + '.' + paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.ar
 * JD-Core Version:    0.7.0.1
 */