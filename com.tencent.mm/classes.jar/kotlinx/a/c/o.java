package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.z;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonPrimitive;", "number", "", "(Ljava/lang/Number;)V", "boolean", "", "(Z)V", "string", "", "(Ljava/lang/String;)V", "body", "", "isString", "(Ljava/lang/Object;Z)V", "getBody", "()Ljava/lang/Object;", "content", "getContent", "()Ljava/lang/String;", "contentOrNull", "getContentOrNull", "()Z", "equals", "other", "hashCode", "", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class o
  extends v
{
  public static final a NNO;
  private final String NNL;
  private final Object NNM;
  public final boolean NNN;
  final String content;
  
  static
  {
    AppMethodBeat.i(191414);
    NNO = new a((byte)0);
    AppMethodBeat.o(191414);
  }
  
  public o(Object paramObject, boolean paramBoolean)
  {
    super((byte)0);
    AppMethodBeat.i(191412);
    this.NNM = paramObject;
    this.NNN = paramBoolean;
    this.content = this.NNM.toString();
    this.NNL = this.content;
    AppMethodBeat.o(191412);
  }
  
  public o(String paramString)
  {
    this(paramString, true);
    AppMethodBeat.i(191413);
    AppMethodBeat.o(191413);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191410);
    if ((o)this == paramObject)
    {
      AppMethodBeat.o(191410);
      return true;
    }
    if ((paramObject == null) || ((d.g.b.p.i(z.bp(getClass()), z.bp(paramObject.getClass())) ^ true)))
    {
      AppMethodBeat.o(191410);
      return false;
    }
    if (this.NNN != ((o)paramObject).NNN)
    {
      AppMethodBeat.o(191410);
      return false;
    }
    if ((d.g.b.p.i(this.content, ((o)paramObject).content) ^ true))
    {
      AppMethodBeat.o(191410);
      return false;
    }
    AppMethodBeat.o(191410);
    return true;
  }
  
  public final String getContent()
  {
    return this.content;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191411);
    int i = Boolean.valueOf(this.NNN).hashCode();
    int j = this.content.hashCode();
    AppMethodBeat.o(191411);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191409);
    if (this.NNN)
    {
      localObject = new StringBuilder();
      kotlinx.a.c.a.p.b((StringBuilder)localObject, this.content);
      localObject = ((StringBuilder)localObject).toString();
      d.g.b.p.g(localObject, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(191409);
      return localObject;
    }
    Object localObject = this.content;
    AppMethodBeat.o(191409);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/JsonLiteral$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "kotlinx-serialization-runtime"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.o
 * JD-Core Version:    0.7.0.1
 */