package com.tencent.soter.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;

public final class b
{
  int IvC = 0;
  String IvD = "";
  boolean IvE = false;
  boolean IvF = false;
  private a IvG = null;
  private boolean IvH = false;
  
  private b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, a parama)
  {
    this.IvC = paramInt;
    this.IvD = paramString;
    this.IvE = paramBoolean1;
    this.IvF = paramBoolean2;
    this.IvG = parama;
  }
  
  public final void gB()
  {
    AppMethodBeat.i(26);
    com.tencent.soter.a.g.g.fnz().ae(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24);
        Object localObject = b.this;
        if ((((b)localObject).IvC & 0x1) != 1) {
          if ((((b)localObject).IvC & 0x2) == 2)
          {
            if (!com.tencent.soter.core.c.g.isNullOrNil(((b)localObject).IvD)) {
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
        if (!com.tencent.soter.core.a.fmR())
        {
          d.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
          b.a(b.this, new c(2));
          AppMethodBeat.o(24);
          return;
        }
        if ((b.this.IvC & 0x1) == 1)
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
          if ((b.this.IvE) && (com.tencent.soter.core.a.fmU()))
          {
            d.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
            localObject = com.tencent.soter.core.a.fmT();
            if (!((f)localObject).isSuccess())
            {
              d.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[] { ((f)localObject).errMsg });
              b.a(b.this, (f)localObject);
              AppMethodBeat.o(24);
              return;
            }
          }
          localObject = com.tencent.soter.core.a.fmS();
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[] { ((f)localObject).errMsg });
            com.tencent.soter.core.a.fmT();
            b.a(b.this, (f)localObject);
            AppMethodBeat.o(24);
            return;
          }
          d.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
          b.a(b.this, (f)localObject);
        }
        if ((b.this.IvC & 0x2) == 2)
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[] { b.this.IvD });
          if (!com.tencent.soter.core.a.fmV())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
            b.a(b.this, new c(3, "ASK not exists when generate auth key"));
            AppMethodBeat.o(24);
            return;
          }
          if ((b.this.IvF) && (com.tencent.soter.core.a.aNP(b.this.IvD)))
          {
            d.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
            localObject = com.tencent.soter.core.a.cU(b.this.IvD, false);
            if (!((f)localObject).isSuccess())
            {
              d.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[] { b.this.IvD, ((f)localObject).errMsg });
              b.a(b.this, (f)localObject);
              AppMethodBeat.o(24);
              return;
            }
          }
          localObject = com.tencent.soter.core.a.aNO(b.this.IvD);
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[] { b.this.IvD, ((f)localObject).errMsg });
            com.tencent.soter.core.a.cU(b.this.IvD, true);
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
    public int IvC = 0;
    private String IvD = "";
    public boolean IvE = false;
    private boolean IvF = false;
    public a IvG = null;
    
    public final a cV(String paramString, boolean paramBoolean)
    {
      this.IvD = paramString;
      this.IvF = paramBoolean;
      this.IvC |= 0x2;
      return this;
    }
    
    public final b fns()
    {
      AppMethodBeat.i(25);
      b localb = new b(this.IvC, this.IvD, this.IvE, this.IvF, this.IvG, (byte)0);
      AppMethodBeat.o(25);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.e.b
 * JD-Core Version:    0.7.0.1
 */