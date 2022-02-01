package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebj
  extends com.tencent.mm.bw.a
{
  public float Eht;
  public float Ehu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117958);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.Eht);
      paramVarArgs.x(2, this.Ehu);
      AppMethodBeat.o(117958);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      AppMethodBeat.o(117958);
      return paramInt + 4 + 0 + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117958);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ebj localebj = (ebj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117958);
        return -1;
      case 1: 
        localebj.Eht = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(117958);
        return 0;
      }
      localebj.Ehu = Float.intBitsToFloat(locala.LVo.gaa());
      AppMethodBeat.o(117958);
      return 0;
    }
    AppMethodBeat.o(117958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebj
 * JD-Core Version:    0.7.0.1
 */