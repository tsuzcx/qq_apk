package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dix
  extends com.tencent.mm.bx.a
{
  public String aaNn;
  public int aaOq;
  public int aaOr;
  public int aaOs;
  public b aaOt;
  public b aaOu;
  public b aaOv;
  public String aaOw;
  public long aaOx;
  public long aaOy;
  public String aaOz;
  public long mMJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260119);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaOq);
      if (this.aaNn != null) {
        paramVarArgs.g(2, this.aaNn);
      }
      paramVarArgs.bS(3, this.aaOr);
      paramVarArgs.bS(4, this.aaOs);
      if (this.aaOt != null) {
        paramVarArgs.d(5, this.aaOt);
      }
      if (this.aaOu != null) {
        paramVarArgs.d(6, this.aaOu);
      }
      if (this.aaOv != null) {
        paramVarArgs.d(7, this.aaOv);
      }
      if (this.aaOw != null) {
        paramVarArgs.g(8, this.aaOw);
      }
      paramVarArgs.bv(9, this.aaOx);
      paramVarArgs.bv(10, this.aaOy);
      paramVarArgs.bv(11, this.mMJ);
      if (this.aaOz != null) {
        paramVarArgs.g(12, this.aaOz);
      }
      AppMethodBeat.o(260119);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aaOq) + 0;
      paramInt = i;
      if (this.aaNn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaNn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.aaOr) + i.a.a.b.b.a.cJ(4, this.aaOs);
      paramInt = i;
      if (this.aaOt != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.aaOt);
      }
      i = paramInt;
      if (this.aaOu != null) {
        i = paramInt + i.a.a.b.b.a.c(6, this.aaOu);
      }
      paramInt = i;
      if (this.aaOv != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.aaOv);
      }
      i = paramInt;
      if (this.aaOw != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaOw);
      }
      i = i + i.a.a.b.b.a.q(9, this.aaOx) + i.a.a.b.b.a.q(10, this.aaOy) + i.a.a.b.b.a.q(11, this.mMJ);
      paramInt = i;
      if (this.aaOz != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaOz);
      }
      AppMethodBeat.o(260119);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260119);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dix localdix = (dix)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260119);
        return -1;
      case 1: 
        localdix.aaOq = locala.ajGk.aar();
        AppMethodBeat.o(260119);
        return 0;
      case 2: 
        localdix.aaNn = locala.ajGk.readString();
        AppMethodBeat.o(260119);
        return 0;
      case 3: 
        localdix.aaOr = locala.ajGk.aar();
        AppMethodBeat.o(260119);
        return 0;
      case 4: 
        localdix.aaOs = locala.ajGk.aar();
        AppMethodBeat.o(260119);
        return 0;
      case 5: 
        localdix.aaOt = locala.ajGk.kFX();
        AppMethodBeat.o(260119);
        return 0;
      case 6: 
        localdix.aaOu = locala.ajGk.kFX();
        AppMethodBeat.o(260119);
        return 0;
      case 7: 
        localdix.aaOv = locala.ajGk.kFX();
        AppMethodBeat.o(260119);
        return 0;
      case 8: 
        localdix.aaOw = locala.ajGk.readString();
        AppMethodBeat.o(260119);
        return 0;
      case 9: 
        localdix.aaOx = locala.ajGk.aaw();
        AppMethodBeat.o(260119);
        return 0;
      case 10: 
        localdix.aaOy = locala.ajGk.aaw();
        AppMethodBeat.o(260119);
        return 0;
      case 11: 
        localdix.mMJ = locala.ajGk.aaw();
        AppMethodBeat.o(260119);
        return 0;
      }
      localdix.aaOz = locala.ajGk.readString();
      AppMethodBeat.o(260119);
      return 0;
    }
    AppMethodBeat.o(260119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dix
 * JD-Core Version:    0.7.0.1
 */