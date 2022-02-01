package com.tencent.mm.plugin.whatsnew.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/Config;", "", "initCount", "", "inScreenCount", "minRadius", "maxRadius", "blurRadius", "alpha", "", "distance", "minSpeed", "maxSpeed", "minAngle", "maxAngle", "colors", "", "", "bgColors", "(IIIIIDIIIII[Ljava/lang/String;[Ljava/lang/String;)V", "getAlpha", "()D", "getBgColors", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getBlurRadius", "()I", "getColors", "getDistance", "getInScreenCount", "getInitCount", "getMaxAngle", "getMaxRadius", "getMaxSpeed", "getMinAngle", "getMinRadius", "getMinSpeed", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIIIIDIIIII[Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/whatsnew/ui/Config;", "equals", "", "other", "hashCode", "toString", "Companion", "app_release"})
public final class b
{
  private static b JOS;
  public static final a JOT;
  final int JOI;
  final int JOJ;
  final int JOK;
  final double JOL;
  final int JOM;
  final int JON;
  final int JOO;
  final int JOP;
  final String[] JOQ;
  final String[] JOR;
  final int initCount;
  final int jbm;
  final int vPo;
  
  static
  {
    AppMethodBeat.i(230959);
    JOT = new a((byte)0);
    JOS = new b();
    AppMethodBeat.o(230959);
  }
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(230957);
    this.initCount = paramInt1;
    this.JOI = paramInt2;
    this.JOJ = paramInt3;
    this.JOK = paramInt4;
    this.jbm = paramInt5;
    this.JOL = paramDouble;
    this.vPo = paramInt6;
    this.JOM = paramInt7;
    this.JON = paramInt8;
    this.JOO = paramInt9;
    this.JOP = paramInt10;
    this.JOQ = paramArrayOfString1;
    this.JOR = paramArrayOfString2;
    AppMethodBeat.o(230957);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(230954);
    if ((b)this == paramObject)
    {
      AppMethodBeat.o(230954);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (p.j(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.whatsnew.ui.Config");
      AppMethodBeat.o(230954);
      throw paramObject;
    }
    if (this.initCount != ((b)paramObject).initCount)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (this.JOI != ((b)paramObject).JOI)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (this.JOJ != ((b)paramObject).JOJ)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (this.JOK != ((b)paramObject).JOK)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (this.jbm != ((b)paramObject).jbm)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (this.JOL != ((b)paramObject).JOL)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (this.vPo != ((b)paramObject).vPo)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (this.JOM != ((b)paramObject).JOM)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (this.JON != ((b)paramObject).JON)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (this.JOO != ((b)paramObject).JOO)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (this.JOP != ((b)paramObject).JOP)
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (!Arrays.equals(this.JOQ, ((b)paramObject).JOQ))
    {
      AppMethodBeat.o(230954);
      return false;
    }
    if (!Arrays.equals(this.JOR, ((b)paramObject).JOR))
    {
      AppMethodBeat.o(230954);
      return false;
    }
    AppMethodBeat.o(230954);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(230955);
    int i = this.initCount;
    int j = this.JOI;
    int k = this.JOJ;
    int m = this.JOK;
    int n = this.jbm;
    int i1 = Double.valueOf(this.JOL).hashCode();
    int i2 = this.vPo;
    int i3 = this.JOM;
    int i4 = this.JON;
    int i5 = this.JOO;
    int i6 = this.JOP;
    int i7 = Arrays.hashCode(this.JOQ);
    int i8 = Arrays.hashCode(this.JOR);
    AppMethodBeat.o(230955);
    return (((((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(230956);
    String str = "Config(\n    initCount = " + this.initCount + ",\n    inScreenCount = " + this.JOI + ",\n    minRadius = " + this.JOJ + ",\n    maxRadius = " + this.JOK + ",\n    blurRadius = " + this.jbm + ",\n    alpha = " + this.JOL + ",\n    distance = " + this.vPo + ",\n    minSpeed = " + this.JOM + ",\n    maxSpeed = " + this.JON + ",\n    minAngle = " + this.JOO + ",\n    maxAngle = " + this.JOP + ",\n    colors = arrayOf(" + e.a(this.JOQ, null, null, null, 0, null, (kotlin.g.a.b)b.b.JOU, 31) + "),\n    bgColors = arrayOf(" + e.a(this.JOR, null, null, null, 0, null, (kotlin.g.a.b)b.c.JOV, 31) + ")\n)";
    AppMethodBeat.o(230956);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/Config$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/whatsnew/ui/Config;", "getInstance", "()Lcom/tencent/mm/plugin/whatsnew/ui/Config;", "setInstance", "(Lcom/tencent/mm/plugin/whatsnew/ui/Config;)V", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.b
 * JD-Core Version:    0.7.0.1
 */