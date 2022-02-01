package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mq
  extends com.tencent.mm.bw.a
{
  public int KQU;
  public String KQV;
  public int KQW;
  public int KQX;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124393);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      paramVarArgs.aM(2, this.KQU);
      if (this.KQV != null) {
        paramVarArgs.e(3, this.KQV);
      }
      paramVarArgs.aM(4, this.KQW);
      paramVarArgs.aM(5, this.KQX);
      AppMethodBeat.o(124393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KQU);
      paramInt = i;
      if (this.KQV != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KQV);
      }
      i = g.a.a.b.b.a.bu(4, this.KQW);
      int j = g.a.a.b.b.a.bu(5, this.KQX);
      AppMethodBeat.o(124393);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124393);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        mq localmq = (mq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124393);
          return -1;
        case 1: 
          localmq.UserName = locala.UbS.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 2: 
          localmq.KQU = locala.UbS.zi();
          AppMethodBeat.o(124393);
          return 0;
        case 3: 
          localmq.KQV = locala.UbS.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 4: 
          localmq.KQW = locala.UbS.zi();
          AppMethodBeat.o(124393);
          return 0;
        }
        localmq.KQX = locala.UbS.zi();
        AppMethodBeat.o(124393);
        return 0;
      }
      AppMethodBeat.o(124393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mq
 * JD-Core Version:    0.7.0.1
 */