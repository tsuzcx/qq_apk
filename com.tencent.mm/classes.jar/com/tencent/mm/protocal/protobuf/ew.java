package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ew
  extends com.tencent.mm.bw.a
{
  public int KIm;
  public String KIn;
  public String jfi;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi != null) {
        paramVarArgs.e(1, this.jfi);
      }
      paramVarArgs.aM(2, this.oUv);
      paramVarArgs.aM(3, this.KIm);
      if (this.KIn != null) {
        paramVarArgs.e(4, this.KIn);
      }
      AppMethodBeat.o(123539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfi == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.f(1, this.jfi) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.KIm);
      paramInt = i;
      if (this.KIn != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KIn);
      }
      AppMethodBeat.o(123539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123539);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ew localew = (ew)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123539);
          return -1;
        case 1: 
          localew.jfi = locala.UbS.readString();
          AppMethodBeat.o(123539);
          return 0;
        case 2: 
          localew.oUv = locala.UbS.zi();
          AppMethodBeat.o(123539);
          return 0;
        case 3: 
          localew.KIm = locala.UbS.zi();
          AppMethodBeat.o(123539);
          return 0;
        }
        localew.KIn = locala.UbS.readString();
        AppMethodBeat.o(123539);
        return 0;
      }
      AppMethodBeat.o(123539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ew
 * JD-Core Version:    0.7.0.1
 */