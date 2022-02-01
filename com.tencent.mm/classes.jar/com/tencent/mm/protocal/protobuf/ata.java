package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ata
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String nQG;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91465);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nQG != null) {
        paramVarArgs.g(1, this.nQG);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      AppMethodBeat.o(91465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nQG == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.nQG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.desc);
      }
      AppMethodBeat.o(91465);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91465);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ata localata = (ata)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91465);
          return -1;
        case 1: 
          localata.nQG = locala.ajGk.readString();
          AppMethodBeat.o(91465);
          return 0;
        case 2: 
          localata.title = locala.ajGk.readString();
          AppMethodBeat.o(91465);
          return 0;
        }
        localata.desc = locala.ajGk.readString();
        AppMethodBeat.o(91465);
        return 0;
      }
      AppMethodBeat.o(91465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ata
 * JD-Core Version:    0.7.0.1
 */