package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyc
  extends com.tencent.mm.bv.a
{
  public String jKG;
  public String xlH;
  public com.tencent.mm.bv.b yeB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28767);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlH == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(28767);
        throw paramVarArgs;
      }
      if (this.jKG == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(28767);
        throw paramVarArgs;
      }
      if (this.xlH != null) {
        paramVarArgs.e(1, this.xlH);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      if (this.yeB != null) {
        paramVarArgs.c(3, this.yeB);
      }
      AppMethodBeat.o(28767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlH == null) {
        break label443;
      }
    }
    label443:
    for (int i = e.a.a.b.b.a.f(1, this.xlH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKG);
      }
      i = paramInt;
      if (this.yeB != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.yeB);
      }
      AppMethodBeat.o(28767);
      return i;
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
          AppMethodBeat.o(28767);
          throw paramVarArgs;
        }
        if (this.jKG == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: NickName");
          AppMethodBeat.o(28767);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28767);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cyc localcyc = (cyc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28767);
          return -1;
        case 1: 
          localcyc.xlH = locala.CLY.readString();
          AppMethodBeat.o(28767);
          return 0;
        case 2: 
          localcyc.jKG = locala.CLY.readString();
          AppMethodBeat.o(28767);
          return 0;
        }
        localcyc.yeB = locala.CLY.eqS();
        AppMethodBeat.o(28767);
        return 0;
      }
      AppMethodBeat.o(28767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyc
 * JD-Core Version:    0.7.0.1
 */