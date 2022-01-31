package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hc
  extends com.tencent.mm.bv.a
{
  public String nLq;
  public String poq;
  public String por;
  public String ubQ;
  public String wtO;
  public String wtP;
  public String wtQ;
  public String wtR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56708);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wtO != null) {
        paramVarArgs.e(1, this.wtO);
      }
      if (this.ubQ != null) {
        paramVarArgs.e(2, this.ubQ);
      }
      if (this.poq != null) {
        paramVarArgs.e(3, this.poq);
      }
      if (this.por != null) {
        paramVarArgs.e(4, this.por);
      }
      if (this.nLq != null) {
        paramVarArgs.e(5, this.nLq);
      }
      if (this.wtP != null) {
        paramVarArgs.e(6, this.wtP);
      }
      if (this.wtQ != null) {
        paramVarArgs.e(7, this.wtQ);
      }
      if (this.wtR != null) {
        paramVarArgs.e(8, this.wtR);
      }
      AppMethodBeat.o(56708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wtO == null) {
        break label642;
      }
    }
    label642:
    for (int i = e.a.a.b.b.a.f(1, this.wtO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ubQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ubQ);
      }
      i = paramInt;
      if (this.poq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.poq);
      }
      paramInt = i;
      if (this.por != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.por);
      }
      i = paramInt;
      if (this.nLq != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nLq);
      }
      paramInt = i;
      if (this.wtP != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wtP);
      }
      i = paramInt;
      if (this.wtQ != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wtQ);
      }
      paramInt = i;
      if (this.wtR != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wtR);
      }
      AppMethodBeat.o(56708);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56708);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        hc localhc = (hc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56708);
          return -1;
        case 1: 
          localhc.wtO = locala.CLY.readString();
          AppMethodBeat.o(56708);
          return 0;
        case 2: 
          localhc.ubQ = locala.CLY.readString();
          AppMethodBeat.o(56708);
          return 0;
        case 3: 
          localhc.poq = locala.CLY.readString();
          AppMethodBeat.o(56708);
          return 0;
        case 4: 
          localhc.por = locala.CLY.readString();
          AppMethodBeat.o(56708);
          return 0;
        case 5: 
          localhc.nLq = locala.CLY.readString();
          AppMethodBeat.o(56708);
          return 0;
        case 6: 
          localhc.wtP = locala.CLY.readString();
          AppMethodBeat.o(56708);
          return 0;
        case 7: 
          localhc.wtQ = locala.CLY.readString();
          AppMethodBeat.o(56708);
          return 0;
        }
        localhc.wtR = locala.CLY.readString();
        AppMethodBeat.o(56708);
        return 0;
      }
      AppMethodBeat.o(56708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hc
 * JD-Core Version:    0.7.0.1
 */