package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxj
  extends com.tencent.mm.bx.a
{
  public String CoM;
  public String Epw;
  public int Epx;
  public int dep;
  public int wSJ;
  public String xin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125845);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.wSJ);
      if (this.Epw != null) {
        paramVarArgs.d(2, this.Epw);
      }
      if (this.CoM != null) {
        paramVarArgs.d(3, this.CoM);
      }
      paramVarArgs.aR(4, this.dep);
      if (this.xin != null) {
        paramVarArgs.d(5, this.xin);
      }
      paramVarArgs.aR(6, this.Epx);
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.wSJ) + 0;
      paramInt = i;
      if (this.Epw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Epw);
      }
      i = paramInt;
      if (this.CoM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CoM);
      }
      i += f.a.a.b.b.a.bA(4, this.dep);
      paramInt = i;
      if (this.xin != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.xin);
      }
      i = f.a.a.b.b.a.bA(6, this.Epx);
      AppMethodBeat.o(125845);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cxj localcxj = (cxj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125845);
        return -1;
      case 1: 
        localcxj.wSJ = locala.KhF.xS();
        AppMethodBeat.o(125845);
        return 0;
      case 2: 
        localcxj.Epw = locala.KhF.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 3: 
        localcxj.CoM = locala.KhF.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 4: 
        localcxj.dep = locala.KhF.xS();
        AppMethodBeat.o(125845);
        return 0;
      case 5: 
        localcxj.xin = locala.KhF.readString();
        AppMethodBeat.o(125845);
        return 0;
      }
      localcxj.Epx = locala.KhF.xS();
      AppMethodBeat.o(125845);
      return 0;
    }
    AppMethodBeat.o(125845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxj
 * JD-Core Version:    0.7.0.1
 */