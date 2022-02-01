package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axt
  extends com.tencent.mm.bw.a
{
  public String ErZ;
  public int Esb;
  public String LIb;
  public String country;
  public float dTj;
  public String fuJ;
  public String fuK;
  public String jlI;
  public String kHV;
  public float latitude;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169004);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.dTj);
      paramVarArgs.E(2, this.latitude);
      if (this.fuK != null) {
        paramVarArgs.e(3, this.fuK);
      }
      if (this.kHV != null) {
        paramVarArgs.e(4, this.kHV);
      }
      if (this.ErZ != null) {
        paramVarArgs.e(5, this.ErZ);
      }
      if (this.LIb != null) {
        paramVarArgs.e(6, this.LIb);
      }
      paramVarArgs.aM(7, this.Esb);
      if (this.fuJ != null) {
        paramVarArgs.e(8, this.fuJ);
      }
      if (this.jlI != null) {
        paramVarArgs.e(9, this.jlI);
      }
      if (this.country != null) {
        paramVarArgs.e(10, this.country);
      }
      paramVarArgs.aM(11, this.source);
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 4 + 0 + (g.a.a.b.b.a.fS(2) + 4);
      paramInt = i;
      if (this.fuK != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.fuK);
      }
      i = paramInt;
      if (this.kHV != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.kHV);
      }
      paramInt = i;
      if (this.ErZ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.ErZ);
      }
      i = paramInt;
      if (this.LIb != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LIb);
      }
      i += g.a.a.b.b.a.bu(7, this.Esb);
      paramInt = i;
      if (this.fuJ != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.fuJ);
      }
      i = paramInt;
      if (this.jlI != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.jlI);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.country);
      }
      i = g.a.a.b.b.a.bu(11, this.source);
      AppMethodBeat.o(169004);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      axt localaxt = (axt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169004);
        return -1;
      case 1: 
        localaxt.dTj = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(169004);
        return 0;
      case 2: 
        localaxt.latitude = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(169004);
        return 0;
      case 3: 
        localaxt.fuK = locala.UbS.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 4: 
        localaxt.kHV = locala.UbS.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 5: 
        localaxt.ErZ = locala.UbS.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 6: 
        localaxt.LIb = locala.UbS.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 7: 
        localaxt.Esb = locala.UbS.zi();
        AppMethodBeat.o(169004);
        return 0;
      case 8: 
        localaxt.fuJ = locala.UbS.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 9: 
        localaxt.jlI = locala.UbS.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 10: 
        localaxt.country = locala.UbS.readString();
        AppMethodBeat.o(169004);
        return 0;
      }
      localaxt.source = locala.UbS.zi();
      AppMethodBeat.o(169004);
      return 0;
    }
    AppMethodBeat.o(169004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axt
 * JD-Core Version:    0.7.0.1
 */