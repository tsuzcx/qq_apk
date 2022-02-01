package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyf
  extends com.tencent.mm.bw.a
{
  public String lHA;
  public String lHB;
  public String qwt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91691);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lHA != null) {
        paramVarArgs.e(1, this.lHA);
      }
      if (this.lHB != null) {
        paramVarArgs.e(2, this.lHB);
      }
      if (this.qwt != null) {
        paramVarArgs.e(3, this.qwt);
      }
      AppMethodBeat.o(91691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lHA == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.lHA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lHB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.lHB);
      }
      i = paramInt;
      if (this.qwt != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qwt);
      }
      AppMethodBeat.o(91691);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91691);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyf localdyf = (dyf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91691);
          return -1;
        case 1: 
          localdyf.lHA = locala.UbS.readString();
          AppMethodBeat.o(91691);
          return 0;
        case 2: 
          localdyf.lHB = locala.UbS.readString();
          AppMethodBeat.o(91691);
          return 0;
        }
        localdyf.qwt = locala.UbS.readString();
        AppMethodBeat.o(91691);
        return 0;
      }
      AppMethodBeat.o(91691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyf
 * JD-Core Version:    0.7.0.1
 */