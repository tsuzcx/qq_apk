package com.tencent.mm.plugin.shake.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/shake/util/PcmAmplitudeCheckUtil;", "", "()V", "RMS_TYPE_HIGH", "", "RMS_TYPE_LOW", "RMS_TYPE_MIDDLE", "RMS_TYPE_SILENT", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPcmAmplitude", "length", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a PEO;
  
  static
  {
    AppMethodBeat.i(273539);
    PEO = new a();
    AppMethodBeat.o(273539);
  }
  
  public static short[] E(byte[] paramArrayOfByte, int paramInt)
  {
    short[] arrayOfShort = new short[paramInt];
    paramInt = 0;
    int j = arrayOfShort.length - 1;
    if (j >= 0) {}
    for (;;)
    {
      int i = paramInt + 1;
      arrayOfShort[paramInt] = ((short)(paramArrayOfByte[(paramInt * 2)] & 0xFF | (paramArrayOfByte[(paramInt * 2 + 1)] & 0xFF) << 8));
      if (i > j) {
        return arrayOfShort;
      }
      paramInt = i;
    }
  }
  
  public static double h(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(273524);
    double d = 0.0D;
    int i = 0;
    int j = paramArrayOfShort.length;
    while (i < j)
    {
      int k = paramArrayOfShort[i];
      i += 1;
      d += k * k;
    }
    d = Math.sqrt(d / paramInt);
    AppMethodBeat.o(273524);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a
 * JD-Core Version:    0.7.0.1
 */