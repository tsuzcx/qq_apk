package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fcn
  extends com.tencent.mm.bw.a
{
  public int KWR;
  public int KXC;
  public long Nys;
  public boolean Nyt;
  public String Nyu;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123692);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aM(2, this.KWR);
      paramVarArgs.aM(3, this.KXC);
      paramVarArgs.bb(4, this.Nys);
      paramVarArgs.cc(5, this.Nyt);
      if (this.Nyu != null) {
        paramVarArgs.e(6, this.Nyu);
      }
      AppMethodBeat.o(123692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KWR) + g.a.a.b.b.a.bu(3, this.KXC) + g.a.a.b.b.a.r(4, this.Nys) + (g.a.a.b.b.a.fS(5) + 1);
      paramInt = i;
      if (this.Nyu != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Nyu);
      }
      AppMethodBeat.o(123692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123692);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fcn localfcn = (fcn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123692);
          return -1;
        case 1: 
          localfcn.username = locala.UbS.readString();
          AppMethodBeat.o(123692);
          return 0;
        case 2: 
          localfcn.KWR = locala.UbS.zi();
          AppMethodBeat.o(123692);
          return 0;
        case 3: 
          localfcn.KXC = locala.UbS.zi();
          AppMethodBeat.o(123692);
          return 0;
        case 4: 
          localfcn.Nys = locala.UbS.zl();
          AppMethodBeat.o(123692);
          return 0;
        case 5: 
          localfcn.Nyt = locala.UbS.yZ();
          AppMethodBeat.o(123692);
          return 0;
        }
        localfcn.Nyu = locala.UbS.readString();
        AppMethodBeat.o(123692);
        return 0;
      }
      AppMethodBeat.o(123692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcn
 * JD-Core Version:    0.7.0.1
 */