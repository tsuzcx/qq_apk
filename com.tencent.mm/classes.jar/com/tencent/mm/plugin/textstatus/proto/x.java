package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bx.a
{
  public String ToD;
  public int end_time;
  public int ftu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290052);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ToD != null) {
        paramVarArgs.g(1, this.ToD);
      }
      paramVarArgs.bS(2, this.ftu);
      paramVarArgs.bS(3, this.end_time);
      AppMethodBeat.o(290052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ToD == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.ToD) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ftu);
      int j = i.a.a.b.b.a.cJ(3, this.end_time);
      AppMethodBeat.o(290052);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290052);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(290052);
          return -1;
        case 1: 
          localx.ToD = locala.ajGk.readString();
          AppMethodBeat.o(290052);
          return 0;
        case 2: 
          localx.ftu = locala.ajGk.aar();
          AppMethodBeat.o(290052);
          return 0;
        }
        localx.end_time = locala.ajGk.aar();
        AppMethodBeat.o(290052);
        return 0;
      }
      AppMethodBeat.o(290052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.x
 * JD-Core Version:    0.7.0.1
 */