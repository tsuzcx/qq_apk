package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bfh
  extends com.tencent.mm.bv.a
{
  public String Username;
  public double xuw;
  public long xux;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124327);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(124327);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      paramVarArgs.f(2, this.xuw);
      paramVarArgs.am(3, this.xux);
      AppMethodBeat.o(124327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label353;
      }
    }
    label353:
    for (paramInt = e.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.p(3, this.xux);
      AppMethodBeat.o(124327);
      return paramInt + (i + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(124327);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124327);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bfh localbfh = (bfh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124327);
          return -1;
        case 1: 
          localbfh.Username = locala.CLY.readString();
          AppMethodBeat.o(124327);
          return 0;
        case 2: 
          localbfh.xuw = Double.longBitsToDouble(locala.CLY.emy());
          AppMethodBeat.o(124327);
          return 0;
        }
        localbfh.xux = locala.CLY.sm();
        AppMethodBeat.o(124327);
        return 0;
      }
      AppMethodBeat.o(124327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfh
 * JD-Core Version:    0.7.0.1
 */