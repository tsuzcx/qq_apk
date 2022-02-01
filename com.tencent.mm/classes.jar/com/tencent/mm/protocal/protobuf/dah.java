package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dah
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public String Kmq;
  public String OcO;
  public long aaFI;
  public String aaFK;
  public int aaFM;
  public int aaFN;
  public String aaFO;
  public String aatc;
  public String icon_url;
  public String nQV;
  public int state;
  public int tNW;
  public int wso;
  public String wtN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72506);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aatc != null) {
        paramVarArgs.g(1, this.aatc);
      }
      if (this.nQV != null) {
        paramVarArgs.g(2, this.nQV);
      }
      paramVarArgs.bv(3, this.aaFI);
      paramVarArgs.bS(4, this.state);
      paramVarArgs.bS(5, this.HTK);
      paramVarArgs.bS(6, this.wso);
      paramVarArgs.bS(7, this.aaFM);
      paramVarArgs.bS(8, this.aaFN);
      if (this.aaFO != null) {
        paramVarArgs.g(9, this.aaFO);
      }
      if (this.wtN != null) {
        paramVarArgs.g(10, this.wtN);
      }
      if (this.Kmq != null) {
        paramVarArgs.g(11, this.Kmq);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(12, this.icon_url);
      }
      if (this.OcO != null) {
        paramVarArgs.g(13, this.OcO);
      }
      if (this.aaFK != null) {
        paramVarArgs.g(14, this.aaFK);
      }
      paramVarArgs.bS(15, this.tNW);
      AppMethodBeat.o(72506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aatc == null) {
        break label950;
      }
    }
    label950:
    for (paramInt = i.a.a.b.b.a.h(1, this.aatc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nQV != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nQV);
      }
      i = i + i.a.a.b.b.a.q(3, this.aaFI) + i.a.a.b.b.a.cJ(4, this.state) + i.a.a.b.b.a.cJ(5, this.HTK) + i.a.a.b.b.a.cJ(6, this.wso) + i.a.a.b.b.a.cJ(7, this.aaFM) + i.a.a.b.b.a.cJ(8, this.aaFN);
      paramInt = i;
      if (this.aaFO != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaFO);
      }
      i = paramInt;
      if (this.wtN != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.wtN);
      }
      paramInt = i;
      if (this.Kmq != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.Kmq);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.icon_url);
      }
      paramInt = i;
      if (this.OcO != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.OcO);
      }
      i = paramInt;
      if (this.aaFK != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.aaFK);
      }
      paramInt = i.a.a.b.b.a.cJ(15, this.tNW);
      AppMethodBeat.o(72506);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72506);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dah localdah = (dah)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72506);
          return -1;
        case 1: 
          localdah.aatc = locala.ajGk.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 2: 
          localdah.nQV = locala.ajGk.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 3: 
          localdah.aaFI = locala.ajGk.aaw();
          AppMethodBeat.o(72506);
          return 0;
        case 4: 
          localdah.state = locala.ajGk.aar();
          AppMethodBeat.o(72506);
          return 0;
        case 5: 
          localdah.HTK = locala.ajGk.aar();
          AppMethodBeat.o(72506);
          return 0;
        case 6: 
          localdah.wso = locala.ajGk.aar();
          AppMethodBeat.o(72506);
          return 0;
        case 7: 
          localdah.aaFM = locala.ajGk.aar();
          AppMethodBeat.o(72506);
          return 0;
        case 8: 
          localdah.aaFN = locala.ajGk.aar();
          AppMethodBeat.o(72506);
          return 0;
        case 9: 
          localdah.aaFO = locala.ajGk.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 10: 
          localdah.wtN = locala.ajGk.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 11: 
          localdah.Kmq = locala.ajGk.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 12: 
          localdah.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 13: 
          localdah.OcO = locala.ajGk.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 14: 
          localdah.aaFK = locala.ajGk.readString();
          AppMethodBeat.o(72506);
          return 0;
        }
        localdah.tNW = locala.ajGk.aar();
        AppMethodBeat.o(72506);
        return 0;
      }
      AppMethodBeat.o(72506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dah
 * JD-Core Version:    0.7.0.1
 */