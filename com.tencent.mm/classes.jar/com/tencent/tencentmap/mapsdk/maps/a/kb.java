package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cz;

public class kb
{
  public static double a(cz paramcz1, cz paramcz2)
  {
    AppMethodBeat.i(148940);
    double d4 = paramcz1.b;
    double d3 = paramcz1.a;
    double d2 = paramcz2.b;
    double d1 = paramcz2.a;
    double d5 = d4 * 0.01745329251994329D;
    double d6 = d3 * 0.01745329251994329D;
    d3 = d2 * 0.01745329251994329D;
    d4 = d1 * 0.01745329251994329D;
    d1 = Math.sin(d5);
    d2 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d3);
    double d8 = Math.sin(d4);
    d3 = Math.cos(d3);
    d4 = Math.cos(d4);
    paramcz1 = new double[3];
    paramcz2 = new double[3];
    paramcz1[0] = (d5 * d6);
    paramcz1[1] = (d6 * d1);
    paramcz1[2] = d2;
    paramcz2[0] = (d4 * d3);
    paramcz2[1] = (d4 * d7);
    paramcz2[2] = d8;
    d1 = Math.asin(Math.sqrt((paramcz1[0] - paramcz2[0]) * (paramcz1[0] - paramcz2[0]) + (paramcz1[1] - paramcz2[1]) * (paramcz1[1] - paramcz2[1]) + (paramcz1[2] - paramcz2[2]) * (paramcz1[2] - paramcz2[2])) / 2.0D);
    AppMethodBeat.o(148940);
    return d1 * 12742001.579854401D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kb
 * JD-Core Version:    0.7.0.1
 */