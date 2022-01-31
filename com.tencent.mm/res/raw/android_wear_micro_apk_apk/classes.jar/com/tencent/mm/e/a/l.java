package com.tencent.mm.e.a;

import a.a.a.b;

public final class l
  extends com.tencent.mm.d.a
{
  public String VB;
  public String VC;
  public String VD;
  public String VE;
  public String VF;
  public String VG;
  public String VH;
  public String VI;
  public String VJ;
  public int VK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VB == null) {
        throw new b("Not all required fields were included: LocalNodeId");
      }
      if (this.VB != null) {
        paramVarArgs.d(1, this.VB);
      }
      if (this.VC != null) {
        paramVarArgs.d(2, this.VC);
      }
      if (this.VD != null) {
        paramVarArgs.d(3, this.VD);
      }
      if (this.VE != null) {
        paramVarArgs.d(4, this.VE);
      }
      if (this.VF != null) {
        paramVarArgs.d(5, this.VF);
      }
      if (this.VG != null) {
        paramVarArgs.d(6, this.VG);
      }
      if (this.VH != null) {
        paramVarArgs.d(7, this.VH);
      }
      if (this.VI != null) {
        paramVarArgs.d(8, this.VI);
      }
      if (this.VJ != null) {
        paramVarArgs.d(9, this.VJ);
      }
      paramVarArgs.aq(10, this.VK);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VB == null) {
        break label664;
      }
    }
    label664:
    for (int i = a.a.a.b.b.a.e(1, this.VB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.VC != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.VC);
      }
      i = paramInt;
      if (this.VD != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.VD);
      }
      paramInt = i;
      if (this.VE != null) {
        paramInt = i + a.a.a.b.b.a.e(4, this.VE);
      }
      i = paramInt;
      if (this.VF != null) {
        i = paramInt + a.a.a.b.b.a.e(5, this.VF);
      }
      paramInt = i;
      if (this.VG != null) {
        paramInt = i + a.a.a.b.b.a.e(6, this.VG);
      }
      i = paramInt;
      if (this.VH != null) {
        i = paramInt + a.a.a.b.b.a.e(7, this.VH);
      }
      paramInt = i;
      if (this.VI != null) {
        paramInt = i + a.a.a.b.b.a.e(8, this.VI);
      }
      i = paramInt;
      if (this.VJ != null) {
        i = paramInt + a.a.a.b.b.a.e(9, this.VJ);
      }
      return i + a.a.a.a.ak(10, this.VK);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
        for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.oz();
          }
        }
        if (this.VB != null) {
          break;
        }
        throw new b("Not all required fields were included: LocalNodeId");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locall.VB = locala.ou();
          return 0;
        case 2: 
          locall.VC = locala.ou();
          return 0;
        case 3: 
          locall.VD = locala.ou();
          return 0;
        case 4: 
          locall.VE = locala.ou();
          return 0;
        case 5: 
          locall.VF = locala.ou();
          return 0;
        case 6: 
          locall.VG = locala.ou();
          return 0;
        case 7: 
          locall.VH = locala.ou();
          return 0;
        case 8: 
          locall.VI = locala.ou();
          return 0;
        case 9: 
          locall.VJ = locala.ou();
          return 0;
        }
        locall.VK = locala.ot();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.l
 * JD-Core Version:    0.7.0.1
 */