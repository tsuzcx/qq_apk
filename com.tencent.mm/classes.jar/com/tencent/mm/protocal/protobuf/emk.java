package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class emk
  extends com.tencent.mm.cd.a
{
  public String BHO;
  public long GhA;
  public b UoX;
  public String id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204304);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      if (this.BHO != null) {
        paramVarArgs.f(2, this.BHO);
      }
      paramVarArgs.bm(3, this.GhA);
      paramVarArgs.aY(4, this.type);
      if (this.UoX != null) {
        paramVarArgs.c(5, this.UoX);
      }
      AppMethodBeat.o(204304);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.BHO != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.BHO);
      }
      i = i + g.a.a.b.b.a.p(3, this.GhA) + g.a.a.b.b.a.bM(4, this.type);
      paramInt = i;
      if (this.UoX != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.UoX);
      }
      AppMethodBeat.o(204304);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204304);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        emk localemk = (emk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(204304);
          return -1;
        case 1: 
          localemk.id = locala.abFh.readString();
          AppMethodBeat.o(204304);
          return 0;
        case 2: 
          localemk.BHO = locala.abFh.readString();
          AppMethodBeat.o(204304);
          return 0;
        case 3: 
          localemk.GhA = locala.abFh.AN();
          AppMethodBeat.o(204304);
          return 0;
        case 4: 
          localemk.type = locala.abFh.AK();
          AppMethodBeat.o(204304);
          return 0;
        }
        localemk.UoX = locala.abFh.iUw();
        AppMethodBeat.o(204304);
        return 0;
      }
      AppMethodBeat.o(204304);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emk
 * JD-Core Version:    0.7.0.1
 */