package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fxt
  extends com.tencent.mm.bx.a
{
  public boolean UbT;
  public String Wqc;
  public long duration;
  public String nBT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257826);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Wqc == null)
      {
        paramVarArgs = new b("Not all required fields were included: templatePath");
        AppMethodBeat.o(257826);
        throw paramVarArgs;
      }
      if (this.nBT == null)
      {
        paramVarArgs = new b("Not all required fields were included: musicPath");
        AppMethodBeat.o(257826);
        throw paramVarArgs;
      }
      if (this.Wqc != null) {
        paramVarArgs.g(1, this.Wqc);
      }
      if (this.nBT != null) {
        paramVarArgs.g(2, this.nBT);
      }
      paramVarArgs.bv(3, this.duration);
      paramVarArgs.di(4, this.UbT);
      AppMethodBeat.o(257826);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Wqc == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = i.a.a.b.b.a.h(1, this.Wqc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nBT != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nBT);
      }
      paramInt = i.a.a.b.b.a.q(3, this.duration);
      int j = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(257826);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Wqc == null)
        {
          paramVarArgs = new b("Not all required fields were included: templatePath");
          AppMethodBeat.o(257826);
          throw paramVarArgs;
        }
        if (this.nBT == null)
        {
          paramVarArgs = new b("Not all required fields were included: musicPath");
          AppMethodBeat.o(257826);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257826);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fxt localfxt = (fxt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257826);
          return -1;
        case 1: 
          localfxt.Wqc = locala.ajGk.readString();
          AppMethodBeat.o(257826);
          return 0;
        case 2: 
          localfxt.nBT = locala.ajGk.readString();
          AppMethodBeat.o(257826);
          return 0;
        case 3: 
          localfxt.duration = locala.ajGk.aaw();
          AppMethodBeat.o(257826);
          return 0;
        }
        localfxt.UbT = locala.ajGk.aai();
        AppMethodBeat.o(257826);
        return 0;
      }
      AppMethodBeat.o(257826);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxt
 * JD-Core Version:    0.7.0.1
 */