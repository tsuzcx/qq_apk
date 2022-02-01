package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class um
  extends com.tencent.mm.bw.a
{
  public String eaP;
  public String pRX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113964);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.pRX != null) {
        paramVarArgs.e(1, this.pRX);
      }
      if (this.eaP != null) {
        paramVarArgs.e(2, this.eaP);
      }
      AppMethodBeat.o(113964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pRX == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.pRX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.eaP != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.eaP);
      }
      AppMethodBeat.o(113964);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113964);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        um localum = (um)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113964);
          return -1;
        case 1: 
          localum.pRX = locala.UbS.readString();
          AppMethodBeat.o(113964);
          return 0;
        }
        localum.eaP = locala.UbS.readString();
        AppMethodBeat.o(113964);
        return 0;
      }
      AppMethodBeat.o(113964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.um
 * JD-Core Version:    0.7.0.1
 */