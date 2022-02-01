package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aaw
  extends com.tencent.mm.bx.a
{
  public String id;
  public boolean ssW = true;
  public long timestamp;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210577);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new b("Not all required fields were included: id");
        AppMethodBeat.o(210577);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      paramVarArgs.aY(2, this.timestamp);
      paramVarArgs.aS(3, this.type);
      paramVarArgs.bt(4, this.ssW);
      AppMethodBeat.o(210577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.timestamp);
      int j = f.a.a.b.b.a.bz(3, this.type);
      int k = f.a.a.b.b.a.alV(4);
      AppMethodBeat.o(210577);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new b("Not all required fields were included: id");
          AppMethodBeat.o(210577);
          throw paramVarArgs;
        }
        AppMethodBeat.o(210577);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aaw localaaw = (aaw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(210577);
          return -1;
        case 1: 
          localaaw.id = locala.NPN.readString();
          AppMethodBeat.o(210577);
          return 0;
        case 2: 
          localaaw.timestamp = locala.NPN.zd();
          AppMethodBeat.o(210577);
          return 0;
        case 3: 
          localaaw.type = locala.NPN.zc();
          AppMethodBeat.o(210577);
          return 0;
        }
        localaaw.ssW = locala.NPN.grw();
        AppMethodBeat.o(210577);
        return 0;
      }
      AppMethodBeat.o(210577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaw
 * JD-Core Version:    0.7.0.1
 */