package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class se
  extends com.tencent.mm.bw.a
{
  public int Eln;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50082);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aR(1, this.Eln);
      AppMethodBeat.o(50082);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Eln);
      AppMethodBeat.o(50082);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(50082);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      se localse = (se)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50082);
        return -1;
      }
      localse.Eln = locala.LVo.xF();
      AppMethodBeat.o(50082);
      return 0;
    }
    AppMethodBeat.o(50082);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.se
 * JD-Core Version:    0.7.0.1
 */