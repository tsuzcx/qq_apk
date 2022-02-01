package kotlinx.a.c;

import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlinx/serialization/json/JsonElement;", "()V", "boolean", "", "getBoolean", "()Z", "booleanOrNull", "getBooleanOrNull", "()Ljava/lang/Boolean;", "content", "", "getContent", "()Ljava/lang/String;", "contentOrNull", "getContentOrNull", "double", "", "getDouble", "()D", "doubleOrNull", "getDoubleOrNull", "()Ljava/lang/Double;", "float", "", "getFloat", "()F", "floatOrNull", "getFloatOrNull", "()Ljava/lang/Float;", "int", "", "getInt", "()I", "intOrNull", "getIntOrNull", "()Ljava/lang/Integer;", "long", "", "getLong", "()J", "longOrNull", "getLongOrNull", "()Ljava/lang/Long;", "primitive", "primitive$annotations", "getPrimitive", "()Lkotlinx/serialization/json/JsonPrimitive;", "toString", "Companion", "Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonNull;", "kotlinx-serialization-runtime"})
public abstract class v
  extends f
{
  public static final v.a Uac = new v.a((byte)0);
  private final v Uab = (v)this;
  
  private v()
  {
    super((byte)0);
  }
  
  public abstract String getContent();
  
  public final v hOP()
  {
    return this.Uab;
  }
  
  public String toString()
  {
    return getContent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.v
 * JD-Core Version:    0.7.0.1
 */