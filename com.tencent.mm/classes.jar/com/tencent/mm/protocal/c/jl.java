package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class jl
  extends blm
{
  public int count;
  public int mLS;
  public int nFr;
  public String nGG;
  public String nGH;
  public String sEc;
  public String sEd;
  public String sEe;
  public String sEf;
  public String sEg;
  public String sEh;
  public int type;
  public String value;
  
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
      if (this.nGH != null) {
        paramVarArgs.d(9, this.nGH);
      }
      if (this.nGG != null) {
        paramVarArgs.d(10, this.nGG);
      }
      paramVarArgs.gB(11, this.type);
      if (this.value != null) {
        paramVarArgs.d(12, this.value);
      }
      paramVarArgs.gB(13, this.count);
      paramVarArgs.gB(14, this.mLS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label936;
      }
    }
    label936:
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
      i = paramInt;
      if (this.nGH != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.nGH);
      }
      paramInt = i;
      if (this.nGG != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.nGG);
      }
      i = paramInt + d.a.a.a.gy(11, this.type);
      paramInt = i;
      if (this.value != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.value);
      }
      return paramInt + d.a.a.a.gy(13, this.count) + d.a.a.a.gy(14, this.mLS);
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
        jl localjl = (jl)paramVarArgs[1];
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
            localjl.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localjl.sEc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localjl.sEd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localjl.sEe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localjl.sEf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localjl.sEg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localjl.nFr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localjl.sEh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localjl.nGH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localjl.nGG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localjl.type = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localjl.value = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localjl.count = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localjl.mLS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jl
 * JD-Core Version:    0.7.0.1
 */