package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxv
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public com.tencent.mm.bv.b wrr;
  public String xlH;
  public long yfa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28760);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlH == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(28760);
        throw paramVarArgs;
      }
      if (this.wrr == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(28760);
        throw paramVarArgs;
      }
      if (this.xlH != null) {
        paramVarArgs.e(1, this.xlH);
      }
      paramVarArgs.am(2, this.yfa);
      if (this.wrr != null) {
        paramVarArgs.c(3, this.wrr);
      }
      paramVarArgs.aO(4, this.Scene);
      AppMethodBeat.o(28760);
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
      int i = paramInt + e.a.a.b.b.a.p(2, this.yfa);
      paramInt = i;
      if (this.wrr != null) {
        paramInt = i + e.a.a.b.b.a.b(3, this.wrr);
      }
      i = e.a.a.b.b.a.bl(4, this.Scene);
      AppMethodBeat.o(28760);
      return paramInt + i;
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
          paramVarArgs = new e.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(28760);
          throw paramVarArgs;
        }
        if (this.wrr == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: VoiceData");
          AppMethodBeat.o(28760);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28760);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cxv localcxv = (cxv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28760);
          return -1;
        case 1: 
          localcxv.xlH = locala.CLY.readString();
          AppMethodBeat.o(28760);
          return 0;
        case 2: 
          localcxv.yfa = locala.CLY.sm();
          AppMethodBeat.o(28760);
          return 0;
        case 3: 
          localcxv.wrr = locala.CLY.eqS();
          AppMethodBeat.o(28760);
          return 0;
        }
        localcxv.Scene = locala.CLY.sl();
        AppMethodBeat.o(28760);
        return 0;
      }
      AppMethodBeat.o(28760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxv
 * JD-Core Version:    0.7.0.1
 */