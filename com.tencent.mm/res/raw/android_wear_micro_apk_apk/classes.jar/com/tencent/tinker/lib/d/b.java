package com.tencent.tinker.lib.d;

import android.content.Context;
import com.tencent.tinker.lib.c.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.a.f;
import java.io.File;

public final class b
{
  private File ajU;
  private com.tencent.tinker.lib.a.b ajV;
  private com.tencent.tinker.lib.c.c ajW;
  private d ajX;
  private File ajY;
  private File ajZ;
  private final boolean ake;
  private final boolean akf;
  private Boolean akg;
  private final Context context;
  private int status = -1;
  
  public b(Context paramContext)
  {
    if (paramContext == null) {
      throw new TinkerRuntimeException("Context must not be null.");
    }
    this.context = paramContext;
    this.ake = com.tencent.tinker.lib.e.c.Q(paramContext);
    this.akf = com.tencent.tinker.lib.e.c.G(paramContext);
    this.ajU = f.M(paramContext);
    if (this.ajU == null)
    {
      com.tencent.tinker.lib.e.a.a("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
      return;
    }
    this.ajY = f.ac(this.ajU.getAbsolutePath());
    this.ajZ = f.ad(this.ajU.getAbsolutePath());
    com.tencent.tinker.lib.e.a.b("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.ajU });
  }
  
  public final a oc()
  {
    if (this.status == -1) {
      this.status = 7;
    }
    if (this.ajW == null) {
      this.ajW = new com.tencent.tinker.lib.c.a(this.context);
    }
    if (this.ajX == null) {
      this.ajX = new com.tencent.tinker.lib.c.b(this.context);
    }
    if (this.ajV == null) {
      this.ajV = new com.tencent.tinker.lib.a.a(this.context);
    }
    if (this.akg == null) {
      this.akg = Boolean.valueOf(false);
    }
    return new a(this.context, this.status, this.ajW, this.ajX, this.ajV, this.ajU, this.ajY, this.ajZ, this.ake, this.akf, this.akg.booleanValue(), (byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.d.b
 * JD-Core Version:    0.7.0.1
 */