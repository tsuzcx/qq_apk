package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecl
  extends com.tencent.mm.bw.a
{
  public int GhT;
  public boolean GhU;
  public boolean GhV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123713);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.GhT);
      paramVarArgs.bl(2, this.GhU);
      paramVarArgs.bl(3, this.GhV);
      AppMethodBeat.o(123713);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.GhT);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(123713);
      return paramInt + 0 + (i + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123713);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ecl localecl = (ecl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123713);
        return -1;
      case 1: 
        localecl.GhT = locala.LVo.xF();
        AppMethodBeat.o(123713);
        return 0;
      case 2: 
        localecl.GhU = locala.LVo.fZX();
        AppMethodBeat.o(123713);
        return 0;
      }
      localecl.GhV = locala.LVo.fZX();
      AppMethodBeat.o(123713);
      return 0;
    }
    AppMethodBeat.o(123713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecl
 * JD-Core Version:    0.7.0.1
 */