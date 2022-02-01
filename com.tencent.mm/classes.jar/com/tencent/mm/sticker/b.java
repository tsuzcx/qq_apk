package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.g.b.s;
import kotlin.k.k;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"toDoubleArray", "", "Lorg/json/JSONArray;", "toJsonArray", "plugin-sticker_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final double[] ac(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(105887);
    s.u(paramJSONArray, "<this>");
    double[] arrayOfDouble = new double[paramJSONArray.length()];
    Iterator localIterator = ((Iterable)k.qt(0, paramJSONArray.length())).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ah)localIterator).Zo();
      arrayOfDouble[i] = paramJSONArray.getDouble(i);
    }
    AppMethodBeat.o(105887);
    return arrayOfDouble;
  }
  
  public static final JSONArray e(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(105888);
    s.u(paramArrayOfDouble, "<this>");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.b
 * JD-Core Version:    0.7.0.1
 */