package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class adk
  extends blm
{
  public int bZe;
  public String iQe;
  public String sign;
  public String stb;
  public String stc;
  public int std;
  public LinkedList<lw> stg = new LinkedList();
  public String tbG;
  public String tbH;
  
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
      paramVarArgs.d(2, 8, this.stg);
      paramVarArgs.gB(3, this.bZe);
      if (this.tbH != null) {
        paramVarArgs.d(4, this.tbH);
      }
      if (this.iQe != null) {
        paramVarArgs.d(5, this.iQe);
      }
      if (this.sign != null) {
        paramVarArgs.d(6, this.sign);
      }
      if (this.stb != null) {
        paramVarArgs.d(7, this.stb);
      }
      if (this.stc != null) {
        paramVarArgs.d(8, this.stc);
      }
      if (this.tbG != null) {
        paramVarArgs.d(9, this.tbG);
      }
      paramVarArgs.gB(10, this.std);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.stg) + d.a.a.a.gy(3, this.bZe);
      paramInt = i;
      if (this.tbH != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tbH);
      }
      i = paramInt;
      if (this.iQe != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.iQe);
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sign);
      }
      i = paramInt;
      if (this.stb != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.stb);
      }
      paramInt = i;
      if (this.stc != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.stc);
      }
      i = paramInt;
      if (this.tbG != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.tbG);
      }
      return i + d.a.a.a.gy(10, this.std);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.stg.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        adk localadk = (adk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localadk.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localadk.stg.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          localadk.bZe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localadk.tbH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localadk.iQe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localadk.sign = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localadk.stb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localadk.stc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localadk.tbG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localadk.std = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.adk
 * JD-Core Version:    0.7.0.1
 */