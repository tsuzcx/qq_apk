package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class emf
  extends com.tencent.mm.cd.a
{
  public String UoK;
  public int UoL;
  public boolean UoM;
  public boolean UoN;
  public String appName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116816);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UoK != null) {
        paramVarArgs.f(1, this.UoK);
      }
      if (this.appName != null) {
        paramVarArgs.f(2, this.appName);
      }
      paramVarArgs.aY(3, this.UoL);
      paramVarArgs.co(4, this.UoM);
      paramVarArgs.co(5, this.UoN);
      AppMethodBeat.o(116816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UoK == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = g.a.a.b.b.a.g(1, this.UoK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appName != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.appName);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.UoL);
      int j = g.a.a.b.b.a.gL(4);
      int k = g.a.a.b.b.a.gL(5);
      AppMethodBeat.o(116816);
      return i + paramInt + (j + 1) + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116816);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        emf localemf = (emf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116816);
          return -1;
        case 1: 
          localemf.UoK = locala.abFh.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 2: 
          localemf.appName = locala.abFh.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 3: 
          localemf.UoL = locala.abFh.AK();
          AppMethodBeat.o(116816);
          return 0;
        case 4: 
          localemf.UoM = locala.abFh.AB();
          AppMethodBeat.o(116816);
          return 0;
        }
        localemf.UoN = locala.abFh.AB();
        AppMethodBeat.o(116816);
        return 0;
      }
      AppMethodBeat.o(116816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emf
 * JD-Core Version:    0.7.0.1
 */