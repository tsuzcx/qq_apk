package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ank
  extends com.tencent.mm.bx.a
{
  public String ZuL;
  public String ZuM;
  public int crm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260171);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZuL != null) {
        paramVarArgs.g(1, this.ZuL);
      }
      if (this.ZuM != null) {
        paramVarArgs.g(2, this.ZuM);
      }
      paramVarArgs.bS(3, this.crm);
      AppMethodBeat.o(260171);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZuL == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZuL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZuM != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZuM);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.crm);
      AppMethodBeat.o(260171);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260171);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ank localank = (ank)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260171);
          return -1;
        case 1: 
          localank.ZuL = locala.ajGk.readString();
          AppMethodBeat.o(260171);
          return 0;
        case 2: 
          localank.ZuM = locala.ajGk.readString();
          AppMethodBeat.o(260171);
          return 0;
        }
        localank.crm = locala.ajGk.aar();
        AppMethodBeat.o(260171);
        return 0;
      }
      AppMethodBeat.o(260171);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ank
 * JD-Core Version:    0.7.0.1
 */