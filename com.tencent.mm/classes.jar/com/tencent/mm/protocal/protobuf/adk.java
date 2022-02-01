package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adk
  extends com.tencent.mm.bw.a
{
  public long EvZ;
  public long Ewa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EvZ);
      paramVarArgs.aO(2, this.Ewa);
      AppMethodBeat.o(91440);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.EvZ);
      int i = f.a.a.b.b.a.p(2, this.Ewa);
      AppMethodBeat.o(91440);
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
      AppMethodBeat.o(91440);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      adk localadk = (adk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91440);
        return -1;
      case 1: 
        localadk.EvZ = locala.LVo.xG();
        AppMethodBeat.o(91440);
        return 0;
      }
      localadk.Ewa = locala.LVo.xG();
      AppMethodBeat.o(91440);
      return 0;
    }
    AppMethodBeat.o(91440);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adk
 * JD-Core Version:    0.7.0.1
 */