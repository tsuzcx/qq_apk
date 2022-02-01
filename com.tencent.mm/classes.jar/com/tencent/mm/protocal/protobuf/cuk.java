package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuk
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public String UserName;
  public String aamI;
  public int aamK;
  public int aamo;
  public int aazR;
  public String aazV;
  public String aazW;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152608);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idd);
      if (this.aamI != null) {
        paramVarArgs.g(2, this.aamI);
      }
      paramVarArgs.bS(3, this.aamK);
      paramVarArgs.bS(4, this.aazR);
      if (this.hAP != null) {
        paramVarArgs.g(5, this.hAP);
      }
      if (this.UserName != null) {
        paramVarArgs.g(6, this.UserName);
      }
      if (this.aazV != null) {
        paramVarArgs.g(7, this.aazV);
      }
      if (this.aazW != null) {
        paramVarArgs.g(8, this.aazW);
      }
      paramVarArgs.bS(9, this.aamo);
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Idd) + 0;
      paramInt = i;
      if (this.aamI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aamI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.aamK) + i.a.a.b.b.a.cJ(4, this.aazR);
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hAP);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.UserName);
      }
      paramInt = i;
      if (this.aazV != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aazV);
      }
      i = paramInt;
      if (this.aazW != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aazW);
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.aamo);
      AppMethodBeat.o(152608);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cuk localcuk = (cuk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152608);
        return -1;
      case 1: 
        localcuk.Idd = locala.ajGk.aar();
        AppMethodBeat.o(152608);
        return 0;
      case 2: 
        localcuk.aamI = locala.ajGk.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 3: 
        localcuk.aamK = locala.ajGk.aar();
        AppMethodBeat.o(152608);
        return 0;
      case 4: 
        localcuk.aazR = locala.ajGk.aar();
        AppMethodBeat.o(152608);
        return 0;
      case 5: 
        localcuk.hAP = locala.ajGk.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 6: 
        localcuk.UserName = locala.ajGk.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 7: 
        localcuk.aazV = locala.ajGk.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 8: 
        localcuk.aazW = locala.ajGk.readString();
        AppMethodBeat.o(152608);
        return 0;
      }
      localcuk.aamo = locala.ajGk.aar();
      AppMethodBeat.o(152608);
      return 0;
    }
    AppMethodBeat.o(152608);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuk
 * JD-Core Version:    0.7.0.1
 */