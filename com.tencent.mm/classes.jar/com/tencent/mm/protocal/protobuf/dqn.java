package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqn
  extends com.tencent.mm.bw.a
{
  public String LZy;
  public String MJR;
  public String MJS;
  public int oTz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91678);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LZy != null) {
        paramVarArgs.e(1, this.LZy);
      }
      if (this.MJS != null) {
        paramVarArgs.e(2, this.MJS);
      }
      paramVarArgs.aM(3, this.oTz);
      if (this.MJR != null) {
        paramVarArgs.e(4, this.MJR);
      }
      AppMethodBeat.o(91678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LZy == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.f(1, this.LZy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MJS != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MJS);
      }
      i += g.a.a.b.b.a.bu(3, this.oTz);
      paramInt = i;
      if (this.MJR != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MJR);
      }
      AppMethodBeat.o(91678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91678);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dqn localdqn = (dqn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91678);
          return -1;
        case 1: 
          localdqn.LZy = locala.UbS.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 2: 
          localdqn.MJS = locala.UbS.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 3: 
          localdqn.oTz = locala.UbS.zi();
          AppMethodBeat.o(91678);
          return 0;
        }
        localdqn.MJR = locala.UbS.readString();
        AppMethodBeat.o(91678);
        return 0;
      }
      AppMethodBeat.o(91678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqn
 * JD-Core Version:    0.7.0.1
 */