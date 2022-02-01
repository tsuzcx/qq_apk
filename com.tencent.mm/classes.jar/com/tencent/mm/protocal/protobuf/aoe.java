package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoe
  extends com.tencent.mm.bx.a
{
  public int Dpk;
  public int Dpr;
  public String Dps;
  public String Dpt;
  public String Dpu;
  public String Dpv;
  public int Scene;
  public String hnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dpr);
      if (this.Dps != null) {
        paramVarArgs.d(2, this.Dps);
      }
      if (this.hnC != null) {
        paramVarArgs.d(3, this.hnC);
      }
      if (this.Dpt != null) {
        paramVarArgs.d(4, this.Dpt);
      }
      if (this.Dpu != null) {
        paramVarArgs.d(5, this.Dpu);
      }
      if (this.Dpv != null) {
        paramVarArgs.d(7, this.Dpv);
      }
      paramVarArgs.aR(8, this.Dpk);
      paramVarArgs.aR(9, this.Scene);
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Dpr) + 0;
      paramInt = i;
      if (this.Dps != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dps);
      }
      i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hnC);
      }
      paramInt = i;
      if (this.Dpt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dpt);
      }
      i = paramInt;
      if (this.Dpu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dpu);
      }
      paramInt = i;
      if (this.Dpv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Dpv);
      }
      i = f.a.a.b.b.a.bA(8, this.Dpk);
      int j = f.a.a.b.b.a.bA(9, this.Scene);
      AppMethodBeat.o(152546);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aoe localaoe = (aoe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(152546);
        return -1;
      case 1: 
        localaoe.Dpr = locala.KhF.xS();
        AppMethodBeat.o(152546);
        return 0;
      case 2: 
        localaoe.Dps = locala.KhF.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 3: 
        localaoe.hnC = locala.KhF.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 4: 
        localaoe.Dpt = locala.KhF.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 5: 
        localaoe.Dpu = locala.KhF.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 7: 
        localaoe.Dpv = locala.KhF.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 8: 
        localaoe.Dpk = locala.KhF.xS();
        AppMethodBeat.o(152546);
        return 0;
      }
      localaoe.Scene = locala.KhF.xS();
      AppMethodBeat.o(152546);
      return 0;
    }
    AppMethodBeat.o(152546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoe
 * JD-Core Version:    0.7.0.1
 */