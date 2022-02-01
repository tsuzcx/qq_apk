package com.tencent.soter.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;

public final class b
{
  int ahxT = 0;
  String ahxU = "";
  boolean ahxV = false;
  boolean ahxW = false;
  private a ahxX = null;
  private boolean ahxY = false;
  
  private b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, a parama)
  {
    this.ahxT = paramInt;
    this.ahxU = paramString;
    this.ahxV = paramBoolean1;
    this.ahxW = paramBoolean2;
    this.ahxX = parama;
  }
  
  public final void Iz()
  {
    AppMethodBeat.i(26);
    com.tencent.soter.a.g.g.jYG().au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24);
        Object localObject = b.this;
        if ((((b)localObject).ahxT & 0x1) != 1) {
          if ((((b)localObject).ahxT & 0x2) == 2)
          {
            if (!com.tencent.soter.core.c.g.isNullOrNil(((b)localObject).ahxU)) {
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
        if (!com.tencent.soter.core.a.jXV())
        {
          d.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
          b.a(b.this, new c(2));
          AppMethodBeat.o(24);
          return;
        }
        if ((b.this.ahxT & 0x1) == 1)
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
          if ((b.this.ahxV) && (com.tencent.soter.core.a.jXY()))
          {
            d.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
            localObject = com.tencent.soter.core.a.jXX();
            if (!((f)localObject).isSuccess())
            {
              d.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[] { ((f)localObject).errMsg });
              b.a(b.this, (f)localObject);
              AppMethodBeat.o(24);
              return;
            }
          }
          localObject = com.tencent.soter.core.a.jXW();
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[] { ((f)localObject).errMsg });
            com.tencent.soter.core.a.jXX();
            b.a(b.this, (f)localObject);
            AppMethodBeat.o(24);
            return;
          }
          d.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
          b.a(b.this, (f)localObject);
        }
        if ((b.this.ahxT & 0x2) == 2)
        {
          d.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[] { b.this.ahxU });
          if (!com.tencent.soter.core.a.jXZ())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
            b.a(b.this, new c(3, "ASK not exists when generate auth key"));
            AppMethodBeat.o(24);
            return;
          }
          if ((b.this.ahxW) && (com.tencent.soter.core.a.bFF(b.this.ahxU)))
          {
            d.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
            localObject = com.tencent.soter.core.a.eF(b.this.ahxU, false);
            if (!((f)localObject).isSuccess())
            {
              d.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[] { b.this.ahxU, ((f)localObject).errMsg });
              b.a(b.this, (f)localObject);
              AppMethodBeat.o(24);
              return;
            }
          }
          localObject = com.tencent.soter.core.a.bFE(b.this.ahxU);
          if (!((f)localObject).isSuccess())
          {
            d.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[] { b.this.ahxU, ((f)localObject).errMsg });
            com.tencent.soter.core.a.eF(b.this.ahxU, true);
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
    public int ahxT = 0;
    private String ahxU = "";
    public boolean ahxV = false;
    private boolean ahxW = false;
    public a ahxX = null;
    
    public final a eG(String paramString, boolean paramBoolean)
    {
      this.ahxU = paramString;
      this.ahxW = paramBoolean;
      this.ahxT |= 0x2;
      return this;
    }
    
    public final b jYx()
    {
      AppMethodBeat.i(25);
      b localb = new b(this.ahxT, this.ahxU, this.ahxV, this.ahxW, this.ahxX, (byte)0);
      AppMethodBeat.o(25);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.a.e.b
 * JD-Core Version:    0.7.0.1
 */