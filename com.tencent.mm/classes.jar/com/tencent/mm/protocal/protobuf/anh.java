package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anh
  extends com.tencent.mm.cd.a
{
  public String Sus;
  public String Sxx;
  public String UserName;
  public int rVU;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32210);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.Sxx != null) {
        paramVarArgs.f(2, this.Sxx);
      }
      if (this.rWI != null) {
        paramVarArgs.f(3, this.rWI);
      }
      if (this.Sus != null) {
        paramVarArgs.f(4, this.Sus);
      }
      paramVarArgs.aY(5, this.rVU);
      AppMethodBeat.o(32210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label449;
      }
    }
    label449:
    for (int i = g.a.a.b.b.a.g(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sxx != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sxx);
      }
      i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rWI);
      }
      paramInt = i;
      if (this.Sus != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sus);
      }
      i = g.a.a.b.b.a.bM(5, this.rVU);
      AppMethodBeat.o(32210);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32210);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        anh localanh = (anh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32210);
          return -1;
        case 1: 
          localanh.UserName = locala.abFh.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 2: 
          localanh.Sxx = locala.abFh.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 3: 
          localanh.rWI = locala.abFh.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 4: 
          localanh.Sus = locala.abFh.readString();
          AppMethodBeat.o(32210);
          return 0;
        }
        localanh.rVU = locala.abFh.AK();
        AppMethodBeat.o(32210);
        return 0;
      }
      AppMethodBeat.o(32210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anh
 * JD-Core Version:    0.7.0.1
 */