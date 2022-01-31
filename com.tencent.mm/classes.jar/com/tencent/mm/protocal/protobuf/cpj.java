package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cpj
  extends com.tencent.mm.bv.a
{
  public String gwU;
  public String jJA;
  public String jKG;
  public String wNM;
  public String woO;
  public String xYv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124372);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(124372);
        throw paramVarArgs;
      }
      if (this.xYv == null)
      {
        paramVarArgs = new b("Not all required fields were included: MatchWord");
        AppMethodBeat.o(124372);
        throw paramVarArgs;
      }
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.xYv != null) {
        paramVarArgs.e(2, this.xYv);
      }
      if (this.jKG != null) {
        paramVarArgs.e(3, this.jKG);
      }
      if (this.wNM != null) {
        paramVarArgs.e(4, this.wNM);
      }
      if (this.gwU != null) {
        paramVarArgs.e(5, this.gwU);
      }
      if (this.woO != null) {
        paramVarArgs.e(6, this.woO);
      }
      AppMethodBeat.o(124372);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label614;
      }
    }
    label614:
    for (int i = e.a.a.b.b.a.f(1, this.jJA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xYv != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xYv);
      }
      i = paramInt;
      if (this.jKG != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.jKG);
      }
      paramInt = i;
      if (this.wNM != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wNM);
      }
      i = paramInt;
      if (this.gwU != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.gwU);
      }
      paramInt = i;
      if (this.woO != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.woO);
      }
      AppMethodBeat.o(124372);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jJA == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(124372);
          throw paramVarArgs;
        }
        if (this.xYv == null)
        {
          paramVarArgs = new b("Not all required fields were included: MatchWord");
          AppMethodBeat.o(124372);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124372);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cpj localcpj = (cpj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124372);
          return -1;
        case 1: 
          localcpj.jJA = locala.CLY.readString();
          AppMethodBeat.o(124372);
          return 0;
        case 2: 
          localcpj.xYv = locala.CLY.readString();
          AppMethodBeat.o(124372);
          return 0;
        case 3: 
          localcpj.jKG = locala.CLY.readString();
          AppMethodBeat.o(124372);
          return 0;
        case 4: 
          localcpj.wNM = locala.CLY.readString();
          AppMethodBeat.o(124372);
          return 0;
        case 5: 
          localcpj.gwU = locala.CLY.readString();
          AppMethodBeat.o(124372);
          return 0;
        }
        localcpj.woO = locala.CLY.readString();
        AppMethodBeat.o(124372);
        return 0;
      }
      AppMethodBeat.o(124372);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpj
 * JD-Core Version:    0.7.0.1
 */