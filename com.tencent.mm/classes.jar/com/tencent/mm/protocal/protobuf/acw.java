package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acw
  extends com.tencent.mm.bw.a
{
  public long Id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125720);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aZ(1, this.Id);
      AppMethodBeat.o(125720);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.Id);
      AppMethodBeat.o(125720);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125720);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      acw localacw = (acw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125720);
        return -1;
      }
      localacw.Id = locala.OmT.zd();
      AppMethodBeat.o(125720);
      return 0;
    }
    AppMethodBeat.o(125720);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acw
 * JD-Core Version:    0.7.0.1
 */