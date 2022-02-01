package com.tencent.soter.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;

public final class b
{
  int JXl = 0;
  String JXm = "";
  boolean JXn = false;
  boolean JXo = false;
  private a JXp = null;
  private boolean JXq = false;
  
  private b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, a parama)
  {
    this.JXl = paramInt;
    this.JXm = paramString;
    this.JXn = paramBoolean1;
    this.JXo = paramBoolean2;
    this.JXp = parama;
  }
  
  public final void gJ()
  {
    AppMethodBeat.i(26);
    com.tencent.soter.a.g.g.fDP().ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24);
        Object localObject = b.this;
        if ((((b)localObject).JXl & 0x1) != 1) {
          if ((((b)localObject).JXl & 0x2) == 2)
          {
            if (!com.tencent.soter.core.c.g.isNullOrNil(((b)localObject).JXm)) {
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
        if (!com.tencent.soter.core.a.fDh())
        {
          d.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
          b.a(b.this, new c(2));
          AppMethodBeat.o(24);
          return;
        }
        if ((b.this.JXl & 0x1) == 1)
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
          if ((b.this.JXn) && (com.tencent.soter.core.a.fDk()))
          {
            d.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
            localObject = com.tencent.soter.core.a.fDj();
            if (!((f)localObject).isSuccess())
            {
              d.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[] { ((f)localObject).errMsg });
              b.a(b.this, (f)localObject);
              AppMethodBeat.o(24);
              return;
            }
          }
          localObject = com.tencent.soter.core.a.fDi();
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[] { ((f)localObject).errMsg });
            com.tencent.soter.core.a.fDj();
            b.a(b.this, (f)localObject);
            AppMethodBeat.o(24);
            return;
          }
          d.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
          b.a(b.this, (f)localObject);
        }
        if ((b.this.JXl & 0x2) == 2)
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[] { b.this.JXm });
          if (!com.tencent.soter.core.a.fDl())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
            b.a(b.this, new c(3, "ASK not exists when generate auth key"));
            AppMethodBeat.o(24);
            return;
          }
          if ((b.this.JXo) && (com.tencent.soter.core.a.aTs(b.this.JXm)))
          {
            d.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
            localObject = com.tencent.soter.core.a.db(b.this.JXm, false);
            if (!((f)localObject).isSuccess())
            {
              d.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[] { b.this.JXm, ((f)localObject).errMsg });
              b.a(b.this, (f)localObject);
              AppMethodBeat.o(24);
              return;
            }
          }
          localObject = com.tencent.soter.core.a.aTr(b.this.JXm);
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[] { b.this.JXm, ((f)localObject).errMsg });
            com.tencent.soter.core.a.db(b.this.JXm, true);
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
    public int JXl = 0;
    private String JXm = "";
    public boolean JXn = false;
    private boolean JXo = false;
    public a JXp = null;
    
    public final a dc(String paramString, boolean paramBoolean)
    {
      this.JXm = paramString;
      this.JXo = paramBoolean;
      this.JXl |= 0x2;
      return this;
    }
    
    public final b fDI()
    {
      AppMethodBeat.i(25);
      b localb = new b(this.JXl, this.JXm, this.JXn, this.JXo, this.JXp, (byte)0);
      AppMethodBeat.o(25);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.e.b
 * JD-Core Version:    0.7.0.1
 */