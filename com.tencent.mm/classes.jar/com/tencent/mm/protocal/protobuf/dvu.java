package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvu
  extends com.tencent.mm.bx.a
{
  public int dvY;
  public String dvZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103210);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvZ != null) {
        paramVarArgs.d(1, this.dvZ);
      }
      paramVarArgs.aS(2, this.dvY);
      AppMethodBeat.o(103210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvZ == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.dvZ) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.dvY);
      AppMethodBeat.o(103210);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(103210);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvu localdvu = (dvu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103210);
          return -1;
        case 1: 
          localdvu.dvZ = locala.NPN.readString();
          AppMethodBeat.o(103210);
          return 0;
        }
        localdvu.dvY = locala.NPN.zc();
        AppMethodBeat.o(103210);
        return 0;
      }
      AppMethodBeat.o(103210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvu
 * JD-Core Version:    0.7.0.1
 */