package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class cbf
  extends com.tencent.mm.bx.a
{
  public int YVh;
  public String aako;
  public String aakv;
  public String crB;
  public String muA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42637);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.muA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.aakv == null)
      {
        paramVarArgs = new b("Not all required fields were included: RecommendKey");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.muA != null) {
        paramVarArgs.g(1, this.muA);
      }
      if (this.aakv != null) {
        paramVarArgs.g(2, this.aakv);
      }
      if (this.crB != null) {
        paramVarArgs.g(3, this.crB);
      }
      paramVarArgs.bS(4, this.YVh);
      if (this.aako != null) {
        paramVarArgs.g(5, this.aako);
      }
      AppMethodBeat.o(42637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.muA == null) {
        break label530;
      }
    }
    label530:
    for (int i = i.a.a.b.b.a.h(1, this.muA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aakv != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aakv);
      }
      i = paramInt;
      if (this.crB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.crB);
      }
      i += i.a.a.b.b.a.cJ(4, this.YVh);
      paramInt = i;
      if (this.aako != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aako);
      }
      AppMethodBeat.o(42637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.muA == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        if (this.aakv == null)
        {
          paramVarArgs = new b("Not all required fields were included: RecommendKey");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42637);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cbf localcbf = (cbf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42637);
          return -1;
        case 1: 
          localcbf.muA = locala.ajGk.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 2: 
          localcbf.aakv = locala.ajGk.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 3: 
          localcbf.crB = locala.ajGk.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 4: 
          localcbf.YVh = locala.ajGk.aar();
          AppMethodBeat.o(42637);
          return 0;
        }
        localcbf.aako = locala.ajGk.readString();
        AppMethodBeat.o(42637);
        return 0;
      }
      AppMethodBeat.o(42637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbf
 * JD-Core Version:    0.7.0.1
 */