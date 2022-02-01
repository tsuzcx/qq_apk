package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbh
  extends com.tencent.mm.cd.a
{
  public String RTv;
  public int RTw;
  public int RTx;
  public int RTy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207779);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RTv != null) {
        paramVarArgs.f(1, this.RTv);
      }
      paramVarArgs.aY(2, this.RTw);
      paramVarArgs.aY(3, this.RTx);
      paramVarArgs.aY(4, this.RTy);
      AppMethodBeat.o(207779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RTv == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.g(1, this.RTv) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.RTw);
      int j = g.a.a.b.b.a.bM(3, this.RTx);
      int k = g.a.a.b.b.a.bM(4, this.RTy);
      AppMethodBeat.o(207779);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207779);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbh localfbh = (fbh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207779);
          return -1;
        case 1: 
          localfbh.RTv = locala.abFh.readString();
          AppMethodBeat.o(207779);
          return 0;
        case 2: 
          localfbh.RTw = locala.abFh.AK();
          AppMethodBeat.o(207779);
          return 0;
        case 3: 
          localfbh.RTx = locala.abFh.AK();
          AppMethodBeat.o(207779);
          return 0;
        }
        localfbh.RTy = locala.abFh.AK();
        AppMethodBeat.o(207779);
        return 0;
      }
      AppMethodBeat.o(207779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbh
 * JD-Core Version:    0.7.0.1
 */