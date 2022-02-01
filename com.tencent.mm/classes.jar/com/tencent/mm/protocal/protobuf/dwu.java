package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dwu
  extends com.tencent.mm.bw.a
{
  public boolean GdE;
  public String Username;
  public String pAD;
  
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
      if (this.pAD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Language");
        AppMethodBeat.o(32532);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.pAD != null) {
        paramVarArgs.d(2, this.pAD);
      }
      paramVarArgs.bl(3, this.GdE);
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
      if (this.pAD != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.pAD);
      }
      paramInt = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(32532);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(32532);
          throw paramVarArgs;
        }
        if (this.pAD == null)
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
        dwu localdwu = (dwu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32532);
          return -1;
        case 1: 
          localdwu.Username = locala.LVo.readString();
          AppMethodBeat.o(32532);
          return 0;
        case 2: 
          localdwu.pAD = locala.LVo.readString();
          AppMethodBeat.o(32532);
          return 0;
        }
        localdwu.GdE = locala.LVo.fZX();
        AppMethodBeat.o(32532);
        return 0;
      }
      AppMethodBeat.o(32532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwu
 * JD-Core Version:    0.7.0.1
 */