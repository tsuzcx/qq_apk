package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aad
  extends blm
{
  public int nFr;
  public String sEc;
  public String sEd;
  public String sEe;
  public String sEf;
  public String sEg;
  public String sEh;
  
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
      if (this.sEc != null) {
        paramVarArgs.d(2, this.sEc);
      }
      if (this.sEd != null) {
        paramVarArgs.d(3, this.sEd);
      }
      if (this.sEe != null) {
        paramVarArgs.d(4, this.sEe);
      }
      if (this.sEf != null) {
        paramVarArgs.d(5, this.sEf);
      }
      if (this.sEg != null) {
        paramVarArgs.d(6, this.sEg);
      }
      paramVarArgs.gB(7, this.nFr);
      if (this.sEh != null) {
        paramVarArgs.d(8, this.sEh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label646;
      }
    }
    label646:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sEc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sEc);
      }
      i = paramInt;
      if (this.sEd != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sEd);
      }
      paramInt = i;
      if (this.sEe != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sEe);
      }
      i = paramInt;
      if (this.sEf != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sEf);
      }
      paramInt = i;
      if (this.sEg != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sEg);
      }
      i = paramInt + d.a.a.a.gy(7, this.nFr);
      paramInt = i;
      if (this.sEh != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sEh);
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
        aad localaad = (aad)paramVarArgs[1];
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
            localaad.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaad.sEc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaad.sEd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaad.sEe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaad.sEf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaad.sEg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localaad.nFr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaad.sEh = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aad
 * JD-Core Version:    0.7.0.1
 */