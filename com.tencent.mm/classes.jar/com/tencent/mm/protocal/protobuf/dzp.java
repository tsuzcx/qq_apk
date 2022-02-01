package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzp
  extends com.tencent.mm.bx.a
{
  public String HMw;
  public LinkedList<String> HMx;
  
  public dzp()
  {
    AppMethodBeat.i(147798);
    this.HMx = new LinkedList();
    AppMethodBeat.o(147798);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147799);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMw != null) {
        paramVarArgs.d(1, this.HMw);
      }
      paramVarArgs.e(2, 1, this.HMx);
      AppMethodBeat.o(147799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMw == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.HMw) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.HMx);
      AppMethodBeat.o(147799);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HMx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147799);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzp localdzp = (dzp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147799);
          return -1;
        case 1: 
          localdzp.HMw = locala.NPN.readString();
          AppMethodBeat.o(147799);
          return 0;
        }
        localdzp.HMx.add(locala.NPN.readString());
        AppMethodBeat.o(147799);
        return 0;
      }
      AppMethodBeat.o(147799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzp
 * JD-Core Version:    0.7.0.1
 */