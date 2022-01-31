package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dc
  extends com.tencent.mm.bv.a
{
  public int bsY;
  public String cyA;
  public String kNB;
  public String opC;
  public String opD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48772);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.bsY);
      if (this.cyA != null) {
        paramVarArgs.e(2, this.cyA);
      }
      if (this.opC != null) {
        paramVarArgs.e(3, this.opC);
      }
      if (this.opD != null) {
        paramVarArgs.e(4, this.opD);
      }
      if (this.kNB != null) {
        paramVarArgs.e(5, this.kNB);
      }
      AppMethodBeat.o(48772);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.bsY) + 0;
      paramInt = i;
      if (this.cyA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cyA);
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
      if (this.kNB != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.kNB);
      }
      AppMethodBeat.o(48772);
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
      AppMethodBeat.o(48772);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dc localdc = (dc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(48772);
        return -1;
      case 1: 
        localdc.bsY = locala.CLY.sl();
        AppMethodBeat.o(48772);
        return 0;
      case 2: 
        localdc.cyA = locala.CLY.readString();
        AppMethodBeat.o(48772);
        return 0;
      case 3: 
        localdc.opC = locala.CLY.readString();
        AppMethodBeat.o(48772);
        return 0;
      case 4: 
        localdc.opD = locala.CLY.readString();
        AppMethodBeat.o(48772);
        return 0;
      }
      localdc.kNB = locala.CLY.readString();
      AppMethodBeat.o(48772);
      return 0;
    }
    AppMethodBeat.o(48772);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dc
 * JD-Core Version:    0.7.0.1
 */