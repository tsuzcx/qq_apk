package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cyb
  extends com.tencent.mm.bv.a
{
  public int wld;
  public String wxW;
  public String xlH;
  public boolean yfj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28766);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlH == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(28766);
        throw paramVarArgs;
      }
      if (this.wxW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(28766);
        throw paramVarArgs;
      }
      if (this.xlH != null) {
        paramVarArgs.e(1, this.xlH);
      }
      if (this.wxW != null) {
        paramVarArgs.e(2, this.wxW);
      }
      paramVarArgs.aS(3, this.yfj);
      paramVarArgs.aO(4, this.wld);
      AppMethodBeat.o(28766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlH == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = e.a.a.b.b.a.f(1, this.xlH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wxW != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wxW);
      }
      paramInt = e.a.a.b.b.a.eW(3);
      int j = e.a.a.b.b.a.bl(4, this.wld);
      AppMethodBeat.o(28766);
      return i + (paramInt + 1) + j;
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
          AppMethodBeat.o(28766);
          throw paramVarArgs;
        }
        if (this.wxW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(28766);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28766);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cyb localcyb = (cyb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28766);
          return -1;
        case 1: 
          localcyb.xlH = locala.CLY.readString();
          AppMethodBeat.o(28766);
          return 0;
        case 2: 
          localcyb.wxW = locala.CLY.readString();
          AppMethodBeat.o(28766);
          return 0;
        case 3: 
          localcyb.yfj = locala.CLY.emu();
          AppMethodBeat.o(28766);
          return 0;
        }
        localcyb.wld = locala.CLY.sl();
        AppMethodBeat.o(28766);
        return 0;
      }
      AppMethodBeat.o(28766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyb
 * JD-Core Version:    0.7.0.1
 */