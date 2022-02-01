package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fvv
  extends com.tencent.mm.bx.a
{
  public String VHR;
  public String VHS;
  public String VHT;
  public int abMH;
  public int mdV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258511);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.mdV);
      if (this.VHR != null) {
        paramVarArgs.g(2, this.VHR);
      }
      if (this.VHS != null) {
        paramVarArgs.g(3, this.VHS);
      }
      if (this.VHT != null) {
        paramVarArgs.g(4, this.VHT);
      }
      paramVarArgs.bS(5, this.abMH);
      AppMethodBeat.o(258511);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.mdV) + 0;
      paramInt = i;
      if (this.VHR != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.VHR);
      }
      i = paramInt;
      if (this.VHS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.VHS);
      }
      paramInt = i;
      if (this.VHT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.VHT);
      }
      i = i.a.a.b.b.a.cJ(5, this.abMH);
      AppMethodBeat.o(258511);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258511);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fvv localfvv = (fvv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258511);
        return -1;
      case 1: 
        localfvv.mdV = locala.ajGk.aar();
        AppMethodBeat.o(258511);
        return 0;
      case 2: 
        localfvv.VHR = locala.ajGk.readString();
        AppMethodBeat.o(258511);
        return 0;
      case 3: 
        localfvv.VHS = locala.ajGk.readString();
        AppMethodBeat.o(258511);
        return 0;
      case 4: 
        localfvv.VHT = locala.ajGk.readString();
        AppMethodBeat.o(258511);
        return 0;
      }
      localfvv.abMH = locala.ajGk.aar();
      AppMethodBeat.o(258511);
      return 0;
    }
    AppMethodBeat.o(258511);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvv
 * JD-Core Version:    0.7.0.1
 */