package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dvi
  extends com.tencent.mm.bw.a
{
  public b GcM;
  public b GcN;
  public b GcO;
  public b GcP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91729);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GcM != null) {
        paramVarArgs.c(1, this.GcM);
      }
      if (this.GcN != null) {
        paramVarArgs.c(2, this.GcN);
      }
      if (this.GcO != null) {
        paramVarArgs.c(3, this.GcO);
      }
      if (this.GcP != null) {
        paramVarArgs.c(4, this.GcP);
      }
      AppMethodBeat.o(91729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GcM == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.b(1, this.GcM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GcN != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GcN);
      }
      i = paramInt;
      if (this.GcO != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GcO);
      }
      paramInt = i;
      if (this.GcP != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GcP);
      }
      AppMethodBeat.o(91729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91729);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvi localdvi = (dvi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91729);
          return -1;
        case 1: 
          localdvi.GcM = locala.LVo.gfk();
          AppMethodBeat.o(91729);
          return 0;
        case 2: 
          localdvi.GcN = locala.LVo.gfk();
          AppMethodBeat.o(91729);
          return 0;
        case 3: 
          localdvi.GcO = locala.LVo.gfk();
          AppMethodBeat.o(91729);
          return 0;
        }
        localdvi.GcP = locala.LVo.gfk();
        AppMethodBeat.o(91729);
        return 0;
      }
      AppMethodBeat.o(91729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvi
 * JD-Core Version:    0.7.0.1
 */