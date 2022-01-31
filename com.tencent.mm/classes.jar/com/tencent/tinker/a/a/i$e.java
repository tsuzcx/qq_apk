package com.tencent.tinker.a.a;

import java.nio.ByteBuffer;

public final class i$e
  extends com.tencent.tinker.a.a.a.a
{
  private final String name;
  
  private i$e(i parami, String paramString, ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
    this.name = paramString;
  }
  
  private void a(t.a parama, boolean paramBoolean)
  {
    if (parama.wTu)
    {
      if (!paramBoolean) {
        break label87;
      }
      super.JA(((this.ayD.position() + 3 & 0xFFFFFFFC) - this.ayD.position()) * 1);
      while ((this.ayD.position() & 0x3) != 0) {
        this.ayD.put((byte)0);
      }
      if (this.ayD.position() > this.wTA) {
        this.wTA = this.ayD.position();
      }
    }
    return;
    label87:
    this.ayD.position(this.ayD.position() + 3 & 0xFFFFFFFC);
  }
  
  public final int a(a parama)
  {
    a(i.a(this.wSL).wTl, true);
    return super.a(parama);
  }
  
  public final int a(b paramb)
  {
    a(i.a(this.wSL).wTg, true);
    return super.a(paramb);
  }
  
  public final int a(c paramc)
  {
    a(i.a(this.wSL).wTf, true);
    return super.a(paramc);
  }
  
  public final int a(d paramd)
  {
    a(i.a(this.wSL).wTn, true);
    return super.a(paramd);
  }
  
  public final int a(e parame)
  {
    a(i.a(this.wSL).wTh, true);
    return super.a(parame);
  }
  
  public final int a(f paramf)
  {
    a(i.a(this.wSL).wTc, true);
    return super.a(paramf);
  }
  
  public final int a(g paramg)
  {
    a(i.a(this.wSL).wTi, true);
    return super.a(paramg);
  }
  
  public final int a(h paramh)
  {
    a(i.a(this.wSL).wTk, true);
    return super.a(paramh);
  }
  
  public final int a(k paramk)
  {
    a(i.a(this.wSL).wTm, true);
    return super.a(paramk);
  }
  
  public final int a(n paramn)
  {
    a(i.a(this.wSL).wTa, true);
    return super.a(paramn);
  }
  
  public final int a(p paramp)
  {
    a(i.a(this.wSL).wTb, true);
    return super.a(paramp);
  }
  
  public final int a(r paramr)
  {
    a(i.a(this.wSL).wSZ, true);
    return super.a(paramr);
  }
  
  public final int a(s params)
  {
    a(i.a(this.wSL).wTj, true);
    return super.a(params);
  }
  
  public final int a(u paramu)
  {
    a(i.a(this.wSL).wTe, true);
    return super.a(paramu);
  }
  
  public final s cPZ()
  {
    a(i.a(this.wSL).wTj, false);
    return super.cPZ();
  }
  
  public final u cQa()
  {
    a(i.a(this.wSL).wTe, false);
    return super.cQa();
  }
  
  public final n cQb()
  {
    a(i.a(this.wSL).wTa, false);
    return super.cQb();
  }
  
  public final p cQc()
  {
    a(i.a(this.wSL).wTb, false);
    return super.cQc();
  }
  
  public final r cQd()
  {
    a(i.a(this.wSL).wSZ, false);
    return super.cQd();
  }
  
  public final f cQe()
  {
    a(i.a(this.wSL).wTc, false);
    return super.cQe();
  }
  
  public final g cQf()
  {
    a(i.a(this.wSL).wTi, false);
    return super.cQf();
  }
  
  public final h cQg()
  {
    a(i.a(this.wSL).wTk, false);
    return super.cQg();
  }
  
  public final e cQh()
  {
    a(i.a(this.wSL).wTh, false);
    return super.cQh();
  }
  
  public final a cQi()
  {
    a(i.a(this.wSL).wTl, false);
    return super.cQi();
  }
  
  public final b cQj()
  {
    a(i.a(this.wSL).wTg, false);
    return super.cQj();
  }
  
  public final c cQk()
  {
    a(i.a(this.wSL).wTf, false);
    return super.cQk();
  }
  
  public final d cQl()
  {
    a(i.a(this.wSL).wTn, false);
    return super.cQl();
  }
  
  public final k cQm()
  {
    a(i.a(this.wSL).wTm, false);
    return super.cQm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.i.e
 * JD-Core Version:    0.7.0.1
 */