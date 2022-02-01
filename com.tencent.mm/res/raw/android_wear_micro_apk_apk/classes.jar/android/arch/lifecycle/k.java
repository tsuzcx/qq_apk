package android.arch.lifecycle;

final class k
{
  g O;
  GenericLifecycleObserver V;
  
  k(h paramh, g paramg)
  {
    this.V = m.c(paramh);
    this.O = paramg;
  }
  
  final void b(i parami, f paramf)
  {
    g localg = j.b(paramf);
    this.O = j.a(this.O, localg);
    this.V.a(parami, paramf);
    this.O = localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.k
 * JD-Core Version:    0.7.0.1
 */