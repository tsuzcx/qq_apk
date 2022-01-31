package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bsx
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public String kVs;
  public int mPL;
  public String sSS;
  public int swS;
  public bkk swb;
  public String tAY;
  public String tJr;
  public String tJs;
  public int tJt;
  public int tJu;
  public int tJv;
  public long tJw;
  public long tJx;
  public bmk tJy;
  public int tJz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tAY != null) {
        paramVarArgs.d(1, this.tAY);
      }
      if (this.sSS != null) {
        paramVarArgs.d(2, this.sSS);
      }
      if (this.tJr != null) {
        paramVarArgs.d(3, this.tJr);
      }
      if (this.tJs != null) {
        paramVarArgs.d(4, this.tJs);
      }
      paramVarArgs.gB(5, this.hQR);
      paramVarArgs.gB(6, this.swS);
      paramVarArgs.gB(7, this.mPL);
      if (this.kVs != null) {
        paramVarArgs.d(8, this.kVs);
      }
      paramVarArgs.gB(9, this.tJt);
      paramVarArgs.gB(10, this.tJu);
      paramVarArgs.gB(11, this.tJv);
      paramVarArgs.Y(12, this.tJw);
      paramVarArgs.Y(13, this.tJx);
      if (this.tJy != null)
      {
        paramVarArgs.gD(14, this.tJy.btq());
        this.tJy.a(paramVarArgs);
      }
      paramVarArgs.gB(15, this.tJz);
      if (this.swb != null)
      {
        paramVarArgs.gD(16, this.swb.btq());
        this.swb.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tAY == null) {
        break label1056;
      }
    }
    label1056:
    for (int i = d.a.a.b.b.a.e(1, this.tAY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sSS != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sSS);
      }
      i = paramInt;
      if (this.tJr != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tJr);
      }
      paramInt = i;
      if (this.tJs != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tJs);
      }
      i = paramInt + d.a.a.a.gy(5, this.hQR) + d.a.a.a.gy(6, this.swS) + d.a.a.a.gy(7, this.mPL);
      paramInt = i;
      if (this.kVs != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.kVs);
      }
      i = paramInt + d.a.a.a.gy(9, this.tJt) + d.a.a.a.gy(10, this.tJu) + d.a.a.a.gy(11, this.tJv) + d.a.a.a.X(12, this.tJw) + d.a.a.a.X(13, this.tJx);
      paramInt = i;
      if (this.tJy != null) {
        paramInt = i + d.a.a.a.gA(14, this.tJy.btq());
      }
      i = paramInt + d.a.a.a.gy(15, this.tJz);
      paramInt = i;
      if (this.swb != null) {
        paramInt = i + d.a.a.a.gA(16, this.swb.btq());
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
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bsx localbsx = (bsx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbsx.tAY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbsx.sSS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbsx.tJr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbsx.tJs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbsx.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbsx.swS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbsx.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbsx.kVs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbsx.tJt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localbsx.tJu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localbsx.tJv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localbsx.tJw = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 13: 
          localbsx.tJx = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 14: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbsx.tJy = ((bmk)localObject1);
            paramInt += 1;
          }
        case 15: 
          localbsx.tJz = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbsx.swb = ((bkk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsx
 * JD-Core Version:    0.7.0.1
 */