package kotlinx.a.d;

import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.b.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/internal/TaggedDecoder;", "", "rootName", "(Ljava/lang/String;)V", "getRootName", "()Ljava/lang/String;", "composeName", "parentName", "childName", "elementName", "desc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "nested", "nestedName", "getTag", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class ab
  extends am<String>
{
  private final String ajDF;
  
  private ab(String paramString)
  {
    this.ajDF = paramString;
  }
  
  protected final String e(e parame, int paramInt)
  {
    s.u(parame, "$this$getTag");
    String str2 = g(parame, paramInt);
    s.u(str2, "nestedName");
    String str1 = (String)kFy();
    parame = str1;
    if (str1 == null) {
      parame = this.ajDF;
    }
    return rx(parame, str2);
  }
  
  protected String g(e parame, int paramInt)
  {
    s.u(parame, "desc");
    return parame.aMK(paramInt);
  }
  
  protected String rx(String paramString1, String paramString2)
  {
    s.u(paramString1, "parentName");
    s.u(paramString2, "childName");
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramString2;
    }
    return paramString1 + '.' + paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.ab
 * JD-Core Version:    0.7.0.1
 */