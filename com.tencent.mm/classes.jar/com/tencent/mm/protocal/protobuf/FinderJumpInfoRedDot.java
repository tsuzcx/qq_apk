package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FinderJumpInfoRedDot
  extends com.tencent.mm.bx.a
{
  public long red_dot_type;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258067);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.red_dot_type);
      if (this.value != null) {
        paramVarArgs.g(2, this.value);
      }
      AppMethodBeat.o(258067);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.red_dot_type) + 0;
      paramInt = i;
      if (this.value != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.value);
      }
      AppMethodBeat.o(258067);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258067);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      FinderJumpInfoRedDot localFinderJumpInfoRedDot = (FinderJumpInfoRedDot)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258067);
        return -1;
      case 1: 
        localFinderJumpInfoRedDot.red_dot_type = locala.ajGk.aaw();
        AppMethodBeat.o(258067);
        return 0;
      }
      localFinderJumpInfoRedDot.value = locala.ajGk.readString();
      AppMethodBeat.o(258067);
      return 0;
    }
    AppMethodBeat.o(258067);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderJumpInfoRedDot
 * JD-Core Version:    0.7.0.1
 */