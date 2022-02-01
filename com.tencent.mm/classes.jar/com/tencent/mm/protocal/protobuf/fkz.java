package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class fkz
  extends com.tencent.mm.bx.a
{
  public int Tps;
  public b ZQV;
  public int abLz;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259217);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Tps);
      paramVarArgs.bS(2, this.ret);
      if (this.ZQV != null) {
        paramVarArgs.d(3, this.ZQV);
      }
      paramVarArgs.bS(4, this.abLz);
      AppMethodBeat.o(259217);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Tps) + 0 + i.a.a.b.b.a.cJ(2, this.ret);
      paramInt = i;
      if (this.ZQV != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZQV);
      }
      i = i.a.a.b.b.a.cJ(4, this.abLz);
      AppMethodBeat.o(259217);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259217);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fkz localfkz = (fkz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259217);
        return -1;
      case 1: 
        localfkz.Tps = locala.ajGk.aar();
        AppMethodBeat.o(259217);
        return 0;
      case 2: 
        localfkz.ret = locala.ajGk.aar();
        AppMethodBeat.o(259217);
        return 0;
      case 3: 
        localfkz.ZQV = locala.ajGk.kFX();
        AppMethodBeat.o(259217);
        return 0;
      }
      localfkz.abLz = locala.ajGk.aar();
      AppMethodBeat.o(259217);
      return 0;
    }
    AppMethodBeat.o(259217);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkz
 * JD-Core Version:    0.7.0.1
 */