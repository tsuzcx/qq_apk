package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eyx
  extends com.tencent.mm.bx.a
{
  public String abzX;
  public String className;
  public String dataPath;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122531);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.className != null) {
        paramVarArgs.g(1, this.className);
      }
      if (this.dataPath != null) {
        paramVarArgs.g(2, this.dataPath);
      }
      if (this.abzX != null) {
        paramVarArgs.g(3, this.abzX);
      }
      AppMethodBeat.o(122531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.className == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.className) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dataPath != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.dataPath);
      }
      i = paramInt;
      if (this.abzX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abzX);
      }
      AppMethodBeat.o(122531);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122531);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eyx localeyx = (eyx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122531);
          return -1;
        case 1: 
          localeyx.className = locala.ajGk.readString();
          AppMethodBeat.o(122531);
          return 0;
        case 2: 
          localeyx.dataPath = locala.ajGk.readString();
          AppMethodBeat.o(122531);
          return 0;
        }
        localeyx.abzX = locala.ajGk.readString();
        AppMethodBeat.o(122531);
        return 0;
      }
      AppMethodBeat.o(122531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyx
 * JD-Core Version:    0.7.0.1
 */