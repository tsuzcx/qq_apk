package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acx
  extends com.tencent.mm.bx.a
{
  public String Zlw;
  public String zIB;
  public String zIO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257897);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.zIO != null) {
        paramVarArgs.g(1, this.zIO);
      }
      if (this.zIB != null) {
        paramVarArgs.g(2, this.zIB);
      }
      if (this.Zlw != null) {
        paramVarArgs.g(3, this.Zlw);
      }
      AppMethodBeat.o(257897);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zIO == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.zIO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.zIB != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.zIB);
      }
      i = paramInt;
      if (this.Zlw != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zlw);
      }
      AppMethodBeat.o(257897);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257897);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        acx localacx = (acx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257897);
          return -1;
        case 1: 
          localacx.zIO = locala.ajGk.readString();
          AppMethodBeat.o(257897);
          return 0;
        case 2: 
          localacx.zIB = locala.ajGk.readString();
          AppMethodBeat.o(257897);
          return 0;
        }
        localacx.Zlw = locala.ajGk.readString();
        AppMethodBeat.o(257897);
        return 0;
      }
      AppMethodBeat.o(257897);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acx
 * JD-Core Version:    0.7.0.1
 */