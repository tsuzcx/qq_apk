package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class iy
  extends com.tencent.mm.bx.a
{
  public int channel;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91361);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuid == null)
      {
        paramVarArgs = new b("Not all required fields were included: uuid");
        AppMethodBeat.o(91361);
        throw paramVarArgs;
      }
      if (this.uuid != null) {
        paramVarArgs.d(1, this.uuid);
      }
      paramVarArgs.aS(2, this.channel);
      AppMethodBeat.o(91361);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.channel);
      AppMethodBeat.o(91361);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.uuid == null)
        {
          paramVarArgs = new b("Not all required fields were included: uuid");
          AppMethodBeat.o(91361);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91361);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        iy localiy = (iy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91361);
          return -1;
        case 1: 
          localiy.uuid = locala.NPN.readString();
          AppMethodBeat.o(91361);
          return 0;
        }
        localiy.channel = locala.NPN.zc();
        AppMethodBeat.o(91361);
        return 0;
      }
      AppMethodBeat.o(91361);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iy
 * JD-Core Version:    0.7.0.1
 */