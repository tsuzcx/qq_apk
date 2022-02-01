package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dol
  extends com.tencent.mm.bx.a
{
  public String nRQ;
  public String url;
  public String vFa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72514);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vFa != null) {
        paramVarArgs.g(1, this.vFa);
      }
      if (this.nRQ != null) {
        paramVarArgs.g(2, this.nRQ);
      }
      if (this.url != null) {
        paramVarArgs.g(4, this.url);
      }
      AppMethodBeat.o(72514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vFa == null) {
        break label334;
      }
    }
    label334:
    for (int i = i.a.a.b.b.a.h(1, this.vFa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nRQ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nRQ);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.url);
      }
      AppMethodBeat.o(72514);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72514);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dol localdol = (dol)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72514);
          return -1;
        case 1: 
          localdol.vFa = locala.ajGk.readString();
          AppMethodBeat.o(72514);
          return 0;
        case 2: 
          localdol.nRQ = locala.ajGk.readString();
          AppMethodBeat.o(72514);
          return 0;
        }
        localdol.url = locala.ajGk.readString();
        AppMethodBeat.o(72514);
        return 0;
      }
      AppMethodBeat.o(72514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dol
 * JD-Core Version:    0.7.0.1
 */