package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bll
  extends com.tencent.mm.bw.a
{
  public int FaZ;
  public int Fba;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116331);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FaZ);
      paramVarArgs.aR(2, this.Fba);
      AppMethodBeat.o(116331);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FaZ);
      int i = f.a.a.b.b.a.bx(2, this.Fba);
      AppMethodBeat.o(116331);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(116331);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bll localbll = (bll)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116331);
        return -1;
      case 1: 
        localbll.FaZ = locala.LVo.xF();
        AppMethodBeat.o(116331);
        return 0;
      }
      localbll.Fba = locala.LVo.xF();
      AppMethodBeat.o(116331);
      return 0;
    }
    AppMethodBeat.o(116331);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bll
 * JD-Core Version:    0.7.0.1
 */