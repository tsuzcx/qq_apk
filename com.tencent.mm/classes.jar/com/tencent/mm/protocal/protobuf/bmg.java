package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmg
  extends com.tencent.mm.bx.a
{
  public int HWO;
  public int ZKz;
  public long update_time;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259084);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZKz);
      paramVarArgs.bS(2, this.HWO);
      paramVarArgs.bv(3, this.update_time);
      AppMethodBeat.o(259084);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZKz);
      int i = i.a.a.b.b.a.cJ(2, this.HWO);
      int j = i.a.a.b.b.a.q(3, this.update_time);
      AppMethodBeat.o(259084);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259084);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bmg localbmg = (bmg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259084);
        return -1;
      case 1: 
        localbmg.ZKz = locala.ajGk.aar();
        AppMethodBeat.o(259084);
        return 0;
      case 2: 
        localbmg.HWO = locala.ajGk.aar();
        AppMethodBeat.o(259084);
        return 0;
      }
      localbmg.update_time = locala.ajGk.aaw();
      AppMethodBeat.o(259084);
      return 0;
    }
    AppMethodBeat.o(259084);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmg
 * JD-Core Version:    0.7.0.1
 */