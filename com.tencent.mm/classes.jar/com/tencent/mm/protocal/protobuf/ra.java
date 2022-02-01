package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ra
  extends com.tencent.mm.bx.a
{
  public String FMZ;
  public long Id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117853);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FMZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(117853);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Id);
      if (this.FMZ != null) {
        paramVarArgs.d(2, this.FMZ);
      }
      AppMethodBeat.o(117853);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.FMZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FMZ);
      }
      AppMethodBeat.o(117853);
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
      if (this.FMZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(117853);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117853);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ra localra = (ra)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117853);
        return -1;
      case 1: 
        localra.Id = locala.NPN.zd();
        AppMethodBeat.o(117853);
        return 0;
      }
      localra.FMZ = locala.NPN.readString();
      AppMethodBeat.o(117853);
      return 0;
    }
    AppMethodBeat.o(117853);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ra
 * JD-Core Version:    0.7.0.1
 */