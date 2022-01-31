package com.tencent.tencentmap.mapsdk.a;

public class ne
{
  private qb a = qb.a;
  
  protected int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 % paramInt2;
    paramInt1 = i;
    if (i * paramInt2 < 0) {
      paramInt1 = i + paramInt2;
    }
    return paramInt1;
  }
  
  public qb a()
  {
    return this.a;
  }
  
  public String a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = nb.e();
    if (str == null) {
      return null;
    }
    int[] arrayOfInt = nb.h();
    if (arrayOfInt.length == 0) {}
    for (str = str.replaceFirst("\\{range\\}", "");; str = str.replaceFirst("\\{range\\}", Integer.toString(a(paramInt1 + paramInt2, arrayOfInt.length))))
    {
      str = str.replaceFirst("\\{z\\}", Integer.toString(paramInt3)).replaceFirst("\\{x\\}", Integer.toString(paramInt1)).replaceFirst("\\{y\\}", Integer.toString(paramInt2)).replaceFirst("\\{style\\}", Integer.toString(nb.a())).replaceFirst("\\{scene\\}", Integer.toString(nb.b())).replaceFirst("\\{version\\}", Integer.toString(nb.c())).replaceFirst("\\{ch\\}", this.a.name());
      return str + "&foreignLanguage=" + this.a.name();
    }
  }
  
  public void a(qb paramqb)
  {
    this.a = paramqb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ne
 * JD-Core Version:    0.7.0.1
 */