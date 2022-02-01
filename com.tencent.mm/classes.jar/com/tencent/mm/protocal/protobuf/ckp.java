package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckp
  extends com.tencent.mm.cd.a
{
  public int oey;
  public int oez;
  public double paU;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.f(1, this.uuid);
      }
      paramVarArgs.aY(2, this.oey);
      paramVarArgs.aY(3, this.oez);
      paramVarArgs.e(4, this.paU);
      AppMethodBeat.o(82426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label353;
      }
    }
    label353:
    for (paramInt = g.a.a.b.b.a.g(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.oey);
      int j = g.a.a.b.b.a.bM(3, this.oez);
      int k = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(82426);
      return paramInt + i + j + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82426);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ckp localckp = (ckp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82426);
          return -1;
        case 1: 
          localckp.uuid = locala.abFh.readString();
          AppMethodBeat.o(82426);
          return 0;
        case 2: 
          localckp.oey = locala.abFh.AK();
          AppMethodBeat.o(82426);
          return 0;
        case 3: 
          localckp.oez = locala.abFh.AK();
          AppMethodBeat.o(82426);
          return 0;
        }
        localckp.paU = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(82426);
        return 0;
      }
      AppMethodBeat.o(82426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckp
 * JD-Core Version:    0.7.0.1
 */