package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class acw
  extends com.tencent.mm.bx.a
{
  public int Ddx;
  public String Ddy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ddy == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(104760);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Ddx);
      if (this.Ddy != null) {
        paramVarArgs.d(2, this.Ddy);
      }
      AppMethodBeat.o(104760);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Ddx) + 0;
      paramInt = i;
      if (this.Ddy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ddy);
      }
      AppMethodBeat.o(104760);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Ddy == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(104760);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104760);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      acw localacw = (acw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104760);
        return -1;
      case 1: 
        localacw.Ddx = locala.KhF.xS();
        AppMethodBeat.o(104760);
        return 0;
      }
      localacw.Ddy = locala.KhF.readString();
      AppMethodBeat.o(104760);
      return 0;
    }
    AppMethodBeat.o(104760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acw
 * JD-Core Version:    0.7.0.1
 */