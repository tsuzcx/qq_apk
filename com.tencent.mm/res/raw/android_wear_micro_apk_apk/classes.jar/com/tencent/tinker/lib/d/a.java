package com.tencent.tinker.lib.d;

import android.content.Context;
import com.tencent.tinker.lib.c.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.a.f;
import java.io.File;

public class a
{
  private static a anr;
  private static boolean ans = false;
  final boolean anA;
  c anB;
  private boolean anC = false;
  final File ant;
  final com.tencent.tinker.lib.a.b anu;
  final com.tencent.tinker.lib.c.c anv;
  final d anw;
  final File anx;
  final File any;
  final boolean anz;
  final Context context;
  int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  
  private a(Context paramContext, int paramInt, com.tencent.tinker.lib.c.c paramc, d paramd, com.tencent.tinker.lib.a.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.anu = paramb;
    this.anv = paramc;
    this.anw = paramd;
    this.tinkerFlags = paramInt;
    this.ant = paramFile1;
    this.anx = paramFile2;
    this.any = paramFile3;
    this.anz = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.anA = paramBoolean2;
  }
  
  public static a E(Context paramContext)
  {
    if (!ans) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (anr == null) {
        anr = new b(paramContext).oP();
      }
      return anr;
    }
    finally {}
  }
  
  public final void d(File paramFile)
  {
    if ((this.ant == null) || (paramFile == null) || (!paramFile.exists())) {}
    do
    {
      return;
      paramFile = f.ai(f.n(paramFile));
    } while ((this.ant == null) || (paramFile == null));
    f.al(this.ant.getAbsolutePath() + "/" + paramFile);
  }
  
  public final c oL()
  {
    return this.anB;
  }
  
  public final void oM()
  {
    this.tinkerFlags = 0;
  }
  
  public final d oN()
  {
    return this.anw;
  }
  
  public final boolean oO()
  {
    return this.anC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.d.a
 * JD-Core Version:    0.7.0.1
 */