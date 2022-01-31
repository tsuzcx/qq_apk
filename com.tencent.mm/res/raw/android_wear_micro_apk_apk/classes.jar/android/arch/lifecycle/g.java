package android.arch.lifecycle;

final class g
{
  a E;
  d u;
  
  final void b(e parame, c paramc)
  {
    d locald2 = f.b(paramc);
    d locald3 = this.u;
    d locald1 = locald3;
    if (locald2 != null)
    {
      locald1 = locald3;
      if (locald2.compareTo(locald3) < 0) {
        locald1 = locald2;
      }
    }
    this.u = locald1;
    this.E.a(parame, paramc);
    this.u = locald2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.g
 * JD-Core Version:    0.7.0.1
 */