package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.w;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/WeVisionUtil;", "", "()V", "Companion", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class d
{
  public static final a agXC;
  
  static
  {
    AppMethodBeat.i(234502);
    agXC = new a((byte)0);
    AppMethodBeat.o(234502);
  }
  
  public static final String[] cX(Map<String, String> paramMap)
  {
    AppMethodBeat.i(234508);
    paramMap = a.cX(paramMap);
    AppMethodBeat.o(234508);
    return paramMap;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/WeVisionUtil$Companion;", "", "()V", "getSdkVersion", "", "toStringArray", "", "", "strMap", "", "(Ljava/util/Map;)[Ljava/lang/String;", "renderlib_release"}, k=1, mv={1, 1, 15})
  public static final class a
  {
    public static String[] cX(Map<String, String> paramMap)
    {
      AppMethodBeat.i(234518);
      s.t(paramMap, "strMap");
      int j = paramMap.size() * 2;
      String[] arrayOfString1 = new String[j];
      int i = 0;
      while (i < j)
      {
        arrayOfString1[i] = new String();
        i += 1;
      }
      Object localObject = ((Collection)paramMap.keySet()).toArray(new String[0]);
      if (localObject == null)
      {
        paramMap = new w("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(234518);
        throw paramMap;
      }
      String[] arrayOfString2 = (String[])localObject;
      j = arrayOfString2.length;
      i = 0;
      while (i < j)
      {
        arrayOfString1[(i * 2)] = arrayOfString2[i];
        String str = (String)paramMap.get(arrayOfString2[i]);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        arrayOfString1[(i * 2 + 1)] = localObject;
        i += 1;
      }
      AppMethodBeat.o(234518);
      return arrayOfString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xeffect.d
 * JD-Core Version:    0.7.0.1
 */