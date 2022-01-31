package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avz
  extends com.tencent.mm.bv.a
{
  public String nqz;
  public String puI;
  public int wKy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28532);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wKy);
      if (this.puI != null) {
        paramVarArgs.e(2, this.puI);
      }
      if (this.nqz != null) {
        paramVarArgs.e(3, this.nqz);
      }
      AppMethodBeat.o(28532);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wKy) + 0;
      paramInt = i;
      if (this.puI != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.puI);
      }
      i = paramInt;
      if (this.nqz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nqz);
      }
      AppMethodBeat.o(28532);
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
      AppMethodBeat.o(28532);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      avz localavz = (avz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28532);
        return -1;
      case 1: 
        localavz.wKy = locala.CLY.sl();
        AppMethodBeat.o(28532);
        return 0;
      case 2: 
        localavz.puI = locala.CLY.readString();
        AppMethodBeat.o(28532);
        return 0;
      }
      localavz.nqz = locala.CLY.readString();
      AppMethodBeat.o(28532);
      return 0;
    }
    AppMethodBeat.o(28532);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avz
 * JD-Core Version:    0.7.0.1
 */