package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cxa
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String ntu;
  public long wsz;
  public String xlH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28734);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlH == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(28734);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(28734);
        throw paramVarArgs;
      }
      if (this.ntu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(28734);
        throw paramVarArgs;
      }
      if (this.xlH != null) {
        paramVarArgs.e(1, this.xlH);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.ntu != null) {
        paramVarArgs.e(3, this.ntu);
      }
      paramVarArgs.am(4, this.wsz);
      AppMethodBeat.o(28734);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlH == null) {
        break label540;
      }
    }
    label540:
    for (int i = e.a.a.b.b.a.f(1, this.xlH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.ntu != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ntu);
      }
      paramInt = e.a.a.b.b.a.p(4, this.wsz);
      AppMethodBeat.o(28734);
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
          AppMethodBeat.o(28734);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(28734);
          throw paramVarArgs;
        }
        if (this.ntu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Content");
          AppMethodBeat.o(28734);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28734);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cxa localcxa = (cxa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28734);
          return -1;
        case 1: 
          localcxa.xlH = locala.CLY.readString();
          AppMethodBeat.o(28734);
          return 0;
        case 2: 
          localcxa.Title = locala.CLY.readString();
          AppMethodBeat.o(28734);
          return 0;
        case 3: 
          localcxa.ntu = locala.CLY.readString();
          AppMethodBeat.o(28734);
          return 0;
        }
        localcxa.wsz = locala.CLY.sm();
        AppMethodBeat.o(28734);
        return 0;
      }
      AppMethodBeat.o(28734);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxa
 * JD-Core Version:    0.7.0.1
 */