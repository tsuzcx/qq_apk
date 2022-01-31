package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cxu
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String wxW;
  public String xlH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28759);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlH == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(28759);
        throw paramVarArgs;
      }
      if (this.wxW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(28759);
        throw paramVarArgs;
      }
      if (this.xlH != null) {
        paramVarArgs.e(1, this.xlH);
      }
      if (this.wxW != null) {
        paramVarArgs.e(2, this.wxW);
      }
      paramVarArgs.aO(3, this.Scene);
      AppMethodBeat.o(28759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlH == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = e.a.a.b.b.a.f(1, this.xlH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wxW != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wxW);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.Scene);
      AppMethodBeat.o(28759);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xlH == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(28759);
          throw paramVarArgs;
        }
        if (this.wxW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(28759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28759);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cxu localcxu = (cxu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28759);
          return -1;
        case 1: 
          localcxu.xlH = locala.CLY.readString();
          AppMethodBeat.o(28759);
          return 0;
        case 2: 
          localcxu.wxW = locala.CLY.readString();
          AppMethodBeat.o(28759);
          return 0;
        }
        localcxu.Scene = locala.CLY.sl();
        AppMethodBeat.o(28759);
        return 0;
      }
      AppMethodBeat.o(28759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxu
 * JD-Core Version:    0.7.0.1
 */