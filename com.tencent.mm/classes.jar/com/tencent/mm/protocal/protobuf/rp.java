package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class rp
  extends com.tencent.mm.bw.a
{
  public int Ggg;
  public b oGT;
  public int oIw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220229);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ggg);
      paramVarArgs.aS(2, this.oIw);
      if (this.oGT != null) {
        paramVarArgs.c(3, this.oGT);
      }
      AppMethodBeat.o(220229);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Ggg) + 0 + f.a.a.b.b.a.bz(2, this.oIw);
      paramInt = i;
      if (this.oGT != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.oGT);
      }
      AppMethodBeat.o(220229);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(220229);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      rp localrp = (rp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(220229);
        return -1;
      case 1: 
        localrp.Ggg = locala.OmT.zc();
        AppMethodBeat.o(220229);
        return 0;
      case 2: 
        localrp.oIw = locala.OmT.zc();
        AppMethodBeat.o(220229);
        return 0;
      }
      localrp.oGT = locala.OmT.gCk();
      AppMethodBeat.o(220229);
      return 0;
    }
    AppMethodBeat.o(220229);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rp
 * JD-Core Version:    0.7.0.1
 */