package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkv
  extends com.tencent.mm.bx.a
{
  public int YFu;
  public String aaQP;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124528);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaQP != null) {
        paramVarArgs.g(1, this.aaQP);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      paramVarArgs.bS(3, this.YFu);
      AppMethodBeat.o(124528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaQP == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaQP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hAP);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.YFu);
      AppMethodBeat.o(124528);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124528);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dkv localdkv = (dkv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124528);
          return -1;
        case 1: 
          localdkv.aaQP = locala.ajGk.readString();
          AppMethodBeat.o(124528);
          return 0;
        case 2: 
          localdkv.hAP = locala.ajGk.readString();
          AppMethodBeat.o(124528);
          return 0;
        }
        localdkv.YFu = locala.ajGk.aar();
        AppMethodBeat.o(124528);
        return 0;
      }
      AppMethodBeat.o(124528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkv
 * JD-Core Version:    0.7.0.1
 */