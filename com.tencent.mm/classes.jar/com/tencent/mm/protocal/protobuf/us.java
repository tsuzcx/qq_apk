package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class us
  extends com.tencent.mm.bw.a
{
  public float DWG;
  public String Leo;
  public String Lep;
  public String country;
  public float dTj;
  public String descriptor;
  public String fuJ;
  public String fuK;
  public String iUO;
  public float latitude;
  public String name;
  public String pSm;
  public String pTL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113969);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      if (this.descriptor != null) {
        paramVarArgs.e(2, this.descriptor);
      }
      if (this.pSm != null) {
        paramVarArgs.e(3, this.pSm);
      }
      if (this.country != null) {
        paramVarArgs.e(4, this.country);
      }
      if (this.fuJ != null) {
        paramVarArgs.e(5, this.fuJ);
      }
      if (this.fuK != null) {
        paramVarArgs.e(6, this.fuK);
      }
      if (this.iUO != null) {
        paramVarArgs.e(7, this.iUO);
      }
      paramVarArgs.E(8, this.DWG);
      paramVarArgs.E(9, this.dTj);
      paramVarArgs.E(10, this.latitude);
      if (this.pTL != null) {
        paramVarArgs.e(11, this.pTL);
      }
      if (this.Leo != null) {
        paramVarArgs.e(12, this.Leo);
      }
      if (this.Lep != null) {
        paramVarArgs.e(13, this.Lep);
      }
      AppMethodBeat.o(113969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label903;
      }
    }
    label903:
    for (int i = g.a.a.b.b.a.f(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.descriptor != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.descriptor);
      }
      i = paramInt;
      if (this.pSm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.pSm);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.country);
      }
      i = paramInt;
      if (this.fuJ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.fuJ);
      }
      paramInt = i;
      if (this.fuK != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.fuK);
      }
      i = paramInt;
      if (this.iUO != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.iUO);
      }
      i = i + (g.a.a.b.b.a.fS(8) + 4) + (g.a.a.b.b.a.fS(9) + 4) + (g.a.a.b.b.a.fS(10) + 4);
      paramInt = i;
      if (this.pTL != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.pTL);
      }
      i = paramInt;
      if (this.Leo != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Leo);
      }
      paramInt = i;
      if (this.Lep != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Lep);
      }
      AppMethodBeat.o(113969);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113969);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        us localus = (us)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113969);
          return -1;
        case 1: 
          localus.name = locala.UbS.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 2: 
          localus.descriptor = locala.UbS.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 3: 
          localus.pSm = locala.UbS.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 4: 
          localus.country = locala.UbS.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 5: 
          localus.fuJ = locala.UbS.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 6: 
          localus.fuK = locala.UbS.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 7: 
          localus.iUO = locala.UbS.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 8: 
          localus.DWG = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(113969);
          return 0;
        case 9: 
          localus.dTj = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(113969);
          return 0;
        case 10: 
          localus.latitude = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(113969);
          return 0;
        case 11: 
          localus.pTL = locala.UbS.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 12: 
          localus.Leo = locala.UbS.readString();
          AppMethodBeat.o(113969);
          return 0;
        }
        localus.Lep = locala.UbS.readString();
        AppMethodBeat.o(113969);
        return 0;
      }
      AppMethodBeat.o(113969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.us
 * JD-Core Version:    0.7.0.1
 */