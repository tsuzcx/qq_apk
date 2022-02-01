package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.ab;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonPrimitive;", "number", "", "(Ljava/lang/Number;)V", "boolean", "", "(Z)V", "string", "", "(Ljava/lang/String;)V", "body", "", "isString", "(Ljava/lang/Object;Z)V", "getBody", "()Ljava/lang/Object;", "content", "getContent", "()Ljava/lang/String;", "contentOrNull", "getContentOrNull", "()Z", "equals", "other", "hashCode", "", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class o
  extends v
{
  public static final o.a abDf;
  private final String abDc;
  private final Object abDd;
  public final boolean abDe;
  final String content;
  
  static
  {
    AppMethodBeat.i(256713);
    abDf = new o.a((byte)0);
    AppMethodBeat.o(256713);
  }
  
  public o(Object paramObject, boolean paramBoolean)
  {
    super((byte)0);
    AppMethodBeat.i(256708);
    this.abDd = paramObject;
    this.abDe = paramBoolean;
    this.content = this.abDd.toString();
    this.abDc = this.content;
    AppMethodBeat.o(256708);
  }
  
  public o(String paramString)
  {
    this(paramString, true);
    AppMethodBeat.i(256711);
    AppMethodBeat.o(256711);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(256703);
    if ((o)this == paramObject)
    {
      AppMethodBeat.o(256703);
      return true;
    }
    if ((paramObject == null) || ((kotlin.g.b.p.h(ab.bO(getClass()), ab.bO(paramObject.getClass())) ^ true)))
    {
      AppMethodBeat.o(256703);
      return false;
    }
    if (this.abDe != ((o)paramObject).abDe)
    {
      AppMethodBeat.o(256703);
      return false;
    }
    if ((kotlin.g.b.p.h(this.content, ((o)paramObject).content) ^ true))
    {
      AppMethodBeat.o(256703);
      return false;
    }
    AppMethodBeat.o(256703);
    return true;
  }
  
  public final String getContent()
  {
    return this.content;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(256706);
    int i = Boolean.valueOf(this.abDe).hashCode();
    int j = this.content.hashCode();
    AppMethodBeat.o(256706);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(256700);
    if (this.abDe)
    {
      localObject = new StringBuilder();
      kotlinx.a.c.a.p.b((StringBuilder)localObject, this.content);
      localObject = ((StringBuilder)localObject).toString();
      kotlin.g.b.p.j(localObject, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(256700);
      return localObject;
    }
    Object localObject = this.content;
    AppMethodBeat.o(256700);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.o
 * JD-Core Version:    0.7.0.1
 */