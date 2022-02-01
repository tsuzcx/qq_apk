package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aig
  extends com.tencent.mm.bw.a
{
  public String data;
  public String syg;
  public long syh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220687);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.syg != null) {
        paramVarArgs.e(1, this.syg);
      }
      paramVarArgs.bb(2, this.syh);
      if (this.data != null) {
        paramVarArgs.e(3, this.data);
      }
      AppMethodBeat.o(220687);
      return 0;
    }
    if (paramInt == 1) {
      if (this.syg == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.syg) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.syh);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.data);
      }
      AppMethodBeat.o(220687);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(220687);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aig localaig = (aig)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(220687);
          return -1;
        case 1: 
          localaig.syg = locala.UbS.readString();
          AppMethodBeat.o(220687);
          return 0;
        case 2: 
          localaig.syh = locala.UbS.zl();
          AppMethodBeat.o(220687);
          return 0;
        }
        localaig.data = locala.UbS.readString();
        AppMethodBeat.o(220687);
        return 0;
      }
      AppMethodBeat.o(220687);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aig
 * JD-Core Version:    0.7.0.1
 */