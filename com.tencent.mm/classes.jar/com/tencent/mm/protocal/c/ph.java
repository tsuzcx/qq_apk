package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ph
  extends blm
{
  public String bGw;
  public String euK;
  public String eux;
  public int pyo;
  public String sMY;
  public String sMZ;
  public String sNa;
  public String sNb;
  public String sNc;
  public String sNd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.eux != null) {
        paramVarArgs.d(2, this.eux);
      }
      if (this.bGw != null) {
        paramVarArgs.d(3, this.bGw);
      }
      if (this.sMY != null) {
        paramVarArgs.d(4, this.sMY);
      }
      if (this.sMZ != null) {
        paramVarArgs.d(5, this.sMZ);
      }
      if (this.sNa != null) {
        paramVarArgs.d(6, this.sNa);
      }
      if (this.sNb != null) {
        paramVarArgs.d(7, this.sNb);
      }
      if (this.sNc != null) {
        paramVarArgs.d(8, this.sNc);
      }
      if (this.euK != null) {
        paramVarArgs.d(9, this.euK);
      }
      paramVarArgs.gB(10, this.pyo);
      if (this.sNd != null) {
        paramVarArgs.d(11, this.sNd);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label819;
      }
    }
    label819:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.eux != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.eux);
      }
      i = paramInt;
      if (this.bGw != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bGw);
      }
      paramInt = i;
      if (this.sMY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sMY);
      }
      i = paramInt;
      if (this.sMZ != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sMZ);
      }
      paramInt = i;
      if (this.sNa != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sNa);
      }
      i = paramInt;
      if (this.sNb != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sNb);
      }
      paramInt = i;
      if (this.sNc != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sNc);
      }
      i = paramInt;
      if (this.euK != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.euK);
      }
      i += d.a.a.a.gy(10, this.pyo);
      paramInt = i;
      if (this.sNd != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.sNd);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ph localph = (ph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localph.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localph.eux = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localph.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localph.sMY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localph.sMZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localph.sNa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localph.sNb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localph.sNc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localph.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localph.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localph.sNd = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ph
 * JD-Core Version:    0.7.0.1
 */