package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bx.a
{
  public String FpG;
  public String FpH;
  public String FpU;
  public String FpV;
  public String FpW;
  public long dOa;
  public int role;
  public int state;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91322);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FpG != null) {
        paramVarArgs.d(1, this.FpG);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aY(3, this.dOa);
      if (this.FpU != null) {
        paramVarArgs.d(5, this.FpU);
      }
      paramVarArgs.aS(10, this.state);
      paramVarArgs.aS(11, this.role);
      if (this.FpV != null) {
        paramVarArgs.d(12, this.FpV);
      }
      if (this.FpH != null) {
        paramVarArgs.d(13, this.FpH);
      }
      if (this.FpW != null) {
        paramVarArgs.d(14, this.FpW);
      }
      AppMethodBeat.o(91322);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FpG == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.b.b.a.e(1, this.FpG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      i += f.a.a.b.b.a.p(3, this.dOa);
      paramInt = i;
      if (this.FpU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FpU);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.state) + f.a.a.b.b.a.bz(11, this.role);
      paramInt = i;
      if (this.FpV != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FpV);
      }
      i = paramInt;
      if (this.FpH != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FpH);
      }
      paramInt = i;
      if (this.FpW != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FpW);
      }
      AppMethodBeat.o(91322);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91322);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 4: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(91322);
          return -1;
        case 1: 
          localk.FpG = locala.NPN.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 2: 
          localk.title = locala.NPN.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 3: 
          localk.dOa = locala.NPN.zd();
          AppMethodBeat.o(91322);
          return 0;
        case 5: 
          localk.FpU = locala.NPN.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 10: 
          localk.state = locala.NPN.zc();
          AppMethodBeat.o(91322);
          return 0;
        case 11: 
          localk.role = locala.NPN.zc();
          AppMethodBeat.o(91322);
          return 0;
        case 12: 
          localk.FpV = locala.NPN.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 13: 
          localk.FpH = locala.NPN.readString();
          AppMethodBeat.o(91322);
          return 0;
        }
        localk.FpW = locala.NPN.readString();
        AppMethodBeat.o(91322);
        return 0;
      }
      AppMethodBeat.o(91322);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.k
 * JD-Core Version:    0.7.0.1
 */