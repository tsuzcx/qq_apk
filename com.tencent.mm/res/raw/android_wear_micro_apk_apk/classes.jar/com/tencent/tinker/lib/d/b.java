package com.tencent.tinker.lib.d;

import android.content.Context;
import com.tencent.tinker.lib.c.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.a.f;
import java.io.File;

public final class b
{
  private final boolean anD;
  private final boolean anE;
  private Boolean anF;
  private File ant;
  private com.tencent.tinker.lib.a.b anu;
  private com.tencent.tinker.lib.c.c anv;
  private d anw;
  private File anx;
  private File any;
  private final Context context;
  private int status = -1;
  
  public b(Context paramContext)
  {
    if (paramContext == null) {
      throw new TinkerRuntimeException("Context must not be null.");
    }
    this.context = paramContext;
    this.anD = com.tencent.tinker.lib.e.c.S(paramContext);
    this.anE = com.tencent.tinker.lib.e.c.H(paramContext);
    this.ant = f.N(paramContext);
    if (this.ant == null)
    {
      com.tencent.tinker.lib.e.a.a("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
      return;
    }
    this.anx = f.ag(this.ant.getAbsolutePath());
    this.any = f.ah(this.ant.getAbsolutePath());
    com.tencent.tinker.lib.e.a.b("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.ant });
  }
  
  public final a oP()
  {
    if (this.status == -1) {
      this.status = 7;
    }
    if (this.anv == null) {
      this.anv = new com.tencent.tinker.lib.c.a(this.context);
    }
    if (this.anw == null) {
      this.anw = new com.tencent.tinker.lib.c.b(this.context);
    }
    if (this.anu == null) {
      this.anu = new com.tencent.tinker.lib.a.a(this.context);
    }
    if (this.anF == null) {
      this.anF = Boolean.FALSE;
    }
    return new a(this.context, this.status, this.anv, this.anw, this.anu, this.ant, this.anx, this.any, this.anD, this.anE, this.anF.booleanValue(), (byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.d.b
 * JD-Core Version:    0.7.0.1
 */