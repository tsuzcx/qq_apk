package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cet
  extends com.tencent.mm.bx.a
{
  public String bVF;
  public int status;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152636);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      paramVarArgs.aS(2, this.status);
      if (this.bVF != null) {
        paramVarArgs.d(3, this.bVF);
      }
      AppMethodBeat.o(152636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.status);
      paramInt = i;
      if (this.bVF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.bVF);
      }
      AppMethodBeat.o(152636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152636);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cet localcet = (cet)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152636);
          return -1;
        case 1: 
          localcet.userName = locala.NPN.readString();
          AppMethodBeat.o(152636);
          return 0;
        case 2: 
          localcet.status = locala.NPN.zc();
          AppMethodBeat.o(152636);
          return 0;
        }
        localcet.bVF = locala.NPN.readString();
        AppMethodBeat.o(152636);
        return 0;
      }
      AppMethodBeat.o(152636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cet
 * JD-Core Version:    0.7.0.1
 */