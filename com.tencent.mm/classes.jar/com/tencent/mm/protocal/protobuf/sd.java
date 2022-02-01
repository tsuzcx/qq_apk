package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sd
  extends com.tencent.mm.bw.a
{
  public int Eln;
  public String Elo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50081);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Eln);
      if (this.Elo != null) {
        paramVarArgs.d(2, this.Elo);
      }
      AppMethodBeat.o(50081);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Eln) + 0;
      paramInt = i;
      if (this.Elo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Elo);
      }
      AppMethodBeat.o(50081);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(50081);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      sd localsd = (sd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50081);
        return -1;
      case 1: 
        localsd.Eln = locala.LVo.xF();
        AppMethodBeat.o(50081);
        return 0;
      }
      localsd.Elo = locala.LVo.readString();
      AppMethodBeat.o(50081);
      return 0;
    }
    AppMethodBeat.o(50081);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sd
 * JD-Core Version:    0.7.0.1
 */