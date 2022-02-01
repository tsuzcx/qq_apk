package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cse
  extends com.tencent.mm.bw.a
{
  public b AqP;
  public boolean AqQ;
  public String MwX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256718);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MwX != null) {
        paramVarArgs.e(1, this.MwX);
      }
      if (this.AqP != null) {
        paramVarArgs.c(2, this.AqP);
      }
      paramVarArgs.cc(3, this.AqQ);
      AppMethodBeat.o(256718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MwX == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.MwX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.AqP != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.AqP);
      }
      paramInt = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(256718);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256718);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cse localcse = (cse)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(256718);
          return -1;
        case 1: 
          localcse.MwX = locala.UbS.readString();
          AppMethodBeat.o(256718);
          return 0;
        case 2: 
          localcse.AqP = locala.UbS.hPo();
          AppMethodBeat.o(256718);
          return 0;
        }
        localcse.AqQ = locala.UbS.yZ();
        AppMethodBeat.o(256718);
        return 0;
      }
      AppMethodBeat.o(256718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cse
 * JD-Core Version:    0.7.0.1
 */