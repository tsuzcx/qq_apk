package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfj
  extends com.tencent.mm.cd.a
{
  public int SQb;
  public int SQc;
  public String mbB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206186);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mbB != null) {
        paramVarArgs.f(1, this.mbB);
      }
      paramVarArgs.aY(2, this.SQb);
      paramVarArgs.aY(3, this.SQc);
      AppMethodBeat.o(206186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mbB == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.mbB) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.SQb);
      int j = g.a.a.b.b.a.bM(3, this.SQc);
      AppMethodBeat.o(206186);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206186);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bfj localbfj = (bfj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(206186);
          return -1;
        case 1: 
          localbfj.mbB = locala.abFh.readString();
          AppMethodBeat.o(206186);
          return 0;
        case 2: 
          localbfj.SQb = locala.abFh.AK();
          AppMethodBeat.o(206186);
          return 0;
        }
        localbfj.SQc = locala.abFh.AK();
        AppMethodBeat.o(206186);
        return 0;
      }
      AppMethodBeat.o(206186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfj
 * JD-Core Version:    0.7.0.1
 */