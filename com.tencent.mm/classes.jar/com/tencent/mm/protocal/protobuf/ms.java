package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ms
  extends com.tencent.mm.bw.a
{
  public String hpH;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(209564);
        throw paramVarArgs;
      }
      if (this.hpH == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(209564);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      if (this.hpH != null) {
        paramVarArgs.d(2, this.hpH);
      }
      AppMethodBeat.o(209564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hpH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hpH);
      }
      AppMethodBeat.o(209564);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(209564);
          throw paramVarArgs;
        }
        if (this.hpH == null)
        {
          paramVarArgs = new b("Not all required fields were included: val");
          AppMethodBeat.o(209564);
          throw paramVarArgs;
        }
        AppMethodBeat.o(209564);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ms localms = (ms)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209564);
          return -1;
        case 1: 
          localms.key = locala.LVo.readString();
          AppMethodBeat.o(209564);
          return 0;
        }
        localms.hpH = locala.LVo.readString();
        AppMethodBeat.o(209564);
        return 0;
      }
      AppMethodBeat.o(209564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ms
 * JD-Core Version:    0.7.0.1
 */