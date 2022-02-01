package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aks
  extends com.tencent.mm.bx.a
{
  public String ILw;
  public String OzQ;
  public int ZrW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258147);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ILw != null) {
        paramVarArgs.g(1, this.ILw);
      }
      if (this.OzQ != null) {
        paramVarArgs.g(2, this.OzQ);
      }
      paramVarArgs.bS(3, this.ZrW);
      AppMethodBeat.o(258147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ILw == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.ILw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.OzQ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.OzQ);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ZrW);
      AppMethodBeat.o(258147);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258147);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aks localaks = (aks)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258147);
          return -1;
        case 1: 
          localaks.ILw = locala.ajGk.readString();
          AppMethodBeat.o(258147);
          return 0;
        case 2: 
          localaks.OzQ = locala.ajGk.readString();
          AppMethodBeat.o(258147);
          return 0;
        }
        localaks.ZrW = locala.ajGk.aar();
        AppMethodBeat.o(258147);
        return 0;
      }
      AppMethodBeat.o(258147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aks
 * JD-Core Version:    0.7.0.1
 */