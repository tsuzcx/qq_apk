package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqc
  extends com.tencent.mm.bw.a
{
  public String Username;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181513);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.xut != null) {
        paramVarArgs.e(2, this.xut);
      }
      AppMethodBeat.o(181513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xut != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xut);
      }
      AppMethodBeat.o(181513);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(181513);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dqc localdqc = (dqc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181513);
          return -1;
        case 1: 
          localdqc.Username = locala.UbS.readString();
          AppMethodBeat.o(181513);
          return 0;
        }
        localdqc.xut = locala.UbS.readString();
        AppMethodBeat.o(181513);
        return 0;
      }
      AppMethodBeat.o(181513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqc
 * JD-Core Version:    0.7.0.1
 */