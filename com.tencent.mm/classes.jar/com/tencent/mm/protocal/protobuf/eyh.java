package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eyh
  extends com.tencent.mm.bw.a
{
  public String UserName;
  public String oUJ;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32517);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(32517);
        throw paramVarArgs;
      }
      if (this.oUJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(32517);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      paramVarArgs.aM(3, this.oUv);
      AppMethodBeat.o(32517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.oUJ);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.oUv);
      AppMethodBeat.o(32517);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.UserName == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(32517);
          throw paramVarArgs;
        }
        if (this.oUJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(32517);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32517);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eyh localeyh = (eyh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32517);
          return -1;
        case 1: 
          localeyh.UserName = locala.UbS.readString();
          AppMethodBeat.o(32517);
          return 0;
        case 2: 
          localeyh.oUJ = locala.UbS.readString();
          AppMethodBeat.o(32517);
          return 0;
        }
        localeyh.oUv = locala.UbS.zi();
        AppMethodBeat.o(32517);
        return 0;
      }
      AppMethodBeat.o(32517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyh
 * JD-Core Version:    0.7.0.1
 */