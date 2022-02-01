package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sc
  extends com.tencent.mm.bx.a
{
  public int FOQ;
  public int FOR;
  public String FOS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FOQ);
      paramVarArgs.aS(2, this.FOR);
      if (this.FOS != null) {
        paramVarArgs.d(3, this.FOS);
      }
      AppMethodBeat.o(91386);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FOQ) + 0 + f.a.a.b.b.a.bz(2, this.FOR);
      paramInt = i;
      if (this.FOS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FOS);
      }
      AppMethodBeat.o(91386);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91386);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      sc localsc = (sc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91386);
        return -1;
      case 1: 
        localsc.FOQ = locala.NPN.zc();
        AppMethodBeat.o(91386);
        return 0;
      case 2: 
        localsc.FOR = locala.NPN.zc();
        AppMethodBeat.o(91386);
        return 0;
      }
      localsc.FOS = locala.NPN.readString();
      AppMethodBeat.o(91386);
      return 0;
    }
    AppMethodBeat.o(91386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sc
 * JD-Core Version:    0.7.0.1
 */