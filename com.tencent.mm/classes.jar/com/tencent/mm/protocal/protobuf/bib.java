package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bib
  extends com.tencent.mm.bv.a
{
  public String blZ;
  public int status;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80130);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.e(1, this.userName);
      }
      paramVarArgs.aO(2, this.status);
      if (this.blZ != null) {
        paramVarArgs.e(3, this.blZ);
      }
      AppMethodBeat.o(80130);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.status);
      paramInt = i;
      if (this.blZ != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.blZ);
      }
      AppMethodBeat.o(80130);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80130);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bib localbib = (bib)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80130);
          return -1;
        case 1: 
          localbib.userName = locala.CLY.readString();
          AppMethodBeat.o(80130);
          return 0;
        case 2: 
          localbib.status = locala.CLY.sl();
          AppMethodBeat.o(80130);
          return 0;
        }
        localbib.blZ = locala.CLY.readString();
        AppMethodBeat.o(80130);
        return 0;
      }
      AppMethodBeat.o(80130);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bib
 * JD-Core Version:    0.7.0.1
 */