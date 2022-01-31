package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czc
  extends com.tencent.mm.bv.a
{
  public String cyA;
  public String pJg;
  public String ygb;
  public String ygc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80212);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ygb != null) {
        paramVarArgs.e(1, this.ygb);
      }
      if (this.cyA != null) {
        paramVarArgs.e(2, this.cyA);
      }
      if (this.pJg != null) {
        paramVarArgs.e(3, this.pJg);
      }
      if (this.ygc != null) {
        paramVarArgs.e(4, this.ygc);
      }
      AppMethodBeat.o(80212);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ygb == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.ygb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cyA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cyA);
      }
      i = paramInt;
      if (this.pJg != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.pJg);
      }
      paramInt = i;
      if (this.ygc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ygc);
      }
      AppMethodBeat.o(80212);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80212);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        czc localczc = (czc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80212);
          return -1;
        case 1: 
          localczc.ygb = locala.CLY.readString();
          AppMethodBeat.o(80212);
          return 0;
        case 2: 
          localczc.cyA = locala.CLY.readString();
          AppMethodBeat.o(80212);
          return 0;
        case 3: 
          localczc.pJg = locala.CLY.readString();
          AppMethodBeat.o(80212);
          return 0;
        }
        localczc.ygc = locala.CLY.readString();
        AppMethodBeat.o(80212);
        return 0;
      }
      AppMethodBeat.o(80212);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czc
 * JD-Core Version:    0.7.0.1
 */