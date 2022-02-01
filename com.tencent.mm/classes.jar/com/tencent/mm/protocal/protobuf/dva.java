package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dva
  extends com.tencent.mm.bx.a
{
  public int FxO;
  public String Gdg;
  public int HHB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152724);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FxO);
      if (this.Gdg != null) {
        paramVarArgs.d(2, this.Gdg);
      }
      paramVarArgs.aS(3, this.HHB);
      AppMethodBeat.o(152724);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FxO) + 0;
      paramInt = i;
      if (this.Gdg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gdg);
      }
      i = f.a.a.b.b.a.bz(3, this.HHB);
      AppMethodBeat.o(152724);
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
      AppMethodBeat.o(152724);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dva localdva = (dva)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152724);
        return -1;
      case 1: 
        localdva.FxO = locala.NPN.zc();
        AppMethodBeat.o(152724);
        return 0;
      case 2: 
        localdva.Gdg = locala.NPN.readString();
        AppMethodBeat.o(152724);
        return 0;
      }
      localdva.HHB = locala.NPN.zc();
      AppMethodBeat.o(152724);
      return 0;
    }
    AppMethodBeat.o(152724);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dva
 * JD-Core Version:    0.7.0.1
 */