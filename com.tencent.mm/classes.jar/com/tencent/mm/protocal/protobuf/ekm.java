package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ekm
  extends com.tencent.mm.bw.a
{
  public int NjD;
  public b NjE;
  public b NjF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197138);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NjD);
      if (this.NjE != null) {
        paramVarArgs.c(2, this.NjE);
      }
      if (this.NjF != null) {
        paramVarArgs.c(3, this.NjF);
      }
      AppMethodBeat.o(197138);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.NjD) + 0;
      paramInt = i;
      if (this.NjE != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.NjE);
      }
      i = paramInt;
      if (this.NjF != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.NjF);
      }
      AppMethodBeat.o(197138);
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
      AppMethodBeat.o(197138);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ekm localekm = (ekm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(197138);
        return -1;
      case 1: 
        localekm.NjD = locala.UbS.zi();
        AppMethodBeat.o(197138);
        return 0;
      case 2: 
        localekm.NjE = locala.UbS.hPo();
        AppMethodBeat.o(197138);
        return 0;
      }
      localekm.NjF = locala.UbS.hPo();
      AppMethodBeat.o(197138);
      return 0;
    }
    AppMethodBeat.o(197138);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekm
 * JD-Core Version:    0.7.0.1
 */