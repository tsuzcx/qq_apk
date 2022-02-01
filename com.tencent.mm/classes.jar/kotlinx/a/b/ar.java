package kotlinx.a.b;

import d.g.b.p;
import d.l;
import kotlinx.a.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/internal/TaggedDecoder;", "", "rootName", "(Ljava/lang/String;)V", "getRootName", "()Ljava/lang/String;", "composeName", "parentName", "childName", "elementName", "desc", "Lkotlinx/serialization/SerialDescriptor;", "index", "", "nested", "nestedName", "getTag", "kotlinx-serialization-runtime"})
public abstract class ar
  extends bg<String>
{
  private final String OjL;
  
  private ar(String paramString)
  {
    this.OjL = paramString;
  }
  
  protected final String k(n paramn, int paramInt)
  {
    p.h(paramn, "$this$getTag");
    String str2 = m(paramn, paramInt);
    p.h(str2, "nestedName");
    String str1 = (String)gBC();
    paramn = str1;
    if (str1 == null) {
      paramn = this.OjL;
    }
    return nM(paramn, str2);
  }
  
  public String m(n paramn, int paramInt)
  {
    p.h(paramn, "desc");
    return paramn.amt(paramInt);
  }
  
  public String nM(String paramString1, String paramString2)
  {
    p.h(paramString1, "parentName");
    p.h(paramString2, "childName");
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramString2;
    }
    return paramString1 + '.' + paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ar
 * JD-Core Version:    0.7.0.1
 */