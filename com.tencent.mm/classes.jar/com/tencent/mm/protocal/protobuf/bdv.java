package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdv
  extends com.tencent.mm.bw.a
{
  public int dLS;
  public long hFK;
  public String objectNonceId;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209708);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.hFK);
      if (this.objectNonceId != null) {
        paramVarArgs.e(2, this.objectNonceId);
      }
      paramVarArgs.aM(3, this.dLS);
      if (this.sessionBuffer != null) {
        paramVarArgs.e(4, this.sessionBuffer);
      }
      AppMethodBeat.o(209708);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.hFK) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.objectNonceId);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.dLS);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.sessionBuffer);
      }
      AppMethodBeat.o(209708);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209708);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bdv localbdv = (bdv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209708);
        return -1;
      case 1: 
        localbdv.hFK = locala.UbS.zl();
        AppMethodBeat.o(209708);
        return 0;
      case 2: 
        localbdv.objectNonceId = locala.UbS.readString();
        AppMethodBeat.o(209708);
        return 0;
      case 3: 
        localbdv.dLS = locala.UbS.zi();
        AppMethodBeat.o(209708);
        return 0;
      }
      localbdv.sessionBuffer = locala.UbS.readString();
      AppMethodBeat.o(209708);
      return 0;
    }
    AppMethodBeat.o(209708);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdv
 * JD-Core Version:    0.7.0.1
 */