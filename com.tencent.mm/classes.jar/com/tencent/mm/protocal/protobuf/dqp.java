package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dqp
  extends com.tencent.mm.bx.a
{
  public long EGk;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32515);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32515);
        throw paramVarArgs;
      }
      paramVarArgs.aG(1, this.EGk);
      if (this.Username != null) {
        paramVarArgs.d(2, this.Username);
      }
      AppMethodBeat.o(32515);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.EGk) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Username);
      }
      AppMethodBeat.o(32515);
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
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32515);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32515);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dqp localdqp = (dqp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32515);
        return -1;
      case 1: 
        localdqp.EGk = locala.KhF.xT();
        AppMethodBeat.o(32515);
        return 0;
      }
      localdqp.Username = locala.KhF.readString();
      AppMethodBeat.o(32515);
      return 0;
    }
    AppMethodBeat.o(32515);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqp
 * JD-Core Version:    0.7.0.1
 */