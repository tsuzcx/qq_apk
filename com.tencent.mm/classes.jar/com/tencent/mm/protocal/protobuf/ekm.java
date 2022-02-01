package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ekm
  extends com.tencent.mm.cd.a
{
  public int KGN;
  public int KGO;
  public String RJT;
  public String RJU;
  public String RJV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125804);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RJT != null) {
        paramVarArgs.f(1, this.RJT);
      }
      if (this.RJU != null) {
        paramVarArgs.f(2, this.RJU);
      }
      if (this.RJV != null) {
        paramVarArgs.f(3, this.RJV);
      }
      paramVarArgs.aY(4, this.KGN);
      paramVarArgs.aY(5, this.KGO);
      AppMethodBeat.o(125804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RJT == null) {
        break label426;
      }
    }
    label426:
    for (int i = g.a.a.b.b.a.g(1, this.RJT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RJU != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RJU);
      }
      i = paramInt;
      if (this.RJV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RJV);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.KGN);
      int j = g.a.a.b.b.a.bM(5, this.KGO);
      AppMethodBeat.o(125804);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125804);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ekm localekm = (ekm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125804);
          return -1;
        case 1: 
          localekm.RJT = locala.abFh.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 2: 
          localekm.RJU = locala.abFh.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 3: 
          localekm.RJV = locala.abFh.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 4: 
          localekm.KGN = locala.abFh.AK();
          AppMethodBeat.o(125804);
          return 0;
        }
        localekm.KGO = locala.abFh.AK();
        AppMethodBeat.o(125804);
        return 0;
      }
      AppMethodBeat.o(125804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekm
 * JD-Core Version:    0.7.0.1
 */