package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class nd
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String wCa;
  public String wCb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124296);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(124296);
        throw paramVarArgs;
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(1, this.IconUrl);
      }
      if (this.wCa != null) {
        paramVarArgs.e(2, this.wCa);
      }
      if (this.wCb != null) {
        paramVarArgs.e(3, this.wCb);
      }
      AppMethodBeat.o(124296);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IconUrl == null) {
        break label382;
      }
    }
    label382:
    for (int i = e.a.a.b.b.a.f(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wCa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wCa);
      }
      i = paramInt;
      if (this.wCb != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wCb);
      }
      AppMethodBeat.o(124296);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(124296);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124296);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        nd localnd = (nd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124296);
          return -1;
        case 1: 
          localnd.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(124296);
          return 0;
        case 2: 
          localnd.wCa = locala.CLY.readString();
          AppMethodBeat.o(124296);
          return 0;
        }
        localnd.wCb = locala.CLY.readString();
        AppMethodBeat.o(124296);
        return 0;
      }
      AppMethodBeat.o(124296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nd
 * JD-Core Version:    0.7.0.1
 */