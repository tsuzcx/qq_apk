package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acc
  extends com.tencent.mm.bx.a
{
  public String hHZ;
  public int key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.key);
      if (this.hHZ != null) {
        paramVarArgs.d(2, this.hHZ);
      }
      AppMethodBeat.o(91430);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.key) + 0;
      paramInt = i;
      if (this.hHZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hHZ);
      }
      AppMethodBeat.o(91430);
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
      AppMethodBeat.o(91430);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      acc localacc = (acc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91430);
        return -1;
      case 1: 
        localacc.key = locala.NPN.zc();
        AppMethodBeat.o(91430);
        return 0;
      }
      localacc.hHZ = locala.NPN.readString();
      AppMethodBeat.o(91430);
      return 0;
    }
    AppMethodBeat.o(91430);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acc
 * JD-Core Version:    0.7.0.1
 */