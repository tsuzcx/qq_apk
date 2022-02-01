package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajy
  extends com.tencent.mm.cd.a
{
  public String CNj;
  public String Suq;
  public String Ter;
  public int Tes;
  public int lpw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104772);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Suq != null) {
        paramVarArgs.f(1, this.Suq);
      }
      paramVarArgs.aY(2, this.lpw);
      paramVarArgs.aY(3, this.Tes);
      if (this.CNj != null) {
        paramVarArgs.f(4, this.CNj);
      }
      if (this.Ter != null) {
        paramVarArgs.f(5, this.Ter);
      }
      AppMethodBeat.o(104772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Suq == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.Suq) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.lpw) + g.a.a.b.b.a.bM(3, this.Tes);
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CNj);
      }
      i = paramInt;
      if (this.Ter != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Ter);
      }
      AppMethodBeat.o(104772);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104772);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ajy localajy = (ajy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104772);
          return -1;
        case 1: 
          localajy.Suq = locala.abFh.readString();
          AppMethodBeat.o(104772);
          return 0;
        case 2: 
          localajy.lpw = locala.abFh.AK();
          AppMethodBeat.o(104772);
          return 0;
        case 3: 
          localajy.Tes = locala.abFh.AK();
          AppMethodBeat.o(104772);
          return 0;
        case 4: 
          localajy.CNj = locala.abFh.readString();
          AppMethodBeat.o(104772);
          return 0;
        }
        localajy.Ter = locala.abFh.readString();
        AppMethodBeat.o(104772);
        return 0;
      }
      AppMethodBeat.o(104772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajy
 * JD-Core Version:    0.7.0.1
 */