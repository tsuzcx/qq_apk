package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class air
  extends com.tencent.mm.cd.a
{
  public String data;
  public String wdY;
  public long wdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258170);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wdY != null) {
        paramVarArgs.f(1, this.wdY);
      }
      paramVarArgs.bm(2, this.wdZ);
      if (this.data != null) {
        paramVarArgs.f(3, this.data);
      }
      AppMethodBeat.o(258170);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wdY == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.wdY) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.wdZ);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.data);
      }
      AppMethodBeat.o(258170);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(258170);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        air localair = (air)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258170);
          return -1;
        case 1: 
          localair.wdY = locala.abFh.readString();
          AppMethodBeat.o(258170);
          return 0;
        case 2: 
          localair.wdZ = locala.abFh.AN();
          AppMethodBeat.o(258170);
          return 0;
        }
        localair.data = locala.abFh.readString();
        AppMethodBeat.o(258170);
        return 0;
      }
      AppMethodBeat.o(258170);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.air
 * JD-Core Version:    0.7.0.1
 */