package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmj
  extends com.tencent.mm.bv.a
{
  public String kmm;
  public String nLq;
  public String poq;
  public String por;
  public String wtP;
  public String wtQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48977);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.poq != null) {
        paramVarArgs.e(1, this.poq);
      }
      if (this.kmm != null) {
        paramVarArgs.e(2, this.kmm);
      }
      if (this.nLq != null) {
        paramVarArgs.e(3, this.nLq);
      }
      if (this.por != null) {
        paramVarArgs.e(4, this.por);
      }
      if (this.wtP != null) {
        paramVarArgs.e(5, this.wtP);
      }
      if (this.wtQ != null) {
        paramVarArgs.e(6, this.wtQ);
      }
      AppMethodBeat.o(48977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.poq == null) {
        break label518;
      }
    }
    label518:
    for (int i = e.a.a.b.b.a.f(1, this.poq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kmm != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.kmm);
      }
      i = paramInt;
      if (this.nLq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nLq);
      }
      paramInt = i;
      if (this.por != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.por);
      }
      i = paramInt;
      if (this.wtP != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wtP);
      }
      paramInt = i;
      if (this.wtQ != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wtQ);
      }
      AppMethodBeat.o(48977);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48977);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cmj localcmj = (cmj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48977);
          return -1;
        case 1: 
          localcmj.poq = locala.CLY.readString();
          AppMethodBeat.o(48977);
          return 0;
        case 2: 
          localcmj.kmm = locala.CLY.readString();
          AppMethodBeat.o(48977);
          return 0;
        case 3: 
          localcmj.nLq = locala.CLY.readString();
          AppMethodBeat.o(48977);
          return 0;
        case 4: 
          localcmj.por = locala.CLY.readString();
          AppMethodBeat.o(48977);
          return 0;
        case 5: 
          localcmj.wtP = locala.CLY.readString();
          AppMethodBeat.o(48977);
          return 0;
        }
        localcmj.wtQ = locala.CLY.readString();
        AppMethodBeat.o(48977);
        return 0;
      }
      AppMethodBeat.o(48977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmj
 * JD-Core Version:    0.7.0.1
 */