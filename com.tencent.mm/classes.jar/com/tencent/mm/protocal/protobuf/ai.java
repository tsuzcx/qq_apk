package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai
  extends com.tencent.mm.bx.a
{
  public String YAQ;
  public int YAR;
  public int YAS;
  public int YAT;
  public int YAU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143961);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YAQ != null) {
        paramVarArgs.g(1, this.YAQ);
      }
      paramVarArgs.bS(2, this.YAR);
      paramVarArgs.bS(3, this.YAS);
      paramVarArgs.bS(4, this.YAT);
      paramVarArgs.bS(5, this.YAU);
      AppMethodBeat.o(143961);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YAQ == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = i.a.a.b.b.a.h(1, this.YAQ) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.YAR);
      int j = i.a.a.b.b.a.cJ(3, this.YAS);
      int k = i.a.a.b.b.a.cJ(4, this.YAT);
      int m = i.a.a.b.b.a.cJ(5, this.YAU);
      AppMethodBeat.o(143961);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(143961);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(143961);
          return -1;
        case 1: 
          localai.YAQ = locala.ajGk.readString();
          AppMethodBeat.o(143961);
          return 0;
        case 2: 
          localai.YAR = locala.ajGk.aar();
          AppMethodBeat.o(143961);
          return 0;
        case 3: 
          localai.YAS = locala.ajGk.aar();
          AppMethodBeat.o(143961);
          return 0;
        case 4: 
          localai.YAT = locala.ajGk.aar();
          AppMethodBeat.o(143961);
          return 0;
        }
        localai.YAU = locala.ajGk.aar();
        AppMethodBeat.o(143961);
        return 0;
      }
      AppMethodBeat.o(143961);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ai
 * JD-Core Version:    0.7.0.1
 */