package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eel
  extends com.tencent.mm.bw.a
{
  public boolean IiR;
  public String Username;
  public String qkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32532);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32532);
        throw paramVarArgs;
      }
      if (this.qkN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Language");
        AppMethodBeat.o(32532);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.qkN != null) {
        paramVarArgs.d(2, this.qkN);
      }
      paramVarArgs.bC(3, this.IiR);
      AppMethodBeat.o(32532);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label423;
      }
    }
    label423:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qkN != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.qkN);
      }
      paramInt = f.a.a.b.b.a.amF(3);
      AppMethodBeat.o(32532);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(32532);
          throw paramVarArgs;
        }
        if (this.qkN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Language");
          AppMethodBeat.o(32532);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32532);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eel localeel = (eel)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32532);
          return -1;
        case 1: 
          localeel.Username = locala.OmT.readString();
          AppMethodBeat.o(32532);
          return 0;
        case 2: 
          localeel.qkN = locala.OmT.readString();
          AppMethodBeat.o(32532);
          return 0;
        }
        localeel.IiR = locala.OmT.gvY();
        AppMethodBeat.o(32532);
        return 0;
      }
      AppMethodBeat.o(32532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eel
 * JD-Core Version:    0.7.0.1
 */