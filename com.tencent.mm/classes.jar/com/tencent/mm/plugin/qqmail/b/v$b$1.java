package com.tencent.mm.plugin.qqmail.b;

final class v$b$1
  implements Runnable
{
  v$b$1(v.b paramb) {}
  
  public final void run()
  {
    if (v.b.a(this.nex) != null) {
      v.b.a(this.nex).cancel();
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|onCancelled";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v.b.1
 * JD-Core Version:    0.7.0.1
 */