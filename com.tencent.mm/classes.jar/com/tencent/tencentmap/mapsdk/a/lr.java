package com.tencent.tencentmap.mapsdk.a;

public class lr
{
  public static double a(qc paramqc1, qc paramqc2, qc paramqc3)
  {
    double d2 = b(paramqc1, paramqc2);
    double d3 = b(paramqc1, paramqc3);
    double d4 = b(paramqc2, paramqc3);
    if (d2 + d3 == d4) {
      d1 = 0.0D;
    }
    do
    {
      do
      {
        return d1;
        d1 = d2;
      } while (d4 <= 1.0E-006D);
      d1 = d2;
    } while (d3 * d3 >= d2 * d2 + d4 * d4);
    if (d2 * d2 >= d3 * d3 + d4 * d4) {
      return d3;
    }
    double d1 = (d2 + d3 + d4) / 2.0D;
    return Math.sqrt((d1 - d2) * d1 * (d1 - d3) * (d1 - d4)) * 2.0D / d4;
  }
  
  public static qc a(qc paramqc1, qc paramqc2, int paramInt)
  {
    double d1;
    if (paramqc2.b > paramqc1.b)
    {
      d1 = paramqc1.b - paramInt;
      if (paramqc2.a <= paramqc1.a) {
        break label63;
      }
    }
    label63:
    for (double d2 = paramqc1.a - paramInt;; d2 = paramqc1.a + paramInt)
    {
      return new qc(d2, d1);
      d1 = paramqc1.b + paramInt;
      break;
    }
  }
  
  public static boolean a(qc paramqc1, double paramDouble, qc paramqc2, qc paramqc3)
  {
    if (a(paramqc1, paramqc2, paramqc3) - paramDouble > 1.0E-006D) {
      return false;
    }
    return c(b(paramqc1, paramqc2, paramqc3), paramqc2, paramqc3);
  }
  
  public static double[] a(qc paramqc1, qc paramqc2)
  {
    double d1;
    double d2;
    if (Math.abs(paramqc1.b - paramqc2.b) < 1.0E-006D)
    {
      d1 = (0.0D / 0.0D);
      d2 = (0.0D / 0.0D);
    }
    for (;;)
    {
      return new double[] { d2, d1 };
      if (Math.abs(paramqc1.a - paramqc2.a) < 1.0E-006D)
      {
        d1 = paramqc1.a;
        d2 = 0.0D;
      }
      else
      {
        d2 = (paramqc2.a - paramqc1.a) / (paramqc2.b - paramqc1.b);
        d1 = (paramqc2.b * paramqc1.a - paramqc1.b * paramqc2.a) / (paramqc2.b - paramqc1.a);
      }
    }
  }
  
  public static double b(qc paramqc1, qc paramqc2)
  {
    double d1 = paramqc1.b - paramqc2.b;
    double d2 = paramqc1.a - paramqc2.a;
    return Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public static qc b(qc paramqc1, qc paramqc2, qc paramqc3)
  {
    paramqc3 = a(paramqc2, paramqc3);
    double d2;
    double d1;
    if (Double.isNaN(paramqc3[0]))
    {
      d2 = paramqc2.b;
      d1 = paramqc1.a;
    }
    for (;;)
    {
      return new qc(d1, d2);
      if (paramqc3[0] == 0.0D)
      {
        d2 = paramqc1.b;
        d1 = paramqc2.a;
      }
      else
      {
        d1 = paramqc3[0];
        d2 = d1 * d1;
        d2 = (paramqc2.b * d2 + (paramqc1.a - paramqc2.a) * d1 + paramqc1.b) / (d2 + 1.0D);
        d1 = d1 * (d2 - paramqc2.b) + paramqc2.a;
      }
    }
  }
  
  public static double c(qc paramqc1, qc paramqc2)
  {
    double d4 = paramqc1.b;
    double d3 = paramqc1.a;
    double d2 = paramqc2.b;
    double d1 = paramqc2.a;
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
    paramqc1 = new double[3];
    paramqc2 = new double[3];
    paramqc1[0] = (d5 * d6);
    paramqc1[1] = (d6 * d1);
    paramqc1[2] = d2;
    paramqc2[0] = (d4 * d3);
    paramqc2[1] = (d4 * d7);
    paramqc2[2] = d8;
    return Math.asin(Math.sqrt((paramqc1[0] - paramqc2[0]) * (paramqc1[0] - paramqc2[0]) + (paramqc1[1] - paramqc2[1]) * (paramqc1[1] - paramqc2[1]) + (paramqc1[2] - paramqc2[2]) * (paramqc1[2] - paramqc2[2])) / 2.0D) * 12742001.579854401D;
  }
  
  public static boolean c(qc paramqc1, qc paramqc2, qc paramqc3)
  {
    double d1 = b(paramqc1, paramqc2);
    double d2 = b(paramqc1, paramqc3);
    return b(paramqc2, paramqc3) - d1 - d2 < 1.0E-006D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lr
 * JD-Core Version:    0.7.0.1
 */