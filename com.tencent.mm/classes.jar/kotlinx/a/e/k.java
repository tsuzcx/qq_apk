package kotlinx.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlinx.a.e.a.o;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonPrimitive;", "body", "", "isString", "", "(Ljava/lang/Object;Z)V", "content", "", "getContent", "()Ljava/lang/String;", "()Z", "equals", "other", "hashCode", "", "toString", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class k
  extends n
{
  public final boolean ajEg;
  private final String content;
  
  public k(Object paramObject, boolean paramBoolean)
  {
    super((byte)0);
    AppMethodBeat.i(188460);
    this.ajEg = paramBoolean;
    this.content = paramObject.toString();
    AppMethodBeat.o(188460);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188480);
    if ((k)this == paramObject)
    {
      AppMethodBeat.o(188480);
      return true;
    }
    if ((paramObject == null) || ((s.p(ai.cz(getClass()), ai.cz(paramObject.getClass())) ^ true)))
    {
      AppMethodBeat.o(188480);
      return false;
    }
    if (this.ajEg != ((k)paramObject).ajEg)
    {
      AppMethodBeat.o(188480);
      return false;
    }
    if ((s.p(this.content, ((k)paramObject).content) ^ true))
    {
      AppMethodBeat.o(188480);
      return false;
    }
    AppMethodBeat.o(188480);
    return true;
  }
  
  public final String getContent()
  {
    return this.content;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188492);
    int i = Boolean.valueOf(this.ajEg).hashCode();
    int j = this.content.hashCode();
    AppMethodBeat.o(188492);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188470);
    if (this.ajEg)
    {
      localObject = new StringBuilder();
      o.b((StringBuilder)localObject, this.content);
      localObject = ((StringBuilder)localObject).toString();
      s.s(localObject, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(188470);
      return localObject;
    }
    Object localObject = this.content;
    AppMethodBeat.o(188470);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.a.e.k
 * JD-Core Version:    0.7.0.1
 */