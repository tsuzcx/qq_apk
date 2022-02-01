package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkj
  extends com.tencent.mm.bx.a
{
  public String Hza;
  public int yhn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133200);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.yhn);
      if (this.Hza != null) {
        paramVarArgs.d(2, this.Hza);
      }
      AppMethodBeat.o(133200);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.yhn) + 0;
      paramInt = i;
      if (this.Hza != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hza);
      }
      AppMethodBeat.o(133200);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(133200);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dkj localdkj = (dkj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133200);
        return -1;
      case 1: 
        localdkj.yhn = locala.NPN.zc();
        AppMethodBeat.o(133200);
        return 0;
      }
      localdkj.Hza = locala.NPN.readString();
      AppMethodBeat.o(133200);
      return 0;
    }
    AppMethodBeat.o(133200);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkj
 * JD-Core Version:    0.7.0.1
 */