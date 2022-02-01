package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cke
  extends com.tencent.mm.bw.a
{
  public int fZz;
  public String qzX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qzX == null)
      {
        paramVarArgs = new b("Not all required fields were included: jsonData");
        AppMethodBeat.o(134251);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.fZz);
      if (this.qzX != null) {
        paramVarArgs.d(2, this.qzX);
      }
      AppMethodBeat.o(134251);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.fZz) + 0;
      paramInt = i;
      if (this.qzX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qzX);
      }
      AppMethodBeat.o(134251);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.qzX == null)
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
      cke localcke = (cke)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134251);
        return -1;
      case 1: 
        localcke.fZz = locala.LVo.xF();
        AppMethodBeat.o(134251);
        return 0;
      }
      localcke.qzX = locala.LVo.readString();
      AppMethodBeat.o(134251);
      return 0;
    }
    AppMethodBeat.o(134251);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cke
 * JD-Core Version:    0.7.0.1
 */