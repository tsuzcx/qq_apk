package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class qx
  extends com.tencent.mm.bw.a
{
  public b KXL;
  public b KXM;
  public int port;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133158);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      paramVarArgs.aM(2, this.port);
      if (this.KXL != null) {
        paramVarArgs.c(3, this.KXL);
      }
      if (this.KXM != null) {
        paramVarArgs.c(4, this.KXM);
      }
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0 + g.a.a.b.b.a.bu(2, this.port);
      paramInt = i;
      if (this.KXL != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.KXL);
      }
      i = paramInt;
      if (this.KXM != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.KXM);
      }
      AppMethodBeat.o(133158);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      qx localqx = (qx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133158);
        return -1;
      case 1: 
        localqx.type = locala.UbS.zi();
        AppMethodBeat.o(133158);
        return 0;
      case 2: 
        localqx.port = locala.UbS.zi();
        AppMethodBeat.o(133158);
        return 0;
      case 3: 
        localqx.KXL = locala.UbS.hPo();
        AppMethodBeat.o(133158);
        return 0;
      }
      localqx.KXM = locala.UbS.hPo();
      AppMethodBeat.o(133158);
      return 0;
    }
    AppMethodBeat.o(133158);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qx
 * JD-Core Version:    0.7.0.1
 */