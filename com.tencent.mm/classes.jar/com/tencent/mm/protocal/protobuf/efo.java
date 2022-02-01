package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efo
  extends com.tencent.mm.bx.a
{
  public String HQN;
  public int HQO;
  public String Nickname;
  public String ufR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124574);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HQN != null) {
        paramVarArgs.d(1, this.HQN);
      }
      if (this.ufR != null) {
        paramVarArgs.d(2, this.ufR);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(3, this.Nickname);
      }
      paramVarArgs.aS(4, this.HQO);
      AppMethodBeat.o(124574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HQN == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.HQN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ufR);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Nickname);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HQO);
      AppMethodBeat.o(124574);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124574);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efo localefo = (efo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124574);
          return -1;
        case 1: 
          localefo.HQN = locala.NPN.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 2: 
          localefo.ufR = locala.NPN.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 3: 
          localefo.Nickname = locala.NPN.readString();
          AppMethodBeat.o(124574);
          return 0;
        }
        localefo.HQO = locala.NPN.zc();
        AppMethodBeat.o(124574);
        return 0;
      }
      AppMethodBeat.o(124574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efo
 * JD-Core Version:    0.7.0.1
 */