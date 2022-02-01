package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adp
  extends com.tencent.mm.bw.a
{
  public String dwx;
  public LinkedList<String> uIU;
  
  public adp()
  {
    AppMethodBeat.i(221739);
    this.uIU = new LinkedList();
    AppMethodBeat.o(221739);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221740);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwx != null) {
        paramVarArgs.d(1, this.dwx);
      }
      paramVarArgs.e(2, 1, this.uIU);
      AppMethodBeat.o(221740);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwx == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.dwx) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.uIU);
      AppMethodBeat.o(221740);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uIU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(221740);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        adp localadp = (adp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(221740);
          return -1;
        case 1: 
          localadp.dwx = locala.OmT.readString();
          AppMethodBeat.o(221740);
          return 0;
        }
        localadp.uIU.add(locala.OmT.readString());
        AppMethodBeat.o(221740);
        return 0;
      }
      AppMethodBeat.o(221740);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adp
 * JD-Core Version:    0.7.0.1
 */