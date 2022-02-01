package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class sd
  extends com.tencent.mm.bw.a
{
  public long Id;
  public String KZP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117853);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KZP == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(117853);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.Id);
      if (this.KZP != null) {
        paramVarArgs.e(2, this.KZP);
      }
      AppMethodBeat.o(117853);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.Id) + 0;
      paramInt = i;
      if (this.KZP != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KZP);
      }
      AppMethodBeat.o(117853);
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
      if (this.KZP == null)
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
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      sd localsd = (sd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117853);
        return -1;
      case 1: 
        localsd.Id = locala.UbS.zl();
        AppMethodBeat.o(117853);
        return 0;
      }
      localsd.KZP = locala.UbS.readString();
      AppMethodBeat.o(117853);
      return 0;
    }
    AppMethodBeat.o(117853);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sd
 * JD-Core Version:    0.7.0.1
 */