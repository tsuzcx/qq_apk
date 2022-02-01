package kotlinx.a.e;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlinx/serialization/json/JsonElement;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "isString", "", "()Z", "toString", "Companion", "Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonNull;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class n
  extends e
{
  public static final a ajEl = new a((byte)0);
  
  private n()
  {
    super((byte)0);
  }
  
  public abstract String getContent();
  
  public String toString()
  {
    return getContent();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/JsonPrimitive$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonPrimitive;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.e.n
 * JD-Core Version:    0.7.0.1
 */