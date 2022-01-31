package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cz;
import com.tencent.tencentmap.mapsdk.a.f.a;
import java.lang.reflect.Type;

public class fp
  implements dp<f.a>
{
  public f.a a(dq paramdq, Type paramType, do paramdo)
  {
    AppMethodBeat.i(147955);
    paramType = new f.a();
    paramdq = paramdq.c();
    if (TextUtils.isEmpty(paramdq))
    {
      AppMethodBeat.o(147955);
      return null;
    }
    paramdq = paramdq.split(",");
    if (paramdq.length == 4)
    {
      paramType.b = new cz(Double.valueOf(paramdq[0]).doubleValue(), Double.valueOf(paramdq[1]).doubleValue());
      paramType.a = new cz(Double.valueOf(paramdq[2]).doubleValue(), Double.valueOf(paramdq[3]).doubleValue());
      AppMethodBeat.o(147955);
      return paramType;
    }
    AppMethodBeat.o(147955);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fp
 * JD-Core Version:    0.7.0.1
 */