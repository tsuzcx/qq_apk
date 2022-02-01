package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dpt
  extends com.tencent.mm.bx.a
{
  public int HDK;
  public b HDL;
  public b HDM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189869);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HDK);
      if (this.HDL != null) {
        paramVarArgs.c(2, this.HDL);
      }
      if (this.HDM != null) {
        paramVarArgs.c(3, this.HDM);
      }
      AppMethodBeat.o(189869);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HDK) + 0;
      paramInt = i;
      if (this.HDL != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HDL);
      }
      i = paramInt;
      if (this.HDM != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HDM);
      }
      AppMethodBeat.o(189869);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(189869);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dpt localdpt = (dpt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189869);
        return -1;
      case 1: 
        localdpt.HDK = locala.NPN.zc();
        AppMethodBeat.o(189869);
        return 0;
      case 2: 
        localdpt.HDL = locala.NPN.gxI();
        AppMethodBeat.o(189869);
        return 0;
      }
      localdpt.HDM = locala.NPN.gxI();
      AppMethodBeat.o(189869);
      return 0;
    }
    AppMethodBeat.o(189869);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpt
 * JD-Core Version:    0.7.0.1
 */