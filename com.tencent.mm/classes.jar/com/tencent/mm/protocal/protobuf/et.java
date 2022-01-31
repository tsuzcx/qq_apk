package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class et
  extends com.tencent.mm.bv.a
{
  public long kfs;
  public int kft;
  public String url;
  public String wqR;
  public int wqS;
  public int wqT;
  public long wqU;
  public int wqV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11691);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wqR != null) {
        paramVarArgs.e(1, this.wqR);
      }
      paramVarArgs.am(2, this.kfs);
      paramVarArgs.aO(3, this.kft);
      paramVarArgs.aO(4, this.wqS);
      paramVarArgs.aO(5, this.wqT);
      paramVarArgs.am(6, this.wqU);
      paramVarArgs.aO(7, this.wqV);
      if (this.url != null) {
        paramVarArgs.e(8, this.url);
      }
      AppMethodBeat.o(11691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wqR == null) {
        break label548;
      }
    }
    label548:
    for (paramInt = e.a.a.b.b.a.f(1, this.wqR) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.kfs) + e.a.a.b.b.a.bl(3, this.kft) + e.a.a.b.b.a.bl(4, this.wqS) + e.a.a.b.b.a.bl(5, this.wqT) + e.a.a.b.b.a.p(6, this.wqU) + e.a.a.b.b.a.bl(7, this.wqV);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.url);
      }
      AppMethodBeat.o(11691);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11691);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        et localet = (et)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11691);
          return -1;
        case 1: 
          localet.wqR = locala.CLY.readString();
          AppMethodBeat.o(11691);
          return 0;
        case 2: 
          localet.kfs = locala.CLY.sm();
          AppMethodBeat.o(11691);
          return 0;
        case 3: 
          localet.kft = locala.CLY.sl();
          AppMethodBeat.o(11691);
          return 0;
        case 4: 
          localet.wqS = locala.CLY.sl();
          AppMethodBeat.o(11691);
          return 0;
        case 5: 
          localet.wqT = locala.CLY.sl();
          AppMethodBeat.o(11691);
          return 0;
        case 6: 
          localet.wqU = locala.CLY.sm();
          AppMethodBeat.o(11691);
          return 0;
        case 7: 
          localet.wqV = locala.CLY.sl();
          AppMethodBeat.o(11691);
          return 0;
        }
        localet.url = locala.CLY.readString();
        AppMethodBeat.o(11691);
        return 0;
      }
      AppMethodBeat.o(11691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.et
 * JD-Core Version:    0.7.0.1
 */