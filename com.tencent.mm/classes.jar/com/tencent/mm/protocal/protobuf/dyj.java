package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyj
  extends com.tencent.mm.bw.a
{
  public int HUj;
  public String HUk;
  public int Hzv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115860);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HUj);
      paramVarArgs.aS(2, this.Hzv);
      if (this.HUk != null) {
        paramVarArgs.d(3, this.HUk);
      }
      AppMethodBeat.o(115860);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HUj) + 0 + f.a.a.b.b.a.bz(2, this.Hzv);
      paramInt = i;
      if (this.HUk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HUk);
      }
      AppMethodBeat.o(115860);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115860);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dyj localdyj = (dyj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115860);
        return -1;
      case 1: 
        localdyj.HUj = locala.OmT.zc();
        AppMethodBeat.o(115860);
        return 0;
      case 2: 
        localdyj.Hzv = locala.OmT.zc();
        AppMethodBeat.o(115860);
        return 0;
      }
      localdyj.HUk = locala.OmT.readString();
      AppMethodBeat.o(115860);
      return 0;
    }
    AppMethodBeat.o(115860);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyj
 * JD-Core Version:    0.7.0.1
 */