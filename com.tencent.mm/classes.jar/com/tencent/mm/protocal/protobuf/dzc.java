package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dzc
  extends com.tencent.mm.bx.a
{
  public String hAP;
  public String nUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43117);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nUB != null) {
        paramVarArgs.g(1, this.nUB);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      AppMethodBeat.o(43117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nUB == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.nUB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hAP);
      }
      AppMethodBeat.o(43117);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(43117);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dzc localdzc = (dzc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43117);
          return -1;
        case 1: 
          localdzc.nUB = locala.ajGk.readString();
          AppMethodBeat.o(43117);
          return 0;
        }
        localdzc.hAP = locala.ajGk.readString();
        AppMethodBeat.o(43117);
        return 0;
      }
      AppMethodBeat.o(43117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzc
 * JD-Core Version:    0.7.0.1
 */