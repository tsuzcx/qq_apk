package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vx
  extends com.tencent.mm.bw.a
{
  public long xts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215544);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aZ(1, this.xts);
      AppMethodBeat.o(215544);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.xts);
      AppMethodBeat.o(215544);
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
      AppMethodBeat.o(215544);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      vx localvx = (vx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(215544);
        return -1;
      }
      localvx.xts = locala.OmT.zd();
      AppMethodBeat.o(215544);
      return 0;
    }
    AppMethodBeat.o(215544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vx
 * JD-Core Version:    0.7.0.1
 */