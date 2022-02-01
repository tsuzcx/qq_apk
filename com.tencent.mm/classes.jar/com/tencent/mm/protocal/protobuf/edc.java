package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edc
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String IKJ;
  public String MEX;
  public String MEZ;
  public String MFa;
  public int MFb;
  public String MFc;
  public int MFd;
  public int MFe;
  public String MFg;
  public String MFh;
  public String MFi;
  public String MFj;
  public int abic;
  public String abir;
  public String abis;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91612);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MEX != null) {
        paramVarArgs.g(1, this.MEX);
      }
      paramVarArgs.bS(2, this.abic);
      if (this.MEZ != null) {
        paramVarArgs.g(3, this.MEZ);
      }
      paramVarArgs.bS(4, this.CreateTime);
      if (this.MFa != null) {
        paramVarArgs.g(5, this.MFa);
      }
      paramVarArgs.bS(6, this.MFb);
      if (this.MFc != null) {
        paramVarArgs.g(7, this.MFc);
      }
      paramVarArgs.bS(8, this.MFd);
      paramVarArgs.bS(9, this.MFe);
      if (this.IKJ != null) {
        paramVarArgs.g(11, this.IKJ);
      }
      if (this.MFg != null) {
        paramVarArgs.g(12, this.MFg);
      }
      if (this.MFh != null) {
        paramVarArgs.g(13, this.MFh);
      }
      if (this.MFi != null) {
        paramVarArgs.g(14, this.MFi);
      }
      if (this.MFj != null) {
        paramVarArgs.g(15, this.MFj);
      }
      if (this.abir != null) {
        paramVarArgs.g(18, this.abir);
      }
      if (this.abis != null) {
        paramVarArgs.g(19, this.abis);
      }
      AppMethodBeat.o(91612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MEX == null) {
        break label1062;
      }
    }
    label1062:
    for (paramInt = i.a.a.b.b.a.h(1, this.MEX) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abic);
      paramInt = i;
      if (this.MEZ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.MEZ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.CreateTime);
      paramInt = i;
      if (this.MFa != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.MFa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.MFb);
      paramInt = i;
      if (this.MFc != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.MFc);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.MFd) + i.a.a.b.b.a.cJ(9, this.MFe);
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.IKJ);
      }
      i = paramInt;
      if (this.MFg != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.MFg);
      }
      paramInt = i;
      if (this.MFh != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.MFh);
      }
      i = paramInt;
      if (this.MFi != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.MFi);
      }
      paramInt = i;
      if (this.MFj != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.MFj);
      }
      i = paramInt;
      if (this.abir != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.abir);
      }
      paramInt = i;
      if (this.abis != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.abis);
      }
      AppMethodBeat.o(91612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91612);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        edc localedc = (edc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(91612);
          return -1;
        case 1: 
          localedc.MEX = locala.ajGk.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 2: 
          localedc.abic = locala.ajGk.aar();
          AppMethodBeat.o(91612);
          return 0;
        case 3: 
          localedc.MEZ = locala.ajGk.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 4: 
          localedc.CreateTime = locala.ajGk.aar();
          AppMethodBeat.o(91612);
          return 0;
        case 5: 
          localedc.MFa = locala.ajGk.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 6: 
          localedc.MFb = locala.ajGk.aar();
          AppMethodBeat.o(91612);
          return 0;
        case 7: 
          localedc.MFc = locala.ajGk.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 8: 
          localedc.MFd = locala.ajGk.aar();
          AppMethodBeat.o(91612);
          return 0;
        case 9: 
          localedc.MFe = locala.ajGk.aar();
          AppMethodBeat.o(91612);
          return 0;
        case 11: 
          localedc.IKJ = locala.ajGk.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 12: 
          localedc.MFg = locala.ajGk.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 13: 
          localedc.MFh = locala.ajGk.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 14: 
          localedc.MFi = locala.ajGk.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 15: 
          localedc.MFj = locala.ajGk.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 18: 
          localedc.abir = locala.ajGk.readString();
          AppMethodBeat.o(91612);
          return 0;
        }
        localedc.abis = locala.ajGk.readString();
        AppMethodBeat.o(91612);
        return 0;
      }
      AppMethodBeat.o(91612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edc
 * JD-Core Version:    0.7.0.1
 */