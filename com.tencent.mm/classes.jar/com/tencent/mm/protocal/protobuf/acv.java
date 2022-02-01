package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acv
  extends com.tencent.mm.bw.a
{
  public long GuD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152528);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aZ(1, this.GuD);
      AppMethodBeat.o(152528);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.GuD);
      AppMethodBeat.o(152528);
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
      AppMethodBeat.o(152528);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      acv localacv = (acv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152528);
        return -1;
      }
      localacv.GuD = locala.OmT.zd();
      AppMethodBeat.o(152528);
      return 0;
    }
    AppMethodBeat.o(152528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acv
 * JD-Core Version:    0.7.0.1
 */