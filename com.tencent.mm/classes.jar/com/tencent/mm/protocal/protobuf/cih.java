package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cih
  extends com.tencent.mm.bv.a
{
  public String fiO;
  public int fiP;
  public String fiQ;
  public String fiR;
  public String fiS;
  public String fiT;
  public String fiU;
  public String fiV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94633);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fiO != null) {
        paramVarArgs.e(1, this.fiO);
      }
      paramVarArgs.aO(2, this.fiP);
      if (this.fiR != null) {
        paramVarArgs.e(3, this.fiR);
      }
      if (this.fiS != null) {
        paramVarArgs.e(4, this.fiS);
      }
      if (this.fiQ != null) {
        paramVarArgs.e(5, this.fiQ);
      }
      if (this.fiT != null) {
        paramVarArgs.e(6, this.fiT);
      }
      if (this.fiU != null) {
        paramVarArgs.e(7, this.fiU);
      }
      if (this.fiV != null) {
        paramVarArgs.e(8, this.fiV);
      }
      AppMethodBeat.o(94633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fiO == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = e.a.a.b.b.a.f(1, this.fiO) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.fiP);
      paramInt = i;
      if (this.fiR != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.fiR);
      }
      i = paramInt;
      if (this.fiS != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.fiS);
      }
      paramInt = i;
      if (this.fiQ != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.fiQ);
      }
      i = paramInt;
      if (this.fiT != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.fiT);
      }
      paramInt = i;
      if (this.fiU != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.fiU);
      }
      i = paramInt;
      if (this.fiV != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.fiV);
      }
      AppMethodBeat.o(94633);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94633);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cih localcih = (cih)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94633);
          return -1;
        case 1: 
          localcih.fiO = locala.CLY.readString();
          AppMethodBeat.o(94633);
          return 0;
        case 2: 
          localcih.fiP = locala.CLY.sl();
          AppMethodBeat.o(94633);
          return 0;
        case 3: 
          localcih.fiR = locala.CLY.readString();
          AppMethodBeat.o(94633);
          return 0;
        case 4: 
          localcih.fiS = locala.CLY.readString();
          AppMethodBeat.o(94633);
          return 0;
        case 5: 
          localcih.fiQ = locala.CLY.readString();
          AppMethodBeat.o(94633);
          return 0;
        case 6: 
          localcih.fiT = locala.CLY.readString();
          AppMethodBeat.o(94633);
          return 0;
        case 7: 
          localcih.fiU = locala.CLY.readString();
          AppMethodBeat.o(94633);
          return 0;
        }
        localcih.fiV = locala.CLY.readString();
        AppMethodBeat.o(94633);
        return 0;
      }
      AppMethodBeat.o(94633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cih
 * JD-Core Version:    0.7.0.1
 */