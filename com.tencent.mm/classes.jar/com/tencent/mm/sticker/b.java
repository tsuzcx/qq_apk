package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import org.json.JSONArray;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"toDoubleArray", "", "Lorg/json/JSONArray;", "toJsonArray", "plugin-sticker_release"})
public final class b
{
  public static final double[] W(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(105887);
    p.h(paramJSONArray, "$this$toDoubleArray");
    double[] arrayOfDouble = new double[paramJSONArray.length()];
    Iterator localIterator = ((Iterable)j.mY(0, paramJSONArray.length())).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      arrayOfDouble[i] = paramJSONArray.getDouble(i);
    }
    AppMethodBeat.o(105887);
    return arrayOfDouble;
  }
  
  public static final JSONArray c(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(105888);
    p.h(paramArrayOfDouble, "$this$toJsonArray");
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(paramArrayOfDouble[i]);
      i += 1;
    }
    AppMethodBeat.o(105888);
    return localJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.b
 * JD-Core Version:    0.7.0.1
 */