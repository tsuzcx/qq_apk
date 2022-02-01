package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$n
  extends e
{
  private static volatile n[] LGt;
  public int Fpp = 0;
  public String LGu = "";
  public String nickname = "";
  
  public a$n()
  {
    this.bQO = -1;
  }
  
  public static n[] fSW()
  {
    if (LGt == null) {}
    synchronized (c.bQN)
    {
      if (LGt == null) {
        LGt = new n[0];
      }
      return LGt;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.Fpp != 0) {
      paramb.by(1, this.Fpp);
    }
    if (!this.nickname.equals("")) {
      paramb.d(2, this.nickname);
    }
    if (!this.LGu.equals("")) {
      paramb.d(3, this.LGu);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.Fpp != 0) {
      i = j + b.bA(1, this.Fpp);
    }
    j = i;
    if (!this.nickname.equals("")) {
      j = i + b.e(2, this.nickname);
    }
    i = j;
    if (!this.LGu.equals("")) {
      i = j + b.e(3, this.LGu);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.n
 * JD-Core Version:    0.7.0.1
 */