package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.t;
import kotlinx.a.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"InvalidFloatingPoint", "Lkotlinx/serialization/json/JsonEncodingException;", "value", "", "type", "", "output", "key", "InvalidKeyKindException", "keyDescriptor", "Lkotlinx/serialization/SerialDescriptor;", "JsonDecodingException", "Lkotlinx/serialization/json/JsonDecodingException;", "offset", "", "message", "input", "UnknownKeyException", "minify", "kotlinx-serialization-runtime"})
public final class l
{
  public static final j a(Number paramNumber, String paramString1, String paramString2)
  {
    AppMethodBeat.i(256435);
    p.k(paramNumber, "value");
    p.k(paramString1, "type");
    p.k(paramString2, "output");
    paramNumber = new j("'" + paramNumber + "' is not a valid '" + paramString1 + "' as per JSON specification. You can enable 'serializeSpecialFloatingPointValues' property to serialize such values\nCurrent output: " + iF(paramString2, -1));
    AppMethodBeat.o(256435);
    return paramNumber;
  }
  
  public static final e ak(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(256430);
    p.k(paramString1, "message");
    p.k(paramString2, "input");
    paramString1 = new e(paramInt, paramString1 + ".\n JSON input: " + iF(paramString2, paramInt));
    AppMethodBeat.o(256430);
    return paramString1;
  }
  
  public static final j f(n paramn)
  {
    AppMethodBeat.i(256437);
    p.k(paramn, "keyDescriptor");
    paramn = new j("Value of type '" + paramn.iTF() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + paramn.iTG() + ".'\nYou can convert such maps to arrays [key1, value1, key2, value2,...] using 'allowStructuredMapKeys' property in JsonConfiguration");
    AppMethodBeat.o(256437);
    return paramn;
  }
  
  public static final String iF(String paramString, int paramInt)
  {
    AppMethodBeat.i(256439);
    if (paramString.length() < 200)
    {
      AppMethodBeat.o(256439);
      return paramString;
    }
    Object localObject;
    if (paramInt == -1)
    {
      paramInt = paramString.length() - 60;
      if (paramInt <= 0)
      {
        AppMethodBeat.o(256439);
        return paramString;
      }
      localObject = new StringBuilder(".....");
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(256439);
        throw paramString;
      }
      paramString = paramString.substring(paramInt);
      p.j(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = paramString;
      AppMethodBeat.o(256439);
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
      i = i.ov(i, 0);
      paramInt = i.ow(paramInt, paramString.length());
      if (paramString != null) {
        break label195;
      }
      paramString = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(256439);
      throw paramString;
      localObject = ".....";
      break;
    }
    label195:
    paramString = paramString.substring(i, paramInt);
    p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramString = paramString + str;
    AppMethodBeat.o(256439);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.l
 * JD-Core Version:    0.7.0.1
 */