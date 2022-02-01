package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dws
  extends com.tencent.mm.bw.a
{
  public String EVM;
  public int tlI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EVM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32530);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.tlI);
      if (this.EVM != null) {
        paramVarArgs.d(2, this.EVM);
      }
      AppMethodBeat.o(32530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.tlI) + 0;
      paramInt = i;
      if (this.EVM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EVM);
      }
      AppMethodBeat.o(32530);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.EVM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32530);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32530);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dws localdws = (dws)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32530);
        return -1;
      case 1: 
        localdws.tlI = locala.LVo.xF();
        AppMethodBeat.o(32530);
        return 0;
      }
      localdws.EVM = locala.LVo.readString();
      AppMethodBeat.o(32530);
      return 0;
    }
    AppMethodBeat.o(32530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dws
 * JD-Core Version:    0.7.0.1
 */