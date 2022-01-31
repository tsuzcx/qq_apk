package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class che
  extends com.tencent.mm.bv.a
{
  public String xRT;
  public String xRU;
  public String xRV;
  public String xRW;
  public String xRX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56512);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xRT == null)
      {
        paramVarArgs = new b("Not all required fields were included: videoFileMD5");
        AppMethodBeat.o(56512);
        throw paramVarArgs;
      }
      if (this.xRT != null) {
        paramVarArgs.e(1, this.xRT);
      }
      if (this.xRU != null) {
        paramVarArgs.e(2, this.xRU);
      }
      if (this.xRV != null) {
        paramVarArgs.e(3, this.xRV);
      }
      if (this.xRW != null) {
        paramVarArgs.e(4, this.xRW);
      }
      if (this.xRX != null) {
        paramVarArgs.e(5, this.xRX);
      }
      AppMethodBeat.o(56512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xRT == null) {
        break label502;
      }
    }
    label502:
    for (int i = e.a.a.b.b.a.f(1, this.xRT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xRU != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xRU);
      }
      i = paramInt;
      if (this.xRV != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xRV);
      }
      paramInt = i;
      if (this.xRW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xRW);
      }
      i = paramInt;
      if (this.xRX != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xRX);
      }
      AppMethodBeat.o(56512);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xRT == null)
        {
          paramVarArgs = new b("Not all required fields were included: videoFileMD5");
          AppMethodBeat.o(56512);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56512);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        che localche = (che)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56512);
          return -1;
        case 1: 
          localche.xRT = locala.CLY.readString();
          AppMethodBeat.o(56512);
          return 0;
        case 2: 
          localche.xRU = locala.CLY.readString();
          AppMethodBeat.o(56512);
          return 0;
        case 3: 
          localche.xRV = locala.CLY.readString();
          AppMethodBeat.o(56512);
          return 0;
        case 4: 
          localche.xRW = locala.CLY.readString();
          AppMethodBeat.o(56512);
          return 0;
        }
        localche.xRX = locala.CLY.readString();
        AppMethodBeat.o(56512);
        return 0;
      }
      AppMethodBeat.o(56512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.che
 * JD-Core Version:    0.7.0.1
 */