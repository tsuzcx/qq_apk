package com.tencent.soter.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;

public final class b
{
  int RQB = 0;
  String RQC = "";
  boolean RQD = false;
  boolean RQE = false;
  private a RQF = null;
  private boolean RQG = false;
  
  private b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, a parama)
  {
    this.RQB = paramInt;
    this.RQC = paramString;
    this.RQD = paramBoolean1;
    this.RQE = paramBoolean2;
    this.RQF = parama;
  }
  
  public final void hi()
  {
    AppMethodBeat.i(26);
    com.tencent.soter.a.g.g.hlR().aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24);
        Object localObject = b.this;
        if ((((b)localObject).RQB & 0x1) != 1) {
          if ((((b)localObject).RQB & 0x2) == 2)
          {
            if (!com.tencent.soter.core.c.g.isNullOrNil(((b)localObject).RQC)) {
              break label110;
            }
            d.e("Soter.SoterKeyGenerateEngine", "soter: not pass auth key name", new Object[0]);
            localObject = new c(1, "auth key name not specified");
          }
        }
        while (!((c)localObject).isSuccess())
        {
          b.a(b.this, (f)localObject);
          AppMethodBeat.o(24);
          return;
          d.e("Soter.SoterKeyGenerateEngine", "soter: not specified purpose", new Object[0]);
          localObject = new c(1001, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
          continue;
          label110:
          localObject = new c(0);
        }
        if (!com.tencent.soter.core.a.hlj())
        {
          d.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
          b.a(b.this, new c(2));
          AppMethodBeat.o(24);
          return;
        }
        if ((b.this.RQB & 0x1) == 1)
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
          if ((b.this.RQD) && (com.tencent.soter.core.a.hlm()))
          {
            d.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
            localObject = com.tencent.soter.core.a.hll();
            if (!((f)localObject).isSuccess())
            {
              d.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[] { ((f)localObject).errMsg });
              b.a(b.this, (f)localObject);
              AppMethodBeat.o(24);
              return;
            }
          }
          localObject = com.tencent.soter.core.a.hlk();
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[] { ((f)localObject).errMsg });
            com.tencent.soter.core.a.hll();
            b.a(b.this, (f)localObject);
            AppMethodBeat.o(24);
            return;
          }
          d.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
          b.a(b.this, (f)localObject);
        }
        if ((b.this.RQB & 0x2) == 2)
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[] { b.this.RQC });
          if (!com.tencent.soter.core.a.hln())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
            b.a(b.this, new c(3, "ASK not exists when generate auth key"));
            AppMethodBeat.o(24);
            return;
          }
          if ((b.this.RQE) && (com.tencent.soter.core.a.bqh(b.this.RQC)))
          {
            d.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
            localObject = com.tencent.soter.core.a.dE(b.this.RQC, false);
            if (!((f)localObject).isSuccess())
            {
              d.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[] { b.this.RQC, ((f)localObject).errMsg });
              b.a(b.this, (f)localObject);
              AppMethodBeat.o(24);
              return;
            }
          }
          localObject = com.tencent.soter.core.a.bqg(b.this.RQC);
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[] { b.this.RQC, ((f)localObject).errMsg });
            com.tencent.soter.core.a.dE(b.this.RQC, true);
            b.a(b.this, (f)localObject);
            AppMethodBeat.o(24);
            return;
          }
          d.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
          b.a(b.this, (f)localObject);
        }
        AppMethodBeat.o(24);
      }
    });
    AppMethodBeat.o(26);
  }
  
  public static final class a
  {
    public int RQB = 0;
    private String RQC = "";
    public boolean RQD = false;
    private boolean RQE = false;
    public a RQF = null;
    
    public final a dF(String paramString, boolean paramBoolean)
    {
      this.RQC = paramString;
      this.RQE = paramBoolean;
      this.RQB |= 0x2;
      return this;
    }
    
    public final b hlK()
    {
      AppMethodBeat.i(25);
      b localb = new b(this.RQB, this.RQC, this.RQD, this.RQE, this.RQF, (byte)0);
      AppMethodBeat.o(25);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.e.b
 * JD-Core Version:    0.7.0.1
 */