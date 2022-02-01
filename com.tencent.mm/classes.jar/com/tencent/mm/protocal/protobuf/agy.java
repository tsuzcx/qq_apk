package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class agy
  extends com.tencent.mm.bx.a
{
  public String DiN;
  public int bSt;
  public String xXR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xXR == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagName");
        AppMethodBeat.o(127485);
        throw paramVarArgs;
      }
      if (this.DiN == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagPinYin");
        AppMethodBeat.o(127485);
        throw paramVarArgs;
      }
      if (this.xXR != null) {
        paramVarArgs.d(1, this.xXR);
      }
      if (this.DiN != null) {
        paramVarArgs.d(2, this.DiN);
      }
      paramVarArgs.aR(3, this.bSt);
      AppMethodBeat.o(127485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xXR == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.b.b.a.e(1, this.xXR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DiN != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DiN);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.bSt);
      AppMethodBeat.o(127485);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.xXR == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagName");
          AppMethodBeat.o(127485);
          throw paramVarArgs;
        }
        if (this.DiN == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagPinYin");
          AppMethodBeat.o(127485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127485);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agy localagy = (agy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127485);
          return -1;
        case 1: 
          localagy.xXR = locala.KhF.readString();
          AppMethodBeat.o(127485);
          return 0;
        case 2: 
          localagy.DiN = locala.KhF.readString();
          AppMethodBeat.o(127485);
          return 0;
        }
        localagy.bSt = locala.KhF.xS();
        AppMethodBeat.o(127485);
        return 0;
      }
      AppMethodBeat.o(127485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agy
 * JD-Core Version:    0.7.0.1
 */