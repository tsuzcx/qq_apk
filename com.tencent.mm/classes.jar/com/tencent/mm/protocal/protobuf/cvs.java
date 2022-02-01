package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvs
  extends com.tencent.mm.bx.a
{
  public String HdP;
  public int gsV;
  public String ueY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117905);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HdP != null) {
        paramVarArgs.d(1, this.HdP);
      }
      paramVarArgs.aS(2, this.gsV);
      if (this.ueY != null) {
        paramVarArgs.d(3, this.ueY);
      }
      AppMethodBeat.o(117905);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HdP == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.HdP) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.gsV);
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ueY);
      }
      AppMethodBeat.o(117905);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117905);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cvs localcvs = (cvs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117905);
          return -1;
        case 1: 
          localcvs.HdP = locala.NPN.readString();
          AppMethodBeat.o(117905);
          return 0;
        case 2: 
          localcvs.gsV = locala.NPN.zc();
          AppMethodBeat.o(117905);
          return 0;
        }
        localcvs.ueY = locala.NPN.readString();
        AppMethodBeat.o(117905);
        return 0;
      }
      AppMethodBeat.o(117905);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvs
 * JD-Core Version:    0.7.0.1
 */