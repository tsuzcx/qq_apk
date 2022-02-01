package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class aiz
  extends com.tencent.mm.bw.a
{
  public b EDI;
  public int cmdId;
  public String jXd;
  public int retCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.cmdId);
      paramVarArgs.aR(2, this.retCode);
      if (this.jXd != null) {
        paramVarArgs.d(3, this.jXd);
      }
      if (this.EDI != null) {
        paramVarArgs.c(4, this.EDI);
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.cmdId) + 0 + f.a.a.b.b.a.bx(2, this.retCode);
      paramInt = i;
      if (this.jXd != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.jXd);
      }
      i = paramInt;
      if (this.EDI != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.EDI);
      }
      AppMethodBeat.o(168939);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aiz localaiz = (aiz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168939);
        return -1;
      case 1: 
        localaiz.cmdId = locala.LVo.xF();
        AppMethodBeat.o(168939);
        return 0;
      case 2: 
        localaiz.retCode = locala.LVo.xF();
        AppMethodBeat.o(168939);
        return 0;
      case 3: 
        localaiz.jXd = locala.LVo.readString();
        AppMethodBeat.o(168939);
        return 0;
      }
      localaiz.EDI = locala.LVo.gfk();
      AppMethodBeat.o(168939);
      return 0;
    }
    AppMethodBeat.o(168939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiz
 * JD-Core Version:    0.7.0.1
 */