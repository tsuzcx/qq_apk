package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class drk
  extends com.tencent.mm.bx.a
{
  public long DYU;
  public boolean EGz;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32540);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      paramVarArgs.aG(2, this.DYU);
      paramVarArgs.bg(3, this.EGz);
      AppMethodBeat.o(32540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label363;
      }
    }
    label363:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.DYU);
      int j = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(32540);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(32540);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32540);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        drk localdrk = (drk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32540);
          return -1;
        case 1: 
          localdrk.Username = locala.KhF.readString();
          AppMethodBeat.o(32540);
          return 0;
        case 2: 
          localdrk.DYU = locala.KhF.xT();
          AppMethodBeat.o(32540);
          return 0;
        }
        localdrk.EGz = locala.KhF.fHu();
        AppMethodBeat.o(32540);
        return 0;
      }
      AppMethodBeat.o(32540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drk
 * JD-Core Version:    0.7.0.1
 */