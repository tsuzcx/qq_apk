package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class et
  extends com.tencent.mm.bx.a
{
  public String OiR;
  public String title;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168751);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.OiR != null) {
        paramVarArgs.g(3, this.OiR);
      }
      AppMethodBeat.o(168751);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.OiR != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.OiR);
      }
      AppMethodBeat.o(168751);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168751);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        et localet = (et)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168751);
          return -1;
        case 1: 
          localet.title = locala.ajGk.readString();
          AppMethodBeat.o(168751);
          return 0;
        case 2: 
          localet.wording = locala.ajGk.readString();
          AppMethodBeat.o(168751);
          return 0;
        }
        localet.OiR = locala.ajGk.readString();
        AppMethodBeat.o(168751);
        return 0;
      }
      AppMethodBeat.o(168751);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.et
 * JD-Core Version:    0.7.0.1
 */