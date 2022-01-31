package com.tencent.tinker.lib.d;

import android.content.Context;
import com.tencent.tinker.lib.c.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.a.f;
import java.io.File;

public class a
{
  private static a ajS;
  private static boolean ajT = false;
  final File ajU;
  final com.tencent.tinker.lib.a.b ajV;
  final com.tencent.tinker.lib.c.c ajW;
  final d ajX;
  final File ajY;
  final File ajZ;
  final boolean aka;
  final boolean akb;
  c akc;
  private boolean akd = false;
  final Context context;
  int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  
  private a(Context paramContext, int paramInt, com.tencent.tinker.lib.c.c paramc, d paramd, com.tencent.tinker.lib.a.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.ajV = paramb;
    this.ajW = paramc;
    this.ajX = paramd;
    this.tinkerFlags = paramInt;
    this.ajU = paramFile1;
    this.ajY = paramFile2;
    this.ajZ = paramFile3;
    this.aka = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.akb = paramBoolean2;
  }
  
  public static a D(Context paramContext)
  {
    if (!ajT) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (ajS == null) {
        ajS = new b(paramContext).oc();
      }
      return ajS;
    }
    finally {}
  }
  
  public final void d(File paramFile)
  {
    if ((this.ajU == null) || (paramFile == null) || (!paramFile.exists())) {}
    do
    {
      return;
      paramFile = f.ae(f.n(paramFile));
    } while ((this.ajU == null) || (paramFile == null));
    f.ah(this.ajU.getAbsolutePath() + "/" + paramFile);
  }
  
  public final c nY()
  {
    return this.akc;
  }
  
  public final void nZ()
  {
    this.tinkerFlags = 0;
  }
  
  public final d oa()
  {
    return this.ajX;
  }
  
  public final boolean ob()
  {
    return this.akd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.d.a
 * JD-Core Version:    0.7.0.1
 */