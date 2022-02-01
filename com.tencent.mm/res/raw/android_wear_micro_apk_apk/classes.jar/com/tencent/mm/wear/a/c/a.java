package com.tencent.mm.wear.a.c;

import java.util.ArrayList;
import java.util.List;

public final class a
  implements e
{
  private List<b> amw = new ArrayList(100);
  
  public final void a(e parame)
  {
    int j = this.amw.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.amw.get(i);
      switch (localb.level)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        parame.e(localb.tag, localb.amx, localb.amy);
        continue;
        parame.d(localb.tag, localb.amx, localb.amy);
        continue;
        parame.c(localb.tag, localb.amx, localb.amy);
        continue;
        parame.b(localb.tag, localb.amx, localb.amy);
        continue;
        if (localb.amz != null) {
          parame.a(localb.tag, localb.amz, localb.amx, localb.amy);
        } else {
          parame.a(localb.tag, localb.amx, localb.amy);
        }
      }
    }
    this.amw = new ArrayList();
  }
  
  public final void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.amw.size() < 100)
    {
      b localb = new b(this, (byte)0);
      localb.level = 5;
      localb.tag = paramString1;
      localb.amx = paramString2;
      localb.amy = paramVarArgs;
      this.amw.add(localb);
    }
  }
  
  public final void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (this.amw.size() < 100)
    {
      b localb = new b(this, (byte)0);
      localb.level = 5;
      localb.tag = paramString1;
      localb.amx = paramString2;
      localb.amy = paramVarArgs;
      localb.amz = paramThrowable;
      this.amw.add(localb);
    }
  }
  
  public final void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.amw.size() < 100)
    {
      b localb = new b(this, (byte)0);
      localb.level = 4;
      localb.tag = paramString1;
      localb.amx = paramString2;
      localb.amy = paramVarArgs;
      this.amw.add(localb);
    }
  }
  
  public final void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.amw.size() < 100)
    {
      b localb = new b(this, (byte)0);
      localb.level = 3;
      localb.tag = paramString1;
      localb.amx = paramString2;
      localb.amy = paramVarArgs;
      this.amw.add(localb);
    }
  }
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.amw.size() < 100)
    {
      b localb = new b(this, (byte)0);
      localb.level = 2;
      localb.tag = paramString1;
      localb.amx = paramString2;
      localb.amy = paramVarArgs;
      this.amw.add(localb);
    }
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.amw.size() < 100)
    {
      b localb = new b(this, (byte)0);
      localb.level = 1;
      localb.tag = paramString1;
      localb.amx = paramString2;
      localb.amy = paramVarArgs;
      this.amw.add(localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.c.a
 * JD-Core Version:    0.7.0.1
 */