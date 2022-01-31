package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aub
  extends com.tencent.mm.bv.a
{
  public String opB;
  public String opC;
  public String opD;
  public String opE;
  public int wkQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48865);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wkQ);
      if (this.opB != null) {
        paramVarArgs.e(2, this.opB);
      }
      if (this.opC != null) {
        paramVarArgs.e(3, this.opC);
      }
      if (this.opD != null) {
        paramVarArgs.e(4, this.opD);
      }
      if (this.opE != null) {
        paramVarArgs.e(5, this.opE);
      }
      AppMethodBeat.o(48865);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wkQ) + 0;
      paramInt = i;
      if (this.opB != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.opB);
      }
      i = paramInt;
      if (this.opC != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.opC);
      }
      paramInt = i;
      if (this.opD != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.opD);
      }
      i = paramInt;
      if (this.opE != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.opE);
      }
      AppMethodBeat.o(48865);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(48865);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aub localaub = (aub)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(48865);
        return -1;
      case 1: 
        localaub.wkQ = locala.CLY.sl();
        AppMethodBeat.o(48865);
        return 0;
      case 2: 
        localaub.opB = locala.CLY.readString();
        AppMethodBeat.o(48865);
        return 0;
      case 3: 
        localaub.opC = locala.CLY.readString();
        AppMethodBeat.o(48865);
        return 0;
      case 4: 
        localaub.opD = locala.CLY.readString();
        AppMethodBeat.o(48865);
        return 0;
      }
      localaub.opE = locala.CLY.readString();
      AppMethodBeat.o(48865);
      return 0;
    }
    AppMethodBeat.o(48865);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aub
 * JD-Core Version:    0.7.0.1
 */