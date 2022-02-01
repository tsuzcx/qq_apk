package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aat
  extends com.tencent.mm.bx.a
{
  public String FxE;
  public int Gan;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gan);
      if (this.FxE != null) {
        paramVarArgs.d(2, this.FxE);
      }
      paramVarArgs.aS(3, this.status);
      AppMethodBeat.o(90961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gan) + 0;
      paramInt = i;
      if (this.FxE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FxE);
      }
      i = f.a.a.b.b.a.bz(3, this.status);
      AppMethodBeat.o(90961);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(90961);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aat localaat = (aat)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90961);
        return -1;
      case 1: 
        localaat.Gan = locala.NPN.zc();
        AppMethodBeat.o(90961);
        return 0;
      case 2: 
        localaat.FxE = locala.NPN.readString();
        AppMethodBeat.o(90961);
        return 0;
      }
      localaat.status = locala.NPN.zc();
      AppMethodBeat.o(90961);
      return 0;
    }
    AppMethodBeat.o(90961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aat
 * JD-Core Version:    0.7.0.1
 */