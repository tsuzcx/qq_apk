package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcd
  extends com.tencent.mm.bx.a
{
  public String YBP;
  public String YBQ;
  public int YBS;
  public String xmo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259340);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YBP != null) {
        paramVarArgs.g(1, this.YBP);
      }
      if (this.YBQ != null) {
        paramVarArgs.g(2, this.YBQ);
      }
      if (this.xmo != null) {
        paramVarArgs.g(3, this.xmo);
      }
      paramVarArgs.bS(4, this.YBS);
      AppMethodBeat.o(259340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YBP == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.YBP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YBQ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YBQ);
      }
      i = paramInt;
      if (this.xmo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xmo);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.YBS);
      AppMethodBeat.o(259340);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259340);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bcd localbcd = (bcd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259340);
          return -1;
        case 1: 
          localbcd.YBP = locala.ajGk.readString();
          AppMethodBeat.o(259340);
          return 0;
        case 2: 
          localbcd.YBQ = locala.ajGk.readString();
          AppMethodBeat.o(259340);
          return 0;
        case 3: 
          localbcd.xmo = locala.ajGk.readString();
          AppMethodBeat.o(259340);
          return 0;
        }
        localbcd.YBS = locala.ajGk.aar();
        AppMethodBeat.o(259340);
        return 0;
      }
      AppMethodBeat.o(259340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcd
 * JD-Core Version:    0.7.0.1
 */