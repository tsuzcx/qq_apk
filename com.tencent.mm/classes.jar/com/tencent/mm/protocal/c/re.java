package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class re
  extends com.tencent.mm.bv.a
{
  public String app_id;
  public String sOS;
  public String sOT;
  public String sOU;
  public int sOV;
  public int sOW;
  public int sOX;
  public int sOY;
  public int sOZ;
  public int sPa;
  public String sPb;
  public String sPc;
  public String sPd;
  public b sPe;
  public String sPf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.d(1, this.app_id);
      }
      if (this.sOS != null) {
        paramVarArgs.d(2, this.sOS);
      }
      if (this.sOT != null) {
        paramVarArgs.d(3, this.sOT);
      }
      if (this.sOU != null) {
        paramVarArgs.d(4, this.sOU);
      }
      paramVarArgs.gB(5, this.sOV);
      paramVarArgs.gB(6, this.sOW);
      paramVarArgs.gB(7, this.sOX);
      paramVarArgs.gB(10, this.sOY);
      paramVarArgs.gB(11, this.sOZ);
      paramVarArgs.gB(12, this.sPa);
      if (this.sPb != null) {
        paramVarArgs.d(15, this.sPb);
      }
      if (this.sPc != null) {
        paramVarArgs.d(16, this.sPc);
      }
      if (this.sPd != null) {
        paramVarArgs.d(17, this.sPd);
      }
      if (this.sPe != null) {
        paramVarArgs.b(18, this.sPe);
      }
      if (this.sPf != null) {
        paramVarArgs.d(19, this.sPf);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label874;
      }
    }
    label874:
    for (int i = d.a.a.b.b.a.e(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sOS != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sOS);
      }
      i = paramInt;
      if (this.sOT != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sOT);
      }
      paramInt = i;
      if (this.sOU != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sOU);
      }
      i = paramInt + d.a.a.a.gy(5, this.sOV) + d.a.a.a.gy(6, this.sOW) + d.a.a.a.gy(7, this.sOX) + d.a.a.a.gy(10, this.sOY) + d.a.a.a.gy(11, this.sOZ) + d.a.a.a.gy(12, this.sPa);
      paramInt = i;
      if (this.sPb != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.sPb);
      }
      i = paramInt;
      if (this.sPc != null) {
        i = paramInt + d.a.a.b.b.a.e(16, this.sPc);
      }
      paramInt = i;
      if (this.sPd != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.sPd);
      }
      i = paramInt;
      if (this.sPe != null) {
        i = paramInt + d.a.a.a.a(18, this.sPe);
      }
      paramInt = i;
      if (this.sPf != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.sPf);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        re localre = (re)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 8: 
        case 9: 
        case 13: 
        case 14: 
        default: 
          return -1;
        case 1: 
          localre.app_id = locala.xpH.readString();
          return 0;
        case 2: 
          localre.sOS = locala.xpH.readString();
          return 0;
        case 3: 
          localre.sOT = locala.xpH.readString();
          return 0;
        case 4: 
          localre.sOU = locala.xpH.readString();
          return 0;
        case 5: 
          localre.sOV = locala.xpH.oD();
          return 0;
        case 6: 
          localre.sOW = locala.xpH.oD();
          return 0;
        case 7: 
          localre.sOX = locala.xpH.oD();
          return 0;
        case 10: 
          localre.sOY = locala.xpH.oD();
          return 0;
        case 11: 
          localre.sOZ = locala.xpH.oD();
          return 0;
        case 12: 
          localre.sPa = locala.xpH.oD();
          return 0;
        case 15: 
          localre.sPb = locala.xpH.readString();
          return 0;
        case 16: 
          localre.sPc = locala.xpH.readString();
          return 0;
        case 17: 
          localre.sPd = locala.xpH.readString();
          return 0;
        case 18: 
          localre.sPe = locala.cUs();
          return 0;
        }
        localre.sPf = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.re
 * JD-Core Version:    0.7.0.1
 */