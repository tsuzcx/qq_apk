package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fyb
  extends com.tencent.mm.bx.a
{
  public int bottom;
  public int left;
  public int right;
  public int top;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169093);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.left);
      paramVarArgs.bS(2, this.top);
      paramVarArgs.bS(3, this.right);
      paramVarArgs.bS(4, this.bottom);
      AppMethodBeat.o(169093);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.left);
      int i = i.a.a.b.b.a.cJ(2, this.top);
      int j = i.a.a.b.b.a.cJ(3, this.right);
      int k = i.a.a.b.b.a.cJ(4, this.bottom);
      AppMethodBeat.o(169093);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169093);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fyb localfyb = (fyb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169093);
        return -1;
      case 1: 
        localfyb.left = locala.ajGk.aar();
        AppMethodBeat.o(169093);
        return 0;
      case 2: 
        localfyb.top = locala.ajGk.aar();
        AppMethodBeat.o(169093);
        return 0;
      case 3: 
        localfyb.right = locala.ajGk.aar();
        AppMethodBeat.o(169093);
        return 0;
      }
      localfyb.bottom = locala.ajGk.aar();
      AppMethodBeat.o(169093);
      return 0;
    }
    AppMethodBeat.o(169093);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fyb
 * JD-Core Version:    0.7.0.1
 */