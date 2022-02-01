package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fhc
  extends com.tencent.mm.bx.a
{
  public String abHC;
  public String abHD;
  public int abHE;
  public String abHF;
  public String abHG;
  public int abHH;
  public String appId;
  public String appName;
  public String phA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257495);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.g(2, this.appName);
      }
      if (this.abHC != null) {
        paramVarArgs.g(3, this.abHC);
      }
      if (this.abHD != null) {
        paramVarArgs.g(4, this.abHD);
      }
      paramVarArgs.bS(5, this.abHE);
      if (this.abHF != null) {
        paramVarArgs.g(6, this.abHF);
      }
      if (this.abHG != null) {
        paramVarArgs.g(7, this.abHG);
      }
      if (this.phA != null) {
        paramVarArgs.g(8, this.phA);
      }
      paramVarArgs.bS(9, this.abHH);
      AppMethodBeat.o(257495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label666;
      }
    }
    label666:
    for (int i = i.a.a.b.b.a.h(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appName);
      }
      i = paramInt;
      if (this.abHC != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abHC);
      }
      paramInt = i;
      if (this.abHD != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abHD);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abHE);
      paramInt = i;
      if (this.abHF != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abHF);
      }
      i = paramInt;
      if (this.abHG != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abHG);
      }
      paramInt = i;
      if (this.phA != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.phA);
      }
      i = i.a.a.b.b.a.cJ(9, this.abHH);
      AppMethodBeat.o(257495);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257495);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fhc localfhc = (fhc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257495);
          return -1;
        case 1: 
          localfhc.appId = locala.ajGk.readString();
          AppMethodBeat.o(257495);
          return 0;
        case 2: 
          localfhc.appName = locala.ajGk.readString();
          AppMethodBeat.o(257495);
          return 0;
        case 3: 
          localfhc.abHC = locala.ajGk.readString();
          AppMethodBeat.o(257495);
          return 0;
        case 4: 
          localfhc.abHD = locala.ajGk.readString();
          AppMethodBeat.o(257495);
          return 0;
        case 5: 
          localfhc.abHE = locala.ajGk.aar();
          AppMethodBeat.o(257495);
          return 0;
        case 6: 
          localfhc.abHF = locala.ajGk.readString();
          AppMethodBeat.o(257495);
          return 0;
        case 7: 
          localfhc.abHG = locala.ajGk.readString();
          AppMethodBeat.o(257495);
          return 0;
        case 8: 
          localfhc.phA = locala.ajGk.readString();
          AppMethodBeat.o(257495);
          return 0;
        }
        localfhc.abHH = locala.ajGk.aar();
        AppMethodBeat.o(257495);
        return 0;
      }
      AppMethodBeat.o(257495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhc
 * JD-Core Version:    0.7.0.1
 */