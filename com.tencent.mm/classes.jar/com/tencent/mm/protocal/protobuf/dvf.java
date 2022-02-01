package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvf
  extends com.tencent.mm.bx.a
{
  public String abbd;
  public String abbe;
  public String abbf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258905);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abbd != null) {
        paramVarArgs.g(1, this.abbd);
      }
      if (this.abbe != null) {
        paramVarArgs.g(2, this.abbe);
      }
      if (this.abbf != null) {
        paramVarArgs.g(3, this.abbf);
      }
      AppMethodBeat.o(258905);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abbd == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.abbd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abbe != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abbe);
      }
      i = paramInt;
      if (this.abbf != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abbf);
      }
      AppMethodBeat.o(258905);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258905);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dvf localdvf = (dvf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258905);
          return -1;
        case 1: 
          localdvf.abbd = locala.ajGk.readString();
          AppMethodBeat.o(258905);
          return 0;
        case 2: 
          localdvf.abbe = locala.ajGk.readString();
          AppMethodBeat.o(258905);
          return 0;
        }
        localdvf.abbf = locala.ajGk.readString();
        AppMethodBeat.o(258905);
        return 0;
      }
      AppMethodBeat.o(258905);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvf
 * JD-Core Version:    0.7.0.1
 */