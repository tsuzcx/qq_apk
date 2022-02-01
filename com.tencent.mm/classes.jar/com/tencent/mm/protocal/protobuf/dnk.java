package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnk
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> FVc;
  public int OpCode;
  
  public dnk()
  {
    AppMethodBeat.i(104845);
    this.FVc = new LinkedList();
    AppMethodBeat.o(104845);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.OpCode);
      paramVarArgs.e(2, 1, this.FVc);
      AppMethodBeat.o(104846);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.OpCode);
      int i = f.a.a.a.c(2, 1, this.FVc);
      AppMethodBeat.o(104846);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FVc.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(104846);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dnk localdnk = (dnk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104846);
        return -1;
      case 1: 
        localdnk.OpCode = locala.LVo.xF();
        AppMethodBeat.o(104846);
        return 0;
      }
      localdnk.FVc.add(locala.LVo.readString());
      AppMethodBeat.o(104846);
      return 0;
    }
    AppMethodBeat.o(104846);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnk
 * JD-Core Version:    0.7.0.1
 */