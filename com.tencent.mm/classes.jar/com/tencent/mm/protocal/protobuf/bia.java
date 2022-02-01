package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bia
  extends com.tencent.mm.bw.a
{
  public int KIm;
  public int LSq;
  public String jfi;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123572);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi != null) {
        paramVarArgs.e(1, this.jfi);
      }
      paramVarArgs.aM(2, this.oUv);
      paramVarArgs.aM(3, this.KIm);
      paramVarArgs.aM(4, this.LSq);
      AppMethodBeat.o(123572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfi == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.f(1, this.jfi) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oUv);
      int j = g.a.a.b.b.a.bu(3, this.KIm);
      int k = g.a.a.b.b.a.bu(4, this.LSq);
      AppMethodBeat.o(123572);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123572);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bia localbia = (bia)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123572);
          return -1;
        case 1: 
          localbia.jfi = locala.UbS.readString();
          AppMethodBeat.o(123572);
          return 0;
        case 2: 
          localbia.oUv = locala.UbS.zi();
          AppMethodBeat.o(123572);
          return 0;
        case 3: 
          localbia.KIm = locala.UbS.zi();
          AppMethodBeat.o(123572);
          return 0;
        }
        localbia.LSq = locala.UbS.zi();
        AppMethodBeat.o(123572);
        return 0;
      }
      AppMethodBeat.o(123572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bia
 * JD-Core Version:    0.7.0.1
 */