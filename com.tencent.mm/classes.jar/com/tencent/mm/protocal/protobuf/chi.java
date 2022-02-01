package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chi
  extends com.tencent.mm.bw.a
{
  public String ESn;
  public String FvA;
  public String FvB;
  public int FvC;
  public String FvD;
  public int FvE;
  public LinkedList<acv> FvF;
  public int Fvx;
  public LinkedList<bnx> Fvy;
  public int Fvz;
  public String Name;
  public String PriceType;
  public int Scene;
  public String ThumbUrl;
  public int ncL;
  public int ndI;
  
  public chi()
  {
    AppMethodBeat.i(91633);
    this.Fvy = new LinkedList();
    this.FvF = new LinkedList();
    AppMethodBeat.o(91633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fvx);
      paramVarArgs.e(2, 8, this.Fvy);
      paramVarArgs.aR(3, this.ncL);
      paramVarArgs.aR(4, this.Fvz);
      if (this.PriceType != null) {
        paramVarArgs.d(5, this.PriceType);
      }
      if (this.ESn != null) {
        paramVarArgs.d(6, this.ESn);
      }
      if (this.FvA != null) {
        paramVarArgs.d(7, this.FvA);
      }
      if (this.FvB != null) {
        paramVarArgs.d(8, this.FvB);
      }
      paramVarArgs.aR(9, this.ndI);
      if (this.Name != null) {
        paramVarArgs.d(10, this.Name);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(11, this.ThumbUrl);
      }
      paramVarArgs.aR(12, this.FvC);
      paramVarArgs.aR(13, this.Scene);
      if (this.FvD != null) {
        paramVarArgs.d(14, this.FvD);
      }
      paramVarArgs.aR(15, this.FvE);
      paramVarArgs.e(16, 8, this.FvF);
      AppMethodBeat.o(91634);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Fvx) + 0 + f.a.a.a.c(2, 8, this.Fvy) + f.a.a.b.b.a.bx(3, this.ncL) + f.a.a.b.b.a.bx(4, this.Fvz);
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.PriceType);
      }
      i = paramInt;
      if (this.ESn != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ESn);
      }
      paramInt = i;
      if (this.FvA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FvA);
      }
      i = paramInt;
      if (this.FvB != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FvB);
      }
      i += f.a.a.b.b.a.bx(9, this.ndI);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Name);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ThumbUrl);
      }
      i = i + f.a.a.b.b.a.bx(12, this.FvC) + f.a.a.b.b.a.bx(13, this.Scene);
      paramInt = i;
      if (this.FvD != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FvD);
      }
      i = f.a.a.b.b.a.bx(15, this.FvE);
      int j = f.a.a.a.c(16, 8, this.FvF);
      AppMethodBeat.o(91634);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fvy.clear();
      this.FvF.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      chi localchi = (chi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91634);
        return -1;
      case 1: 
        localchi.Fvx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91634);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bnx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bnx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchi.Fvy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91634);
        return 0;
      case 3: 
        localchi.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91634);
        return 0;
      case 4: 
        localchi.Fvz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91634);
        return 0;
      case 5: 
        localchi.PriceType = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 6: 
        localchi.ESn = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 7: 
        localchi.FvA = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 8: 
        localchi.FvB = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 9: 
        localchi.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91634);
        return 0;
      case 10: 
        localchi.Name = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 11: 
        localchi.ThumbUrl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 12: 
        localchi.FvC = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91634);
        return 0;
      case 13: 
        localchi.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91634);
        return 0;
      case 14: 
        localchi.FvD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 15: 
        localchi.FvE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91634);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new acv();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((acv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localchi.FvF.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    AppMethodBeat.o(91634);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chi
 * JD-Core Version:    0.7.0.1
 */