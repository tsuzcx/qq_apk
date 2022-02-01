package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akg
  extends com.tencent.mm.bw.a
{
  public int height;
  public int left;
  public int top;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127468);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.left);
      paramVarArgs.aS(2, this.top);
      paramVarArgs.aS(3, this.width);
      paramVarArgs.aS(4, this.height);
      AppMethodBeat.o(127468);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.left);
      int i = f.a.a.b.b.a.bz(2, this.top);
      int j = f.a.a.b.b.a.bz(3, this.width);
      int k = f.a.a.b.b.a.bz(4, this.height);
      AppMethodBeat.o(127468);
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
      AppMethodBeat.o(127468);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      akg localakg = (akg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127468);
        return -1;
      case 1: 
        localakg.left = locala.OmT.zc();
        AppMethodBeat.o(127468);
        return 0;
      case 2: 
        localakg.top = locala.OmT.zc();
        AppMethodBeat.o(127468);
        return 0;
      case 3: 
        localakg.width = locala.OmT.zc();
        AppMethodBeat.o(127468);
        return 0;
      }
      localakg.height = locala.OmT.zc();
      AppMethodBeat.o(127468);
      return 0;
    }
    AppMethodBeat.o(127468);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akg
 * JD-Core Version:    0.7.0.1
 */