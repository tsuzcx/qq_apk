package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dvn
  extends com.tencent.mm.bw.a
{
  public b GcM;
  public b GcW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91735);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GcM != null) {
        paramVarArgs.c(1, this.GcM);
      }
      if (this.GcW != null) {
        paramVarArgs.c(2, this.GcW);
      }
      AppMethodBeat.o(91735);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GcM == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.GcM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GcW != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.GcW);
      }
      AppMethodBeat.o(91735);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91735);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvn localdvn = (dvn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91735);
          return -1;
        case 1: 
          localdvn.GcM = locala.LVo.gfk();
          AppMethodBeat.o(91735);
          return 0;
        }
        localdvn.GcW = locala.LVo.gfk();
        AppMethodBeat.o(91735);
        return 0;
      }
      AppMethodBeat.o(91735);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvn
 * JD-Core Version:    0.7.0.1
 */