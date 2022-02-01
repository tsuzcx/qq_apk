package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.z;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonPrimitive;", "number", "", "(Ljava/lang/Number;)V", "boolean", "", "(Z)V", "string", "", "(Ljava/lang/String;)V", "body", "", "isString", "(Ljava/lang/Object;Z)V", "getBody", "()Ljava/lang/Object;", "content", "getContent", "()Ljava/lang/String;", "contentOrNull", "getContentOrNull", "()Z", "equals", "other", "hashCode", "", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class o
  extends v
{
  public static final a OkU;
  private final String OkR;
  private final Object OkS;
  public final boolean OkT;
  final String content;
  
  static
  {
    AppMethodBeat.i(200002);
    OkU = new a((byte)0);
    AppMethodBeat.o(200002);
  }
  
  public o(Object paramObject, boolean paramBoolean)
  {
    super((byte)0);
    AppMethodBeat.i(200000);
    this.OkS = paramObject;
    this.OkT = paramBoolean;
    this.content = this.OkS.toString();
    this.OkR = this.content;
    AppMethodBeat.o(200000);
  }
  
  public o(String paramString)
  {
    this(paramString, true);
    AppMethodBeat.i(200001);
    AppMethodBeat.o(200001);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199998);
    if ((o)this == paramObject)
    {
      AppMethodBeat.o(199998);
      return true;
    }
    if ((paramObject == null) || ((d.g.b.p.i(z.bp(getClass()), z.bp(paramObject.getClass())) ^ true)))
    {
      AppMethodBeat.o(199998);
      return false;
    }
    if (this.OkT != ((o)paramObject).OkT)
    {
      AppMethodBeat.o(199998);
      return false;
    }
    if ((d.g.b.p.i(this.content, ((o)paramObject).content) ^ true))
    {
      AppMethodBeat.o(199998);
      return false;
    }
    AppMethodBeat.o(199998);
    return true;
  }
  
  public final String getContent()
  {
    return this.content;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(199999);
    int i = Boolean.valueOf(this.OkT).hashCode();
    int j = this.content.hashCode();
    AppMethodBeat.o(199999);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199997);
    if (this.OkT)
    {
      localObject = new StringBuilder();
      kotlinx.a.c.a.p.b((StringBuilder)localObject, this.content);
      localObject = ((StringBuilder)localObject).toString();
      d.g.b.p.g(localObject, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(199997);
      return localObject;
    }
    Object localObject = this.content;
    AppMethodBeat.o(199997);
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/JsonLiteral$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "kotlinx-serialization-runtime"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.o
 * JD-Core Version:    0.7.0.1
 */