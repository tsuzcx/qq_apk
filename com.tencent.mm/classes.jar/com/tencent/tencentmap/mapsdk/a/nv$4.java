package com.tencent.tencentmap.mapsdk.a;

class nv$4
  implements is
{
  boolean a = false;
  
  nv$4(nv paramnv) {}
  
  public void a()
  {
    if (!this.a) {
      this.a = true;
    }
    if (nv.a(this.b).p != null) {
      nv.a(this.b).post(new Runnable()
      {
        public void run()
        {
          if ((nv.a(nv.4.this.b) != null) && (nv.a(nv.4.this.b).p != null))
          {
            nv.a(nv.4.this.b).p.a();
            nv.a(nv.4.this.b).p = null;
          }
        }
      });
    }
    nv.a(this.b).a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nv.4
 * JD-Core Version:    0.7.0.1
 */