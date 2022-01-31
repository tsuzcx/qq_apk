package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cya
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b wrr;
  public int wyT;
  public String xlH;
  public boolean yfh;
  public boolean yfi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28765);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlH == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(28765);
        throw paramVarArgs;
      }
      if (this.xlH != null) {
        paramVarArgs.e(1, this.xlH);
      }
      paramVarArgs.aO(2, this.wyT);
      if (this.wrr != null) {
        paramVarArgs.c(3, this.wrr);
      }
      paramVarArgs.aS(4, this.yfh);
      paramVarArgs.aS(5, this.yfi);
      AppMethodBeat.o(28765);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlH == null) {
        break label465;
      }
    }
    label465:
    for (paramInt = e.a.a.b.b.a.f(1, this.xlH) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wyT);
      paramInt = i;
      if (this.wrr != null) {
        paramInt = i + e.a.a.b.b.a.b(3, this.wrr);
      }
      i = e.a.a.b.b.a.eW(4);
      int j = e.a.a.b.b.a.eW(5);
      AppMethodBeat.o(28765);
      return paramInt + (i + 1) + (j + 1);
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
          AppMethodBeat.o(28765);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28765);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cya localcya = (cya)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28765);
          return -1;
        case 1: 
          localcya.xlH = locala.CLY.readString();
          AppMethodBeat.o(28765);
          return 0;
        case 2: 
          localcya.wyT = locala.CLY.sl();
          AppMethodBeat.o(28765);
          return 0;
        case 3: 
          localcya.wrr = locala.CLY.eqS();
          AppMethodBeat.o(28765);
          return 0;
        case 4: 
          localcya.yfh = locala.CLY.emu();
          AppMethodBeat.o(28765);
          return 0;
        }
        localcya.yfi = locala.CLY.emu();
        AppMethodBeat.o(28765);
        return 0;
      }
      AppMethodBeat.o(28765);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cya
 * JD-Core Version:    0.7.0.1
 */