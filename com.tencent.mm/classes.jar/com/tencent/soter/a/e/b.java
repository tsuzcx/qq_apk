package com.tencent.soter.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;

public final class b
{
  int LRg = 0;
  String LRh = "";
  boolean LRi = false;
  boolean LRj = false;
  private a LRk = null;
  private boolean LRl = false;
  
  private b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, a parama)
  {
    this.LRg = paramInt;
    this.LRh = paramString;
    this.LRi = paramBoolean1;
    this.LRj = paramBoolean2;
    this.LRk = parama;
  }
  
  public final void ha()
  {
    AppMethodBeat.i(26);
    com.tencent.soter.a.g.g.fVh().af(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24);
        Object localObject = b.this;
        if ((((b)localObject).LRg & 0x1) != 1) {
          if ((((b)localObject).LRg & 0x2) == 2)
          {
            if (!com.tencent.soter.core.c.g.isNullOrNil(((b)localObject).LRh)) {
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
        if (!com.tencent.soter.core.a.fUz())
        {
          d.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
          b.a(b.this, new c(2));
          AppMethodBeat.o(24);
          return;
        }
        if ((b.this.LRg & 0x1) == 1)
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
          if ((b.this.LRi) && (com.tencent.soter.core.a.fUC()))
          {
            d.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
            localObject = com.tencent.soter.core.a.fUB();
            if (!((f)localObject).isSuccess())
            {
              d.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[] { ((f)localObject).errMsg });
              b.a(b.this, (f)localObject);
              AppMethodBeat.o(24);
              return;
            }
          }
          localObject = com.tencent.soter.core.a.fUA();
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[] { ((f)localObject).errMsg });
            com.tencent.soter.core.a.fUB();
            b.a(b.this, (f)localObject);
            AppMethodBeat.o(24);
            return;
          }
          d.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
          b.a(b.this, (f)localObject);
        }
        if ((b.this.LRg & 0x2) == 2)
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[] { b.this.LRh });
          if (!com.tencent.soter.core.a.fUD())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
            b.a(b.this, new c(3, "ASK not exists when generate auth key"));
            AppMethodBeat.o(24);
            return;
          }
          if ((b.this.LRj) && (com.tencent.soter.core.a.aZs(b.this.LRh)))
          {
            d.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
            localObject = com.tencent.soter.core.a.dg(b.this.LRh, false);
            if (!((f)localObject).isSuccess())
            {
              d.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[] { b.this.LRh, ((f)localObject).errMsg });
              b.a(b.this, (f)localObject);
              AppMethodBeat.o(24);
              return;
            }
          }
          localObject = com.tencent.soter.core.a.aZr(b.this.LRh);
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[] { b.this.LRh, ((f)localObject).errMsg });
            com.tencent.soter.core.a.dg(b.this.LRh, true);
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
    public int LRg = 0;
    private String LRh = "";
    public boolean LRi = false;
    private boolean LRj = false;
    public a LRk = null;
    
    public final a dh(String paramString, boolean paramBoolean)
    {
      this.LRh = paramString;
      this.LRj = paramBoolean;
      this.LRg |= 0x2;
      return this;
    }
    
    public final b fVa()
    {
      AppMethodBeat.i(25);
      b localb = new b(this.LRg, this.LRh, this.LRi, this.LRj, this.LRk, (byte)0);
      AppMethodBeat.o(25);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.e.b
 * JD-Core Version:    0.7.0.1
 */