package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtb
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> HFQ;
  public int OpCode;
  
  public dtb()
  {
    AppMethodBeat.i(104845);
    this.HFQ = new LinkedList();
    AppMethodBeat.o(104845);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.OpCode);
      paramVarArgs.e(2, 1, this.HFQ);
      AppMethodBeat.o(104846);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.OpCode);
      int i = f.a.a.a.c(2, 1, this.HFQ);
      AppMethodBeat.o(104846);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HFQ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(104846);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dtb localdtb = (dtb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104846);
        return -1;
      case 1: 
        localdtb.OpCode = locala.NPN.zc();
        AppMethodBeat.o(104846);
        return 0;
      }
      localdtb.HFQ.add(locala.NPN.readString());
      AppMethodBeat.o(104846);
      return 0;
    }
    AppMethodBeat.o(104846);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtb
 * JD-Core Version:    0.7.0.1
 */