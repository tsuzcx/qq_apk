package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nv
  extends com.tencent.mm.bx.a
{
  public String FGE;
  public LinkedList<String> FIj;
  
  public nv()
  {
    AppMethodBeat.i(207231);
    this.FIj = new LinkedList();
    AppMethodBeat.o(207231);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207232);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FGE != null) {
        paramVarArgs.d(1, this.FGE);
      }
      paramVarArgs.e(2, 1, this.FIj);
      AppMethodBeat.o(207232);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FGE == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.FGE) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.FIj);
      AppMethodBeat.o(207232);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FIj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(207232);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        nv localnv = (nv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207232);
          return -1;
        case 1: 
          localnv.FGE = locala.NPN.readString();
          AppMethodBeat.o(207232);
          return 0;
        }
        localnv.FIj.add(locala.NPN.readString());
        AppMethodBeat.o(207232);
        return 0;
      }
      AppMethodBeat.o(207232);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nv
 * JD-Core Version:    0.7.0.1
 */