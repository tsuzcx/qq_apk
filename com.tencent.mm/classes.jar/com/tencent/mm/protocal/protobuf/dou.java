package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dou
  extends com.tencent.mm.bx.a
{
  public String YBQ;
  public int YBS;
  public String aaVE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258057);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaVE != null) {
        paramVarArgs.g(1, this.aaVE);
      }
      if (this.YBQ != null) {
        paramVarArgs.g(2, this.YBQ);
      }
      paramVarArgs.bS(3, this.YBS);
      AppMethodBeat.o(258057);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaVE == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaVE) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YBQ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YBQ);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.YBS);
      AppMethodBeat.o(258057);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258057);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dou localdou = (dou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258057);
          return -1;
        case 1: 
          localdou.aaVE = locala.ajGk.readString();
          AppMethodBeat.o(258057);
          return 0;
        case 2: 
          localdou.YBQ = locala.ajGk.readString();
          AppMethodBeat.o(258057);
          return 0;
        }
        localdou.YBS = locala.ajGk.aar();
        AppMethodBeat.o(258057);
        return 0;
      }
      AppMethodBeat.o(258057);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dou
 * JD-Core Version:    0.7.0.1
 */