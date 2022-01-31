package com.tencent.soter.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.g;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(10473);
    Object localObject = this.Bni;
    if ((((b)localObject).Bnc & 0x1) != 1) {
      if ((((b)localObject).Bnc & 0x2) == 2)
      {
        if (!g.isNullOrNil(((b)localObject).Bnd)) {
          break label111;
        }
        d.e("Soter.SoterKeyGenerateEngine", "soter: not pass auth key name", new Object[0]);
        localObject = new c(1, "auth key name not specified");
      }
    }
    while (!((c)localObject).isSuccess())
    {
      b.a(this.Bni, (f)localObject);
      AppMethodBeat.o(10473);
      return;
      d.e("Soter.SoterKeyGenerateEngine", "soter: not specified purpose", new Object[0]);
      localObject = new c(7, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
      continue;
      label111:
      localObject = new c(0);
    }
    if (!a.dVc())
    {
      d.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
      b.a(this.Bni, new c(2));
      AppMethodBeat.o(10473);
      return;
    }
    if ((this.Bni.Bnc & 0x1) == 1)
    {
      d.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
      if ((this.Bni.Bne) && (a.dVf()))
      {
        d.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
        localObject = a.dVe();
        if (!((f)localObject).isSuccess())
        {
          d.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[] { ((f)localObject).errMsg });
          b.a(this.Bni, (f)localObject);
          AppMethodBeat.o(10473);
          return;
        }
      }
      localObject = a.dVd();
      if (!((f)localObject).isSuccess())
      {
        d.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[] { ((f)localObject).errMsg });
        a.dVe();
        b.a(this.Bni, (f)localObject);
        AppMethodBeat.o(10473);
        return;
      }
      d.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
      b.a(this.Bni, (f)localObject);
    }
    if ((this.Bni.Bnc & 0x2) == 2)
    {
      d.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[] { this.Bni.Bnd });
      if (!a.dVg())
      {
        d.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
        b.a(this.Bni, new c(3, "ASK not exists when generate auth key"));
        AppMethodBeat.o(10473);
        return;
      }
      if ((this.Bni.Bnf) && (a.awK(this.Bni.Bnd)))
      {
        d.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
        localObject = a.cu(this.Bni.Bnd, false);
        if (!((f)localObject).isSuccess())
        {
          d.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[] { this.Bni.Bnd, ((f)localObject).errMsg });
          b.a(this.Bni, (f)localObject);
          AppMethodBeat.o(10473);
          return;
        }
      }
      localObject = a.awJ(this.Bni.Bnd);
      if (!((f)localObject).isSuccess())
      {
        d.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[] { this.Bni.Bnd, ((f)localObject).errMsg });
        a.cu(this.Bni.Bnd, true);
        b.a(this.Bni, (f)localObject);
        AppMethodBeat.o(10473);
        return;
      }
      d.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
      b.a(this.Bni, (f)localObject);
    }
    AppMethodBeat.o(10473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.soter.a.e.b.1
 * JD-Core Version:    0.7.0.1
 */