package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dvo
  extends com.tencent.mm.bw.a
{
  public b GcX;
  public b GcY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91736);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GcX != null) {
        paramVarArgs.c(1, this.GcX);
      }
      if (this.GcY != null) {
        paramVarArgs.c(2, this.GcY);
      }
      AppMethodBeat.o(91736);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GcX == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.GcX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GcY != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.GcY);
      }
      AppMethodBeat.o(91736);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91736);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvo localdvo = (dvo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91736);
          return -1;
        case 1: 
          localdvo.GcX = locala.LVo.gfk();
          AppMethodBeat.o(91736);
          return 0;
        }
        localdvo.GcY = locala.LVo.gfk();
        AppMethodBeat.o(91736);
        return 0;
      }
      AppMethodBeat.o(91736);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvo
 * JD-Core Version:    0.7.0.1
 */