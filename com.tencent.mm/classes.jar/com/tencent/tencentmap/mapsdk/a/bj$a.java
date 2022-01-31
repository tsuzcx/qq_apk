package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.ConcurrentHashMap;

class bj$a
  implements cd<Integer, at>
{
  public void a(Integer paramInteger, at paramat, long paramLong)
  {
    if (paramat.g())
    {
      paramat.a(new bn("asyncMsg " + paramat.h() + " waiteResp timeout "));
      paramInteger = be.a(-7, paramat.h());
      paramInteger.a(paramat);
      this.a.g.e().a(paramInteger);
    }
    for (;;)
    {
      paramInteger = paramat.m();
      bk localbk = (bk)this.a.j.get(paramInteger);
      if (localbk == null) {
        break;
      }
      paramat.a();
      localbk.a(cb.a(this.a.b, paramat.f(), paramat.d(), "", paramat.k(), paramat.l(), 0, this.a.g.f(), this.a.g.g(), this.a.g.h(), localbk.d().h()), 2, paramat.j(), "", false);
      return;
      paramat.a(new bn("msg " + paramat.h() + " waiteResp timeout "));
    }
    bc.a(this + " timeoutHandler endPoint " + paramInteger + " inactive");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bj.a
 * JD-Core Version:    0.7.0.1
 */