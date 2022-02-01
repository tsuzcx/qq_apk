package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cfb
  extends com.tencent.mm.bx.a
{
  public int fVE;
  public String pRp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pRp == null)
      {
        paramVarArgs = new b("Not all required fields were included: jsonData");
        AppMethodBeat.o(134251);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.fVE);
      if (this.pRp != null) {
        paramVarArgs.d(2, this.pRp);
      }
      AppMethodBeat.o(134251);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.fVE) + 0;
      paramInt = i;
      if (this.pRp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.pRp);
      }
      AppMethodBeat.o(134251);
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
      if (this.pRp == null)
      {
        paramVarArgs = new b("Not all required fields were included: jsonData");
        AppMethodBeat.o(134251);
        throw paramVarArgs;
      }
      AppMethodBeat.o(134251);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cfb localcfb = (cfb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134251);
        return -1;
      case 1: 
        localcfb.fVE = locala.KhF.xS();
        AppMethodBeat.o(134251);
        return 0;
      }
      localcfb.pRp = locala.KhF.readString();
      AppMethodBeat.o(134251);
      return 0;
    }
    AppMethodBeat.o(134251);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfb
 * JD-Core Version:    0.7.0.1
 */