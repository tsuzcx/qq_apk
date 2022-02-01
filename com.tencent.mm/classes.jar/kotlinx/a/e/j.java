package kotlinx.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlinx.a.b.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"InvalidFloatingPoint", "Lkotlinx/serialization/json/JsonEncodingException;", "value", "", "type", "", "output", "key", "InvalidKeyKindException", "keyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "JsonDecodingException", "Lkotlinx/serialization/json/JsonDecodingException;", "offset", "", "message", "input", "UnknownKeyException", "minify", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class j
{
  public static final h a(Number paramNumber, String paramString1, String paramString2)
  {
    AppMethodBeat.i(188467);
    s.u(paramNumber, "value");
    s.u(paramString1, "type");
    s.u(paramString2, "output");
    paramNumber = new h("'" + paramNumber + "' is not a valid '" + paramString1 + "' as per JSON specification. You can enable 'serializeSpecialFloatingPointValues' property to serialize such values\nCurrent output: " + jQ(paramString2, -1));
    AppMethodBeat.o(188467);
    return paramNumber;
  }
  
  public static final d am(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(188462);
    s.u(paramString1, "message");
    s.u(paramString2, "input");
    paramString1 = new d(paramInt, paramString1 + ".\n JSON input: " + jQ(paramString2, paramInt));
    AppMethodBeat.o(188462);
    return paramString1;
  }
  
  public static final h i(e parame)
  {
    AppMethodBeat.i(188476);
    s.u(parame, "keyDescriptor");
    parame = new h("Value of type '" + parame.kFa() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + parame.kFd() + ".'\nYou can convert such maps to arrays [key1, value1, key2, value2,...] using 'JsonBuilder.allowStructuredMapKeys' property");
    AppMethodBeat.o(188476);
    return parame;
  }
  
  public static final String jQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(188491);
    if (paramString.length() < 200)
    {
      AppMethodBeat.o(188491);
      return paramString;
    }
    Object localObject;
    if (paramInt == -1)
    {
      paramInt = paramString.length() - 60;
      if (paramInt <= 0)
      {
        AppMethodBeat.o(188491);
        return paramString;
      }
      localObject = new StringBuilder(".....");
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(188491);
        throw paramString;
      }
      paramString = paramString.substring(paramInt);
      s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = paramString;
      AppMethodBeat.o(188491);
      return paramString;
    }
    int i = paramInt - 30;
    paramInt += 30;
    if (i <= 0)
    {
      localObject = "";
      if (paramInt < paramString.length()) {
        break label188;
      }
    }
    label188:
    for (String str = "";; str = ".....")
    {
      localObject = new StringBuilder().append((String)localObject);
      i = k.qu(i, 0);
      paramInt = k.qv(paramInt, paramString.length());
      if (paramString != null) {
        break label195;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(188491);
      throw paramString;
      localObject = ".....";
      break;
    }
    label195:
    paramString = paramString.substring(i, paramInt);
    s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramString = paramString + str;
    AppMethodBeat.o(188491);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.j
 * JD-Core Version:    0.7.0.1
 */