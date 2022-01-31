package com.tencent.soter.a.e;

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
    Object localObject = this.wPI;
    if ((((b)localObject).wPC & 0x1) != 1) {
      if ((((b)localObject).wPC & 0x2) == 2)
      {
        if (!g.bl(((b)localObject).wPD)) {
          break label99;
        }
        d.e("Soter.SoterKeyGenerateEngine", "soter: not pass auth key name", new Object[0]);
        localObject = new c(1, "auth key name not specified");
        if (((c)localObject).isSuccess()) {
          break label111;
        }
        b.a(this.wPI, (f)localObject);
      }
    }
    label99:
    label111:
    do
    {
      return;
      d.e("Soter.SoterKeyGenerateEngine", "soter: not specified purpose", new Object[0]);
      localObject = new c(7, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
      break;
      localObject = new c(0);
      break;
      if (!a.cPh())
      {
        d.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
        b.a(this.wPI, new c(2));
        return;
      }
      if ((this.wPI.wPC & 0x1) == 1)
      {
        d.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
        if ((this.wPI.wPE) && (a.cPk()))
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
          localObject = a.cPj();
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[] { ((f)localObject).aox });
            b.a(this.wPI, (f)localObject);
            return;
          }
        }
        localObject = a.cPi();
        if (!((f)localObject).isSuccess())
        {
          d.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[] { ((f)localObject).aox });
          a.cPj();
          b.a(this.wPI, (f)localObject);
          return;
        }
        d.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
        b.a(this.wPI, (f)localObject);
      }
    } while ((this.wPI.wPC & 0x2) != 2);
    d.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[] { this.wPI.wPD });
    if (!a.cPl())
    {
      d.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
      b.a(this.wPI, new c(3, "ASK not exists when generate auth key"));
      return;
    }
    if ((this.wPI.wPF) && (a.afP(this.wPI.wPD)))
    {
      d.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
      localObject = a.bR(this.wPI.wPD, false);
      if (!((f)localObject).isSuccess())
      {
        d.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[] { this.wPI.wPD, ((f)localObject).aox });
        b.a(this.wPI, (f)localObject);
        return;
      }
    }
    localObject = a.afO(this.wPI.wPD);
    if (!((f)localObject).isSuccess())
    {
      d.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[] { this.wPI.wPD, ((f)localObject).aox });
      a.bR(this.wPI.wPD, true);
      b.a(this.wPI, (f)localObject);
      return;
    }
    d.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
    b.a(this.wPI, (f)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.soter.a.e.b.1
 * JD-Core Version:    0.7.0.1
 */