package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.storage.ad;
import e.a.a.b;

public final class me
  extends com.tencent.mm.bv.a
{
  public ad contact;
  public d pyd;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14716);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.userName == null)
      {
        paramVarArgs = new b("Not all required fields were included: userName");
        AppMethodBeat.o(14716);
        throw paramVarArgs;
      }
      if (this.userName != null) {
        paramVarArgs.e(1, this.userName);
      }
      AppMethodBeat.o(14716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = e.a.a.b.b.a.f(1, this.userName) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(14716);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.userName == null)
        {
          paramVarArgs = new b("Not all required fields were included: userName");
          AppMethodBeat.o(14716);
          throw paramVarArgs;
        }
        AppMethodBeat.o(14716);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        me localme = (me)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(14716);
          return -1;
        }
        localme.userName = locala.CLY.readString();
        AppMethodBeat.o(14716);
        return 0;
      }
      AppMethodBeat.o(14716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.me
 * JD-Core Version:    0.7.0.1
 */