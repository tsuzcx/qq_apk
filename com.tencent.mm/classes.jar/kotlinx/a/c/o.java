package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonPrimitive;", "number", "", "(Ljava/lang/Number;)V", "boolean", "", "(Z)V", "string", "", "(Ljava/lang/String;)V", "body", "", "isString", "(Ljava/lang/Object;Z)V", "getBody", "()Ljava/lang/Object;", "content", "getContent", "()Ljava/lang/String;", "contentOrNull", "getContentOrNull", "()Z", "equals", "other", "hashCode", "", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class o
  extends v
{
  public static final o.a TZR;
  private final String TZO;
  private final Object TZP;
  public final boolean TZQ;
  final String content;
  
  static
  {
    AppMethodBeat.i(225775);
    TZR = new o.a((byte)0);
    AppMethodBeat.o(225775);
  }
  
  public o(Object paramObject, boolean paramBoolean)
  {
    super((byte)0);
    AppMethodBeat.i(225773);
    this.TZP = paramObject;
    this.TZQ = paramBoolean;
    this.content = this.TZP.toString();
    this.TZO = this.content;
    AppMethodBeat.o(225773);
  }
  
  public o(String paramString)
  {
    this(paramString, true);
    AppMethodBeat.i(225774);
    AppMethodBeat.o(225774);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225771);
    if ((o)this == paramObject)
    {
      AppMethodBeat.o(225771);
      return true;
    }
    if ((paramObject == null) || ((kotlin.g.b.p.j(aa.bp(getClass()), aa.bp(paramObject.getClass())) ^ true)))
    {
      AppMethodBeat.o(225771);
      return false;
    }
    if (this.TZQ != ((o)paramObject).TZQ)
    {
      AppMethodBeat.o(225771);
      return false;
    }
    if ((kotlin.g.b.p.j(this.content, ((o)paramObject).content) ^ true))
    {
      AppMethodBeat.o(225771);
      return false;
    }
    AppMethodBeat.o(225771);
    return true;
  }
  
  public final String getContent()
  {
    return this.content;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(225772);
    int i = Boolean.valueOf(this.TZQ).hashCode();
    int j = this.content.hashCode();
    AppMethodBeat.o(225772);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225770);
    if (this.TZQ)
    {
      localObject = new StringBuilder();
      kotlinx.a.c.a.p.b((StringBuilder)localObject, this.content);
      localObject = ((StringBuilder)localObject).toString();
      kotlin.g.b.p.g(localObject, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(225770);
      return localObject;
    }
    Object localObject = this.content;
    AppMethodBeat.o(225770);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.o
 * JD-Core Version:    0.7.0.1
 */