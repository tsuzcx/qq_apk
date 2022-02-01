package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class drd
  extends com.tencent.mm.bx.a
{
  public boolean EGs;
  public String Username;
  public String oXs;
  
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
      if (this.oXs == null)
      {
        paramVarArgs = new b("Not all required fields were included: Language");
        AppMethodBeat.o(32532);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.oXs != null) {
        paramVarArgs.d(2, this.oXs);
      }
      paramVarArgs.bg(3, this.EGs);
      AppMethodBeat.o(32532);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oXs != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oXs);
      }
      paramInt = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(32532);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(32532);
          throw paramVarArgs;
        }
        if (this.oXs == null)
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
        drd localdrd = (drd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32532);
          return -1;
        case 1: 
          localdrd.Username = locala.KhF.readString();
          AppMethodBeat.o(32532);
          return 0;
        case 2: 
          localdrd.oXs = locala.KhF.readString();
          AppMethodBeat.o(32532);
          return 0;
        }
        localdrd.EGs = locala.KhF.fHu();
        AppMethodBeat.o(32532);
        return 0;
      }
      AppMethodBeat.o(32532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drd
 * JD-Core Version:    0.7.0.1
 */