package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class op
  extends com.tencent.mm.bw.a
{
  public b Eew;
  public b Eex;
  public int port;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133158);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      paramVarArgs.aR(2, this.port);
      if (this.Eew != null) {
        paramVarArgs.c(3, this.Eew);
      }
      if (this.Eex != null) {
        paramVarArgs.c(4, this.Eex);
      }
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0 + f.a.a.b.b.a.bx(2, this.port);
      paramInt = i;
      if (this.Eew != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Eew);
      }
      i = paramInt;
      if (this.Eex != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Eex);
      }
      AppMethodBeat.o(133158);
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
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      op localop = (op)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133158);
        return -1;
      case 1: 
        localop.type = locala.LVo.xF();
        AppMethodBeat.o(133158);
        return 0;
      case 2: 
        localop.port = locala.LVo.xF();
        AppMethodBeat.o(133158);
        return 0;
      case 3: 
        localop.Eew = locala.LVo.gfk();
        AppMethodBeat.o(133158);
        return 0;
      }
      localop.Eex = locala.LVo.gfk();
      AppMethodBeat.o(133158);
      return 0;
    }
    AppMethodBeat.o(133158);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.op
 * JD-Core Version:    0.7.0.1
 */