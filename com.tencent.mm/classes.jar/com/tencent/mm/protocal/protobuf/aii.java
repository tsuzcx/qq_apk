package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aii
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> EDf;
  public int EDg;
  
  public aii()
  {
    AppMethodBeat.i(124487);
    this.EDf = new LinkedList();
    this.EDg = 1;
    AppMethodBeat.o(124487);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124488);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.EDf);
      paramVarArgs.aR(2, this.EDg);
      AppMethodBeat.o(124488);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.EDf);
      int i = f.a.a.b.b.a.bx(2, this.EDg);
      AppMethodBeat.o(124488);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EDf.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124488);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aii localaii = (aii)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124488);
        return -1;
      case 1: 
        localaii.EDf.add(locala.LVo.readString());
        AppMethodBeat.o(124488);
        return 0;
      }
      localaii.EDg = locala.LVo.xF();
      AppMethodBeat.o(124488);
      return 0;
    }
    AppMethodBeat.o(124488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aii
 * JD-Core Version:    0.7.0.1
 */