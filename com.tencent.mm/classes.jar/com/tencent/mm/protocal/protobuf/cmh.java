package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmh
  extends com.tencent.mm.bx.a
{
  public String GBF;
  public int HfC;
  public LinkedList<bsj> HfD;
  public int HfE;
  public String HfF;
  public String HfG;
  public int HfH;
  public String HfI;
  public int HfJ;
  public LinkedList<aew> HfK;
  public String Name;
  public String PriceType;
  public int Scene;
  public String ThumbUrl;
  public int nDi;
  public int nEf;
  
  public cmh()
  {
    AppMethodBeat.i(91633);
    this.HfD = new LinkedList();
    this.HfK = new LinkedList();
    AppMethodBeat.o(91633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HfC);
      paramVarArgs.e(2, 8, this.HfD);
      paramVarArgs.aS(3, this.nDi);
      paramVarArgs.aS(4, this.HfE);
      if (this.PriceType != null) {
        paramVarArgs.d(5, this.PriceType);
      }
      if (this.GBF != null) {
        paramVarArgs.d(6, this.GBF);
      }
      if (this.HfF != null) {
        paramVarArgs.d(7, this.HfF);
      }
      if (this.HfG != null) {
        paramVarArgs.d(8, this.HfG);
      }
      paramVarArgs.aS(9, this.nEf);
      if (this.Name != null) {
        paramVarArgs.d(10, this.Name);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(11, this.ThumbUrl);
      }
      paramVarArgs.aS(12, this.HfH);
      paramVarArgs.aS(13, this.Scene);
      if (this.HfI != null) {
        paramVarArgs.d(14, this.HfI);
      }
      paramVarArgs.aS(15, this.HfJ);
      paramVarArgs.e(16, 8, this.HfK);
      AppMethodBeat.o(91634);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HfC) + 0 + f.a.a.a.c(2, 8, this.HfD) + f.a.a.b.b.a.bz(3, this.nDi) + f.a.a.b.b.a.bz(4, this.HfE);
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.PriceType);
      }
      i = paramInt;
      if (this.GBF != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GBF);
      }
      paramInt = i;
      if (this.HfF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HfF);
      }
      i = paramInt;
      if (this.HfG != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HfG);
      }
      i += f.a.a.b.b.a.bz(9, this.nEf);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Name);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ThumbUrl);
      }
      i = i + f.a.a.b.b.a.bz(12, this.HfH) + f.a.a.b.b.a.bz(13, this.Scene);
      paramInt = i;
      if (this.HfI != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HfI);
      }
      i = f.a.a.b.b.a.bz(15, this.HfJ);
      int j = f.a.a.a.c(16, 8, this.HfK);
      AppMethodBeat.o(91634);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HfD.clear();
      this.HfK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cmh localcmh = (cmh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91634);
        return -1;
      case 1: 
        localcmh.HfC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmh.HfD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91634);
        return 0;
      case 3: 
        localcmh.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 4: 
        localcmh.HfE = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 5: 
        localcmh.PriceType = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 6: 
        localcmh.GBF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 7: 
        localcmh.HfF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 8: 
        localcmh.HfG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 9: 
        localcmh.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 10: 
        localcmh.Name = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 11: 
        localcmh.ThumbUrl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 12: 
        localcmh.HfH = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 13: 
        localcmh.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 14: 
        localcmh.HfI = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 15: 
        localcmh.HfJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91634);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aew();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcmh.HfK.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    AppMethodBeat.o(91634);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmh
 * JD-Core Version:    0.7.0.1
 */