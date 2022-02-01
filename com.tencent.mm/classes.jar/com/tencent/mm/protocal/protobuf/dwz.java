package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwz
  extends com.tencent.mm.bw.a
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.left);
      paramVarArgs.aS(2, this.top);
      paramVarArgs.aS(3, this.right);
      paramVarArgs.aS(4, this.bottom);
      AppMethodBeat.o(169093);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.left);
      int i = f.a.a.b.b.a.bz(2, this.top);
      int j = f.a.a.b.b.a.bz(3, this.right);
      int k = f.a.a.b.b.a.bz(4, this.bottom);
      AppMethodBeat.o(169093);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(169093);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwz localdwz = (dwz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169093);
        return -1;
      case 1: 
        localdwz.left = locala.OmT.zc();
        AppMethodBeat.o(169093);
        return 0;
      case 2: 
        localdwz.top = locala.OmT.zc();
        AppMethodBeat.o(169093);
        return 0;
      case 3: 
        localdwz.right = locala.OmT.zc();
        AppMethodBeat.o(169093);
        return 0;
      }
      localdwz.bottom = locala.OmT.zc();
      AppMethodBeat.o(169093);
      return 0;
    }
    AppMethodBeat.o(169093);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwz
 * JD-Core Version:    0.7.0.1
 */