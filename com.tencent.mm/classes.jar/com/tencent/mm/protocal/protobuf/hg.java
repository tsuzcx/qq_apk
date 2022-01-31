package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hg
  extends com.tencent.mm.bv.a
{
  public String kwK;
  public String nLq;
  public String poq;
  public String ubQ;
  public String wtU;
  public String wtV;
  public String wtW;
  public boolean wtX;
  public String wtY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48775);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nLq != null) {
        paramVarArgs.e(1, this.nLq);
      }
      if (this.poq != null) {
        paramVarArgs.e(2, this.poq);
      }
      if (this.kwK != null) {
        paramVarArgs.e(3, this.kwK);
      }
      if (this.ubQ != null) {
        paramVarArgs.e(4, this.ubQ);
      }
      if (this.wtU != null) {
        paramVarArgs.e(5, this.wtU);
      }
      if (this.wtV != null) {
        paramVarArgs.e(6, this.wtV);
      }
      if (this.wtW != null) {
        paramVarArgs.e(8, this.wtW);
      }
      paramVarArgs.aS(9, this.wtX);
      if (this.wtY != null) {
        paramVarArgs.e(10, this.wtY);
      }
      AppMethodBeat.o(48775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nLq == null) {
        break label690;
      }
    }
    label690:
    for (int i = e.a.a.b.b.a.f(1, this.nLq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.poq != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.poq);
      }
      i = paramInt;
      if (this.kwK != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kwK);
      }
      paramInt = i;
      if (this.ubQ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ubQ);
      }
      i = paramInt;
      if (this.wtU != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wtU);
      }
      paramInt = i;
      if (this.wtV != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wtV);
      }
      i = paramInt;
      if (this.wtW != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wtW);
      }
      i += e.a.a.b.b.a.eW(9) + 1;
      paramInt = i;
      if (this.wtY != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wtY);
      }
      AppMethodBeat.o(48775);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48775);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        hg localhg = (hg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(48775);
          return -1;
        case 1: 
          localhg.nLq = locala.CLY.readString();
          AppMethodBeat.o(48775);
          return 0;
        case 2: 
          localhg.poq = locala.CLY.readString();
          AppMethodBeat.o(48775);
          return 0;
        case 3: 
          localhg.kwK = locala.CLY.readString();
          AppMethodBeat.o(48775);
          return 0;
        case 4: 
          localhg.ubQ = locala.CLY.readString();
          AppMethodBeat.o(48775);
          return 0;
        case 5: 
          localhg.wtU = locala.CLY.readString();
          AppMethodBeat.o(48775);
          return 0;
        case 6: 
          localhg.wtV = locala.CLY.readString();
          AppMethodBeat.o(48775);
          return 0;
        case 8: 
          localhg.wtW = locala.CLY.readString();
          AppMethodBeat.o(48775);
          return 0;
        case 9: 
          localhg.wtX = locala.CLY.emu();
          AppMethodBeat.o(48775);
          return 0;
        }
        localhg.wtY = locala.CLY.readString();
        AppMethodBeat.o(48775);
        return 0;
      }
      AppMethodBeat.o(48775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hg
 * JD-Core Version:    0.7.0.1
 */