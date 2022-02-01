package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbn
  extends com.tencent.mm.bw.a
{
  public String extraInfo;
  public String sGE;
  public String sGH;
  public String sGQ;
  public String sessionId;
  public int tCE;
  public int tyh;
  public int uCt;
  public long wyW;
  public String wyX;
  public int wyY;
  public int wyZ;
  public String wza;
  public boolean wzb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209654);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.e(1, this.sessionId);
      }
      if (this.sGQ != null) {
        paramVarArgs.e(2, this.sGQ);
      }
      if (this.sGE != null) {
        paramVarArgs.e(3, this.sGE);
      }
      if (this.wyX != null) {
        paramVarArgs.e(4, this.wyX);
      }
      paramVarArgs.aM(5, this.uCt);
      paramVarArgs.aM(6, this.tCE);
      paramVarArgs.bb(7, this.wyW);
      paramVarArgs.aM(8, this.tyh);
      paramVarArgs.aM(9, this.wyY);
      if (this.wza != null) {
        paramVarArgs.e(10, this.wza);
      }
      paramVarArgs.aM(11, this.wyZ);
      if (this.extraInfo != null) {
        paramVarArgs.e(12, this.extraInfo);
      }
      if (this.sGH != null) {
        paramVarArgs.e(13, this.sGH);
      }
      paramVarArgs.cc(14, this.wzb);
      AppMethodBeat.o(209654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label890;
      }
    }
    label890:
    for (int i = g.a.a.b.b.a.f(1, this.sessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.sGQ);
      }
      i = paramInt;
      if (this.sGE != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.sGE);
      }
      paramInt = i;
      if (this.wyX != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.wyX);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.uCt) + g.a.a.b.b.a.bu(6, this.tCE) + g.a.a.b.b.a.r(7, this.wyW) + g.a.a.b.b.a.bu(8, this.tyh) + g.a.a.b.b.a.bu(9, this.wyY);
      paramInt = i;
      if (this.wza != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.wza);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.wyZ);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.extraInfo);
      }
      i = paramInt;
      if (this.sGH != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.sGH);
      }
      paramInt = g.a.a.b.b.a.fS(14);
      AppMethodBeat.o(209654);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209654);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bbn localbbn = (bbn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209654);
          return -1;
        case 1: 
          localbbn.sessionId = locala.UbS.readString();
          AppMethodBeat.o(209654);
          return 0;
        case 2: 
          localbbn.sGQ = locala.UbS.readString();
          AppMethodBeat.o(209654);
          return 0;
        case 3: 
          localbbn.sGE = locala.UbS.readString();
          AppMethodBeat.o(209654);
          return 0;
        case 4: 
          localbbn.wyX = locala.UbS.readString();
          AppMethodBeat.o(209654);
          return 0;
        case 5: 
          localbbn.uCt = locala.UbS.zi();
          AppMethodBeat.o(209654);
          return 0;
        case 6: 
          localbbn.tCE = locala.UbS.zi();
          AppMethodBeat.o(209654);
          return 0;
        case 7: 
          localbbn.wyW = locala.UbS.zl();
          AppMethodBeat.o(209654);
          return 0;
        case 8: 
          localbbn.tyh = locala.UbS.zi();
          AppMethodBeat.o(209654);
          return 0;
        case 9: 
          localbbn.wyY = locala.UbS.zi();
          AppMethodBeat.o(209654);
          return 0;
        case 10: 
          localbbn.wza = locala.UbS.readString();
          AppMethodBeat.o(209654);
          return 0;
        case 11: 
          localbbn.wyZ = locala.UbS.zi();
          AppMethodBeat.o(209654);
          return 0;
        case 12: 
          localbbn.extraInfo = locala.UbS.readString();
          AppMethodBeat.o(209654);
          return 0;
        case 13: 
          localbbn.sGH = locala.UbS.readString();
          AppMethodBeat.o(209654);
          return 0;
        }
        localbbn.wzb = locala.UbS.yZ();
        AppMethodBeat.o(209654);
        return 0;
      }
      AppMethodBeat.o(209654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbn
 * JD-Core Version:    0.7.0.1
 */