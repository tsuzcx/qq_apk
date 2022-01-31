package com.tencent.tencentmap.mapsdk.a;

final class cf<K, V>
{
  ce<K, V> a;
  ce<K, V> b;
  
  public final void a(ce<K, V> paramce)
  {
    if (paramce.c != null)
    {
      paramce.c.d = paramce.d;
      if (paramce.d == null) {
        break label63;
      }
      paramce.d.c = paramce.c;
    }
    label63:
    do
    {
      return;
      this.b = paramce.d;
      if (this.b == null) {
        break;
      }
      this.b.c = null;
      break;
      this.a = paramce.c;
    } while (this.a == null);
    this.a.d = null;
  }
  
  public final void b(ce<K, V> paramce)
  {
    if (this.a == null)
    {
      this.a = paramce;
      this.b = paramce;
      return;
    }
    paramce.c = this.a;
    this.a.d = paramce;
    this.a = paramce;
    this.a.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cf
 * JD-Core Version:    0.7.0.1
 */