package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fis
  extends com.tencent.mm.bx.a
{
  public String Id;
  public String Url;
  public String aaTA;
  public String aaTB;
  public int aaTC;
  public String aaTD;
  public String aaTE;
  public String aaTl;
  public int aaTm;
  public int aaTw;
  public long aaTx;
  public String aaTy;
  public int aaTz;
  public int aazR;
  public float abJB;
  public int icg;
  public String md5;
  public String msf;
  public int subType;
  public String taskId;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118454);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.g(1, this.Id);
      }
      paramVarArgs.bS(2, this.vhJ);
      if (this.Url != null) {
        paramVarArgs.g(3, this.Url);
      }
      paramVarArgs.bS(4, this.aazR);
      if (this.aaTl != null) {
        paramVarArgs.g(5, this.aaTl);
      }
      paramVarArgs.bS(6, this.aaTm);
      paramVarArgs.bS(7, this.subType);
      if (this.md5 != null) {
        paramVarArgs.g(8, this.md5);
      }
      if (this.aaTE != null) {
        paramVarArgs.g(9, this.aaTE);
      }
      paramVarArgs.bS(10, this.icg);
      paramVarArgs.bS(11, this.aaTw);
      paramVarArgs.bv(12, this.aaTx);
      if (this.aaTy != null) {
        paramVarArgs.g(13, this.aaTy);
      }
      if (this.msf != null) {
        paramVarArgs.g(14, this.msf);
      }
      paramVarArgs.bS(15, this.aaTz);
      if (this.aaTA != null) {
        paramVarArgs.g(16, this.aaTA);
      }
      if (this.aaTB != null) {
        paramVarArgs.g(17, this.aaTB);
      }
      paramVarArgs.bS(18, this.aaTC);
      if (this.aaTD != null) {
        paramVarArgs.g(19, this.aaTD);
      }
      paramVarArgs.l(20, this.abJB);
      if (this.taskId != null) {
        paramVarArgs.g(21, this.taskId);
      }
      AppMethodBeat.o(118454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label1277;
      }
    }
    label1277:
    for (paramInt = i.a.a.b.b.a.h(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.aazR);
      paramInt = i;
      if (this.aaTl != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaTl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.aaTm) + i.a.a.b.b.a.cJ(7, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.md5);
      }
      i = paramInt;
      if (this.aaTE != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aaTE);
      }
      i = i + i.a.a.b.b.a.cJ(10, this.icg) + i.a.a.b.b.a.cJ(11, this.aaTw) + i.a.a.b.b.a.q(12, this.aaTx);
      paramInt = i;
      if (this.aaTy != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.aaTy);
      }
      i = paramInt;
      if (this.msf != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.msf);
      }
      i += i.a.a.b.b.a.cJ(15, this.aaTz);
      paramInt = i;
      if (this.aaTA != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.aaTA);
      }
      i = paramInt;
      if (this.aaTB != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.aaTB);
      }
      i += i.a.a.b.b.a.cJ(18, this.aaTC);
      paramInt = i;
      if (this.aaTD != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.aaTD);
      }
      i = paramInt + (i.a.a.b.b.a.ko(20) + 4);
      paramInt = i;
      if (this.taskId != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.taskId);
      }
      AppMethodBeat.o(118454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(118454);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fis localfis = (fis)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118454);
          return -1;
        case 1: 
          localfis.Id = locala.ajGk.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 2: 
          localfis.vhJ = locala.ajGk.aar();
          AppMethodBeat.o(118454);
          return 0;
        case 3: 
          localfis.Url = locala.ajGk.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 4: 
          localfis.aazR = locala.ajGk.aar();
          AppMethodBeat.o(118454);
          return 0;
        case 5: 
          localfis.aaTl = locala.ajGk.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 6: 
          localfis.aaTm = locala.ajGk.aar();
          AppMethodBeat.o(118454);
          return 0;
        case 7: 
          localfis.subType = locala.ajGk.aar();
          AppMethodBeat.o(118454);
          return 0;
        case 8: 
          localfis.md5 = locala.ajGk.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 9: 
          localfis.aaTE = locala.ajGk.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 10: 
          localfis.icg = locala.ajGk.aar();
          AppMethodBeat.o(118454);
          return 0;
        case 11: 
          localfis.aaTw = locala.ajGk.aar();
          AppMethodBeat.o(118454);
          return 0;
        case 12: 
          localfis.aaTx = locala.ajGk.aaw();
          AppMethodBeat.o(118454);
          return 0;
        case 13: 
          localfis.aaTy = locala.ajGk.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 14: 
          localfis.msf = locala.ajGk.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 15: 
          localfis.aaTz = locala.ajGk.aar();
          AppMethodBeat.o(118454);
          return 0;
        case 16: 
          localfis.aaTA = locala.ajGk.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 17: 
          localfis.aaTB = locala.ajGk.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 18: 
          localfis.aaTC = locala.ajGk.aar();
          AppMethodBeat.o(118454);
          return 0;
        case 19: 
          localfis.aaTD = locala.ajGk.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 20: 
          localfis.abJB = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(118454);
          return 0;
        }
        localfis.taskId = locala.ajGk.readString();
        AppMethodBeat.o(118454);
        return 0;
      }
      AppMethodBeat.o(118454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fis
 * JD-Core Version:    0.7.0.1
 */