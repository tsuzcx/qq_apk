package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.t;
import kotlinx.a.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"InvalidFloatingPoint", "Lkotlinx/serialization/json/JsonEncodingException;", "value", "", "type", "", "output", "key", "InvalidKeyKindException", "keyDescriptor", "Lkotlinx/serialization/SerialDescriptor;", "JsonDecodingException", "Lkotlinx/serialization/json/JsonDecodingException;", "offset", "", "message", "input", "UnknownKeyException", "minify", "kotlinx-serialization-runtime"})
public final class l
{
  public static final j a(Number paramNumber, String paramString1, String paramString2)
  {
    AppMethodBeat.i(225748);
    p.h(paramNumber, "value");
    p.h(paramString1, "type");
    p.h(paramString2, "output");
    paramNumber = new j("'" + paramNumber + "' is not a valid '" + paramString1 + "' as per JSON specification. You can enable 'serializeSpecialFloatingPointValues' property to serialize such values\nCurrent output: " + hW(paramString2, -1));
    AppMethodBeat.o(225748);
    return paramNumber;
  }
  
  public static final e af(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(225747);
    p.h(paramString1, "message");
    p.h(paramString2, "input");
    paramString1 = new e(paramInt, paramString1 + ".\n JSON input: " + hW(paramString2, paramInt));
    AppMethodBeat.o(225747);
    return paramString1;
  }
  
  public static final j f(n paramn)
  {
    AppMethodBeat.i(225749);
    p.h(paramn, "keyDescriptor");
    paramn = new j("Value of type '" + paramn.hOz() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + paramn.hOA() + ".'\nYou can convert such maps to arrays [key1, value1, key2, value2,...] using 'allowStructuredMapKeys' property in JsonConfiguration");
    AppMethodBeat.o(225749);
    return paramn;
  }
  
  public static final String hW(String paramString, int paramInt)
  {
    AppMethodBeat.i(225750);
    if (paramString.length() < 200)
    {
      AppMethodBeat.o(225750);
      return paramString;
    }
    Object localObject;
    if (paramInt == -1)
    {
      paramInt = paramString.length() - 60;
      if (paramInt <= 0)
      {
        AppMethodBeat.o(225750);
        return paramString;
      }
      localObject = new StringBuilder(".....");
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(225750);
        throw paramString;
      }
      paramString = paramString.substring(paramInt);
      p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = paramString;
      AppMethodBeat.o(225750);
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
      i = kotlin.k.j.mZ(i, 0);
      paramInt = kotlin.k.j.na(paramInt, paramString.length());
      if (paramString != null) {
        break label195;
      }
      paramString = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(225750);
      throw paramString;
      localObject = ".....";
      break;
    }
    label195:
    paramString = paramString.substring(i, paramInt);
    p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramString = paramString + str;
    AppMethodBeat.o(225750);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.l
 * JD-Core Version:    0.7.0.1
 */