package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class dwe
  extends com.tencent.mm.cd.a
{
  public b SrO;
  public int TVM;
  public String Ucf;
  public int rWu;
  public int vhF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138185);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ucf != null) {
        paramVarArgs.f(1, this.Ucf);
      }
      paramVarArgs.aY(2, this.rWu);
      paramVarArgs.aY(3, this.vhF);
      paramVarArgs.aY(4, this.TVM);
      if (this.SrO != null) {
        paramVarArgs.c(5, this.SrO);
      }
      AppMethodBeat.o(138185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ucf == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.b.b.a.g(1, this.Ucf) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu) + g.a.a.b.b.a.bM(3, this.vhF) + g.a.a.b.b.a.bM(4, this.TVM);
      paramInt = i;
      if (this.SrO != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.SrO);
      }
      AppMethodBeat.o(138185);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(138185);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dwe localdwe = (dwe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138185);
          return -1;
        case 1: 
          localdwe.Ucf = locala.abFh.readString();
          AppMethodBeat.o(138185);
          return 0;
        case 2: 
          localdwe.rWu = locala.abFh.AK();
          AppMethodBeat.o(138185);
          return 0;
        case 3: 
          localdwe.vhF = locala.abFh.AK();
          AppMethodBeat.o(138185);
          return 0;
        case 4: 
          localdwe.TVM = locala.abFh.AK();
          AppMethodBeat.o(138185);
          return 0;
        }
        localdwe.SrO = locala.abFh.iUw();
        AppMethodBeat.o(138185);
        return 0;
      }
      AppMethodBeat.o(138185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwe
 * JD-Core Version:    0.7.0.1
 */