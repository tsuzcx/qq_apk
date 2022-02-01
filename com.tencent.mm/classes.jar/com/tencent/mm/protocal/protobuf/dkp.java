package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkp
  extends com.tencent.mm.bw.a
{
  public String IFw;
  public String Lui;
  public long MOC;
  public int MOD;
  public String MOE;
  public String appId;
  public String businessId;
  public String cardId;
  public String dSJ;
  public String data;
  public int pos;
  public String title;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212291);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      paramVarArgs.aM(2, this.pos);
      paramVarArgs.aM(3, this.weight);
      paramVarArgs.bb(4, this.MOC);
      paramVarArgs.aM(5, this.MOD);
      if (this.businessId != null) {
        paramVarArgs.e(6, this.businessId);
      }
      if (this.cardId != null) {
        paramVarArgs.e(7, this.cardId);
      }
      if (this.data != null) {
        paramVarArgs.e(8, this.data);
      }
      if (this.Lui != null) {
        paramVarArgs.e(9, this.Lui);
      }
      if (this.appId != null) {
        paramVarArgs.e(10, this.appId);
      }
      if (this.IFw != null) {
        paramVarArgs.e(11, this.IFw);
      }
      if (this.dSJ != null) {
        paramVarArgs.e(12, this.dSJ);
      }
      if (this.MOE != null) {
        paramVarArgs.e(13, this.MOE);
      }
      AppMethodBeat.o(212291);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = g.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pos) + g.a.a.b.b.a.bu(3, this.weight) + g.a.a.b.b.a.r(4, this.MOC) + g.a.a.b.b.a.bu(5, this.MOD);
      paramInt = i;
      if (this.businessId != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.businessId);
      }
      i = paramInt;
      if (this.cardId != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.cardId);
      }
      paramInt = i;
      if (this.data != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.data);
      }
      i = paramInt;
      if (this.Lui != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Lui);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.appId);
      }
      i = paramInt;
      if (this.IFw != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.IFw);
      }
      paramInt = i;
      if (this.dSJ != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.dSJ);
      }
      i = paramInt;
      if (this.MOE != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.MOE);
      }
      AppMethodBeat.o(212291);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212291);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dkp localdkp = (dkp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212291);
          return -1;
        case 1: 
          localdkp.title = locala.UbS.readString();
          AppMethodBeat.o(212291);
          return 0;
        case 2: 
          localdkp.pos = locala.UbS.zi();
          AppMethodBeat.o(212291);
          return 0;
        case 3: 
          localdkp.weight = locala.UbS.zi();
          AppMethodBeat.o(212291);
          return 0;
        case 4: 
          localdkp.MOC = locala.UbS.zl();
          AppMethodBeat.o(212291);
          return 0;
        case 5: 
          localdkp.MOD = locala.UbS.zi();
          AppMethodBeat.o(212291);
          return 0;
        case 6: 
          localdkp.businessId = locala.UbS.readString();
          AppMethodBeat.o(212291);
          return 0;
        case 7: 
          localdkp.cardId = locala.UbS.readString();
          AppMethodBeat.o(212291);
          return 0;
        case 8: 
          localdkp.data = locala.UbS.readString();
          AppMethodBeat.o(212291);
          return 0;
        case 9: 
          localdkp.Lui = locala.UbS.readString();
          AppMethodBeat.o(212291);
          return 0;
        case 10: 
          localdkp.appId = locala.UbS.readString();
          AppMethodBeat.o(212291);
          return 0;
        case 11: 
          localdkp.IFw = locala.UbS.readString();
          AppMethodBeat.o(212291);
          return 0;
        case 12: 
          localdkp.dSJ = locala.UbS.readString();
          AppMethodBeat.o(212291);
          return 0;
        }
        localdkp.MOE = locala.UbS.readString();
        AppMethodBeat.o(212291);
        return 0;
      }
      AppMethodBeat.o(212291);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkp
 * JD-Core Version:    0.7.0.1
 */