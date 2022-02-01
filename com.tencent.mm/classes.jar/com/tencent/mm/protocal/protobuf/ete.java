package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ete
  extends com.tencent.mm.bx.a
{
  public String IcT;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181513);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.g(1, this.Username);
      }
      if (this.IcT != null) {
        paramVarArgs.g(2, this.IcT);
      }
      AppMethodBeat.o(181513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IcT != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IcT);
      }
      AppMethodBeat.o(181513);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(181513);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ete localete = (ete)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181513);
          return -1;
        case 1: 
          localete.Username = locala.ajGk.readString();
          AppMethodBeat.o(181513);
          return 0;
        }
        localete.IcT = locala.ajGk.readString();
        AppMethodBeat.o(181513);
        return 0;
      }
      AppMethodBeat.o(181513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ete
 * JD-Core Version:    0.7.0.1
 */