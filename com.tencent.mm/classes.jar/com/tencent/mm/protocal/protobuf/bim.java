package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bim
  extends com.tencent.mm.bx.a
{
  public String ZOC;
  public String ZRC;
  public String ZRD;
  public String ZRE;
  public String ZRF;
  public String ZRG;
  public String ZRH;
  public float ZRI;
  public int ZRJ;
  public int ZRK;
  public int business_type;
  public int eQp;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257467);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOC != null) {
        paramVarArgs.g(1, this.ZOC);
      }
      paramVarArgs.bS(2, this.business_type);
      if (this.ZRC != null) {
        paramVarArgs.g(3, this.ZRC);
      }
      if (this.ZRD != null) {
        paramVarArgs.g(4, this.ZRD);
      }
      if (this.ZRE != null) {
        paramVarArgs.g(5, this.ZRE);
      }
      if (this.ZRF != null) {
        paramVarArgs.g(6, this.ZRF);
      }
      if (this.ZRG != null) {
        paramVarArgs.g(7, this.ZRG);
      }
      if (this.ZRH != null) {
        paramVarArgs.g(8, this.ZRH);
      }
      if (this.name != null) {
        paramVarArgs.g(9, this.name);
      }
      paramVarArgs.l(10, this.ZRI);
      paramVarArgs.bS(11, this.ZRJ);
      paramVarArgs.bS(12, this.ZRK);
      paramVarArgs.bS(13, this.eQp);
      AppMethodBeat.o(257467);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOC == null) {
        break label873;
      }
    }
    label873:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZOC) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.business_type);
      paramInt = i;
      if (this.ZRC != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZRC);
      }
      i = paramInt;
      if (this.ZRD != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZRD);
      }
      paramInt = i;
      if (this.ZRE != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZRE);
      }
      i = paramInt;
      if (this.ZRF != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZRF);
      }
      paramInt = i;
      if (this.ZRG != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZRG);
      }
      i = paramInt;
      if (this.ZRH != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.ZRH);
      }
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.name);
      }
      i = i.a.a.b.b.a.ko(10);
      int j = i.a.a.b.b.a.cJ(11, this.ZRJ);
      int k = i.a.a.b.b.a.cJ(12, this.ZRK);
      int m = i.a.a.b.b.a.cJ(13, this.eQp);
      AppMethodBeat.o(257467);
      return paramInt + (i + 4) + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257467);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bim localbim = (bim)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257467);
          return -1;
        case 1: 
          localbim.ZOC = locala.ajGk.readString();
          AppMethodBeat.o(257467);
          return 0;
        case 2: 
          localbim.business_type = locala.ajGk.aar();
          AppMethodBeat.o(257467);
          return 0;
        case 3: 
          localbim.ZRC = locala.ajGk.readString();
          AppMethodBeat.o(257467);
          return 0;
        case 4: 
          localbim.ZRD = locala.ajGk.readString();
          AppMethodBeat.o(257467);
          return 0;
        case 5: 
          localbim.ZRE = locala.ajGk.readString();
          AppMethodBeat.o(257467);
          return 0;
        case 6: 
          localbim.ZRF = locala.ajGk.readString();
          AppMethodBeat.o(257467);
          return 0;
        case 7: 
          localbim.ZRG = locala.ajGk.readString();
          AppMethodBeat.o(257467);
          return 0;
        case 8: 
          localbim.ZRH = locala.ajGk.readString();
          AppMethodBeat.o(257467);
          return 0;
        case 9: 
          localbim.name = locala.ajGk.readString();
          AppMethodBeat.o(257467);
          return 0;
        case 10: 
          localbim.ZRI = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(257467);
          return 0;
        case 11: 
          localbim.ZRJ = locala.ajGk.aar();
          AppMethodBeat.o(257467);
          return 0;
        case 12: 
          localbim.ZRK = locala.ajGk.aar();
          AppMethodBeat.o(257467);
          return 0;
        }
        localbim.eQp = locala.ajGk.aar();
        AppMethodBeat.o(257467);
        return 0;
      }
      AppMethodBeat.o(257467);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bim
 * JD-Core Version:    0.7.0.1
 */